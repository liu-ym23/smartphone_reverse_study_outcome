package com.larus.platform.model.album;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u009c\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&¨\u0006="}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumMediaRule;", "Ljava/io/Serializable;", "type", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "maxCount", "", "maxTotalDuration", "", "maxResolution", "", "minRatio", "maxRatio", "minSingleDuration", "maxSingleDuration", "maxFileSize", "maxCountDisplayText", "", "maxTotalDurationDisplayText", "maxResolutionDisplayText", "<init>", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxTotalDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaxResolution", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMinRatio", "getMaxRatio", "getMinSingleDuration", "getMaxSingleDuration", "getMaxFileSize", "getMaxCountDisplayText", "()Ljava/lang/String;", "getMaxTotalDurationDisplayText", "getMaxResolutionDisplayText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/album/CreationReferenceAlbumMediaRule;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationReferenceAlbumMediaRule implements Serializable {
    private final Integer maxCount;
    private final String maxCountDisplayText;
    private final Long maxFileSize;
    private final Double maxRatio;
    private final Long maxResolution;
    private final String maxResolutionDisplayText;
    private final Double maxSingleDuration;
    private final Double maxTotalDuration;
    private final String maxTotalDurationDisplayText;
    private final Double minRatio;
    private final Double minSingleDuration;
    private final CreationReferenceAlbumMediaType type;

    public static /* synthetic */ CreationReferenceAlbumMediaRule copy$default(CreationReferenceAlbumMediaRule r110, CreationReferenceAlbumMediaType r111, Integer r112, Double r113, Long r114, Double r115, Double r116, Double r210, Double r211, Long r212, String r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        CreationReferenceAlbumMediaType r100 = r110.type;
    L7:
        if ((r216 & 2) == 0) goto L9;
        Integer r101 = r110.maxCount;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Double r102 = r110.maxTotalDuration;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Long r103 = r110.maxResolution;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Double r104 = r110.minRatio;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Double r105 = r110.maxRatio;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Double r106 = r110.minSingleDuration;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Double r107 = r110.maxSingleDuration;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Long r117 = r110.maxFileSize;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.maxCountDisplayText;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.maxTotalDurationDisplayText;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.maxResolutionDisplayText;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final CreationReferenceAlbumMediaType component1() {
        return this.type;
    }

    public final String component10() {
        return this.maxCountDisplayText;
    }

    public final String component11() {
        return this.maxTotalDurationDisplayText;
    }

    public final String component12() {
        return this.maxResolutionDisplayText;
    }

    public final Integer component2() {
        return this.maxCount;
    }

    public final Double component3() {
        return this.maxTotalDuration;
    }

    public final Long component4() {
        return this.maxResolution;
    }

    public final Double component5() {
        return this.minRatio;
    }

    public final Double component6() {
        return this.maxRatio;
    }

    public final Double component7() {
        return this.minSingleDuration;
    }

    public final Double component8() {
        return this.maxSingleDuration;
    }

    public final Long component9() {
        return this.maxFileSize;
    }

    public final CreationReferenceAlbumMediaRule copy(CreationReferenceAlbumMediaType r110, Integer r111, Double r112, Long r113, Double r114, Double r210, Double r211, Double r212, Long r213, String r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r110, "type");
        return new CreationReferenceAlbumMediaRule(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationReferenceAlbumMediaRule) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumMediaRule r101 = (CreationReferenceAlbumMediaRule) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxTotalDuration, r101.maxTotalDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxResolution, r101.maxResolution) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.minRatio, r101.minRatio) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxRatio, r101.maxRatio) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.minSingleDuration, r101.minSingleDuration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maxSingleDuration, r101.maxSingleDuration) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxFileSize, r101.maxFileSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.maxCountDisplayText, r101.maxCountDisplayText) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.maxTotalDurationDisplayText, r101.maxTotalDurationDisplayText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.maxResolutionDisplayText, r101.maxResolutionDisplayText) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = this.type.hashCode() * 31;
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
        Long r108 = this.maxResolution;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Double r111 = this.minRatio;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Double r114 = this.maxRatio;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Double r117 = this.minSingleDuration;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Double r120 = this.maxSingleDuration;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Long r123 = this.maxFileSize;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.maxCountDisplayText;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.maxTotalDurationDisplayText;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.maxResolutionDisplayText;
        if (r132 == null) goto L47;
        r102 = r132.hashCode();
    L47:
        return r131 + r102;
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "CreationReferenceAlbumMediaRule(type=" + this.type + ", maxCount=" + this.maxCount + ", maxTotalDuration=" + this.maxTotalDuration + ", maxResolution=" + this.maxResolution + ", minRatio=" + this.minRatio + ", maxRatio=" + this.maxRatio + ", minSingleDuration=" + this.minSingleDuration + ", maxSingleDuration=" + this.maxSingleDuration + ", maxFileSize=" + this.maxFileSize + ", maxCountDisplayText=" + this.maxCountDisplayText + ", maxTotalDurationDisplayText=" + this.maxTotalDurationDisplayText + ", maxResolutionDisplayText=" + this.maxResolutionDisplayText + ')';
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getMaxCountDisplayText() {
        return this.maxCountDisplayText;
    }

    public final Long getMaxFileSize() {
        return this.maxFileSize;
    }

    public final Double getMaxRatio() {
        return this.maxRatio;
    }

    public final Long getMaxResolution() {
        return this.maxResolution;
    }

    public final String getMaxResolutionDisplayText() {
        return this.maxResolutionDisplayText;
    }

    public final Double getMaxSingleDuration() {
        return this.maxSingleDuration;
    }

    public final Double getMaxTotalDuration() {
        return this.maxTotalDuration;
    }

    public final String getMaxTotalDurationDisplayText() {
        return this.maxTotalDurationDisplayText;
    }

    public final Double getMinRatio() {
        return this.minRatio;
    }

    public final Double getMinSingleDuration() {
        return this.minSingleDuration;
    }

    public final CreationReferenceAlbumMediaType getType() {
        return this.type;
    }

    public CreationReferenceAlbumMediaRule(CreationReferenceAlbumMediaType r100, Integer r101, Double r102, Long r103, Double r104, Double r105, Double r106, Double r107, Long r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.maxCount = r101;
        this.maxTotalDuration = r102;
        this.maxResolution = r103;
        this.minRatio = r104;
        this.maxRatio = r105;
        this.minSingleDuration = r106;
        this.maxSingleDuration = r107;
        this.maxFileSize = r110;
        this.maxCountDisplayText = r111;
        this.maxTotalDurationDisplayText = r112;
        this.maxResolutionDisplayText = r113;
    }

    public /* synthetic */ CreationReferenceAlbumMediaRule(CreationReferenceAlbumMediaType r110, Integer r111, Double r112, Long r210, Double r211, Double r212, Double r213, Double r214, Long r215, String r216, String r217, String r218, int r219, DefaultConstructorMarker r310) {
        if ((r219 & 512) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r219 & 1024) == 0) goto L9;
        String r114 = null;
    L11:
        if ((r219 & 2048) == 0) goto L13;
        String r115 = null;
    L14:
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r113, r114, r115);
        return;
    L13:
        r115 = r218;
        goto L14
    L9:
        r114 = r217;
        goto L11
    L5:
        r113 = r216;
        goto L7
    }
}
