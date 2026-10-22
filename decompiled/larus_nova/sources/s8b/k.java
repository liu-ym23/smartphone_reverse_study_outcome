package s8b;

import android.os.Bundle;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements q8b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q8b.i> f541019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541020b;

    public k() {
        this.f541019a = CollectionsKt.listOf(new q8b.i(q8b.d.f532052c, new q8b.a("COND_ACCESS"), 4));
        this.f541020b = "UnknownNoPermissionActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.f541020b;
    }

    @Override // q8b.b
    public final List<q8b.i> getRules() {
        return this.f541019a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        Bundle r101 = new Bundle();
        r101.putParcelable("param_action", r100);
        int r102 = g8b.b.f480460a;
        g8b.b.a.a().c(NoPermissionType.UNKNOWN, r101);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r100) {
        return q8b.c.a.a(this, r100);
    }
}
