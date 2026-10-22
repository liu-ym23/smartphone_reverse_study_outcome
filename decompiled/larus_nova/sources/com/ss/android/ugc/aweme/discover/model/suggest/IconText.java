package com.ss.android.ugc.aweme.discover.model.suggest;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\t\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/suggest/IconText;", "Ljava/io/Serializable;", "backgroundColor", "", "textColor", "argb", BitableAnalytic.LocationClickType.WORDS, "wordSize", "", "isBold", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;)V", "getArgb", "()Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTextColor", "getWordSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getWords", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/ss/android/ugc/aweme/discover/model/suggest/IconText;", "equals", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconText implements Serializable {

    @SerializedName("argb")
    private final String argb;

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("is_bold")
    private final Boolean isBold;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("word_size")
    private final Float wordSize;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private final String words;

    public IconText() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ IconText copy$default(IconText r100, String r101, String r102, String r103, String r104, Float r105, Boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.argb;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.words;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.wordSize;
    L17:
        Float r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isBold;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final String component2() {
        return this.textColor;
    }

    public final String component3() {
        return this.argb;
    }

    public final String component4() {
        return this.words;
    }

    public final Float component5() {
        return this.wordSize;
    }

    public final Boolean component6() {
        return this.isBold;
    }

    public final IconText copy(String r100, String r110, String r111, String r112, Float r113, Boolean r114) {
        return new IconText(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IconText) == false) goto L18;
        IconText r101 = (IconText) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.argb, r101.argb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.words, r101.words) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.wordSize, r101.wordSize) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isBold, r101.isBold) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.argb;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.words;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.wordSize;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isBold;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "IconText(backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ", argb=" + this.argb + ", words=" + this.words + ", wordSize=" + this.wordSize + ", isBold=" + this.isBold + ")";
    }

    public final String getArgb() {
        return this.argb;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Float getWordSize() {
        return this.wordSize;
    }

    public final String getWords() {
        return this.words;
    }

    public final Boolean isBold() {
        return this.isBold;
    }

    public IconText(String r100, String r101, String r102, String r103, Float r104, Boolean r105) {
        this.backgroundColor = r100;
        this.textColor = r101;
        this.argb = r102;
        this.words = r103;
        this.wordSize = r104;
        this.isBold = r105;
    }

    public /* synthetic */ IconText(String r100, String r101, String r102, String r103, Float r110, Boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Float r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Boolean r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
