package com.bytedance.ee.bear.templates.center.list.business;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListFragment;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter;
import com.bytedance.ee.bear.templates.center.list.base.p;
import com.bytedance.ee.bear.templates.center.list.base.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/list/business/BusinessTemplateListFragment;", "Lcom/bytedance/ee/bear/templates/center/list/base/BaseTemplateListFragment;", "<init>", "()V", "getIModel", "Lcom/bytedance/ee/bear/templates/center/list/base/IBaseTemplateListModel;", "getIView", "Lcom/bytedance/ee/bear/templates/center/list/base/IBaseTemplateListView;", "rootView", "Landroid/view/View;", "getIPresenter", "Lcom/bytedance/ee/bear/templates/center/list/base/BaseTemplateListPresenter;", "model", "view", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BusinessTemplateListFragment extends BaseTemplateListFragment {
    public static final /* synthetic */ int e = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListFragment
    public final p S90() {
        FragmentActivity r1 = getActivity();
        Intrinsics.checkNotNull(r1);
        return new BusinessTemplateListModel(r1);
    }

    public BusinessTemplateListFragment() {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListFragment
    public final q U90(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        FragmentActivity r1 = getActivity();
        Intrinsics.checkNotNull(r1);
        return new com.bytedance.ee.bear.templates.center.list.business.a(r1, this, r3);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListFragment
    public final BaseTemplateListPresenter T90(p r3, q r4) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        return new BaseTemplateListPresenter(this, r3, r4, getString(2131887904));
    }
}
