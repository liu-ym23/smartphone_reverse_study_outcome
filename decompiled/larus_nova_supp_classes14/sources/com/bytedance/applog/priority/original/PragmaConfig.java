package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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

    public static /* synthetic */ PragmaConfig copy$default(PragmaConfig r4, boolean r5, boolean r6, boolean r7, long r8, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.connectLimitAll;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.connectLimitLow;
    L8:
        boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.closeSynchronous;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.mmapSize;
    L14:
        long r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.checkpointLimit;
    L17:
        boolean r9 = r5;
        return r4.copy(r9, r13, r0, r1, r10);
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

    public final PragmaConfig copy(boolean r9, boolean r10, boolean r11, long r12, int r14) {
        return new PragmaConfig(r9, r10, r11, r12, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof PragmaConfig) == true) goto L8;
        return false;
    L8:
        PragmaConfig r9 = (PragmaConfig) r8;
        if (this.connectLimitAll == r9.connectLimitAll) goto L12;
        return false;
    L12:
        if (this.connectLimitLow == r9.connectLimitLow) goto L15;
        return false;
    L15:
        if (this.closeSynchronous == r9.closeSynchronous) goto L18;
        return false;
    L18:
        if (this.mmapSize == r9.mmapSize) goto L21;
        return false;
    L21:
        if (this.checkpointLimit == r9.checkpointLimit) goto L23;
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
        boolean r0 = this.connectLimitAll;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.connectLimitLow;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.closeSynchronous;
        if (r7 == true) goto L12;
        r1 = r7;
    L12:
        int r8 = (r6 + r1) * 31;
        long r9 = this.mmapSize;
        return ((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.checkpointLimit;
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

    public PragmaConfig(boolean r1, boolean r2, boolean r3, long r4, int r6) {
        this.connectLimitAll = r1;
        this.connectLimitLow = r2;
        this.closeSynchronous = r3;
        this.mmapSize = r4;
        this.checkpointLimit = r6;
    }

    public /* synthetic */ PragmaConfig(boolean r6, boolean r7, boolean r8, long r9, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        boolean r14 = false;
    L7:
        if ((r12 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r12 & 4) == 0) goto L13;
        boolean r2 = false;
    L15:
        if ((r12 & 8) == 0) goto L17;
        r9 = 0;
    L17:
        long r3 = r9;
        if ((r12 & 16) == 0) goto L20;
        int r15 = 0;
    L21:
        this(r14, r1, r2, r3, r15);
        return;
    L20:
        r15 = r11;
        goto L21
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
