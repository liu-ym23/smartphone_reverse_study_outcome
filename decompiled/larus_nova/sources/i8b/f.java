package i8b;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PolicyModel> f488730a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f488730a, ((f) r100).f488730a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f488730a.hashCode();
    }

    public final String toString() {
        return "CCMFileProtectUpdateData(policyModels=" + this.f488730a + ')';
    }

    public f(List<PolicyModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModels");
        this.f488730a = r100;
    }
}
