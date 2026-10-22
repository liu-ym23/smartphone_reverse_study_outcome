package com.bytedance.assem.arch.core;

import android.view.View;
import com.bytedance.assem.arch.view.UIContentAssem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements h {
    public KClass<? extends UIContentAssem> a;
    public final AssembleMode b;
    public final List<l> c;
    public View d;

    public final UIContentAssem a() {
        KClass<? extends UIContentAssem> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("type");
    L5:
        UIContentAssem r1 = (UIContentAssem) JvmClassMappingKt.getJavaClass(r0).newInstance();
        boolean r2 = false;
        r1.i = 0;
        View r3 = this.d;
        if (r3 == null) goto L11;
        if (r3 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r1.h = r3;
    L11:
        if (this.b != AssembleMode.IMMEDIATE) goto L13;
        r2 = true;
    L13:
        r1.b = r2;
        return r1;
    }

    public final KClass<? extends UIContentAssem> getType() {
        KClass<? extends UIContentAssem> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("type");
    L5:
        return r0;
    }

    public m() {
        this.b = AssembleMode.IMMEDIATE;
        this.c = new ArrayList();
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
