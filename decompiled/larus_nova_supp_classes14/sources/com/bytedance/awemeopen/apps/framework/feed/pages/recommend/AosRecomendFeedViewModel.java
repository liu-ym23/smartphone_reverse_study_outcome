package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.RecommendFirstBrushDataHelper;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.apps.framework.utils.h0;
import com.bytedance.awemeopen.apps.framework.utils.q;
import com.bytedance.awemeopen.appserviceimpl.feed.preload.FeedListPreloader;
import com.bytedance.awemeopen.bizmodels.feed.feedenum.AosFeedPullType;
import com.bytedance.awemeopen.bizmodels.feed.feedenum.AosFeedRequestFrom;
import com.bytedance.awemeopen.domain.feed.preload.AosPreloadCacheStrategy;
import com.bytedance.awemeopen.domain.feed.preload.feedlist.AosFeedListPreloadManager;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b2\u0018\u0000 n2\u00020\u0001:\u0001oB\u0007¢\u0006\u0004\bl\u0010mJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002Jt\u0010\u0016\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002Jh\u0010\u0017\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u001b\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J(\u0010$\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\"2\u0006\u0010#\u001a\u00020\nH\u0002J \u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\"H\u0002J\u0016\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010'H\u0002J\b\u0010)\u001a\u00020\nH\u0002J\u001e\u0010+\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010*\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\u0006\u0010.\u001a\u00020\nJ\b\u0010/\u001a\u00020\rH\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J$\u00104\u001a\b\u0012\u0004\u0012\u00020\b032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u00102\u001a\u00020\nH\u0016J\u001e\u00105\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u00106\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\"H\u0016J\u0016\u00108\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b07H\u0016J\u0006\u00109\u001a\u00020\u0005J\u001e\u0010=\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u001cJ*\u0010A\u001a\u00020\u00052\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b030>2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b03H\u0016J*\u0010B\u001a\u00020\u00052\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b030>2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b03H\u0016R\"\u0010C\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010Q\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010U\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010N\u001a\u0004\bS\u0010TR\u001b\u0010X\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010N\u001a\u0004\bW\u0010PR\u001b\u0010[\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010N\u001a\u0004\bZ\u0010PR\u001b\u0010^\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010N\u001a\u0004\b]\u0010TR\u001b\u0010a\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010N\u001a\u0004\b`\u0010TR\u001b\u0010d\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010N\u001a\u0004\bc\u0010TR\u001b\u0010g\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010N\u001a\u0004\bf\u0010TR\u001b\u0010j\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010N\u001a\u0004\bi\u0010TR\u0016\u0010k\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010J¨\u0006p"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosRecomendFeedViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "Ljava/util/LinkedList;", "Ls54/a;", "insertAdList", "", "packHostFeedInsertAd", "Lh04/e;", "Ljz3/a;", "callback", "", "isFirst", "doRefresh", "", "enterVideoAid", "enterRequestId", "enterAids", "enterGids", "enterGid", "enterLocalParams", "enterClientParams", "enterVideoSequence", "startServerRefreshSpecified", "startServerRefresh", "", "Lr14/c;", "data", "preformOnRefreshSuccess", "", "getRefreshPullType", "Lw24/a;", "getFeedDuplicateRemovalParams", "resetTopAids", "hostCustomAids", "Lh04/d;", "hasMoreSearchAid", "doLoadMoreSpecified", "aids", "doLoadMore", "", "getAdRequestParams", "enableAdInDraw", "isAppend", "preloadVideos", "reportStartFetchFeedInterface", "tryRecycleFeedData", "isEnableSkeletonLoading", "sceneId", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/j;", "getHostCoverParams", "isRefresh", "", "insertHostAddIfNeed", "refreshData", "loadMoreData", "Lh04/c;", "loadForwardData", "onDestroy", "cpm", "scene", "adScene", "reportCpmForFeed", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState;", "listState", "newData", "onBeforeFilterData", "onBeforeTempData2List", "pageKey", "Ljava/lang/String;", "getPageKey", "()Ljava/lang/String;", "setPageKey", "(Ljava/lang/String;)V", "fetchCount", "I", "isPreloadingFeedListWhenStartPack", "Z", "specifiedLoadMoreMaxCount$delegate", "Lkotlin/Lazy;", "getSpecifiedLoadMoreMaxCount", "()I", "specifiedLoadMoreMaxCount", "enableAd$delegate", "getEnableAd", "()Z", "enableAd", "perFeedCount$delegate", "getPerFeedCount", "perFeedCount", "perHostAdCountToInsert$delegate", "getPerHostAdCountToInsert", "perHostAdCountToInsert", "enableSkeletonLoading$delegate", "getEnableSkeletonLoading", "enableSkeletonLoading", "fixInitEmptyNotPlay$delegate", "getFixInitEmptyNotPlay", "fixInitEmptyNotPlay", "enableWaitFeedPreloadResult$delegate", "getEnableWaitFeedPreloadResult", "enableWaitFeedPreloadResult", "enableRecycleFeedData$delegate", "getEnableRecycleFeedData", "enableRecycleFeedData", "enableShouldReloadFix$delegate", "getEnableShouldReloadFix", "enableShouldReloadFix", "specifiedLoadTimes", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosRecomendFeedViewModel extends FeedPagerListViewModel {
    public static final a Companion = null;
    private static final int MAX_COUNT_FOR_SPECIFIED_LOAD_MORE = 20;
    private static final String TAG = "AosRecomendFeedViewModel";
    private final Lazy enableAd$delegate;
    private final Lazy enableRecycleFeedData$delegate;
    private final Lazy enableShouldReloadFix$delegate;
    private final Lazy enableSkeletonLoading$delegate;
    private final Lazy enableWaitFeedPreloadResult$delegate;
    private int fetchCount;
    private final Lazy fixInitEmptyNotPlay$delegate;
    private boolean isPreloadingFeedListWhenStartPack;
    private String pageKey;
    private final Lazy perFeedCount$delegate;
    private final Lazy perHostAdCountToInsert$delegate;
    private final Lazy specifiedLoadMoreMaxCount$delegate;
    private int specifiedLoadTimes;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
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

    public static final class c implements r34.b<r14.c> {
        public final /* synthetic */ h04.d<jz3.a> a;
        public final /* synthetic */ AosRecomendFeedViewModel b;

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
            AosRecomendFeedViewModel.access$preloadVideos(this.b, r7, true);
            this.a.onSuccess(r1, true);
        }

        public c(h04.d<jz3.a> r1, AosRecomendFeedViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements r34.b<r14.c> {
        public final /* synthetic */ h04.d<jz3.a> a;
        public final /* synthetic */ AosRecomendFeedViewModel b;
        public final /* synthetic */ boolean c;

        public final void onFail(Exception r1) {
            this.a.onFail();
        }

        public final void onSuccess(List<r14.c> r8) {
            Intrinsics.checkNotNullParameter(r8, "data");
            AosRecomendFeedViewModel r0 = this.b;
            boolean r2 = true;
            AosRecomendFeedViewModel.access$setSpecifiedLoadTimes$p(r0, AosRecomendFeedViewModel.access$getSpecifiedLoadTimes$p(r0) + 1);
            List<r14.c> r1 = r8;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r4 = r1.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r3.add(new jz3.a((r14.c) r4.next(), null, 14));
            goto L4
        L6:
            AosRecomendFeedViewModel.access$preloadVideos(this.b, r8, true);
            int r9 = AosRecomendFeedViewModel.access$getSpecifiedLoadMoreMaxCount(this.b) - this.b.dataSize();
            int r5 = r3.size();
            if (r9 > r5) goto L9;
            boolean r6 = false;
        L10:
            if (r5 != 0) goto L19;
            h04.d<jz3.a> r10 = this.a;
            if (r6 == true) goto L14;
        L16:
            r2 = false;
        L17:
            r10.onSuccess(r3, r2);
            return;
        L14:
            if (this.c == false) goto L16;
        L19:
            int r11 = Math.min(r9, r5);
            if (r11 >= 0) goto L22;
            r11 = 0;
        L22:
            h04.d<jz3.a> r7 = this.a;
            List<? extends jz3.a> r12 = r3.subList(0, r11);
            if (r6 == true) goto L25;
        L27:
            r2 = false;
        L28:
            r7.onSuccess(r12, r2);
            return;
        L25:
            if (this.c == false) goto L27;
        L9:
            r6 = true;
            goto L10
        }

        public d(h04.d<jz3.a> r1, AosRecomendFeedViewModel r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements h04.e<jz3.a> {
        public final /* synthetic */ h04.e<jz3.a> a;

        public e(h04.e<jz3.a> r1) {
            this.a = r1;
        }

        @Override // h04.e
        public final void a(Exception r2, int r3) {
            h04.e<jz3.a> r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }

        @Override // h04.e
        public final void b(List<? extends jz3.a> r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "data");
            h04.e<jz3.a> r0 = this.a;
            if (r0 == null) goto L6;
            r0.b(r2, r3, r4);
            return;
        }
    }

    public static final class f implements AosConfigService.c {
        public final /* synthetic */ h04.d<jz3.a> a;
        public final /* synthetic */ AosRecomendFeedViewModel b;

        public f(h04.d<jz3.a> r1, AosRecomendFeedViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(String r3, boolean r4) {
            if (r3 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == false) goto L14;
            if (r4 == false) goto L12;
            this.a.onFail();
            return;
        L12:
            this.a.onSuccess(new ArrayList(), r4);
            return;
        L14:
            this.b.setApiType(AosPagerListViewModel.API_TYPE_SPECIFIED);
            AosRecomendFeedViewModel.access$doLoadMoreSpecified(this.b, r3, this.a, r4);
            return;
        L4:
            if (r3.length() == 0) goto L7;
            r0 = false;
            goto L8
        }
    }

    public static final class g implements r34.c<r14.c> {
        public final /* synthetic */ h04.e<jz3.a> a;
        public final /* synthetic */ AosRecomendFeedViewModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public final void onSuccess(List<r14.c> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            AosEventReporter r0 = AosEventReporter.a;
            int r2 = AosRecomendFeedViewModel.access$getRefreshPullType(this.b);
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
            AosRecomendFeedViewModel.access$resetTopAids(this.b);
            AosRecomendFeedViewModel.access$preformOnRefreshSuccess(this.b, r10, this.a);
        }

        public final void a(Exception r2, int r3) {
            this.a.a(r2, r3);
        }

        public g(h04.e<jz3.a> r1, AosRecomendFeedViewModel r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class h implements r34.b<r14.c> {
        public final /* synthetic */ h04.e<jz3.a> a;
        public final /* synthetic */ AosRecomendFeedViewModel b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public final void onFail(Exception r3) {
            this.a.a(r3, -1);
        }

        public final void onSuccess(List<r14.c> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            AosEventReporter r0 = AosEventReporter.a;
            int r2 = AosRecomendFeedViewModel.access$getRefreshPullType(this.b);
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
            AosRecomendFeedViewModel.access$resetTopAids(this.b);
            AosRecomendFeedViewModel.access$preformOnRefreshSuccess(this.b, r10, this.a);
        }

        public h(h04.e<jz3.a> r1, AosRecomendFeedViewModel r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class i implements r34.b<r14.c> {
        public final /* synthetic */ h04.e<jz3.a> a;
        public final /* synthetic */ AosRecomendFeedViewModel b;

        public final void onFail(Exception r3) {
            this.a.a(r3, -1);
        }

        public final void onSuccess(List<r14.c> r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            AosRecomendFeedViewModel.access$resetTopAids(this.b);
            AosRecomendFeedViewModel.access$preformOnRefreshSuccess(this.b, r3, this.a);
        }

        public i(h04.e<jz3.a> r1, AosRecomendFeedViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        Companion = new a();
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

    private final boolean enableAdInDraw() {
        AosExtConfig.b.Y().c().getClass();
        return false;
    }

    private final boolean getEnableAd() {
        return ((Boolean) this.enableAd$delegate.getValue()).booleanValue();
    }

    private final boolean getEnableRecycleFeedData() {
        return ((Boolean) this.enableRecycleFeedData$delegate.getValue()).booleanValue();
    }

    private final boolean getEnableShouldReloadFix() {
        return ((Boolean) this.enableShouldReloadFix$delegate.getValue()).booleanValue();
    }

    private final boolean getEnableSkeletonLoading() {
        return ((Boolean) this.enableSkeletonLoading$delegate.getValue()).booleanValue();
    }

    private final boolean getEnableWaitFeedPreloadResult() {
        return ((Boolean) this.enableWaitFeedPreloadResult$delegate.getValue()).booleanValue();
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

    private final int getPerFeedCount() {
        return ((Number) this.perFeedCount$delegate.getValue()).intValue();
    }

    private final int getPerHostAdCountToInsert() {
        return ((Number) this.perHostAdCountToInsert$delegate.getValue()).intValue();
    }

    private final int getSpecifiedLoadMoreMaxCount() {
        return ((Number) this.specifiedLoadMoreMaxCount$delegate.getValue()).intValue();
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

    public final boolean getFixInitEmptyNotPlay() {
        return ((Boolean) this.fixInitEmptyNotPlay$delegate.getValue()).booleanValue();
    }

    public final void onDestroy() {
        d14.a r0 = b14.a.a;
        b14.a.a(w24.d.class).f();
        tryRecycleFeedData();
    }

    public AosRecomendFeedViewModel() {
        this.pageKey = "";
        this.specifiedLoadMoreMaxCount$delegate = LazyKt.lazy(AosRecomendFeedViewModel$specifiedLoadMoreMaxCount$2.INSTANCE);
        this.enableAd$delegate = LazyKt.lazy(AosRecomendFeedViewModel$enableAd$2.INSTANCE);
        this.perFeedCount$delegate = LazyKt.lazy(AosRecomendFeedViewModel$perFeedCount$2.INSTANCE);
        this.perHostAdCountToInsert$delegate = LazyKt.lazy(AosRecomendFeedViewModel$perHostAdCountToInsert$2.INSTANCE);
        this.enableSkeletonLoading$delegate = LazyKt.lazy(AosRecomendFeedViewModel$enableSkeletonLoading$2.INSTANCE);
        this.fixInitEmptyNotPlay$delegate = LazyKt.lazy(AosRecomendFeedViewModel$fixInitEmptyNotPlay$2.INSTANCE);
        this.enableWaitFeedPreloadResult$delegate = LazyKt.lazy(AosRecomendFeedViewModel$enableWaitFeedPreloadResult$2.INSTANCE);
        this.enableRecycleFeedData$delegate = LazyKt.lazy(AosRecomendFeedViewModel$enableRecycleFeedData$2.INSTANCE);
        this.enableShouldReloadFix$delegate = LazyKt.lazy(AosRecomendFeedViewModel$enableShouldReloadFix$2.INSTANCE);
    }

    private final Map<String, String> getAdRequestParams() {
        if (enableAdInDraw() == true) goto L7;
        d14.a r0 = b14.a.a;
        return b14.a.a(l24.a.class).p3(this.pageKey);
    L7:
        return new LinkedHashMap();
    }

    private final int getRefreshPullType() {
        ListState.State r0 = getCurrentState();
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return AosFeedPullType.INIT_LOADING.getPullType();
    L11:
        return AosFeedPullType.PULL_TO_REFRESH.getPullType();
    L9:
        return AosFeedPullType.INIT_LOADING.getPullType();
    }

    private final void tryRecycleFeedData() {
        if (getEnableRecycleFeedData() == true) goto L5;
        return;
    L5:
        if (getPageConfig().isTeenagerModel() == true) goto L60;
        ListState r0 = (ListState) getDataList().getValue();
        if (r0 == null) goto L27;
        List r1 = (List) r0.a;
        if (r1 == null) goto L27;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L28;
        Object r4 = r2.next();
        jz3.a r5 = (jz3.a) r4;
        int r6 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.a;
        int r7 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h.c(r5.a);
        if (r7 == 1) goto L18;
        if (r7 == 3) goto L18;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L12;
        r3.add(r4);
    L18:
        if (h0.a(r5.a.c()) == false) goto L24;
        r14.c r9 = r5.a;
        if (r9.q == true) goto L24;
        if (r9.r == false) goto L24;
        r8 = true;
    L28:
        Object[] r10 = new Object[1];
        StringBuilder r11 = new StringBuilder("tryRecycleFeedData: count=");
        ListState r12 = (ListState) getDataList().getValue();
        if (r12 == null) goto L33;
        List r13 = (List) r12.a;
        if (r13 == null) goto L33;
        int r14 = r13.size();
    L34:
        r11.append(r14);
        r11.append(", match=");
        if (r3 == null) goto L37;
        int r15 = r3.size();
    L38:
        r11.append(r15);
        r10[0] = r11.toString();
        AoLogger.g(TAG, r10);
        if (r3 != null) goto L41;
    L44:
        boolean r16 = true;
    L45:
        if (r16 == false) goto L47;
        return;
    L47:
        List r17 = r3.subList(0, Math.min(AosExtConfig.b.z0().d, r3.size()));
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L49:
        if (r19.hasNext() == false) goto L51;
        r14.c r20 = ((jz3.a) r19.next()).a;
        r20.p = true;
        r18.add(r20);
        goto L49
    L51:
        d14.a r21 = b14.a.a;
        b14.a.a(v24.c.class).W2();
        FeedListPreloader.a.g(r18);
        return;
    L41:
        if (r3.isEmpty() == true) goto L44;
        r16 = false;
        goto L45
    L37:
        r15 = 0;
    L33:
        r14 = 0;
    L27:
        r3 = null;
        goto L28
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public j getHostCoverParams() {
        FeedPageConfig r0 = getPageConfig();
        return new j(r0.getHostCoverUrl(), r0.getHostCoverWidth(), r0.getHostCoverHeight(), r0.getExcludedHeight(), r0.getDoubleBallLoadingDelay());
    }

    public final boolean isEnableSkeletonLoading() {
        if (getEnableSkeletonLoading() == false) goto L5;
    L8:
        return true;
    L5:
        if (getPageConfig().getEnableRecFeedSkeletonLoading() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return getSceneId();
    }

    public final String getPageKey() {
        return this.pageKey;
    }

    public static final /* synthetic */ boolean access$enableAdInDraw(AosRecomendFeedViewModel r0) {
        return r0.enableAdInDraw();
    }

    public static final /* synthetic */ Map access$getAdRequestParams(AosRecomendFeedViewModel r0) {
        return r0.getAdRequestParams();
    }

    public static final /* synthetic */ Application access$getApplication(AosRecomendFeedViewModel r0) {
        return r0.getApplication();
    }

    public static final /* synthetic */ boolean access$getEnableWaitFeedPreloadResult(AosRecomendFeedViewModel r0) {
        return r0.getEnableWaitFeedPreloadResult();
    }

    public static final /* synthetic */ w24.a access$getFeedDuplicateRemovalParams(AosRecomendFeedViewModel r0) {
        return r0.getFeedDuplicateRemovalParams();
    }

    public static final /* synthetic */ int access$getFetchCount$p(AosRecomendFeedViewModel r0) {
        return r0.fetchCount;
    }

    public static final /* synthetic */ int access$getRefreshPullType(AosRecomendFeedViewModel r0) {
        return r0.getRefreshPullType();
    }

    public static final /* synthetic */ int access$getSpecifiedLoadMoreMaxCount(AosRecomendFeedViewModel r0) {
        return r0.getSpecifiedLoadMoreMaxCount();
    }

    public static final /* synthetic */ int access$getSpecifiedLoadTimes$p(AosRecomendFeedViewModel r0) {
        return r0.specifiedLoadTimes;
    }

    public static final /* synthetic */ void access$resetTopAids(AosRecomendFeedViewModel r0) {
        r0.resetTopAids();
    }

    private final void packHostFeedInsertAd(LinkedList<s54.a> r4) {
        int r0 = getPerHostAdCountToInsert();
        int r1 = 1;
        if (1 > r0) goto L7;
    L4:
        AosExtConfig.b.Y().a();
        r4.add(null);
        if (r1 == r0) goto L9;
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void loadMoreData(h04.d<jz3.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (getPageConfig().getNeedCustomLoadMore() == false) goto L6;
        AosExtConfig.b.E0(this.specifiedLoadTimes, new f(r4, this));
        return;
    L6:
        setApiType(AosPagerListViewModel.API_TYPE_FEED);
        doLoadMore(null, r4);
    }

    public final void setPageKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageKey = r2;
    }

    public static final /* synthetic */ void access$setSpecifiedLoadTimes$p(AosRecomendFeedViewModel r0, int r1) {
        r0.specifiedLoadTimes = r1;
    }

    private final void doLoadMore(String r4, final h04.d<jz3.a> r5) {
        reportStartFetchFeedInterface();
        if (getPageConfig().isTeenagerModel() == false) goto L5;
        d14.a r6 = b14.a.a;
        b14.a.a(n34.a.class).A(getApplication(), new n34.b(), new c(r5, this));
        return;
    L5:
        final Function0<Unit> r7 = new AosRecomendFeedViewModel$doLoadMore$loadMoreRequestBlock$1(this, r5);
        if (getEnableWaitFeedPreloadResult() == true) goto L8;
    L10:
        r7.invoke();
        return;
    L8:
        if (this.isPreloadingFeedListWhenStartPack == false) goto L10;
        this.isPreloadingFeedListWhenStartPack = false;
        d14.a r0 = b14.a.a;
        b14.a.a(v24.c.class).W2();
        FeedListPreloader.a.e(new AnonymousClass2(r7, this, r5));
    }

    private final void doRefresh(final h04.e<jz3.a> r32, boolean r33) {
        j04.a r0 = j04.b.a;
        long r1 = System.currentTimeMillis();
        j04.a r2 = j04.b.a;
        if (r2 == null) goto L5;
        r2.c = r1;
    L5:
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = getWaitToConsumeEnterAid();
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = getWaitToConsumeEnterRequestId();
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        if (r33 == false) goto L8;
        r4.element = getWaitToConsumeEnterAid();
        r5.element = getWaitToConsumeEnterRequestId();
        r7.element = getWaitToConsumeEnterGid();
        r12.element = getWaitToConsumeEnterLocalParams();
        r13.element = getWaitToConsumeEnterClientParams();
        r6.element = getWaitToConsumeEnterAids();
        r8.element = getWaitToConsumeEnterGids();
        r14.element = getWaitToConsumeEnterHostVideoSequence();
    L8:
        final String r9 = getWaitToConsumeEnterLiveRoomId();
        if (getPageConfig().getNeedCustomLoadMore() == false) goto L12;
        SystemClock.elapsedRealtime();
        setApiType(AosPagerListViewModel.API_TYPE_SPECIFIED);
        int r3 = RecommendFirstBrushDataHelper.a;
        RecommendFirstBrushDataHelper.a((String) r4.element, (String) r5.element, (String) r6.element, (String) r8.element, (String) r7.element, (String) r12.element, (String) r13.element, (String) r14.element, getContentScene(), AosPreloadCacheStrategy.ONLY_NEED_SPECIFIED_AIDS_IN_CACHE, getFeedDuplicateRemovalParams(), getPageConfig().isTeenagerModel(), new AnonymousClass1(r6, this, r32, r4, r5, r8, r7, r12, r13, r14));
        return;
    L12:
        boolean r10 = true;
        if (r9 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L21;
        setApiType(AosPagerListViewModel.API_TYPE_FEED);
        startServerRefresh(new e(r32), (String) r4.element, (String) r6.element, (String) r8.element, (String) r7.element, (String) r12.element, (String) r13.element, (String) r14.element);
        return;
    L21:
        final long r16 = SystemClock.elapsedRealtime();
        d14.a r15 = b14.a.a;
        b14.a.a(v24.c.class).W2();
        final FeedListPreloader r17 = FeedListPreloader.a;
        boolean r18 = AosFeedListPreloadManager.a;
        final boolean r19 = AosFeedListPreloadManager.b;
        if (r19 == false) goto L27;
        if (r33 == false) goto L27;
        if (getPageConfig().isTeenagerModel() == true) goto L27;
    L28:
        this.isPreloadingFeedListWhenStartPack = r10;
        int r20 = RecommendFirstBrushDataHelper.a;
        RecommendFirstBrushDataHelper.a((String) r4.element, (String) r5.element, (String) r6.element, (String) r8.element, (String) r7.element, (String) r12.element, (String) r13.element, (String) r14.element, getContentScene(), AosPreloadCacheStrategy.DEFAULT_STRATEGY, getFeedDuplicateRemovalParams(), getPageConfig().isTeenagerModel(), new AnonymousClass3(this, r19, r17, r4, r6, r7, r8, r9, r16, r32, r12, r13, r14));
        return;
    L27:
        r10 = false;
        goto L28
    L15:
        if (r9.length() == 0) goto L18;
        r11 = false;
        goto L19
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
        List<? extends jz3.a> r3 = r1;
        if (getPageConfig().getNeedCustomLoadMore() == false) goto L11;
        int r9 = r1.size();
        r3 = r1;
        if (r9 <= getSpecifiedLoadMoreMaxCount()) goto L11;
        r3 = r1.subList(0, getSpecifiedLoadMoreMaxCount());
    L11:
        r8.b(r3, false, true);
    }

    private final void preloadVideos(List<r14.c> r5, boolean r6) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        d14.a r3 = b14.a.a;
        x24.a r4 = b14.a.a(x24.a.class);
        if (r4.W((r14.c) r1) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r14.c r9 = (r14.c) r2.next();
        getFeedPlayerHelper().getClass();
        r8.add(FeedPlayerHelper.i(r9));
        goto L10
    L12:
        getFeedPlayerHelper().f(r8, r6, sceneId());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> insertHostAddIfNeed(List<? extends jz3.a> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        if (enableAdInDraw() == false) goto L65;
        if (getPageConfig().getDecodeByOpenAid() == true) goto L65;
        int r0 = 0;
        if (r11 == true) goto L33;
        ListState r12 = (ListState) getDataList().getValue();
        if (r12 == null) goto L25;
        List r13 = (List) r12.a;
        if (r13 == null) goto L25;
        ListIterator r14 = r13.listIterator(r13.size());
    L15:
        if (r14.hasPrevious() == false) goto L24;
        jz3.a r2 = (jz3.a) r14.previous();
        if (r2.a.e == true) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L15;
        int r15 = r14.nextIndex();
    L26:
        ListState r4 = (ListState) getDataList().getValue();
        if (r4 == null) goto L31;
        List r5 = (List) r4.a;
        if (r5 == null) goto L31;
        int r6 = r5.size();
    L32:
        int r7 = r6 - (r15 + 1);
    L34:
        int r16 = getPerFeedCount() - r7;
        if (r16 < 0) goto L38;
        r0 = r16;
    L38:
        List<? extends jz3.a> r17 = r10;
        int r18 = r17.size();
        if (r0 >= r18) goto L41;
        LinkedList<s54.a> r8 = new LinkedList();
        ArrayList r9 = new ArrayList();
        r9.add(Integer.valueOf(r0));
        packHostFeedInsertAd(r8);
        int r19 = r18 - r0;
        if (r19 < getPerFeedCount()) goto L50;
        int r110 = r19 / getPerFeedCount();
        if (1 > r110) goto L50;
        int r20 = 1;
    L47:
        r9.add(Integer.valueOf((getPerFeedCount() * r20) + r0));
        packHostFeedInsertAd(r8);
        if (r20 == r110) goto L50;
        r20 = r20 + 1;
    L50:
        CollectionsKt.reverse(r9);
        List<jz3.a> r111 = CollectionsKt.toMutableList(r17);
        Iterator r112 = r9.iterator();
    L52:
        if (r112.hasNext() == false) goto L63;
        int r1 = ((Number) r112.next()).intValue();
        int r21 = getPerHostAdCountToInsert();
        if (1 > r21) goto L52;
        int r22 = 1;
    L57:
        if ((!r8.isEmpty()) == false) goto L61;
        s54.a r23 = r8.removeLast();
        if (r23 == null) goto L61;
        r14.c r24 = new r14.c();
        r24.e = true;
        Unit r25 = Unit.INSTANCE;
        ListProtector.add(r111, r1, new jz3.a(r24, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.f(r23), 12));
    L61:
        if (r22 == r21) goto L52;
        r22 = r22 + 1;
        goto L57
    L63:
        return r111;
    L41:
        return CollectionsKt.toMutableList(r17);
    L31:
        r6 = 0;
        goto L32
    L19:
        if (r2.b == null) goto L21;
        r3 = true;
        goto L22
    L24:
        r15 = -1;
    L25:
        r15 = 0;
        goto L26
    L33:
        r7 = 0;
    L65:
        return CollectionsKt.toMutableList(r10);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void onBeforeFilterData(ListState<List<jz3.a>> r2, List<jz3.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "listState");
        Intrinsics.checkNotNullParameter(r3, "newData");
        if (isEnableSkeletonLoading() == true) goto L5;
        return;
    L5:
        if ((!r2.a.isEmpty()) == false) goto L9;
        CollectionsKt.removeAll(r2.a, C02331.INSTANCE);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void onBeforeTempData2List(ListState<List<jz3.a>> r6, List<jz3.a> r7) {
        Intrinsics.checkNotNullParameter(r6, "listState");
        Intrinsics.checkNotNullParameter(r7, "newData");
        if (isEnableSkeletonLoading() == true) goto L5;
        return;
    L5:
        if (getPageConfig().getNeedLoadMore() == true) goto L7;
        return;
    L7:
        if (r6.g == true) goto L9;
        return;
    L9:
        if ((!r7.isEmpty()) == true) goto L11;
        return;
    L11:
        if (getEnableShouldReloadFix() == true) goto L13;
        ((jz3.a) ListProtector.get(r7, 0)).a.b = true;
    L26:
        r14.c r8 = new r14.c();
        r8.a = true;
        r7.add(new jz3.a(r8, null, 14));
        return;
    L13:
        if ((!r6.a.isEmpty()) == false) goto L26;
        List<jz3.a> r9 = r6.a;
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L16:
        if (r10.hasNext() == false) goto L20;
        Object r3 = r10.next();
        if (((jz3.a) r3).a.b == false) goto L16;
        r0.add(r3);
        goto L16
    L20:
        Iterator r11 = r0.iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        ((jz3.a) r11.next()).a.b = false;
        goto L22
    L24:
        ((jz3.a) ListProtector.get(r7, 0)).a.b = true;
        goto L26
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public void refreshData(h04.e<jz3.a> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        doRefresh(r2, r3);
    }

    public static final /* synthetic */ void access$preformOnRefreshSuccess(AosRecomendFeedViewModel r0, List r1, h04.e r2) {
        r0.preformOnRefreshSuccess(r1, r2);
    }

    public static final /* synthetic */ void access$preloadVideos(AosRecomendFeedViewModel r0, List r1, boolean r2) {
        r0.preloadVideos(r1, r2);
    }

    private final void doLoadMoreSpecified(String r5, h04.d<jz3.a> r6, boolean r7) {
        d14.a r0 = b14.a.a;
        w24.d r1 = b14.a.a(w24.d.class);
        Application r2 = getApplication();
        w24.b r3 = new w24.b();
        r3.a = getPageConfig().getEnterFrom();
        r3.e = r5;
        r3.q = getContentScene();
        r3.c = Integer.valueOf(this.fetchCount);
        r3.r = getPageConfig().getHostEnterFrom();
        r3.h = getPageConfig().getEnterHostlocalParams();
        r3.l = Integer.valueOf(AosFeedPullType.LOAD_MORE.getPullType());
        r3.m = AosFeedRequestFrom.LOAD_MORE_DRAW.getRequestFrom();
        List r8 = q.b();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r3.n = r8;
        r3.o = getAdRequestParams();
        r3.p = getFeedDuplicateRemovalParams();
        AosExtConfig.b.Y().b();
        r3.s = null;
        r3.t = Boolean.valueOf(enableAdInDraw());
        Unit r9 = Unit.INSTANCE;
        r1.z1(r2, r3, new d(r6, this, r7));
    }

    public final void reportCpmForFeed(int r3, int r4, int r5) {
        d14.a r0 = b14.a.a;
        b14.a.a(w24.d.class).Q(r3, r4, r5, C02341.INSTANCE);
    }

    public static final /* synthetic */ void access$doLoadMoreSpecified(AosRecomendFeedViewModel r0, String r1, h04.d r2, boolean r3) {
        r0.doLoadMoreSpecified(r1, r2, r3);
    }

    private final void startServerRefresh(h04.e<jz3.a> r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        reportStartFetchFeedInterface();
        long r0 = SystemClock.elapsedRealtime();
        if (getPageConfig().isTeenagerModel() == false) goto L5;
        d14.a r15 = b14.a.a;
        b14.a.a(n34.a.class).U2(getApplication(), new n34.b(), new g(r7, this, r8, r0));
        return;
    L5:
        d14.a r16 = b14.a.a;
        w24.d r2 = b14.a.a(w24.d.class);
        Application r3 = getApplication();
        w24.b r4 = new w24.b();
        r4.a = getPageConfig().getEnterFrom();
        r4.b = getPageConfig().getEnterAid();
        r4.q = getContentScene();
        r4.c = Integer.valueOf(this.fetchCount);
        r4.d = r8;
        r4.e = r9;
        r4.g = r10;
        r4.r = getPageConfig().getHostEnterFrom();
        r4.h = getPageConfig().getEnterHostlocalParams();
        r4.i = r13;
        r4.j = r14;
        r4.k = getWaitToConsumeEnterLiveRoomId();
        r4.l = Integer.valueOf(getRefreshPullType());
        r4.m = AosFeedRequestFrom.LOAD_MORE_DRAW.getRequestFrom();
        List r17 = q.b();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r4.n = r17;
        r4.o = getAdRequestParams();
        r4.p = getFeedDuplicateRemovalParams();
        AosExtConfig.b.Y().b();
        r4.s = null;
        r4.t = Boolean.valueOf(enableAdInDraw());
        Unit r18 = Unit.INSTANCE;
        r2.t3(r3, r4, new h(r7, this, r8, r0));
    }

    public static final /* synthetic */ void access$startServerRefresh(AosRecomendFeedViewModel r0, h04.e r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        r0.startServerRefresh(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    private final void startServerRefreshSpecified(h04.e<jz3.a> r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        d14.a r12 = b14.a.a;
        w24.d r13 = b14.a.a(w24.d.class);
        Application r14 = getApplication();
        w24.b r0 = new w24.b();
        r0.a = getPageConfig().getEnterFrom();
        r0.b = getPageConfig().getEnterAid();
        r0.q = getContentScene();
        r0.c = Integer.valueOf(this.fetchCount);
        r0.d = r4;
        r0.e = r6;
        r0.f = r5;
        r0.g = r7;
        r0.r = getPageConfig().getHostEnterFrom();
        r0.h = getPageConfig().getEnterHostlocalParams();
        r0.i = r10;
        r0.j = r11;
        r0.k = getWaitToConsumeEnterLiveRoomId();
        r0.l = Integer.valueOf(getRefreshPullType());
        r0.m = AosFeedRequestFrom.LOAD_MORE_DRAW.getRequestFrom();
        List r15 = q.b();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r0.n = r15;
        r0.o = getAdRequestParams();
        r0.p = getFeedDuplicateRemovalParams();
        AosExtConfig.b.Y().b();
        r0.s = null;
        r0.t = Boolean.valueOf(enableAdInDraw());
        Unit r16 = Unit.INSTANCE;
        r13.z1(r14, r0, new i(r3, this));
    }

    public static final /* synthetic */ void access$startServerRefreshSpecified(AosRecomendFeedViewModel r0, h04.e r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        r0.startServerRefreshSpecified(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void startServerRefresh$default(AosRecomendFeedViewModel r12, h04.e r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, int r21, Object r22) {
        if ((r21 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r21 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r21 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r21 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r21 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r21 & 128) == 0) goto L25;
        String r11 = null;
    L26:
        r12.startServerRefresh(r13, r14, r6, r7, r8, r9, r10, r11);
        return;
    L25:
        r11 = r20;
        goto L26
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public static /* synthetic */ void startServerRefreshSpecified$default(AosRecomendFeedViewModel r13, h04.e r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, int r23, Object r24) {
        if ((r23 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r23 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        String r12 = null;
    L30:
        r13.startServerRefreshSpecified(r14, r15, r6, r7, r8, r9, r10, r11, r12);
        return;
    L29:
        r12 = r22;
        goto L30
    L25:
        r11 = r21;
        goto L27
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
