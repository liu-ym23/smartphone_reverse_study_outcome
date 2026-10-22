package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class v implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f474447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f474448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f474449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u f474450d;

    public v() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474447a, r101.f474447a) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474448b, r101.f474448b) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474449c, r101.f474449c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474450d, r101.f474450d) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        s r100 = this.f474447a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 0) * 31;
        t r104 = this.f474448b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        u r107 = this.f474449c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        u r110 = this.f474450d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ShelfProductMarketingUIData(propsUIData=null, style1UIData=" + this.f474447a + ", style2UIData=" + this.f474448b + ", style3UIData=" + this.f474449c + ", style4UIData=" + this.f474450d + ')';
    }

    public v(int r100) {
        this.f474447a = null;
        this.f474448b = null;
        this.f474449c = null;
        this.f474450d = null;
    }

    public final void a(s r100) {
        this.f474447a = r100;
    }

    public final void b(t r100) {
        this.f474448b = r100;
    }

    public final void c(u r100) {
        this.f474449c = r100;
    }

    public final void d(u r100) {
        this.f474450d = r100;
    }
}
