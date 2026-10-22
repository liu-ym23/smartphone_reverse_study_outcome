package com.larus.account.saas.security.api;

import android.content.Context;
import android.content.Intent;
import com.larus.login.impl.riskcontrol.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import e48.c;
import e48.d;
import e48.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountSecurityService;", "", "Companion", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountSecurityService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286489a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountSecurityService$Companion;", "Lcom/larus/account/saas/security/api/IAccountSecurityService;", "<init>", "()V", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountSecurityService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286490b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IAccountSecurityService> f286491c = null;

        private Companion() {
        }

        static {
            f286490b = new Companion();
            f286491c = LazyKt.lazy(IAccountSecurityService$Companion$impl$2.INSTANCE);
        }

        public static IAccountSecurityService i() {
            return f286491c.getValue();
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            IAccountSecurityService r101 = i();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final boolean e(long r100) {
            Intrinsics.checkNotNullParameter("foreground_dialog", "messageId");
            IAccountSecurityService r101 = i();
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.e(r100);
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void g(f r100) {
            IAccountSecurityService r101 = i();
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void h(d r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            IAccountSecurityService r101 = i();
            if (r101 == null) goto L6;
            r101.h(r100);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void b(String r100, String r101) {
            IAccountSecurityService r102 = i();
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void c(long r100, a r101) {
            IAccountSecurityService r102 = i();
            if (r102 == null) goto L6;
            r102.c(r100, r101);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final Intent d(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, RuleConditionBean.OPEN_URL_KEY);
            IAccountSecurityService r102 = i();
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.d(r100, r101);
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final f f(String r100, JSONObject r101) {
            IAccountSecurityService r102 = i();
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.f(r100, r101);
        }
    }

    static {
        f286489a = Companion.f286490b;
    }

    void a(c r100);

    void b(String r100, String r101);

    void c(long r100, a r101);

    Intent d(Context r100, String r101);

    boolean e(long r100);

    f f(String r100, JSONObject r101);

    void g(f r100);

    void h(d r100);
}
