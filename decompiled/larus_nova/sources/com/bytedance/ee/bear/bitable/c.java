package com.bytedance.ee.bear.bitable;

import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f207079a = 0;

    static {
    }

    @JvmStatic
    public static final boolean A() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.selectoptions.multiple.lines");
    }

    @JvmStatic
    public static final boolean B() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.ui.use_base_design_tag");
    }

    public static boolean a() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.jsb.monitor.report");
    }

    @JvmStatic
    public static final boolean c() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.record.adapter.cell.leak");
    }

    @JvmStatic
    public static final String d() {
        StringBuilder r100 = new StringBuilder();
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.preload_memory_cache") == false) goto L6;
        b(r100);
        r100.append("ccm.bitable.preload_memory_cache");
    L6:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.early_netclientvars") == false) goto L9;
        b(r100);
        r100.append("ccm.bitable.early_netclientvars");
    L9:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.mobile.cache_annotation") == false) goto L12;
        b(r100);
        r100.append("base.mobile.cache_annotation");
    L12:
        if (t() == false) goto L15;
        b(r100);
        r100.append("shareRecordItemView");
    L15:
        if (q() == false) goto L18;
        b(r100);
        r100.append("addRecordItemView");
    L18:
        if (l() == false) goto L21;
        b(r100);
        int r101 = n.f214744a;
        r100.append("base.opt.add_record_cache_first_enable");
    L21:
        return r100.toString();
    }

    @JvmStatic
    public static final boolean e() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base_app_mobile_first_screen_preload_enable");
    }

    @JvmStatic
    public static final boolean f() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile.js_preload");
    }

    @JvmStatic
    public static final boolean g() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.base_in_docx_select_lynx_enable");
    }

    @JvmStatic
    public static final boolean h() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.big_screen_card_view_adaptation");
    }

    @JvmStatic
    public static final boolean i() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.big_screen_panel_adaptation");
    }

    @JvmStatic
    public static final boolean j() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.big_screen_panel_adaptation_v2");
    }

    @JvmStatic
    public static final boolean k() {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.dashboard.mobile_prefetch") == false) goto L22;
        int r100 = co4.a.f24616a;
        String r101 = au4.a.class.getName();
        Intrinsics.checkNotNullParameter(r101, "configClass");
        Boolean r102 = ((xm4.a.InterfaceC8255a) org.koin.java.a.c(xm4.a.InterfaceC8255a.class, null, null, 6)).a(r101);     // Catch: Throwable -> L14
        if (r102 == null) goto L8;
        boolean r103 = r102.booleanValue();     // Catch: Throwable -> L14
    L9:
        tt5.a.h("BitableABTestUtils", "getCommonABTestResult configClass: " + r101 + ", result: " + r103 + ", isDebug: " + eu5.c.c());     // Catch: Throwable -> L14
        if (r103 == true) goto L13;
        if (eu5.c.c() == true) goto L13;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L23;
        return true;
    L23:
        return false;
    L13:
        r104 = true;
        goto L17
    L8:
        r103 = false;
    L14:
        th = move-exception;
        tt5.a.e("BitableABTestUtils", "getCommonABTestResult configClass: " + r101 + ", failed", th, false);
        goto L16
    L22:
        return false;
    }

    @JvmStatic
    public static final boolean m() {
        int r100 = n.f214744a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.field.attach_upload_limitation_polish");
    }

    @JvmStatic
    public static final boolean n() {
        int r100 = n.f214744a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.web.button_field_update");
    }

    @JvmStatic
    public static final boolean o() {
        int r100 = n.f214744a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile.editor_cancel_enable");
    }

    @JvmStatic
    public static final boolean p() {
        int r100 = n.f214744a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile.pure_item_view");
    }

    @JvmStatic
    public static final boolean u() {
        int r100 = n.f214744a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.mobile.enable.link_field_detail_table_v2");
    }

    @JvmStatic
    public static final boolean v() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("bitable_feed_inbox_mobile_enabled");
    }

    @JvmStatic
    public static final boolean w() {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.support.mempope.app") == true) goto L5;
    L7:
        return false;
    L5:
        if (AppInfoUtils.e().booleanValue() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean x() {
        int r100 = n.f214744a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.modify_load_lynx_fragment_way");
    }

    @JvmStatic
    public static final boolean y() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.record.comment.enable");
    }

    @JvmStatic
    public static final boolean z() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.one.record");
    }

    @JvmStatic
    public static final boolean l() {
        if (p() == false) goto L7;
        int r100 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.opt.add_record_cache_first_enable") == false) goto L7;
        return true;
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean q() {
        if (p() == false) goto L7;
        int r100 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.pure_item_view.in_add_record") == false) goto L7;
        return true;
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean r() {
        if (p() == false) goto L7;
        int r100 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.pure_item_view.in_embedded") == false) goto L7;
        return true;
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean s() {
        if (p() == false) goto L7;
        int r100 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.pure_item_view.in_form") == false) goto L7;
        return true;
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean t() {
        if (p() == false) goto L11;
        int r100 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.pure_item_view.in_share_record") == false) goto L11;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.pure_item_view.field_group") == false) goto L11;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.config_item_view") == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static void b(StringBuilder r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.append(",");
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
