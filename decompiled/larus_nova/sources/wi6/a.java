package wi6;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import yf2.e;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    long a(String r100);

    void b(String r100, String r101);

    void c(String r100, e r101);

    ConcurrentHashMap<String, CopyOnWriteArrayList<e>> d();

    void e(String r100);

    CopyOnWriteArrayList<e> f(String r100);

    e g(String r100, String r101);

    void release();
}
