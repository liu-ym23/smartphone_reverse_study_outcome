package com.bytedance.livesdk.ktvcommon.midi.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.KtvMidiHitParticleView;
import com.bytedance.livesdk.ktvcommon.midi.view.midihitview.KtvMidiHitEffectView;
import com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.KtvMidiDataProcessor;
import com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.KtvMidiPlayerView;
import com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.k;
import com.bytedance.livesdk.ktvcommon.midi.view.miditone.KSongToneView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import io.reactivex.disposables.Disposable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016RT\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/KtvMidiView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/livesdk/ktvcommon/midi/view/a;", "Lcom/bytedance/livesdk/ktvcommon/midi/view/j;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "setPerformStrategy", "Lbl6/b;", "config", "setConfig", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, ce.f26391f, "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "h", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiView extends ConstraintLayout implements com.bytedance.livesdk.ktvcommon.midi.view.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f256049i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KtvMidiHitEffectView f256050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KtvMidiPlayerView f256051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KtvMidiHitParticleView f256052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f256053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f256054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f256055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super Boolean, ? super Long, Unit> f256056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f256057h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiView f256058a;

        public b(KtvMidiView r100) {
            this.f256058a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvMidiView r100 = this.f256058a;     // Catch: Throwable -> L4
            int r101 = KtvMidiView.f256049i;     // Catch: Throwable -> L4
            r100.getViewTreeObserver().addOnGlobalLayoutListener(new h(r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public KtvMidiView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvMidiView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void A1() {
        e r100 = this.f256055f;
        r100.f256079h = false;
        Animator r101 = r100.f256086o;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRunning() != true) goto L11;
        Animator r102 = r100.f256086o;
        if (r102 == null) goto L12;
        r102.cancel();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void onDetach() {
        e r100 = this.f256055f;
        r100.a();
        r100.f256084m.clear();
        KtvMidiHitParticleView r101 = this.f256052c;
        if (r101 == null) goto L9;
        com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.d r102 = r101.f256095c;
        Iterator r103 = ((ArrayList) r102.f256118b).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        ((Animator) r103.next()).cancel();
        goto L6
    L8:
        ((ArrayList) r102.f256118b).clear();
        r102.f256119c.f256129a.clear();
        r102.f256120d.f256129a.clear();
        r102.f256121e.f256129a.clear();
        r102.f256122f.f256129a.clear();
        r102.f256123g.f256129a.clear();
        com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.a r104 = r101.f256094b;
        com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.a.C3638a r105 = r104.f256096a;
        ((ArrayList) r105.f256100a).clear();
        ((ArrayList) r105.f256101b).clear();
        com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.a.C3638a r106 = r104.f256097b;
        ((ArrayList) r106.f256100a).clear();
        ((ArrayList) r106.f256101b).clear();
    L9:
        KtvMidiHitEffectView r107 = this.f256050a;
        if (r107 == null) goto L12;
        r107.onDetach();
    L12:
        KtvMidiPlayerView r108 = this.f256051b;
        if (r108 == null) goto L24;
        r108.f256190k = null;
        r108.f256191l = null;
        r108.f256205z.removeCallbacksAndMessages(null);
        KtvMidiDataProcessor r109 = r108.f256188i;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L17:
        r109.f256175a.dispose();
        Disposable r110 = r108.f256202w;
        if (r110 == null) goto L20;
        r110.dispose();
    L20:
        k r111 = r108.f256189j;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("animationController");
    L23:
        r111.a();
    L24:
        setVisibility(8);
    }

    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.f256056g;
    }

    public String getTypeName() {
        return this.f256057h;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void E3(i r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        e r101 = this.f256055f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r101.f256083l = r100;
        KtvMidiPlayerView r102 = this.f256051b;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r102.f256192m = r100;
        return;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void R2(long r100) {
        KtvMidiPlayerView r101 = this.f256051b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        r101.D3(r100);
        return;
    L15:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        Function2<Boolean, Long, Unit> r101 = getOneDrawCallback();
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void p5(bl6.g r100) {
        KtvMidiPlayerView r101 = this.f256051b;
        if (r101 == null) goto L6;
        r101.setToneRange(r100);
        return;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public void setConfig(bl6.b r100) {
        this.f256055f.getClass();
    }

    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.f256056g = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public void setPerformStrategy(j r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        e r101 = this.f256055f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r101.f256084m = r100;
        MidiSkinDressInfo r102 = r100.z();
        if (r102 == null) goto L5;
        r100.y(r102);
    L5:
        KtvMidiPlayerView r103 = this.f256051b;
        if (r103 == null) goto L8;
        r103.setPerformStrategy(r100);
    L8:
        KtvMidiHitParticleView r104 = this.f256052c;
        if (r104 == null) goto L11;
        r104.a(r100);
    L11:
        KtvMidiHitEffectView r105 = this.f256050a;
        if (r105 == null) goto L15;
        r105.Z5(r100);
    L15:
        if (r100.getCurrentMode() != 2) goto L21;
        KtvMidiHitEffectView r106 = this.f256050a;
        if (r106 == null) goto L21;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L21;
        r107.width = s1.f(144.0f);
    L21:
        postDelayed(new b(this), 100);
    }

    public void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f256057h = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void R(bl6.e r110, Long r111) {
        Intrinsics.checkNotNullParameter(r110, "scoreInfo");
        r111.longValue();
        KtvMidiPlayerView r112 = this.f256051b;
        if (r112 == null) goto L5;
        r112.getClass();
    L5:
        if (r112 == null) goto L303;
        float r100 = r110.f19483d;
        float r101 = r110.f19484e;
        float r102 = r110.f19480a;
        boolean r103 = r110.f19489j;
        boolean r104 = false;
        if (r112.f256204y == true) goto L9;
    L216:
        Pair r113 = TuplesKt.to(Float.valueOf(r112.E.f256217e), Float.valueOf(r112.f256195p));
    L217:
        if (r113 == null) goto L308;
        final e r105 = this.f256055f;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "scoreInfo");
        Intrinsics.checkNotNullParameter(r113, "position");
        int r106 = r105.f256078g;
        int r107 = r110.f19485f;
        if (r106 != r107) goto L222;
    L284:
        float r108 = r110.f19483d;
        float r109 = 0;
        if (r108 <= r109) goto L291;
        float r114 = r110.f19484e;
        if (r114 <= r109) goto L291;
        if (Math.abs(r108 - r114) > r105.f256082k) goto L291;
        r104 = true;
    L291:
        if (r104 == false) goto L304;
        KtvMidiPlayerView r115 = r105.f256074c;
        if (r115 == null) goto L295;
        r115.S3();
    L295:
        i r116 = r105.f256083l;
        if (r116 == null) goto L305;
        r116.a();
        long r117 = r105.f256077f % ((long) r105.f256081j);
        r105.f256077f = 1 + r117;
        if (r117 != 0) goto L306;
        KtvMidiHitParticleView r118 = r105.f256073b;
        if (r118 == null) goto L307;
        r118.post(new d(r105, r113, r110));
        return;
    L307:
        return;
    L306:
        return;
    L305:
        return;
    L304:
        return;
    L222:
        if (r110.f19481b <= 0) goto L284;
        if (r107 < 0) goto L284;
        i r119 = r105.f256083l;
        if (r119 == null) goto L273;
        r119.d();
        HitType r120 = r110.f19487h;
        if (r120 != null) goto L229;
        r120 = HitType.MISS;
    L229:
        int r121 = r110.f19488i;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvMidiController", "showComboEffect hitType " + r120 + " comboCount " + r121);
        int r122 = KtvSettingHelper.l();
        HitType r123 = HitType.PERFECT;
        if (r120 == r123) goto L232;
    L235:
        if (r120 != r123) goto L237;
    L240:
        KtvMidiHitEffectView r124 = r105.f256072a;
        if (r124 != null) goto L243;
    L247:
        r105.f256084m.A();
        if (r105.f256079h == false) goto L272;
        int r125 = r105.f256084m.getCurrentMode();
        Animator r126 = r105.f256085n;
        if (r126 != null) goto L252;
    L253:
        Animator r127 = r105.f256086o;
        if (r127 == null) goto L258;
        if (r127.isRunning() == true) goto L273;
    L258:
        if (r125 == 2) goto L273;
        ObjectAnimator r128 = ObjectAnimator.ofFloat(r105.f256075d, View.ALPHA, new float[]{0.0f, 1.0f});
        r128.setDuration(500);
        r128.setInterpolator(new LinearInterpolator());
        r128.addListener(new com.bytedance.livesdk.ktvcommon.midi.view.b(r105));
        Unit r129 = Unit.INSTANCE;
        r105.f256085n = r128;
        ObjectAnimator r130 = ObjectAnimator.ofFloat(r105.f256075d, View.ALPHA, new float[]{1.0f, 0.0f});
        r130.setDuration(500);
        r130.setInterpolator(new LinearInterpolator());
        r130.addListener(new c(r105));
        r105.f256086o = r130;
        final Function0<Unit> r131 = new KtvMidiController$playBackgroundAnimation$3(r105);
        String r132 = com.bytedance.android.live.ktv.common.midi.c.f69840b;
        if (r132 != null) goto L263;
    L266:
        boolean r133 = true;
    L267:
        if (r133 == true) goto L273;
        Context r134 = r105.f256076e;
        if (r134 == null) goto L273;
        Intrinsics.checkNotNull(r134);
        FrescoLoader r135 = FrescoLoader.with(r134).load(r132).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        int r136 = com.bytedance.android.livesdk.chatroom.utils.f.f114457a;
        HitType r137 = null;
        r135.controllerListener(com.bytedance.android.livesdk.chatroom.utils.f.a(null, new KtvMidiController$loadImage$1(r131), 3)).into(r105.f256075d);
    L274:
        r105.f256078g = r110.f19485f;
        HitType r138 = r110.f19487h;
        if (r138 == null) goto L284;
        if (r138.compareTo(HitType.MISS) <= 0) goto L279;
        boolean r139 = true;
    L280:
        if (r139 == false) goto L282;
        r137 = r138;
    L282:
        if (r137 == null) goto L284;
        r105.f256080i = r137;
        goto L284
    L279:
        r139 = false;
        goto L280
    L263:
        if (r132.length() == 0) goto L266;
        r133 = false;
        goto L267
    L252:
        if (r126.isRunning() == true) goto L273;
    L272:
        r137 = null;
        r105.a();
        goto L274
    L243:
        if (r105.f256079h == false) goto L245;
        r105.f256084m.H();
        boolean r140 = true;
    L246:
        r124.b6(r120, r121, r140);
        goto L247
    L245:
        r140 = false;
        goto L246
    L237:
        if (r105.f256079h == false) goto L240;
        if (r121 >= r122) goto L240;
        r105.f256079h = false;
        goto L240
    L232:
        if (r105.f256079h == true) goto L235;
        if (r121 < r122) goto L235;
        r105.f256079h = true;
    L273:
        r137 = null;
        goto L274
    L308:
        return;
    L9:
        if (r112.getVisibility() != 0) goto L216;
        j r141 = r112.f256191l;
        if (r141 != null) goto L14;
    L16:
        boolean r142 = false;
    L17:
        if (r142 == false) goto L22;
        i r143 = r112.f256192m;
        if (r143 == null) goto L21;
        r143.c();
        goto L22
    L21:
        boolean r144 = false;
    L23:
        j r145 = r112.f256191l;
        if (r145 == null) goto L28;
        r145.c();
        i r146 = r112.f256192m;
        if (r146 == null) goto L28;
        r146.b();
        boolean r147 = true;
    L30:
        if (r144 == false) goto L60;
        if (r103 == true) goto L60;
        KtvMidiDataProcessor r148 = r112.f256188i;
        if (r148 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L35:
        r148.getClass();
        float r149 = Math.abs(r100 - r101);
        com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.d r150 = r148.f256177c;
        if (r149 > r150.f256228p) goto L39;
        KtvMidiDataProcessor.HitStatus r151 = KtvMidiDataProcessor.HitStatus.PERFECT;
    L46:
        if (r151 == KtvMidiDataProcessor.HitStatus.MISS) goto L48;
        boolean r152 = true;
    L49:
        if (r152 == true) goto L51;
    L52:
        if (r152 == false) goto L54;
    L56:
        if (r152 == false) goto L58;
        r112.f256205z.removeMessages(1);
        r112.f256205z.sendEmptyMessageDelayed(0, r112.E.f256221i);
        goto L60
    L58:
        r112.f256205z.removeMessages(0);
        r112.f256205z.sendEmptyMessageDelayed(1, r112.E.f256221i);
        goto L60
    L54:
        if (r112.f256200u == true) goto L56;
    L51:
        if (r112.f256200u == true) goto L60;
    L48:
        r152 = false;
        goto L49
    L39:
        if (r149 > r150.f256229q) goto L42;
        r151 = KtvMidiDataProcessor.HitStatus.GOOD;
        goto L46
    L42:
        if (r149 > r150.f256230r) goto L44;
        r151 = KtvMidiDataProcessor.HitStatus.NORMAL;
        goto L46
    L44:
        r151 = KtvMidiDataProcessor.HitStatus.MISS;
    L60:
        if (r147 == true) goto L62;
    L169:
        ConstraintLayout r153 = r112.f256184e;
        if (r153 != null) goto L172;
    L174:
        int r154 = r112.f256196q;
        com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.d r155 = r112.E;
        int r156 = r154 % r155.f256231s;
        r112.f256196q = r156 + 1;
        if (r156 == 0) goto L178;
        r113 = TuplesKt.to(Float.valueOf(r155.f256217e), Float.valueOf(r112.f256195p));
        goto L217
    L178:
        if (r100 >= r155.f256215c) goto L180;
    L183:
        int r157 = r112.f256197r + 1;
        r112.f256197r = r157;
        if (r157 >= r155.f256232t) goto L186;
        r113 = TuplesKt.to(Float.valueOf(r155.f256217e), Float.valueOf(r112.f256195p));
    L186:
        KSongToneView r158 = r112.f256183d;
        if (r158 != null) goto L189;
        r113 = TuplesKt.to(Float.valueOf(r155.f256217e), Float.valueOf(0.0f));
        goto L217
    L189:
        KtvMidiDataProcessor r159 = r112.f256188i;
        if (r159 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L192:
        int r160 = r112.E.f256219g;
        r159.getClass();
        Intrinsics.checkNotNullParameter(r158, "toneLines");
        int r161 = (int) r101;
        com.bytedance.livesdk.ktvcommon.midi.view.miditone.d r162 = r158.f256274h;
        int r163 = r162.f256287b;
        if (r161 < r163) goto L195;
        int r164 = r162.f256292g;
    L202:
        int r165 = r164 + r160;
        r112.f256195p = r165;
        k r166 = r112.f256189j;
        if (r166 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("animationController");
    L205:
        com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator r167 = r166.f256249c;
        if (r167 == null) goto L210;
        if (r167.isRunning() != true) goto L210;
    L212:
        boolean r168 = false;
    L213:
        if (r168 == false) goto L215;
        int r169 = r112.f256195p;
        r112.f256205z.removeMessages(2);
        r112.f256205z.sendMessage(r112.f256205z.obtainMessage(2, Integer.valueOf(r169)));
    L215:
        r113 = TuplesKt.to(Float.valueOf(r112.E.f256217e), Float.valueOf(r112.f256195p));
    L210:
        if (r112.f256194o == r165) goto L212;
        r168 = true;
        goto L213
    L195:
        int r170 = r162.f256286a;
        if (r161 != r170) goto L198;
        int r171 = r162.f256289d;
        int r172 = r162.f256292g;
    L201:
        r164 = r172 + r171;
        goto L202
    L198:
        if (r161 >= r170) goto L200;
        r171 = r162.f256289d;
        r172 = r162.f256292g;
        goto L201
    L200:
        r171 = (int) (r162.f256290e * (r163 - r161));
        r172 = r162.f256292g;
        goto L201
    L180:
        if (r100 > r155.f256216d) goto L183;
        r112.f256197r = 0;
        goto L186
    L172:
        if (r153.getVisibility() != 0) goto L174;
        KtvMidiPlayerView.R5(r112.f256184e);
        goto L174
    L62:
        if (r102 <= 0) goto L169;
        float r173 = r112.f256198s;
        if (r102 == r173) goto L169;
        if (r102 == r173) goto L174;
        if (r102 == 0.0f) goto L174;
        r112.f256198s = r102;
        ConstraintLayout r174 = r112.f256184e;
        if (r174 == null) goto L71;
        r174.setVisibility(0);
    L71:
        TextView r175 = r112.f256185f;
        if (r175 == null) goto L78;
        Typeface r176 = r175.getTypeface();
        if (r176 == null) goto L78;
        int r177 = 2;
        if (r176.getStyle() != 2) goto L79;
    L82:
        KtvMidiDataProcessor r178 = r112.f256188i;
        if (r178 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L85:
        r178.getClass();
        if (r102 < 100) goto L88;
        String r179 = "100";
    L89:
        TextView r180 = r112.f256185f;
        if (r180 == null) goto L92;
        CharSequence r181 = r180.getText();
    L94:
        if ((!Intrinsics.areEqual(r181, r179)) == false) goto L98;
        TextView r182 = r112.f256185f;
        if (r182 == null) goto L98;
        r182.setText(r179);
    L98:
        ImageView r183 = r112.f256186g;
        if (r183 == null) goto L101;
        r183.setVisibility(0);
    L101:
        TextView r184 = r112.f256185f;
        if (r184 == null) goto L104;
        r184.setBackground(null);
    L104:
        j r185 = r112.f256191l;
        if (r185 == null) goto L107;
        Integer r186 = Integer.valueOf(r185.getCurrentMode());
    L108:
        if (r186 != null) goto L111;
    L134:
        int r187 = r112.f256199t;
        if (r187 != 1) goto L137;
        float r188 = r112.f256198s;
        com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.d r189 = r112.E;
        if (r188 < r189.f256227o) goto L146;
        Pair<Integer, Integer> r190 = r189.f256236x;
    L147:
        int r191 = r190.component1().intValue();
        int r192 = r190.component2().intValue();
        ImageView r193 = r112.f256186g;
        if (r193 == null) goto L152;
        Drawable r194 = r193.getDrawable();
        if (r194 == null) goto L152;
        Drawable.ConstantState r195 = r194.getConstantState();
    L153:
        Drawable r196 = r112.getContext().getDrawable(r191);
        if (r196 == null) goto L156;
        Drawable.ConstantState r197 = r196.getConstantState();
    L158:
        if ((!Intrinsics.areEqual(r195, r197)) == false) goto L162;
        ImageView r198 = r112.f256186g;
        if (r198 == null) goto L162;
        r198.setImageResource(r191);
    L162:
        TextView r199 = r112.f256185f;
        if (r199 != null) goto L165;
    L166:
        TextView r200 = r112.f256185f;
        if (r200 == null) goto L174;
        r200.setTextColor(r192);
        goto L174
    L165:
        if (r199.getCurrentTextColor() == r192) goto L174;
    L156:
        r197 = null;
    L152:
        r195 = null;
        goto L153
    L146:
        r190 = r189.f256237y;
        goto L147
    L137:
        if (r187 != 2) goto L174;
        float r201 = r112.f256198s;
        com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.d r202 = r112.E;
        if (r201 < r202.f256227o) goto L142;
        r190 = r202.f256238z;
        goto L147
    L142:
        r190 = r202.A;
        goto L147
    L111:
        if (r186.intValue() != 2) goto L134;
        Pair<Integer, Integer> r203 = r112.E.B;
        int r204 = r203.component1().intValue();
        int r205 = r203.component2().intValue();
        ImageView r206 = r112.f256186g;
        if (r206 == null) goto L117;
        Drawable r207 = r206.getDrawable();
        if (r207 == null) goto L117;
        Drawable.ConstantState r208 = r207.getConstantState();
    L118:
        Drawable r1100 = r112.getContext().getDrawable(r204);
        if (r1100 == null) goto L121;
        Drawable.ConstantState r1101 = r1100.getConstantState();
    L123:
        if ((!Intrinsics.areEqual(r208, r1101)) == false) goto L127;
        ImageView r209 = r112.f256186g;
        if (r209 == null) goto L127;
        r209.setImageResource(r204);
    L127:
        TextView r210 = r112.f256185f;
        if (r210 != null) goto L130;
    L131:
        TextView r211 = r112.f256185f;
        if (r211 == null) goto L174;
        r211.setTextColor(r205);
        goto L174
    L130:
        if (r210.getCurrentTextColor() == r205) goto L174;
    L121:
        r1101 = null;
    L117:
        r208 = null;
        goto L118
    L107:
        r186 = null;
        goto L108
    L92:
        r181 = null;
        goto L94
    L88:
        r179 = new DecimalFormat(r178.f256177c.f256225m).format(Float.valueOf(r102));
    L79:
        TextView r212 = r112.f256185f;
        if (r212 == null) goto L82;
        r212.setTypeface(Typeface.defaultFromStyle(r177));
    L78:
        r177 = 2;
    L28:
        r147 = false;
    L22:
        r144 = true;
        goto L23
    L14:
        if (r141.getCurrentMode() != 1) goto L16;
        r142 = true;
        goto L17
    }

    @Override // com.bytedance.livesdk.ktvcommon.midi.view.a
    public final void y0(zk6.b r110, com.bytedance.livesdk.ktvimpl.base.midi.d r111) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        j r112 = r111;
        if (r111 != null) goto L6;
        r112 = new KtvMidiStrategy();
    L6:
        if (r112.getCurrentMode() != 2) goto L12;
        UIUtils.updateLayout(this, -3, -1);
        UIUtils.updateLayout(this.f256053d, -3, -1);
        UIUtils.updateLayout(this.f256050a, -3, -1);
        KtvMidiHitEffectView r100 = this.f256050a;
        if (r100 == null) goto L12;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L12;
        r101.width = s1.f(144.0f);
    L12:
        KtvMidiPlayerView r102 = this.f256051b;
        if (r102 == null) goto L63;
        Intrinsics.checkNotNullParameter(r110, "midiDataHolder");
        Intrinsics.checkNotNullParameter(r112, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r102.f256190k = r110;
        r102.f256191l = r112;
        r102.f256188i = new KtvMidiDataProcessor(r102.E, r110);
        j r113 = r102.f256191l;
        if (r113 == null) goto L62;
        int r114 = r113.getCurrentMode();
        KSongToneView r103 = r102.f256183d;
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L19;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
    L21:
        if ((r105 instanceof ViewGroup.LayoutParams) == false) goto L25;
        r104 = r105;
    L25:
        if (r114 == 1) goto L47;
        if (r114 == 2) goto L33;
        KSongToneView r106 = r102.f256183d;
        if (r106 == null) goto L30;
        r106.a(r102.E.f256213a.getFirst().longValue(), r102.E.f256213a.getSecond().longValue());
    L30:
        ConstraintLayout r107 = r102.f256184e;
        if (r107 == null) goto L53;
        r107.setVisibility(8);
    L53:
        j r108 = r102.f256191l;
        if (r108 == null) goto L59;
        r108.c();
        if (r114 != 2) goto L58;
        int r115 = r102.E.f256220h;
    L60:
        int r116 = 0 - r115;
    L61:
        com.bytedance.android.live.ktv.common.midi.e.b("KtvMidiPlayerView", "initView topAdapter : " + r116);
        goto L62
    L58:
        r116 = s1.f(19.0f) - r102.E.f256220h;
        goto L61
    L59:
        r115 = r102.E.f256220h;
        goto L60
    L33:
        if (r104 == null) goto L35;
        r104.width = -1;
    L35:
        KSongToneView r109 = r102.f256183d;
        if (r109 == null) goto L38;
        r109.setLayoutParams(r104);
    L38:
        KSongToneView r117 = r102.f256183d;
        if (r117 == null) goto L41;
        com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.d r118 = r102.E;
        r117.c(r118.f256234v, r118.f256233u);
    L41:
        KSongToneView r119 = r102.f256183d;
        if (r119 == null) goto L44;
        r119.a(r102.E.f256213a.getFirst().longValue(), r102.E.f256213a.getSecond().longValue());
    L44:
        ConstraintLayout r120 = r102.f256184e;
        if (r120 == null) goto L53;
        r120.setVisibility(8);
        goto L53
    L47:
        KSongToneView r121 = r102.f256183d;
        if (r121 == null) goto L50;
        r121.a(r102.E.f256214b.getFirst().longValue(), r102.E.f256214b.getSecond().longValue());
    L50:
        View r122 = r102.f256187h;
        if (r122 == null) goto L53;
        r122.setVisibility(8);
        goto L53
    L19:
        r105 = null;
    L62:
        r102.post(new com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.h(r102, new com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.i(r102)));
    L63:
        e r123 = this.f256055f;
        r123.getClass();
        Intrinsics.checkNotNullParameter(r112, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r123.f256084m = r112;
        MidiSkinDressInfo r124 = r112.z();
        if (r124 == null) goto L66;
        r112.y(r124);
    L66:
        KtvMidiPlayerView r125 = this.f256051b;
        if (r125 == null) goto L69;
        r125.setScoreInterval(vm2.h.D());
    L69:
        postDelayed(new g(this), 100);
    }

    public KtvMidiView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        e r103 = new e();
        this.f256055f = r103;
        this.f256057h = KtvSubElement.MIDI;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_ktv_midi_view, this);
        this.f256053d = (ViewGroup) findViewById(R.id.ktv_component_midi_view_cl);
        this.f256051b = (KtvMidiPlayerView) findViewById(R.id.component_midi_view);
        this.f256052c = (KtvMidiHitParticleView) findViewById(R.id.component_hit_animation);
        this.f256050a = (KtvMidiHitEffectView) findViewById(R.id.component_hit_type_display);
        this.f256054e = (HSImageView) findViewById(R.id.ktv_midi_bg);
        KtvMidiHitParticleView r104 = this.f256052c;
        if (r104 == null) goto L5;
        r104.setAnimGap(0);
    L5:
        KtvMidiHitEffectView r105 = this.f256050a;
        KtvMidiHitParticleView r106 = this.f256052c;
        KtvMidiPlayerView r107 = this.f256051b;
        HSImageView r108 = this.f256054e;
        Context r109 = getContext();
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.f256072a = r105;
        r103.f256073b = r106;
        r103.f256074c = r107;
        r103.f256075d = r108;
        r103.f256076e = r109;
        if (r105 == null) goto L8;
        r105.Z5(r103.f256084m);
    L8:
        if (r106 == null) goto L11;
        r106.a(r103.f256084m);
        return;
    }

    public /* synthetic */ KtvMidiView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
