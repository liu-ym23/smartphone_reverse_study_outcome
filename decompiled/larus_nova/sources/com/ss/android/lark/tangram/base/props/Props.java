package com.ss.android.lark.tangram.base.props;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020\u0000H\u0016J\u0013\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010=H\u0096\u0002J\b\u0010>\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102¨\u0006?"}, d2 = {"Lcom/ss/android/lark/tangram/base/props/Props;", "Ljava/io/Serializable;", "<init>", "()V", "paddingLeft", "", "getPaddingLeft", "()I", "setPaddingLeft", "(I)V", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingTop", "getPaddingTop", "setPaddingTop", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "marginBottom", "getMarginBottom", "setMarginBottom", "backgroundColor", "getBackgroundColor", "()Ljava/lang/Integer;", "setBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "backGroundResId", "getBackGroundResId", "setBackGroundResId", "isDataChange", "", "()Z", "setDataChange", "(Z)V", "forceUpdateLayout", "getForceUpdateLayout", "setForceUpdateLayout", "applyToView", "", "view", "Landroid/view/View;", "clone", "equals", "other", "", "hashCode", "tangram-component_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Props implements Serializable {
    private Integer backGroundResId;
    private Integer backgroundColor;
    private Drawable backgroundDrawable;
    private boolean forceUpdateLayout;
    private boolean isDataChange;
    private int marginBottom;
    private int marginLeft;
    private int marginRight;
    private int marginTop;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;

    public Props() {
    }

    public Props clone() {
        Props r100 = new Props();
        r100.marginLeft = this.marginLeft;
        r100.marginRight = this.marginRight;
        r100.marginTop = this.marginTop;
        r100.marginBottom = this.marginBottom;
        r100.paddingBottom = this.paddingBottom;
        r100.paddingLeft = this.paddingLeft;
        r100.paddingRight = this.paddingRight;
        r100.paddingTop = this.paddingTop;
        r100.forceUpdateLayout = this.forceUpdateLayout;
        return r100;
    }

    public int hashCode() {
        int r100 = ((((((((((((((this.paddingLeft * 31) + this.paddingRight) * 31) + this.paddingTop) * 31) + this.paddingBottom) * 31) + this.marginLeft) * 31) + this.marginRight) * 31) + this.marginTop) * 31) + this.marginBottom) * 31;
        Integer r101 = this.backgroundColor;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        int r104 = (r100 + r103) * 31;
        Drawable r105 = this.backgroundDrawable;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.isDataChange == false) goto L12;
        int r108 = 1231;
    L13:
        int r109 = (r106 + r108) * 31;
        if (this.forceUpdateLayout == true) goto L18;
        r107 = 1237;
    L18:
        return r109 + r107;
    L12:
        r108 = 1237;
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public final Integer getBackGroundResId() {
        return this.backGroundResId;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final boolean getForceUpdateLayout() {
        return this.forceUpdateLayout;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    public final int getPaddingRight() {
        return this.paddingRight;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final boolean isDataChange() {
        return this.isDataChange;
    }

    public final void applyToView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Integer r101 = this.backgroundColor;
        if (r101 == null) goto L5;
        r101.intValue();
        Integer r102 = this.backgroundColor;
        Intrinsics.checkNotNull(r102);
        r100.setBackgroundColor(r102.intValue());
    L5:
        Drawable r103 = this.backgroundDrawable;
        if (r103 == null) goto L8;
        r100.setBackgroundDrawable(r103);
    L8:
        Integer r104 = this.backGroundResId;
        if (r104 == null) goto L12;
        r104.intValue();
        Integer r105 = this.backGroundResId;
        Intrinsics.checkNotNull(r105);
        r100.setBackgroundResource(r105.intValue());
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Props) == true) goto L8;
        return false;
    L8:
        Props r101 = (Props) r100;
        if (this.paddingLeft == r101.paddingLeft) goto L12;
        return false;
    L12:
        if (this.paddingRight == r101.paddingRight) goto L15;
        return false;
    L15:
        if (this.paddingTop == r101.paddingTop) goto L18;
        return false;
    L18:
        if (this.paddingBottom == r101.paddingBottom) goto L21;
        return false;
    L21:
        if (this.marginLeft == r101.marginLeft) goto L24;
        return false;
    L24:
        if (this.marginRight == r101.marginRight) goto L27;
        return false;
    L27:
        if (this.marginTop == r101.marginTop) goto L30;
        return false;
    L30:
        if (this.marginBottom == r101.marginBottom) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.backgroundDrawable, r101.backgroundDrawable) == true) goto L39;
        return false;
    L39:
        if (this.isDataChange == r101.isDataChange) goto L42;
        return false;
    L42:
        if (this.forceUpdateLayout == r101.forceUpdateLayout) goto L44;
        return false;
    L44:
        return true;
    }

    public final void setBackGroundResId(Integer r100) {
        this.backGroundResId = r100;
    }

    public final void setBackgroundColor(Integer r100) {
        this.backgroundColor = r100;
    }

    public final void setBackgroundDrawable(Drawable r100) {
        this.backgroundDrawable = r100;
    }

    public final void setDataChange(boolean r100) {
        this.isDataChange = r100;
    }

    public final void setForceUpdateLayout(boolean r100) {
        this.forceUpdateLayout = r100;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setMarginLeft(int r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(int r100) {
        this.marginRight = r100;
    }

    public final void setMarginTop(int r100) {
        this.marginTop = r100;
    }

    public final void setPaddingBottom(int r100) {
        this.paddingBottom = r100;
    }

    public final void setPaddingLeft(int r100) {
        this.paddingLeft = r100;
    }

    public final void setPaddingRight(int r100) {
        this.paddingRight = r100;
    }

    public final void setPaddingTop(int r100) {
        this.paddingTop = r100;
    }
}
