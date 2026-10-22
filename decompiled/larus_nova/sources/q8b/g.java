package q8b;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.d0;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f532057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532058b;

    public g() {
        this.f532057a = CollectionsKt.listOf(new i(new a("UNIVERSAL_FALLBACK_COMMON"), null, 6));
        this.f532058b = "FallbackActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.f532058b;
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.f532057a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        int r101 = d0.f418172a;
        Intrinsics.checkNotNullParameter(r100, "action");
        String r102 = com.larksuite.framework.utils.b.f285948a.getString(R.string.Lark_SecureDowngrade_Toast_UnableToEditInternetError);     // Catch: Exception -> L5
        UDToast.show(com.larksuite.framework.utils.b.f285948a, r102, R.drawable.lkui_icon_fail);
        ScsLogger.d("SecurityPolicy_SecurityPolicyFallbackActionManager", "handleFallbackAction()，show Toast");
        return;
    L5:
        e = move-exception;
        int r103 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_SecurityPolicyFallbackActionManager", ExceptionsKt.stackTraceToString(e));
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r100) {
        return c.a.a(this, r100);
    }
}
