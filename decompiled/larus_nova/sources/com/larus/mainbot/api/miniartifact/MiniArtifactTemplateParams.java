package com.larus.mainbot.api.miniartifact;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1a.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014¨\u0006&"}, d2 = {"Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "miniArtifactInputContent", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactInputContent;", "templateUrl", "", "templateTitle", "templateEnableConfig", "", "inputPreviewWebUrl", "pushFromBottom", "<init>", "(Lcom/larus/mainbot/api/miniartifact/MiniArtifactInputContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getMiniArtifactInputContent", "()Lcom/larus/mainbot/api/miniartifact/MiniArtifactInputContent;", "getTemplateUrl", "()Ljava/lang/String;", "getTemplateTitle", "getTemplateEnableConfig", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getInputPreviewWebUrl", "getPushFromBottom", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/larus/mainbot/api/miniartifact/MiniArtifactInputContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "equals", "other", "", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactTemplateParams implements Serializable, c {

    @SerializedName("input_preview_web_url")
    private final String inputPreviewWebUrl;

    @SerializedName("mini_artifact_input_content")
    private final MiniArtifactInputContent miniArtifactInputContent;

    @SerializedName("push_from_bottom")
    private final Boolean pushFromBottom;

    @SerializedName("template_enable_config")
    private final Boolean templateEnableConfig;

    @SerializedName("template_title")
    private final String templateTitle;

    @SerializedName("template_url")
    private final String templateUrl;

    public MiniArtifactTemplateParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MiniArtifactTemplateParams copy$default(MiniArtifactTemplateParams r100, MiniArtifactInputContent r101, String r102, String r103, Boolean r104, String r105, Boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.miniArtifactInputContent;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.templateUrl;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.templateTitle;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.templateEnableConfig;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.inputPreviewWebUrl;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.pushFromBottom;
    L20:
        MiniArtifactInputContent r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final MiniArtifactInputContent component1() {
        return this.miniArtifactInputContent;
    }

    public final String component2() {
        return this.templateUrl;
    }

    public final String component3() {
        return this.templateTitle;
    }

    public final Boolean component4() {
        return this.templateEnableConfig;
    }

    public final String component5() {
        return this.inputPreviewWebUrl;
    }

    public final Boolean component6() {
        return this.pushFromBottom;
    }

    public final MiniArtifactTemplateParams copy(MiniArtifactInputContent r100, String r110, String r111, Boolean r112, String r113, Boolean r114) {
        return new MiniArtifactTemplateParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniArtifactTemplateParams) == true) goto L8;
        return false;
    L8:
        MiniArtifactTemplateParams r101 = (MiniArtifactTemplateParams) r100;
        if (Intrinsics.areEqual(this.miniArtifactInputContent, r101.miniArtifactInputContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateUrl, r101.templateUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateTitle, r101.templateTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateEnableConfig, r101.templateEnableConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.inputPreviewWebUrl, r101.inputPreviewWebUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pushFromBottom, r101.pushFromBottom) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        MiniArtifactInputContent r100 = this.miniArtifactInputContent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.templateUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.templateTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.templateEnableConfig;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.inputPreviewWebUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.pushFromBottom;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "MiniArtifactTemplateParams(miniArtifactInputContent=" + this.miniArtifactInputContent + ", templateUrl=" + this.templateUrl + ", templateTitle=" + this.templateTitle + ", templateEnableConfig=" + this.templateEnableConfig + ", inputPreviewWebUrl=" + this.inputPreviewWebUrl + ", pushFromBottom=" + this.pushFromBottom + ')';
    }

    public final String getInputPreviewWebUrl() {
        return this.inputPreviewWebUrl;
    }

    public final MiniArtifactInputContent getMiniArtifactInputContent() {
        return this.miniArtifactInputContent;
    }

    public final Boolean getPushFromBottom() {
        return this.pushFromBottom;
    }

    public final Boolean getTemplateEnableConfig() {
        return this.templateEnableConfig;
    }

    public final String getTemplateTitle() {
        return this.templateTitle;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public MiniArtifactTemplateParams(MiniArtifactInputContent r100, String r101, String r102, Boolean r103, String r104, Boolean r105) {
        this.miniArtifactInputContent = r100;
        this.templateUrl = r101;
        this.templateTitle = r102;
        this.templateEnableConfig = r103;
        this.inputPreviewWebUrl = r104;
        this.pushFromBottom = r105;
    }

    public /* synthetic */ MiniArtifactTemplateParams(MiniArtifactInputContent r100, String r101, String r102, Boolean r103, String r110, Boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        MiniArtifactInputContent r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Boolean r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
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
