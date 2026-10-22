package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.hilt.EntryPoints;
import dagger.hilt.components.SingletonComponent;
import dagger.internal.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements com.ss.android.lark.passportc.internal.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f433094a;

    @Override // com.ss.android.lark.passportc.internal.w
    public final e0c.m a() {
        v r100 = new v();
        Object r101 = EntryPoints.get(this.f433094a, SingletonComponent.class);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.officesdk.HiltRoot_HiltComponents.SingletonC");
        r100.f437243d = (w0) Preconditions.checkNotNull((w0) r101);
        return r100;
    }

    @Override // com.ss.android.lark.passportc.internal.c
    public final e0c.b b() {
        c r100 = new c();
        Object r101 = EntryPoints.get(this.f433094a, SingletonComponent.class);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.officesdk.HiltRoot_HiltComponents.SingletonC");
        r100.f433124d = (w0) Preconditions.checkNotNull((w0) r101);
        return r100;
    }

    @Inject
    public a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f433094a = r100;
    }
}
