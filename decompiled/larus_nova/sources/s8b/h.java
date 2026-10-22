package s8b;

import android.os.Bundle;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements q8b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q8b.i> f541013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541014b;

    public h() {
        this.f541013a = CollectionsKt.listOf(new q8b.i(new q8b.a("ACCESS_MFA"), null, 6));
        this.f541014b = "MFANoPermissionActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.f541014b;
    }

    @Override // q8b.b
    public final List<q8b.i> getRules() {
        return this.f541013a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        Bundle r101 = new Bundle();
        r101.putParcelable("param_action", r100);
        int r102 = g8b.b.f480460a;
        g8b.b.a.a().c(NoPermissionType.MFA, r101);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r100) {
        return q8b.c.a.a(this, r100);
    }
}
