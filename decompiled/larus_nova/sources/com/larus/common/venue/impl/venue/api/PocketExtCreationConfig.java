package com.larus.common.venue.impl.venue.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006&"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/PocketExtCreationConfig;", "", "selectedModel", "", "selectedRatio", "selectedResolution", "selectedDuration", "hiddenResourceUrl", "", "hiddenResourceUri", "hiddenResourceVid", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSelectedModel", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSelectedRatio", "getSelectedResolution", "getSelectedDuration", "getHiddenResourceUrl", "()Ljava/lang/String;", "getHiddenResourceUri", "getHiddenResourceVid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/PocketExtCreationConfig;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PocketExtCreationConfig {

    @SerializedName("hidden_resource_uri")
    private final String hiddenResourceUri;

    @SerializedName("hidden_resource_url")
    private final String hiddenResourceUrl;

    @SerializedName("hidden_resource_vid")
    private final String hiddenResourceVid;

    @SerializedName("selected_duration")
    private final Long selectedDuration;

    @SerializedName("selected_model")
    private final Long selectedModel;

    @SerializedName("selected_ratio")
    private final Long selectedRatio;

    @SerializedName("selected_resolution")
    private final Long selectedResolution;

    public PocketExtCreationConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PocketExtCreationConfig copy$default(PocketExtCreationConfig r100, Long r101, Long r102, Long r103, Long r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.selectedModel;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.selectedRatio;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.selectedResolution;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.selectedDuration;
    L14:
        Long r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.hiddenResourceUrl;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.hiddenResourceUri;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.hiddenResourceVid;
    L23:
        Long r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Long component1() {
        return this.selectedModel;
    }

    public final Long component2() {
        return this.selectedRatio;
    }

    public final Long component3() {
        return this.selectedResolution;
    }

    public final Long component4() {
        return this.selectedDuration;
    }

    public final String component5() {
        return this.hiddenResourceUrl;
    }

    public final String component6() {
        return this.hiddenResourceUri;
    }

    public final String component7() {
        return this.hiddenResourceVid;
    }

    public final PocketExtCreationConfig copy(Long r110, Long r111, Long r112, Long r113, String r114, String r115, String r116) {
        return new PocketExtCreationConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PocketExtCreationConfig) == true) goto L8;
        return false;
    L8:
        PocketExtCreationConfig r101 = (PocketExtCreationConfig) r100;
        if (Intrinsics.areEqual(this.selectedModel, r101.selectedModel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedRatio, r101.selectedRatio) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedResolution, r101.selectedResolution) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedDuration, r101.selectedDuration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hiddenResourceUrl, r101.hiddenResourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hiddenResourceUri, r101.hiddenResourceUri) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hiddenResourceVid, r101.hiddenResourceVid) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Long r100 = this.selectedModel;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.selectedRatio;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.selectedResolution;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.selectedDuration;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.hiddenResourceUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.hiddenResourceUri;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.hiddenResourceVid;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public String toString() {
        return "PocketExtCreationConfig(selectedModel=" + this.selectedModel + ", selectedRatio=" + this.selectedRatio + ", selectedResolution=" + this.selectedResolution + ", selectedDuration=" + this.selectedDuration + ", hiddenResourceUrl=" + this.hiddenResourceUrl + ", hiddenResourceUri=" + this.hiddenResourceUri + ", hiddenResourceVid=" + this.hiddenResourceVid + ')';
    }

    public final String getHiddenResourceUri() {
        return this.hiddenResourceUri;
    }

    public final String getHiddenResourceUrl() {
        return this.hiddenResourceUrl;
    }

    public final String getHiddenResourceVid() {
        return this.hiddenResourceVid;
    }

    public final Long getSelectedDuration() {
        return this.selectedDuration;
    }

    public final Long getSelectedModel() {
        return this.selectedModel;
    }

    public final Long getSelectedRatio() {
        return this.selectedRatio;
    }

    public final Long getSelectedResolution() {
        return this.selectedResolution;
    }

    public PocketExtCreationConfig(Long r100, Long r101, Long r102, Long r103, String r104, String r105, String r106) {
        this.selectedModel = r100;
        this.selectedRatio = r101;
        this.selectedResolution = r102;
        this.selectedDuration = r103;
        this.hiddenResourceUrl = r104;
        this.hiddenResourceUri = r105;
        this.hiddenResourceVid = r106;
    }

    public /* synthetic */ PocketExtCreationConfig(Long r100, Long r101, Long r102, Long r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Long r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Long r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Long r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Long r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
