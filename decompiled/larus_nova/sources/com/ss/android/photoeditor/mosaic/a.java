package com.ss.android.photoeditor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import pfc.f;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends AbstractMosaicStrategy {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f449304o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f449305p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[][] f449306q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public tfc.b f449307r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public tfc.b f449308s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RectF f449309t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f449310u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f449311v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f449312w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f449313x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f449314y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<C5438a.C5439a> f449315z;

    /* JADX INFO: renamed from: com.ss.android.photoeditor.mosaic.a$a, reason: collision with other inner class name */
    public static class C5438a extends f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<C5439a> f449316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f449317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RectF f449318e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f449319f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f449320g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RectF f449321h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RectF f449322i;

        /* JADX INFO: renamed from: com.ss.android.photoeditor.mosaic.a$a$a, reason: collision with other inner class name */
        public static class C5439a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int[][] f449323a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int[][][] f449324b;

            public C5439a(int[][] r100, int[][][] r101) {
                this.f449323a = r100;
                this.f449324b = r101;
            }
        }

        @Override // pfc.f.a
        public final Bitmap d() {
            Bitmap r100 = Bitmap.createBitmap((int) this.f449321h.width(), (int) this.f449321h.height(), Bitmap.Config.ARGB_4444);
            Canvas r101 = new Canvas(r100);
            char r102 = 0;
            int r103 = 0;
        L4:
            if (r103 >= ((ArrayList) this.f449316c).size()) goto L31;
            C5439a r104 = (C5439a) ListProtector.get(this.f449316c, r103);
            int[][] r105 = r104.f449323a;
            int[][][] r106 = r104.f449324b;
            int r107 = this.f449319f / this.f449320g;
            Paint r108 = new Paint();
            char r109 = 1;
            r108.setAntiAlias(true);
            int r110 = 0;
        L6:
            if (r110 >= r107) goto L30;
            int r111 = this.f449320g * r110;
            int r112 = 0;
        L8:
            if (r112 >= r107) goto L29;
            int r113 = r105[r111][this.f449320g * r112];
            if (r113 == 0) goto L28;
            r108.setColor(r113);
            int[] r114 = r106[r110][r112];
            int r115 = r114[r102];
            int r116 = r114[r109];
            int r117 = this.f449320g;
            int r118 = r115 + r117;
            int r119 = r117 + r116;
            float r120 = r115;
            RectF r121 = this.f449321h;
            float r122 = r121.right;
            if (r120 < r122) goto L15;
            r115 = (int) (r122 - 1.0f);
        L15:
            float r123 = r116;
            float r124 = r121.bottom;
            if (r123 < r124) goto L19;
            r116 = (int) (r124 - 1.0f);
        L19:
            if (r118 < r122) goto L22;
            r118 = (int) (r122 - 1.0f);
        L22:
            if (r119 < r124) goto L25;
            r119 = (int) (r124 - 1.0f);
        L25:
            if (this.f449322i != null) goto L27;
            this.f449322i = new RectF();
        L27:
            RectF r125 = this.f449322i;
            float r126 = r115;
            RectF r127 = this.f449321h;
            float r128 = r127.left;
            float r129 = r127.top;
            r125.set(r126 - r128, r116 - r129, r118 - r128, r119 - r129);
            r101.drawRect(this.f449322i, r108);
        L28:
            r112 = r112 + 1;
            r106 = r106;
            r105 = r105;
            r102 = 0;
            r109 = 1;
            goto L8
        L29:
            r110 = r110 + 1;
            r102 = 0;
            r109 = 1;
            goto L6
        L30:
            r103 = r103 + 1;
            r102 = 0;
            goto L4
        L31:
            Bitmap r130 = Bitmap.createBitmap((int) this.f449318e.width(), (int) this.f449318e.height(), Bitmap.Config.ARGB_4444);
            Canvas r131 = new Canvas(r130);
            Matrix r132 = new Matrix();
            float r133 = this.f449317d.width() / this.f449321h.width();
            r132.postScale(r133, r133);
            RectF r134 = this.f449317d;
            float r135 = r134.left;
            RectF r136 = this.f449318e;
            r132.postTranslate(r135 - r136.left, r134.top - r136.top);
            r131.drawBitmap(r100, r132, null);
            return r130;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return this.f449318e;
        }

        @Override // pfc.f.a
        public final RectF f() {
            return this.f449317d;
        }

        @Override // pfc.f.a
        public final f.b c(f.b r100) {
            new RectF(r100.f529058a);
            new RectF(r100.f529059b);
            return r100;
        }

        public C5438a(List<C5439a> r100, RectF r101, int r102, int r103, RectF r104, RectF r105) {
            this.f449322i = new RectF();
            this.f449316c = new ArrayList(r100);
            this.f449317d = new RectF(r101);
            this.f449319f = r102;
            this.f449320g = r103;
            this.f449321h = new RectF(r104);
            this.f449318e = r105;
        }
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void c() {
        Paint r100 = new Paint();
        r100.reset();
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        r100.setPathEffect(new CornerPathEffect(10.0f));
        r100.setStrokeWidth(this.f449305p);
        r100.setStrokeJoin(Paint.Join.ROUND);
        r100.setStrokeCap(Paint.Cap.ROUND);
        if (this.f449305p != 0) goto L5;
        d(128);
    L5:
        this.f449246b = Bitmap.createBitmap((int) this.f449249e.width(), (int) this.f449249e.height(), Bitmap.Config.ARGB_4444);
        this.f449247c = new Canvas(this.f449246b);
        this.f449258n = true;
    }

    public a(Context r100) {
        super(r100);
        this.f449304o = 3;
        this.f449307r = new tfc.b(0.0f, 0.0f);
        this.f449308s = new tfc.b(0.0f, 0.0f);
        this.f449314y = false;
        this.f449315z = new ArrayList();
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void b(MotionEvent r110) {
        if (this.f449245a != null) goto L5;
        return;
    L5:
        if (this.f449246b == null) goto L60;
        int r100 = r110.getAction();
        if (r100 != 0) goto L10;
        this.f449314y = false;
        this.f449312w = r110.getX();
        this.f449313x = r110.getY();
        ((ArrayList) this.f449315z).clear();
        this.f449307r = new tfc.b(r110.getX(), r110.getY());
        return;
    L10:
        if (r100 == 1) goto L49;
        if (r100 == 2) goto L15;
        return;
    L15:
        if (this.f449314y == false) goto L17;
    L18:
        this.f449314y = true;
        float r101 = r110.getX();
        float r111 = r110.getY();
        tfc.b r102 = new tfc.b(r101, r111);
        this.f449308s = r102;
        tfc.b r103 = this.f449307r;
        float r104 = r102.f545815a - r103.f545815a;
        if (r104 != 0.0f) goto L21;
        r104 = 1.0f;
    L21:
        float r105 = (float) ((Math.atan(Math.abs((r102.f545816b - r103.f545816b) / r104)) * 180.0d) / 3.141592653589793d);
        float r106 = r102.f545816b;
        float r107 = r103.f545816b;
        if (r106 > r107) goto L27;
        if (r102.f545815a < r103.f545815a) goto L27;
        r105 = -r105;
    L37:
        if (Math.random() <= 0.5d) goto L39;
        double r108 = ((double) r105) + ((Math.random() * 10.0d) + 10.0d);
    L40:
        float r109 = (float) r108;
        this.f449308s.f545817c = r109;
        tfc.b r112 = this.f449307r;
        float r113 = r101 - r112.f545815a;
        float r114 = r111 - r112.f545816b;
        if (((int) Math.sqrt((r113 * r113) + (r114 * r114))) <= this.f449305p) goto L45;
        tfc.b r115 = this.f449307r;
        float r116 = r101 - r115.f545815a;
        float r117 = r111 - r115.f545816b;
        int r118 = ((int) Math.sqrt((r116 * r116) + (r117 * r117))) / this.f449305p;
        int r119 = 1;
    L43:
        if (r119 >= r118) goto L45;
        tfc.b r120 = this.f449307r;
        float r121 = r120.f545815a;
        float r122 = r119;
        float r123 = r118;
        float r124 = r120.f545816b;
        g(this.f449247c, new tfc.b(r121 + ((((r101 - r121) * r122) / r123) * 1.0f), r124 + ((((r111 - r124) * r122) / r123) * 1.0f), r109));
        this.f449256l.a(this.f449246b, true);
        r119 = r119 + 1;
    L45:
        tfc.b r125 = this.f449307r;
        float r126 = r101 - r125.f545815a;
        float r127 = r111 - r125.f545816b;
        if (((int) Math.sqrt((r126 * r126) + (r127 * r127))) <= 20) goto L56;
        g(this.f449247c, this.f449308s);
        this.f449307r = this.f449308s;
        this.f449256l.a(this.f449246b, true);
        return;
    L56:
        return;
    L39:
        r108 = ((double) r105) - ((Math.random() * 10.0d) + 10.0d);
    L27:
        if (r106 > r107) goto L32;
        if (r102.f545815a > r103.f545815a) goto L32;
        r105 = -(180.0f - r105);
    L32:
        if (r106 < r107) goto L37;
        if (r102.f545815a > r103.f545815a) goto L37;
        r105 = 180.0f - r105;
        goto L37
    L17:
        if (pfc.a.a(this.f449257m, this.f449312w, this.f449313x, r110.getX(), r110.getY()) == true) goto L18;
        return;
    L49:
        if (this.f449314y == false) goto L58;
        this.f449256l.a(this.f449246b, true);
        f.i().a(new C5438a(this.f449315z, this.f449250f, this.f449305p, this.f449304o, this.f449249e, new RectF(0.0f, 0.0f, this.f449251g.width(), this.f449251g.height())));
        ((ArrayList) this.f449315z).clear();
        return;
    L58:
        return;
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void d(int r100) {
        this.f449305p = (int) (r100 * 1.4f);
        Bitmap r101 = BitmapFactory.decodeResource(this.f449257m.getResources(), R.drawable.photo_editor_mosaic_brush);
        int r102 = this.f449305p;
        if (r101 != null) goto L5;
        Bitmap r103 = null;
    L6:
        int r104 = this.f449305p;
        this.f449306q = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r104, r104});
        int r105 = 0;
    L8:
        if (r105 >= this.f449305p) goto L14;
        int r106 = 0;
    L11:
        if (r106 >= this.f449305p) goto L13;
        this.f449306q[r105][r106] = Color.alpha(r103.getPixel(r105, r106));
        r106 = r106 + 1;
        goto L11
    L13:
        r105 = r105 + 1;
        goto L8
    L14:
        r103.recycle();
        return;
    L5:
        int r107 = r101.getWidth();
        int r108 = r101.getHeight();
        float r109 = r102;
        float r110 = Math.max(r109 / r107, r109 / r108);
        Matrix r111 = new Matrix();
        r111.postScale(r110, r110);
        Bitmap r112 = Bitmap.createBitmap(r101, 0, 0, r107, r108, r111, true);
        r101.recycle();
        r103 = r112;
        goto L6
    }

    public final void g(Canvas r210, tfc.b r211) {
        r210.drawColor(0, PorterDuff.Mode.CLEAR);
        float r100 = this.f449249e.width() / this.f449250f.width();
        float r101 = r211.f545815a;
        RectF r102 = this.f449250f;
        float r103 = (r101 - r102.left) * r100;
        RectF r104 = this.f449249e;
        float r105 = r103 + r104.left;
        float r106 = r211.f545816b;
        float r107 = ((r106 - r102.top) * r100) + r104.top;
        this.f449310u = r101;
        this.f449311v = r106;
        r211.f545815a = r105;
        r211.f545816b = r107;
        float r108 = (float) ((((double) r211.f545817c) * 3.141592653589793d) / 180.0d);
        int r109 = this.f449305p;
        int[][] r110 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r109, r109});
        int r111 = this.f449305p / 2;
        int r112 = 0;
    L4:
        if (r112 >= this.f449305p) goto L33;
        int r113 = 0;
    L6:
        int r114 = this.f449305p;
        if (r113 >= r114) goto L32;
        if (r112 < r114) goto L10;
        r112 = r114 - 1;
    L10:
        if (r113 < r114) goto L13;
        r113 = r114 - 1;
    L13:
        if (r108 == 0.0f) goto L20;
        double r115 = r112 - r111;
        double r116 = r108;
        int r117 = r112;
        double r118 = r113 - r111;
        float r119 = r108;
        double r120 = r111;
        int r212 = r111;
        float r121 = (int) (((Math.cos(r116) * r115) - (Math.sin(r116) * r118)) + r120);
        float r122 = (int) (((r115 * Math.sin(r116)) + (r118 * Math.cos(r116))) + r120);
        int r123 = (int) r121;
        int r124 = (int) r122;
        if ((r121 - r123) <= 0.5d) goto L18;
        r123 = r123 + 1;
    L18:
        if ((r122 - r124) <= 0.5d) goto L21;
        r124 = r124 + 1;
    L21:
        int r125 = this.f449305p;
        if (r123 < r125) goto L24;
        r123 = r125 - 1;
    L24:
        if (r124 < r125) goto L26;
        int r126 = r125 - 1;
    L27:
        if (r123 >= 0) goto L29;
        r123 = 0;
    L29:
        if (r126 >= 0) goto L31;
        r126 = 0;
    L31:
        r110[r123][r126] = this.f449306q[r117][r113];
        r113 = r113 + 1;
        r112 = r117;
        r108 = r119;
        r111 = r212;
        goto L6
    L26:
        r126 = r124;
        goto L27
    L20:
        r119 = r108;
        r212 = r111;
        r117 = r112;
        r124 = r113;
        r123 = r117;
        goto L21
    L32:
        r112 = r112 + 1;
        goto L4
    L33:
        int r127 = 0;
    L35:
        if (r127 >= r110.length) goto L70;
        int[] r128 = r110[r127];
        int r129 = 0;
    L38:
        if (r129 >= (r128.length - 3)) goto L45;
        if (r128[r129] <= 3) goto L44;
        if (r128[r129 + 1] > 3) goto L45;
    L44:
        r129 = r129 + 1;
    L45:
        int[] r130 = r110[r127];
        int r131 = r130.length - 1;
    L46:
        if (r131 <= 3) goto L53;
        if (r130[r131] <= 3) goto L52;
        if (r130[r131 - 1] > 3) goto L53;
    L52:
        r131 = r131 - 1;
    L53:
        if (r129 >= r131) goto L69;
        int[] r132 = r110[r127];
    L55:
        r129 = r129 + 1;
        if (r129 >= r131) goto L69;
        int r133 = r132[r129];
        if (r133 == 0) goto L59;
        r132[r129] = r133 + 50;
        goto L55
    L59:
        int r134 = r129;
    L60:
        if (r134 <= 3) goto L67;
        if (r132[r134] <= 3) goto L66;
        if (r132[r134 - 1] > 3) goto L67;
    L66:
        r134 = r134 - 1;
    L67:
        r132[r129] = r132[r134] + 16;
    L69:
        r127 = r127 + 1;
        goto L35
    L70:
        int r135 = this.f449305p;
        int[][] r136 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r135, r135});
        float r137 = r211.f545815a;
        RectF r138 = this.f449249e;
        int r139 = (int) (r137 - r138.left);
        int r140 = (int) (r211.f545816b - r138.top);
        if (r139 >= 0) goto L73;
        r139 = 0;
    L73:
        if (r140 >= 0) goto L75;
        r140 = 0;
    L75:
        float r141 = (this.f449245a.getWidth() / this.f449249e.width()) * r139;
        float r142 = (this.f449245a.getHeight() / this.f449249e.height()) * r140;
        Bitmap r143 = this.f449245a;
        int r144 = r143.getPixel(Math.min((int) r141, r143.getWidth() - 1), Math.min((int) r142, this.f449245a.getHeight() - 1));
        int r145 = Color.red(r144);
        int r146 = Color.green(r144);
        int r147 = Color.blue(r144);
        int r148 = this.f449305p / this.f449304o;
        int r149 = 0;
    L76:
        if (r149 >= r148) goto L85;
        int r150 = 0;
    L78:
        if (r150 >= r148) goto L84;
        int r151 = this.f449304o;
        int r152 = r149 * r151;
        int r153 = r151 * r150;
        int r154 = r110[r152][r153];
        if (r154 == 0) goto L83;
        r136[r152][r153] = Color.argb(r154, r145, r146, r147);
    L83:
        r150 = r150 + 1;
        goto L78
    L84:
        r149 = r149 + 1;
        goto L76
    L85:
        float r155 = r211.f545815a;
        int r156 = this.f449305p;
        float r157 = r156 / 2;
        int r158 = (int) (r155 - r157);
        int r159 = (int) (r211.f545816b - r157);
        float r160 = r158;
        RectF r161 = this.f449249e;
        float r162 = r161.left;
        if (r160 >= r162) goto L88;
        r158 = (int) r162;
    L88:
        float r163 = r159;
        float r164 = r161.top;
        if (r163 >= r164) goto L91;
        r159 = (int) r164;
    L91:
        int r165 = r156 / this.f449304o;
        int[][][] r166 = (int[][][]) Array.newInstance(Integer.TYPE, new int[]{r165, r165, 2});
        int r167 = 0;
    L92:
        if (r167 >= r165) goto L97;
        int r168 = this.f449304o * r167;
        int r169 = 0;
    L94:
        if (r169 >= r165) goto L96;
        int r170 = (this.f449304o * r169) + r159;
        int[] r171 = r166[r167][r169];
        r171[0] = r158 + r168;
        r171[1] = r170;
        r169 = r169 + 1;
        goto L94
    L96:
        r167 = r167 + 1;
        goto L92
    L97:
        r211.f545815a = this.f449310u;
        r211.f545816b = this.f449311v;
        ((ArrayList) this.f449315z).add(new C5438a.C5439a(r136, r166));
        int r172 = this.f449305p / this.f449304o;
        Paint r173 = new Paint();
        r173.setAntiAlias(true);
        int r174 = 0;
    L98:
        if (r174 >= r172) goto L122;
        int r175 = this.f449304o * r174;
        int r176 = 0;
    L100:
        if (r176 >= r172) goto L121;
        int r177 = r136[r175][this.f449304o * r176];
        if (r177 == 0) goto L120;
        r173.setColor(r177);
        int[] r178 = r166[r174][r176];
        int r179 = r178[0];
        int r180 = r178[1];
        int r181 = this.f449304o;
        int r182 = r179 + r181;
        int r183 = r181 + r180;
        float r184 = r179;
        RectF r185 = this.f449249e;
        float r186 = r185.right;
        if (r184 < r186) goto L107;
        r179 = (int) (r186 - 1.0f);
    L107:
        float r187 = r180;
        float r188 = r185.bottom;
        if (r187 < r188) goto L111;
        r180 = (int) (r188 - 1.0f);
    L111:
        if (r182 < r186) goto L114;
        r182 = (int) (r186 - 1.0f);
    L114:
        if (r183 < r188) goto L117;
        r183 = (int) (r188 - 1.0f);
    L117:
        if (this.f449309t != null) goto L119;
        this.f449309t = new RectF();
    L119:
        RectF r189 = this.f449309t;
        RectF r190 = this.f449249e;
        float r191 = r190.left;
        float r192 = r190.top;
        r189.set(r179 - r191, r180 - r192, r182 - r191, r183 - r192);
        r210.drawRect(this.f449309t, r173);
    L120:
        r176 = r176 + 1;
        goto L100
    L121:
        r174 = r174 + 1;
        goto L98
    }
}
