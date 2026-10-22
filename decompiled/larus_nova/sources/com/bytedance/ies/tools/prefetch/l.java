package com.bytedance.ies.tools.prefetch;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface l {
    PrefetchProcess a(PrefetchRequest r100, x r101);

    PrefetchProcess b(PrefetchRequest r100, x r101);

    List<PrefetchProcess> getCacheByScheme(String r100);
}
