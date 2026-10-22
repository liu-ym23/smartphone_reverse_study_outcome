package com.ss.android.lark.keyboard.edittext2.base;

import com.ss.android.lark.keyboard.edittext2.base.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d<E extends a> implements a.InterfaceC5085a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<E> f428961a;

    @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
    public final Class<E> a() {
        return this.f428961a;
    }

    public d(Class<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f428961a = r100;
        FunctionEditText.f428959b.add(r100);
    }
}
