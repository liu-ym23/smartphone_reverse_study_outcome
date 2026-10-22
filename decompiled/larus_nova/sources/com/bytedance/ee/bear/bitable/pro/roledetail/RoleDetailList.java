package com.bytedance.ee.bear.bitable.pro.roledetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u00100\u0016R\f0\u0017R\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailList;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView;", "Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailItemData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onCreateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "data", "onBindContentView", "", "itemViewHolder", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;", MapController.ITEM_LAYER_TAG, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoleDetailList extends MultiItemGroupView<RoleDetailItemData> {
    public RoleDetailList(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoleDetailList(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView
    public final /* bridge */ /* synthetic */ int r(GroupMultiItemModel r100) {
        RoleDetailItemData r101 = (RoleDetailItemData) r100;
        return 0;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView
    public final void t(MultiItemGroupView<RoleDetailItemData>.ItemAdapter.ItemViewHolder r100, GroupMultiItemModel r101) {
        RoleDetailItemData r102 = (RoleDetailItemData) r101;
        Intrinsics.checkNotNullParameter(r100, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        TextView r103 = (TextView) r100.f209969a.findViewById(R.id.entityName);
        r103.setText(r102.getEntityName());
        Intrinsics.checkNotNull(r103);
        m.m(r103, true);
        ((TextView) r100.f209969a.findViewById(R.id.entityPermDesc)).setText(r102.getEntityPermission());
        m.z(r100.f209969a.findViewById(R.id.entityPermDesc), r102.getShowPermissionDesc());
        TextView r104 = (TextView) r100.f209969a.findViewById(R.id.groupTitle);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), R.color.text_placeholder));
        Intrinsics.checkNotNull(r104);
        m.r(r104, n.d(8));
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView
    public final View u(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_pro_table_perm_item, r100, false);
    }

    public RoleDetailList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ RoleDetailList(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
