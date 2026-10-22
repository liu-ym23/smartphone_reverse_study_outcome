package com.bytedance.flow.search.kmp.impl.provider;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ChatSectionPayload;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        ISearchDataPayload r102 = ((FlowSearchData) r101).f243281c;
        ChatSectionPayload r103 = null;
        if ((r102 instanceof ChatSectionPayload) == false) goto L5;
        ChatSectionPayload r104 = (ChatSectionPayload) r102;
    L6:
        long r105 = 0;
        if (r104 == null) goto L9;
        long r106 = r104.f243337i;
    L10:
        Long r107 = Long.valueOf(r106);
        ISearchDataPayload r108 = ((FlowSearchData) r100).f243281c;
        if ((r108 instanceof ChatSectionPayload) == false) goto L13;
        r103 = (ChatSectionPayload) r108;
    L13:
        if (r103 == null) goto L16;
        r105 = r103.f243337i;
    L16:
        return ComparisonsKt.compareValues(r107, Long.valueOf(r105));
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
