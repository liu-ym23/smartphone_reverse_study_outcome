package com.relax.runtime.gen;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/relax/runtime/gen/PageConfig;", "", "enableFlatten", "", "enableLayoutOnly", "(ZZ)V", "getEnableFlatten", "()Z", "setEnableFlatten", "(Z)V", "getEnableLayoutOnly", "setEnableLayoutOnly", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageConfig {
    private boolean enableFlatten;
    private boolean enableLayoutOnly;

    public static /* synthetic */ PageConfig copy$default(PageConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enableFlatten;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableLayoutOnly;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enableFlatten;
    }

    public final boolean component2() {
        return this.enableLayoutOnly;
    }

    public final PageConfig copy(boolean r100, boolean r101) {
        return new PageConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PageConfig) == true) goto L8;
        return false;
    L8:
        PageConfig r101 = (PageConfig) r100;
        if (this.enableFlatten == r101.enableFlatten) goto L12;
        return false;
    L12:
        if (this.enableLayoutOnly == r101.enableLayoutOnly) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.enableFlatten;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enableLayoutOnly;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public String toString() {
        return "PageConfig(enableFlatten=" + this.enableFlatten + ", enableLayoutOnly=" + this.enableLayoutOnly + ')';
    }

    public final boolean getEnableFlatten() {
        return this.enableFlatten;
    }

    public final boolean getEnableLayoutOnly() {
        return this.enableLayoutOnly;
    }

    public final void setEnableFlatten(boolean r100) {
        this.enableFlatten = r100;
    }

    public final void setEnableLayoutOnly(boolean r100) {
        this.enableLayoutOnly = r100;
    }

    public PageConfig(boolean r100, boolean r101) {
        this.enableFlatten = r100;
        this.enableLayoutOnly = r101;
    }
}
