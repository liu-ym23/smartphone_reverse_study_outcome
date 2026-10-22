package i8b;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileAuthMonitor.a f488726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PolicyModel> f488727b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f488726a, r101.f488726a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488727b, r101.f488727b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f488726a.hashCode() * 31) + this.f488727b.hashCode();
    }

    public final String toString() {
        return "BatchValidateData(updateInfo=" + this.f488726a + ", validateModels=" + this.f488727b + ')';
    }

    public b(FileAuthMonitor.a r100, List<PolicyModel> r101) {
        Intrinsics.checkNotNullParameter(r100, "updateInfo");
        Intrinsics.checkNotNullParameter(r101, "validateModels");
        this.f488726a = r100;
        this.f488727b = r101;
    }
}
