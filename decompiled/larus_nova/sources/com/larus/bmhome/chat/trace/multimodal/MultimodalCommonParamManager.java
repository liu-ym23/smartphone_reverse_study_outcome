package com.larus.bmhome.chat.trace.multimodal;

import androidx.collection.LruCache;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
public final class MultimodalCommonParamManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, CommonParam> f310238a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b3\b\u0007\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010A\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001e\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b9\u00103\"\u0004\b:\u00105R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b;\u00103\"\u0004\b<\u00105R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b?\u00103\"\u0004\b@\u00105¨\u0006B"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalCommonParamManager$CommonParam;", "", "localSendMsgId", "", "scene", "cvsId", "botId", "chatType", "fileSize", "", "fileType", "fileAttachmentType", "fileMD5", "pendingInvoked", "startProcessTime", "", "preProcessReadyTime", "uploadedToServerTime", "uploadReadyTime", "localProcessDuration", "processSuccessTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getLocalSendMsgId", "()Ljava/lang/String;", "setLocalSendMsgId", "(Ljava/lang/String;)V", "getScene", "setScene", "getCvsId", "setCvsId", "getBotId", "setBotId", "getChatType", "setChatType", "getFileSize", "()Ljava/lang/Integer;", "setFileSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFileType", "setFileType", "getFileAttachmentType", "setFileAttachmentType", "getFileMD5", "setFileMD5", "getPendingInvoked", "()I", "setPendingInvoked", "(I)V", "getStartProcessTime", "()Ljava/lang/Long;", "setStartProcessTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPreProcessReadyTime", "setPreProcessReadyTime", "getUploadedToServerTime", "setUploadedToServerTime", "getUploadReadyTime", "setUploadReadyTime", "getLocalProcessDuration", "setLocalProcessDuration", "getProcessSuccessTime", "setProcessSuccessTime", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommonParam {

        @SerializedName("bot_id")
        private String botId;

        @SerializedName("chat_type")
        private String chatType;

        @SerializedName("conversation_id")
        private String cvsId;

        @SerializedName("attachment_area_type")
        private Integer fileAttachmentType;

        @SerializedName("send_file_md5")
        private String fileMD5;

        @SerializedName("send_file_size")
        private Integer fileSize;

        @SerializedName("send_file_type")
        private String fileType;
        private transient Long localProcessDuration;

        @SerializedName("local_message_id")
        private String localSendMsgId;

        @SerializedName("pending_invoked")
        private int pendingInvoked;
        private transient Long preProcessReadyTime;
        private transient Long processSuccessTime;

        @SerializedName("scene")
        private String scene;
        private transient Long startProcessTime;
        private transient Long uploadReadyTime;
        private transient Long uploadedToServerTime;

        public CommonParam() {
            this(null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, 65535, null);
        }

        public String toString() {
            return "scene=" + this.scene + ", localSendMsgId=" + this.localSendMsgId + ", cvsId=" + this.cvsId + ", botId=" + this.botId + ", chatType=" + this.chatType;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getChatType() {
            return this.chatType;
        }

        public final String getCvsId() {
            return this.cvsId;
        }

        public final Integer getFileAttachmentType() {
            return this.fileAttachmentType;
        }

        public final String getFileMD5() {
            return this.fileMD5;
        }

        public final Integer getFileSize() {
            return this.fileSize;
        }

        public final String getFileType() {
            return this.fileType;
        }

        public final Long getLocalProcessDuration() {
            return this.localProcessDuration;
        }

        public final String getLocalSendMsgId() {
            return this.localSendMsgId;
        }

        public final int getPendingInvoked() {
            return this.pendingInvoked;
        }

        public final Long getPreProcessReadyTime() {
            return this.preProcessReadyTime;
        }

        public final Long getProcessSuccessTime() {
            return this.processSuccessTime;
        }

        public final String getScene() {
            return this.scene;
        }

        public final Long getStartProcessTime() {
            return this.startProcessTime;
        }

        public final Long getUploadReadyTime() {
            return this.uploadReadyTime;
        }

        public final Long getUploadedToServerTime() {
            return this.uploadedToServerTime;
        }

        public final void setBotId(String r100) {
            this.botId = r100;
        }

        public final void setChatType(String r100) {
            this.chatType = r100;
        }

        public final void setCvsId(String r100) {
            this.cvsId = r100;
        }

        public final void setFileAttachmentType(Integer r100) {
            this.fileAttachmentType = r100;
        }

        public final void setFileMD5(String r100) {
            this.fileMD5 = r100;
        }

        public final void setFileSize(Integer r100) {
            this.fileSize = r100;
        }

        public final void setFileType(String r100) {
            this.fileType = r100;
        }

        public final void setLocalProcessDuration(Long r100) {
            this.localProcessDuration = r100;
        }

        public final void setLocalSendMsgId(String r100) {
            this.localSendMsgId = r100;
        }

        public final void setPendingInvoked(int r100) {
            this.pendingInvoked = r100;
        }

        public final void setPreProcessReadyTime(Long r100) {
            this.preProcessReadyTime = r100;
        }

        public final void setProcessSuccessTime(Long r100) {
            this.processSuccessTime = r100;
        }

        public final void setScene(String r100) {
            this.scene = r100;
        }

        public final void setStartProcessTime(Long r100) {
            this.startProcessTime = r100;
        }

        public final void setUploadReadyTime(Long r100) {
            this.uploadReadyTime = r100;
        }

        public final void setUploadedToServerTime(Long r100) {
            this.uploadedToServerTime = r100;
        }

        public CommonParam(String r100, String r101, String r102, String r103, String r104, Integer r105, String r106, Integer r110, String r111, int r112, Long r113, Long r114, Long r115, Long r116, Long r117, Long r118) {
            this.localSendMsgId = r100;
            this.scene = r101;
            this.cvsId = r102;
            this.botId = r103;
            this.chatType = r104;
            this.fileSize = r105;
            this.fileType = r106;
            this.fileAttachmentType = r110;
            this.fileMD5 = r111;
            this.pendingInvoked = r112;
            this.startProcessTime = r113;
            this.preProcessReadyTime = r114;
            this.uploadedToServerTime = r115;
            this.uploadReadyTime = r116;
            this.localProcessDuration = r117;
            this.processSuccessTime = r118;
        }

        public /* synthetic */ CommonParam(String r110, String r111, String r210, String r211, String r212, Integer r213, String r214, Integer r215, String r216, int r217, Long r218, Long r219, Long r310, Long r311, Long r312, Long r313, int r314, DefaultConstructorMarker r315) {
            if ((r314 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r314 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r314 & 4) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r314 & 8) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r314 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r314 & 32) == 0) goto L25;
            Integer r105 = null;
        L27:
            if ((r314 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r314 & 128) == 0) goto L33;
            Integer r107 = null;
        L35:
            if ((r314 & 256) == 0) goto L37;
            String r112 = null;
        L39:
            if ((r314 & 512) == 0) goto L41;
            int r113 = 0;
        L43:
            if ((r314 & 1024) == 0) goto L45;
            Long r114 = null;
        L47:
            if ((r314 & 2048) == 0) goto L49;
            Long r115 = null;
        L51:
            if ((r314 & 4096) == 0) goto L53;
            Long r116 = null;
        L55:
            if ((r314 & 8192) == 0) goto L57;
            Long r117 = null;
        L59:
            if ((r314 & 16384) == 0) goto L61;
            Long r108 = null;
        L63:
            if ((r314 & 32768) == 0) goto L65;
            Long r109 = null;
        L66:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
            return;
        L65:
            r109 = r313;
            goto L66
        L61:
            r108 = r312;
            goto L63
        L57:
            r117 = r311;
            goto L59
        L53:
            r116 = r310;
            goto L55
        L49:
            r115 = r219;
            goto L51
        L45:
            r114 = r218;
            goto L47
        L41:
            r113 = r217;
            goto L43
        L37:
            r112 = r216;
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
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    static {
        f310238a = new LruCache(50);
    }

    public static CommonParam a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return f310238a.get(r100);
    }

    public static void b(String r100) {
        if (r100 == null) goto L5;
        CommonParam r101 = f310238a.remove(r100);
        return;
    }
}
