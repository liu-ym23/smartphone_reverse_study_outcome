package com.bytedance.reparo.core;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Comparator<Map.Entry<c97.h, d97.d>> {
    public m() {
    }

    @Override // java.util.Comparator
    public final int compare(Map.Entry<c97.h, d97.d> r100, Map.Entry<c97.h, d97.d> r101) {
        return r101.getKey().f22890j.compareTo(r100.getKey().f22890j);
    }
}
