package com.larus.camera.impl.ui.component.capture.edu;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class f0 implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f321912a;

    public f0(Ref.ObjectRef<Function0<Unit>> r100) {
        this.f321912a = r100;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.larus.camera.impl.ui.component.capture.edu.e0] */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f321912a.element.invoke();
        Ref.ObjectRef<Function0<Unit>> r100 = this.f321912a;
        r100.element = e0.f321911a;
        return Unit.INSTANCE;
    }
}
