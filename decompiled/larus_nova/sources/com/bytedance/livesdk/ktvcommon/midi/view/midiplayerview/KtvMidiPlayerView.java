package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.livesdk.ktvcommon.midi.view.miditone.KSongToneView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u000f\u0010J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/midiplayerview/KtvMidiPlayerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lkotlin/Pair;", "", "getTimeRange", "Lcom/bytedance/livesdk/ktvcommon/midi/view/j;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "setPerformStrategy", VideoThumbInfo.KEY_INTERVAL, "setScoreInterval", "Lbl6/g;", "toneRange", "setToneRange", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiPlayerView extends ConstraintLayout {
    public static final /* synthetic */ int G = 0;
    public final a A;
    public final com.bytedance.android.live.ktv.common.midi.d B;
    public final com.bytedance.android.live.ktv.common.midi.d C;
    public final g D;
    public final d E;
    public final j F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f256180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f256181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f256182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public KSongToneView f256183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintLayout f256184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f256185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f256186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f256187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public KtvMidiDataProcessor f256188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f256189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zk6.c f256190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.livesdk.ktvcommon.midi.view.j f256191l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.livesdk.ktvcommon.midi.view.i f256192m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MidiSkinDressInfo f256193n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f256194o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f256195p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f256196q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f256197r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f256198s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f256199t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f256200u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public py.k f256201v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Disposable f256202w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f256203x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f256204y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f256205z;

    public final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiPlayerView f256206a;

        public a(KtvMidiPlayerView r100) {
            this.f256206a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            int r100 = r110.what;
            View r101 = null;
            if (r100 == 0) goto L48;
            if (r100 == 1) goto L14;
            if (r100 != 2) goto L105;
            Object r111 = r110.obj;
            if (r111 == null) goto L13;
            int r112 = ((Integer) r111).intValue();
            ImageView r102 = this.f256206a.f256181b;
            if (r102 == null) goto L105;
            r102.post(new e(this, r112));
            goto L105
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L105:
            return true;
        L14:
            final KtvMidiPlayerView r113 = this.f256206a;
            r113.f256200u = false;
            com.bytedance.livesdk.ktvcommon.midi.view.j r103 = r113.f256191l;
            if (r103 != null) goto L17;
        L19:
            final boolean r104 = false;
        L20:
            k r105 = r113.f256189j;
            if (r105 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("animationController");
        L23:
            ImageView r106 = r113.f256182c;
            HSImageView r114 = r113.f256180a;
            Function0<Unit> r115 = new KtvMidiPlayerView$showMissAnimation$1(r113, r104);
            r105.a();
            if (r106 == null) goto L26;
            WeakReference<View> r116 = new WeakReference(r106);
        L27:
            r105.f256250d = r116;
            if (r114 == null) goto L30;
            WeakReference<View> r117 = new WeakReference(r114);
        L31:
            r105.f256251e = r117;
            r105.f256248b.cancel();
            r105.f256248b.removeAllListeners();
            ValueAnimator r107 = k.b(r106, 1.0f, 0.0f, r105.f256260n);
            ValueAnimator r108 = k.b(r114, 1.0f, 0.0f, r105.f256260n);
            AnimatorSet r109 = r105.f256248b;
            if (r104 == false) goto L34;
            List r118 = CollectionsKt.listOf(r107);
        L35:
            r109.playTogether(r118);
            k.b r119 = r105.f256256j;
            r119.f256263a = null;
            r119.f256264b = r115;
            r105.f256248b.addListener(r119);
            k r120 = r113.f256189j;
            if (r120 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("animationController");
        L38:
            WeakReference<View> r121 = r120.f256250d;
            if (r121 == null) goto L41;
            View r122 = r121.get();
        L42:
            if (r122 != null) goto L47;
            WeakReference<View> r123 = r120.f256251e;
            if (r123 == null) goto L46;
            r101 = r123.get();
        L46:
            if (r101 == null) goto L105;
        L47:
            r120.f256248b.start();
            goto L105
        L41:
            r122 = null;
            goto L42
        L34:
            r118 = CollectionsKt.listOf(new ValueAnimator[]{r107, r108});
            goto L35
        L30:
            r117 = null;
            goto L31
        L26:
            r116 = null;
            goto L27
        L17:
            if (r103.getCurrentMode() != 1) goto L19;
            r104 = true;
            goto L20
        L48:
            final KtvMidiPlayerView r124 = this.f256206a;
            r124.f256200u = true;
            com.bytedance.livesdk.ktvcommon.midi.view.j r125 = r124.f256191l;
            if (r125 != null) goto L51;
        L53:
            boolean r126 = false;
        L54:
            k r127 = r124.f256189j;
            if (r127 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("animationController");
        L57:
            ImageView r128 = r124.f256182c;
            HSImageView r129 = r124.f256180a;
            Function0<Unit> r130 = new KtvMidiPlayerView$showHitAnimation$1(r124);
            r127.a();
            if (r128 == null) goto L60;
            WeakReference<View> r131 = new WeakReference(r128);
        L61:
            r127.f256250d = r131;
            if (r129 == null) goto L64;
            WeakReference<View> r132 = new WeakReference(r129);
        L65:
            r127.f256251e = r132;
            r127.f256247a.cancel();
            r127.f256247a.removeAllListeners();
            ValueAnimator r133 = k.b(r128, 0.0f, 1.0f, r127.f256259m);
            ValueAnimator r134 = k.b(r129, 0.0f, 1.0f, r127.f256259m);
            AnimatorSet r135 = r127.f256247a;
            if (r126 == false) goto L68;
            List r136 = CollectionsKt.listOf(r133);
        L69:
            r135.playTogether(r136);
            k.a r137 = r127.f256255i;
            r137.f256261a = r130;
            r137.f256262b = null;
            r127.f256247a.addListener(r137);
            com.bytedance.livesdk.ktvcommon.midi.view.j r138 = r124.f256191l;
            if (r138 == null) goto L105;
            int r139 = r138.getCurrentMode();
            com.bytedance.livesdk.ktvcommon.midi.view.j r140 = r124.f256191l;
            if (r140 == null) goto L75;
            py.k r141 = r140.G();
            if (r141 == null) goto L75;
        L83:
            if (r141 != null) goto L85;
        L89:
            r124.f256201v = r141;
            if (r124.S5() == false) goto L96;
            j r142 = r124.F;
            HSImageView r143 = r124.f256180a;
            com.bytedance.android.live.ktv.common.midi.d r144 = r124.B;
            r142.getClass();
            Intrinsics.checkNotNullParameter(r144, "callback");
            if (r143 == null) goto L105;
            if (r141 == null) goto L105;
            FrescoLoader.with(r142.f256246a).load(r141).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r144).into(r143);
            goto L105
        L96:
            if (r139 != 2) goto L101;
            j r145 = r124.F;
            HSImageView r146 = r124.f256180a;
            com.bytedance.android.live.ktv.common.midi.d r147 = r124.C;
            r145.getClass();
            Intrinsics.checkNotNullParameter(r147, "callback");
            if (r146 == null) goto L105;
            FrescoLoader.with(r145.f256246a).load(com.bytedance.android.live.ktv.common.midi.j.f69856c).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r147).into(r146);
            goto L105
        L101:
            j r148 = r124.F;
            HSImageView r149 = r124.f256180a;
            com.bytedance.android.live.ktv.common.midi.d r150 = r124.C;
            r148.getClass();
            Intrinsics.checkNotNullParameter(r150, "callback");
            if (r149 == null) goto L105;
            FrescoLoader.with(r148.f256246a).load(com.bytedance.android.live.ktv.common.midi.c.f69842d).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(r150).into(r149);
            goto L105
        L85:
            if (Intrinsics.areEqual(r124.f256201v, r141) == false) goto L89;
            com.bytedance.android.live.ktv.common.midi.d r151 = r124.B;
            if (r151 == null) goto L105;
            r151.onFinalImageSet("", null, null);
        L75:
            MidiSkinDressInfo r152 = r124.f256193n;
            if (r152 == null) goto L82;
            MidiSkinMaterial r153 = r152.getMaterial();
            if (r153 == null) goto L82;
            BackgroundMaterial r154 = r153.getBg();
            if (r154 == null) goto L82;
            r141 = r154.getBuoyAreaBg();
        L82:
            r141 = null;
            goto L83
        L68:
            r136 = CollectionsKt.listOf(new ValueAnimator[]{r133, r134});
            goto L69
        L64:
            r132 = null;
            goto L65
        L60:
            r131 = null;
            goto L61
        L51:
            if (r125.getCurrentMode() != 1) goto L53;
            r126 = true;
            goto L54
        }
    }

    public static final class b {
    }

    static {
    }

    public KtvMidiPlayerView(Context r100) {
        this(r100, null, 0, 30);
    }

    public KtvMidiPlayerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 28);
    }

    public KtvMidiPlayerView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 24);
    }

    public void setScoreInterval(long r100) {
    }

    public final void S3() {
        if (this.f256190k == null) goto L12;
        Disposable r100 = this.f256202w;
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        KtvMidiDataProcessor r101 = this.f256188i;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L10:
        Function1<bl6.f, Unit> r102 = new KtvMidiPlayerView$updateMatch$$inlined$let$lambda$1(this);
        KtvMidiPlayerView$updateMatch$1$2 r103 = KtvMidiPlayerView$updateMatch$1$2.INSTANCE;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f256202w = Single.create(new com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.a(r101)).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r102), new c(r103));
        return;
    }

    public final boolean S5() {
        MidiSkinDressInfo r100 = this.f256193n;
        String r101 = null;
        if (r100 == null) goto L12;
        String r102 = r100.getDressId();
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L13:
        if (r102 == null) goto L21;
        MidiSkinDressInfo r104 = this.f256193n;
        if (r104 == null) goto L18;
        r101 = r104.getDressId();
    L18:
        if ((!Intrinsics.areEqual(r101, "0")) == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L9:
        r103 = false;
    L12:
        r102 = null;
        goto L13
    }

    public final Pair<Long, Long> getTimeRange() {
        com.bytedance.livesdk.ktvcommon.midi.view.j r100 = this.f256191l;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.getCurrentMode() != 1) goto L7;
    L8:
        KtvMidiDataProcessor r102 = this.f256188i;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L11:
        if (r101 == false) goto L14;
        return r102.f256177c.f256214b;
    L14:
        return r102.f256177c.f256213a;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k r100 = this.f256189j;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationController");
    L5:
        r100.a();
        Disposable r101 = this.f256202w;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f256205z.removeCallbacksAndMessages(null);
        HSImageView r102 = this.f256180a;
        if (r102 == null) goto L11;
        r102.setImageDrawable(null);
    L11:
        ImageView r103 = this.f256181b;
        if (r103 == null) goto L14;
        r103.setImageDrawable(null);
    L14:
        ImageView r104 = this.f256182c;
        if (r104 == null) goto L17;
        r104.setImageDrawable(null);
    L17:
        setLayerType(0, null);
    }

    public static void R5(View r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 == null) goto L10;
        r100.setVisibility(8);
        return;
    L10:
        return;
    L5:
        if (r100.getVisibility() != 8) goto L7;
    }

    public final void D3(final long r110) {
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f256203x) >= 16) goto L5;
        return;
    L5:
        this.f256203x = r100;
        com.bytedance.livesdk.ktvcommon.midi.view.j r101 = this.f256191l;
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.getCurrentMode() != 1) goto L10;
    L11:
        KtvMidiDataProcessor r103 = this.f256188i;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L14:
        Function1<List<? extends bl6.f>, Unit> r111 = new KtvMidiPlayerView$drawLines$1(this, r110);
        KtvMidiPlayerView$drawLines$2 r112 = KtvMidiPlayerView$drawLines$2.INSTANCE;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        Intrinsics.checkNotNullParameter(r112, LynxVideoManagerLite.EVENT_ON_ERROR);
        r103.f256176b = r110;
        if (r102 == false) goto L17;
        Pair<Long, Long> r104 = r103.f256177c.f256214b;
    L18:
        RxUtilKt.c(Single.create(new com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.b(r103, r110, r104.component1().longValue(), r104.component2().longValue())).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r111), new c(r112)), r103.f256175a);
        return;
    L17:
        r104 = r103.f256177c.f256213a;
    L10:
        r102 = false;
        goto L11
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setPerformStrategy(com.bytedance.livesdk.ktvcommon.midi.view.j r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f256191l = r100;
        TextView r101 = this.f256185f;
        if (r101 == null) goto L5;
        r101.setTextColor(r100.B());
    L5:
        MidiSkinDressInfo r102 = r100.z();
        MidiSkinDressInfo r103 = this.f256193n;
        Pair<String, String> r104 = null;
        String r105 = null;
        r105 = null;
        r105 = null;
        if (r103 == null) goto L8;
        String r106 = r103.getDressId();
    L9:
        if (r102 == null) goto L11;
        String r107 = r102.getDressId();
    L13:
        if (Intrinsics.areEqual(r106, r107) == true) goto L99;
        this.f256193n = r102;
        com.bytedance.livesdk.ktvcommon.midi.view.j r108 = this.f256191l;
        if (r108 == null) goto L18;
        Integer r109 = Integer.valueOf(r108.getCurrentMode());
    L20:
        if (S5() == false) goto L63;
        j r110 = this.F;
        ImageView r111 = this.f256182c;
        MidiSkinDressInfo r112 = this.f256193n;
        if (r112 == null) goto L28;
        MidiSkinMaterial r113 = r112.getMaterial();
        if (r113 == null) goto L28;
        BuoyMaterial r114 = r113.getBuoy();
        if (r114 == null) goto L28;
        py.k r115 = r114.getBuoyTailing();
    L29:
        r110.getClass();
        if (r111 == null) goto L33;
        ImageUtil.loadImage(r111, r115, 0);
    L33:
        j r116 = this.F;
        ImageView r117 = this.f256181b;
        MidiSkinDressInfo r118 = this.f256193n;
        if (r118 == null) goto L40;
        MidiSkinMaterial r119 = r118.getMaterial();
        if (r119 == null) goto L40;
        BuoyMaterial r120 = r119.getBuoy();
        if (r120 == null) goto L40;
        py.k r121 = r120.getBuoyBall();
    L41:
        r116.getClass();
        if (r117 == null) goto L45;
        ImageUtil.loadImage(r117, r121, 0);
    L45:
        KSongToneView r122 = this.f256183d;
        if (r122 == null) goto L88;
        MidiSkinDressInfo r123 = this.f256193n;
        if (r123 == null) goto L54;
        MidiSkinMaterial r124 = r123.getMaterial();
        if (r124 == null) goto L54;
        BackgroundMaterial r125 = r124.getBg();
        if (r125 == null) goto L54;
        String r126 = r125.getToneLineStart();
    L55:
        MidiSkinDressInfo r127 = this.f256193n;
        if (r127 == null) goto L62;
        MidiSkinMaterial r128 = r127.getMaterial();
        if (r128 == null) goto L62;
        BackgroundMaterial r129 = r128.getBg();
        if (r129 == null) goto L62;
        r105 = r129.getToneLineEnd();
    L62:
        r122.setToneLineColorConfig(TuplesKt.to(r126, r105));
    L54:
        r126 = null;
    L88:
        com.bytedance.livesdk.ktvcommon.midi.view.j r130 = this.f256191l;
        if (r130 == null) goto L91;
        int r131 = r130.B();
    L92:
        TextView r132 = this.f256185f;
        if (r132 != null) goto L95;
    L96:
        TextView r133 = this.f256185f;
        if (r133 == null) goto L99;
        r133.setTextColor(r131);
        goto L99
    L95:
        if (r132.getCurrentTextColor() == r131) goto L99;
    L91:
        r131 = s1.h(R.color.ttlive_chorus_midi_score_low_text_color);
    L40:
        r121 = null;
    L28:
        r115 = null;
        goto L29
    L63:
        if (r109 != null) goto L66;
    L77:
        j r134 = this.F;
        ImageView r135 = this.f256182c;
        r134.getClass();
        if (r135 == null) goto L81;
        r135.setImageResource(R.drawable.ttlive_ktv_hit_float_ball_tail);
    L81:
        j r136 = this.F;
        ImageView r137 = this.f256181b;
        r136.getClass();
        if (r137 == null) goto L85;
        r137.setImageResource(R.drawable.ttlive_ktv_hit_float_ball);
    L85:
        KSongToneView r138 = this.f256183d;
        if (r138 == null) goto L88;
        r138.setToneLineColorConfig(null);
        goto L88
    L66:
        if (r109.intValue() != 2) goto L77;
        j r139 = this.F;
        ImageView r140 = this.f256182c;
        r139.getClass();
        if (r140 == null) goto L71;
        r140.setImageResource(R.drawable.ttlive_chorus_hit_tail);
    L71:
        KSongToneView r141 = this.f256183d;
        if (r141 == null) goto L88;
        com.bytedance.livesdk.ktvcommon.midi.view.j r142 = this.f256191l;
        if (r142 == null) goto L76;
        r104 = r142.E();
    L76:
        r141.setToneLineColorConfig(r104);
        goto L88
    L18:
        r109 = null;
    L99:
        removeCallbacks(this.D);
        postDelayed(this.D, 100);
        return;
    L11:
        r107 = null;
        goto L13
    L8:
        r106 = null;
        goto L9
    }

    public void setToneRange(bl6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "toneRange");
        d r101 = this.E;
        int r102 = r100.f19490a;
        r101.f256215c = r102;
        int r103 = r100.f19491b;
        r101.f256216d = r103;
        KSongToneView r104 = this.f256183d;
        if (r104 == null) goto L11;
        com.bytedance.livesdk.ktvcommon.midi.view.miditone.d r105 = r104.f256274h;
        if (r105.f256286a == r102) goto L7;
    L9:
        r105.f256286a = r102;
        r105.f256287b = r103;
        r105.f256290e = r105.f256289d / (r103 - r102);
        r104.f256275i.b();
        r104.invalidate();
        return;
    L7:
        if (r105.f256287b != r103) goto L9;
        return;
    }

    public KtvMidiPlayerView(Context r210, AttributeSet r211, int r212, int r213) {
        if ((r213 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r213 & 8) == 0) goto L13;
        Pair r102 = TuplesKt.to(1360L, 3470L);
        Pair r103 = TuplesKt.to(1000L, 2500L);
        float r110 = s1.f(92.0f);
        int r111 = s1.f(55.0f);
        int r112 = s1.f(14.0f) - s1.f(9.0f);
        int r113 = s1.f(9.0f);
        String r114 = s1.B(R.string.ttlive_ktv_score);
        int r115 = s1.f(18.0f);
        int r116 = s1.j(R.dimen.ttlive_rt_chorus_midi_container_width);
        Pair r104 = TuplesKt.to(Integer.valueOf(R.drawable.ttlive_ktv_component_midi_score_high_top_bg), Integer.valueOf(s1.h(R.color.ttlive_ktv_midi_score_high_text_color)));
        Integer r105 = Integer.valueOf(R.drawable.ttlive_ktv_component_midi_score_bg);
        d r106 = new d(r102, r103, r110, r111, r112, r113, r114, r115, r116, r104, TuplesKt.to(r105, Integer.valueOf(s1.h(R.color.ttlive_ktv_midi_score_low_text_color))), TuplesKt.to(Integer.valueOf(R.drawable.ttlive_ktv_component_midi_score_high_bottom_bg), Integer.valueOf(s1.h(R.color.ttlive_ktv_midi_score_high_text_color))), TuplesKt.to(Integer.valueOf(R.drawable.ttlive_ktv_component_midi_score_low_bottom_bg), Integer.valueOf(s1.h(R.color.ttlive_ktv_midi_score_low_text_color))), TuplesKt.to(r105, Integer.valueOf(s1.h(R.color.ttlive_chorus_midi_score_low_text_color))), RxUtil.rxSchedulerHelper());
    L15:
        if ((r213 & 16) == 0) goto L17;
        j r107 = new j(r210);
    L18:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, "config");
        Intrinsics.checkNotNullParameter(r107, "resourceManager");
        super(r210, r100, r101);
        this.E = r106;
        this.F = r107;
        this.f256198s = -1.0f;
        this.f256199t = r106.f256226n;
        this.f256205z = new f(this, Looper.getMainLooper());
        this.A = new a(this);
        this.B = com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvMidiPlayerView$midiHitAnimCallback$1(this));
        this.C = com.bytedance.android.live.ktv.common.midi.e.a(this, new KtvMidiPlayerView$hitAnimationCallback$1(this));
        setLayerType(2, null);
        this.f256189j = new k(r106.f256222j, r106.f256223k);
        ViewGroup.inflate(getContext(), R.layout.ttlive_ktv_midi_player_view, this);
        HSImageView r108 = (HSImageView) findViewById(R.id.midi_tone_hit_bg);
        r108.setVisibility(8);
        r108.setLayerType(2, null);
        Unit r109 = Unit.INSTANCE;
        this.f256180a = r108;
        View r117 = findViewById(R.id.tonePoint);
        ((HSImageView) r117).setLayerType(2, null);
        this.f256181b = (ImageView) r117;
        View r118 = findViewById(R.id.tonePoint_tail);
        HSImageView r119 = (HSImageView) r118;
        r119.setVisibility(8);
        r119.setLayerType(2, null);
        this.f256182c = (ImageView) r118;
        KSongToneView r120 = (KSongToneView) findViewById(R.id.toneLines);
        r120.setLayerType(2, null);
        r120.setWillNotDraw(false);
        this.f256183d = r120;
        ConstraintLayout r121 = (ConstraintLayout) findViewById(R.id.ktv_component_midi_score_content);
        r121.setVisibility(8);
        this.f256184e = r121;
        this.f256185f = (TextView) findViewById(R.id.ktv_component_midi_score_text);
        View r122 = findViewById(R.id.ktv_component_midi_score_bg);
        ((HSImageView) r122).setVisibility(8);
        this.f256186g = (ImageView) r122;
        this.f256187h = findViewById(R.id.midi_divide_line);
        TextView r123 = this.f256185f;
        if (r123 == null) goto L21;
        r123.setText(r106.f256224l);
    L21:
        this.D = new g(this);
        return;
    L17:
        r107 = null;
        goto L18
    L13:
        r106 = null;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
