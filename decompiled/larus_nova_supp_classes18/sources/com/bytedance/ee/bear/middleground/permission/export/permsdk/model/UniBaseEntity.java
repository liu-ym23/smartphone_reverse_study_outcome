package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UniBaseEntity;", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "ownerUserId", "tokenEntityType", "scopedFileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "scopedEntityOperate", "scopedEntityType", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/String;)V", "getOwnerUserId", "()Ljava/lang/String;", "setOwnerUserId", "(Ljava/lang/String;)V", "getTokenEntityType", "()Lcom/ss/android/lark/docs/icon/util/DocumentType;", "setTokenEntityType", "(Lcom/ss/android/lark/docs/icon/util/DocumentType;)V", "getScopedFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "setScopedFileBizDomain", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;)V", "getScopedEntityOperate", "setScopedEntityOperate", "getScopedEntityType", "setScopedEntityType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniBaseEntity extends BaseEntity {
    private String ownerUserId;
    private String scopedEntityOperate;
    private String scopedEntityType;
    private FileBizDomain scopedFileBizDomain;
    private e tokenEntityType;

    public UniBaseEntity(String r13, e r14, BizDomain r15) {
        this(r13, r14, r15, null, null, null, null, null, null, 504, null);
    }

    public UniBaseEntity(String r13, e r14, BizDomain r15, String r16) {
        this(r13, r14, r15, r16, null, null, null, null, null, 496, null);
    }

    public UniBaseEntity(String r13, e r14, BizDomain r15, String r16, String r17) {
        this(r13, r14, r15, r16, r17, null, null, null, null, 480, null);
    }

    public UniBaseEntity(String r13, e r14, BizDomain r15, String r16, String r17, e r18) {
        this(r13, r14, r15, r16, r17, r18, null, null, null, 448, null);
    }

    public UniBaseEntity(String r13, e r14, BizDomain r15, String r16, String r17, e r18, FileBizDomain r19) {
        this(r13, r14, r15, r16, r17, r18, r19, null, null, 384, null);
    }

    public UniBaseEntity(String r13, e r14, BizDomain r15, String r16, String r17, e r18, FileBizDomain r19, @EntityOperate String r20) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, null, 256, null);
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

    public final e getTokenEntityType() {
        return this.tokenEntityType;
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

    public final void setTokenEntityType(e r1) {
        this.tokenEntityType = r1;
    }

    public UniBaseEntity(String r1, e r2, BizDomain r3, String r4, String r5, e r6, FileBizDomain r7, @EntityOperate String r8, @EntityType String r9) {
        super(r1, r2, r3, r4);
        this.ownerUserId = r5;
        this.tokenEntityType = r6;
        this.scopedFileBizDomain = r7;
        this.scopedEntityOperate = r8;
        this.scopedEntityType = r9;
    }

    public /* synthetic */ UniBaseEntity(String r14, e r15, BizDomain r16, String r17, String r18, e r19, FileBizDomain r20, String r21, String r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r23 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r23 & 32) == 0) goto L13;
        e r9 = null;
    L15:
        if ((r23 & 64) == 0) goto L17;
        FileBizDomain r10 = null;
    L19:
        if ((r23 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r23 & 256) == 0) goto L25;
        String r12 = null;
    L26:
        this(r14, r15, r16, r7, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }
}
