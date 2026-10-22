package t45;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.config.InterfaceDomain;
import com.bytedance.ee.bear.contract.config.TenantInfo;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.integrator.ccm.dependency.FrontierAppKeyConfig;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f544575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mcb.c f544576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile TenantInfo f544577c;

    public static final class a {
    }

    static {
    }

    @Override // t45.b
    public final TenantInfo a() {
        if (this.f544577c != null) goto L65;
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L6:
        if (this.f544577c != null) goto L59;
        User r100 = this.f544575a.getUser();     // Catch: Throwable -> L62
        boolean r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.enable_user_domain");     // Catch: Throwable -> L62
        if (r101 == false) goto L13;
        String r102 = r100.userId;     // Catch: Throwable -> L62
        String r103 = r100.getTenantCode();     // Catch: Throwable -> L62
        String r104 = jcb.b.c().L0(r102, "docs_main_domain");     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r103) == false) goto L12;
        r103 = "www";
    L12:
        String r105 = r103 + '.' + r104;     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L62
    L14:
        String r106 = r105;
        if (r101 == false) goto L23;
        String r107 = r100.userId;     // Catch: Throwable -> L62
        String r108 = r100.getTenantCode();     // Catch: Throwable -> L62
        String r109 = jcb.b.c().L0(r107, IDomainConfigService.DomainAlias.DOCS_MG_MAIN_DOMAIN);     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r109) == false) goto L20;
        r109 = jcb.b.c().L0(r107, "docs_main_domain");     // Catch: Throwable -> L62
    L20:
        if (TextUtils.isEmpty(r108) == false) goto L22;
        r108 = "www";
    L22:
        String r110 = r108 + '.' + r109;     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L62
    L24:
        String r111 = r110;
        boolean r112 = !Intrinsics.areEqual("feishu", r100.getTenantBrand());     // Catch: Throwable -> L62
        if (r101 == false) goto L27;
        String r113 = this.f544576b.a("docs_api");     // Catch: Throwable -> L62
    L30:
        if (r101 == false) goto L32;
        String r114 = this.f544576b.a("docs_drive");     // Catch: Throwable -> L62
    L35:
        InterfaceDomain r115 = new InterfaceDomain(r113, r114);     // Catch: Throwable -> L62
        if (r101 == false) goto L38;
        String r116 = this.f544576b.a("docs_long");     // Catch: Throwable -> L62
    L39:
        if (r101 == false) goto L41;
        List<String> r117 = this.f544576b.b("docs_frontier");     // Catch: Throwable -> L62
    L42:
        if (r117 != null) goto L44;
    L46:
        String r118 = r116;
    L47:
        if (r101 == false) goto L49;
        String r119 = this.f544576b.a("mina");     // Catch: Throwable -> L62
    L50:
        String r120 = r119;
        if (r101 == false) goto L53;
        String r121 = this.f544576b.a("docs_fe_resource_hotfix");     // Catch: Throwable -> L62
    L54:
        String r122 = r121;
        iva.a.a().getClass();     // Catch: Throwable -> L62
        int r123 = LarkAppContext.inst().appIdInfo().f18218a;     // Catch: Throwable -> L62
        FrontierAppKeyConfig r124 = (FrontierAppKeyConfig) SettingManager.getInstance().get(FrontierAppKeyConfig.class);     // Catch: Throwable -> L62
        if (r124 == null) goto L57;
        String r125 = r124.mDocAppKey;     // Catch: Throwable -> L62
    L58:
        this.f544577c = new TenantInfo(r106, r111, r112, r115, r118, r117, r120, r122, r123, r125);     // Catch: Throwable -> L62
        tt5.a.h("UserDocDomainConfigImpl", "getDocDomainConfig userSession=" + this.f544575a.getSession() + " this@" + hashCode() + " getDocDomainConfig: " + this.f544577c + " allAvailablePersistentConnectionDomain:" + r117 + " mainPersistentConnectionDomainOld:" + r116 + " enableUserDomain:" + r101);     // Catch: Throwable -> L62
        goto L59
    L57:
        r125 = null;
        goto L58
    L53:
        r121 = jcb.b.c().a("docs_fe_resource_hotfix");     // Catch: Throwable -> L62
        goto L54
    L49:
        r119 = jcb.b.c().a("mina");     // Catch: Throwable -> L62
        goto L50
    L44:
        if (r117.isEmpty() == true) goto L46;
        r118 = r117.get(0);     // Catch: Throwable -> L62
        goto L47
    L41:
        r117 = jcb.b.c().b("docs_frontier");     // Catch: Throwable -> L62
        goto L42
    L38:
        r116 = jcb.b.c().a("docs_long");     // Catch: Throwable -> L62
        goto L39
    L32:
        r114 = jcb.b.c().a("docs_drive");     // Catch: Throwable -> L62
        if (r114 != null) goto L35;
        r114 = "";
        goto L35
    L27:
        r113 = jcb.b.c().a("docs_api");     // Catch: Throwable -> L62
        if (r113 != null) goto L30;
        r113 = "";
        goto L30
    L23:
        r110 = gcb.b.b(r100.getTenantCode());     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L62
        goto L24
    L13:
        r105 = gcb.b.a(r100.getTenantCode());     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L62
    L59:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(this);
    L65:
        TenantInfo r127 = this.f544577c;
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.config.TenantInfo");
        return r127;
    }

    public e(m r100, mcb.c r101) {
        Intrinsics.checkNotNullParameter(r100, "passportUserService");
        Intrinsics.checkNotNullParameter(r101, "userDomainConfig");
        this.f544575a = r100;
        this.f544576b = r101;
    }
}
