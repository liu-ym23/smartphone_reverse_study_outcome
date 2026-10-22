package com.ss.android.lark.export.entity.preview;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010\u0018\u001a\u00020\u0000J$\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u001aHÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006'"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UDIcon;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "key", "", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "unicode", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setThemeColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getUnicode", "setUnicode", "isItemSame", "", "diffable", "isContentSame", "clone", "patchData", "", "previewData", "Lcom/ss/android/lark/export/entity/preview/PreviewData;", "udIcon", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDIcon implements Serializable, b<UDIcon> {
    private String key;
    private ThemeColor themeColor;
    private String unicode;

    public UDIcon() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UDIcon copy$default(UDIcon r100, String r101, ThemeColor r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.themeColor;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.unicode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.key;
    }

    public final ThemeColor component2() {
        return this.themeColor;
    }

    public final String component3() {
        return this.unicode;
    }

    public final UDIcon copy(String r100, ThemeColor r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return new UDIcon(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UDIcon) == true) goto L8;
        return false;
    L8:
        UDIcon r101 = (UDIcon) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.themeColor, r101.themeColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.unicode, r101.unicode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.key.hashCode() * 31;
        ThemeColor r101 = this.themeColor;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.unicode;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "UDIcon(key=" + this.key + ", themeColor=" + this.themeColor + ", unicode=" + this.unicode + ')';
    }

    public final UDIcon clone() {
        String r100 = this.key;
        ThemeColor r101 = this.themeColor;
        if (r101 == null) goto L5;
        ThemeColor r102 = r101.clone();
    L7:
        return new UDIcon(r100, r102, this.unicode);
    L5:
        r102 = null;
        goto L7
    }

    public final String getKey() {
        return this.key;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final String getUnicode() {
        return this.unicode;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UDIcon) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UDIcon) r100);
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setThemeColor(ThemeColor r100) {
        this.themeColor = r100;
    }

    public final void setUnicode(String r100) {
        this.unicode = r100;
    }

    public boolean isContentSame(UDIcon r100) {
        return Intrinsics.areEqual(this, r100);
    }

    public boolean isItemSame(UDIcon r100) {
        return Intrinsics.areEqual(this, r100);
    }

    public UDIcon(String r100, ThemeColor r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.key = r100;
        this.themeColor = r101;
        this.unicode = r102;
    }

    public final UDIcon patchData(int r100, PreviewData r110, UDIcon r111) {
        if (r100 != ComponentAttribute.ud_icon_key.getValue()) goto L20;
        String r101 = "";
        if (r111 == null) goto L7;
        if (r110 == null) goto L19;
        String r112 = r110.getString();
        if (r112 == null) goto L19;
        r101 = r112;
    L19:
        r111.key = r101;
    L40:
        return r111;
    L7:
        if (r110 == null) goto L12;
        String r113 = r110.getString();
        if (r113 == null) goto L12;
        String r102 = r113;
    L13:
        r111 = new UDIcon(r102, null, null, 6, null);
    L12:
        r102 = "";
        goto L13
    L20:
        String r103 = null;
        ThemeColor r104 = null;
        ThemeColor r105 = null;
        String r106 = null;
        if (r100 != ComponentAttribute.ud_icon_theme_color.getValue()) goto L31;
        if (r111 != null) goto L27;
        String r107 = null;
        if (r110 == null) goto L26;
        r104 = r110.getThemeColor();
    L26:
        r111 = new UDIcon(r107, r104, null, 5, null);
        goto L40
    L27:
        if (r110 == null) goto L29;
        r105 = r110.getThemeColor();
    L29:
        r111.themeColor = r105;
        goto L40
    L31:
        if (r100 != ComponentAttribute.unicode.getValue()) goto L40;
        if (r111 != null) goto L37;
        String r108 = null;
        ThemeColor r109 = null;
        if (r110 == null) goto L36;
        r106 = r110.getString();
    L36:
        r111 = new UDIcon(r108, r109, r106, 3, null);
        goto L40
    L37:
        if (r110 == null) goto L39;
        r103 = r110.getString();
    L39:
        r111.unicode = r103;
        goto L40
    }

    public /* synthetic */ UDIcon(String r100, ThemeColor r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
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
