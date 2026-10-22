package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final boolean a;
    public final float b;
    public final float c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final Animator.AnimatorListener g;
    public final Function1<Float, Float> h;
    public final long i;
    public boolean j;

    public a(float r3, float r4, boolean r5, boolean r6, boolean r7, Animator.AnimatorListener r8) {
        CommentAnimationParam$1 r0 = CommentAnimationParam$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "interpolator");
        this.a = true;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r0;
        this.i = 300;
    }
}
