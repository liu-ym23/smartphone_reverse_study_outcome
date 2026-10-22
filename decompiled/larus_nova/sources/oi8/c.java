package oi8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/search/CardParam;", "", "indicator", "", "abVersion", "cardDecorateParam", "Lcom/larus/bmhome/chat/search/CardDecorateParam;", "richMedia", "Lcom/larus/bmhome/chat/search/RichMedia;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/chat/search/CardDecorateParam;Lcom/larus/bmhome/chat/search/RichMedia;)V", "getIndicator", "()Ljava/lang/Integer;", "setIndicator", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAbVersion", "setAbVersion", "getCardDecorateParam", "()Lcom/larus/bmhome/chat/search/CardDecorateParam;", "setCardDecorateParam", "(Lcom/larus/bmhome/chat/search/CardDecorateParam;)V", "getRichMedia", "()Lcom/larus/bmhome/chat/search/RichMedia;", "setRichMedia", "(Lcom/larus/bmhome/chat/search/RichMedia;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/chat/search/CardDecorateParam;Lcom/larus/bmhome/chat/search/RichMedia;)Lcom/larus/bmhome/chat/search/CardParam;", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("ABVersion")
    private Integer abVersion;

    @SerializedName("decorateParams")
    private b cardDecorateParam;

    @SerializedName("indicator")
    private Integer indicator;

    @SerializedName("rich_media")
    private e richMedia;

    public c() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.indicator, r101.indicator) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.abVersion, r101.abVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardDecorateParam, r101.cardDecorateParam) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.richMedia, r101.richMedia) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.indicator;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.abVersion;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.cardDecorateParam;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        e r110 = this.richMedia;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardParam(indicator=" + this.indicator + ", abVersion=" + this.abVersion + ", cardDecorateParam=" + this.cardDecorateParam + ", richMedia=" + this.richMedia + ')';
    }

    public final Integer a() {
        return this.abVersion;
    }

    public final Integer b() {
        return this.indicator;
    }

    public final e c() {
        return this.richMedia;
    }

    public c(Integer r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.indicator = r100;
        this.abVersion = r101;
        this.cardDecorateParam = null;
        this.richMedia = null;
    }
}
