package e19;

import android.app.Activity;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f470720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f470721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f470722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f470723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470724e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f470720a, r101.f470720a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470721b, r101.f470721b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470722c, r101.f470722c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470723d, r101.f470723d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470724e, r101.f470724e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        h r100 = this.f470720a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Activity r104 = this.f470721b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ViewGroup r107 = this.f470722c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f470723d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.f470724e.hashCode();
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
        return "FloatWindowHostResolveContext(request=" + this.f470720a + ", activity=" + this.f470721b + ", fallbackParent=" + this.f470722c + ", previousHost=" + this.f470723d + ", reason=" + this.f470724e + ')';
    }

    public final Activity getActivity() {
        return this.f470721b;
    }

    public c(h r100, Activity r101, ViewGroup r102, b r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "reason");
        this.f470720a = r100;
        this.f470721b = r101;
        this.f470722c = r102;
        this.f470723d = r103;
        this.f470724e = r104;
    }
}
