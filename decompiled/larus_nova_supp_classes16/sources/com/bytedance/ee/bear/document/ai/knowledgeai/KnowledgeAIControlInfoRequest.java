package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\t\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000b\u0010\u0016¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIControlInfoRequest;", "Ljava/io/Serializable;", "uid", "", "tenantId", "scenario", "", "objToken", "objType", "isNeedChatIsExist", "", "isNeedShadowId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getUid", "()Ljava/lang/String;", "getTenantId", "getScenario", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getObjToken", "getObjType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIControlInfoRequest;", "equals", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIControlInfoRequest implements Serializable {

    @SerializedName("is_need_chat_is_exist")
    private final Boolean isNeedChatIsExist;

    @SerializedName("is_need_shadow_id")
    private final Boolean isNeedShadowId;

    @SerializedName("obj_token")
    private final String objToken;

    @SerializedName("obj_type")
    private final Integer objType;

    @SerializedName("scenario")
    private final Integer scenario;

    @SerializedName("tenant_id")
    private final String tenantId;

    @SerializedName("uid")
    private final String uid;

    public static /* synthetic */ KnowledgeAIControlInfoRequest copy$default(KnowledgeAIControlInfoRequest r5, String r6, String r7, Integer r8, String r9, Integer r10, Boolean r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.uid;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.tenantId;
    L8:
        String r16 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.scenario;
    L11:
        Integer r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.objToken;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.objType;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isNeedChatIsExist;
    L20:
        Boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.isNeedShadowId;
    L23:
        String r17 = r6;
        return r5.copy(r17, r16, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.tenantId;
    }

    public final Integer component3() {
        return this.scenario;
    }

    public final String component4() {
        return this.objToken;
    }

    public final Integer component5() {
        return this.objType;
    }

    public final Boolean component6() {
        return this.isNeedChatIsExist;
    }

    public final Boolean component7() {
        return this.isNeedShadowId;
    }

    public final KnowledgeAIControlInfoRequest copy(String r10, String r11, Integer r12, String r13, Integer r14, Boolean r16, Boolean r17) {
        return new KnowledgeAIControlInfoRequest(r10, r11, r12, r13, r14, r16, r17);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KnowledgeAIControlInfoRequest) == true) goto L8;
        return false;
    L8:
        KnowledgeAIControlInfoRequest r6 = (KnowledgeAIControlInfoRequest) r5;
        if (Intrinsics.areEqual(this.uid, r6.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tenantId, r6.tenantId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scenario, r6.scenario) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objToken, r6.objToken) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.objType, r6.objType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isNeedChatIsExist, r6.isNeedChatIsExist) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isNeedShadowId, r6.isNeedShadowId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.uid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.tenantId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.scenario;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.objToken;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.objType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        Boolean r17 = this.isNeedChatIsExist;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.isNeedShadowId;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r19 + r1;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeAIControlInfoRequest(uid=" + this.uid + ", tenantId=" + this.tenantId + ", scenario=" + this.scenario + ", objToken=" + this.objToken + ", objType=" + this.objType + ", isNeedChatIsExist=" + this.isNeedChatIsExist + ", isNeedShadowId=" + this.isNeedShadowId + ')';
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final Integer getObjType() {
        return this.objType;
    }

    public final Integer getScenario() {
        return this.scenario;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUid() {
        return this.uid;
    }

    public final Boolean isNeedChatIsExist() {
        return this.isNeedChatIsExist;
    }

    public final Boolean isNeedShadowId() {
        return this.isNeedShadowId;
    }

    public KnowledgeAIControlInfoRequest(String r1, String r2, Integer r3, String r4, Integer r5, Boolean r6, Boolean r7) {
        this.uid = r1;
        this.tenantId = r2;
        this.scenario = r3;
        this.objToken = r4;
        this.objType = r5;
        this.isNeedChatIsExist = r6;
        this.isNeedShadowId = r7;
    }
}
