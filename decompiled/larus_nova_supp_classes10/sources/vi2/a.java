package vi2;

import android.content.Context;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.core.vmsdk.JsWorkerWrapper;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.network.monitor.ECMonitorPathWhiteList;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static ECMonitorPathWhiteList a;

    static {
    }

    @JvmStatic
    public static final void a(wi2.a<Object> r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "monitorData");
        Intrinsics.checkNotNullParameter(r12, "apiUrl");
        String r13 = UriProtector.parse(r12).getPath();
        String r0 = "";
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        Intrinsics.checkNotNullParameter(r13, "value");
        r11.e = r13;
        wi2.a.c r1 = r11.i;
        if (r1 != null) goto L8;
    L9:
        wi2.a.c r2 = r11.i;
        if (r2 != null) goto L12;
        r2 = new wi2.a.c(null, null, null);
    L12:
        r11.i = wi2.a.c.a(r2, r13);
    L13:
        Lazy r14 = ECSettingKeys.a;
        int r15 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r3 = Boolean.FALSE;
        boolean r4 = false;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L18
        jj4.b r6 = jj4.b.b;     // Catch: Throwable -> L18
        Object r16 = jj4.a.a("ec_live_enable_api_jsverify_helper", Boolean.class, r3, false);     // Catch: Throwable -> L18
        if (r16 != null) goto L24;
        Intrinsics.throwNpe();     // Catch: Throwable -> L18
    L24:
        String r7 = "-1";
        if (((Boolean) r16).booleanValue() == false) goto L79;
        Context r17 = ECAppInfoService.e.getApplicationContext();     // Catch: Exception -> L76
        if (r17 == null) goto L60;
        com.bytedance.android.ec.core.vmsdk.p r8 = com.bytedance.android.ec.core.vmsdk.p.e;     // Catch: Exception -> L76
        String r9 = VmSdkSetting.a().f();     // Catch: Exception -> L76
        if (r9 != null) goto L31;
        r9 = "";
    L31:
        JsWorkerWrapper r18 = r8.b(r17, new com.bytedance.android.ec.core.vmsdk.b(r9, "ecom_live_api_monitor", false, 508));     // Catch: Exception -> L76
        if (r18 == null) goto L60;
        String[] r10 = new String[5];     // Catch: Exception -> L76
        wi2.a.c r19 = r11.i;     // Catch: Exception -> L76
        if (r19 == null) goto L36;
        String r20 = com.bytedance.android.shopping.extensions.k.x(r19);     // Catch: Exception -> L76
    L37:
        if (r20 != null) goto L39;
        r20 = "";
    L39:
        r10[0] = r20;     // Catch: Exception -> L76
        wi2.a.d r21 = r11.j;     // Catch: Exception -> L76
        if (r21 == null) goto L42;
        String r22 = com.bytedance.android.shopping.extensions.k.x(r21);     // Catch: Exception -> L76
    L43:
        if (r22 != null) goto L45;
        r22 = "";
    L45:
        r10[1] = r22;     // Catch: Exception -> L76
        r10[2] = String.valueOf(r11.d);     // Catch: Exception -> L76
        wi2.a.C0184a r23 = r11.k;     // Catch: Exception -> L76
        if (r23 == null) goto L48;
        String r24 = com.bytedance.android.shopping.extensions.k.x(r23);     // Catch: Exception -> L76
    L49:
        if (r24 != null) goto L51;
        r24 = "";
    L51:
        r10[3] = r24;     // Catch: Exception -> L76
        wi2.a.b r25 = r11.l;     // Catch: Exception -> L76
        if (r25 == null) goto L54;
        String r26 = com.bytedance.android.shopping.extensions.k.x(r25);     // Catch: Exception -> L76
    L55:
        if (r26 == null) goto L58;
        r0 = r26;
    L58:
        r10[4] = r0;     // Catch: Exception -> L76
        r18.b("app.monitor", r10);     // Catch: Exception -> L76
        goto L60
    L54:
        r26 = null;
        goto L55
    L48:
        r24 = null;
        goto L49
    L42:
        r22 = null;
        goto L43
    L36:
        r20 = null;
    L60:
        if (r11.d == 0) goto L62;
    L64:
        if (r4 == true) goto L70;
        xh.a r110 = xh.c.a("Live");     // Catch: Exception -> L76
        xh.b.b r27 = new xh.b.b();     // Catch: Exception -> L76
        r27.c(r11.e);     // Catch: Exception -> L76
        r27.d(Integer.valueOf(r11.c));     // Catch: Exception -> L76
        r27.e(r11.g);     // Catch: Exception -> L76
        r27.a(Integer.valueOf(r11.d));     // Catch: Exception -> L76
        String r111 = r11.h;     // Catch: Exception -> L76
        if (r111 == null) goto L69;
        r7 = r111;
    L69:
        r27.b(r7);     // Catch: Exception -> L76
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L76
        r110.b(null, r27);     // Catch: Exception -> L76
        return;
    L70:
        xh.a r113 = xh.c.a("Live");     // Catch: Exception -> L76
        xh.b.c r28 = new xh.b.c();     // Catch: Exception -> L76
        r28.b(r11.e);     // Catch: Exception -> L76
        r28.c(Integer.valueOf(r11.c));     // Catch: Exception -> L76
        r28.d(r11.g);     // Catch: Exception -> L76
        String r114 = r11.h;     // Catch: Exception -> L76
        if (r114 == null) goto L74;
        r7 = r114;
    L74:
        r28.a(r7);     // Catch: Exception -> L76
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L76
        r113.c(null, r28);     // Catch: Exception -> L76
        return;
    L62:
        if (r11.c != 0) goto L64;
        r4 = true;
    L76:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L79:
        if (EComABUtils.enableCommonNetworkReport() == true) goto L82;
        return;
    L82:
        if (a != null) goto L87;
        int r29 = w0.a;
        ECMonitorPathWhiteList r30 = (ECMonitorPathWhiteList) w0.b(EComABUtils.enableCommonNetworkReportPaths(), ECMonitorPathWhiteList.class);
        if (r30 != null) goto L86;
        r30 = new ECMonitorPathWhiteList();
    L86:
        a = r30;
    L87:
        ECMonitorPathWhiteList r31 = a;
        if (r31 == null) goto L94;
        List<String> r32 = r31.getPaths();
        if (r32 == null) goto L94;
        if ((!r32.isEmpty()) == false) goto L94;
    L95:
        if (r32 != null) goto L97;
    L128:
        JSONObject r33 = new JSONObject();     // Catch: Exception -> L123
        r33.put("http_code", r11.b);     // Catch: Exception -> L123
        r33.put("status_code", r11.c);     // Catch: Exception -> L123
        r33.put("path", r11.e);     // Catch: Exception -> L123
        r33.put(LocationMonitorConst.ERROR_CODE, r11.d);     // Catch: Exception -> L123
        String r34 = r11.h;     // Catch: Exception -> L123
        if (r34 != null) goto L102;
        r34 = "-1";
    L102:
        r33.put("log_id", r34);     // Catch: Exception -> L123
        String r35 = (String) ((HashMap) r11.m).get("request_scene");     // Catch: Exception -> L123
        if (r35 == null) goto L106;
        r0 = r35;
    L106:
        r33.put("request_scene", r0);     // Catch: Exception -> L123
        JSONObject r116 = new JSONObject().put("duration", r11.f);     // Catch: Exception -> L123
        int r36 = ECMonitorService.b;     // Catch: Exception -> L123
        ECMonitorService.a.a("ec_live_common_network", r33, r116, null);     // Catch: Exception -> L123
        if (r11.d == 0) goto L109;
    L111:
        if (r4 == true) goto L117;
        xh.a r117 = xh.c.a("Live");     // Catch: Exception -> L123
        xh.b.b r37 = new xh.b.b();     // Catch: Exception -> L123
        r37.c(r11.e);     // Catch: Exception -> L123
        r37.d(Integer.valueOf(r11.c));     // Catch: Exception -> L123
        r37.e(r11.g);     // Catch: Exception -> L123
        r37.a(Integer.valueOf(r11.d));     // Catch: Exception -> L123
        String r118 = r11.h;     // Catch: Exception -> L123
        if (r118 == null) goto L116;
        r7 = r118;
    L116:
        r37.b(r7);     // Catch: Exception -> L123
        Unit r119 = Unit.INSTANCE;     // Catch: Exception -> L123
        r117.b(null, r37);     // Catch: Exception -> L123
        return;
    L117:
        xh.a r120 = xh.c.a("Live");     // Catch: Exception -> L123
        xh.b.c r38 = new xh.b.c();     // Catch: Exception -> L123
        r38.b(r11.e);     // Catch: Exception -> L123
        r38.c(Integer.valueOf(r11.c));     // Catch: Exception -> L123
        r38.d(r11.g);     // Catch: Exception -> L123
        String r121 = r11.h;     // Catch: Exception -> L123
        if (r121 == null) goto L121;
        r7 = r121;
    L121:
        r38.a(r7);     // Catch: Exception -> L123
        Unit r122 = Unit.INSTANCE;     // Catch: Exception -> L123
        r120.c(null, r38);     // Catch: Exception -> L123
        return;
    L109:
        if (r11.c != 0) goto L111;
        r4 = true;
    L123:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L97:
        if (r32.contains(r11.e) == true) goto L128;
        return;
    L94:
        r32 = null;
    L18:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r123 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r123) == true) goto L23;
        r3 = r123;
    L23:
        r16 = r3;
        goto L24
    L8:
        if (r1.b() != null) goto L13;
        goto L9
    }
}
