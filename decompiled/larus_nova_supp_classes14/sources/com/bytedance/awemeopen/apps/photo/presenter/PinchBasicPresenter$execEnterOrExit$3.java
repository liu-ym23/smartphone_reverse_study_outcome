package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.awemeopen.apps.photo.event.PinchStableViewEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class PinchBasicPresenter$execEnterOrExit$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public PinchBasicPresenter$execEnterOrExit$3(Object r8) {
        super(0, r8, PinchBasicPresenter.class, "onExitStableViewEnd", "onExitStableViewEnd()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1638invoke() {
        PinchBasicPresenter r0 = (PinchBasicPresenter) ((CallableReference) this).receiver;
        String r1 = r0.d.a.c();
        r0.o = false;
        r0.q().setInStableView(false);
        r0.q().onStableViewEvent(new PinchStableViewEvent(r1, PinchStableViewEvent.State.EXIT_END));
        View r2 = r0.j;
        if (r2 != null) goto L22;
    L20:
        r0.n(false);
        r0.s(true);
        return;
    L22:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        ViewParent r4 = r2.getParent();     // Catch: Throwable -> L13
        Unit r5 = null;
        if ((r4 instanceof ViewGroup) == false) goto L8;
        ViewGroup r6 = (ViewGroup) r4;     // Catch: Throwable -> L13
    L9:
        if (r6 == null) goto L11;
        r6.removeView(r2);     // Catch: Throwable -> L13
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(r5);     // Catch: Throwable -> L13
    L16:
        if (r2.getParent() != null) goto L20;
        ViewGroup r7 = r0.i;
        if (r7 == null) goto L20;
        r7.addView(r2, 0);
        goto L20
    L8:
        r6 = null;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1638invoke();
        return Unit.INSTANCE;
    }
}
