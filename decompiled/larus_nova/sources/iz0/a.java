package iz0;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface a {
    void a(String r100, String r101);

    void b(String r100, long r101);

    Completable c(Map<String, ?> r100);

    Completable clear();

    String d(String r100, String r101);

    long e(String r100, long r101);

    Completable f(String r100);

    Completable g(String r100);

    Single<Map<String, ?>> getAll();

    Single getString();

    boolean h(String r100);

    void i(String r100);
}
