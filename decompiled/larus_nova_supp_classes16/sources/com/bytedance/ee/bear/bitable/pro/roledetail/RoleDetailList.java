package com.bytedance.ee.bear.bitable.pro.roledetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u00100\u0016R\f0\u0017R\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailList;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView;", "Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailItemData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onCreateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "data", "onBindContentView", "", "itemViewHolder", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;", "item", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoleDetailList extends MultiItemGroupView<RoleDetailItemData> {
    public RoleDetailList(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RoleDetailList(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final /* bridge */ /* synthetic */ int r(GroupMultiItemModel r1) {
        RoleDetailItemData r2 = (RoleDetailItemData) r1;
        return 0;
    }

    public final void t(MultiItemGroupView.ItemAdapter.ItemViewHolder r4, GroupMultiItemModel r5) {
        RoleDetailItemData r6 = (RoleDetailItemData) r5;
        Intrinsics.checkNotNullParameter(r4, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r6, "item");
        TextView r0 = (TextView) r4.a.findViewById(2131371695);
        r0.setText(r6.getEntityName());
        Intrinsics.checkNotNull(r0);
        m.m(r0, true);
        ((TextView) r4.a.findViewById(2131371696)).setText(r6.getEntityPermission());
        m.z(r4.a.findViewById(2131371696), r6.getShowPermissionDesc());
        TextView r7 = (TextView) r4.a.findViewById(2131373908);
        r7.setTextColor(ContextCompat.getColor(r7.getContext(), 2131106620));
        Intrinsics.checkNotNull(r7);
        m.r(r7, n.d(8));
    }

    public final View u(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return LayoutInflater.from(r3.getContext()).inflate(2131559127, r3, false);
    }

    public RoleDetailList(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ RoleDetailList(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
