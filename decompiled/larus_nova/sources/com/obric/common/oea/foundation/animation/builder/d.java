package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f396374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f396375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dja.a<?> f396376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<String, Object, Object, Unit> f396377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Boolean, Throwable, Unit> f396378e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f396379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f396380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public dja.a<?> f396381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function3<? super String, Object, Object, Unit> f396382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function2<? super Boolean, ? super Throwable, Unit> f396383e;

        public final d a() {
            dja.a<?> r100 = this.f396381c;
            if (r100 != null) goto L5;
            int r101 = ija.b.f490154a;
            Intrinsics.checkNotNullParameter("必须先调用方法ofXXX方法指定动画初始和目标值", "message");
            throw new IllegalArgumentException("必须先调用方法ofXXX方法指定动画初始和目标值");
        L5:
            return new d(this.f396379a, this.f396380b, r100, this.f396382d, this.f396383e);
        }

        public a() {
            this.f396379a = 1.0f;
            this.f396380b = 60.0f;
        }

        public final void b(float r100, float r110, gja.a r111, Float r112) {
            Intrinsics.checkNotNullParameter(r111, "spec");
            if ((r111 instanceof hja.a) == false) goto L6;
            dja.a<?> r101 = new dja.a.b("valueAnimationPlaceholder", Float.valueOf(r100), Float.valueOf(r110), Reflection.getOrCreateKotlinClass(Float.TYPE), r111, r112);
        L8:
            this.f396381c = r101;
            return;
        L6:
            if ((r111 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L11;
            r101 = new dja.a.C5678a("valueAnimationPlaceholder", Float.valueOf(r100), Float.valueOf(r110), Reflection.getOrCreateKotlinClass(Float.TYPE), r111, r112);
            goto L8
        L11:
            throw new IllegalStateException("不支持的 spec 类型: ".concat(r111.getClass().getSimpleName()));
        }
    }

    public final fja.d a() {
        RunMode r100 = RunMode.PARALLEL;
        RepeatMode r101 = RepeatMode.NORMAL;
        mja.a.C6822a r102 = mja.a.f514263a;
        mja.a.a("ValueAnimatable", "执行start ");
        com.obric.common.oea.foundation.animation.builder.a r103 = new com.obric.common.oea.foundation.animation.builder.a(r100, r101, this.f396374a, this.f396375b);
        int r104 = com.obric.common.oea.foundation.animation.parser.a.f396386a;
        ArrayList r105 = new ArrayList();
        r105.add(this.f396376c);
        Unit r106 = Unit.INSTANCE;
        return com.obric.common.oea.foundation.animation.parser.a.a(r103, null, r105, this.f396377d, this.f396378e);
    }

    public d(float r100, float r101, dja.a r102, Function3 r103, Function2 r104) {
        this.f396374a = r100;
        this.f396375b = r101;
        this.f396376c = r102;
        this.f396377d = r103;
        this.f396378e = r104;
    }
}
