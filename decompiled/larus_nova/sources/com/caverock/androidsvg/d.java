package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.ota.g2.j0;
import com.lynx.textra.PlatformFontCaps;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static HashSet<String> f272990h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Canvas f272991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f272992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SVG f272993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f272994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Stack<h> f272995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Stack<SVG.h0> f272996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Stack<Matrix> f272997g;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272998a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f272999b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f273000c = null;

        static {
            int[] r100 = new int[SVG.Style.LineJoin.values().length];
            f273000c = r100;
            r100[SVG.Style.LineJoin.Miter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L54:
            f273000c[SVG.Style.LineJoin.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L42:
            f273000c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            int[] r101 = new int[SVG.Style.LineCap.values().length];
            f272999b = r101;
            r101[SVG.Style.LineCap.Butt.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L62:
            f272999b[SVG.Style.LineCap.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L36:
            f272999b[SVG.Style.LineCap.Square.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L12:
            int[] r102 = new int[PreserveAspectRatio.Alignment.values().length];
            f272998a = r102;
            r102[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L40:
            f272998a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            f272998a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L52:
            f272998a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L38:
            f272998a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L50:
            f272998a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L56:
            f272998a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L44:
            f272998a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
            return;
        }
    }

    public class b implements SVG.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f273001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f273002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f273003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f273004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f273005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f273006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f273007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f273008h;

        @Override // com.caverock.androidsvg.SVG.w
        public final void close() {
            List<c> r100 = this.f273001a;
            ArrayList r101 = (ArrayList) r100;
            r101.add(this.f273004d);
            lineTo(this.f273002b, this.f273003c);
            this.f273008h = true;
        }

        public b(d r100, SVG.v r101) {
            ArrayList r102 = new ArrayList();
            this.f273001a = r102;
            this.f273004d = null;
            this.f273005e = false;
            this.f273006f = true;
            this.f273007g = -1;
            if (r101 != null) goto L5;
            return;
        L5:
            r101.e(this);
            if (this.f273008h == false) goto L8;
            this.f273004d.b((c) ListProtector.get(r102, this.f273007g));
            ListProtector.set(r102, this.f273007g, this.f273004d);
            this.f273008h = false;
        L8:
            c r103 = this.f273004d;
            if (r103 == null) goto L12;
            r102.add(r103);
            return;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void lineTo(float r100, float r101) {
            this.f273004d.a(r100, r101);
            List<c> r102 = this.f273001a;
            ArrayList r103 = (ArrayList) r102;
            r103.add(this.f273004d);
            c r104 = this.f273004d;
            this.f273004d = new c(r100, r101, r100 - r104.f273009a, r101 - r104.f273010b);
            this.f273008h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void moveTo(float r100, float r101) {
            if (this.f273008h == false) goto L5;
            this.f273004d.b((c) ListProtector.get(this.f273001a, this.f273007g));
            ListProtector.set(this.f273001a, this.f273007g, this.f273004d);
            this.f273008h = false;
        L5:
            c r102 = this.f273004d;
            if (r102 == null) goto L8;
            ((ArrayList) this.f273001a).add(r102);
        L8:
            this.f273002b = r100;
            this.f273003c = r101;
            this.f273004d = new c(r100, r101, 0.0f, 0.0f);
            this.f273007g = ((ArrayList) this.f273001a).size();
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void b(float r100, float r101, float r102, float r103) {
            this.f273004d.a(r100, r101);
            List<c> r104 = this.f273001a;
            ArrayList r105 = (ArrayList) r104;
            r105.add(this.f273004d);
            this.f273004d = new c(r102, r103, r102 - r100, r103 - r101);
            this.f273008h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void cubicTo(float r100, float r101, float r102, float r103, float r104, float r105) {
            if (this.f273006f == false) goto L5;
        L6:
            this.f273004d.a(r100, r101);
            List<c> r106 = this.f273001a;
            ArrayList r107 = (ArrayList) r106;
            r107.add(this.f273004d);
            this.f273005e = false;
        L7:
            this.f273004d = new c(r104, r105, r104 - r102, r105 - r103);
            this.f273008h = false;
            return;
        L5:
            if (this.f273005e == false) goto L7;
            goto L6
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void a(float r110, float r111, float r112, boolean r113, boolean r114, float r115, float r210) {
            this.f273005e = true;
            this.f273006f = false;
            c r100 = this.f273004d;
            d.a(r100.f273009a, r100.f273010b, r110, r111, r112, r113, r114, r115, r210, this);
            this.f273006f = true;
            this.f273008h = false;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f273009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f273010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f273011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f273012d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f273013e;

        public final String toString() {
            return "(" + this.f273009a + "," + this.f273010b + " " + this.f273011c + "," + this.f273012d + ")";
        }

        public final void b(c r100) {
            float r101 = r100.f273011c;
            float r102 = this.f273011c;
            if (r101 != (-r102)) goto L7;
            float r103 = r100.f273012d;
            if (r103 != (-this.f273012d)) goto L7;
            this.f273013e = true;
            this.f273011c = -r103;
            this.f273012d = r100.f273011c;
            return;
        L7:
            this.f273011c = r102 + r101;
            this.f273012d += r100.f273012d;
        }

        public final void a(float r100, float r101) {
            float r102 = r100 - this.f273009a;
            float r103 = r101 - this.f273010b;
            double r104 = Math.sqrt((r102 * r102) + (r103 * r103));
            if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
            r102 = (float) (((double) r102) / r104);
            r103 = (float) (((double) r103) / r104);
        L5:
            float r105 = this.f273011c;
            if (r102 == (-r105)) goto L8;
        L10:
            this.f273011c = r105 + r102;
            this.f273012d += r103;
            return;
        L8:
            if (r103 != (-this.f273012d)) goto L10;
            this.f273013e = true;
            this.f273011c = -r103;
            this.f273012d = r102;
        }

        public c(float r100, float r101, float r102, float r103) {
            this.f273011c = 0.0f;
            this.f273012d = 0.0f;
            this.f273013e = false;
            this.f273009a = r100;
            this.f273010b = r101;
            double r104 = Math.sqrt((r102 * r102) + (r103 * r103));
            if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
            this.f273011c = (float) (((double) r102) / r104);
            this.f273012d = (float) (((double) r103) / r104);
            return;
        }
    }

    /* JADX INFO: renamed from: com.caverock.androidsvg.d$d, reason: collision with other inner class name */
    public class C3816d implements SVG.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f273014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f273015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f273016c;

        @Override // com.caverock.androidsvg.SVG.w
        public final void close() {
            this.f273014a.close();
        }

        public C3816d(SVG.v r100) {
            this.f273014a = new Path();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.e(this);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void lineTo(float r100, float r101) {
            this.f273014a.lineTo(r100, r101);
            this.f273015b = r100;
            this.f273016c = r101;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void moveTo(float r100, float r101) {
            this.f273014a.moveTo(r100, r101);
            this.f273015b = r100;
            this.f273016c = r101;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void b(float r100, float r101, float r102, float r103) {
            this.f273014a.quadTo(r100, r101, r102, r103);
            this.f273015b = r102;
            this.f273016c = r103;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void cubicTo(float r100, float r101, float r110, float r111, float r112, float r113) {
            this.f273014a.cubicTo(r100, r101, r110, r111, r112, r113);
            this.f273015b = r112;
            this.f273016c = r113;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void a(float r110, float r111, float r112, boolean r113, boolean r114, float r115, float r116) {
            d.a(this.f273015b, this.f273016c, r110, r111, r112, r113, r114, r115, r116, this);
            this.f273015b = r115;
            this.f273016c = r116;
        }
    }

    public class e extends f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Path f273017d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f273018e;

        @Override // com.caverock.androidsvg.d.f, com.caverock.androidsvg.d.j
        public final void b(String r110) {
            if (this.f273018e.V() == false) goto L10;
            d r100 = this.f273018e;
            h r101 = r100.f272994d;
            if (r101.f273027b == false) goto L7;
            r100.f272991a.drawTextOnPath(r110, this.f273017d, this.f273019a, this.f273020b, r101.f273029d);
        L7:
            d r102 = this.f273018e;
            h r103 = r102.f272994d;
            if (r103.f273028c == false) goto L10;
            r102.f272991a.drawTextOnPath(r110, this.f273017d, this.f273019a, this.f273020b, r103.f273030e);
        L10:
            this.f273019a += this.f273018e.f272994d.f273029d.measureText(r110);
        }

        public e(d r100, Path r101, float r102) {
            this.f273018e = r100;
            super(r100, r102, 0.0f);
            this.f273017d = r101;
        }
    }

    public class f extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f273019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f273020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f273021c;

        @Override // com.caverock.androidsvg.d.j
        public void b(String r100) {
            if (this.f273021c.V() == false) goto L10;
            d r101 = this.f273021c;
            h r102 = r101.f272994d;
            if (r102.f273027b == false) goto L7;
            r101.f272991a.drawText(r100, this.f273019a, this.f273020b, r102.f273029d);
        L7:
            d r103 = this.f273021c;
            h r104 = r103.f272994d;
            if (r104.f273028c == false) goto L10;
            r103.f272991a.drawText(r100, this.f273019a, this.f273020b, r104.f273030e);
        L10:
            this.f273019a += this.f273021c.f272994d.f273029d.measureText(r100);
        }

        public f(d r100, float r101, float r102) {
            this.f273021c = r100;
            this.f273019a = r101;
            this.f273020b = r102;
        }
    }

    public class g extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f273022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f273023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Path f273024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f273025d;

        @Override // com.caverock.androidsvg.d.j
        public final boolean a(SVG.w0 r100) {
            if ((r100 instanceof SVG.x0) == false) goto L6;
            String.format("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        L6:
            return true;
        }

        @Override // com.caverock.androidsvg.d.j
        public final void b(String r100) {
            if (this.f273025d.V() == false) goto L5;
            Path r101 = new Path();
            this.f273025d.f272994d.f273029d.getTextPath(r100, 0, r100.length(), this.f273022a, this.f273023b, r101);
            this.f273024c.addPath(r101);
        L5:
            this.f273022a += this.f273025d.f272994d.f273029d.measureText(r100);
        }

        public g(d r100, float r101, float r102, Path r103) {
            this.f273025d = r100;
            this.f273022a = r101;
            this.f273023b = r102;
            this.f273024c = r103;
        }
    }

    public class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SVG.Style f273026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f273027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f273028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f273029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f273030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SVG.b f273031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SVG.b f273032g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f273033h;

        public h() {
            Paint r100 = new Paint();
            this.f273029d = r100;
            r100.setFlags(193);
            r100.setHinting(0);
            r100.setStyle(Paint.Style.FILL);
            r100.setTypeface(Typeface.DEFAULT);
            Paint r101 = new Paint();
            this.f273030e = r101;
            r101.setFlags(193);
            r101.setHinting(0);
            r101.setStyle(Paint.Style.STROKE);
            r101.setTypeface(Typeface.DEFAULT);
            this.f273026a = SVG.Style.a();
        }

        public h(h r100) {
            this.f273027b = r100.f273027b;
            this.f273028c = r100.f273028c;
            this.f273029d = new Paint(r100.f273029d);
            this.f273030e = new Paint(r100.f273030e);
            SVG.b r101 = r100.f273031f;
            if (r101 == null) goto L5;
            this.f273031f = new SVG.b(r101);
        L5:
            SVG.b r102 = r100.f273032g;
            if (r102 == null) goto L8;
            this.f273032g = new SVG.b(r102);
        L8:
            this.f273033h = r100.f273033h;
            this.f273026a = (SVG.Style) r100.f273026a.clone();     // Catch: CloneNotSupportedException -> L11
            return;
        L11:
            this.f273026a = SVG.Style.a();
        }
    }

    public class i extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f273034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f273035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f273036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f273037d;

        @Override // com.caverock.androidsvg.d.j
        public final boolean a(SVG.w0 r100) {
            if ((r100 instanceof SVG.x0) == false) goto L13;
            SVG.x0 r101 = (SVG.x0) r100;
            SVG.j0 r102 = r100.f272872a.h(r101.f272922o);
            if (r102 != null) goto L8;
            String.format("TextPath path reference '%s' not found", new Object[]{r101.f272922o});
            return false;
        L8:
            SVG.u r103 = (SVG.u) r102;
            Path r104 = new C3816d(r103.f272908o).f273014a;
            Matrix r105 = r103.f272866n;
            if (r105 == null) goto L11;
            r104.transform(r105);
        L11:
            RectF r106 = new RectF();
            r104.computeBounds(r106, true);
            this.f273036c.union(r106);
            return false;
        L13:
            return true;
        }

        @Override // com.caverock.androidsvg.d.j
        public final void b(String r100) {
            if (this.f273037d.V() == false) goto L5;
            Rect r101 = new Rect();
            this.f273037d.f272994d.f273029d.getTextBounds(r100, 0, r100.length(), r101);
            RectF r102 = new RectF(r101);
            r102.offset(this.f273034a, this.f273035b);
            this.f273036c.union(r102);
        L5:
            this.f273034a += this.f273037d.f272994d.f273029d.measureText(r100);
        }

        public i(d r100, float r101, float r102) {
            this.f273037d = r100;
            this.f273036c = new RectF();
            this.f273034a = r101;
            this.f273035b = r102;
        }
    }

    public abstract class j {
        public boolean a(SVG.w0 r100) {
            return true;
        }

        public abstract void b(String r100);

        public j() {
        }
    }

    public class k extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f273038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f273039b;

        public k(d r100) {
            this.f273039b = r100;
            this.f273038a = 0.0f;
        }

        @Override // com.caverock.androidsvg.d.j
        public final void b(String r100) {
            this.f273038a += this.f273039b.f272994d.f273029d.measureText(r100);
        }
    }

    public final boolean E() {
        if (this.f272994d.f273026a.f272774m.floatValue() >= 1.0f) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        return false;
    L11:
        Canvas r101 = this.f272991a;
        int r102 = (int) (this.f272994d.f273026a.f272774m.floatValue() * 256.0f);
        if (r102 >= 0) goto L15;
        r102 = 0;
    L17:
        r101.saveLayerAlpha(null, r102, 31);
        this.f272995e.push(this.f272994d);
        h r103 = new h(this.f272994d);
        this.f272994d = r103;
        String r104 = r103.f273026a.G;
        if (r104 == null) goto L24;
        SVG.j0 r105 = this.f272993c.h(r104);
        if (r105 != null) goto L22;
    L23:
        String.format("Mask reference '%s' not found", new Object[]{this.f272994d.f273026a.G});
        this.f272994d.f273026a.G = null;
        goto L24
    L22:
        if ((r105 instanceof SVG.r) == false) goto L23;
    L24:
        return true;
    L15:
        if (r102 <= 255) goto L17;
        r102 = 255;
        goto L17
    L5:
        if (this.f272994d.f273026a.G != null) goto L8;
        r100 = false;
        goto L9
    }

    public final void O() {
        this.f272991a.restore();
        this.f272994d = this.f272995e.pop();
    }

    public final void P() {
        this.f272991a.save();
        this.f272995e.push(this.f272994d);
        this.f272994d = new h(this.f272994d);
    }

    public final void U() {
        SVG.Style r100 = this.f272994d.f273026a;
        SVG.m0 r101 = r100.f272761J;
        if ((r101 instanceof SVG.f) == false) goto L6;
        int r102 = ((SVG.f) r101).f272838a;
    L8:
        Float r103 = r100.K;
        if (r103 == null) goto L11;
        r102 = i(r102, r103.floatValue());
    L11:
        this.f272991a.drawColor(r102);
        return;
    L6:
        if ((r101 instanceof SVG.g) == false) goto L13;
        r102 = r100.f272775n.f272838a;
        goto L8
    }

    public final boolean V() {
        Boolean r100 = this.f272994d.f273026a.B;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.booleanValue();
    }

    public final boolean k() {
        Boolean r100 = this.f272994d.f273026a.A;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.booleanValue();
    }

    public final SVG.Style.TextAnchor u() {
        SVG.Style r100 = this.f272994d.f273026a;
        if (r100.f272781t == SVG.Style.TextDirection.LTR) goto L12;
        SVG.Style.TextAnchor r101 = r100.f272782u;
        if (r101 == SVG.Style.TextAnchor.Middle) goto L12;
        SVG.Style.TextAnchor r102 = SVG.Style.TextAnchor.Start;
        if (r101 == r102) goto L10;
        return r102;
    L10:
        return SVG.Style.TextAnchor.End;
    L12:
        return r100.f272782u;
    }

    public final Path.FillType v() {
        SVG.Style.FillRule r100 = this.f272994d.f273026a.F;
        if (r100 == null) goto L9;
        if (r100 != SVG.Style.FillRule.EvenOdd) goto L9;
        return Path.FillType.EVEN_ODD;
    L9:
        return Path.FillType.WINDING;
    }

    public static SVG.b c(Path r100) {
        RectF r101 = new RectF();
        r100.computeBounds(r101, true);
        return new SVG.b(r101.left, r101.top, r101.width(), r101.height());
    }

    public static Path z(SVG.y r100) {
        Path r101 = new Path();
        float[] r102 = r100.f272925o;
        r101.moveTo(r102[0], r102[1]);
        int r103 = 2;
    L3:
        float[] r104 = r100.f272925o;
        if (r103 >= r104.length) goto L7;
        r101.lineTo(r104[r103], r104[r103 + 1]);
        r103 = r103 + 2;
        goto L3
    L7:
        if ((r100 instanceof SVG.z) == false) goto L10;
        r101.close();
    L10:
        if (r100.f272855h != null) goto L12;
        r100.f272855h = c(r101);
    L12:
        return r101;
    }

    public final Path A(SVG.a0 r210) {
        SVG.o r100 = r210.f272811s;
        if (r100 == null) goto L5;
    L7:
        if (r100 != null) goto L11;
        float r101 = r210.f272812t.e(this);
    L9:
        float r102 = r101;
    L14:
        float r103 = Math.min(r101, r210.f272809q.d(this) / 2.0f);
        float r104 = Math.min(r102, r210.f272810r.e(this) / 2.0f);
        SVG.o r105 = r210.f272807o;
        if (r105 == null) goto L17;
        float r106 = r105.d(this);
    L18:
        SVG.o r107 = r210.f272808p;
        if (r107 == null) goto L21;
        float r110 = r107.e(this);
    L22:
        float r108 = r210.f272809q.d(this);
        float r109 = r210.f272810r.e(this);
        if (r210.f272855h != null) goto L25;
        r210.f272855h = new SVG.b(r106, r110, r108, r109);
    L25:
        float r111 = r106 + r108;
        float r112 = r110 + r109;
        Path r113 = new Path();
        if (r103 != 0.0f) goto L28;
    L31:
        Path r114 = r113;
        r114.moveTo(r106, r110);
        r114.lineTo(r111, r110);
        r114.lineTo(r111, r112);
        r114.lineTo(r106, r112);
        r114.lineTo(r106, r110);
    L32:
        r114.close();
        return r114;
    L28:
        if (r104 == 0.0f) goto L31;
        float r115 = r103 * 0.5522848f;
        float r116 = 0.5522848f * r104;
        float r117 = r110 + r104;
        r113.moveTo(r106, r117);
        float r118 = r117 - r116;
        float r119 = r106 + r103;
        float r211 = r119 - r115;
        r113.cubicTo(r106, r118, r211, r110, r119, r110);
        float r120 = r111 - r103;
        r113.lineTo(r120, r110);
        float r121 = r120 + r115;
        r113.cubicTo(r121, r110, r111, r118, r111, r117);
        float r122 = r112 - r104;
        r113.lineTo(r111, r122);
        float r123 = r122 + r116;
        r114 = r113;
        r113.cubicTo(r111, r123, r121, r112, r120, r112);
        r114.lineTo(r119, r112);
        r114.cubicTo(r211, r112, r106, r123, r106, r122);
        r114.lineTo(r106, r117);
        goto L32
    L21:
        r110 = 0.0f;
        goto L22
    L17:
        r106 = 0.0f;
        goto L18
    L11:
        if (r210.f272812t != null) goto L13;
        r101 = r100.d(this);
        goto L9
    L13:
        r101 = r100.d(this);
        r102 = r210.f272812t.e(this);
        goto L14
    L5:
        if (r210.f272812t != null) goto L7;
        r101 = 0.0f;
        r102 = 0.0f;
        goto L14
    }

    public final void D(SVG.b r100) {
        if (this.f272994d.f273026a.G == null) goto L5;
        Paint r101 = new Paint();
        r101.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f272991a.saveLayer(null, r101, 31);
        Paint r102 = new Paint();
        r102.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
        this.f272991a.saveLayer(null, r102, 31);
        SVG.r r103 = (SVG.r) this.f272993c.h(this.f272994d.f273026a.G);
        L(r103, r100);
        this.f272991a.restore();
        Paint r104 = new Paint();
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f272991a.saveLayer(null, r104, 31);
        L(r103, r100);
        this.f272991a.restore();
        this.f272991a.restore();
    L5:
        O();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G(SVG.l0 r110) {
        if ((r110 instanceof SVG.s) == false) goto L5;
        return;
    L5:
        P();
        if ((r110 instanceof SVG.j0) == false) goto L12;
        Boolean r100 = ((SVG.j0) r110).f272862d;
        if (r100 == null) goto L12;
        this.f272994d.f273033h = r100.booleanValue();
    L12:
        if ((r110 instanceof SVG.d0) == false) goto L14;
        SVG.d0 r111 = (SVG.d0) r110;
        F(r111, B(r111.f272831q, r111.f272832r, r111.f272833s, r111.f272834t), r111.f272892p, r111.f272880o);
    L469:
        O();
        return;
    L14:
        float r101 = 0.0f;
        Bitmap r102 = null;
        int r103 = 0;
        if ((r110 instanceof SVG.b1) == false) goto L82;
        SVG.b1 r112 = (SVG.b1) r110;
        SVG.o r104 = r112.f272821s;
        if (r104 != null) goto L19;
    L20:
        SVG.o r105 = r112.f272822t;
        if (r105 != null) goto L23;
    L25:
        T(this.f272994d, r112);
        if (k() == false) goto L469;
        SVG.l0 r106 = r112.f272872a.h(r112.f272818p);
        if (r106 != null) goto L31;
        String.format("Use reference '%s' not found", new Object[]{r112.f272818p});
        goto L469
    L31:
        Matrix r107 = r112.f272871o;
        if (r107 == null) goto L34;
        this.f272991a.concat(r107);
    L34:
        SVG.o r108 = r112.f272819q;
        if (r108 == null) goto L37;
        float r109 = r108.d(this);
    L38:
        SVG.o r113 = r112.f272820r;
        if (r113 == null) goto L41;
        float r114 = r113.e(this);
    L42:
        this.f272991a.translate(r109, r114);
        f(r112, r112.f272855h);
        boolean r115 = E();
        this.f272996f.push(r112);
        this.f272997g.push(this.f272991a.getMatrix());
        if ((r106 instanceof SVG.d0) == false) goto L46;
        SVG.d0 r116 = (SVG.d0) r106;
        SVG.b r117 = B(null, null, r112.f272821s, r112.f272822t);
        P();
        F(r116, r117, r116.f272892p, r116.f272880o);
        O();
    L77:
        this.f272996f.pop();
        this.f272997g.pop();
        if (r115 == false) goto L80;
        D(r112.f272855h);
    L80:
        R(r112);
        goto L469
    L46:
        if ((r106 instanceof SVG.r0) == false) goto L76;
        SVG.o r118 = r112.f272821s;
        if (r118 != null) goto L51;
        r118 = new SVG.o(100.0f, SVG.Unit.percent);
    L51:
        SVG.o r119 = r112.f272822t;
        if (r119 != null) goto L55;
        r119 = new SVG.o(100.0f, SVG.Unit.percent);
    L55:
        SVG.b r120 = B(null, null, r118, r119);
        P();
        SVG.r0 r121 = (SVG.r0) r106;
        if (r120.f272816c != 0.0f) goto L58;
    L75:
        O();
        goto L77
    L58:
        if (r120.f272817d == 0.0f) goto L75;
        PreserveAspectRatio r122 = r121.f272880o;
        if (r122 != null) goto L64;
        r122 = PreserveAspectRatio.f272751d;
    L64:
        T(this.f272994d, r121);
        h r123 = this.f272994d;
        r123.f273031f = r120;
        if (r123.f273026a.f272783v.booleanValue() == true) goto L67;
        SVG.b r124 = this.f272994d.f273031f;
        M(r124.f272814a, r124.f272815b, r124.f272816c, r124.f272817d);
    L67:
        SVG.b r125 = r121.f272892p;
        if (r125 == null) goto L70;
        this.f272991a.concat(e(this.f272994d.f273031f, r125, r122));
        this.f272994d.f273032g = r121.f272892p;
    L71:
        boolean r126 = E();
        H(r121, true);
        if (r126 == false) goto L74;
        D(r121.f272855h);
    L74:
        R(r121);
        goto L75
    L70:
        Canvas r127 = this.f272991a;
        SVG.b r128 = this.f272994d.f273031f;
        r127.translate(r128.f272814a, r128.f272815b);
        goto L71
    L76:
        G(r106);
        goto L77
    L41:
        r114 = 0.0f;
        goto L42
    L37:
        r109 = 0.0f;
        goto L38
    L23:
        if (r105.g() == false) goto L25;
    L19:
        if (r104.g() == true) goto L469;
    L82:
        if ((r110 instanceof SVG.q0) == false) goto L133;
        SVG.q0 r129 = (SVG.q0) r110;
        T(this.f272994d, r129);
        if (k() == false) goto L469;
        Matrix r130 = r129.f272871o;
        if (r130 == null) goto L89;
        this.f272991a.concat(r130);
    L89:
        f(r129, r129.f272855h);
        boolean r131 = E();
        String r132 = Locale.getDefault().getLanguage();
        Iterator<SVG.l0> r133 = r129.f272839i.iterator();
    L91:
        if (r133.hasNext() == false) goto L129;
        SVG.l0 r134 = r133.next();
        if ((r134 instanceof SVG.e0) == false) goto L91;
        SVG.e0 r135 = (SVG.e0) r134;
        if (r135.c() != null) goto L91;
        Set<String> r136 = r135.e();
        if (r136 == null) goto L105;
        if (r136.isEmpty() == true) goto L91;
        if (r136.contains(r132) == false) goto L91;
    L105:
        Set<String> r137 = r135.j();
        if (r137 == null) goto L122;
        if (f272990h != null) goto L118;
        monitor-enter(d.class);
        HashSet<String> r138 = new HashSet();     // Catch: Throwable -> L114
        f272990h = r138;     // Catch: Throwable -> L114
        r138.add("Structure");     // Catch: Throwable -> L114
        f272990h.add("BasicStructure");     // Catch: Throwable -> L114
        f272990h.add("ConditionalProcessing");     // Catch: Throwable -> L114
        f272990h.add("Image");     // Catch: Throwable -> L114
        f272990h.add("Style");     // Catch: Throwable -> L114
        f272990h.add("ViewportAttribute");     // Catch: Throwable -> L114
        f272990h.add("Shape");     // Catch: Throwable -> L114
        f272990h.add("BasicText");     // Catch: Throwable -> L114
        f272990h.add("PaintAttribute");     // Catch: Throwable -> L114
        f272990h.add("BasicPaintAttribute");     // Catch: Throwable -> L114
        f272990h.add("OpacityAttribute");     // Catch: Throwable -> L114
        f272990h.add("BasicGraphicsAttribute");     // Catch: Throwable -> L114
        f272990h.add("Marker");     // Catch: Throwable -> L114
        f272990h.add("Gradient");     // Catch: Throwable -> L114
        f272990h.add("Pattern");     // Catch: Throwable -> L114
        f272990h.add("Clip");     // Catch: Throwable -> L114
        f272990h.add("BasicClip");     // Catch: Throwable -> L114
        f272990h.add("Mask");     // Catch: Throwable -> L114
        f272990h.add("View");     // Catch: Throwable -> L114
        monitor-exit(d.class);
    L114:
        th = move-exception;
        throw th;
    L118:
        if (r137.isEmpty() == true) goto L91;
        if (f272990h.containsAll(r137) == false) goto L91;
    L122:
        Set<String> r139 = r135.d();
        if (r139 != null) goto L124;
        Set<String> r140 = r135.g();
        if (r140 == null) goto L128;
        r140.isEmpty();
        goto L91
    L128:
        G(r134);
        goto L129
    L124:
        r139.isEmpty();
    L129:
        if (r131 == false) goto L131;
        D(r129.f272855h);
    L131:
        R(r129);
        goto L469
    L133:
        if ((r110 instanceof SVG.l) == false) goto L145;
        SVG.l r141 = (SVG.l) r110;
        T(this.f272994d, r141);
        if (k() == false) goto L469;
        Matrix r142 = r141.f272871o;
        if (r142 == null) goto L140;
        this.f272991a.concat(r142);
    L140:
        f(r141, r141.f272855h);
        boolean r143 = E();
        H(r141, true);
        if (r143 == false) goto L143;
        D(r141.f272855h);
    L143:
        R(r141);
        goto L469
    L145:
        if ((r110 instanceof SVG.n) == false) goto L208;
        SVG.n r144 = (SVG.n) r110;
        SVG.o r145 = r144.f272877s;
        if (r145 == null) goto L469;
        if (r145.g() == true) goto L469;
        SVG.o r146 = r144.f272878t;
        if (r146 == null) goto L469;
        if (r146.g() == true) goto L469;
        String r147 = r144.f272874p;
        if (r147 == null) goto L469;
        PreserveAspectRatio r148 = r144.f272880o;
        if (r148 != null) goto L163;
        r148 = PreserveAspectRatio.f272751d;
    L163:
        if (r147.startsWith(fyb.a.KEY_DATA) == true) goto L166;
    L178:
        if (r102 == null) goto L469;
        SVG.b r149 = new SVG.b(0.0f, 0.0f, r102.getWidth(), r102.getHeight());
        T(this.f272994d, r144);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        Matrix r150 = r144.f272879u;
        if (r150 == null) goto L189;
        this.f272991a.concat(r150);
    L189:
        SVG.o r151 = r144.f272875q;
        if (r151 == null) goto L192;
        float r152 = r151.d(this);
    L193:
        SVG.o r153 = r144.f272876r;
        if (r153 == null) goto L196;
        float r154 = r153.e(this);
    L197:
        float r155 = r144.f272877s.d(this);
        float r156 = r144.f272878t.d(this);
        h r157 = this.f272994d;
        r157.f273031f = new SVG.b(r152, r154, r155, r156);
        if (r157.f273026a.f272783v.booleanValue() == true) goto L200;
        SVG.b r158 = this.f272994d.f273031f;
        M(r158.f272814a, r158.f272815b, r158.f272816c, r158.f272817d);
    L200:
        r144.f272855h = this.f272994d.f273031f;
        R(r144);
        f(r144, r144.f272855h);
        boolean r159 = E();
        U();
        this.f272991a.save();
        this.f272991a.concat(e(this.f272994d.f273031f, r149, r148));
        if (this.f272994d.f273026a.M == SVG.Style.RenderQuality.optimizeSpeed) goto L204;
        r103 = 2;
    L204:
        this.f272991a.drawBitmap(r102, 0.0f, 0.0f, new Paint(r103));
        this.f272991a.restore();
        if (r159 == false) goto L469;
        D(r144.f272855h);
        goto L469
    L196:
        r154 = 0.0f;
        goto L197
    L192:
        r152 = 0.0f;
        goto L193
    L166:
        if (r147.length() < 14) goto L178;
        int r160 = r147.indexOf(44);
        if (r160 < 12) goto L178;
        if (";base64".equals(r147.substring(r160 - 7, r160)) == false) goto L178;
        byte[] r161 = Base64.decode(r147.substring(r160 + 1), 0);     // Catch: Exception -> L177
        r102 = BitmapFactory.decodeByteArray(r161, 0, r161.length);     // Catch: Exception -> L177
        goto L178
    L208:
        if ((r110 instanceof SVG.u) == false) goto L245;
        SVG.u r162 = (SVG.u) r110;
        if (r162.f272908o == null) goto L469;
        T(this.f272994d, r162);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        h r163 = this.f272994d;
        if (r163.f273028c == false) goto L221;
    L223:
        Matrix r164 = r162.f272866n;
        if (r164 == null) goto L226;
        this.f272991a.concat(r164);
    L226:
        Path r165 = new C3816d(r162.f272908o).f273014a;
        if (r162.f272855h != null) goto L229;
        r162.f272855h = c(r165);
    L229:
        R(r162);
        g(r162);
        f(r162, r162.f272855h);
        boolean r166 = E();
        h r167 = this.f272994d;
        if (r167.f273027b == false) goto L239;
        SVG.Style.FillRule r168 = r167.f273026a.f272764c;
        if (r168 != null) goto L234;
    L236:
        Path.FillType r169 = Path.FillType.WINDING;
    L237:
        r165.setFillType(r169);
        l(r162, r165);
        goto L239
    L234:
        if (r168 != SVG.Style.FillRule.EvenOdd) goto L236;
        r169 = Path.FillType.EVEN_ODD;
    L239:
        if (this.f272994d.f273028c == false) goto L241;
        m(r165);
    L241:
        K(r162);
        if (r166 == false) goto L469;
        D(r162.f272855h);
        goto L469
    L221:
        if (r163.f273027b == true) goto L223;
    L245:
        if ((r110 instanceof SVG.a0) == false) goto L273;
        SVG.a0 r170 = (SVG.a0) r110;
        SVG.o r171 = r170.f272809q;
        if (r171 == null) goto L469;
        if (r170.f272810r == null) goto L469;
        if (r171.g() == true) goto L469;
        if (r170.f272810r.g() == true) goto L469;
        T(this.f272994d, r170);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        Matrix r172 = r170.f272866n;
        if (r172 == null) goto L264;
        this.f272991a.concat(r172);
    L264:
        Path r173 = A(r170);
        R(r170);
        g(r170);
        f(r170, r170.f272855h);
        boolean r174 = E();
        if (this.f272994d.f273027b == false) goto L268;
        l(r170, r173);
    L268:
        if (this.f272994d.f273028c == false) goto L270;
        m(r173);
    L270:
        if (r174 == false) goto L469;
        D(r170.f272855h);
        goto L469
    L273:
        if ((r110 instanceof SVG.d) == false) goto L297;
        SVG.d r175 = (SVG.d) r110;
        SVG.o r176 = r175.f272830q;
        if (r176 == null) goto L469;
        if (r176.g() == true) goto L469;
        T(this.f272994d, r175);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        Matrix r177 = r175.f272866n;
        if (r177 == null) goto L288;
        this.f272991a.concat(r177);
    L288:
        Path r178 = x(r175);
        R(r175);
        g(r175);
        f(r175, r175.f272855h);
        boolean r179 = E();
        if (this.f272994d.f273027b == false) goto L292;
        l(r175, r178);
    L292:
        if (this.f272994d.f273028c == false) goto L294;
        m(r178);
    L294:
        if (r179 == false) goto L469;
        D(r175.f272855h);
        goto L469
    L297:
        if ((r110 instanceof SVG.i) == false) goto L325;
        SVG.i r180 = (SVG.i) r110;
        SVG.o r181 = r180.f272853q;
        if (r181 == null) goto L469;
        if (r180.f272854r == null) goto L469;
        if (r181.g() == true) goto L469;
        if (r180.f272854r.g() == true) goto L469;
        T(this.f272994d, r180);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        Matrix r182 = r180.f272866n;
        if (r182 == null) goto L316;
        this.f272991a.concat(r182);
    L316:
        Path r183 = y(r180);
        R(r180);
        g(r180);
        f(r180, r180.f272855h);
        boolean r184 = E();
        if (this.f272994d.f273027b == false) goto L320;
        l(r180, r183);
    L320:
        if (this.f272994d.f273028c == false) goto L322;
        m(r183);
    L322:
        if (r184 == false) goto L469;
        D(r180.f272855h);
        goto L469
    L325:
        if ((r110 instanceof SVG.p) == false) goto L361;
        SVG.p r185 = (SVG.p) r110;
        T(this.f272994d, r185);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        if (this.f272994d.f273028c == false) goto L469;
        Matrix r186 = r185.f272866n;
        if (r186 == null) goto L338;
        this.f272991a.concat(r186);
    L338:
        SVG.o r187 = r185.f272888o;
        if (r187 != null) goto L341;
        float r188 = 0.0f;
    L342:
        SVG.o r189 = r185.f272889p;
        if (r189 != null) goto L345;
        float r190 = 0.0f;
    L346:
        SVG.o r191 = r185.f272890q;
        if (r191 != null) goto L349;
        float r192 = 0.0f;
    L350:
        SVG.o r193 = r185.f272891r;
        if (r193 == null) goto L355;
        r101 = r193.e(this);
    L355:
        if (r185.f272855h != null) goto L357;
        r185.f272855h = new SVG.b(Math.min(r188, r192), Math.min(r190, r101), Math.abs(r192 - r188), Math.abs(r101 - r190));
    L357:
        Path r194 = new Path();
        r194.moveTo(r188, r190);
        r194.lineTo(r192, r101);
        R(r185);
        g(r185);
        f(r185, r185.f272855h);
        boolean r195 = E();
        m(r194);
        K(r185);
        if (r195 == false) goto L469;
        D(r185.f272855h);
        goto L469
    L349:
        r192 = r191.d(this);
        goto L350
    L345:
        r190 = r189.e(this);
        goto L346
    L341:
        r188 = r187.d(this);
        goto L342
    L361:
        if ((r110 instanceof SVG.z) == false) goto L389;
        SVG.z r196 = (SVG.z) r110;
        T(this.f272994d, r196);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        h r197 = this.f272994d;
        if (r197.f273028c == false) goto L371;
    L373:
        Matrix r198 = r196.f272866n;
        if (r198 == null) goto L377;
        this.f272991a.concat(r198);
    L377:
        if (r196.f272925o.length < 2) goto L469;
        Path r199 = z(r196);
        R(r196);
        g(r196);
        f(r196, r196.f272855h);
        boolean r200 = E();
        if (this.f272994d.f273027b == false) goto L383;
        l(r196, r199);
    L383:
        if (this.f272994d.f273028c == false) goto L385;
        m(r199);
    L385:
        K(r196);
        if (r200 == false) goto L469;
        D(r196.f272855h);
        goto L469
    L371:
        if (r197.f273027b == true) goto L373;
    L389:
        if ((r110 instanceof SVG.y) == false) goto L423;
        SVG.y r1100 = (SVG.y) r110;
        T(this.f272994d, r1100);
        if (k() == false) goto L469;
        if (V() == false) goto L469;
        h r201 = this.f272994d;
        if (r201.f273028c == false) goto L399;
    L401:
        Matrix r202 = r1100.f272866n;
        if (r202 == null) goto L405;
        this.f272991a.concat(r202);
    L405:
        if (r1100.f272925o.length < 2) goto L469;
        Path r203 = z(r1100);
        R(r1100);
        SVG.Style.FillRule r204 = this.f272994d.f273026a.f272764c;
        if (r204 != null) goto L410;
    L412:
        Path.FillType r205 = Path.FillType.WINDING;
    L413:
        r203.setFillType(r205);
        g(r1100);
        f(r1100, r1100.f272855h);
        boolean r206 = E();
        if (this.f272994d.f273027b == false) goto L417;
        l(r1100, r203);
    L417:
        if (this.f272994d.f273028c == false) goto L419;
        m(r203);
    L419:
        K(r1100);
        if (r206 == false) goto L469;
        D(r1100.f272855h);
        goto L469
    L410:
        if (r204 != SVG.Style.FillRule.EvenOdd) goto L412;
        r205 = Path.FillType.EVEN_ODD;
        goto L413
    L399:
        if (r201.f273027b == true) goto L401;
    L423:
        if ((r110 instanceof SVG.u0) == false) goto L469;
        SVG.u0 r1101 = (SVG.u0) r110;
        T(this.f272994d, r1101);
        if (k() == false) goto L469;
        Matrix r207 = r1101.f272909s;
        if (r207 == null) goto L430;
        this.f272991a.concat(r207);
    L430:
        List<SVG.o> r208 = r1101.f272926o;
        if (r208 != null) goto L433;
    L436:
        float r209 = 0.0f;
    L437:
        List<SVG.o> r210 = r1101.f272927p;
        if (r210 != null) goto L440;
    L443:
        float r211 = 0.0f;
    L444:
        List<SVG.o> r212 = r1101.f272928q;
        if (r212 != null) goto L447;
    L450:
        float r213 = 0.0f;
    L451:
        List<SVG.o> r214 = r1101.f272929r;
        if (r214 != null) goto L454;
    L457:
        SVG.Style.TextAnchor r215 = u();
        if (r215 == SVG.Style.TextAnchor.Start) goto L464;
        float r216 = d(r1101);
        if (r215 != SVG.Style.TextAnchor.Middle) goto L462;
        r216 = r216 / 2.0f;
    L462:
        r209 = r209 - r216;
    L464:
        if (r1101.f272855h != null) goto L466;
        i r217 = new i(this, r209, r211);
        n(r1101, r217);
        RectF r218 = r217.f273036c;
        r1101.f272855h = new SVG.b(r218.left, r218.top, r218.width(), r217.f273036c.height());
    L466:
        R(r1101);
        g(r1101);
        f(r1101, r1101.f272855h);
        boolean r219 = E();
        n(r1101, new f(this, r209 + r213, r211 + r101));
        if (r219 == false) goto L469;
        D(r1101.f272855h);
        goto L469
    L454:
        if (((ArrayList) r214).size() == 0) goto L457;
        r101 = ((SVG.o) ListProtector.get(r1101.f272929r, 0)).e(this);
        goto L457
    L447:
        if (((ArrayList) r212).size() == 0) goto L450;
        r213 = ((SVG.o) ListProtector.get(r1101.f272928q, 0)).d(this);
        goto L451
    L440:
        if (((ArrayList) r210).size() == 0) goto L443;
        r211 = ((SVG.o) ListProtector.get(r1101.f272927p, 0)).e(this);
        goto L444
    L433:
        if (((ArrayList) r208).size() == 0) goto L436;
        r209 = ((SVG.o) ListProtector.get(r1101.f272926o, 0)).d(this);
        goto L437
    }

    public final void K(SVG.k r110) {
        SVG.Style r100 = this.f272994d.f273026a;
        String r101 = r100.f272785x;
        if (r101 != null) goto L10;
        if (r100.f272786y != null) goto L10;
        if (r100.f272787z != null) goto L10;
        return;
    L10:
        if (r101 == null) goto L15;
        SVG.j0 r102 = r110.f272872a.h(r101);
        if (r102 == null) goto L14;
        SVG.q r103 = (SVG.q) r102;
    L16:
        String r104 = this.f272994d.f273026a.f272786y;
        if (r104 == null) goto L22;
        SVG.j0 r105 = r110.f272872a.h(r104);
        if (r105 == null) goto L21;
        SVG.q r106 = (SVG.q) r105;
    L23:
        String r107 = this.f272994d.f273026a.f272787z;
        if (r107 == null) goto L29;
        SVG.j0 r108 = r110.f272872a.h(r107);
        if (r108 == null) goto L28;
        SVG.q r109 = (SVG.q) r108;
    L31:
        if ((r110 instanceof SVG.u) == false) goto L34;
        List<c> r111 = new b(this, ((SVG.u) r110).f272908o).f273001a;
    L67:
        if (r111 != null) goto L69;
        return;
    L69:
        int r112 = r111.size();
        if (r112 != 0) goto L72;
        return;
    L72:
        SVG.Style r113 = this.f272994d.f273026a;
        r113.f272787z = null;
        r113.f272786y = null;
        r113.f272785x = null;
        if (r103 == null) goto L75;
        J(r103, (c) ListProtector.get(r111, 0));
    L75:
        if (r106 != null) goto L77;
    L98:
        if (r109 == null) goto L108;
        J(r109, (c) ListProtector.get(r111, r112 - 1));
        return;
    L108:
        return;
    L77:
        if (r111.size() <= 2) goto L98;
        int r114 = 1;
        c r115 = (c) ListProtector.get(r111, 0);
        c r116 = (c) ListProtector.get(r111, 1);
    L80:
        if (r114 >= (r112 - 1)) goto L98;
        r114 = r114 + 1;
        c r117 = (c) ListProtector.get(r111, r114);
        if (r116.f273013e == false) goto L97;
        float r118 = r116.f273011c;
        float r119 = r116.f273012d;
        float r120 = r116.f273009a;
        float r121 = r120 - r115.f273009a;
        float r122 = r116.f273010b;
        float r123 = (r121 * r118) + ((r122 - r115.f273010b) * r119);
        if (r123 != 0.0f) goto L87;
        r123 = ((r117.f273009a - r120) * r118) + ((r117.f273010b - r122) * r119);
    L87:
        if (r123 > 0.0f) goto L97;
        if (r123 == 0.0f) goto L91;
    L95:
        r116.f273011c = -r118;
        r116.f273012d = -r119;
        goto L97
    L91:
        if (r118 > 0.0f) goto L97;
        if (r119 < 0.0f) goto L95;
    L97:
        J(r106, r116);
        r115 = r116;
        r116 = r117;
        goto L80
    L34:
        if ((r110 instanceof SVG.p) == false) goto L52;
        SVG.p r124 = (SVG.p) r110;
        SVG.o r125 = r124.f272888o;
        if (r125 == null) goto L38;
        float r126 = r125.d(this);
    L39:
        SVG.o r127 = r124.f272889p;
        if (r127 == null) goto L42;
        float r128 = r127.e(this);
    L43:
        SVG.o r129 = r124.f272890q;
        if (r129 == null) goto L46;
        float r130 = r129.d(this);
    L47:
        SVG.o r131 = r124.f272891r;
        if (r131 == null) goto L50;
        float r132 = r131.e(this);
    L51:
        ArrayList r133 = new ArrayList(2);
        float r134 = r130 - r126;
        float r135 = r132 - r128;
        r133.add(new c(r126, r128, r134, r135));
        r133.add(new c(r130, r132, r134, r135));
        r111 = r133;
        goto L67
    L50:
        r132 = 0.0f;
        goto L51
    L46:
        r130 = 0.0f;
        goto L47
    L42:
        r128 = 0.0f;
        goto L43
    L38:
        r126 = 0.0f;
        goto L39
    L52:
        SVG.y r136 = (SVG.y) r110;
        int r137 = r136.f272925o.length;
        if (r137 >= 2) goto L55;
        r111 = null;
        goto L67
    L55:
        ArrayList r138 = new ArrayList();
        float[] r139 = r136.f272925o;
        c r140 = new c(r139[0], r139[1], 0.0f, 0.0f);
        int r141 = 2;
        float r142 = 0.0f;
        float r143 = 0.0f;
    L56:
        if (r141 >= r137) goto L59;
        float[] r144 = r136.f272925o;
        float r145 = r144[r141];
        float r146 = r144[r141 + 1];
        r140.a(r145, r146);
        r138.add(r140);
        r141 = r141 + 2;
        r140 = new c(r145, r146, r145 - r140.f273009a, r146 - r140.f273010b);
        r143 = r146;
        r142 = r145;
        goto L56
    L59:
        if ((r136 instanceof SVG.z) == false) goto L65;
        float[] r147 = r136.f272925o;
        float r148 = r147[0];
        if (r142 == r148) goto L66;
        float r149 = r147[1];
        if (r143 == r149) goto L66;
        r140.a(r148, r149);
        r138.add(r140);
        c r150 = new c(r148, r149, r148 - r140.f273009a, r149 - r140.f273010b);
        r150.b((c) ListProtector.get(r138, 0));
        r138.add(r150);
        ListProtector.set(r138, 0, r150);
    L66:
        r111 = r138;
        goto L67
    L65:
        r138.add(r140);
        goto L66
    L28:
        String.format("Marker reference '%s' not found", new Object[]{this.f272994d.f273026a.f272787z});
    L29:
        r109 = null;
        goto L31
    L21:
        String.format("Marker reference '%s' not found", new Object[]{this.f272994d.f273026a.f272786y});
    L22:
        r106 = null;
        goto L23
    L14:
        String.format("Marker reference '%s' not found", new Object[]{this.f272994d.f273026a.f272785x});
    L15:
        r103 = null;
        goto L16
    }

    public final void R(SVG.i0 r110) {
        if (r110.f272873b != null) goto L6;
        return;
    L6:
        if (r110.f272855h != null) goto L8;
        return;
    L8:
        Matrix r100 = new Matrix();
        if (this.f272997g.peek().invert(r100) == false) goto L44;
        SVG.b r111 = r110.f272855h;
        float r101 = r111.f272814a;
        float r102 = r111.f272815b;
        float r103 = r111.f272816c + r101;
        int r104 = 2;
        float r105 = r102 + r111.f272817d;
        float[] r106 = {r101, r102, r103, r102, r103, r105, r101, r105};
        r100.preConcat(this.f272991a.getMatrix());
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
        SVG.i0 r114 = (SVG.i0) this.f272996f.peek();
        SVG.b r115 = r114.f272855h;
        if (r115 != null) goto L28;
        float r116 = r109.left;
        float r117 = r109.top;
        r114.f272855h = new SVG.b(r116, r117, r109.right - r116, r109.bottom - r117);
        return;
    L28:
        float r118 = r109.left;
        float r119 = r109.top;
        float r120 = r109.right - r118;
        float r121 = r109.bottom - r119;
        if (r118 >= r115.f272814a) goto L32;
        r115.f272814a = r118;
    L32:
        if (r119 >= r115.f272815b) goto L34;
        r115.f272815b = r119;
    L34:
        float r122 = r118 + r120;
        float r123 = r115.f272814a;
        if (r122 <= (r115.f272816c + r123)) goto L37;
        r115.f272816c = r122 - r123;
    L37:
        float r124 = r119 + r121;
        float r125 = r115.f272815b;
        if (r124 <= (r115.f272817d + r125)) goto L46;
        r115.f272817d = r124 - r125;
        return;
    L46:
        return;
    }

    public final float d(SVG.w0 r100) {
        k r101 = new k(this);
        n(r100, r101);
        return r101.f273038a;
    }

    public final void g(SVG.i0 r100) {
        SVG.m0 r101 = this.f272994d.f273026a.f272763b;
        if ((r101 instanceof SVG.t) == false) goto L5;
        j(true, r100.f272855h, (SVG.t) r101);
    L5:
        SVG.m0 r102 = this.f272994d.f273026a.f272766e;
        if ((r102 instanceof SVG.t) == false) goto L9;
        j(false, r100.f272855h, (SVG.t) r102);
        return;
    }

    public final void m(Path r100) {
        h r101 = this.f272994d;
        if (r101.f273026a.L != SVG.Style.VectorEffect.NonScalingStroke) goto L10;
        Matrix r102 = this.f272991a.getMatrix();
        Path r103 = new Path();
        r100.transform(r102, r103);
        this.f272991a.setMatrix(new Matrix());
        Shader r104 = this.f272994d.f273030e.getShader();
        Matrix r105 = new Matrix();
        if (r104 == null) goto L7;
        r104.getLocalMatrix(r105);
        Matrix r106 = new Matrix(r105);
        r106.postConcat(r102);
        r104.setLocalMatrix(r106);
    L7:
        this.f272991a.drawPath(r103, this.f272994d.f273030e);
        this.f272991a.setMatrix(r102);
        if (r104 == null) goto L12;
        r104.setLocalMatrix(r105);
        return;
    L12:
        return;
    L10:
        this.f272991a.drawPath(r100, r101.f273030e);
    }

    public final h s(SVG.l0 r100) {
        h r101 = new h();
        S(r101, SVG.Style.a());
        t(r100, r101);
        return r101;
    }

    public final Path x(SVG.d r210) {
        SVG.o r100 = r210.f272828o;
        float r101 = 0.0f;
        if (r100 == null) goto L5;
        float r102 = r100.d(this);
    L6:
        SVG.o r103 = r210.f272829p;
        if (r103 == null) goto L9;
        r101 = r103.e(this);
    L9:
        float r104 = r210.f272830q.b(this);
        float r110 = r102 - r104;
        float r111 = r101 - r104;
        float r112 = r102 + r104;
        float r113 = r101 + r104;
        if (r210.f272855h != null) goto L12;
        float r105 = 2.0f * r104;
        r210.f272855h = new SVG.b(r110, r111, r105, r105);
    L12:
        float r106 = 0.5522848f * r104;
        Path r114 = new Path();
        r114.moveTo(r102, r111);
        float r115 = r102 + r106;
        float r116 = r101 - r106;
        r114.cubicTo(r115, r111, r112, r116, r112, r101);
        float r117 = r101 + r106;
        r114.cubicTo(r112, r117, r115, r113, r102, r113);
        float r107 = r102 - r106;
        r114.cubicTo(r107, r113, r110, r117, r110, r101);
        r114.cubicTo(r110, r116, r107, r111, r102, r111);
        r114.close();
        return r114;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final Path y(SVG.i r210) {
        SVG.o r100 = r210.f272851o;
        float r101 = 0.0f;
        if (r100 == null) goto L5;
        float r102 = r100.d(this);
    L6:
        SVG.o r103 = r210.f272852p;
        if (r103 == null) goto L9;
        r101 = r103.e(this);
    L9:
        float r104 = r210.f272853q.d(this);
        float r105 = r210.f272854r.e(this);
        float r110 = r102 - r104;
        float r111 = r101 - r105;
        float r112 = r102 + r104;
        float r113 = r101 + r105;
        if (r210.f272855h != null) goto L12;
        r210.f272855h = new SVG.b(r110, r111, r104 * 2.0f, 2.0f * r105);
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

    public d(Canvas r100, float r101) {
        this.f272991a = r100;
        this.f272992b = r101;
    }

    public static int i(int r100, float r101) {
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

    public static void p(SVG.j r100, String r101) {
        SVG.j0 r102 = r100.f272872a.h(r101);
        if (r102 != null) goto L7;
        String.format("Gradient reference '%s' not found", new Object[]{r101});
        return;
    L7:
        if ((r102 instanceof SVG.j) == true) goto L10;
        String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
        return;
    L10:
        if (r102 != r100) goto L13;
        String.format("Circular reference in gradient href attribute '%s'", new Object[]{r101});
        return;
    L13:
        SVG.j r103 = (SVG.j) r102;
        if (r100.f272857i != null) goto L17;
        r100.f272857i = r103.f272857i;
    L17:
        if (r100.f272858j != null) goto L20;
        r100.f272858j = r103.f272858j;
    L20:
        if (r100.f272859k != null) goto L23;
        r100.f272859k = r103.f272859k;
    L23:
        if (r100.f272856h.isEmpty() == false) goto L46;
        r100.f272856h = r103.f272856h;
    L46:
        if ((r100 instanceof SVG.k0) == false) goto L39;
        SVG.k0 r104 = (SVG.k0) r100;     // Catch: ClassCastException -> L41
        SVG.k0 r105 = (SVG.k0) r102;     // Catch: ClassCastException -> L41
        if (r104.f272867m != null) goto L31;
        r104.f272867m = r105.f272867m;     // Catch: ClassCastException -> L41
    L31:
        if (r104.f272868n != null) goto L34;
        r104.f272868n = r105.f272868n;     // Catch: ClassCastException -> L41
    L34:
        if (r104.f272869o != null) goto L37;
        r104.f272869o = r105.f272869o;     // Catch: ClassCastException -> L41
    L37:
        if (r104.f272870p != null) goto L42;
        r104.f272870p = r105.f272870p;     // Catch: ClassCastException -> L41
        goto L42
    L39:
        q((SVG.o0) r100, (SVG.o0) r102);     // Catch: ClassCastException -> L41
    L42:
        String r106 = r103.f272860l;
        if (r106 == null) goto L47;
        p(r100, r106);
        return;
    }

    public static void q(SVG.o0 r100, SVG.o0 r101) {
        if (r100.f272883m != null) goto L6;
        r100.f272883m = r101.f272883m;
    L6:
        if (r100.f272884n != null) goto L9;
        r100.f272884n = r101.f272884n;
    L9:
        if (r100.f272885o != null) goto L12;
        r100.f272885o = r101.f272885o;
    L12:
        if (r100.f272886p != null) goto L15;
        r100.f272886p = r101.f272886p;
    L15:
        if (r100.f272887q != null) goto L18;
        r100.f272887q = r101.f272887q;
        return;
    }

    public static void r(SVG.x r100, String r101) {
        SVG.j0 r102 = r100.f272872a.h(r101);
        if (r102 != null) goto L7;
        String.format("Pattern reference '%s' not found", new Object[]{r101});
        return;
    L7:
        if ((r102 instanceof SVG.x) == true) goto L10;
        String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
        return;
    L10:
        if (r102 != r100) goto L13;
        String.format("Circular reference in pattern href attribute '%s'", new Object[]{r101});
        return;
    L13:
        SVG.x r103 = (SVG.x) r102;
        if (r100.f272914q != null) goto L17;
        r100.f272914q = r103.f272914q;
    L17:
        if (r100.f272915r != null) goto L20;
        r100.f272915r = r103.f272915r;
    L20:
        if (r100.f272916s != null) goto L23;
        r100.f272916s = r103.f272916s;
    L23:
        if (r100.f272917t != null) goto L26;
        r100.f272917t = r103.f272917t;
    L26:
        if (r100.f272918u != null) goto L29;
        r100.f272918u = r103.f272918u;
    L29:
        if (r100.f272919v != null) goto L32;
        r100.f272919v = r103.f272919v;
    L32:
        if (r100.f272920w != null) goto L35;
        r100.f272920w = r103.f272920w;
    L35:
        if (r100.f272839i.isEmpty() == false) goto L38;
        r100.f272839i = r103.f272839i;
    L38:
        if (r100.f272892p != null) goto L41;
        r100.f272892p = r103.f272892p;
    L41:
        if (r100.f272880o != null) goto L43;
        r100.f272880o = r103.f272880o;
    L43:
        String r104 = r103.f272921x;
        if (r104 == null) goto L47;
        r(r100, r104);
        return;
    }

    public static boolean w(SVG.Style r100, long r101) {
        if ((r100.f272762a & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Path C(SVG.i0 r110, boolean r111) {
        this.f272995e.push(this.f272994d);
        h r100 = new h(this.f272994d);
        this.f272994d = r100;
        T(r100, r110);
        if (k() == true) goto L5;
    L108:
        this.f272994d = this.f272995e.pop();
        return null;
    L5:
        if (V() == false) goto L108;
        if ((r110 instanceof SVG.b1) == false) goto L29;
        if (r111 == true) goto L11;
        String.format("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
    L11:
        SVG.b1 r112 = (SVG.b1) r110;
        SVG.j0 r101 = r110.f272872a.h(r112.f272818p);
        if (r101 != null) goto L16;
        String.format("Use reference '%s' not found", new Object[]{r112.f272818p});
        this.f272994d = this.f272995e.pop();
        return null;
    L16:
        if ((r101 instanceof SVG.i0) == true) goto L19;
        this.f272994d = this.f272995e.pop();
        return null;
    L19:
        Path r102 = C((SVG.i0) r101, false);
        if (r102 != null) goto L23;
        return null;
    L23:
        if (r112.f272855h != null) goto L25;
        r112.f272855h = c(r102);
    L25:
        Matrix r113 = r112.f272871o;
        if (r113 == null) goto L100;
        r102.transform(r113);
    L100:
        if (this.f272994d.f273026a.E == null) goto L104;
        Path r114 = b(r110, r110.f272855h);
        if (r114 == null) goto L104;
        r102.op(r114, Path.Op.INTERSECT);
    L104:
        this.f272994d = this.f272995e.pop();
        return r102;
    L29:
        if ((r110 instanceof SVG.k) == false) goto L58;
        SVG.k r115 = (SVG.k) r110;
        if ((r110 instanceof SVG.u) == false) goto L36;
        r102 = new C3816d(((SVG.u) r110).f272908o).f273014a;
        if (r110.f272855h != null) goto L48;
        r110.f272855h = c(r102);
    L48:
        if (r102 != null) goto L51;
        return null;
    L51:
        if (r115.f272855h != null) goto L53;
        r115.f272855h = c(r102);
    L53:
        Matrix r116 = r115.f272866n;
        if (r116 == null) goto L56;
        r102.transform(r116);
    L56:
        r102.setFillType(v());
        goto L100
    L36:
        if ((r110 instanceof SVG.a0) == false) goto L39;
        r102 = A((SVG.a0) r110);
        goto L48
    L39:
        if ((r110 instanceof SVG.d) == false) goto L42;
        r102 = x((SVG.d) r110);
        goto L48
    L42:
        if ((r110 instanceof SVG.i) == false) goto L45;
        r102 = y((SVG.i) r110);
        goto L48
    L45:
        if ((r110 instanceof SVG.y) == false) goto L47;
        r102 = z((SVG.y) r110);
        goto L48
    L47:
        r102 = null;
        goto L48
    L58:
        if ((r110 instanceof SVG.u0) == false) goto L106;
        SVG.u0 r117 = (SVG.u0) r110;
        List<SVG.o> r103 = r117.f272926o;
        float r104 = 0.0f;
        if (r103 != null) goto L62;
    L65:
        float r105 = 0.0f;
    L66:
        List<SVG.o> r106 = r117.f272927p;
        if (r106 != null) goto L69;
    L72:
        float r107 = 0.0f;
    L73:
        List<SVG.o> r108 = r117.f272928q;
        if (r108 != null) goto L76;
    L79:
        float r109 = 0.0f;
    L80:
        List<SVG.o> r118 = r117.f272929r;
        if (r118 == null) goto L87;
        if (((ArrayList) r118).size() == 0) goto L87;
        r104 = ((SVG.o) ListProtector.get(r117.f272929r, 0)).e(this);
    L87:
        if (this.f272994d.f273026a.f272782u == SVG.Style.TextAnchor.Start) goto L93;
        float r119 = d(r117);
        if (this.f272994d.f273026a.f272782u != SVG.Style.TextAnchor.Middle) goto L91;
        r119 = r119 / 2.0f;
    L91:
        r105 = r105 - r119;
    L93:
        if (r117.f272855h != null) goto L95;
        i r120 = new i(this, r105, r107);
        n(r117, r120);
        RectF r121 = r120.f273036c;
        r117.f272855h = new SVG.b(r121.left, r121.top, r121.width(), r120.f273036c.height());
    L95:
        Path r122 = new Path();
        n(r117, new g(this, r105 + r109, r107 + r104, r122));
        Matrix r123 = r117.f272909s;
        if (r123 == null) goto L98;
        r122.transform(r123);
    L98:
        r122.setFillType(v());
        r102 = r122;
        goto L100
    L76:
        if (((ArrayList) r108).size() == 0) goto L79;
        r109 = ((SVG.o) ListProtector.get(r117.f272928q, 0)).d(this);
        goto L80
    L69:
        if (((ArrayList) r106).size() == 0) goto L72;
        r107 = ((SVG.o) ListProtector.get(r117.f272927p, 0)).e(this);
        goto L73
    L62:
        if (((ArrayList) r103).size() == 0) goto L65;
        r105 = ((SVG.o) ListProtector.get(r117.f272926o, 0)).d(this);
        goto L66
    L106:
        String.format("Invalid %s element found in clipPath definition", new Object[]{r110.n()});
        return null;
    }

    public final void H(SVG.h0 r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f272996f.push(r100);
        this.f272997g.push(this.f272991a.getMatrix());
    L4:
        Iterator<SVG.l0> r102 = r100.getChildren().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        G(r102.next());
        goto L6
    L8:
        if (r101 == false) goto L12;
        this.f272996f.pop();
        this.f272997g.pop();
        return;
    }

    public final void I(SVG r100, com.caverock.androidsvg.c r110) {
        this.f272993c = r100;
        SVG.d0 r101 = r100.f272756a;
        boolean r102 = false;
        if (r101 != null) goto L6;
        String.format("Nothing to render. Document is empty.", new Object[0]);
        return;
    L6:
        String r103 = r110.f272988d;
        if (r103 == null) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L23;
        SVG.j0 r105 = r100.c(r103);
        if (r105 != null) goto L14;
    L21:
        String.format("View element with id \"%s\" not found.", new Object[]{r110.f272988d});
        return;
    L14:
        if ((r105 instanceof SVG.c1) == false) goto L21;
        SVG.c1 r106 = (SVG.c1) r105;
        SVG.b r107 = r106.f272892p;
        if (r107 != null) goto L20;
        String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[]{r110.f272988d});
        return;
    L20:
        PreserveAspectRatio r108 = r106.f272880o;
    L37:
        CSSParser.m r109 = r110.f272985a;
        if (r109 == null) goto L45;
        List<CSSParser.l> r111 = r109.f272743a;
        if (r111 == null) goto L42;
        int r112 = ((ArrayList) r111).size();
    L43:
        if (r112 <= 0) goto L45;
        boolean r113 = true;
    L46:
        if (r113 == false) goto L48;
        r100.f272758c.b(r110.f272985a);
    L48:
        this.f272994d = new h();
        this.f272995e = new Stack();
        S(this.f272994d, SVG.Style.a());
        h r114 = this.f272994d;
        r114.f273031f = null;
        r114.f273033h = false;
        this.f272995e.push(new h(r114));
        this.f272997g = new Stack();
        this.f272996f = new Stack();
        Boolean r115 = r101.f272862d;
        if (r115 == null) goto L51;
        this.f272994d.f273033h = r115.booleanValue();
    L51:
        P();
        SVG.b r116 = new SVG.b(r110.f272989e);
        SVG.o r117 = r101.f272833s;
        if (r117 == null) goto L54;
        r116.f272816c = r117.c(this, r116.f272816c);
    L54:
        SVG.o r118 = r101.f272834t;
        if (r118 == null) goto L57;
        r116.f272817d = r118.c(this, r116.f272817d);
    L57:
        F(r101, r116, r107, r108);
        O();
        CSSParser.m r119 = r110.f272985a;
        if (r119 == null) goto L65;
        List<CSSParser.l> r120 = r119.f272743a;
        if (r120 == null) goto L62;
        int r121 = ((ArrayList) r120).size();
    L63:
        if (r121 <= 0) goto L65;
        r102 = true;
        goto L65
    L62:
        r121 = 0;
    L65:
        if (r102 == false) goto L75;
        CSSParser.m r122 = r100.f272758c;
        CSSParser.Source r123 = CSSParser.Source.RenderOptions;
        List<CSSParser.l> r124 = r122.f272743a;
        if (r124 == null) goto L81;
        Iterator r125 = ((ArrayList) r124).iterator();
    L71:
        if (r125.hasNext() == false) goto L82;
        if (((CSSParser.l) r125.next()).f272742c != r123) goto L71;
        r125.remove();
        goto L71
    L82:
        return;
    L81:
        return;
    L75:
        return;
    L42:
        r112 = 0;
    L45:
        r113 = false;
        goto L46
    L23:
        SVG.b r126 = r110.f272987c;
        if (r126 == null) goto L26;
        boolean r127 = true;
    L27:
        if (r127 == true) goto L30;
        r126 = r101.f272892p;
    L30:
        r107 = r126;
        r108 = r110.f272986b;
        if (r108 == null) goto L33;
        boolean r128 = true;
    L34:
        if (r128 == true) goto L37;
        r108 = r101.f272880o;
        goto L37
    L33:
        r128 = false;
        goto L34
    L26:
        r127 = false;
        goto L27
    L9:
        r104 = false;
        goto L10
    }

    public final void J(SVG.q r110, c r111) {
        P();
        Float r100 = r110.f272898v;
        float r101 = 0.0f;
        if (r100 != null) goto L5;
    L12:
        float r102 = 0.0f;
    L14:
        if (r110.f272893q == false) goto L16;
        float r103 = 1.0f;
    L17:
        this.f272994d = s(r110);
        Matrix r104 = new Matrix();
        r104.preTranslate(r111.f273009a, r111.f273010b);
        r104.preRotate(r102);
        r104.preScale(r103, r103);
        SVG.o r112 = r110.f272894r;
        if (r112 == null) goto L20;
        float r113 = r112.d(this);
    L21:
        SVG.o r105 = r110.f272895s;
        if (r105 == null) goto L24;
        float r106 = r105.e(this);
    L25:
        SVG.o r107 = r110.f272896t;
        float r108 = 3.0f;
        if (r107 == null) goto L28;
        float r109 = r107.d(this);
    L29:
        SVG.o r114 = r110.f272897u;
        if (r114 == null) goto L32;
        r108 = r114.e(this);
    L32:
        SVG.b r115 = r110.f272892p;
        if (r115 == null) goto L71;
        float r116 = r109 / r115.f272816c;
        float r117 = r108 / r115.f272817d;
        PreserveAspectRatio r118 = r110.f272880o;
        if (r118 != null) goto L39;
        r118 = PreserveAspectRatio.f272751d;
    L39:
        if (r118.equals(PreserveAspectRatio.f272750c) == false) goto L41;
    L45:
        r104.preTranslate((-r113) * r116, (-r106) * r117);
        this.f272991a.concat(r104);
        SVG.b r119 = r110.f272892p;
        float r120 = r119.f272816c * r116;
        float r121 = r119.f272817d * r117;
        int[] r122 = a.f272998a;
        switch(r122[r118.f272752a.ordinal()]) {
            case 1: goto L49;
            case 2: goto L49;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L48;
            case 6: goto L48;
            default: goto L47;
        };
    L47:
        float r123 = 0.0f;
    L51:
        int r124 = r122[r118.f272752a.ordinal()];
        if (r124 != 2) goto L54;
    L65:
        float r125 = (r108 - r121) / 2.0f;
    L66:
        r101 = 0.0f - r125;
    L68:
        if (this.f272994d.f273026a.f272783v.booleanValue() == true) goto L70;
        M(r123, r101, r109, r108);
    L70:
        r104.reset();
        r104.preScale(r116, r117);
        this.f272991a.concat(r104);
    L74:
        boolean r126 = E();
        H(r110, false);
        if (r126 == false) goto L77;
        D(r110.f272855h);
    L77:
        O();
        return;
    L54:
        if (r124 != 3) goto L56;
    L64:
        r125 = r108 - r121;
        goto L66
    L56:
        if (r124 == 5) goto L65;
        if (r124 == 6) goto L64;
        if (r124 == 7) goto L65;
        if (r124 == 8) goto L64;
    L48:
        float r127 = r109 - r120;
    L50:
        r123 = 0.0f - r127;
        goto L51
    L49:
        r127 = (r109 - r120) / 2.0f;
        goto L50
    L41:
        if (r118.f272753b != PreserveAspectRatio.Scale.slice) goto L43;
        float r128 = Math.max(r116, r117);
    L44:
        r116 = r128;
        r117 = r116;
        goto L45
    L43:
        r128 = Math.min(r116, r117);
        goto L44
    L71:
        r104.preTranslate(-r113, -r106);
        this.f272991a.concat(r104);
        if (this.f272994d.f273026a.f272783v.booleanValue() == true) goto L74;
        M(0.0f, 0.0f, r109, r108);
        goto L74
    L28:
        r109 = 3.0f;
        goto L29
    L24:
        r106 = 0.0f;
        goto L25
    L20:
        r113 = 0.0f;
        goto L21
    L16:
        r103 = this.f272994d.f273026a.f272768g.a(this.f272992b);
        goto L17
    L5:
        if (Float.isNaN(r100.floatValue()) == false) goto L11;
        float r129 = r111.f273011c;
        if (r129 == 0.0f) goto L9;
    L10:
        r102 = (float) Math.toDegrees(Math.atan2(r111.f273012d, r129));
        goto L14
    L9:
        if (r111.f273012d == 0.0f) goto L12;
    L11:
        r102 = r110.f272898v.floatValue();
        goto L14
    }

    public final void L(SVG.r r100, SVG.b r101) {
        Boolean r102 = r100.f272899o;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L18;
        SVG.o r105 = r100.f272901q;
        if (r105 == null) goto L13;
        float r106 = r105.d(this);
    L14:
        SVG.o r107 = r100.f272902r;
        if (r107 == null) goto L17;
        float r108 = r107.e(this);
    L27:
        if (r106 != 0.0f) goto L29;
        return;
    L29:
        if (r108 == 0.0f) goto L45;
        P();
        h r109 = s(r100);
        this.f272994d = r109;
        SVG.Style r110 = r109.f273026a;
        r110.f272774m = Float.valueOf(1.0f);
        boolean r111 = E();
        this.f272991a.save();
        Boolean r112 = r100.f272900p;
        if (r112 != null) goto L34;
    L37:
        if (r103 == true) goto L39;
        this.f272991a.translate(r101.f272814a, r101.f272815b);
        this.f272991a.scale(r101.f272816c, r101.f272817d);
    L39:
        H(r100, false);
        this.f272991a.restore();
        if (r111 == false) goto L42;
        D(r101);
    L42:
        O();
        return;
    L34:
        if (r112.booleanValue() == true) goto L37;
        r103 = false;
        goto L37
    L45:
        return;
    L17:
        r108 = r101.f272817d;
        goto L27
    L13:
        r106 = r101.f272816c;
        goto L14
    L18:
        SVG.o r113 = r100.f272901q;
        float r114 = 1.2f;
        if (r113 == null) goto L21;
        float r115 = r113.c(this, 1.0f);
    L22:
        SVG.o r116 = r100.f272902r;
        if (r116 == null) goto L25;
        r114 = r116.c(this, 1.0f);
    L25:
        r106 = r115 * r101.f272816c;
        r108 = r114 * r101.f272817d;
        goto L27
    L21:
        r115 = 1.2f;
        goto L22
    L5:
        if (r102.booleanValue() == false) goto L7;
        r104 = true;
        goto L9
    }

    public final void S(h r110, SVG.Style r111) {
        if (w(r111, 4096) == false) goto L6;
        SVG.Style r100 = r110.f273026a;
        r100.f272775n = r111.f272775n;
    L6:
        if (w(r111, 2048) == false) goto L8;
        SVG.Style r101 = r110.f273026a;
        r101.f272774m = r111.f272774m;
    L8:
        boolean r102 = false;
        if (w(r111, 1) == false) goto L18;
        SVG.Style r103 = r110.f273026a;
        r103.f272763b = r111.f272763b;
        SVG.m0 r104 = r111.f272763b;
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        r110.f273027b = r105;
        goto L18
    L13:
        if (r104 == SVG.f.f272837c) goto L15;
        r105 = true;
    L18:
        if (w(r111, 4) == false) goto L21;
        SVG.Style r106 = r110.f273026a;
        r106.f272765d = r111.f272765d;
    L21:
        if (w(r111, 6149) == false) goto L24;
        N(r110, true, r110.f273026a.f272763b);
    L24:
        if (w(r111, 2) == false) goto L27;
        SVG.Style r107 = r110.f273026a;
        r107.f272764c = r111.f272764c;
    L27:
        if (w(r111, 8) == false) goto L36;
        SVG.Style r108 = r110.f273026a;
        r108.f272766e = r111.f272766e;
        SVG.m0 r109 = r111.f272766e;
        if (r109 != null) goto L31;
    L33:
        boolean r112 = false;
    L34:
        r110.f273028c = r112;
        goto L36
    L31:
        if (r109 == SVG.f.f272837c) goto L33;
        r112 = true;
    L36:
        if (w(r111, 16) == false) goto L39;
        SVG.Style r113 = r110.f273026a;
        r113.f272767f = r111.f272767f;
    L39:
        if (w(r111, 6168) == false) goto L42;
        N(r110, false, r110.f273026a.f272766e);
    L42:
        if (w(r111, 34359738368L) == false) goto L45;
        SVG.Style r114 = r110.f273026a;
        r114.L = r111.L;
    L45:
        if (w(r111, 32) == false) goto L48;
        SVG.Style r115 = r110.f273026a;
        SVG.o r116 = r111.f272768g;
        r115.f272768g = r116;
        r110.f273030e.setStrokeWidth(r116.b(this));
    L48:
        if (w(r111, 64) == false) goto L58;
        SVG.Style r117 = r110.f273026a;
        r117.f272769h = r111.f272769h;
        int r118 = a.f272999b[r111.f272769h.ordinal()];
        if (r118 == 1) goto L56;
        if (r118 == 2) goto L55;
        if (r118 != 3) goto L58;
        r110.f273030e.setStrokeCap(Paint.Cap.SQUARE);
        goto L58
    L55:
        r110.f273030e.setStrokeCap(Paint.Cap.ROUND);
        goto L58
    L56:
        r110.f273030e.setStrokeCap(Paint.Cap.BUTT);
    L58:
        if (w(r111, 128) == false) goto L68;
        SVG.Style r119 = r110.f273026a;
        r119.f272770i = r111.f272770i;
        int r120 = a.f273000c[r111.f272770i.ordinal()];
        if (r120 == 1) goto L66;
        if (r120 == 2) goto L65;
        if (r120 != 3) goto L68;
        r110.f273030e.setStrokeJoin(Paint.Join.BEVEL);
        goto L68
    L65:
        r110.f273030e.setStrokeJoin(Paint.Join.ROUND);
        goto L68
    L66:
        r110.f273030e.setStrokeJoin(Paint.Join.MITER);
    L68:
        if (w(r111, 256) == false) goto L71;
        SVG.Style r121 = r110.f273026a;
        r121.f272771j = r111.f272771j;
        r110.f273030e.setStrokeMiter(r111.f272771j.floatValue());
    L71:
        if (w(r111, 512) == false) goto L74;
        SVG.Style r122 = r110.f273026a;
        r122.f272772k = r111.f272772k;
    L74:
        if (w(r111, 1024) == false) goto L76;
        SVG.Style r123 = r110.f273026a;
        r123.f272773l = r111.f272773l;
    L76:
        Typeface r124 = null;
        if (w(r111, 1536) == false) goto L96;
        SVG.o[] r125 = r110.f273026a.f272772k;
        if (r125 != null) goto L81;
        r110.f273030e.setPathEffect(null);
        goto L96
    L81:
        int r126 = r125.length;
        if ((r126 % 2) != 0) goto L84;
        int r127 = r126;
    L85:
        float[] r128 = new float[r127];
        int r129 = 0;
        float r130 = 0.0f;
    L86:
        if (r129 >= r127) goto L89;
        float r131 = r110.f273026a.f272772k[r129 % r126].b(this);
        r128[r129] = r131;
        r130 = r130 + r131;
        r129 = r129 + 1;
        goto L86
    L89:
        if (r130 != 0.0f) goto L91;
        r110.f273030e.setPathEffect(null);
        goto L96
    L91:
        float r132 = r110.f273026a.f272773l.b(this);
        if (r132 >= 0.0f) goto L94;
        r132 = (r132 % r130) + r130;
    L94:
        r110.f273030e.setPathEffect(new DashPathEffect(r128, r132));
        goto L96
    L84:
        r127 = r126 * 2;
    L96:
        if (w(r111, 16384) == false) goto L99;
        float r133 = this.f272994d.f273029d.getTextSize();
        SVG.Style r134 = r110.f273026a;
        r134.f272777p = r111.f272777p;
        r110.f273029d.setTextSize(r111.f272777p.c(this, r133));
        r110.f273030e.setTextSize(r111.f272777p.c(this, r133));
    L99:
        if (w(r111, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == false) goto L102;
        SVG.Style r135 = r110.f273026a;
        r135.f272776o = r111.f272776o;
    L102:
        if (w(r111, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) == false) goto L115;
        if (r111.f272778q.intValue() != (-1)) goto L109;
        if (r110.f273026a.f272778q.intValue() <= 100) goto L109;
        SVG.Style r136 = r110.f273026a;
        r136.f272778q = Integer.valueOf(r136.f272778q.intValue() - 100);
    L109:
        if (r111.f272778q.intValue() == 1) goto L111;
    L113:
        SVG.Style r137 = r110.f273026a;
        r137.f272778q = r111.f272778q;
        goto L115
    L111:
        if (r110.f273026a.f272778q.intValue() >= 900) goto L113;
        SVG.Style r138 = r110.f273026a;
        r138.f272778q = Integer.valueOf(r138.f272778q.intValue() + 100);
    L115:
        if (w(r111, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == false) goto L118;
        SVG.Style r139 = r110.f273026a;
        r139.f272779r = r111.f272779r;
    L118:
        if (w(r111, 106496) == false) goto L132;
        List<String> r140 = r110.f273026a.f272776o;
        if (r140 != null) goto L122;
    L128:
        if (r124 != null) goto L130;
        SVG.Style r141 = r110.f273026a;
        r124 = h("serif", r141.f272778q, r141.f272779r);
    L130:
        r110.f273029d.setTypeface(r124);
        r110.f273030e.setTypeface(r124);
        goto L132
    L122:
        if (this.f272993c == null) goto L128;
        Iterator<String> r142 = r140.iterator();
    L125:
        if (r142.hasNext() == false) goto L128;
        String r143 = r142.next();
        SVG.Style r144 = r110.f273026a;
        r124 = h(r143, r144.f272778q, r144.f272779r);
        if (r124 == null) goto L125;
    L132:
        if (w(r111, PlaybackStateCompat.ACTION_PREPARE_FROM_URI) == false) goto L150;
        SVG.Style r145 = r110.f273026a;
        r145.f272780s = r111.f272780s;
        Paint r146 = r110.f273029d;
        SVG.Style.TextDecoration r147 = r111.f272780s;
        SVG.Style.TextDecoration r148 = SVG.Style.TextDecoration.LineThrough;
        if (r147 != r148) goto L136;
        boolean r149 = true;
    L137:
        r146.setStrikeThruText(r149);
        Paint r150 = r110.f273029d;
        SVG.Style.TextDecoration r151 = r111.f272780s;
        SVG.Style.TextDecoration r152 = SVG.Style.TextDecoration.Underline;
        if (r151 != r152) goto L140;
        boolean r153 = true;
    L141:
        r150.setUnderlineText(r153);
        Paint r154 = r110.f273030e;
        if (r111.f272780s != r148) goto L144;
        boolean r155 = true;
    L145:
        r154.setStrikeThruText(r155);
        Paint r156 = r110.f273030e;
        if (r111.f272780s != r152) goto L148;
        r102 = true;
    L148:
        r156.setUnderlineText(r102);
        goto L150
    L144:
        r155 = false;
        goto L145
    L140:
        r153 = false;
        goto L141
    L136:
        r149 = false;
    L150:
        if (w(r111, 68719476736L) == false) goto L153;
        SVG.Style r157 = r110.f273026a;
        r157.f272781t = r111.f272781t;
    L153:
        if (w(r111, PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == false) goto L156;
        SVG.Style r158 = r110.f273026a;
        r158.f272782u = r111.f272782u;
    L156:
        if (w(r111, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == false) goto L159;
        SVG.Style r159 = r110.f273026a;
        r159.f272783v = r111.f272783v;
    L159:
        if (w(r111, 2097152) == false) goto L162;
        SVG.Style r160 = r110.f273026a;
        r160.f272785x = r111.f272785x;
    L162:
        if (w(r111, 4194304) == false) goto L165;
        SVG.Style r161 = r110.f273026a;
        r161.f272786y = r111.f272786y;
    L165:
        if (w(r111, 8388608) == false) goto L168;
        SVG.Style r162 = r110.f273026a;
        r162.f272787z = r111.f272787z;
    L168:
        if (w(r111, 16777216) == false) goto L171;
        SVG.Style r163 = r110.f273026a;
        r163.A = r111.A;
    L171:
        if (w(r111, 33554432) == false) goto L174;
        SVG.Style r164 = r110.f273026a;
        r164.B = r111.B;
    L174:
        if (w(r111, 1048576) == false) goto L177;
        SVG.Style r165 = r110.f273026a;
        r165.f272784w = r111.f272784w;
    L177:
        if (w(r111, 268435456) == false) goto L180;
        SVG.Style r166 = r110.f273026a;
        r166.E = r111.E;
    L180:
        if (w(r111, 536870912) == false) goto L183;
        SVG.Style r167 = r110.f273026a;
        r167.F = r111.F;
    L183:
        if (w(r111, 1073741824) == false) goto L186;
        SVG.Style r168 = r110.f273026a;
        r168.G = r111.G;
    L186:
        if (w(r111, 67108864) == false) goto L189;
        SVG.Style r169 = r110.f273026a;
        r169.C = r111.C;
    L189:
        if (w(r111, 134217728) == false) goto L192;
        SVG.Style r170 = r110.f273026a;
        r170.D = r111.D;
    L192:
        if (w(r111, 8589934592L) == false) goto L195;
        SVG.Style r171 = r110.f273026a;
        r171.f272761J = r111.f272761J;
    L195:
        if (w(r111, 17179869184L) == false) goto L198;
        SVG.Style r172 = r110.f273026a;
        r172.K = r111.K;
    L198:
        if (w(r111, 137438953472L) == false) goto L205;
        SVG.Style r173 = r110.f273026a;
        r173.M = r111.M;
        return;
    }

    public final void T(h r100, SVG.j0 r101) {
        boolean r102 = false;
        if (r101.f272873b != null) goto L5;
        boolean r103 = true;
    L6:
        SVG.Style r104 = r100.f273026a;
        Boolean r105 = Boolean.TRUE;
        r104.A = r105;
        if (r103 == true) goto L10;
        r105 = Boolean.FALSE;
    L10:
        r104.f272783v = r105;
        r104.f272784w = null;
        r104.E = null;
        r104.f272774m = Float.valueOf(1.0f);
        r104.C = SVG.f.f272836b;
        r104.D = Float.valueOf(1.0f);
        r104.G = null;
        r104.H = null;
        r104.I = Float.valueOf(1.0f);
        r104.f272761J = null;
        r104.K = Float.valueOf(1.0f);
        r104.L = SVG.Style.VectorEffect.None;
        SVG.Style r106 = r101.f272863e;
        if (r106 == null) goto L13;
        S(r100, r106);
    L13:
        List<CSSParser.l> r107 = this.f272993c.f272758c.f272743a;
        if (r107 != null) goto L16;
    L17:
        r102 = true;
    L19:
        if ((!r102) == false) goto L26;
        Iterator r108 = ((ArrayList) this.f272993c.f272758c.f272743a).iterator();
    L22:
        if (r108.hasNext() == false) goto L26;
        CSSParser.l r109 = (CSSParser.l) r108.next();
        if (CSSParser.g(r109.f272740a, r101) == false) goto L22;
        S(r100, r109.f272741b);
    L26:
        SVG.Style r110 = r101.f272864f;
        if (r110 == null) goto L35;
        S(r100, r110);
        return;
    L35:
        return;
    L16:
        if (((ArrayList) r107).isEmpty() == false) goto L19;
    L5:
        r103 = false;
        goto L6
    }

    public final Path b(SVG.i0 r100, SVG.b r101) {
        SVG.j0 r102 = r100.f272872a.h(this.f272994d.f273026a.E);
        boolean r103 = false;
        if (r102 != null) goto L6;
        String.format("ClipPath reference '%s' not found", new Object[]{this.f272994d.f273026a.E});
        return null;
    L6:
        SVG.e r104 = (SVG.e) r102;
        this.f272995e.push(this.f272994d);
        this.f272994d = s(r104);
        Boolean r105 = r104.f272835p;
        if (r105 != null) goto L9;
    L10:
        r103 = true;
    L11:
        Matrix r106 = new Matrix();
        if (r103 == true) goto L14;
        r106.preTranslate(r101.f272814a, r101.f272815b);
        r106.preScale(r101.f272816c, r101.f272817d);
    L14:
        Matrix r107 = r104.f272871o;
        if (r107 == null) goto L17;
        r106.preConcat(r107);
    L17:
        Path r108 = new Path();
        Iterator<SVG.l0> r109 = r104.f272839i.iterator();
    L19:
        if (r109.hasNext() == false) goto L27;
        SVG.l0 r110 = r109.next();
        if ((r110 instanceof SVG.i0) == false) goto L19;
        Path r111 = C((SVG.i0) r110, true);
        if (r111 == null) goto L19;
        r108.op(r111, Path.Op.UNION);
        goto L19
    L27:
        if (this.f272994d.f273026a.E != null) goto L29;
    L34:
        r108.transform(r106);
        this.f272994d = this.f272995e.pop();
        return r108;
    L29:
        if (r104.f272855h != null) goto L31;
        r104.f272855h = c(r108);
    L31:
        Path r112 = b(r104, r104.f272855h);
        if (r112 == null) goto L34;
        r108.op(r112, Path.Op.INTERSECT);
        goto L34
    L9:
        if (r105.booleanValue() == false) goto L11;
        goto L10
    }

    public final void f(SVG.i0 r100, SVG.b r101) {
        if (this.f272994d.f273026a.E != null) goto L5;
        return;
    L5:
        Path r102 = b(r100, r101);
        if (r102 == null) goto L9;
        this.f272991a.clipPath(r102);
        return;
    }

    public final void l(SVG.i0 r210, Path r211) {
        SVG.m0 r100 = this.f272994d.f273026a.f272763b;
        if ((r100 instanceof SVG.t) == false) goto L112;
        SVG.j0 r101 = this.f272993c.h(((SVG.t) r100).f272905a);
        if ((r101 instanceof SVG.x) == false) goto L112;
        SVG.x r102 = (SVG.x) r101;
        Boolean r103 = r102.f272914q;
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        String r105 = r102.f272921x;
        if (r105 == null) goto L16;
        r(r102, r105);
    L16:
        if (r104 == false) goto L33;
        SVG.o r106 = r102.f272917t;
        if (r106 == null) goto L20;
        float r107 = r106.d(this);
    L21:
        SVG.o r108 = r102.f272918u;
        if (r108 == null) goto L24;
        float r109 = r108.e(this);
    L25:
        SVG.o r110 = r102.f272919v;
        if (r110 == null) goto L28;
        float r111 = r110.d(this);
    L29:
        SVG.o r112 = r102.f272920w;
        if (r112 == null) goto L32;
        float r113 = r112.e(this);
    L51:
        if (r111 != 0.0f) goto L53;
        return;
    L53:
        if (r113 == 0.0f) goto L121;
        PreserveAspectRatio r114 = r102.f272880o;
        if (r114 != null) goto L59;
        r114 = PreserveAspectRatio.f272751d;
    L59:
        P();
        this.f272991a.clipPath(r211);
        h r115 = new h();
        S(r115, SVG.Style.a());
        r115.f273026a.f272783v = Boolean.FALSE;
        t(r102, r115);
        this.f272994d = r115;
        SVG.b r116 = r210.f272855h;
        Matrix r117 = r102.f272916s;
        if (r117 == null) goto L79;
        this.f272991a.concat(r117);
        Matrix r118 = new Matrix();
        if (r102.f272916s.invert(r118) == false) goto L79;
        SVG.b r119 = r210.f272855h;
        float r120 = r119.f272814a;
        float r121 = r119.f272815b;
        float r122 = r119.f272816c + r120;
        float r123 = r121 + r119.f272817d;
        float[] r124 = {r120, r121, r122, r121, r122, r123, r120, r123};
        r118.mapPoints(r124);
        float r125 = r124[0];
        float r126 = r124[1];
        RectF r127 = new RectF(r125, r126, r125, r126);
        int r128 = 2;
    L64:
        if (r128 > 6) goto L78;
        float r129 = r124[r128];
        if (r129 >= r127.left) goto L69;
        r127.left = r129;
    L69:
        if (r129 <= r127.right) goto L71;
        r127.right = r129;
    L71:
        float r130 = r124[r128 + 1];
        if (r130 >= r127.top) goto L75;
        r127.top = r130;
    L75:
        if (r130 <= r127.bottom) goto L77;
        r127.bottom = r130;
    L77:
        r128 = r128 + 2;
        goto L64
    L78:
        float r131 = r127.left;
        float r132 = r127.top;
        r116 = new SVG.b(r131, r132, r127.right - r131, r127.bottom - r132);
    L79:
        float r133 = r107 + (((float) Math.floor((r116.f272814a - r107) / r111)) * r111);
        float r134 = r109 + (((float) Math.floor((r116.f272815b - r109) / r113)) * r113);
        float r135 = r116.f272814a + r116.f272816c;
        float r136 = r116.f272815b + r116.f272817d;
        SVG.b r137 = new SVG.b(0.0f, 0.0f, r111, r113);
        boolean r138 = E();
    L81:
        if (r134 >= r136) goto L108;
        float r139 = r133;
    L84:
        if (r139 >= r135) goto L107;
        r137.f272814a = r139;
        r137.f272815b = r134;
        P();
        if (this.f272994d.f273026a.f272783v.booleanValue() == true) goto L89;
        M(r137.f272814a, r137.f272815b, r137.f272816c, r137.f272817d);
    L89:
        SVG.b r140 = r102.f272892p;
        if (r140 == null) goto L92;
        this.f272991a.concat(e(r137, r140, r114));
    L102:
        Iterator<SVG.l0> r141 = r102.f272839i.iterator();
    L104:
        if (r141.hasNext() == false) goto L106;
        G(r141.next());
        goto L104
    L106:
        O();
        r139 = r139 + r111;
        r133 = r133;
        goto L84
    L92:
        Boolean r142 = r102.f272915r;
        if (r142 != null) goto L95;
    L98:
        boolean r143 = true;
    L99:
        this.f272991a.translate(r139, r134);
        if (r143 == true) goto L102;
        Canvas r144 = this.f272991a;
        SVG.b r145 = r210.f272855h;
        r144.scale(r145.f272816c, r145.f272817d);
        goto L102
    L95:
        if (r142.booleanValue() == true) goto L98;
        r143 = false;
        goto L99
    L107:
        r134 = r134 + r113;
        goto L81
    L108:
        if (r138 == false) goto L110;
        D(r102.f272855h);
    L110:
        O();
        return;
    L121:
        return;
    L32:
        r113 = 0.0f;
        goto L51
    L28:
        r111 = 0.0f;
        goto L29
    L24:
        r109 = 0.0f;
        goto L25
    L20:
        r107 = 0.0f;
        goto L21
    L33:
        SVG.o r146 = r102.f272917t;
        if (r146 == null) goto L36;
        float r147 = r146.c(this, 1.0f);
    L37:
        SVG.o r148 = r102.f272918u;
        if (r148 == null) goto L40;
        float r149 = r148.c(this, 1.0f);
    L41:
        SVG.o r150 = r102.f272919v;
        if (r150 == null) goto L44;
        float r151 = r150.c(this, 1.0f);
    L45:
        SVG.o r152 = r102.f272920w;
        if (r152 == null) goto L48;
        float r153 = r152.c(this, 1.0f);
    L49:
        SVG.b r154 = r210.f272855h;
        float r155 = r154.f272814a;
        float r156 = r154.f272816c;
        r107 = (r147 * r156) + r155;
        float r157 = r154.f272815b;
        float r158 = r154.f272817d;
        float r159 = r151 * r156;
        r113 = r153 * r158;
        r109 = (r149 * r158) + r157;
        r111 = r159;
        goto L51
    L48:
        r153 = 0.0f;
        goto L49
    L44:
        r151 = 0.0f;
        goto L45
    L40:
        r149 = 0.0f;
        goto L41
    L36:
        r147 = 0.0f;
        goto L37
    L9:
        if (r103.booleanValue() == false) goto L11;
        r104 = true;
    L112:
        this.f272991a.drawPath(r211, this.f272994d.f273029d);
    }

    public final void n(SVG.w0 r110, j r111) {
        if (k() == true) goto L5;
        return;
    L5:
        Iterator<SVG.l0> r112 = r110.f272839i.iterator();
        boolean r100 = true;
    L7:
        if (r112.hasNext() == false) goto L105;
        SVG.l0 r101 = r112.next();
        if ((r101 instanceof SVG.a1) == false) goto L12;
        r111.b(Q(((SVG.a1) r101).f272813c, r100, !r112.hasNext()));
    L104:
        r100 = false;
        goto L7
    L12:
        if (r111.a((SVG.w0) r101) == false) goto L104;
        float r102 = 0.0f;
        if ((r101 instanceof SVG.x0) == false) goto L42;
        P();
        SVG.x0 r103 = (SVG.x0) r101;
        T(this.f272994d, r103);
        if (k() == true) goto L20;
    L40:
        O();
        goto L104
    L20:
        if (V() == false) goto L40;
        SVG.j0 r104 = r103.f272872a.h(r103.f272922o);
        if (r104 != null) goto L25;
        String.format("TextPath reference '%s' not found", new Object[]{r103.f272922o});
        goto L40
    L25:
        SVG.u r105 = (SVG.u) r104;
        Path r106 = new C3816d(r105.f272908o).f273014a;
        Matrix r107 = r105.f272866n;
        if (r107 == null) goto L28;
        r106.transform(r107);
    L28:
        PathMeasure r108 = new PathMeasure(r106, false);
        SVG.o r109 = r103.f272923p;
        if (r109 == null) goto L31;
        r102 = r109.c(this, r108.getLength());
    L31:
        SVG.Style.TextAnchor r113 = u();
        if (r113 == SVG.Style.TextAnchor.Start) goto L37;
        float r114 = d(r103);
        if (r113 != SVG.Style.TextAnchor.Middle) goto L36;
        r114 = r114 / 2.0f;
    L36:
        r102 = r102 - r114;
    L37:
        g((SVG.i0) r103.f272924q);
        boolean r115 = E();
        n(r103, new e(this, r106, r102));
        if (r115 == false) goto L40;
        D(r103.f272855h);
        goto L40
    L42:
        if ((r101 instanceof SVG.t0) == false) goto L92;
        P();
        SVG.t0 r116 = (SVG.t0) r101;
        T(this.f272994d, r116);
        if (k() == false) goto L90;
        List<SVG.o> r117 = r116.f272926o;
        if (r117 != null) goto L48;
    L50:
        boolean r118 = false;
    L51:
        boolean r119 = r111 instanceof f;
        if (r119 == false) goto L76;
        if (r118 == true) goto L55;
        float r120 = ((f) r111).f273019a;
    L56:
        List<SVG.o> r121 = r116.f272927p;
        if (r121 != null) goto L59;
    L62:
        float r122 = ((f) r111).f273020b;
    L63:
        List<SVG.o> r123 = r116.f272928q;
        if (r123 != null) goto L66;
    L69:
        float r124 = 0.0f;
    L70:
        List<SVG.o> r125 = r116.f272929r;
        if (r125 != null) goto L73;
    L77:
        if (r118 == false) goto L84;
        SVG.Style.TextAnchor r126 = u();
        if (r126 == SVG.Style.TextAnchor.Start) goto L84;
        float r127 = d(r116);
        if (r126 != SVG.Style.TextAnchor.Middle) goto L83;
        r127 = r127 / 2.0f;
    L83:
        r120 = r120 - r127;
    L84:
        g((SVG.i0) r116.f272907s);
        if (r119 == false) goto L87;
        f r128 = (f) r111;
        r128.f273019a = r120 + r124;
        r128.f273020b = r122 + r102;
    L87:
        boolean r129 = E();
        n(r116, r111);
        if (r129 == false) goto L90;
        D(r116.f272855h);
        goto L90
    L73:
        if (((ArrayList) r125).size() == 0) goto L77;
        r102 = ((SVG.o) ListProtector.get(r116.f272929r, 0)).e(this);
        goto L77
    L66:
        if (((ArrayList) r123).size() == 0) goto L69;
        r124 = ((SVG.o) ListProtector.get(r116.f272928q, 0)).d(this);
        goto L70
    L59:
        if (((ArrayList) r121).size() == 0) goto L62;
        r122 = ((SVG.o) ListProtector.get(r116.f272927p, 0)).e(this);
        goto L63
    L55:
        r120 = ((SVG.o) ListProtector.get(r116.f272926o, 0)).d(this);
        goto L56
    L76:
        r120 = 0.0f;
        r122 = 0.0f;
        r124 = 0.0f;
        goto L77
    L48:
        if (((ArrayList) r117).size() <= 0) goto L50;
        r118 = true;
    L90:
        O();
        goto L104
    L92:
        if ((r101 instanceof SVG.s0) == false) goto L104;
        P();
        SVG.s0 r130 = (SVG.s0) r101;
        T(this.f272994d, r130);
        if (k() == false) goto L103;
        g((SVG.i0) r130.f272904p);
        SVG.j0 r131 = r101.f272872a.h(r130.f272903o);
        if (r131 != null) goto L98;
    L102:
        String.format("Tref reference '%s' not found", new Object[]{r130.f272903o});
        goto L103
    L98:
        if ((r131 instanceof SVG.w0) == false) goto L102;
        StringBuilder r132 = new StringBuilder();
        o((SVG.w0) r131, r132);
        if (r132.length() <= 0) goto L103;
        r111.b(r132.toString());
    L103:
        O();
        goto L104
    }

    public final void o(SVG.w0 r100, StringBuilder r101) {
        Iterator<SVG.l0> r102 = r100.f272839i.iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L12;
        SVG.l0 r104 = r102.next();
        if ((r104 instanceof SVG.w0) == false) goto L9;
        o((SVG.w0) r104, r101);
    L11:
        r103 = false;
        goto L4
    L9:
        if ((r104 instanceof SVG.a1) == false) goto L11;
        r101.append(Q(((SVG.a1) r104).f272813c, r103, !r102.hasNext()));
        goto L11
    }

    public final void t(SVG.l0 r100, h r101) {
        ArrayList r102 = new ArrayList();
    L4:
        if ((r100 instanceof SVG.j0) == false) goto L6;
        ListProtector.add(r102, 0, (SVG.j0) r100);
    L6:
        Object r103 = r100.f272873b;
        if (r103 == null) goto L8;
        r100 = (SVG.l0) r103;
        goto L4
    L8:
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        T(r101, (SVG.j0) r104.next());
        goto L10
    L12:
        h r105 = this.f272994d;
        r101.f273032g = r105.f273032g;
        r101.f273031f = r105.f273031f;
    }

    public static void N(h r100, boolean r101, SVG.m0 r102) {
        SVG.Style r103 = r100.f273026a;
        if (r101 == false) goto L5;
        Float r104 = r103.f272765d;
    L6:
        float r105 = r104.floatValue();
        if ((r102 instanceof SVG.f) == false) goto L10;
        int r106 = ((SVG.f) r102).f272838a;
    L12:
        int r107 = i(r106, r105);
        if (r101 == false) goto L15;
        r100.f273029d.setColor(r107);
        return;
    L15:
        r100.f273030e.setColor(r107);
        return;
    L10:
        if ((r102 instanceof SVG.g) == false) goto L17;
        r106 = r100.f273026a.f272775n.f272838a;
        goto L12
    L17:
        return;
    L5:
        r104 = r103.f272767f;
        goto L6
    }

    public static Matrix e(SVG.b r100, SVG.b r110, PreserveAspectRatio r111) {
        Matrix r101 = new Matrix();
        if (r111 != null) goto L5;
    L38:
        return r101;
    L5:
        if (r111.f272752a == null) goto L38;
        float r102 = r100.f272816c / r110.f272816c;
        float r103 = r100.f272817d / r110.f272817d;
        float r104 = -r110.f272814a;
        float r105 = -r110.f272815b;
        if (r111.equals(PreserveAspectRatio.f272750c) == false) goto L12;
        r101.preTranslate(r100.f272814a, r100.f272815b);
        r101.preScale(r102, r103);
        r101.preTranslate(r104, r105);
        return r101;
    L12:
        if (r111.f272753b != PreserveAspectRatio.Scale.slice) goto L14;
        float r106 = Math.max(r102, r103);
    L15:
        float r107 = r100.f272816c / r106;
        float r108 = r100.f272817d / r106;
        int[] r109 = a.f272998a;
        switch(r109[r111.f272752a.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L18;
            case 6: goto L18;
            default: goto L21;
        };
    L18:
        float r112 = r110.f272816c - r107;
    L20:
        r104 = r104 - r112;
        goto L21
    L19:
        r112 = (r110.f272816c - r107) / 2.0f;
    L21:
        int r113 = r109[r111.f272752a.ordinal()];
        if (r113 != 2) goto L24;
    L35:
        float r114 = (r110.f272817d - r108) / 2.0f;
    L36:
        r105 = r105 - r114;
    L37:
        r101.preTranslate(r100.f272814a, r100.f272815b);
        r101.preScale(r106, r106);
        r101.preTranslate(r104, r105);
        goto L38
    L24:
        if (r113 != 3) goto L26;
    L34:
        r114 = r110.f272817d - r108;
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

    public static Typeface h(String r100, Integer r101, SVG.Style.FontStyle r102) {
        byte r103 = 0;
        if (r102 != SVG.Style.FontStyle.Italic) goto L5;
        boolean r104 = true;
    L7:
        if (r101.intValue() <= 500) goto L11;
        if (r104 == false) goto L10;
        int r105 = 3;
    L14:
        r100.getClass();
        switch(r100.hashCode()) {
            case -1536685117: goto L34;
            case -1431958525: goto L30;
            case -1081737434: goto L26;
            case 109326717: goto L22;
            case 1126973893: goto L18;
            default: goto L35;
        };
    L35:
        r103 = -1;
    L36:
        if (r103 == 0) goto L47;
        if (r103 == 1) goto L52;
        if (r103 == 2) goto L51;
        if (r103 == 3) goto L50;
        if (r103 == 4) goto L49;
        return null;
    L49:
        return Typeface.create(Typeface.SANS_SERIF, r105);
    L50:
        return Typeface.create(Typeface.SERIF, r105);
    L51:
        return Typeface.create(Typeface.SANS_SERIF, r105);
    L52:
        return Typeface.create(Typeface.MONOSPACE, r105);
    L47:
        return Typeface.create(Typeface.SANS_SERIF, r105);
    L18:
        if (r100.equals("cursive") == false) goto L35;
        r103 = 4;
        goto L36
    L22:
        if (r100.equals("serif") == false) goto L35;
        r103 = 3;
        goto L36
    L26:
        if (r100.equals("fantasy") == false) goto L35;
        r103 = 2;
        goto L36
    L30:
        if (r100.equals("monospace") == false) goto L35;
        r103 = 1;
        goto L36
    L34:
        if (r100.equals(PlatformFontCaps.DEFAULT_FAMILY_NAME) == true) goto L36;
    L10:
        r105 = 1;
        goto L14
    L11:
        if (r104 == false) goto L13;
        r105 = 2;
        goto L14
    L13:
        r105 = 0;
        goto L14
    L5:
        r104 = false;
        goto L7
    }

    public final String Q(String r100, boolean r101, boolean r102) {
        if (this.f272994d.f273033h == true) goto L5;
        String r103 = r100.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (r101 == false) goto L9;
        r103 = r103.replaceAll("^\\s+", "");
    L9:
        if (r102 == false) goto L12;
        r103 = r103.replaceAll("\\s+$", "");
    L12:
        return r103.replaceAll("\\s{2,}", " ");
    L5:
        return r100.replaceAll("[\\n\\t]", " ");
    }

    public final void j(boolean r210, SVG.b r211, SVG.t r212) {
        SVG.j0 r100 = this.f272993c.h(r212.f272905a);
        boolean r101 = true;
        int r102 = 0;
        if (r100 != null) goto L16;
        Object[] r103 = new Object[2];
        if (r210 == false) goto L7;
        String r104 = "Fill";
    L8:
        r103[0] = r104;
        r103[1] = r212.f272905a;
        String.format("%s reference '%s' not found", r103);
        SVG.m0 r105 = r212.f272906b;
        if (r105 == null) goto L11;
        N(this.f272994d, r210, r105);
        return;
    L11:
        if (r210 == false) goto L13;
        this.f272994d.f273027b = false;
        return;
    L13:
        this.f272994d.f273028c = false;
        return;
    L7:
        r104 = "Stroke";
        goto L8
    L16:
        if ((r100 instanceof SVG.k0) == false) goto L120;
        SVG.k0 r106 = (SVG.k0) r100;
        String r107 = r106.f272860l;
        if (r107 == null) goto L20;
        p(r106, r107);
    L20:
        Boolean r108 = r106.f272857i;
        if (r108 != null) goto L23;
    L25:
        boolean r109 = false;
    L26:
        h r110 = this.f272994d;
        if (r210 == false) goto L29;
        Paint r111 = r110.f273029d;
    L30:
        if (r109 == false) goto L52;
        SVG.b r112 = r110.f273032g;
        if (r112 != null) goto L35;
        r112 = r110.f273031f;
    L35:
        SVG.o r113 = r106.f272867m;
        if (r113 == null) goto L38;
        float r114 = r113.d(this);
    L39:
        SVG.o r115 = r106.f272868n;
        if (r115 == null) goto L42;
        float r116 = r115.e(this);
    L43:
        SVG.o r117 = r106.f272869o;
        if (r117 == null) goto L46;
        float r118 = r117.d(this);
    L47:
        SVG.o r119 = r106.f272870p;
        if (r119 == null) goto L50;
        float r120 = r119.e(this);
    L51:
        float r121 = r118;
        float r122 = r114;
        float r123 = r116;
        float r213 = r120;
    L69:
        P();
        this.f272994d = s(r106);
        Matrix r124 = new Matrix();
        if (r109 == true) goto L72;
        r124.preTranslate(r211.f272814a, r211.f272815b);
        r124.preScale(r211.f272816c, r211.f272817d);
    L72:
        Matrix r125 = r106.f272858j;
        if (r125 == null) goto L75;
        r124.preConcat(r125);
    L75:
        int r126 = r106.f272856h.size();
        if (r126 != 0) goto L81;
        O();
        if (r210 == false) goto L80;
        this.f272994d.f273027b = false;
        return;
    L80:
        this.f272994d.f273028c = false;
        return;
    L81:
        int[] r127 = new int[r126];
        float[] r128 = new float[r126];
        Iterator<SVG.l0> r129 = r106.f272856h.iterator();
        float r130 = -1.0f;
        int r131 = 0;
    L83:
        if (r129.hasNext() == false) goto L99;
        SVG.c0 r132 = (SVG.c0) r129.next();
        Float r133 = r132.f272827h;
        if (r133 == null) goto L87;
        float r134 = r133.floatValue();
    L88:
        if (r131 != 0) goto L90;
    L93:
        r128[r131] = r134;
        r130 = r134;
    L94:
        P();
        T(this.f272994d, r132);
        SVG.Style r135 = this.f272994d.f273026a;
        SVG.f r136 = (SVG.f) r135.C;
        if (r136 != null) goto L97;
        r136 = SVG.f.f272836b;
    L97:
        r127[r131] = i(r136.f272838a, r135.D.floatValue());
        r131 = r131 + 1;
        O();
        goto L83
    L90:
        if (r134 >= r130) goto L93;
        r128[r131] = r130;
        goto L94
    L87:
        r134 = 0.0f;
        goto L88
    L99:
        if (r122 == r121) goto L101;
    L102:
        if (r126 != 1) goto L104;
    L103:
        O();
        r111.setColor(r127[r126 - 1]);
        return;
    L104:
        Shader.TileMode r137 = Shader.TileMode.CLAMP;
        SVG.GradientSpread r138 = r106.f272859k;
        if (r138 != null) goto L107;
    L112:
        O();
        LinearGradient r139 = new LinearGradient(r122, r123, r121, r213, r127, r128, r137);
        r139.setLocalMatrix(r124);
        r111.setShader(r139);
        int r140 = (int) (this.f272994d.f273026a.f272765d.floatValue() * 256.0f);
        if (r140 < 0) goto L118;
        if (r140 <= 255) goto L117;
        r102 = 255;
        goto L118
    L117:
        r102 = r140;
    L118:
        r111.setAlpha(r102);
        return;
    L107:
        if (r138 != SVG.GradientSpread.reflect) goto L110;
        r137 = Shader.TileMode.MIRROR;
        goto L112
    L110:
        if (r138 != SVG.GradientSpread.repeat) goto L112;
        r137 = Shader.TileMode.REPEAT;
        goto L112
    L101:
        if (r123 == r213) goto L103;
    L50:
        r120 = 0.0f;
        goto L51
    L46:
        r118 = r112.f272816c;
        goto L47
    L42:
        r116 = 0.0f;
        goto L43
    L38:
        r114 = 0.0f;
        goto L39
    L52:
        SVG.o r141 = r106.f272867m;
        if (r141 == null) goto L55;
        float r142 = r141.c(this, 1.0f);
    L56:
        SVG.o r143 = r106.f272868n;
        if (r143 == null) goto L59;
        float r144 = r143.c(this, 1.0f);
    L60:
        SVG.o r145 = r106.f272869o;
        if (r145 == null) goto L63;
        float r146 = r145.c(this, 1.0f);
    L64:
        SVG.o r147 = r106.f272870p;
        if (r147 == null) goto L67;
        float r148 = r147.c(this, 1.0f);
    L68:
        r213 = r148;
        r122 = r142;
        r123 = r144;
        r121 = r146;
        goto L69
    L67:
        r148 = 0.0f;
        goto L68
    L63:
        r146 = 1.0f;
        goto L64
    L59:
        r144 = 0.0f;
        goto L60
    L55:
        r142 = 0.0f;
        goto L56
    L29:
        r111 = r110.f273030e;
        goto L30
    L23:
        if (r108.booleanValue() == false) goto L25;
        r109 = true;
        goto L26
    L120:
        if ((r100 instanceof SVG.o0) == false) goto L211;
        SVG.o0 r149 = (SVG.o0) r100;
        String r150 = r149.f272860l;
        if (r150 == null) goto L124;
        p(r149, r150);
    L124:
        Boolean r151 = r149.f272857i;
        if (r151 != null) goto L127;
    L129:
        boolean r152 = false;
    L130:
        h r153 = this.f272994d;
        if (r210 == false) goto L133;
        Paint r154 = r153.f273029d;
    L134:
        if (r152 == false) goto L148;
        SVG.o r155 = new SVG.o(50.0f, SVG.Unit.percent);
        SVG.o r156 = r149.f272883m;
        if (r156 == null) goto L138;
        float r157 = r156.d(this);
    L139:
        SVG.o r158 = r149.f272884n;
        if (r158 == null) goto L142;
        float r159 = r158.e(this);
    L143:
        SVG.o r160 = r149.f272885o;
        if (r160 == null) goto L146;
        float r161 = r160.b(this);
    L147:
        float r214 = r161;
        float r162 = r157;
        float r163 = r159;
    L161:
        P();
        this.f272994d = s(r149);
        Matrix r164 = new Matrix();
        if (r152 == true) goto L164;
        r164.preTranslate(r211.f272814a, r211.f272815b);
        r164.preScale(r211.f272816c, r211.f272817d);
    L164:
        Matrix r165 = r149.f272858j;
        if (r165 == null) goto L167;
        r164.preConcat(r165);
    L167:
        int r166 = r149.f272856h.size();
        if (r166 != 0) goto L173;
        O();
        if (r210 == false) goto L172;
        this.f272994d.f273027b = false;
        return;
    L172:
        this.f272994d.f273028c = false;
        return;
    L173:
        int[] r167 = new int[r166];
        float[] r168 = new float[r166];
        Iterator<SVG.l0> r169 = r149.f272856h.iterator();
        float r170 = -1.0f;
        int r171 = 0;
    L175:
        if (r169.hasNext() == false) goto L191;
        SVG.c0 r172 = (SVG.c0) r169.next();
        Float r173 = r172.f272827h;
        if (r173 == null) goto L179;
        float r174 = r173.floatValue();
    L180:
        if (r171 != 0) goto L182;
    L185:
        r168[r171] = r174;
        r170 = r174;
    L186:
        P();
        T(this.f272994d, r172);
        SVG.Style r175 = this.f272994d.f273026a;
        SVG.f r176 = (SVG.f) r175.C;
        if (r176 != null) goto L189;
        r176 = SVG.f.f272836b;
    L189:
        r167[r171] = i(r176.f272838a, r175.D.floatValue());
        r171 = r171 + 1;
        O();
        goto L175
    L182:
        if (r174 >= r170) goto L185;
        r168[r171] = r170;
        goto L186
    L179:
        r174 = 0.0f;
        goto L180
    L191:
        if (r214 == 0.0f) goto L209;
        if (r166 == 1) goto L209;
        Shader.TileMode r177 = Shader.TileMode.CLAMP;
        SVG.GradientSpread r178 = r149.f272859k;
        if (r178 != null) goto L197;
    L202:
        O();
        RadialGradient r179 = new RadialGradient(r162, r163, r214, r167, r168, r177);
        r179.setLocalMatrix(r164);
        r154.setShader(r179);
        int r180 = (int) (this.f272994d.f273026a.f272765d.floatValue() * 256.0f);
        if (r180 < 0) goto L208;
        if (r180 <= 255) goto L207;
        r102 = 255;
        goto L208
    L207:
        r102 = r180;
    L208:
        r154.setAlpha(r102);
        return;
    L197:
        if (r178 != SVG.GradientSpread.reflect) goto L200;
        r177 = Shader.TileMode.MIRROR;
        goto L202
    L200:
        if (r178 != SVG.GradientSpread.repeat) goto L202;
        r177 = Shader.TileMode.REPEAT;
    L209:
        O();
        r154.setColor(r167[r166 - 1]);
        return;
    L146:
        r161 = r155.b(this);
        goto L147
    L142:
        r159 = r155.e(this);
        goto L143
    L138:
        r157 = r155.d(this);
        goto L139
    L148:
        SVG.o r181 = r149.f272883m;
        if (r181 == null) goto L151;
        float r182 = r181.c(this, 1.0f);
    L152:
        SVG.o r183 = r149.f272884n;
        if (r183 == null) goto L155;
        float r184 = r183.c(this, 1.0f);
    L156:
        SVG.o r185 = r149.f272885o;
        if (r185 == null) goto L159;
        float r186 = r185.c(this, 1.0f);
    L160:
        r214 = r186;
        r162 = r182;
        r163 = r184;
        goto L161
    L159:
        r186 = 0.5f;
        goto L160
    L155:
        r184 = 0.5f;
        goto L156
    L151:
        r182 = 0.5f;
        goto L152
    L133:
        r154 = r153.f273030e;
        goto L134
    L127:
        if (r151.booleanValue() == false) goto L129;
        r152 = true;
        goto L130
    L211:
        if ((r100 instanceof SVG.b0) == false) goto L257;
        SVG.b0 r187 = (SVG.b0) r100;
        if (r210 == false) goto L228;
        if (w(r187.f272863e, j0.G2_OTA_SPACE_RESERVE_BYTES) == false) goto L222;
        h r188 = this.f272994d;
        SVG.Style r189 = r188.f273026a;
        SVG.m0 r190 = r187.f272863e.H;
        r189.f272763b = r190;
        if (r190 != null) goto L220;
        r101 = false;
    L220:
        r188.f273027b = r101;
    L222:
        if (w(r187.f272863e, 4294967296L) == false) goto L225;
        SVG.Style r191 = this.f272994d.f273026a;
        r191.f272765d = r187.f272863e.I;
    L225:
        if (w(r187.f272863e, 6442450944L) == false) goto L258;
        h r192 = this.f272994d;
        N(r192, r210, r192.f273026a.f272763b);
        return;
    L258:
        return;
    L228:
        if (w(r187.f272863e, j0.G2_OTA_SPACE_RESERVE_BYTES) == false) goto L235;
        h r193 = this.f272994d;
        SVG.Style r194 = r193.f273026a;
        SVG.m0 r195 = r187.f272863e.H;
        r194.f272766e = r195;
        if (r195 != null) goto L233;
        r101 = false;
    L233:
        r193.f273028c = r101;
    L235:
        if (w(r187.f272863e, 4294967296L) == false) goto L238;
        SVG.Style r196 = this.f272994d.f273026a;
        r196.f272767f = r187.f272863e.I;
    L238:
        if (w(r187.f272863e, 6442450944L) == false) goto L260;
        h r197 = this.f272994d;
        N(r197, r210, r197.f273026a.f272766e);
        return;
    L260:
        return;
    }

    public final SVG.b B(SVG.o r100, SVG.o r101, SVG.o r102, SVG.o r103) {
        float r104 = 0.0f;
        if (r100 == null) goto L5;
        float r105 = r100.d(this);
    L6:
        if (r101 == null) goto L8;
        r104 = r101.e(this);
    L8:
        h r106 = this.f272994d;
        SVG.b r107 = r106.f273032g;
        if (r107 != null) goto L12;
        r107 = r106.f273031f;
    L12:
        if (r102 == null) goto L14;
        float r108 = r102.d(this);
    L15:
        if (r103 == null) goto L17;
        float r109 = r103.e(this);
    L19:
        return new SVG.b(r105, r104, r108, r109);
    L17:
        r109 = r107.f272817d;
        goto L19
    L14:
        r108 = r107.f272816c;
        goto L15
    L5:
        r105 = 0.0f;
        goto L6
    }

    public final void F(SVG.d0 r100, SVG.b r101, SVG.b r102, PreserveAspectRatio r103) {
        if (r101.f272816c != 0.0f) goto L5;
        return;
    L5:
        if (r101.f272817d == 0.0f) goto L28;
        if (r103 != null) goto L12;
        r103 = r100.f272880o;
        if (r103 != null) goto L12;
        r103 = PreserveAspectRatio.f272751d;
    L12:
        T(this.f272994d, r100);
        if (k() == true) goto L15;
        return;
    L15:
        h r104 = this.f272994d;
        r104.f273031f = r101;
        if (r104.f273026a.f272783v.booleanValue() == true) goto L18;
        SVG.b r105 = this.f272994d.f273031f;
        M(r105.f272814a, r105.f272815b, r105.f272816c, r105.f272817d);
    L18:
        f(r100, this.f272994d.f273031f);
        if (r102 == null) goto L21;
        this.f272991a.concat(e(this.f272994d.f273031f, r102, r103));
        h r106 = this.f272994d;
        r106.f273032g = r100.f272892p;
    L22:
        boolean r107 = E();
        U();
        H(r100, true);
        if (r107 == false) goto L25;
        D(r100.f272855h);
    L25:
        R(r100);
        return;
    L21:
        Canvas r108 = this.f272991a;
        SVG.b r109 = this.f272994d.f273031f;
        r108.translate(r109.f272814a, r109.f272815b);
        goto L22
    }

    public final void M(float r100, float r101, float r102, float r103) {
        float r104 = r102 + r100;
        float r105 = r103 + r101;
        SVG.c r106 = this.f272994d.f273026a.f272784w;
        if (r106 == null) goto L5;
        r100 = r100 + r106.f272826d.d(this);
        r101 = r101 + this.f272994d.f273026a.f272784w.f272823a.e(this);
        r104 = r104 - this.f272994d.f273026a.f272784w.f272824b.d(this);
        r105 = r105 - this.f272994d.f273026a.f272784w.f272825c.e(this);
    L5:
        this.f272991a.clipRect(r100, r101, r104, r105);
    }

    public static void a(float r310, float r311, float r312, float r313, float r314, boolean r315, boolean r316, float r317, float r318, SVG.w r410) {
        if (r310 != r317) goto L8;
        if (r311 != r318) goto L8;
        return;
    L8:
        if (r312 == 0.0f) goto L53;
        if (r313 == 0.0f) goto L53;
        float r100 = Math.abs(r312);
        float r101 = Math.abs(r313);
        double r102 = Math.toRadians(((double) r314) % 360.0d);
        double r103 = Math.cos(r102);
        double r104 = Math.sin(r102);
        double r110 = ((double) (r310 - r317)) / 2.0d;
        double r111 = ((double) (r311 - r318)) / 2.0d;
        double r112 = (r103 * r110) + (r104 * r111);
        double r105 = ((-r104) * r110) + (r111 * r103);
        double r113 = r100 * r100;
        double r114 = r101 * r101;
        double r115 = r112 * r112;
        double r116 = r105 * r105;
        double r210 = (r115 / r113) + (r116 / r114);
        if (r210 <= 0.99999d) goto L16;
        double r117 = Math.sqrt(r210) * 1.00001d;
        r100 = (float) (((double) r100) * r117);
        r101 = (float) (r117 * ((double) r101));
        r113 = r100 * r100;
        r114 = r101 * r101;
    L16:
        if (r315 != r316) goto L18;
        double r211 = -1.0d;
    L19:
        double r212 = r113 * r114;
        double r118 = r113 * r116;
        double r119 = r114 * r115;
        double r213 = ((r212 - r118) - r119) / (r118 + r119);
        if (r213 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        r213 = 0.0d;
    L22:
        double r214 = r211 * Math.sqrt(r213);
        double r120 = r100;
        double r121 = r101;
        double r122 = ((r120 * r105) / r121) * r214;
        float r106 = r100;
        float r215 = r101;
        double r216 = r214 * (-((r121 * r112) / r120));
        double r107 = (((double) (r310 + r317)) / 2.0d) + ((r103 * r122) - (r104 * r216));
        double r108 = (((double) (r311 + r318)) / 2.0d) + ((r104 * r122) + (r103 * r216));
        double r109 = (r112 - r122) / r120;
        double r123 = (r105 - r216) / r121;
        double r124 = ((-r112) - r122) / r120;
        double r125 = ((-r105) - r216) / r121;
        double r126 = (r109 * r109) + (r123 * r123);
        double r127 = Math.sqrt(r126);
        if (r123 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        double r128 = -1.0d;
    L26:
        double r129 = r128 * Math.acos(r109 / r127);
        double r130 = Math.sqrt(r126 * ((r124 * r124) + (r125 * r125)));
        double r131 = (r109 * r124) + (r123 * r125);
        if (((r109 * r125) - (r123 * r124)) >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        double r132 = -1.0d;
    L30:
        double r133 = r131 / r130;
        if (r133 >= (-1.0d)) goto L34;
        double r134 = 3.141592653589793d;
    L37:
        double r135 = r132 * r134;
        if (r316 == false) goto L40;
    L42:
        if (r316 == true) goto L44;
    L46:
        double r136 = r135 % 6.283185307179586d;
        double r137 = r129 % 6.283185307179586d;
        int r138 = (int) Math.ceil((Math.abs(r136) * 2.0d) / 3.141592653589793d);
        double r139 = r136 / ((double) r138);
        double r140 = r139 / 2.0d;
        double r141 = (Math.sin(r140) * 1.3333333333333333d) / (Math.cos(r140) + 1.0d);
        int r142 = r138 * 6;
        float[] r143 = new float[r142];
        int r144 = 0;
        int r145 = 0;
    L47:
        if (r144 >= r138) goto L49;
        double r146 = r137 + (((double) r144) * r139);
        double r147 = Math.cos(r146);
        double r217 = Math.sin(r146);
        int r218 = r145 + 1;
        int r219 = r144;
        r143[r145] = (float) (r147 - (r141 * r217));
        int r148 = r218 + 1;
        r143[r218] = (float) (r217 + (r147 * r141));
        double r149 = r146 + r139;
        double r150 = Math.cos(r149);
        double r151 = Math.sin(r149);
        int r152 = r148 + 1;
        double r319 = r139;
        r143[r148] = (float) ((r141 * r151) + r150);
        int r153 = r152 + 1;
        r143[r152] = (float) (r151 - (r141 * r150));
        int r154 = r153 + 1;
        r143[r153] = (float) r150;
        r145 = r154 + 1;
        r143[r154] = (float) r151;
        r144 = r219 + 1;
        r139 = r319;
        r141 = r141;
        goto L47
    L49:
        Matrix r155 = new Matrix();
        r155.postScale(r106, r215);
        r155.postRotate(r314);
        r155.postTranslate((float) r107, (float) r108);
        r155.mapPoints(r143);
        r143[r142 - 2] = r317;
        r143[r142 - 1] = r318;
        int r156 = 0;
    L50:
        if (r156 >= r142) goto L58;
        r410.cubicTo(r143[r156], r143[r156 + 1], r143[r156 + 2], r143[r156 + 3], r143[r156 + 4], r143[r156 + 5]);
        r156 = r156 + 6;
        goto L50
    L58:
        return;
    L44:
        if (r135 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L46;
        r135 = r135 + 6.283185307179586d;
        goto L46
    L40:
        if (r135 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L42;
        r135 = r135 - 6.283185307179586d;
        goto L46
    L34:
        if (r133 <= 1.0d) goto L36;
        r134 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L37
    L36:
        r134 = Math.acos(r133);
        goto L37
    L29:
        r132 = 1.0d;
        goto L30
    L25:
        r128 = 1.0d;
        goto L26
    L18:
        r211 = 1.0d;
    L53:
        r410.lineTo(r317, r318);
    }
}
