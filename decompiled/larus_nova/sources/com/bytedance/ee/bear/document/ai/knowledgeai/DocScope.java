package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.document.DocViewModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u000eHÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\f\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocScope;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIDocScope;", "objToken", "", "objType", "", "nodeToken", "docType", "spaceId", "hasChild", "", "isShareFolder", "docSubType", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getObjToken", "()Ljava/lang/String;", "getObjType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNodeToken", "getDocType", "getSpaceId", "getHasChild", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDocSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocScope;", "equals", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocScope implements Serializable, IKnowledgeAIDocScope {

    @SerializedName("doc_sub_type")
    private final Integer docSubType;

    @SerializedName("doc_type")
    private final Long docType;

    @SerializedName("has_child")
    private final Boolean hasChild;

    @SerializedName("is_share_folder")
    private final Boolean isShareFolder;

    @SerializedName("node_token")
    private final String nodeToken;

    @SerializedName("obj_token")
    private final String objToken;

    @SerializedName("obj_type")
    private final Long objType;

    @SerializedName(DocViewModel.EXTRA_SPACE_ID)
    private final String spaceId;

    public static /* synthetic */ DocScope copy$default(DocScope r100, String r110, Long r111, String r112, Long r113, String r114, Boolean r115, Boolean r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.objToken;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = r100.objType;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.nodeToken;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Long r104 = r100.docType;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.spaceId;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Boolean r106 = r100.hasChild;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Boolean r107 = r100.isShareFolder;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.docSubType;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.objToken;
    }

    public final Long component2() {
        return this.objType;
    }

    public final String component3() {
        return this.nodeToken;
    }

    public final Long component4() {
        return this.docType;
    }

    public final String component5() {
        return this.spaceId;
    }

    public final Boolean component6() {
        return this.hasChild;
    }

    public final Boolean component7() {
        return this.isShareFolder;
    }

    public final Integer component8() {
        return this.docSubType;
    }

    public final DocScope copy(String r110, Long r111, String r112, Long r113, String r114, Boolean r115, Boolean r116, Integer r117) {
        return new DocScope(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocScope) == true) goto L8;
        return false;
    L8:
        DocScope r101 = (DocScope) r100;
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.objType, r101.objType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nodeToken, r101.nodeToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.docType, r101.docType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.spaceId, r101.spaceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hasChild, r101.hasChild) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isShareFolder, r101.isShareFolder) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.docSubType, r101.docSubType) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.objToken;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.objType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nodeToken;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.docType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.spaceId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.hasChild;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isShareFolder;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.docSubType;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "DocScope(objToken=" + this.objToken + ", objType=" + this.objType + ", nodeToken=" + this.nodeToken + ", docType=" + this.docType + ", spaceId=" + this.spaceId + ", hasChild=" + this.hasChild + ", isShareFolder=" + this.isShareFolder + ", docSubType=" + this.docSubType + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public Integer getDocSubType() {
        return this.docSubType;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public Long getDocType() {
        return this.docType;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public Boolean getHasChild() {
        return this.hasChild;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public String getNodeToken() {
        return this.nodeToken;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public String getObjToken() {
        return this.objToken;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public Long getObjType() {
        return this.objType;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public String getSpaceId() {
        return this.spaceId;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope
    public Boolean isShareFolder() {
        return this.isShareFolder;
    }

    public DocScope(String r100, Long r101, String r102, Long r103, String r104, Boolean r105, Boolean r106, Integer r107) {
        this.objToken = r100;
        this.objType = r101;
        this.nodeToken = r102;
        this.docType = r103;
        this.spaceId = r104;
        this.hasChild = r105;
        this.isShareFolder = r106;
        this.docSubType = r107;
    }
}
