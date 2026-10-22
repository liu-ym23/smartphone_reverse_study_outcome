package com.bytedance.kmp.ec.yata.store.redux;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class m {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.bytedance.kmp.ec.yata.store.redux.StoreKt$createStoreInternal$dispatcher$1] */
    public static final h a(com.bytedance.kmp.ec.yata.store.core.l r110, g r111, j r112) {
        Intrinsics.checkNotNullParameter(r111, "reducer");
        if (r112 != null) goto L5;
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = r111;
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = r110;
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = new ArrayList();
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = r102.element;
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        final ?? r113 = new StoreKt$createStoreInternal$dispatcher$1(r104, r101, r100, r103, r102);
        return new StoreKt$createStoreInternal$1(r113, r101, r104, r103, r102);
    L5:
        return r112.a(new l()).a(r111, r110);
    }
}
