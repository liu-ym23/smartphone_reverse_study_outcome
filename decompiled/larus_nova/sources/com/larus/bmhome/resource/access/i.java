package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends DelegatingResourceNode {
    public i(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "dependsOn");
        super("post_process", ResourcePhase.POST_PROCESS, r100, false, 24);
    }
}
