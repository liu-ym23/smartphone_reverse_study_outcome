package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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

    public static /* synthetic */ KnowledgeAIControlInfoRequest copy$default(KnowledgeAIControlInfoRequest r100, String r101, String r102, Integer r103, String r104, Integer r110, Boolean r111, Boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.uid;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.tenantId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.scenario;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.objToken;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.objType;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isNeedChatIsExist;
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.isNeedShadowId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
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

    public final KnowledgeAIControlInfoRequest copy(String r110, String r111, Integer r112, String r113, Integer r114, Boolean r115, Boolean r116) {
        return new KnowledgeAIControlInfoRequest(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KnowledgeAIControlInfoRequest) == true) goto L8;
        return false;
    L8:
        KnowledgeAIControlInfoRequest r101 = (KnowledgeAIControlInfoRequest) r100;
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scenario, r101.scenario) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.objType, r101.objType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isNeedChatIsExist, r101.isNeedChatIsExist) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isNeedShadowId, r101.isNeedShadowId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.uid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tenantId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.scenario;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.objToken;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.objType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isNeedChatIsExist;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isNeedShadowId;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
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

    public KnowledgeAIControlInfoRequest(String r100, String r101, Integer r102, String r103, Integer r104, Boolean r105, Boolean r106) {
        this.uid = r100;
        this.tenantId = r101;
        this.scenario = r102;
        this.objToken = r103;
        this.objType = r104;
        this.isNeedChatIsExist = r105;
        this.isNeedShadowId = r106;
    }
}
