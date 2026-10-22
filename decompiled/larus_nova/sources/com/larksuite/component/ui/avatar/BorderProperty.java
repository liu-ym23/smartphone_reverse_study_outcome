package com.larksuite.component.ui.avatar;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0007J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/avatar/BorderProperty;", "Ljava/io/Serializable;", "borderColor", "", "borderWidthPx", "borderRadiusPx", "<init>", "(III)V", "equals", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "hashCode", "getBorderColor", "getBorderWidthPx", "getBorderRadiusPx", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderProperty implements Serializable {
    private int borderColor;
    private int borderRadiusPx;
    private int borderWidthPx;

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.borderColor), Integer.valueOf(this.borderWidthPx), Integer.valueOf(this.borderRadiusPx)});
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderRadiusPx() {
        return this.borderRadiusPx;
    }

    public final int getBorderWidthPx() {
        return this.borderWidthPx;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BorderProperty) == true) goto L8;
        return false;
    L8:
        BorderProperty r101 = (BorderProperty) r100;
        if (this.borderWidthPx == r101.borderWidthPx) goto L11;
    L15:
        return false;
    L11:
        if (this.borderRadiusPx != r101.borderRadiusPx) goto L15;
        if (this.borderColor != r101.borderColor) goto L15;
        return true;
    }

    public BorderProperty(int r100, int r101, int r102) {
        this.borderColor = r100;
        this.borderWidthPx = r101;
        this.borderRadiusPx = r102;
    }
}
