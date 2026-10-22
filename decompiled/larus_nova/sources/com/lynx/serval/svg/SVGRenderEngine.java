package com.lynx.serval.svg;

import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.camera.video.AudioStats;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.model.FillPaintModel;
import com.lynx.serval.svg.model.LinearGradientModel;
import com.lynx.serval.svg.model.RadialGradientModel;
import com.lynx.serval.svg.model.StopModel;
import com.lynx.serval.svg.model.StrokePaintModel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class SVGRenderEngine {
    public static final String CIRCLE = "circle";
    public static final String CLIP_PATH = "clipPath";
    public static final String DRAW = "draw";
    public static final String ELLIPSE = "ellipse";
    public static final String IMAGE = "image";
    public static final int JNI_OK = 0;
    public static final String LINE = "line";
    public static final String LINEAR_GRADIENT = "linearGradient";
    public static final String PATH = "path";
    public static final String POLYGON = "polygon";
    public static final String POLYLINE = "polyline";
    public static final String RADIAL_GRADIENT = "radialGradient";
    public static final String RECT = "rect";
    public static final String RESTORE = "restore";
    public static final String SAVE = "save";
    public static final String SVG = "svg";
    public static final String TAG = "SrSVGRenderEngine";
    public static final String TRANSLATE = "translate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f381481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SVGRenderEngine f381482b;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static void layout(float r100) {
    }

    public native float[] calculateViewBoxTransform(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, int r108, int r110, int r111);

    public native int render(SVGRender r100, String r101, float r102, float r103, float r104, float r105, String r106);

    public static SVGRenderEngine getInstance() {
        if (f381482b != null) goto L15;
        monitor-enter(SVGRenderEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f381482b != null) goto L9;
        f381482b = new SVGRenderEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SVGRenderEngine.class);     // Catch: Throwable -> L11
    L15:
        return f381482b;
    }

    public static Path makeMutablePath() {
        return new Path();
    }

    public static SpannableStringBuilder makeStringBuilder() {
        return new SpannableStringBuilder();
    }

    public SVGRenderEngine() {
        if (f381481a == true) goto L13;
        INVOKESTATIC_com_lynx_serval_svg_SVGRenderEngine_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("serval_svg");     // Catch: UnsatisfiedLinkError -> L7
        f381481a = true;
        return;
    L7:
        e = move-exception;
        e.getMessage();
        return;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_serval_svg_SVGRenderEngine_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static Path makePolyLinePath(float[] r100) {
        return k6a.a.a(r100, false);
    }

    public static Path makePolygonPath(float[] r100) {
        return k6a.a.a(r100, true);
    }

    public static Path makePath(byte[] r410, float[] r411) {
        Path r100 = new Path();
        int r101 = 0;
        int r110 = 0;
    L4:
        if (r110 >= r410.length) goto L87;
        byte r102 = r410[r110];
        if (r102 == 0) goto L83;
        boolean r103 = true;
        if (r102 != 1) goto L10;
        r100 = r100;
        int r104 = r101 + 1;
        int r105 = r104 + 1;
        r100.lineTo(r411[r101], r411[r104]);
    L84:
        r101 = r105;
    L85:
        r110 = r110 + 1;
        r100 = r100;
        goto L4
    L10:
        if (r102 != 2) goto L12;
        r100 = r100;
        r110 = r110;
        int r106 = r101 + 1;
        float r107 = r411[r101];
        int r108 = r106 + 1;
        float r109 = r411[r106];
        int r111 = r108 + 1;
        float r112 = r411[r108];
        int r113 = r111 + 1;
        float r114 = r411[r111];
        int r115 = r113 + 1;
        r100.cubicTo(r107, r109, r112, r114, r411[r113], r411[r115]);
        r101 = r115 + 1;
        goto L85
    L12:
        if (r102 != 3) goto L14;
        r100 = r100;
        r110 = r110;
        int r116 = r101 + 1;
        int r117 = r116 + 1;
        int r118 = r117 + 1;
        r100.quadTo(r411[r101], r411[r116], r411[r117], r411[r118]);
        r101 = r118 + 1;
        goto L85
    L14:
        if (r102 == 5) goto L79;
        int r119 = r101 + 1;
        float r120 = r411[r101];
        int r121 = r119 + 1;
        float r122 = r411[r119];
        int r123 = r121 + 1;
        float r124 = r411[r121];
        int r125 = r123 + 1;
        float r126 = r411[r123];
        int r127 = r125 + 1;
        float r128 = r411[r125];
        int r129 = r127 + 1;
        if (((int) r411[r127]) == 0) goto L18;
        boolean r130 = true;
    L19:
        int r131 = r129 + 1;
        if (((int) r411[r129]) != 0) goto L23;
        r103 = false;
    L23:
        int r132 = r131 + 1;
        float r133 = r411[r131];
        int r134 = r132 + 1;
        float r135 = r411[r132];
        if (r120 != r133) goto L29;
        if (r122 != r135) goto L29;
        r100 = r100;
        r110 = r110;
        r134 = r134;
    L78:
        r101 = r134;
    L29:
        if (r124 == 0.0f) goto L77;
        if (r126 == 0.0f) goto L77;
        float r136 = Math.abs(r124);
        float r137 = Math.abs(r126);
        double r138 = Math.toRadians(((double) r128) % 360.0d);
        double r139 = Math.cos(r138);
        double r140 = Math.sin(r138);
        r110 = r110;
        double r141 = ((double) (r120 - r133)) / 2.0d;
        double r142 = ((double) (r122 - r135)) / 2.0d;
        double r143 = (r139 * r141) + (r140 * r142);
        boolean r210 = r103;
        double r144 = ((-r140) * r141) + (r142 * r139);
        double r145 = r136 * r136;
        double r146 = r137 * r137;
        double r211 = r143 * r143;
        double r212 = r144 * r144;
        double r310 = (r211 / r145) + (r212 / r146);
        if (r310 <= 0.99999d) goto L36;
        double r147 = Math.sqrt(r310) * 1.00001d;
        r136 = (float) (((double) r136) * r147);
        r137 = (float) (r147 * ((double) r137));
        r145 = r136 * r136;
        r146 = r137 * r137;
    L36:
        r134 = r134;
        if (r130 != r210) goto L39;
        double r311 = -1.0d;
    L40:
        double r312 = r145 * r146;
        double r148 = r145 * r212;
        double r149 = r146 * r211;
        double r313 = ((r312 - r148) - r149) / (r148 + r149);
        if (r313 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L43;
        r313 = 0.0d;
    L43:
        double r314 = r311 * Math.sqrt(r313);
        double r150 = r136;
        double r151 = r137;
        double r213 = ((r150 * r144) / r151) * r314;
        double r315 = r314 * (-((r151 * r143) / r150));
        float r214 = r136;
        float r215 = r137;
        double r152 = (((double) (r120 + r133)) / 2.0d) + ((r139 * r213) - (r140 * r315));
        double r153 = (((double) (r122 + r135)) / 2.0d) + ((r140 * r213) + (r139 * r315));
        double r154 = (r143 - r213) / r150;
        double r155 = (r144 - r315) / r151;
        double r156 = ((-r143) - r213) / r150;
        double r157 = ((-r144) - r315) / r151;
        double r158 = (r154 * r154) + (r155 * r155);
        double r159 = Math.sqrt(r158);
        if (r155 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L46;
        double r216 = -1.0d;
    L47:
        double r217 = r216 * Math.acos(r154 / r159);
        double r160 = Math.sqrt(r158 * ((r156 * r156) + (r157 * r157)));
        double r161 = (r154 * r156) + (r155 * r157);
        if (((r154 * r157) - (r155 * r156)) >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L50;
        double r162 = -1.0d;
    L51:
        double r163 = r161 / r160;
        if (r163 >= (-1.0d)) goto L55;
        double r164 = 3.141592653589793d;
    L58:
        double r165 = r162 * r164;
        if (r165 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L61;
        r100.lineTo(r133, r135);
        r100 = r100;
        goto L78
    L61:
        float r166 = r133;
        float r167 = r135;
        if (r210 == true) goto L65;
        if (r165 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L65;
        r165 = r165 - 6.283185307179586d;
    L69:
        double r168 = r165 % 6.283185307179586d;
        double r218 = r217 % 6.283185307179586d;
        int r169 = (int) Math.ceil((Math.abs(r168) * 2.0d) / 3.141592653589793d);
        double r170 = r168 / ((double) r169);
        double r171 = r170 / 2.0d;
        double r172 = (Math.sin(r171) * 1.3333333333333333d) / (Math.cos(r171) + 1.0d);
        int r173 = r169 * 6;
        float[] r174 = new float[r173];
        int r175 = 0;
        int r176 = 0;
    L70:
        if (r175 >= r169) goto L72;
        Path r177 = r100;
        double r178 = (((double) r175) * r170) + r218;
        double r179 = Math.cos(r178);
        double r219 = Math.sin(r178);
        int r180 = r176 + 1;
        float r316 = r167;
        int r317 = r173;
        r174[r176] = (float) (r179 - (r172 * r219));
        int r181 = r180 + 1;
        double r220 = r153;
        r174[r180] = (float) (r219 + (r179 * r172));
        double r182 = r178 + r170;
        double r183 = Math.cos(r182);
        double r184 = Math.sin(r182);
        int r185 = r181 + 1;
        double r221 = r170;
        r174[r181] = (float) ((r172 * r184) + r183);
        int r186 = r185 + 1;
        r174[r185] = (float) (r184 - (r172 * r183));
        int r187 = r186 + 1;
        r174[r186] = (float) r183;
        r176 = r187 + 1;
        r174[r187] = (float) r184;
        r175 = r175 + 1;
        r100 = r177;
        r166 = r166;
        r170 = r221;
        r153 = r220;
        r167 = r316;
        r173 = r317;
        r172 = r172;
        goto L70
    L72:
        Path r188 = r100;
        int r318 = r173;
        Matrix r189 = new Matrix();
        r189.postScale(r214, r215);
        r189.postRotate(r128);
        r189.postTranslate((float) r152, (float) r153);
        r189.mapPoints(r174);
        r174[r318 - 2] = r166;
        r174[r318 - 1] = r167;
        int r190 = 0;
    L73:
        if (r190 >= r318) goto L75;
        r188.cubicTo(r174[r190], r174[r190 + 1], r174[r190 + 2], r174[r190 + 3], r174[r190 + 4], r174[r190 + 5]);
        r190 = r190 + 6;
        goto L73
    L75:
        r100 = r188;
    L65:
        if (r210 == false) goto L69;
        if (r165 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L69;
        r165 = r165 + 6.283185307179586d;
        goto L69
    L55:
        if (r163 <= 1.0d) goto L57;
        r164 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L58
    L57:
        r164 = Math.acos(r163);
        goto L58
    L50:
        r162 = 1.0d;
        goto L51
    L46:
        r216 = 1.0d;
        goto L47
    L39:
        r311 = 1.0d;
    L77:
        r100.lineTo(r133, r135);
        goto L78
    L18:
        r130 = false;
        goto L19
    L79:
        r100 = r100;
        r110 = r110;
        r100.close();
        goto L85
    L83:
        r100 = r100;
        int r191 = r101 + 1;
        r105 = r191 + 1;
        r100.moveTo(r411[r101], r411[r191]);
        goto L84
    L87:
        return r100;
    }

    public static void setFillType(Path r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != 1) goto L6;
        Path.FillType r102 = Path.FillType.EVEN_ODD;
    L7:
        r100.setFillType(r102);
        return;
    L6:
        r102 = Path.FillType.WINDING;
        goto L7
    }

    public static Path makeCirclePath(float r110, float r111, float r112) {
        float r100 = r110 - r112;
        float r101 = r111 - r112;
        float r113 = r110 + r112;
        float r114 = r111 + r112;
        float r115 = r112 * 0.5522848f;
        Path r116 = new Path();
        r116.moveTo(r113, r111);
        float r117 = r111 + r115;
        float r118 = r110 + r115;
        r116.cubicTo(r113, r117, r118, r114, r110, r114);
        float r119 = r110 - r115;
        r116.cubicTo(r119, r114, r100, r117, r100, r111);
        float r120 = r111 - r115;
        r116.cubicTo(r100, r120, r119, r101, r110, r101);
        r116.cubicTo(r118, r101, r113, r120, r113, r111);
        r116.close();
        return r116;
    }

    public static StopModel makeStopModel(float r100, long r101, float r102) {
        return new StopModel(r100, r101, r102);
    }

    public static void op(Path r100, Path r101, int r102) {
        Path.Op r103 = Path.Op.UNION;
        if (r102 != 0) goto L5;
        r103 = Path.Op.DIFFERENCE;
    L17:
        r100.op(r101, r103);
        return;
    L5:
        if (r102 != 1) goto L7;
        r103 = Path.Op.INTERSECT;
        goto L17
    L7:
        if (r102 == 2) goto L17;
        if (r102 != 3) goto L11;
        r103 = Path.Op.XOR;
        goto L17
    L11:
        if (r102 != 4) goto L17;
        r103 = Path.Op.REVERSE_DIFFERENCE;
        goto L17
    }

    public static void appendSpan(SpannableStringBuilder r100, String r101, int r102, float r103) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        int r104 = r101.length();
        SpannableString r105 = new SpannableString(r101);
        r105.setSpan(new ForegroundColorSpan(r102), 0, r104, 33);
        r105.setSpan(new AbsoluteSizeSpan((int) r103, true), 0, r104, 33);
        r100.append(r105);
    }

    public static Path makeEllipsePath(float r110, float r111, float r112, float r210) {
        float r100 = r110 - r112;
        float r101 = r111 - r210;
        float r113 = r110 + r112;
        float r114 = r111 + r210;
        float r115 = r112 * 0.5522848f;
        float r116 = r210 * 0.5522848f;
        Path r117 = new Path();
        r117.moveTo(r110, r101);
        float r118 = r110 + r115;
        float r119 = r111 - r116;
        r117.cubicTo(r118, r101, r113, r119, r113, r111);
        float r120 = r111 + r116;
        r117.cubicTo(r113, r120, r118, r114, r110, r114);
        float r121 = r110 - r115;
        r117.cubicTo(r121, r114, r100, r120, r100, r111);
        r117.cubicTo(r100, r119, r121, r101, r110, r101);
        r117.close();
        return r117;
    }

    public static Path makeLinePath(float r100, float r101, float r102, float r103) {
        Path r104 = new Path();
        r104.moveTo(r100, r101);
        r104.lineTo(r102, r103);
        return r104;
    }

    public static FillPaintModel makeFillPaintModel(int r100, String r101, long r110, int r111, float r112) {
        return new FillPaintModel(r100, r101, r110, r112, r111);
    }

    public static Path makeRectPath(float r110, float r111, float r112, float r210, float r211, float r212) {
        float r100 = r110 + r211;
        float r113 = r111 + r212;
        Path r114 = new Path();
        if (r112 != 0.0f) goto L5;
    L8:
        r114.moveTo(r110, r111);
        r114.lineTo(r100, r111);
        r114.lineTo(r100, r113);
        r114.lineTo(r110, r113);
        r114.close();
    L9:
        return r114;
    L5:
        if (r210 == 0.0f) goto L8;
        float r115 = r112 * 0.5522848f;
        float r116 = r210 * 0.5522848f;
        float r117 = r111 + r210;
        r114.moveTo(r110, r117);
        float r118 = r117 - r116;
        float r101 = r110 + r112;
        float r119 = r101 - r115;
        r114.cubicTo(r110, r118, r119, r111, r101, r111);
        float r102 = r100 - r112;
        r114.lineTo(r102, r111);
        float r120 = r115 + r102;
        r114.cubicTo(r120, r111, r100, r118, r100, r117);
        float r121 = r113 - r210;
        r114.lineTo(r100, r121);
        float r122 = r116 + r121;
        r114.cubicTo(r100, r122, r120, r113, r102, r113);
        r114.lineTo(r101, r113);
        r114.cubicTo(r119, r113, r110, r122, r110, r121);
        r114.lineTo(r110, r117);
        r114.close();
        goto L9
    }

    public static Path makeStrokePath(Path r100, float r101, int r102, int r103, float r104, float r105, float[] r106) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Paint r107 = new Paint();
        r107.setStyle(Paint.Style.STROKE);
        r107.setStrokeWidth(r101);
        if (r102 != 0) goto L8;
        r107.setStrokeCap(Paint.Cap.BUTT);
    L11:
        if (r103 != 0) goto L13;
        r107.setStrokeJoin(Paint.Join.MITER);
    L16:
        r107.setStrokeMiter(r104);
        if (r106 != null) goto L19;
    L21:
        Path r108 = new Path();
        r107.getFillPath(r100, r108);
        return r108;
    L19:
        if (r106.length <= 0) goto L21;
        r107.setPathEffect(new DashPathEffect(r106, r105));
        goto L21
    L13:
        if (r103 != 1) goto L15;
        r107.setStrokeJoin(Paint.Join.ROUND);
        goto L16
    L15:
        r107.setStrokeJoin(Paint.Join.BEVEL);
        goto L16
    L8:
        if (r102 != 1) goto L10;
        r107.setStrokeCap(Paint.Cap.ROUND);
        goto L11
    L10:
        r107.setStrokeCap(Paint.Cap.SQUARE);
        goto L11
    }

    public static void makeLinearGradient(SVGRender r100, String r101, float[] r102, int r103, float r104, float r105, float r106, float r107, int r108, StopModel[] r110) {
        if (r100 == null) goto L5;
        LinearGradientModel r109 = new LinearGradientModel();
        r109.mType = r108;
        r109.mTransform = r102;
        r109.mStopModels = r110;
        r109.mX1 = r104;
        r109.mX2 = r105;
        r109.mY1 = r106;
        r109.mY2 = r107;
        r109.mSpreadMode = r103;
        r100.addGradientModel(r101, LINEAR_GRADIENT, r109);
        return;
    }

    public static void makeRadialGradient(SVGRender r100, String r101, float[] r102, int r103, float r104, float r105, float r106, float r107, float r108, int r110, StopModel[] r111) {
        if (r100 == null) goto L5;
        RadialGradientModel r109 = new RadialGradientModel();
        r109.mType = r110;
        r109.mTransform = r102;
        r109.mStopModels = r111;
        r109.mSpreadMode = r103;
        r109.mCx = r104;
        r109.mCy = r105;
        r109.mFr = r106;
        r109.mFx = r107;
        r109.mFy = r108;
        r100.addGradientModel(r101, RADIAL_GRADIENT, r109);
        return;
    }

    public static StrokePaintModel makeStrokePaintModel(int r110, String r111, long r112, float r113, float r114, int r210, int r211, float r212, float r213, float[] r214, int r215) {
        return new StrokePaintModel(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215);
    }
}
