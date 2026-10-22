package com.bytedance.assem.arch.core;

import com.bytedance.assem.arch.view.UISlotAssem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements h {
    public final AssembleMode a;
    public final List<l> b;
    public final InflateMode c;

    public final UISlotAssem a() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        UISlotAssem r0 = (UISlotAssem) JvmClassMappingKt.getJavaClass(null).newInstance();
        boolean r1 = false;
        r0.i = 0;
        InflateMode r2 = this.c;
        InflateMode r3 = InflateMode.ASYNC;
        if (r2 == r3) goto L5;
    L7:
        r3 = InflateMode.X2C;
        if (r2 == r3) goto L10;
    L12:
        r3 = InflateMode.SYNC;
    L13:
        r0.j = r3;
        if (this.a != AssembleMode.IMMEDIATE) goto L16;
        r1 = true;
    L16:
        r0.b = r1;
        return r0;
    L10:
        if (((Boolean) UISlotAssem.m.getValue()).booleanValue() == false) goto L12;
    L5:
        if (((Boolean) UISlotAssem.l.getValue()).booleanValue() == false) goto L7;
        goto L7
    }

    public final KClass<? extends UISlotAssem> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public n() {
        this.a = AssembleMode.IMMEDIATE;
        this.b = new ArrayList();
        this.c = InflateMode.SYNC;
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
