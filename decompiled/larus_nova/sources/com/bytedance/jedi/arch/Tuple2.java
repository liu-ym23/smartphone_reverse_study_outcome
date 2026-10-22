package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/jedi/arch/Tuple2;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getB", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/jedi/arch/Tuple2;", "equals", "", "other", "hashCode", "", "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tuple2<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f250926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f250927b;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tuple2 copy$default(Tuple2 r100, Object r101, Object r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f250926a;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f250927b;
    L9:
        return r100.copy(r101, r102);
    }

    public final A component1() {
        return this.f250926a;
    }

    public final B component2() {
        return this.f250927b;
    }

    public final Tuple2<A, B> copy(A r100, B r101) {
        return new Tuple2(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tuple2) == true) goto L8;
        return false;
    L8:
        Tuple2 r101 = (Tuple2) r100;
        if (Intrinsics.areEqual(this.f250926a, r101.f250926a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250927b, r101.f250927b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        A r100 = this.f250926a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f250927b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Tuple2(a=" + this.f250926a + ", b=" + this.f250927b + ')';
    }

    public final A getA() {
        return this.f250926a;
    }

    public final B getB() {
        return this.f250927b;
    }

    public Tuple2(A r100, B r101) {
        this.f250926a = r100;
        this.f250927b = r101;
    }
}
