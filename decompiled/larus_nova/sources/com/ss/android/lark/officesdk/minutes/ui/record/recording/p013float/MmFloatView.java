package com.ss.android.lark.officesdk.minutes.ui.record.recording.p013float;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import bwb.b;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingWindowMode;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.e;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmViewFloatBinding;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar.MmAudioWaveBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.g;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import uvb.c;
import yub.d;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010&*\u0004\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0016H\u0014J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\u00162\u0006\u00101\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/float/MmFloatView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/databinding/OfficeSdkMmViewFloatBinding;", "currentState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "pauseResumeVisible", "", "hardwareRecordingSession", "Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingSession;", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "onCloseWindow", "Lkotlin/Function0;", "", "getOnCloseWindow", "()Lkotlin/jvm/functions/Function0;", "setOnCloseWindow", "(Lkotlin/jvm/functions/Function0;)V", "feishuDrawableProvider", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIDrawableProvider;", "getFeishuDrawableProvider", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIDrawableProvider;", "feishuDrawableProvider$delegate", "Lkotlin/Lazy;", "bindSession", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;", "getRecordingLaunchContext", "availableActivity", "Landroid/app/Activity;", "trackFloatWindowClick", "click", "", "onDetachedFromWindow", "updateDuration", "durationMs", "", "updateVolume", ITTVideoEngineEventSource.KEY_VOLUME, "updateState", "state", "updateResumePauseButton", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmFloatView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSdkMmViewFloatBinding f436342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MMRecordingState f436343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f436344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f436345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoroutineScope f436346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f436347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f436348g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436349a = null;

        static {
            int[] r100 = new int[MMRecordingState.values().length];
            r100[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MMRecordingState.DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f436349a = r100;
        }
    }

    public MmFloatView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmFloatView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.e getFeishuDrawableProvider() {
        return (com.ss.android.lark.officesdk.minutes.ui.style.contract.e) this.f436348g.getValue();
    }

    private final Context getRecordingLaunchContext() {
        d r100 = d.f569261a;
        Activity r101 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r101 != null) goto L5;
    L12:
        r101 = null;
    L13:
        if (r101 == null) goto L16;
        return r101;
    L16:
        return getContext();
    L5:
        if (r101.isFinishing() == false) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
    L7:
        if (r101.isDestroyed() == true) goto L9;
        r102 = true;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = b.f21271a;
        b.g(MmUiLogScene.FLOAT, "onDetachedFromWindow", null, null, 12);
        CoroutineScope r101 = this.f436346e;
        if (r101 == null) goto L5;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L5:
        this.f436346e = null;
    }

    public final Function0<Unit> getOnCloseWindow() {
        return this.f436347f;
    }

    public static final /* synthetic */ Context R5(MmFloatView r100) {
        return r100.getRecordingLaunchContext();
    }

    public final void U5(final MmRecordingSession r110) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        int r100 = b.f21271a;
        b.g(MmUiLogScene.FLOAT, "bindSession", "context=".concat(getContext().getClass().getName()), null, 8);
        CoroutineScope r101 = this.f436346e;
        boolean r102 = true;
        if (r101 == null) goto L5;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L5:
        CoroutineScope r103 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f436346e = r103;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r110.f434112p, new MmFloatView$bindSession$1(this, null)), r103);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r110.f434111o, new MmFloatView$bindSession$2(this, null)), r103);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r110.f434098b.L().h(), new MmFloatView$bindSession$3(this, r110, null)), r103);
        k r104 = r110.f434102f;
        if (r104 == null) goto L8;
        MmRecordingSource r105 = r104.f495846a;
    L10:
        if (r105 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L13;
        r102 = false;
    L13:
        BuildersKt.launch$default(r103, null, null, new MmFloatView$bindSession$4(r110, this, r102, null), 3, null);
        h.a(this.f436342a.f435604d, new MmFloatView$bindSession$5(this, r110));
        MmRecordingWindowMode r106 = MmRecordingWindowMode.FLOAT_WINDOW;
        Intrinsics.checkNotNullParameter(r106, "mode");
        MmRecordingRepo r107 = r110.f();
        if (r107 == null) goto L20;
        MmRecordingMetaRepo r108 = r107.w();
        if (r108 == null) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r109 = r108.l();
        if (r109 == null) goto L20;
        r109.N(r106);
    L20:
        h.a(this, new MmFloatView$bindSession$6(this, r110));
        return;
    L8:
        r105 = null;
        goto L10
    }

    public final void setOnCloseWindow(Function0<Unit> r100) {
        this.f436347f = r100;
    }

    public static final void T5(MmFloatView r100, MMRecordingState r101) {
        r100.f436343b = r101;
        if (r101 != MMRecordingState.IDLE) goto L7;
        Function0<Unit> r102 = r100.f436347f;
        if (r102 == null) goto L45;
        r102.invoke();
        return;
    L45:
        return;
    L7:
        int r103 = 0;
        if (r100.f436342a.f435604d.getVisibility() == 0) goto L10;
        r100.f436342a.f435604d.setVisibility(0);
    L10:
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r104 = r100.getFeishuDrawableProvider();
        if (r104 == null) goto L13;
        r100.f436342a.f435604d.setImageTintList(ColorStateList.valueOf(UIUtils.getColor(r100.getContext(), r104.h())));
    L13:
        int r105 = a.f436349a[r101.ordinal()];
        boolean r106 = true;
        if (r105 == 1) goto L28;
        int r107 = R.drawable.ud_icon_mic_ai_filled;
        if (r105 != 2) goto L18;
        r100.f436342a.f435605e.b();
        r100.f436342a.f435604d.setEnabled(true);
        AppCompatImageView r108 = r100.f436342a.f435604d;
        if (r104 == null) goto L27;
        r107 = r104.j();
    L27:
        r108.setImageResource(r107);
    L34:
        if (r101 != MMRecordingState.RECORDING) goto L36;
    L39:
        AppCompatImageView r109 = r100.f436342a.f435604d;
        if (r100.f436344c == true) goto L43;
        r103 = 8;
    L43:
        r109.setVisibility(r103);
        r100.f436342a.f435604d.setEnabled(r106);
        r100.f436342a.f435604d.setAlpha(1.0f);
        return;
    L36:
        if (r101 == MMRecordingState.PAUSED) goto L39;
        r106 = false;
        goto L39
    L18:
        if (r105 != 3) goto L34;
        r100.f436342a.f435605e.b();
        r100.f436342a.f435604d.setEnabled(false);
        AppCompatImageView r110 = r100.f436342a.f435604d;
        if (r104 == null) goto L23;
        r107 = r104.j();
    L23:
        r110.setImageResource(r107);
        goto L34
    L28:
        r100.f436342a.f435605e.g();
        r100.f436342a.f435604d.setEnabled(true);
        AppCompatImageView r111 = r100.f436342a.f435604d;
        if (r104 == null) goto L31;
        int r112 = r104.b();
    L32:
        r111.setImageResource(r112);
        goto L34
    L31:
        r112 = R.drawable.ud_icon_pause_filled;
        goto L32
    }

    public MmFloatView(final Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f436343b = MMRecordingState.INIT;
        this.f436344c = true;
        this.f436348g = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MmFloatView$feishuDrawableProvider$2(r110));
        LayoutInflater.from(r110).inflate(R.layout.office_sdk_mm_view_float, this);
        int r113 = R.id.gradientLeft;
        View r114 = ViewBindings.findChildViewById(this, R.id.gradientLeft);
        if (r114 == null) goto L20;
        r113 = R.id.gradientRight;
        View r100 = ViewBindings.findChildViewById(this, R.id.gradientRight);
        if (r100 == null) goto L20;
        r113 = R.id.ivResumePause;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ivResumePause);
        if (r101 == null) goto L20;
        MmAudioWaveBarView r102 = (MmAudioWaveBarView) ViewBindings.findChildViewById(this, R.id.recordWaveBarView);
        if (r102 == null) goto L18;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.tvDuration);
        if (r103 == null) goto L17;
        this.f436342a = new OfficeSdkMmViewFloatBinding(this, r114, r100, r101, r102, r103);
        if (getId() != (-1)) goto L15;
        setId(R.id.mmFloatView);
    L15:
        int r104 = uvb.b.f551863a;
        uvb.a.b(this, c.Y);
        uvb.b.a(this, R.id.ivResumePause, c.Z);
        uvb.b.a(this, R.id.tvDuration, c.f551866a0);
        uvb.b.a(this, R.id.recordWaveBarView, c.f551868b0);
        setLayoutParams(new ConstraintLayout.LayoutParams(UIUtils.dp2px(r110, 78.0f), UIUtils.dp2px(r110, 96.0f)));
        g r115 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r110);
        setBackground(r115.d(r110));
        r114.setBackground(r115.g(r110));
        r100.setBackground(r115.e(r110));
        return;
    L17:
        r113 = R.id.tvDuration;
        goto L20
    L18:
        r113 = R.id.recordWaveBarView;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public static final void S5(MmFloatView r100, MmRecordingSession r101, String r102) {
        r100.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.e r103 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.e) r101.f434098b.N().f435425d.getValue();
        String r104 = r101.e();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "click");
        if (r103.f435437a.d(r104) == true) goto L5;
        lvb.a.b("MmRecordFloatWindowTracker", "[trackClick] commonParam invalid, sessionId=" + r104 + ", click=" + r102);
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r105 = r103.f435437a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r106 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r106.e("click", r102);
        r105.g(r104, "vc_record_float_window_click", r106.a());
    }

    public /* synthetic */ MmFloatView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
