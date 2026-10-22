package com.bytedance.assem.arch.core;

import android.view.View;
import com.bytedance.assem.arch.reused.ReusedUISlotAssem;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements h {
    public final AssembleMode a;
    public final InflateMode b;
    public View c;

    public final ReusedUISlotAssem<? extends com.bytedance.tiktok.proxy.a> a() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        ReusedUISlotAssem<? extends com.bytedance.tiktok.proxy.a> r0 = (ReusedUISlotAssem) JvmClassMappingKt.getJavaClass(null).newInstance();
        boolean r1 = false;
        r0.x = 0;
        InflateMode r2 = this.b;
        InflateMode r3 = InflateMode.ASYNC;
        if (r2 == r3) goto L5;
    L7:
        r3 = InflateMode.X2C;
        Lazy r4 = ReusedUISlotAssem.B;
        if (r2 == r3) goto L10;
    L12:
        r3 = InflateMode.ASYNC_X2C;
        if (r2 == r3) goto L15;
    L17:
        r3 = InflateMode.SYNC;
    L18:
        r0.y = r3;
        if (this.a != AssembleMode.IMMEDIATE) goto L21;
        r1 = true;
    L21:
        r0.b = r1;
        View r5 = this.c;
        if (r5 == null) goto L24;
        r0.h = r5;
    L24:
        return r0;
    L15:
        if (((Boolean) ReusedUISlotAssem.C.getValue()).booleanValue() == false) goto L17;
    L10:
        if (((Boolean) ReusedUISlotAssem.C.getValue()).booleanValue() == false) goto L12;
    L5:
        if (((Boolean) ReusedUISlotAssem.B.getValue()).booleanValue() == false) goto L7;
        goto L7
    }

    public final KClass<? extends ReusedUISlotAssem<? extends com.bytedance.tiktok.proxy.a>> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public k() {
        this.a = AssembleMode.IMMEDIATE;
        new ArrayList();
        this.b = InflateMode.SYNC;
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
