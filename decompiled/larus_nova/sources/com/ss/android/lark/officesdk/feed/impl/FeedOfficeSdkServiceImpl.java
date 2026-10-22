package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.feed.v1.FeedCursor;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListRequest;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListResponse;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkFeedType;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkUpdateLarkFeedRequest;
import com.bytedance.lark.pb.office_sdk.im.PairFeed;
import com.bytedance.lark.rustclient.api.c;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.lark.sdk.refactor.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class FeedOfficeSdkServiceImpl implements qtb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f433210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f433211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f433212d;

    public static final class a {
    }

    static {
    }

    @Override // qtb.a
    public final void v(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "bizIdList");
        Long r100 = StringsKt.toLongOrNull(this.f433209a);
        if (r100 == null) goto L5;
        long r101 = ULong.m9623constructorimpl(r100.longValue());
    L6:
        AtomicLong r102 = p.f254275a;
        String r103 = this.f433209a;
        Intrinsics.checkNotNullParameter(r103, "userId");
        Long r104 = p.f254276b.get(r103);
        if (r104 == null) goto L9;
        long r105 = ULong.m9623constructorimpl(r104.longValue());
    L11:
        if (this.f433210b.a(this.f433209a) == null) goto L13;
        boolean r106 = true;
    L14:
        Log.i("FeedOfficeSdkServiceImpl", "notifyUpdateFeedData, uid=" + ULong.m9669toStringimpl(r101) + ", sdkSession=" + ULong.m9669toStringimpl(r105) + ", containerReady=" + r106 + ", bizId size=" + r110.size());
        if (r101 != 0) goto L17;
    L26:
        Log.e("FeedOfficeSdkServiceImpl", "notifyUpdateFeedData abort: uid/sdkSession is 0 or container not ready");
        return;
    L17:
        if (r105 == 0) goto L26;
        if (r106 == false) goto L26;
        OfficeSdkUpdateLarkFeedRequest.Builder r107 = new OfficeSdkUpdateLarkFeedRequest.Builder();
        List<String> r111 = r110;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L22:
        if (r112.hasNext() == false) goto L24;
        r108.add(new PairFeed.Builder().biz_id((String) r112.next()).feed_type(OfficeSdkFeedType.DOUBAO_CUSTOM).build());
        goto L22
    L24:
        BuildersKt.launch$default(this.f433212d, null, null, new FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1(r101, r105, r107.feeds(r108).build().encode(), null), 3, null);
        return;
    L13:
        r106 = false;
        goto L14
    L9:
        r105 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qtb.a
    public final GetDoubaoFeedListResponse Ra(FeedCursor r210, int r211) {
        Long r100 = StringsKt.toLongOrNull(this.f433209a);
        if (r100 == null) goto L5;
        long r101 = ULong.m9623constructorimpl(r100.longValue());
    L6:
        Long r102 = this.f433210b.a(this.f433209a);
        if (r102 == null) goto L9;
        long r103 = ULong.m9623constructorimpl(r102.longValue());
    L10:
        Log.i("FeedOfficeSdkServiceImpl", "getPagingDoubaoFeedList, uid=" + ULong.m9669toStringimpl(r101) + ", sdkSession=" + ULong.m9669toStringimpl(r103) + ", cursor.id=" + r210.f253623id + ", cursor.rt=" + r210.rank_time + ", count=" + r211);
        Long r104 = null;
        if (r101 != 0) goto L13;
    L27:
        Log.e("FeedOfficeSdkServiceImpl", "getPagingDoubaoFeedList abort: uid or sdkSession is 0, container not ready");
        return null;
    L13:
        if (r103 == 0) goto L27;
        s r105 = this.f433211c.h(new d(new GetDoubaoFeedListRequest.Builder().feed_cursor(r210).count(Boxing.boxInt(r211)), GetDoubaoFeedListResponse.ADAPTER, Command.GET_DOUBAO_FEED_LIST, null, null, null, null, 248)).execute();
        if ((r105 instanceof x) == false) goto L22;
        StringBuilder r106 = new StringBuilder("getPagingDoubaoFeedList success, next_cursor.id=");
        x r107 = (x) r105;
        FeedCursor r108 = ((GetDoubaoFeedListResponse) r107.f253935c).next_cursor;
        if (r108 == null) goto L20;
        r104 = r108.f253623id;
    L20:
        r106.append(r104);
        r106.append(", size=");
        r106.append(((GetDoubaoFeedListResponse) r107.f253935c).previews.size());
        Log.i("FeedOfficeSdkServiceImpl", r106.toString());
        return (GetDoubaoFeedListResponse) r107.f253935c;
    L22:
        if ((r105 instanceof c) == false) goto L26;
        Log.e("FeedOfficeSdkServiceImpl", "getPagingDoubaoFeedList failed, error=" + ((c) r105).f253907c.f253922b);
        return null;
    L26:
        throw new NoWhenBranchMatchedException();
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    @Inject
    public FeedOfficeSdkServiceImpl(String r100, n r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "rustSdk");
        Intrinsics.checkNotNullParameter(r102, "rustClient");
        this.f433209a = r100;
        this.f433210b = r101;
        this.f433211c = r102;
        this.f433212d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }
}
