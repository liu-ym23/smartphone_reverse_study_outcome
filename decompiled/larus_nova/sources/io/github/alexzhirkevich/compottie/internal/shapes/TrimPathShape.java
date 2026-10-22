package io.github.alexzhirkevich.compottie.internal.shapes;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.b2;

/* JADX INFO: loaded from: classes41.dex */
@SerialName("tm")
@Serializable
public final class TrimPathShape implements Shape {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f491562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f491563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f491564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f491565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f491566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte f491567g;

    public static final class a {
        public a() {
        }

        public final juc.d<TrimPathShape> serializer() {
            return TrimPathShape$$serializer.f491568a;
        }
    }

    @Override // zrc.a
    public final void b(List<? extends zrc.a> r100, List<? extends zrc.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "contentsBefore");
        Intrinsics.checkNotNullParameter(r101, "contentsAfter");
    }

    static {
        Companion = new a();
    }

    @Override // io.github.alexzhirkevich.compottie.internal.shapes.Shape
    public final Shape deepCopy() {
        return new TrimPathShape(this.f491561a, this.f491562b, this.f491563c, this.f491564d.i(), this.f491565e.i(), this.f491566f.i(), this.f491567g);
    }

    @Override // io.github.alexzhirkevich.compottie.internal.shapes.Shape
    public final boolean a() {
        return this.f491563c;
    }

    @Override // zrc.a
    public final String getName() {
        return this.f491561a;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.shapes.Shape
    public final void p(String r100, orc.j r101) {
        String r102 = this.f491561a;
        if (r102 == null) goto L7;
        if (r101 == null) goto L8;
        orc.k r103 = (orc.k) orc.j.a(r101, orc.q.a(r100, r102), Reflection.getOrCreateKotlinClass(orc.k.class));
        return;
    L8:
        return;
    }

    public TrimPathShape(String r100, String r101, boolean r102, io.github.alexzhirkevich.compottie.internal.animation.x r103, io.github.alexzhirkevich.compottie.internal.animation.x r104, io.github.alexzhirkevich.compottie.internal.animation.x r105, byte r106) {
        Intrinsics.checkNotNullParameter(r103, "start");
        Intrinsics.checkNotNullParameter(r104, "end");
        Intrinsics.checkNotNullParameter(r105, "offset");
        this.f491561a = r100;
        this.f491562b = r101;
        this.f491563c = r102;
        this.f491564d = r103;
        this.f491565e = r104;
        this.f491566f = r105;
        this.f491567g = r106;
    }

    public TrimPathShape(int r100, String r101, String r102, boolean r103, io.github.alexzhirkevich.compottie.internal.animation.x r104, io.github.alexzhirkevich.compottie.internal.animation.x r105, io.github.alexzhirkevich.compottie.internal.animation.x r110, bsc.y r111) {
        if (56 == (r100 & 56)) goto L5;
        b2.b(r100, 56, TrimPathShape$$serializer.f491569b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f491561a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f491562b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f491563c = false;
    L16:
        this.f491564d = r104;
        this.f491565e = r105;
        this.f491566f = r110;
        if ((r100 & 64) != 0) goto L19;
        bsc.y.Companion.getClass();
        byte r106 = bsc.y.f20487b;
    L20:
        this.f491567g = r106;
        return;
    L19:
        r106 = r111.f20489a;
        goto L20
    L15:
        this.f491563c = r103;
        goto L16
    L11:
        this.f491562b = r102;
        goto L13
    L7:
        this.f491561a = r101;
        goto L9
    }
}
