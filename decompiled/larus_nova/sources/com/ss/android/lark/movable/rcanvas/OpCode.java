package com.ss.android.lark.movable.rcanvas;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/ss/android/lark/movable/rcanvas/OpCode;", "", BaseSwitches.V, "", "<init>", "(Ljava/lang/String;II)V", "getV", "()I", "SetFillRGBA", "FillRect", "SetStrokeRGBA", "StrokeRect", "SetFont", "DrawGlyphRun", "SaveGState", "RestoreGState", "Translate", "BeginPath", "MoveTo", "LineTo", "BezierCurveTo", "ClosePath", "FillPath", "StrokePath", "ClipPath", "SetLineWidth", "SetLineJoin", "SetLineCap", "SetMiterLimit", "Concatenate", "SetFillVariable", "SetStrokeVariable", "DrawText", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpCode extends Enum<OpCode> {
    public static final OpCode BeginPath = null;
    public static final OpCode BezierCurveTo = null;
    public static final OpCode ClipPath = null;
    public static final OpCode ClosePath = null;
    public static final a Companion = null;
    public static final OpCode Concatenate = null;
    public static final OpCode DrawGlyphRun = null;
    public static final OpCode DrawText = null;
    public static final OpCode FillPath = null;
    public static final OpCode FillRect = null;
    public static final OpCode LineTo = null;
    public static final OpCode MoveTo = null;
    public static final OpCode RestoreGState = null;
    public static final OpCode SaveGState = null;
    public static final OpCode SetFillRGBA = null;
    public static final OpCode SetFillVariable = null;
    public static final OpCode SetFont = null;
    public static final OpCode SetLineCap = null;
    public static final OpCode SetLineJoin = null;
    public static final OpCode SetLineWidth = null;
    public static final OpCode SetMiterLimit = null;
    public static final OpCode SetStrokeRGBA = null;
    public static final OpCode SetStrokeVariable = null;
    public static final OpCode StrokePath = null;
    public static final OpCode StrokeRect = null;
    public static final OpCode Translate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpCode[] f432704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432705b = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f432706v;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OpCode> getEntries() {
        return f432705b;
    }

    static {
        OpCode r100 = new OpCode("SetFillRGBA", 0, 1);
        SetFillRGBA = r100;
        OpCode r101 = new OpCode("FillRect", 1, 2);
        FillRect = r101;
        OpCode r102 = new OpCode("SetStrokeRGBA", 2, 3);
        SetStrokeRGBA = r102;
        OpCode r103 = new OpCode("StrokeRect", 3, 4);
        StrokeRect = r103;
        OpCode r104 = new OpCode("SetFont", 4, 5);
        SetFont = r104;
        OpCode r110 = new OpCode("DrawGlyphRun", 5, 6);
        DrawGlyphRun = r110;
        OpCode r111 = new OpCode("SaveGState", 6, 7);
        SaveGState = r111;
        OpCode r112 = new OpCode("RestoreGState", 7, 8);
        RestoreGState = r112;
        OpCode r113 = new OpCode("Translate", 8, 9);
        Translate = r113;
        OpCode r114 = new OpCode("BeginPath", 9, 10);
        BeginPath = r114;
        OpCode r115 = new OpCode("MoveTo", 10, 11);
        MoveTo = r115;
        OpCode r105 = new OpCode("LineTo", 11, 12);
        LineTo = r105;
        OpCode r106 = new OpCode("BezierCurveTo", 12, 13);
        BezierCurveTo = r106;
        OpCode r107 = new OpCode("ClosePath", 13, 14);
        ClosePath = r107;
        OpCode r108 = new OpCode("FillPath", 14, 15);
        FillPath = r108;
        OpCode r109 = new OpCode("StrokePath", 15, 16);
        StrokePath = r109;
        OpCode r116 = new OpCode("ClipPath", 16, 17);
        ClipPath = r116;
        OpCode r117 = new OpCode("SetLineWidth", 17, 18);
        SetLineWidth = r117;
        OpCode r118 = new OpCode("SetLineJoin", 18, 19);
        SetLineJoin = r118;
        OpCode r119 = new OpCode("SetLineCap", 19, 20);
        SetLineCap = r119;
        OpCode r120 = new OpCode("SetMiterLimit", 20, 21);
        SetMiterLimit = r120;
        OpCode r121 = new OpCode("Concatenate", 21, 22);
        Concatenate = r121;
        OpCode r122 = new OpCode("SetFillVariable", 22, 23);
        SetFillVariable = r122;
        OpCode r123 = new OpCode("SetStrokeVariable", 23, 24);
        SetStrokeVariable = r123;
        OpCode r124 = new OpCode("DrawText", 24, 25);
        DrawText = r124;
        OpCode[] r125 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
        f432704a = r125;
        f432705b = EnumEntriesKt.enumEntries(r125);
        Companion = new a();
    }

    public static OpCode[] values() {
        return (OpCode[]) f432704a.clone();
    }

    public final int getV() {
        return this.f432706v;
    }

    public static OpCode valueOf(String r100) {
        return (OpCode) r27.a.a(OpCode.class, r100);
    }

    public OpCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.f432706v = r102;
    }
}
