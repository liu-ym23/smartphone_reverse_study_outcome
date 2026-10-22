package com.bytedance.ee.bear.middleground.permission;

import android.app.Application;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f233101a = 0;

    static {
    }

    @JvmStatic
    public static final boolean c() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r101 = LarkContext.getApplication();
        r100.getClass();
        boolean r102 = ((dn4.a) k.b(((v) k.a(r101, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("lark.security.file-encrypt.error-handling");
        tt5.a.h("PermFGUtils", "fileEncryptErrorHandling()...enable = " + r102);
        return r102;
    }

    @JvmStatic
    public static final boolean f() {
        return com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.doc.dlp_enable");
    }

    @JvmStatic
    public static final boolean g() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.mobile.permission.reference_document_enable");
        tt5.a.h("PermFGUtils", "isDocxBaseEnable()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean l() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.permission.third_party_permission_service_enabled");
        tt5.a.h("PermFGUtils", "isSecretThirdPart()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean a() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.allowlist_to_copy_temporary_client");
        tt5.a.h("PermFGUtils", "canKpViewCopy()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean b() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.custompasswordfordocs");
        tt5.a.h("PermFGUtils", "enableCustomPassword()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean e() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("com.permission.audit_control_enable");
        tt5.a.h("PermFGUtils", "isAuditControlEnable()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final Boolean h() {
        jdb.g r100 = d(LarkContext.getApplication());
        if (r100 == null) goto L5;
        boolean r101 = r100.isEnable("ccm.permission.l1_l2_access_expand_update_native");
    L6:
        tt5.a.h("PermFGUtils", "isEnableL1L2AccessExpandUpdateNative()...isEnable = " + r101);
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final Boolean i() {
        jdb.g r100 = d(LarkContext.getApplication());
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = r100.isEnable("ccm.permission.secret_level_searchable_tip");
    L6:
        if (r100 == null) goto L8;
        boolean r103 = r100.isEnable("ccm.permission.secret_level_tip_new");
    L9:
        tt5.a.h("PermFGUtils", "isEnableWarnTip()...isEnable = " + r102 + ", isEnableNew = " + r103);
        if (r102 == false) goto L14;
        if (r103 == false) goto L14;
        r101 = true;
    L14:
        return Boolean.valueOf(r101);
    L8:
        r103 = false;
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean j() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.secret_label_b2b_optimize_enable");
        tt5.a.h("PermFGUtils", "isRelatedOrgEnable()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean k() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.search_entity_enable");
        tt5.a.h("PermFGUtils", "isSearchEntityEnable()...enable = " + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean m() {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission_settings_passport");
    }

    @JvmStatic
    public static final boolean n() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.security.sensitivity_label.escape_enabled");
        tt5.a.h("PermFGUtils", "sensitivityLabelEscape()...enable = " + r100);
        return r100;
    }

    public static jdb.g d(Application r100) {
        if (r100 == null) goto L4;
        com.bytedance.ee.bear.appsetting.c.a.f206237a.getClass();
        UserSession r101 = ((com.ss.android.lark.passportc.convention.a) k.a(r100, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) k.b(((v) k.a(r100, v.class)).c(r101), dn4.a.class)).a();
    L4:
        return null;
    }
}
