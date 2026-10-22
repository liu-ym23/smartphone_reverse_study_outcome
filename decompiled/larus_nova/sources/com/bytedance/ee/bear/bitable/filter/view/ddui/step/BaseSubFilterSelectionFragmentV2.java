package com.bytedance.ee.bear.bitable.filter.view.ddui.step;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.bitable.ddui.model.ConditionEditItemModel;
import com.bytedance.ee.bear.bitable.ddui.model.ImageWidgetModel;
import com.bytedance.ee.bear.bitable.ddui.model.StepContentModel;
import com.bytedance.ee.bear.bitable.ddui.model.TextWidgetModel;
import com.bytedance.ee.bear.bitable.filter.step.impl.BaseSubFilterSelectionFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/view/ddui/step/BaseSubFilterSelectionFragmentV2;", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/BaseSubFilterSelectionFragment;", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/step/ISubFilterFragment;", "<init>", "()V", "mFilterStepDelegate", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/step/IFilterStepDelegate;", "getMFilterStepDelegate", "()Lcom/bytedance/ee/bear/bitable/filter/view/ddui/step/IFilterStepDelegate;", "setMFilterStepDelegate", "(Lcom/bytedance/ee/bear/bitable/filter/view/ddui/step/IFilterStepDelegate;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setFilterStepDelegate", "filterStepDelegate", "refreshPanel", "value", "Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentModel;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubFilterSelectionFragmentV2 extends BaseSubFilterSelectionFragment implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f212097h;

    @Override // com.bytedance.ee.bear.bitable.filter.view.ddui.step.b
    public final void B00(StepContentModel r100) {
    }

    public BaseSubFilterSelectionFragmentV2() {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.view.ddui.step.b
    public final void Qg(a r100) {
        Intrinsics.checkNotNullParameter(r100, "filterStepDelegate");
        this.f212097h = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.BaseSubFilterSelectionFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        a r112 = this.f212097h;
        if (r112 == null) goto L27;
        List<ConditionEditItemModel> r113 = r112.cC(j10());
        if (r113 == null) goto L32;
        Iterator<T> r114 = r113.iterator();
    L8:
        if (r114.hasNext() == false) goto L33;
        final ConditionEditItemModel r115 = (ConditionEditItemModel) r114.next();
        TextWidgetModel r100 = r115.getContentText();
        Integer r101 = null;
        if (r100 == null) goto L12;
        String r102 = r100.getText();
    L13:
        Context r103 = getContext();
        if (r103 == null) goto L20;
        ImageWidgetModel r104 = r115.getContentImg();
        if (r104 == null) goto L18;
        Integer r105 = r104.getIconRes(r103);
    L19:
        Integer r106 = r105;
    L21:
        Context r107 = getContext();
        if (r107 == null) goto L26;
        ImageWidgetModel r108 = r115.getRightIcon();
        if (r108 == null) goto L26;
        r101 = r108.getIconRes(r107);
    L26:
        U90(r102, r106, r101, r115.isSync(), Intrinsics.areEqual(r115.getChecked(), Boolean.TRUE), new BaseSubFilterSelectionFragmentV2$onViewCreated$1$3(this, r115));
        goto L8
    L18:
        r105 = null;
        goto L19
    L20:
        r106 = null;
        goto L21
    L12:
        r102 = null;
        goto L13
    L33:
        return;
    L32:
        return;
    }
}
