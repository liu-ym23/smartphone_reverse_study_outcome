package com.bytedance.awemeopen.apps.framework.feed.profile;

import android.content.Context;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.q;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002J0\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\b\u0010\u001c\u001a\u00020\rH\u0016J\u001e\u0010\u001d\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u001e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016J\u0016\u0010 \u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0016R\u0016\u0010!\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010\u000e\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010\u001b\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\"\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/profile/AosUserProfileFeedFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "Lh04/e;", "Ljz3/a;", "callback", "", "isFirst", "", "doRefresh", "Lh04/d;", "doLoadMore", "Landroid/content/Context;", "context", "", "userOpenId", "", UploadTypeInf.COUNT, "", "cursor", "Lm24/a;", "doLoadData", "getFromAweme", "getFromGroupId", "getFromUserOpenId", "Lcom/bytedance/awemeopen/apps/framework/feed/profile/f$a;", "getFromUserProfileType", "copyFromTransientDataCache", "initIndex", "sceneId", "refreshData", "loadMoreData", "Lh04/c;", "loadForwardData", "pageCount", "I", "maxCursor", "J", "hasMore", "Z", "Ljava/lang/String;", "getUserOpenId", "()Ljava/lang/String;", "setUserOpenId", "(Ljava/lang/String;)V", "fromGroupId", "profileType", "Lcom/bytedance/awemeopen/apps/framework/feed/profile/f$a;", "", "cachedData", "Ljava/util/List;", "getInitIndex", "()I", "setInitIndex", "(I)V", "fromAweme", "Ljz3/a;", "Lm24/c;", "authorService", "Lm24/c;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosUserProfileFeedFragmentViewModel extends FeedPagerListViewModel {
    private final m24.c authorService;
    private List<jz3.a> cachedData;
    private jz3.a fromAweme;
    private String fromGroupId;
    private boolean hasMore;
    private int initIndex;
    private long maxCursor;
    private int pageCount;
    private f.a profileType;
    private String userOpenId;

    public static final class a implements m24.a {
        public final /* synthetic */ AosUserProfileFeedFragmentViewModel a;
        public final /* synthetic */ h04.d<jz3.a> b;

        public final void onFail(Exception r1) {
            this.b.onFail();
        }

        public a(AosUserProfileFeedFragmentViewModel r1, h04.d<jz3.a> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(List<r14.c> r6, long r7, boolean r9) {
            Intrinsics.checkNotNullParameter(r6, "data");
            List<r14.c> r8 = r6;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r0.add(new jz3.a((r14.c) r10.next(), null, 14));
            goto L4
        L6:
            AosUserProfileFeedFragmentViewModel.access$setMaxCursor$p(this.a, r7);
            AosUserProfileFeedFragmentViewModel.access$setHasMore$p(this.a, r9);
            this.b.onSuccess(r0, r9);
        }
    }

    public static final class b implements m24.a {
        public final /* synthetic */ AosUserProfileFeedFragmentViewModel a;
        public final /* synthetic */ h04.e<jz3.a> b;

        public final void onFail(Exception r3) {
            this.b.a(r3, -1);
        }

        public b(AosUserProfileFeedFragmentViewModel r1, h04.e<jz3.a> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(List<r14.c> r6, long r7, boolean r9) {
            Intrinsics.checkNotNullParameter(r6, "data");
            List<r14.c> r8 = r6;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r0.add(new jz3.a((r14.c) r10.next(), null, 14));
            goto L4
        L6:
            AosUserProfileFeedFragmentViewModel.access$setMaxCursor$p(this.a, r7);
            AosUserProfileFeedFragmentViewModel.access$setHasMore$p(this.a, r9);
            this.b.b(r0, false, r9);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadForwardData(h04.c<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return "others_homepage";
    }

    public void copyFromTransientDataCache() {
        if (this.cachedData.size() != 0) goto L13;
        String r0 = f.a;
        this.pageCount = f.d;
        this.maxCursor = f.e;
        this.hasMore = f.f;
        this.userOpenId = f.a;
        this.fromGroupId = f.b;
        this.profileType = f.c;
        this.cachedData.clear();
        List<jz3.a> r1 = this.cachedData;
        List<jz3.a> r2 = f.g;
        r1.addAll(r2);
        this.initIndex = f.h;
        if (this.cachedData.size() <= 0) goto L11;
        int r3 = this.initIndex;
        if (r3 < 0) goto L11;
        if (r3 >= this.cachedData.size()) goto L11;
        this.fromAweme = (jz3.a) ListProtector.get(this.cachedData, this.initIndex);
    L11:
        f.a = "";
        f.c = null;
        f.d = 20;
        f.e = 0;
        f.f = false;
        ((ArrayList) r2).clear();
        f.h = 0;
        return;
    }

    public AosUserProfileFeedFragmentViewModel() {
        this.pageCount = 20;
        this.userOpenId = "";
        this.fromGroupId = "";
        this.cachedData = new ArrayList();
        d14.a r0 = b14.a.a;
        this.authorService = b14.a.a(m24.c.class);
    }

    public final jz3.a getFromAweme() {
        return this.fromAweme;
    }

    public final String getFromGroupId() {
        return this.fromGroupId;
    }

    public final String getFromUserOpenId() {
        return this.userOpenId;
    }

    public final f.a getFromUserProfileType() {
        return this.profileType;
    }

    public final int getInitIndex() {
        return this.initIndex;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public final int initIndex() {
        return this.initIndex;
    }

    private final void doLoadMore(h04.d<jz3.a> r8) {
        doLoadData(getApplication(), this.userOpenId, this.pageCount, this.maxCursor, new a(this, r8));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadMoreData(h04.d<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        doLoadMore(r2);
    }

    public final void setInitIndex(int r1) {
        this.initIndex = r1;
    }

    public final void setUserOpenId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userOpenId = r2;
    }

    public static final /* synthetic */ void access$setHasMore$p(AosUserProfileFeedFragmentViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setMaxCursor$p(AosUserProfileFeedFragmentViewModel r0, long r1) {
        r0.maxCursor = r1;
    }

    private final void doRefresh(h04.e<jz3.a> r10, boolean r11) {
        if (this.cachedData.size() <= 0) goto L9;
        List<jz3.a> r12 = this.cachedData;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r0.add((jz3.a) r13.next());
        goto L6
    L8:
        r10.b(r0, false, this.hasMore);
        return;
    L9:
        doLoadData(getApplication(), this.userOpenId, this.pageCount, 0, new b(this, r10));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void refreshData(h04.e<jz3.a> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        doRefresh(r2, r3);
    }

    private final void doLoadData(Context r4, String r5, int r6, long r7, m24.a r9) {
        if (Intrinsics.areEqual(this.profileType, f.a.b.a) == false) goto L6;
        m24.c r0 = this.authorService;
        m24.b r2 = new m24.b();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.a = r5;
        r2.b = r6;
        r2.c = r7;
        List r8 = q.a();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r2.d = r8;
        Unit r10 = Unit.INSTANCE;
        r0.r3(r4, r2, r9);
        return;
    L6:
        if (Intrinsics.areEqual(this.profileType, f.a.C0084a.a) == false) goto L10;
        m24.c r1 = this.authorService;
        m24.b r3 = new m24.b();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.a = r5;
        r3.b = r6;
        r3.c = r7;
        List r11 = q.a();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r3.d = r11;
        Unit r12 = Unit.INSTANCE;
        r1.m1(r4, r3, r9);
        return;
    }
}
