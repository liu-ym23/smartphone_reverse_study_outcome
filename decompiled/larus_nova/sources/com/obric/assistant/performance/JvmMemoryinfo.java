package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/performance/JvmMemoryinfo;", "", "jvmLeakThreshold", "", "jvmMaxMemory", "", "jvmUsedMemory", "jvmTotalMemory", "<init>", "(Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getJvmLeakThreshold", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getJvmMaxMemory", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getJvmUsedMemory", "getJvmTotalMemory", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/assistant/performance/JvmMemoryinfo;", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JvmMemoryinfo {
    private final Float jvmLeakThreshold;
    private final Long jvmMaxMemory;
    private final Long jvmTotalMemory;
    private final Long jvmUsedMemory;

    public static /* synthetic */ JvmMemoryinfo copy$default(JvmMemoryinfo r100, Float r101, Long r102, Long r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.jvmLeakThreshold;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.jvmMaxMemory;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.jvmUsedMemory;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.jvmTotalMemory;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Float component1() {
        return this.jvmLeakThreshold;
    }

    public final Long component2() {
        return this.jvmMaxMemory;
    }

    public final Long component3() {
        return this.jvmUsedMemory;
    }

    public final Long component4() {
        return this.jvmTotalMemory;
    }

    public final JvmMemoryinfo copy(Float r100, Long r101, Long r102, Long r103) {
        return new JvmMemoryinfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JvmMemoryinfo) == true) goto L8;
        return false;
    L8:
        JvmMemoryinfo r101 = (JvmMemoryinfo) r100;
        if (Intrinsics.areEqual(this.jvmLeakThreshold, r101.jvmLeakThreshold) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jvmMaxMemory, r101.jvmMaxMemory) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jvmUsedMemory, r101.jvmUsedMemory) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jvmTotalMemory, r101.jvmTotalMemory) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Float r100 = this.jvmLeakThreshold;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.jvmMaxMemory;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.jvmUsedMemory;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.jvmTotalMemory;
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
        return "JvmMemoryinfo(jvmLeakThreshold=" + this.jvmLeakThreshold + ", jvmMaxMemory=" + this.jvmMaxMemory + ", jvmUsedMemory=" + this.jvmUsedMemory + ", jvmTotalMemory=" + this.jvmTotalMemory + ')';
    }

    public final Float getJvmLeakThreshold() {
        return this.jvmLeakThreshold;
    }

    public final Long getJvmMaxMemory() {
        return this.jvmMaxMemory;
    }

    public final Long getJvmTotalMemory() {
        return this.jvmTotalMemory;
    }

    public final Long getJvmUsedMemory() {
        return this.jvmUsedMemory;
    }

    public JvmMemoryinfo(Float r100, Long r101, Long r102, Long r103) {
        this.jvmLeakThreshold = r100;
        this.jvmMaxMemory = r101;
        this.jvmUsedMemory = r102;
        this.jvmTotalMemory = r103;
    }
}
