package af3;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.dialog.NativeDialogConfig;
import com.bytedance.android.shopping.api.mall.common.tools.i;
import com.bytedance.android.shopping.mall.homepage.component.ECMFPageCardComponent;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final d a;
    public final b b;
    public final NativeDialogConfig c;
    public final f d;
    public final String e;
    public final c f;
    public final a g;
    public final ck.a h;
    public final g i;

    public final void a() {
        this.b.a = System.currentTimeMillis();
        b(new String[]{"setup"});
    L66:
        f r1 = this.d;
        r1.a = 0;
        r1.b = "client error";
        return;
    L4:
        boolean r4 = true;
        if (this.h == null) goto L7;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        b(new String[]{"没有ready return"});     // Catch: Exception -> L66
        d r2 = this.a;     // Catch: Exception -> L66
        r2.getClass();     // Catch: Exception -> L66
        Intrinsics.checkNotNullParameter("popupManager_not_ready", "reason");     // Catch: Exception -> L66
        r2.a = false;     // Catch: Exception -> L66
        r2.b = "popupManager_not_ready";     // Catch: Exception -> L66
        r2.a();     // Catch: Exception -> L66
        f r5 = this.d;     // Catch: Exception -> L66
        r5.a = 0;     // Catch: Exception -> L66
        r5.b = "client error";     // Catch: Exception -> L66
        return;
    L11:
        a r6 = this.g;     // Catch: Exception -> L66
        if (r6.d == true) goto L70;
        b(new String[]{"数据无效 return"});     // Catch: Exception -> L66
        d r7 = this.a;     // Catch: Exception -> L66
        r7.getClass();     // Catch: Exception -> L66
        Intrinsics.checkNotNullParameter("api data error", "reason");     // Catch: Exception -> L66
        r7.a = false;     // Catch: Exception -> L66
        r7.b = "api data error";     // Catch: Exception -> L66
        r7.a();     // Catch: Exception -> L66
        f r8 = this.d;     // Catch: Exception -> L66
        r8.a = 0;     // Catch: Exception -> L66
        r8.b = "api data error";     // Catch: Exception -> L66
        return;
    L70:
        int r9 = JSONObjectProtectorUtils.getInt(r6.c, "native_open_ab");     // Catch: Exception -> L17
    L18:
        if (r9 == 1) goto L73;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == true) goto L28;
        b(new String[]{"没有命中实验 return"});     // Catch: Exception -> L66
        d r11 = this.a;     // Catch: Exception -> L66
        r11.getClass();     // Catch: Exception -> L66
        Intrinsics.checkNotNullParameter("not hit ab", "reason");     // Catch: Exception -> L66
        r11.a = false;     // Catch: Exception -> L66
        r11.b = "not hit ab";     // Catch: Exception -> L66
        r11.a();     // Catch: Exception -> L66
        f r12 = this.d;     // Catch: Exception -> L66
        r12.a = 0;     // Catch: Exception -> L66
        r12.b = "no hit AB";     // Catch: Exception -> L66
        return;
    L28:
        List<String> r13 = this.c.getEnablePageName();     // Catch: Exception -> L66
        if (r13 != null) goto L32;
        r13 = CollectionsKt.emptyList();     // Catch: Exception -> L66
    L32:
        if (r13.contains(this.i.a) == true) goto L34;
        b(new String[]{"没有命中配置的PageName return"});     // Catch: Exception -> L66
        f r14 = this.d;     // Catch: Exception -> L66
        r14.a = 0;     // Catch: Exception -> L66
        r14.b = "disable page name";     // Catch: Exception -> L66
        return;
    L34:
        List<String> r15 = this.c.getDisableComponent();     // Catch: Exception -> L66
        if (r15 != null) goto L38;
        r15 = CollectionsKt.emptyList();     // Catch: Exception -> L66
    L38:
        if ((!r15.contains(a.d(this.g.b, "component"))) == true) goto L40;
        b(new String[]{"component在黑名单里 return"});     // Catch: Exception -> L66
        f r16 = this.d;     // Catch: Exception -> L66
        r16.a = 0;     // Catch: Exception -> L66
        r16.b = "disable component";     // Catch: Exception -> L66
        return;
    L40:
        List<Integer> r17 = this.c.getDisablePlanId();     // Catch: Exception -> L66
        if (r17 != null) goto L68;
        r17 = CollectionsKt.emptyList();     // Catch: Exception -> L66
    L68:
        int r18 = JSONObjectProtectorUtils.getInt(this.g.b, "plan_id");     // Catch: Exception -> L46
    L48:
        if ((!r17.contains(Integer.valueOf(r18))) == true) goto L51;
        b(new String[]{"planId在黑名单里 return"});     // Catch: Exception -> L66
        f r19 = this.d;     // Catch: Exception -> L66
        r19.a = 0;     // Catch: Exception -> L66
        r19.b = "disable plan id";     // Catch: Exception -> L66
        return;
    L51:
        if (this.i.d == false) goto L54;
        b(new String[]{"引流场景 return"});     // Catch: Exception -> L66
        f r20 = this.d;     // Catch: Exception -> L66
        r20.a = -2;     // Catch: Exception -> L66
        r20.b = "guide scene";     // Catch: Exception -> L66
        return;
    L54:
        if (this.g.a().length() <= 0) goto L56;
        boolean r21 = true;
    L57:
        if (r21 == false) goto L59;
    L62:
        if (r4 == false) goto L64;
        b(new String[]{"只弹Toast return"});     // Catch: Exception -> L66
        c();     // Catch: Exception -> L66
        d r22 = this.a;     // Catch: Exception -> L66
        r22.a = false;     // Catch: Exception -> L66
        r22.b = "break_by_toast";     // Catch: Exception -> L66
        r22.a();     // Catch: Exception -> L66
        f r23 = this.d;     // Catch: Exception -> L66
        r23.a = -3;     // Catch: Exception -> L66
        r23.b = "toast scene";     // Catch: Exception -> L66
        return;
    L64:
        this.f.b();     // Catch: Exception -> L66
        b(new String[]{"当前页面不可见"});     // Catch: Exception -> L66
        d r24 = this.a;     // Catch: Exception -> L66
        r24.a = false;     // Catch: Exception -> L66
        r24.b = "break_by_native_jsb";     // Catch: Exception -> L66
        r24.a();     // Catch: Exception -> L66
        f r25 = this.d;     // Catch: Exception -> L66
        r25.a = -1;     // Catch: Exception -> L66
        r25.b = "page not visible";     // Catch: Exception -> L66
        return;
    L59:
        if (StringsKt.startsWith$default(a.d(this.g.b, "schema"), this.e, false, 2, null) == true) goto L62;
        r4 = false;
        goto L62
    L56:
        r21 = false;
    L46:
        r18 = 0;
        goto L48
    L73:
        int r26 = JSONObjectProtectorUtils.getInt(this.g.c, "popup_optimize_ab");     // Catch: Exception -> L22
    L23:
        if (r26 != 1) goto L25;
        r10 = true;
    L22:
        r26 = 0;
    L17:
        r9 = 0;
        goto L18
    L7:
        r3 = false;
        goto L9
    }

    public final void c() {
        boolean r4 = false;
        if (StringsKt.startsWith$default(a.d(this.g.b, "schema"), this.e, false, 2, null) == false) goto L9;
        JSONObject r0 = a.b(this.g.b, "view_config");
        if (r0 != null) goto L7;
        r0 = new JSONObject();
    L7:
        String r1 = a.d(r0, "message");
    L14:
        i.b.showToast(this.f.getContext(), r1);
        return;
    L9:
        if (this.g.a().length() <= 0) goto L11;
        r4 = true;
    L11:
        if (r4 == false) goto L13;
        r1 = this.g.a();
        goto L14
    L13:
        r1 = "";
        goto L14
    }

    public static void b(String... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Logger.e("NativeDialogController", r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public e(ECMFPageCardComponent.a r23, a r24, ck.a r25, g r26) {
        Intrinsics.checkNotNullParameter(r23, "mallAbility");
        Intrinsics.checkNotNullParameter(r24, "apiDataHelper");
        Intrinsics.checkNotNullParameter(r26, "queryMapHelper");
        this.f = r23;
        this.g = r24;
        this.h = r25;
        this.i = r26;
        this.a = new d(r23, r24, r26);
        this.b = new b(r23, r26, r24);
        int r1 = s93.c.a;
        Lazy r2 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L19;
        Object r3 = new NativeDialogConfig(null, null, null, null, null, null, null, 127, null);
    L9:
        IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();
        if (r4 == null) goto L17;
        yj.g r5 = r4.getHostAB();
        if (r5 == null) goto L17;
        Object r6 = r5.a("ecom_mall_native_dailog_config", r3);
        if (r6 == null) goto L17;
        r3 = r6;
    L17:
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ecom_mall_native_dailog_config, Value: " + r3);
        this.c = (NativeDialogConfig) r3;
        this.d = new f();
        this.e = "__ECOM_INTERNAL_NO_POPUP_BUT_TOAST_SCHEMA__";
        return;
    L19:
        r3 = (NativeDialogConfig) new Gson().fromJson("{\"enable_page_name\":[\"xtab_homepage\"],\"disable_component\":[\"redpack_rain_561124\"],\"disable_plan_id\":[],\"need_adaptive_parent_type\":true,\"default_task_config\":\"{\\\"group\\\":{\\\"name\\\":\\\"default\\\",\\\"strategy\\\":0},\\\"parent\\\":\\\"custom\\\",\\\"z_index\\\":0,\\\"priority\\\":0,\\\"must_show_on_visible\\\":true}\",\"default_popup_config\":\"{\\\"type\\\":1,\\\"width_percent\\\":100,\\\"height_percent\\\":100,\\\"enter_type\\\":\\\"center\\\",\\\"mask_intercept_event\\\":false,\\\"use_anim\\\":false,\\\"gray_enable\\\":false}\",\"append_schema_params\":\"&enable_animax=1&enable_canvas=true&enable_canvas_optimize=true&enable_dynamic_v8=true&disable_auto_expose=1\"}", NativeDialogConfig.class);     // Catch: Exception -> L7
    L7:
        r3 = new NativeDialogConfig(null, null, null, null, null, null, null, 127, null);
        goto L9
    }
}
