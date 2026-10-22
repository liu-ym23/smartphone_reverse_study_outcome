package com.bytedance.badger.z;

import com.bytedance.badger.data.DataString;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class b0 extends Lambda implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n0 f199450a;

    public b0(n0 r100) {
        this.f199450a = r100;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object r100, Object r101, Object r102) {
        long r103 = ((Number) r102).longValue();
        n0 r104 = this.f199450a;
        DataString r105 = new DataString((String) r101);
        r104.getClass();
        return Boolean.valueOf(u0.b((Long) r100, r105, r103));
    }
}
