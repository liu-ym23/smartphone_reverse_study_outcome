package com.larus.livetutor.impl.utils;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f356668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f356669b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (UtilsKt.f356659a == false) goto L6;
        UtilsKt.f356659a = false;
        UtilsKt.f356660b.postDelayed(UtilsKt.f356661c, this.f356668a);
        this.f356669b.invoke(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(long r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "clickBlock");
        this.f356668a = r100;
        this.f356669b = r101;
    }
}
