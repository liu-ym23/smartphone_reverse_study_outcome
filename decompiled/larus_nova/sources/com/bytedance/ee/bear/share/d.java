package com.bytedance.ee.bear.share;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f237013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f237014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f237015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f237016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f237017e;

    static {
        f237013a = "";
        f237014b = "";
        f237016d = "none";
        f237017e = "none";
    }

    public static void a(JSONObject r100, a r101) {
        String r102 = sbb.e.c(r101.f236999b);
        r100.put("file_id", du5.b.g(r101.f236998a));
        r100.put("file_type", r102);
        r100.put("app_form", r101.f237000c);
        String r103 = "none";
        boolean r104 = false;
        if (r101.f236999b != sbb.e.f541301l.f541317b) goto L16;
        String r105 = r101.f237001d;
        if (r105 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == false) goto L13;
        String r107 = "none";
    L14:
        r100.put("sub_file_type", r107);
        goto L16
    L13:
        r107 = r101.f237001d;
        goto L14
    L7:
        if (r105.length() == 0) goto L10;
        r106 = false;
    L16:
        if (r101.f237008k == false) goto L18;
        r102 = sbb.e.f541303n.getType();
    L29:
        r100.put(EventConstant.Key.MODULE, r102);
        String r108 = r101.f237003f;
        if (r108 != null) goto L32;
    L33:
        r104 = true;
    L34:
        if (r104 == true) goto L37;
        r103 = r101.f237003f;
    L37:
        r100.put("sub_module", r103);
        if (r101.f236999b != sbb.e.f541295f.f541317b) goto L40;
        r100.put("user_permission_folder", r101.f237004g);
        r100.put("folder_permission", r101.f237005h);
    L41:
        r100.put("container_id", r101.f237006i);
        r100.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r101.f237007j);
        return;
    L40:
        r100.put("user_permission", r101.f237004g);
        r100.put("file_permission", r101.f237005h);
        goto L41
    L32:
        if (r108.length() != 0) goto L34;
    L18:
        String r109 = f237016d;
        if (r109 != null) goto L21;
    L26:
        boolean r110 = false;
    L27:
        if (r110 == false) goto L29;
        r102 = f237016d;
        goto L29
    L21:
        if (r109.length() <= 0) goto L23;
        boolean r111 = true;
    L24:
        if (r111 != true) goto L26;
        r110 = true;
        goto L27
    L23:
        r111 = false;
        goto L24
    }

    public static void b(String r100, JSONObject r101) {
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).i(r100, r101);     // Catch: Throwable -> L5
        tt5.a.b("ShareAnalyticV2", "eventName:" + r100 + ", params : " + r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareAnalyticV2", "doReport()...failed", th, false);
    }

    public static void f(String r110, String r111, c r112) {
        JSONObject r100 = new JSONObject();
        String r101 = r112.f237009a;
        int r102 = r112.getType();
        if (f237015c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, new a(r101, r102, r103, r112.f237011c, f237016d, f237017e, f237013a, f237014b, r112.f237012d));
        r100.put("click", r110);
        r100.put(PickerReporterConstants.KEY.TARGET, r111);
        b("ccm_permission_share_click", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void c(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "subType");
        f("copy_link", "ccm_permission_copy_link_view", new c(r100, r101, r102, r103));
    }

    @JvmStatic
    public static final void e(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "subType");
        f("image_share", "none", new c(r100, r101, r102, r103));
    }

    public static void d(String r110, int r111, String r112, boolean r113, String r114) {
        JSONObject r100 = new JSONObject();
        if (f237015c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, new a(r110, r111, r101, r112, f237016d, f237017e, f237013a, f237014b, r113));
        r100.put("click", r114);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        b("ccm_permission_copy_link_click", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void g(String r110, int r111, String r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "subType");
        JSONObject r100 = new JSONObject();
        if (f237015c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, new a(r110, r111, r101, r112, f237016d, f237017e, f237013a, f237014b, r113));
        if (r114 == false) goto L9;
        String r102 = "share";
    L10:
        r100.put("click", r102);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        b("ccm_permission_share_wechat_click", r100);
        return;
    L9:
        r102 = "cancel";
        goto L10
    L5:
        r101 = "none";
        goto L6
    }

    public static void h(String r110, String r111, int r112, String r113, boolean r114) {
        JSONObject r100 = new JSONObject();
        if (f237015c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, new a(r111, r112, r101, r113, f237016d, f237017e, f237013a, f237014b, r114));
        b(r110, r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }
}
