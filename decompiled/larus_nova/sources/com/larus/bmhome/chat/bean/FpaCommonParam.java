package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/bean/FpaCommonParam;", "", "agentId", "", "agentIntention", "scene", "secEnterMethod", "bizType", "action", "isAIPodcast", "aiPodcastContentSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgentId", "()Ljava/lang/String;", "setAgentId", "(Ljava/lang/String;)V", "getAgentIntention", "setAgentIntention", "getScene", "setScene", "getSecEnterMethod", "setSecEnterMethod", "getBizType", "setBizType", "getAction", "setAction", "getAiPodcastContentSource", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FpaCommonParam {

    @SerializedName("action")
    private String action;

    @SerializedName("agent_id")
    private String agentId;

    @SerializedName("agent_intention")
    private String agentIntention;

    @SerializedName("ai_podcast_content_source")
    private final String aiPodcastContentSource;

    @SerializedName("biz_type")
    private String bizType;

    @SerializedName("is_ai_podcast")
    private final String isAIPodcast;

    @SerializedName("scene")
    private String scene;

    @SerializedName("sec_enter_method")
    private String secEnterMethod;

    public FpaCommonParam() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentIntention() {
        return this.agentIntention;
    }

    public final String getAiPodcastContentSource() {
        return this.aiPodcastContentSource;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSecEnterMethod() {
        return this.secEnterMethod;
    }

    public final String isAIPodcast() {
        return this.isAIPodcast;
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setAgentId(String r100) {
        this.agentId = r100;
    }

    public final void setAgentIntention(String r100) {
        this.agentIntention = r100;
    }

    public final void setBizType(String r100) {
        this.bizType = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setSecEnterMethod(String r100) {
        this.secEnterMethod = r100;
    }

    public FpaCommonParam(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.agentId = r100;
        this.agentIntention = r101;
        this.scene = r102;
        this.secEnterMethod = r103;
        this.bizType = r104;
        this.action = r105;
        this.isAIPodcast = r106;
        this.aiPodcastContentSource = r107;
    }

    public /* synthetic */ FpaCommonParam(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
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
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
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
