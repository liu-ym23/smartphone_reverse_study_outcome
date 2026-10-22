package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.kmp.o;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetMultiSelectorBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.l0;
import cq8.p;
import cq8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ny9.g;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001,B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\tH\u0002J\u001e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J \u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpMultiSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetMultiSelectorBinding;", "widgetList", "", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "bindInstructionViewModel", "", "viewModel", "init", "onDescriptorChanged", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "Lcom/larus/bmhome/instruction/core/model/widget/MultiSelectorDescriptor;", "bindMultiRowsView", "verticalLayout", "Landroid/widget/LinearLayout;", "childDescriptors", "", "Lcom/larus/bmhome/instruction/core/model/widget/WidgetEntry;", "rowCount", "bindRowView", "rowLayout", "rowDescriptors", "buildLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "index", "rowSize", "isFlushStartDescriptor", "", "getMiddleMarginStart", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMultiSelectorWidget extends AbsKmpInstructionWidget implements b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetMultiSelectorBinding f316659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<AbsKmpInstructionWidget> f316660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f316661h;

    public static final class a {
    }

    static {
    }

    public KmpMultiSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpMultiSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(c r100) {
        this.f316661h = r100;
        Iterator<T> r101 = this.f316660g.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        ViewParent r102 = (AbsKmpInstructionWidget) r101.next();
        if ((r102 instanceof b) == false) goto L8;
        b r103 = (b) r102;
    L9:
        if (r103 == null) goto L4;
        r103.L4(r100);
        goto L4
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "descriptor");
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r100 = null;
        if ((r110 instanceof l0) == true) goto L5;
        r110 = null;
    L5:
        l0 r111 = (l0) r110;
        if (r111 == null) goto L92;
        Intrinsics.checkNotNullParameter(r111, "descriptor");
        List<y0> r101 = CollectionsKt.filterNotNull(r111.f464888k);
        b0 r102 = r111.f464886i;
        if (r102 == null) goto L13;
        Integer r103 = r102.f294986b;
        if (r103 == null) goto L13;
        int r104 = r103.intValue();
    L14:
        FLogger.f375446a.i("KmpMultiSelectorWidget", "[bind] childWidgetEntry.size:" + r101.size() + ", rowCount:" + r104);
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r105 = this.f316659f;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L17:
        r105.f351586c.removeAllViews();
        ((ArrayList) this.f316660g).clear();
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r106 = this.f316659f;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L20:
        int r107 = 8;
        r106.f351588e.setVisibility(8);
        if (r111.f464885h == false) goto L35;
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r108 = this.f316659f;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L25:
        View r109 = r108.f351585b;
        if (z2.f365865a.getImageInspireConfig().a() == true) goto L28;
    L32:
        r107 = 0;
    L33:
        r109.setVisibility(r107);
        goto L35
    L28:
        if ((getFragment() instanceof g) == false) goto L32;
        if (CollectionsKt.listOf(new Integer[]{4, 16}).contains(Integer.valueOf(r111.f464887j)) == false) goto L32;
    L35:
        if (r101.isEmpty() == true) goto L93;
        if (r104 <= 1) goto L75;
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r112 = this.f316659f;
        if (r112 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L41:
        r112.f351586c.setOrientation(1);
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r113 = this.f316659f;
        if (r113 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L45:
        LinearLayout r114 = r100.f351586c;
        if (r104 <= 0) goto L94;
        ArrayList r115 = new ArrayList(r104);
        int r116 = 0;
    L49:
        if (r116 >= r104) goto L51;
        r115.add(new ArrayList());
        r116 = r116 + 1;
        goto L49
    L51:
        Iterator r117 = r101.iterator();
        int r118 = 0;
    L53:
        if (r117.hasNext() == false) goto L58;
        Object r119 = r117.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        ((List) ListProtector.get(r115, r118 % r104)).add((y0) r119);
        r118 = r120;
        goto L53
    L58:
        Iterator r121 = r115.iterator();
        int r122 = 0;
    L60:
        if (r121.hasNext() == false) goto L95;
        Object r123 = r121.next();
        int r124 = r122 + 1;
        if (r122 >= 0) goto L64;
        CollectionsKt.throwIndexOverflow();
    L64:
        List<y0> r125 = (List) r123;
        if (r125.isEmpty() == true) goto L74;
        LinearLayout r126 = new LinearLayout(getContext());
        r126.setOrientation(0);
        r114.addView(r126);
        if (r122 >= CollectionsKt.getLastIndex(r115)) goto L73;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if (r127 == null) goto L72;
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        r128.bottomMargin = i5.h();
        r126.setLayoutParams(r128);
        goto L73
    L72:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L73:
        V5(r126, r125);
    L74:
        r122 = r124;
        goto L60
    L95:
        return;
    L94:
        return;
    L44:
        r100 = r113;
        goto L45
    L75:
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r129 = this.f316659f;
        if (r129 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L78:
        r129.f351586c.setOrientation(0);
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r130 = this.f316659f;
        if (r130 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L82:
        V5(r100.f351586c, r101);
        return;
    L81:
        r100 = r130;
        goto L82
    L93:
        return;
    L13:
        r104 = 1;
        goto L14
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f316659f = LarusLayoutActionBarEditorWidgetMultiSelectorBinding.a(LayoutInflater.from(r100), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(LinearLayout r110, List<y0> r111) {
        Iterator<T> r100 = r111.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L39;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        y0 r104 = (y0) r102;
        a0 r105 = r104.f465006c.getValue();
        if (r105 == null) goto L38;
        FLogger.f375446a.i("KmpMultiSelectorWidget", "[bindRowView] index:" + r101 + ", descriptor:" + Reflection.getOrCreateKotlinClass(r105.getClass()).getSimpleName());
        o r106 = o.f316591a;
        Context r107 = getContext();
        r106.getClass();
        AbsKmpInstructionWidget r108 = o.a(r107, r105);
        t1a.b r109 = getVContext();
        if (r109 == null) goto L38;
        if ((r108 instanceof b) == false) goto L17;
        b r112 = (b) r108;
    L18:
        if (r112 == null) goto L20;
        r112.L4(this.f316661h);
    L20:
        r108.U5(r109, getFragment(), r104.f465006c, r104.f465005b);
        ((ArrayList) this.f316660g).add(r108);
        int r113 = r111.size();
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        if (r101 != 0) goto L26;
        if ((r105 instanceof p) == true) goto L37;
        r114.setMarginStart(i5.h());
    L37:
        r110.addView(r108, r114);
        goto L38
    L26:
        if (r101 != (r113 - 1)) goto L33;
        if ((r105 instanceof p) == false) goto L30;
        int r115 = -i5.N();
    L31:
        r114.setMarginStart(r115);
        r114.setMarginEnd(i5.h());
        goto L37
    L30:
        r115 = i5.r0();
        goto L31
    L33:
        if ((r105 instanceof p) == false) goto L35;
        int r116 = -i5.N();
    L36:
        r114.setMarginStart(r116);
        goto L37
    L35:
        r116 = i5.r0();
        goto L36
    L17:
        r112 = null;
    L38:
        r101 = r103;
        goto L4
    }

    public KmpMultiSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f316660g = new ArrayList();
    }

    public /* synthetic */ KmpMultiSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
