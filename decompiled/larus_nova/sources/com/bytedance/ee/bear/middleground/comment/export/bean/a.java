package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f231364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f231365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f231366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f231367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f231368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f231369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Animator.AnimatorListener f231370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Float, Float> f231371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f231372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f231373j;

    public a(float r100, float r101, boolean r102, boolean r103, boolean r104, Animator.AnimatorListener r105) {
        CommentAnimationParam$1 r106 = CommentAnimationParam$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r106, "interpolator");
        this.f231364a = true;
        this.f231365b = r100;
        this.f231366c = r101;
        this.f231367d = r102;
        this.f231368e = r103;
        this.f231369f = r104;
        this.f231370g = r105;
        this.f231371h = r106;
        this.f231372i = 300;
    }
}
