package mya;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface h {
    <T extends g> void a(Class<T> r100, T r101);

    <T extends g> T b(Class<T> r100);

    <T extends g> List<T> c(Class<T> r100);

    <T extends g> boolean d(Class<T> r100);

    void e(h r100);

    Map<Class<? extends g>, List<g>> f();
}
