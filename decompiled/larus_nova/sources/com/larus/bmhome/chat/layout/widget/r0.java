package com.larus.bmhome.chat.layout.widget;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class r0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f305247a;

    public /* synthetic */ r0(q0 r100) {
        this.f305247a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        q0 r101 = this.f305247a;
        WeakReference r102 = (WeakReference) r100;
        if (r102.get() != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        return Boolean.valueOf(r103);
    L5:
        if (Intrinsics.areEqual(r102.get(), r101) == true) goto L8;
        r103 = false;
        goto L10
    }
}
