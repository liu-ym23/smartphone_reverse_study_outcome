package com.ss.ugc.effectplatform.cache;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
public interface j {
    void a(long r100, Function2<? super Integer, ? super Long, Unit> r101);

    long b(String r100, bytekn.foundation.io.file.b r101);

    void c(List<String> r100);

    void clear();

    void d(String r100);

    boolean has(String r100);

    bytekn.foundation.io.file.b queryToStream(String r100);

    String queryToValue(String r100);

    boolean remove(String r100);

    void removePattern(String r100);

    long save(String r100, String r101);
}
