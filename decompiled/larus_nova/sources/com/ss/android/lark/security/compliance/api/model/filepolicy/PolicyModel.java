package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0006\u0010\u001a\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyModel;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/IParams;", "pointKey", "", "entity", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "config", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyModel$PolicyModelConfig;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyModel$PolicyModelConfig;)V", "getPointKey", "()Ljava/lang/String;", "getEntity", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyEntity;", "getConfig", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyModel$PolicyModelConfig;", "setConfig", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyModel$PolicyModelConfig;)V", "equals", "", "other", "", "hashCode", "", "getTaskId", "getTaskIdV2", "toRawString", "PolicyModelConfig", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PolicyModel implements e {
    private transient a config;
    private final PolicyEntity entity;
    private final String pointKey;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f440394a;

        public a(boolean r100) {
            this.f440394a = r100;
        }
    }

    private final String getTaskIdV2() {
        PolicyEntity r100 = this.entity;
        if ((r100 instanceof CCMFileEntity) == false) goto L5;
    L10:
        String r101 = this.pointKey;
        a r102 = this.config;
        boolean r103 = false;
        if (r102 != null) goto L13;
    L15:
        if (r103 == false) goto L17;
        r100 = h.b(r100);
    L17:
        String r104 = com.ss.android.lark.security.compliance.infra.util.f.c(new PolicyModel(r101, r100, null, 4, null));
        Intrinsics.checkNotNull(r104);
        return r104;
    L13:
        if (r102.f440394a == true) goto L15;
        r103 = true;
        goto L15
    L5:
        if ((r100 instanceof CalendarFileEntity) == true) goto L10;
        if ((r100 instanceof VCFileEntity) == true) goto L10;
        String r105 = com.ss.android.lark.security.compliance.infra.util.f.c(this);
        Intrinsics.checkNotNull(r105);
        return r105;
    }

    public final String getTaskId() {
        if (f.f440407a.values().contains(this.pointKey) == false) goto L9;
        PolicyEntity r100 = this.entity;
        if ((r100 instanceof CCMFileEntity) == false) goto L9;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity");
        return com.ss.android.lark.security.compliance.infra.util.f.c(new PolicyModel(this.pointKey, h.l((CCMFileEntity) r100), null, 4, null));
    L9:
        if (w4c.c.a().c() == false) goto L13;
        return getTaskIdV2();
    L13:
        if (this.entity.getEntityDomain() != EntityDomain.EntityDomainCCM) goto L27;
        a r101 = this.config;
        boolean r102 = false;
        if (r101 != null) goto L17;
    L19:
        if (r102 == true) goto L24;
        String r103 = this.pointKey;
        CCMFileEntity r104 = h.c(this.entity);
        if (ArraysKt.contains(d.f440406a, r104.getEntityType()) == false) goto L23;
        r104.setEntityType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC);
    L23:
        PolicyModel r105 = new PolicyModel(r103, r104, null, 4, null);
    L28:
        IMFileEntity r106 = null;
        if (Intrinsics.areEqual(this.pointKey, "PointKey_IM_MSG_FILE_DOWNLOAD") == false) goto L36;
        PolicyEntity r107 = this.entity;
        if ((r107 instanceof IMFileEntity) == false) goto L33;
        IMFileEntity r108 = (IMFileEntity) r107;
    L34:
        if (r108 == null) goto L36;
        r105 = h.a(r108.getOperatorUid(), r108.getOperatorTenantId());
        goto L36
    L33:
        r108 = null;
    L36:
        boolean r109 = g.f440409a;
        if (g.f440409a == false) goto L48;
        if (g.f440410b == true) goto L48;
        if (Intrinsics.areEqual(this.pointKey, "PointKey_IM_MSG_FILE_READ") == false) goto L48;
        PolicyEntity r110 = this.entity;
        if ((r110 instanceof IMFileEntity) == false) goto L45;
        r106 = (IMFileEntity) r110;
    L45:
        if (r106 == null) goto L48;
        long r111 = r106.getOperatorUid();
        String r112 = "IM_MSG_FILE";
        String r113 = "IM_MSG_FILE_READ";
        r105 = new PolicyModel("PointKey_IM_MSG_FILE_READ", new IMFileEntity(r112, EntityDomain.EntityDomainIM, r113, r106.getOperatorTenantId(), r111, FileBizDomain.FileBizDomainIM, r106.getSenderUserId(), r106.getSenderTenantId(), null, null, null, null, null, null, null, 32256, null), null, 4, null);
    L48:
        return com.ss.android.lark.security.compliance.infra.util.f.c(r105);
    L24:
        PolicyEntity r114 = this.entity;
        if ((r114 instanceof CCMFileEntity) == false) goto L27;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity");
        r105 = new PolicyModel(this.pointKey, h.l((CCMFileEntity) r114), null, 4, null);
        goto L28
    L17:
        if (r101.f440394a != true) goto L19;
        r102 = true;
    L27:
        r105 = this;
        goto L28
    }

    public final String toRawString() {
        PolicyEntity r100 = this.entity;
        if ((r100 instanceof CCMFileEntity) == false) goto L11;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity");
        CCMFileEntity r101 = (CCMFileEntity) r100;
        String r102 = this.pointKey;
        CCMFileEntity r103 = h.c(r101);
        String r104 = r101.getToken();
        if (r104 == null) goto L7;
        String r105 = StringsKt.takeLast(r104, RangesKt.coerceAtMost(5, r104.length()));
    L8:
        r103.setToken(r105);
        r103.setTokenEntityType(r101.getTokenEntityType());
        r103.setOwnerUserId(r101.getOwnerUserId());
        r103.setOwnerTenantId(Long.valueOf(r101.getOperatorTenantId()));
        r103.setObjectType(r101.getObjectType());
        return com.ss.android.lark.security.compliance.infra.util.f.c(new PolicyModel(r102, r103, null, 4, null));
    L7:
        r105 = null;
        goto L8
    L11:
        return com.ss.android.lark.security.compliance.infra.util.f.c(this);
    }

    public int hashCode() {
        return com.ss.android.lark.security.compliance.infra.util.f.c(this).hashCode();
    }

    public final a getConfig() {
        return this.config;
    }

    public final PolicyEntity getEntity() {
        return this.entity;
    }

    public final String getPointKey() {
        return this.pointKey;
    }

    public boolean equals(Object r100) {
        return com.ss.android.lark.security.compliance.infra.util.f.c(this).equals(com.ss.android.lark.security.compliance.infra.util.f.c(r100));
    }

    public final void setConfig(a r100) {
        this.config = r100;
    }

    public PolicyModel(@PointKey String r100, PolicyEntity r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        Intrinsics.checkNotNullParameter(r101, "entity");
        this.pointKey = r100;
        this.entity = r101;
        this.config = r102;
    }

    public /* synthetic */ PolicyModel(String r100, PolicyEntity r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
