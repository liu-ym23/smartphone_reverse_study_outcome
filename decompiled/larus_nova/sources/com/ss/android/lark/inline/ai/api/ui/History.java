package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006%"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/History;", "Ljava/io/Serializable;", "show", "", "total", "", "curNum", "leftArrowEnabled", "rightArrowEnabled", "<init>", "(ZIIZZ)V", "getShow", "()Z", "setShow", "(Z)V", "getTotal", "()I", "setTotal", "(I)V", "getCurNum", "setCurNum", "getLeftArrowEnabled", "setLeftArrowEnabled", "getRightArrowEnabled", "setRightArrowEnabled", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class History implements Serializable {
    private int curNum;
    private boolean leftArrowEnabled;
    private boolean rightArrowEnabled;
    private boolean show;
    private int total;

    public static /* synthetic */ History copy$default(History r100, boolean r101, int r102, int r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.total;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.curNum;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.leftArrowEnabled;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.rightArrowEnabled;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.show;
    }

    public final int component2() {
        return this.total;
    }

    public final int component3() {
        return this.curNum;
    }

    public final boolean component4() {
        return this.leftArrowEnabled;
    }

    public final boolean component5() {
        return this.rightArrowEnabled;
    }

    public final History copy(boolean r100, int r101, int r110, boolean r111, boolean r112) {
        return new History(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof History) == true) goto L8;
        return false;
    L8:
        History r101 = (History) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (this.total == r101.total) goto L15;
        return false;
    L15:
        if (this.curNum == r101.curNum) goto L18;
        return false;
    L18:
        if (this.leftArrowEnabled == r101.leftArrowEnabled) goto L21;
        return false;
    L21:
        if (this.rightArrowEnabled == r101.rightArrowEnabled) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.show == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.total) * 31) + this.curNum) * 31;
        if (this.leftArrowEnabled == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.rightArrowEnabled == true) goto L15;
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
        return "History(show=" + this.show + ", total=" + this.total + ", curNum=" + this.curNum + ", leftArrowEnabled=" + this.leftArrowEnabled + ", rightArrowEnabled=" + this.rightArrowEnabled + ')';
    }

    public final int getCurNum() {
        return this.curNum;
    }

    public final boolean getLeftArrowEnabled() {
        return this.leftArrowEnabled;
    }

    public final boolean getRightArrowEnabled() {
        return this.rightArrowEnabled;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setCurNum(int r100) {
        this.curNum = r100;
    }

    public final void setLeftArrowEnabled(boolean r100) {
        this.leftArrowEnabled = r100;
    }

    public final void setRightArrowEnabled(boolean r100) {
        this.rightArrowEnabled = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setTotal(int r100) {
        this.total = r100;
    }

    public History(boolean r100, int r101, int r102, boolean r103, boolean r104) {
        this.show = r100;
        this.total = r101;
        this.curNum = r102;
        this.leftArrowEnabled = r103;
        this.rightArrowEnabled = r104;
    }

    public /* synthetic */ History(boolean r100, int r101, int r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 16) == 0) goto L9;
        boolean r103 = false;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
