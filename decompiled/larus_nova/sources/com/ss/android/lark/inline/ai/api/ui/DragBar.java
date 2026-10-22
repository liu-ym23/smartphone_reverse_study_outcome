package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "Ljava/io/Serializable;", "show", "", "doubleConfirm", "<init>", "(ZZ)V", "getShow", "()Z", "setShow", "(Z)V", "getDoubleConfirm", "setDoubleConfirm", "toString", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragBar implements Serializable {
    private boolean doubleConfirm;
    private boolean show;

    public static /* synthetic */ DragBar copy$default(DragBar r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.doubleConfirm;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component2() {
        return this.doubleConfirm;
    }

    public final DragBar copy(boolean r100, boolean r101) {
        return new DragBar(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DragBar) == true) goto L8;
        return false;
    L8:
        DragBar r101 = (DragBar) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (this.doubleConfirm == r101.doubleConfirm) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.show == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.doubleConfirm == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DragBar(show=" + this.show + ", doubleConfirm=" + this.doubleConfirm + ')';
    }

    public final boolean getDoubleConfirm() {
        return this.doubleConfirm;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setDoubleConfirm(boolean r100) {
        this.doubleConfirm = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public DragBar(boolean r100, boolean r101) {
        this.show = r100;
        this.doubleConfirm = r101;
    }
}
