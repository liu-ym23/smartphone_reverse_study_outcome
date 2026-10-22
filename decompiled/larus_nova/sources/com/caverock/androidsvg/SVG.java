package com.caverock.androidsvg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class SVG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f272756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f272757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CSSParser.m f272758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, j0> f272759d;

    public static final enum GradientSpread extends Enum<GradientSpread> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GradientSpread[] f272760a = null;
        public static final GradientSpread pad = null;
        public static final GradientSpread reflect = null;
        public static final GradientSpread repeat = null;

        static {
            GradientSpread r100 = new GradientSpread(CommonCmd.AIDL_PLATFORM_TYPE_PAD, 0);
            pad = r100;
            GradientSpread r101 = new GradientSpread("reflect", 1);
            reflect = r101;
            GradientSpread r102 = new GradientSpread(SalesInfoStruct.REPEAT, 2);
            repeat = r102;
            f272760a = new GradientSpread[]{r100, r101, r102};
        }

        public static GradientSpread[] values() {
            return (GradientSpread[]) f272760a.clone();
        }

        public static GradientSpread valueOf(String r100) {
            return (GradientSpread) r27.a.a(GradientSpread.class, r100);
        }

        public GradientSpread(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class Style implements Cloneable {
        public Boolean A;
        public Boolean B;
        public m0 C;
        public Float D;
        public String E;
        public FillRule F;
        public String G;
        public m0 H;
        public Float I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public m0 f272761J;
        public Float K;
        public VectorEffect L;
        public RenderQuality M;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f272762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m0 f272763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FillRule f272764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Float f272765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public m0 f272766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Float f272767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o f272768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public LineCap f272769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public LineJoin f272770i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Float f272771j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o[] f272772k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f272773l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Float f272774m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public f f272775n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<String> f272776o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272777p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Integer f272778q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public FontStyle f272779r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public TextDecoration f272780s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public TextDirection f272781t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public TextAnchor f272782u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Boolean f272783v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public c f272784w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f272785x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f272786y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f272787z;

        public static final enum FillRule extends Enum<FillRule> {
            public static final FillRule EvenOdd = null;
            public static final FillRule NonZero = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ FillRule[] f272788a = null;

            static {
                FillRule r100 = new FillRule("NonZero", 0);
                NonZero = r100;
                FillRule r101 = new FillRule("EvenOdd", 1);
                EvenOdd = r101;
                f272788a = new FillRule[]{r100, r101};
            }

            public static FillRule[] values() {
                return (FillRule[]) f272788a.clone();
            }

            public static FillRule valueOf(String r100) {
                return (FillRule) r27.a.a(FillRule.class, r100);
            }

            public FillRule(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum FontStyle extends Enum<FontStyle> {
            public static final FontStyle Italic = null;
            public static final FontStyle Normal = null;
            public static final FontStyle Oblique = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ FontStyle[] f272789a = null;

            static {
                FontStyle r100 = new FontStyle("Normal", 0);
                Normal = r100;
                FontStyle r101 = new FontStyle("Italic", 1);
                Italic = r101;
                FontStyle r102 = new FontStyle("Oblique", 2);
                Oblique = r102;
                f272789a = new FontStyle[]{r100, r101, r102};
            }

            public static FontStyle[] values() {
                return (FontStyle[]) f272789a.clone();
            }

            public static FontStyle valueOf(String r100) {
                return (FontStyle) r27.a.a(FontStyle.class, r100);
            }

            public FontStyle(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum LineCap extends Enum<LineCap> {
            public static final LineCap Butt = null;
            public static final LineCap Round = null;
            public static final LineCap Square = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LineCap[] f272790a = null;

            static {
                LineCap r100 = new LineCap("Butt", 0);
                Butt = r100;
                LineCap r101 = new LineCap("Round", 1);
                Round = r101;
                LineCap r102 = new LineCap("Square", 2);
                Square = r102;
                f272790a = new LineCap[]{r100, r101, r102};
            }

            public static LineCap[] values() {
                return (LineCap[]) f272790a.clone();
            }

            public static LineCap valueOf(String r100) {
                return (LineCap) r27.a.a(LineCap.class, r100);
            }

            public LineCap(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum LineJoin extends Enum<LineJoin> {
            public static final LineJoin Bevel = null;
            public static final LineJoin Miter = null;
            public static final LineJoin Round = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LineJoin[] f272791a = null;

            static {
                LineJoin r100 = new LineJoin("Miter", 0);
                Miter = r100;
                LineJoin r101 = new LineJoin("Round", 1);
                Round = r101;
                LineJoin r102 = new LineJoin("Bevel", 2);
                Bevel = r102;
                f272791a = new LineJoin[]{r100, r101, r102};
            }

            public static LineJoin[] values() {
                return (LineJoin[]) f272791a.clone();
            }

            public static LineJoin valueOf(String r100) {
                return (LineJoin) r27.a.a(LineJoin.class, r100);
            }

            public LineJoin(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum RenderQuality extends Enum<RenderQuality> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ RenderQuality[] f272792a = null;
            public static final RenderQuality auto = null;
            public static final RenderQuality optimizeQuality = null;
            public static final RenderQuality optimizeSpeed = null;

            static {
                RenderQuality r100 = new RenderQuality("auto", 0);
                auto = r100;
                RenderQuality r101 = new RenderQuality("optimizeQuality", 1);
                optimizeQuality = r101;
                RenderQuality r102 = new RenderQuality("optimizeSpeed", 2);
                optimizeSpeed = r102;
                f272792a = new RenderQuality[]{r100, r101, r102};
            }

            public static RenderQuality[] values() {
                return (RenderQuality[]) f272792a.clone();
            }

            public static RenderQuality valueOf(String r100) {
                return (RenderQuality) r27.a.a(RenderQuality.class, r100);
            }

            public RenderQuality(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum TextAnchor extends Enum<TextAnchor> {
            public static final TextAnchor End = null;
            public static final TextAnchor Middle = null;
            public static final TextAnchor Start = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TextAnchor[] f272793a = null;

            static {
                TextAnchor r100 = new TextAnchor("Start", 0);
                Start = r100;
                TextAnchor r101 = new TextAnchor("Middle", 1);
                Middle = r101;
                TextAnchor r102 = new TextAnchor("End", 2);
                End = r102;
                f272793a = new TextAnchor[]{r100, r101, r102};
            }

            public static TextAnchor[] values() {
                return (TextAnchor[]) f272793a.clone();
            }

            public static TextAnchor valueOf(String r100) {
                return (TextAnchor) r27.a.a(TextAnchor.class, r100);
            }

            public TextAnchor(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum TextDecoration extends Enum<TextDecoration> {
            public static final TextDecoration Blink = null;
            public static final TextDecoration LineThrough = null;
            public static final TextDecoration None = null;
            public static final TextDecoration Overline = null;
            public static final TextDecoration Underline = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TextDecoration[] f272794a = null;

            static {
                TextDecoration r100 = new TextDecoration("None", 0);
                None = r100;
                TextDecoration r101 = new TextDecoration("Underline", 1);
                Underline = r101;
                TextDecoration r102 = new TextDecoration("Overline", 2);
                Overline = r102;
                TextDecoration r103 = new TextDecoration("LineThrough", 3);
                LineThrough = r103;
                TextDecoration r104 = new TextDecoration("Blink", 4);
                Blink = r104;
                f272794a = new TextDecoration[]{r100, r101, r102, r103, r104};
            }

            public static TextDecoration[] values() {
                return (TextDecoration[]) f272794a.clone();
            }

            public static TextDecoration valueOf(String r100) {
                return (TextDecoration) r27.a.a(TextDecoration.class, r100);
            }

            public TextDecoration(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum TextDirection extends Enum<TextDirection> {
            public static final TextDirection LTR = null;
            public static final TextDirection RTL = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TextDirection[] f272795a = null;

            static {
                TextDirection r100 = new TextDirection("LTR", 0);
                LTR = r100;
                TextDirection r101 = new TextDirection("RTL", 1);
                RTL = r101;
                f272795a = new TextDirection[]{r100, r101};
            }

            public static TextDirection[] values() {
                return (TextDirection[]) f272795a.clone();
            }

            public static TextDirection valueOf(String r100) {
                return (TextDirection) r27.a.a(TextDirection.class, r100);
            }

            public TextDirection(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum VectorEffect extends Enum<VectorEffect> {
            public static final VectorEffect NonScalingStroke = null;
            public static final VectorEffect None = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ VectorEffect[] f272796a = null;

            static {
                VectorEffect r100 = new VectorEffect("None", 0);
                None = r100;
                VectorEffect r101 = new VectorEffect("NonScalingStroke", 1);
                NonScalingStroke = r101;
                f272796a = new VectorEffect[]{r100, r101};
            }

            public static VectorEffect[] values() {
                return (VectorEffect[]) f272796a.clone();
            }

            public static VectorEffect valueOf(String r100) {
                return (VectorEffect) r27.a.a(VectorEffect.class, r100);
            }

            public VectorEffect(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static Style a() {
            Style r100 = new Style();
            r100.f272762a = -1;
            f r101 = f.f272836b;
            r100.f272763b = r101;
            FillRule r102 = FillRule.NonZero;
            r100.f272764c = r102;
            Float r103 = Float.valueOf(1.0f);
            r100.f272765d = r103;
            r100.f272766e = null;
            r100.f272767f = r103;
            r100.f272768g = new o(1.0f);
            r100.f272769h = LineCap.Butt;
            r100.f272770i = LineJoin.Miter;
            r100.f272771j = Float.valueOf(4.0f);
            r100.f272772k = null;
            r100.f272773l = new o(0.0f);
            r100.f272774m = r103;
            r100.f272775n = r101;
            r100.f272776o = null;
            r100.f272777p = new o(12.0f, Unit.f272804pt);
            r100.f272778q = 400;
            r100.f272779r = FontStyle.Normal;
            r100.f272780s = TextDecoration.None;
            r100.f272781t = TextDirection.LTR;
            r100.f272782u = TextAnchor.Start;
            Boolean r104 = Boolean.TRUE;
            r100.f272783v = r104;
            r100.f272784w = null;
            r100.f272785x = null;
            r100.f272786y = null;
            r100.f272787z = null;
            r100.A = r104;
            r100.B = r104;
            r100.C = r101;
            r100.D = r103;
            r100.E = null;
            r100.F = r102;
            r100.G = null;
            r100.H = null;
            r100.I = r103;
            r100.f272761J = null;
            r100.K = r103;
            r100.L = VectorEffect.None;
            r100.M = RenderQuality.auto;
            return r100;
        }

        public Style() {
            this.f272762a = 0;
        }

        public final Object clone() throws CloneNotSupportedException {
            Style r100 = (Style) super.clone();
            o[] r101 = this.f272772k;
            if (r101 == null) goto L5;
            r100.f272772k = (o[]) r101.clone();
        L5:
            return r100;
        }
    }

    public static final enum Unit extends Enum<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Unit[] f272797a = null;

        /* JADX INFO: renamed from: cm, reason: collision with root package name */
        public static final Unit f272798cm = null;

        /* JADX INFO: renamed from: em, reason: collision with root package name */
        public static final Unit f272799em = null;

        /* JADX INFO: renamed from: ex, reason: collision with root package name */
        public static final Unit f272800ex = null;

        /* JADX INFO: renamed from: in, reason: collision with root package name */
        public static final Unit f272801in = null;

        /* JADX INFO: renamed from: mm, reason: collision with root package name */
        public static final Unit f272802mm = null;

        /* JADX INFO: renamed from: pc, reason: collision with root package name */
        public static final Unit f272803pc = null;
        public static final Unit percent = null;

        /* JADX INFO: renamed from: pt, reason: collision with root package name */
        public static final Unit f272804pt = null;

        /* JADX INFO: renamed from: px, reason: collision with root package name */
        public static final Unit f272805px = null;

        static {
            Unit r100 = new Unit(GXTemplateKey.GAIAX_PX, 0);
            f272805px = r100;
            Unit r101 = new Unit("em", 1);
            f272799em = r101;
            Unit r102 = new Unit(BaseHttpRequestInfo.KEY_EXCEPTION, 2);
            f272800ex = r102;
            Unit r103 = new Unit("in", 3);
            f272801in = r103;
            Unit r104 = new Unit("cm", 4);
            f272798cm = r104;
            Unit r105 = new Unit("mm", 5);
            f272802mm = r105;
            Unit r110 = new Unit(GXTemplateKey.GAIAX_PT, 6);
            f272804pt = r110;
            Unit r111 = new Unit(BackupSeiMessage.SOURCE_PC, 7);
            f272803pc = r111;
            Unit r112 = new Unit("percent", 8);
            percent = r112;
            f272797a = new Unit[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static Unit[] values() {
            return (Unit[]) f272797a.clone();
        }

        public static Unit valueOf(String r100) {
            return (Unit) r27.a.a(Unit.class, r100);
        }

        public Unit(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272806a = null;

        static {
            int[] r100 = new int[Unit.values().length];
            f272806a = r100;
            r100[Unit.f272805px.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f272806a[Unit.f272799em.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f272806a[Unit.f272800ex.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f272806a[Unit.f272801in.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f272806a[Unit.f272798cm.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f272806a[Unit.f272802mm.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f272806a[Unit.f272804pt.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f272806a[Unit.f272803pc.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f272806a[Unit.percent.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static class a0 extends k {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f272807o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272808p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272809q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272810r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public o f272811s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public o f272812t;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.RECT;
        }

        public a0() {
        }
    }

    public static class a1 extends l0 implements v0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f272813c;

        @Override // com.caverock.androidsvg.SVG.v0
        public final z0 h() {
            return null;
        }

        public final String toString() {
            return "TextChild: '" + this.f272813c + "'";
        }

        public a1(String r100) {
            this.f272813c = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f272814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f272815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f272816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f272817d;

        public final String toString() {
            return "[" + this.f272814a + " " + this.f272815b + " " + this.f272816c + " " + this.f272817d + "]";
        }

        public b(b r100) {
            this.f272814a = r100.f272814a;
            this.f272815b = r100.f272815b;
            this.f272816c = r100.f272816c;
            this.f272817d = r100.f272817d;
        }

        public b(float r100, float r101, float r102, float r103) {
            this.f272814a = r100;
            this.f272815b = r101;
            this.f272816c = r102;
            this.f272817d = r103;
        }
    }

    public static class b0 extends j0 implements h0 {
        @Override // com.caverock.androidsvg.SVG.h0
        public final void f(l0 r100) {
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "solidColor";
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public final List<l0> getChildren() {
            return Collections.emptyList();
        }

        public b0() {
        }
    }

    public static class b1 extends l {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f272818p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272819q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272820r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public o f272821s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public o f272822t;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public final String n() {
            return NameKeys.LoadStrategy_Use;
        }

        public b1() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f272823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f272824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f272825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o f272826d;

        public c(o r100, o r101, o r102, o r103) {
            this.f272823a = r100;
            this.f272824b = r101;
            this.f272825c = r102;
            this.f272826d = r103;
        }
    }

    public static class c0 extends j0 implements h0 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Float f272827h;

        @Override // com.caverock.androidsvg.SVG.h0
        public final void f(l0 r100) {
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "stop";
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public final List<l0> getChildren() {
            return Collections.emptyList();
        }

        public c0() {
        }
    }

    public static class c1 extends p0 implements s {
        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "view";
        }

        public c1() {
        }
    }

    public static class d extends k {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f272828o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272829p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272830q;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.CIRCLE;
        }

        public d() {
        }
    }

    public static class d0 extends p0 {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272831q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272832r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public o f272833s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public o f272834t;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "svg";
        }

        public d0() {
        }
    }

    public static class e extends l implements s {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f272835p;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.CLIP_PATH;
        }

        public e() {
        }
    }

    public interface e0 {
        void b(String r100);

        String c();

        Set<String> d();

        Set<String> e();

        Set<String> g();

        void i(Set<String> r100);

        Set<String> j();

        void k(Set<String> r100);

        void l(Set<String> r100);

        void m(Set<String> r100);
    }

    public static class f extends m0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f272836b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f272837c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f272838a;

        public final String toString() {
            return String.format("#%08x", new Object[]{Integer.valueOf(this.f272838a)});
        }

        static {
            f272836b = new f(-16777216);
            f272837c = new f(0);
        }

        public f(int r100) {
            this.f272838a = r100;
        }
    }

    public static abstract class f0 extends i0 implements h0, e0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<l0> f272839i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Set<String> f272840j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f272841k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Set<String> f272842l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Set<String> f272843m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Set<String> f272844n;

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> e() {
            return null;
        }

        public f0() {
            this.f272839i = new ArrayList();
            this.f272840j = null;
            this.f272841k = null;
            this.f272843m = null;
            this.f272844n = null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final String c() {
            return this.f272841k;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> d() {
            return this.f272843m;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> g() {
            return this.f272844n;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public final List<l0> getChildren() {
            return this.f272839i;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> j() {
            return this.f272840j;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void b(String r100) {
            this.f272841k = r100;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void f(l0 r100) throws SVGParseException {
            this.f272839i.add(r100);
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void i(Set<String> r100) {
            this.f272842l = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void k(Set<String> r100) {
            this.f272843m = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void l(Set<String> r100) {
            this.f272844n = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void m(Set<String> r100) {
            this.f272840j = r100;
        }
    }

    public static class g extends m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f272845a = null;

        static {
            f272845a = new g();
        }

        public g() {
        }
    }

    public static abstract class g0 extends i0 implements e0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Set<String> f272846i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f272847j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Set<String> f272848k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Set<String> f272849l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Set<String> f272850m;

        public g0() {
            this.f272846i = null;
            this.f272847j = null;
            this.f272848k = null;
            this.f272849l = null;
            this.f272850m = null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final String c() {
            return this.f272847j;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> d() {
            return this.f272849l;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> e() {
            return this.f272848k;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> g() {
            return this.f272850m;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final Set<String> j() {
            return this.f272846i;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void b(String r100) {
            this.f272847j = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void i(Set<String> r100) {
            this.f272848k = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void k(Set<String> r100) {
            this.f272849l = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void l(Set<String> r100) {
            this.f272850m = r100;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public final void m(Set<String> r100) {
            this.f272846i = r100;
        }
    }

    public static class h extends l implements s {
        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "defs";
        }

        public h() {
        }
    }

    public interface h0 {
        void f(l0 r100) throws SVGParseException;

        List<l0> getChildren();
    }

    public static class i extends k {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f272851o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272852p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272853q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272854r;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.ELLIPSE;
        }

        public i() {
        }
    }

    public static abstract class i0 extends j0 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b f272855h;

        public i0() {
            this.f272855h = null;
        }
    }

    public static abstract class j extends j0 implements h0 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<l0> f272856h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f272857i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Matrix f272858j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public GradientSpread f272859k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f272860l;

        public j() {
            this.f272856h = new ArrayList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public final List<l0> getChildren() {
            return this.f272856h;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public final void f(l0 r100) throws SVGParseException {
            if ((r100 instanceof c0) == false) goto L7;
            this.f272856h.add(r100);
            return;
        L7:
            throw new SVGParseException("Gradient elements cannot contain " + r100 + " elements.");
        }
    }

    public static abstract class j0 extends l0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f272861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f272862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Style f272863e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Style f272864f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<String> f272865g;

        public j0() {
            this.f272861c = null;
            this.f272862d = null;
            this.f272863e = null;
            this.f272864f = null;
            this.f272865g = null;
        }

        public final String toString() {
            return n();
        }
    }

    public static abstract class k extends g0 implements m {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Matrix f272866n;

        public k() {
        }

        @Override // com.caverock.androidsvg.SVG.m
        public final void a(Matrix r100) {
            this.f272866n = r100;
        }
    }

    public static class k0 extends j {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f272867m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f272868n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f272869o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272870p;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.LINEAR_GRADIENT;
        }

        public k0() {
        }
    }

    public static class l extends f0 implements m {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Matrix f272871o;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            return "group";
        }

        public l() {
        }

        @Override // com.caverock.androidsvg.SVG.m
        public final void a(Matrix r100) {
            this.f272871o = r100;
        }
    }

    public static class l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SVG f272872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h0 f272873b;

        public l0() {
        }

        public String n() {
            return "";
        }
    }

    public interface m {
        void a(Matrix r100);
    }

    public static abstract class m0 implements Cloneable {
        public m0() {
        }
    }

    public static class n extends n0 implements m {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f272874p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272875q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272876r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public o f272877s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public o f272878t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Matrix f272879u;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "image";
        }

        public n() {
        }

        @Override // com.caverock.androidsvg.SVG.m
        public final void a(Matrix r100) {
            this.f272879u = r100;
        }
    }

    public static abstract class n0 extends f0 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public PreserveAspectRatio f272880o;

        public n0() {
            this.f272880o = null;
        }
    }

    public static class o implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f272881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Unit f272882b;

        public final boolean f() {
            if (this.f272881a >= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean g() {
            if (this.f272881a != 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public final String toString() {
            return String.valueOf(this.f272881a) + this.f272882b;
        }

        public o(float r100) {
            this.f272881a = r100;
            this.f272882b = Unit.f272805px;
        }

        public final float a(float r100) {
            int r101 = a.f272806a[this.f272882b.ordinal()];
            if (r101 == 1) goto L18;
            switch(r101) {
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                default: goto L6;
            };
        L6:
            return this.f272881a;
        L8:
            return (this.f272881a * r100) / 6.0f;
        L10:
            return (this.f272881a * r100) / 72.0f;
        L12:
            return (this.f272881a * r100) / 25.4f;
        L14:
            return (this.f272881a * r100) / 2.54f;
        L16:
            return this.f272881a * r100;
        L18:
            return this.f272881a;
        }

        public final float b(com.caverock.androidsvg.d r100) {
            if (this.f272882b != Unit.percent) goto L18;
            com.caverock.androidsvg.d.h r101 = r100.f272994d;
            b r102 = r101.f273032g;
            if (r102 != null) goto L8;
            r102 = r101.f273031f;
        L8:
            if (r102 == null) goto L10;
            float r103 = r102.f272816c;
            float r104 = r102.f272817d;
            if (r103 != r104) goto L16;
            float r105 = this.f272881a;
        L15:
            return (r105 * r103) / 100.0f;
        L16:
            r103 = (float) (Math.sqrt((r103 * r103) + (r104 * r104)) / 1.414213562373095d);
            r105 = this.f272881a;
            goto L15
        L10:
            return this.f272881a;
        L18:
            return d(r100);
        }

        public final float d(com.caverock.androidsvg.d r100) {
            switch(a.f272806a[this.f272882b.ordinal()]) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L22;
                case 6: goto L20;
                case 7: goto L18;
                case 8: goto L16;
                case 9: goto L6;
                default: goto L5;
            };
        L6:
            com.caverock.androidsvg.d.h r101 = r100.f272994d;
            b r102 = r101.f273032g;
            if (r102 != null) goto L10;
            r102 = r101.f273031f;
        L10:
            if (r102 != null) goto L14;
            return this.f272881a;
        L14:
            return (this.f272881a * r102.f272816c) / 100.0f;
        L5:
            return this.f272881a;
        L16:
            return (this.f272881a * r100.f272992b) / 6.0f;
        L18:
            return (this.f272881a * r100.f272992b) / 72.0f;
        L20:
            return (this.f272881a * r100.f272992b) / 25.4f;
        L22:
            return (this.f272881a * r100.f272992b) / 2.54f;
        L24:
            return this.f272881a * r100.f272992b;
        L26:
            return this.f272881a * (r100.f272994d.f273029d.getTextSize() / 2.0f);
        L28:
            return this.f272881a * r100.f272994d.f273029d.getTextSize();
        L30:
            return this.f272881a;
        }

        public final float e(com.caverock.androidsvg.d r100) {
            if (this.f272882b != Unit.percent) goto L14;
            com.caverock.androidsvg.d.h r101 = r100.f272994d;
            b r102 = r101.f273032g;
            if (r102 != null) goto L8;
            r102 = r101.f273031f;
        L8:
            if (r102 != null) goto L12;
            return this.f272881a;
        L12:
            return (this.f272881a * r102.f272817d) / 100.0f;
        L14:
            return d(r100);
        }

        public o(float r100, Unit r101) {
            this.f272881a = r100;
            this.f272882b = r101;
        }

        public final float c(com.caverock.androidsvg.d r100, float r101) {
            if (this.f272882b != Unit.percent) goto L7;
            return (this.f272881a * r101) / 100.0f;
        L7:
            return d(r100);
        }
    }

    public static class o0 extends j {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f272883m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f272884n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f272885o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272886p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272887q;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.RADIAL_GRADIENT;
        }

        public o0() {
        }
    }

    public static class p extends k {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f272888o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272889p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272890q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272891r;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "line";
        }

        public p() {
        }
    }

    public static abstract class p0 extends n0 {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public b f272892p;

        public p0() {
        }
    }

    public static class q extends p0 implements s {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f272893q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272894r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public o f272895s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public o f272896t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public o f272897u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Float f272898v;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "marker";
        }

        public q() {
        }
    }

    public static class q0 extends l {
        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "switch";
        }

        public q0() {
        }
    }

    public static class r extends f0 implements s {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Boolean f272899o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f272900p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f272901q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public o f272902r;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return BuyNowCloseMethod.MASK;
        }

        public r() {
        }
    }

    public static class r0 extends p0 implements s {
        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "symbol";
        }

        public r0() {
        }
    }

    public interface s {
    }

    public static class s0 extends w0 implements v0 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f272903o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public z0 f272904p;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "tref";
        }

        public s0() {
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public final z0 h() {
            return this.f272904p;
        }
    }

    public static class t extends m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f272905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m0 f272906b;

        public final String toString() {
            return this.f272905a + " " + this.f272906b;
        }

        public t(String r100, m0 r101) {
            this.f272905a = r100;
            this.f272906b = r101;
        }
    }

    public static class t0 extends y0 implements v0 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public z0 f272907s;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "tspan";
        }

        public t0() {
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public final z0 h() {
            return this.f272907s;
        }
    }

    public static class u extends k {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public v f272908o;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "path";
        }

        public u() {
        }
    }

    public static class u0 extends y0 implements z0, m {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Matrix f272909s;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "text";
        }

        public u0() {
        }

        @Override // com.caverock.androidsvg.SVG.m
        public final void a(Matrix r100) {
            this.f272909s = r100;
        }
    }

    public static class v implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f272910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f272911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f272912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f272913d;

        @Override // com.caverock.androidsvg.SVG.w
        public final void close() {
            c((byte) 8);
        }

        public v() {
            this.f272911b = 0;
            this.f272913d = 0;
            this.f272910a = new byte[8];
            this.f272912c = new float[16];
        }

        public final void c(byte r100) {
            int r101 = this.f272911b;
            byte[] r102 = this.f272910a;
            if (r101 != r102.length) goto L5;
            byte[] r103 = new byte[r102.length * 2];
            System.arraycopy(r102, 0, r103, 0, r102.length);
            this.f272910a = r103;
        L5:
            byte[] r104 = this.f272910a;
            int r105 = this.f272911b;
            this.f272911b = r105 + 1;
            r104[r105] = r100;
        }

        public final void d(int r100) {
            float[] r101 = this.f272912c;
            if (r101.length >= (this.f272913d + r100)) goto L6;
            float[] r102 = new float[r101.length * 2];
            System.arraycopy(r101, 0, r102, 0, r101.length);
            this.f272912c = r102;
            return;
        }

        public final void e(w r110) {
            int r100 = 0;
            int r101 = 0;
        L4:
            if (r100 >= this.f272911b) goto L31;
            byte r102 = this.f272910a[r100];
            if (r102 != 0) goto L8;
            float[] r103 = this.f272912c;
            int r104 = r101 + 1;
            int r105 = r104 + 1;
            r110.moveTo(r103[r101], r103[r104]);
        L29:
            r101 = r105;
        L30:
            r100 = r100 + 1;
            goto L4
        L8:
            if (r102 != 1) goto L10;
            float[] r106 = this.f272912c;
            int r107 = r101 + 1;
            r105 = r107 + 1;
            r110.lineTo(r106[r101], r106[r107]);
            goto L29
        L10:
            if (r102 != 2) goto L12;
            float[] r108 = this.f272912c;
            int r109 = r101 + 1;
            float r111 = r108[r101];
            int r112 = r109 + 1;
            float r113 = r108[r109];
            int r114 = r112 + 1;
            float r115 = r108[r112];
            int r116 = r114 + 1;
            float r117 = r108[r114];
            int r118 = r116 + 1;
            float r119 = r108[r116];
            r101 = r118 + 1;
            r110.cubicTo(r111, r113, r115, r117, r119, r108[r118]);
            goto L30
        L12:
            if (r102 != 3) goto L14;
            float[] r120 = this.f272912c;
            int r121 = r101 + 1;
            int r122 = r121 + 1;
            int r123 = r122 + 1;
            r110.b(r120[r101], r120[r121], r120[r122], r120[r123]);
            r101 = r123 + 1;
            goto L30
        L14:
            if (r102 != 8) goto L16;
            r110.close();
            goto L30
        L16:
            if ((r102 & 2) == 0) goto L18;
            boolean r124 = true;
        L20:
            if ((r102 & 1) == 0) goto L22;
            boolean r125 = true;
        L23:
            float[] r126 = this.f272912c;
            int r127 = r101 + 1;
            float r128 = r126[r101];
            int r129 = r127 + 1;
            float r130 = r126[r127];
            int r131 = r129 + 1;
            float r132 = r126[r129];
            int r133 = r131 + 1;
            float r134 = r126[r131];
            r110.a(r128, r130, r132, r124, r125, r134, r126[r133]);
            r101 = r133 + 1;
            goto L30
        L22:
            r125 = false;
            goto L23
        L18:
            r124 = false;
            goto L20
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void lineTo(float r100, float r101) {
            c((byte) 1);
            d(2);
            float[] r102 = this.f272912c;
            int r103 = this.f272913d;
            int r104 = r103 + 1;
            r102[r103] = r100;
            this.f272913d = r104 + 1;
            r102[r104] = r101;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void moveTo(float r100, float r101) {
            c((byte) 0);
            d(2);
            float[] r102 = this.f272912c;
            int r103 = this.f272913d;
            int r104 = r103 + 1;
            r102[r103] = r100;
            this.f272913d = r104 + 1;
            r102[r104] = r101;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void b(float r100, float r101, float r102, float r103) {
            c((byte) 3);
            d(4);
            float[] r104 = this.f272912c;
            int r105 = this.f272913d;
            int r106 = r105 + 1;
            r104[r105] = r100;
            int r107 = r106 + 1;
            r104[r106] = r101;
            int r108 = r107 + 1;
            r104[r107] = r102;
            this.f272913d = r108 + 1;
            r104[r108] = r103;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void cubicTo(float r100, float r101, float r102, float r103, float r104, float r105) {
            c((byte) 2);
            d(6);
            float[] r106 = this.f272912c;
            int r107 = this.f272913d;
            int r108 = r107 + 1;
            r106[r107] = r100;
            int r109 = r108 + 1;
            r106[r108] = r101;
            int r110 = r109 + 1;
            r106[r109] = r102;
            int r111 = r110 + 1;
            r106[r110] = r103;
            int r112 = r111 + 1;
            r106[r111] = r104;
            this.f272913d = r112 + 1;
            r106[r112] = r105;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public final void a(float r100, float r101, float r102, boolean r103, boolean r104, float r105, float r106) {
            if (r103 == false) goto L4;
            int r107 = 2;
        L5:
            c((byte) ((r107 | 4) | (r104 ? 1 : 0)));
            d(5);
            float[] r108 = this.f272912c;
            int r109 = this.f272913d;
            int r110 = r109 + 1;
            r108[r109] = r100;
            int r111 = r110 + 1;
            r108[r110] = r101;
            int r112 = r111 + 1;
            r108[r111] = r102;
            int r113 = r112 + 1;
            r108[r112] = r105;
            this.f272913d = r113 + 1;
            r108[r113] = r106;
            return;
        L4:
            r107 = 0;
            goto L5
        }
    }

    public interface v0 {
        z0 h();
    }

    public interface w {
        void a(float r100, float r101, float r102, boolean r103, boolean r104, float r105, float r106);

        void b(float r100, float r101, float r102, float r103);

        void close();

        void cubicTo(float r100, float r101, float r102, float r103, float r104, float r105);

        void lineTo(float r100, float r101);

        void moveTo(float r100, float r101);
    }

    public static abstract class w0 extends f0 {
        public w0() {
        }

        @Override // com.caverock.androidsvg.SVG.f0, com.caverock.androidsvg.SVG.h0
        public final void f(l0 r100) throws SVGParseException {
            if ((r100 instanceof v0) == false) goto L7;
            this.f272839i.add(r100);
            return;
        L7:
            throw new SVGParseException("Text content elements cannot contain " + r100 + " elements.");
        }
    }

    public static class x extends p0 implements s {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f272914q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Boolean f272915r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Matrix f272916s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public o f272917t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public o f272918u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public o f272919v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public o f272920w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f272921x;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "pattern";
        }

        public x() {
        }
    }

    public static class x0 extends w0 implements v0 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f272922o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f272923p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public z0 f272924q;

        @Override // com.caverock.androidsvg.SVG.l0
        public final String n() {
            return "textPath";
        }

        public x0() {
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public final z0 h() {
            return this.f272924q;
        }
    }

    public static class y extends k {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float[] f272925o;

        @Override // com.caverock.androidsvg.SVG.l0
        public String n() {
            return SVGRenderEngine.POLYLINE;
        }

        public y() {
        }
    }

    public static abstract class y0 extends w0 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<o> f272926o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List<o> f272927p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List<o> f272928q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List<o> f272929r;

        public y0() {
        }
    }

    public static class z extends y {
        @Override // com.caverock.androidsvg.SVG.y, com.caverock.androidsvg.SVG.l0
        public final String n() {
            return SVGRenderEngine.POLYGON;
        }

        public z() {
        }
    }

    public interface z0 {
    }

    public SVG() {
        this.f272756a = null;
        this.f272757b = 96.0f;
        this.f272758c = new CSSParser.m();
        this.f272759d = new HashMap();
    }

    public static SVG d(InputStream r100) throws SVGParseException {
        return new SVGParser().g(r100);
    }

    public final b a(float r100) {
        d0 r101 = this.f272756a;
        o r102 = r101.f272833s;
        o r103 = r101.f272834t;
        if (r102 == null) goto L32;
        if (r102.g() == true) goto L32;
        Unit r104 = r102.f272882b;
        Unit r105 = Unit.percent;
        if (r104 == r105) goto L32;
        Unit r106 = Unit.f272799em;
        if (r104 == r106) goto L32;
        Unit r107 = Unit.f272800ex;
        if (r104 == r107) goto L32;
        float r108 = r102.a(r100);
        if (r103 != null) goto L16;
        b r109 = this.f272756a.f272892p;
        if (r109 == null) goto L28;
        float r110 = (r109.f272817d * r108) / r109.f272816c;
    L30:
        return new b(0.0f, 0.0f, r108, r110);
    L28:
        r110 = r108;
        goto L30
    L16:
        if (r103.g() == true) goto L24;
        Unit r111 = r103.f272882b;
        if (r111 == r105) goto L24;
        if (r111 == r106) goto L24;
        if (r111 == r107) goto L24;
        r110 = r103.a(r100);
    L24:
        return new b(-1.0f, -1.0f, -1.0f, -1.0f);
    L32:
        return new b(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    public final j0 c(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        if (r100.equals(this.f272756a.f272861c) == false) goto L11;
        return this.f272756a;
    L11:
        if (((HashMap) this.f272759d).containsKey(r100) == true) goto L13;
        j0 r101 = b(this.f272756a, r100);
        ((HashMap) this.f272759d).put(r100, r101);
        return r101;
    L13:
        return (j0) ((HashMap) this.f272759d).get(r100);
    }

    public final void e(Canvas r100) {
        com.caverock.androidsvg.c r101 = new com.caverock.androidsvg.c();
        if (r101.f272989e == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        r101.f272989e = new b(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
    L8:
        new com.caverock.androidsvg.d(r100, this.f272757b).I(this, r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final Picture g(com.caverock.androidsvg.c r100) {
        boolean r101 = true;
        if (r100 == null) goto L10;
        b r102 = r100.f272987c;
        if (r102 == null) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
    L11:
        if (r100 == null) goto L19;
        b r104 = r100.f272989e;
        if (r104 != null) goto L16;
        r101 = false;
    L16:
        if (r101 == false) goto L19;
        return f((int) Math.ceil(r104.f272814a + r104.f272816c), (int) Math.ceil(r104.f272815b + r104.f272817d), r100);
    L19:
        d0 r105 = this.f272756a;
        o r106 = r105.f272833s;
        if (r106 == null) goto L29;
        Unit r107 = r106.f272882b;
        Unit r108 = Unit.percent;
        if (r107 == r108) goto L29;
        o r109 = r105.f272834t;
        if (r109 == null) goto L29;
        if (r109.f272882b == r108) goto L29;
        return f((int) Math.ceil(r106.a(this.f272757b)), (int) Math.ceil(this.f272756a.f272834t.a(this.f272757b)), r100);
    L29:
        if (r106 == null) goto L33;
        if (r102 == null) goto L33;
        float r110 = r106.a(this.f272757b);
        return f((int) Math.ceil(r110), (int) Math.ceil((r102.f272817d * r110) / r102.f272816c), r100);
    L33:
        o r111 = r105.f272834t;
        if (r111 == null) goto L39;
        if (r102 == null) goto L39;
        float r112 = r111.a(this.f272757b);
        return f((int) Math.ceil((r102.f272816c * r112) / r102.f272817d), (int) Math.ceil(r112), r100);
    L39:
        return f(512, 512, r100);
    L7:
        r103 = false;
    L10:
        r102 = this.f272756a.f272892p;
        goto L11
    }

    public final j0 h(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.startsWith("\"") == false) goto L11;
        if (r100.endsWith("\"") == false) goto L11;
        r100 = r100.substring(1, r100.length() - 1).replace("\\\"", "\"");
    L15:
        String r101 = r100.replace("\\\n", "").replace("\\A", "\n");
        if (r101.length() > 1) goto L18;
    L21:
        return null;
    L18:
        if (r101.startsWith("#") == false) goto L21;
        return c(r101.substring(1));
    L11:
        if (r100.startsWith("'") == false) goto L15;
        if (r100.endsWith("'") == false) goto L15;
        r100 = r100.substring(1, r100.length() - 1).replace("\\'", "'");
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static j0 b(h0 r100, String r101) {
        j0 r102 = (j0) r100;
        if (r101.equals(r102.f272861c) == false) goto L5;
        return r102;
    L5:
        Iterator<l0> r103 = r100.getChildren().iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        Object r104 = (l0) r103.next();
        if ((r104 instanceof j0) == false) goto L7;
        j0 r105 = (j0) r104;
        if (r101.equals(r105.f272861c) == true) goto L13;
        if ((r104 instanceof h0) == false) goto L7;
        j0 r106 = b((h0) r104, r101);
        if (r106 == null) goto L7;
        return r106;
    L13:
        return r105;
    L19:
        return null;
    }

    public final Picture f(int r100, int r101, com.caverock.androidsvg.c r102) {
        Picture r103 = new Picture();
        Canvas r104 = r103.beginRecording(r100, r101);
        if (r102 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
        r102 = new com.caverock.androidsvg.c();
    L9:
        r102.f272989e = new b(0.0f, 0.0f, r100, r101);
    L10:
        new com.caverock.androidsvg.d(r104, this.f272757b).I(this, r102);
        r103.endRecording();
        return r103;
    L8:
        r102 = new com.caverock.androidsvg.c(r102);
        goto L9
    L5:
        if (r102.f272989e != null) goto L10;
        goto L6
    }
}
