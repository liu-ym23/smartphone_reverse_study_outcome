package com.ss.android.lark.appcontext.applifecycle2.impl;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements jva.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f408892a;

    public d(c r100) {
        this.f408892a = r100;
    }

    @Override // jva.d.a
    public final void a(jva.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "processState");
        Log.i("AppLifecycle2", "process: " + this.f408892a.f408887b.b() + ", notify background change to remote: " + r100.a() + ' ');
        this.f408892a.f408888c.a(r100);
    }

    @Override // jva.d.a
    public final void b(jva.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "processState");
        int r101 = c.f408885g;
        Log.i("AppLifecycle2", "process: " + this.f408892a.f408887b.b() + ", notify foreground change to remote: " + r100.a() + ' ');
        this.f408892a.f408888c.a(r100);
    }
}
