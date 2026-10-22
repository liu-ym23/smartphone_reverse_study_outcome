package u4;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f548642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<a> f548643d;

    public final int hashCode() {
        return (this.f548640a + this.f548641b + this.f548642c).hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f548640a);
        r100.append(' ');
        r100.append(this.f548641b);
        r100.append(' ');
        r100.append(this.f548642c);
        r100.append(' ');
        WeakReference<a> r101 = this.f548643d;
        if (r101 == null) goto L5;
        a r102 = r101.get();
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(r101.f548640a, this.f548640a) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r101.f548641b, this.f548641b) == true) goto L13;
        return false;
    L13:
        if (r101.f548642c != this.f548642c) goto L26;
        WeakReference<a> r102 = r101.f548643d;
        a r103 = null;
        if (r102 == null) goto L17;
        a r104 = r102.get();
    L18:
        WeakReference<a> r105 = this.f548643d;
        if (r105 == null) goto L21;
        r103 = r105.get();
    L21:
        if (r104 != r103) goto L27;
        return true;
    L27:
        return false;
    L17:
        r104 = null;
        goto L18
    L26:
        return false;
    }

    public h(String r100, String r101, boolean r102, WeakReference<a> r103) {
        Intrinsics.checkNotNullParameter(r100, "mappingStorage");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        this.f548640a = r100;
        this.f548641b = r101;
        this.f548642c = r102;
        this.f548643d = r103;
    }
}
