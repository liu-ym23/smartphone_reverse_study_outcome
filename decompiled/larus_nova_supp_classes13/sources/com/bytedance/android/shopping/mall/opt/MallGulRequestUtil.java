package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.pitaya.api.PTYMessageHandler;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0012R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/MallGulRequestUtil;", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "", "addPyListener", "", "pageName", "Lcom/bytedance/android/shopping/mall/opt/d;", "data", "onPyCallback", "Lorg/json/JSONObject;", "message", "onMessage", "sceneId", "Lcom/bytedance/android/shopping/mall/opt/e;", "listener", "registerListener", "sceneID", "unRegisterListener", "Lcom/bytedance/android/shopping/mall/opt/c;", "exposureEvent", "", "Ljava/util/Map;", "sceneIdMapName", "", "isAddPyListener", "Z", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallGulRequestUtil implements PTYMessageHandler {
    public static final MallGulRequestUtil INSTANCE = null;
    private static volatile boolean isAddPyListener;
    private static final Map<String, e> listener = null;
    private static final Map<String, String> sceneIdMapName = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = HybridAppInfoService.p.getAppId();     // Catch: Throwable -> L7
            if (r0 == null) goto L10;
            Lazy r1 = ECMallLogUtil.a;     // Catch: Throwable -> L7
            ECMallLogUtil.c(r.b.b, "start register pitaya");     // Catch: Throwable -> L7
            PitayaCoreFactory.getCore(r0).registerMessageHandler("ecom_gyl_refresh", MallGulRequestUtil.INSTANCE);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    private MallGulRequestUtil() {
    }

    static {
        INSTANCE = new MallGulRequestUtil();
        listener = new LinkedHashMap();
        sceneIdMapName = new LinkedHashMap();
    }

    private final void addPyListener() {
        com.bytedance.android.ec.hybrid.a.d().submit(a.a);
    }

    public final void exposureEvent(c r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(r.b.b, "exposure event notice to pitaya ");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        AppLogNewUtils.onEventV3("homepage_ecom_resume", tv5.a.a(p.b(), r3));     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public JSONObject onMessage(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(r.b.b, "on message from pitaya is " + r8);
        int r1 = r8.optInt("code");
        String r2 = r8.optString("type");
        if (r1 == 0) goto L5;
        return null;
    L5:
        if (r2 == null) goto L56;
        int r3 = r2.hashCode();
        if (r3 == (-1193578154)) goto L30;
        if (r3 != 1085444827) goto L56;
        if (r2.equals(ErrorPageButtonAction.REFRESH) == false) goto L56;
        JSONObject r9 = r8.optJSONObject("data");
        if (r9 == null) goto L17;
        Integer r4 = Integer.valueOf(r9.optInt("hit_rule"));
    L18:
        if (r9 == null) goto L20;
        String r5 = r9.optString(PdpOpenThirdParam.KEY_PAGE_NAME);
    L21:
        if (r4 == null) goto L56;
        if (r5 == null) goto L56;
        d r6 = new d(r4.intValue(), false, 2);
        String r7 = sceneIdMapName.get(r5);
        if (r7 == null) goto L28;
        e r10 = listener.get(r7);
        if (r10 == null) goto L28;
        r10.a(r6, r9, null);
    L28:
        INSTANCE.onPyCallback(r5, r6);
        goto L56
    L20:
        r5 = null;
        goto L21
    L17:
        r4 = null;
        goto L18
    L30:
        if (r2.equals("gyl_refresh") == false) goto L56;
        JSONObject r11 = r8.optJSONObject("data");
        if (r11 == null) goto L34;
        String r12 = r11.optString(PdpOpenThirdParam.KEY_PAGE_NAME);
    L35:
        JSONObject r13 = r8.optJSONObject("pitaya_refresh_reason");
        if (r12 != null) goto L38;
        String r14 = "";
    L39:
        g r15 = new g("pitaya", r14);
        r15.b(r13);
        if (r12 != null) goto L42;
    L55:
        r15.a(false, 1, 1002);
        goto L56
    L42:
        if (r12.length() <= 0) goto L44;
        boolean r16 = true;
    L45:
        if (r16 == true) goto L48;
        r12 = null;
    L48:
        if (r12 == null) goto L55;
        d r17 = new d(0, true, 1);
        String r18 = sceneIdMapName.get(r12);
        if (r18 == null) goto L55;
        e r19 = listener.get(r18);
        if (r19 == null) goto L54;
        r19.a(r17, r11, r15);
    L54:
        return null;
    L44:
        r16 = false;
        goto L45
    L38:
        r14 = r12;
        goto L39
    L34:
        r12 = null;
    L56:
        return null;
    }

    public final void unRegisterListener(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneID");
        listener.remove(r2);
    }

    private final void onPyCallback(String r4, d r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
        r1.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r4);     // Catch: Throwable -> L4
        r1.putOpt("hit_rule", Integer.valueOf(r5.a));     // Catch: Throwable -> L4
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3("homepage_ecom_refresh", r1);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void registerListener(String r2, String r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        Intrinsics.checkNotNullParameter(r3, "sceneId");
        Intrinsics.checkNotNullParameter(r4, "listener");
        sceneIdMapName.put(r2, r3);
        listener.put(r3, r4);
        if (isAddPyListener == true) goto L6;
        addPyListener();
        isAddPyListener = true;
        return;
    }
}
