package i0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public final class h implements e, j0.a.InterfaceC6374a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f487765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f487766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f487767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f487768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f487769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f487770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f487771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<m> f487772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GradientType f487773j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j0.d f487774k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j0.e f487775l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j0.j f487776m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j0.j f487777n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j0.p f487778o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LottieDrawable f487779p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f487780q;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487779p.invalidateSelf();
    }

    public final int e() {
        int r100 = Math.round(this.f487776m.f496749e * this.f487780q);
        int r101 = Math.round(this.f487777n.f496749e * this.f487780q);
        int r102 = Math.round(this.f487774k.f496749e * this.f487780q);
        if (r100 == 0) goto L5;
        int r103 = r100 * TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER;
    L6:
        if (r101 == 0) goto L8;
        r103 = (r103 * 31) * r101;
    L8:
        if (r102 != 0) goto L10;
        return r103;
    L10:
        return (r103 * 31) * r102;
    L5:
        r103 = 17;
        goto L6
    }

    @Override // i0.c
    public final String getName() {
        return this.f487764a;
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L9;
        c r103 = (c) ListProtector.get(r101, r102);
        if ((r103 instanceof m) == false) goto L8;
        ArrayList r104 = (ArrayList) this.f487772i;
        r104.add((m) r103);
    L8:
        r102 = r102 + 1;
        goto L4
    }

    @Override // i0.e
    public final void c(RectF r100, Matrix r101) {
        this.f487769f.reset();
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f487772i).size()) goto L6;
        this.f487769f.addPath(((m) ListProtector.get(this.f487772i, r102)).getPath(), r101);
        r102 = r102 + 1;
        goto L4
    L6:
        this.f487769f.computeBounds(r100, false);
        r100.set(r100.left - 1.0f, r100.top - 1.0f, r100.right + 1.0f, r100.bottom + 1.0f);
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        if (r100 == com.airbnb.lottie.k.C) goto L5;
        return;
    L5:
        if (r0.c.a.f535397a == false) goto L9;
        j0.p r102 = this.f487778o;
        if (r102 == null) goto L9;
        ((ArrayList) this.f487765b.f24906t).remove(r102);
    L9:
        if (r101 != null) goto L11;
        this.f487778o = null;
        return;
    L11:
        j0.p r103 = new j0.p(r101);
        this.f487778o = r103;
        r103.a(this);
        this.f487765b.e(this.f487778o);
    }

    public h(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.d r102) {
        this.f487766c = new LongSparseArray();
        this.f487767d = new LongSparseArray();
        this.f487768e = new Matrix();
        Path r103 = new Path();
        this.f487769f = r103;
        this.f487771h = new RectF();
        this.f487772i = new ArrayList();
        if (r0.c.a.f535397a == false) goto L5;
        this.f487770g = new h0.a(1);
    L6:
        this.f487765b = r101;
        this.f487764a = r102.f521581g;
        this.f487779p = r100;
        this.f487773j = r102.f521575a;
        r103.setFillType(r102.f521576b);
        this.f487780q = (int) (r100.f24725b.getDuration() / 32.0f);
        j0.a<o0.c, o0.c> r104 = r102.f521577c.a();
        this.f487774k = (j0.d) r104;
        r104.a(this);
        r101.e(r104);
        j0.a<Integer, Integer> r105 = r102.f521578d.a();
        this.f487775l = (j0.e) r105;
        r105.a(this);
        r101.e(r105);
        j0.a<PointF, PointF> r106 = r102.f521579e.a();
        this.f487776m = (j0.j) r106;
        r106.a(this);
        r101.e(r106);
        j0.a<PointF, PointF> r107 = r102.f521580f.a();
        this.f487777n = (j0.j) r107;
        r107.a(this);
        r101.e(r107);
        return;
    L5:
        this.f487770g = new Paint(1);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // i0.e
    public final void d(Canvas r110, Matrix r111, int r112) {
        Set<String> r100 = com.airbnb.lottie.f.f24776a;
        this.f487769f.reset();
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f487772i).size()) goto L6;
        this.f487769f.addPath(((m) ListProtector.get(this.f487772i, r101)).getPath(), r111);
        r101 = r101 + 1;
        goto L4
    L6:
        this.f487769f.computeBounds(this.f487771h, false);
        if (this.f487773j != GradientType.Linear) goto L12;
        long r102 = e();
        RadialGradient r103 = this.f487766c.get(r102);
        if (r103 != null) goto L16;
        PointF r104 = this.f487776m.g();
        PointF r105 = this.f487777n.g();
        o0.c r106 = this.f487774k.g();
        LinearGradient r107 = new LinearGradient(r104.x, r104.y, r105.x, r105.y, r106.f521574b, r106.f521573a, Shader.TileMode.CLAMP);
        this.f487766c.put(r102, r107);
        r103 = r107;
    L16:
        this.f487768e.set(r111);
        r103.setLocalMatrix(this.f487768e);
        this.f487770g.setShader(r103);
        j0.p r108 = this.f487778o;
        if (r108 == null) goto L19;
        this.f487770g.setColorFilter((ColorFilter) r108.g());
    L19:
        int r109 = (int) ((((r112 / 255.0f) * this.f487775l.g().intValue()) / 100.0f) * 255.0f);
        Paint r113 = this.f487770g;
        u0.e.a r114 = u0.e.f548111a;
        r113.setAlpha(Math.max(0, Math.min(255, r109)));
        r110.drawPath(this.f487769f, this.f487770g);
        com.airbnb.lottie.f.a();
        return;
    L12:
        long r115 = e();
        r103 = this.f487767d.get(r115);
        if (r103 != null) goto L16;
        PointF r116 = this.f487776m.g();
        PointF r117 = this.f487777n.g();
        o0.c r118 = this.f487774k.g();
        int[] r119 = r118.f521574b;
        float[] r120 = r118.f521573a;
        float r121 = r116.x;
        float r122 = r116.y;
        r103 = new RadialGradient(r121, r122, (float) Math.hypot(r117.x - r121, r117.y - r122), r119, r120, Shader.TileMode.CLAMP);
        this.f487767d.put(r115, r103);
        goto L16
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        u0.e.d(r100, r101, r102, r103, this);
    }
}
