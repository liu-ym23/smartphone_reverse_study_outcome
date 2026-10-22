package com.bytedance.ee.bear.bitable.filter.view.ddui;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.ddui.DDUIModel;
import com.bytedance.ee.bear.bitable.ddui.model.FilterConjunctionModel;
import com.bytedance.ee.bear.bitable.panel.BitablePanelFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/view/ddui/BitableFilterConjunctionFragment;", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelFragment;", "Lcom/bytedance/ee/bear/bitable/ddui/IDDUIWidget;", "<init>", "()V", "lifeCycleListener", "Lcom/bytedance/ee/bear/bitable/ddui/IDDUIContainerLifeCycleListener;", "delegate", "Lcom/bytedance/ee/bear/bitable/ddui/IDDUIDelegate;", "initPanelData", "", "initContentView", "initWidgetData", "data", "", "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "updateWidgetData", "unmount", "openIndependentMode", "", "getComponentType", "setLifeCycleListener", "setDDUIDelegate", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFilterConjunctionFragment extends BitablePanelFragment implements bs4.c {
    public bs4.a V;
    public bs4.b W;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.panel.BitablePanelFragment
    public final void Ba0() {
        this.N = new com.bytedance.ee.bear.bitable.filter.view.ddui.a(this);
        super.Ba0();
    }

    @Override // com.bytedance.ee.bear.bitable.panel.BitablePanelFragment
    public final void Ca0() {
        bs4.a r100 = this.V;
        if (r100 == null) goto L6;
        r100.a(getComponentType());
        return;
    }

    @Override // bs4.c
    public final String getComponentType() {
        return DDUIModel.ComponentType.FILTER_CONJUNCTION_PANEL.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.panel.BitablePanelFragment, com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final mr4.a o() {
        bs4.b r100 = this.W;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.o();
    }

    @Override // bs4.c
    public final void unmount() {
        BaseActionPanelFragment.da0(this);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L11;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public BitableFilterConjunctionFragment() {
    }

    @Override // bs4.c
    public final void ML(String r100) {
        OE(r100);
    }

    @Override // bs4.c
    public final void NQ(com.bytedance.ee.bear.bitable.ddui.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.W = r100;
    }

    @Override // bs4.c
    public final void OE(String r100) {
        if (r100 == null) goto L10;
        Da0(((FilterConjunctionModel) JSON.parseObject(r100, FilterConjunctionModel.class)).into());     // Catch: Exception -> L5
        xa0();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("BitableFilterConjunctionFragment", "setData failed", e, false);
        return;
    }

    @Override // bs4.c
    public final void z90(com.bytedance.ee.bear.bitable.ddui.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeCycleListener");
        this.V = r100;
    }
}
