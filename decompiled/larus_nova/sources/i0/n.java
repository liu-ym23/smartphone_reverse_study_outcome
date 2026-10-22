package i0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class n implements m, j0.a.InterfaceC6374a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f487796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f487798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolystarShape.Type f487799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0.c f487800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0.a<?, PointF> f487801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0.c f487802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j0.c f487803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0.c f487804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j0.c f487805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j0.c f487806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f487807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f487808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f487809n;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f487810a = null;

        static {
            int[] r100 = new int[PolystarShape.Type.values().length];
            f487810a = r100;
            r100[PolystarShape.Type.Star.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f487810a[PolystarShape.Type.Polygon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487809n = false;
        this.f487798c.invalidateSelf();
    }

    @Override // i0.m
    public final Path getPath() {
        if (this.f487809n == true) goto L5;
        this.f487796a.reset();
        int r100 = a.f487810a[this.f487799d.ordinal()];
        double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 != 1) goto L9;
        float r101 = this.f487800e.g().floatValue();
        j0.c r102 = this.f487802g;
        if (r102 == null) goto L28;
        r110 = r102.g().floatValue();
    L28:
        double r103 = Math.toRadians(r110 - 90.0d);
        double r104 = r101;
        float r105 = (float) (6.283185307179586d / r104);
        float r106 = r105 / 2.0f;
        float r107 = r101 - ((int) r101);
        if (r107 == 0.0f) goto L31;
        r103 = r103 + ((double) ((1.0f - r107) * r106));
    L31:
        float r111 = this.f487804i.g().floatValue();
        float r112 = this.f487803h.g().floatValue();
        j0.c r113 = this.f487805j;
        if (r113 == null) goto L34;
        float r114 = r113.g().floatValue() / 100.0f;
    L35:
        j0.c r115 = this.f487806k;
        if (r115 == null) goto L38;
        float r108 = r115.g().floatValue() / 100.0f;
    L39:
        if (r107 == 0.0f) goto L41;
        float r116 = ((r111 - r112) * r107) + r112;
        double r109 = r116;
        float r210 = r116;
        float r117 = (float) (r109 * Math.cos(r103));
        float r118 = (float) (r109 * Math.sin(r103));
        this.f487796a.moveTo(r117, r118);
        double r119 = r103 + ((double) ((r105 * r107) / 2.0f));
        float r120 = r106;
        float r121 = r118;
    L42:
        double r122 = Math.ceil(r104) * 2.0d;
        float r211 = r120;
        boolean r123 = false;
        float r124 = r117;
        double r125 = r119;
        int r126 = 0;
    L43:
        double r127 = r126;
        if (r127 >= r122) goto L87;
        if (r123 == false) goto L47;
        float r212 = r111;
    L49:
        if (r210 != 0.0f) goto L51;
    L53:
        float r128 = r211;
    L55:
        if (r210 != 0.0f) goto L57;
    L59:
        float r129 = r212;
    L60:
        double r130 = r129;
        double r310 = r122;
        float r131 = (float) (Math.cos(r125) * r130);
        float r132 = (float) (r130 * Math.sin(r125));
        if (r114 == 0.0f) goto L63;
    L65:
        float r213 = r114;
        double r133 = (float) (Math.atan2(r121, r124) - 1.5707963267948966d);
        float r134 = (float) Math.cos(r133);
        float r135 = (float) Math.sin(r133);
        float r136 = r128;
        float r137 = r108;
        double r138 = (float) (Math.atan2(r132, r131) - 1.5707963267948966d);
        float r139 = (float) Math.cos(r138);
        float r140 = (float) Math.sin(r138);
        if (r123 == false) goto L68;
        float r141 = r213;
    L69:
        if (r123 == false) goto L71;
        float r142 = r137;
    L72:
        if (r123 == false) goto L74;
        float r311 = r112;
    L75:
        if (r123 == false) goto L77;
        float r312 = r111;
    L78:
        float r313 = (r311 * r141) * 0.47829f;
        float r143 = r134 * r313;
        float r314 = r313 * r135;
        float r315 = (r312 * r142) * 0.47829f;
        float r144 = r139 * r315;
        float r316 = r315 * r140;
        if (r107 == 0.0f) goto L85;
        if (r126 != 0) goto L83;
        r143 = r143 * r107;
        r314 = r314 * r107;
        goto L85
    L83:
        if (r127 != (r310 - 1.0d)) goto L85;
        r144 = r144 * r107;
        r316 = r316 * r107;
    L85:
        this.f487796a.cubicTo(r124 - r143, r121 - r314, r131 + r144, r132 + r316, r131, r132);
        float r145 = r136;
    L86:
        r125 = r125 + ((double) r145);
        r123 = !r123;
        r126 = r126 + 1;
        r124 = r131;
        r121 = r132;
        r108 = r137;
        r114 = r213;
        r112 = r112;
        r105 = r105;
        r122 = r310;
        goto L43
    L77:
        r312 = r112;
        goto L78
    L74:
        r311 = r111;
        goto L75
    L71:
        r142 = r213;
        goto L72
    L68:
        r141 = r137;
        goto L69
    L63:
        if (r108 != 0.0f) goto L65;
        this.f487796a.lineTo(r131, r132);
        r145 = r128;
        r137 = r108;
        r213 = r114;
        goto L86
    L57:
        if (r127 != (r122 - 1.0d)) goto L59;
        r129 = r210;
        goto L60
    L51:
        if (r127 != (r122 - 2.0d)) goto L53;
        r128 = (r105 * r107) / 2.0f;
        goto L55
    L47:
        r212 = r112;
        goto L49
    L87:
        PointF r146 = this.f487801f.g();
        this.f487796a.offset(r146.x, r146.y);
        this.f487796a.close();
    L88:
        this.f487796a.close();
        if (r0.c.a.f535397a == false) goto L93;
        b r147 = this.f487808m;
        if (r147 == null) goto L93;
        r147.a(this.f487796a);
    L94:
        this.f487809n = true;
        return this.f487796a;
    L93:
        u0.f.b(this.f487796a, this.f487807l);
        goto L94
    L41:
        double r148 = r111;
        float r149 = (float) (Math.cos(r103) * r148);
        r121 = (float) (r148 * Math.sin(r103));
        this.f487796a.moveTo(r149, r121);
        r120 = r106;
        r119 = r103 + ((double) r120);
        r117 = r149;
        r210 = 0.0f;
        goto L42
    L38:
        r108 = 0.0f;
        goto L39
    L34:
        r114 = 0.0f;
        goto L35
    L9:
        if (r100 != 2) goto L88;
        int r150 = (int) Math.floor(this.f487800e.g().floatValue());
        j0.c r151 = this.f487802g;
        if (r151 == null) goto L15;
        r110 = r151.g().floatValue();
    L15:
        double r152 = Math.toRadians(r110 - 90.0d);
        double r153 = r150;
        float r154 = this.f487806k.g().floatValue() / 100.0f;
        float r155 = this.f487804i.g().floatValue();
        double r156 = r155;
        float r157 = (float) (Math.cos(r152) * r156);
        float r158 = (float) (Math.sin(r152) * r156);
        this.f487796a.moveTo(r157, r158);
        double r159 = (float) (6.283185307179586d / r153);
        double r160 = r152 + r159;
        double r161 = Math.ceil(r153);
        float r162 = r157;
        int r163 = 0;
    L17:
        if (r163 >= r161) goto L23;
        float r164 = (float) (Math.cos(r160) * r156);
        float r165 = (float) (Math.sin(r160) * r156);
        if (r154 == 0.0f) goto L21;
        double r166 = (float) (Math.atan2(r158, r162) - 1.5707963267948966d);
        float r167 = (float) Math.cos(r166);
        float r168 = (float) Math.sin(r166);
        double r169 = (float) (Math.atan2(r165, r164) - 1.5707963267948966d);
        float r170 = (r155 * r154) * 0.25f;
        this.f487796a.cubicTo(r162 - (r167 * r170), r158 - (r168 * r170), r164 + (((float) Math.cos(r169)) * r170), r165 + (r170 * ((float) Math.sin(r169))), r164, r165);
    L22:
        r160 = r160 + r159;
        r163 = r163 + 1;
        r162 = r164;
        r158 = r165;
        r161 = r161;
        r156 = r156;
        goto L17
    L21:
        this.f487796a.lineTo(r164, r165);
        goto L22
    L23:
        PointF r171 = this.f487801f.g();
        this.f487796a.offset(r171.x, r171.y);
        this.f487796a.close();
        goto L88
    L5:
        return this.f487796a;
    }

    @Override // i0.c
    public final String getName() {
        return this.f487797b;
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) r100).size()) goto L16;
        c r103 = (c) ListProtector.get(r100, r102);
        if ((r103 instanceof s) == false) goto L15;
        s r104 = (s) r103;
        if (r104.getType() != ShapeTrimPath.Type.Simultaneously) goto L15;
        if (r0.c.a.f535397a == false) goto L14;
        b r105 = this.f487808m;
        if (r105 == null) goto L14;
        ((ArrayList) r105.f487737a).add(r104);
        r104.e(this);
    L14:
        this.f487807l = r104;
        r104.e(this);
    L15:
        r102 = r102 + 1;
        goto L4
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        if (r100 != com.airbnb.lottie.k.f24804s) goto L6;
        this.f487800e.k(r101);
        return;
    L6:
        if (r100 != com.airbnb.lottie.k.f24805t) goto L9;
        this.f487802g.k(r101);
        return;
    L9:
        if (r100 != com.airbnb.lottie.k.f24795j) goto L12;
        this.f487801f.k(r101);
        return;
    L12:
        if (r100 != com.airbnb.lottie.k.f24806u) goto L17;
        j0.c r102 = this.f487803h;
        if (r102 == null) goto L17;
        r102.k(r101);
        return;
    L17:
        if (r100 != com.airbnb.lottie.k.f24807v) goto L20;
        this.f487804i.k(r101);
        return;
    L20:
        if (r100 != com.airbnb.lottie.k.f24808w) goto L25;
        j0.c r103 = this.f487805j;
        if (r103 == null) goto L25;
        r103.k(r101);
        return;
    L25:
        if (r100 != com.airbnb.lottie.k.f24809x) goto L34;
        this.f487806k.k(r101);
        return;
    }

    public n(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, PolystarShape r110) {
        this.f487796a = new Path();
        if (r0.c.a.f535397a == false) goto L5;
        this.f487808m = new b();
    L5:
        this.f487798c = r100;
        this.f487797b = r110.f24824a;
        PolystarShape.Type r102 = r110.getType();
        this.f487799d = r102;
        j0.a<?, ?> r103 = r110.f24826c.a();
        this.f487800e = (j0.c) r103;
        j0.a<PointF, PointF> r104 = r110.f24827d.a();
        this.f487801f = r104;
        j0.a<?, ?> r105 = r110.f24828e.a();
        this.f487802g = (j0.c) r105;
        j0.a<?, ?> r106 = r110.f24830g.a();
        this.f487804i = (j0.c) r106;
        j0.a<?, ?> r107 = r110.f24832i.a();
        this.f487806k = (j0.c) r107;
        PolystarShape.Type r108 = PolystarShape.Type.Star;
        if (r102 != r108) goto L8;
        this.f487803h = (j0.c) r110.f24829f.a();
        this.f487805j = (j0.c) r110.f24831h.a();
    L9:
        r101.e(r103);
        r101.e(r104);
        r101.e(r105);
        r101.e(r106);
        r101.e(r107);
        if (r102 != r108) goto L12;
        r101.e(this.f487803h);
        r101.e(this.f487805j);
    L12:
        r103.a(this);
        r104.a(this);
        r105.a(this);
        r106.a(this);
        r107.a(this);
        if (r102 != r108) goto L16;
        this.f487803h.a(this);
        this.f487805j.a(this);
        return;
    L16:
        return;
    L8:
        this.f487803h = null;
        this.f487805j = null;
        goto L9
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        u0.e.d(r100, r101, r102, r103, this);
    }
}
