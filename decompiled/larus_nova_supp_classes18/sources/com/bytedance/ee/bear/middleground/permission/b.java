package com.bytedance.ee.bear.middleground.permission;

import android.app.Application;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean c() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        boolean r2 = ((dn4.a) k.b(((v) k.a(r1, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("lark.security.file-encrypt.error-handling");
        tt5.a.h("PermFGUtils", "fileEncryptErrorHandling()...enable = " + r2);
        return r2;
    }

    @JvmStatic
    public static final boolean f() {
        return com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.doc.dlp_enable");
    }

    @JvmStatic
    public static final boolean g() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.permission.reference_document_enable");
        tt5.a.h("PermFGUtils", "isDocxBaseEnable()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean l() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.permission.third_party_permission_service_enabled");
        tt5.a.h("PermFGUtils", "isSecretThirdPart()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean a() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.allowlist_to_copy_temporary_client");
        tt5.a.h("PermFGUtils", "canKpViewCopy()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean b() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.custompasswordfordocs");
        tt5.a.h("PermFGUtils", "enableCustomPassword()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean e() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("com.permission.audit_control_enable");
        tt5.a.h("PermFGUtils", "isAuditControlEnable()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final Boolean h() {
        jdb.g r0 = d(LarkContext.getApplication());
        if (r0 == null) goto L5;
        boolean r1 = r0.isEnable("ccm.permission.l1_l2_access_expand_update_native");
    L6:
        tt5.a.h("PermFGUtils", "isEnableL1L2AccessExpandUpdateNative()...isEnable = " + r1);
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final Boolean i() {
        jdb.g r0 = d(LarkContext.getApplication());
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.isEnable("ccm.permission.secret_level_searchable_tip");
    L6:
        if (r0 == null) goto L8;
        boolean r3 = r0.isEnable("ccm.permission.secret_level_tip_new");
    L9:
        tt5.a.h("PermFGUtils", "isEnableWarnTip()...isEnable = " + r2 + ", isEnableNew = " + r3);
        if (r2 == false) goto L14;
        if (r3 == false) goto L14;
        r1 = true;
    L14:
        return Boolean.valueOf(r1);
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean j() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.secret_label_b2b_optimize_enable");
        tt5.a.h("PermFGUtils", "isRelatedOrgEnable()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean k() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.search_entity_enable");
        tt5.a.h("PermFGUtils", "isSearchEntityEnable()...enable = " + r0);
        return r0;
    }

    @JvmStatic
    public static final boolean m() {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission_settings_passport");
    }

    @JvmStatic
    public static final boolean n() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.security.sensitivity_label.escape_enabled");
        tt5.a.h("PermFGUtils", "sensitivityLabelEscape()...enable = " + r0);
        return r0;
    }

    public static jdb.g d(Application r3) {
        if (r3 == null) goto L4;
        com.bytedance.ee.bear.appsetting.c.a.a.getClass();
        UserSession r1 = ((com.ss.android.lark.passportc.convention.a) k.a(r3, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) k.b(((v) k.a(r3, v.class)).c(r1), dn4.a.class)).a();
    L4:
        return null;
    }
}
