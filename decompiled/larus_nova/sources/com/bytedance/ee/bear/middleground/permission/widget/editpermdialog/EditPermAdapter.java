package com.bytedance.ee.bear.middleground.permission.widget.editpermdialog;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vi5.c;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermItemModel;", "Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter$EditPermViewHolder;", "<init>", "()V", "convert", "", "helper", MapController.ITEM_LAYER_TAG, "getColor", "", "view", "Landroid/view/View;", "getTipsColor", "EditPermViewHolder", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditPermAdapter extends BaseQuickAdapter<c, EditPermViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter$EditPermViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter;Landroid/view/View;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class EditPermViewHolder extends BaseViewHolder {
        public EditPermViewHolder(EditPermAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            super(r101);
        }
    }

    public EditPermAdapter() {
        super(R.layout.perm_edit_perm_dialog_item, new ArrayList());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, c r101) {
        EditPermViewHolder r102 = (EditPermViewHolder) r100;
        c r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "helper");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        BaseViewHolder r104 = r102.setText(R.id.descTv, r103.f555336a);
        View r105 = r102.itemView;
        boolean r106 = r103.f555340e;
        int r107 = R.color.text_disable;
        if (r106 == false) goto L5;
        int r108 = r103.f555337b;
    L6:
        BaseViewHolder r109 = r104.setTextColor(R.id.descTv, r105.getResources().getColor(r108)).setText(R.id.tipTv, r103.f555338c);
        if (r103.f555338c.length() <= 0) goto L9;
        boolean r110 = true;
    L10:
        BaseViewHolder r111 = r109.setGone(R.id.tipTv, r110);
        View r112 = r102.itemView;
        if (r103.f555340e == false) goto L13;
        r107 = R.color.text_placeholder;
    L13:
        r111.setTextColor(R.id.tipTv, r112.getResources().getColor(r107)).setEnabled(R.id.descTv, r103.f555340e).setGone(R.id.selectedIcon, r103.f555339d).setGone(R.id.divider, r103.f555341f);
        if (r103.f555340e == true) goto L16;
    L18:
        r102.itemView.setOnClickListener(null);
        return;
    L16:
        if (r103.f555339d == true) goto L18;
        r102.itemView.setOnClickListener(r103.f555342g);
        return;
    L9:
        r110 = false;
        goto L10
    L5:
        r108 = R.color.text_disable;
        goto L6
    }
}
