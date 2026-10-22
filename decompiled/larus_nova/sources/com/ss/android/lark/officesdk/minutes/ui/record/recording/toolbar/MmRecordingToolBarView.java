package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mwb.g;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingToolbarViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "recordingState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "pauseResumeVisible", "", "setBottomPadding", "", GXTemplateKey.FLEXBOX_PADDING, "bind", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "renderResumePauseButton", "ensureBinding", "uiLaunchMode", "subscribeDuration", "subscribeAudioVolume", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingToolBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f436645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MmRecordingUILaunchMode f436646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MMRecordingState f436647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f436648d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436649a = null;

        static {
            int[] r100 = new int[MMRecordingState.values().length];
            r100[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436649a = r100;
        }
    }

    public MmRecordingToolBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmRecordingToolBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setBottomPadding(int r100) {
        setPadding(0, 0, 0, r100);
    }

    public static final void R5(MmRecordingToolBarView r100, MmRecordingViewModel r101) {
        r100.getClass();
        e r102 = e.f436896a;
        MmRecordingUILaunchMode r103 = r101.getUiLaunchMode();
        r102.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r104 = e.b(r103).getDrawable();
        int r105 = a.f436649a[r100.f436647c.ordinal()];
        boolean r106 = true;
        g r107 = null;
        if (r105 != 1) goto L5;
        g r108 = r100.f436645a;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L23:
        r108.f516077f.setImageResource(r104.b());
        g r109 = r100.f436645a;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L26:
        r109.f516073b.g();
    L27:
        MMRecordingState r110 = r100.f436647c;
        int r111 = 0;
        if (r110 != MMRecordingState.RECORDING) goto L30;
    L33:
        g r112 = r100.f436645a;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L36:
        ImageView r113 = r112.f516077f;
        if (r100.f436648d == true) goto L40;
        r111 = 8;
    L40:
        r113.setVisibility(r111);
        g r114 = r100.f436645a;
        if (r114 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L43:
        r114.f516077f.setEnabled(r106);
        g r115 = r100.f436645a;
        if (r115 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L47:
        r107.f516077f.setAlpha(1.0f);
        return;
    L46:
        r107 = r115;
        goto L47
    L30:
        if (r110 == MMRecordingState.PAUSED) goto L33;
        r106 = false;
        goto L33
    L5:
        if (r105 == 2) goto L13;
        g r116 = r100.f436645a;
        if (r116 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L9:
        r116.f516077f.setImageResource(r104.j());
        g r117 = r100.f436645a;
        if (r117 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L12:
        r117.f516073b.b();
        goto L27
    L13:
        g r118 = r100.f436645a;
        if (r118 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L16:
        r118.f516077f.setImageResource(r104.j());
        g r119 = r100.f436645a;
        if (r119 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L19:
        r119.f516073b.b();
        goto L27
    }

    public final void S5(final MmRecordingViewModel r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        MmRecordingUILaunchMode r102 = r100.getUiLaunchMode();
        if (this.f436645a != null) goto L5;
    L7:
        removeAllViews();
        e.f436896a.getClass();
        g r103 = e.b(r102).getLayout().v(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r102)), this);
        this.f436645a = r103;
        this.f436646b = r102;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L10:
        r103.f516074c.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).o(getContext()));
        g r104 = this.f436645a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L13:
        r104.f516075d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).c(getContext()));
    L14:
        g r105 = this.f436645a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L17:
        h.a(r105.f516077f, new MmRecordingToolBarView$bind$1(this, r100));
        g r106 = this.f436645a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L20:
        r106.f516078g.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).x(getContext()));
        g r107 = this.f436645a;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L23:
        h.a(r107.f516078g, new MmRecordingToolBarView$bind$2(r100));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingToolBarView$subscribeAudioVolume$1.INSTANCE, new MmRecordingToolBarView$subscribeAudioVolume$2(this, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingToolBarView$subscribeDuration$1.INSTANCE, new MmRecordingToolBarView$subscribeDuration$2(this, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingToolBarView$bind$3.INSTANCE, new MmRecordingToolBarView$bind$4(this, r100, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingToolBarView$bind$5.INSTANCE, new MmRecordingToolBarView$bind$6(this, r100, null));
        return;
    L5:
        if (this.f436646b != r102) goto L7;
        goto L7
    }

    public MmRecordingToolBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f436647c = MMRecordingState.INIT;
        this.f436648d = true;
    }

    public /* synthetic */ MmRecordingToolBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
