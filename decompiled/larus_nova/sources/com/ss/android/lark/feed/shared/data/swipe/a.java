package com.ss.android.lark.feed.shared.data.swipe;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import com.bytedance.lark.pb.feed.v1.GetFeedActionSettingRequest;
import com.bytedance.lark.pb.feed.v1.GetFeedActionSettingResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.log.Log;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<FeedSlideActionSetting.FeedSlideActionType, List<FeedActionType>> f421143f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<FeedSlideActionSetting.FeedSlideActionType> f421144g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<FeedActionType> f421145h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f421146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<FeedSlideActionSetting> f421147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<FeedActionType> f421148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<FeedActionType> f421149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f421150e;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.shared.data.swipe.a$a, reason: collision with other inner class name */
    public static final class C4964a {
        public C4964a() {
        }

        public static List a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "slideActionList");
            ArrayList r101 = new ArrayList();
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            FeedSlideActionSetting.FeedSlideActionType r103 = (FeedSlideActionSetting.FeedSlideActionType) r102.next();
            if (r103 == null) goto L4;
            Map<FeedSlideActionSetting.FeedSlideActionType, List<FeedActionType>> r104 = a.f421143f;
            List<FeedActionType> r105 = a.f421143f.get(r103);
            if (r105 == null) goto L4;
            r101.addAll(r105);
            goto L4
        L10:
            return r101;
        }
    }

    static {
        new C4964a();
        FeedSlideActionSetting.FeedSlideActionType r100 = FeedSlideActionSetting.FeedSlideActionType.SHORTCUT;
        FeedSlideActionSetting.FeedSlideActionType r101 = FeedSlideActionSetting.FeedSlideActionType.FLAG;
        FeedSlideActionSetting.FeedSlideActionType r102 = FeedSlideActionSetting.FeedSlideActionType.FEED_GROUP;
        FeedSlideActionSetting.FeedSlideActionType r103 = FeedSlideActionSetting.FeedSlideActionType.MUTE;
        FeedSlideActionSetting.FeedSlideActionType r104 = FeedSlideActionSetting.FeedSlideActionType.DONE;
        FeedSlideActionSetting.FeedSlideActionType r110 = FeedSlideActionSetting.FeedSlideActionType.MARK_OR_CLEAR_UNREAD;
        f421143f = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, CollectionsKt.listOf(FeedActionType.TOPPING)), TuplesKt.to(r101, CollectionsKt.listOf(FeedActionType.FLAG_MARK)), TuplesKt.to(r102, CollectionsKt.listOf(FeedActionType.ADD_FEED_TAG)), TuplesKt.to(r103, CollectionsKt.listOf(FeedActionType.NO_DISTURB)), TuplesKt.to(r104, CollectionsKt.listOf(FeedActionType.DONE)), TuplesKt.to(r110, CollectionsKt.listOf(new FeedActionType[]{FeedActionType.MARK_UNREAD, FeedActionType.CLEAR_UNREAD}))});
        List<FeedSlideActionSetting.FeedSlideActionType> r105 = CollectionsKt.listOf(new FeedSlideActionSetting.FeedSlideActionType[]{r101, r100, r110, r102, r103, r104});
        f421144g = r105;
        f421145h = C4964a.a(p.a(r105));
    }

    public a() {
        this.f421146a = null;
        FeedSlideActionSetting.Builder r100 = new FeedSlideActionSetting.Builder();
        Boolean r101 = Boolean.FALSE;
        this.f421147b = new MutableLiveData(r100.left_slide_action_on(r101).right_slide_action_on(r101).left_slide_action(CollectionsKt.emptyList()).right_slide_action(CollectionsKt.emptyList()).build());
        this.f421148c = new ArrayList();
        this.f421149d = new ArrayList();
        this.f421150e = new CompositeDisposable();
        Log.i("SwipeActionSettingStore", "listenPush rustClient is empty");
    }

    public static final void a(final a r110, final int r111) {
        r110.getClass();
        Log.i("SwipeActionSettingStore", "fetchFromLocal retryCount:" + r111);
        if (r111 < 1) goto L5;
        Log.w("SwipeActionSettingStore", "fetchFromLocal retry return.");
        return;
    L5:
        l r100 = r110.f421146a;
        if (r100 == null) goto L10;
        SyncDataStrategy r101 = SyncDataStrategy.LOCAL;
        final IGetDataCallback<FeedSlideActionSetting> r102 = new SwipeActionSettingStore$fetchFromLocal$1(r110, r111);
        GetFeedActionSettingRequest.Builder r103 = new GetFeedActionSettingRequest.Builder().sync_data_strategy(r101);
        Intrinsics.checkNotNull(r103);
        r110.f421150e.add(t.a(r100.h(new d(r103, GetFeedActionSettingResponse.ADAPTER, Command.GET_FEED_ACTION_SETTING, null, null, null, null, 248)).a().map(b.f421151a), new SwipeActionSettingStore$getFeedActionSetting$2(r102), new SwipeActionSettingStore$getFeedActionSetting$3(r102), SwipeActionSettingStore$getFeedActionSetting$4.INSTANCE));
        return;
    }

    public static final void b(a r100, FeedSlideActionSetting r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        Log.e("SwipeActionSettingStore", "onChange return for null.");
        return;
    L5:
        ThreadUtils.runOnUIThread(new c(r100, r101));
    }
}
