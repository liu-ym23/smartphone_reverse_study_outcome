package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.MmStringCheckUtil;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mwb.f;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u001a\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020\u0013H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTitleNameView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingTitleNameViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "hostFragment", "Landroidx/fragment/app/Fragment;", "bind", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", WidgetService.PARAM_FRAGMENT, "isAiNotesDisabled", "", "ensureBinding", "uiLaunchMode", "initVMStateObserver", "initVMEventObserver", "initLocationChooseClickListener", "initTopicUpdateClickListener", "onTitleChanged", "title", "", "from", "showTitle", "ss", "getTitle", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingTitleNameView extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f436640e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f436641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MmRecordingUILaunchMode f436642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MmRecordingViewModel f436643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f436644d;

    public MmRecordingTitleNameView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmRecordingTitleNameView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final String getTitle() {
        f r100 = this.f436641a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L6:
        return r100.f516064d.getText().toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f r100 = this.f436641a;
        if (r100 == null) goto L11;
        MmCoveredEditTextView r101 = r100.f516063c;
        if ((r101 instanceof MmCoveredEditTextView) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L12;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.a(r101));
        return;
    L12:
        return;
    }

    public static final /* synthetic */ String R5(MmRecordingTitleNameView r100) {
        return r100.getTitle();
    }

    public static final void S5(MmRecordingTitleNameView r100, String r101) {
        r100.getClass();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        MmCoveredEditTextView r103 = null;
        if (r102 == false) goto L9;
    L26:
        MmRecordingViewModel r104 = r100.f436643c;
        if (r104 == null) goto L29;
        MmRecordingViewModel.trackPageClick$default(r104, "cancel_rename", null, 2, null);
    L29:
        r100.U5(null, "EditDown_SameOrEmpty");
        f r105 = r100.f436641a;
        if (r105 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L32:
        MmCoveredEditTextView r106 = r105.f516063c;
        if ((r106 instanceof MmCoveredEditTextView) == true) goto L36;
        r106 = null;
    L36:
        if (r106 == null) goto L38;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.a(r106));
    L38:
        int r107 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.TOOLBAR, "onTitleChanged", "title is same or empty, return", null, 8);
        return;
    L9:
        if (Intrinsics.areEqual(r101, r100.getTitle()) == true) goto L26;
        MmRecordingViewModel r108 = r100.f436643c;
        if (r108 == null) goto L14;
        MmRecordingViewModel.trackPageClick$default(r108, "save_rename", null, 2, null);
    L14:
        MmRecordingViewModel r109 = r100.f436643c;
        if (r109 == null) goto L17;
        r109.dispatchEvent(new g.v(r100.getTitle(), r101));
    L17:
        f r110 = r100.f436641a;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L20:
        MmCoveredEditTextView r111 = r110.f516063c;
        if ((r111 instanceof MmCoveredEditTextView) == false) goto L23;
        r103 = r111;
    L23:
        if (r103 == null) goto L25;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.a(r103));
    L25:
        r100.U5(r101, "EditDown");
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void U5(String r100, String r101) {
        int r102 = bwb.b.f21271a;
        f r103 = null;
        bwb.b.g(MmUiLogScene.TOOLBAR, "showTitle", "ss=" + r100 + ", from=" + r101, null, 8);
        if (r100 == null) goto L8;
        f r104 = this.f436641a;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L7:
        r104.f516064d.setText(r100);
    L8:
        f r105 = this.f436641a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L11:
        r105.f516064d.setVisibility(0);
        f r106 = this.f436641a;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r103.f516063c.setVisibility(8);
        return;
    L14:
        r103 = r106;
        goto L15
    }

    public MmRecordingTitleNameView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ MmRecordingTitleNameView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void T5(MmRecordingViewModel r100, final MmRecordingFragment r101, MmRecordingFragment r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        MmRecordingUILaunchMode r104 = r100.getUiLaunchMode();
        if (this.f436641a != null) goto L5;
    L7:
        removeAllViews();
        e.f436896a.getClass();
        this.f436641a = e.b(r104).getLayout().E(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r104)), this);
        this.f436642b = r104;
    L8:
        this.f436643c = r100;
        this.f436644d = r102;
        f r105 = this.f436641a;
        f r106 = null;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L11:
        View r107 = r105.f516070j;
        if (r107 == null) goto L17;
        if (r103 == false) goto L15;
        int r108 = 0;
    L16:
        r107.setVisibility(r108);
        goto L17
    L15:
        r108 = 8;
    L17:
        MmRecordingViewModel r109 = this.f436643c;
        if (r109 == null) goto L20;
        r109.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingTitleNameView$initVMStateObserver$1.INSTANCE, new MmRecordingTitleNameView$initVMStateObserver$2(this, null));
    L20:
        MmRecordingViewModel r110 = this.f436643c;
        if (r110 == null) goto L23;
        r110.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingTitleNameView$initVMStateObserver$3.INSTANCE, new MmRecordingTitleNameView$initVMStateObserver$4(this, null));
    L23:
        MmRecordingViewModel r111 = this.f436643c;
        if (r111 == null) goto L26;
        r111.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r101), MmRecordingTitleNameView$initVMStateObserver$5.INSTANCE, new MmRecordingTitleNameView$initVMStateObserver$6(this, null));
    L26:
        f r112 = this.f436641a;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L29:
        final MmCoveredEditTextView r113 = r112.f516063c;
        if ((r113 instanceof MmCoveredEditTextView) == true) goto L33;
        r113 = null;
    L33:
        if (r113 == null) goto L39;
        f r114 = this.f436641a;
        if (r114 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L38:
        TextView r115 = r114.f516064d;
        UIUtils.setTextViewCursorDrawable(r113, com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).t(getContext()));
        Intrinsics.checkNotNullParameter(r115, "view");
        r113.f435642b = r115;
        r113.f435645e = true;
        Function1<String, Unit> r116 = new MmRecordingTitleNameView$initTopicUpdateClickListener$1(this);
        Intrinsics.checkNotNullParameter(r116, "callback");
        r113.f435643c = r116;
        Function2<String, MmStringCheckUtil.StringCheckoutErrorType, Unit> r117 = new MmRecordingTitleNameView$initTopicUpdateClickListener$2(r101, this);
        Intrinsics.checkNotNullParameter(r117, "callback");
        r113.f435644d = r117;
        h.a(r115, new MmRecordingTitleNameView$initTopicUpdateClickListener$3(this, r113));
    L39:
        MmRecordingViewModel r118 = this.f436643c;
        if (r118 == null) goto L42;
        r118.selectSubscribeVMEvent(LifecycleOwnerKt.getLifecycleScope(r101), new MmRecordingTitleNameView$initVMEventObserver$1(this, null));
    L42:
        final b r119 = new b(this);
        f r120 = this.f436641a;
        if (r120 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L45:
        h.a(r120.f516069i, new MmRecordingTitleNameView$initLocationChooseClickListener$1(r119));
        f r121 = this.f436641a;
        if (r121 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        h.a(r106.f516068h, new MmRecordingTitleNameView$initLocationChooseClickListener$2(r119));
        return;
    L48:
        r106 = r121;
        goto L49
    L5:
        if (this.f436642b != r104) goto L7;
        goto L7
    }
}
