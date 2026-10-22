package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JW\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR4\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIRecommendation;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIRecommendation;", "icon", "", "id", "content", "bizParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getIcon", "()Ljava/lang/String;", "getId", "getContent", "getBizParams", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIRecommendation implements IKnowledgeAIRecommendation {
    private final HashMap<String, Object> bizParams;
    private final String content;
    private final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f426826id;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIRecommendation copy$default(KnowledgeAIRecommendation r100, String r101, String r102, String r103, HashMap r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.icon;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f426826id;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bizParams;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.f426826id;
    }

    public final String component3() {
        return this.content;
    }

    public final HashMap<String, Object> component4() {
        return this.bizParams;
    }

    public final KnowledgeAIRecommendation copy(String r100, String r101, String r102, HashMap<String, Object> r103) {
        return new KnowledgeAIRecommendation(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KnowledgeAIRecommendation) == true) goto L8;
        return false;
    L8:
        KnowledgeAIRecommendation r101 = (KnowledgeAIRecommendation) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426826id, r101.f426826id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizParams, r101.bizParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.icon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f426826id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, Object> r110 = this.bizParams;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "KnowledgeAIRecommendation(icon=" + this.icon + ", id=" + this.f426826id + ", content=" + this.content + ", bizParams=" + this.bizParams + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public /* bridge */ /* synthetic */ Map getBizParams() {
        return getBizParams();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public String getContent() {
        return this.content;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public String getIcon() {
        return this.icon;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public String getId() {
        return this.f426826id;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public HashMap<String, Object> getBizParams() {
        return this.bizParams;
    }

    public KnowledgeAIRecommendation(String r100, String r101, String r102, HashMap<String, Object> r103) {
        this.icon = r100;
        this.f426826id = r101;
        this.content = r102;
        this.bizParams = r103;
    }

    public /* synthetic */ KnowledgeAIRecommendation(String r100, String r101, String r102, HashMap r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
