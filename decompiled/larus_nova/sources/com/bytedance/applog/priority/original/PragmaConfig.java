package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applog/priority/original/PragmaConfig;", "", "connectLimitAll", "", "connectLimitLow", "closeSynchronous", "mmapSize", "", "checkpointLimit", "", "(ZZZJI)V", "getCheckpointLimit", "()I", "getCloseSynchronous", "()Z", "getConnectLimitAll", "getConnectLimitLow", "getMmapSize", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PragmaConfig {
    private final int checkpointLimit;
    private final boolean closeSynchronous;
    private final boolean connectLimitAll;
    private final boolean connectLimitLow;
    private final long mmapSize;

    public PragmaConfig() {
        this(false, false, false, 0, 0, 31, null);
    }

    public static /* synthetic */ PragmaConfig copy$default(PragmaConfig r100, boolean r101, boolean r102, boolean r103, long r104, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.connectLimitAll;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.connectLimitLow;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.closeSynchronous;
    L11:
        boolean r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.mmapSize;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.checkpointLimit;
    L17:
        boolean r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final boolean component1() {
        return this.connectLimitAll;
    }

    public final boolean component2() {
        return this.connectLimitLow;
    }

    public final boolean component3() {
        return this.closeSynchronous;
    }

    public final long component4() {
        return this.mmapSize;
    }

    public final int component5() {
        return this.checkpointLimit;
    }

    public final PragmaConfig copy(boolean r100, boolean r110, boolean r111, long r112, int r113) {
        return new PragmaConfig(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PragmaConfig) == true) goto L8;
        return false;
    L8:
        PragmaConfig r101 = (PragmaConfig) r100;
        if (this.connectLimitAll == r101.connectLimitAll) goto L12;
        return false;
    L12:
        if (this.connectLimitLow == r101.connectLimitLow) goto L15;
        return false;
    L15:
        if (this.closeSynchronous == r101.closeSynchronous) goto L18;
        return false;
    L18:
        if (this.mmapSize == r101.mmapSize) goto L21;
        return false;
    L21:
        if (this.checkpointLimit == r101.checkpointLimit) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        boolean r100 = this.connectLimitAll;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.connectLimitLow;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.closeSynchronous;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        long r109 = this.mmapSize;
        return ((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.checkpointLimit;
    }

    public String toString() {
        return "PragmaConfig(connectLimitAll=" + this.connectLimitAll + ", connectLimitLow=" + this.connectLimitLow + ", closeSynchronous=" + this.closeSynchronous + ", mmapSize=" + this.mmapSize + ", checkpointLimit=" + this.checkpointLimit + ')';
    }

    public final int getCheckpointLimit() {
        return this.checkpointLimit;
    }

    public final boolean getCloseSynchronous() {
        return this.closeSynchronous;
    }

    public final boolean getConnectLimitAll() {
        return this.connectLimitAll;
    }

    public final boolean getConnectLimitLow() {
        return this.connectLimitLow;
    }

    public final long getMmapSize() {
        return this.mmapSize;
    }

    public PragmaConfig(boolean r100, boolean r101, boolean r102, long r103, int r104) {
        this.connectLimitAll = r100;
        this.connectLimitLow = r101;
        this.closeSynchronous = r102;
        this.mmapSize = r103;
        this.checkpointLimit = r104;
    }

    public /* synthetic */ PragmaConfig(boolean r100, boolean r101, boolean r102, long r103, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r111 & 4) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r111 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        long r106 = r103;
        if ((r111 & 16) == 0) goto L20;
        int r114 = 0;
    L21:
        this(r113, r104, r105, r106, r114);
        return;
    L20:
        r114 = r110;
        goto L21
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
