package s8b;

import android.os.Bundle;
import com.bytedance.lark.pb.security.v1.ChallengeType;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements q8b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q8b.i> f541001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541002b;

    public b() {
        this.f541001a = CollectionsKt.listOf(new q8b.i(new q8b.a("BLOCKED_BY_DEVICE_CREDIBILITY"), new q8b.a("COND_ACCESS"), new q8b.a(Integer.valueOf(ChallengeType.NEED_APPLY_DEVICE_STATUS.getValue()))));
        this.f541002b = "DeviceCredibilityNoPermissionActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.f541002b;
    }

    @Override // q8b.b
    public final List<q8b.i> getRules() {
        return this.f541001a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "internalSecurityAction");
        Bundle r101 = new Bundle();
        r101.putParcelable("param_action", r100);
        int r102 = g8b.b.f480460a;
        g8b.b.a.a().c(NoPermissionType.DEVICE_CREDIBILITY, r101);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r100) {
        return q8b.c.a.a(this, r100);
    }
}
