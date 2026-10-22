package com.larus.bmhome.miniartifact.listpage.request;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "Ljava/io/Serializable;", GXTemplateKey.GAIAX_TEMPLATE_ID, "", "templateCoverUrl", "templateTitle", "templateWebUrl", "templateInvalidTimestamp", "", "enableConfigElement", "", "configElementImage", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ConfigElementImage;", "configElementPrompt", "coverMainColor", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTemplateId", "()Ljava/lang/String;", "getTemplateCoverUrl", "getTemplateTitle", "getTemplateWebUrl", "getTemplateInvalidTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnableConfigElement", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfigElementImage", "()Ljava/util/List;", "getConfigElementPrompt", "getCoverMainColor", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationTemplate implements Serializable {

    @SerializedName("config_element_image")
    private final List<ConfigElementImage> configElementImage;

    @SerializedName("config_element_prompt")
    private final String configElementPrompt;

    @SerializedName("cover_main_color")
    private final String coverMainColor;

    @SerializedName("enable_config_element")
    private final Boolean enableConfigElement;

    @SerializedName("template_cover_url")
    private final String templateCoverUrl;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final String templateId;

    @SerializedName("template_invalid_timestamp")
    private final Long templateInvalidTimestamp;

    @SerializedName("template_title")
    private final String templateTitle;

    @SerializedName("template_web_url")
    private final String templateWebUrl;

    @SerializedName("version")
    private final String version;

    public ApplicationTemplate() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationTemplate copy$default(ApplicationTemplate r110, String r111, String r112, String r113, String r114, Long r115, Boolean r116, List r117, String r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.templateId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.templateCoverUrl;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.templateTitle;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.templateWebUrl;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Long r104 = r110.templateInvalidTimestamp;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Boolean r105 = r110.enableConfigElement;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.configElementImage;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.configElementPrompt;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.coverMainColor;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.version;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
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

    public final String component1() {
        return this.templateId;
    }

    public final String component10() {
        return this.version;
    }

    public final String component2() {
        return this.templateCoverUrl;
    }

    public final String component3() {
        return this.templateTitle;
    }

    public final String component4() {
        return this.templateWebUrl;
    }

    public final Long component5() {
        return this.templateInvalidTimestamp;
    }

    public final Boolean component6() {
        return this.enableConfigElement;
    }

    public final List<ConfigElementImage> component7() {
        return this.configElementImage;
    }

    public final String component8() {
        return this.configElementPrompt;
    }

    public final String component9() {
        return this.coverMainColor;
    }

    public final ApplicationTemplate copy(String r110, String r111, String r112, String r113, Long r114, Boolean r115, List<ConfigElementImage> r116, String r210, String r211, String r212) {
        return new ApplicationTemplate(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApplicationTemplate) == true) goto L8;
        return false;
    L8:
        ApplicationTemplate r101 = (ApplicationTemplate) r100;
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateCoverUrl, r101.templateCoverUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateTitle, r101.templateTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateWebUrl, r101.templateWebUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.templateInvalidTimestamp, r101.templateInvalidTimestamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enableConfigElement, r101.enableConfigElement) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.configElementImage, r101.configElementImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.configElementPrompt, r101.configElementPrompt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.coverMainColor, r101.coverMainColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.templateId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.templateCoverUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.templateTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.templateWebUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.templateInvalidTimestamp;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.enableConfigElement;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<ConfigElementImage> r119 = this.configElementImage;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.configElementPrompt;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.coverMainColor;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.version;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "ApplicationTemplate(templateId=" + this.templateId + ", templateCoverUrl=" + this.templateCoverUrl + ", templateTitle=" + this.templateTitle + ", templateWebUrl=" + this.templateWebUrl + ", templateInvalidTimestamp=" + this.templateInvalidTimestamp + ", enableConfigElement=" + this.enableConfigElement + ", configElementImage=" + this.configElementImage + ", configElementPrompt=" + this.configElementPrompt + ", coverMainColor=" + this.coverMainColor + ", version=" + this.version + ')';
    }

    public final List<ConfigElementImage> getConfigElementImage() {
        return this.configElementImage;
    }

    public final String getConfigElementPrompt() {
        return this.configElementPrompt;
    }

    public final String getCoverMainColor() {
        return this.coverMainColor;
    }

    public final Boolean getEnableConfigElement() {
        return this.enableConfigElement;
    }

    public final String getTemplateCoverUrl() {
        return this.templateCoverUrl;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final Long getTemplateInvalidTimestamp() {
        return this.templateInvalidTimestamp;
    }

    public final String getTemplateTitle() {
        return this.templateTitle;
    }

    public final String getTemplateWebUrl() {
        return this.templateWebUrl;
    }

    public final String getVersion() {
        return this.version;
    }

    public ApplicationTemplate(String r100, String r101, String r102, String r103, Long r104, Boolean r105, List<ConfigElementImage> r106, String r107, String r108, String r110) {
        this.templateId = r100;
        this.templateCoverUrl = r101;
        this.templateTitle = r102;
        this.templateWebUrl = r103;
        this.templateInvalidTimestamp = r104;
        this.enableConfigElement = r105;
        this.configElementImage = r106;
        this.configElementPrompt = r107;
        this.coverMainColor = r108;
        this.version = r110;
    }

    public /* synthetic */ ApplicationTemplate(String r110, String r111, String r112, String r113, Long r114, Boolean r115, List r116, String r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Boolean r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
}
