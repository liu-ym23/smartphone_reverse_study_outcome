package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inline.ai.api.knowledgeai.IAiScopeItemI18nText;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIEntityScope;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocKnowledgeAIScopeItemInfo;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIScopeItemInfo;", "entityScope", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;", "id", "", CustomHeaderConfig.Menu.Style.ICON_STYLE, "text", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;", "entityType", "", "<init>", "(Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;Ljava/lang/Integer;)V", "getEntityScope", "()Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;", "getId", "()Ljava/lang/String;", "getIcon", "getText", "()Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;", "getEntityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/document/ai/knowledgeai/AiScopeItemI18nText;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocKnowledgeAIScopeItemInfo;", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocKnowledgeAIScopeItemInfo implements Serializable, IKnowledgeAIScopeItemInfo {

    @SerializedName("entity_scope")
    private final EntityScope entityScope;

    @SerializedName("entity_type")
    private final Integer entityType;

    @SerializedName(CustomHeaderConfig.Menu.Style.ICON_STYLE)
    private final String icon;

    @SerializedName("id")
    private final String id;

    @SerializedName("text")
    private final AiScopeItemI18nText text;

    public DocKnowledgeAIScopeItemInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DocKnowledgeAIScopeItemInfo copy$default(DocKnowledgeAIScopeItemInfo r3, EntityScope r4, String r5, String r6, AiScopeItemI18nText r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.entityScope;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.id;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.icon;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.text;
    L14:
        AiScopeItemI18nText r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.entityType;
    L17:
        EntityScope r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final EntityScope component1() {
        return this.entityScope;
    }

    public final String component2() {
        return this.id;
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

    public final DocKnowledgeAIScopeItemInfo copy(EntityScope r8, String r9, String r10, AiScopeItemI18nText r11, Integer r12) {
        return new DocKnowledgeAIScopeItemInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocKnowledgeAIScopeItemInfo) == true) goto L8;
        return false;
    L8:
        DocKnowledgeAIScopeItemInfo r6 = (DocKnowledgeAIScopeItemInfo) r5;
        if (Intrinsics.areEqual(this.entityScope, r6.entityScope) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entityType, r6.entityType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        EntityScope r0 = this.entityScope;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.icon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AiScopeItemI18nText r10 = this.text;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.entityType;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "DocKnowledgeAIScopeItemInfo(entityScope=" + this.entityScope + ", id=" + this.id + ", icon=" + this.icon + ", text=" + this.text + ", entityType=" + this.entityType + ')';
    }

    /* JADX INFO: renamed from: getEntityScope, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IKnowledgeAIEntityScope m188getEntityScope() {
        return getEntityScope();
    }

    /* JADX INFO: renamed from: getText, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IAiScopeItemI18nText m189getText() {
        return getText();
    }

    public Integer getEntityType() {
        return this.entityType;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public EntityScope getEntityScope() {
        return this.entityScope;
    }

    public AiScopeItemI18nText getText() {
        return this.text;
    }

    public DocKnowledgeAIScopeItemInfo(EntityScope r1, String r2, String r3, AiScopeItemI18nText r4, Integer r5) {
        this.entityScope = r1;
        this.id = r2;
        this.icon = r3;
        this.text = r4;
        this.entityType = r5;
    }

    public /* synthetic */ DocKnowledgeAIScopeItemInfo(EntityScope r5, String r6, String r7, AiScopeItemI18nText r8, Integer r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        EntityScope r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        AiScopeItemI18nText r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Integer r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
