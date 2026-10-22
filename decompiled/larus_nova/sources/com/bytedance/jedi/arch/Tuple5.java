package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u00052\u00020\u0006B-\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\u0006\u0010\t\u001a\u00028\u0002\u0012\u0006\u0010\n\u001a\u00028\u0003\u0012\u0006\u0010\u000b\u001a\u00028\u0004¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0015\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0016\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0017\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0018\u001a\u00028\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ^\u0010\u0019\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00028\u00012\b\b\u0002\u0010\t\u001a\u00028\u00022\b\b\u0002\u0010\n\u001a\u00028\u00032\b\b\u0002\u0010\u000b\u001a\u00028\u0004HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\t\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\n\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u000b\u001a\u00028\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/jedi/arch/Tuple5;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getB", "getC", "getD", "getE", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/jedi/arch/Tuple5;", "equals", "", "other", "hashCode", "", "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tuple5<A, B, C, D, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f250935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f250936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C f250937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final D f250938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final E f250939e;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tuple5 copy$default(Tuple5 r100, Object r101, Object r102, Object r103, Object r104, Object r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f250935a;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.f250936b;
    L8:
        Object r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.f250937c;
    L11:
        Object r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.f250938d;
    L14:
        Object r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.f250939e;
    L17:
        Object r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final A component1() {
        return this.f250935a;
    }

    public final B component2() {
        return this.f250936b;
    }

    public final C component3() {
        return this.f250937c;
    }

    public final D component4() {
        return this.f250938d;
    }

    public final E component5() {
        return this.f250939e;
    }

    public final Tuple5<A, B, C, D, E> copy(A r100, B r101, C r110, D r111, E r112) {
        return new Tuple5(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tuple5) == true) goto L8;
        return false;
    L8:
        Tuple5 r101 = (Tuple5) r100;
        if (Intrinsics.areEqual(this.f250935a, r101.f250935a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250936b, r101.f250936b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f250937c, r101.f250937c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f250938d, r101.f250938d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f250939e, r101.f250939e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        A r100 = this.f250935a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f250936b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f250937c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f250938d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f250939e;
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

    public String toString() {
        return "Tuple5(a=" + this.f250935a + ", b=" + this.f250936b + ", c=" + this.f250937c + ", d=" + this.f250938d + ", e=" + this.f250939e + ')';
    }

    public final A getA() {
        return this.f250935a;
    }

    public final B getB() {
        return this.f250936b;
    }

    public final C getC() {
        return this.f250937c;
    }

    public final D getD() {
        return this.f250938d;
    }

    public final E getE() {
        return this.f250939e;
    }

    public Tuple5(A r100, B r101, C r102, D r103, E r104) {
        this.f250935a = r100;
        this.f250936b = r101;
        this.f250937c = r102;
        this.f250938d = r103;
        this.f250939e = r104;
    }
}
