package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f532065a;

    public static final class a {
    }

    static {
    }

    @Override // q8b.c
    public final String c() {
        return "TTBlockActionHandler";
    }

    public k() {
        this.f532065a = CollectionsKt.listOf(new i(new q8b.a("TT_BLOCK"), null, 6));
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.f532065a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_TTBlockActionHandler", "hit TT control, action:" + r100.getCurrentAction());
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r100) {
        return c.a.a(this, r100);
    }
}
