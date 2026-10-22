package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.larus.utils.e1;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.q;
import cq8.r;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import v19.y6;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010 \u001a\u00020\u001eH\u0014J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006'"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpImageListSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/ImageListSelectorDescriptor;", "isBound", "", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "localImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "itemClickCallback", "com/larus/uaigc/instruction/kmp/KmpImageListSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/instruction/kmp/KmpImageListSelectorWidget$itemClickCallback$1;", "init", "", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onBindView", ChameleonOpenTracker.Stage.RENDER, "startObserveTemplateChoose", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpImageListSelectorWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f373365n = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding f373366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageSelectorWidgetAdapter f373367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f373368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f373369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f373370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineScope f373371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<w> f373372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f373373m;

    public static final class a {
    }

    public static final class b implements vz9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpImageListSelectorWidget f373374a;

        @Override // vz9.d
        public final void b(w r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        }

        public b(KmpImageListSelectorWidget r100) {
            this.f373374a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [int] */
        /* JADX WARN: Type inference failed for: r4v5 */
        @Override // vz9.d
        public final void a(w r410, int r510) {
            Intrinsics.checkNotNullParameter(r410, MapController.ITEM_LAYER_TAG);
            r r100 = this.f373374a.f373368h;
            if (r100 != null) goto L5;
            return;
        L5:
            com.larus.bmhome.actionbar.model.l r101 = r100.f464940f;
            if (r101 == null) goto L8;
            ?? r102 = Intrinsics.areEqual(r101.f295272c, Boolean.TRUE);
        L9:
            Iterator r103 = this.f373374a.f373372l.iterator();
        L10:
            Integer r104 = null;
            if (r103.hasNext() == false) goto L15;
            Object r105 = r103.next();
            if (Intrinsics.areEqual(((w) r105).f295510a, r410.f295510a) == false) goto L10;
        L16:
            w r106 = (w) r105;
            if (r106 == null) goto L20;
            r104 = r106.f295528s;
        L20:
            if (r102 != 0) goto L26;
            if (r104 == null) goto L26;
            if (r104.intValue() != 1) goto L26;
            boolean r107 = true;
        L27:
            z r108 = r100.f464938d;
            String r110 = r100.f464937c;
            Long r111 = r410.f295510a;
            if (r111 == null) goto L47;
            r108.a(new q(r110, r111.longValue(), r107));
            z0 r109 = r100.f464944j;
            String r112 = r109.f465007a;
            String r113 = r109.f465009c;
            String r114 = r109.f465010d;
            String r115 = r109.f465012f;
            String r116 = r109.f465013g;
            String r117 = r109.f465016j;
            String r118 = r410.f295511b;
            String r119 = String.valueOf(r410.f295510a);
            com.larus.bmhome.actionbar.model.l r120 = r100.f464940f;
            if (r120 == null) goto L37;
            Integer r121 = r120.f295271b;
            if (r121 == null) goto L37;
            if (r510 != r121.intValue()) goto L37;
            int r122 = 1;
        L38:
            Integer r123 = Integer.valueOf(r122);
            Integer r124 = Integer.valueOf(r102);
            Integer r210 = Integer.valueOf(r510 + 1);
            if (r107 == true) goto L41;
            String r125 = "select";
        L42:
            tx9.b.e(r112, r113, r114, r115, r116, r117, null, r118, r119, r123, r124, r210, r125, null, null, null, null, "original", null, null, null, null, null, null, r109.f465015i, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
            return;
        L41:
            r125 = "cancel";
        L37:
            r122 = 0;
            goto L38
        L47:
            return;
        L26:
            r107 = false;
            goto L27
        L15:
            r105 = null;
            goto L16
        L8:
            r102 = 0;
            goto L9
        }
    }

    static {
    }

    public KmpImageListSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpImageListSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.f373371k, null, 1, null);
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(com.larus.bmhome.view.actionbar.edit.c r100) {
        this.f373370j = r100;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "descriptor");
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r100 = null;
        if ((r110 instanceof r) == false) goto L5;
        r r111 = (r) r110;
    L6:
        if (r111 != null) goto L8;
        return;
    L8:
        this.f373368h = r111;
        if (this.f373369i == true) goto L44;
        boolean r101 = true;
        this.f373369i = true;
        if (r111.f464942h == false) goto L16;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r102 = this.f373366f;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L15:
        e1.x(r102.f373205b);
    L16:
        String r103 = r111.f464941g;
        if (r103 != null) goto L19;
    L22:
        if (r101 == false) goto L27;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r104 = this.f373366f;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L26:
        e1.o(r104.f373208e);
    L34:
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r105 = this.f373366f;
        if (r105 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L37:
        y6.d(r105.f373206c, null, null, null, new c(this), 15);
        this.f373367g = new ImageSelectorWidgetAdapter(this.f373373m, null);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r106 = this.f373366f;
        if (r106 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L40:
        r106.f373206c.setAdapter(this.f373367g);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r107 = this.f373366f;
        if (r107 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L43:
        r107.f373206c.addItemDecoration(new KmpImageListSelectorWidget$onBindView$2());
        BuildersKt.launch$default(this.f373371k, null, null, new KmpImageListSelectorWidget$startObserveTemplateChoose$1(this, null), 3, null);
        goto L44
    L27:
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r108 = this.f373366f;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L30:
        r108.f373208e.setText(r103);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r109 = this.f373366f;
        if (r109 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L33:
        e1.x(r109.f373208e);
        goto L34
    L19:
        if (r103.length() == 0) goto L22;
        r101 = false;
    L44:
        com.larus.bmhome.actionbar.model.l r112 = r111.f464940f;
        if (r112 == null) goto L47;
        List<w> r113 = r112.f295270a;
    L48:
        if (r113 != null) goto L50;
        r113 = CollectionsKt.emptyList();
    L50:
        List<w> r114 = r113;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r116 = r114.iterator();
    L52:
        if (r116.hasNext() == false) goto L54;
        r115.add(w.a((w) r116.next(), null, null, null, null, null, null, 8388607));
        goto L52
    L54:
        ImageSelectorWidgetAdapter r117 = this.f373367g;
        if (r117 == null) goto L57;
        r117.submitList(r115);
    L57:
        this.f373372l = r115;
        if (r111.f464945k < 0) goto L68;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r118 = this.f373366f;
        if (r118 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L63:
        RecyclerView.LayoutManager r119 = r100.f373206c.getLayoutManager();
        if (r119 == null) goto L69;
        r119.scrollToPosition(r111.f464945k);
        return;
    L69:
        return;
    L62:
        r100 = r118;
        goto L63
    L68:
        return;
    L47:
        r113 = null;
        goto L48
    L5:
        r111 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f373366f = LarusLayoutActionBarEditorWidgetImageSelectorV2Binding.a(LayoutInflater.from(r100), this);
    }

    public KmpImageListSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f373371k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f373372l = CollectionsKt.emptyList();
        this.f373373m = new b(this);
    }

    public /* synthetic */ KmpImageListSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
