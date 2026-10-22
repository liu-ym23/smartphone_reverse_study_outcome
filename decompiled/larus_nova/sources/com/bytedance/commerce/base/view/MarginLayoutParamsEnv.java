package com.bytedance.commerce.base.view;

import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR$\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\f¨\u0006%"}, d2 = {"Lcom/bytedance/commerce/base/view/MarginLayoutParamsEnv;", "", "Landroid/view/ViewGroup$LayoutParams;", PickerReporterConstants.KEY.TARGET, "Landroid/view/ViewGroup$LayoutParams;", "getTarget", "()Landroid/view/ViewGroup$LayoutParams;", "", "value", "getWidth", "()I", "setWidth", "(I)V", "width", "getHeight", "setHeight", "height", "getMarginLeft", "setMarginLeft", "marginLeft", "getMarginStart", "setMarginStart", "marginStart", "getMarginTop", "setMarginTop", "marginTop", "getMarginRight", "setMarginRight", "marginRight", "getMarginEnd", "setMarginEnd", "marginEnd", "getMarginBottom", "setMarginBottom", "marginBottom", "<init>", "(Landroid/view/ViewGroup$LayoutParams;)V", "base_release"}, k = 1, mv = {1, 4, 0})
public class MarginLayoutParamsEnv {
    private final ViewGroup.LayoutParams target;

    public int getHeight() {
        return getTarget().height;
    }

    public int getMarginBottom() {
        ViewGroup.LayoutParams r100 = getTarget();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.bottomMargin;
    }

    public int getMarginEnd() {
        ViewGroup.LayoutParams r100 = getTarget();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return MarginLayoutParamsCompat.getMarginEnd(r101);
    }

    public int getMarginLeft() {
        ViewGroup.LayoutParams r100 = getTarget();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.leftMargin;
    }

    public int getMarginRight() {
        ViewGroup.LayoutParams r100 = getTarget();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.rightMargin;
    }

    public int getMarginStart() {
        ViewGroup.LayoutParams r100 = getTarget();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return MarginLayoutParamsCompat.getMarginStart(r101);
    }

    public int getMarginTop() {
        ViewGroup.LayoutParams r100 = getTarget();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.topMargin;
    }

    public int getWidth() {
        return getTarget().width;
    }

    public ViewGroup.LayoutParams getTarget() {
        return this.target;
    }

    public MarginLayoutParamsEnv(ViewGroup.LayoutParams r100) {
        this.target = r100;
    }

    public void setHeight(int r100) {
        getTarget().height = r100;
    }

    public void setMarginBottom(int r100) {
        ViewGroup.LayoutParams r101 = getTarget();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        r102.bottomMargin = r100;
        return;
    }

    public void setMarginEnd(int r100) {
        ViewGroup.LayoutParams r101 = getTarget();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        MarginLayoutParamsCompat.setMarginEnd(r102, r100);
        return;
    }

    public void setMarginLeft(int r100) {
        ViewGroup.LayoutParams r101 = getTarget();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        r102.leftMargin = r100;
        return;
    }

    public void setMarginRight(int r100) {
        ViewGroup.LayoutParams r101 = getTarget();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        r102.rightMargin = r100;
        return;
    }

    public void setMarginStart(int r100) {
        ViewGroup.LayoutParams r101 = getTarget();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        MarginLayoutParamsCompat.setMarginStart(r102, r100);
        return;
    }

    public void setMarginTop(int r100) {
        ViewGroup.LayoutParams r101 = getTarget();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        r102.topMargin = r100;
        return;
    }

    public void setWidth(int r100) {
        getTarget().width = r100;
    }
}
