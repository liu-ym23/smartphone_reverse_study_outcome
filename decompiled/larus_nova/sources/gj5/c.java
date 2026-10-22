package gj5;

import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f481503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileAuthResultFrom f481504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValidateResult f481505c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f481503a == r101.f481503a) goto L12;
        return false;
    L12:
        if (this.f481504b == r101.f481504b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f481503a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f481504b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ValidateResult(allow=" + this.f481503a + ", validateSource=" + this.f481504b + ')';
    }

    public c(boolean r100, FileAuthResultFrom r101) {
        Intrinsics.checkNotNullParameter(r101, "validateSource");
        this.f481503a = r100;
        this.f481504b = r101;
    }
}
