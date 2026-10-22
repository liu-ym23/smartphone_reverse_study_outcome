package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIDocScope;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIEntityScope;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/EntityScope;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIEntityScope;", "docScope", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocScope;", "<init>", "(Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocScope;)V", "getDocScope", "()Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocScope;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntityScope implements Serializable, IKnowledgeAIEntityScope {

    @SerializedName("doc_scope")
    private final DocScope docScope;

    public static /* synthetic */ EntityScope copy$default(EntityScope r100, DocScope r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.docScope;
    L6:
        return r100.copy(r101);
    }

    public final DocScope component1() {
        return this.docScope;
    }

    public final EntityScope copy(DocScope r100) {
        return new EntityScope(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EntityScope) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.docScope, ((EntityScope) r100).docScope) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        DocScope r100 = this.docScope;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "EntityScope(docScope=" + this.docScope + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIEntityScope
    public /* bridge */ /* synthetic */ IKnowledgeAIDocScope getDocScope() {
        return getDocScope();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIEntityScope
    public DocScope getDocScope() {
        return this.docScope;
    }

    public EntityScope(DocScope r100) {
        this.docScope = r100;
    }
}
