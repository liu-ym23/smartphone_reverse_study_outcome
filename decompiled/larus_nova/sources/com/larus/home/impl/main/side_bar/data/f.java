package com.larus.home.impl.main.side_bar.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/Divider;", "", "position", "", "type", "blankHeight", "<init>", "(III)V", "getPosition", "()I", "getType", "getBlankHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("blank_height")
    private final int blankHeight;

    @SerializedName("position")
    private final int position;

    @SerializedName("type")
    private final int type;

    public f() {
        this(0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.position == r101.position) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.blankHeight == r101.blankHeight) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.position * 31) + this.type) * 31) + this.blankHeight;
    }

    public final String toString() {
        return "Divider(position=" + this.position + ", type=" + this.type + ", blankHeight=" + this.blankHeight + ')';
    }

    public final int a() {
        return this.blankHeight;
    }

    public final int b() {
        return this.position;
    }

    public final int getType() {
        return this.type;
    }

    public f(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = DividerPositionEnum.BOTTOM.getPosition();
    L6:
        if ((r101 & 2) == 0) goto L8;
        int r102 = DividerTypeEnum.LINE.getType();
    L9:
        this.position = r100;
        this.type = r102;
        this.blankHeight = 0;
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
