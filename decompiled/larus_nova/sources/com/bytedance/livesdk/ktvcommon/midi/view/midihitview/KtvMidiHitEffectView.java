package com.bytedance.livesdk.ktvcommon.midi.view.midihitview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.f;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import com.bytedance.livesdk.ktvcommon.midi.view.j;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/KtvMidiHitEffectView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", RemoteMessageConst.Notification.VISIBILITY, "", "setAllViewsVisibility", "Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/KtvMidiHitResourceManager;", "f", "Lkotlin/Lazy;", "getResourceManager", "()Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/KtvMidiHitResourceManager;", "resourceManager", "Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/MidiHitAnimationController;", ce.f26391f, "getAnimationController", "()Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/MidiHitAnimationController;", "animationController", "Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/a;", "h", "getConfig", "()Lcom/bytedance/livesdk/ktvcommon/midi/view/midihitview/a;", "config", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiHitEffectView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f256134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f256135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f256136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f256137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f256138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f256139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f256140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f256141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f256142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f256143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f256144k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMidiHitEffectView f256145a;

        public a(KtvMidiHitEffectView r100) {
            this.f256145a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvMidiHitEffectView.Y5(this.f256145a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, Typeface> f256146a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f256147b = null;

        public c() {
        }

        static {
            f256147b = new c();
            f256146a = new LinkedHashMap();
        }
    }

    static {
    }

    public KtvMidiHitEffectView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvMidiHitEffectView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final MidiHitAnimationController getAnimationController() {
        return (MidiHitAnimationController) this.f256140g.getValue();
    }

    private final com.bytedance.livesdk.ktvcommon.midi.view.midihitview.a getConfig() {
        return (com.bytedance.livesdk.ktvcommon.midi.view.midihitview.a) this.f256141h.getValue();
    }

    private final KtvMidiHitResourceManager getResourceManager() {
        return (KtvMidiHitResourceManager) this.f256139f.getValue();
    }

    public final void onDetach() {
        this.f256143j.dispose();
        if (this.f256134a != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L11;
        getAnimationController().a();
        setAllViewsVisibility(4);
    L11:
        getAnimationController().a();
        this.f256142i = null;
        return;
    L5:
        if (this.f256135b == null) goto L7;
        r100 = true;
        goto L8
    }

    public static final /* synthetic */ MidiHitAnimationController R5(KtvMidiHitEffectView r100) {
        return r100.getAnimationController();
    }

    public static final /* synthetic */ TextView S5(KtvMidiHitEffectView r100) {
        TextView r101 = r100.f256136c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L5:
        return r101;
    }

    public static final /* synthetic */ com.bytedance.livesdk.ktvcommon.midi.view.midihitview.a T5(KtvMidiHitEffectView r100) {
        return r100.getConfig();
    }

    public static final /* synthetic */ HSImageView U5(KtvMidiHitEffectView r100) {
        HSImageView r101 = r100.f256135b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hitTypeImage");
    L5:
        return r101;
    }

    public static final /* synthetic */ KtvMidiHitResourceManager V5(KtvMidiHitEffectView r100) {
        return r100.getResourceManager();
    }

    public static final void Y5(KtvMidiHitEffectView r100) {
        if (r100.f256134a != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L40;
        r100.f256134a = (HSImageView) r100.findViewById(R.id.hit_type_bg);
        r100.f256135b = (HSImageView) r100.findViewById(R.id.hit_type_iv);
        r100.f256136c = (TextView) r100.findViewById(R.id.combo_time);
        r100.f256137d = (TextView) r100.findViewById(R.id.combo_time_v2);
        r100.f256138e = (HSImageView) r100.findViewById(R.id.hit_advanced_type_iv);
        r100.setAllViewsVisibility(4);
        c r102 = c.f256147b;     // Catch: Exception -> L22
        Context r103 = r100.getContext();     // Catch: Exception -> L22
        r102.getClass();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter("font/ttlive_ktv_midi_combo_font.ttf", "path");     // Catch: Exception -> L22
        Map<String, Typeface> r104 = c.f256146a;     // Catch: Exception -> L22
        Typeface r105 = (Typeface) ((LinkedHashMap) r104).get("font/ttlive_ktv_midi_combo_font.ttf");     // Catch: Exception -> L22
        if (r105 != null) goto L14;
        r105 = Typeface.createFromAsset(r103.getAssets(), "font/ttlive_ktv_midi_combo_font.ttf");     // Catch: Exception -> L22
        r104.put("font/ttlive_ktv_midi_combo_font.ttf", r105);     // Catch: Exception -> L22
    L14:
        TextView r106 = r100.f256136c;     // Catch: Exception -> L22
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");     // Catch: Exception -> L22
    L17:
        r106.setTypeface(r105);     // Catch: Exception -> L22
        TextView r107 = r100.f256137d;     // Catch: Exception -> L22
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("comboTextV2");     // Catch: Exception -> L22
    L20:
        r107.setTypeface(r105);     // Catch: Exception -> L22
    L25:
        if (r100.f256144k != 0) goto L39;
        TextView r108 = r100.f256136c;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L29:
        r100.f256144k = (int) r108.getPaint().measureText("x444");
        TextView r109 = r100.f256136c;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L32:
        r109.getLayoutParams().width = r100.f256144k;
        TextView r110 = r100.f256137d;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("comboTextV2");
    L35:
        r110.getLayoutParams().width = r100.f256144k;
        return;
    L39:
        return;
    L22:
        e = move-exception;
        ALogger.e("KtvMidiHitEffectView", "加载连击字体失败: " + e.getMessage());
        goto L25
    L40:
        return;
    L5:
        if (r100.f256135b == null) goto L7;
        r101 = true;
        goto L8
    }

    private final void setAllViewsVisibility(int r100) {
        HSImageView r101 = this.f256134a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hitBackground");
    L5:
        r101.setVisibility(r100);
        HSImageView r102 = this.f256135b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("hitTypeImage");
    L8:
        r102.setVisibility(r100);
        TextView r103 = this.f256136c;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L11:
        r103.setVisibility(r100);
        TextView r104 = this.f256137d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("comboTextV2");
    L14:
        r104.setVisibility(r100);
        HSImageView r105 = this.f256138e;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("advancedHitImage");
    L17:
        r105.setVisibility(r100);
    }

    public final void Z5(j r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (this.f256142i != r100) goto L5;
        return;
    L5:
        this.f256142i = r100;
        boolean r101 = true;
        if (r100.getCurrentMode() == 1) goto L8;
        return;
    L8:
        if (this.f256134a != null) goto L10;
    L12:
        r101 = false;
    L13:
        if (r101 == false) goto L49;
        TextView r102 = this.f256136c;
        if (r102 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L19:
        if (r102.getTextSize() == getConfig().f256169j) goto L27;
        TextView r103 = this.f256136c;
        if (r103 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L23:
        r103.setTextSize(getConfig().f256169j);
        TextView r104 = this.f256137d;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("comboTextV2");
    L26:
        r104.setTextSize(getConfig().f256169j);
    L27:
        TextView r105 = this.f256136c;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L30:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L46;
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        if (((ViewGroup.MarginLayoutParams) r107).bottomMargin == getConfig().f256170k) goto L36;
        ((ViewGroup.MarginLayoutParams) r107).bottomMargin = getConfig().f256170k;
    L36:
        if (r107.getMarginEnd() == getConfig().f256171l) goto L38;
        r107.setMarginEnd(getConfig().f256171l);
    L38:
        TextView r108 = this.f256136c;
        if (r108 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L41:
        r108.setLayoutParams(r107);
        TextView r109 = this.f256137d;
        if (r109 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("comboTextV2");
    L44:
        r109.setLayoutParams(r107);
        return;
    L46:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L49:
        return;
    L10:
        if (this.f256135b == null) goto L12;
        goto L12
    }

    public KtvMidiHitEffectView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f256139f = LazyKt.lazy(new KtvMidiHitEffectView$resourceManager$2(r100));
        this.f256140g = LazyKt.lazy(new KtvMidiHitEffectView$animationController$2(this));
        this.f256141h = LazyKt.lazy(new KtvMidiHitEffectView$config$2(r100));
        this.f256143j = new CompositeDisposable();
        setLayerType(2, null);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_ktv_midi_hit_effect_view, this);
        post(new a(this));
    }

    public final void b6(HitType r100, final int r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "hitType");
        if (this.f256134a != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        j r103 = this.f256142i;
        if (r103 != null) goto L13;
        return;
    L13:
        String r111 = r103.a(r100, r110);
        if (r111 == null) goto L67;
        j r104 = this.f256142i;
        if (r104 == null) goto L20;
        final String r105 = r104.b(r100);
        if (r105 == null) goto L20;
    L21:
        getAnimationController().a();
        int r106 = com.bytedance.livesdk.ktvcommon.midi.view.midihitview.b.f256174a[r100.ordinal()];
        if (r106 != 1) goto L24;
    L46:
        HSImageView r107 = this.f256134a;
        if (r107 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("hitBackground");
    L49:
        r107.setVisibility(4);
        HSImageView r108 = this.f256138e;
        if (r108 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("advancedHitImage");
    L52:
        r108.setVisibility(4);
        TextView r109 = this.f256136c;
        if (r109 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("comboText");
    L55:
        r109.setVisibility(4);
        TextView r112 = this.f256137d;
        if (r112 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("comboTextV2");
    L58:
        r112.setVisibility(4);
        KtvMidiHitResourceManager r113 = getResourceManager();
        HSImageView r114 = this.f256135b;
        if (r114 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("hitTypeImage");
    L61:
        r113.a(r114, r111, new KtvMidiHitEffectView$showGoodOrGreatEffect$1(this));
        return;
    L24:
        if (r106 == 2) goto L46;
        if (r106 == 3) goto L28;
        ALogger.w("KtvMidiHitEffectView", "未知击中类型: " + r100);
        return;
    L28:
        j r115 = this.f256142i;
        if (r115 == null) goto L68;
        setAllViewsVisibility(4);
        r115.H();
        if (r101 < r115.C()) goto L37;
        KtvMidiHitResourceManager r116 = getResourceManager();
        HSImageView r117 = this.f256138e;
        if (r117 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("advancedHitImage");
    L36:
        final Function0<Unit> r118 = new KtvMidiHitEffectView$handlePerfectHit$1(this, r105, r101);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r118, "onLoaded");
        FrescoLoader r119 = FrescoLoader.with(r116.f256148a).load(r111).actualScaleType(ImageView.ScaleType.FIT_CENTER);
        int r120 = f.f114457a;
        r119.controllerListener(f.a(null, new KtvMidiHitResourceManager$loadAdvancedHitImage$2(r118), 3)).into(r117);
        return;
    L37:
        if (r101 <= 1) goto L42;
        KtvMidiHitResourceManager r121 = getResourceManager();
        HSImageView r122 = this.f256135b;
        if (r122 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("hitTypeImage");
    L41:
        r121.a(r122, r111, new KtvMidiHitEffectView$handlePerfectHit$2(this, r101));
        return;
    L42:
        KtvMidiHitResourceManager r123 = getResourceManager();
        HSImageView r124 = this.f256135b;
        if (r124 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("hitTypeImage");
    L45:
        r123.a(r124, r111, new KtvMidiHitEffectView$handlePerfectHit$3(this));
        return;
    L68:
        return;
    L20:
        r105 = getConfig().f256172m;
        goto L21
    L67:
        return;
    L5:
        if (this.f256135b == null) goto L7;
        r102 = true;
        goto L8
    }

    public /* synthetic */ KtvMidiHitEffectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
