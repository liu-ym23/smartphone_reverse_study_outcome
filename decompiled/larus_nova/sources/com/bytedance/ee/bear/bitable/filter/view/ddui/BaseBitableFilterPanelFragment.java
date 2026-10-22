package com.bytedance.ee.bear.bitable.filter.view.ddui;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/view/ddui/BaseBitableFilterPanelFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "Lcom/bytedance/ee/bear/bitable/ddui/IDDUIWidget;", "<init>", "()V", "lifeCycleListener", "Lcom/bytedance/ee/bear/bitable/ddui/IDDUIContainerLifeCycleListener;", "delegate", "Lcom/bytedance/ee/bear/bitable/ddui/IDDUIDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/ddui/IDDUIDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/bitable/ddui/IDDUIDelegate;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "setLifeCycleListener", "setDDUIDelegate", "unmount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseBitableFilterPanelFragment extends BaseActionPanelFragment implements bs4.c {
    public bs4.a G;
    public bs4.b H;

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final mr4.a o() {
        bs4.b r100 = this.H;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.o();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        bs4.a r100 = this.G;
        if (r100 == null) goto L6;
        r100.b(getComponentType());
        return;
    }

    @Override // bs4.c
    public final void unmount() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L11;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public BaseBitableFilterPanelFragment() {
    }

    @Override // bs4.c
    public final void NQ(com.bytedance.ee.bear.bitable.ddui.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.H = r100;
    }

    @Override // bs4.c
    public final void z90(com.bytedance.ee.bear.bitable.ddui.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeCycleListener");
        this.G = r100;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        bs4.a r102 = this.G;
        if (r102 == null) goto L6;
        r102.a(getComponentType());
        return;
    }
}
