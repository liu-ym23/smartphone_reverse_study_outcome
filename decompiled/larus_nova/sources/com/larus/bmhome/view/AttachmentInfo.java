package com.larus.bmhome.view;

import com.larus.im.bean.message.Image;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100JÒ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0007HÖ\u0001J\t\u0010I\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100¨\u0006J"}, d2 = {"Lcom/larus/bmhome/view/AttachmentInfo;", "Ljava/io/Serializable;", "isImage", "", "tosKey", "", "height", "", "width", "filePath", "fileName", "fromScene", "resourceId", "fileIdentifier", "actionBarKey", "enterMethod", "serverUrl", "previewUrl", "instantUploadInfo", "Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "image", "Lcom/larus/im/bean/message/Image;", "localMessageId", "aiCreationImage", "<init>", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;Lcom/larus/im/bean/message/Image;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Z", "getTosKey", "()Ljava/lang/String;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getFilePath", "getFileName", "getFromScene", "getResourceId", "getFileIdentifier", "getActionBarKey", "getEnterMethod", "getServerUrl", "getPreviewUrl", "getInstantUploadInfo", "()Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "getImage", "()Lcom/larus/im/bean/message/Image;", "getLocalMessageId", "getAiCreationImage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;Lcom/larus/im/bean/message/Image;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/view/AttachmentInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentInfo implements Serializable {
    private final String actionBarKey;
    private final Boolean aiCreationImage;
    private final String enterMethod;
    private final String fileIdentifier;
    private final String fileName;
    private final String filePath;
    private final String fromScene;
    private final Integer height;
    private final Image image;
    private final ResourceUploadInstantInfo instantUploadInfo;
    private final boolean isImage;
    private final String localMessageId;
    private final String previewUrl;
    private final String resourceId;
    private final String serverUrl;
    private final String tosKey;
    private final Integer width;

    public static /* synthetic */ AttachmentInfo copy$default(AttachmentInfo r110, boolean r111, String r112, Integer r210, Integer r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, ResourceUploadInstantInfo r311, Image r312, String r313, Boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        boolean r100 = r110.isImage;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.tosKey;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Integer r102 = r110.height;
    L15:
        if ((r315 & 8) == 0) goto L17;
        Integer r103 = r110.width;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = r110.filePath;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.fileName;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.fromScene;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r107 = r110.resourceId;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.fileIdentifier;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.actionBarKey;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.enterMethod;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.serverUrl;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.previewUrl;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        ResourceUploadInstantInfo r118 = r110.instantUploadInfo;
    L58:
        ResourceUploadInstantInfo r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        Image r119 = r110.image;
    L62:
        Image r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.localMessageId;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        Boolean r108 = r110.aiCreationImage;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.isImage;
    }

    public final String component10() {
        return this.actionBarKey;
    }

    public final String component11() {
        return this.enterMethod;
    }

    public final String component12() {
        return this.serverUrl;
    }

    public final String component13() {
        return this.previewUrl;
    }

    public final ResourceUploadInstantInfo component14() {
        return this.instantUploadInfo;
    }

    public final Image component15() {
        return this.image;
    }

    public final String component16() {
        return this.localMessageId;
    }

    public final Boolean component17() {
        return this.aiCreationImage;
    }

    public final String component2() {
        return this.tosKey;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Integer component4() {
        return this.width;
    }

    public final String component5() {
        return this.filePath;
    }

    public final String component6() {
        return this.fileName;
    }

    public final String component7() {
        return this.fromScene;
    }

    public final String component8() {
        return this.resourceId;
    }

    public final String component9() {
        return this.fileIdentifier;
    }

    public final AttachmentInfo copy(boolean r210, String r211, Integer r212, Integer r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, ResourceUploadInstantInfo r313, Image r314, String r315, Boolean r316) {
        Intrinsics.checkNotNullParameter(r211, "tosKey");
        Intrinsics.checkNotNullParameter(r214, "filePath");
        Intrinsics.checkNotNullParameter(r216, "fromScene");
        return new AttachmentInfo(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttachmentInfo) == true) goto L8;
        return false;
    L8:
        AttachmentInfo r101 = (AttachmentInfo) r100;
        if (this.isImage == r101.isImage) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tosKey, r101.tosKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fromScene, r101.fromScene) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileIdentifier, r101.fileIdentifier) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionBarKey, r101.actionBarKey) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.serverUrl, r101.serverUrl) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.previewUrl, r101.previewUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.instantUploadInfo, r101.instantUploadInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.aiCreationImage, r101.aiCreationImage) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        if (this.isImage == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.tosKey.hashCode()) * 31;
        Integer r102 = this.height;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Integer r106 = this.width;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r105 + r107) * 31) + this.filePath.hashCode()) * 31;
        String r109 = this.fileName;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (((r108 + r110) * 31) + this.fromScene.hashCode()) * 31;
        String r112 = this.resourceId;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.fileIdentifier;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.actionBarKey;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.enterMethod;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.serverUrl;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.previewUrl;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        ResourceUploadInstantInfo r130 = this.instantUploadInfo;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Image r133 = this.image;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.localMessageId;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Boolean r139 = this.aiCreationImage;
        if (r139 == null) goto L59;
        r103 = r139.hashCode();
    L59:
        return r138 + r103;
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "AttachmentInfo(isImage=" + this.isImage + ", tosKey=" + this.tosKey + ", height=" + this.height + ", width=" + this.width + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", fromScene=" + this.fromScene + ", resourceId=" + this.resourceId + ", fileIdentifier=" + this.fileIdentifier + ", actionBarKey=" + this.actionBarKey + ", enterMethod=" + this.enterMethod + ", serverUrl=" + this.serverUrl + ", previewUrl=" + this.previewUrl + ", instantUploadInfo=" + this.instantUploadInfo + ", image=" + this.image + ", localMessageId=" + this.localMessageId + ", aiCreationImage=" + this.aiCreationImage + ')';
    }

    public final String getActionBarKey() {
        return this.actionBarKey;
    }

    public final Boolean getAiCreationImage() {
        return this.aiCreationImage;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Image getImage() {
        return this.image;
    }

    public final ResourceUploadInstantInfo getInstantUploadInfo() {
        return this.instantUploadInfo;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getServerUrl() {
        return this.serverUrl;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final boolean isImage() {
        return this.isImage;
    }

    public AttachmentInfo(boolean r100, String r101, Integer r102, Integer r103, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, ResourceUploadInstantInfo r119, Image r210, String r211, Boolean r212) {
        Intrinsics.checkNotNullParameter(r101, "tosKey");
        Intrinsics.checkNotNullParameter(r110, "filePath");
        Intrinsics.checkNotNullParameter(r112, "fromScene");
        this.isImage = r100;
        this.tosKey = r101;
        this.height = r102;
        this.width = r103;
        this.filePath = r110;
        this.fileName = r111;
        this.fromScene = r112;
        this.resourceId = r113;
        this.fileIdentifier = r114;
        this.actionBarKey = r115;
        this.enterMethod = r116;
        this.serverUrl = r117;
        this.previewUrl = r118;
        this.instantUploadInfo = r119;
        this.image = r210;
        this.localMessageId = r211;
        this.aiCreationImage = r212;
    }

    public /* synthetic */ AttachmentInfo(boolean r210, String r211, Integer r212, Integer r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, ResourceUploadInstantInfo r314, Image r315, String r316, Boolean r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r318 & 4) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r318 & 8) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r318 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 128) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r318 & 256) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r318 & 512) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r318 & 1024) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r318 & 2048) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r318 & 4096) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r318 & 8192) == 0) goto L45;
        ResourceUploadInstantInfo r116 = null;
    L47:
        if ((r318 & 16384) == 0) goto L49;
        Image r117 = null;
    L51:
        if ((32768 & r318) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r318 & 65536) == 0) goto L57;
        Boolean r119 = null;
    L58:
        this(r100, r211, r101, r102, r214, r103, r216, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L57:
        r119 = r317;
        goto L58
    L53:
        r118 = r316;
        goto L55
    L49:
        r117 = r315;
        goto L51
    L45:
        r116 = r314;
        goto L47
    L41:
        r115 = r313;
        goto L43
    L37:
        r114 = r312;
        goto L39
    L33:
        r113 = r311;
        goto L35
    L29:
        r112 = r310;
        goto L31
    L25:
        r111 = r218;
        goto L27
    L21:
        r110 = r217;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
