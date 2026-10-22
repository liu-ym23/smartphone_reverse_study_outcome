package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.EntityProvider;
import com.ss.android.lark.inline.ai.api.knowledgeai.IAiScopeItemI18nText;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIEntityScope;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocKnowledgeAIScopeItemInfo;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIScopeItemInfo;", "entityScope", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;", "id", "", "icon", "text", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;", "entityType", "", "<init>", "(Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;Ljava/lang/Integer;)V", "getEntityScope", "()Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;", "getId", "()Ljava/lang/String;", "getIcon", "getText", "()Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;", "getEntityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocKnowledgeAIScopeItemInfo;", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocKnowledgeAIScopeItemInfo implements Serializable, IKnowledgeAIScopeItemInfo {

    @SerializedName("entity_scope")
    private final EntityScope entityScope;

    @SerializedName(EntityProvider.KEY_ENTITY_TYPE)
    private final Integer entityType;

    @SerializedName("icon")
    private final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f218838id;

    @SerializedName("text")
    private final AiScopeItemI18nText text;

    public DocKnowledgeAIScopeItemInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DocKnowledgeAIScopeItemInfo copy$default(DocKnowledgeAIScopeItemInfo r100, EntityScope r101, String r102, String r103, AiScopeItemI18nText r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.entityScope;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.f218838id;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.icon;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.text;
    L14:
        AiScopeItemI18nText r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.entityType;
    L17:
        EntityScope r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final EntityScope component1() {
        return this.entityScope;
    }

    public final String component2() {
        return this.f218838id;
    }

    public final String component3() {
        return this.icon;
    }

    public final AiScopeItemI18nText component4() {
        return this.text;
    }

    public final Integer component5() {
        return this.entityType;
    }

    public final DocKnowledgeAIScopeItemInfo copy(EntityScope r100, String r101, String r110, AiScopeItemI18nText r111, Integer r112) {
        return new DocKnowledgeAIScopeItemInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocKnowledgeAIScopeItemInfo) == true) goto L8;
        return false;
    L8:
        DocKnowledgeAIScopeItemInfo r101 = (DocKnowledgeAIScopeItemInfo) r100;
        if (Intrinsics.areEqual(this.entityScope, r101.entityScope) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f218838id, r101.f218838id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entityType, r101.entityType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        EntityScope r100 = this.entityScope;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f218838id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.icon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        AiScopeItemI18nText r110 = this.text;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.entityType;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "DocKnowledgeAIScopeItemInfo(entityScope=" + this.entityScope + ", id=" + this.f218838id + ", icon=" + this.icon + ", text=" + this.text + ", entityType=" + this.entityType + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public /* bridge */ /* synthetic */ IKnowledgeAIEntityScope getEntityScope() {
        return getEntityScope();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public /* bridge */ /* synthetic */ IAiScopeItemI18nText getText() {
        return getText();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public Integer getEntityType() {
        return this.entityType;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public String getIcon() {
        return this.icon;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public String getId() {
        return this.f218838id;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public EntityScope getEntityScope() {
        return this.entityScope;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo
    public AiScopeItemI18nText getText() {
        return this.text;
    }

    public DocKnowledgeAIScopeItemInfo(EntityScope r100, String r101, String r102, AiScopeItemI18nText r103, Integer r104) {
        this.entityScope = r100;
        this.f218838id = r101;
        this.icon = r102;
        this.text = r103;
        this.entityType = r104;
    }

    public /* synthetic */ DocKnowledgeAIScopeItemInfo(EntityScope r100, String r101, String r102, AiScopeItemI18nText r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        EntityScope r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        AiScopeItemI18nText r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
