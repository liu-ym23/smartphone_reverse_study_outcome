package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005B%\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002\u0012\u0006\u0010\t\u001a\u00028\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\fJN\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u00022\b\b\u0002\u0010\t\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\t\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/jedi/arch/Tuple4;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getB", "getC", "getD", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/jedi/arch/Tuple4;", "equals", "", "other", "hashCode", "", "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tuple4<A, B, C, D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f250931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f250932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C f250933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final D f250934d;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tuple4 copy$default(Tuple4 r100, Object r101, Object r102, Object r103, Object r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f250931a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f250932b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f250933c;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.f250934d;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final A component1() {
        return this.f250931a;
    }

    public final B component2() {
        return this.f250932b;
    }

    public final C component3() {
        return this.f250933c;
    }

    public final D component4() {
        return this.f250934d;
    }

    public final Tuple4<A, B, C, D> copy(A r100, B r101, C r102, D r103) {
        return new Tuple4(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tuple4) == true) goto L8;
        return false;
    L8:
        Tuple4 r101 = (Tuple4) r100;
        if (Intrinsics.areEqual(this.f250931a, r101.f250931a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250932b, r101.f250932b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f250933c, r101.f250933c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f250934d, r101.f250934d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        A r100 = this.f250931a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f250932b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f250933c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f250934d;
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

    public String toString() {
        return "Tuple4(a=" + this.f250931a + ", b=" + this.f250932b + ", c=" + this.f250933c + ", d=" + this.f250934d + ')';
    }

    public final A getA() {
        return this.f250931a;
    }

    public final B getB() {
        return this.f250932b;
    }

    public final C getC() {
        return this.f250933c;
    }

    public final D getD() {
        return this.f250934d;
    }

    public Tuple4(A r100, B r101, C r102, D r103) {
        this.f250931a = r100;
        this.f250932b = r101;
        this.f250933c = r102;
        this.f250934d = r103;
    }
}
