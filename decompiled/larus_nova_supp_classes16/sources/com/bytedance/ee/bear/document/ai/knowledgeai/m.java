package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T, R> implements Function {
    public static final m<T, R> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    public final Object apply(Object r4) {
        KnowledgeAIScopeItemInfoResult r5 = (KnowledgeAIScopeItemInfoResult) r4;
        Intrinsics.checkNotNullParameter(r5, "resp");
        KnowledgeAIScopeResp r0 = (KnowledgeAIScopeResp) r5.data;
        if (r0 == null) goto L5;
        boolean r1 = r0.isVcMeetingNote();
    L6:
        KnowledgeAIScopeResp r6 = (KnowledgeAIScopeResp) r5.data;
        if (r6 == null) goto L21;
        HashMap<String, KnowledgeAIScopeTokenInfo> r7 = r6.getTokensInfo();
        if (r7 == null) goto L21;
        Collection<KnowledgeAIScopeTokenInfo> r8 = r7.values();
        if (r8 == null) goto L21;
        ?? r2 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L23;
        KnowledgeAIScopeTokenInfo r3 = (KnowledgeAIScopeTokenInfo) r9.next();
        if (r3 == null) goto L18;
        DocKnowledgeAIScopeItemInfo r10 = r3.getItemScopeInfo();
    L19:
        if (r10 == null) goto L14;
        r2.add(r10);
        goto L14
    L18:
        r10 = null;
    L23:
        return new com.ss.android.lark.inline.ai.api.knowledgeai.f(r1, r2);
    L21:
        r2 = CollectionsKt.emptyList();
        goto L23
    L5:
        r1 = false;
        goto L6
    }
}
