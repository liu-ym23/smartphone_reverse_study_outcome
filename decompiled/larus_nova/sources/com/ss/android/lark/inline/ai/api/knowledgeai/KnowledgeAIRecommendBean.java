package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003JE\u0010\u000e\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R(\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR(\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIRecommendBean;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIRecommend;", "mainRecommend", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIRecommendation;", "Lkotlin/collections/ArrayList;", "keyboardRecommend", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getMainRecommend", "()Ljava/util/ArrayList;", "getKeyboardRecommend", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIRecommendBean implements IKnowledgeAIRecommend {
    private final ArrayList<KnowledgeAIRecommendation> keyboardRecommend;
    private final ArrayList<KnowledgeAIRecommendation> mainRecommend;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIRecommendBean copy$default(KnowledgeAIRecommendBean r100, ArrayList r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.mainRecommend;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.keyboardRecommend;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<KnowledgeAIRecommendation> component1() {
        return this.mainRecommend;
    }

    public final ArrayList<KnowledgeAIRecommendation> component2() {
        return this.keyboardRecommend;
    }

    public final KnowledgeAIRecommendBean copy(ArrayList<KnowledgeAIRecommendation> r100, ArrayList<KnowledgeAIRecommendation> r101) {
        return new KnowledgeAIRecommendBean(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KnowledgeAIRecommendBean) == true) goto L8;
        return false;
    L8:
        KnowledgeAIRecommendBean r101 = (KnowledgeAIRecommendBean) r100;
        if (Intrinsics.areEqual(this.mainRecommend, r101.mainRecommend) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keyboardRecommend, r101.keyboardRecommend) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ArrayList<KnowledgeAIRecommendation> r100 = this.mainRecommend;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<KnowledgeAIRecommendation> r104 = this.keyboardRecommend;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeAIRecommendBean(mainRecommend=" + this.mainRecommend + ", keyboardRecommend=" + this.keyboardRecommend + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public /* bridge */ /* synthetic */ List getKeyboardRecommend() {
        return getKeyboardRecommend();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public /* bridge */ /* synthetic */ List getMainRecommend() {
        return getMainRecommend();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public ArrayList<KnowledgeAIRecommendation> getKeyboardRecommend() {
        return this.keyboardRecommend;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public ArrayList<KnowledgeAIRecommendation> getMainRecommend() {
        return this.mainRecommend;
    }

    public KnowledgeAIRecommendBean(ArrayList<KnowledgeAIRecommendation> r100, ArrayList<KnowledgeAIRecommendation> r101) {
        this.mainRecommend = r100;
        this.keyboardRecommend = r101;
    }
}
