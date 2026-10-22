package com.larus.bmhome.instruction.base;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.n;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import up8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010.\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H$J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0010J\b\u00101\u001a\u00020!H&J\b\u00102\u001a\u00020!H\u0014J\b\u00103\u001a\u00020!H\u0014J\b\u00104\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020!H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u00020)8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+¨\u0006<"}, d2 = {"Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "getFragment", "()Landroidx/fragment/app/Fragment;", "componentController", "Lcom/larus/bmhome/instruction/base/AbsInstructionController;", "inputDepend", "Lcom/larus/bmhome/view/actionbar/edit/OutInputDepend;", "getInputDepend", "()Lcom/larus/bmhome/view/actionbar/edit/OutInputDepend;", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getInstructionItem", "()Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getController", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "bindFragment", "", "componentScope", "Lkotlinx/coroutines/CoroutineScope;", "getComponentScope", "()Lkotlinx/coroutines/CoroutineScope;", "setComponentScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "viewLifecycleOwner", "Lcom/larus/bmhome/instruction/base/ViewLifecycleOwner;", "getViewLifecycleOwner", "()Lcom/larus/bmhome/instruction/base/ViewLifecycleOwner;", "viewLifecycleOwner$delegate", "Lkotlin/Lazy;", "init", "bindView", "controller", "onBindView", "onAttachedToWindow", "onDetachedFromWindow", "onViewShow", "applyMarginTop", "bindPickPictureResult", "uri", "Landroid/net/Uri;", "reportShow", "requestInputBoxFocus", "clearInputFocus", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsInstructionWidget extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f311893e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f311894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f311895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CoroutineScope f311896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f311897d;

    public AbsInstructionWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsInstructionWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void S5(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
    }

    public void U5() {
    }

    public abstract void V5(Context r100, AttributeSet r101);

    public abstract void Y5();

    public void Z5() {
    }

    public void b6() {
    }

    public void c6() {
    }

    public final <T> T getController() {
        T r100 = (T) this.f311895b;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    public final n getInputDepend() {
        b r100 = this.f311895b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f551065e;
    }

    public final u getInstructionItem() {
        b r100 = this.f311895b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f551062b;
    }

    public final ViewLifecycleOwner getViewLifecycleOwner() {
        return (ViewLifecycleOwner) this.f311897d.getValue();
    }

    public final c getViewModel() {
        b r100 = this.f311895b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f551063c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewLifecycleOwner().f311899b.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewLifecycleOwner r100 = getViewLifecycleOwner();
        Lifecycle.State r101 = r100.f311899b.getCurrentState();
        Lifecycle.State r102 = Lifecycle.State.DESTROYED;
        if (r101 == r102) goto L11;
        LifecycleRegistry r103 = r100.f311899b;
        if (r100.f311898a == null) goto L9;
        r102 = Lifecycle.State.CREATED;
    L9:
        r103.setCurrentState(r102);
        return;
    }

    public final CoroutineScope getComponentScope() {
        return this.f311896c;
    }

    public final Fragment getFragment() {
        return this.f311894a;
    }

    public void R5(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f311894a = r100;
    }

    public final void T5(b r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f311895b = r100;
        u r101 = r100.f551062b;
        if (r101 == null) goto L9;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, -2);
        int r103 = CircleProgressBarView.f328410k;
        Context r104 = getContext();
        Integer r105 = r101.f295481h;
        if (r105 == null) goto L7;
        float r106 = r105.intValue();
    L8:
        r102.setMargins(0, (int) CircleProgressBarView.a.a(r104, r106), 0, 0);
        setLayoutParams(r102);
        goto L9
    L7:
        r106 = 0.0f;
    L9:
        Y5();
    }

    public final void setComponentScope(CoroutineScope r100) {
        this.f311896c = r100;
    }

    public AbsInstructionWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f311897d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new up8.c(this));
        V5(r100, r101);
    }

    public /* synthetic */ AbsInstructionWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
