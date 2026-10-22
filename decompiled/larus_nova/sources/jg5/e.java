package jg5;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.leader.LeaderPermCenterConfig;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements cj5.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f499003a = null;

        static {
            f499003a = new e();
        }
    }

    public final boolean a() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.link_share_optimize_enable");
        tt5.a.h("PermFGUtils", "enableOptimizeLinkShare()...enable = " + r101);
        return r101;
    }

    public final String c() {
        LeaderPermCenterConfig r100 = (LeaderPermCenterConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(LeaderPermCenterConfig.KEY, LeaderPermCenterConfig.class, new LeaderPermCenterConfig());
        tt5.a.h("PermissionApiConfigImpl", "getLeaderPermHelpUrl()...config = " + du5.b.f(r100));
        if (TextUtils.equals(((i0) org.koin.java.a.a(i0.class)).a(), Locale.CHINESE.getLanguage()) == false) goto L6;
        String r101 = r100.getCn_url();
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return "";
    L13:
        return r101;
    L6:
        if (TextUtils.equals(((i0) org.koin.java.a.a(i0.class)).a(), Locale.JAPANESE.getLanguage()) == false) goto L8;
        r101 = r100.getJp_url();
        goto L10
    L8:
        r101 = r100.getEn_url();
        goto L10
    }

    public final boolean d() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.security.dlp_upload");
        tt5.a.h("PermFGUtils", "isDlpUploadControl()...enable = " + r101);
        return r101;
    }

    public final boolean e() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.share_recommend.leader_auth");
        tt5.a.h("PermFGUtils", "isLeaderAuthorizeEnable()...enable = " + r101);
        return r101;
    }

    public final boolean f() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.permission.offline_perm_screenshot");
        tt5.a.h("PermFGUtils", "isOfflineScreenShotPermission()...enable = " + r101);
        return r101;
    }

    public final boolean g() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.permission.permission_sdk_enable");
        tt5.a.h("PermFGUtils", "isPermissionPlatformEnable()...enable = " + r101);
        return r101;
    }

    public final boolean h() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.permission.share_channel");
        tt5.a.h("PermFGUtils", "isShowThirdChannel()...enable = " + r101);
        return !r101;
    }

    public final boolean i() {
        int r100 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.wiki_share_channel");
        tt5.a.h("PermFGUtils", "wikiShowChannel()...enable = " + r101);
        return r101;
    }

    public e() {
    }

    public final boolean b(int r100) {
        int r101 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        if (r100 != 8) goto L7;
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r103 = LarkContext.getApplication();
        r102.getClass();
        boolean r104 = ((dn4.a) e0c.k.b(((v) e0c.k.a(r103, v.class)).c(((com.ss.android.lark.passportc.convention.a) e0c.k.a(r103, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.bitable_pro_add_to_new_share_panel");
        tt5.a.h("PermFGUtils", "showNewSharePanel()...enable = " + r104);
        if (r104 == true) goto L7;
        return false;
    L7:
        boolean r105 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.share_panel_v2");
        tt5.a.h("PermFGUtils", "showNewSharePanel()...enable = " + r105);
        return r105;
    }
}
