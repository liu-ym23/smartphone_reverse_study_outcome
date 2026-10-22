package com.larksuite.component.card.protocol.context;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/card/protocol/context/CardStyle;", "Ljava/io/Serializable;", "isWideMode", "", "headerNoPaddingTop", "showTranslateMargin", "bodyMinHeight", "", "<init>", "(ZZZLjava/lang/Integer;)V", "()Z", "getHeaderNoPaddingTop", "getShowTranslateMargin", "getBodyMinHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(ZZZLjava/lang/Integer;)Lcom/larksuite/component/card/protocol/context/CardStyle;", "equals", "other", "", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardStyle implements Serializable {
    private final Integer bodyMinHeight;
    private final boolean headerNoPaddingTop;
    private final boolean isWideMode;
    private final boolean showTranslateMargin;

    public CardStyle() {
        this(false, false, false, null, 15, null);
    }

    public static /* synthetic */ CardStyle copy$default(CardStyle r100, boolean r101, boolean r102, boolean r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isWideMode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.headerNoPaddingTop;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.showTranslateMargin;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bodyMinHeight;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isWideMode;
    }

    public final boolean component2() {
        return this.headerNoPaddingTop;
    }

    public final boolean component3() {
        return this.showTranslateMargin;
    }

    public final Integer component4() {
        return this.bodyMinHeight;
    }

    public final CardStyle copy(boolean r100, boolean r101, boolean r102, Integer r103) {
        return new CardStyle(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardStyle) == true) goto L8;
        return false;
    L8:
        CardStyle r101 = (CardStyle) r100;
        if (this.isWideMode == r101.isWideMode) goto L12;
        return false;
    L12:
        if (this.headerNoPaddingTop == r101.headerNoPaddingTop) goto L15;
        return false;
    L15:
        if (this.showTranslateMargin == r101.showTranslateMargin) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bodyMinHeight, r101.bodyMinHeight) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isWideMode == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.headerNoPaddingTop == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showTranslateMargin == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        Integer r106 = this.bodyMinHeight;
        if (r106 != null) goto L17;
        int r107 = 0;
    L19:
        return r105 + r107;
    L17:
        r107 = r106.hashCode();
        goto L19
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CardStyle(isWideMode=" + this.isWideMode + ", headerNoPaddingTop=" + this.headerNoPaddingTop + ", showTranslateMargin=" + this.showTranslateMargin + ", bodyMinHeight=" + this.bodyMinHeight + ')';
    }

    public final Integer getBodyMinHeight() {
        return this.bodyMinHeight;
    }

    public final boolean getHeaderNoPaddingTop() {
        return this.headerNoPaddingTop;
    }

    public final boolean getShowTranslateMargin() {
        return this.showTranslateMargin;
    }

    public final boolean isWideMode() {
        return this.isWideMode;
    }

    public CardStyle(boolean r100, boolean r101, boolean r102, Integer r103) {
        this.isWideMode = r100;
        this.headerNoPaddingTop = r101;
        this.showTranslateMargin = r102;
        this.bodyMinHeight = r103;
    }

    public /* synthetic */ CardStyle(boolean r100, boolean r101, boolean r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
