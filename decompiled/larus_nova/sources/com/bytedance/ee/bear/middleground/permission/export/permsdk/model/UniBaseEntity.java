package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UniBaseEntity;", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", "token", "", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "ownerUserId", "tokenEntityType", "scopedFileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "scopedEntityOperate", "scopedEntityType", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;Ljava/lang/String;)V", "getOwnerUserId", "()Ljava/lang/String;", "setOwnerUserId", "(Ljava/lang/String;)V", "getTokenEntityType", "()Lcom/ss/android/lark/docs/icon/util/DocumentType;", "setTokenEntityType", "(Lcom/ss/android/lark/docs/icon/util/DocumentType;)V", "getScopedFileBizDomain", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "setScopedFileBizDomain", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;)V", "getScopedEntityOperate", "setScopedEntityOperate", "getScopedEntityType", "setScopedEntityType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniBaseEntity extends BaseEntity {
    private String ownerUserId;
    private String scopedEntityOperate;
    private String scopedEntityType;
    private FileBizDomain scopedFileBizDomain;
    private e tokenEntityType;

    public UniBaseEntity(String r110, e r111, BizDomain r112) {
        this(r110, r111, r112, null, null, null, null, null, null, 504, null);
    }

    public UniBaseEntity(String r110, e r111, BizDomain r112, String r113) {
        this(r110, r111, r112, r113, null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, null);
    }

    public UniBaseEntity(String r110, e r111, BizDomain r112, String r113, String r114) {
        this(r110, r111, r112, r113, r114, null, null, null, null, 480, null);
    }

    public UniBaseEntity(String r110, e r111, BizDomain r112, String r113, String r114, e r115) {
        this(r110, r111, r112, r113, r114, r115, null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
    }

    public UniBaseEntity(String r110, e r111, BizDomain r112, String r113, String r114, e r115, FileBizDomain r116) {
        this(r110, r111, r112, r113, r114, r115, r116, null, null, 384, null);
    }

    public UniBaseEntity(String r110, e r111, BizDomain r112, String r113, String r114, e r115, FileBizDomain r116, @EntityOperate String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, null, 256, null);
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

    public final void setOwnerUserId(String r100) {
        this.ownerUserId = r100;
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

    public final void setTokenEntityType(e r100) {
        this.tokenEntityType = r100;
    }

    public UniBaseEntity(String r100, e r101, BizDomain r102, String r103, String r104, e r105, FileBizDomain r106, @EntityOperate String r107, @EntityType String r108) {
        super(r100, r101, r102, r103);
        this.ownerUserId = r104;
        this.tokenEntityType = r105;
        this.scopedFileBizDomain = r106;
        this.scopedEntityOperate = r107;
        this.scopedEntityType = r108;
    }

    public /* synthetic */ UniBaseEntity(String r110, e r111, BizDomain r112, String r113, String r114, e r115, FileBizDomain r210, String r211, String r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 32) == 0) goto L13;
        e r102 = null;
    L15:
        if ((r213 & 64) == 0) goto L17;
        FileBizDomain r116 = null;
    L19:
        if ((r213 & 128) == 0) goto L21;
        String r117 = null;
    L23:
        if ((r213 & 256) == 0) goto L25;
        String r118 = null;
    L26:
        this(r110, r111, r112, r100, r101, r102, r116, r117, r118);
        return;
    L25:
        r118 = r212;
        goto L26
    L21:
        r117 = r211;
        goto L23
    L17:
        r116 = r210;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
