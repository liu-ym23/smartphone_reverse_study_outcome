package com.bytedance.ee.bear.bitable.filter.step.impl;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.filter.step.EFilterStep;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "isFragmentInForseti", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "mFilterStepViewModel", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "getMFilterStepViewModel", "()Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "mFilterStepViewModel$delegate", "Lkotlin/Lazy;", "onCreateContentView", "onViewCreated", "", "view", "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "initPanelStyle", "initObservers", "manageChildFragmentRouter", "updatePanelLeftMenu", "updatePanelHeight", "isInStartStep", "onCreateDialog", "Landroid/app/Dialog;", "onBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterStepFragment extends BaseActionPanelFragment {
    public static final Map<EFilterStep, Class<?>> I = null;
    public boolean G;
    public final Lazy H;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterStepFragment f211899a;

        public b(FilterStepFragment r100) {
            this.f211899a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 == 4) goto L5;
            return false;
        L5:
            if (r102 != null) goto L7;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == false) goto L14;
            FilterStepFragment.ya0(this.f211899a);
            return true;
        L14:
            return false;
        L7:
            if (r102.getAction() != 1) goto L9;
            r103 = true;
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return null;
    }

    static {
        I = MapsKt.mapOf(new Pair[]{TuplesKt.to(EFilterStep.Field, SubFilterFieldFragment.class), TuplesKt.to(EFilterStep.Operator, SubFilterOperatorFragment.class), TuplesKt.to(EFilterStep.Value, SubFilterValueFragment.class)});
    }

    public final FilterStepViewModel za0() {
        return (FilterStepViewModel) this.H.getValue();
    }

    public FilterStepFragment() {
        this.H = LazyKt.lazy(new FilterStepFragment$mFilterStepViewModel$2(this));
    }

    public final boolean Aa0() {
        EFilterStep r100 = za0().getCurrentFilterStep().getValue();
        Pair<EFilterStep, EFilterStep.SubValueStep> r101 = za0().getStartStep();
        EFilterStep.SubValueStep r102 = null;
        if (r101 == null) goto L5;
        EFilterStep r103 = r101.getFirst();
    L6:
        if (r103 != r100) goto L15;
        Pair<EFilterStep, EFilterStep.SubValueStep> r104 = za0().getStartStep();
        if (r104 == null) goto L10;
        EFilterStep.SubValueStep r105 = r104.getSecond();
    L11:
        if (r100 == null) goto L13;
        r102 = r100.getSubValueStep();
    L13:
        if (r105 != r102) goto L15;
        return true;
    L10:
        r105 = null;
    L15:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final mr4.a o() {
        return za0().getSrcObjInfo();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        com.bytedance.ee.bear.bitable.filter.step.a r100 = za0().getFilterStepPanelDelegate();
        if (r100 == null) goto L5;
        r100.c();
    L5:
        za0().clearTemporaryData();
        c.f211908a = false;
        super.onDestroy();
    }

    public static final void ya0(FilterStepFragment r100) {
        if (r100.Aa0() == false) goto L13;
        com.bytedance.ee.bear.bitable.filter.step.a r101 = r100.za0().getFilterStepPanelDelegate();
        if (r101 == null) goto L15;
        r101.b("cancel", r100.za0().getCurrentFilterStep().getValue());
    L15:
        BaseActionPanelFragment.da0(r100);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    L13:
        r100.za0().backToPreStep();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnKeyListener(new b(this));
        return r101;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (this.G == false) goto L8;
        UDShadowLayout r102 = (UDShadowLayout) ia0().findViewById(R.id.shadowLayout);
        if (r102 == null) goto L7;
        r102.setShadowSize(UDShadowLayout.Size.NONE);
    L7:
        this.f209815p = 1;
    L9:
        pa0(R.color.bg_float_base);
        ua0(new Pair(null, getString(R.string.Bitable_Common_ButtonDone)), Integer.valueOf(R.color.primary_fill_default), new FilterStepFragment$initPanelStyle$1(this));
        FilterStepViewModel r103 = za0();
        r103.getActive().setValue(Boolean.TRUE);
        r103.getActive().observe(getViewLifecycleOwner(), new FilterStepFragment$initObservers$1$1(this));
        r103.getCurrentStepTitle().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.filter.step.impl.a(this));
        za0().getCurrentFilterStep().observe(this, new com.bytedance.ee.bear.bitable.filter.step.impl.b(this));
        return;
    L8:
        this.f209815p = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.G = r103;
        if (r103 == false) goto L12;
        this.f209813n = true;
    L12:
        return super.onCreateView(r100, r101, r102);
    L5:
        if (ForsetiHelper.r(this) == false) goto L7;
        r103 = true;
        goto L8
    }
}
