package hm4;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f485934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f485935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f485936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<View> f485937e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f485933a == r101.f485933a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f485934b, r101.f485934b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f485935c, r101.f485935c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f485936d, r101.f485936d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f485937e, r101.f485937e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f485933a * 31) + this.f485934b.hashCode()) * 31) + this.f485935c.hashCode()) * 31) + this.f485936d.hashCode()) * 31;
        WeakReference<View> r101 = this.f485937e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BreakPointUpdate(orientation=" + this.f485933a + ", horizontalBreakPoint=" + this.f485934b + ", verticalBreakPoint=" + this.f485935c + ", pageSize=" + this.f485936d + ", viewWR=" + this.f485937e + ')';
    }

    public /* synthetic */ d(b r100, b r101, a r102) {
        this(1, r100, r101, r102, null);
    }

    public d(int r100, b r101, b r102, a r103, WeakReference<View> r104) {
        Intrinsics.checkNotNullParameter(r101, "horizontalBreakPoint");
        Intrinsics.checkNotNullParameter(r102, "verticalBreakPoint");
        Intrinsics.checkNotNullParameter(r103, "pageSize");
        this.f485933a = r100;
        this.f485934b = r101;
        this.f485935c = r102;
        this.f485936d = r103;
        this.f485937e = r104;
    }
}
