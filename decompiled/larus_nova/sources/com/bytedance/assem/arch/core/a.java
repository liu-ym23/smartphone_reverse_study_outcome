package com.bytedance.assem.arch.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssembleMode f192884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l> f192885b;

    @Override // com.bytedance.assem.arch.core.h
    public final Assem build() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        Assem r100 = (Assem) JvmClassMappingKt.getJavaClass(null).newInstance();
        if (this.f192884a != AssembleMode.IMMEDIATE) goto L5;
        boolean r101 = true;
    L6:
        r100.f192853b = r101;
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final KClass<? extends Assem> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public a() {
        this.f192884a = AssembleMode.IMMEDIATE;
        this.f192885b = new ArrayList();
    }
}
