package com.bytedance.assem.arch.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements h {
    public final AssembleMode a;
    public final List<l> b;

    @Override // com.bytedance.assem.arch.core.h
    public final Assem build() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        Assem r0 = (Assem) JvmClassMappingKt.getJavaClass(null).newInstance();
        if (this.a != AssembleMode.IMMEDIATE) goto L5;
        boolean r1 = true;
    L6:
        r0.b = r1;
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final KClass<? extends Assem> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public a() {
        this.a = AssembleMode.IMMEDIATE;
        this.b = new ArrayList();
    }
}
