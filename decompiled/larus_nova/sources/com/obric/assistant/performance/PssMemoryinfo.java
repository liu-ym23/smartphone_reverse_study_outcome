package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/performance/PssMemoryinfo;", "", "pssLeakThreshold", "", "totalPss", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPssLeakThreshold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalPss", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/performance/PssMemoryinfo;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PssMemoryinfo {
    private final Integer pssLeakThreshold;
    private final Integer totalPss;

    public static /* synthetic */ PssMemoryinfo copy$default(PssMemoryinfo r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pssLeakThreshold;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.totalPss;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.pssLeakThreshold;
    }

    public final Integer component2() {
        return this.totalPss;
    }

    public final PssMemoryinfo copy(Integer r100, Integer r101) {
        return new PssMemoryinfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PssMemoryinfo) == true) goto L8;
        return false;
    L8:
        PssMemoryinfo r101 = (PssMemoryinfo) r100;
        if (Intrinsics.areEqual(this.pssLeakThreshold, r101.pssLeakThreshold) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.totalPss, r101.totalPss) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.pssLeakThreshold;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.totalPss;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PssMemoryinfo(pssLeakThreshold=" + this.pssLeakThreshold + ", totalPss=" + this.totalPss + ')';
    }

    public final Integer getPssLeakThreshold() {
        return this.pssLeakThreshold;
    }

    public final Integer getTotalPss() {
        return this.totalPss;
    }

    public PssMemoryinfo(Integer r100, Integer r101) {
        this.pssLeakThreshold = r100;
        this.totalPss = r101;
    }
}
