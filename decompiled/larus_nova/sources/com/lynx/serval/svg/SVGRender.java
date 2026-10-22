package com.lynx.serval.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.lynx.serval.svg.model.FillPaintModel;
import com.lynx.serval.svg.model.GradientModel;
import com.lynx.serval.svg.model.LinearGradientModel;
import com.lynx.serval.svg.model.PaintRef;
import com.lynx.serval.svg.model.RadialGradientModel;
import com.lynx.serval.svg.model.StopModel;
import com.lynx.serval.svg.model.StrokePaintModel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class SVGRender {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f381465h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f381466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Pair<String, GradientModel>> f381467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SVGRenderEngine f381468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f381469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f381470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f381471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f381472g;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f381473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f381474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f381475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f381476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f381477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f381478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f381479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SVGRender f381480h;

        public final void a(Bitmap r110) {
            if (r110 != null) goto L4;
            return;
        L4:
            float r100 = r110.getWidth();
            float r101 = r110.getHeight();
            float r102 = this.f381473a;
            if (r102 <= 0.0f) goto L22;
            float r103 = this.f381474b;
            if (r103 > 0.0f) goto L9;
            return;
        L9:
            if (r100 > 0.0f) goto L11;
            return;
        L11:
            if (r101 <= 0.0f) goto L25;
            SVGRenderEngine r104 = this.f381480h.f381468c;
            if (r104 == null) goto L26;
            float[] r105 = r104.calculateViewBoxTransform(this.f381475c, this.f381476d, r102, r103, 0.0f, 0.0f, r100, r101, this.f381477e, this.f381478f, this.f381479g);
            if (r105 != null) goto L17;
            return;
        L17:
            if (r105.length == 6) goto L19;
            return;
        L19:
            if (this.f381480h.f381466a == null) goto L29;
            float[] r106 = {r105[0], r105[2], r105[4], r105[1], r105[3], r105[5], 0.0f, 0.0f, 1.0f};
            Matrix r107 = new Matrix();
            r107.setValues(r106);
            this.f381480h.f381466a.concat(r107);
            this.f381480h.f381466a.drawBitmap(r110, 0.0f, 0.0f, new Paint(2));
            return;
        L29:
            return;
        L26:
            return;
        L25:
            return;
        }

        public a(SVGRender r100, float r101, float r102, float r103, float r104, int r105, int r106, int r107) {
            this.f381480h = r100;
            this.f381473a = r101;
            this.f381474b = r102;
            this.f381475c = r103;
            this.f381476d = r104;
            this.f381477e = r105;
            this.f381478f = r106;
            this.f381479g = r107;
        }
    }

    public interface b {
    }

    public interface c {
        void a(String r100, a r101);
    }

    public void applyLuminanceToAlpha() {
    }

    public void setViewBox(float r100, float r101, float r102, float r103) {
    }

    static {
        f381465h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f};
    }

    public void restore() {
        Canvas r100 = this.f381466a;
        if (r100 == null) goto L6;
        r100.restore();
        return;
    }

    public void restoreLayer() {
        Canvas r100 = this.f381466a;
        if (r100 == null) goto L6;
        r100.restore();
        return;
    }

    public void save() {
        Canvas r100 = this.f381466a;
        if (r100 == null) goto L6;
        r100.save();
        return;
    }

    public SVGRender() {
        this.f381470e = null;
        this.f381471f = false;
        this.f381472g = false;
        this.f381468c = SVGRenderEngine.getInstance();
        this.f381467b = new HashMap();
    }

    public String getColor() {
        return this.f381470e;
    }

    public static Paint a(FillPaintModel r100) {
        Paint r101 = new Paint();
        r101.setStyle(Paint.Style.FILL);
        r101.setTypeface(Typeface.DEFAULT);
        r101.setFlags(193);
        r101.setHinting(0);
        if (r100 == null) goto L5;
        r101.setColor(getColorWithOpacity(r100.mColor, r100.mOpacity));
    L5:
        return r101;
    }

    public static float[] calculatePathBoundsArray(Path r100) {
        RectF r101 = new RectF();
        r100.computeBounds(r101, true);
        return new float[]{r101.left, r101.top, r101.width(), r101.height()};
    }

    public static int clampOpacity(float r100) {
        return Math.max(0, Math.min((int) (r100 * 256.0f), 255));
    }

    public static Paint d(StrokePaintModel r110) {
        Paint r100 = new Paint();
        r100.setStyle(Paint.Style.STROKE);
        r100.setTypeface(Typeface.DEFAULT);
        r100.setFlags(193);
        int r101 = 0;
        r100.setHinting(0);
        if (r110 == null) goto L40;
        r100.setColor(getColorWithOpacity(r110.mColor, r110.mOpacity));
        r100.setStrokeWidth(r110.mWith);
        int r102 = r110.mStrokeLineCap;
        if (r102 == 0) goto L11;
        if (r102 == 1) goto L10;
        if (r102 != 2) goto L12;
        r100.setStrokeCap(Paint.Cap.SQUARE);
    L12:
        int r103 = r110.mStrokeLineJoin;
        if (r103 == 0) goto L19;
        if (r103 == 1) goto L18;
        if (r103 != 2) goto L20;
        r100.setStrokeJoin(Paint.Join.BEVEL);
    L20:
        r100.setStrokeMiter(r110.mStrokeMiterLimit);
        float[] r104 = r110.mStrokeDashArray;
        if (r104 != null) goto L23;
    L39:
        r100.setPathEffect(null);
        goto L40
    L23:
        if (r104.length == 0) goto L39;
        int r105 = r104.length;
        if ((r105 % 2) != 0) goto L28;
        int r106 = r105;
    L29:
        float[] r107 = new float[r106];
        float r108 = 0.0f;
    L30:
        if (r101 >= r106) goto L33;
        float r109 = r104[r101 % r105];
        r107[r101] = r109;
        r108 = r108 + r109;
        r101 = r101 + 1;
        goto L30
    L33:
        if (r108 != 0.0f) goto L35;
        r100.setPathEffect(null);
        goto L40
    L35:
        float r111 = r110.mStrokeDashOffset;
        if (r111 >= 0.0f) goto L38;
        r111 = (r111 % r108) + r108;
    L38:
        r100.setPathEffect(new DashPathEffect(r107, r111));
        goto L40
    L28:
        r106 = r105 * 2;
        goto L29
    L18:
        r100.setStrokeJoin(Paint.Join.ROUND);
        goto L20
    L19:
        r100.setStrokeJoin(Paint.Join.MITER);
        goto L20
    L10:
        r100.setStrokeCap(Paint.Cap.ROUND);
        goto L12
    L11:
        r100.setStrokeCap(Paint.Cap.BUTT);
    L40:
        return r100;
    }

    public void setBlendMode(int r100) {
        Canvas r101 = this.f381466a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == 1) goto L7;
    L12:
        if (r100 == 0) goto L14;
        return;
    L14:
        if (this.f381471f == false) goto L20;
        r101.restore();
        this.f381471f = false;
        return;
    L20:
        return;
    L7:
        if (this.f381471f == true) goto L12;
        boolean r102 = this.f381472g;
        Paint r103 = new Paint();
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        if (r102 == false) goto L11;
        r103.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(f381465h)));
    L11:
        this.f381466a.saveLayer(null, r103);
        this.f381471f = true;
    }

    public void setColor(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        this.f381470e = null;
        return;
    L6:
        this.f381470e = r100.trim();
    }

    public void setMaskIsLuminance(boolean r100) {
        this.f381472g = r100;
    }

    public void setResourceManager(c r100) {
        this.f381469d = r100;
    }

    public void transform(float[] r100) {
        if (this.f381466a == null) goto L9;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length != 6) goto L11;
        float[] r101 = {r100[0], r100[2], r100[4], r100[1], r100[3], r100[5], 0.0f, 0.0f, 1.0f};
        Matrix r102 = new Matrix();
        r102.setValues(r101);
        this.f381466a.concat(r102);
        return;
    L11:
        return;
    }

    public static void applyTransform(Path r100, float[] r101) {
        if (r100 == null) goto L5;
        float[] r102 = {r101[0], r101[2], r101[4], r101[1], r101[3], r101[5], 0.0f, 0.0f, 1.0f};
        Matrix r103 = new Matrix();
        r103.setValues(r102);
        r100.transform(r103);
        return;
    }

    public static float[] e(float[] r110, float[] r111) {
        float r100 = r110[0];
        float r101 = r111[0];
        float r102 = r110[2];
        float r103 = r111[1];
        float r104 = (r100 * r101) + (r102 * r103);
        float r105 = r110[1];
        float r112 = r110[3];
        float r106 = (r101 * r105) + (r103 * r112);
        float r107 = r111[2];
        float r113 = r111[3];
        float r114 = r111[4];
        float r115 = r111[5];
        return new float[]{r104, r106, (r100 * r107) + (r102 * r113), (r107 * r105) + (r113 * r112), ((r100 * r114) + (r102 * r115)) + r110[4], ((r105 * r114) + (r112 * r115)) + r110[5]};
    }

    public static int getColorWithOpacity(long r100, float r101) {
        int r102 = Math.round(((int) ((r100 >> 24) & 255)) * r101);
        if (r102 >= 0) goto L5;
        int r103 = 0;
    L7:
        return (r103 << 24) | ((int) (r100 & 16777215));
    L5:
        r103 = Math.min(r102, 255);
        goto L7
    }

    public void clipPath(Path r100, int r101) {
        if (this.f381466a == null) goto L11;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101 != 1) goto L8;
        r100.setFillType(Path.FillType.EVEN_ODD);
    L9:
        this.f381466a.clipPath(r100);
        return;
    L8:
        r100.setFillType(Path.FillType.WINDING);
        goto L9
    }

    public Picture renderPicture(String r110, Rect r111) {
        Picture r100 = new Picture();
        this.f381466a = r100.beginRecording(r111.width(), r111.height());
        SVGRenderEngine r101 = this.f381468c;
        if (r101 == null) goto L5;
        float r102 = r111.left;
        float r103 = r111.top;
        float r104 = r111.width();
        float r105 = r111.height();
        r101.getClass();
        r101.render(this, r110, r102, r103, r104, r105, getColor());
    L5:
        r100.endRecording();
        return r100;
    }

    public void translate(float r100, float r101) {
        Canvas r102 = this.f381466a;
        if (r102 == null) goto L6;
        r102.translate(r100, r101);
        return;
    }

    public static Paint b(LinearGradientModel r110, Path r111, PaintRef r210) {
        int r100 = r110.mStopModels.length;
        Paint r101 = null;
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r210 instanceof FillPaintModel) == false) goto L9;
        r101 = a((FillPaintModel) r210);
    L11:
        r101.setAlpha(clampOpacity(r210.mOpacity));
        float[] r112 = new float[r100];
        int[] r102 = new int[r100];
        float r103 = -1.0f;
        int r104 = 0;
    L12:
        if (r104 >= r100) goto L21;
        StopModel r105 = r110.mStopModels[r104];
        float r106 = r105.mOffset;
        if (r104 != 0) goto L16;
    L19:
        r112[r104] = r106;
        r103 = r106;
    L20:
        r102[r104] = getColorWithOpacity(r105.mColor, r105.mStopOpacity);
        r104 = r104 + 1;
        goto L12
    L16:
        if (r106 >= r103) goto L19;
        r112[r104] = r103;
        goto L20
    L21:
        float r107 = r110.mX1;
        float r108 = r110.mY1;
        float r109 = r110.mX2;
        float r113 = r110.mY2;
        RectF r114 = new RectF();
        r111.computeBounds(r114, true);
        if (r110.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L24;
        float r115 = r114.left;
        float r116 = r114.top;
        float r117 = r114.width();
        float r118 = r114.height();
        r107 = (r107 * r117) + r115;
        float r119 = (r108 * r118) + r116;
        float r120 = r115 + (r109 * r117);
        float r121 = r116 + (r113 * r118);
        float r122 = r119;
        float r123 = r120;
        float r124 = r121;
    L25:
        float r125 = r107;
        if (r125 == r123) goto L28;
    L29:
        if (r100 != 1) goto L32;
    L30:
        r101.setColor(r102[r100 - 1]);
        return r101;
    L32:
        Shader.TileMode r126 = Shader.TileMode.CLAMP;
        int r127 = r110.mSpreadMode;
        if (r127 != GradientModel.GRADIENT_SPREAD_REFLECT) goto L36;
        r126 = Shader.TileMode.MIRROR;
    L38:
        LinearGradient r128 = new LinearGradient(r125, r122, r123, r124, r102, r112, r126);
        float[] r129 = r110.mTransform;
        if (r129 != null) goto L41;
    L52:
        r101.setShader(r128);
        return r101;
    L41:
        if (r110.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L51;
        float r130 = r114.left;
        float r131 = r114.top;
        float r132 = r114.width();
        float r133 = r114.height();
        if (r129.length != 6) goto L51;
        if (r132 == 0.0f) goto L51;
        if (r133 == 0.0f) goto L51;
        float[] r134 = {1.0f / r132, 0.0f, 0.0f, 1.0f / r133, (-r130) / r132, (-r131) / r133};
        r129 = e(e(new float[]{r132, 0.0f, 0.0f, r133, r130, r131}, r129), r134);
    L51:
        Matrix r135 = new Matrix();
        r135.setValues(new float[]{r129[0], r129[2], r129[4], r129[1], r129[3], r129[5], 0.0f, 0.0f, 1.0f});
        r128.setLocalMatrix(r135);
        goto L52
    L36:
        if (r127 != GradientModel.GRADIENT_SPREAD_REPEAT) goto L38;
        r126 = Shader.TileMode.REPEAT;
        goto L38
    L28:
        if (r122 == r124) goto L30;
    L24:
        r124 = r113;
        r123 = r109;
        r122 = r108;
        goto L25
    L9:
        if ((r210 instanceof StrokePaintModel) == false) goto L11;
        r101 = d((StrokePaintModel) r210);
        goto L11
    }

    public static Paint c(RadialGradientModel r210, Path r211, PaintRef r212) {
        int r100 = r210.mStopModels.length;
        Paint r101 = null;
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r212 instanceof FillPaintModel) == false) goto L9;
        r101 = a((FillPaintModel) r212);
    L11:
        r101.setAlpha(clampOpacity(r212.mOpacity));
        float[] r102 = new float[r100];
        int[] r103 = new int[r100];
        float r104 = -1.0f;
        int r105 = 0;
    L12:
        if (r105 >= r100) goto L21;
        StopModel r106 = r210.mStopModels[r105];
        float r107 = r106.mOffset;
        if (r105 != 0) goto L16;
    L19:
        r102[r105] = r107;
        r104 = r107;
    L20:
        r103[r105] = getColorWithOpacity(r106.mColor, r106.mStopOpacity);
        r105 = r105 + 1;
        goto L12
    L16:
        if (r107 >= r104) goto L19;
        r102[r105] = r104;
        goto L20
    L21:
        RectF r110 = new RectF();
        r211.computeBounds(r110, true);
        Shader.TileMode r108 = Shader.TileMode.CLAMP;
        int r109 = r210.mSpreadMode;
        if (r109 != GradientModel.GRADIENT_SPREAD_REFLECT) goto L25;
        r108 = Shader.TileMode.MIRROR;
    L27:
        Shader.TileMode r111 = r108;
        float[] r112 = r210.mTransform;
        if (r210.mType != GradientModel.GRADIENT_TYPE_OBJECT_BOUNDING_BOX) goto L47;
        float r213 = r110.width();
        float r214 = r110.height();
        if (r213 != 0.0f) goto L32;
    L45:
        r101.setColor(r103[r100 - 1]);
        return r101;
    L32:
        if (r214 == 0.0f) goto L45;
        float r113 = r210.mFr;
        if (r113 == 0.0f) goto L43;
        if (r100 == 1) goto L43;
        RadialGradient r114 = new RadialGradient(r210.mCx, r210.mCy, r113, r103, r102, r111);
        Matrix r115 = new Matrix();
        r115.setValues(new float[]{r213, 0.0f, r110.left, 0.0f, r214, r110.top, 0.0f, 0.0f, 1.0f});
        if (r112 == null) goto L41;
        Matrix r116 = new Matrix();
        r116.setValues(new float[]{r112[0], r112[2], r112[4], r112[1], r112[3], r112[5], 0.0f, 0.0f, 1.0f});
        r115.preConcat(r116);
    L41:
        r114.setLocalMatrix(r115);
        r101.setShader(r114);
        return r101;
    L43:
        r101.setColor(r103[r100 - 1]);
        return r101;
    L47:
        float r117 = r210.mFr;
        if (r117 == 0.0f) goto L56;
        if (r100 == 1) goto L56;
        RadialGradient r118 = new RadialGradient(r210.mCx, r210.mCy, r117, r103, r102, r111);
        if (r112 == null) goto L54;
        Matrix r119 = new Matrix();
        r119.setValues(new float[]{r112[0], r112[2], r112[4], r112[1], r112[3], r112[5], 0.0f, 0.0f, 1.0f});
        r118.setLocalMatrix(r119);
    L54:
        r101.setShader(r118);
        return r101;
    L56:
        r101.setColor(r103[r100 - 1]);
        return r101;
    L25:
        if (r109 != GradientModel.GRADIENT_SPREAD_REPEAT) goto L27;
        r108 = Shader.TileMode.REPEAT;
        goto L27
    L9:
        if ((r212 instanceof StrokePaintModel) == false) goto L11;
        r101 = d((StrokePaintModel) r212);
        goto L11
    }

    public void addGradientModel(String r100, String r101, GradientModel r102) {
        this.f381467b.put("#" + r100, new Pair(r101, r102));
    }

    public void draw(Path r100, FillPaintModel r110, StrokePaintModel r111) {
        Canvas r101 = this.f381466a;
        if (r101 == null) goto L65;
        if (r100 == null) goto L66;
        boolean r102 = false;
        Matrix r103 = null;
        if (r110 != null) goto L8;
        Paint r112 = new Paint();
        r112.setStyle(Paint.Style.FILL);
        r112.setTypeface(Typeface.DEFAULT);
        r112.setFlags(193);
        r112.setHinting(0);
        r101.drawPath(r100, r112);
    L31:
        Canvas r113 = this.f381466a;
        if (r111 == null) goto L67;
        int r104 = r111.mType;
        if (r104 != 2) goto L44;
        Pair<String, GradientModel> r105 = this.f381467b.get(r111.mIri);
        if (r105 == null) goto L40;
        GradientModel r106 = r105.second;
        if ((r106 instanceof LinearGradientModel) == false) goto L40;
        Paint r107 = b((LinearGradientModel) r106, r100, r111);
    L47:
        if (r107 != null) goto L49;
        return;
    L49:
        if (r111.mVectorEffect != 1) goto L63;
        Matrix r114 = r113.getMatrix();
        Path r108 = new Path();
        r100.transform(r114, r108);
        Shader r109 = r107.getShader();
        if (r109 == null) goto L57;
        r103 = new Matrix();
        r102 = r109.getLocalMatrix(r103);
        if (r102 == false) goto L55;
        Matrix r115 = new Matrix(r103);
    L56:
        r115.postConcat(r114);
        r109.setLocalMatrix(r115);
        goto L57
    L55:
        r115 = new Matrix();
    L57:
        r113.save();
        r113.setMatrix(new Matrix());
        r113.drawPath(r108, r107);
        r113.restore();
        if (r109 == null) goto L69;
        if (r102 == true) goto L62;
        r103 = new Matrix();
    L62:
        r109.setLocalMatrix(r103);
        return;
    L69:
        return;
    L63:
        r113.drawPath(r100, r107);
        return;
    L40:
        if (r105 == null) goto L46;
        GradientModel r116 = r105.second;
        if ((r116 instanceof RadialGradientModel) == false) goto L46;
        r107 = c((RadialGradientModel) r116, r100, r111);
    L46:
        r107 = null;
        goto L47
    L44:
        if (r104 != 1) goto L46;
        r107 = d(r111);
        goto L47
    L67:
        return;
    L8:
        if (r110.mFillRule != 1) goto L10;
        r100.setFillType(Path.FillType.EVEN_ODD);
    L11:
        int r117 = r110.mType;
        if (r117 != 2) goto L28;
        if (r117 != 2) goto L31;
        if (TextUtils.isEmpty(r110.mIri) == true) goto L31;
        Pair<String, GradientModel> r118 = this.f381467b.get(r110.mIri);
        if (r118 == null) goto L21;
        GradientModel r119 = r118.second;
        if ((r119 instanceof LinearGradientModel) == false) goto L21;
        Paint r120 = b((LinearGradientModel) r119, r100, r110);
    L26:
        if (r120 == null) goto L31;
        r101.drawPath(r100, r120);
    L21:
        if (r118 == null) goto L25;
        GradientModel r121 = r118.second;
        if ((r121 instanceof RadialGradientModel) == false) goto L25;
        r120 = c((RadialGradientModel) r121, r100, r110);
    L25:
        r120 = null;
        goto L26
    L28:
        if (r117 != 1) goto L31;
        r101.drawPath(r100, a(r110));
        goto L31
    L10:
        r100.setFillType(Path.FillType.WINDING);
        goto L11
    L66:
        return;
    }

    public void clipRect(float r100, float r101, float r102, float r103) {
        Canvas r104 = this.f381466a;
        if (r104 == null) goto L6;
        r104.clipRect(r100, r101, r102, r103);
        return;
    }

    public void drawText(SpannableStringBuilder r110, int r111, float r112, float r113) {
        TextPaint r100 = new TextPaint();
        r100.setAntiAlias(true);
        BoringLayout.Metrics r101 = BoringLayout.isBoring(r110, r100);
        if (r101 != null) goto L14;
        StaticLayout r102 = new StaticLayout(r110, r100, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int r114 = r102.getWidth();
        if (r111 != 1) goto L8;
        r114 = r114 / 2;
    L7:
        r112 = r112 - r114;
    L11:
        if (r102.getLineCount() <= 0) goto L13;
        this.f381466a.translate(r112, r113 + ((r102.getLineAscent(0) - r102.getLineDescent(0)) / 2));
    L13:
        r102.draw(this.f381466a);
        return;
    L8:
        if (r111 != 2) goto L11;
    L14:
        BoringLayout r115 = BoringLayout.make(r110, r100, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, r101, false);
        if (r111 != 1) goto L18;
        int r116 = r101.width / 2;
    L17:
        r112 = r112 - r116;
    L20:
        this.f381466a.translate(r112, r113 + ((r101.ascent - r101.descent) / 2));
        r115.draw(this.f381466a);
        return;
    L18:
        if (r111 != 2) goto L20;
        r116 = r101.width;
        goto L17
    }

    public void saveLayer(float r100, float r101, float r102, float r103) {
        Canvas r104 = this.f381466a;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r100 == 0.0f) goto L7;
    L13:
        RectF r105 = new RectF(r100, r101, r102, r103);
        this.f381466a.saveLayer(r105, null);
        return;
    L7:
        if (r101 != 0.0f) goto L13;
        if (r102 != 0.0f) goto L13;
        if (r103 != 0.0f) goto L13;
        r104.saveLayer(null, null);
    }

    public void drawImage(String r110, float r111, float r112, float r113, float r114, int r115, int r116, int r210) {
        if (TextUtils.isEmpty(r110) == true) goto L10;
        c r117 = this.f381469d;
        if (r117 == null) goto L11;
        r117.a(r110, new a(this, r113, r114, r111, r112, r115, r116, r210));
        return;
    L11:
        return;
    }
}
