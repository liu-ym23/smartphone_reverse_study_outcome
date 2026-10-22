package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/ImPermEntity;", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "senderUserId", "", "senderTenantId", "msgId", "fileKey", "chatID", "chatType", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getSenderUserId", "()Ljava/lang/Long;", "setSenderUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSenderTenantId", "setSenderTenantId", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getFileKey", "setFileKey", "getChatID", "setChatID", "getChatType", "setChatType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImPermEntity extends BaseEntity {
    private Long chatID;
    private Long chatType;
    private String fileKey;
    private String msgId;
    private Long senderTenantId;
    private Long senderUserId;

    public final Long getChatID() {
        return this.chatID;
    }

    public final Long getChatType() {
        return this.chatType;
    }

    public final String getFileKey() {
        return this.fileKey;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final Long getSenderTenantId() {
        return this.senderTenantId;
    }

    public final Long getSenderUserId() {
        return this.senderUserId;
    }

    public final void setChatID(Long r1) {
        this.chatID = r1;
    }

    public final void setChatType(Long r1) {
        this.chatType = r1;
    }

    public final void setFileKey(String r1) {
        this.fileKey = r1;
    }

    public final void setMsgId(String r1) {
        this.msgId = r1;
    }

    public final void setSenderTenantId(Long r1) {
        this.senderTenantId = r1;
    }

    public final void setSenderUserId(Long r1) {
        this.senderUserId = r1;
    }

    public ImPermEntity(String r1, e r2, BizDomain r3, String r4, Long r5, Long r6, String r7, String r8, Long r9, Long r10) {
        super(r1, r2, r3, r4);
        this.senderUserId = r5;
        this.senderTenantId = r6;
        this.msgId = r7;
        this.fileKey = r8;
        this.chatID = r9;
        this.chatType = r10;
    }

    public /* synthetic */ ImPermEntity(String r15, e r16, BizDomain r17, String r18, Long r19, Long r20, String r21, String r22, Long r23, Long r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 16) == 0) goto L5;
        Long r8 = null;
    L7:
        if ((r25 & 32) == 0) goto L9;
        Long r9 = null;
    L11:
        if ((r25 & 64) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r25 & 128) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r25 & 256) == 0) goto L21;
        Long r12 = null;
    L23:
        if ((r25 & 512) == 0) goto L25;
        Long r13 = null;
    L26:
        this(r15, r16, r17, r18, r8, r9, r10, r11, r12, r13);
        return;
    L25:
        r13 = r24;
        goto L26
    L21:
        r12 = r23;
        goto L23
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r8 = r19;
        goto L7
    }
}
