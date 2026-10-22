package com.obric.assistant.cocreationreview;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0080\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", "", "uniqId", "", "source", EventConstant.Key.MODULE, "", PromotionProductPrivilegesStruct.TAGS, "", "feedbackType", "content", "logId", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "extra", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getUniqId", "()Ljava/lang/String;", "getSource", "getModule", "()I", "getTags", "()Ljava/util/List;", "getFeedbackType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "getLogId", "getAttachment", "getExtra", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackRequest;", "equals", "", "other", "hashCode", "toString", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationUserFeedbackRequest {

    @SerializedName(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT)
    private final String attachment;

    @SerializedName("content")
    private final String content;

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("feedback_type")
    private final Integer feedbackType;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName(EventConstant.Key.MODULE)
    private final int module;

    @SerializedName("source")
    private final String source;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<String> tags;

    @SerializedName("uniq_id")
    private final String uniqId;

    public CocreationUserFeedbackRequest() {
        this(null, null, 0, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CocreationUserFeedbackRequest copy$default(CocreationUserFeedbackRequest r110, String r111, String r112, int r113, List r114, Integer r115, String r116, String r117, String r118, JsonObject r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.uniqId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.source;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.module;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r103 = r110.tags;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Integer r104 = r110.feedbackType;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.content;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.logId;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.attachment;
    L35:
        if ((r210 & 256) == 0) goto L37;
        JsonObject r108 = r110.extra;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
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
        return this.uniqId;
    }

    public final String component2() {
        return this.source;
    }

    public final int component3() {
        return this.module;
    }

    public final List<String> component4() {
        return this.tags;
    }

    public final Integer component5() {
        return this.feedbackType;
    }

    public final String component6() {
        return this.content;
    }

    public final String component7() {
        return this.logId;
    }

    public final String component8() {
        return this.attachment;
    }

    public final JsonObject component9() {
        return this.extra;
    }

    public final CocreationUserFeedbackRequest copy(String r110, String r111, int r112, List<String> r113, Integer r114, String r115, String r116, String r117, JsonObject r210) {
        return new CocreationUserFeedbackRequest(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CocreationUserFeedbackRequest) == true) goto L8;
        return false;
    L8:
        CocreationUserFeedbackRequest r101 = (CocreationUserFeedbackRequest) r100;
        if (Intrinsics.areEqual(this.uniqId, r101.uniqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L15;
        return false;
    L15:
        if (this.module == r101.module) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.feedbackType, r101.feedbackType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.attachment, r101.attachment) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.uniqId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.source;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.module) * 31;
        List<String> r107 = this.tags;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.feedbackType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.content;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.logId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.attachment;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        JsonObject r122 = this.extra;
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
        return "CocreationUserFeedbackRequest(uniqId=" + this.uniqId + ", source=" + this.source + ", module=" + this.module + ", tags=" + this.tags + ", feedbackType=" + this.feedbackType + ", content=" + this.content + ", logId=" + this.logId + ", attachment=" + this.attachment + ", extra=" + this.extra + ')';
    }

    public final String getAttachment() {
        return this.attachment;
    }

    public final String getContent() {
        return this.content;
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final Integer getFeedbackType() {
        return this.feedbackType;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getModule() {
        return this.module;
    }

    public final String getSource() {
        return this.source;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public CocreationUserFeedbackRequest(String r100, String r101, int r102, List<String> r103, Integer r104, String r105, String r106, String r107, JsonObject r108) {
        this.uniqId = r100;
        this.source = r101;
        this.module = r102;
        this.tags = r103;
        this.feedbackType = r104;
        this.content = r105;
        this.logId = r106;
        this.attachment = r107;
        this.extra = r108;
    }

    public /* synthetic */ CocreationUserFeedbackRequest(String r110, String r111, int r112, List r113, Integer r114, String r115, String r116, String r117, JsonObject r118, int r210, DefaultConstructorMarker r211) {
        JsonObject r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
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
