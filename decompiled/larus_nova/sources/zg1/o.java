package zg1;

import android.os.Bundle;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Effect f571891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f571893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f571894e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L16;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f571890a, r101.f571890a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571891b, r101.f571891b) == true) goto L10;
        return false;
    L10:
        if (this.f571892c == r101.f571892c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571893d, r101.f571893d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f571894e, r101.f571894e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        String r100 = this.f571890a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Effect r104 = this.f571891b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f571892c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        q r110 = this.f571893d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Bundle r113 = this.f571894e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ChangeStickerEvent(panel=" + this.f571890a + ", effect=" + this.f571891b + ", use=" + this.f571892c + ", listener=" + this.f571893d + ", extra=" + this.f571894e + ")";
    }

    public o(String r100, Effect r101, boolean r102, q r103, Bundle r104) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "effect");
        Intrinsics.checkNotNullParameter(r104, "extra");
        this.f571890a = r100;
        this.f571891b = r101;
        this.f571892c = r102;
        this.f571893d = r103;
        this.f571894e = r104;
    }
}
