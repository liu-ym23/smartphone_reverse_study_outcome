package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.i;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import iub.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J \u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0002J(\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u0012J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u00020\u0015J\b\u00101\u001a\u00020\u0015H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00063"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTopBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/MmRecordingTopPaddingTarget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingTopBarViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "hasShownAudioSaveBoarding", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "onCloseClick", "Lkotlin/Function0;", "", "getOnCloseClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClick", "(Lkotlin/jvm/functions/Function0;)V", "setTopPadding", GXTemplateKey.FLEXBOX_PADDING, "bind", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navRectProvider", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "ensureBinding", "uiLaunchMode", WidgetService.PARAM_FRAGMENT, "subscribeData", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "showAudioSaveBoardingBubble", "initViews", "shouldShowMoreEntry", "createTopBarCapabilityContext", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/MmTopBarCapabilityContext;", "handleShareClick", "showTitleInBar", "hideTitleInBar", "onDetachedFromWindow", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingTopBarView extends ConstraintLayout implements com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f436650f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f436651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MmRecordingUILaunchMode f436652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f436653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f436654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f436655e;

    public static final class a {
    }

    static {
    }

    public MmRecordingTopBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmRecordingTopBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h r100 = this.f436651a;
        if (r100 == null) goto L8;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L6:
        r100.f516082c.animate().cancel();
        return;
    }

    public final Function0<Unit> getOnCloseClick() {
        return this.f436655e;
    }

    public final void setOnCloseClick(Function0<Unit> r100) {
        this.f436655e = r100;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a
    public void setTopPadding(int r100) {
        setPadding(0, r100, 0, 0);
    }

    public static i S5(MmRecordingViewModel r100, uub.b r101) {
        boolean r102 = false;
        if (r100.hostBridge() == null) goto L5;
        boolean r103 = true;
    L6:
        MmRecordingSource r104 = null;
        if (r101 == null) goto L9;
        Rect r105 = r101.p0();
    L10:
        if (r105 == null) goto L12;
        r102 = true;
    L12:
        MmRecordingSession r106 = r100.getSession();
        if (r106 == null) goto L18;
        k r107 = r106.f434102f;
        if (r107 == null) goto L18;
        r104 = r107.f495846a;
    L18:
        return new i(r103, r102, r104);
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public MmRecordingTopBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ MmRecordingTopBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void R5(final MmRecordingViewModel r100, MmRecordingFragment r101, uub.b r102, MmRecordingFragment r110) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        this.f436654d = r110;
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        e r111 = e.f436896a;
        MmRecordingUILaunchMode r103 = r100.getUiLaunchMode();
        r111.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.c r112 = e.b(r103).getCapability();
        i r104 = S5(r100, r102);
        int r105 = 0;
        if (r112.e() == true) goto L5;
    L7:
        boolean r113 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        MmRecordingUILaunchMode r106 = r100.getUiLaunchMode();
        if (this.f436651a != null) goto L11;
    L13:
        removeAllViews();
        this.f436651a = e.b(r106).getLayout().e(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r106)), this);
        this.f436652b = r106;
    L14:
        com.ss.android.lark.officesdk.minutes.ui.style.contract.c r107 = e.b(r100.getUiLaunchMode()).getCapability();
        h r108 = null;
        i r109 = S5(r100, null);
        h r114 = this.f436651a;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L17:
        ImageView r115 = r114.f516087h;
        r107.b(r109);
        r115.setVisibility(8);
        h r116 = this.f436651a;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L20:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r116.f516081b, new MmRecordingTopBarView$initViews$1(this));
        h r117 = this.f436651a;
        if (r117 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L23:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r117.f516086g, new MmRecordingTopBarView$initViews$2(r100, this));
        h r118 = this.f436651a;
        if (r118 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L26:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r118.f516083d, new MmRecordingTopBarView$initViews$3(r100, this));
        h r119 = this.f436651a;
        if (r119 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L29:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r119.f516084e, new MmRecordingTopBarView$initViews$4(r100, this));
        h r120 = this.f436651a;
        if (r120 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L32:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r120.f516085f, new MmRecordingTopBarView$initViews$5(this, r100));
        h r121 = this.f436651a;
        if (r121 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L35:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r121.f516087h, new MmRecordingTopBarView$initViews$6(this, r100));
        LifecycleCoroutineScope r122 = LifecycleOwnerKt.getLifecycleScope(r101);
        r100.selectSubscribe(r122, MmRecordingTopBarView$subscribeData$1.INSTANCE, new MmRecordingTopBarView$subscribeData$2(this, null));
        r100.selectSubscribe(r122, MmRecordingTopBarView$subscribeData$3.INSTANCE, new MmRecordingTopBarView$subscribeData$4(this, null));
        r100.selectSubscribe(r122, MmRecordingTopBarView$subscribeData$5.INSTANCE, new MmRecordingTopBarView$subscribeData$6(this, r100, null));
        r100.selectSubscribe(r122, MmRecordingTopBarView$subscribeData$7.INSTANCE, new MmRecordingTopBarView$subscribeData$8(this, null));
        r100.selectSubscribe(r122, MmRecordingTopBarView$subscribeData$9.INSTANCE, new MmRecordingTopBarView$subscribeData$10(this, null));
        h r123 = this.f436651a;
        if (r123 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r123 = null;
    L38:
        ImageView r124 = r123.f516086g;
        if (e.b(r100.getUiLaunchMode()).getCapability().f(S5(r100, r102)) == true) goto L42;
        r105 = 8;
    L42:
        r124.setVisibility(r105);
        if (r113 == false) goto L50;
        h r125 = this.f436651a;
        if (r125 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L48:
        r108.f516081b.setVisibility(8);
        return;
    L47:
        r108 = r125;
        goto L48
    L50:
        return;
    L11:
        if (this.f436652b != r106) goto L13;
    L5:
        if (r104.f436893b == false) goto L7;
        r113 = true;
        goto L8
    }
}
