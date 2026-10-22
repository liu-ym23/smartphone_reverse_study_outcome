package com.ss.android.lark.inline.ai.api.knowledgeai;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIControlInfoBean;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIControlInfo;", "enable", "", "<init>", "(Z)V", "getEnable", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIControlInfoBean implements IKnowledgeAIControlInfo {
    private final boolean enable;

    public static /* synthetic */ KnowledgeAIControlInfoBean copy$default(KnowledgeAIControlInfoBean r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final KnowledgeAIControlInfoBean copy(boolean r100) {
        return new KnowledgeAIControlInfoBean(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KnowledgeAIControlInfoBean) == true) goto L9;
        return false;
    L9:
        if (this.enable == ((KnowledgeAIControlInfoBean) r100).enable) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "KnowledgeAIControlInfoBean(enable=" + this.enable + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIControlInfo
    public boolean getEnable() {
        return this.enable;
    }

    public KnowledgeAIControlInfoBean(boolean r100) {
        this.enable = r100;
    }
}
