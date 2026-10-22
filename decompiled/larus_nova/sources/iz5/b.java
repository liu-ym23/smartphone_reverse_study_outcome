package iz5;

import hz5.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f496699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f496700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f496701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f496702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f496703e;

    /* JADX INFO: loaded from: classes19.dex */
    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f496699a, r101.f496699a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f496700b, r101.f496700b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f496701c, r101.f496701c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496702d, r101.f496702d) == true) goto L14;
        return false;
    L14:
        if (this.f496703e == r101.f496703e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // hz5.f
    public final String getTag() {
        return "ExceptionEvent";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Thread r100 = this.f496699a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Throwable r104 = this.f496700b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f496701c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f496702d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.f496703e;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExceptionEvent(thread=" + this.f496699a + ", e=" + this.f496700b + ", label=" + this.f496701c + ", data=" + this.f496702d + ", isThrowWhenOffline=" + this.f496703e + ")";
    }

    public /* synthetic */ b(Thread r100, Throwable r110, String r111, Map r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        Thread r101 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        r111 = "";
    L9:
        String r102 = r111;
        if ((r113 & 8) == 0) goto L12;
        Map r103 = null;
    L13:
        this(r101, r110, r102, r103, false);
        return;
    L12:
        r103 = r112;
        goto L13
    L5:
        r101 = r100;
        goto L7
    }

    public b(Thread r100, Throwable r101, String r102, Map<String, String> r103, boolean r104) {
        this.f496699a = r100;
        this.f496700b = r101;
        this.f496701c = r102;
        this.f496702d = r103;
        this.f496703e = r104;
    }
}
