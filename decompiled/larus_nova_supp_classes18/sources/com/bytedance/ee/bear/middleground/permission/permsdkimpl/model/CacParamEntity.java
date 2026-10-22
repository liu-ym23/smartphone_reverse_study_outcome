package com.bytedance.ee.bear.middleground.permission.permsdkimpl.model;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b?\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0081\u0001\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010-\"\u0004\b.\u0010\u0005R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010\u0005R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001aR&\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001aR\u001c\u0010>\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010\u001aR\u001e\u0010A\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010G\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\u001e\u0010J\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bK\u0010C\"\u0004\bL\u0010E¨\u0006M"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permsdkimpl/model/CacParamEntity;", "", "shouldCheck", "", "<init>", "(Z)V", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", WikiFolderPushPlugin.OPT, "domain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "senderTenantId", "", "ownerUserId", "creatorTenantId", "tokenEntityType", "isAdd", "scopedFileBizDomain", "scopedEntityOperate", "scopedEntityType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/String;)V", "getOperation", "()Ljava/lang/String;", "setOperation", "(Ljava/lang/String;)V", "getDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "setDomain", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;)V", "getType", "()I", "setType", "(I)V", "getToken", "setToken", "getSenderTenantId", "()J", "setSenderTenantId", "(J)V", "getOwnerUserId", "setOwnerUserId", "getCreatorTenantId", "setCreatorTenantId", "()Z", "setAdd", "getTokenEntityType", "()Ljava/lang/Integer;", "setTokenEntityType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShouldCheck", "setShouldCheck", "getScopedFileBizDomain", "setScopedFileBizDomain", "getScopedEntityOperate", "setScopedEntityOperate", "getScopedEntityType$annotations", "()V", "getScopedEntityType", "setScopedEntityType", "msgId", "getMsgId", "setMsgId", "chatID", "getChatID", "()Ljava/lang/Long;", "setChatID", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "chatType", "getChatType", "setChatType", "senderUserId", "getSenderUserId", "setSenderUserId", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacParamEntity {
    private Long chatID;
    private Long chatType;
    private String creatorTenantId;
    private FileBizDomain domain;
    private boolean isAdd;
    private String msgId;
    private String operation;
    private String ownerUserId;
    private String scopedEntityOperate;
    private String scopedEntityType;
    private FileBizDomain scopedFileBizDomain;
    private long senderTenantId;
    private Long senderUserId;
    private boolean shouldCheck;
    private String token;
    private Integer tokenEntityType;
    private int type;

    @EntityType
    public static /* synthetic */ void getScopedEntityType$annotations() {
    }

    public final Long getChatID() {
        return this.chatID;
    }

    public final Long getChatType() {
        return this.chatType;
    }

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final FileBizDomain getDomain() {
        return this.domain;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getOwnerUserId() {
        return this.ownerUserId;
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

    public final long getSenderTenantId() {
        return this.senderTenantId;
    }

    public final Long getSenderUserId() {
        return this.senderUserId;
    }

    public final boolean getShouldCheck() {
        return this.shouldCheck;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getTokenEntityType() {
        return this.tokenEntityType;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isAdd() {
        return this.isAdd;
    }

    public CacParamEntity(boolean r2) {
        this.operation = "";
        this.domain = FileBizDomain.FileBizDomainCCM;
        this.type = -1;
        this.shouldCheck = r2;
    }

    public final void setAdd(boolean r1) {
        this.isAdd = r1;
    }

    public final void setChatID(Long r1) {
        this.chatID = r1;
    }

    public final void setChatType(Long r1) {
        this.chatType = r1;
    }

    public final void setCreatorTenantId(String r1) {
        this.creatorTenantId = r1;
    }

    public final void setDomain(FileBizDomain r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.domain = r2;
    }

    public final void setMsgId(String r1) {
        this.msgId = r1;
    }

    public final void setOperation(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.operation = r2;
    }

    public final void setOwnerUserId(String r1) {
        this.ownerUserId = r1;
    }

    public final void setScopedEntityOperate(String r1) {
        this.scopedEntityOperate = r1;
    }

    public final void setScopedEntityType(String r1) {
        this.scopedEntityType = r1;
    }

    public final void setScopedFileBizDomain(FileBizDomain r1) {
        this.scopedFileBizDomain = r1;
    }

    public final void setSenderTenantId(long r1) {
        this.senderTenantId = r1;
    }

    public final void setSenderUserId(Long r1) {
        this.senderUserId = r1;
    }

    public final void setShouldCheck(boolean r1) {
        this.shouldCheck = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setTokenEntityType(Integer r1) {
        this.tokenEntityType = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public CacParamEntity(String r3, Integer r4, String r5, FileBizDomain r6, Long r7, String r8, String r9, Integer r10, boolean r11, FileBizDomain r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r6, "domain");
        this.operation = "";
        this.domain = FileBizDomain.FileBizDomainCCM;
        int r0 = -1;
        this.type = -1;
        this.shouldCheck = true;
        this.token = r3;
        if (r4 == null) goto L5;
        r0 = r4.intValue();
    L5:
        this.type = r0;
        this.operation = r5;
        this.domain = r6;
        if (r7 == null) goto L8;
        this.senderTenantId = r7.longValue();
    L8:
        this.ownerUserId = r8;
        this.creatorTenantId = r9;
        this.tokenEntityType = r10;
        this.isAdd = r11;
        this.scopedFileBizDomain = r12;
        this.scopedEntityOperate = r13;
        this.scopedEntityType = r14;
    }

    public /* synthetic */ CacParamEntity(String r17, Integer r18, String r19, FileBizDomain r20, Long r21, String r22, String r23, Integer r24, boolean r25, FileBizDomain r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 512) == 0) goto L5;
        FileBizDomain r13 = null;
    L7:
        if ((r29 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r29 & DocUserPermission.USER_PREVIEW) == 0) goto L13;
        String r15 = null;
    L14:
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r13, r14, r15);
        return;
    L13:
        r15 = r28;
        goto L14
    L9:
        r14 = r27;
        goto L11
    L5:
        r13 = r26;
        goto L7
    }
}
