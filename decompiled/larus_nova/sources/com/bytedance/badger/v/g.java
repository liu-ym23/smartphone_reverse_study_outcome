package com.bytedance.badger.v;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f199346d;

    public g(v r100, String r101, Function0 r102, TimeUnit r103) {
        super(r100, r101, r102);
        this.f199346d = r103;
    }

    @Override // com.bytedance.badger.v.e
    public final Object b(JSONObject r100, String r101, Object r102) {
        return new w(r100.optLong(r101, ((w) r102).f199356a), this.f199346d);
    }
}
