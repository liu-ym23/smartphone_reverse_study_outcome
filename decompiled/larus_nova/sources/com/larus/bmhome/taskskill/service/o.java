package com.larus.bmhome.taskskill.service;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o implements l, Function1<k, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f314472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f314473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f314474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Function1<? super k, Unit> f314475d;

    @Override // com.larus.bmhome.taskskill.service.l
    public final void dispose() {
        this.f314473b.set(true);
        this.f314475d = null;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(k r100) {
        final k r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "event");
        boolean r102 = false;
        if (this.f314473b.get() == false) goto L5;
    L13:
        if (r102 == false) goto L27;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        this.f314472a.post(new n(this, r101));
        goto L27
    L18:
        if (this.f314473b.get() == true) goto L27;
        Function1<? super k, Unit> r103 = this.f314475d;
        if ((r101 instanceof k.h) == false) goto L23;
        this.f314475d = null;
    L23:
        if (r103 == null) goto L27;
        r103.invoke(r101);
    L27:
        return Unit.INSTANCE;
    L5:
        if ((r101 instanceof k.h) == false) goto L8;
        boolean r104 = this.f314474c.compareAndSet(false, true);
    L11:
        if (r104 == false) goto L13;
        r102 = true;
        goto L13
    L8:
        if (this.f314474c.get() == true) goto L10;
        r104 = true;
        goto L11
    L10:
        r104 = false;
        goto L11
    }

    public o(com.larus.bmhome.chat.standarduikit.interaction.viewmodel.h r100, Handler r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "mainHandler");
        this.f314472a = r101;
        this.f314473b = new AtomicBoolean(false);
        this.f314474c = new AtomicBoolean(false);
        this.f314475d = r100;
    }
}
