package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CardBorder;", "Ljava/io/Serializable;", "color", "", "borderRadius", "", "borderWidth", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBorderRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBorderWidth", "getColor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/ugc/aweme/discover/model/CardBorder;", "equals", "", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardBorder implements Serializable {

    @SerializedName("border_radius")
    private final Integer borderRadius;

    @SerializedName("border_width")
    private final Integer borderWidth;

    @SerializedName("color")
    private final String color;

    public CardBorder() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CardBorder copy$default(CardBorder r100, String r101, Integer r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.color;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.borderRadius;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.borderWidth;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.color;
    }

    public final Integer component2() {
        return this.borderRadius;
    }

    public final Integer component3() {
        return this.borderWidth;
    }

    public final CardBorder copy(String r100, Integer r101, Integer r102) {
        return new CardBorder(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CardBorder) == false) goto L12;
        CardBorder r101 = (CardBorder) r100;
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.borderWidth, r101.borderWidth) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.color;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.borderRadius;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.borderWidth;
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

    public String toString() {
        return "CardBorder(color=" + this.color + ", borderRadius=" + this.borderRadius + ", borderWidth=" + this.borderWidth + ")";
    }

    public final Integer getBorderRadius() {
        return this.borderRadius;
    }

    public final Integer getBorderWidth() {
        return this.borderWidth;
    }

    public final String getColor() {
        return this.color;
    }

    public CardBorder(String r100, Integer r101, Integer r102) {
        this.color = r100;
        this.borderRadius = r101;
        this.borderWidth = r102;
    }

    public /* synthetic */ CardBorder(String r100, Integer r101, Integer r102, int r103, DefaultConstructorMarker r104) {
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
