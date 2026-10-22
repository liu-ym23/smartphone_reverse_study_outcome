package j29;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements t1a.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f497041c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserCreation f497042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497043b;

    public static final class a {
    }

    public c() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f497042a, r101.f497042a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f497043b, r101.f497043b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        UserCreation r100 = this.f497042a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f497043b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationDataWrap(userCreation=" + this.f497042a + ", creationId=" + this.f497043b + ')';
    }

    static {
        f497041c = new c(null, null);
    }

    public c(UserCreation r100, String r101) {
        this.f497042a = r100;
        this.f497043b = r101;
    }
}
