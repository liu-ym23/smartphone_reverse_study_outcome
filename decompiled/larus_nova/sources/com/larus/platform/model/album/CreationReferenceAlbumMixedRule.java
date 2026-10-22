package com.larus.platform.model.album;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JN\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006&"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumMixedRule;", "Ljava/io/Serializable;", "subTypes", "", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "maxCount", "", "maxTotalDuration", "", "maxCountDisplayText", "", "maxTotalDurationDisplayText", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getSubTypes", "()Ljava/util/List;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxTotalDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaxCountDisplayText", "()Ljava/lang/String;", "getMaxTotalDurationDisplayText", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/album/CreationReferenceAlbumMixedRule;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationReferenceAlbumMixedRule implements Serializable {
    private final Integer maxCount;
    private final String maxCountDisplayText;
    private final Double maxTotalDuration;
    private final String maxTotalDurationDisplayText;
    private final List<CreationReferenceAlbumMediaType> subTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationReferenceAlbumMixedRule copy$default(CreationReferenceAlbumMixedRule r100, List r101, Integer r102, Double r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.subTypes;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maxCount;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.maxTotalDuration;
    L11:
        Double r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.maxCountDisplayText;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.maxTotalDurationDisplayText;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<CreationReferenceAlbumMediaType> component1() {
        return this.subTypes;
    }

    public final Integer component2() {
        return this.maxCount;
    }

    public final Double component3() {
        return this.maxTotalDuration;
    }

    public final String component4() {
        return this.maxCountDisplayText;
    }

    public final String component5() {
        return this.maxTotalDurationDisplayText;
    }

    public final CreationReferenceAlbumMixedRule copy(List<? extends CreationReferenceAlbumMediaType> r100, Integer r101, Double r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "subTypes");
        return new CreationReferenceAlbumMixedRule(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationReferenceAlbumMixedRule) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumMixedRule r101 = (CreationReferenceAlbumMixedRule) r100;
        if (Intrinsics.areEqual(this.subTypes, r101.subTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxTotalDuration, r101.maxTotalDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxCountDisplayText, r101.maxCountDisplayText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxTotalDurationDisplayText, r101.maxTotalDurationDisplayText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.subTypes.hashCode() * 31;
        Integer r101 = this.maxCount;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Double r105 = this.maxTotalDuration;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.maxCountDisplayText;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.maxTotalDurationDisplayText;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationReferenceAlbumMixedRule(subTypes=" + this.subTypes + ", maxCount=" + this.maxCount + ", maxTotalDuration=" + this.maxTotalDuration + ", maxCountDisplayText=" + this.maxCountDisplayText + ", maxTotalDurationDisplayText=" + this.maxTotalDurationDisplayText + ')';
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getMaxCountDisplayText() {
        return this.maxCountDisplayText;
    }

    public final Double getMaxTotalDuration() {
        return this.maxTotalDuration;
    }

    public final String getMaxTotalDurationDisplayText() {
        return this.maxTotalDurationDisplayText;
    }

    public final List<CreationReferenceAlbumMediaType> getSubTypes() {
        return this.subTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationReferenceAlbumMixedRule(List<? extends CreationReferenceAlbumMediaType> r100, Integer r101, Double r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "subTypes");
        this.subTypes = r100;
        this.maxCount = r101;
        this.maxTotalDuration = r102;
        this.maxCountDisplayText = r103;
        this.maxTotalDurationDisplayText = r104;
    }

    public /* synthetic */ CreationReferenceAlbumMixedRule(List r100, Integer r101, Double r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        String r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
