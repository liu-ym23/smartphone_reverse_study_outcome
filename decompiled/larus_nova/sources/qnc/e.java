package qnc;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f534137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f534138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.suite.lark.component.navroute.a f534139e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f534135a, r101.f534135a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534136b, r101.f534136b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f534137c, r101.f534137c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f534138d, r101.f534138d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f534139e, r101.f534139e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f534135a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f534136b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Fragment r107 = this.f534137c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FragmentActivity r110 = this.f534138d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.f534139e.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("fragment=");
        Fragment r101 = this.f534137c;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getClass().getSimpleName();
    L6:
        r100.append(r103);
        r100.append(", routerId=");
        r100.append(this.f534139e.c());
        r100.append(", route=");
        r100.append(this.f534135a);
        r100.append(", activity=");
        FragmentActivity r104 = this.f534138d;
        if (r104 == null) goto L9;
        r102 = r104.getClass().getSimpleName();
    L9:
        r100.append(r102);
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public static e a(e r100, com.suite.lark.component.navroute.a r101) {
        String r102 = r100.f534135a;
        String r103 = r100.f534136b;
        Fragment r104 = r100.f534137c;
        FragmentActivity r105 = r100.f534138d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "navController");
        return new e(r102, r103, r104, r105, r101);
    }

    public e(String r100, String r101, Fragment r102, FragmentActivity r103, com.suite.lark.component.navroute.a r104) {
        Intrinsics.checkNotNullParameter(r104, "navController");
        this.f534135a = r100;
        this.f534136b = r101;
        this.f534137c = r102;
        this.f534138d = r103;
        this.f534139e = r104;
    }
}
