package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0000J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/KeyTag;", "Ljava/io/Serializable;", "tag", "", "textColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "backgroundColor", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getTag", "()Ljava/lang/String;", "getTextColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getBackgroundColor", "clone", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyTag implements Serializable {
    private final ThemeColor backgroundColor;
    private final String tag;
    private final ThemeColor textColor;

    public static /* synthetic */ KeyTag copy$default(KeyTag r100, String r101, ThemeColor r102, ThemeColor r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tag;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.textColor;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.backgroundColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.tag;
    }

    public final ThemeColor component2() {
        return this.textColor;
    }

    public final ThemeColor component3() {
        return this.backgroundColor;
    }

    public final KeyTag copy(String r100, ThemeColor r101, ThemeColor r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return new KeyTag(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KeyTag) == true) goto L8;
        return false;
    L8:
        KeyTag r101 = (KeyTag) r100;
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.tag.hashCode() * 31;
        ThemeColor r101 = this.textColor;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ThemeColor r105 = this.backgroundColor;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "KeyTag(tag=" + this.tag + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ')';
    }

    public final KeyTag clone() {
        String r100 = this.tag;
        ThemeColor r101 = this.textColor;
        ThemeColor r102 = null;
        if (r101 == null) goto L5;
        ThemeColor r103 = r101.clone();
    L6:
        ThemeColor r104 = this.backgroundColor;
        if (r104 == null) goto L10;
        r102 = r104.clone();
    L10:
        return new KeyTag(r100, r103, r102);
    L5:
        r103 = null;
        goto L6
    }

    public final ThemeColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getTag() {
        return this.tag;
    }

    public final ThemeColor getTextColor() {
        return this.textColor;
    }

    public KeyTag(String r100, ThemeColor r101, ThemeColor r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.tag = r100;
        this.textColor = r101;
        this.backgroundColor = r102;
    }

    public /* synthetic */ KeyTag(String r100, ThemeColor r101, ThemeColor r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100, r101, r102);
    }
}
