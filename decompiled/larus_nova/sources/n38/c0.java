package n38;

import com.larus.account.base.model.PhoneOneKeyPlatform;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhoneOneKeyPlatform f516996b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f516995a, r101.f516995a) == true) goto L12;
        return false;
    L12:
        if (this.f516996b == r101.f516996b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f516995a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PhoneOneKeyPlatform r104 = this.f516996b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhoneOneKeyInfo(maskPhone=" + this.f516995a + ", carrier=" + this.f516996b + ')';
    }

    public c0(String r100, PhoneOneKeyPlatform r101) {
        this.f516995a = r100;
        this.f516996b = r101;
    }
}
