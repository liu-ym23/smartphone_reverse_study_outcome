package pf1;

import com.bytedance.android.livesdk.castscreen.castscreenapi.model.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f528840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final of1.a f528841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f528842c;

    /* JADX INFO: renamed from: pf1.a$a, reason: collision with other inner class name */
    public static final class C7190a {
    }

    static {
    }

    public a() {
        this(null, null, 3);
    }

    public final int hashCode() {
        of1.a r100 = this.f528841b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f528842c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L29;
        a r102 = (a) r100;
        of1.a r103 = this.f528841b;
        if (r103 == null) goto L27;
        of1.a r104 = r102.f528841b;
        if (r104 != null) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 != true) goto L27;
        if ((!Intrinsics.areEqual(this.f528842c, r102.f528842c)) == false) goto L26;
        return false;
    L26:
        return true;
    L18:
        if (r103.a(r104) != true) goto L20;
        r105 = true;
    L27:
        return false;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.castscreen.padandpc.model.PadAndPcDeviceItemModel");
    L8:
        r101 = null;
        goto L10
    }

    public a(of1.a r100, b r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f528841b = r100;
        this.f528842c = r101;
    }
}
