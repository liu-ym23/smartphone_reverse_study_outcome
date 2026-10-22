package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.larus.camera.impl.ui.component.capture.CaptureTitleComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 extends CaptureTitleComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.larus.camera.impl.utils.h f321902n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f321903o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f321904p;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f321905a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public a(Function0 r100) {
            this.f321905a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f321905a.invoke();
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f321906a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public b(Function0 r100) {
            this.f321906a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f321906a.invoke();
        }
    }

    public c0() {
        this.f321902n = new com.larus.camera.impl.utils.h();
        this.f321903o = "CAPTURE_MODE_EDU_GENERAL_PHOTO";
        List<String> r100 = fx8.a.f479110a;
        this.f321904p = fx8.a.f479114e;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent, com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f321904p;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent
    public final void s(CameraCaptureViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        w(r100, this.f321903o);
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent
    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        if (Intrinsics.areEqual(r100, this.f321903o) == false) goto L5;
        return;
    L5:
        String r101 = this.f321903o;
        this.f321903o = r100;
        if (Intrinsics.areEqual("CAPTURE_MODE_EDU_HOMEWORK_PHOTO", r100) == false) goto L8;
    L9:
        CameraCaptureViewModel r102 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r102 != null) goto L12;
        return;
    L12:
        w(r102, r100);
        return;
    L8:
        if (Intrinsics.areEqual("CAPTURE_MODE_EDU_HOMEWORK_PHOTO", r101) == true) goto L9;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.larus.camera.impl.ui.component.capture.edu.i0] */
    public static final Object u(c0 r100, Continuation r101) {
        r100.getClass();
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = new i0(r102);
        r100.r(new h0(r100, r103));
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L6:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r104;
    L9:
        return Unit.INSTANCE;
    }

    public final void v(View r100, Function0<Unit> r101) {
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, View.ALPHA, new float[]{1.0f, 0.3f, 1.0f});
        r102.setStartDelay(500);
        r102.setDuration(1000);
        r102.setInterpolator(new AccelerateDecelerateInterpolator());
        Intrinsics.checkNotNull(r102);
        r102.addListener(new b(r101));
        r102.addListener(new a(r101));
        com.larus.camera.impl.utils.h r103 = this.f321902n;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "animator");
        r103.f322774a.add(r102);
        r102.start();
    }

    public final void w(final CameraCaptureViewModel r100, String r101) {
        if (Intrinsics.areEqual("CAPTURE_MODE_EDU_HOMEWORK_PHOTO", r101) == false) goto L5;
        super.s(r100);
        return;
    L5:
        q(new com.larus.camera.impl.ui.component.capture.edu.a(r100, this));
        r100.checkupDarkMode(new h(this), new i(this));
    }
}
