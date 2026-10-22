package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class BackgroundDrawable extends d<a7a.e> {
    public BorderRadius A;
    public UIShadowProxy.a B;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f383091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f383092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f383093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k f383094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BorderStyle[] f383095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PathEffect f383096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RoundRectPath f383097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RoundRectPath f383098o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<RoundRectPath.Pos, RoundRectPath> f383099p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f383100q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Path f383101r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PointF f383102s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PointF f383103t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PointF f383104u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PointF f383105v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f383106w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f383107x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f383108y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f383109z;

    public static final enum BorderRadiusLocation extends Enum<BorderRadiusLocation> {
        public static final BorderRadiusLocation BOTTOM_END = null;
        public static final BorderRadiusLocation BOTTOM_LEFT = null;
        public static final BorderRadiusLocation BOTTOM_RIGHT = null;
        public static final BorderRadiusLocation BOTTOM_START = null;
        public static final BorderRadiusLocation TOP_END = null;
        public static final BorderRadiusLocation TOP_LEFT = null;
        public static final BorderRadiusLocation TOP_RIGHT = null;
        public static final BorderRadiusLocation TOP_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BorderRadiusLocation[] f383110a = null;

        static {
            BorderRadiusLocation r100 = new BorderRadiusLocation("TOP_LEFT", 0);
            TOP_LEFT = r100;
            BorderRadiusLocation r101 = new BorderRadiusLocation("TOP_RIGHT", 1);
            TOP_RIGHT = r101;
            BorderRadiusLocation r102 = new BorderRadiusLocation("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r102;
            BorderRadiusLocation r103 = new BorderRadiusLocation("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r103;
            BorderRadiusLocation r104 = new BorderRadiusLocation("TOP_START", 4);
            TOP_START = r104;
            BorderRadiusLocation r105 = new BorderRadiusLocation("TOP_END", 5);
            TOP_END = r105;
            BorderRadiusLocation r110 = new BorderRadiusLocation("BOTTOM_START", 6);
            BOTTOM_START = r110;
            BorderRadiusLocation r111 = new BorderRadiusLocation("BOTTOM_END", 7);
            BOTTOM_END = r111;
            f383110a = new BorderRadiusLocation[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static BorderRadiusLocation[] values() {
            return (BorderRadiusLocation[]) f383110a.clone();
        }

        public static BorderRadiusLocation valueOf(String r100) {
            return (BorderRadiusLocation) r27.a.a(BorderRadiusLocation.class, r100);
        }

        public BorderRadiusLocation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class RoundRectPath {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f383111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float[] f383112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Path f383113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f383114d;

        public static final enum Pos extends Enum<Pos> {
            public static final Pos CENTER = null;
            public static final Pos INNER2 = null;
            public static final Pos INNER3 = null;
            public static final Pos OUTER2 = null;
            public static final Pos OUTER3 = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Pos[] f383115a = null;

            static {
                Pos r100 = new Pos("CENTER", 0);
                CENTER = r100;
                Pos r101 = new Pos("INNER2", 1);
                INNER2 = r101;
                Pos r102 = new Pos("OUTER2", 2);
                OUTER2 = r102;
                Pos r103 = new Pos("INNER3", 3);
                INNER3 = r103;
                Pos r104 = new Pos("OUTER3", 4);
                OUTER3 = r104;
                f383115a = new Pos[]{r100, r101, r102, r103, r104};
            }

            public static Pos[] values() {
                return (Pos[]) f383115a.clone();
            }

            public float getOffset() {
                int r100 = a.f383116a[ordinal()];
                if (r100 != 1) goto L5;
                return 0.5f;
            L5:
                if (r100 != 2) goto L7;
                return 0.75f;
            L7:
                if (r100 != 3) goto L9;
                return 0.25f;
            L9:
                if (r100 != 4) goto L11;
                return 0.8333333f;
            L11:
                if (r100 == 5) goto L14;
                return 0.0f;
            L14:
                return 0.16666667f;
            }

            public static Pos valueOf(String r100) {
                return (Pos) r27.a.a(Pos.class, r100);
            }

            public Pos(String r100, int r101) {
                super(r100, r101);
            }
        }

        public RoundRectPath() {
        }

        public static boolean a(float[] r100) {
            int r101 = 2;
        L4:
            if (r101 > 6) goto L17;
            float r102 = r100[r101] - r100[0];
            if (r102 > 1.0E-4f) goto L16;
            if (r102 < (-1.0E-4f)) goto L16;
            float r103 = r100[r101 + 1] - r100[1];
            if (r103 > 1.0E-4f) goto L16;
            if (r103 < (-1.0E-4f)) goto L16;
            r101 = r101 + 2;
        L16:
            return false;
        L17:
            return true;
        }

        public final void b(Canvas r100, Paint r101) {
            if (this.f383114d == false) goto L5;
            RectF r102 = this.f383111a;
            float[] r103 = this.f383112b;
            r100.drawRoundRect(r102, r103[0], r103[1], r101);
            return;
        L5:
            r100.drawPath(this.f383113c, r101);
        }

        public RoundRectPath(x6a.j r100, x6a.j r101, Pos r110) {
            Rect r102 = r100.a();
            float[] r103 = r100.f562750b;
            RectF r104 = r101.f562749a;
            float r105 = r104.left;
            RectF r106 = r100.f562749a;
            RectF r107 = new RectF(r105 - r106.left, r104.top - r106.top, r106.right - r104.right, r106.bottom - r104.bottom);
            float r108 = r110.getOffset();
            if (r110 != Pos.CENTER) goto L5;
            boolean r109 = true;
        L6:
            d(r102, r103, r107, r108, r109);
            return;
        L5:
            r109 = false;
            goto L6
        }

        public static float[] c(float[] r100, RectF r101, float r102) {
            return new float[]{Math.max(r100[0] - (r101.left * r102), 0.0f), Math.max(r100[1] - (r101.top * r102), 0.0f), Math.max(r100[2] - (r101.right * r102), 0.0f), Math.max(r100[3] - (r101.top * r102), 0.0f), Math.max(r100[4] - (r101.right * r102), 0.0f), Math.max(r100[5] - (r101.bottom * r102), 0.0f), Math.max(r100[6] - (r101.left * r102), 0.0f), Math.max(r100[7] - (r101.bottom * r102), 0.0f)};
        }

        public final void d(Rect r100, float[] r101, RectF r102, float r103, boolean r104) {
            if (this.f383111a != null) goto L5;
            this.f383111a = new RectF();
        L5:
            RectF r105 = this.f383111a;
            r105.left = r100.left + (r102.left * r103);
            r105.top = r100.top + (r102.top * r103);
            r105.right = r100.right - (r102.right * r103);
            r105.bottom = r100.bottom - (r102.bottom * r103);
            if (r104 == false) goto L8;
            float[] r106 = {Math.max(r101[0] - (r102.left * r103), 0.0f), Math.max(r101[1] - (r102.top * r103), 0.0f), Math.max(r101[2] - (r102.right * r103), 0.0f), Math.max(r101[3] - (r102.top * r103), 0.0f), Math.max(r101[4] - (r102.right * r103), 0.0f), Math.max(r101[5] - (r102.bottom * r103), 0.0f), Math.max(r101[6] - (r102.left * r103), 0.0f), Math.max(r101[7] - (r102.bottom * r103), 0.0f)};
        L9:
            this.f383112b = r106;
            this.f383114d = a(r106);
            Path r107 = this.f383113c;
            if (r107 != null) goto L12;
            this.f383113c = new Path();
        L13:
            this.f383113c.addRoundRect(this.f383111a, this.f383112b, Path.Direction.CW);
            return;
        L12:
            r107.reset();
            goto L13
        L8:
            r106 = c(r101, r102, r103);
            goto L9
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f383116a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f383117b = null;

        static {
            int[] r100 = new int[BorderStyle.values().length];
            f383117b = r100;
            r100[BorderStyle.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L59:
            f383117b[BorderStyle.HIDDEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L41:
            f383117b[BorderStyle.DASHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L55:
            f383117b[BorderStyle.DOTTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L61:
            f383117b[BorderStyle.SOLID.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L45:
            f383117b[BorderStyle.INSET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L47:
            f383117b[BorderStyle.OUTSET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L67:
            f383117b[BorderStyle.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L39:
            f383117b[BorderStyle.GROOVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L63:
            f383117b[BorderStyle.RIDGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L17:
            int[] r101 = new int[RoundRectPath.Pos.values().length];
            f383116a = r101;
            r101[RoundRectPath.Pos.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L53:
            f383116a[RoundRectPath.Pos.INNER2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L57:
            f383116a[RoundRectPath.Pos.OUTER2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L65:
            f383116a[RoundRectPath.Pos.INNER3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L49:
            f383116a[RoundRectPath.Pos.OUTER3.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final a7a.k a() {
        return new a7a.e(this.f383138f, this, this.f383139g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int r100 = c.a(this.f383108y, this.f383109z) >>> 24;
        if (r100 != 255) goto L5;
        return -1;
    L5:
        if (r100 != 0) goto L7;
        return -2;
    L7:
        return -3;
    }

    public final Path l() {
        if (this.A != null) goto L5;
        return null;
    L5:
        if (s() == false) goto L12;
        RoundRectPath r100 = this.f383097n;
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.f383113c;
    L12:
        return null;
    }

    public final boolean s() {
        if (this.A != null) goto L6;
        return false;
    L6:
        if (this.f383106w == true) goto L8;
        return true;
    L8:
        Rect r100 = getBounds();
        if (r100.width() != 0) goto L11;
    L68:
        return false;
    L11:
        if (r100.height() == 0) goto L68;
        this.f383106w = false;
        RectF r110 = b();
        if (this.A == null) goto L16;
        Rect r101 = getBounds();
        this.A.d(r101.width(), r101.height());
    L16:
        BorderRadius r102 = this.A;
        if (r102 == null) goto L19;
        float[] r103 = r102.a();
    L20:
        float[] r111 = r103;
        if (this.f383097n != null) goto L23;
        this.f383097n = new RoundRectPath();
    L23:
        this.f383097n.d(r100, r111, r110, 1.0f, false);
        if (this.f383098o != null) goto L26;
        this.f383098o = new RoundRectPath();
    L26:
        this.f383098o.d(r100, r111, r110, 0.0f, false);
        BorderRadius r104 = this.A;
        if (r104 != null) goto L29;
    L50:
        Path r105 = this.f383100q;
        if (r105 != null) goto L53;
        this.f383100q = new Path();
    L54:
        this.f383100q.addRoundRect(new RectF(r100), RoundRectPath.c(r111, r110, -0.5f), Path.Direction.CW);
        RoundRectPath r106 = this.f383097n;
        RectF r107 = r106.f383111a;
        RectF r108 = this.f383098o.f383111a;
        float[] r109 = r106.f383112b;
        if (this.f383102s != null) goto L57;
        this.f383102s = new PointF();
    L57:
        PointF r112 = this.f383102s;
        RectF r113 = this.f383097n.f383111a;
        r112.x = r113.left;
        r112.y = r113.top;
        float r114 = r107.left;
        double r115 = r114;
        float r116 = r107.top;
        double r117 = r116;
        k(r115, r117, (r109[0] * 2.0f) + r114, (r109[1] * 2.0f) + r116, r108.left, r108.top, r115, r117, r112);
        if (this.f383105v != null) goto L60;
        this.f383105v = new PointF();
    L60:
        PointF r118 = this.f383105v;
        float r119 = r107.left;
        r118.x = r119;
        float r120 = r107.bottom;
        r118.y = r120;
        double r121 = r119;
        double r122 = r120;
        k(r121, r120 - (r109[6] * 2.0f), (r109[7] * 2.0f) + r119, r122, r108.left, r108.bottom, r121, r122, r118);
        if (this.f383103t != null) goto L63;
        this.f383103t = new PointF();
    L63:
        PointF r123 = this.f383103t;
        float r124 = r107.right;
        r123.x = r124;
        float r125 = r107.top;
        r123.y = r125;
        double r126 = r124 - (r109[2] * 2.0f);
        double r127 = r125;
        double r128 = r124;
        k(r126, r127, r128, (r109[3] * 2.0f) + r125, r108.right, r108.top, r128, r127, r123);
        if (this.f383104u != null) goto L66;
        this.f383104u = new PointF();
    L66:
        PointF r129 = this.f383104u;
        float r130 = r107.right;
        r129.x = r130;
        float r131 = r107.bottom;
        r129.y = r131;
        double r132 = r130;
        double r133 = r131;
        k(r130 - (r109[4] * 2.0f), r131 - (r109[5] * 2.0f), r132, r133, r108.right, r108.bottom, r132, r133, r129);
        return true;
    L53:
        r105.reset();
        goto L54
    L29:
        if (r104.b() == false) goto L50;
        r(RoundRectPath.Pos.CENTER, r100, r111, r110);
        if (this.f383095l == null) goto L50;
        int r134 = 0;
        boolean r135 = false;
        boolean r136 = false;
    L34:
        if (r134 > 8) goto L46;
        BorderStyle r137 = this.f383095l[r134];
        if (r137 == null) goto L45;
        if (r137 != BorderStyle.DOUBLE) goto L41;
        r135 = true;
        goto L45
    L41:
        if (r137 != BorderStyle.GROOVE) goto L43;
    L44:
        r136 = true;
        goto L45
    L43:
        if (r137 == BorderStyle.RIDGE) goto L44;
    L45:
        r134 = r134 + 1;
        goto L34
    L46:
        if (r135 == false) goto L48;
        r(RoundRectPath.Pos.INNER3, r100, r111, r110);
        r(RoundRectPath.Pos.OUTER3, r100, r111, r110);
    L48:
        if (r136 == false) goto L50;
        r(RoundRectPath.Pos.INNER2, r100, r111, r110);
        r(RoundRectPath.Pos.OUTER2, r100, r111, r110);
        goto L50
    L19:
        r103 = null;
        goto L20
    }

    public final boolean n() {
        RectF r100 = b();
        if (r100.left <= 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r100.top > 0.0f) goto L12;
        if (r100.right > 0.0f) goto L12;
        if (r100.bottom > 0.0f) goto L12;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f383109z;
    }

    public static int f(float r100) {
        if (r100 <= 0.1f) goto L8;
        if (r100 >= 1.0f) goto L8;
        return 1;
    L8:
        return Math.round(r100);
    }

    public static boolean o(BorderStyle r100) {
        if (r100 != BorderStyle.DASHED) goto L5;
    L10:
        return true;
    L5:
        if (r100 == BorderStyle.DOTTED) goto L10;
        if (r100 == BorderStyle.HIDDEN) goto L10;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r210) {
        if (this.f383091h == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        e();
        this.f383092i = false;
        this.f383091h = false;
    L11:
        int r101 = c.a(this.f383108y, this.f383109z);
        if (Color.alpha(r101) == 0) goto L81;
        this.f383107x.setColor(r101);
        this.f383107x.setStyle(Paint.Style.FILL);
        BorderRadius r102 = this.A;
        if (r102 != null) goto L16;
    L67:
        int r103 = ((a7a.e) this.f383137e).b();
        if (r103 == 4) goto L70;
        if (r103 != 1) goto L77;
        r210.drawRect(getBounds(), this.f383107x);
        goto L81
    L77:
        if (r103 != 0) goto L79;
        r210.drawRect(this.f383135c, this.f383107x);
        goto L81
    L79:
        r210.drawRect(this.f383136d, this.f383107x);
        goto L81
    L70:
        if (n() == true) goto L72;
        Path r104 = null;
    L73:
        if (r104 == null) goto L81;
        r210.drawPath(r104, this.f383107x);
        goto L81
    L72:
        RectF r105 = new RectF(getBounds());
        RectF r106 = new RectF(this.f383135c);
        r104 = new Path();
        r104.setFillType(Path.FillType.EVEN_ODD);
        r104.addRect(r105, Path.Direction.CW);
        r104.addRect(r106, Path.Direction.CCW);
        goto L73
    L16:
        if (r102.b() == false) goto L67;
        if (s() == false) goto L81;
        int r107 = ((a7a.e) this.f383137e).b();
        if (r107 == 1) goto L23;
        if (r107 != 0) goto L53;
        RoundRectPath r108 = this.f383097n;
        if (r108 == null) goto L53;
        r108.b(r210, this.f383107x);
    L53:
        if (r107 == 4) goto L55;
        r210.drawRect(this.f383136d, this.f383107x);
        goto L81
    L55:
        if (n() == true) goto L58;
    L63:
        Path r109 = null;
    L64:
        if (r109 == null) goto L81;
        r210.drawPath(r109, this.f383107x);
        goto L81
    L58:
        if (this.f383098o == null) goto L63;
        if (this.f383097n == null) goto L63;
        r109 = new Path();
        r109.setFillType(Path.FillType.EVEN_ODD);
        r109.addPath(this.f383098o.f383113c);
        r109.addPath(this.f383097n.f383113c);
        goto L64
    L23:
        if ((((Color.alpha(h(0)) & Color.alpha(h(1))) & Color.alpha(h(2))) & Color.alpha(h(3))) == 255) goto L25;
        boolean r110 = true;
    L26:
        if (r110 == false) goto L28;
    L41:
        boolean r111 = true;
    L42:
        if (r111 == false) goto L46;
        RoundRectPath r112 = this.f383098o;
        if (r112 == null) goto L46;
        r112.b(r210, this.f383107x);
    L46:
        RoundRectPath r113 = this.f383097n;
        if (r113 == null) goto L81;
        r113.b(r210, this.f383107x);
        goto L81
    L28:
        if (o(i(0)) == false) goto L30;
    L37:
        boolean r114 = true;
    L38:
        if (r114 == true) goto L41;
        r111 = false;
        goto L42
    L30:
        if (o(i(1)) == true) goto L37;
        if (o(i(2)) == true) goto L37;
        if (o(i(3)) == true) goto L37;
        r114 = false;
        goto L38
    L25:
        r110 = false;
    L81:
        if ((!((ArrayList) ((a7a.e) this.f383137e).f2094a).isEmpty()) == false) goto L98;
        r210.save();
        RectF r115 = new RectF(getBounds());
        RectF r116 = new RectF(this.f383135c);
        RectF r117 = new RectF(this.f383136d);
        if (this.A == null) goto L85;
        s();
    L85:
        RoundRectPath r118 = this.f383098o;
        if (r118 == null) goto L88;
        Path r119 = r118.f383113c;
    L89:
        RoundRectPath r120 = this.f383097n;
        if (r120 == null) goto L92;
        Path r121 = r120.f383113c;
    L93:
        a7a.e r122 = (a7a.e) this.f383137e;
        if (this.f383133a == null) goto L96;
        boolean r123 = true;
    L97:
        r122.a(r210, r115, r116, r117, r115, r119, r121, r123);
        r210.restore();
        goto L98
    L96:
        r123 = false;
        goto L97
    L92:
        r121 = null;
        goto L93
    L88:
        r119 = null;
    L98:
        BorderRadius r124 = this.A;
        if (r124 != null) goto L101;
    L213:
        RectF r125 = b();
        b.c(r210, this.f383107x, getBounds(), new int[]{f(r125.left), f(r125.top), f(r125.right), f(r125.bottom)}, new int[]{h(0), h(1), h(2), h(3)}, new BorderStyle[]{j(0), j(1), j(2), j(3)});
    L214:
        UIShadowProxy.a r126 = this.B;
        if (r126 != null) goto L217;
        return;
    L217:
        if (r126.f382378a == null) goto L248;
        int r127 = r210.save();
        r210.translate(-r126.f382379b, -r126.f382380c);
        UIShadowProxy.d r128 = r126.f382378a;
        ArrayList<UIShadowProxy.c> r129 = r128.f382411b;
        if (r129 == null) goto L223;
        if (r129.isEmpty() == true) goto L223;
    L225:
        ArrayList<UIShadowProxy.c> r130 = r128.f382411b;
        if (r130 == null) goto L235;
        int r131 = r130.size();
    L228:
        r131 = r131 - 1;
        if (r131 < 0) goto L235;
        UIShadowProxy.c r132 = (UIShadowProxy.c) ListProtector.get(r128.f382411b, r131);
        if (r132 == null) goto L228;
        if (r132.f382398k.a() == false) goto L228;
        r132.d(r210);
    L235:
        UIShadowProxy.b r133 = r128.f382412c;
        if (r133 == null) goto L238;
        r133.b(r210);
    L238:
        r210.restoreToCount(r127);
        return;
    L223:
        if (r128.f382412c != null) goto L225;
    L248:
        return;
    L101:
        if (r124.b() == false) goto L213;
        if (s() == false) goto L214;
        r210.save();
        RectF r134 = b();
        int r135 = f(r134.left);
        int r136 = f(r134.top);
        int r137 = f(r134.right);
        int r138 = f(r134.bottom);
        if (r136 > 0) goto L111;
        if (r138 > 0) goto L111;
        if (r135 > 0) goto L111;
        if (r137 > 0) goto L111;
    L212:
        r210.restore();
    L111:
        int r139 = h(8);
        int r140 = h(0);
        if (r140 == h(2)) goto L114;
    L118:
        boolean r141 = false;
    L119:
        if (r141 == true) goto L122;
        r140 = r139;
    L122:
        if (r136 != r135) goto L126;
        if (r138 != r135) goto L126;
        if (r137 != r135) goto L126;
        boolean r142 = true;
    L127:
        if (r142 == false) goto L162;
        if (r141 == false) goto L162;
        BorderStyle[] r143 = this.f383095l;
        if (r143 == null) goto L158;
        BorderStyle r144 = r143[8];
        BorderStyle r145 = r143[0];
        if (r145 != null) goto L136;
        r145 = r144;
    L136:
        BorderStyle r146 = r143[2];
        if (r146 != null) goto L140;
        r146 = r144;
    L140:
        if (r146 != r145) goto L157;
        BorderStyle r147 = r143[1];
        if (r147 != null) goto L146;
        r147 = r144;
    L146:
        if (r147 != r145) goto L157;
        BorderStyle r148 = r143[3];
        if (r148 == null) goto L151;
        r144 = r148;
    L151:
        if (r144 != r145) goto L157;
        if (r145 == null) goto L158;
        if (r145.isSolidDashedOrDotted() == true) goto L158;
    L157:
        boolean r149 = false;
    L159:
        if (r149 == false) goto L162;
        if (r135 <= 0) goto L162;
        float r150 = r135;
        p(r210, 1, r140, r150, r150);
    L158:
        r149 = true;
    L162:
        int r151 = h(0);
        int r152 = h(1);
        int r153 = h(2);
        int r154 = h(3);
        RectF r155 = this.f383098o.f383111a;
        float r156 = r155.left;
        float r157 = r155.right;
        float r158 = r155.top;
        float r159 = r155.bottom;
        if (r136 > 0) goto L165;
    L175:
        float r211 = r158;
        float r212 = r157;
        RectF r160 = r134;
    L176:
        if (r137 > 0) goto L178;
    L188:
        if (r138 > 0) goto L190;
    L200:
        if (r135 <= 0) goto L212;
        if (Color.alpha(r151) == 0) goto L212;
        PointF r161 = this.f383102s;
        float r162 = r161.x;
        float r163 = r161.y;
        PointF r164 = this.f383105v;
        float r165 = r164.x;
        float r166 = r164.y;
        float r167 = r160.left;
        if (r142 == true) goto L210;
        float r168 = Math.max(r167, Math.max(r160.top, r160.bottom));
        if ((r168 - Math.min(r160.top, r160.bottom)) < 2.0f) goto L208;
        boolean r169 = true;
    L209:
        boolean r170 = r169;
        float r171 = r168;
    L211:
        r210.save();
        g(r210, r156, r211, r162, r163, r165, r166, r156, r159, r170);
        p(r210, 0, r151, r160.left, r171);
        r210.restore();
        goto L212
    L208:
        r169 = false;
        goto L209
    L210:
        r171 = r167;
        r170 = false;
        goto L211
    L190:
        if (Color.alpha(r154) == 0) goto L200;
        PointF r172 = this.f383105v;
        float r173 = r172.x;
        float r174 = r172.y;
        PointF r175 = this.f383104u;
        float r176 = r175.x;
        float r177 = r175.y;
        float r178 = r160.bottom;
        if (r142 == true) goto L198;
        float r179 = Math.max(r178, Math.max(r160.left, r160.right));
        if ((r179 - Math.min(r160.left, r160.right)) < 2.0f) goto L196;
        boolean r180 = true;
    L197:
        float r181 = r179;
        boolean r182 = r180;
    L199:
        r210.save();
        g(r210, r156, r159, r173, r174, r176, r177, r212, r159, r182);
        p(r210, 3, r154, r160.bottom, r181);
        r210.restore();
        goto L200
    L196:
        r180 = false;
        goto L197
    L198:
        r181 = r178;
        r182 = false;
        goto L199
    L178:
        if (Color.alpha(r153) == 0) goto L188;
        PointF r183 = this.f383103t;
        float r184 = r183.x;
        float r185 = r183.y;
        PointF r186 = this.f383104u;
        float r187 = r186.x;
        float r188 = r186.y;
        float r189 = r160.right;
        if (r142 == true) goto L186;
        float r190 = Math.max(r189, Math.max(r160.top, r160.bottom));
        if ((r190 - Math.min(r160.top, r160.bottom)) < 2.0f) goto L184;
        boolean r191 = true;
    L185:
        float r192 = r190;
        boolean r193 = r191;
    L187:
        r210.save();
        g(r210, r212, r211, r184, r185, r187, r188, r212, r159, r193);
        p(r210, 2, r153, r160.right, r192);
        r210.restore();
        goto L188
    L184:
        r191 = false;
        goto L185
    L186:
        r192 = r189;
        r193 = false;
        goto L187
    L165:
        if (Color.alpha(r152) == 0) goto L175;
        PointF r194 = this.f383102s;
        float r195 = r194.x;
        float r196 = r194.y;
        PointF r197 = this.f383103t;
        float r198 = r197.x;
        float r199 = r197.y;
        float r1100 = r134.top;
        if (r142 == true) goto L173;
        float r200 = Math.max(r1100, Math.max(r134.left, r134.right));
        if ((r200 - Math.min(r134.left, r134.right)) < 2.0f) goto L171;
        boolean r201 = true;
    L172:
        r1100 = r200;
        boolean r213 = r201;
    L174:
        r210.save();
        r211 = r158;
        r212 = r157;
        r160 = r134;
        g(r210, r156, r158, r195, r196, r198, r199, r212, r211, r213);
        p(r210, 1, r152, r160.top, r1100);
        r210.restore();
        goto L176
    L171:
        r201 = false;
        goto L172
    L173:
        r213 = false;
    L126:
        r142 = false;
        goto L127
    L114:
        if (r140 != h(1)) goto L118;
        if (r140 != h(3)) goto L118;
        r141 = true;
        goto L119
    L5:
        if (this.f383092i == true) goto L8;
        r100 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r100) {
        if (this.A != null) goto L5;
    L10:
        r100.setRect(getBounds());
        return;
    L5:
        if (s() == false) goto L10;
        Path r101 = this.f383100q;
        if (r101 == null) goto L10;
        r100.setConvexPath(r101);
    }

    public final int h(int r100) {
        k r101 = this.f383093j;
        if (r101 == null) goto L5;
        float r102 = r101.a(r100);
    L6:
        k r103 = this.f383094k;
        if (r103 == null) goto L9;
        float r104 = r103.a(r100);
    L10:
        int r105 = (((int) r104) << 24) & (-16777216);
        return r105 | (((int) r102) & 16777215);
    L9:
        r104 = 255.0f;
        goto L10
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final BorderStyle i(int r100) {
        if (r100 > 8) goto L13;
        if (r100 < 0) goto L15;
        BorderStyle[] r101 = this.f383095l;
        if (r101 == null) goto L16;
        BorderStyle r102 = r101[r100];
        if (r102 == null) goto L12;
        return r102;
    L12:
        return r101[8];
    L16:
        return null;
    L15:
        return null;
    L13:
        return null;
    }

    public final BorderStyle j(int r100) {
        BorderStyle[] r101 = this.f383095l;
        if (r101 != null) goto L5;
        BorderStyle r102 = null;
    L9:
        if (r102 == null) goto L11;
        return r102;
    L11:
        if (this.f383138f.getCssAlignWithLegacyW3c() == false) goto L14;
        return BorderStyle.NONE;
    L14:
        return BorderStyle.SOLID;
    L5:
        r102 = r101[r100];
        if (r102 != null) goto L9;
        r102 = r101[8];
        goto L9
    }

    public final RoundRectPath m(RoundRectPath.Pos r100) {
        if (r100 == null) goto L8;
        Map<RoundRectPath.Pos, RoundRectPath> r101 = this.f383099p;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (RoundRectPath) ((HashMap) r101).get(r100);
    L8:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        this.f383106w = true;
        super.onBoundsChange(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (r100 == this.f383109z) goto L6;
        this.f383109z = r100;
        invalidateSelf();
        return;
    }

    public void setColor(int r100) {
        this.f383108y = r100;
        invalidateSelf();
    }

    public BackgroundDrawable(LynxContext r100, float r101) {
        super(r100, r101);
        this.f383091h = false;
        this.f383092i = false;
        this.f383106w = true;
        this.f383107x = new Paint(1);
        this.f383108y = 0;
        this.f383109z = 255;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final boolean c(int r100, float r101) {
        boolean r102 = super.c(r100, r101);
        if (r102 == false) goto L5;
        this.f383106w = true;
        this.f383092i = true;
    L5:
        return r102;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final boolean d(float r100, float r101, float r102, float r103) {
        boolean r104 = super.d(r100, r101, r102, r103);
        if (r104 == false) goto L5;
        this.f383106w = true;
        this.f383091h = true;
    L5:
        return r104;
    }

    public final void r(RoundRectPath.Pos r100, Rect r101, float[] r102, RectF r110) {
        if (r100 == null) goto L16;
        Map<RoundRectPath.Pos, RoundRectPath> r103 = this.f383099p;     // Catch: Exception -> L11
        if (r103 == null) goto L6;
        RoundRectPath r104 = (RoundRectPath) ((HashMap) r103).get(r100);     // Catch: Exception -> L11
    L7:
        if (r104 != null) goto L9;
        r104 = new RoundRectPath();     // Catch: Exception -> L11
        ((HashMap) this.f383099p).put(r100, r104);     // Catch: Exception -> L11
    L9:
        r104.d(r101, r102, r110, r100.getOffset(), true);     // Catch: Exception -> L11
        return;
    L6:
        this.f383099p = new HashMap();     // Catch: Exception -> L11
        r104 = null;
    L11:
        e = move-exception;
        LLog.e("BackgroundDrawable", "updateCachePath exception:" + e.toString());
        return;
    }

    public final void p(Canvas r110, int r111, int r112, float r113, float r114) {
        BorderStyle[] r100 = this.f383095l;
        if (r100 != null) goto L5;
        BorderStyle r101 = null;
    L9:
        if (r101 == null) goto L11;
    L14:
        this.f383096m = null;
        switch(a.f383117b[r101.ordinal()]) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L31;
            case 5: goto L33;
            case 6: goto L28;
            case 7: goto L24;
            case 8: goto L21;
            case 9: goto L19;
            case 10: goto L17;
            default: goto L33;
        };
    L17:
        q(r110, r111, r113 / 2.0f, (r112 & (-16777216)) | ((r112 & 16711422) >> 1), r112, false);
        return;
    L19:
        q(r110, r111, r113 / 2.0f, r112, (r112 & (-16777216)) | ((r112 & 16711422) >> 1), false);
        return;
    L21:
        q(r110, r111, r113 / 3.0f, r112, r112, true);
        return;
    L28:
        if (r111 != 1) goto L29;
    L27:
        int r102 = ((r112 & 16711422) >> 1) | (r112 & (-16777216));
    L34:
        this.f383107x.setStyle(Paint.Style.STROKE);
        this.f383107x.setColor(c.a(r102, this.f383109z));
        this.f383107x.setStrokeWidth(r114);
        this.f383107x.setPathEffect(this.f383096m);
        this.f383107x.setAntiAlias(true);
        RoundRectPath r103 = m(RoundRectPath.Pos.CENTER);
        if (r103 == null) goto L37;
        r103.b(r110, this.f383107x);
    L37:
        this.f383107x.setPathEffect(null);
        return;
    L29:
        if (r111 != 0) goto L33;
    L31:
        this.f383096m = r101.getPathEffect(r113);
        goto L33
    L32:
        return;
    L33:
        r102 = r112;
        goto L34
    L24:
        if (r111 == 3) goto L27;
        if (r111 != 2) goto L33;
    L11:
        if (this.f383138f.getCssAlignWithLegacyW3c() == false) goto L13;
        r101 = BorderStyle.NONE;
        goto L14
    L13:
        r101 = BorderStyle.SOLID;
        goto L14
    L5:
        r101 = r100[r111];
        if (r101 != null) goto L9;
        r101 = r100[8];
        goto L9
    }

    public final void q(Canvas r100, int r101, float r102, int r103, int r104, boolean r105) {
        this.f383107x.setPathEffect(null);
        this.f383107x.setStyle(Paint.Style.STROKE);
        this.f383107x.setStrokeWidth(r102);
        boolean r106 = true;
        if (r101 == 1) goto L7;
        if (r101 == 0) goto L7;
        r106 = false;
    L7:
        Paint r107 = this.f383107x;
        if (r106 == false) goto L10;
        int r108 = r104;
    L11:
        r107.setColor(c.a(r108, this.f383109z));
        if (r105 == false) goto L14;
        RoundRectPath.Pos r109 = RoundRectPath.Pos.OUTER3;
    L15:
        RoundRectPath r110 = m(r109);
        if (r110 == null) goto L18;
        r110.b(r100, this.f383107x);
    L18:
        Paint r111 = this.f383107x;
        if (r106 == true) goto L22;
        r103 = r104;
    L22:
        r111.setColor(c.a(r103, this.f383109z));
        if (r105 == false) goto L25;
        RoundRectPath.Pos r112 = RoundRectPath.Pos.INNER3;
    L26:
        RoundRectPath r113 = m(r112);
        if (r113 == null) goto L30;
        r113.b(r100, this.f383107x);
        return;
    L30:
        return;
    L25:
        r112 = RoundRectPath.Pos.INNER2;
        goto L26
    L14:
        r109 = RoundRectPath.Pos.OUTER2;
        goto L15
    L10:
        r108 = r103;
        goto L11
    }

    public static void k(double r210, double r211, double r212, double r213, double r214, double r310, double r311, double r312, PointF r313) {
        double r100 = (r210 + r212) / 2.0d;
        double r101 = (r211 + r213) / 2.0d;
        double r102 = r214 - r100;
        double r103 = r310 - r101;
        double r110 = Math.abs(r212 - r210) / 2.0d;
        double r111 = Math.abs(r213 - r211) / 2.0d;
        double r112 = ((r312 - r101) - r103) / ((r311 - r100) - r102);
        double r104 = r103 - (r102 * r112);
        double r113 = r111 * r111;
        double r105 = r110 * r110;
        double r114 = r113 + ((r105 * r112) * r112);
        double r106 = (((r110 * 2.0d) * r110) * r104) * r112;
        double r107 = (-(r105 * ((r104 * r104) - r113))) / r114;
        double r115 = r114 * 2.0d;
        double r108 = (-r106) / r115;
        double r109 = r108 - Math.sqrt(r107 + Math.pow(r106 / r115, 2.0d));
        double r116 = (r112 * r109) + r104;
        double r117 = r109 + r100;
        double r118 = r116 + r101;
        if (Double.isNaN(r117) == false) goto L5;
        return;
    L5:
        if (Double.isNaN(r118) == true) goto L9;
        r313.x = (float) r117;
        r313.y = (float) r118;
        return;
    }

    public final void g(Canvas r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r110, boolean r111) {
        if (r111 == false) goto L10;
        RoundRectPath r112 = this.f383098o;
        if (r112 == null) goto L6;
        r100.clipPath(r112.f383113c, Region.Op.INTERSECT);
    L6:
        RoundRectPath r113 = this.f383097n;
        if (r113 == null) goto L10;
        r100.clipPath(r113.f383113c, Region.Op.DIFFERENCE);
    L10:
        if (this.f383101r != null) goto L12;
        this.f383101r = new Path();
    L12:
        this.f383101r.reset();
        this.f383101r.moveTo(r101, r102);
        this.f383101r.lineTo(r103, r104);
        this.f383101r.lineTo(r105, r106);
        this.f383101r.lineTo(r107, r110);
        this.f383101r.lineTo(r101, r102);
        r100.clipPath(this.f383101r);
    }
}
