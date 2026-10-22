package com.bytedance.component.lyric.model;

import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import ig4.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class LyricsDisplayConfig {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final float f203005u = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f203006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f203007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f203008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f203009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f203010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint.Align f203011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f203012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f203013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f203014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Float f203015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f203016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f203017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f203018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f203019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f203020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Paint, Unit> f203021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Shader f203022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Float f203023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Float f203024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f203025t;

    public static final class a {
    }

    static {
        f203005u = t6.a(jc1.a.b(), 240.0f);
    }

    public final void a() {
        final LyricsDisplayConfig$applyDefault$initPaintTast$1 r100 = LyricsDisplayConfig$applyDefault$initPaintTast$1.INSTANCE;
        d(new LyricsDisplayConfig$applyDefault$1(r100));
        b(new LyricsDisplayConfig$applyDefault$2(r100));
        c(new LyricsDisplayConfig$applyDefault$3(r100));
        this.f203012g = 2;
        e(Paint.Align.RIGHT, 2);
        this.f203007b = 8.0f;
        this.f203015j = Float.valueOf(UtilityKotlinExtentionsKt.h(2.0f));
        this.f203010e = true;
    }

    public LyricsDisplayConfig() {
        this.f203006a = 9.0f;
        this.f203007b = 2.0f;
        this.f203008c = 1.0f;
        this.f203009d = f203005u;
        this.f203010e = true;
        this.f203011f = Paint.Align.CENTER;
        this.f203012g = 2;
        int r100 = c.f489728f;
        this.f203013h = c.a.a(Paint.Align.CENTER, 2);
        this.f203014i = new Paint();
        this.f203016k = new Paint();
        this.f203017l = new Paint();
        this.f203018m = new Paint();
        this.f203019n = 3;
        this.f203020o = true;
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        r100.invoke(this.f203017l);
    }

    public final void c(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        r100.invoke(this.f203014i);
    }

    public final void d(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        r100.invoke(this.f203016k);
    }

    public final void f(float r100) {
        if (r100 <= 0) goto L5;
        this.f203010e = false;
    L5:
        this.f203009d = r100;
    }

    public final void g(Typeface r100) {
        this.f203025t = r100;
        if (r100 == null) goto L5;
        this.f203016k.setTypeface(r100);
        this.f203017l.setTypeface(r100);
        this.f203014i.setTypeface(r100);
        Unit r101 = Unit.INSTANCE;
        return;
    L5:
        new LyricsDisplayConfig$updateFont$2(this);
    }

    public final void e(Paint.Align r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "align");
        this.f203011f = r100;
        int r102 = c.f489728f;
        this.f203013h = c.a.a(r100, r101);
        this.f203016k.setTextAlign(this.f203011f);
        this.f203017l.setTextAlign(this.f203011f);
        this.f203018m.setTextAlign(this.f203011f);
        this.f203014i.setTextAlign(this.f203011f);
    }

    public final void h(String r100, String r101) {
        Paint r102 = this.f203017l;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "#FE4479";
    L6:
        r102.setColor(ColorProtector.parseColor(r100));
        Paint r103 = this.f203014i;
        if (TextUtils.isEmpty(r101) == true) goto L9;
        int r104 = ColorProtector.parseColor(r101);
    L10:
        r103.setColor(r104);
        return;
    L9:
        r104 = -1;
        goto L10
    }

    public final void i(float r100, float r101) {
        this.f203023r = Float.valueOf(r100);
        this.f203024s = Float.valueOf(r101);
        this.f203016k.setTextSize(r100);
        this.f203017l.setTextSize(r100);
        this.f203018m.setTextSize(r100);
        this.f203014i.setTextSize(r101);
    }
}
