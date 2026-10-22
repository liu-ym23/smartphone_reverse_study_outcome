package jmb;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.contract.config.InterfaceDomain;
import com.bytedance.ee.bear.contract.config.LoginInfo;
import com.bytedance.ee.bear.contract.config.TenantInfo;
import com.bytedance.ee.bear.lark.dependency.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.integrator.ccm.dependency.FrontierAppKeyConfig;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    public static DocDynamicConfig a() {
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 == null) goto L5;
        String r101 = r100.getUserId();
        String r102 = r100.getTenantCode();
        String r103 = r101;
    L6:
        String r104 = jl5.a.a();
        if (TextUtils.isEmpty(r104) == true) goto L9;
        String r105 = r104;
    L10:
        User r106 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r106 != null) goto L13;
        String r107 = "";
    L14:
        User r108 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        String r110 = null;
        if (r108 == null) goto L17;
        String r109 = b0c.a.a(r108);
    L18:
        if (r109 != null) goto L20;
        String r111 = "";
    L21:
        User r112 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r112 == null) goto L24;
        String r113 = r112.enName;
    L25:
        if (r113 != null) goto L27;
        String r114 = "";
    L28:
        User r115 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r115 == null) goto L31;
        String r116 = r115.getTenantId();
    L32:
        if (r116 != null) goto L34;
        String r117 = "";
    L35:
        User r118 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r118 == null) goto L38;
        String r119 = r118.getTenantName();
    L39:
        if (r119 != null) goto L41;
        String r120 = "";
    L42:
        LoginInfo r121 = new LoginInfo(r103, r105, r107, r111, r114, r117, r120, false);
        String r122 = ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
        String r123 = gcb.b.a(r102);
        String r124 = gcb.b.b(r102);
        boolean r125 = !((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
        InterfaceDomain r126 = new InterfaceDomain(jcb.b.c().a("docs_api"), jcb.b.c().a("docs_drive"));
        String r127 = jcb.b.c().a("docs_long");
        List<String> r128 = jcb.b.c().b("docs_frontier");
        if (r128 != null) goto L45;
    L47:
        String r129 = r127;
        String r210 = jcb.b.c().a("mina");
        String r211 = jcb.b.c().a("docs_fe_resource_hotfix");
        iva.a.a().getClass();
        int r130 = LarkAppContext.inst().appIdInfo().f18218a;
        FrontierAppKeyConfig r131 = (FrontierAppKeyConfig) SettingManager.getInstance().get(FrontierAppKeyConfig.class);
        if (r131 == null) goto L50;
        r110 = r131.mDocAppKey;
    L50:
        TenantInfo r132 = new TenantInfo(r123, r124, r125, r126, r129, r128, r210, r211, r130, r110);
        boolean r133 = !((g) LarkContext.spiByDwarf(g.class)).N0();
        Application r134 = LarkContext.getApplication();
        if (PackageChannelManager.isKABuildPackage(r134) == true) goto L53;
    L55:
        boolean r135 = false;
    L56:
        String r136 = PackageChannelManager.getBuildPackageChannel(r134);
        String r137 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).getUserUnit();
        String r138 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).getTenantBrand();
        boolean r139 = LarkAppContext.inst().buildConfig().isUsPackage();
        tt5.a.h("DocDynamicConfigImpl", "getDocDynamicConfig: showDocWatermark= " + r133 + " isPrivateKaPkg= " + r135 + " buildPackageChannel= " + r136 + "userUnit= " + r137 + "isUsPackage=" + r139);
        return new DocDynamicConfig(r121, r122, r132, r133, r135, r136, r137, r138, r139);
    L53:
        if (PackageChannelManager.getDeployMode(r134) == 1) goto L55;
        r135 = true;
        goto L56
    L45:
        if (r128.isEmpty() == true) goto L47;
        r127 = (String) ListProtector.get(r128, 0);
        goto L47
    L41:
        r120 = r119;
        goto L42
    L38:
        r119 = null;
        goto L39
    L34:
        r117 = r116;
        goto L35
    L31:
        r116 = null;
        goto L32
    L27:
        r114 = r113;
        goto L28
    L24:
        r113 = null;
        goto L25
    L20:
        r111 = r109;
        goto L21
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = r106.avatarUrl;
        goto L14
    L9:
        tt5.a.d("DocDynamicConfigImpl", "preloadDocSdk().getAppKey() appToken is empty");
        r105 = "";
        goto L10
    L5:
        r102 = "";
        r103 = r102;
        goto L6
    }
}
