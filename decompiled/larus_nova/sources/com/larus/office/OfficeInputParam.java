package com.larus.office;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.search.v2.DocMeta;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\bV\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010¥\u0001\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u00101\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001c\u0010<\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR\u001c\u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001a\u0010B\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\tR\u001a\u0010E\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00107\"\u0004\bF\u00109R\u001c\u0010G\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0007\"\u0004\bI\u0010\tR\u001c\u0010J\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010\tR\u001e\u0010M\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010S\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR\u001c\u0010V\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0007\"\u0004\bX\u0010\tR\u001c\u0010Y\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0007\"\u0004\b[\u0010\tR\u001c\u0010\\\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR\u001c\u0010_\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0007\"\u0004\b`\u0010\tR\u001c\u0010a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0007\"\u0004\bc\u0010\tR\u001a\u0010d\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00107\"\u0004\bf\u00109R\u001c\u0010g\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\u001c\u0010j\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0007\"\u0004\bl\u0010\tR\u001a\u0010m\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00107\"\u0004\bn\u00109R\u001c\u0010o\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0007\"\u0004\bq\u0010\tR\u001a\u0010r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\r\"\u0004\bt\u0010\u000fR\u001a\u0010u\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00107\"\u0004\bv\u00109R\u001a\u0010w\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u00107\"\u0004\bx\u00109R\u001c\u0010y\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0007\"\u0004\b{\u0010\tR\u001a\u0010|\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\r\"\u0004\b~\u0010\u000fR\u001e\u0010\u007f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0007\"\u0005\b\u0081\u0001\u0010\tR\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010\tR\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0007\"\u0005\b\u0087\u0001\u0010\tR\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008a\u0001\u0010\tR7\u0010\u008b\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u0001j\f\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u0001`\u008e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0007\"\u0005\b\u0095\u0001\u0010\tR\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0007\"\u0005\b\u0098\u0001\u0010\tR!\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0002\u0010R\u001a\u0005\b\u009a\u0001\u0010O\"\u0005\b\u009b\u0001\u0010QR\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010\u0007\"\u0005\b\u009e\u0001\u0010\tR\u001d\u0010\u009f\u0001\u001a\u000205X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u00107\"\u0005\b¡\u0001\u00109R\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0007\"\u0005\b¤\u0001\u0010\t¨\u0006¦\u0001"}, d2 = {"Lcom/larus/office/OfficeInputParam;", "Ljava/io/Serializable;", "<init>", "()V", "resourceId", "", "getResourceId", "()Ljava/lang/String;", "setResourceId", "(Ljava/lang/String;)V", "resourceType", "", "getResourceType", "()I", "setResourceType", "(I)V", "resourceVersion", "getResourceVersion", "setResourceVersion", "slidesToken", "getSlidesToken", "setSlidesToken", DocumentType.SHEET_NAME, "getSheet", "setSheet", "artifactMetaId", "getArtifactMetaId", "setArtifactMetaId", "artifactVersionId", "getArtifactVersionId", "setArtifactVersionId", "conversationId", "getConversationId", "setConversationId", "trackingConversationId", "getTrackingConversationId", "setTrackingConversationId", "clickTimestamp", "", "getClickTimestamp", "()J", "setClickTimestamp", "(J)V", "enterMethod", "getEnterMethod", "setEnterMethod", "beginLoadTimestamp", "getBeginLoadTimestamp", "setBeginLoadTimestamp", "loadSuccessTimestamp", "getLoadSuccessTimestamp", "setLoadSuccessTimestamp", "hasReportFinishEvent", "", "getHasReportFinishEvent", "()Z", "setHasReportFinishEvent", "(Z)V", "isColdStart", "setColdStart", "clickPreviousPage", "getClickPreviousPage", "setClickPreviousPage", "previousPage", "getPreviousPage", "setPreviousPage", "docLogicKey", "getDocLogicKey", "setDocLogicKey", "isOwner", "setOwner", "applyPermissionConversationId", "getApplyPermissionConversationId", "setApplyPermissionConversationId", "applyPermissionMessageId", "getApplyPermissionMessageId", "setApplyPermissionMessageId", "objType", "getObjType", "()Ljava/lang/Integer;", "setObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enterFrom", "getEnterFrom", "setEnterFrom", "feishuRecordId", "getFeishuRecordId", "setFeishuRecordId", "feishuRecordContentType", "getFeishuRecordContentType", "setFeishuRecordContentType", "recordScene", "getRecordScene", "setRecordScene", "isGeneralAgent", "setGeneralAgent", "agentChatId", "getAgentChatId", "setAgentChatId", "docPreloaded", "getDocPreloaded", "setDocPreloaded", "messageId", "getMessageId", "setMessageId", "offlineCreateAttemptId", "getOfflineCreateAttemptId", "setOfflineCreateAttemptId", "isFakeOfflineDoc", "setFakeOfflineDoc", "sourceUrlForParams", "getSourceUrlForParams", "setSourceUrlForParams", "contentLength", "getContentLength", "setContentLength", "isGenerating", "setGenerating", "isMainConv", "setMainConv", "createDocByMsgConvId", "getCreateDocByMsgConvId", "setCreateDocByMsgConvId", "actionBarWidth", "getActionBarWidth", "setActionBarWidth", "sectionId", "getSectionId", "setSectionId", "aiPPTTaskId", "getAiPPTTaskId", "setAiPPTTaskId", "botId", "getBotId", "setBotId", "cotRefArtifacts", "getCotRefArtifacts", "setCotRefArtifacts", "docListToApplyPermission", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/search/v2/DocMeta;", "Lkotlin/collections/ArrayList;", "getDocListToApplyPermission", "()Ljava/util/ArrayList;", "setDocListToApplyPermission", "(Ljava/util/ArrayList;)V", "docTitle", "getDocTitle", "setDocTitle", "type", "getType", "setType", "hostChatThemeStyleResId", "getHostChatThemeStyleResId", "setHostChatThemeStyleResId", "driveOverrideCurrentPage", "getDriveOverrideCurrentPage", "setDriveOverrideCurrentPage", "openChatWithNewLocalConv", "getOpenChatWithNewLocalConv", "setOpenChatWithNewLocalConv", "meetingRecordCreatePlatform", "getMeetingRecordCreatePlatform", "setMeetingRecordCreatePlatform", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInputParam implements Serializable {
    private int actionBarWidth;
    private String agentChatId;
    private String aiPPTTaskId;
    private String applyPermissionConversationId;
    private String applyPermissionMessageId;
    private String artifactMetaId;
    private String artifactVersionId;
    private long beginLoadTimestamp;
    private String botId;
    private String clickPreviousPage;
    private long clickTimestamp;
    private int contentLength;
    private String conversationId;
    private String cotRefArtifacts;
    private String createDocByMsgConvId;
    private ArrayList<DocMeta> docListToApplyPermission;
    private String docLogicKey;
    private boolean docPreloaded;
    private String docTitle;
    private String driveOverrideCurrentPage;
    private String enterFrom;
    private String enterMethod;
    private String feishuRecordContentType;
    private String feishuRecordId;
    private boolean hasReportFinishEvent;
    private Integer hostChatThemeStyleResId;
    private boolean isColdStart;
    private boolean isFakeOfflineDoc;
    private String isGeneralAgent;
    private boolean isGenerating;
    private boolean isMainConv;
    private boolean isOwner;
    private long loadSuccessTimestamp;
    private String meetingRecordCreatePlatform;
    private String messageId;
    private Integer objType;
    private String offlineCreateAttemptId;
    private boolean openChatWithNewLocalConv;
    private String previousPage;
    private String recordScene;
    private String resourceId;
    private int resourceType;
    private int resourceVersion;
    private String sectionId;
    private String sheet;
    private String slidesToken;
    private String sourceUrlForParams;
    private String trackingConversationId;
    private String type;

    public String toString() {
        return "resourceId=" + this.resourceId + ",resourceType=" + this.resourceType + ",resourceVersion=" + this.resourceVersion + ",enterFrom=" + this.enterFrom;
    }

    public OfficeInputParam() {
        this.resourceId = "";
        this.resourceType = 3;
        this.resourceVersion = -1;
        this.slidesToken = "";
        this.sheet = "";
        this.artifactMetaId = "";
        this.artifactVersionId = "";
        this.enterMethod = "";
        this.docLogicKey = "";
        this.isOwner = true;
        this.enterFrom = "";
        this.isMainConv = true;
    }

    public final int getActionBarWidth() {
        return this.actionBarWidth;
    }

    public final String getAgentChatId() {
        return this.agentChatId;
    }

    public final String getAiPPTTaskId() {
        return this.aiPPTTaskId;
    }

    public final String getApplyPermissionConversationId() {
        return this.applyPermissionConversationId;
    }

    public final String getApplyPermissionMessageId() {
        return this.applyPermissionMessageId;
    }

    public final String getArtifactMetaId() {
        return this.artifactMetaId;
    }

    public final String getArtifactVersionId() {
        return this.artifactVersionId;
    }

    public final long getBeginLoadTimestamp() {
        return this.beginLoadTimestamp;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getClickPreviousPage() {
        return this.clickPreviousPage;
    }

    public final long getClickTimestamp() {
        return this.clickTimestamp;
    }

    public final int getContentLength() {
        return this.contentLength;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCotRefArtifacts() {
        return this.cotRefArtifacts;
    }

    public final String getCreateDocByMsgConvId() {
        return this.createDocByMsgConvId;
    }

    public final ArrayList<DocMeta> getDocListToApplyPermission() {
        return this.docListToApplyPermission;
    }

    public final String getDocLogicKey() {
        return this.docLogicKey;
    }

    public final boolean getDocPreloaded() {
        return this.docPreloaded;
    }

    public final String getDocTitle() {
        return this.docTitle;
    }

    public final String getDriveOverrideCurrentPage() {
        return this.driveOverrideCurrentPage;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFeishuRecordContentType() {
        return this.feishuRecordContentType;
    }

    public final String getFeishuRecordId() {
        return this.feishuRecordId;
    }

    public final boolean getHasReportFinishEvent() {
        return this.hasReportFinishEvent;
    }

    public final Integer getHostChatThemeStyleResId() {
        return this.hostChatThemeStyleResId;
    }

    public final long getLoadSuccessTimestamp() {
        return this.loadSuccessTimestamp;
    }

    public final String getMeetingRecordCreatePlatform() {
        return this.meetingRecordCreatePlatform;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final Integer getObjType() {
        return this.objType;
    }

    public final String getOfflineCreateAttemptId() {
        return this.offlineCreateAttemptId;
    }

    public final boolean getOpenChatWithNewLocalConv() {
        return this.openChatWithNewLocalConv;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getRecordScene() {
        return this.recordScene;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getResourceType() {
        return this.resourceType;
    }

    public final int getResourceVersion() {
        return this.resourceVersion;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSheet() {
        return this.sheet;
    }

    public final String getSlidesToken() {
        return this.slidesToken;
    }

    public final String getSourceUrlForParams() {
        return this.sourceUrlForParams;
    }

    public final String getTrackingConversationId() {
        return this.trackingConversationId;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isColdStart() {
        return this.isColdStart;
    }

    public final boolean isFakeOfflineDoc() {
        return this.isFakeOfflineDoc;
    }

    public final String isGeneralAgent() {
        return this.isGeneralAgent;
    }

    public final boolean isGenerating() {
        return this.isGenerating;
    }

    public final boolean isMainConv() {
        return this.isMainConv;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final void setActionBarWidth(int r100) {
        this.actionBarWidth = r100;
    }

    public final void setAgentChatId(String r100) {
        this.agentChatId = r100;
    }

    public final void setAiPPTTaskId(String r100) {
        this.aiPPTTaskId = r100;
    }

    public final void setApplyPermissionConversationId(String r100) {
        this.applyPermissionConversationId = r100;
    }

    public final void setApplyPermissionMessageId(String r100) {
        this.applyPermissionMessageId = r100;
    }

    public final void setArtifactMetaId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.artifactMetaId = r100;
    }

    public final void setArtifactVersionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.artifactVersionId = r100;
    }

    public final void setBeginLoadTimestamp(long r100) {
        this.beginLoadTimestamp = r100;
    }

    public final void setBotId(String r100) {
        this.botId = r100;
    }

    public final void setClickPreviousPage(String r100) {
        this.clickPreviousPage = r100;
    }

    public final void setClickTimestamp(long r100) {
        this.clickTimestamp = r100;
    }

    public final void setColdStart(boolean r100) {
        this.isColdStart = r100;
    }

    public final void setContentLength(int r100) {
        this.contentLength = r100;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setCotRefArtifacts(String r100) {
        this.cotRefArtifacts = r100;
    }

    public final void setCreateDocByMsgConvId(String r100) {
        this.createDocByMsgConvId = r100;
    }

    public final void setDocListToApplyPermission(ArrayList<DocMeta> r100) {
        this.docListToApplyPermission = r100;
    }

    public final void setDocLogicKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docLogicKey = r100;
    }

    public final void setDocPreloaded(boolean r100) {
        this.docPreloaded = r100;
    }

    public final void setDocTitle(String r100) {
        this.docTitle = r100;
    }

    public final void setDriveOverrideCurrentPage(String r100) {
        this.driveOverrideCurrentPage = r100;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setFakeOfflineDoc(boolean r100) {
        this.isFakeOfflineDoc = r100;
    }

    public final void setFeishuRecordContentType(String r100) {
        this.feishuRecordContentType = r100;
    }

    public final void setFeishuRecordId(String r100) {
        this.feishuRecordId = r100;
    }

    public final void setGeneralAgent(String r100) {
        this.isGeneralAgent = r100;
    }

    public final void setGenerating(boolean r100) {
        this.isGenerating = r100;
    }

    public final void setHasReportFinishEvent(boolean r100) {
        this.hasReportFinishEvent = r100;
    }

    public final void setHostChatThemeStyleResId(Integer r100) {
        this.hostChatThemeStyleResId = r100;
    }

    public final void setLoadSuccessTimestamp(long r100) {
        this.loadSuccessTimestamp = r100;
    }

    public final void setMainConv(boolean r100) {
        this.isMainConv = r100;
    }

    public final void setMeetingRecordCreatePlatform(String r100) {
        this.meetingRecordCreatePlatform = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setObjType(Integer r100) {
        this.objType = r100;
    }

    public final void setOfflineCreateAttemptId(String r100) {
        this.offlineCreateAttemptId = r100;
    }

    public final void setOpenChatWithNewLocalConv(boolean r100) {
        this.openChatWithNewLocalConv = r100;
    }

    public final void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setRecordScene(String r100) {
        this.recordScene = r100;
    }

    public final void setResourceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resourceId = r100;
    }

    public final void setResourceType(int r100) {
        this.resourceType = r100;
    }

    public final void setResourceVersion(int r100) {
        this.resourceVersion = r100;
    }

    public final void setSectionId(String r100) {
        this.sectionId = r100;
    }

    public final void setSheet(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sheet = r100;
    }

    public final void setSlidesToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.slidesToken = r100;
    }

    public final void setSourceUrlForParams(String r100) {
        this.sourceUrlForParams = r100;
    }

    public final void setTrackingConversationId(String r100) {
        this.trackingConversationId = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
