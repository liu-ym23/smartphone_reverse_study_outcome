package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f532053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532054b;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f532053a = CollectionsKt.listOf(new i[]{new i(new q8b.a("DLP_CONTENT_DETECTING"), null, 6), new i(new q8b.a("DLP_CONTENT_SENSITIVE"), null, 6)});
        this.f532054b = "DLPActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.f532054b;
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.f532053a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_DLPActionHandler", "hit DLP control, action:" + r100.getCurrentAction());
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r100) {
        return c.a.a(this, r100);
    }
}
