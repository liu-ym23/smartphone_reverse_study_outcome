package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/jedi/arch/Tuple1;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/bytedance/jedi/arch/Tuple1;", "equals", "", "other", "hashCode", "", "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tuple1<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f250925a;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tuple1 copy$default(Tuple1 r100, Object r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.f250925a;
    L6:
        return r100.copy(r101);
    }

    public final A component1() {
        return this.f250925a;
    }

    public final Tuple1<A> copy(A r100) {
        return new Tuple1(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tuple1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f250925a, ((Tuple1) r100).f250925a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        A r100 = this.f250925a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "Tuple1(a=" + this.f250925a + ')';
    }

    public final A getA() {
        return this.f250925a;
    }

    public Tuple1(A r100) {
        this.f250925a = r100;
    }
}
