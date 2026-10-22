package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import bt8.b0;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.kmp.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.f0;
import cq8.g0;
import cq8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001$B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u001dH\u0014J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010 \u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpMenuTabContainerWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "childContainer", "Landroid/widget/LinearLayout;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/MenuTabContainerDescriptor;", "tabListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "widgetList", "", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "bindInstructionViewModel", "", "viewModel", "init", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "renderTabs", "renderChildren", "childWidgetEntry", "", "Lcom/larus/bmhome/instruction/core/model/widget/WidgetEntry;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMenuTabContainerWidget extends AbsKmpInstructionWidget implements b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TabLayout f316650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f316651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f0 f316652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b0 f316653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<AbsKmpInstructionWidget> f316654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f316655k;

    public static final class a {
    }

    static {
    }

    public KmpMenuTabContainerWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpMenuTabContainerWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(c r100) {
        this.f316655k = r100;
        Iterator<T> r101 = this.f316654j.iterator();
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
    public final void T5(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if ((r100 instanceof f0) == true) goto L5;
        r100 = null;
    L5:
        f0 r101 = (f0) r100;
        if (r101 == null) goto L10;
        V5(r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        this.f316652h = r100;
        FLogger.f375446a.i("KmpMenuTabContainerWidget", "[bind] tabs:" + r100.f464834f.size() + ", childWidgetEntry:" + r100.f464837i.size());
        b0 r101 = this.f316653i;
        LinearLayout r102 = null;
        if (r101 == null) goto L8;
        TabLayout r103 = this.f316650f;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r103 = null;
    L7:
        r103.removeOnTabSelectedListener(r101);
    L8:
        TabLayout r104 = this.f316650f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r104 = null;
    L11:
        r104.removeAllTabs();
        Iterator<T> r105 = r100.f464834f.iterator();
    L13:
        if (r105.hasNext() == false) goto L21;
        g0 r106 = (g0) r105.next();
        TabLayout r107 = this.f316650f;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r107 = null;
    L17:
        TabLayout.Tab r108 = r107.newTab();
        r108.setText(r106.f464842b);
        r108.setTag(Long.valueOf(r106.f464841a));
        TabLayout r109 = this.f316650f;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r109 = null;
    L20:
        r109.addTab(r108);
        goto L13
    L21:
        b0 r110 = new b0(this);
        this.f316653i = r110;
        TabLayout r111 = this.f316650f;
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r111 = null;
    L24:
        r111.addOnTabSelectedListener(r110);
        Iterator<g0> r112 = r100.f464834f.iterator();
        int r113 = 0;
    L26:
        if (r112.hasNext() == false) goto L31;
        if (r112.next().f464843c == true) goto L32;
        r113 = r113 + 1;
    L32:
        if (r113 < 0) goto L39;
        TabLayout r114 = this.f316650f;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r114 = null;
    L36:
        TabLayout.Tab r115 = r114.getTabAt(r113);
        if (r115 == null) goto L39;
        r115.select();
    L39:
        List r116 = CollectionsKt.filterNotNull(r100.f464837i);
        LinearLayout r117 = this.f316651g;
        if (r117 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
        r117 = null;
    L42:
        r117.removeAllViews();
        Iterator r118 = ((ArrayList) this.f316654j).iterator();
    L44:
        if (r118.hasNext() == false) goto L49;
        AbsKmpInstructionWidget r119 = (AbsKmpInstructionWidget) r118.next();
        Job r120 = r119.f312174a;
        if (r120 == null) goto L48;
        Job.DefaultImpls.cancel$default(r120, null, 1, null);
    L48:
        r119.f312174a = null;
        r119.f312175b = null;
        goto L44
    L49:
        ((ArrayList) this.f316654j).clear();
        if (r116.isEmpty() == false) goto L56;
        LinearLayout r121 = this.f316651g;
        if (r121 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
    L55:
        r102.setVisibility(8);
        return;
    L54:
        r102 = r121;
        goto L55
    L56:
        LinearLayout r122 = this.f316651g;
        if (r122 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
        r122 = null;
    L59:
        r122.setVisibility(0);
        t1a.b r123 = getVContext();
        if (r123 == null) goto L92;
        Iterator r124 = r116.iterator();
    L64:
        if (r124.hasNext() == false) goto L93;
        y0 r125 = (y0) r124.next();
        a0 r126 = r125.f465006c.getValue();
        if (r126 == null) goto L64;
        o r127 = o.f316591a;
        Context r128 = getContext();
        r127.getClass();
        AbsKmpInstructionWidget r129 = o.a(r128, r126);
        if ((r129 instanceof b) == false) goto L71;
        b r130 = (b) r129;
    L72:
        if (r130 == null) goto L74;
        r130.L4(this.f316655k);
    L74:
        r129.U5(r123, getFragment(), r125.f465006c, r125.f465005b);
        ((ArrayList) this.f316654j).add(r129);
        LinearLayout r131 = this.f316651g;
        LinearLayout r132 = r131;
        if (r131 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
        r132 = null;
    L77:
        r132.addView(r129, new LinearLayout.LayoutParams(-1, -2));
        goto L64
    L71:
        r130 = null;
        goto L72
    L93:
        return;
    L92:
        return;
    L31:
        r113 = -1;
        goto L32
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r102 = new LinearLayout(r100);
        r102.setOrientation(1);
        r102.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        TabLayout r103 = new TabLayout(r100);
        r103.setTabMode(0);
        r103.setElevation(1.0f);
        r103.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f316650f = r103;
        LinearLayout r104 = new LinearLayout(r100);
        r104.setOrientation(1);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f316651g = r104;
        TabLayout r105 = this.f316650f;
        LinearLayout r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r105 = null;
    L5:
        r102.addView(r105);
        LinearLayout r107 = this.f316651g;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
    L9:
        r102.addView(r106);
        addView(r102);
        return;
    L8:
        r106 = r107;
        goto L9
    }

    public KmpMenuTabContainerWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f316654j = new ArrayList();
    }

    public /* synthetic */ KmpMenuTabContainerWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
