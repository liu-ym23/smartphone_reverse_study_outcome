package com.larus.bmhome.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H$J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\rH$J4\u0010\u001f\u001a\u00020\u001b\"\n\b\u0000\u0010 \u0018\u0001*\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001b0\"H\u0084\bø\u0001\u0000J2\u0010#\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0%2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0006\u0010)\u001a\u00020\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collectJob", "Lkotlinx/coroutines/Job;", "lastDescriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getVContext", "()Lcom/larus/ui/arch/context/external/VContext;", "setVContext", "(Lcom/larus/ui/arch/context/external/VContext;)V", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "onDetachedFromWindow", "", "init", "onDescriptorChanged", "descriptor", "withDescriptor", "D", "block", "Lkotlin/Function1;", LynxTemplateRender.RENDER_PHASE_SETUP, "descriptorFlow", "Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatchDescriptor", "stopObserving", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsKmpInstructionWidget extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f312173e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f312174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f312175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t1a.b f312176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f312177d;

    public static final class a {
    }

    static {
    }

    public AbsKmpInstructionWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsKmpInstructionWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract void S5(Context r100, AttributeSet r101);

    public abstract void T5(a0 r100);

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r100 = this.f312174a;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f312174a = null;
        this.f312175b = null;
    }

    public final Fragment getFragment() {
        return this.f312177d;
    }

    public final t1a.b getVContext() {
        return this.f312176c;
    }

    public final void R5(a0 r100) {
        String r101 = r100.a();
        a0 r102 = this.f312175b;
        if (r102 == null) goto L5;
        String r103 = r102.a();
    L7:
        if (Intrinsics.areEqual(r101, r103) == false) goto L9;
        return;
    L9:
        FLogger.f375446a.i("AbsKmpInstructionWidget", "[dispatchDescriptor] " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName());
        this.f312175b = r100;
        T5(r100);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final void setFragment(Fragment r100) {
        this.f312177d = r100;
    }

    public final void setVContext(t1a.b r100) {
        this.f312176c = r100;
    }

    public AbsKmpInstructionWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        S5(r100, r101);
    }

    public /* synthetic */ AbsKmpInstructionWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void U5(t1a.b r100, Fragment r101, i1<? extends a0> r102, CoroutineScope r110) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        Intrinsics.checkNotNullParameter(r102, "descriptorFlow");
        Intrinsics.checkNotNullParameter(r110, "scope");
        this.f312176c = r100;
        this.f312177d = r101;
        Job r103 = this.f312174a;
        if (r103 == null) goto L5;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L5:
        this.f312175b = null;
        a0 r104 = r102.getValue();
        if (r104 == null) goto L8;
        R5(r104);
    L8:
        this.f312174a = BuildersKt.launch$default(r110, Dispatchers.getMain().getImmediate(), null, new AbsKmpInstructionWidget$setup$2(r102, this, null), 2, null);
    }
}
