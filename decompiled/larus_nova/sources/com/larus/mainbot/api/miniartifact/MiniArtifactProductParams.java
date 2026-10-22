package com.larus.mainbot.api.miniartifact;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1a.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bw\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001b\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J~\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R(\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016¨\u0006,"}, d2 = {"Lcom/larus/mainbot/api/miniartifact/MiniArtifactProductParams;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "miniArtifactUrl", "", "miniArtifactUserInputInfoId", "miniArtifactTitle", "miniArtifactFinished", "", "miniArtifactId", "trackParams", "", "", "templateEnableConfig", "pushFromBottom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getMiniArtifactUrl", "()Ljava/lang/String;", "getMiniArtifactUserInputInfoId", "getMiniArtifactTitle", "getMiniArtifactFinished", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMiniArtifactId", "getTrackParams", "()Ljava/util/Map;", "getTemplateEnableConfig", "getPushFromBottom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/mainbot/api/miniartifact/MiniArtifactProductParams;", "equals", "other", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactProductParams implements Serializable, c {

    @SerializedName("mini_artifact_finished")
    private final Boolean miniArtifactFinished;

    @SerializedName("mini_artifact_artifact_id")
    private final String miniArtifactId;

    @SerializedName("mini_artifact_title")
    private final String miniArtifactTitle;

    @SerializedName("mini_artifact_url")
    private final String miniArtifactUrl;

    @SerializedName("mini_artifact_user_input_info_id")
    private final String miniArtifactUserInputInfoId;

    @SerializedName("push_from_bottom")
    private final Boolean pushFromBottom;

    @SerializedName("template_enable_config")
    private final Boolean templateEnableConfig;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public MiniArtifactProductParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniArtifactProductParams copy$default(MiniArtifactProductParams r100, String r110, String r111, String r112, Boolean r113, String r114, Map r115, Boolean r116, Boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.miniArtifactUrl;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.miniArtifactUserInputInfoId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.miniArtifactTitle;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = r100.miniArtifactFinished;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.miniArtifactId;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Map r106 = r100.trackParams;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Boolean r107 = r100.templateEnableConfig;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Boolean r108 = r100.pushFromBottom;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.miniArtifactUrl;
    }

    public final String component2() {
        return this.miniArtifactUserInputInfoId;
    }

    public final String component3() {
        return this.miniArtifactTitle;
    }

    public final Boolean component4() {
        return this.miniArtifactFinished;
    }

    public final String component5() {
        return this.miniArtifactId;
    }

    public final Map<String, Object> component6() {
        return this.trackParams;
    }

    public final Boolean component7() {
        return this.templateEnableConfig;
    }

    public final Boolean component8() {
        return this.pushFromBottom;
    }

    public final MiniArtifactProductParams copy(String r110, String r111, String r112, Boolean r113, String r114, Map<String, ? extends Object> r115, Boolean r116, Boolean r117) {
        return new MiniArtifactProductParams(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniArtifactProductParams) == true) goto L8;
        return false;
    L8:
        MiniArtifactProductParams r101 = (MiniArtifactProductParams) r100;
        if (Intrinsics.areEqual(this.miniArtifactUrl, r101.miniArtifactUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.miniArtifactUserInputInfoId, r101.miniArtifactUserInputInfoId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.miniArtifactTitle, r101.miniArtifactTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.miniArtifactFinished, r101.miniArtifactFinished) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.miniArtifactId, r101.miniArtifactId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.templateEnableConfig, r101.templateEnableConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pushFromBottom, r101.pushFromBottom) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.miniArtifactUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.miniArtifactUserInputInfoId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.miniArtifactTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.miniArtifactFinished;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.miniArtifactId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, Object> r116 = this.trackParams;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.templateEnableConfig;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.pushFromBottom;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "MiniArtifactProductParams(miniArtifactUrl=" + this.miniArtifactUrl + ", miniArtifactUserInputInfoId=" + this.miniArtifactUserInputInfoId + ", miniArtifactTitle=" + this.miniArtifactTitle + ", miniArtifactFinished=" + this.miniArtifactFinished + ", miniArtifactId=" + this.miniArtifactId + ", trackParams=" + this.trackParams + ", templateEnableConfig=" + this.templateEnableConfig + ", pushFromBottom=" + this.pushFromBottom + ')';
    }

    public final Boolean getMiniArtifactFinished() {
        return this.miniArtifactFinished;
    }

    public final String getMiniArtifactId() {
        return this.miniArtifactId;
    }

    public final String getMiniArtifactTitle() {
        return this.miniArtifactTitle;
    }

    public final String getMiniArtifactUrl() {
        return this.miniArtifactUrl;
    }

    public final String getMiniArtifactUserInputInfoId() {
        return this.miniArtifactUserInputInfoId;
    }

    public final Boolean getPushFromBottom() {
        return this.pushFromBottom;
    }

    public final Boolean getTemplateEnableConfig() {
        return this.templateEnableConfig;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public MiniArtifactProductParams(String r100, String r101, String r102, Boolean r103, String r104, Map<String, ? extends Object> r105, Boolean r106, Boolean r107) {
        this.miniArtifactUrl = r100;
        this.miniArtifactUserInputInfoId = r101;
        this.miniArtifactTitle = r102;
        this.miniArtifactFinished = r103;
        this.miniArtifactId = r104;
        this.trackParams = r105;
        this.templateEnableConfig = r106;
        this.pushFromBottom = r107;
    }

    public /* synthetic */ MiniArtifactProductParams(String r110, String r111, String r112, Boolean r113, String r114, Map r115, Boolean r116, Boolean r117, int r118, DefaultConstructorMarker r119) {
        Boolean r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Boolean r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
