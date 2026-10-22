package com.ss.ugc.effectplatform.cache.disklrucache;

import java.io.FileOutputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends bytekn.foundation.io.file.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bytekn.foundation.io.file.e f457322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f457323c;

    @Override // bytekn.foundation.io.file.e
    public final void a() {
        this.f457322b.a();     // Catch: Exception -> L4
        return;
    L4:
        this.f457323c.invoke();
    }

    @Override // bytekn.foundation.io.file.e, bytekn.foundation.io.file.g
    public final void close() {
        this.f457322b.close();     // Catch: Exception -> L4
        return;
    L4:
        this.f457323c.invoke();
    }

    public d(bytekn.foundation.io.file.e r100, Function0<Unit> r101) {
        this.f457322b = r100;
        this.f457323c = r101;
        FileOutputStream r102 = r100.f21797a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");
    L5:
        this.f21797a = r102;
    }

    @Override // bytekn.foundation.io.file.e
    public final void b(byte[] r100, int r101) {
        this.f457322b.b(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        this.f457323c.invoke();
    }
}
