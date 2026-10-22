package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00028\u0002¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u0010\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/jedi/arch/Tuple3;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getB", "getC", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/jedi/arch/Tuple3;", "equals", "", "other", "hashCode", "", "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tuple3<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f250928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f250929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C f250930c;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tuple3 copy$default(Tuple3 r100, Object r101, Object r102, Object r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f250928a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f250929b;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f250930c;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final A component1() {
        return this.f250928a;
    }

    public final B component2() {
        return this.f250929b;
    }

    public final C component3() {
        return this.f250930c;
    }

    public final Tuple3<A, B, C> copy(A r100, B r101, C r102) {
        return new Tuple3(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tuple3) == true) goto L8;
        return false;
    L8:
        Tuple3 r101 = (Tuple3) r100;
        if (Intrinsics.areEqual(this.f250928a, r101.f250928a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250929b, r101.f250929b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f250930c, r101.f250930c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        A r100 = this.f250928a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f250929b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f250930c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Tuple3(a=" + this.f250928a + ", b=" + this.f250929b + ", c=" + this.f250930c + ')';
    }

    public final A getA() {
        return this.f250928a;
    }

    public final B getB() {
        return this.f250929b;
    }

    public final C getC() {
        return this.f250930c;
    }

    public Tuple3(A r100, B r101, C r102) {
        this.f250928a = r100;
        this.f250929b = r101;
        this.f250930c = r102;
    }
}
