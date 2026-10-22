package owa;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.auditsdk.authorization.AuthorizationService;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.wrapper.AuditService;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static AuditService a() {
        return AuditService.f409701a.getValue();
    }

    public static AuthorizationService b() {
        return AuthorizationService.f409559a.getValue();
    }

    public static AuthorizationServiceV2 c() {
        return AuthorizationServiceV2.f409595b.getValue();
    }

    public static IAuditModuleDependency d() {
        return (IAuditModuleDependency) ClaymoreServiceLoader.loadFirst(IAuditModuleDependency.class);
    }
}
