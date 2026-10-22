package i8b;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PolicyModel> f488728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f488729b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f488728a, r101.f488728a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488729b, r101.f488729b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f488728a.hashCode() * 31) + this.f488729b.hashCode();
    }

    public final String toString() {
        return "CCMDLPUpdateData(policyModels=" + this.f488728a + ", identifier=" + this.f488729b + ')';
    }

    public final String getIdentifier() {
        return this.f488729b;
    }

    public d(List<PolicyModel> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "policyModels");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        this.f488728a = r100;
        this.f488729b = r101;
    }
}
