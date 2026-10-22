package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IEnsure extends IService {
    boolean ensureFalse(boolean r1);

    boolean ensureFalse(boolean r1, String r2);

    boolean ensureFalse(boolean r1, String r2, Map<String, String> r3);

    boolean ensureNotEmpty(Collection r1);

    boolean ensureNotNull(Object r1);

    boolean ensureNotNull(Object r1, String r2);

    void ensureNotReachHere();

    void ensureNotReachHere(String r1);

    void ensureNotReachHere(String r1, Map<String, String> r2);

    void ensureNotReachHere(Throwable r1);

    void ensureNotReachHere(Throwable r1, String r2);

    void ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3);

    boolean ensureTrue(boolean r1);

    boolean ensureTrue(boolean r1, String r2);

    boolean ensureTrue(boolean r1, String r2, Map<String, String> r3);

    void reportLogException(int r1, Throwable r2, String r3);

    void reportLogException(Throwable r1);

    void reportLogException(Throwable r1, String r2);
}
