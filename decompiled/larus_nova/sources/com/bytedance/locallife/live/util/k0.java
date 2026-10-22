package com.bytedance.locallife.live.util;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class k0 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f260708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f260709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f260710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f260711d;

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f260712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f260713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f260714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Animatable f260715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<Integer, Unit> f260716e;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            this.f260713b.invoke();
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            this.f260714c.invoke();
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            if (com.bytedance.locallife.live.experiment.z.a() == false) goto L5;
        L8:
            Function1<Integer, Unit> r102 = this.f260716e;
            if (r102 == null) goto L12;
            r102.invoke(Integer.valueOf(r101));
            return;
        L12:
            return;
        L5:
            if (r101 >= this.f260712a) goto L7;
            this.f260715d.stop();
        L7:
            this.f260712a = r101;
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<Unit> r100, Function0<Unit> r101, Animatable r102, Function1<? super Integer, Unit> r103) {
            this.f260713b = r100;
            this.f260714c = r101;
            this.f260715d = r102;
            this.f260716e = r103;
            this.f260712a = -1;
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Function0<Unit> r102 = this.f260708a;
        if (r102 == null) goto L6;
        r102.invoke();
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if ((r102 instanceof AnimatedDrawable2) == false) goto L14;
        jv6.h r103 = com.bytedance.locallife.live.settings.c.f();
        boolean r104 = true;
        if (r103 == null) goto L7;
        int r105 = r103.d();
    L8:
        if (r105 == 1) goto L11;
        r104 = false;
    L11:
        if (r104 == true) goto L13;
        AnimatedDrawable2 r106 = (AnimatedDrawable2) r102;
        r106.setPrivateFrameScheduler(new DropFramesFrameScheduler(r106.getAnimationBackend()));
    L13:
        ((AnimatedDrawable2) r102).setAnimationListener(new a(this.f260709b, this.f260710c, r102, this.f260711d));
        goto L14
    L7:
        r105 = 1;
    L14:
        if (r102 == null) goto L17;
        r102.start();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k0(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102, Function1<? super Integer, Unit> r103) {
        this.f260708a = r100;
        this.f260709b = r101;
        this.f260710c = r102;
        this.f260711d = r103;
    }
}
