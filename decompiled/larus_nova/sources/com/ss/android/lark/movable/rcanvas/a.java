package com.ss.android.lark.movable.rcanvas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.fonts.Font;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.utils.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f432708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f432709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f432710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f432711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Font f432712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f432713g;

    /* JADX INFO: renamed from: com.ss.android.lark.movable.rcanvas.a$a, reason: collision with other inner class name */
    public static final class C5140a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f432714a = null;

        static {
            int[] r100 = new int[OpCode.values().length];
            r100[OpCode.SetFillRGBA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L87:
            r100[OpCode.FillRect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L103:
            r100[OpCode.SetStrokeRGBA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L63:
            r100[OpCode.StrokeRect.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L67:
            r100[OpCode.SetFont.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L81:
            r100[OpCode.DrawGlyphRun.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L97:
            r100[OpCode.DrawText.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L73:
            r100[OpCode.SaveGState.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L91:
            r100[OpCode.RestoreGState.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L93:
            r100[OpCode.Translate.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L57:
            r100[OpCode.SetLineWidth.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L85:
            r100[OpCode.SetLineJoin.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L101:
            r100[OpCode.SetLineCap.ordinal()] = 13;     // Catch: NoSuchFieldError -> L42
        L55:
            r100[OpCode.SetMiterLimit.ordinal()] = 14;     // Catch: NoSuchFieldError -> L43
        L69:
            r100[OpCode.BeginPath.ordinal()] = 15;     // Catch: NoSuchFieldError -> L44
        L99:
            r100[OpCode.MoveTo.ordinal()] = 16;     // Catch: NoSuchFieldError -> L45
        L61:
            r100[OpCode.LineTo.ordinal()] = 17;     // Catch: NoSuchFieldError -> L46
        L65:
            r100[OpCode.BezierCurveTo.ordinal()] = 18;     // Catch: NoSuchFieldError -> L47
        L83:
            r100[OpCode.ClosePath.ordinal()] = 19;     // Catch: NoSuchFieldError -> L48
        L59:
            r100[OpCode.FillPath.ordinal()] = 20;     // Catch: NoSuchFieldError -> L49
        L77:
            r100[OpCode.StrokePath.ordinal()] = 21;     // Catch: NoSuchFieldError -> L50
        L79:
            r100[OpCode.ClipPath.ordinal()] = 22;     // Catch: NoSuchFieldError -> L51
        L95:
            r100[OpCode.Concatenate.ordinal()] = 23;     // Catch: NoSuchFieldError -> L52
        L71:
            r100[OpCode.SetFillVariable.ordinal()] = 24;     // Catch: NoSuchFieldError -> L53
        L89:
            r100[OpCode.SetStrokeVariable.ordinal()] = 25;     // Catch: NoSuchFieldError -> L54
        L28:
            f432714a = r100;
        }
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f432707a = r100;
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.FILL);
        this.f432708b = r101;
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.STROKE);
        this.f432709c = r102;
        this.f432710d = new Path();
        this.f432711e = 16.0f;
    }

    public final float b(float r100) {
        return com.ss.android.lark.movable.utils.b.d(r100, this.f432707a);
    }

    public final int c(String r100) {
        Integer r101 = g.a(r100);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L7:
        return UDColorUtils.getColor(this.f432707a, r102);
    L5:
        Log.i("CanvasApplier", "receive unknow color variable: ".concat(r100));
        r102 = R.color.ud_text_color;
        goto L7
    }

    public static int a(float r100, float r101, float r102, float r103) {
        return Color.argb(RangesKt.coerceIn(MathKt.roundToInt(RangesKt.coerceIn(r100, 0.0f, 1.0f) * 255.0f), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(r101), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(r102), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(r103), 0, 255));
    }
}
