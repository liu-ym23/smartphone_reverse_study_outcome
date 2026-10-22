package com.larus.canvas.feature.component.instruction.factory;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.canvas.feature.component.input.v;
import com.larus.canvas.service.bean.InstructionTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes26.dex */
public final class InstructionTabWidgetFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f323129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f323130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f323131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<InstructionTab> f323132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<InstructionTab, com.larus.canvas.feature.component.instruction.b> f323133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<String> f323134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f323135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f323136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f323137i;

    public final void b() {
        ViewGroup r100 = this.f323131c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r100 = null;
    L5:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L10;
        r101.height = 0;
        r100.setLayoutParams(r101);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public InstructionTabWidgetFactory() {
        this.f323132d = new ArrayList();
        this.f323133e = new LinkedHashMap();
    }

    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "tabLabel");
        Iterator<T> r100 = this.f323132d.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (Intrinsics.areEqual(((InstructionTab) r101).getTabLabel(), r110) == false) goto L4;
    L9:
        InstructionTab r102 = (InstructionTab) r101;
        if (r102 != null) goto L12;
        return;
    L12:
        if (this.f323133e.get(r102) == null) goto L28;
        ViewGroup r111 = this.f323131c;
        if (r111 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r111 = null;
    L16:
        ViewGroup.LayoutParams r103 = r111.getLayoutParams();
        if (r103 == null) goto L23;
        r103.height = -2;
        r111.setLayoutParams(r103);
        Fragment r112 = this.f323129a;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
        r112 = null;
    L21:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r112), null, null, new InstructionTabWidgetFactory$selectInstructionTab$3$1$2(r102, null), 3, null);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void a(Fragment r100, ViewGroup r101, ViewGroup r102, v r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "tabContainer");
        Intrinsics.checkNotNullParameter(r102, "customAreaContainer");
        Intrinsics.checkNotNullParameter(r110, "getCurrentPrompt");
        Intrinsics.checkNotNullParameter(r111, "traceMap");
        this.f323129a = r100;
        this.f323130b = r101;
        this.f323131c = r102;
        this.f323134f = r110;
        this.f323135g = r111;
        b();
        Fragment r103 = this.f323129a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
        r103 = null;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r103), null, null, new InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1(this, null), 3, null);
    }
}
