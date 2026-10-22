package com.bytedance.locallife.cube.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/FileLoadOptions;", "", "checkUpdate", "", "waitGeckoUpdate", "(ZZ)V", "getCheckUpdate", "()Z", "getWaitGeckoUpdate", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FileLoadOptions {
    private final boolean checkUpdate;
    private final boolean waitGeckoUpdate;

    public FileLoadOptions() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ FileLoadOptions copy$default(FileLoadOptions r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.checkUpdate;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.waitGeckoUpdate;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.checkUpdate;
    }

    public final boolean component2() {
        return this.waitGeckoUpdate;
    }

    public final FileLoadOptions copy(boolean r100, boolean r101) {
        return new FileLoadOptions(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileLoadOptions) == true) goto L8;
        return false;
    L8:
        FileLoadOptions r101 = (FileLoadOptions) r100;
        if (this.checkUpdate == r101.checkUpdate) goto L12;
        return false;
    L12:
        if (this.waitGeckoUpdate == r101.waitGeckoUpdate) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.checkUpdate == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.waitGeckoUpdate == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "FileLoadOptions(checkUpdate=" + this.checkUpdate + ", waitGeckoUpdate=" + this.waitGeckoUpdate + ')';
    }

    public final boolean getCheckUpdate() {
        return this.checkUpdate;
    }

    public final boolean getWaitGeckoUpdate() {
        return this.waitGeckoUpdate;
    }

    public FileLoadOptions(boolean r100, boolean r101) {
        this.checkUpdate = r100;
        this.waitGeckoUpdate = r101;
    }

    public /* synthetic */ FileLoadOptions(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
