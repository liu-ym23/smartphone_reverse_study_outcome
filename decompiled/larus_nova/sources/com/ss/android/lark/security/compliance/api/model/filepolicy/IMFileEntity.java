package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\b\u0007\u0018\u00002\u00020\u0001B§\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%¨\u00062"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/IMFileEntity;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "entityType", "", "entityDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "entityOperate", "operatorTenantId", "", "operatorUid", "fileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "senderUserId", "senderTenantId", RemoteMessageConst.MSGID, "fileKey", "chatID", "chatType", "scopedFileBizDomain", "scopedEntityOperate", "scopedEntityType", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;Ljava/lang/String;JJLcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/String;)V", "getFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "setFileBizDomain", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;)V", "getSenderUserId", "()Ljava/lang/Long;", "setSenderUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSenderTenantId", "setSenderTenantId", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getFileKey", "setFileKey", "getChatID", "setChatID", "getChatType", "setChatType", "getScopedFileBizDomain", "setScopedFileBizDomain", "getScopedEntityOperate", "setScopedEntityOperate", "getScopedEntityType", "setScopedEntityType", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMFileEntity extends PolicyEntity {
    private Long chatID;
    private Long chatType;
    private FileBizDomain fileBizDomain;
    private String fileKey;
    private String msgId;
    private String scopedEntityOperate;
    private String scopedEntityType;
    private FileBizDomain scopedFileBizDomain;
    private Long senderTenantId;
    private Long senderUserId;

    public final Long getChatID() {
        return this.chatID;
    }

    public final Long getChatType() {
        return this.chatType;
    }

    public final FileBizDomain getFileBizDomain() {
        return this.fileBizDomain;
    }

    public final String getFileKey() {
        return this.fileKey;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getScopedEntityOperate() {
        return this.scopedEntityOperate;
    }

    public final String getScopedEntityType() {
        return this.scopedEntityType;
    }

    public final FileBizDomain getScopedFileBizDomain() {
        return this.scopedFileBizDomain;
    }

    public final Long getSenderTenantId() {
        return this.senderTenantId;
    }

    public final Long getSenderUserId() {
        return this.senderUserId;
    }

    public final void setChatID(Long r100) {
        this.chatID = r100;
    }

    public final void setChatType(Long r100) {
        this.chatType = r100;
    }

    public final void setFileBizDomain(FileBizDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileBizDomain = r100;
    }

    public final void setFileKey(String r100) {
        this.fileKey = r100;
    }

    public final void setMsgId(String r100) {
        this.msgId = r100;
    }

    public final void setScopedEntityOperate(String r100) {
        this.scopedEntityOperate = r100;
    }

    public final void setScopedEntityType(String r100) {
        this.scopedEntityType = r100;
    }

    public final void setScopedFileBizDomain(FileBizDomain r100) {
        this.scopedFileBizDomain = r100;
    }

    public final void setSenderTenantId(Long r100) {
        this.senderTenantId = r100;
    }

    public final void setSenderUserId(Long r100) {
        this.senderUserId = r100;
    }

    public IMFileEntity(@EntityType String r100, EntityDomain r101, @EntityOperate String r110, long r111, long r112, FileBizDomain r113, Long r114, Long r115, String r116, String r117, Long r210, Long r211, FileBizDomain r212, String r213, @EntityType String r214) {
        Intrinsics.checkNotNullParameter(r100, "entityType");
        Intrinsics.checkNotNullParameter(r101, "entityDomain");
        Intrinsics.checkNotNullParameter(r110, "entityOperate");
        Intrinsics.checkNotNullParameter(r113, "fileBizDomain");
        super(r100, r101, r110, r111, r112);
        this.fileBizDomain = r113;
        this.senderUserId = r114;
        this.senderTenantId = r115;
        this.msgId = r116;
        this.fileKey = r117;
        this.chatID = r210;
        this.chatType = r211;
        this.scopedFileBizDomain = r212;
        this.scopedEntityOperate = r213;
        this.scopedEntityType = r214;
        String r102 = null;
        if (r116 != null) goto L5;
    L11:
        this.msgId = r102;
        return;
    L5:
        if (r116.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = r116;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public /* synthetic */ IMFileEntity(String r210, EntityDomain r211, String r212, long r213, long r214, FileBizDomain r215, Long r310, Long r311, String r312, String r313, Long r314, Long r315, FileBizDomain r316, String r317, String r318, int r319, DefaultConstructorMarker r410) {
        if ((r319 & 64) == 0) goto L5;
        Long r110 = null;
    L7:
        if ((r319 & 128) == 0) goto L9;
        Long r111 = null;
    L11:
        if ((r319 & 256) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r319 & 512) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r319 & 1024) == 0) goto L21;
        Long r114 = null;
    L23:
        if ((r319 & 2048) == 0) goto L25;
        Long r115 = null;
    L27:
        if ((r319 & 4096) == 0) goto L29;
        FileBizDomain r116 = null;
    L31:
        if ((r319 & 8192) == 0) goto L33;
        String r117 = null;
    L35:
        if ((r319 & 16384) == 0) goto L37;
        String r216 = null;
    L38:
        this(r210, r211, r212, r213, r214, r215, r110, r111, r112, r113, r114, r115, r116, r117, r216);
        return;
    L37:
        r216 = r318;
        goto L38
    L33:
        r117 = r317;
        goto L35
    L29:
        r116 = r316;
        goto L31
    L25:
        r115 = r315;
        goto L27
    L21:
        r114 = r314;
        goto L23
    L17:
        r113 = r313;
        goto L19
    L13:
        r112 = r312;
        goto L15
    L9:
        r111 = r311;
        goto L11
    L5:
        r110 = r310;
        goto L7
    }
}
