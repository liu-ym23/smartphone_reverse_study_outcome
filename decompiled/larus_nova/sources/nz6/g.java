package nz6;

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
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.GradientType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements d, oz6.a.InterfaceC7134a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lottie.model.layer.a f521471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f521472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f521473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f521474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f521475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f521476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f521477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<l> f521478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GradientType f521479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final oz6.d f521480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final oz6.e f521481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final oz6.j f521482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final oz6.j f521483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public oz6.p f521484o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LottieDrawable f521485p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f521486q;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521485p.invalidateSelf();
    }

    public final int e() {
        int r100 = Math.round(this.f521482m.f527199d * this.f521486q);
        int r101 = Math.round(this.f521483n.f527199d * this.f521486q);
        int r102 = Math.round(this.f521480k.f527199d * this.f521486q);
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

    @Override // nz6.b
    public final String getName() {
        return this.f521470a;
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L9;
        b r103 = (b) ListProtector.get(r101, r102);
        if ((r103 instanceof l) == false) goto L8;
        ArrayList r104 = (ArrayList) this.f521478i;
        r104.add((l) r103);
    L8:
        r102 = r102 + 1;
        goto L4
    }

    @Override // nz6.d
    public final void c(RectF r100, Matrix r101) {
        this.f521475f.reset();
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f521478i).size()) goto L6;
        this.f521475f.addPath(((l) ListProtector.get(this.f521478i, r102)).getPath(), r101);
        r102 = r102 + 1;
        goto L4
    L6:
        this.f521475f.computeBounds(r100, false);
        r100.set(r100.left - 1.0f, r100.top - 1.0f, r100.right + 1.0f, r100.bottom + 1.0f);
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        if (r100 != com.bytedance.lottie.n.f264576x) goto L8;
        if (r101 != null) goto L6;
        this.f521484o = null;
        return;
    L6:
        oz6.p r102 = new oz6.p(r101);
        this.f521484o = r102;
        r102.a(this);
        this.f521471b.e(this.f521484o);
        return;
    }

    public g(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.d r102) {
        this.f521472c = new LongSparseArray();
        this.f521473d = new LongSparseArray();
        this.f521474e = new Matrix();
        Path r103 = new Path();
        this.f521475f = r103;
        this.f521476g = new Paint(1);
        this.f521477h = new RectF();
        this.f521478i = new ArrayList();
        this.f521471b = r101;
        this.f521470a = r102.f543960g;
        this.f521485p = r100;
        this.f521479j = r102.f543954a;
        r103.setFillType(r102.f543955b);
        this.f521486q = (int) (r100.f264394b.b() / 32.0f);
        oz6.a<sz6.c, sz6.c> r104 = r102.f543956c.a();
        this.f521480k = (oz6.d) r104;
        r104.a(this);
        r101.e(r104);
        oz6.a<Integer, Integer> r105 = r102.f543957d.a();
        this.f521481l = (oz6.e) r105;
        r105.a(this);
        r101.e(r105);
        oz6.a<PointF, PointF> r106 = r102.f543958e.a();
        this.f521482m = (oz6.j) r106;
        r106.a(this);
        r101.e(r106);
        oz6.a<PointF, PointF> r107 = r102.f543959f.a();
        this.f521483n = (oz6.j) r107;
        r107.a(this);
        r101.e(r107);
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
    @Override // nz6.d
    public final void d(Canvas r110, Matrix r111, int r112) {
        Set<String> r100 = com.bytedance.lottie.c.f264422a;
        this.f521475f.reset();
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f521478i).size()) goto L6;
        this.f521475f.addPath(((l) ListProtector.get(this.f521478i, r101)).getPath(), r111);
        r101 = r101 + 1;
        goto L4
    L6:
        this.f521475f.computeBounds(this.f521477h, false);
        if (this.f521479j != GradientType.Linear) goto L12;
        long r102 = e();
        RadialGradient r103 = this.f521472c.get(r102);
        if (r103 != null) goto L16;
        PointF r104 = this.f521482m.e();
        PointF r105 = this.f521483n.e();
        sz6.c r106 = this.f521480k.e();
        LinearGradient r107 = new LinearGradient(r104.x, r104.y, r105.x, r105.y, r106.f543953b, r106.f543952a, Shader.TileMode.CLAMP);
        this.f521472c.put(r102, r107);
        r103 = r107;
    L16:
        this.f521474e.set(r111);
        r103.setLocalMatrix(this.f521474e);
        this.f521476g.setShader(r103);
        oz6.p r108 = this.f521484o;
        if (r108 == null) goto L19;
        this.f521476g.setColorFilter((ColorFilter) r108.e());
    L19:
        this.f521476g.setAlpha(Math.max(0, Math.min(255, (int) ((((r112 / 255.0f) * this.f521481l.e().intValue()) / 100.0f) * 255.0f))));
        r110.drawPath(this.f521475f, this.f521476g);
        com.bytedance.lottie.c.a();
        return;
    L12:
        long r109 = e();
        r103 = this.f521473d.get(r109);
        if (r103 != null) goto L16;
        PointF r113 = this.f521482m.e();
        PointF r114 = this.f521483n.e();
        sz6.c r115 = this.f521480k.e();
        int[] r116 = r115.f543953b;
        float[] r117 = r115.f543952a;
        float r118 = r113.x;
        float r119 = r113.y;
        r103 = new RadialGradient(r118, r119, (float) Math.hypot(r114.x - r118, r114.y - r119), r116, r117, Shader.TileMode.CLAMP);
        this.f521473d.put(r109, r103);
        goto L16
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        wz6.f.d(r100, r101, r102, r103, this);
    }
}
