package com.bytedance.locallife.cube.api.model;

import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kp6.f;

/* JADX INFO: loaded from: classes21.dex */
@Deprecated(message = "use CubeConfig instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/LynxLayoutParams;", "", "widthSize", "", "widthSpecMode", "heightSize", "heightSpecMode", "(IIII)V", "getHeightSize", "()I", "setHeightSize", "(I)V", "getHeightSpecMode", "setHeightSpecMode", "getWidthSize", "setWidthSize", "getWidthSpecMode", "setWidthSpecMode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "heightSpec", "toString", "", "widthSpec", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LynxLayoutParams {
    private int heightSize;
    private int heightSpecMode;
    private int widthSize;
    private int widthSpecMode;

    public LynxLayoutParams() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ LynxLayoutParams copy$default(LynxLayoutParams r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.widthSize;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.widthSpecMode;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.heightSize;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.heightSpecMode;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.widthSize;
    }

    public final int component2() {
        return this.widthSpecMode;
    }

    public final int component3() {
        return this.heightSize;
    }

    public final int component4() {
        return this.heightSpecMode;
    }

    public final LynxLayoutParams copy(int r100, int r101, int r102, int r103) {
        return new LynxLayoutParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LynxLayoutParams) == true) goto L8;
        return false;
    L8:
        LynxLayoutParams r101 = (LynxLayoutParams) r100;
        if (this.widthSize == r101.widthSize) goto L12;
        return false;
    L12:
        if (this.widthSpecMode == r101.widthSpecMode) goto L15;
        return false;
    L15:
        if (this.heightSize == r101.heightSize) goto L18;
        return false;
    L18:
        if (this.heightSpecMode == r101.heightSpecMode) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.widthSize * 31) + this.widthSpecMode) * 31) + this.heightSize) * 31) + this.heightSpecMode;
    }

    public String toString() {
        return "LynxLayoutParams(widthSize=" + this.widthSize + ", widthSpecMode=" + this.widthSpecMode + ", heightSize=" + this.heightSize + ", heightSpecMode=" + this.heightSpecMode + ')';
    }

    public final int heightSpec() {
        return View.MeasureSpec.makeMeasureSpec(this.heightSize, this.heightSpecMode);
    }

    public final int widthSpec() {
        return View.MeasureSpec.makeMeasureSpec(this.widthSize, this.widthSpecMode);
    }

    public final int getHeightSize() {
        return this.heightSize;
    }

    public final int getHeightSpecMode() {
        return this.heightSpecMode;
    }

    public final int getWidthSize() {
        return this.widthSize;
    }

    public final int getWidthSpecMode() {
        return this.widthSpecMode;
    }

    public final void setHeightSize(int r100) {
        this.heightSize = r100;
    }

    public final void setHeightSpecMode(int r100) {
        this.heightSpecMode = r100;
    }

    public final void setWidthSize(int r100) {
        this.widthSize = r100;
    }

    public final void setWidthSpecMode(int r100) {
        this.widthSpecMode = r100;
    }

    public LynxLayoutParams(int r100, int r101, int r102, int r103) {
        this.widthSize = r100;
        this.widthSpecMode = r101;
        this.heightSize = r102;
        this.heightSpecMode = r103;
    }

    public /* synthetic */ LynxLayoutParams(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = f.b();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1073741824;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
