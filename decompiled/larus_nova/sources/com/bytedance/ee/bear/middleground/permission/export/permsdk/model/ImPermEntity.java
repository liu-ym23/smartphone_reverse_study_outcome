package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/ImPermEntity;", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", "token", "", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "senderUserId", "", "senderTenantId", RemoteMessageConst.MSGID, "fileKey", "chatID", "chatType", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getSenderUserId", "()Ljava/lang/Long;", "setSenderUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSenderTenantId", "setSenderTenantId", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getFileKey", "setFileKey", "getChatID", "setChatID", "getChatType", "setChatType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public final void setChatID(Long r100) {
        this.chatID = r100;
    }

    public final void setChatType(Long r100) {
        this.chatType = r100;
    }

    public final void setFileKey(String r100) {
        this.fileKey = r100;
    }

    public final void setMsgId(String r100) {
        this.msgId = r100;
    }

    public final void setSenderTenantId(Long r100) {
        this.senderTenantId = r100;
    }

    public final void setSenderUserId(Long r100) {
        this.senderUserId = r100;
    }

    public ImPermEntity(String r100, e r101, BizDomain r102, String r103, Long r104, Long r105, String r106, String r107, Long r108, Long r110) {
        super(r100, r101, r102, r103);
        this.senderUserId = r104;
        this.senderTenantId = r105;
        this.msgId = r106;
        this.fileKey = r107;
        this.chatID = r108;
        this.chatType = r110;
    }

    public /* synthetic */ ImPermEntity(String r110, e r111, BizDomain r112, String r113, Long r114, Long r210, String r211, String r212, Long r213, Long r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 16) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r215 & 32) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r215 & 64) == 0) goto L13;
        String r115 = null;
    L15:
        if ((r215 & 128) == 0) goto L17;
        String r116 = null;
    L19:
        if ((r215 & 256) == 0) goto L21;
        Long r117 = null;
    L23:
        if ((r215 & 512) == 0) goto L25;
        Long r118 = null;
    L26:
        this(r110, r111, r112, r113, r100, r101, r115, r116, r117, r118);
        return;
    L25:
        r118 = r214;
        goto L26
    L21:
        r117 = r213;
        goto L23
    L17:
        r116 = r212;
        goto L19
    L13:
        r115 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
