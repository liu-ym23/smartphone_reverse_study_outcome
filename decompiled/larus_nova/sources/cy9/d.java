package cy9;

import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WeakReference<Object> f465953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f465954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f465955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f465956d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f465957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f465958b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f465957a, r101.f465957a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f465958b, r101.f465958b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f465957a.hashCode() * 31) + this.f465958b.hashCode();
        }

        public final String toString() {
            return "DetailOwnerActions(onSetPrivate=" + this.f465957a + ", onDelete=" + this.f465958b + ')';
        }

        public a(Function0<Unit> r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "onSetPrivate");
            Intrinsics.checkNotNullParameter(r101, "onDelete");
            this.f465957a = r100;
            this.f465958b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f465959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f465960b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f465959a, r101.f465959a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f465960b, r101.f465960b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f465959a.hashCode() * 31) + this.f465960b.hashCode();
        }

        public final String toString() {
            return "ProfileUserActions(onBlock=" + this.f465959a + ", onReport=" + this.f465960b + ')';
        }

        public b(Function0<Unit> r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "onBlock");
            Intrinsics.checkNotNullParameter(r101, "onReport");
            this.f465959a = r100;
            this.f465960b = r101;
        }
    }

    static {
    }

    public static void b() {
        WeakReference<Object> r100 = f465953a;
        if (r100 == null) goto L5;
        Object r101 = r100.get();
    L7:
        if ((r101 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r102 = (LifecycleOwner) r101;
    L10:
        c r103 = f465954b;
        if (r102 == null) goto L14;
        if (r103 == null) goto L14;
        r102.getLifecycle().removeObserver(r103);
    L14:
        f465954b = null;
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public static a c() {
        WeakReference<Object> r100 = f465953a;
        if (r100 == null) goto L5;
        Object r101 = r100.get();
    L6:
        if (r101 != null) goto L9;
        b();
        f465953a = null;
        f465955c = null;
        f465956d = null;
        return null;
    L9:
        return f465955c;
    L5:
        r101 = null;
        goto L6
    }

    public static b d() {
        WeakReference<Object> r100 = f465953a;
        if (r100 == null) goto L5;
        Object r101 = r100.get();
    L6:
        if (r101 != null) goto L9;
        b();
        f465953a = null;
        f465955c = null;
        f465956d = null;
        return null;
    L9:
        return f465956d;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.LifecycleObserver, cy9.c] */
    public static void a(final Object r100) {
        b();
        f465953a = new WeakReference(r100);
        if ((r100 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r101 = (LifecycleOwner) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        ?? r102 = new c(r100);
        r101.getLifecycle().addObserver(r102);
        f465954b = r102;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static void e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        WeakReference<Object> r101 = f465953a;
        if (r101 == null) goto L5;
        Object r102 = r101.get();
    L6:
        if (r102 == r100) goto L12;
        WeakReference<Object> r103 = f465953a;
        if (r103 == null) goto L10;
        Object r104 = r103.get();
    L11:
        if (r104 == null) goto L12;
        return;
    L10:
        r104 = null;
    L12:
        b();
        f465953a = null;
        f465955c = null;
        f465956d = null;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
