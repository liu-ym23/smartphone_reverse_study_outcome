package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T, R> f218855a = null;

    static {
        f218855a = new m();
    }

    public m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        KnowledgeAIScopeItemInfoResult r101 = (KnowledgeAIScopeItemInfoResult) r100;
        Intrinsics.checkNotNullParameter(r101, "resp");
        KnowledgeAIScopeResp r102 = (KnowledgeAIScopeResp) r101.data;
        if (r102 == null) goto L5;
        boolean r103 = r102.isVcMeetingNote();
    L6:
        KnowledgeAIScopeResp r104 = (KnowledgeAIScopeResp) r101.data;
        if (r104 == null) goto L21;
        HashMap<String, KnowledgeAIScopeTokenInfo> r105 = r104.getTokensInfo();
        if (r105 == null) goto L21;
        Collection<KnowledgeAIScopeTokenInfo> r106 = r105.values();
        if (r106 == null) goto L21;
        ?? r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L23;
        KnowledgeAIScopeTokenInfo r109 = (KnowledgeAIScopeTokenInfo) r108.next();
        if (r109 == null) goto L18;
        DocKnowledgeAIScopeItemInfo r110 = r109.getItemScopeInfo();
    L19:
        if (r110 == null) goto L14;
        r107.add(r110);
        goto L14
    L18:
        r110 = null;
    L23:
        return new com.ss.android.lark.inline.ai.api.knowledgeai.f(r103, r107);
    L21:
        r107 = CollectionsKt.emptyList();
        goto L23
    L5:
        r103 = false;
        goto L6
    }
}
