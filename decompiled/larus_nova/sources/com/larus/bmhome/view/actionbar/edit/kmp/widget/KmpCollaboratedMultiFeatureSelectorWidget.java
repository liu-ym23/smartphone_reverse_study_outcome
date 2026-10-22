package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bt8.j;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.component.CollaboratedMultiFeatureSelectorWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.f;
import cq8.g;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import xs8.d;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpCollaboratedMultiFeatureSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "legacyController", "Lcom/larus/bmhome/view/actionbar/edit/controller/CollaboratedMultiFeatureSelectorController;", "legacyWidget", "Lcom/larus/bmhome/view/actionbar/edit/component/CollaboratedMultiFeatureSelectorWidget;", "boundTemplate", "", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/CollaboratedMultiFeatureSelectorDescriptor;", "pendingBind", "Lkotlin/Pair;", "init", "", "bindInstructionViewModel", "viewModel", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onAttachedToWindow", "resolveFragment", "Landroidx/fragment/app/Fragment;", "bindLegacy", "d", ThumbGlideUrl.SOURCE_TEMPLATE, "syncToCore", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCollaboratedMultiFeatureSelectorWidget extends AbsKmpInstructionWidget implements b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f316602k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f316603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f316604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f316605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f316606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Pair<f, String> f316607j;

    public static final class a {
    }

    static {
    }

    public KmpCollaboratedMultiFeatureSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpCollaboratedMultiFeatureSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final void Y5() {
        f r100 = this.f316606i;
        if (r100 != null) goto L5;
        return;
    L5:
        d r101 = this.f316604g;
        if (r101 != null) goto L8;
        return;
    L8:
        r100.f464826d.a(new g(r100.f464825c, r101.g(), r101.a()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Pair<f, String> r100 = this.f316607j;
        if (r100 == null) goto L6;
        f r101 = r100.component1();
        String r102 = r100.component2();
        this.f316607j = null;
        V5(r101, r102);
        return;
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(c r100) {
        this.f316603f = r100;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if ((r100 instanceof f) == true) goto L5;
        r100 = null;
    L5:
        f r101 = (f) r100;
        if (r101 == null) goto L29;
        this.f316606i = r101;
        String r102 = r101.f464828f;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L18;
        FLogger.f375446a.w("KmpCollaboratedMultiFeatureSelectorWidget", "[onDescriptorChanged] empty template, skip");
        return;
    L18:
        if (this.f316604g == null) goto L22;
        if (Intrinsics.areEqual(r102, this.f316605h) == false) goto L22;
        return;
    L22:
        if (isAttachedToWindow() == false) goto L24;
        V5(r101, r102);
        return;
    L24:
        this.f316607j = TuplesKt.to(r101, r102);
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    }

    public final void V5(f r100, String r101) {
        removeAllViews();
        d r102 = new d();
        r102.f551067g = r100.f464829g;
        wa8.a0 r103 = r102.r(r101, this.f316603f, null, null, null);
        if (Intrinsics.areEqual(r103.f558831a, Boolean.TRUE) == true) goto L6;
        FLogger.f375446a.e("KmpCollaboratedMultiFeatureSelectorWidget", "[bindLegacy] legacy setUp failed: " + r103.f558832b);
        return;
    L6:
        this.f316604g = r102;
        this.f316605h = r101;
        Fragment r104 = getFragment();
        LifecycleCoroutineScope r105 = null;
        if (r104 == null) goto L30;
    L16:
        CollaboratedMultiFeatureSelectorWidget r106 = new CollaboratedMultiFeatureSelectorWidget(getContext());
        if (r104 == null) goto L21;
        LifecycleOwner r107 = r104.getViewLifecycleOwner();
        if (r107 == null) goto L21;
        r105 = LifecycleOwnerKt.getLifecycleScope(r107);
    L21:
        r106.setComponentScope(r105);
        if (r104 == null) goto L24;
        Intrinsics.checkNotNullParameter(r104, WidgetService.PARAM_FRAGMENT);
        r106.f311894a = r104;
    L24:
        r106.setOnDataChanged(new j(this));
        addView(r106);
        r106.T5(r102);
        Y5();
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("[bindLegacy] bound, parentType=");
        r109.append(r100.f464829g);
        r109.append(", hasFragment=");
        if (r104 == null) goto L27;
        boolean r110 = true;
    L28:
        r109.append(r110);
        r108.i("KmpCollaboratedMultiFeatureSelectorWidget", r109.toString());
        return;
    L27:
        r110 = false;
        goto L28
    L30:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L10
        Object r112 = Result.m9449constructorimpl(FragmentManager.findFragment(this));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r112) == false) goto L15;
        r112 = null;
    L15:
        r104 = (Fragment) r112;
    L10:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public KmpCollaboratedMultiFeatureSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ KmpCollaboratedMultiFeatureSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
