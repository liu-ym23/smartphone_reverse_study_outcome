package com.bytedance.ee.bear.share;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static String a;
    public static String b;
    public static boolean c;
    public static String d;
    public static String e;

    static {
        a = "";
        b = "";
        d = "none";
        e = "none";
    }

    public static void a(JSONObject r6, a r7) {
        String r0 = sbb.e.c(r7.b);
        r6.put("file_id", du5.b.g(r7.a));
        r6.put("file_type", r0);
        r6.put("app_form", r7.c);
        String r3 = "none";
        boolean r4 = false;
        if (r7.b != sbb.e.l.b) goto L16;
        String r1 = r7.d;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        String r5 = "none";
    L14:
        r6.put("sub_file_type", r5);
        goto L16
    L13:
        r5 = r7.d;
        goto L14
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
    L16:
        if (r7.k == false) goto L18;
        r0 = sbb.e.n.getType();
    L29:
        r6.put("module", r0);
        String r8 = r7.f;
        if (r8 != null) goto L32;
    L33:
        r4 = true;
    L34:
        if (r4 == true) goto L37;
        r3 = r7.f;
    L37:
        r6.put("sub_module", r3);
        if (r7.b != sbb.e.f.b) goto L40;
        r6.put("user_permission_folder", r7.g);
        r6.put("folder_permission", r7.h);
    L41:
        r6.put("container_id", r7.i);
        r6.put("container_type", r7.j);
        return;
    L40:
        r6.put("user_permission", r7.g);
        r6.put("file_permission", r7.h);
        goto L41
    L32:
        if (r8.length() != 0) goto L34;
    L18:
        String r9 = d;
        if (r9 != null) goto L21;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L29;
        r0 = d;
        goto L29
    L21:
        if (r9.length() <= 0) goto L23;
        boolean r11 = true;
    L24:
        if (r11 != true) goto L26;
        r10 = true;
        goto L27
    L23:
        r11 = false;
        goto L24
    }

    public static void b(String r5, JSONObject r6) {
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).i(r5, r6);     // Catch: Throwable -> L5
        tt5.a.b("ShareAnalyticV2", "eventName:" + r5 + ", params : " + r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareAnalyticV2", "doReport()...failed", th, false);
    }

    public static void f(String r12, String r13, c r14) {
        JSONObject r0 = new JSONObject();
        String r2 = r14.a;
        int r3 = r14.getType();
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, new a(r2, r3, r1, r14.c, d, e, a, b, r14.d));
        r0.put("click", r12);
        r0.put("target", r13);
        b("ccm_permission_share_click", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void c(String r1, int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "subType");
        f("copy_link", "ccm_permission_copy_link_view", new c(r1, r2, r3, r4));
    }

    @JvmStatic
    public static final void e(String r1, int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "subType");
        f("image_share", "none", new c(r1, r2, r3, r4));
    }

    public static void d(String r13, int r14, String r15, boolean r16, String r17) {
        JSONObject r0 = new JSONObject();
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, new a(r13, r14, r4, r15, d, e, a, b, r16));
        r0.put("click", r17);
        r0.put("target", "none");
        b("ccm_permission_copy_link_click", r0);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void g(String r13, int r14, String r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r15, "subType");
        JSONObject r0 = new JSONObject();
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, new a(r13, r14, r4, r15, d, e, a, b, r16));
        if (r17 == false) goto L9;
        String r1 = "share";
    L10:
        r0.put("click", r1);
        r0.put("target", "none");
        b("ccm_permission_share_wechat_click", r0);
        return;
    L9:
        r1 = DocFeed$Value$Result.CANCEL;
        goto L10
    L5:
        r4 = "none";
        goto L6
    }

    public static void h(String r12, String r13, int r14, String r15, boolean r16) {
        JSONObject r0 = new JSONObject();
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, new a(r13, r14, r1, r15, d, e, a, b, r16));
        b(r12, r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }
}
