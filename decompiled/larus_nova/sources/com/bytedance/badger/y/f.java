package com.bytedance.badger.y;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class f extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f199441a = null;

    static {
        f199441a = new f();
    }

    public f() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        com.bytedance.badger.t.c r101 = (com.bytedance.badger.t.c) r100;
        List r102 = g.f199442a;
        r101.b(r102.size());
        r101.d(r102);
        return Unit.INSTANCE;
    }
}
