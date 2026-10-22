package com.bytedance.ee.bear.bitable.homepage.list;

import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.star.FavoriteListStyleAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/list/BitableFavoriteListStyleAdapter;", "Lcom/bytedance/ee/bear/list/star/FavoriteListStyleAdapter;", EventConstant.Key.MODULE, "", "locale", "layoutManager", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/DocsLinearLayoutManager;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/DocsLinearLayoutManager;Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "onCreateDefViewHolder", "Lcom/chad/library/adapter/base/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableFavoriteListStyleAdapter extends FavoriteListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ListStyleViewHolder r102 = new ListStyleViewHolder(pd5.c.a.f528677a.a(r100.getContext()));
        int r103 = UIHelper.getDimens(R.dimen.bitable_homepage_list_height);
        r102.f228499a.getLayoutParams().height = r103;
        r102.f228500b.getLayoutParams().height = r103;
        return r102;
    }

    public BitableFavoriteListStyleAdapter(String r100, DocsLinearLayoutManager r101, ce5.a r102) {
        super("lark_workspace_bitable_landing", r100, r101, r102, null);
    }
}
