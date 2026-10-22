package com.bytedance.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.c;
import com.bytedance.lottie.model.content.Mask;
import com.bytedance.lottie.s;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nz6.d;
import oz6.g;
import oz6.o;
import qz6.e;
import qz6.f;
import rz6.l;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a implements d, oz6.a.InterfaceC7134a, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f264525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f264526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f264527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f264528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f264529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f264530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f264531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f264532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f264533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f264534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f264535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f264536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LottieDrawable f264537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Layer f264538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f264539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f264540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f264541q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<a> f264542r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<oz6.a<?, ?>> f264543s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final o f264544t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f264545u;

    /* JADX INFO: renamed from: com.bytedance.lottie.model.layer.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C3709a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f264546a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f264547b = null;

        static {
            int[] r100 = new int[Mask.MaskMode.values().length];
            f264547b = r100;
            r100[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            f264547b[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L35:
            f264547b[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            int[] r101 = new int[Layer.LayerType.values().length];
            f264546a = r101;
            r101[Layer.LayerType.Shape.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L45:
            f264546a[Layer.LayerType.PreComp.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L27:
            f264546a[Layer.LayerType.Solid.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L33:
            f264546a[Layer.LayerType.Image.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L43:
            f264546a[Layer.LayerType.Null.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            f264546a[Layer.LayerType.Text.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L37:
            f264546a[Layer.LayerType.Unknown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    @Override // nz6.b
    public final void b(List<nz6.b> r100, List<nz6.b> r101) {
    }

    public abstract void j(Canvas r100, Matrix r101, int r102);

    public void m(e r100, int r101, List<e> r102, e r103) {
    }

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f264537m.invalidateSelf();
    }

    @Override // nz6.b
    public final String getName() {
        return this.f264538n.f264504c;
    }

    public final boolean k() {
        g r100 = this.f264539o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (((ArrayList) r100.f527212a).isEmpty() == true) goto L7;
        return true;
    }

    public final void l() {
        s r100 = this.f264537m.f264394b.f264424a;
        String r101 = this.f264538n.f264504c;
        if (r100.f264590a == false) goto L19;
        wz6.e r102 = (wz6.e) ((HashMap) r100.f264592c).get(r101);
        if (r102 != null) goto L8;
        r102 = new wz6.e();
        ((HashMap) r100.f264592c).put(r101, r102);
    L8:
        int r103 = r102.f561953a + 1;
        r102.f561953a = r103;
        if (r103 != Integer.MAX_VALUE) goto L12;
        r102.f561953a = r103 / 2;
    L12:
        if (r101.equals("__container") == false) goto L17;
        Iterator<E> r104 = r100.f264591b.iterator();
    L15:
        if (r104.hasNext() == false) goto L20;
        ((s.a) r104.next()).a();
        goto L15
    L20:
        return;
    L17:
        return;
    }

    public final void e(oz6.a<?, ?> r100) {
        this.f264543s.add(r100);
    }

    public final void i(Canvas r110) {
        Set<String> r100 = c.f264422a;
        RectF r101 = this.f264532h;
        r110.drawRect(r101.left - 1.0f, r101.top - 1.0f, r101.right + 1.0f, r101.bottom + 1.0f, this.f264531g);
        c.a();
    }

    public void n(float r100) {
        o r101 = this.f264544t;
        r101.f527227b.h(r100);
        r101.f527228c.h(r100);
        r101.f527229d.h(r100);
        r101.f527230e.h(r100);
        r101.f527231f.h(r100);
        oz6.c r102 = r101.f527232g;
        if (r102 == null) goto L5;
        r102.h(r100);
    L5:
        oz6.c r103 = r101.f527233h;
        if (r103 == null) goto L8;
        r103.h(r100);
    L8:
        int r104 = 0;
        if (this.f264539o == null) goto L14;
        int r105 = 0;
    L12:
        if (r105 >= ((ArrayList) this.f264539o.f527212a).size()) goto L14;
        ((oz6.a) ListProtector.get(this.f264539o.f527212a, r105)).h(r100);
        r105 = r105 + 1;
    L14:
        float r106 = this.f264538n.f264514m;
        if (r106 == 0.0f) goto L17;
        r100 = r100 / r106;
    L17:
        a r107 = this.f264540p;
        if (r107 == null) goto L21;
        r107.n(r107.f264538n.f264514m * r100);
    L21:
        if (r104 >= ((ArrayList) this.f264543s).size()) goto L23;
        ((oz6.a) ListProtector.get(this.f264543s, r104)).h(r100);
        r104 = r104 + 1;
        goto L21
    }

    public a(LottieDrawable r100, Layer r101) {
        this.f264525a = new Path();
        this.f264526b = new Matrix();
        boolean r102 = true;
        this.f264527c = new Paint(1);
        Paint r103 = new Paint(1);
        this.f264528d = r103;
        Paint r104 = new Paint(1);
        this.f264529e = r104;
        Paint r105 = new Paint(1);
        this.f264530f = r105;
        Paint r106 = new Paint();
        this.f264531g = r106;
        this.f264532h = new RectF();
        this.f264533i = new RectF();
        this.f264534j = new RectF();
        this.f264535k = new RectF();
        this.f264536l = new Matrix();
        this.f264543s = new ArrayList();
        this.f264545u = true;
        this.f264537m = r100;
        this.f264538n = r101;
        StringBuilder r107 = new StringBuilder();
        r107.append(r101.f264504c);
        r107.append("#draw");
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (r101.f264522u != Layer.MatteType.Invert) goto L5;
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    L6:
        l r108 = r101.f264510i;
        r108.getClass();
        o r109 = new o(r108);
        this.f264544t = r109;
        r109.b(this);
        List<Mask> r110 = r101.f264509h;
        if (r110 == null) goto L19;
        if (r110.isEmpty() == true) goto L19;
        g r111 = new g(r101.f264509h);
        this.f264539o = r111;
        Iterator r112 = ((ArrayList) r111.f527212a).iterator();
    L12:
        if (r112.hasNext() == false) goto L14;
        ((oz6.a) r112.next()).a(this);
        goto L12
    L14:
        Iterator r113 = ((ArrayList) this.f264539o.f527213b).iterator();
    L16:
        if (r113.hasNext() == false) goto L19;
        oz6.a<?, ?> r114 = (oz6.a) r113.next();
        e(r114);
        r114.a(this);
    L19:
        if (this.f264538n.f264521t.isEmpty() == true) goto L29;
        oz6.c r115 = new oz6.c(this.f264538n.f264521t);
        r115.f527197b = true;
        r115.a(new tz6.a(this, r115));
        if (r115.e().floatValue() == 1.0f) goto L25;
        r102 = false;
    L25:
        if (r102 == this.f264545u) goto L27;
        this.f264545u = r102;
        this.f264537m.invalidateSelf();
    L27:
        e(r115);
        return;
    L29:
        if (true == this.f264545u) goto L35;
        this.f264545u = true;
        this.f264537m.invalidateSelf();
        return;
    L35:
        return;
    L5:
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        goto L6
    }

    @Override // nz6.d
    public void c(RectF r100, Matrix r101) {
        this.f264536l.set(r101);
        this.f264536l.preConcat(this.f264544t.d());
    }

    @Override // qz6.f
    public <T> void f(T r100, xz6.c<T> r101) {
        this.f264544t.c(r100, r101);
    }

    @Override // nz6.d
    public final void d(Canvas r110, Matrix r111, int r112) {
        Set<String> r100 = c.f264422a;
        if (this.f264545u == true) goto L7;
        c.a();
        return;
    L7:
        if (this.f264542r == null) goto L10;
    L15:
        Set<String> r101 = c.f264422a;
        this.f264526b.reset();
        this.f264526b.set(r111);
        int r102 = 1;
        int r103 = this.f264542r.size() - 1;
    L16:
        if (r103 < 0) goto L18;
        this.f264526b.preConcat(((a) ListProtector.get(this.f264542r, r103)).f264544t.d());
        r103 = r103 - 1;
        goto L16
    L18:
        c.a();
        int r104 = (int) ((((r112 / 255.0f) * this.f264544t.f527231f.e().intValue()) / 100.0f) * 255.0f);
        if (this.f264540p == null) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L24;
    L27:
        this.f264532h.set(0.0f, 0.0f, 0.0f, 0.0f);
        c(this.f264532h, this.f264526b);
        RectF r106 = this.f264532h;
        Matrix r107 = this.f264526b;
        a r108 = this.f264540p;
        if (r108 == null) goto L30;
        boolean r113 = true;
    L31:
        if (r113 == true) goto L34;
    L37:
        this.f264526b.preConcat(this.f264544t.d());
        RectF r109 = this.f264532h;
        Matrix r114 = this.f264526b;
        this.f264533i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (k() == false) goto L52;
        int r115 = this.f264539o.f527214c.size();
        int r116 = 0;
    L41:
        if (r116 >= r115) goto L51;
        Mask r117 = (Mask) ListProtector.get(this.f264539o.f527214c, r116);
        this.f264525a.set((Path) ((oz6.a) ListProtector.get(this.f264539o.f527212a, r116)).e());
        this.f264525a.transform(r114);
        int r118 = C3709a.f264547b[r117.f264456a.ordinal()];
        if (r118 == r102) goto L52;
        if (r118 == 2) goto L52;
        this.f264525a.computeBounds(this.f264535k, false);
        if (r116 != 0) goto L49;
        this.f264533i.set(this.f264535k);
    L50:
        r116 = r116 + 1;
        r102 = 1;
        goto L41
    L49:
        RectF r119 = this.f264533i;
        r119.set(Math.min(r119.left, this.f264535k.left), Math.min(this.f264533i.top, this.f264535k.top), Math.max(this.f264533i.right, this.f264535k.right), Math.max(this.f264533i.bottom, this.f264535k.bottom));
        goto L50
    L51:
        r109.set(Math.max(r109.left, this.f264533i.left), Math.max(r109.top, this.f264533i.top), Math.min(r109.right, this.f264533i.right), Math.min(r109.bottom, this.f264533i.bottom));
    L52:
        this.f264532h.set(0.0f, 0.0f, r110.getWidth(), r110.getHeight());
        c.a();
        RectF r120 = this.f264532h;
        Paint r121 = this.f264527c;
        int r122 = Build.VERSION.SDK_INT;
        if (r122 >= 23) goto L55;
        r110.saveLayer(r120, r121, 31);
    L56:
        c.a();
        i(r110);
        j(r110, this.f264526b, r104);
        c.a();
        if (k() == false) goto L60;
        Matrix r123 = this.f264526b;
        h(r110, r123, Mask.MaskMode.MaskModeAdd);
        h(r110, r123, Mask.MaskMode.MaskModeIntersect);
        h(r110, r123, Mask.MaskMode.MaskModeSubtract);
    L60:
        if (this.f264540p == null) goto L62;
        boolean r124 = true;
    L63:
        if (r124 == false) goto L69;
        RectF r125 = this.f264532h;
        Paint r126 = this.f264530f;
        if (r122 >= 23) goto L67;
        r110.saveLayer(r125, r126, 31);
    L68:
        c.a();
        i(r110);
        this.f264540p.d(r110, r111, r104);
        r110.restore();
        c.a();
        c.a();
        goto L69
    L67:
        r110.saveLayer(r125, r126);
    L69:
        r110.restore();
        c.a();
        c.a();
        l();
        return;
    L62:
        r124 = false;
        goto L63
    L55:
        r110.saveLayer(r120, r121);
        goto L56
    L34:
        if (this.f264538n.f264522u == Layer.MatteType.Invert) goto L37;
        r108.c(this.f264534j, r107);
        r106.set(Math.max(r106.left, this.f264534j.left), Math.max(r106.top, this.f264534j.top), Math.min(r106.right, this.f264534j.right), Math.min(r106.bottom, this.f264534j.bottom));
        goto L37
    L30:
        r113 = false;
        goto L31
    L24:
        if (k() == true) goto L27;
        this.f264526b.preConcat(this.f264544t.d());
        j(r110, this.f264526b, r104);
        c.a();
        c.a();
        l();
        return;
    L21:
        r105 = false;
        goto L22
    L10:
        if (this.f264541q != null) goto L12;
        this.f264542r = Collections.emptyList();
        goto L15
    L12:
        this.f264542r = new ArrayList();
        a r127 = this.f264541q;
    L13:
        if (r127 == null) goto L15;
        this.f264542r.add(r127);
        r127 = r127.f264541q;
        goto L13
    }

    public final void h(Canvas r100, Matrix r101, Mask.MaskMode r102) {
        boolean r103 = true;
        if (C3709a.f264547b[r102.ordinal()] == 1) goto L5;
        Paint r104 = this.f264528d;
    L6:
        int r105 = this.f264539o.f527214c.size();
        int r106 = 0;
        int r107 = 0;
    L7:
        if (r107 >= r105) goto L12;
        if (((Mask) ListProtector.get(this.f264539o.f527214c, r107)).f264456a == r102) goto L13;
        r107 = r107 + 1;
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        Set<String> r108 = c.f264422a;
        RectF r109 = this.f264532h;
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        r100.saveLayer(r109, r104, 31);
    L19:
        c.a();
        i(r100);
    L20:
        if (r106 >= r105) goto L26;
        if (((Mask) ListProtector.get(this.f264539o.f527214c, r106)).f264456a != r102) goto L25;
        this.f264525a.set((Path) ((oz6.a) ListProtector.get(this.f264539o.f527212a, r106)).e());
        this.f264525a.transform(r101);
        oz6.a r110 = (oz6.a) ListProtector.get(this.f264539o.f527213b, r106);
        int r111 = this.f264527c.getAlpha();
        this.f264527c.setAlpha((int) (((Integer) r110.e()).intValue() * 2.55f));
        r100.drawPath(this.f264525a, this.f264527c);
        this.f264527c.setAlpha(r111);
    L25:
        r106 = r106 + 1;
        goto L20
    L26:
        Set<String> r112 = c.f264422a;
        r100.restore();
        c.a();
        c.a();
        return;
    L18:
        r100.saveLayer(r109, r104);
        goto L19
    L12:
        r103 = false;
        goto L13
    L5:
        r104 = this.f264529e;
        goto L6
    }

    @Override // qz6.f
    public final void g(e r100, int r101, List<e> r102, e r103) {
        if (r100.c(this.f264538n.f264504c, r101) == true) goto L6;
        return;
    L6:
        if ("__container".equals(this.f264538n.f264504c) == true) goto L12;
        String r104 = this.f264538n.f264504c;
        r103.getClass();
        e r105 = new e(r103);
        r105.f535375a.add(r104);
        if (r100.a(this.f264538n.f264504c, r101) == false) goto L10;
        e r106 = new e(r105);
        r106.f535376b = this;
        ((ArrayList) r102).add(r106);
    L10:
        r103 = r105;
    L12:
        if (r100.d(this.f264538n.f264504c, r101) == false) goto L15;
        m(r100, r101 + r100.b(this.f264538n.f264504c, r101), r102, r103);
        return;
    }
}
