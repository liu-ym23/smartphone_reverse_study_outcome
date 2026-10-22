package jg5;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.leader.LeaderPermCenterConfig;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements cj5.a {

    public static class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public final boolean a() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.link_share_optimize_enable");
        tt5.a.h("PermFGUtils", "enableOptimizeLinkShare()...enable = " + r1);
        return r1;
    }

    public final String c() {
        LeaderPermCenterConfig r0 = (LeaderPermCenterConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(LeaderPermCenterConfig.KEY, LeaderPermCenterConfig.class, new LeaderPermCenterConfig());
        tt5.a.h("PermissionApiConfigImpl", "getLeaderPermHelpUrl()...config = " + du5.b.f(r0));
        if (TextUtils.equals(((i0) org.koin.java.a.a(i0.class)).a(), Locale.CHINESE.getLanguage()) == false) goto L6;
        String r1 = r0.getCn_url();
    L10:
        if (TextUtils.isEmpty(r1) == false) goto L13;
        return "";
    L13:
        return r1;
    L6:
        if (TextUtils.equals(((i0) org.koin.java.a.a(i0.class)).a(), Locale.JAPANESE.getLanguage()) == false) goto L8;
        r1 = r0.getJp_url();
        goto L10
    L8:
        r1 = r0.getEn_url();
        goto L10
    }

    public final boolean d() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.security.dlp_upload");
        tt5.a.h("PermFGUtils", "isDlpUploadControl()...enable = " + r1);
        return r1;
    }

    public final boolean e() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.share_recommend.leader_auth");
        tt5.a.h("PermFGUtils", "isLeaderAuthorizeEnable()...enable = " + r1);
        return r1;
    }

    public final boolean f() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.permission.offline_perm_screenshot");
        tt5.a.h("PermFGUtils", "isOfflineScreenShotPermission()...enable = " + r1);
        return r1;
    }

    public final boolean g() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.permission.permission_sdk_enable");
        tt5.a.h("PermFGUtils", "isPermissionPlatformEnable()...enable = " + r1);
        return r1;
    }

    public final boolean h() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.permission.share_channel");
        tt5.a.h("PermFGUtils", "isShowThirdChannel()...enable = " + r1);
        return !r1;
    }

    public final boolean i() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.wiki_share_channel");
        tt5.a.h("PermFGUtils", "wikiShowChannel()...enable = " + r1);
        return r1;
    }

    public e() {
    }

    public final boolean b(int r6) {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        if (r6 != 8) goto L7;
        com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r7.getClass();
        boolean r8 = ((dn4.a) e0c.k.b(((v) e0c.k.a(r1, v.class)).c(((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.bitable_pro_add_to_new_share_panel");
        tt5.a.h("PermFGUtils", "showNewSharePanel()...enable = " + r8);
        if (r8 == true) goto L7;
        return false;
    L7:
        boolean r9 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.share_panel_v2");
        tt5.a.h("PermFGUtils", "showNewSharePanel()...enable = " + r9);
        return r9;
    }
}
