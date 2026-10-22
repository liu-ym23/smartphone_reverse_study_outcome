package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.facebook.keyframes.model.KFAnimation;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import defpackage.v0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f396362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f396363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f396364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<dja.a<?>> f396365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<? super String, Object, Object, Unit> f396366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<? super Boolean, ? super Throwable, Unit> f396367f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f396368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f396369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<dja.a<?>> f396370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function3<? super String, Object, Object, Unit> f396371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function2<? super Boolean, ? super Throwable, Unit> f396372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f396373f;

        public final b a() {
            List<dja.a<?>> r100 = this.f396370c;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            int r102 = ija.b.f490154a;
            Intrinsics.checkNotNullParameter("必须先调用方法ofXXX方法指定添加动画", "message");
            throw new IllegalArgumentException("必须先调用方法ofXXX方法指定添加动画");
        L11:
            return new b(this.f396373f, this.f396368a, this.f396369b, this.f396370c, this.f396371d, this.f396372e);
        L5:
            if (((ArrayList) r100).isEmpty() == true) goto L8;
            r101 = false;
            goto L9
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f396373f = r100;
            this.f396368a = 1.0f;
            this.f396369b = 60.0f;
            this.f396370c = new ArrayList();
        }

        public static /* synthetic */ void c(a r100, AnimationProperty$FloatProperty r101, Float r102, float r103, gja.a r110) {
            r100.b(r101, r102, r103, r110, null);
        }

        public final void b(AnimationProperty$FloatProperty r100, Float r110, float r111, gja.a r112, Float r113) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r112, "spec");
            if (r110 == null) goto L27;
            float r114 = r110.floatValue();
        L16:
            if ((r112 instanceof hja.a) == false) goto L19;
            Object r101 = new dja.a.b(r100.getPropertyName(), Float.valueOf(r114), Float.valueOf(r111), Reflection.getOrCreateKotlinClass(Float.TYPE), r112, r113);
        L21:
            ((ArrayList) this.f396370c).add(r101);
            return;
        L19:
            if ((r112 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L24;
            r101 = new dja.a.C5678a(r100.getPropertyName(), Float.valueOf(r114), Float.valueOf(r111), Reflection.getOrCreateKotlinClass(Float.TYPE), r112, r113);
            goto L21
        L24:
            throw new IllegalStateException("不支持的 spec 类型: ".concat(r112.getClass().getSimpleName()));
        L27:
            Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L10
            Object r116 = v0.c(this.f396373f, r100.getPropertyName());     // Catch: Throwable -> L10
            if (r116 == null) goto L9;
            Object r117 = Result.m9449constructorimpl(Float.valueOf(((Float) r116).floatValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r102 = Result.m9452exceptionOrNullimpl(r117);
            if (r102 != null) goto L26;
            r114 = ((Number) r117).floatValue();
            goto L16
        L26:
            throw new IllegalArgumentException("获取属性 " + r100.getPropertyName() + " 的初始值时出错，请检查", r102);
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }
    }

    public static fja.d a(b r100) {
        RunMode r101 = RunMode.PARALLEL;
        RepeatMode r102 = RepeatMode.NORMAL;
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r102, "repeatMode");
        mja.a.C6822a r103 = mja.a.f514263a;
        mja.a.a("PropertyAnimatable", "执行start ");
        com.obric.common.oea.foundation.animation.builder.a r104 = new com.obric.common.oea.foundation.animation.builder.a(r101, r102, r100.f396363b, r100.f396364c);
        int r105 = com.obric.common.oea.foundation.animation.parser.a.f396386a;
        View r106 = r100.f396362a;
        List<dja.a<?>> r107 = r100.f396365d;
        if (r107 == null) goto L7;
        return com.obric.common.oea.foundation.animation.parser.a.a(r104, r106, r107, r100.f396366e, r100.f396367f);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }

    public b(View r100, float r101, float r102, List r103, Function3 r104, Function2 r105) {
        this.f396362a = r100;
        this.f396363b = r101;
        this.f396364c = r102;
        this.f396365d = r103;
        this.f396366e = r104;
        this.f396367f = r105;
    }
}
