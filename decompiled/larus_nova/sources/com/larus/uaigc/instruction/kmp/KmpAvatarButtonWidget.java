package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.instruction.AvatarTemplateWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpAvatarButtonWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "legacyController", "Lcom/larus/uaigc/instruction/AvatarTemplateController;", "boundTemplate", "", "pendingBind", "Lkotlin/Pair;", "Lcom/larus/bmhome/instruction/core/model/widget/AvatarButtonDescriptor;", "init", "", "bindInstructionViewModel", "viewModel", "onDescriptorChanged", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onAttachedToWindow", "resolveFragment", "Landroidx/fragment/app/Fragment;", "bindLegacy", "d", ThumbGlideUrl.SOURCE_TEMPLATE, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpAvatarButtonWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f373348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larus.uaigc.instruction.a f373349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f373350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Pair<cq8.a, String> f373351i;

    public static final class a {
    }

    static {
    }

    public KmpAvatarButtonWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpAvatarButtonWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Pair<cq8.a, String> r100 = this.f373351i;
        if (r100 == null) goto L6;
        cq8.a r101 = r100.component1();
        String r102 = r100.component2();
        this.f373351i = null;
        V5(r101, r102);
        return;
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(com.larus.bmhome.view.actionbar.edit.c r100) {
        this.f373348f = r100;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if ((r100 instanceof cq8.a) == true) goto L5;
        r100 = null;
    L5:
        cq8.a r101 = (cq8.a) r100;
        if (r101 == null) goto L29;
        String r102 = r101.f464797f;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L18;
        FLogger.f375446a.w("KmpAvatarButtonWidget", "[onDescriptorChanged] empty template, skip");
        return;
    L18:
        if (this.f373349g == null) goto L22;
        if (Intrinsics.areEqual(r102, this.f373350h) == false) goto L22;
        return;
    L22:
        if (isAttachedToWindow() == false) goto L24;
        V5(r101, r102);
        return;
    L24:
        this.f373351i = TuplesKt.to(r101, r102);
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    }

    public final void V5(cq8.a r100, String r101) {
        removeAllViews();
        com.larus.uaigc.instruction.a r102 = new com.larus.uaigc.instruction.a();
        r102.f551067g = r100.f464798g;
        wa8.a0 r103 = r102.r(r101, this.f373348f, null, null, null);
        if (Intrinsics.areEqual(r103.f558831a, Boolean.TRUE) == true) goto L6;
        FLogger.f375446a.e("KmpAvatarButtonWidget", "[bindLegacy] legacy setUp failed: " + r103.f558832b);
        return;
    L6:
        this.f373349g = r102;
        this.f373350h = r101;
        Fragment r104 = getFragment();
        LifecycleCoroutineScope r105 = null;
        if (r104 == null) goto L30;
    L16:
        AvatarTemplateWidget r106 = new AvatarTemplateWidget(getContext());
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
        addView(r106);
        r106.T5(r102);
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("[bindLegacy] bound, parentType=");
        r109.append(r100.f464798g);
        r109.append(", hasFragment=");
        if (r104 == null) goto L27;
        boolean r110 = true;
    L28:
        r109.append(r110);
        r108.i("KmpAvatarButtonWidget", r109.toString());
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

    public KmpAvatarButtonWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ KmpAvatarButtonWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
