package com.ss.android.lark.cameraview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f0 implements d0b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayout f410977a;

    @Override // d0b.a
    public final void b() {
        d0b.a r100 = this.f410977a.f410807a;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // d0b.a
    public final void c() {
        d0b.a r100 = this.f410977a.f410807a;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f410977a.b();
    }

    public f0(CaptureLayout r100) {
        this.f410977a = r100;
    }

    @Override // d0b.a
    public final void a(long r100) {
        d0b.a r101 = this.f410977a.f410807a;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        this.f410977a.b();
    }

    @Override // d0b.a
    public final void d(long r100) {
        d0b.a r101 = this.f410977a.f410807a;
        if (r101 == null) goto L5;
        r101.d(r100);
    L5:
        this.f410977a.b();
        CaptureLayout r102 = this.f410977a;
        a1 r103 = null;
        if (r102.f410820n == 0) goto L11;
        ImageView r110 = r102.f410815i;
        if (r110 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r110 = null;
    L10:
        r110.setVisibility(8);
    L16:
        if (r102.f410821o == 0) goto L21;
        ImageView r111 = r102.f410816j;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r111 = null;
    L20:
        r111.setVisibility(8);
    L21:
        w r112 = r102.f410811e;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r112 = null;
    L24:
        r112.setVisibility(8);
        a1 r113 = r102.f410813g;
        if (r113 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r113 = null;
    L27:
        r113.setVisibility(0);
        a1 r114 = r102.f410812f;
        if (r114 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        r114 = null;
    L30:
        r114.setVisibility(0);
        a1 r115 = r102.f410813g;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r115 = null;
    L33:
        r115.setClickable(false);
        a1 r116 = r102.f410812f;
        if (r116 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        r116 = null;
    L36:
        r116.setClickable(false);
        a1 r117 = r102.f410813g;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        r117 = null;
    L39:
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r117, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102.f410818l / 4, 0.0f});
        a1 r104 = r102.f410812f;
        if (r104 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
    L43:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{(-r102.f410818l) / 4, 0.0f});
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r118, r105});
        r106.addListener(new l0(r102));
        r106.setDuration(200);
        r106.start();
        return;
    L42:
        r103 = r104;
        goto L43
    L11:
        y0 r119 = r102.f410814h;
        if (r119 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnReturn");
        r119 = null;
    L14:
        r119.setVisibility(8);
        goto L16
    }
}
