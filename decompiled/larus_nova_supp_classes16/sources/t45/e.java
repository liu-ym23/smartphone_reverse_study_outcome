package t45;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.config.InterfaceDomain;
import com.bytedance.ee.bear.contract.config.TenantInfo;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.integrator.ccm.dependency.FrontierAppKeyConfig;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements b {
    public final m a;
    public final mcb.c b;
    public volatile TenantInfo c;

    public static final class a {
    }

    static {
    }

    @Override // t45.b
    public final TenantInfo a() {
        if (this.c != null) goto L65;
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L6:
        if (this.c != null) goto L59;
        User r2 = this.a.getUser();     // Catch: Throwable -> L62
        boolean r3 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.enable_user_domain");     // Catch: Throwable -> L62
        if (r3 == false) goto L13;
        String r5 = r2.userId;     // Catch: Throwable -> L62
        String r6 = r2.getTenantCode();     // Catch: Throwable -> L62
        String r7 = jcb.b.c().L0(r5, "docs_main_domain");     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r6) == false) goto L12;
        r6 = "www";
    L12:
        String r8 = r6 + '.' + r7;     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L62
    L14:
        String r9 = r8;
        if (r3 == false) goto L23;
        String r10 = r2.userId;     // Catch: Throwable -> L62
        String r11 = r2.getTenantCode();     // Catch: Throwable -> L62
        String r12 = jcb.b.c().L0(r10, "docs_mg_main_domain");     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r12) == false) goto L20;
        r12 = jcb.b.c().L0(r10, "docs_main_domain");     // Catch: Throwable -> L62
    L20:
        if (TextUtils.isEmpty(r11) == false) goto L22;
        r11 = "www";
    L22:
        String r4 = r11 + '.' + r12;     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L62
    L24:
        String r13 = r4;
        boolean r14 = !Intrinsics.areEqual("feishu", r2.getTenantBrand());     // Catch: Throwable -> L62
        if (r3 == false) goto L27;
        String r16 = this.b.a("docs_api");     // Catch: Throwable -> L62
    L30:
        if (r3 == false) goto L32;
        String r17 = this.b.a("docs_drive");     // Catch: Throwable -> L62
    L35:
        InterfaceDomain r18 = new InterfaceDomain(r16, r17);     // Catch: Throwable -> L62
        if (r3 == false) goto L38;
        String r19 = this.b.a("docs_long");     // Catch: Throwable -> L62
    L39:
        if (r3 == false) goto L41;
        List r20 = this.b.b("docs_frontier");     // Catch: Throwable -> L62
    L42:
        if (r20 != null) goto L44;
    L46:
        String r110 = r19;
    L47:
        if (r3 == false) goto L49;
        String r21 = this.b.a("mina");     // Catch: Throwable -> L62
    L50:
        String r111 = r21;
        if (r3 == false) goto L53;
        String r22 = this.b.a("docs_fe_resource_hotfix");     // Catch: Throwable -> L62
    L54:
        String r112 = r22;
        iva.a.a().getClass();     // Catch: Throwable -> L62
        int r113 = LarkAppContext.inst().appIdInfo().a;     // Catch: Throwable -> L62
        FrontierAppKeyConfig r23 = (FrontierAppKeyConfig) SettingManager.getInstance().get(FrontierAppKeyConfig.class);     // Catch: Throwable -> L62
        if (r23 == null) goto L57;
        String r24 = r23.mDocAppKey;     // Catch: Throwable -> L62
    L58:
        this.c = new TenantInfo(r9, r13, r14, r18, r110, r20, r111, r112, r113, r24);     // Catch: Throwable -> L62
        tt5.a.h("UserDocDomainConfigImpl", "getDocDomainConfig userSession=" + this.a.getSession() + " this@" + hashCode() + " getDocDomainConfig: " + this.c + " allAvailablePersistentConnectionDomain:" + r20 + " mainPersistentConnectionDomainOld:" + r19 + " enableUserDomain:" + r3);     // Catch: Throwable -> L62
        goto L59
    L57:
        r24 = null;
        goto L58
    L53:
        r22 = jcb.b.c().a("docs_fe_resource_hotfix");     // Catch: Throwable -> L62
        goto L54
    L49:
        r21 = jcb.b.c().a("mina");     // Catch: Throwable -> L62
        goto L50
    L44:
        if (r20.isEmpty() == true) goto L46;
        r110 = (String) r20.get(0);     // Catch: Throwable -> L62
        goto L47
    L41:
        r20 = jcb.b.c().b("docs_frontier");     // Catch: Throwable -> L62
        goto L42
    L38:
        r19 = jcb.b.c().a("docs_long");     // Catch: Throwable -> L62
        goto L39
    L32:
        r17 = jcb.b.c().a("docs_drive");     // Catch: Throwable -> L62
        if (r17 != null) goto L35;
        r17 = "";
        goto L35
    L27:
        r16 = jcb.b.c().a("docs_api");     // Catch: Throwable -> L62
        if (r16 != null) goto L30;
        r16 = "";
        goto L30
    L23:
        r4 = gcb.b.b(r2.getTenantCode());     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L62
        goto L24
    L13:
        r8 = gcb.b.a(r2.getTenantCode());     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L62
    L59:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(this);
    L65:
        TenantInfo r1 = this.c;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.config.TenantInfo");
        return r1;
    }

    public e(m r2, mcb.c r3) {
        Intrinsics.checkNotNullParameter(r2, "passportUserService");
        Intrinsics.checkNotNullParameter(r3, "userDomainConfig");
        this.a = r2;
        this.b = r3;
    }
}
