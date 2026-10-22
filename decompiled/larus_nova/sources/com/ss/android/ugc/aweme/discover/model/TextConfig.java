package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\b\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/TextConfig;", "Ljava/io/Serializable;", "textContent", "", "textSize", "", "textColor", "Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "isBold", "", "(Ljava/lang/String;Ljava/lang/Float;Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTextColor", "()Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "getTextContent", "()Ljava/lang/String;", "getTextSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Float;Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;Ljava/lang/Boolean;)Lcom/ss/android/ugc/aweme/discover/model/TextConfig;", "equals", "other", "", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextConfig implements Serializable {

    @SerializedName("is_bold")
    private final Boolean isBold;

    @SerializedName("text_color")
    private final ColorConfig textColor;

    @SerializedName("text_content")
    private final String textContent;

    @SerializedName("text_size")
    private final Float textSize;

    public TextConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TextConfig copy$default(TextConfig r100, String r101, Float r102, ColorConfig r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.textContent;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.textSize;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.textColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isBold;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.textContent;
    }

    public final Float component2() {
        return this.textSize;
    }

    public final ColorConfig component3() {
        return this.textColor;
    }

    public final Boolean component4() {
        return this.isBold;
    }

    public final TextConfig copy(String r100, Float r101, ColorConfig r102, Boolean r103) {
        return new TextConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextConfig) == false) goto L14;
        TextConfig r101 = (TextConfig) r100;
        if (Intrinsics.areEqual(this.textContent, r101.textContent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textSize, r101.textSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isBold, r101.isBold) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.textContent;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.textSize;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ColorConfig r107 = this.textColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isBold;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TextConfig(textContent=" + this.textContent + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", isBold=" + this.isBold + ")";
    }

    public final ColorConfig getTextColor() {
        return this.textColor;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final Float getTextSize() {
        return this.textSize;
    }

    public final Boolean isBold() {
        return this.isBold;
    }

    public TextConfig(String r100, Float r101, ColorConfig r102, Boolean r103) {
        this.textContent = r100;
        this.textSize = r101;
        this.textColor = r102;
        this.isBold = r103;
    }

    public /* synthetic */ TextConfig(String r100, Float r101, ColorConfig r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Float.valueOf(0.0f);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = Boolean.FALSE;
    L14:
        this(r100, r101, r102, r103);
    }
}
