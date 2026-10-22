package nz6;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.camera.video.AudioStats;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.PolystarShape;
import com.bytedance.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements l, oz6.a.InterfaceC7134a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f521502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f521504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolystarShape.Type f521505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oz6.c f521506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oz6.a<?, PointF> f521507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oz6.c f521508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final oz6.c f521509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final oz6.c f521510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final oz6.c f521511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final oz6.c f521512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f521513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f521514m;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521515a = null;

        static {
            int[] r100 = new int[PolystarShape.Type.values().length];
            f521515a = r100;
            r100[PolystarShape.Type.Star.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f521515a[PolystarShape.Type.Polygon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521514m = false;
        this.f521504c.invalidateSelf();
    }

    @Override // nz6.l
    public final Path getPath() {
        if (this.f521514m == true) goto L5;
        this.f521502a.reset();
        int r100 = a.f521515a[this.f521505d.ordinal()];
        double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 != 1) goto L9;
        float r101 = this.f521506e.e().floatValue();
        oz6.c r102 = this.f521508g;
        if (r102 == null) goto L28;
        r110 = r102.e().floatValue();
    L28:
        double r103 = Math.toRadians(r110 - 90.0d);
        double r104 = r101;
        float r105 = (float) (6.283185307179586d / r104);
        float r106 = r105 / 2.0f;
        float r107 = r101 - ((int) r101);
        if (r107 == 0.0f) goto L31;
        r103 = r103 + ((double) ((1.0f - r107) * r106));
    L31:
        float r111 = this.f521510i.e().floatValue();
        float r112 = this.f521509h.e().floatValue();
        oz6.c r113 = this.f521511j;
        if (r113 == null) goto L34;
        float r114 = r113.e().floatValue() / 100.0f;
    L35:
        oz6.c r115 = this.f521512k;
        if (r115 == null) goto L38;
        float r108 = r115.e().floatValue() / 100.0f;
    L39:
        if (r107 == 0.0f) goto L41;
        float r116 = ((r111 - r112) * r107) + r112;
        double r109 = r116;
        float r210 = r116;
        float r117 = (float) (r109 * Math.cos(r103));
        float r118 = (float) (r109 * Math.sin(r103));
        this.f521502a.moveTo(r117, r118);
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
        this.f521502a.cubicTo(r124 - r143, r121 - r314, r131 + r144, r132 + r316, r131, r132);
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
        this.f521502a.lineTo(r131, r132);
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
        PointF r146 = this.f521507f.e();
        this.f521502a.offset(r146.x, r146.y);
        this.f521502a.close();
    L88:
        this.f521502a.close();
        wz6.h.b(this.f521502a, this.f521513l);
        this.f521514m = true;
        return this.f521502a;
    L41:
        double r147 = r111;
        float r148 = (float) (Math.cos(r103) * r147);
        r121 = (float) (r147 * Math.sin(r103));
        this.f521502a.moveTo(r148, r121);
        r120 = r106;
        r119 = r103 + ((double) r120);
        r117 = r148;
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
        int r149 = (int) Math.floor(this.f521506e.e().floatValue());
        oz6.c r150 = this.f521508g;
        if (r150 == null) goto L15;
        r110 = r150.e().floatValue();
    L15:
        double r151 = Math.toRadians(r110 - 90.0d);
        double r152 = r149;
        float r153 = this.f521512k.e().floatValue() / 100.0f;
        float r154 = this.f521510i.e().floatValue();
        double r155 = r154;
        float r156 = (float) (Math.cos(r151) * r155);
        float r157 = (float) (Math.sin(r151) * r155);
        this.f521502a.moveTo(r156, r157);
        double r158 = (float) (6.283185307179586d / r152);
        double r159 = r151 + r158;
        double r160 = Math.ceil(r152);
        float r161 = r156;
        int r162 = 0;
    L17:
        if (r162 >= r160) goto L23;
        float r163 = (float) (Math.cos(r159) * r155);
        float r164 = (float) (Math.sin(r159) * r155);
        if (r153 == 0.0f) goto L21;
        double r165 = (float) (Math.atan2(r157, r161) - 1.5707963267948966d);
        float r166 = (float) Math.cos(r165);
        float r167 = (float) Math.sin(r165);
        double r168 = (float) (Math.atan2(r164, r163) - 1.5707963267948966d);
        float r169 = (r154 * r153) * 0.25f;
        this.f521502a.cubicTo(r161 - (r166 * r169), r157 - (r167 * r169), r163 + (((float) Math.cos(r168)) * r169), r164 + (r169 * ((float) Math.sin(r168))), r163, r164);
    L22:
        r159 = r159 + r158;
        r162 = r162 + 1;
        r161 = r163;
        r157 = r164;
        r160 = r160;
        r155 = r155;
        goto L17
    L21:
        this.f521502a.lineTo(r163, r164);
        goto L22
    L23:
        PointF r170 = this.f521507f.e();
        this.f521502a.offset(r170.x, r170.y);
        this.f521502a.close();
        goto L88
    L5:
        return this.f521502a;
    }

    @Override // nz6.b
    public final String getName() {
        return this.f521503b;
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) r100).size()) goto L11;
        b r103 = (b) ListProtector.get(r100, r102);
        if ((r103 instanceof r) == false) goto L10;
        r r104 = (r) r103;
        if (r104.getType() != ShapeTrimPath.Type.Simultaneously) goto L10;
        this.f521513l = r104;
        r104.e(this);
    L10:
        r102 = r102 + 1;
        goto L4
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        if (r100 != com.bytedance.lottie.n.f264567o) goto L6;
        this.f521506e.i(r101);
        return;
    L6:
        if (r100 != com.bytedance.lottie.n.f264568p) goto L9;
        this.f521508g.i(r101);
        return;
    L9:
        if (r100 != com.bytedance.lottie.n.f264560h) goto L12;
        this.f521507f.i(r101);
        return;
    L12:
        if (r100 != com.bytedance.lottie.n.f264569q) goto L17;
        oz6.c r102 = this.f521509h;
        if (r102 == null) goto L17;
        r102.i(r101);
        return;
    L17:
        if (r100 != com.bytedance.lottie.n.f264570r) goto L20;
        this.f521510i.i(r101);
        return;
    L20:
        if (r100 != com.bytedance.lottie.n.f264571s) goto L25;
        oz6.c r103 = this.f521511j;
        if (r103 == null) goto L25;
        r103.i(r101);
        return;
    L25:
        if (r100 != com.bytedance.lottie.n.f264572t) goto L34;
        this.f521512k.i(r101);
        return;
    }

    public m(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, PolystarShape r110) {
        this.f521502a = new Path();
        this.f521504c = r100;
        this.f521503b = r110.f264462a;
        PolystarShape.Type r102 = r110.getType();
        this.f521505d = r102;
        oz6.a<?, ?> r103 = r110.f264464c.a();
        this.f521506e = (oz6.c) r103;
        oz6.a<PointF, PointF> r104 = r110.f264465d.a();
        this.f521507f = r104;
        oz6.a<?, ?> r105 = r110.f264466e.a();
        this.f521508g = (oz6.c) r105;
        oz6.a<?, ?> r106 = r110.f264468g.a();
        this.f521510i = (oz6.c) r106;
        oz6.a<?, ?> r107 = r110.f264470i.a();
        this.f521512k = (oz6.c) r107;
        PolystarShape.Type r108 = PolystarShape.Type.Star;
        if (r102 != r108) goto L5;
        this.f521509h = (oz6.c) r110.f264467f.a();
        this.f521511j = (oz6.c) r110.f264469h.a();
    L6:
        r101.e(r103);
        r101.e(r104);
        r101.e(r105);
        r101.e(r106);
        r101.e(r107);
        if (r102 != r108) goto L9;
        r101.e(this.f521509h);
        r101.e(this.f521511j);
    L9:
        r103.a(this);
        r104.a(this);
        r105.a(this);
        r106.a(this);
        r107.a(this);
        if (r102 != r108) goto L13;
        this.f521509h.a(this);
        this.f521511j.a(this);
        return;
    L13:
        return;
    L5:
        this.f521509h = null;
        this.f521511j = null;
        goto L6
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        wz6.f.d(r100, r101, r102, r103, this);
    }
}
