package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import bt8.j0;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTabSelectorBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.r0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00060\u0001j\u0002`\u0002:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0014J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTabSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTabSelectorBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/TabSelectorDescriptor;", "tabListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "bind", "renderSubTitle", "renderBottomDivider", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTabSelectorWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetTabSelectorBinding f316662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f316663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f316664h;

    public static final class a {
    }

    static {
    }

    public KmpTabSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpTabSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        FLogger.f375446a.i("KmpTabSelectorWidget", "[onDescriptorChanged] descriptor:" + r100);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r101 = null;
        if ((r100 instanceof r0) == true) goto L5;
        r100 = null;
    L5:
        r0 r102 = (r0) r100;
        if (r102 == null) goto L99;
        Intrinsics.checkNotNullParameter(r102, "descriptor");
        this.f316663g = r102;
        i0 r103 = r102.f464949f;
        if (r103 == null) goto L11;
        List<w> r104 = r103.f295197a;
    L12:
        if (r104 != null) goto L14;
        r104 = CollectionsKt.emptyList();
    L14:
        j0 r105 = this.f316664h;
        if (r105 == null) goto L20;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r106 = this.f316662f;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L19:
        r106.f351592d.removeOnTabSelectedListener(r105);
    L20:
        String r107 = r102.f464950g;
        if (r107 != null) goto L23;
    L25:
        r107 = null;
    L26:
        int r108 = 8;
        if (r107 != null) goto L32;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r109 = this.f316662f;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L31:
        r109.f351591c.setVisibility(8);
    L39:
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r110 = this.f316662f;
        if (r110 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L42:
        View r111 = r110.f351590b;
        if (r102.f464951h == false) goto L45;
        r108 = 0;
    L45:
        r111.setVisibility(r108);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r112 = this.f316662f;
        if (r112 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L48:
        r112.f351592d.removeAllTabs();
        Iterator<T> r113 = r104.iterator();
    L50:
        if (r113.hasNext() == false) goto L58;
        w r114 = (w) r113.next();
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r115 = this.f316662f;
        if (r115 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L54:
        TabLayout.Tab r116 = r115.f351592d.newTab();
        r116.setText(r114.f295511b);
        r116.setTag(r114.f295510a);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r117 = this.f316662f;
        if (r117 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L57:
        r117.f351592d.addTab(r116, false);
        goto L50
    L58:
        j0 r118 = new j0(this);
        this.f316664h = r118;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r119 = this.f316662f;
        if (r119 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L61:
        r119.f351592d.addOnTabSelectedListener(r118);
        Iterator<w> r120 = r104.iterator();
        int r121 = 0;
    L63:
        if (r120.hasNext() == false) goto L74;
        Integer r122 = r120.next().f295528s;
        if (r122 != null) goto L68;
    L70:
        boolean r123 = false;
    L71:
        if (r123 == true) goto L75;
        r121 = r121 + 1;
    L75:
        if (r121 < 0) goto L83;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r124 = this.f316662f;
        if (r124 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L80:
        TabLayout.Tab r125 = r101.f351592d.getTabAt(r121);
        if (r125 == null) goto L96;
        r125.select();
        return;
    L96:
        return;
    L79:
        r101 = r124;
        goto L80
    L83:
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r126 = this.f316662f;
        if (r126 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L87:
        TabLayout.Tab r127 = r101.f351592d.getTabAt(0);
        if (r127 == null) goto L98;
        r127.select();
        return;
    L98:
        return;
    L86:
        r101 = r126;
        goto L87
    L68:
        if (r122.intValue() != 1) goto L70;
        r123 = true;
        goto L71
    L74:
        r121 = -1;
        goto L75
    L32:
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r128 = this.f316662f;
        if (r128 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L35:
        r128.f351591c.setText(r107);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r129 = this.f316662f;
        if (r129 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L38:
        r129.f351591c.setVisibility(0);
        goto L39
    L23:
        if ((!StringsKt.isBlank(r107)) == false) goto L25;
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r102 = LarusLayoutActionBarEditorWidgetTabSelectorBinding.a(LayoutInflater.from(r100), this);
        this.f316662f = r102;
        r102.f351592d.setElevation(1.0f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(i5.h0(), 1073741824));
    }

    public KmpTabSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ KmpTabSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
