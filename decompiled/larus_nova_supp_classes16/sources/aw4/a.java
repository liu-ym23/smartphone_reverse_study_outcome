package aw4;

import io.reactivex.Flowable;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {
    void a(String r1, Serializable r2);

    Flowable<Boolean> clearCache();

    <T extends Serializable> T get(String r1) throws IOException;

    Flowable<Long> getCacheSize();
}
