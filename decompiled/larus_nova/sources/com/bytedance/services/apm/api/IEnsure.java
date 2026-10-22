package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IEnsure extends IService {
    boolean ensureFalse(boolean r100);

    boolean ensureFalse(boolean r100, String r101);

    boolean ensureFalse(boolean r100, String r101, Map<String, String> r102);

    boolean ensureNotEmpty(Collection r100);

    boolean ensureNotNull(Object r100);

    boolean ensureNotNull(Object r100, String r101);

    void ensureNotReachHere();

    void ensureNotReachHere(String r100);

    void ensureNotReachHere(String r100, Map<String, String> r101);

    void ensureNotReachHere(Throwable r100);

    void ensureNotReachHere(Throwable r100, String r101);

    void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102);

    boolean ensureTrue(boolean r100);

    boolean ensureTrue(boolean r100, String r101);

    boolean ensureTrue(boolean r100, String r101, Map<String, String> r102);

    void reportLogException(int r100, Throwable r101, String r102);

    void reportLogException(Throwable r100);

    void reportLogException(Throwable r100, String r101);
}
