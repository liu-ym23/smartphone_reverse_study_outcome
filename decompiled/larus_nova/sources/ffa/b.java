package ffa;

import com.obric.assistant.obric_action.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final efa.a f476781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<Object> f476782b;

    public b() {
        this(null, null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f476781a, r101.f476781a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476782b, r101.f476782b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        efa.a r100 = this.f476781a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h<Object> r104 = this.f476782b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResolveObricIntentResult(actionSpec=" + this.f476781a + ", errorResult=" + this.f476782b + ')';
    }

    public b(efa.a r100, h r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f476781a = r100;
        this.f476782b = r101;
    }
}
