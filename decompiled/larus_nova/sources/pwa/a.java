package pwa;

import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValidateResult f530855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ValidateResult f530856b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f530855a, r101.f530855a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530856b, r101.f530856b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ValidateResult r100 = this.f530855a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ValidateResult r104 = this.f530856b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AuthorizationResult(receiveAuthResult=" + this.f530855a + ", previewAuthResult=" + this.f530856b + ')';
    }

    public a(ValidateResult r100, ValidateResult r101) {
        this.f530855a = r100;
        this.f530856b = r101;
    }
}
