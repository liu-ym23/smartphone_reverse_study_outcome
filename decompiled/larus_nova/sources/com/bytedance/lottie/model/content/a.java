package com.bytedance.lottie.model.content;

import com.bytedance.lottie.LottieDrawable;
import java.util.List;
import nz6.h;
import rz6.c;
import rz6.d;
import rz6.f;
import sz6.b;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f264490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientType f264491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f264492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f264493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f264494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f264495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rz6.b f264496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ShapeStroke.LineCapType f264497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f264498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f264499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<rz6.b> f264500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final rz6.b f264501l;

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new h(r100, r101, this);
    }

    public a(String r100, GradientType r101, c r102, d r103, f r104, f r105, rz6.b r106, ShapeStroke.LineCapType r107, ShapeStroke.LineJoinType r108, float r110, List<rz6.b> r111, rz6.b r112) {
        this.f264490a = r100;
        this.f264491b = r101;
        this.f264492c = r102;
        this.f264493d = r103;
        this.f264494e = r104;
        this.f264495f = r105;
        this.f264496g = r106;
        this.f264497h = r107;
        this.f264498i = r108;
        this.f264499j = r110;
        this.f264500k = r111;
        this.f264501l = r112;
    }
}
