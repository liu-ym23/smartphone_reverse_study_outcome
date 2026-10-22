package ij7;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ug.sdk.luckycat.impl.browser.webview.PageInfo;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.model.ContainerType;
import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import com.bytedance.ug.sdk.luckycat.impl.model.PluginState;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.bytedance.ug.sdk.luckycat.utils.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class i implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f490106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PageInfo f490107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f490108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ContainerType f490109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f490110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ug.sdk.luckycat.impl.lynx.c f490111g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f490112a;

        public final void a() {
            if (TextUtils.isEmpty(this.f490112a.f490107c.f271128l) == false) goto L13;
            i r100 = this.f490112a;
            PageInfo r101 = r100.f490107c;
            Set<String> r102 = to7.a.f546943k;
            if (to7.a.d.f546961a.f546946c == true) goto L8;
            String r103 = "background";
        L11:
            r101.f271128l = r103;
            return;
        L8:
            if (r100.f490108d == true) goto L10;
            r103 = "open_new_page";
            goto L11
        L10:
            r103 = "tab_change";
            goto L11
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

        public a(i r100) {
            this.f490112a = r100;
        }
    }

    @Override // com.bytedance.ug.sdk.luckycat.utils.j.a
    public final void handleMsg(Message r100) {
    }

    public final void f() {
        PageInfo r100 = this.f490107c;
        if (r100 == null) goto L32;
        r100.f271124h = false;
        if (r100.f271126j == false) goto L7;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("PageInfo", "onPageOut return");
    L26:
        if (TextUtils.isEmpty(this.f490107c.f271128l) == false) goto L33;
        this.f490106b.post(new a(this));
        return;
    L33:
        return;
    L7:
        r100.f271126j = true;
        long r101 = System.currentTimeMillis();
        long r102 = r100.f271122f;
        if (r102 == (-1)) goto L26;
        r100.f271127k = r101 - r102;
        com.bytedance.ug.sdk.luckycat.api.depend.d r103 = m.a.f271349a.f271337e;
        if (r103 == null) goto L15;
        bn7.a r104 = ((cn7.a) r103).f24554b;
        if (r104 == null) goto L15;
        JSONObject r105 = r104.c();
    L16:
        r100.f271129m = r105;
        if (r105 == null) goto L26;
        PageInfo.PAGE_LOAD_STATUS r106 = r100.F;     // Catch: Throwable -> L24
        if (r106 == null) goto L22;
        r105.put("cur_page_load_status", PageInfo.PAGE_LOAD_STATUS.access$000(r106));     // Catch: Throwable -> L24
    L29:
        goto L26
    L22:
        r105.put("cur_page_load_status", PageInfo.PAGE_LOAD_STATUS.access$000(PageInfo.PAGE_LOAD_STATUS.UNKNOWN));     // Catch: Throwable -> L24
    L15:
        r105 = null;
        goto L16
    }

    public final void g() {
        PageInfo r100 = this.f490107c;
        if (r100 == null) goto L6;
        r100.f271124h = true;
        return;
    }

    public final void j() {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_insert_window_;key:all;result:success;common_params:" + e(this.f490107c));
        e(this.f490107c);
        JSONObject r100 = new JSONObject();
        r100.put("key", "all").put("result", "success");     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_insert_window", r100, true);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void k() {
        PageInfo r100 = this.f490107c;
        if (r100 == null) goto L5;
        r100.f271123g = System.currentTimeMillis();
    L5:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_loading_show;common_params:" + e(this.f490107c));
        JSONObject r101 = new JSONObject(e(this.f490107c).toString());     // Catch: JSONException -> L8
    L10:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_loading_show", r101, true);
        PageInfo r102 = this.f490107c;
        if (r102 == null) goto L16;
        r102.f271132p = "show_loading";
        return;
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L10
    }

    public i(com.bytedance.ug.sdk.luckycat.impl.lynx.c r100) {
        this.f490106b = new j(Looper.getMainLooper(), this);
        this.f490110f = false;
        this.f490111g = r100;
        this.f490105a = r100.getContainerID();
    }

    public final void a(JSONObject r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "container_create_duration");
        JSONObject r101 = new JSONObject(e(this.f490107c).toString());     // Catch: Throwable -> L13
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();     // Catch: Throwable -> L11
        if (r100.has(r103) == false) goto L6;
        r101.put(r103, r100.get(r103));     // Catch: Throwable -> L11
    L16:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_container_created_duration", r101, true);
        return;
    L11:
        th = th;
    L15:
        th.printStackTrace();
    L13:
        th = th;
        r101 = null;
        goto L15
    }

    public final void b(String r110) {
        long r100 = System.currentTimeMillis() - this.f490107c.f271123g;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_loading_dismiss;dimiss_reason:" + r110 + ";duration:" + r100 + ";common_params:" + e(this.f490107c));
        JSONObject r111 = null;
        JSONObject r112 = new JSONObject(e(this.f490107c).toString());     // Catch: JSONException -> L8
        r112.put("dismiss_reason", r110);     // Catch: JSONException -> L6
        r112.put("duration", r100);     // Catch: JSONException -> L6
    L11:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_loading_dismiss", r112, true);
        if (this.f490107c.f271123g <= 0) goto L22;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_loading_duration_;dimiss_reason:" + r110 + ";duration:" + r100 + ";common_params:" + e(this.f490107c));
        JSONObject r101 = new JSONObject(e(this.f490107c).toString());     // Catch: JSONException -> L19
        r101.put("duration", r100);     // Catch: JSONException -> L17
        r101.put("dismiss_reason", r110);     // Catch: JSONException -> L17
    L21:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_loading_duration", r101, true);
    L17:
        e = e;
        r111 = r101;
    L20:
        e.printStackTrace();
        r101 = r111;
    L19:
        e = e;
    L22:
        PageInfo r102 = this.f490107c;
        if (r102 == null) goto L34;
        r102.f271132p = "dissmiss_loading";
        return;
    L34:
        return;
    L6:
        e = e;
    L10:
        e.printStackTrace();
    L8:
        e = e;
        r112 = null;
        goto L10
    }

    public final void c(int r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_error_page_click_;common_params:" + e(this.f490107c));
        JSONObject r101 = new JSONObject(e(this.f490107c).toString());     // Catch: JSONException -> L8
        r101.put("error_code", r100);     // Catch: JSONException -> L6
    L11:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_error_page_click", r101, true);
        return;
    L6:
        e = e;
    L10:
        e.printStackTrace();
    L8:
        e = e;
        r101 = null;
        goto L10
    }

    public final JSONObject e(PageInfo r100) {
        if (r100 == null) goto L5;
        JSONObject r101 = new JSONObject();
        String r102 = "unknow";
        ContainerType r103 = r100.f271125i;     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        ContainerType r104 = ContainerType.H5;     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (r103 != r104) goto L11;
        r102 = "h5";
    L16:
        r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r102);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        String r105 = "normal";
        JSONObject r106 = null;
        if (r100.f271125i != ContainerType.LYNX) goto L26;
        m r107 = m.a.f271349a;     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (r107.s() == true) goto L26;
        com.bytedance.ug.sdk.luckycat.api.depend.h r108 = r107.f271343k;     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (r108 == null) goto L23;
        PluginState r109 = r108.c();     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
    L24:
        if (r109 == null) goto L26;
        r105 = "plugin_" + r109.status;     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        goto L26
    L23:
        r109 = null;
    L26:
        int r110 = 0;
        if (r100.f271125i == r104) goto L29;
    L33:
        r101.put("container_status", r105);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (r100.f271124h == false) goto L36;
        int r111 = 1;
    L37:
        r101.put("page_visible", r111);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (r100.f271126j == false) goto L40;
        int r112 = 1;
    L41:
        r101.put("page_out", r112);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        r101.put("page_load_type", r100.f271130n);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        r101.put("pre_step", r100.f271132p);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        r101.put("container_id", this.f490105a);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        PageLoadReason r113 = r100.f271119c;     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (r113 == null) goto L45;
        r101.put("reason", r113.reason);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
    L45:
        if (com.bytedance.ug.sdk.luckycat.utils.i.f(r100.f271117a) == false) goto L47;
        URL r114 = new URL(r100.f271117a);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        r101.put("host", r114.getHost());     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        r101.put("path", r114.getPath());     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
    L47:
        r101.put("url", r100.f271117a);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        if (TextUtils.isEmpty(r100.f271118b) == true) goto L51;
        r101.put("replaced_url", r100.f271118b);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
    L51:
        if (r100.f271131o == false) goto L53;
        int r115 = 1;
    L54:
        r101.put("loading_status", r115);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        com.bytedance.ug.sdk.luckycat.api.depend.d r116 = m.a.f271349a.f271337e;     // Catch: Throwable -> L73
        if (r116 == null) goto L60;
        bn7.a r117 = ((cn7.a) r116).f24554b;     // Catch: Throwable -> L73
        if (r117 == null) goto L60;
        r106 = r117.c();     // Catch: Throwable -> L73
    L60:
        if (r106 == null) goto L64;
        r101.put("app_status", r106);     // Catch: Throwable -> L73
    L64:
        if (r100.f271133q == false) goto L66;
        r110 = 1;
    L66:
        r101.put("is_recovered_page", r110);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        goto L72
    L53:
        r115 = 0;
        goto L54
    L40:
        r112 = 0;
        goto L41
    L36:
        r111 = 0;
        goto L37
    L29:
        if (r100.f271121e == false) goto L31;
        int r118 = 1;
    L32:
        r101.put("pia_enable", r118);     // Catch: MalformedURLException -> L68 JSONException -> L70 Throwable -> L74
        goto L33
    L31:
        r118 = 0;
        goto L32
    L11:
        if (r103 != ContainerType.LYNX) goto L14;
        r102 = "lynx";
        goto L16
    L14:
        if (r103 != ContainerType.LYNX_POPUP) goto L16;
        r102 = "lynx_popup";
    L68:
        e = move-exception;
        e.printStackTrace();
    L70:
        e = move-exception;
        e.printStackTrace();
    L72:
        return r101;
    L5:
        return new JSONObject();
    }

    public i(String r100) {
        this.f490106b = new j(Looper.getMainLooper(), this);
        this.f490110f = false;
        this.f490105a = r100;
    }

    public final void d(int r100, String r101) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_error_page_show_;common_params:" + e(this.f490107c));
        PageInfo r102 = this.f490107c;
        JSONObject r103 = new JSONObject(e(r102).toString());     // Catch: JSONException -> L12
        r103.put("error_code", r100);     // Catch: JSONException -> L10
        r103.put("error_msg", r101);     // Catch: JSONException -> L10
        if (r102 == null) goto L15;
        PageInfo.PAGE_LOAD_STATUS r104 = r102.F;     // Catch: JSONException -> L10
        if (r104 == null) goto L15;
        r103.put("page_load_status", r104.getValue());     // Catch: JSONException -> L10
    L15:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_error_page_show", r103, true);
        h(false, r100, r101);
        return;
    L10:
        e = e;
    L14:
        e.printStackTrace();
    L12:
        e = e;
        r103 = null;
        goto L14
    }

    public final void i(String r100, PageLoadReason r101) {
        PageInfo r102 = this.f490107c;
        JSONObject r103 = null;
        if (r102 != null) goto L5;
    L17:
        PageInfo r104 = this.f490107c;
        PageInfo r105 = new PageInfo();
        this.f490107c = r105;
        r105.f271119c = r101;
        r105.f271117a = r100;
        r105.f271122f = System.currentTimeMillis();
        PageInfo r106 = this.f490107c;
        r106.f271126j = false;
        r106.f271131o = true;
        if (this.f490108d == true) goto L21;
        String r107 = "new_page";
    L24:
        r106.f271130n = r107;
        this.f490107c.f271125i = this.f490109e;
        if (r104 == null) goto L31;
        if (TextUtils.isEmpty(r104.f271132p) == true) goto L29;
        this.f490107c.f271132p = r104.f271132p;
    L29:
        this.f490107c.f271121e = r104.f271121e;
    L31:
        if (this.f490110f == false) goto L33;
        this.f490107c.f271133q = true;
    L33:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_load_start_;common_params:" + e(this.f490107c));
        r103 = new JSONObject(e(this.f490107c).toString());     // Catch: JSONException -> L36
    L38:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_load_start", r103, true);
        PageInfo r108 = this.f490107c;
        if (r108 == null) goto L48;
        r108.f271132p = "page_load_start";
        return;
    L48:
        return;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L21:
        if (u.a().d("first_load_task_tab", Boolean.TRUE) == false) goto L23;
        u.a().h("first_load_task_tab", false);
        r107 = "tab_first";
        goto L24
    L23:
        r107 = "tab";
        goto L24
    L5:
        if (r102.f271131o == false) goto L17;
        JSONObject r109 = e(r102);
        r109.put("error_load_reason", r101.reason);     // Catch: JSONException -> L9
    L11:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_load_error_start;common_params:" + r109);
        JSONObject r110 = new JSONObject(r109.toString());     // Catch: JSONException -> L14
    L16:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_load_error_start", r110, true);
    L14:
        e = move-exception;
        e.printStackTrace();
        r110 = null;
    L9:
        e = move-exception;
        e.getMessage();
        goto L11
    }

    public void h(boolean r210, int r211, String r212) {
        String r100 = "fail";
        PageInfo r101 = this.f490107c;
        if (r101 == null) goto L19;
        if (r210 == false) goto L7;
        r101.F = PageInfo.PAGE_LOAD_STATUS.PAGE_LOAD_END;
    L7:
        if (r101.f271140x == (-1)) goto L9;
        r101.E = true;
        goto L19
    L9:
        long r110 = System.currentTimeMillis();
        r101.f271140x = r110;
        long r111 = r101.f271122f;
        if (r111 != (-1)) goto L12;
        r101.E = true;
        goto L19
    L12:
        r101.f271142z = r110 - r111;
        if (r210 == false) goto L19;
        long r112 = r101.f271138v;
        if (r112 != (-1)) goto L18;
        r101.E = true;
        goto L19
    L18:
        r101.A = r110 - r112;
    L19:
        long r113 = System.currentTimeMillis() - this.f490107c.f271122f;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_load_end_;isSuccess:" + r210 + ";errorCode:" + r211 + ";duration:" + r113 + ";common_params:" + e(this.f490107c));
        JSONObject r114 = new JSONObject(e(this.f490107c).toString());     // Catch: JSONException -> L28
        if (r210 == false) goto L23;
        Object r102 = "succ";
    L86:
        r114.put("is_succ", r102);     // Catch: JSONException -> L26
        r114.put("error_code", r211);     // Catch: JSONException -> L26
        r114.put("error_msg", r212);     // Catch: JSONException -> L26
        r114.put("duration", r113);     // Catch: JSONException -> L26
    L31:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_load_end", r114, true);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_load_duration_;duration:" + r113 + ";common_params:" + e(this.f490107c));
        com.bytedance.ug.sdk.luckycat.impl.lynx.c r103 = this.f490111g;
        if (r103 == null) goto L36;
        vi7.c r104 = r103.Qw();
        if (r104 == null) goto L36;
        String r105 = this.f490107c.f271117a;     // Catch: Throwable -> L77
        r104.i();     // Catch: Throwable -> L77
    L36:
        JSONObject r106 = e(this.f490107c);
        PageInfo r107 = this.f490107c;
        JSONObject r115 = new JSONObject(r106.toString());     // Catch: JSONException -> L67
        if (r210 == false) goto L80;
        r100 = "succ";
    L80:
        r115.put("is_succ", r100);     // Catch: JSONException -> L65
        r115.put("error_code", r211);     // Catch: JSONException -> L65
        r115.put("error_msg", r212);     // Catch: JSONException -> L65
        r115.put("duration", r113);     // Catch: JSONException -> L65
        if (r107 != null) goto L43;
    L70:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_load_duration", r115, true);
        PageInfo r108 = this.f490107c;
        if (r108 == null) goto L90;
        if (r210 == false) goto L74;
        String r109 = "page_load_end_succ";
    L75:
        r108.f271132p = r109;
        r108.f271131o = false;
        return;
    L74:
        r109 = "page_load_end_fail";
        goto L75
    L90:
        return;
    L43:
        if (r210 == false) goto L50;
        r115.put("client_load_url_duration", r107.f271135s);     // Catch: JSONException -> L65
        r115.put("fe_load_url_duration", r107.A);     // Catch: JSONException -> L65
        r115.put("load_template_duration", r107.f271137u);     // Catch: JSONException -> L65
        r115.put("load_resource_duration", r107.f271139w);     // Catch: JSONException -> L65
        r115.put("pre_load_url_duration", r107.f271141y);     // Catch: JSONException -> L65
        long r116 = r107.B;     // Catch: JSONException -> L65
        if (r116 <= 0) goto L47;
        r115.put("fe_render_duration", r116);     // Catch: JSONException -> L65
    L47:
        long r117 = r107.D;     // Catch: JSONException -> L65
        if (r117 <= 0) goto L50;
        r115.put("lynx_load_duration", r117);     // Catch: JSONException -> L65
    L50:
        PageInfo.PAGE_LOAD_STATUS r118 = r107.F;     // Catch: JSONException -> L65
        if (r118 == null) goto L53;
        r115.put("page_load_status", r118.getValue());     // Catch: JSONException -> L65
    L53:
        r115.put("page_load_duration", r107.f271142z);     // Catch: JSONException -> L65
        r115.put("is_occur_error", r107.E);     // Catch: JSONException -> L65
        if (r107.f271126j == false) goto L78;
        JSONObject r119 = r107.f271129m;     // Catch: JSONException -> L65
        if (r119 == null) goto L58;
        r115.put("page_out_app_status", r119);     // Catch: JSONException -> L65
    L58:
        long r120 = r107.f271127k;     // Catch: JSONException -> L65
        if (r120 < 0) goto L61;
        r115.put("page_out_duration", r120);     // Catch: JSONException -> L65
    L61:
        r115.put("page_out_reason", r107.f271128l);     // Catch: JSONException -> L65
    L78:
        r115.put("template_from", "error_template_info_null");     // Catch: Throwable -> L64
        r115.put("template_size", -1);     // Catch: Throwable -> L64
    L65:
        e = e;
        JSONObject r121 = r115;
    L69:
        e.printStackTrace();
        r115 = r121;
    L67:
        e = e;
        r121 = null;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        goto L31
    L23:
        r102 = "fail";
    L28:
        e = e;
        r114 = null;
        goto L30
    }
}
