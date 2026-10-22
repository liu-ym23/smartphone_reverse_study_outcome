package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0013HÖ\u0001J\u0006\u0010#\u001a\u00020\u001fJ\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "Ljava/io/Serializable;", "fontSize", "", "textColor", "", "fontWeight", "fontShadow", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;)V", "getFontShadow", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;", "getFontSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFontWeight", "getTextColor", "()Ljava/lang/String;", "textColorInt", "", "getTextColorInt", "()Ljava/lang/Integer;", "textColorInt$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "equals", "", "other", "", "hashCode", "isBoldStyle", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FontStyle implements Serializable {

    @SerializedName("shadow")
    private final FontShadow fontShadow;

    @SerializedName("size")
    private final Long fontSize;

    @SerializedName("weight")
    private final Long fontWeight;

    @SerializedName("color")
    private final String textColor;
    private final Lazy textColorInt$delegate;

    public FontStyle() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FontStyle copy$default(FontStyle r0, Long r1, String r2, Long r3, FontShadow r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.fontSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.textColor;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.fontWeight;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.fontShadow;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Long component1() {
        return this.fontSize;
    }

    public final String component2() {
        return this.textColor;
    }

    public final Long component3() {
        return this.fontWeight;
    }

    public final FontShadow component4() {
        return this.fontShadow;
    }

    public final FontStyle copy(Long r2, String r3, Long r4, FontShadow r5) {
        return new FontStyle(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FontStyle) == false) goto L14;
        FontStyle r4 = (FontStyle) r3;
        if (Intrinsics.areEqual(this.fontSize, r4.fontSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r4.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontWeight, r4.fontWeight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontShadow, r4.fontShadow) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final Integer getTextColorInt() {
        return (Integer) this.textColorInt$delegate.getValue();
    }

    public int hashCode() {
        Long r0 = this.fontSize;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.textColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.fontWeight;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        FontShadow r10 = this.fontShadow;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FontStyle(fontSize=" + this.fontSize + ", textColor=" + this.textColor + ", fontWeight=" + this.fontWeight + ", fontShadow=" + this.fontShadow + ")";
    }

    public final boolean isBoldStyle() {
        Long r0 = this.fontWeight;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.longValue() < 500) goto L7;
        return true;
    }

    public final FontShadow getFontShadow() {
        return this.fontShadow;
    }

    public final Long getFontSize() {
        return this.fontSize;
    }

    public final Long getFontWeight() {
        return this.fontWeight;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public FontStyle(Long r1, String r2, Long r3, FontShadow r4) {
        this.fontSize = r1;
        this.textColor = r2;
        this.fontWeight = r3;
        this.fontShadow = r4;
        this.textColorInt$delegate = LazyKt.lazy(new FontStyle$textColorInt$2(this));
    }

    public /* synthetic */ FontStyle(Long r2, String r3, Long r4, FontShadow r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
