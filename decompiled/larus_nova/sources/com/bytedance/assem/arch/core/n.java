package com.bytedance.assem.arch.core;

import com.bytedance.assem.arch.view.UISlotAssem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssembleMode f192908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l> f192909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InflateMode f192910c;

    public final UISlotAssem a() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        UISlotAssem r100 = (UISlotAssem) JvmClassMappingKt.getJavaClass(null).newInstance();
        boolean r101 = false;
        r100.f193060i = 0;
        InflateMode r102 = this.f192910c;
        InflateMode r103 = InflateMode.ASYNC;
        if (r102 == r103) goto L5;
    L7:
        r103 = InflateMode.X2C;
        if (r102 == r103) goto L10;
    L12:
        r103 = InflateMode.SYNC;
    L13:
        r100.f193061j = r103;
        if (this.f192908a != AssembleMode.IMMEDIATE) goto L16;
        r101 = true;
    L16:
        r100.f192853b = r101;
        return r100;
    L10:
        if (((Boolean) UISlotAssem.f193059m.getValue()).booleanValue() == false) goto L12;
    L5:
        if (((Boolean) UISlotAssem.f193058l.getValue()).booleanValue() == false) goto L7;
        goto L7
    }

    public final KClass<? extends UISlotAssem> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public n() {
        this.f192908a = AssembleMode.IMMEDIATE;
        this.f192909b = new ArrayList();
        this.f192910c = InflateMode.SYNC;
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
