package io.ktor.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public interface q {
    List<String> a(String r100);

    void b(String r100, String r101);

    boolean c();

    void d(String r100, Iterable<String> r101);

    Set<Map.Entry<String, List<String>>> entries();

    boolean isEmpty();

    Set<String> names();
}
