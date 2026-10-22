package com.bytedance.assem.arch.core;

import com.bytedance.assem.arch.reused.ReusedUIContentAssem;
import java.util.ArrayList;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements h {
    public final AssembleMode a;

    public final ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a> a() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a> r0 = (ReusedUIContentAssem) JvmClassMappingKt.getJavaClass(null).newInstance();
        boolean r1 = false;
        r0.x = 0;
        r0.y = 0;
        if (this.a != AssembleMode.IMMEDIATE) goto L5;
        r1 = true;
    L5:
        r0.b = r1;
        return r0;
    }

    public final KClass<? extends ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a>> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public j() {
        this.a = AssembleMode.IMMEDIATE;
        new ArrayList();
        InflateMode r0 = InflateMode.SYNC;
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
