package com.ss.android.lark.abtest.api;

import iua.a;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public interface IABTestService {
    <T> T getAbTestValue(Class<? extends a> r100, boolean r101);

    Set<String> getAllAbTestKeys();

    void registerExperiments(String r100, List<a> r101);
}
