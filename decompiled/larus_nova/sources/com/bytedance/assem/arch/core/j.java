package com.bytedance.assem.arch.core;

import com.bytedance.assem.arch.reused.ReusedUIContentAssem;
import java.util.ArrayList;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssembleMode f192898a;

    public final ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a> a() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a> r100 = (ReusedUIContentAssem) JvmClassMappingKt.getJavaClass(null).newInstance();
        boolean r101 = false;
        r100.f193000x = 0;
        r100.f193001y = 0;
        if (this.f192898a != AssembleMode.IMMEDIATE) goto L5;
        r101 = true;
    L5:
        r100.f192853b = r101;
        return r100;
    }

    public final KClass<? extends ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a>> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public j() {
        this.f192898a = AssembleMode.IMMEDIATE;
        new ArrayList();
        InflateMode r100 = InflateMode.SYNC;
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
