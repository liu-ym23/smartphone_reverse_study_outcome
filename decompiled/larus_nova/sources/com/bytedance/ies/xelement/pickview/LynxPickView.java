package com.bytedance.ies.xelement.pickview;

import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-picker-view"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.pickview")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/pickview/LynxPickView;", "Lcom/lynx/tasm/behavior/ui/view/UIView;", "", "style", "", "setIndicatorStyle", "setMaskStyle", "value", "setVisibleCount", "x-element-pickerview_release"}, k = 1, mv = {1, 6, 0})
public final class LynxPickView extends UIView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f250295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f250296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f250297c;

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void measureChildren() {
        String r100 = this.f250295a;
        if (r100 == null) goto L10;
        List<LynxBaseUI> r101 = this.mChildren;
        if (r101 == null) goto L10;
        Iterator r102 = CollectionsKt.filterIsInstance(r101, LynxPickerViewColumn.class).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((LynxPickerViewColumn) r102.next()).setIndicatorStyle(r100);
    L10:
        String r103 = this.f250296b;
        if (r103 == null) goto L18;
        List<LynxBaseUI> r104 = this.mChildren;
        if (r104 == null) goto L18;
        Iterator r105 = CollectionsKt.filterIsInstance(r104, LynxPickerViewColumn.class).iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        ((LynxPickerViewColumn) r105.next()).setMaskStyle(r103);
    L18:
        String r106 = this.f250297c;
        if (r106 == null) goto L26;
        List<LynxBaseUI> r107 = this.mChildren;
        if (r107 == null) goto L26;
        Iterator r108 = CollectionsKt.filterIsInstance(r107, LynxPickerViewColumn.class).iterator();
    L24:
        if (r108.hasNext() == false) goto L26;
        ((LynxPickerViewColumn) r108.next()).setVisibleCount(r106);
    L26:
        super.measureChildren();
    }

    public LynxPickView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
    }

    @LynxProp(name = "indicator-style")
    public final void setIndicatorStyle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f250295a = r100;
    }

    @LynxProp(name = "mask-style")
    public final void setMaskStyle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f250296b = r100;
    }

    @LynxProp(name = "visible-count")
    public final void setVisibleCount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f250297c = r100;
    }

    public LynxPickView(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
