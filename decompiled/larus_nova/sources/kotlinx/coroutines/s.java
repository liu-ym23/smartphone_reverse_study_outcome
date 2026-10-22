package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f505055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f505056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Throwable, Unit> f505057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f505058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f505059e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f505055a, r101.f505055a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f505056b, r101.f505056b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f505057c, r101.f505057c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f505058d, r101.f505058d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f505059e, r101.f505059e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f505055a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h r104 = this.f505056b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<Throwable, Unit> r107 = this.f505057c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.f505058d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Throwable r113 = this.f505059e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "CompletedContinuation";
    }

    public static s a(s r100, h r101, Throwable r110, int r111) {
        Object r102 = null;
        if ((r111 & 1) == 0) goto L5;
        Object r103 = r100.f505055a;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = r100.f505056b;
    L9:
        h r104 = r101;
        if ((r111 & 4) == 0) goto L12;
        Function1<Throwable, Unit> r105 = r100.f505057c;
    L14:
        if ((r111 & 8) == 0) goto L16;
        r102 = r100.f505058d;
    L16:
        Object r106 = r102;
        if ((r111 & 16) == 0) goto L19;
        r110 = r100.f505059e;
    L19:
        r100.getClass();
        return new s(r103, r104, r105, r106, r110);
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(Object r100, h r101, Function1<? super Throwable, Unit> r102, Object r103, Throwable r104) {
        this.f505055a = r100;
        this.f505056b = r101;
        this.f505057c = r102;
        this.f505058d = r103;
        this.f505059e = r104;
    }

    public /* synthetic */ s(Object r100, h r110, Function1 r111, Object r112, Throwable r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        h r101 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        Function1 r102 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        Object r103 = null;
    L15:
        if ((r114 & 16) == 0) goto L17;
        Throwable r104 = null;
    L18:
        this(r100, r101, r102, r103, r104);
        return;
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
