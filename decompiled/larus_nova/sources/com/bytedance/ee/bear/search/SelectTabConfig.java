package com.bytedance.ee.bear.search;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/search/SelectTabConfig;", "Ljava/io/Serializable;", "useFolder", "", "useDoc", "useWiki", "<init>", "(ZZZ)V", "getUseFolder", "()Z", "getUseDoc", "getUseWiki", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "contentmanager-search-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectTabConfig implements Serializable {
    private final boolean useDoc;
    private final boolean useFolder;
    private final boolean useWiki;

    public SelectTabConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ SelectTabConfig copy$default(SelectTabConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.useFolder;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.useDoc;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.useWiki;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.useFolder;
    }

    public final boolean component2() {
        return this.useDoc;
    }

    public final boolean component3() {
        return this.useWiki;
    }

    public final SelectTabConfig copy(boolean r100, boolean r101, boolean r102) {
        return new SelectTabConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectTabConfig) == true) goto L8;
        return false;
    L8:
        SelectTabConfig r101 = (SelectTabConfig) r100;
        if (this.useFolder == r101.useFolder) goto L12;
        return false;
    L12:
        if (this.useDoc == r101.useDoc) goto L15;
        return false;
    L15:
        if (this.useWiki == r101.useWiki) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.useFolder == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.useDoc == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.useWiki == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SelectTabConfig(useFolder=" + this.useFolder + ", useDoc=" + this.useDoc + ", useWiki=" + this.useWiki + ')';
    }

    public final boolean getUseDoc() {
        return this.useDoc;
    }

    public final boolean getUseFolder() {
        return this.useFolder;
    }

    public final boolean getUseWiki() {
        return this.useWiki;
    }

    public SelectTabConfig(boolean r100, boolean r101, boolean r102) {
        this.useFolder = r100;
        this.useDoc = r101;
        this.useWiki = r102;
    }

    public /* synthetic */ SelectTabConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
