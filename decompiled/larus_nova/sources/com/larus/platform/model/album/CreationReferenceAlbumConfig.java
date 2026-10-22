package com.larus.platform.model.album;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001eJ\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJ`\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\fHÖ\u0001J\t\u00100\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "Ljava/io/Serializable;", "mediaRules", "", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaRule;", "mixedRules", "Lcom/larus/platform/model/album/CreationReferenceAlbumMixedRule;", "existingAttachments", "Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "displayText", "", "additionalVideoCount", "", "additionalVideoDurationSeconds", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/Double;)V", "getMediaRules", "()Ljava/util/List;", "getMixedRules", "getExistingAttachments", "getDisplayText", "()Ljava/lang/String;", "getAdditionalVideoCount", "()I", "getAdditionalVideoDurationSeconds", "()Ljava/lang/Double;", "Ljava/lang/Double;", "ruleFor", "type", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "violationMessage", "violation", "Lcom/larus/platform/model/album/CreationReferenceAlbumViolation;", "candidateType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/Double;)Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationReferenceAlbumConfig implements Serializable {
    private final int additionalVideoCount;
    private final Double additionalVideoDurationSeconds;
    private final String displayText;
    private final List<CreationReferenceAlbumAttachment> existingAttachments;
    private final List<CreationReferenceAlbumMediaRule> mediaRules;
    private final List<CreationReferenceAlbumMixedRule> mixedRules;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f365540a = null;

        static {
            int[] r100 = new int[CreationReferenceAlbumViolation.values().length];
            r100[CreationReferenceAlbumViolation.TYPE_COUNT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[CreationReferenceAlbumViolation.MIXED_COUNT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[CreationReferenceAlbumViolation.TOTAL_DURATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[CreationReferenceAlbumViolation.MIXED_TOTAL_DURATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[CreationReferenceAlbumViolation.RESOLUTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[CreationReferenceAlbumViolation.UNSUPPORTED_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[CreationReferenceAlbumViolation.METADATA_UNAVAILABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[CreationReferenceAlbumViolation.SINGLE_DURATION.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[CreationReferenceAlbumViolation.FILE_SIZE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[CreationReferenceAlbumViolation.RATIO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f365540a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationReferenceAlbumConfig copy$default(CreationReferenceAlbumConfig r100, List r101, List r102, List r103, String r104, int r105, Double r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.mediaRules;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.mixedRules;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.existingAttachments;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.displayText;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.additionalVideoCount;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.additionalVideoDurationSeconds;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<CreationReferenceAlbumMediaRule> component1() {
        return this.mediaRules;
    }

    public final List<CreationReferenceAlbumMixedRule> component2() {
        return this.mixedRules;
    }

    public final List<CreationReferenceAlbumAttachment> component3() {
        return this.existingAttachments;
    }

    public final String component4() {
        return this.displayText;
    }

    public final int component5() {
        return this.additionalVideoCount;
    }

    public final Double component6() {
        return this.additionalVideoDurationSeconds;
    }

    public final CreationReferenceAlbumConfig copy(List<CreationReferenceAlbumMediaRule> r100, List<CreationReferenceAlbumMixedRule> r110, List<CreationReferenceAlbumAttachment> r111, String r112, int r113, Double r114) {
        Intrinsics.checkNotNullParameter(r100, "mediaRules");
        Intrinsics.checkNotNullParameter(r110, "mixedRules");
        Intrinsics.checkNotNullParameter(r111, "existingAttachments");
        return new CreationReferenceAlbumConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationReferenceAlbumConfig) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumConfig r101 = (CreationReferenceAlbumConfig) r100;
        if (Intrinsics.areEqual(this.mediaRules, r101.mediaRules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mixedRules, r101.mixedRules) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.existingAttachments, r101.existingAttachments) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L21;
        return false;
    L21:
        if (this.additionalVideoCount == r101.additionalVideoCount) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.additionalVideoDurationSeconds, r101.additionalVideoDurationSeconds) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.mediaRules.hashCode() * 31) + this.mixedRules.hashCode()) * 31) + this.existingAttachments.hashCode()) * 31;
        String r101 = this.displayText;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.additionalVideoCount) * 31;
        Double r105 = this.additionalVideoDurationSeconds;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationReferenceAlbumConfig(mediaRules=" + this.mediaRules + ", mixedRules=" + this.mixedRules + ", existingAttachments=" + this.existingAttachments + ", displayText=" + this.displayText + ", additionalVideoCount=" + this.additionalVideoCount + ", additionalVideoDurationSeconds=" + this.additionalVideoDurationSeconds + ')';
    }

    public final int getAdditionalVideoCount() {
        return this.additionalVideoCount;
    }

    public final Double getAdditionalVideoDurationSeconds() {
        return this.additionalVideoDurationSeconds;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final List<CreationReferenceAlbumAttachment> getExistingAttachments() {
        return this.existingAttachments;
    }

    public final List<CreationReferenceAlbumMediaRule> getMediaRules() {
        return this.mediaRules;
    }

    public final List<CreationReferenceAlbumMixedRule> getMixedRules() {
        return this.mixedRules;
    }

    public final CreationReferenceAlbumMediaRule ruleFor(CreationReferenceAlbumMediaType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Iterator<T> r101 = this.mediaRules.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((CreationReferenceAlbumMediaRule) r102).getType() != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L13:
        return (CreationReferenceAlbumMediaRule) r102;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L13
    }

    public final String violationMessage(CreationReferenceAlbumViolation r100, CreationReferenceAlbumMediaType r101) {
        Intrinsics.checkNotNullParameter(r100, "violation");
        if (r101 == null) goto L5;
        CreationReferenceAlbumMediaRule r102 = ruleFor(r101);
    L6:
        if (r101 == null) goto L15;
        Iterator<T> r103 = this.mixedRules.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((CreationReferenceAlbumMixedRule) r104).getSubTypes().contains(r101) == false) goto L9;
    L14:
        CreationReferenceAlbumMixedRule r105 = (CreationReferenceAlbumMixedRule) r104;
    L17:
        switch(a.f365540a[r100.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            default: goto L19;
        };
    L20:
        String r106 = null;
    L31:
        if (r106 != null) goto L33;
    L37:
        r106 = this.displayText;
        if (r106 != null) goto L40;
        return null;
    L40:
        if ((!StringsKt.isBlank(r106)) == true) goto L42;
        return null;
    L42:
        return r106;
    L33:
        if ((!StringsKt.isBlank(r106)) == true) goto L36;
        r106 = null;
    L36:
        if (r106 != null) goto L42;
    L21:
        if (r102 == null) goto L46;
        r106 = r102.getMaxResolutionDisplayText();
        goto L31
    L46:
        r106 = null;
        goto L31
    L23:
        if (r105 == null) goto L47;
        r106 = r105.getMaxTotalDurationDisplayText();
        goto L31
    L47:
        r106 = null;
        goto L31
    L25:
        if (r102 == null) goto L48;
        r106 = r102.getMaxTotalDurationDisplayText();
        goto L31
    L48:
        r106 = null;
        goto L31
    L27:
        if (r105 == null) goto L49;
        r106 = r105.getMaxCountDisplayText();
        goto L31
    L49:
        r106 = null;
        goto L31
    L29:
        if (r102 == null) goto L50;
        r106 = r102.getMaxCountDisplayText();
        goto L31
    L50:
        r106 = null;
        goto L31
    L19:
        throw new NoWhenBranchMatchedException();
    L13:
        r104 = null;
        goto L14
    L15:
        r105 = null;
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    public static /* synthetic */ String violationMessage$default(CreationReferenceAlbumConfig r100, CreationReferenceAlbumViolation r101, CreationReferenceAlbumMediaType r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.violationMessage(r101, r102);
    }

    public CreationReferenceAlbumConfig(List<CreationReferenceAlbumMediaRule> r100, List<CreationReferenceAlbumMixedRule> r101, List<CreationReferenceAlbumAttachment> r102, String r103, int r104, Double r105) {
        Intrinsics.checkNotNullParameter(r100, "mediaRules");
        Intrinsics.checkNotNullParameter(r101, "mixedRules");
        Intrinsics.checkNotNullParameter(r102, "existingAttachments");
        this.mediaRules = r100;
        this.mixedRules = r101;
        this.existingAttachments = r102;
        this.displayText = r103;
        this.additionalVideoCount = r104;
        this.additionalVideoDurationSeconds = r105;
    }

    public /* synthetic */ CreationReferenceAlbumConfig(List r110, List r111, List r112, String r113, int r114, Double r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r116 & 32) == 0) goto L13;
        Double r102 = null;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
