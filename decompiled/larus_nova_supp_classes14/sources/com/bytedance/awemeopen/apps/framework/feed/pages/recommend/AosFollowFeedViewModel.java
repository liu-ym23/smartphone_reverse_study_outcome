package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.RecommendFirstBrushDataHelper;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.apps.framework.utils.q;
import com.bytedance.awemeopen.bizmodels.feed.feedenum.AosFeedPullType;
import com.bytedance.awemeopen.bizmodels.feed.feedenum.AosFeedRequestFrom;
import com.bytedance.awemeopen.domain.feed.preload.AosPreloadCacheStrategy;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002J\u001e\u0010\u0017\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u001e\u0010\u001b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\u0016\u0010\u001e\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0016R\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\u001b\u0010.\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*¨\u00061"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFollowFeedViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "Lh04/e;", "Ljz3/a;", "callback", "", "doRefresh", "", "enterVideoAid", "startServerRefresh", "", "Lr14/c;", "data", "preformOnRefreshSuccess", "", "getRefreshPullType", "Lw24/a;", "getFeedDuplicateRemovalParams", "resetTopAids", "Lh04/d;", "doLoadMore", "", "isAppend", "preloadVideos", "reportStartFetchFeedInterface", "sceneId", "isFirst", "refreshData", "loadMoreData", "Lh04/c;", "loadForwardData", "pageKey", "Ljava/lang/String;", "getPageKey", "()Ljava/lang/String;", "setPageKey", "(Ljava/lang/String;)V", "fetchCount", "I", "isEnablePreload$delegate", "Lkotlin/Lazy;", "isEnablePreload", "()Z", "isEnablePreloadWifi$delegate", "isEnablePreloadWifi", "isEnableHostAd$delegate", "isEnableHostAd", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosFollowFeedViewModel extends FeedPagerListViewModel {
    private int fetchCount;
    private final Lazy isEnableHostAd$delegate;
    private final Lazy isEnablePreload$delegate;
    private final Lazy isEnablePreloadWifi$delegate;
    private String pageKey;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ListState.State.values().length];
            r0[ListState.State.INITIAL_LOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ListState.State.START_REFRESH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements r34.b<r14.c> {
        public final /* synthetic */ h04.d<jz3.a> a;
        public final /* synthetic */ AosFollowFeedViewModel b;

        public final void onFail(Exception r1) {
            this.a.onFail();
        }

        public final void onSuccess(List<r14.c> r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            List<r14.c> r0 = r7;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(new jz3.a((r14.c) r2.next(), null, 14));
            goto L4
        L6:
            AosFollowFeedViewModel.access$preloadVideos(this.b, r7, true);
            this.a.onSuccess(r1, true);
        }

        public b(h04.d<jz3.a> r1, AosFollowFeedViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements r34.b<r14.c> {
        public final /* synthetic */ h04.d<jz3.a> a;
        public final /* synthetic */ AosFollowFeedViewModel b;

        public final void onFail(Exception r1) {
            this.a.onFail();
        }

        public final void onSuccess(List<r14.c> r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            List<r14.c> r0 = r7;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(new jz3.a((r14.c) r2.next(), null, 14));
            goto L4
        L6:
            AosFollowFeedViewModel.access$preloadVideos(this.b, r7, true);
            this.a.onSuccess(r1, true);
        }

        public c(h04.d<jz3.a> r1, AosFollowFeedViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements r34.c<r14.c> {
        public final /* synthetic */ h04.e<jz3.a> a;
        public final /* synthetic */ AosFollowFeedViewModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public final void onSuccess(List<r14.c> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            AosEventReporter r0 = AosEventReporter.a;
            int r2 = AosFollowFeedViewModel.access$getRefreshPullType(this.b);
            String r3 = this.c;
            String r4 = "";
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            String r5 = this.b.getWaitToConsumeEnterLiveRoomId();
            if (r5 == null) goto L9;
            r4 = r5;
        L9:
            long r6 = SystemClock.elapsedRealtime() - this.d;
            int r7 = r10.size();
            r0.getClass();
            AosEventReporter.O(false, r2, r3, r4, r6, r7);
            AosFollowFeedViewModel.access$resetTopAids(this.b);
            AosFollowFeedViewModel.access$preformOnRefreshSuccess(this.b, r10, this.a);
        }

        public final void a(Exception r2, int r3) {
            this.a.a(r2, r3);
        }

        public d(h04.e<jz3.a> r1, AosFollowFeedViewModel r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e implements r34.b<r14.c> {
        public final /* synthetic */ h04.e<jz3.a> a;
        public final /* synthetic */ AosFollowFeedViewModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public final void onFail(Exception r3) {
            this.a.a(r3, -1);
        }

        public final void onSuccess(List<r14.c> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            AosEventReporter r0 = AosEventReporter.a;
            int r2 = AosFollowFeedViewModel.access$getRefreshPullType(this.b);
            String r3 = this.c;
            String r4 = "";
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            String r5 = this.b.getWaitToConsumeEnterLiveRoomId();
            if (r5 == null) goto L9;
            r4 = r5;
        L9:
            long r6 = SystemClock.elapsedRealtime() - this.d;
            int r7 = r10.size();
            r0.getClass();
            AosEventReporter.O(false, r2, r3, r4, r6, r7);
            AosFollowFeedViewModel.access$resetTopAids(this.b);
            AosFollowFeedViewModel.access$preformOnRefreshSuccess(this.b, r10, this.a);
        }

        public e(h04.e<jz3.a> r1, AosFollowFeedViewModel r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    private final void resetTopAids() {
        setWaitToConsumeEnterAid(null);
        setWaitToConsumeEnterRequestId(null);
        setWaitToConsumeEnterLiveRoomId(null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadForwardData(h04.c<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    private final w24.a getFeedDuplicateRemovalParams() {
        b54.b r0 = AosExtConfig.b.l1();
        w24.a r1 = new w24.a();
        r1.a = r0.a;
        long r2 = r0.b;
        long r4 = 120000;
        if (r2 >= 120000) goto L5;
    L4:
        r2 = r4;
    L8:
        r1.b = r2;
        return r1;
    L5:
        r4 = 7776000000L;
        if (r2 <= 7776000000L) goto L8;
        goto L8
    }

    private final boolean isEnableHostAd() {
        return ((Boolean) this.isEnableHostAd$delegate.getValue()).booleanValue();
    }

    private final boolean isEnablePreload() {
        return ((Boolean) this.isEnablePreload$delegate.getValue()).booleanValue();
    }

    private final boolean isEnablePreloadWifi() {
        return ((Boolean) this.isEnablePreloadWifi$delegate.getValue()).booleanValue();
    }

    private final void reportStartFetchFeedInterface() {
        AosEventReporter r0 = AosEventReporter.a;
        String r1 = sceneId();
        int r2 = this.fetchCount + 1;
        this.fetchCount = r2;
        boolean r3 = AoLive.b();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "enterFrom");
        d14.a r4 = b14.a.a;
        b14.a.a(t24.a.class).t0(r1, r2, r3, null);
    }

    public AosFollowFeedViewModel() {
        this.pageKey = "";
        this.isEnablePreload$delegate = LazyKt.lazy(C02312.INSTANCE);
        this.isEnablePreloadWifi$delegate = LazyKt.lazy(C02322.INSTANCE);
        this.isEnableHostAd$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    private final int getRefreshPullType() {
        ListState.State r0 = getCurrentState();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return AosFeedPullType.INIT_LOADING.getPullType();
    L11:
        return AosFeedPullType.PULL_TO_REFRESH.getPullType();
    L9:
        return AosFeedPullType.INIT_LOADING.getPullType();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return getSceneId();
    }

    public final String getPageKey() {
        return this.pageKey;
    }

    public static final /* synthetic */ int access$getRefreshPullType(AosFollowFeedViewModel r0) {
        return r0.getRefreshPullType();
    }

    public static final /* synthetic */ void access$resetTopAids(AosFollowFeedViewModel r0) {
        r0.resetTopAids();
    }

    private final void doLoadMore(h04.d<jz3.a> r6) {
        reportStartFetchFeedInterface();
        if (getPageConfig().isTeenagerModel() == false) goto L5;
        d14.a r0 = b14.a.a;
        b14.a.a(n34.a.class).A(getApplication(), new n34.b(), new b(r6, this));
        return;
    L5:
        d14.a r1 = b14.a.a;
        w24.d r2 = b14.a.a(w24.d.class);
        Application r3 = getApplication();
        w24.b r4 = new w24.b();
        r4.a = getPageConfig().getEnterFrom();
        r4.b = getPageConfig().getEnterAid();
        r4.q = getContentScene();
        r4.r = getPageConfig().getHostEnterFrom();
        r4.c = Integer.valueOf(this.fetchCount);
        r4.l = Integer.valueOf(AosFeedPullType.LOAD_MORE.getPullType());
        r4.m = AosFeedRequestFrom.LOAD_MORE_DRAW.getRequestFrom();
        List r5 = q.b();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.n = r5;
        r4.o = b14.a.a(l24.a.class).p3(this.pageKey);
        r4.p = getFeedDuplicateRemovalParams();
        AosExtConfig.b.Y().b();
        r4.s = null;
        r4.t = Boolean.valueOf(isEnableHostAd());
        Unit r7 = Unit.INSTANCE;
        r2.y1(r3, r4, new c(r6, this));
    }

    private final void doRefresh(final h04.e<jz3.a> r21) {
        final String r7 = "";
        final String r4 = "";
        if ("".length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        startServerRefresh(r21, "");
        return;
    L8:
        if (getPageConfig().isTeenagerModel() == true) goto L11;
        final long r5 = SystemClock.elapsedRealtime();
        int r1 = RecommendFirstBrushDataHelper.a;
        RecommendFirstBrushDataHelper.a("", null, null, null, null, null, null, null, getContentScene(), AosPreloadCacheStrategy.DEFAULT_STRATEGY, getFeedDuplicateRemovalParams(), getPageConfig().isTeenagerModel(), new AnonymousClass1(this, r21, r7, r4, r5));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadMoreData(h04.d<jz3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        doLoadMore(r2);
    }

    public final void setPageKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageKey = r2;
    }

    private final void preformOnRefreshSuccess(List<r14.c> r7, h04.e<jz3.a> r8) {
        List<r14.c> r0 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(new jz3.a((r14.c) r2.next(), null, 14));
        goto L4
    L6:
        preloadVideos(r7, false);
        r8.b(r1, false, true);
    }

    private final void preloadVideos(List<r14.c> r6, boolean r7) {
        Context r0 = getApplication();
        int r1 = NetworkUtils.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        if ((r0 instanceof Activity) == false) goto L39;
        r0 = ((Activity) r0).getApplicationContext();
    L39:
        Object r2 = r0.getSystemService("connectivity");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L14
        NetworkInfo r3 = ((ConnectivityManager) r2).getActiveNetworkInfo();     // Catch: Exception -> L14
        if (r3 == null) goto L15;
        if (r3.isAvailable() == false) goto L15;
        if (1 != r3.getType()) goto L15;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
    L22:
        if (r4 == false) goto L24;
    L27:
        AoLogger.c("preloadVideos", new Object[]{"执行预加载"});
        ArrayList r5 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L29:
        if (r8.hasNext() == false) goto L33;
        Object r9 = r8.next();
        d14.a r10 = b14.a.a;
        if (b14.a.a(x24.a.class).W((r14.c) r9) == false) goto L29;
        r5.add(r9);
        goto L29
    L33:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r12 = r5.iterator();
    L35:
        if (r12.hasNext() == false) goto L37;
        r14.c r13 = (r14.c) r12.next();
        getFeedPlayerHelper().getClass();
        r11.add(FeedPlayerHelper.i(r13));
        goto L35
    L37:
        getFeedPlayerHelper().f(r11, r7, sceneId());
        return;
    L24:
        if (isEnablePreload() == true) goto L27;
        AoLogger.c("preloadVideos", new Object[]{"流量，不预加载"});
        return;
    L19:
        if (isEnablePreloadWifi() == true) goto L22;
        AoLogger.c("preloadVideos", new Object[]{"wifi,不预加载"});
        return;
    L15:
        r4 = false;
        goto L17
    }

    private final void startServerRefresh(h04.e<jz3.a> r11, String r12) {
        reportStartFetchFeedInterface();
        long r4 = SystemClock.elapsedRealtime();
        if (getPageConfig().isTeenagerModel() == false) goto L5;
        d14.a r0 = b14.a.a;
        b14.a.a(n34.a.class).U2(getApplication(), new n34.b(), new d(r11, this, r12, r4));
        return;
    L5:
        d14.a r1 = b14.a.a;
        w24.d r6 = b14.a.a(w24.d.class);
        Application r7 = getApplication();
        w24.b r8 = new w24.b();
        r8.a = getPageConfig().getEnterFrom();
        r8.b = getPageConfig().getEnterAid();
        r8.q = getContentScene();
        r8.c = Integer.valueOf(this.fetchCount);
        r8.d = r12;
        r8.k = getWaitToConsumeEnterLiveRoomId();
        r8.l = Integer.valueOf(getRefreshPullType());
        r8.r = getPageConfig().getHostEnterFrom();
        r8.m = AosFeedRequestFrom.LOAD_MORE_DRAW.getRequestFrom();
        List r2 = q.b();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r8.n = r2;
        r8.o = b14.a.a(l24.a.class).p3(this.pageKey);
        r8.p = getFeedDuplicateRemovalParams();
        AosExtConfig.b.Y().b();
        r8.s = null;
        r8.t = Boolean.valueOf(isEnableHostAd());
        Unit r3 = Unit.INSTANCE;
        r6.t3(r7, r8, new e(r11, this, r12, r4));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void refreshData(h04.e<jz3.a> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        doRefresh(r1);
    }

    public static final /* synthetic */ void access$preformOnRefreshSuccess(AosFollowFeedViewModel r0, List r1, h04.e r2) {
        r0.preformOnRefreshSuccess(r1, r2);
    }

    public static final /* synthetic */ void access$preloadVideos(AosFollowFeedViewModel r0, List r1, boolean r2) {
        r0.preloadVideos(r1, r2);
    }

    public static final /* synthetic */ void access$startServerRefresh(AosFollowFeedViewModel r0, h04.e r1, String r2) {
        r0.startServerRefresh(r1, r2);
    }
}
