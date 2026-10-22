package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusItemActionBarMsgInstructionV2Binding;
import com.larus.uaigc.instruction.MsgInstructionWidget;
import com.larus.uaigc.instruction.x;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.j0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;
import v19.c7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\"\u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010#\u001a\u00020!H\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001dH\u0002J\u000f\u0010)\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpMsgInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionBarMsgInstructionV2Binding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusItemActionBarMsgInstructionV2Binding;", "binding$delegate", "Lkotlin/Lazy;", "isBeautyDowngrade", "", "()Z", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/MsgInstructionDescriptor;", "isBound", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "init", "", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onBindView", "refreshUI", "data", "getImageEditFunctionId", "()Ljava/lang/Integer;", "getButtonName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMsgInstructionWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b, com.larus.uaigc.creation.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f373392k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f373393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j0 f373394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f373395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f373396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineScope f373397j;

    public static final class a {
    }

    static {
    }

    public KmpMsgInstructionWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpMsgInstructionWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        return 0;
    }

    private final LarusItemActionBarMsgInstructionV2Binding getBinding() {
        return (LarusItemActionBarMsgInstructionV2Binding) this.f373393f.getValue();
    }

    private final p1 getCurrentBindData() {
        j0 r100 = this.f373394g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f464860f;
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        p1 r100 = getCurrentBindData();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f295384b;
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        p1 r100 = getCurrentBindData();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f295383a;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.f373397j, null, 1, null);
    }

    public static final /* synthetic */ p1 Y5(KmpMsgInstructionWidget r100) {
        return r100.getCurrentBindData();
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(com.larus.bmhome.view.actionbar.edit.c r100) {
        this.f373396i = r100;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "descriptor");
        if ((r110 instanceof j0) == false) goto L5;
        j0 r100 = (j0) r110;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        this.f373394g = r100;
        if (this.f373395h == true) goto L14;
        this.f373395h = true;
        e1.d(getBinding().f373161a, new k(this));
        p1 r101 = getCurrentBindData();
        if (r101 == null) goto L13;
        Z5(r101);
    L13:
        BuildersKt.launch$default(this.f373397j, null, null, new KmpMsgInstructionWidget$onBindView$3(this, null), 3, null);
        BuildersKt.launch$default(this.f373397j, null, null, new KmpMsgInstructionWidget$onBindView$4(this, null), 3, null);
        BuildersKt.launch$default(this.f373397j, null, null, new KmpMsgInstructionWidget$onBindView$5(this, null), 3, null);
        return;
    L14:
        p1 r102 = getCurrentBindData();
        if (r102 == null) goto L19;
        Z5(r102);
        return;
    L19:
        return;
    L5:
        r100 = null;
        goto L6
    }

    public final void Z5(p1 r100) {
        boolean r101 = true;
        int r102 = 0;
        if (getVisibility() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (Intrinsics.areEqual(r100.f295388f, Boolean.TRUE) == false) goto L18;
        com.larus.bmhome.view.actionbar.edit.c r104 = this.f373396i;
        if (r104 == null) goto L15;
        i1<Boolean> r105 = r104.getMediaSelectedFlow();
        if (r105 == null) goto L15;
        if (r105.getValue().booleanValue() != true) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        e1.o(this);
    L20:
        if (getVisibility() != 0) goto L22;
        boolean r107 = true;
    L23:
        if (r103 == r107) goto L31;
        com.larus.bmhome.view.actionbar.edit.c r108 = this.f373396i;
        if (r108 == null) goto L31;
        if (getVisibility() == 0) goto L30;
        r101 = false;
    L30:
        r108.onComponentVisibilityChanged(this, r101);
    L31:
        getBinding().f373162b.setText(r100.f295384b);
        boolean r109 = v19.h.f552477a;
        boolean r110 = v19.h.b(getContext());
        e1.x(getBinding().f373163c);
        int r111 = 16;
        String r112 = null;
        if (r110 == false) goto L71;
        g1 r113 = r100.f295387e;
        if (r113 == null) goto L36;
        String r114 = r113.f295156b;
    L38:
        if (o0.d(r114) == false) goto L71;
        SimpleDraweeView r115 = getBinding().f373163c;
        g1 r116 = r100.f295387e;
        if (r116 == null) goto L42;
        r112 = r116.f295156b;
    L42:
        ImageLoaderKt.u(r115, r112, "msg_instruction");
        g1 r117 = r100.f295387e;
        if (r117 == null) goto L47;
        Integer r118 = r117.f295157c;
        if (r118 == null) goto L47;
        int r119 = r118.intValue();
    L48:
        if (r119 <= 0) goto L112;
        g1 r120 = r100.f295387e;
        if (r120 == null) goto L54;
        Integer r121 = r120.f295158d;
        if (r121 == null) goto L54;
        r102 = r121.intValue();
    L54:
        if (r102 <= 0) goto L113;
        SimpleDraweeView r122 = getBinding().f373163c;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if (r123 == null) goto L70;
        g1 r124 = r100.f295387e;
        if (r124 == null) goto L62;
        Integer r125 = r124.f295157c;
        if (r125 == null) goto L62;
        int r126 = r125.intValue();
    L63:
        r123.width = c7.b(Integer.valueOf(r126));
        g1 r127 = r100.f295387e;
        if (r127 == null) goto L68;
        Integer r128 = r127.f295158d;
        if (r128 == null) goto L68;
        r111 = r128.intValue();
    L68:
        r123.height = c7.b(Integer.valueOf(r111));
        r122.setLayoutParams(r123);
        return;
    L62:
        r126 = 16;
        goto L63
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L113:
        return;
    L112:
        return;
    L47:
        r119 = 0;
        goto L48
    L36:
        r114 = null;
    L71:
        if (r110 == true) goto L110;
        g1 r129 = r100.f295386d;
        if (r129 == null) goto L75;
        String r130 = r129.f295156b;
    L77:
        if (o0.d(r130) == false) goto L110;
        SimpleDraweeView r131 = getBinding().f373163c;
        g1 r132 = r100.f295386d;
        if (r132 == null) goto L81;
        r112 = r132.f295156b;
    L81:
        ImageLoaderKt.u(r131, r112, "msg_instruction");
        g1 r133 = r100.f295386d;
        if (r133 == null) goto L86;
        Integer r134 = r133.f295157c;
        if (r134 == null) goto L86;
        int r135 = r134.intValue();
    L87:
        if (r135 <= 0) goto L115;
        g1 r136 = r100.f295386d;
        if (r136 == null) goto L93;
        Integer r137 = r136.f295158d;
        if (r137 == null) goto L93;
        r102 = r137.intValue();
    L93:
        if (r102 <= 0) goto L116;
        SimpleDraweeView r138 = getBinding().f373163c;
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if (r139 == null) goto L109;
        g1 r140 = r100.f295386d;
        if (r140 == null) goto L101;
        Integer r141 = r140.f295157c;
        if (r141 == null) goto L101;
        int r142 = r141.intValue();
    L102:
        r139.width = c7.b(Integer.valueOf(r142));
        g1 r143 = r100.f295386d;
        if (r143 == null) goto L107;
        Integer r144 = r143.f295158d;
        if (r144 == null) goto L107;
        r111 = r144.intValue();
    L107:
        r139.height = c7.b(Integer.valueOf(r111));
        r138.setLayoutParams(r139);
        return;
    L101:
        r142 = 16;
        goto L102
    L109:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L116:
        return;
    L115:
        return;
    L86:
        r135 = 0;
        goto L87
    L75:
        r130 = null;
    L110:
        e1.o(getBinding().f373163c);
        return;
    L22:
        r107 = false;
    L15:
        r106 = false;
    L18:
        e1.x(this);
        goto L20
    L5:
        r103 = false;
        goto L7
    }

    public static Unit V5(KmpMsgInstructionWidget r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.getClass();
        new MsgInstructionWidget(r100.getContext());
        if (Intrinsics.areEqual(PollingConfigService.f326423a.f("cre_bty_dg"), "1") == false) goto L5;
        x.a(r101.getContext());
        return Unit.INSTANCE;
    L5:
        p1 r102 = r100.getCurrentBindData();
        if (r102 == null) goto L11;
        com.larus.bmhome.view.actionbar.edit.c r103 = r100.f373396i;
        if (r103 == null) goto L11;
        r103.onMsgInstructionClicked(r102);
    L11:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        setVisibility(8);
    }

    public KmpMsgInstructionWidget(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f373393f = LazyKt.lazy(new l(r100, this));
        this.f373397j = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    public /* synthetic */ KmpMsgInstructionWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
