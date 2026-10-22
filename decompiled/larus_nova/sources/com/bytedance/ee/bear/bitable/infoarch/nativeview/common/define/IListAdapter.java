package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0006H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IListAdapter$BaseViewHolder;", "<init>", "()V", "setData", "", "list", "", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderItem;", "setFooter", ContainerPosition.FOOTER, "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "updateUI", "getCurrentGroupPositions", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "scrollToGroupPosition", "scrollGroupPosition", "getIndex", "", "groupPosition", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)Ljava/lang/Integer;", "BaseViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IListAdapter;Landroid/view/View;)V", "groupPosition", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "getGroupPosition", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "setGroupPosition", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BaseViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GroupPosition f213302a;

        public BaseViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public void A2(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "scrollGroupPosition");
    }

    public abstract void B2(SimpleItemModel r100);

    public void C2() {
    }

    public void setData(List<RenderItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
    }

    public List<GroupPosition> y2() {
        return CollectionsKt.emptyList();
    }

    public IListAdapter() {
    }

    public Integer z2(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPosition");
        return 0;
    }
}
