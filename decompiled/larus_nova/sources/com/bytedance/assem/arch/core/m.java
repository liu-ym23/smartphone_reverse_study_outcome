package com.bytedance.assem.arch.core;

import android.view.View;
import com.bytedance.assem.arch.view.UIContentAssem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KClass<? extends UIContentAssem> f192904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssembleMode f192905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<l> f192906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f192907d;

    public final UIContentAssem a() {
        KClass<? extends UIContentAssem> r100 = this.f192904a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("type");
    L5:
        UIContentAssem r101 = (UIContentAssem) JvmClassMappingKt.getJavaClass(r100).newInstance();
        boolean r102 = false;
        r101.f193057i = 0;
        View r103 = this.f192907d;
        if (r103 == null) goto L11;
        if (r103 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r101.f192883h = r103;
    L11:
        if (this.f192905b != AssembleMode.IMMEDIATE) goto L13;
        r102 = true;
    L13:
        r101.f192853b = r102;
        return r101;
    }

    public final KClass<? extends UIContentAssem> getType() {
        KClass<? extends UIContentAssem> r100 = this.f192904a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("type");
    L5:
        return r100;
    }

    public m() {
        this.f192905b = AssembleMode.IMMEDIATE;
        this.f192906c = new ArrayList();
    }

    @Override // com.bytedance.assem.arch.core.h
    public final /* bridge */ /* synthetic */ Assem build() {
        return a();
    }
}
