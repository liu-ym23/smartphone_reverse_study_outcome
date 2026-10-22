package com.ss.android.ugc.aweme.search.mob.base;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.search.common.ab.ECSearchExperiment;
import com.ss.android.ugc.aweme.search.common.base.BaseMetricsEvent;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchSchemaMonitorEvent;", "Lcom/ss/android/ugc/aweme/search/common/base/BaseMetricsEvent;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSearchSchemaMonitorEvent extends BaseMetricsEvent<BaseSearchSchemaMonitorEvent> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SearchSchemaEvent f453323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f453324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f453325e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchSchemaMonitorEvent$Companion;", "", "", "EVENT_OPEN", "Ljava/lang/String;", "EVENT_PARSE", "KEY_APP_USE_TIME", "KEY_CONTEXT_WAY", "KEY_CUR_CLASS_NAME", "KEY_DURATION", "KEY_END_TIME", "KEY_ENTER_MALL_TIME", "KEY_IS_BACKGROUND", "KEY_IS_COLD_BOT", "KEY_IS_IN_MALL", "KEY_IS_IN_MALL_BOTTOM", "KEY_IS_IN_MALL_TOP", "KEY_IS_SAAS", "KEY_IS_SUCCESS", "KEY_MALL_COST", "KEY_REASON", "KEY_START_TIME", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final void e() {
        SearchSchemaEvent r100 = this.f453323c;
        if (r100 != null) goto L27;
    L25:
        d();
        return;
    L27:
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L23
        c("duration", String.valueOf(r101 - r100.f453327a));     // Catch: Exception -> L23
        if (ECSearchExperiment.g().a() == false) goto L25;
        c(ILoadStallMonitor.START_TIME, String.valueOf(r100.f453327a));     // Catch: Exception -> L23
        c("end_time", String.valueOf(r101));     // Catch: Exception -> L23
        c("app_use_time", String.valueOf(r101 - this.f453324d));     // Catch: Exception -> L23
        c("is_in_mall_top", "0");     // Catch: Exception -> L23
        c("is_in_mall_bottom", "0");     // Catch: Exception -> L23
        c("is_in_mall", "0");     // Catch: Exception -> L23
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Exception -> L23
        if (r102 == null) goto L13;
        ITradeSearchHostAppInfo r103 = r102.getITradeSearchHostAppInfo();     // Catch: Exception -> L23
        if (r103 == null) goto L13;
        boolean r104 = true;
        if (r103.isAppInBackground() != true) goto L13;
    L14:
        if (r104 == false) goto L16;
        String r105 = "1";
    L17:
        c(LocationMonitorConst.IS_BACKGROUND, r105);     // Catch: Exception -> L23
        c("is_cold_bot", "0");     // Catch: Exception -> L23
        c("enter_mall_time", String.valueOf(0));     // Catch: Exception -> L23
        c("mall_cost", String.valueOf(r101 - 0));     // Catch: Exception -> L23
        String r106 = this.f453325e;     // Catch: Exception -> L23
        if (r106 == null) goto L25;
        JSONObject r107 = new JSONObject(r106);     // Catch: Exception -> L21
        c("mall_cost_extra", String.valueOf(r101 - r107.optLong("mall_open_time")));     // Catch: Exception -> L21
        c("mall_lynx_cost_extra", String.valueOf(r101 - r107.optLong("mall_lynx_open_time")));     // Catch: Exception -> L21
        c("mall_schema_cost_extra", String.valueOf(r101 - r107.optLong("mall_schema_open_time")));     // Catch: Exception -> L21
        c("mall_is_loaded", String.valueOf(r107.optBoolean("mall_is_loaded")));     // Catch: Exception -> L21
    L21:
        Unit r108 = Unit.INSTANCE;     // Catch: Exception -> L23
        goto L25
    L16:
        r105 = "0";
    L13:
        r104 = false;
    L23:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saas_search_monitor_info");
        goto L25
    }

    public BaseSearchSchemaMonitorEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L7;
        ITradeSearchHostAppInfo r102 = r101.getITradeSearchHostAppInfo();
        if (r102 == null) goto L7;
        long r103 = r102.getAppLaunchTime();
    L8:
        this.f453324d = r103;
        return;
    L7:
        r103 = 0;
        goto L8
    }
}
