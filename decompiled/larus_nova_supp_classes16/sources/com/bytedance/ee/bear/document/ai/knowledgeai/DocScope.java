package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public static /* synthetic */ DocScope copy$default(DocScope r9, String r10, Long r11, String r12, Long r13, String r14, Boolean r16, Boolean r17, Integer r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r2 = r9.objToken;
    L7:
        if ((r19 & 2) == 0) goto L9;
        Long r3 = r9.objType;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r4 = r9.nodeToken;
    L15:
        if ((r19 & 8) == 0) goto L17;
        Long r5 = r9.docType;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r6 = r9.spaceId;
    L23:
        if ((r19 & 32) == 0) goto L25;
        Boolean r7 = r9.hasChild;
    L27:
        if ((r19 & 64) == 0) goto L29;
        Boolean r8 = r9.isShareFolder;
    L31:
        if ((r19 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        Integer r1 = r9.docSubType;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
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

    public final DocScope copy(String r11, Long r12, String r13, Long r14, String r16, Boolean r17, Boolean r18, Integer r19) {
        return new DocScope(r11, r12, r13, r14, r16, r17, r18, r19);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocScope) == true) goto L8;
        return false;
    L8:
        DocScope r6 = (DocScope) r5;
        if (Intrinsics.areEqual(this.objToken, r6.objToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.objType, r6.objType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nodeToken, r6.nodeToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.docType, r6.docType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.spaceId, r6.spaceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hasChild, r6.hasChild) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isShareFolder, r6.isShareFolder) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.docSubType, r6.docSubType) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.objToken;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.objType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.nodeToken;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.docType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.spaceId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        Boolean r17 = this.hasChild;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.isShareFolder;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.docSubType;
        if (r23 == null) goto L35;
        r1 = r23.hashCode();
    L35:
        return r22 + r1;
    L29:
        r21 = r20.hashCode();
        goto L30
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
        return "DocScope(objToken=" + this.objToken + ", objType=" + this.objType + ", nodeToken=" + this.nodeToken + ", docType=" + this.docType + ", spaceId=" + this.spaceId + ", hasChild=" + this.hasChild + ", isShareFolder=" + this.isShareFolder + ", docSubType=" + this.docSubType + ')';
    }

    public Integer getDocSubType() {
        return this.docSubType;
    }

    public Long getDocType() {
        return this.docType;
    }

    public Boolean getHasChild() {
        return this.hasChild;
    }

    public String getNodeToken() {
        return this.nodeToken;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public Long getObjType() {
        return this.objType;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public Boolean isShareFolder() {
        return this.isShareFolder;
    }

    public DocScope(String r1, Long r2, String r3, Long r4, String r5, Boolean r6, Boolean r7, Integer r8) {
        this.objToken = r1;
        this.objType = r2;
        this.nodeToken = r3;
        this.docType = r4;
        this.spaceId = r5;
        this.hasChild = r6;
        this.isShareFolder = r7;
        this.docSubType = r8;
    }
}
