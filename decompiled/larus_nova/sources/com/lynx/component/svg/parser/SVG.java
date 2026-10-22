package com.lynx.component.svg.parser;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.aivoice.core.data.NameKeys;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class SVG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f381027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, e0> f381028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.lynx.component.svg.parser.c f381029c;

    public static final enum GradientSpread extends Enum<GradientSpread> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GradientSpread[] f381030a = null;
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
            f381030a = new GradientSpread[]{r100, r101, r102};
        }

        public static GradientSpread[] values() {
            return (GradientSpread[]) f381030a.clone();
        }

        public static GradientSpread valueOf(String r100) {
            return (GradientSpread) r27.a.a(GradientSpread.class, r100);
        }

        public GradientSpread(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class Style implements Cloneable {
        public VectorEffect A;
        public RenderQuality B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f381031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h0 f381032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FillRule f381033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Float f381034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public h0 f381035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Float f381036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o f381037g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public LineCap f381038h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public LineJoin f381039i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Float f381040j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o[] f381041k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381042l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Float f381043m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public f f381044n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Boolean f381045o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public c f381046p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f381047q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Boolean f381048r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public h0 f381049s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Float f381050t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f381051u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public FillRule f381052v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public h0 f381053w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Float f381054x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public h0 f381055y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Float f381056z;

        public static final enum FillRule extends Enum<FillRule> {
            public static final FillRule EvenOdd = null;
            public static final FillRule NonZero = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ FillRule[] f381057a = null;

            static {
                FillRule r100 = new FillRule("NonZero", 0);
                NonZero = r100;
                FillRule r101 = new FillRule("EvenOdd", 1);
                EvenOdd = r101;
                f381057a = new FillRule[]{r100, r101};
            }

            public static FillRule[] values() {
                return (FillRule[]) f381057a.clone();
            }

            public static FillRule valueOf(String r100) {
                return (FillRule) r27.a.a(FillRule.class, r100);
            }

            public FillRule(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum LineCap extends Enum<LineCap> {
            public static final LineCap Butt = null;
            public static final LineCap Round = null;
            public static final LineCap Square = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LineCap[] f381058a = null;

            static {
                LineCap r100 = new LineCap("Butt", 0);
                Butt = r100;
                LineCap r101 = new LineCap("Round", 1);
                Round = r101;
                LineCap r102 = new LineCap("Square", 2);
                Square = r102;
                f381058a = new LineCap[]{r100, r101, r102};
            }

            public static LineCap[] values() {
                return (LineCap[]) f381058a.clone();
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
            public static final /* synthetic */ LineJoin[] f381059a = null;

            static {
                LineJoin r100 = new LineJoin("Miter", 0);
                Miter = r100;
                LineJoin r101 = new LineJoin("Round", 1);
                Round = r101;
                LineJoin r102 = new LineJoin("Bevel", 2);
                Bevel = r102;
                f381059a = new LineJoin[]{r100, r101, r102};
            }

            public static LineJoin[] values() {
                return (LineJoin[]) f381059a.clone();
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
            public static final /* synthetic */ RenderQuality[] f381060a = null;
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
                f381060a = new RenderQuality[]{r100, r101, r102};
            }

            public static RenderQuality[] values() {
                return (RenderQuality[]) f381060a.clone();
            }

            public static RenderQuality valueOf(String r100) {
                return (RenderQuality) r27.a.a(RenderQuality.class, r100);
            }

            public RenderQuality(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum VectorEffect extends Enum<VectorEffect> {
            public static final VectorEffect NonScalingStroke = null;
            public static final VectorEffect None = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ VectorEffect[] f381061a = null;

            static {
                VectorEffect r100 = new VectorEffect("None", 0);
                None = r100;
                VectorEffect r101 = new VectorEffect("NonScalingStroke", 1);
                NonScalingStroke = r101;
                f381061a = new VectorEffect[]{r100, r101};
            }

            public static VectorEffect[] values() {
                return (VectorEffect[]) f381061a.clone();
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
            r100.f381031a = -1;
            f r101 = f.f381094b;
            r100.f381032b = r101;
            FillRule r102 = FillRule.NonZero;
            r100.f381033c = r102;
            Float r103 = Float.valueOf(1.0f);
            r100.f381034d = r103;
            r100.f381035e = null;
            r100.f381036f = r103;
            r100.f381037g = new o();
            r100.f381038h = LineCap.Butt;
            r100.f381039i = LineJoin.Miter;
            r100.f381040j = Float.valueOf(4.0f);
            r100.f381041k = null;
            r100.f381042l = new o();
            r100.f381043m = r103;
            r100.f381044n = r101;
            Boolean r104 = Boolean.TRUE;
            r100.f381045o = r104;
            r100.f381046p = null;
            r100.f381047q = r104;
            r100.f381048r = r104;
            r100.f381049s = r101;
            r100.f381050t = r103;
            r100.f381051u = null;
            r100.f381052v = r102;
            r100.f381053w = null;
            r100.f381054x = r103;
            r100.f381055y = null;
            r100.f381056z = r103;
            r100.A = VectorEffect.None;
            r100.B = RenderQuality.auto;
            return r100;
        }

        public Style() {
            this.f381031a = 0;
        }

        public final Object clone() throws CloneNotSupportedException {
            Style r100 = (Style) super.clone();
            o[] r101 = this.f381041k;
            if (r101 == null) goto L5;
            r100.f381041k = (o[]) r101.clone();
        L5:
            return r100;
        }
    }

    public static final enum Unit extends Enum<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Unit[] f381062a = null;

        /* JADX INFO: renamed from: cm, reason: collision with root package name */
        public static final Unit f381063cm = null;

        /* JADX INFO: renamed from: em, reason: collision with root package name */
        public static final Unit f381064em = null;

        /* JADX INFO: renamed from: ex, reason: collision with root package name */
        public static final Unit f381065ex = null;

        /* JADX INFO: renamed from: in, reason: collision with root package name */
        public static final Unit f381066in = null;

        /* JADX INFO: renamed from: mm, reason: collision with root package name */
        public static final Unit f381067mm = null;

        /* JADX INFO: renamed from: pc, reason: collision with root package name */
        public static final Unit f381068pc = null;
        public static final Unit percent = null;

        /* JADX INFO: renamed from: pt, reason: collision with root package name */
        public static final Unit f381069pt = null;

        /* JADX INFO: renamed from: px, reason: collision with root package name */
        public static final Unit f381070px = null;
        public static final Unit rem = null;
        public static final Unit rpx = null;

        static {
            Unit r100 = new Unit(GXTemplateKey.GAIAX_PX, 0);
            f381070px = r100;
            Unit r101 = new Unit("em", 1);
            f381064em = r101;
            Unit r102 = new Unit(BaseHttpRequestInfo.KEY_EXCEPTION, 2);
            f381065ex = r102;
            Unit r103 = new Unit("in", 3);
            f381066in = r103;
            Unit r104 = new Unit("cm", 4);
            f381063cm = r104;
            Unit r105 = new Unit("mm", 5);
            f381067mm = r105;
            Unit r110 = new Unit(GXTemplateKey.GAIAX_PT, 6);
            f381069pt = r110;
            Unit r111 = new Unit(BackupSeiMessage.SOURCE_PC, 7);
            f381068pc = r111;
            Unit r112 = new Unit("percent", 8);
            percent = r112;
            Unit r113 = new Unit("rpx", 9);
            rpx = r113;
            Unit r114 = new Unit("rem", 10);
            rem = r114;
            f381062a = new Unit[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static Unit[] values() {
            return (Unit[]) f381062a.clone();
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
        public static final /* synthetic */ int[] f381071a = null;

        static {
            int[] r100 = new int[Unit.values().length];
            f381071a = r100;
            r100[Unit.f381064em.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f381071a[Unit.rem.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f381071a[Unit.rpx.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f381071a[Unit.f381065ex.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f381071a[Unit.f381066in.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f381071a[Unit.f381063cm.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f381071a[Unit.f381067mm.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f381071a[Unit.f381069pt.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f381071a[Unit.f381068pc.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f381071a[Unit.percent.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f381071a[Unit.f381070px.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static class a0 extends k0 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381072k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381073l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f381074m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381075n;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "svg";
        }

        public a0() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f381076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f381077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f381078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f381079d;

        public final String toString() {
            return "[" + this.f381076a + " " + this.f381077b + " " + this.f381078c + " " + this.f381079d + "]";
        }

        public b(b r100) {
            this.f381076a = r100.f381076a;
            this.f381077b = r100.f381077b;
            this.f381078c = r100.f381078c;
            this.f381079d = r100.f381079d;
        }

        public b(float r100, float r101, float r102, float r103) {
            this.f381076a = r100;
            this.f381077b = r101;
            this.f381078c = r102;
            this.f381079d = r103;
        }
    }

    public static abstract class b0 extends d0 implements c0 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<g0> f381080h;

        public b0() {
            this.f381080h = new ArrayList();
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return this.f381080h;
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r100) throws SVGParseException {
            this.f381080h.add(r100);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f381081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f381082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f381083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o f381084d;

        public c(o r100, o r101, o r102, o r103) {
            this.f381081a = r100;
            this.f381082b = r101;
            this.f381083c = r102;
            this.f381084d = r103;
        }
    }

    public interface c0 {
        void b(e0 r100) throws SVGParseException;

        List<g0> getChildren();
    }

    public static class d extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o f381085i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public o f381086j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381087k;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.CIRCLE;
        }

        public d() {
        }
    }

    public static abstract class d0 extends e0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b f381088g;

        public d0() {
            this.f381088g = null;
        }
    }

    public static class e extends l implements q {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Boolean f381089j;

        @Override // com.lynx.component.svg.parser.SVG.l, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.CLIP_PATH;
        }

        public e() {
        }
    }

    public static abstract class e0 extends g0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f381090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f381091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Style f381092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Style f381093f;

        public e0() {
            this.f381090c = null;
            this.f381091d = null;
            this.f381092e = null;
            this.f381093f = null;
        }

        public final String toString() {
            return c();
        }
    }

    public static class f extends h0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f381094b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f381095c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f381096a;

        public final String toString() {
            return String.format("#%08x", new Object[]{Integer.valueOf(this.f381096a)});
        }

        static {
            f381094b = new f(-16777216);
            f381095c = new f(0);
        }

        public f(int r100) {
            this.f381096a = r100;
        }
    }

    public static class f0 extends j {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381097l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f381098m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381099n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f381100o;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.LINEAR_GRADIENT;
        }

        public f0() {
        }
    }

    public static class g extends h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f381101a = null;

        static {
            f381101a = new g();
        }

        public g() {
        }
    }

    public static class g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SVG f381102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c0 f381103b;

        public g0() {
        }

        public String c() {
            return "";
        }
    }

    public static class h extends l implements q {
        @Override // com.lynx.component.svg.parser.SVG.l, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "defs";
        }

        public h() {
        }
    }

    public static abstract class h0 implements Cloneable {
        public h0() {
        }
    }

    public static class i extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o f381104i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public o f381105j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381106k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381107l;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.ELLIPSE;
        }

        public i() {
        }
    }

    public static abstract class i0 extends b0 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PreserveAspectRatio f381108i;

        public i0() {
            this.f381108i = null;
        }
    }

    public static abstract class j extends e0 implements c0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<g0> f381109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f381110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Matrix f381111i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public GradientSpread f381112j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f381113k;

        public j() {
            this.f381109g = new ArrayList();
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return this.f381109g;
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r100) throws SVGParseException {
            if ((r100 instanceof z) == false) goto L7;
            this.f381109g.add(r100);
            return;
        L7:
            throw new SVGParseException("Gradient elements cannot contain " + r100 + " elements.");
        }
    }

    public static class j0 extends j {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381114l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f381115m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381116n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f381117o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f381118p;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.RADIAL_GRADIENT;
        }

        public j0() {
        }
    }

    public static abstract class k extends d0 implements m {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Matrix f381119h;

        public k() {
        }

        @Override // com.lynx.component.svg.parser.SVG.m
        public final void a(Matrix r100) {
            this.f381119h = r100;
        }
    }

    public static abstract class k0 extends i0 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b f381120j;

        public k0() {
        }
    }

    public static class l extends b0 implements m {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Matrix f381121i;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public String c() {
            return "group";
        }

        public l() {
        }

        @Override // com.lynx.component.svg.parser.SVG.m
        public final void a(Matrix r100) {
            this.f381121i = r100;
        }
    }

    public static class l0 extends l {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f381122j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381123k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381124l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f381125m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381126n;

        @Override // com.lynx.component.svg.parser.SVG.l, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return NameKeys.LoadStrategy_Use;
        }

        public l0() {
        }
    }

    public interface m {
        void a(Matrix r100);
    }

    public static class n extends i0 implements m {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f381127j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381128k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381129l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f381130m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381131n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Matrix f381132o;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "image";
        }

        public n() {
        }

        @Override // com.lynx.component.svg.parser.SVG.m
        public final void a(Matrix r100) {
            this.f381132o = r100;
        }
    }

    public static class o implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f381133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Unit f381134b;

        public final boolean f() {
            if (this.f381133a >= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean g() {
            if (this.f381133a != 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public final String toString() {
            return String.valueOf(this.f381133a) + this.f381134b;
        }

        public o() {
            this.f381133a = 0.0f;
            this.f381134b = Unit.f381070px;
        }

        public final float b(com.lynx.component.svg.parser.e r100) {
            if (this.f381134b != Unit.percent) goto L18;
            com.lynx.component.svg.parser.e.c r101 = r100.f381208e;
            b r102 = r101.f381224g;
            if (r102 != null) goto L8;
            r102 = r101.f381223f;
        L8:
            if (r102 == null) goto L10;
            float r103 = r102.f381078c;
            float r104 = r102.f381079d;
            if (r103 != r104) goto L16;
            float r105 = this.f381133a;
        L15:
            return (r105 * r103) / 100.0f;
        L16:
            r103 = (float) (Math.sqrt((r103 * r103) + (r104 * r104)) / 1.414213562373095d);
            r105 = this.f381133a;
            goto L15
        L10:
            return this.f381133a;
        L18:
            return d(r100);
        }

        public final float c(com.lynx.component.svg.parser.e r100) {
            if (this.f381134b != Unit.percent) goto L7;
            return (this.f381133a * 1.0f) / 100.0f;
        L7:
            return d(r100);
        }

        public final float d(com.lynx.component.svg.parser.e r110) {
            switch(a.f381071a[this.f381134b.ordinal()]) {
                case 1: goto L24;
                case 2: goto L24;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L20;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L6;
                default: goto L5;
            };
        L6:
            com.lynx.component.svg.parser.e.c r111 = r110.f381208e;
            b r100 = r111.f381224g;
            if (r100 != null) goto L10;
            r100 = r111.f381223f;
        L10:
            if (r100 == null) goto L12;
            float r112 = this.f381133a * r100.f381078c;
            float r101 = 100.0f;
        L19:
            return r112 / r101;
        L12:
            return this.f381133a;
        L14:
            float r102 = this.f381133a;
            r110.getClass();
            r112 = r102 * 96.0f;
            r101 = 6.0f;
            goto L19
        L15:
            float r103 = this.f381133a;
            r110.getClass();
            r112 = r103 * 96.0f;
            r101 = 72.0f;
            goto L19
        L16:
            float r104 = this.f381133a;
            r110.getClass();
            r112 = r104 * 96.0f;
            r101 = 25.4f;
            goto L19
        L17:
            float r105 = this.f381133a;
            r110.getClass();
            r112 = r105 * 96.0f;
            r101 = 2.54f;
            goto L19
        L20:
            float r106 = this.f381133a;
            r110.getClass();
            return r106 * 96.0f;
        L24:
            String r107 = this.f381133a + this.f381134b.toString();
            float r108 = r110.f381205b;
            return com.lynx.tasm.utils.n.b(r107, r108, r108, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.getScreenDisplayMetrics());
        L5:
            return this.f381133a;
        L23:
            return this.f381133a * (r110.f381205b / 2.0f);
        }

        public final float e(com.lynx.component.svg.parser.e r100) {
            if (this.f381134b != Unit.percent) goto L14;
            com.lynx.component.svg.parser.e.c r101 = r100.f381208e;
            b r102 = r101.f381224g;
            if (r102 != null) goto L8;
            r102 = r101.f381223f;
        L8:
            if (r102 != null) goto L12;
            return this.f381133a;
        L12:
            return (this.f381133a * r102.f381079d) / 100.0f;
        L14:
            return d(r100);
        }

        public o(float r100, Unit r101) {
            this.f381133a = r100;
            this.f381134b = r101;
        }

        public final float a(float r110, float r111) {
            switch(a.f381071a[this.f381134b.ordinal()]) {
                case 1: goto L17;
                case 2: goto L17;
                case 3: goto L17;
                case 4: goto L5;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                default: goto L5;
            };
        L5:
            return this.f381133a;
        L7:
            return (this.f381133a * 96.0f) / 6.0f;
        L9:
            return (this.f381133a * 96.0f) / 72.0f;
        L11:
            return (this.f381133a * 96.0f) / 25.4f;
        L13:
            return (this.f381133a * 96.0f) / 2.54f;
        L15:
            return this.f381133a * 96.0f;
        L17:
            return com.lynx.tasm.utils.n.b(this.f381133a + this.f381134b.toString(), r110, r111, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.getScreenDisplayMetrics());
        }
    }

    public static class p extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o f381135i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public o f381136j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381137k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381138l;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "line";
        }

        public p() {
        }
    }

    public interface q {
    }

    public static class r extends h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f381139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0 f381140b;

        public final String toString() {
            return this.f381139a + " " + this.f381140b;
        }

        public r(String r100, h0 r101) {
            this.f381139a = r100;
            this.f381140b = r101;
        }
    }

    public static class s extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public t f381141i;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "path";
        }

        public s() {
        }
    }

    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f381142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f381143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f381144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f381145d;

        public t() {
            this.f381143b = 0;
            this.f381145d = 0;
            this.f381142a = new byte[8];
            this.f381144c = new float[16];
        }

        public final void a(byte r100) {
            int r101 = this.f381143b;
            byte[] r102 = this.f381142a;
            if (r101 != r102.length) goto L5;
            byte[] r103 = new byte[r102.length * 2];
            System.arraycopy(r102, 0, r103, 0, r102.length);
            this.f381142a = r103;
        L5:
            byte[] r104 = this.f381142a;
            int r105 = this.f381143b;
            this.f381143b = r105 + 1;
            r104[r105] = r100;
        }

        public final void b(int r100) {
            float[] r101 = this.f381144c;
            if (r101.length >= (this.f381145d + r100)) goto L6;
            float[] r102 = new float[r101.length * 2];
            System.arraycopy(r101, 0, r102, 0, r101.length);
            this.f381144c = r102;
            return;
        }

        public final void d(float r100, float r101) {
            a((byte) 1);
            b(2);
            float[] r102 = this.f381144c;
            int r103 = this.f381145d;
            int r104 = r103 + 1;
            r102[r103] = r100;
            this.f381145d = r104 + 1;
            r102[r104] = r101;
        }

        public final void e(float r100, float r101, float r102, float r103) {
            a((byte) 3);
            b(4);
            float[] r104 = this.f381144c;
            int r105 = this.f381145d;
            int r106 = r105 + 1;
            r104[r105] = r100;
            int r107 = r106 + 1;
            r104[r106] = r101;
            int r108 = r107 + 1;
            r104[r107] = r102;
            this.f381145d = r108 + 1;
            r104[r108] = r103;
        }

        public final void c(float r100, float r101, float r102, float r103, float r104, float r105) {
            a((byte) 2);
            b(6);
            float[] r106 = this.f381144c;
            int r107 = this.f381145d;
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
            this.f381145d = r112 + 1;
            r106[r112] = r105;
        }
    }

    public static class u extends k0 implements q {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Boolean f381146k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Boolean f381147l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Matrix f381148m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381149n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f381150o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public o f381151p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public o f381152q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f381153r;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "pattern";
        }

        public u() {
        }
    }

    public static class v extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f381154i;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public String c() {
            return SVGRenderEngine.POLYLINE;
        }

        public v() {
        }
    }

    public static class w extends v {
        @Override // com.lynx.component.svg.parser.SVG.v, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.POLYGON;
        }

        public w() {
        }
    }

    public static class x extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o f381155i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public o f381156j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public o f381157k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o f381158l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public o f381159m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f381160n;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.RECT;
        }

        public x() {
        }
    }

    public static class y extends e0 implements c0 {
        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r100) {
        }

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "solidColor";
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return Collections.emptyList();
        }

        public y() {
        }
    }

    public static class z extends e0 implements c0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Float f381161g;

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r100) {
        }

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "stop";
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return Collections.emptyList();
        }

        public z() {
        }
    }

    public final b a() {
        a0 r100 = this.f381027a;
        o r101 = r100.f381074m;
        o r102 = r100.f381075n;
        if (r101 == null) goto L32;
        if (r101.g() == true) goto L32;
        Unit r103 = r101.f381134b;
        Unit r104 = Unit.percent;
        if (r103 == r104) goto L32;
        Unit r105 = Unit.f381064em;
        if (r103 == r105) goto L32;
        Unit r106 = Unit.f381065ex;
        if (r103 == r106) goto L32;
        com.lynx.component.svg.parser.c r107 = this.f381029c;
        float r108 = r101.a(r107.f381199b, r107.f381200c);
        if (r102 != null) goto L16;
        b r109 = this.f381027a.f381120j;
        if (r109 == null) goto L28;
        float r110 = (r109.f381079d * r108) / r109.f381078c;
    L30:
        return new b(0.0f, 0.0f, r108, r110);
    L28:
        r110 = r108;
        goto L30
    L16:
        if (r102.g() == true) goto L24;
        Unit r111 = r102.f381134b;
        if (r111 == r104) goto L24;
        if (r111 == r105) goto L24;
        if (r111 == r106) goto L24;
        com.lynx.component.svg.parser.c r112 = this.f381029c;
        r110 = r102.a(r112.f381199b, r112.f381200c);
    L24:
        return new b(-1.0f, -1.0f, -1.0f, -1.0f);
    L32:
        return new b(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    public SVG() {
        this.f381027a = null;
        this.f381028b = new HashMap();
    }

    public static SVG c(String r100) throws SVGParseException {
        LLog.i("lynx_UISvg", "getFromString():" + r100);
        SVGParser r101 = new SVGParser();
        InputStream r102 = new ByteArrayInputStream(r100.getBytes());
        if (r102.markSupported() == true) goto L23;
        r102 = new BufferedInputStream(r102);
    L23:
        r102.mark(3);     // Catch: IOException -> L16
        int r103 = r102.read() + (r102.read() << 8);     // Catch: IOException -> L16
        r102.reset();     // Catch: IOException -> L16
        if (r103 != 35615) goto L21;
        r102 = new BufferedInputStream(new GZIPInputStream(r102));     // Catch: IOException -> L16
    L21:
        r101.s(r102);     // Catch: Throwable -> L13
        SVG r104 = r101.f381162a;     // Catch: Throwable -> L13
        r102.close();     // Catch: IOException -> L18
    L12:
        return r104;
    L13:
        th = move-exception;
        r102.close();     // Catch: IOException -> L17
    L15:
        throw th;
    }

    public final e0 f(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.startsWith("\"") == false) goto L11;
        if (r100.endsWith("\"") == false) goto L11;
        r100 = r100.substring(1, r100.length() - 1).replace("\\\"", "\"");
    L15:
        String r101 = r100.replace("\\\n", "").replace("\\A", "\n");
        if (r101.length() > 1) goto L18;
        return null;
    L18:
        if (r101.startsWith("#") == false) goto L33;
        String r102 = r101.substring(1);
        if (r102 != null) goto L22;
        return null;
    L22:
        if (r102.length() != 0) goto L25;
        return null;
    L25:
        if (r102.equals(this.f381027a.f381090c) == false) goto L28;
        return this.f381027a;
    L28:
        if (((HashMap) this.f381028b).containsKey(r102) == true) goto L36;
        e0 r103 = b(this.f381027a, r102);
        ((HashMap) this.f381028b).put(r102, r103);
        return r103;
    L36:
        return (e0) ((HashMap) this.f381028b).get(r102);
    L33:
        return null;
    L11:
        if (r100.startsWith("'") == false) goto L15;
        if (r100.endsWith("'") == false) goto L15;
        r100 = r100.substring(1, r100.length() - 1).replace("\\'", "'");
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e0 b(c0 r100, String r101) {
        e0 r102 = (e0) r100;
        if (r101.equals(r102.f381090c) == false) goto L5;
        return r102;
    L5:
        Iterator<g0> r103 = r100.getChildren().iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        Object r104 = (g0) r103.next();
        if ((r104 instanceof e0) == false) goto L7;
        e0 r105 = (e0) r104;
        if (r101.equals(r105.f381090c) == true) goto L13;
        if ((r104 instanceof c0) == false) goto L7;
        e0 r106 = b((c0) r104, r101);
        if (r106 == null) goto L7;
        return r106;
    L13:
        return r105;
    L19:
        return null;
    }

    public final Picture e(com.lynx.component.svg.parser.c r100, com.lynx.component.svg.d r101) {
        this.f381029c = r100;
        a0 r102 = this.f381027a;
        if (r102 != null) goto L6;
        LLog.e("SVG", " bad format SVG, rootElement is null");
        return null;
    L6:
        b r103 = r102.f381120j;
        if (r100 == null) goto L15;
        b r104 = r100.f381198a;
        if (r104 == null) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        return d((int) Math.ceil(r104.f381076a + r104.f381078c), (int) Math.ceil(r104.f381077b + r104.f381079d), r100, r101);
    L11:
        r105 = false;
    L15:
        o r106 = r102.f381074m;
        if (r106 == null) goto L25;
        Unit r107 = r106.f381134b;
        Unit r108 = Unit.percent;
        if (r107 == r108) goto L25;
        o r109 = r102.f381075n;
        if (r109 == null) goto L25;
        if (r109.f381134b == r108) goto L25;
        return d((int) Math.ceil(r106.a(r100.f381199b, r100.f381200c)), (int) Math.ceil(this.f381027a.f381075n.a(r100.f381199b, r100.f381200c)), r100, r101);
    L25:
        if (r106 == null) goto L29;
        if (r103 == null) goto L29;
        float r110 = r106.a(r100.f381199b, r100.f381200c);
        return d((int) Math.ceil(r110), (int) Math.ceil((r103.f381079d * r110) / r103.f381078c), r100, r101);
    L29:
        o r111 = r102.f381075n;
        if (r111 == null) goto L35;
        if (r103 == null) goto L35;
        float r112 = r111.a(r100.f381199b, r100.f381200c);
        return d((int) Math.ceil((r103.f381078c * r112) / r103.f381079d), (int) Math.ceil(r112), r100, r101);
    L35:
        return d(512, 512, r100, r101);
    }

    public final Picture d(int r100, int r101, com.lynx.component.svg.parser.c r102, com.lynx.component.svg.d r103) {
        this.f381029c = r102;
        Picture r104 = new Picture();
        Canvas r105 = r104.beginRecording(r100, r101);
        if (r102 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
        r102 = new com.lynx.component.svg.parser.c(14.0f, 14.0f);
    L9:
        r102.f381198a = new b(0.0f, 0.0f, r100, r101);
    L10:
        com.lynx.component.svg.parser.e r106 = new com.lynx.component.svg.parser.e(r105, r102.f381199b, r103);
        LLog.i("lynx_UISvg", "beforeRenderDocument(),  svg hasCode:" + this);
        r106.C(this, r102);
        LLog.i("lynx_UISvg", "AfterRenderDocument(),svg hasCode:" + this);
        r104.endRecording();
        return r104;
    L8:
        r102 = new com.lynx.component.svg.parser.c(r102);
        goto L9
    L5:
        if (r102.f381198a != null) goto L10;
        goto L6
    }
}
