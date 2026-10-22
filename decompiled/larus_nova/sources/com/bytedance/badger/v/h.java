package com.bytedance.badger.v;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends e {
    public h(v r100, String r101, Function0 r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.badger.v.e
    public final Object b(JSONObject r100, String r101, Object r102) {
        return Integer.valueOf(r100.optInt(r101, ((Number) r102).intValue()));
    }
}
