package com.edu.onetex.latex.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import com.edu.onetex.latex.view.ILaTeXView;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0013\n\u0002\b\u0007\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0002\\]B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J8\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016H\u0002J(\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J(\u0010)\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J8\u0010*\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\"\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J8\u00100\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J(\u00101\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J8\u00102\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\n\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020\u0012H\u0002J\u0012\u00107\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u000109H\u0002J.\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010\u00012\b\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@J\b\u0010A\u001a\u00020\u0012H\u0002J\b\u0010B\u001a\u00020\u0012H\u0002J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0016H\u0002J\b\u0010E\u001a\u00020\u0012H\u0002J\b\u0010F\u001a\u00020\u0012H\u0002J\u0016\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u0016J\u000e\u0010J\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010K\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u000205J\u0014\u0010L\u001a\u00020\u00122\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0NJ\b\u0010O\u001a\u00020\u0012H\u0002J\u0012\u0010P\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J0\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u0002052\u0006\u0010U\u001a\u0002052\b\u0010V\u001a\u0004\u0018\u00010WJ\u0016\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\u0016J\f\u0010[\u001a\u00020>*\u00020WH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/edu/onetex/latex/graphic/Graphics2D;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "canvas", "Landroid/graphics/Canvas;", "(Landroid/content/Context;Landroid/graphics/Canvas;)V", "Ljava/lang/ref/WeakReference;", "customViewList", "Ljava/util/LinkedList;", "Lcom/edu/onetex/latex/view/ILaTeXView;", LynxResourceModule.FONT_TYPE, "Lcom/edu/onetex/latex/graphic/Font;", "mOldDrawPaintStyle", "Landroid/graphics/Paint$Style;", "paint", "Landroid/text/TextPaint;", "afterFill", "", "beforeFill", "drawArc", "x", "", "y", "w", "h", "startAngle", "endAngle", "drawChar", "c", "", "drawCircle", "radius", "drawLine", "x1", "y1", "x2", "y2", "drawPath", "path", "Lcom/edu/onetex/latex/graphic/Path;", "drawRect", "drawRoundRect", "rx", "ry", "drawText", "txt", "", "fillArc", "fillRect", "fillRoundRect", "getCanvas", "getColor", "", "init", "play", SocialConstants.PARAM_ACT, "Lcom/edu/onetex/latex/graphic/GraphicAction;", "record", "action", "arg", "args", "", "intArgs", "", "restoreDrawPaintStyle", "restoreTransform", "rotate", "angle", "saveDrawPaintStyle", "saveTransform", "scale", "sx", "sy", "setCanvas", "setColor", "setCustomViewList", "list", "", "setDrawPaintFillStyle", "setFont", "setStroke", "width", "miterLimit", "cap", "join", "doubleArray", "", "translate", "dx", "dy", "toFloatArray", "ACT", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class Graphics2D {
    private static final int CAP_BUTT = 0;
    private static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    public static final Companion Companion = null;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    private static final int JOIN_ROUND = 1;
    public static final String TAG = "com.edu.onetex.latex.graphic.Graphics2D";
    private static boolean isTextContrastMode;
    private WeakReference<Canvas> canvas;
    private final Context context;
    private LinkedList<ILaTeXView> customViewList;
    private Font font;
    private Paint.Style mOldDrawPaintStyle;
    private final TextPaint paint;

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/edu/onetex/latex/graphic/Graphics2D$ACT;", "", "action", "", "(Ljava/lang/String;IB)V", "getAction", "()B", "setAction", "(B)V", "ACT_SETFONT", "ACT_SETCOLOR", "ACT_SETSTROKE", "ACT_TRANSLATE", "ACT_SCALE", "ACT_ROTATE", "ACT_DRAWCHAR", "ACT_DRAWTEXT", "ACT_DRAWLINE", "ACT_DRAWRECT", "ACT_FILLRECT", "ACT_DRAWROUNDRECT", "ACT_DRAWARC", "ACT_FILLARC", "ACT_DRAWPATH", "ACT_SAVETRANSFORM", "ACT_RESTORETRANSFORM", "ACT_GETTRANSFORM", "ACT_DRAWIMAGE", "ACT_DRAWVIEW", "ACT_DRAWCIRCLE", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final enum ACT extends Enum<ACT> {
        private static final /* synthetic */ ACT[] $VALUES = null;
        public static final ACT ACT_DRAWARC = null;
        public static final ACT ACT_DRAWCHAR = null;
        public static final ACT ACT_DRAWCIRCLE = null;
        public static final ACT ACT_DRAWIMAGE = null;
        public static final ACT ACT_DRAWLINE = null;
        public static final ACT ACT_DRAWPATH = null;
        public static final ACT ACT_DRAWRECT = null;
        public static final ACT ACT_DRAWROUNDRECT = null;
        public static final ACT ACT_DRAWTEXT = null;
        public static final ACT ACT_DRAWVIEW = null;
        public static final ACT ACT_FILLARC = null;
        public static final ACT ACT_FILLRECT = null;
        public static final ACT ACT_GETTRANSFORM = null;
        public static final ACT ACT_RESTORETRANSFORM = null;
        public static final ACT ACT_ROTATE = null;
        public static final ACT ACT_SAVETRANSFORM = null;
        public static final ACT ACT_SCALE = null;
        public static final ACT ACT_SETCOLOR = null;
        public static final ACT ACT_SETFONT = null;
        public static final ACT ACT_SETSTROKE = null;
        public static final ACT ACT_TRANSLATE = null;
        private byte action;

        public static ACT valueOf(String r100) {
            return (ACT) a.a(ACT.class, r100);
        }

        public static ACT[] values() {
            return (ACT[]) $VALUES.clone();
        }

        static {
            ACT r100 = new ACT("ACT_SETFONT", 0, (byte) 1);
            ACT_SETFONT = r100;
            ACT r101 = new ACT("ACT_SETCOLOR", 1, (byte) 2);
            ACT_SETCOLOR = r101;
            ACT r102 = new ACT("ACT_SETSTROKE", 2, (byte) 3);
            ACT_SETSTROKE = r102;
            ACT r103 = new ACT("ACT_TRANSLATE", 3, (byte) 4);
            ACT_TRANSLATE = r103;
            ACT r104 = new ACT("ACT_SCALE", 4, (byte) 5);
            ACT_SCALE = r104;
            ACT r105 = new ACT("ACT_ROTATE", 5, (byte) 6);
            ACT_ROTATE = r105;
            ACT r106 = new ACT("ACT_DRAWCHAR", 6, (byte) 7);
            ACT_DRAWCHAR = r106;
            ACT r107 = new ACT("ACT_DRAWTEXT", 7, (byte) 8);
            ACT_DRAWTEXT = r107;
            ACT r108 = new ACT("ACT_DRAWLINE", 8, (byte) 9);
            ACT_DRAWLINE = r108;
            ACT r109 = new ACT("ACT_DRAWRECT", 9, (byte) 10);
            ACT_DRAWRECT = r109;
            ACT r110 = new ACT("ACT_FILLRECT", 10, (byte) 11);
            ACT_FILLRECT = r110;
            ACT r111 = new ACT("ACT_DRAWROUNDRECT", 11, (byte) 12);
            ACT_DRAWROUNDRECT = r111;
            ACT r112 = new ACT("ACT_DRAWARC", 12, HTTP.CR);
            ACT_DRAWARC = r112;
            ACT r113 = new ACT("ACT_FILLARC", 13, (byte) 14);
            ACT_FILLARC = r113;
            ACT r114 = new ACT("ACT_DRAWPATH", 14, (byte) 15);
            ACT_DRAWPATH = r114;
            ACT r115 = new ACT("ACT_SAVETRANSFORM", 15, (byte) 16);
            ACT_SAVETRANSFORM = r115;
            ACT r116 = new ACT("ACT_RESTORETRANSFORM", 16, (byte) 17);
            ACT_RESTORETRANSFORM = r116;
            ACT r117 = new ACT("ACT_GETTRANSFORM", 17, (byte) 18);
            ACT_GETTRANSFORM = r117;
            ACT r118 = new ACT("ACT_DRAWIMAGE", 18, (byte) 19);
            ACT_DRAWIMAGE = r118;
            ACT r119 = new ACT("ACT_DRAWVIEW", 19, (byte) 20);
            ACT_DRAWVIEW = r119;
            ACT r120 = new ACT("ACT_DRAWCIRCLE", 20, (byte) 21);
            ACT_DRAWCIRCLE = r120;
            $VALUES = new ACT[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
        }

        public final byte getAction() {
            return this.action;
        }

        public final void setAction(byte r100) {
            this.action = r100;
        }

        private ACT(String r100, int r101, byte r102) {
            super(r100, r101);
            this.action = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/edu/onetex/latex/graphic/Graphics2D$Companion;", "", "()V", "CAP_BUTT", "", "CAP_ROUND", "CAP_SQUARE", "JOIN_BEVEL", "JOIN_MITER", "JOIN_ROUND", "TAG", "", "isTextContrastMode", "", "()Z", "setTextContrastMode", "(Z)V", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isTextContrastMode() {
            return Graphics2D.access$isTextContrastMode$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setTextContrastMode(boolean r100) {
            Graphics2D.access$setTextContrastMode$cp(r100);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ACT.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[ACT.ACT_SETFONT.ordinal()] = 1;
            r100[ACT.ACT_SETCOLOR.ordinal()] = 2;
            r100[ACT.ACT_SETSTROKE.ordinal()] = 3;
            r100[ACT.ACT_TRANSLATE.ordinal()] = 4;
            r100[ACT.ACT_SCALE.ordinal()] = 5;
            r100[ACT.ACT_ROTATE.ordinal()] = 6;
            r100[ACT.ACT_DRAWCHAR.ordinal()] = 7;
            r100[ACT.ACT_DRAWTEXT.ordinal()] = 8;
            r100[ACT.ACT_DRAWLINE.ordinal()] = 9;
            r100[ACT.ACT_DRAWRECT.ordinal()] = 10;
            r100[ACT.ACT_FILLRECT.ordinal()] = 11;
            r100[ACT.ACT_DRAWROUNDRECT.ordinal()] = 12;
            r100[ACT.ACT_DRAWCIRCLE.ordinal()] = 13;
            r100[ACT.ACT_DRAWARC.ordinal()] = 14;
            r100[ACT.ACT_FILLARC.ordinal()] = 15;
            r100[ACT.ACT_SAVETRANSFORM.ordinal()] = 16;
            r100[ACT.ACT_RESTORETRANSFORM.ordinal()] = 17;
            r100[ACT.ACT_DRAWPATH.ordinal()] = 18;
            r100[ACT.ACT_DRAWVIEW.ordinal()] = 19;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Graphics2D(Context r100) {
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    private final Canvas getCanvas() {
        WeakReference<Canvas> r100 = this.canvas;
        if (r100 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNull(r100);
        return r100.get();
    }

    private final void init() {
        this.paint.setColor(-16777216);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setSubpixelText(true);
        this.paint.setLinearText(true);
    }

    private final void restoreDrawPaintStyle() {
        this.paint.setStyle(this.mOldDrawPaintStyle);
    }

    private final void saveDrawPaintStyle() {
        this.mOldDrawPaintStyle = this.paint.getStyle();
    }

    private final void setDrawPaintFillStyle() {
        this.paint.setStyle(Paint.Style.FILL);
    }

    public final int getColor() {
        return this.paint.getColor();
    }

    private final void beforeFill() {
        saveDrawPaintStyle();
        setDrawPaintFillStyle();
    }

    private final void restoreTransform() {
        Canvas r100 = getCanvas();
        if (r100 == null) goto L6;
        r100.restore();
        return;
    }

    private final void saveTransform() {
        Canvas r100 = getCanvas();
        if (r100 == null) goto L6;
        r100.save();
        return;
    }

    public static final /* synthetic */ boolean access$isTextContrastMode$cp() {
        return isTextContrastMode;
    }

    private final void afterFill() {
        restoreDrawPaintStyle();
    }

    public static final /* synthetic */ void access$setTextContrastMode$cp(boolean r100) {
        isTextContrastMode = r100;
    }

    private final void drawPath(Path r100) {
        beforeFill();
        Canvas r101 = getCanvas();
        if (r101 == null) goto L16;
        OneTexConfiguration r102 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r102 != null) goto L7;
    L12:
        r101.drawPath(r100.getPath(), this.paint);
    L13:
        afterFill();
        return;
    L7:
        if (r102.getLowVersionCompat() != true) goto L12;
        Iterator<T> r103 = r100.getOpList().iterator();
    L10:
        if (r103.hasNext() == false) goto L13;
        Path.Op r104 = (Path.Op) r103.next();
        r101.drawLine((float) r104.getStartX(), (float) r104.getStartY(), (float) r104.getEndX(), (float) r104.getEndY(), this.paint);
        goto L10
    }

    private final void play(GraphicAction r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        Object r100 = null;
        switch(WhenMappings.$EnumSwitchMapping$0[ACT.values()[r110.getAction()].ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L16;
            case 18: goto L11;
            case 19: goto L7;
            default: goto L60;
        };
    L7:
        Iterator<T> r101 = this.customViewList.iterator();
    L9:
        if (r101.hasNext() == false) goto L61;
        ((ILaTeXView) r101.next()).paintAndroidView(this);
        goto L9
    L61:
        return;
    L11:
        Object r102 = r110.getArg();
        if (r102 == null) goto L15;
        drawPath((Path) r102);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.edu.onetex.latex.graphic.Path");
    L16:
        restoreTransform();
        return;
    L17:
        saveTransform();
        return;
    L18:
        float[] r103 = r110.getArgs();
        Intrinsics.checkNotNull(r103);
        float r104 = r103[0];
        float[] r105 = r110.getArgs();
        Intrinsics.checkNotNull(r105);
        float r106 = r105[1];
        float[] r107 = r110.getArgs();
        Intrinsics.checkNotNull(r107);
        float r108 = r107[2];
        float[] r109 = r110.getArgs();
        Intrinsics.checkNotNull(r109);
        float r111 = r109[3];
        float[] r112 = r110.getArgs();
        Intrinsics.checkNotNull(r112);
        float r113 = r112[4];
        float[] r114 = r110.getArgs();
        Intrinsics.checkNotNull(r114);
        fillArc(r104, r106, r108, r111, r113, r114[5]);
        return;
    L19:
        float[] r115 = r110.getArgs();
        Intrinsics.checkNotNull(r115);
        float r116 = r115[0];
        float[] r117 = r110.getArgs();
        Intrinsics.checkNotNull(r117);
        float r118 = r117[1];
        float[] r119 = r110.getArgs();
        Intrinsics.checkNotNull(r119);
        float r120 = r119[2];
        float[] r121 = r110.getArgs();
        Intrinsics.checkNotNull(r121);
        float r122 = r121[3];
        float[] r123 = r110.getArgs();
        Intrinsics.checkNotNull(r123);
        float r124 = r123[4];
        float[] r125 = r110.getArgs();
        Intrinsics.checkNotNull(r125);
        drawArc(r116, r118, r120, r122, r124, r125[5]);
        return;
    L20:
        float[] r126 = r110.getArgs();
        Intrinsics.checkNotNull(r126);
        float r127 = r126[0];
        float[] r128 = r110.getArgs();
        Intrinsics.checkNotNull(r128);
        float r129 = r128[1];
        float[] r130 = r110.getArgs();
        Intrinsics.checkNotNull(r130);
        drawCircle(r127, r129, r130[2]);
        return;
    L21:
        float[] r131 = r110.getArgs();
        Intrinsics.checkNotNull(r131);
        float r132 = r131[0];
        float[] r133 = r110.getArgs();
        Intrinsics.checkNotNull(r133);
        float r134 = r133[1];
        float[] r135 = r110.getArgs();
        Intrinsics.checkNotNull(r135);
        float r136 = r135[2];
        float[] r137 = r110.getArgs();
        Intrinsics.checkNotNull(r137);
        float r138 = r137[3];
        float[] r139 = r110.getArgs();
        Intrinsics.checkNotNull(r139);
        float r140 = r139[4];
        float[] r141 = r110.getArgs();
        Intrinsics.checkNotNull(r141);
        drawRoundRect(r132, r134, r136, r138, r140, r141[5]);
        return;
    L22:
        float[] r142 = r110.getArgs();
        Intrinsics.checkNotNull(r142);
        float r143 = r142[0];
        float[] r144 = r110.getArgs();
        Intrinsics.checkNotNull(r144);
        float r145 = r144[1];
        float[] r146 = r110.getArgs();
        Intrinsics.checkNotNull(r146);
        float r147 = r146[2];
        float[] r148 = r110.getArgs();
        Intrinsics.checkNotNull(r148);
        fillRect(r143, r145, r147, r148[3]);
        return;
    L23:
        float[] r149 = r110.getArgs();
        Intrinsics.checkNotNull(r149);
        float r150 = r149[0];
        float[] r151 = r110.getArgs();
        Intrinsics.checkNotNull(r151);
        float r152 = r151[1];
        float[] r153 = r110.getArgs();
        Intrinsics.checkNotNull(r153);
        float r154 = r153[2];
        float[] r155 = r110.getArgs();
        Intrinsics.checkNotNull(r155);
        drawRect(r150, r152, r154, r155[3]);
        return;
    L24:
        float[] r156 = r110.getArgs();
        Intrinsics.checkNotNull(r156);
        float r157 = r156[0];
        float[] r158 = r110.getArgs();
        Intrinsics.checkNotNull(r158);
        float r159 = r158[1];
        float[] r160 = r110.getArgs();
        Intrinsics.checkNotNull(r160);
        float r161 = r160[2];
        float[] r162 = r110.getArgs();
        Intrinsics.checkNotNull(r162);
        drawLine(r157, r159, r161, r162[3]);
        return;
    L25:
        String r163 = (String) r110.getArg();
        float[] r164 = r110.getArgs();
        Intrinsics.checkNotNull(r164);
        float r165 = r164[0];
        float[] r166 = r110.getArgs();
        Intrinsics.checkNotNull(r166);
        drawText(r163, r165, r166[1]);
        return;
    L26:
        float[] r167 = r110.getArgs();
        Intrinsics.checkNotNull(r167);
        char r168 = (char) r167[0];
        float[] r169 = r110.getArgs();
        Intrinsics.checkNotNull(r169);
        float r170 = r169[1];
        float[] r171 = r110.getArgs();
        Intrinsics.checkNotNull(r171);
        drawChar(r168, r170, r171[2]);
        return;
    L27:
        float[] r172 = r110.getArgs();
        Intrinsics.checkNotNull(r172);
        rotate(r172[0]);
        return;
    L28:
        float[] r173 = r110.getArgs();
        Intrinsics.checkNotNull(r173);
        float r174 = r173[0];
        float[] r175 = r110.getArgs();
        Intrinsics.checkNotNull(r175);
        scale(r174, r175[1]);
        return;
    L29:
        float[] r176 = r110.getArgs();
        Intrinsics.checkNotNull(r176);
        float r177 = r176[0];
        float[] r178 = r110.getArgs();
        Intrinsics.checkNotNull(r178);
        translate(r177, r178[1]);
        return;
    L30:
        float[] r179 = r110.getArgs();
        Intrinsics.checkNotNull(r179);
        float r180 = r179[0];
        float[] r181 = r110.getArgs();
        Intrinsics.checkNotNull(r181);
        float r182 = r181[1];
        float[] r183 = r110.getArgs();
        Intrinsics.checkNotNull(r183);
        int r184 = (int) r183[2];
        float[] r185 = r110.getArgs();
        Intrinsics.checkNotNull(r185);
        int r186 = (int) r185[3];
        Object r187 = r110.getArg();
        if ((r187 instanceof double[]) == false) goto L34;
        r100 = r187;
    L34:
        setStroke(r180, r182, r184, r186, (double[]) r100);
        return;
    L35:
        int[] r188 = r110.getIntArgs();
        Intrinsics.checkNotNull(r188);
        setColor(r188[0]);
        return;
    L36:
        Object r189 = r110.getArg();
        if ((r189 instanceof Font) == false) goto L40;
        r100 = r189;
    L40:
        setFont((Font) r100);
        return;
    }

    private final void rotate(float r100) {
        float r101 = (float) ((((double) r100) / 3.141592653589793d) * ((double) 180));
        Canvas r102 = getCanvas();
        if (r102 == null) goto L6;
        r102.rotate(r101);
        return;
    }

    private final void setFont(Font r100) {
        if (r100 == null) goto L4;
        this.font = r100;
    L4:
        this.paint.setTypeface(this.font.getTypeface());
        this.paint.setTextSize(this.font.getSize());
        TextPaint r101 = this.paint;
        if (this.font.isItalic() == false) goto L7;
        float r102 = -0.25f;
    L8:
        r101.setTextSkewX(r102);
        return;
    L7:
        r102 = 0.0f;
        goto L8
    }

    private final float[] toFloatArray(double[] r100) {
        int r101 = r100.length;
        float[] r102 = new float[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = (float) r100[r103];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public final void setCanvas(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.canvas = new WeakReference(r100);
    }

    public final void setColor(int r100) {
        this.paint.setColor(r100);
    }

    public final void setCustomViewList(List<? extends ILaTeXView> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.customViewList.clear();
        this.customViewList.addAll(r100);
    }

    public Graphics2D(Context r100, Canvas r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.paint = new TextPaint(1);
        this.font = new Font(Typeface.DEFAULT, 46.0f, false);
        this.customViewList = new LinkedList();
        if (r101 == null) goto L5;
        this.canvas = new WeakReference(r101);
    L5:
        init();
    }

    public final void scale(float r100, float r101) {
        Canvas r102 = getCanvas();
        if (r102 == null) goto L6;
        r102.scale(r100, r101);
        return;
    }

    public final void translate(float r100, float r101) {
        Canvas r102 = getCanvas();
        if (r102 == null) goto L6;
        r102.translate(r100, r101);
        return;
    }

    private final void drawChar(char r100, float r101, float r102) {
        drawText(String.valueOf(r100), r101, r102);
    }

    private final void drawCircle(float r100, float r101, float r102) {
        Canvas r103 = getCanvas();
        if (r103 == null) goto L6;
        r103.drawCircle(r100, r101, r102, this.paint);
        return;
    }

    private final void drawText(String r110, float r111, float r112) {
        Canvas r100 = getCanvas();
        if (r100 == null) goto L21;
        if (r110 == null) goto L22;
        beforeFill();
        if (isTextContrastMode == false) goto L8;
        android.graphics.Path r101 = new android.graphics.Path();
        this.paint.getTextPath(r110, 0, r110.length(), r111, r112, r101);
        r100.drawPath(r101, this.paint);
    L19:
        afterFill();
        return;
    L8:
        Paint.Style r102 = this.paint.getStyle();
        float r103 = this.paint.getStrokeWidth();
        if (Build.VERSION.SDK_INT >= 24) goto L13;
        OneTexConfiguration r104 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r104 == null) goto L13;
        r104.setFontBold(false);
    L13:
        OneTexConfiguration r105 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r105 != null) goto L16;
    L18:
        r100.drawText(r110, 0, r110.length(), r111, r112, this.paint);
        this.paint.setStyle(r102);
        this.paint.setStrokeWidth(r103);
        goto L19
    L16:
        if (r105.getFontBold() != true) goto L18;
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setStrokeWidth(0.02f);
        goto L18
    L22:
        return;
    }

    public /* synthetic */ Graphics2D(Context r100, Canvas r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    private final void drawLine(float r100, float r101, float r102, float r110) {
        Canvas r103 = getCanvas();
        if (r103 == null) goto L6;
        r103.drawLine(r100, r101, r100 + (r102 - r100), r110, this.paint);
        return;
    }

    private final void drawRect(float r100, float r101, float r102, float r110) {
        Canvas r103 = getCanvas();
        if (r103 == null) goto L6;
        r103.drawRect(r100, r101, r100 + r102, r101 + r110, this.paint);
        return;
    }

    private final void fillRect(float r100, float r101, float r102, float r103) {
        beforeFill();
        drawRect(r100, r101, r102, r103);
        afterFill();
    }

    public final void record(int r100, Object r101, float[] r102, int[] r103) {
        play(new GraphicAction((byte) r100, r101, r102, r103));
    }

    public final void setStroke(float r100, float r101, int r102, int r103, double[] r104) {
        this.paint.setStrokeWidth(r100);
        this.paint.setStrokeMiter(r101);
        if (r102 == 0) goto L9;
        if (r102 == 1) goto L8;
        if (r102 != 2) goto L10;
        this.paint.setStrokeCap(Paint.Cap.SQUARE);
    L10:
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L17;
        this.paint.setStrokeJoin(Paint.Join.BEVEL);
    L17:
        if (r104 == null) goto L19;
        this.paint.setPathEffect(new DashPathEffect(toFloatArray(r104), 0.0f));
        return;
    L19:
        this.paint.setPathEffect(null);
        return;
    L15:
        this.paint.setStrokeJoin(Paint.Join.ROUND);
        goto L17
    L16:
        this.paint.setStrokeJoin(Paint.Join.MITER);
        goto L17
    L8:
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        goto L10
    L9:
        this.paint.setStrokeCap(Paint.Cap.BUTT);
        goto L10
    }

    private final void drawArc(float r110, float r111, float r112, float r113, float r114, float r115) {
        Canvas r100 = getCanvas();
        if (r100 == null) goto L6;
        double r101 = 180.0f;
        r100.drawArc(r110, r111, r110 + r112, r111 + r113, (float) ((((double) r114) * 3.141592653589793d) / r101), (float) ((((double) r115) * 3.141592653589793d) / r101), false, this.paint);
        return;
    }

    private final void drawRoundRect(float r100, float r110, float r111, float r112, float r113, float r114) {
        Canvas r101 = getCanvas();
        if (r101 == null) goto L6;
        r101.drawRoundRect(r100, r110, r100 + r111, r110 + r112, r113, r114, this.paint);
        return;
    }

    private final void fillArc(float r100, float r101, float r102, float r103, float r104, float r105) {
        beforeFill();
        drawArc(r100, r101, r102, r103, r104, r105);
        afterFill();
    }

    private final void fillRoundRect(float r100, float r101, float r102, float r103, float r104, float r105) {
        beforeFill();
        drawRoundRect(r100, r101, r102, r103, r104, r105);
        afterFill();
    }

    public static /* synthetic */ void record$default(Graphics2D r100, int r101, Object r102, float[] r103, int[] r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.record(r101, r102, r103, r104);
    }
}
