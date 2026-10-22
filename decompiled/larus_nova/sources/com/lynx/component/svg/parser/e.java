package com.lynx.component.svg.parser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.ota.g2.j0;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Canvas f381204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f381205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.lynx.component.svg.d f381206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SVG f381207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f381208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Stack<c> f381209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Stack<SVG.c0> f381210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Stack<Matrix> f381211h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381212a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f381213b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f381214c = null;

        static {
            int[] r100 = new int[SVG.Style.LineJoin.values().length];
            f381214c = r100;
            r100[SVG.Style.LineJoin.Miter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L54:
            f381214c[SVG.Style.LineJoin.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L42:
            f381214c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            int[] r101 = new int[SVG.Style.LineCap.values().length];
            f381213b = r101;
            r101[SVG.Style.LineCap.Butt.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L62:
            f381213b[SVG.Style.LineCap.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L36:
            f381213b[SVG.Style.LineCap.Square.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L12:
            int[] r102 = new int[PreserveAspectRatio.Alignment.values().length];
            f381212a = r102;
            r102[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L40:
            f381212a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            f381212a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L52:
            f381212a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L38:
            f381212a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L50:
            f381212a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L56:
            f381212a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L44:
            f381212a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f381215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f381216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f381217c;

        public final void b() {
            this.f381215a.close();
        }

        public b(SVG.t r110) {
            this.f381215a = new Path();
            if (r110 != null) goto L5;
            return;
        L5:
            int r100 = 0;
            int r101 = 0;
        L7:
            if (r100 >= r110.f381143b) goto L34;
            byte r102 = r110.f381142a[r100];
            if (r102 != 0) goto L11;
            float[] r103 = r110.f381144c;
            int r104 = r101 + 1;
            int r105 = r104 + 1;
            c(r103[r101], r103[r104]);
        L32:
            r101 = r105;
        L33:
            r100 = r100 + 1;
            goto L7
        L11:
            if (r102 != 1) goto L13;
            float[] r106 = r110.f381144c;
            int r107 = r101 + 1;
            float r108 = r106[r101];
            r105 = r107 + 1;
            float r109 = r106[r107];
            this.f381215a.lineTo(r108, r109);
            this.f381216b = r108;
            this.f381217c = r109;
            goto L32
        L13:
            if (r102 != 2) goto L15;
            float[] r111 = r110.f381144c;
            int r112 = r101 + 1;
            float r113 = r111[r101];
            int r114 = r112 + 1;
            float r115 = r111[r112];
            int r116 = r114 + 1;
            float r117 = r111[r114];
            int r118 = r116 + 1;
            float r119 = r111[r116];
            int r120 = r118 + 1;
            float r121 = r111[r118];
            float r122 = r111[r120];
            this.f381215a.cubicTo(r113, r115, r117, r119, r121, r122);
            this.f381216b = r121;
            this.f381217c = r122;
            r101 = r120 + 1;
            goto L33
        L15:
            if (r102 != 3) goto L17;
            float[] r123 = r110.f381144c;
            int r124 = r101 + 1;
            int r125 = r124 + 1;
            int r126 = r125 + 1;
            d(r123[r101], r123[r124], r123[r125], r123[r126]);
            r101 = r126 + 1;
            goto L33
        L17:
            if (r102 != 8) goto L19;
            b();
            goto L33
        L19:
            if ((r102 & 2) == 0) goto L21;
            boolean r127 = true;
        L23:
            if ((r102 & 1) == 0) goto L25;
            boolean r128 = true;
        L26:
            float[] r129 = r110.f381144c;
            int r130 = r101 + 1;
            float r131 = r129[r101];
            int r132 = r130 + 1;
            float r133 = r129[r130];
            int r134 = r132 + 1;
            float r135 = r129[r132];
            int r136 = r134 + 1;
            float r137 = r129[r134];
            a(r131, r133, r135, r127, r128, r137, r129[r136]);
            r101 = r136 + 1;
            goto L33
        L25:
            r128 = false;
            goto L26
        L21:
            r127 = false;
            goto L23
        }

        public final void c(float r100, float r101) {
            this.f381215a.moveTo(r100, r101);
            this.f381216b = r100;
            this.f381217c = r101;
        }

        public final void d(float r100, float r101, float r102, float r103) {
            this.f381215a.quadTo(r100, r101, r102, r103);
            this.f381216b = r102;
            this.f381217c = r103;
        }

        public final void a(float r310, float r311, float r312, boolean r313, boolean r314, float r410, float r411) {
            float r100 = r411;
            float r101 = this.f381216b;
            float r102 = this.f381217c;
            if (r101 != r410) goto L8;
            if (r102 != r100) goto L8;
            b r103 = this;
            float r104 = r410;
        L56:
            r103.f381216b = r104;
            r103.f381217c = r100;
            return;
        L8:
            if (r310 != 0.0f) goto L10;
        L55:
            r103 = this;
            r104 = r410;
            r103.f381215a.lineTo(r104, r100);
            r103.f381216b = r104;
            r103.f381217c = r100;
            goto L56
        L10:
            if (r311 == 0.0f) goto L55;
            float r105 = Math.abs(r310);
            float r106 = Math.abs(r311);
            double r107 = Math.toRadians(((double) r312) % 360.0d);
            double r110 = Math.cos(r107);
            double r108 = Math.sin(r107);
            double r111 = ((double) (r101 - r410)) / 2.0d;
            double r109 = ((double) (r102 - r100)) / 2.0d;
            double r112 = (r110 * r111) + (r108 * r109);
            double r113 = ((-r108) * r111) + (r109 * r110);
            double r114 = r105 * r105;
            double r115 = r106 * r106;
            double r116 = r112 * r112;
            double r210 = r113 * r113;
            double r211 = (r116 / r114) + (r210 / r115);
            if (r211 <= 0.99999d) goto L16;
            double r117 = Math.sqrt(r211) * 1.00001d;
            r105 = (float) (((double) r105) * r117);
            r106 = (float) (r117 * ((double) r106));
            r114 = r105 * r105;
            r115 = r106 * r106;
        L16:
            if (r313 != r314) goto L18;
            double r118 = -1.0d;
        L19:
            double r212 = r114 * r115;
            double r119 = r114 * r210;
            double r120 = r115 * r116;
            double r213 = ((r212 - r119) - r120) / (r119 + r120);
            if (r213 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
            r213 = 0.0d;
        L22:
            double r121 = r118 * Math.sqrt(r213);
            double r122 = r105;
            double r123 = r106;
            double r124 = ((r122 * r113) / r123) * r121;
            double r125 = r121 * (-((r123 * r112) / r122));
            float r214 = r105;
            float r215 = r106;
            r100 = r411;
            double r126 = (((double) (r101 + r410)) / 2.0d) + ((r110 * r124) - (r108 * r125));
            double r127 = (((double) (r102 + r100)) / 2.0d) + ((r108 * r124) + (r110 * r125));
            double r128 = (r112 - r124) / r122;
            double r129 = (r113 - r125) / r123;
            double r130 = ((-r112) - r124) / r122;
            double r131 = ((-r113) - r125) / r123;
            double r132 = (r128 * r128) + (r129 * r129);
            double r133 = Math.sqrt(r132);
            if (r129 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
            double r134 = -1.0d;
        L26:
            double r135 = r134 * Math.acos(r128 / r133);
            double r136 = Math.sqrt(r132 * ((r130 * r130) + (r131 * r131)));
            double r137 = (r128 * r130) + (r129 * r131);
            if (((r128 * r131) - (r129 * r130)) >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
            double r138 = -1.0d;
        L30:
            double r139 = r137 / r136;
            if (r139 >= (-1.0d)) goto L34;
            double r140 = 3.141592653589793d;
        L37:
            double r141 = r138 * r140;
            if (r141 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L41;
            this.f381215a.lineTo(r410, r100);
            this.f381216b = r410;
            this.f381217c = r100;
            r103 = this;
            r104 = r410;
            goto L56
        L41:
            if (r314 == true) goto L44;
            if (r141 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L44;
            r141 = r141 - 6.283185307179586d;
        L48:
            double r142 = r141 % 6.283185307179586d;
            double r143 = r135 % 6.283185307179586d;
            int r144 = (int) Math.ceil((Math.abs(r142) * 2.0d) / 3.141592653589793d);
            double r145 = r142 / ((double) r144);
            double r146 = r145 / 2.0d;
            double r147 = (Math.sin(r146) * 1.3333333333333333d) / (Math.cos(r146) + 1.0d);
            int r148 = r144 * 6;
            float[] r149 = new float[r148];
            int r150 = 0;
            int r151 = 0;
        L49:
            if (r150 >= r144) goto L51;
            double r315 = r147;
            double r152 = (((double) r150) * r145) + r143;
            double r153 = Math.cos(r152);
            double r216 = Math.sin(r152);
            int r154 = r151 + 1;
            r149[r151] = (float) (r153 - (r315 * r216));
            int r155 = r154 + 1;
            int r156 = r144;
            r149[r154] = (float) (r216 + (r153 * r315));
            double r157 = r152 + r145;
            double r158 = Math.cos(r157);
            double r159 = Math.sin(r157);
            int r160 = r155 + 1;
            double r217 = r145;
            r149[r155] = (float) ((r315 * r159) + r158);
            int r161 = r160 + 1;
            r149[r160] = (float) (r159 - (r315 * r158));
            int r162 = r161 + 1;
            r149[r161] = (float) r158;
            r151 = r162 + 1;
            r149[r162] = (float) r159;
            r150 = r150 + 1;
            r148 = r148;
            r144 = r156;
            r145 = r217;
            r147 = r315;
            goto L49
        L51:
            int r316 = r148;
            Matrix r163 = new Matrix();
            r163.postScale(r214, r215);
            r163.postRotate(r312);
            r163.postTranslate((float) r126, (float) r127);
            r163.mapPoints(r149);
            r104 = r410;
            r149[r316 - 2] = r104;
            r149[r316 - 1] = r100;
            int r164 = 0;
        L52:
            if (r164 >= r316) goto L54;
            float r165 = r149[r164];
            float r166 = r149[r164 + 1];
            float r167 = r149[r164 + 2];
            float r168 = r149[r164 + 3];
            float r169 = r149[r164 + 4];
            float r170 = r149[r164 + 5];
            this.f381215a.cubicTo(r165, r166, r167, r168, r169, r170);
            this.f381216b = r169;
            this.f381217c = r170;
            r164 = r164 + 6;
            goto L52
        L54:
            r103 = this;
        L44:
            if (r314 == false) goto L48;
            if (r141 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L48;
            r141 = r141 + 6.283185307179586d;
            goto L48
        L34:
            if (r139 <= 1.0d) goto L36;
            r140 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L37
        L36:
            r140 = Math.acos(r139);
            goto L37
        L29:
            r138 = 1.0d;
            goto L30
        L25:
            r134 = 1.0d;
            goto L26
        L18:
            r118 = 1.0d;
            goto L19
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SVG.Style f381218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f381219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f381220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f381221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f381222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SVG.b f381223f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SVG.b f381224g;

        public c() {
            Paint r100 = new Paint();
            this.f381221d = r100;
            r100.setFlags(193);
            r100.setHinting(0);
            r100.setStyle(Paint.Style.FILL);
            r100.setTypeface(Typeface.DEFAULT);
            Paint r101 = new Paint();
            this.f381222e = r101;
            r101.setFlags(193);
            r101.setHinting(0);
            r101.setStyle(Paint.Style.STROKE);
            r101.setTypeface(Typeface.DEFAULT);
            this.f381218a = SVG.Style.a();
        }

        public c(c r100) {
            this.f381219b = r100.f381219b;
            this.f381220c = r100.f381220c;
            this.f381221d = new Paint(r100.f381221d);
            this.f381222e = new Paint(r100.f381222e);
            SVG.b r101 = r100.f381223f;
            if (r101 == null) goto L5;
            this.f381223f = new SVG.b(r101);
        L5:
            SVG.b r102 = r100.f381224g;
            if (r102 == null) goto L12;
            this.f381224g = new SVG.b(r102);
        L12:
            this.f381218a = (SVG.Style) r100.f381218a.clone();     // Catch: CloneNotSupportedException -> L10
            return;
        L10:
            this.f381218a = SVG.Style.a();
        }
    }

    public final void G() {
        this.f381204a.restore();
        this.f381208e = this.f381209f.pop();
    }

    public final void H() {
        this.f381204a.save();
        this.f381209f.push(this.f381208e);
        this.f381208e = new c(this.f381208e);
    }

    public final void L() {
        SVG.Style r100 = this.f381208e.f381218a;
        SVG.h0 r101 = r100.f381055y;
        if ((r101 instanceof SVG.f) == false) goto L6;
        int r102 = ((SVG.f) r101).f381096a;
    L8:
        Float r103 = r100.f381056z;
        if (r103 == null) goto L11;
        r102 = f(r102, r103.floatValue());
    L11:
        this.f381204a.drawColor(r102);
        return;
    L6:
        if ((r101 instanceof SVG.g) == false) goto L13;
        r102 = r100.f381044n.f381096a;
        goto L8
    }

    public final boolean M() {
        Boolean r100 = this.f381208e.f381218a.f381048r;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.booleanValue();
    }

    public final boolean i() {
        Boolean r100 = this.f381208e.f381218a.f381047q;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.booleanValue();
    }

    public final Path.FillType q() {
        SVG.Style.FillRule r100 = this.f381208e.f381218a.f381052v;
        if (r100 == null) goto L9;
        if (r100 != SVG.Style.FillRule.EvenOdd) goto L9;
        return Path.FillType.EVEN_ODD;
    L9:
        return Path.FillType.WINDING;
    }

    public final boolean y() {
        int r100 = 0;
        if (this.f381208e.f381218a.f381043m.floatValue() >= 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return false;
    L8:
        Canvas r102 = this.f381204a;
        int r103 = (int) (this.f381208e.f381218a.f381043m.floatValue() * 256.0f);
        if (r103 < 0) goto L15;
        r100 = 255;
        if (r103 > 255) goto L15;
        r100 = r103;
    L15:
        r102.saveLayerAlpha(null, r100, 31);
        this.f381209f.push(this.f381208e);
        this.f381208e = new c(this.f381208e);
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public static SVG.b b(Path r100) {
        RectF r101 = new RectF();
        r100.computeBounds(r101, true);
        return new SVG.b(r101.left, r101.top, r101.width(), r101.height());
    }

    public static Path u(SVG.v r100) {
        Path r101 = new Path();
        float[] r102 = r100.f381154i;
        r101.moveTo(r102[0], r102[1]);
        int r103 = 2;
    L3:
        float[] r104 = r100.f381154i;
        if (r103 >= r104.length) goto L7;
        r101.lineTo(r104[r103], r104[r103 + 1]);
        r103 = r103 + 2;
        goto L3
    L7:
        if ((r100 instanceof SVG.w) == false) goto L10;
        r101.close();
    L10:
        if (r100.f381088g != null) goto L12;
        r100.f381088g = b(r101);
    L12:
        return r101;
    }

    public final void A(SVG.g0 r110) {
        if ((r110 instanceof SVG.q) == false) goto L5;
        return;
    L5:
        H();
        if ((r110 instanceof SVG.e0) == false) goto L12;
        Boolean r100 = ((SVG.e0) r110).f381091d;
        if (r100 == null) goto L12;
        c r101 = this.f381208e;
        r100.booleanValue();
        r101.getClass();
    L12:
        if ((r110 instanceof SVG.a0) == false) goto L14;
        SVG.a0 r111 = (SVG.a0) r110;
        z(r111, w(r111.f381072k, r111.f381073l, r111.f381074m, r111.f381075n), r111.f381120j, r111.f381108i);
    L310:
        G();
        return;
    L14:
        float r102 = 0.0f;
        Bitmap r103 = null;
        if ((r110 instanceof SVG.l0) == false) goto L50;
        SVG.l0 r112 = (SVG.l0) r110;
        g("Use render", new Object[0]);
        SVG.o r104 = r112.f381125m;
        if (r104 != null) goto L19;
    L20:
        SVG.o r105 = r112.f381126n;
        if (r105 != null) goto L23;
    L25:
        K(this.f381208e, r112);
        if (i() == false) goto L310;
        SVG.g0 r106 = r112.f381102a.f(r112.f381122j);
        if (r106 != null) goto L31;
        l("Use reference '%s' not found", new Object[]{r112.f381122j});
        goto L310
    L31:
        Matrix r107 = r112.f381121i;
        if (r107 == null) goto L34;
        this.f381204a.concat(r107);
    L34:
        SVG.o r108 = r112.f381123k;
        if (r108 == null) goto L37;
        float r109 = r108.d(this);
    L38:
        SVG.o r113 = r112.f381124l;
        if (r113 == null) goto L41;
        r102 = r113.e(this);
    L41:
        this.f381204a.translate(r109, r102);
        d(r112, r112.f381088g);
        boolean r114 = y();
        this.f381210g.push(r112);
        this.f381211h.push(this.f381204a.getMatrix());
        if ((r106 instanceof SVG.a0) == false) goto L44;
        SVG.a0 r115 = (SVG.a0) r106;
        SVG.b r116 = w(null, null, r112.f381125m, r112.f381126n);
        H();
        z(r115, r116, r115.f381120j, r115.f381108i);
        G();
    L45:
        this.f381210g.pop();
        this.f381211h.pop();
        if (r114 == false) goto L48;
        G();
    L48:
        I(r112);
        goto L310
    L44:
        A(r106);
        goto L45
    L37:
        r109 = 0.0f;
        goto L38
    L23:
        if (r105.g() == false) goto L25;
    L19:
        if (r104.g() == true) goto L310;
    L50:
        if ((r110 instanceof SVG.l) == false) goto L62;
        SVG.l r117 = (SVG.l) r110;
        g(r117.c() + " render", new Object[0]);
        K(this.f381208e, r117);
        if (i() == false) goto L310;
        Matrix r118 = r117.f381121i;
        if (r118 == null) goto L57;
        this.f381204a.concat(r118);
    L57:
        d(r117, r117.f381088g);
        boolean r119 = y();
        B(r117);
        if (r119 == false) goto L60;
        G();
    L60:
        I(r117);
        goto L310
    L62:
        if ((r110 instanceof SVG.n) == false) goto L99;
        SVG.n r120 = (SVG.n) r110;
        g("Image render", new Object[0]);
        SVG.o r121 = r120.f381130m;
        if (r121 == null) goto L310;
        if (r121.g() == true) goto L310;
        SVG.o r122 = r120.f381131n;
        if (r122 == null) goto L310;
        if (r122.g() == true) goto L310;
        String r123 = r120.f381127j;
        if (r123 == null) goto L310;
        PreserveAspectRatio r124 = r120.f381108i;
        if (r124 != null) goto L80;
        r124 = PreserveAspectRatio.f381022d;
    L80:
        if (r123.startsWith(fyb.a.KEY_DATA) == true) goto L83;
    L95:
        if (r103 != null) goto L97;
        this.f381206c.b(r120.f381127j, new d(this, r120, r124));
        goto L310
    L97:
        D(r120, r124, r103);
        goto L310
    L83:
        if (r123.length() < 14) goto L95;
        int r125 = r123.indexOf(44);
        if (r125 < 12) goto L95;
        if (";base64".equals(r123.substring(r125 - 7, r125)) == false) goto L95;
        byte[] r126 = Base64.decode(r123.substring(r125 + 1), 0);     // Catch: Exception -> L94
        r103 = BitmapFactory.decodeByteArray(r126, 0, r126.length);     // Catch: Exception -> L94
        goto L95
    L99:
        if ((r110 instanceof SVG.s) == false) goto L135;
        SVG.s r127 = (SVG.s) r110;
        g("Path render", new Object[0]);
        if (r127.f381141i == null) goto L310;
        K(this.f381208e, r127);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        c r128 = this.f381208e;
        if (r128.f381220c == false) goto L112;
    L114:
        Matrix r129 = r127.f381119h;
        if (r129 == null) goto L117;
        this.f381204a.concat(r129);
    L117:
        Path r130 = new b(r127.f381141i).f381215a;
        if (r127.f381088g != null) goto L120;
        r127.f381088g = b(r130);
    L120:
        I(r127);
        e(r127);
        d(r127, r127.f381088g);
        boolean r131 = y();
        c r132 = this.f381208e;
        if (r132.f381219b == false) goto L130;
        SVG.Style.FillRule r133 = r132.f381218a.f381033c;
        if (r133 != null) goto L125;
    L127:
        Path.FillType r134 = Path.FillType.WINDING;
    L128:
        r130.setFillType(r134);
        j(r127, r130);
        goto L130
    L125:
        if (r133 != SVG.Style.FillRule.EvenOdd) goto L127;
        r134 = Path.FillType.EVEN_ODD;
    L130:
        if (this.f381208e.f381220c == false) goto L132;
        k(r130);
    L132:
        if (r131 == false) goto L310;
        G();
        goto L310
    L112:
        if (r128.f381219b == true) goto L114;
    L135:
        if ((r110 instanceof SVG.x) == false) goto L163;
        SVG.x r135 = (SVG.x) r110;
        g("Rect render", new Object[0]);
        SVG.o r136 = r135.f381157k;
        if (r136 == null) goto L310;
        if (r135.f381158l == null) goto L310;
        if (r136.g() == true) goto L310;
        if (r135.f381158l.g() == true) goto L310;
        K(this.f381208e, r135);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        Matrix r137 = r135.f381119h;
        if (r137 == null) goto L154;
        this.f381204a.concat(r137);
    L154:
        Path r138 = v(r135);
        I(r135);
        e(r135);
        d(r135, r135.f381088g);
        boolean r139 = y();
        if (this.f381208e.f381219b == false) goto L158;
        j(r135, r138);
    L158:
        if (this.f381208e.f381220c == false) goto L160;
        k(r138);
    L160:
        if (r139 == false) goto L310;
        G();
        goto L310
    L163:
        if ((r110 instanceof SVG.d) == false) goto L187;
        SVG.d r140 = (SVG.d) r110;
        g("Circle render", new Object[0]);
        SVG.o r141 = r140.f381087k;
        if (r141 == null) goto L310;
        if (r141.g() == true) goto L310;
        K(this.f381208e, r140);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        Matrix r142 = r140.f381119h;
        if (r142 == null) goto L178;
        this.f381204a.concat(r142);
    L178:
        Path r143 = s(r140);
        I(r140);
        e(r140);
        d(r140, r140.f381088g);
        boolean r144 = y();
        if (this.f381208e.f381219b == false) goto L182;
        j(r140, r143);
    L182:
        if (this.f381208e.f381220c == false) goto L184;
        k(r143);
    L184:
        if (r144 == false) goto L310;
        G();
        goto L310
    L187:
        if ((r110 instanceof SVG.i) == false) goto L215;
        SVG.i r145 = (SVG.i) r110;
        g("Ellipse render", new Object[0]);
        SVG.o r146 = r145.f381106k;
        if (r146 == null) goto L310;
        if (r145.f381107l == null) goto L310;
        if (r146.g() == true) goto L310;
        if (r145.f381107l.g() == true) goto L310;
        K(this.f381208e, r145);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        Matrix r147 = r145.f381119h;
        if (r147 == null) goto L206;
        this.f381204a.concat(r147);
    L206:
        Path r148 = t(r145);
        I(r145);
        e(r145);
        d(r145, r145.f381088g);
        boolean r149 = y();
        if (this.f381208e.f381219b == false) goto L210;
        j(r145, r148);
    L210:
        if (this.f381208e.f381220c == false) goto L212;
        k(r148);
    L212:
        if (r149 == false) goto L310;
        G();
        goto L310
    L215:
        if ((r110 instanceof SVG.p) == false) goto L251;
        SVG.p r150 = (SVG.p) r110;
        g("Line render", new Object[0]);
        K(this.f381208e, r150);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        if (this.f381208e.f381220c == false) goto L310;
        Matrix r151 = r150.f381119h;
        if (r151 == null) goto L228;
        this.f381204a.concat(r151);
    L228:
        SVG.o r152 = r150.f381135i;
        if (r152 != null) goto L231;
        float r153 = 0.0f;
    L232:
        SVG.o r154 = r150.f381136j;
        if (r154 != null) goto L235;
        float r155 = 0.0f;
    L236:
        SVG.o r156 = r150.f381137k;
        if (r156 != null) goto L239;
        float r157 = 0.0f;
    L240:
        SVG.o r158 = r150.f381138l;
        if (r158 == null) goto L245;
        r102 = r158.e(this);
    L245:
        if (r150.f381088g != null) goto L247;
        r150.f381088g = new SVG.b(Math.min(r153, r157), Math.min(r155, r102), Math.abs(r157 - r153), Math.abs(r102 - r155));
    L247:
        Path r159 = new Path();
        r159.moveTo(r153, r155);
        r159.lineTo(r157, r102);
        I(r150);
        e(r150);
        d(r150, r150.f381088g);
        boolean r160 = y();
        k(r159);
        if (r160 == false) goto L310;
        G();
        goto L310
    L239:
        r157 = r156.d(this);
        goto L240
    L235:
        r155 = r154.e(this);
        goto L236
    L231:
        r153 = r152.d(this);
        goto L232
    L251:
        if ((r110 instanceof SVG.w) == false) goto L278;
        SVG.w r161 = (SVG.w) r110;
        g("Polygon render", new Object[0]);
        K(this.f381208e, r161);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        c r162 = this.f381208e;
        if (r162.f381220c == false) goto L261;
    L263:
        Matrix r163 = r161.f381119h;
        if (r163 == null) goto L267;
        this.f381204a.concat(r163);
    L267:
        if (r161.f381154i.length < 2) goto L310;
        Path r164 = u(r161);
        I(r161);
        e(r161);
        d(r161, r161.f381088g);
        boolean r165 = y();
        if (this.f381208e.f381219b == false) goto L273;
        j(r161, r164);
    L273:
        if (this.f381208e.f381220c == false) goto L275;
        k(r164);
    L275:
        if (r165 == false) goto L310;
        G();
        goto L310
    L261:
        if (r162.f381219b == true) goto L263;
    L278:
        if ((r110 instanceof SVG.v) == false) goto L310;
        SVG.v r166 = (SVG.v) r110;
        g("PolyLine render", new Object[0]);
        K(this.f381208e, r166);
        if (i() == false) goto L310;
        if (M() == false) goto L310;
        c r167 = this.f381208e;
        if (r167.f381220c == false) goto L288;
    L290:
        Matrix r168 = r166.f381119h;
        if (r168 == null) goto L294;
        this.f381204a.concat(r168);
    L294:
        if (r166.f381154i.length < 2) goto L310;
        Path r169 = u(r166);
        I(r166);
        SVG.Style.FillRule r170 = this.f381208e.f381218a.f381033c;
        if (r170 != null) goto L299;
    L301:
        Path.FillType r171 = Path.FillType.WINDING;
    L302:
        r169.setFillType(r171);
        e(r166);
        d(r166, r166.f381088g);
        boolean r172 = y();
        if (this.f381208e.f381219b == false) goto L306;
        j(r166, r169);
    L306:
        if (this.f381208e.f381220c == false) goto L308;
        k(r169);
    L308:
        if (r172 == false) goto L310;
        G();
        goto L310
    L299:
        if (r170 != SVG.Style.FillRule.EvenOdd) goto L301;
        r171 = Path.FillType.EVEN_ODD;
        goto L302
    L288:
        if (r167.f381219b == true) goto L290;
        goto L290
    }

    public final void B(SVG.c0 r100) {
        this.f381210g.push(r100);
        this.f381211h.push(this.f381204a.getMatrix());
        Iterator<SVG.g0> r101 = r100.getChildren().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        A(r101.next());
        goto L4
    L6:
        this.f381210g.pop();
        this.f381211h.pop();
    }

    public final void I(SVG.d0 r110) {
        if (r110.f381103b != null) goto L6;
        return;
    L6:
        if (r110.f381088g != null) goto L8;
        return;
    L8:
        Matrix r100 = new Matrix();
        if (this.f381211h.peek().invert(r100) == false) goto L44;
        SVG.b r111 = r110.f381088g;
        float r101 = r111.f381076a;
        float r102 = r111.f381077b;
        float r103 = r111.f381078c + r101;
        int r104 = 2;
        float r105 = r102 + r111.f381079d;
        float[] r106 = {r101, r102, r103, r102, r103, r105, r101, r105};
        r100.preConcat(this.f381204a.getMatrix());
        r100.mapPoints(r106);
        float r107 = r106[0];
        float r108 = r106[1];
        RectF r109 = new RectF(r107, r108, r107, r108);
    L11:
        if (r104 > 6) goto L25;
        float r112 = r106[r104];
        if (r112 >= r109.left) goto L16;
        r109.left = r112;
    L16:
        if (r112 <= r109.right) goto L18;
        r109.right = r112;
    L18:
        float r113 = r106[r104 + 1];
        if (r113 >= r109.top) goto L22;
        r109.top = r113;
    L22:
        if (r113 <= r109.bottom) goto L24;
        r109.bottom = r113;
    L24:
        r104 = r104 + 2;
        goto L11
    L25:
        SVG.d0 r114 = (SVG.d0) this.f381210g.peek();
        SVG.b r115 = r114.f381088g;
        if (r115 != null) goto L28;
        float r116 = r109.left;
        float r117 = r109.top;
        r114.f381088g = new SVG.b(r116, r117, r109.right - r116, r109.bottom - r117);
        return;
    L28:
        float r118 = r109.left;
        float r119 = r109.top;
        float r120 = r109.right - r118;
        float r121 = r109.bottom - r119;
        if (r118 >= r115.f381076a) goto L32;
        r115.f381076a = r118;
    L32:
        if (r119 >= r115.f381077b) goto L34;
        r115.f381077b = r119;
    L34:
        float r122 = r118 + r120;
        float r123 = r115.f381076a;
        if (r122 <= (r115.f381078c + r123)) goto L37;
        r115.f381078c = r122 - r123;
    L37:
        float r124 = r119 + r121;
        float r125 = r115.f381077b;
        if (r124 <= (r115.f381079d + r125)) goto L46;
        r115.f381079d = r124 - r125;
        return;
    L46:
        return;
    }

    public final void e(SVG.d0 r100) {
        SVG.h0 r101 = this.f381208e.f381218a.f381032b;
        if ((r101 instanceof SVG.r) == false) goto L5;
        h(true, r100.f381088g, (SVG.r) r101);
    L5:
        SVG.h0 r102 = this.f381208e.f381218a.f381035e;
        if ((r102 instanceof SVG.r) == false) goto L9;
        h(false, r100.f381088g, (SVG.r) r102);
        return;
    }

    public final void k(Path r100) {
        c r101 = this.f381208e;
        if (r101.f381218a.A != SVG.Style.VectorEffect.NonScalingStroke) goto L10;
        Matrix r102 = this.f381204a.getMatrix();
        Path r103 = new Path();
        r100.transform(r102, r103);
        this.f381204a.setMatrix(new Matrix());
        Shader r104 = this.f381208e.f381222e.getShader();
        Matrix r105 = new Matrix();
        if (r104 == null) goto L7;
        r104.getLocalMatrix(r105);
        Matrix r106 = new Matrix(r105);
        r106.postConcat(r102);
        r104.setLocalMatrix(r106);
    L7:
        this.f381204a.drawPath(r103, this.f381208e.f381222e);
        this.f381204a.setMatrix(r102);
        if (r104 == null) goto L12;
        r104.setLocalMatrix(r105);
        return;
    L12:
        return;
    L10:
        this.f381204a.drawPath(r100, r101.f381222e);
    }

    public final Path s(SVG.d r210) {
        SVG.o r100 = r210.f381085i;
        float r101 = 0.0f;
        if (r100 == null) goto L5;
        float r102 = r100.d(this);
    L6:
        SVG.o r103 = r210.f381086j;
        if (r103 == null) goto L9;
        r101 = r103.e(this);
    L9:
        float r104 = r210.f381087k.b(this);
        float r110 = r102 - r104;
        float r111 = r101 - r104;
        float r112 = r102 + r104;
        float r113 = r101 + r104;
        if (r210.f381088g != null) goto L12;
        float r105 = 2.0f * r104;
        r210.f381088g = new SVG.b(r110, r111, r105, r105);
    L12:
        float r106 = 0.5522848f * r104;
        Path r114 = new Path();
        r114.moveTo(r112, r101);
        float r115 = r101 + r106;
        float r116 = r102 + r106;
        r114.cubicTo(r112, r115, r116, r113, r102, r113);
        float r117 = r102 - r106;
        r114.cubicTo(r117, r113, r110, r115, r110, r101);
        float r107 = r101 - r106;
        r114.cubicTo(r110, r107, r117, r111, r102, r111);
        r114.cubicTo(r116, r111, r112, r107, r112, r101);
        r114.close();
        return r114;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final Path t(SVG.i r210) {
        SVG.o r100 = r210.f381104i;
        float r101 = 0.0f;
        if (r100 == null) goto L5;
        float r102 = r100.d(this);
    L6:
        SVG.o r103 = r210.f381105j;
        if (r103 == null) goto L9;
        r101 = r103.e(this);
    L9:
        float r104 = r210.f381106k.d(this);
        float r105 = r210.f381107l.e(this);
        float r110 = r102 - r104;
        float r111 = r101 - r105;
        float r112 = r102 + r104;
        float r113 = r101 + r105;
        if (r210.f381088g != null) goto L12;
        r210.f381088g = new SVG.b(r110, r111, r104 * 2.0f, 2.0f * r105);
    L12:
        float r114 = r104 * 0.5522848f;
        float r106 = 0.5522848f * r105;
        Path r115 = new Path();
        r115.moveTo(r102, r111);
        float r116 = r102 + r114;
        float r117 = r101 - r106;
        r115.cubicTo(r116, r111, r112, r117, r112, r101);
        float r107 = r106 + r101;
        r115.cubicTo(r112, r107, r116, r113, r102, r113);
        float r118 = r102 - r114;
        r115.cubicTo(r118, r113, r110, r107, r110, r101);
        r115.cubicTo(r110, r117, r118, r111, r102, r111);
        r115.close();
        return r115;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final Path v(SVG.x r210) {
        SVG.o r100 = r210.f381159m;
        if (r100 == null) goto L5;
    L7:
        if (r100 != null) goto L11;
        float r101 = r210.f381160n.e(this);
    L9:
        float r102 = r101;
    L14:
        float r103 = Math.min(r101, r210.f381157k.d(this) / 2.0f);
        float r104 = Math.min(r102, r210.f381158l.e(this) / 2.0f);
        SVG.o r105 = r210.f381155i;
        if (r105 == null) goto L17;
        float r106 = r105.d(this);
    L18:
        SVG.o r107 = r210.f381156j;
        if (r107 == null) goto L21;
        float r110 = r107.e(this);
    L22:
        float r108 = r210.f381157k.d(this);
        float r109 = r210.f381158l.e(this);
        if (r210.f381088g != null) goto L25;
        r210.f381088g = new SVG.b(r106, r110, r108, r109);
    L25:
        float r111 = r106 + r108;
        float r112 = r110 + r109;
        Path r113 = new Path();
        if (r103 != 0.0f) goto L28;
    L31:
        float r114 = r106;
        float r115 = r110;
        r113.addRect(r114, r115, r111, r112, Path.Direction.CW);
        return r113;
    L28:
        if (r104 == 0.0f) goto L31;
        float r116 = r103 * 0.5522848f;
        float r117 = 0.5522848f * r104;
        float r118 = r110 + r104;
        r113.moveTo(r106, r118);
        float r119 = r118 - r117;
        float r120 = r106 + r103;
        float r211 = r120 - r116;
        r113.cubicTo(r106, r119, r211, r110, r120, r110);
        float r121 = r111 - r103;
        r113.lineTo(r121, r110);
        float r122 = r121 + r116;
        r113.cubicTo(r122, r110, r111, r119, r111, r118);
        float r123 = r112 - r104;
        r113.lineTo(r111, r123);
        float r124 = r123 + r117;
        r113.cubicTo(r111, r124, r122, r112, r121, r112);
        r113.lineTo(r120, r112);
        r113.cubicTo(r211, r112, r106, r124, r106, r123);
        r113.lineTo(r106, r118);
        r113.close();
        return r113;
    L21:
        r110 = 0.0f;
        goto L22
    L17:
        r106 = 0.0f;
        goto L18
    L11:
        if (r210.f381160n != null) goto L13;
        r101 = r100.d(this);
        goto L9
    L13:
        r101 = r100.d(this);
        r102 = r210.f381160n.e(this);
        goto L14
    L5:
        if (r210.f381160n != null) goto L7;
        r101 = 0.0f;
        r102 = 0.0f;
        goto L14
    }

    public static int f(int r100, float r101) {
        int r102 = 255;
        int r103 = Math.round(((r100 >> 24) & 255) * r101);
        if (r103 >= 0) goto L5;
        r102 = 0;
    L9:
        return (r100 & 16777215) | (r102 << 24);
    L5:
        if (r103 > 255) goto L9;
        r102 = r103;
        goto L9
    }

    public static void g(String r100, Object... r101) {
        LLog.d("SVGAndroidRenderer", String.format(r100, r101));
    }

    public static void l(String r100, Object... r101) {
        LLog.e("SVGAndroidRenderer", String.format(r100, r101));
    }

    public static void m(SVG.j r100, String r101) {
        SVG.e0 r102 = r100.f381102a.f(r101);
        if (r102 != null) goto L7;
        LLog.w("SVGAndroidRenderer", String.format("Gradient reference '%s' not found", new Object[]{r101}));
        return;
    L7:
        if ((r102 instanceof SVG.j) == true) goto L10;
        l("Gradient href attributes must point to other gradient elements", new Object[0]);
        return;
    L10:
        if (r102 != r100) goto L13;
        l("Circular reference in gradient href attribute '%s'", new Object[]{r101});
        return;
    L13:
        SVG.j r103 = (SVG.j) r102;
        if (r100.f381110h != null) goto L17;
        r100.f381110h = r103.f381110h;
    L17:
        if (r100.f381111i != null) goto L20;
        r100.f381111i = r103.f381111i;
    L20:
        if (r100.f381112j != null) goto L23;
        r100.f381112j = r103.f381112j;
    L23:
        if (r100.f381109g.isEmpty() == false) goto L46;
        r100.f381109g = r103.f381109g;
    L46:
        if ((r100 instanceof SVG.f0) == false) goto L39;
        SVG.f0 r104 = (SVG.f0) r100;     // Catch: ClassCastException -> L41
        SVG.f0 r105 = (SVG.f0) r102;     // Catch: ClassCastException -> L41
        if (r104.f381097l != null) goto L31;
        r104.f381097l = r105.f381097l;     // Catch: ClassCastException -> L41
    L31:
        if (r104.f381098m != null) goto L34;
        r104.f381098m = r105.f381098m;     // Catch: ClassCastException -> L41
    L34:
        if (r104.f381099n != null) goto L37;
        r104.f381099n = r105.f381099n;     // Catch: ClassCastException -> L41
    L37:
        if (r104.f381100o != null) goto L42;
        r104.f381100o = r105.f381100o;     // Catch: ClassCastException -> L41
        goto L42
    L39:
        n((SVG.j0) r100, (SVG.j0) r102);     // Catch: ClassCastException -> L41
    L42:
        String r106 = r103.f381113k;
        if (r106 == null) goto L47;
        m(r100, r106);
        return;
    }

    public static void n(SVG.j0 r100, SVG.j0 r101) {
        if (r100.f381114l != null) goto L6;
        r100.f381114l = r101.f381114l;
    L6:
        if (r100.f381115m != null) goto L9;
        r100.f381115m = r101.f381115m;
    L9:
        if (r100.f381116n != null) goto L12;
        r100.f381116n = r101.f381116n;
    L12:
        if (r100.f381117o != null) goto L15;
        r100.f381117o = r101.f381117o;
    L15:
        if (r100.f381118p != null) goto L18;
        r100.f381118p = r101.f381118p;
        return;
    }

    public static void o(SVG.u r100, String r101) {
        SVG.e0 r102 = r100.f381102a.f(r101);
        if (r102 != null) goto L7;
        LLog.w("SVGAndroidRenderer", String.format("Pattern reference '%s' not found", new Object[]{r101}));
        return;
    L7:
        if ((r102 instanceof SVG.u) == true) goto L10;
        l("Pattern href attributes must point to other pattern elements", new Object[0]);
        return;
    L10:
        if (r102 != r100) goto L13;
        l("Circular reference in pattern href attribute '%s'", new Object[]{r101});
        return;
    L13:
        SVG.u r103 = (SVG.u) r102;
        if (r100.f381146k != null) goto L17;
        r100.f381146k = r103.f381146k;
    L17:
        if (r100.f381147l != null) goto L20;
        r100.f381147l = r103.f381147l;
    L20:
        if (r100.f381148m != null) goto L23;
        r100.f381148m = r103.f381148m;
    L23:
        if (r100.f381149n != null) goto L26;
        r100.f381149n = r103.f381149n;
    L26:
        if (r100.f381150o != null) goto L29;
        r100.f381150o = r103.f381150o;
    L29:
        if (r100.f381151p != null) goto L32;
        r100.f381151p = r103.f381151p;
    L32:
        if (r100.f381152q != null) goto L35;
        r100.f381152q = r103.f381152q;
    L35:
        if (r100.f381080h.isEmpty() == false) goto L38;
        r100.f381080h = r103.f381080h;
    L38:
        if (r100.f381120j != null) goto L41;
        r100.f381120j = r103.f381120j;
    L41:
        if (r100.f381108i != null) goto L43;
        r100.f381108i = r103.f381108i;
    L43:
        String r104 = r103.f381153r;
        if (r104 == null) goto L47;
        o(r100, r104);
        return;
    }

    public static boolean r(SVG.Style r100, long r101) {
        if ((r100.f381031a & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void C(SVG r100, com.lynx.component.svg.parser.c r101) {
        this.f381207d = r100;
        SVG.a0 r102 = r100.f381027a;
        if (r102 != null) goto L6;
        LLog.w("SVGAndroidRenderer", String.format("Nothing to render. Document is empty.", new Object[0]));
        return;
    L6:
        SVG.b r103 = r102.f381120j;
        PreserveAspectRatio r104 = r102.f381108i;
        this.f381208e = new c();
        this.f381209f = new Stack();
        J(this.f381208e, SVG.Style.a());
        c r105 = this.f381208e;
        r105.f381223f = null;
        this.f381209f.push(new c(r105));
        this.f381211h = new Stack();
        this.f381210g = new Stack();
        Boolean r106 = r102.f381091d;
        if (r106 == null) goto L9;
        c r107 = this.f381208e;
        r106.booleanValue();
        r107.getClass();
    L9:
        H();
        z(r102, new SVG.b(r101.f381198a), r103, r104);
        G();
    }

    public final void J(c r110, SVG.Style r111) {
        if (r(r111, 4096) == false) goto L6;
        SVG.Style r100 = r110.f381218a;
        r100.f381044n = r111.f381044n;
    L6:
        if (r(r111, 2048) == false) goto L8;
        SVG.Style r101 = r110.f381218a;
        r101.f381043m = r111.f381043m;
    L8:
        int r102 = 0;
        if (r(r111, 1) == false) goto L18;
        SVG.Style r103 = r110.f381218a;
        r103.f381032b = r111.f381032b;
        SVG.h0 r104 = r111.f381032b;
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        r110.f381219b = r105;
        goto L18
    L13:
        if (r104 == SVG.f.f381095c) goto L15;
        r105 = true;
    L18:
        if (r(r111, 4) == false) goto L21;
        SVG.Style r106 = r110.f381218a;
        r106.f381034d = r111.f381034d;
    L21:
        if (r(r111, 6149) == false) goto L24;
        F(r110, true, r110.f381218a.f381032b);
    L24:
        if (r(r111, 2) == false) goto L27;
        SVG.Style r107 = r110.f381218a;
        r107.f381033c = r111.f381033c;
    L27:
        if (r(r111, 8) == false) goto L36;
        SVG.Style r108 = r110.f381218a;
        r108.f381035e = r111.f381035e;
        SVG.h0 r109 = r111.f381035e;
        if (r109 != null) goto L31;
    L33:
        boolean r112 = false;
    L34:
        r110.f381220c = r112;
        goto L36
    L31:
        if (r109 == SVG.f.f381095c) goto L33;
        r112 = true;
    L36:
        if (r(r111, 16) == false) goto L39;
        SVG.Style r113 = r110.f381218a;
        r113.f381036f = r111.f381036f;
    L39:
        if (r(r111, 6168) == false) goto L42;
        F(r110, false, r110.f381218a.f381035e);
    L42:
        if (r(r111, 34359738368L) == false) goto L45;
        SVG.Style r114 = r110.f381218a;
        r114.A = r111.A;
    L45:
        if (r(r111, 32) == false) goto L54;
        SVG.Style r115 = r110.f381218a;
        SVG.o r116 = r111.f381037g;
        r115.f381037g = r116;
        r110.f381222e.setStrokeWidth(r116.b(this));
        if (r110.f381220c == true) goto L49;
    L51:
        boolean r117 = false;
    L52:
        r110.f381220c = r117;
        goto L54
    L49:
        if (r111.f381037g.g() == true) goto L51;
        r117 = true;
    L54:
        if (r(r111, 64) == false) goto L64;
        SVG.Style r118 = r110.f381218a;
        r118.f381038h = r111.f381038h;
        int r119 = a.f381213b[r111.f381038h.ordinal()];
        if (r119 == 1) goto L62;
        if (r119 == 2) goto L61;
        if (r119 != 3) goto L64;
        r110.f381222e.setStrokeCap(Paint.Cap.SQUARE);
        goto L64
    L61:
        r110.f381222e.setStrokeCap(Paint.Cap.ROUND);
        goto L64
    L62:
        r110.f381222e.setStrokeCap(Paint.Cap.BUTT);
    L64:
        if (r(r111, 128) == false) goto L74;
        SVG.Style r120 = r110.f381218a;
        r120.f381039i = r111.f381039i;
        int r121 = a.f381214c[r111.f381039i.ordinal()];
        if (r121 == 1) goto L72;
        if (r121 == 2) goto L71;
        if (r121 != 3) goto L74;
        r110.f381222e.setStrokeJoin(Paint.Join.BEVEL);
        goto L74
    L71:
        r110.f381222e.setStrokeJoin(Paint.Join.ROUND);
        goto L74
    L72:
        r110.f381222e.setStrokeJoin(Paint.Join.MITER);
    L74:
        if (r(r111, 256) == false) goto L77;
        SVG.Style r122 = r110.f381218a;
        r122.f381040j = r111.f381040j;
        r110.f381222e.setStrokeMiter(r111.f381040j.floatValue());
    L77:
        if (r(r111, 512) == false) goto L80;
        SVG.Style r123 = r110.f381218a;
        r123.f381041k = r111.f381041k;
    L80:
        if (r(r111, 1024) == false) goto L83;
        SVG.Style r124 = r110.f381218a;
        r124.f381042l = r111.f381042l;
    L83:
        if (r(r111, 1536) == false) goto L102;
        SVG.o[] r125 = r110.f381218a.f381041k;
        if (r125 != null) goto L87;
        r110.f381222e.setPathEffect(null);
        goto L102
    L87:
        int r126 = r125.length;
        if ((r126 % 2) != 0) goto L90;
        int r127 = r126;
    L91:
        float[] r128 = new float[r127];
        float r129 = 0.0f;
    L92:
        if (r102 >= r127) goto L95;
        float r130 = r110.f381218a.f381041k[r102 % r126].b(this);
        r128[r102] = r130;
        r129 = r129 + r130;
        r102 = r102 + 1;
        goto L92
    L95:
        if (r129 != 0.0f) goto L97;
        r110.f381222e.setPathEffect(null);
        goto L102
    L97:
        float r131 = r110.f381218a.f381042l.b(this);
        if (r131 >= 0.0f) goto L100;
        r131 = (r131 % r129) + r129;
    L100:
        r110.f381222e.setPathEffect(new DashPathEffect(r128, r131));
        goto L102
    L90:
        r127 = r126 * 2;
    L102:
        if (r(r111, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == false) goto L105;
        SVG.Style r132 = r110.f381218a;
        r132.f381045o = r111.f381045o;
    L105:
        if (r(r111, 16777216) == false) goto L108;
        SVG.Style r133 = r110.f381218a;
        r133.f381047q = r111.f381047q;
    L108:
        if (r(r111, 33554432) == false) goto L111;
        SVG.Style r134 = r110.f381218a;
        r134.f381048r = r111.f381048r;
    L111:
        if (r(r111, 1048576) == false) goto L114;
        SVG.Style r135 = r110.f381218a;
        r135.f381046p = r111.f381046p;
    L114:
        if (r(r111, 268435456) == false) goto L117;
        SVG.Style r136 = r110.f381218a;
        r136.f381051u = r111.f381051u;
    L117:
        if (r(r111, 536870912) == false) goto L120;
        SVG.Style r137 = r110.f381218a;
        r137.f381052v = r111.f381052v;
    L120:
        if (r(r111, 67108864) == false) goto L123;
        SVG.Style r138 = r110.f381218a;
        r138.f381049s = r111.f381049s;
    L123:
        if (r(r111, 134217728) == false) goto L126;
        SVG.Style r139 = r110.f381218a;
        r139.f381050t = r111.f381050t;
    L126:
        if (r(r111, 8589934592L) == false) goto L129;
        SVG.Style r140 = r110.f381218a;
        r140.f381055y = r111.f381055y;
    L129:
        if (r(r111, 17179869184L) == false) goto L132;
        SVG.Style r141 = r110.f381218a;
        r141.f381056z = r111.f381056z;
    L132:
        if (r(r111, 137438953472L) == false) goto L136;
        SVG.Style r142 = r110.f381218a;
        r142.B = r111.B;
        return;
    }

    public final void K(c r100, SVG.e0 r101) {
        if (r101.f381103b != null) goto L5;
        boolean r102 = true;
    L6:
        SVG.Style r103 = r100.f381218a;
        Boolean r104 = Boolean.TRUE;
        r103.f381047q = r104;
        if (r102 == true) goto L10;
        r104 = Boolean.FALSE;
    L10:
        r103.f381045o = r104;
        r103.f381046p = null;
        r103.f381051u = null;
        r103.f381043m = Float.valueOf(1.0f);
        r103.f381049s = SVG.f.f381094b;
        r103.f381050t = Float.valueOf(1.0f);
        r103.f381053w = null;
        r103.f381054x = Float.valueOf(1.0f);
        r103.f381055y = null;
        r103.f381056z = Float.valueOf(1.0f);
        r103.A = SVG.Style.VectorEffect.None;
        SVG.Style r105 = r101.f381092e;
        if (r105 == null) goto L13;
        J(r100, r105);
    L13:
        SVG.Style r106 = r101.f381093f;
        if (r106 == null) goto L17;
        J(r100, r106);
        return;
    L17:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final Path a(SVG.d0 r100, SVG.b r101) {
        SVG.e0 r102 = r100.f381102a.f(this.f381208e.f381218a.f381051u);
        boolean r103 = false;
        if (r102 != null) goto L6;
        l("ClipPath reference '%s' not found", new Object[]{this.f381208e.f381218a.f381051u});
        return null;
    L6:
        SVG.e r104 = (SVG.e) r102;
        this.f381209f.push(this.f381208e);
        c r105 = new c();
        J(r105, SVG.Style.a());
        p(r104, r105);
        this.f381208e = r105;
        Boolean r106 = r104.f381089j;
        if (r106 != null) goto L9;
    L10:
        r103 = true;
    L11:
        Matrix r107 = new Matrix();
        if (r103 == true) goto L14;
        r107.preTranslate(r101.f381076a, r101.f381077b);
        r107.preScale(r101.f381078c, r101.f381079d);
    L14:
        Matrix r108 = r104.f381121i;
        if (r108 == null) goto L17;
        r107.preConcat(r108);
    L17:
        Path r109 = new Path();
        Iterator<SVG.g0> r110 = r104.f381080h.iterator();
    L19:
        if (r110.hasNext() == false) goto L27;
        SVG.g0 r111 = r110.next();
        if ((r111 instanceof SVG.d0) == false) goto L19;
        Path r112 = x((SVG.d0) r111, true);
        if (r112 == null) goto L19;
        r109.op(r112, Path.Op.UNION);
        goto L19
    L27:
        if (this.f381208e.f381218a.f381051u != null) goto L29;
    L34:
        r109.transform(r107);
        this.f381208e = this.f381209f.pop();
        return r109;
    L29:
        if (r104.f381088g != null) goto L31;
        r104.f381088g = b(r109);
    L31:
        Path r113 = a(r104, r104.f381088g);
        if (r113 == null) goto L34;
        r109.op(r113, Path.Op.INTERSECT);
        goto L34
    L9:
        if (r106.booleanValue() == false) goto L11;
        goto L10
    }

    public final void d(SVG.d0 r100, SVG.b r101) {
        if (this.f381208e.f381218a.f381051u != null) goto L5;
        return;
    L5:
        Path r102 = a(r100, r101);
        if (r102 == null) goto L9;
        this.f381204a.clipPath(r102);
        return;
    }

    public final void j(SVG.d0 r110, Path r210) {
        SVG.h0 r100 = this.f381208e.f381218a.f381032b;
        if ((r100 instanceof SVG.r) == false) goto L112;
        SVG.e0 r101 = this.f381207d.f(((SVG.r) r100).f381139a);
        if ((r101 instanceof SVG.u) == false) goto L112;
        SVG.u r102 = (SVG.u) r101;
        Boolean r103 = r102.f381146k;
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        String r105 = r102.f381153r;
        if (r105 == null) goto L16;
        o(r102, r105);
    L16:
        if (r104 == false) goto L33;
        SVG.o r106 = r102.f381149n;
        if (r106 == null) goto L20;
        float r107 = r106.d(this);
    L21:
        SVG.o r108 = r102.f381150o;
        if (r108 == null) goto L24;
        float r109 = r108.e(this);
    L25:
        SVG.o r111 = r102.f381151p;
        if (r111 == null) goto L28;
        float r112 = r111.d(this);
    L29:
        SVG.o r113 = r102.f381152q;
        if (r113 == null) goto L32;
        float r114 = r113.e(this);
    L51:
        if (r112 != 0.0f) goto L53;
        return;
    L53:
        if (r114 == 0.0f) goto L121;
        PreserveAspectRatio r115 = r102.f381108i;
        if (r115 != null) goto L59;
        r115 = PreserveAspectRatio.f381022d;
    L59:
        H();
        this.f381204a.clipPath(r210);
        c r116 = new c();
        J(r116, SVG.Style.a());
        r116.f381218a.f381045o = Boolean.FALSE;
        p(r102, r116);
        this.f381208e = r116;
        SVG.b r117 = r110.f381088g;
        Matrix r118 = r102.f381148m;
        if (r118 == null) goto L79;
        this.f381204a.concat(r118);
        Matrix r119 = new Matrix();
        if (r102.f381148m.invert(r119) == false) goto L79;
        SVG.b r120 = r110.f381088g;
        float r121 = r120.f381076a;
        float r122 = r120.f381077b;
        float r123 = r120.f381078c + r121;
        float r124 = r122 + r120.f381079d;
        float[] r125 = {r121, r122, r123, r122, r123, r124, r121, r124};
        r119.mapPoints(r125);
        float r126 = r125[0];
        float r127 = r125[1];
        RectF r128 = new RectF(r126, r127, r126, r127);
        int r129 = 2;
    L64:
        if (r129 > 6) goto L78;
        float r130 = r125[r129];
        if (r130 >= r128.left) goto L69;
        r128.left = r130;
    L69:
        if (r130 <= r128.right) goto L71;
        r128.right = r130;
    L71:
        float r131 = r125[r129 + 1];
        if (r131 >= r128.top) goto L75;
        r128.top = r131;
    L75:
        if (r131 <= r128.bottom) goto L77;
        r128.bottom = r131;
    L77:
        r129 = r129 + 2;
        goto L64
    L78:
        float r132 = r128.left;
        float r133 = r128.top;
        r117 = new SVG.b(r132, r133, r128.right - r132, r128.bottom - r133);
    L79:
        float r134 = r107 + (((float) Math.floor((r117.f381076a - r107) / r112)) * r112);
        float r135 = r109 + (((float) Math.floor((r117.f381077b - r109) / r114)) * r114);
        float r136 = r117.f381076a + r117.f381078c;
        float r137 = r117.f381077b + r117.f381079d;
        SVG.b r138 = new SVG.b(0.0f, 0.0f, r112, r114);
        boolean r139 = y();
    L81:
        if (r135 >= r137) goto L108;
        float r140 = r134;
    L84:
        if (r140 >= r136) goto L107;
        r138.f381076a = r140;
        r138.f381077b = r135;
        H();
        if (this.f381208e.f381218a.f381045o.booleanValue() == true) goto L89;
        E(r138.f381076a, r138.f381077b, r138.f381078c, r138.f381079d);
    L89:
        SVG.b r141 = r102.f381120j;
        if (r141 == null) goto L92;
        this.f381204a.concat(c(r138, r141, r115));
    L102:
        Iterator<SVG.g0> r142 = r102.f381080h.iterator();
    L104:
        if (r142.hasNext() == false) goto L106;
        A(r142.next());
        goto L104
    L106:
        G();
        r140 = r140 + r112;
        r134 = r134;
        goto L84
    L92:
        Boolean r143 = r102.f381147l;
        if (r143 != null) goto L95;
    L98:
        boolean r144 = true;
    L99:
        this.f381204a.translate(r140, r135);
        if (r144 == true) goto L102;
        Canvas r145 = this.f381204a;
        SVG.b r146 = r110.f381088g;
        r145.scale(r146.f381078c, r146.f381079d);
        goto L102
    L95:
        if (r143.booleanValue() == true) goto L98;
        r144 = false;
        goto L99
    L107:
        r135 = r135 + r114;
        goto L81
    L108:
        if (r139 == false) goto L110;
        G();
    L110:
        G();
        return;
    L121:
        return;
    L32:
        r114 = 0.0f;
        goto L51
    L28:
        r112 = 0.0f;
        goto L29
    L24:
        r109 = 0.0f;
        goto L25
    L20:
        r107 = 0.0f;
        goto L21
    L33:
        SVG.o r147 = r102.f381149n;
        if (r147 == null) goto L36;
        float r148 = r147.c(this);
    L37:
        SVG.o r149 = r102.f381150o;
        if (r149 == null) goto L40;
        float r150 = r149.c(this);
    L41:
        SVG.o r151 = r102.f381151p;
        if (r151 == null) goto L44;
        float r152 = r151.c(this);
    L45:
        SVG.o r153 = r102.f381152q;
        if (r153 == null) goto L48;
        float r154 = r153.c(this);
    L49:
        SVG.b r155 = r110.f381088g;
        float r156 = r155.f381076a;
        float r157 = r155.f381078c;
        r107 = (r148 * r157) + r156;
        float r158 = r155.f381077b;
        float r159 = r155.f381079d;
        r109 = (r150 * r159) + r158;
        r112 = r152 * r157;
        r114 = r154 * r159;
        goto L51
    L48:
        r154 = 0.0f;
        goto L49
    L44:
        r152 = 0.0f;
        goto L45
    L40:
        r150 = 0.0f;
        goto L41
    L36:
        r148 = 0.0f;
        goto L37
    L9:
        if (r103.booleanValue() == false) goto L11;
        r104 = true;
    L112:
        this.f381204a.drawPath(r210, this.f381208e.f381221d);
    }

    public final void p(SVG.e0 r100, c r101) {
        ArrayList r102 = new ArrayList();
        SVG.g0 r103 = r100;
    L4:
        if ((r103 instanceof SVG.e0) == false) goto L6;
        ListProtector.add(r102, 0, (SVG.e0) r103);
    L6:
        Object r104 = r103.f381103b;
        if (r104 == null) goto L8;
        r103 = (SVG.g0) r104;
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        K(r101, (SVG.e0) r105.next());
        goto L10
    L12:
        c r106 = this.f381208e;
        r101.f381224g = r106.f381224g;
        r101.f381223f = r106.f381223f;
    }

    public final Path x(SVG.d0 r100, boolean r101) {
        this.f381209f.push(this.f381208e);
        c r102 = new c(this.f381208e);
        this.f381208e = r102;
        K(r102, r100);
        if (i() == true) goto L5;
    L66:
        this.f381208e = this.f381209f.pop();
        return null;
    L5:
        if (M() == false) goto L66;
        if ((r100 instanceof SVG.l0) == false) goto L29;
        if (r101 == true) goto L11;
        l("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
    L11:
        SVG.l0 r103 = (SVG.l0) r100;
        SVG.e0 r104 = r100.f381102a.f(r103.f381122j);
        if (r104 != null) goto L16;
        l("Use reference '%s' not found", new Object[]{r103.f381122j});
        this.f381208e = this.f381209f.pop();
        return null;
    L16:
        if ((r104 instanceof SVG.d0) == true) goto L19;
        this.f381208e = this.f381209f.pop();
        return null;
    L19:
        Path r105 = x((SVG.d0) r104, false);
        if (r105 != null) goto L23;
        return null;
    L23:
        if (r103.f381088g != null) goto L25;
        r103.f381088g = b(r105);
    L25:
        Matrix r106 = r103.f381121i;
        if (r106 == null) goto L58;
        r105.transform(r106);
    L58:
        if (this.f381208e.f381218a.f381051u == null) goto L62;
        Path r107 = a(r100, r100.f381088g);
        if (r107 == null) goto L62;
        r105.op(r107, Path.Op.INTERSECT);
    L62:
        this.f381208e = this.f381209f.pop();
        return r105;
    L29:
        if ((r100 instanceof SVG.k) == false) goto L64;
        SVG.k r108 = (SVG.k) r100;
        if ((r100 instanceof SVG.s) == false) goto L36;
        r105 = new b(((SVG.s) r100).f381141i).f381215a;
        if (r100.f381088g != null) goto L48;
        r100.f381088g = b(r105);
    L48:
        if (r105 != null) goto L51;
        return null;
    L51:
        if (r108.f381088g != null) goto L53;
        r108.f381088g = b(r105);
    L53:
        Matrix r109 = r108.f381119h;
        if (r109 == null) goto L56;
        r105.transform(r109);
    L56:
        r105.setFillType(q());
        goto L58
    L36:
        if ((r100 instanceof SVG.x) == false) goto L39;
        r105 = v((SVG.x) r100);
        goto L48
    L39:
        if ((r100 instanceof SVG.d) == false) goto L42;
        r105 = s((SVG.d) r100);
        goto L48
    L42:
        if ((r100 instanceof SVG.i) == false) goto L45;
        r105 = t((SVG.i) r100);
        goto L48
    L45:
        if ((r100 instanceof SVG.v) == false) goto L47;
        r105 = u((SVG.v) r100);
        goto L48
    L47:
        r105 = null;
        goto L48
    L64:
        l("Invalid %s element found in clipPath definition", new Object[]{r100.c()});
        return null;
    }

    public e(Canvas r100, float r101, com.lynx.component.svg.d r102) {
        this.f381204a = r100;
        this.f381205b = r101;
        this.f381206c = r102;
    }

    public static void F(c r100, boolean r101, SVG.h0 r102) {
        SVG.Style r103 = r100.f381218a;
        if (r101 == false) goto L5;
        Float r104 = r103.f381034d;
    L6:
        float r105 = r104.floatValue();
        if ((r102 instanceof SVG.f) == false) goto L10;
        int r106 = ((SVG.f) r102).f381096a;
    L12:
        int r107 = f(r106, r105);
        if (r101 == false) goto L15;
        r100.f381221d.setColor(r107);
        return;
    L15:
        r100.f381222e.setColor(r107);
        return;
    L10:
        if ((r102 instanceof SVG.g) == false) goto L17;
        r106 = r100.f381218a.f381044n.f381096a;
        goto L12
    L17:
        return;
    L5:
        r104 = r103.f381036f;
        goto L6
    }

    public static Matrix c(SVG.b r100, SVG.b r110, PreserveAspectRatio r111) {
        Matrix r101 = new Matrix();
        if (r111 != null) goto L5;
    L38:
        return r101;
    L5:
        if (r111.f381023a == null) goto L38;
        float r102 = r100.f381078c / r110.f381078c;
        float r103 = r100.f381079d / r110.f381079d;
        float r104 = -r110.f381076a;
        float r105 = -r110.f381077b;
        if (r111.equals(PreserveAspectRatio.f381021c) == false) goto L12;
        r101.preTranslate(r100.f381076a, r100.f381077b);
        r101.preScale(r102, r103);
        r101.preTranslate(r104, r105);
        return r101;
    L12:
        if (r111.f381024b != PreserveAspectRatio.Scale.slice) goto L14;
        float r106 = Math.max(r102, r103);
    L15:
        float r107 = r100.f381078c / r106;
        float r108 = r100.f381079d / r106;
        int[] r109 = a.f381212a;
        switch(r109[r111.f381023a.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L18;
            case 6: goto L18;
            default: goto L21;
        };
    L18:
        float r112 = r110.f381078c - r107;
    L20:
        r104 = r104 - r112;
        goto L21
    L19:
        r112 = (r110.f381078c - r107) / 2.0f;
    L21:
        int r113 = r109[r111.f381023a.ordinal()];
        if (r113 != 2) goto L24;
    L35:
        float r114 = (r110.f381079d - r108) / 2.0f;
    L36:
        r105 = r105 - r114;
    L37:
        r101.preTranslate(r100.f381076a, r100.f381077b);
        r101.preScale(r106, r106);
        r101.preTranslate(r104, r105);
        goto L38
    L24:
        if (r113 != 3) goto L26;
    L34:
        r114 = r110.f381079d - r108;
        goto L36
    L26:
        if (r113 == 5) goto L35;
        if (r113 == 6) goto L34;
        if (r113 == 7) goto L35;
        if (r113 == 8) goto L34;
    L14:
        r106 = Math.min(r102, r103);
        goto L15
    }

    public final void D(SVG.n r110, PreserveAspectRatio r111, Bitmap r112) {
        int r100 = 0;
        if (r112 != null) goto L6;
        l("Could not locate image '%s'", new Object[]{r110.f381127j});
        return;
    L6:
        SVG.b r101 = new SVG.b(0.0f, 0.0f, r112.getWidth(), r112.getHeight());
        K(this.f381208e, r110);
        if (i() == true) goto L10;
        return;
    L10:
        if (M() == true) goto L12;
        return;
    L12:
        Matrix r102 = r110.f381132o;
        if (r102 == null) goto L15;
        this.f381204a.concat(r102);
    L15:
        SVG.o r103 = r110.f381128k;
        if (r103 == null) goto L18;
        float r104 = r103.d(this);
    L19:
        SVG.o r105 = r110.f381129l;
        if (r105 == null) goto L22;
        float r106 = r105.e(this);
    L23:
        float r107 = r110.f381130m.d(this);
        float r108 = r110.f381131n.d(this);
        c r109 = this.f381208e;
        r109.f381223f = new SVG.b(r104, r106, r107, r108);
        if (r109.f381218a.f381045o.booleanValue() == true) goto L26;
        SVG.b r113 = this.f381208e.f381223f;
        E(r113.f381076a, r113.f381077b, r113.f381078c, r113.f381079d);
    L26:
        r110.f381088g = this.f381208e.f381223f;
        I(r110);
        d(r110, r110.f381088g);
        boolean r114 = y();
        L();
        this.f381204a.save();
        this.f381204a.concat(c(this.f381208e.f381223f, r101, r111));
        if (this.f381208e.f381218a.B == SVG.Style.RenderQuality.optimizeSpeed) goto L30;
        r100 = 2;
    L30:
        this.f381204a.drawBitmap(r112, 0.0f, 0.0f, new Paint(r100));
        this.f381204a.restore();
        if (r114 == false) goto L34;
        G();
        return;
    L34:
        return;
    L22:
        r106 = 0.0f;
        goto L23
    L18:
        r104 = 0.0f;
        goto L19
    }

    public final void h(boolean r210, SVG.b r211, SVG.r r212) {
        SVG.e0 r100 = this.f381207d.f(r212.f381139a);
        boolean r101 = true;
        int r102 = 0;
        if (r100 != null) goto L15;
        Object[] r103 = new Object[2];
        if (r210 == false) goto L7;
        String r104 = "Fill";
    L8:
        r103[0] = r104;
        r103[1] = r212.f381139a;
        l("%s reference '%s' not found", r103);
        SVG.h0 r105 = r212.f381140b;
        if (r105 == null) goto L11;
        F(this.f381208e, r210, r105);
        return;
    L11:
        if (r210 == false) goto L13;
        this.f381208e.f381219b = false;
        return;
    L13:
        this.f381208e.f381220c = false;
        return;
    L7:
        r104 = "Stroke";
        goto L8
    L15:
        float r110 = -1.0f;
        if ((r100 instanceof SVG.f0) == false) goto L117;
        SVG.f0 r106 = (SVG.f0) r100;
        String r107 = r106.f381113k;
        if (r107 == null) goto L20;
        m(r106, r107);
    L20:
        Boolean r108 = r106.f381110h;
        if (r108 != null) goto L23;
    L25:
        boolean r109 = false;
    L26:
        c r111 = this.f381208e;
        if (r210 == false) goto L29;
        Paint r112 = r111.f381221d;
    L30:
        if (r109 == false) goto L50;
        SVG.b r113 = r111.f381224g;
        if (r113 != null) goto L35;
        r113 = r111.f381223f;
    L35:
        SVG.o r114 = r106.f381097l;
        if (r114 == null) goto L38;
        float r115 = r114.d(this);
    L39:
        SVG.o r116 = r106.f381098m;
        if (r116 == null) goto L42;
        float r117 = r116.e(this);
    L43:
        SVG.o r118 = r106.f381099n;
        if (r118 == null) goto L46;
        float r119 = r118.d(this);
    L47:
        SVG.o r120 = r106.f381100o;
        if (r120 == null) goto L65;
        float r121 = r120.e(this);
    L66:
        float r122 = r115;
        float r123 = r119;
        float r124 = r117;
        float r213 = r121;
        H();
        c r125 = new c();
        J(r125, SVG.Style.a());
        p(r106, r125);
        this.f381208e = r125;
        Matrix r126 = new Matrix();
        if (r109 == true) goto L69;
        r126.preTranslate(r211.f381076a, r211.f381077b);
        r126.preScale(r211.f381078c, r211.f381079d);
    L69:
        Matrix r127 = r106.f381111i;
        if (r127 == null) goto L72;
        r126.preConcat(r127);
    L72:
        int r128 = r106.f381109g.size();
        if (r128 != 0) goto L78;
        G();
        if (r210 == false) goto L77;
        this.f381208e.f381219b = false;
        return;
    L77:
        this.f381208e.f381220c = false;
        return;
    L78:
        int[] r129 = new int[r128];
        float[] r130 = new float[r128];
        Iterator<SVG.g0> r131 = r106.f381109g.iterator();
        int r132 = 0;
    L80:
        if (r131.hasNext() == false) goto L96;
        SVG.z r133 = (SVG.z) r131.next();
        Float r134 = r133.f381161g;
        if (r134 == null) goto L84;
        float r135 = r134.floatValue();
    L85:
        if (r132 != 0) goto L87;
    L90:
        r130[r132] = r135;
        r110 = r135;
    L91:
        H();
        K(this.f381208e, r133);
        SVG.Style r136 = this.f381208e.f381218a;
        SVG.f r137 = (SVG.f) r136.f381049s;
        if (r137 != null) goto L94;
        r137 = SVG.f.f381094b;
    L94:
        r129[r132] = f(r137.f381096a, r136.f381050t.floatValue());
        r132 = r132 + 1;
        G();
        goto L80
    L87:
        if (r135 >= r110) goto L90;
        r130[r132] = r110;
        goto L91
    L84:
        r135 = 0.0f;
        goto L85
    L96:
        if (r122 == r123) goto L98;
    L99:
        if (r128 != 1) goto L101;
    L100:
        G();
        r112.setColor(r129[r128 - 1]);
        return;
    L101:
        Shader.TileMode r138 = Shader.TileMode.CLAMP;
        SVG.GradientSpread r139 = r106.f381112j;
        if (r139 != null) goto L104;
    L109:
        G();
        LinearGradient r140 = new LinearGradient(r122, r124, r123, r213, r129, r130, r138);
        r140.setLocalMatrix(r126);
        r112.setShader(r140);
        int r141 = (int) (this.f381208e.f381218a.f381034d.floatValue() * 256.0f);
        if (r141 < 0) goto L115;
        if (r141 <= 255) goto L114;
        r102 = 255;
        goto L115
    L114:
        r102 = r141;
    L115:
        r112.setAlpha(r102);
        return;
    L104:
        if (r139 != SVG.GradientSpread.reflect) goto L107;
        r138 = Shader.TileMode.MIRROR;
        goto L109
    L107:
        if (r139 != SVG.GradientSpread.repeat) goto L109;
        r138 = Shader.TileMode.REPEAT;
        goto L109
    L98:
        if (r124 == r213) goto L100;
    L65:
        r121 = 0.0f;
        goto L66
    L46:
        r119 = r113.f381078c;
        goto L47
    L42:
        r117 = 0.0f;
        goto L43
    L38:
        r115 = 0.0f;
        goto L39
    L50:
        SVG.o r142 = r106.f381097l;
        if (r142 == null) goto L53;
        r115 = r142.c(this);
    L54:
        SVG.o r143 = r106.f381098m;
        if (r143 == null) goto L57;
        r117 = r143.c(this);
    L58:
        SVG.o r144 = r106.f381099n;
        if (r144 == null) goto L61;
        r119 = r144.c(this);
    L62:
        SVG.o r145 = r106.f381100o;
        if (r145 == null) goto L65;
        r121 = r145.c(this);
        goto L66
    L61:
        r119 = 1.0f;
        goto L62
    L57:
        r117 = 0.0f;
        goto L58
    L53:
        r115 = 0.0f;
        goto L54
    L29:
        r112 = r111.f381222e;
        goto L30
    L23:
        if (r108.booleanValue() == false) goto L25;
        r109 = true;
        goto L26
    L117:
        if ((r100 instanceof SVG.j0) == false) goto L207;
        SVG.j0 r146 = (SVG.j0) r100;
        String r147 = r146.f381113k;
        if (r147 == null) goto L121;
        m(r146, r147);
    L121:
        Boolean r148 = r146.f381110h;
        if (r148 != null) goto L124;
    L126:
        boolean r149 = false;
    L127:
        c r150 = this.f381208e;
        if (r210 == false) goto L130;
        Paint r151 = r150.f381221d;
    L131:
        if (r149 == false) goto L145;
        SVG.o r152 = new SVG.o(50.0f, SVG.Unit.percent);
        SVG.o r153 = r146.f381114l;
        if (r153 == null) goto L135;
        float r154 = r153.d(this);
    L136:
        SVG.o r155 = r146.f381115m;
        if (r155 == null) goto L139;
        float r156 = r155.e(this);
    L140:
        SVG.o r157 = r146.f381116n;
        if (r157 == null) goto L143;
        float r158 = r157.b(this);
    L144:
        float r159 = r158;
        float r160 = r154;
    L157:
        float r161 = r156;
        H();
        c r162 = new c();
        J(r162, SVG.Style.a());
        p(r146, r162);
        this.f381208e = r162;
        Matrix r163 = new Matrix();
        if (r149 == true) goto L160;
        r163.preTranslate(r211.f381076a, r211.f381077b);
        r163.preScale(r211.f381078c, r211.f381079d);
    L160:
        Matrix r164 = r146.f381111i;
        if (r164 == null) goto L163;
        r163.preConcat(r164);
    L163:
        int r165 = r146.f381109g.size();
        if (r165 != 0) goto L169;
        G();
        if (r210 == false) goto L168;
        this.f381208e.f381219b = false;
        return;
    L168:
        this.f381208e.f381220c = false;
        return;
    L169:
        int[] r166 = new int[r165];
        float[] r167 = new float[r165];
        Iterator<SVG.g0> r168 = r146.f381109g.iterator();
        int r169 = 0;
    L171:
        if (r168.hasNext() == false) goto L187;
        SVG.z r170 = (SVG.z) r168.next();
        Float r171 = r170.f381161g;
        if (r171 == null) goto L175;
        float r172 = r171.floatValue();
    L176:
        if (r169 != 0) goto L178;
    L181:
        r167[r169] = r172;
        r110 = r172;
    L182:
        H();
        K(this.f381208e, r170);
        SVG.Style r173 = this.f381208e.f381218a;
        SVG.f r174 = (SVG.f) r173.f381049s;
        if (r174 != null) goto L185;
        r174 = SVG.f.f381094b;
    L185:
        r166[r169] = f(r174.f381096a, r173.f381050t.floatValue());
        r169 = r169 + 1;
        G();
        goto L171
    L178:
        if (r172 >= r110) goto L181;
        r167[r169] = r110;
        goto L182
    L175:
        r172 = 0.0f;
        goto L176
    L187:
        if (r159 == 0.0f) goto L205;
        if (r165 == 1) goto L205;
        Shader.TileMode r175 = Shader.TileMode.CLAMP;
        SVG.GradientSpread r176 = r146.f381112j;
        if (r176 != null) goto L193;
    L198:
        G();
        RadialGradient r177 = new RadialGradient(r160, r161, r159, r166, r167, r175);
        r177.setLocalMatrix(r163);
        r151.setShader(r177);
        int r178 = (int) (this.f381208e.f381218a.f381034d.floatValue() * 256.0f);
        if (r178 >= 0) goto L201;
        int r179 = 0;
    L204:
        r151.setAlpha(r179);
        return;
    L201:
        if (r178 <= 255) goto L203;
        r179 = 255;
        goto L204
    L203:
        r179 = r178;
        goto L204
    L193:
        if (r176 != SVG.GradientSpread.reflect) goto L196;
        r175 = Shader.TileMode.MIRROR;
        goto L198
    L196:
        if (r176 != SVG.GradientSpread.repeat) goto L198;
        r175 = Shader.TileMode.REPEAT;
    L205:
        G();
        r151.setColor(r166[r165 - 1]);
        return;
    L143:
        r158 = r152.b(this);
        goto L144
    L139:
        r156 = r152.e(this);
        goto L140
    L135:
        r154 = r152.d(this);
        goto L136
    L145:
        SVG.o r180 = r146.f381114l;
        float r181 = 0.5f;
        if (r180 == null) goto L148;
        float r182 = r180.c(this);
    L149:
        SVG.o r183 = r146.f381115m;
        if (r183 == null) goto L152;
        r156 = r183.c(this);
    L153:
        SVG.o r184 = r146.f381116n;
        if (r184 == null) goto L156;
        r181 = r184.c(this);
    L156:
        r160 = r182;
        r159 = r181;
        goto L157
    L152:
        r156 = 0.5f;
        goto L153
    L148:
        r182 = 0.5f;
        goto L149
    L130:
        r151 = r150.f381222e;
        goto L131
    L124:
        if (r148.booleanValue() == false) goto L126;
        r149 = true;
        goto L127
    L207:
        if ((r100 instanceof SVG.y) == false) goto L253;
        SVG.y r185 = (SVG.y) r100;
        if (r210 == false) goto L224;
        if (r(r185.f381092e, j0.G2_OTA_SPACE_RESERVE_BYTES) == false) goto L218;
        c r186 = this.f381208e;
        SVG.Style r187 = r186.f381218a;
        SVG.h0 r188 = r185.f381092e.f381053w;
        r187.f381032b = r188;
        if (r188 != null) goto L216;
        r101 = false;
    L216:
        r186.f381219b = r101;
    L218:
        if (r(r185.f381092e, 4294967296L) == false) goto L221;
        SVG.Style r189 = this.f381208e.f381218a;
        r189.f381034d = r185.f381092e.f381054x;
    L221:
        if (r(r185.f381092e, 6442450944L) == false) goto L254;
        c r190 = this.f381208e;
        F(r190, r210, r190.f381218a.f381032b);
        return;
    L254:
        return;
    L224:
        if (r(r185.f381092e, j0.G2_OTA_SPACE_RESERVE_BYTES) == false) goto L231;
        c r191 = this.f381208e;
        SVG.Style r192 = r191.f381218a;
        SVG.h0 r193 = r185.f381092e.f381053w;
        r192.f381035e = r193;
        if (r193 != null) goto L229;
        r101 = false;
    L229:
        r191.f381220c = r101;
    L231:
        if (r(r185.f381092e, 4294967296L) == false) goto L234;
        SVG.Style r194 = this.f381208e.f381218a;
        r194.f381036f = r185.f381092e.f381054x;
    L234:
        if (r(r185.f381092e, 6442450944L) == false) goto L256;
        c r195 = this.f381208e;
        F(r195, r210, r195.f381218a.f381035e);
        return;
    L256:
        return;
    }

    public final void E(float r100, float r101, float r102, float r103) {
        float r104 = r102 + r100;
        float r105 = r103 + r101;
        SVG.c r106 = this.f381208e.f381218a.f381046p;
        if (r106 == null) goto L5;
        r100 = r100 + r106.f381084d.d(this);
        r101 = r101 + this.f381208e.f381218a.f381046p.f381081a.e(this);
        r104 = r104 - this.f381208e.f381218a.f381046p.f381082b.d(this);
        r105 = r105 - this.f381208e.f381218a.f381046p.f381083c.e(this);
    L5:
        this.f381204a.clipRect(r100, r101, r104, r105);
    }

    public final SVG.b w(SVG.o r100, SVG.o r101, SVG.o r102, SVG.o r103) {
        float r104 = 0.0f;
        if (r100 == null) goto L5;
        float r105 = r100.d(this);
    L6:
        if (r101 == null) goto L8;
        r104 = r101.e(this);
    L8:
        c r106 = this.f381208e;
        SVG.b r107 = r106.f381224g;
        if (r107 != null) goto L12;
        r107 = r106.f381223f;
    L12:
        if (r102 == null) goto L14;
        float r108 = r102.d(this);
    L15:
        if (r103 == null) goto L17;
        float r109 = r103.e(this);
    L19:
        return new SVG.b(r105, r104, r108, r109);
    L17:
        r109 = r107.f381079d;
        goto L19
    L14:
        r108 = r107.f381078c;
        goto L15
    L5:
        r105 = 0.0f;
        goto L6
    }

    public final void z(SVG.a0 r100, SVG.b r101, SVG.b r102, PreserveAspectRatio r103) {
        g("Svg render", new Object[0]);
        if (r101.f381078c != 0.0f) goto L5;
        return;
    L5:
        if (r101.f381079d == 0.0f) goto L28;
        if (r103 != null) goto L12;
        r103 = r100.f381108i;
        if (r103 != null) goto L12;
        r103 = new PreserveAspectRatio(PreserveAspectRatio.Alignment.none, PreserveAspectRatio.Scale.meet);
    L12:
        K(this.f381208e, r100);
        if (i() == true) goto L15;
        return;
    L15:
        c r104 = this.f381208e;
        r104.f381223f = r101;
        if (r104.f381218a.f381045o.booleanValue() == true) goto L18;
        SVG.b r105 = this.f381208e.f381223f;
        E(r105.f381076a, r105.f381077b, r105.f381078c, r105.f381079d);
    L18:
        d(r100, this.f381208e.f381223f);
        if (r102 == null) goto L21;
        this.f381204a.concat(c(this.f381208e.f381223f, r102, r103));
        c r106 = this.f381208e;
        r106.f381224g = r100.f381120j;
    L22:
        boolean r107 = y();
        L();
        B(r100);
        if (r107 == false) goto L25;
        G();
    L25:
        I(r100);
        return;
    L21:
        Canvas r108 = this.f381204a;
        SVG.b r109 = this.f381208e.f381223f;
        r108.translate(r109.f381076a, r109.f381077b);
        goto L22
    }
}
