package com.obric.assistant.network.api.bean;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0012HÆ\u0003J£\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0012HÆ\u0001J\u0013\u00102\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\tHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageRequest;", "", DBDefinition.TASK_ID, "", "toolId", "encryptedImage", "viewTree", "reactViewTree", DecodeProducer.EXTRA_IMAGE_COUNT, "", "isFinish", "", "mime", "source", "feedback", "Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageFeedback;", "type", "extra", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageFeedback;Ljava/lang/String;Ljava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "getToolId", "getEncryptedImage", "getViewTree", "getReactViewTree", "getImageCount", "()I", "()Z", "getMime", "getSource", "getFeedback", "()Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageFeedback;", "getType", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOmniUploadImageRequest {

    @SerializedName("encrypted_image")
    private final String encryptedImage;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("feedback")
    private final ObricOmniUploadImageFeedback feedback;

    @SerializedName("Image_count")
    private final int imageCount;

    @SerializedName(EventConstant.Key.IS_FINISH)
    private final boolean isFinish;

    @SerializedName("mime")
    private final String mime;

    @SerializedName("react_view_tree")
    private final String reactViewTree;

    @SerializedName("source")
    private final String source;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("tool_id")
    private final String toolId;

    @SerializedName("type")
    private final String type;

    @SerializedName("view_tree")
    private final String viewTree;

    public ObricOmniUploadImageRequest() {
        this(null, null, null, null, null, 0, false, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricOmniUploadImageRequest copy$default(ObricOmniUploadImageRequest r110, String r111, String r112, String r113, String r114, String r115, int r116, boolean r210, String r211, String r212, ObricOmniUploadImageFeedback r213, String r214, Map r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.toolId;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.encryptedImage;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.viewTree;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.reactViewTree;
    L23:
        if ((r216 & 32) == 0) goto L25;
        int r105 = r110.imageCount;
    L27:
        if ((r216 & 64) == 0) goto L29;
        boolean r106 = r110.isFinish;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.mime;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.source;
    L39:
        if ((r216 & 512) == 0) goto L41;
        ObricOmniUploadImageFeedback r118 = r110.feedback;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.type;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r108 = r110.extra;
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

    public final String component1() {
        return this.taskId;
    }

    public final ObricOmniUploadImageFeedback component10() {
        return this.feedback;
    }

    public final String component11() {
        return this.type;
    }

    public final Map<String, String> component12() {
        return this.extra;
    }

    public final String component2() {
        return this.toolId;
    }

    public final String component3() {
        return this.encryptedImage;
    }

    public final String component4() {
        return this.viewTree;
    }

    public final String component5() {
        return this.reactViewTree;
    }

    public final int component6() {
        return this.imageCount;
    }

    public final boolean component7() {
        return this.isFinish;
    }

    public final String component8() {
        return this.mime;
    }

    public final String component9() {
        return this.source;
    }

    public final ObricOmniUploadImageRequest copy(String r110, String r111, String r112, String r113, String r114, int r210, boolean r211, String r212, String r213, ObricOmniUploadImageFeedback r214, String r215, Map<String, String> r216) {
        return new ObricOmniUploadImageRequest(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricOmniUploadImageRequest) == true) goto L8;
        return false;
    L8:
        ObricOmniUploadImageRequest r101 = (ObricOmniUploadImageRequest) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolId, r101.toolId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.encryptedImage, r101.encryptedImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.viewTree, r101.viewTree) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.reactViewTree, r101.reactViewTree) == true) goto L24;
        return false;
    L24:
        if (this.imageCount == r101.imageCount) goto L27;
        return false;
    L27:
        if (this.isFinish == r101.isFinish) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mime, r101.mime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.feedback, r101.feedback) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.toolId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.encryptedImage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.viewTree;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.reactViewTree;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.imageCount) * 31;
        if (this.isFinish == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.mime;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.source;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        ObricOmniUploadImageFeedback r124 = this.feedback;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.type;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        Map<String, String> r130 = this.extra;
        if (r130 == null) goto L47;
        r101 = r130.hashCode();
    L47:
        return r129 + r101;
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
        r116 = 1237;
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
        return "ObricOmniUploadImageRequest(taskId=" + this.taskId + ", toolId=" + this.toolId + ", encryptedImage=" + this.encryptedImage + ", viewTree=" + this.viewTree + ", reactViewTree=" + this.reactViewTree + ", imageCount=" + this.imageCount + ", isFinish=" + this.isFinish + ", mime=" + this.mime + ", source=" + this.source + ", feedback=" + this.feedback + ", type=" + this.type + ", extra=" + this.extra + ')';
    }

    public final String getEncryptedImage() {
        return this.encryptedImage;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final ObricOmniUploadImageFeedback getFeedback() {
        return this.feedback;
    }

    public final int getImageCount() {
        return this.imageCount;
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getReactViewTree() {
        return this.reactViewTree;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToolId() {
        return this.toolId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getViewTree() {
        return this.viewTree;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public ObricOmniUploadImageRequest(String r100, String r101, String r102, String r103, String r104, int r105, boolean r106, String r107, String r108, ObricOmniUploadImageFeedback r110, String r111, Map<String, String> r112) {
        this.taskId = r100;
        this.toolId = r101;
        this.encryptedImage = r102;
        this.viewTree = r103;
        this.reactViewTree = r104;
        this.imageCount = r105;
        this.isFinish = r106;
        this.mime = r107;
        this.source = r108;
        this.feedback = r110;
        this.type = r111;
        this.extra = r112;
    }

    public /* synthetic */ ObricOmniUploadImageRequest(String r110, String r111, String r112, String r113, String r114, int r115, boolean r210, String r211, String r212, ObricOmniUploadImageFeedback r213, String r214, Map r215, int r216, DefaultConstructorMarker r217) {
        Map r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L22:
        boolean r106 = false;
        if ((r216 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r216 & 64) != 0) goto L31;
        r106 = r210;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        ObricOmniUploadImageFeedback r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r107, r106, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
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
