package com.larus.reach.api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.platform.api.q;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ns9.t;
import ns9.u;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\bH&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\bH&J,\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0017\u001a\u00020\bH&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/larus/reach/api/ReachService;", "", LocationMonitorConst.SUBMIT, "Lcom/larus/reach/api/ReachSubmitResult;", "request", "Lcom/larus/reach/api/ReachRequest;", "clickAction", "Lkotlin/Function0;", "", "refreshPendingReach", "isTopBannerBridgeEnabled", "", "pushScene", "", "isBottomBannerBridgeEnabled", "bannerSource", "isInappPushPullEnabled", "startNotifyReceiver", "reportClickResult", "click", "Lcom/larus/reach/api/ReachClickEvent;", "success", "failReason", "notifyInappPushPullReady", "notifyExternalDeeplink", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/larus/platform/api/ExternalRouteSession;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReachService {
    u a(t r100);

    void b(q r100);

    void c();

    boolean d(String r100);

    void e();

    u f(t r100, Function0<Unit> r101);

    boolean g();

    boolean h(String r100);
}
