package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f435753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f435754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<View, Unit> f435755c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = System.currentTimeMillis();
        if ((r101 - this.f435753a) < this.f435754b) goto L6;
        this.f435753a = r101;
        this.f435755c.invoke(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(long r100, Function1<? super View, Unit> r101) {
        this.f435754b = r100;
        this.f435755c = r101;
    }
}
