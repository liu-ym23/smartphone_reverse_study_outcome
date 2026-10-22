package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0000J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Border;", "Ljava/io/Serializable;", "width", "", "cornerRadius", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCornerRadius", "setCornerRadius", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setThemeColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "clone", "equals", "", "other", "", "hashCode", "", "component1", "component2", "component3", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)Lcom/ss/android/lark/export/entity/preview/Border;", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Border implements Serializable {
    private Float cornerRadius;
    private ThemeColor themeColor;
    private Float width;

    public Border() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Border copy$default(Border r100, Float r101, Float r102, ThemeColor r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.cornerRadius;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.themeColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Float component1() {
        return this.width;
    }

    public final Float component2() {
        return this.cornerRadius;
    }

    public final ThemeColor component3() {
        return this.themeColor;
    }

    public final Border copy(Float r100, Float r101, ThemeColor r102) {
        return new Border(r100, r101, r102);
    }

    public String toString() {
        return "Border(width=" + this.width + ", cornerRadius=" + this.cornerRadius + ", themeColor=" + this.themeColor + ')';
    }

    public final Border clone() {
        Float r100 = this.width;
        Float r101 = this.cornerRadius;
        ThemeColor r102 = this.themeColor;
        if (r102 == null) goto L5;
        ThemeColor r103 = r102.clone();
    L7:
        return new Border(r100, r101, r103);
    L5:
        r103 = null;
        goto L7
    }

    public int hashCode() {
        Float r100 = this.width;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.cornerRadius;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ThemeColor r107 = this.themeColor;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final Float getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Border) == true) goto L8;
        return false;
    L8:
        Border r101 = (Border) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cornerRadius, r101.cornerRadius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.themeColor, r101.themeColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setCornerRadius(Float r100) {
        this.cornerRadius = r100;
    }

    public final void setThemeColor(ThemeColor r100) {
        this.themeColor = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }

    public Border(Float r100, Float r101, ThemeColor r102) {
        this.width = r100;
        this.cornerRadius = r101;
        this.themeColor = r102;
    }

    public /* synthetic */ Border(Float r100, Float r101, ThemeColor r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
