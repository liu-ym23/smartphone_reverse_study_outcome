package com.obric.assistant.view.glowui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Float> f394250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Float, Unit> f394251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Float, Unit> f394252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f394253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Float> f394254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f394255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f394256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f394257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f394258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f394259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f394260k;

    /* JADX INFO: renamed from: com.obric.assistant.view.glowui.a$a, reason: collision with other inner class name */
    public static final class C4637a {
    }

    static {
    }

    public final void a(Function0<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "getAmplitude");
        if (this.f394253d != 0) goto L5;
        return;
    L5:
        this.f394253d = 0;
        this.f394254e = r100;
        float r101 = this.f394250a.invoke().floatValue();
        this.f394255f = 0;
        this.f394256g = 0;
        this.f394257h = 0;
        this.f394258i = 0;
        this.f394259j = 0.0f;
        this.f394260k = r101;
    }

    public a(e r100, f r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "getVolume");
        Intrinsics.checkNotNullParameter(r101, "setVolume");
        Intrinsics.checkNotNullParameter(r102, "setTime");
        this.f394250a = r100;
        this.f394251b = r101;
        this.f394252c = r102;
        this.f394253d = 1;
    }
}
