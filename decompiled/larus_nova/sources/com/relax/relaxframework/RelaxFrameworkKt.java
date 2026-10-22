package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class RelaxFrameworkKt {
    public static int A;
    public static final Function0<m5> B = null;
    public static final Function0<f6> C = null;
    public static final Function0<b7> D = null;
    public static final int E = 0;
    public static final int F = 0;
    public static final Function0<RxPageImpl> G = null;
    public static final Function0<v6> H = null;
    public static final Function0<s6> I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Function0<e7> f404870J = null;
    public static final Function0<f7> K = null;
    public static final e4<Object> L = null;
    public static final Function1<Object, Unit> M = null;
    public static final e4<y2> N = null;
    public static final Function0<Unit> O = null;
    public static final Function0<v5> P = null;
    public static final Function0<d6> Q = null;
    public static final Function0<q6> R = null;
    public static final Function0<RxScrollViewImpl> S = null;
    public static final Function0<RxTextImpl> T = null;
    public static final Function0<c7> U = null;
    public static final Function0<j7> V = null;
    public static final Function0<RxViewPagerImpl> W = null;
    public static final Function0<RxInlineTextImpl> X = null;
    public static final Function0<t5> Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n0 f404871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f404872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object[] f404873c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f404874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList<ReactiveRuntime> f404875e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Function2<ReactiveRuntime, ReactiveRuntime, Integer> f404876f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Function2<o7, o7, Integer> f404877g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ReactiveRuntime f404878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object[] f404879i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Function0<Double> f404880j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Function1<Function1<? super Double, Double>, Unit> f404881k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Function0<Unit> f404882l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final double f404883m = 0.0d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y3 f404884n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y3 f404885o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final y3 f404886p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final y3 f404887q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ModifierValue_TextDecorationLine f404888r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ModifierValue_TextDecorationStyle f404889s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ArrayList<Integer> f404890t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Function3<ModifierValue_TextDecorationLine, Long, ModifierValue_TextDecorationStyle, y3> f404891u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static Long f404892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f404893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f404894x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Function0<l7> f404895y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Function2<a8, Function0<? extends ArrayList<j5>>, j5> f404896z = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f404897a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f404898b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f404899c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f404900d = null;

        static {
            int[] r100 = new int[CSSModifierProperty.values().length];
            r100[CSSModifierProperty.Width.ordinal()] = 1;     // Catch: NoSuchFieldError -> L93
        L178:
            r100[CSSModifierProperty.Height.ordinal()] = 2;     // Catch: NoSuchFieldError -> L94
        L188:
            r100[CSSModifierProperty.MinWidth.ordinal()] = 3;     // Catch: NoSuchFieldError -> L95
        L198:
            r100[CSSModifierProperty.MinHeight.ordinal()] = 4;     // Catch: NoSuchFieldError -> L96
        L202:
            r100[CSSModifierProperty.MaxWidth.ordinal()] = 5;     // Catch: NoSuchFieldError -> L97
        L210:
            r100[CSSModifierProperty.MaxHeight.ordinal()] = 6;     // Catch: NoSuchFieldError -> L98
        L216:
            r100[CSSModifierProperty.PaddingTop.ordinal()] = 7;     // Catch: NoSuchFieldError -> L99
        L234:
            r100[CSSModifierProperty.PaddingRight.ordinal()] = 8;     // Catch: NoSuchFieldError -> L100
        L250:
            r100[CSSModifierProperty.PaddingBottom.ordinal()] = 9;     // Catch: NoSuchFieldError -> L101
        L252:
            r100[CSSModifierProperty.PaddingLeft.ordinal()] = 10;     // Catch: NoSuchFieldError -> L102
        L260:
            r100[CSSModifierProperty.MarginTop.ordinal()] = 11;     // Catch: NoSuchFieldError -> L103
        L278:
            r100[CSSModifierProperty.MarginRight.ordinal()] = 12;     // Catch: NoSuchFieldError -> L104
        L290:
            r100[CSSModifierProperty.MarginBottom.ordinal()] = 13;     // Catch: NoSuchFieldError -> L105
        L160:
            r100[CSSModifierProperty.MarginLeft.ordinal()] = 14;     // Catch: NoSuchFieldError -> L106
        L166:
            r100[CSSModifierProperty.FlexBasis.ordinal()] = 15;     // Catch: NoSuchFieldError -> L107
        L180:
            r100[CSSModifierProperty.FlexGrow.ordinal()] = 16;     // Catch: NoSuchFieldError -> L108
        L196:
            r100[CSSModifierProperty.FlexShrink.ordinal()] = 17;     // Catch: NoSuchFieldError -> L109
        L200:
            r100[CSSModifierProperty.GridColumnSpan.ordinal()] = 18;     // Catch: NoSuchFieldError -> L110
        L212:
            r100[CSSModifierProperty.GridColumnStart.ordinal()] = 19;     // Catch: NoSuchFieldError -> L111
        L224:
            r100[CSSModifierProperty.GridColumnEnd.ordinal()] = 20;     // Catch: NoSuchFieldError -> L112
        L240:
            r100[CSSModifierProperty.GridRowSpan.ordinal()] = 21;     // Catch: NoSuchFieldError -> L113
        L242:
            r100[CSSModifierProperty.GridRowStart.ordinal()] = 22;     // Catch: NoSuchFieldError -> L114
        L254:
            r100[CSSModifierProperty.GridRowEnd.ordinal()] = 23;     // Catch: NoSuchFieldError -> L115
        L268:
            r100[CSSModifierProperty.JustifySelf.ordinal()] = 24;     // Catch: NoSuchFieldError -> L116
        L282:
            r100[CSSModifierProperty.AlignSelf.ordinal()] = 25;     // Catch: NoSuchFieldError -> L117
        L284:
            r100[CSSModifierProperty.Bottom.ordinal()] = 26;     // Catch: NoSuchFieldError -> L118
        L162:
            r100[CSSModifierProperty.Top.ordinal()] = 27;     // Catch: NoSuchFieldError -> L119
        L174:
            r100[CSSModifierProperty.Right.ordinal()] = 28;     // Catch: NoSuchFieldError -> L120
        L186:
            r100[CSSModifierProperty.Left.ordinal()] = 29;     // Catch: NoSuchFieldError -> L121
        L190:
            r100[CSSModifierProperty.Order.ordinal()] = 30;     // Catch: NoSuchFieldError -> L122
        L204:
            r100[CSSModifierProperty.BorderLeftWidth.ordinal()] = 31;     // Catch: NoSuchFieldError -> L123
        L218:
            r100[CSSModifierProperty.BorderRightWidth.ordinal()] = 32;     // Catch: NoSuchFieldError -> L124
        L230:
            r100[CSSModifierProperty.BorderTopWidth.ordinal()] = 33;     // Catch: NoSuchFieldError -> L125
        L232:
            r100[CSSModifierProperty.BorderBottomWidth.ordinal()] = 34;     // Catch: NoSuchFieldError -> L126
        L244:
            r100[CSSModifierProperty.LinearLayoutGravity.ordinal()] = 35;     // Catch: NoSuchFieldError -> L127
        L262:
            r100[CSSModifierProperty.LinearWeight.ordinal()] = 36;     // Catch: NoSuchFieldError -> L128
        L274:
            r100[CSSModifierProperty.Position.ordinal()] = 37;     // Catch: NoSuchFieldError -> L129
        L276:
            r100[CSSModifierProperty.BoxSizing.ordinal()] = 38;     // Catch: NoSuchFieldError -> L130
        L286:
            r100[CSSModifierProperty.Direction.ordinal()] = 39;     // Catch: NoSuchFieldError -> L131
        L168:
            r100[CSSModifierProperty.AspectRatio.ordinal()] = 40;     // Catch: NoSuchFieldError -> L132
        L61:
            f404897a = r100;
            int[] r101 = new int[ElementAttribute.values().length];
            r101[ElementAttribute.GridTemplateColumns.ordinal()] = 1;     // Catch: NoSuchFieldError -> L133
        L194:
            r101[ElementAttribute.GridTemplateRows.ordinal()] = 2;     // Catch: NoSuchFieldError -> L134
        L208:
            r101[ElementAttribute.GridAutoColumns.ordinal()] = 3;     // Catch: NoSuchFieldError -> L135
        L214:
            r101[ElementAttribute.GridAutoRows.ordinal()] = 4;     // Catch: NoSuchFieldError -> L136
        L220:
            r101[ElementAttribute.FlexDirection.ordinal()] = 5;     // Catch: NoSuchFieldError -> L137
        L226:
            r101[ElementAttribute.FlexWrap.ordinal()] = 6;     // Catch: NoSuchFieldError -> L138
        L236:
            r101[ElementAttribute.AlignItems.ordinal()] = 7;     // Catch: NoSuchFieldError -> L139
        L246:
            r101[ElementAttribute.AlignContent.ordinal()] = 8;     // Catch: NoSuchFieldError -> L140
        L256:
            r101[ElementAttribute.JustifyContent.ordinal()] = 9;     // Catch: NoSuchFieldError -> L141
        L264:
            r101[ElementAttribute.LinearOrientation.ordinal()] = 10;     // Catch: NoSuchFieldError -> L142
        L270:
            r101[ElementAttribute.LinearCrossGravity.ordinal()] = 11;     // Catch: NoSuchFieldError -> L143
        L280:
            r101[ElementAttribute.LinearGravity.ordinal()] = 12;     // Catch: NoSuchFieldError -> L144
        L288:
            r101[ElementAttribute.LinearWeightSum.ordinal()] = 13;     // Catch: NoSuchFieldError -> L145
        L164:
            r101[ElementAttribute.GridColumnGap.ordinal()] = 14;     // Catch: NoSuchFieldError -> L146
        L172:
            r101[ElementAttribute.GridRowGap.ordinal()] = 15;     // Catch: NoSuchFieldError -> L147
        L176:
            r101[ElementAttribute.JustifyItems.ordinal()] = 16;     // Catch: NoSuchFieldError -> L148
        L182:
            r101[ElementAttribute.GridAutoFlow.ordinal()] = 17;     // Catch: NoSuchFieldError -> L149
        L192:
            r101[ElementAttribute.ColumnGap.ordinal()] = 18;     // Catch: NoSuchFieldError -> L150
        L206:
            r101[ElementAttribute.RowGap.ordinal()] = 19;     // Catch: NoSuchFieldError -> L151
        L81:
            f404898b = r101;
            int[] r102 = new int[ModifierValuePattern.values().length];
            r102[ModifierValuePattern.PX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L152
        L228:
            r102[ModifierValuePattern.PERCENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L153
        L238:
            r102[ModifierValuePattern.PPX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L154
        L248:
            r102[ModifierValuePattern.VW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L155
        L258:
            r102[ModifierValuePattern.VH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L156
        L266:
            r102[ModifierValuePattern.RPX.ordinal()] = 6;     // Catch: NoSuchFieldError -> L157
        L272:
            r102[ModifierValuePattern.NUMBER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L158
        L89:
            f404899c = r102;
            int[] r103 = new int[LengthType.values().length];
            r103[LengthType.PERCENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L159
        L91:
            f404900d = r103;
        }
    }

    static {
        f404873c = new Object[]{Double.valueOf(50.0d), ModifierValuePattern.PERCENT};
        f404875e = com.bytedance.rts.foundation.j.k(new ReactiveRuntime[0]);
        f404876f = RelaxFrameworkKt$sortRuntimeById$1.INSTANCE;
        f404877g = RelaxFrameworkKt$sortEffectById$1.INSTANCE;
        Object[] r100 = i0(Double.valueOf(1.0d));
        f404879i = r100;
        Object r101 = r100[0];
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Function0<kotlin.Double>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<kotlin.Double> }");
        f404880j = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 0);
        Object r102 = r100[1];
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'fn')] kotlin.Function1<@[ParameterName(name = 'v')] kotlin.Double, kotlin.Double>{ @[ParameterName(name = 'fn')] com.relax.relaxframework.RelaxFrameworkKt.Updater<kotlin.Double> }, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<kotlin.Double> }");
        f404881k = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 1);
        f404882l = RelaxFrameworkKt$initRpxRatio$1.INSTANCE;
        f404883m = 14.0d;
        int r103 = y3.f405359e;
        f404884n = y3.a.c(AudioStats.AUDIO_AMPLITUDE_NONE, ModifierValuePattern.PX);
        f404885o = y3.a.a(0);
        y3 r104 = new y3(PropertyValueType.DOUBLE);
        r104.f405318c = AudioStats.AUDIO_AMPLITUDE_NONE;
        f404886p = r104;
        f404887q = y3.a.b(com.bytedance.rts.foundation.j.k(new Object[0]));
        ModifierValue_TextDecorationLine r105 = ModifierValue_TextDecorationLine.None;
        f404888r = r105;
        ModifierValue_TextDecorationStyle r106 = ModifierValue_TextDecorationStyle.Solid;
        f404889s = r106;
        int r107 = com.bytedance.rts.foundation.e.f267578a;
        f404890t = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r106.getValue()), Integer.valueOf((int) 0), Integer.valueOf(r105.getValue())});
        f404891u = RelaxFrameworkKt$wrapTextDecorationData$1.INSTANCE;
        f404894x = 1000000000;
        f404895y = RelaxFrameworkKt$createWrapper$1.INSTANCE;
        f404896z = RelaxFrameworkKt$Switch$1.INSTANCE;
        RelaxFrameworkKt$LazyReactivity$1 r108 = RelaxFrameworkKt$LazyReactivity$1.INSTANCE;
        RelaxFrameworkKt$StrictMode$1 r109 = RelaxFrameworkKt$StrictMode$1.INSTANCE;
        B = RelaxFrameworkKt$createFlex$1.INSTANCE;
        RelaxFrameworkKt$createColumn$1 r110 = RelaxFrameworkKt$createColumn$1.INSTANCE;
        RelaxFrameworkKt$createRow$1 r111 = RelaxFrameworkKt$createRow$1.INSTANCE;
        RelaxFrameworkKt$createWrap$1 r112 = RelaxFrameworkKt$createWrap$1.INSTANCE;
        RelaxFrameworkKt$createGrid$1 r113 = RelaxFrameworkKt$createGrid$1.INSTANCE;
        C = RelaxFrameworkKt$createLinear$1.INSTANCE;
        D = RelaxFrameworkKt$createStack$1.INSTANCE;
        RelaxFrameworkKt$createAnchor$1 r114 = RelaxFrameworkKt$createAnchor$1.INSTANCE;
        E = 2;
        F = 17;
        G = RelaxFrameworkKt$createPage$1.INSTANCE;
        RelaxFrameworkKt$createFoldView$1 r115 = RelaxFrameworkKt$createFoldView$1.INSTANCE;
        RelaxFrameworkKt$createFoldViewHeader$1 r116 = RelaxFrameworkKt$createFoldViewHeader$1.INSTANCE;
        RelaxFrameworkKt$createFoldViewToolbar$1 r117 = RelaxFrameworkKt$createFoldViewToolbar$1.INSTANCE;
        RelaxFrameworkKt$createFoldViewSlot$1 r118 = RelaxFrameworkKt$createFoldViewSlot$1.INSTANCE;
        RelaxFrameworkKt$createFoldViewSlotDrag$1 r119 = RelaxFrameworkKt$createFoldViewSlotDrag$1.INSTANCE;
        H = RelaxFrameworkKt$createRefreshView$1.INSTANCE;
        I = RelaxFrameworkKt$createRefreshHeader$1.INSTANCE;
        RelaxFrameworkKt$createRefreshFooter$1 r120 = RelaxFrameworkKt$createRefreshFooter$1.INSTANCE;
        f404870J = RelaxFrameworkKt$createSwiper$1.INSTANCE;
        K = RelaxFrameworkKt$createSwiperItem$1.INSTANCE;
        L = A();
        M = RelaxFrameworkKt$injectGlobalData$1.INSTANCE;
        N = A();
        O = RelaxFrameworkKt$injectMediaQuery$1.INSTANCE;
        RelaxFrameworkKt$createAnimax$1 r121 = RelaxFrameworkKt$createAnimax$1.INSTANCE;
        P = RelaxFrameworkKt$createImage$1.INSTANCE;
        Q = RelaxFrameworkKt$createInput$1.INSTANCE;
        R = RelaxFrameworkKt$createRawText$1.INSTANCE;
        S = RelaxFrameworkKt$createScrollView$1.INSTANCE;
        T = RelaxFrameworkKt$createText$1.INSTANCE;
        RelaxFrameworkKt$createTextarea$1 r122 = RelaxFrameworkKt$createTextarea$1.INSTANCE;
        U = RelaxFrameworkKt$createSvg$1.INSTANCE;
        RelaxFrameworkKt$createLottie$1 r123 = RelaxFrameworkKt$createLottie$1.INSTANCE;
        V = RelaxFrameworkKt$createViewPagerItem$1.INSTANCE;
        W = RelaxFrameworkKt$createViewPager$1.INSTANCE;
        RelaxFrameworkKt$createInlineImage$1 r124 = RelaxFrameworkKt$createInlineImage$1.INSTANCE;
        X = RelaxFrameworkKt$createInlineText$1.INSTANCE;
        RelaxFrameworkKt$createInlineTruncation$1 r125 = RelaxFrameworkKt$createInlineTruncation$1.INSTANCE;
        Y = RelaxFrameworkKt$createFragment$1.INSTANCE;
    }

    public static final e4 A() {
        int r100 = A;
        A = r100 + 1;
        return new e4(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.relax.relaxframework.f4] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.relax.relaxframework.g4] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.relax.relaxframework.RxListImpl, java.lang.Object] */
    public static final RxListImpl F() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        ?? r101 = new f4(r100);
        ?? r102 = new g4(r100);
        RelaxInstance.Companion.getClass();
        ?? r103 = new RxListImpl(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().A(r101, r102));
        r100.element = r103;
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    public static final long M() {
        Long r100 = f404892v;
        Intrinsics.checkNotNull(r100);
        return r100.longValue();
    }

    public static final void R() {
    L2:
        IntCompanionObject r100 = IntCompanionObject.INSTANCE;
        ArrayList<ReactiveRuntime> r101 = f404875e;
        int r102 = com.bytedance.rts.foundation.j.d(r101);
        com.bytedance.rts.foundation.k.c(r100, r102);
        if (r102 == 0) goto L5;
        com.bytedance.rts.foundation.j.o(r101, f404876f);
        Object r103 = com.bytedance.rts.foundation.j.i(r101);
        Intrinsics.checkNotNull(r103);
        int r104 = ReactiveRuntime.f404854m;
        ((ReactiveRuntime) r103).b(null);
        goto L2
    }

    public static final ReactiveRuntime S() {
        if (f404878h != null) goto L5;
        f404878h = new ReactiveRuntime();
    L5:
        ReactiveRuntime r100 = f404878h;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public static final int b() {
        int r100 = c3.f405033a;
        int r101 = c3.f405033a;
        c3.f405033a = r101 + 1;
        return r101;
    }

    public static final v c() {
        int r100 = z2.f405371a;
        if (z2.a.h() == false) goto L7;
        return new m1();
    L7:
        return new v();
    }

    public static final r3 g() {
        return new r3(PositionOffset_Type___.TopLeft);
    }

    public static final z j0() {
        int r100 = z2.f405371a;
        if (z2.a.h() == false) goto L7;
        return new g8();
    L7:
        return new z();
    }

    public static final b2 l() {
        int r100 = z2.f405371a;
        if (z2.a.h() == false) goto L6;
        int r101 = Transform.f404980a;
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        Transform$Companion$scale$valueGetter$1 r103 = new Transform$Companion$scale$valueGetter$1(1);
        return new m7(r103, r103);
    L6:
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        double r105 = 1;
        return new l8(r105, r105);
    }

    public static final x0 m0() {
        OwnerImpl r100 = OwnerImpl.f404833g;
        OwnerImpl r101 = OwnerImpl.f404833g;
        if (r101 == null) goto L5;
        final RelaxInstance r102 = r101.f404835b;
    L7:
        return new x0(new RelaxFrameworkKt$useEventEmitter$on$1(r102), new RelaxFrameworkKt$useEventEmitter$emit$1(r102));
    L5:
        r102 = null;
        goto L7
    }

    public static final b2 n() {
        int r100 = z2.f405371a;
        if (z2.a.h() == false) goto L6;
        int r101 = Transform.f404980a;
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        return Transform.Companion.a(new d3(0, ModifierValuePattern.PX));
    L6:
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return new m8(new d3(0, ModifierValuePattern.PX));
    }

    public static final Function0<x2> n0() {
        Object r100 = l0(N);
        Intrinsics.checkNotNull(r100);
        return ((y2) r100).f405358b;
    }

    public static final void w() {
        OwnerImpl r100 = OwnerImpl.f404833g;
        if (r100 == null) goto L5;
        StrictModeLevel r101 = r100.f404836c;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101 != StrictModeLevel.Silent) goto L11;
        return;
    L11:
        if (f404871a == null) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L20;
        int r103 = l6.f405180a;
        l6.a.a(new String[]{"Getting a signal without an downstream listener! If it's intended, use `untrack` to wrap it"});
        if (r101 != StrictModeLevel.Fatal) goto L21;
        Intrinsics.checkNotNull(null);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public static Object B(final Function1 r100) {
        OwnerImpl r101 = OwnerImpl.f404833g;
        Intrinsics.checkNotNullParameter(r100, "cb");
        final OwnerImpl r102 = new OwnerImpl(r101, true);
        return h0(r102, new RelaxFrameworkKt$createDetachedRoot$1(r100, r102));
    }

    public static final void C(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        t0 r101 = new t0(r100);
        OwnerImpl r102 = OwnerImpl.f404833g;
        if (r102 == null) goto L5;
        ReactiveRuntime r103 = r102.f404834a;
    L6:
        if (r103 == null) goto L10;
        Intrinsics.checkNotNullParameter(r101, "effect");
        if (r103.f404860f == true) goto L12;
        com.bytedance.rts.foundation.j.j(r103.f404862h, r101);
        return;
    L12:
        return;
    L10:
        S().c(r101);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final t0 K(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        OwnerImpl r101 = OwnerImpl.f404833g;
        if (r101 == null) goto L6;
        ReactiveRuntime r102 = r101.f404834a;
        if (r102 == null) goto L6;
    L7:
        t0 r103 = new t0(r100);
        if (k2.f405164b == null) goto L10;
        h0(r103, new RelaxFrameworkKt$createRenderEffect$1(r100));
        k2 r104 = k2.f405164b;
        Intrinsics.checkNotNull(r104);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "effect");
        com.bytedance.rts.foundation.j.j(r104.f405165a, r103);
    L11:
        return r103;
    L10:
        r102.c(r103);
    L6:
        r102 = S();
        goto L7
    }

    public static Object L(final Function0 r100) {
        OwnerImpl r101 = OwnerImpl.f404833g;
        Intrinsics.checkNotNullParameter(r100, "cb");
        return h0(new OwnerImpl(r101, false), new RelaxFrameworkKt$createRoot$1(r100));
    }

    public static final EventBindType N(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        int r101 = s2.f405262a;
        if (Intrinsics.areEqual(r100, "bindEvent") == false) goto L7;
        return EventBindType.Bind;
    L7:
        if (Intrinsics.areEqual(r100, "catchEvent") == false) goto L11;
        return EventBindType.Catch;
    L11:
        if (Intrinsics.areEqual(r100, "captureBindEvent") == false) goto L15;
        return EventBindType.CaptureBind;
    L15:
        if (Intrinsics.areEqual(r100, "captureCatchEvent") == false) goto L19;
        return EventBindType.CaptureCatch;
    L19:
        return EventBindType.Bind;
    }

    public static final ArrayList<Integer> O(ArrayList<ArrayList<Integer>> r100) {
        Intrinsics.checkNotNullParameter(r100, "arr");
        ArrayList<Integer> r101 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r102, r103);
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        int r107 = com.bytedance.rts.foundation.j.d((ArrayList) ListProtector.get(r100, r104));
        com.bytedance.rts.foundation.k.c(r105, r107);
        int r108 = 0;
    L5:
        if (r108 >= r107) goto L7;
        int r109 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r101, ListProtector.get((ArrayList) ListProtector.get(r100, r104), r108));
        r108 = r108 + 1;
        goto L5
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    public static final Object[] P(ArrayList<h0> r100) {
        Intrinsics.checkNotNullParameter(r100, "colorStopList");
        ArrayList r101 = com.bytedance.rts.foundation.j.k(new Long[0]);
        ArrayList r102 = com.bytedance.rts.foundation.j.k(new Double[0]);
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        int r104 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r103, r104);
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r101, Long.valueOf(((h0) ListProtector.get(r100, r105)).f405109a));
        com.bytedance.rts.foundation.j.j(r102, Double.valueOf(((h0) ListProtector.get(r100, r105)).f405110b));
        r105 = r105 + 1;
        goto L3
    L6:
        return new Object[]{r101, r102};
    }

    public static final Object[] Q(ArrayList<h0> r100) {
        Intrinsics.checkNotNullParameter(r100, "colorStopList");
        ArrayList r101 = com.bytedance.rts.foundation.j.k(new Long[0]);
        ArrayList r102 = com.bytedance.rts.foundation.j.k(new Double[0]);
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        int r104 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r103, r104);
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r101, Long.valueOf(((h0) ListProtector.get(r100, r105)).f405109a));
        com.bytedance.rts.foundation.j.j(r102, Double.valueOf(((h0) ListProtector.get(r100, r105)).f405110b * 100.0d));
        r105 = r105 + 1;
        goto L3
    L6:
        return new Object[]{r101, r102};
    }

    public static final boolean V(CSSModifierProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        switch(a.f404897a[r100.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L6;
            case 24: goto L6;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L6;
            case 28: goto L6;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L6;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L6;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L6;
            case 38: goto L6;
            case 39: goto L6;
            case 40: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    public static final boolean W(CSSModifierProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        switch(a.f404897a[r100.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L6;
            case 24: goto L6;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L6;
            case 28: goto L6;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L4;
            case 32: goto L4;
            case 33: goto L4;
            case 34: goto L4;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L6;
            case 38: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        return false;
    }

    public static final void Y(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cleanup");
        OwnerImpl r101 = OwnerImpl.f404833g;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "cleanup");
        if (r101.f404839f != null) goto L7;
        r101.f404839f = com.bytedance.rts.foundation.j.k(new Function0[0]);
    L7:
        ArrayList<Function0<Unit>> r102 = r101.f404839f;
        Intrinsics.checkNotNull(r102);
        com.bytedance.rts.foundation.j.j(r102, r100);
        return;
    }

    public static final d3 Z(int r100) {
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        return new d3(r100, ModifierValuePattern.PERCENT);
    }

    public static final t1 a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        int r101 = z2.f405371a;
        if (z2.a.h() == false) goto L7;
        return new i(r100);
    L7:
        return new g(r100);
    }

    public static final d3 a0(double r100) {
        return new d3(r100, ModifierValuePattern.PX);
    }

    public static final d3 b0(int r100) {
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        return new d3(r100, ModifierValuePattern.PX);
    }

    public static final e3 c0(Function0<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return new e3(r100, ModifierValuePattern.PX);
    }

    public static final CSSModifierProperty d(ElementAttribute r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        switch(a.f404898b[r100.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            default: goto L5;
        };
    L5:
        return CSSModifierProperty.None;
    L7:
        return CSSModifierProperty.RowGap;
    L9:
        return CSSModifierProperty.ColumnGap;
    L11:
        return CSSModifierProperty.GridAutoFlow;
    L13:
        return CSSModifierProperty.JustifyItems;
    L15:
        return CSSModifierProperty.GridRowGap;
    L17:
        return CSSModifierProperty.GridColumnGap;
    L19:
        return CSSModifierProperty.LinearWeightSum;
    L21:
        return CSSModifierProperty.LinearGravity;
    L23:
        return CSSModifierProperty.LinearCrossGravity;
    L25:
        return CSSModifierProperty.LinearOrientation;
    L27:
        return CSSModifierProperty.JustifyContent;
    L29:
        return CSSModifierProperty.AlignContent;
    L31:
        return CSSModifierProperty.AlignItems;
    L33:
        return CSSModifierProperty.FlexWrap;
    L35:
        return CSSModifierProperty.FlexDirection;
    L37:
        return CSSModifierProperty.GridAutoRows;
    L39:
        return CSSModifierProperty.GridAutoColumns;
    L41:
        return CSSModifierProperty.GridTemplateRows;
    L43:
        return CSSModifierProperty.GridTemplateColumns;
    }

    public static final e3 d0(final Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return new e3(y(new RelaxFrameworkKt$px__M_PFI32$1(r100)), ModifierValuePattern.PX);
    }

    public static final e3 f0(final int r100) {
        return new e3(new RelaxFrameworkKt$rpx$1(r100), ModifierValuePattern.PX);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object[] i0(Object r100) {
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = r100;
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        final p7 r103 = null;
        return new Object[]{new RelaxFrameworkKt$state$getter$1(r102, r101, r103), new RelaxFrameworkKt$state$setter$1(r102, r101)};
    }

    public static final b2 k(int r100) {
        int r101 = z2.f405371a;
        if (z2.a.h() == false) goto L6;
        int r102 = Transform.f404980a;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        final double r104 = r100;
        return new o4(new Transform$Companion$rotate$valueGetter$1(r104));
    L6:
        int r105 = com.bytedance.rts.foundation.d.f267577a;
        return new k8(r100);
    }

    public static final <T> T k0(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        n0 r101 = f404871a;
        f404871a = null;
        T r102 = r100.invoke();
        f404871a = r101;
        return r102;
    }

    public static final <T> T l0(e4<T> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OwnerImpl r101 = OwnerImpl.f404833g;
        OwnerImpl r102 = OwnerImpl.f404833g;
        if (r102 == null) goto L16;
        int r103 = r100.f405070a;
        Map<Integer, Object> r104 = r102.f404837d;
        if (r104 == null) goto L9;
        Intrinsics.checkNotNull(r104);
        if (com.bytedance.rts.foundation.m.b(r104, Integer.valueOf(r103)) == false) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L16;
        T r106 = (T) r102.getContext(r100.f405070a);
        if (r106 != null) goto L17;
        return null;
    L17:
        return r106;
    L9:
        r105 = false;
    L16:
        return r100.f405071b;
    }

    public static final b2 m(double r100) {
        int r101 = z2.f405371a;
        if (z2.a.h() == false) goto L7;
        int r102 = Transform.f404980a;
        Transform$Companion$scale$valueGetter$1 r103 = new Transform$Companion$scale$valueGetter$1(r100);
        return new m7(r103, r103);
    L7:
        return new l8(r100, r100);
    }

    public static final b2 o(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "y");
        int r101 = z2.f405371a;
        if (z2.a.h() == false) goto L6;
        int r102 = Transform.f404980a;
        return Transform.Companion.b(r100);
    L6:
        Intrinsics.checkNotNullParameter(r100, "y");
        return new n8(r100);
    }

    public static final p p(ModifierValue_BackgroundSize r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        int r100 = z2.f405371a;
        if (z2.a.h() == false) goto L6;
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        double r102 = r110.getValue();
        ModifierValuePattern r103 = ModifierValuePattern.ENUM;
        return new m(r102, r103, r110.getValue(), r103);
    L6:
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        double r105 = r110.getValue();
        ModifierValuePattern r111 = ModifierValuePattern.ENUM;
        return new p(r105, r111, r110.getValue(), r111);
    }

    public static final q r(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        double r101 = r100.f405055a;
        ModifierValuePattern r102 = r100.f405056b;
        return new q(r101, r102, r101, r102);
    }

    public static final q s(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return new q(r100.f405068a.invoke().doubleValue(), r100.f405069b, r100.f405068a.invoke().doubleValue(), r100.f405069b);
    }

    public static final e0 t(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        double r101 = r100.f405055a;
        ModifierValuePattern r102 = r100.f405056b;
        return new e0(r101, r102, r101, r102);
    }

    public static final e0 u(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return new e0(r100.f405068a.invoke().doubleValue(), r100.f405069b, r100.f405068a.invoke().doubleValue(), r100.f405069b);
    }

    public static final j x(k r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        if ((r110 instanceof w8) == false) goto L7;
        BackgroundImageType___0 r100 = BackgroundImageType___0.Url;
        ((w8) r110).getClass();
        return new j(r100, null);
    L7:
        if ((r110 instanceof m1) == false) goto L11;
        BackgroundImageType___0 r101 = BackgroundImageType___0.LinearGradient;
        ArrayList<Object> r102 = ((m1) r110).a();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Any");
        return new j(r101, r102);
    L11:
        if ((r110 instanceof n1) == false) goto L35;
        n1 r103 = (n1) r110;
        BackgroundImageType___0 r104 = BackgroundImageType___0.RadialGradient;
        ArrayList<h0> r105 = r103.f405344a;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("colorStopList");
        r105 = null;
    L16:
        Object[] r106 = Q(r105);
        Object r107 = r106[0];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Long> }");
        ArrayList r108 = (ArrayList) r107;
        Object r109 = r106[1];
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
        ArrayList r111 = (ArrayList) r109;
        RelaxInstance.Companion.getClass();
        RelaxInstance r112 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r112);
        z8 r113 = r112.getViewportMetrics();
        Object r114 = r103.a()[0];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        double r115 = ((d3) r114).f405055a;
        Object r116 = r103.a()[0];
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        l3 r117 = T(r115, ((d3) r116).f405056b, r113);
        Object r118 = r103.a()[1];
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        double r119 = ((d3) r118).f405055a;
        Object r120 = r103.a()[1];
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        l3 r121 = T(r119, ((d3) r120).f405056b, r113);
        Object[] r122 = new Object[14];
        int r123 = com.bytedance.rts.foundation.e.f267578a;
        RadialGradientShape r124 = r103.f405345b;
        if (r124 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("shapeValue");
        r124 = null;
    L20:
        r122[0] = Integer.valueOf((int) r124.getValue());
        r122[1] = 4;
        ModifierValuePattern r125 = ModifierValuePattern.PERCENT;
        r122[2] = Integer.valueOf(r125.getValue());
        ArrayList<Double> r126 = r103.f405347d;
        if (r126 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("positionList");
        r126 = null;
    L24:
        r122[3] = ListProtector.get(r126, 0);
        r122[4] = Integer.valueOf(r125.getValue());
        ArrayList<Double> r127 = r103.f405347d;
        if (r127 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("positionList");
        r127 = null;
    L28:
        r122[5] = ListProtector.get(r127, 1);
        Object r128 = r103.a()[0];
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        r122[6] = Double.valueOf(((d3) r128).f405055a);
        Object r129 = r103.a()[0];
        Intrinsics.checkNotNull(r129, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        r122[7] = ((d3) r129).f405056b;
        Object r130 = r103.a()[1];
        Intrinsics.checkNotNull(r130, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        r122[8] = Double.valueOf(((d3) r130).f405055a);
        Object r131 = r103.a()[1];
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
        r122[9] = ((d3) r131).f405056b;
        r122[10] = Double.valueOf(r117.f405177a);
        r122[11] = Integer.valueOf(r117.getType().getValue());
        r122[12] = Double.valueOf(r121.f405177a);
        r122[13] = Integer.valueOf(r121.getType().getValue());
        ArrayList r132 = com.bytedance.rts.foundation.j.k(r122);
        ArrayList r133 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        int r134 = 0;
    L29:
        IntCompanionObject r135 = IntCompanionObject.INSTANCE;
        int r136 = com.bytedance.rts.foundation.j.d(r108);
        com.bytedance.rts.foundation.k.c(r135, r136);
        if (r134 >= r136) goto L32;
        int r137 = com.bytedance.rts.foundation.e.f267578a;
        int r138 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r133, Integer.valueOf((int) ((Number) ListProtector.get(r108, r134)).longValue()));
        r134 = r134 + 1;
        goto L29
    L32:
        ArrayList r139 = com.bytedance.rts.foundation.j.k(new Object[]{r132, r133, r111});
        Intrinsics.checkNotNull(r139, "null cannot be cast to non-null type kotlin.Any");
        return new j(r104, r139);
    L35:
        return new j(BackgroundImageType___0.Empty, "");
    }

    public static Function0 y(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM);
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        final p7 r102 = null;
        return new RelaxFrameworkKt$computed$getter$1(r101, r100, r102);
    }

    public static final <T> s5<T> D(final Function0<? extends ArrayList<T>> r100, final Function2<? super T, ? super Integer, ? extends j5> r101) {
        Intrinsics.checkNotNullParameter(r100, "each");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        Intrinsics.checkNotNullParameter(r100, "each");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        final s5<T> r102 = new s5();
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = (T) com.bytedance.rts.foundation.j.k(new Object[0]);
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = (T) com.bytedance.rts.foundation.j.k(new Object[0][]);
        Y(new RelaxFrameworkKt$createReactiveFor$1(r104));
        K(new RelaxFrameworkKt$createReactiveFor$2(r103, r100, r104, r102, r101));
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r5v0 */
    public static final ListInsertAction G(int r100, q2 r101) {
        Intrinsics.checkNotNullParameter(r101, "itemProps");
        Boolean r102 = r101.f405230e;
        Boolean r103 = Boolean.TRUE;
        boolean r104 = Intrinsics.areEqual(r102, r103);
        ?? r105 = r104;
        if (Intrinsics.areEqual(r101.f405228c, r103) == false) goto L5;
        r105 = (r104 ? 1 : 0) | 2;
    L5:
        ?? r106 = r105;
        if (Intrinsics.areEqual(r101.f405229d, r103) == false) goto L8;
        r106 = (r105 == true ? 1 : 0) | 4;
    L8:
        ?? r107 = r106;
        String r108 = r101.f405226a;
        String r109 = r101.f405227b;
        Double r110 = r101.f405231f;
        if (r110 == null) goto L11;
        double r111 = r110.doubleValue();
    L13:
        return new ListInsertAction(r108, r100, r109, r107 == true ? 1 : 0, r111);
    L11:
        r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L13
    }

    public static final RxListItemImpl H(final q2 r100, Function0<? extends j5> r101) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        return new RxListItemImpl(new RelaxFrameworkKt$createListItem$listItem$1(r100), r101);
    }

    public static final o6 J(Function0<Boolean> r100, Function0<? extends ArrayList<j5>> r101) {
        Intrinsics.checkNotNullParameter(r100, "__when");
        o6 r102 = new o6(r101);
        Intrinsics.checkNotNullParameter(r100, "__when");
        r102.f405206c = r100;
        return r102;
    }

    public static final void U(ArrayList<p6> r110, final long r111) {
        Intrinsics.checkNotNullParameter(r110, "modifiers");
        final ArrayList r100 = com.bytedance.rts.foundation.j.k(new ArrayList[0]);
        ArrayList r112 = com.bytedance.rts.foundation.j.k(new Object[0][]);
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = com.bytedance.rts.foundation.j.d(r110);
        com.bytedance.rts.foundation.k.c(r101, r102);
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L15;
        com.bytedance.rts.foundation.j.j(r100, com.bytedance.rts.foundation.j.k(new Integer[0]));
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        p6 r105 = (p6) ListProtector.get(r110, r103);
        RxModifierType r106 = r105.b();
        if (r106 != RxModifierType.Builtin) goto L9;
        r105.a();
        ListProtector.set(r100, r103, com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r105.c())}));
    L14:
        r103 = r103 + 1;
        goto L4
    L9:
        if (r106 != RxModifierType.Composed) goto L12;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.relax.relaxframework.RxComposedModifier");
        d5 r107 = (d5) r105;
        ListProtector.set(r100, r103, com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.j.k(new p6[0]), RelaxFrameworkKt$initModifiers$1$1.INSTANCE));
        goto L14
    L12:
        if (r106 != RxModifierType.Computed) goto L14;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.relax.relaxframework.RxComputedModifier");
        com.bytedance.rts.foundation.j.j(r112, new Object[]{Integer.valueOf(r103), (e5) r105});
        goto L14
    L15:
        final Ref.BooleanRef r108 = new Ref.BooleanRef();
        r108.element = true;
        IntCompanionObject r109 = IntCompanionObject.INSTANCE;
        int r113 = com.bytedance.rts.foundation.j.d(r112);
        com.bytedance.rts.foundation.k.c(r109, r113);
        if (r113 <= 0) goto L20;
        int r114 = com.bytedance.rts.foundation.j.d(r112);
        com.bytedance.rts.foundation.k.c(r109, r114);
        int r115 = 0;
    L18:
        if (r115 >= r114) goto L20;
        int r116 = com.bytedance.rts.foundation.d.f267577a;
        Object[] r117 = (Object[]) ListProtector.get(r112, r115);
        Object r118 = r117[0];
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.Int");
        final int r119 = ((Integer) r118).intValue();
        Object r120 = r117[1];
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.relax.relaxframework.RxComputedModifier");
        final e5 r121 = (e5) r120;
        K(new RelaxFrameworkKt$initModifiers$2$1(r121, r100, r119, r108, r111));
        r115 = r115 + 1;
    L20:
        ArrayList<Integer> r122 = O(r100);
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().j0(r111, r122);
        r108.element = false;
    }

    public static final <K, V> void X(Map<K, V> r100, Function2<? super V, ? super K, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r101, "cb");
        com.bytedance.rts.foundation.m.d(r100, r101);
    }

    public static final p3 e(d3 r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r100, "bottom");
        Intrinsics.checkNotNullParameter(r101, "left");
        return new p3(PositionOffset_Type___.BottomLeft, r100, r101);
    }

    public static final p3 f(d3 r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r100, "top");
        Intrinsics.checkNotNullParameter(r101, "left");
        return new p3(PositionOffset_Type___.TopLeft, r100, r101);
    }

    public static final <T> T g0(RelaxInstance r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "cb");
        RelaxInstance.Companion.getClass();
        RelaxInstance r102 = RelaxInstance.access$getCurrentInstance$cp();
        RelaxInstance.access$setCurrentInstance$cp(r100);
        T r103 = r101.invoke();
        RelaxInstance.access$setCurrentInstance$cp(r102);
        return r103;
    }

    public static final p3 h(d3 r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r100, "top");
        Intrinsics.checkNotNullParameter(r101, "right");
        return new p3(PositionOffset_Type___.TopRight, r100, r101);
    }

    public static final Object h0(OwnerImpl r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "cb");
        OwnerImpl r102 = OwnerImpl.f404833g;
        RelaxInstance.Companion.getClass();
        RelaxInstance r103 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.relax.relaxframework.OwnerImpl");
        OwnerImpl.f404833g = r100;
        if (r100 == null) goto L5;
        RelaxInstance r104 = r100.f404835b;
    L6:
        RelaxInstance.access$setCurrentInstance$cp(r104);
        Object r105 = r101.invoke();
        OwnerImpl.f404833g = r102;
        RelaxInstance.access$setCurrentInstance$cp(r103);
        return r105;
    L5:
        r104 = null;
        goto L6
    }

    public static final q3 i(e3 r100, e3 r101) {
        Intrinsics.checkNotNullParameter(r100, "top");
        Intrinsics.checkNotNullParameter(r101, "right");
        return new q3(PositionOffset_Type___.TopRight, r100, r101);
    }

    public static final int j(int r100, boolean r101) {
        if (r100 != ModifierValue_TextAlign.Start.getValue()) goto L10;
        if (r101 == false) goto L6;
        ModifierValue_TextAlign r102 = ModifierValue_TextAlign.Right;
    L8:
        return r102.getValue();
    L6:
        r102 = ModifierValue_TextAlign.Left;
        goto L8
    L10:
        if (r100 != ModifierValue_TextAlign.End.getValue()) goto L16;
        if (r101 == false) goto L13;
        ModifierValue_TextAlign r103 = ModifierValue_TextAlign.Left;
    L15:
        return r103.getValue();
    L13:
        r103 = ModifierValue_TextAlign.Right;
        goto L15
    L16:
        Intrinsics.checkNotNull(Integer.valueOf(r100), "null cannot be cast to non-null type kotlin.Int");
        return r100;
    }

    public static final int q(ArrayList<Integer> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "arr");
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r102, r103);
        int r104 = -1;
        int r105 = r103 - 1;
        int r106 = 0;
    L3:
        if (r106 > r105) goto L8;
        int r107 = (r106 + r105) / 2;
        int r108 = com.bytedance.rts.foundation.d.f267577a;
        Object r109 = ListProtector.get(r100, r107);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) r109).intValue() < r101) goto L6;
        r105 = r107 - 1;
        goto L3
    L6:
        r106 = r107 + 1;
        r104 = r107;
        goto L3
    L8:
        return r104;
    }

    public static final d3 v(double r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r101, "lineHeight");
        if (r101.f405056b == ModifierValuePattern.NUMBER) goto L5;
        return r101;
    L5:
        return new d3(r100 * r101.f405055a, ModifierValuePattern.PX);
    }

    public static final <T> s5<T> E(Function0<? extends ArrayList<T>> r100, Function2<? super Function0<? extends T>, ? super Function0<Integer>, ? extends j5> r101, Function2<? super T, ? super Integer, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "each");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        if (r102 != null) goto L5;
        r102 = RelaxFrameworkKt$createFor$2.INSTANCE;
    L5:
        final d4 r103 = new d4(r100, r101, r102, 0, new s5());
        Intrinsics.checkNotNullParameter(r103, SlcElement.KEY_PROPS);
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = (T) com.bytedance.rts.foundation.j.k(new n2[0]);
        Integer r105 = r103.f405061e;
        if (r105 == null) goto L8;
        int r106 = r105.intValue();
    L9:
        final c4 r107 = new c4(r106, null);
        final l7 r108 = r103.f405062f;
        if (r108 != null) goto L12;
        r108 = f404895y.invoke();
    L12:
        Y(new RelaxFrameworkKt$RecycleFor$1(r104, r107));
        K(new RelaxFrameworkKt$RecycleFor$2(r103, r104, r107, r108));
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.relax.relaxframework.RxForImpl<T of com.relax.relaxframework.RelaxFrameworkKt.createFor>");
        return (s5) r108;
    L8:
        r106 = -1;
        goto L9
    }

    public static final RxListItemsImplFor I(Function0 r100, Function2 r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "each");
        Intrinsics.checkNotNullParameter(r101, "getItemProps");
        Intrinsics.checkNotNullParameter(r102, "renderItem");
        return new RxListItemsImplFor(r100, r102, r101);
    }

    public static final l3 T(double r100, ModifierValuePattern r101, z8 r102) {
        Intrinsics.checkNotNullParameter(r101, "pattern");
        Intrinsics.checkNotNullParameter(r102, "viewportMetrics");
        if (r102.f405380d == false) goto L5;
        double r103 = 1.0d;
    L7:
        switch(a.f404899c[r101.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        return new l3(r100 * r103, LengthType.NUMBER);
    L11:
        return new l3(r100, LengthType.NUMBER);
    L13:
        return new l3((r100 / 750.0d) * r102.f405377a, LengthType.NUMBER);
    L15:
        return new l3((r100 / 100.0d) * r102.f405378b, LengthType.NUMBER);
    L17:
        return new l3((r100 / 100.0d) * r102.f405377a, LengthType.NUMBER);
    L19:
        return new l3(r100 / r102.f405379c, LengthType.NUMBER);
    L21:
        return new l3(r100 / 100.0d, LengthType.PERCENT);
    L23:
        return new l3(r100 * r103, LengthType.NUMBER);
    L5:
        r103 = r102.f405379c;
        goto L7
    }

    public static final RxPageImpl e0(final Function2 r100, final Object r101, final RelaxInstance r110) {
        final n4 r102 = null;
        Intrinsics.checkNotNullParameter(r100, "App");
        Intrinsics.checkNotNullParameter(r110, "relaxInstance");
        Intrinsics.checkNotNullParameter(r100, "App");
        Intrinsics.checkNotNullParameter(r110, "relaxInstance");
        int r103 = l6.f405180a;
        l6.a.a(new String[]{"Relax renderPage (RTS pipeline enabled: " + r110.rtsPipelineEnabled() + ')'});
        final ReactiveRuntime r104 = new ReactiveRuntime();
        OwnerImpl r105 = new OwnerImpl(null, true);
        LinkedHashMap r106 = new LinkedHashMap();
        Map<Integer, Object> r107 = r105.f404837d;
        if (r107 == null) goto L5;
        Intrinsics.checkNotNull(r107);
        X(r107, new OwnerImpl$copyContext$1(r106));
    L5:
        r105.f404837d = r106;
        r105.f404835b = r110;
        Intrinsics.checkNotNullParameter(r105, RootDescription.ROOT_ELEMENT);
        r104.f404863i = r105;
        r105.f404834a = r104;
        return (RxPageImpl) h0(r105, new RelaxFrameworkKt$renderPage$pageEle$1(r102, r110, r100, r101, r104));
    }

    public static final <T, R> R o0(e4<T> r100, T r101, Function0<? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "cb");
        OwnerImpl r103 = new OwnerImpl(OwnerImpl.f404833g, false);
        LinkedHashMap r104 = new LinkedHashMap();
        Map<Integer, Object> r105 = r103.f404837d;
        if (r105 == null) goto L5;
        Intrinsics.checkNotNull(r105);
        X(r105, new OwnerImpl$copyContext$1(r104));
    L5:
        r103.f404837d = r104;
        int r106 = r100.f405070a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Any");
        r103.b(r106, r101);
        return (R) h0(r103, r102);
    }

    public static final <T> j5 z(final Function2<? super T, ? super Function0<? extends ArrayList<j5>>, ? extends j5> r100, final T r101, final Function0<? extends ArrayList<j5>> r102) {
        Intrinsics.checkNotNullParameter(r100, "Comp");
        return (j5) k0(new RelaxFrameworkKt$createComponent$1(r100, r101, r102));
    }
}
