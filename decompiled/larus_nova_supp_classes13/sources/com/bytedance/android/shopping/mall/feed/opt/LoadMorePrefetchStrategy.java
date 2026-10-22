package com.bytedance.android.shopping.mall.feed.opt;

import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ListEngineOptConfig;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.q;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.pitaya.api.PTYMessageHandler;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import e93.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B!\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00106\u001a\u00020/\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J4\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J#\u0010\u0018\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\nH\u0016J\u000f\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 H\u0016J1\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010$R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010,R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010,R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00104\u001a\u0004\u0018\u0001038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00101¨\u0006="}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/opt/LoadMorePrefetchStrategy;", "Le93/e;", "Lcom/bytedance/android/ec/hybrid/list/opt/a;", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "", "isOpenPage", "", "registerPitayaListener", "reportForPitaya", "checkNotifyPitaya", "", "last", "total", "prevItemCount", "alreadyScrollY", "Lkotlin/Pair;", "checkLoadMoreFromNewSetting", "tabId", "onTabChange", "(Ljava/lang/Integer;)V", "onBackMall", "onLeaveMall", "preRequestCount", "nextPageCount", "updatePreRequestCount", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "curNextPageCount", "curPreRequestCount", "()Ljava/lang/Integer;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "injectRecyclerView", "Lorg/json/JSONObject;", "message", "onMessage", "shouldExecuteLoadMore", "(Landroidx/recyclerview/widget/RecyclerView;III)Ljava/lang/Boolean;", "", "tabOffsetY", "Ljava/util/Map;", "", "tabPreReportTime", "tabPreOffsetY", "curTabId", "Ljava/lang/Integer;", "state", "I", "", "msgTag", "Ljava/lang/String;", "curCheckNextPageCount", "Lcom/bytedance/android/ec/hybrid/list/ListEngineOptConfig;", "listEngineOpt", "Lcom/bytedance/android/ec/hybrid/list/ListEngineOptConfig;", "pageName", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "(Lcom/bytedance/android/ec/hybrid/list/ListEngineOptConfig;Ljava/lang/String;Landroidx/lifecycle/Lifecycle;)V", "Companion", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMorePrefetchStrategy implements e, com.bytedance.android.ec.hybrid.list.opt.a, PTYMessageHandler {
    public static final a Companion = null;
    private static final String PITAYA_TAG = "ecom_mall_fast_scroll_msg";
    private static final a.C0087a setting = null;
    private int curCheckNextPageCount;
    private Integer curTabId;
    private final ListEngineOptConfig listEngineOpt;
    private final String msgTag;
    private volatile Integer nextPageCount;
    private final String pageName;
    private volatile Integer preRequestCount;
    private int state;
    private final Map<Integer, Integer> tabOffsetY;
    private final Map<Integer, Integer> tabPreOffsetY;
    private final Map<Integer, Long> tabPreReportTime;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.opt.LoadMorePrefetchStrategy$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/opt/LoadMorePrefetchStrategy$a$a;", "", "", "loadMoreFromPitaya", "Z", "a", "()Z", "", "scrollYToNotify", "I", "d", "()I", "", "scrollTimeToNotify", "J", "c", "()J", "", "pageName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0087a {

            @SerializedName("load_more_from_pitaya")
            private final boolean loadMoreFromPitaya;

            @SerializedName("pageName")
            private final String pageName;

            @SerializedName("scroll_time_to_notify")
            private final long scrollTimeToNotify;

            @SerializedName("scroll_y_to_notify")
            private final int scrollYToNotify;

            public C0087a() {
                this(0);
            }

            public final boolean equals(Object r6) {
                if (this != r6) goto L4;
                return true;
            L4:
                if ((r6 instanceof C0087a) == false) goto L14;
                C0087a r7 = (C0087a) r6;
                if (this.loadMoreFromPitaya == r7.loadMoreFromPitaya) goto L8;
                return false;
            L8:
                if (this.scrollYToNotify == r7.scrollYToNotify) goto L10;
                return false;
            L10:
                if (this.scrollTimeToNotify == r7.scrollTimeToNotify) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.pageName, r7.pageName) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            public final int hashCode() {
                boolean r0 = this.loadMoreFromPitaya;
                ?? r1 = r0;
                if (r0 == false) goto L5;
                r1 = 1;
            L5:
                int r2 = ((r1 * 31) + this.scrollYToNotify) * 31;
                long r3 = this.scrollTimeToNotify;
                int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
                String r5 = this.pageName;
                if (r5 == null) goto L8;
                int r6 = r5.hashCode();
            L10:
                return r4 + r6;
            L8:
                r6 = 0;
                goto L10
            }

            public final String toString() {
                return "LoadMorePrefetchStrategyParam(loadMoreFromPitaya=" + this.loadMoreFromPitaya + ", scrollYToNotify=" + this.scrollYToNotify + ", scrollTimeToNotify=" + this.scrollTimeToNotify + ", pageName=" + this.pageName + ")";
            }

            public final boolean a() {
                return this.loadMoreFromPitaya;
            }

            public final String b() {
                return this.pageName;
            }

            public final long c() {
                return this.scrollTimeToNotify;
            }

            public final int d() {
                return this.scrollYToNotify;
            }

            public C0087a(int r4) {
                Intrinsics.checkNotNullParameter(MallPageName.X_TAB_MALL, "pageName");
                this.loadMoreFromPitaya = false;
                this.scrollYToNotify = 400;
                this.scrollTimeToNotify = 5000;
                this.pageName = MallPageName.X_TAB_MALL;
            }
        }

        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LoadMorePrefetchStrategy a;

        public b(LoadMorePrefetchStrategy r1) {
            this.a = r1;
        }

        public final void a() {
            int r1 = 0;
            int r2 = 1;
            if (LoadMorePrefetchStrategy.access$getState$p(this.a) == 1) goto L6;
            r2 = 0;
        L6:
            JSONObject r0 = new JSONObject();
            r0.putOpt("tab_id", LoadMorePrefetchStrategy.access$getCurTabId$p(this.a));
            Map r3 = LoadMorePrefetchStrategy.access$getTabOffsetY$p(this.a);
            Integer r4 = LoadMorePrefetchStrategy.access$getCurTabId$p(this.a);
            if (r4 == null) goto L9;
            r1 = r4.intValue();
        L9:
            r0.putOpt("offsetY", r3.get(Integer.valueOf(r1)));
            r0.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, LoadMorePrefetchStrategy.access$getPageName$p(this.a));
            r0.putOpt("fling", Integer.valueOf(r2));
            Unit r5 = Unit.INSTANCE;
            AppLogNewUtils.onEventV3("mall_scroll_offset_for_pitaya", r0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // e93.e
    public void initOrRefresh(boolean r1, Integer r2) {
    }

    @Override // e93.e
    public void onDestroy() {
    }

    @Override // e93.e
    public void onEnterBackGround(boolean r1) {
    }

    @Override // e93.e
    public void onFirstScreen() {
    }

    @Override // e93.e
    public void onGylRefreshStart() {
    }

    @Override // e93.e
    public void onPause() {
    }

    @Override // e93.e
    public void onRefreshEnd() {
    }

    @Override // e93.e
    public void onStartLoadFeed() {
    }

    static {
        Companion = new a();
        int r0 = s93.c.a;
        Object r1 = new a.C0087a(0);
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("mall_load_more_from_pitaya", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_load_more_from_pitaya, Value: " + r1);
        setting = (a.C0087a) r1;
    }

    private final void checkNotifyPitaya() {
        Integer r0 = this.curTabId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        Integer r3 = this.tabOffsetY.get(Integer.valueOf(r2));
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        Integer r5 = this.tabPreOffsetY.get(Integer.valueOf(r2));
        if (r5 == null) goto L13;
        r1 = r5.intValue();
    L13:
        Long r6 = this.tabPreReportTime.get(Integer.valueOf(r2));
        if (r6 == null) goto L16;
        long r7 = r6.longValue();
    L17:
        int r8 = r4 - r1;
        a.C0087a r9 = setting;
        if (r8 < r9.d()) goto L20;
    L21:
        this.tabPreOffsetY.put(Integer.valueOf(r2), Integer.valueOf(r4));
        this.tabPreReportTime.put(Integer.valueOf(r2), Long.valueOf(System.currentTimeMillis()));
        reportForPitaya();
        return;
    L20:
        if ((System.currentTimeMillis() - r7) >= r9.c()) goto L21;
        return;
    L16:
        r7 = 0;
        goto L17
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    private final boolean isOpenPage() {
        a.C0087a r0 = setting;
        if (r0.a() == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r0.b(), this.pageName, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int curNextPageCount() {
        if ((!Intrinsics.areEqual(this.pageName, MallPageName.X_TAB_MALL)) == true) goto L5;
    L8:
        Integer r0 = this.nextPageCount;
        if (r0 != null) goto L13;
        return 0;
    L13:
        return r0.intValue();
    L5:
        if ((!Intrinsics.areEqual(this.pageName, "order_homepage")) == false) goto L8;
        return -1;
    }

    public Integer curPreRequestCount() {
        return Integer.valueOf(this.curCheckNextPageCount);
    }

    @Override // e93.e
    public void onLeaveMall() {
        String r0 = HybridAppInfoService.p.getAppId();
        if (r0 == null) goto L6;
        PitayaCoreFactory.getCore(r0).removeMessageHandler(this.msgTag);
        return;
    }

    private final void registerPitayaListener() {
        if (isOpenPage() == true) goto L5;
        return;
    L5:
        String r0 = HybridAppInfoService.p.getAppId();
        if (r0 == null) goto L9;
        PitayaCoreFactory.getCore(r0).registerMessageHandler(this.msgTag, this);
        return;
    }

    private final void reportForPitaya() {
        ThreadPoolHelper.c().submit(new b(this));
    }

    @Override // e93.e
    public void onBackMall() {
        registerPitayaListener();
    }

    public static final /* synthetic */ void access$checkNotifyPitaya(LoadMorePrefetchStrategy r0) {
        r0.checkNotifyPitaya();
    }

    public static final /* synthetic */ Integer access$getCurTabId$p(LoadMorePrefetchStrategy r0) {
        return r0.curTabId;
    }

    public static final /* synthetic */ String access$getMsgTag$p(LoadMorePrefetchStrategy r0) {
        return r0.msgTag;
    }

    public static final /* synthetic */ String access$getPageName$p(LoadMorePrefetchStrategy r0) {
        return r0.pageName;
    }

    public static final /* synthetic */ int access$getState$p(LoadMorePrefetchStrategy r0) {
        return r0.state;
    }

    public static final /* synthetic */ Map access$getTabOffsetY$p(LoadMorePrefetchStrategy r0) {
        return r0.tabOffsetY;
    }

    public static final /* synthetic */ void access$registerPitayaListener(LoadMorePrefetchStrategy r0) {
        r0.registerPitayaListener();
    }

    public void injectRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (isOpenPage() == true) goto L5;
        return;
    L5:
        r2.addOnScrollListener(new C02721(this));
    }

    public JSONObject onMessage(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        String r0 = r5.optString(PdpOpenThirdParam.KEY_PAGE_NAME);
        int r1 = r5.optInt("tab_id");
        if ((!Intrinsics.areEqual(r0, this.pageName)) == true) goto L18;
        Integer r2 = this.curTabId;
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r1 != r2.intValue()) goto L20;
        int r3 = r5.optInt("pre_request_count");
        int r6 = r5.optInt("request_count");
        if (r3 <= 0) goto L13;
        this.preRequestCount = Integer.valueOf(r3);
    L13:
        if (r6 <= 0) goto L15;
        this.nextPageCount = Integer.valueOf(r6);
    L15:
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(q.a.b, "pitaya load more trigger, preCount: " + r3 + ", nextCount: " + r6);
        return null;
    L20:
        return null;
    L18:
        return null;
    }

    @Override // e93.e
    public void onTabChange(Integer r4) {
        int r0 = 0;
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        this.curTabId = Integer.valueOf(r5);
        Integer r1 = this.tabOffsetY.get(Integer.valueOf(r5));
        if (r1 == null) goto L9;
        r0 = r1.intValue();
    L9:
        this.tabOffsetY.put(Integer.valueOf(r5), Integer.valueOf(r0));
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public static final /* synthetic */ void access$setCurTabId$p(LoadMorePrefetchStrategy r0, Integer r1) {
        r0.curTabId = r1;
    }

    public static final /* synthetic */ void access$setState$p(LoadMorePrefetchStrategy r0, int r1) {
        r0.state = r1;
    }

    public void updatePreRequestCount(Integer r3, Integer r4) {
        if (isOpenPage() == false) goto L5;
        return;
    L5:
        int r0 = 0;
        if (r3 == null) goto L8;
        int r1 = r3.intValue();
    L9:
        if (r1 <= 0) goto L11;
        this.preRequestCount = r3;
    L11:
        if (r4 == null) goto L13;
        r0 = r4.intValue();
    L13:
        if (r0 <= 0) goto L16;
        this.nextPageCount = r4;
        return;
    L16:
        return;
    L8:
        r1 = 0;
        goto L9
    }

    public LoadMorePrefetchStrategy(ListEngineOptConfig r2, String r3, Lifecycle r4) {
        Intrinsics.checkNotNullParameter(r3, "pageName");
        Intrinsics.checkNotNullParameter(r4, "lifecycle");
        this.listEngineOpt = r2;
        this.pageName = r3;
        this.tabOffsetY = new LinkedHashMap();
        this.tabPreReportTime = new LinkedHashMap();
        this.tabPreOffsetY = new LinkedHashMap();
        this.msgTag = "ecom_mall_fast_scroll_msg." + r3;
        this.curCheckNextPageCount = 5;
        r4.addObserver(new AnonymousClass1(this));
        registerPitayaListener();
    }

    private final Pair<Boolean, Boolean> checkLoadMoreFromNewSetting(int r5, int r6, int r7, int r8) {
        ListEngineOptConfig r0 = this.listEngineOpt;
        if (r0 == null) goto L12;
        Integer r1 = r0.c;
        if (r1 == null) goto L12;
        int r2 = r1.intValue();
        if (r2 < 0) goto L12;
        if (r5 >= (r2 + r7)) goto L12;
        return new Pair(Boolean.TRUE, Boolean.FALSE);
    L12:
        Integer r3 = null;
        boolean r4 = true;
        if (r7 != 0) goto L67;
        ListEngineOptConfig r9 = this.listEngineOpt;
        if (r9 == null) goto L38;
        Integer r10 = r9.e;
        if (r10 == null) goto L38;
        int r11 = r10.intValue();
        Integer r12 = this.listEngineOpt.f;
        if (r12 != null) goto L29;
        Boolean r13 = Boolean.TRUE;
        if (r5 > 0) goto L23;
    L25:
        r4 = false;
    L27:
        return new Pair(r13, Boolean.valueOf(r4));
    L23:
        if (r5 < (r6 - r11)) goto L25;
    L29:
        if (r12.intValue() <= r8) goto L38;
        Boolean r14 = Boolean.TRUE;
        if (r5 > 0) goto L33;
    L35:
        r4 = false;
    L37:
        return new Pair(r14, Boolean.valueOf(r4));
    L33:
        if (r5 < (r6 - r11)) goto L35;
    L38:
        Integer r15 = this.preRequestCount;
        if (r15 != null) goto L41;
    L55:
        ListEngineOptConfig r16 = this.listEngineOpt;
        if (r16 == null) goto L113;
        Integer r17 = r16.a;
        if (r17 == null) goto L113;
        int r18 = r17.intValue();
        Boolean r19 = Boolean.TRUE;
        if (r5 > 0) goto L62;
    L64:
        r4 = false;
    L66:
        return new Pair(r19, Boolean.valueOf(r4));
    L62:
        if (r5 < (r6 - r18)) goto L64;
    L113:
        Boolean r20 = Boolean.FALSE;
        return new Pair(r20, r20);
    L41:
        if (r15.intValue() <= 0) goto L43;
        boolean r21 = true;
    L44:
        if (r21 == false) goto L46;
        r3 = r15;
    L46:
        if (r3 == null) goto L55;
        int r22 = r3.intValue();
        Boolean r23 = Boolean.TRUE;
        if (r5 > 0) goto L50;
    L52:
        r4 = false;
    L54:
        return new Pair(r23, Boolean.valueOf(r4));
    L50:
        if (r5 < (r6 - r22)) goto L52;
    L43:
        r21 = false;
        goto L44
    L67:
        if (r7 <= 0) goto L113;
        ListEngineOptConfig r24 = this.listEngineOpt;
        if (r24 == null) goto L80;
        Integer r25 = r24.d;
        if (r25 == null) goto L80;
        int r26 = r25.intValue();
        Boolean r27 = Boolean.TRUE;
        if (r5 > 0) goto L75;
    L77:
        r4 = false;
    L79:
        return new Pair(r27, Boolean.valueOf(r4));
    L75:
        if (r5 < (r6 - r26)) goto L77;
    L80:
        Integer r28 = this.preRequestCount;
        if (r28 != null) goto L83;
    L99:
        ListEngineOptConfig r29 = this.listEngineOpt;
        if (r29 == null) goto L113;
        Integer r30 = r29.b;
        if (r30 == null) goto L113;
        int r31 = r30.intValue();
        Boolean r32 = Boolean.TRUE;
        if (r5 > 0) goto L106;
    L108:
        r4 = false;
    L109:
        Pair<Boolean, Boolean> r33 = new Pair(r32, Boolean.valueOf(r4));
        if (((Boolean) r33.getSecond()).booleanValue() == false) goto L112;
        this.curCheckNextPageCount = r31;
    L112:
        return r33;
    L106:
        if (r5 < (r6 - r31)) goto L108;
    L83:
        if (r28.intValue() <= 0) goto L85;
        boolean r34 = true;
    L86:
        if (r34 == false) goto L88;
        r3 = r28;
    L88:
        if (r3 == null) goto L99;
        int r35 = r3.intValue();
        Boolean r36 = Boolean.TRUE;
        if (r5 > 0) goto L92;
    L94:
        r4 = false;
    L95:
        Pair<Boolean, Boolean> r37 = new Pair(r36, Boolean.valueOf(r4));
        if (((Boolean) r37.getSecond()).booleanValue() == false) goto L98;
        this.curCheckNextPageCount = r35;
    L98:
        return r37;
    L92:
        if (r5 < (r6 - r35)) goto L94;
    L85:
        r34 = false;
        goto L86
    }

    public Boolean shouldExecuteLoadMore(RecyclerView r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        RecyclerView.Adapter r7 = r3.getAdapter();
        if (r7 == null) goto L5;
        int r0 = r7.getItemCount() - 1;
        int r8 = r7.getItemViewType(r7.getItemCount() - 1);
        ECHybridListItemType.a r1 = ECHybridListItemType.Companion;
        Integer r9 = Integer.valueOf(r8);
        r1.getClass();
        if (ECHybridListItemType.a.b(r9) == true) goto L9;
        ListEngineOptConfig r10 = this.listEngineOpt;
        if (r10 == null) goto L19;
        Integer r11 = r10.j;
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
        if (r12 <= 0) goto L19;
        if (r0 > r12) goto L19;
        return Boolean.TRUE;
    L19:
        Pair<Boolean, Boolean> r13 = checkLoadMoreFromNewSetting(r4, r0, r5, r6);
        if (((Boolean) r13.getFirst()).booleanValue() == true) goto L22;
        return null;
    L22:
        return (Boolean) r13.getSecond();
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }
}
