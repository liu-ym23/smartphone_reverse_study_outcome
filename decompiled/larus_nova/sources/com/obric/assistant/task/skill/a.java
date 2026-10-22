package com.obric.assistant.task.skill;

import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static final List<ObricOmniModel> a(ObricOmniModelConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<ObricOmniModel> r101 = r100.getModels();
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        return CollectionsKt.filterNotNull(r101);
    }
}
