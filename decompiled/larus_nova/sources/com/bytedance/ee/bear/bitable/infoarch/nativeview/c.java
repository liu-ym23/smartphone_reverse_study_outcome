package com.bytedance.ee.bear.bitable.infoarch.nativeview;

import kotlin.Pair;

/* JADX INFO: loaded from: classes15.dex */
public interface c {
    Pair<Boolean, Boolean> a(String r100);

    String getDocumentTraceId();

    Long getFirstRebuildTime();

    String getObjToken();

    a getViewDataProvider();

    void setFirstRebuildTime(Long r100);
}
