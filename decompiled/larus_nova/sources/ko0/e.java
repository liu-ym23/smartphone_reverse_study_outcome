package ko0;

import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.utils.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f504362e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f504365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f504366d;

    public static final class a {
        public a() {
        }

        public static boolean b() {
            float r100 = z0.b(false);
            if (a() != 0) goto L5;
            return false;
        L5:
            if (r100 <= o90.f120886a.getValue().d()) goto L9;
            return true;
        L9:
            return false;
        }

        public static int a() {
            return o90.f120886a.getValue().e();
        }
    }

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f504363a == r101.f504363a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f504364b, r101.f504364b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f504365c, r101.f504365c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f504366d, r101.f504366d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f504363a * 31;
        String r101 = this.f504364b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Function0<Unit> r105 = this.f504365c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Function0<Unit> r108 = this.f504366d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppToolbarAnimConfig(animType=" + this.f504363a + ", animUrl=" + this.f504364b + ", onAnimStart=" + this.f504365c + ", onAnimEnd=" + this.f504366d + ")";
    }

    static {
        f504362e = new a();
    }

    public e(int r100, String r101, Function0 r102) {
        this.f504363a = r100;
        this.f504364b = r101;
        this.f504365c = null;
        this.f504366d = r102;
    }
}
