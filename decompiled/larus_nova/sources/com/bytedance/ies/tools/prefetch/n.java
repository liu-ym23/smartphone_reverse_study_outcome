package com.bytedance.ies.tools.prefetch;

import java.util.List;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes19.dex */
public interface n {
    void a();

    PrefetchProcess b(PrefetchRequest r100);

    PrefetchProcess c(PrefetchRequest r100);

    void d(PrefetchHandler$1.a r100);

    void e(String r100, SortedMap r101, SortedMap r102, a0 r103);

    List getCacheByScheme(String r100);
}
