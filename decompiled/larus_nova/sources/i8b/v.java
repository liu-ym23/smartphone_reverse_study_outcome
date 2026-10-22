package i8b;

import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PolicyModel> f488733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b0> f488734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileAuthMonitor.a f488735c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f488733a, r101.f488733a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488734b, r101.f488734b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f488735c, r101.f488735c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f488733a.hashCode() * 31) + this.f488734b.hashCode()) * 31) + this.f488735c.hashCode();
    }

    public final String toString() {
        return "ValidateUpdateData(policyModelList=" + this.f488733a + ", resultMap=" + this.f488734b + ", updateInfo=" + this.f488735c + ')';
    }

    public v(List<PolicyModel> r100, Map<String, b0> r101, FileAuthMonitor.a r102) {
        Intrinsics.checkNotNullParameter(r100, "policyModelList");
        Intrinsics.checkNotNullParameter(r101, "resultMap");
        Intrinsics.checkNotNullParameter(r102, "updateInfo");
        this.f488733a = r100;
        this.f488734b = r101;
        this.f488735c = r102;
    }
}
