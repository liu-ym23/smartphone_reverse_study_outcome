package com.bytedance.ee.bear.middleground.permission.widget.editpermdialog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vi5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermItemModel;", "Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter$EditPermViewHolder;", "<init>", "()V", "convert", "", "helper", "item", "getColor", "", "view", "Landroid/view/View;", "getTipsColor", "EditPermViewHolder", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditPermAdapter extends BaseQuickAdapter<c, EditPermViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter$EditPermViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/widget/editpermdialog/EditPermAdapter;Landroid/view/View;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class EditPermViewHolder extends BaseViewHolder {
        public EditPermViewHolder(EditPermAdapter r1, View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public EditPermAdapter() {
        super(2131564171, new ArrayList());
    }

    public final void convert(BaseViewHolder r7, Object r8) {
        EditPermViewHolder r9 = (EditPermViewHolder) r7;
        c r10 = (c) r8;
        Intrinsics.checkNotNullParameter(r9, "helper");
        Intrinsics.checkNotNullParameter(r10, "item");
        BaseViewHolder r0 = r9.setText(2131368824, r10.a);
        View r2 = ((RecyclerView.ViewHolder) r9).itemView;
        int r4 = 2131106610;
        if (r10.e == false) goto L5;
        int r3 = r10.b;
    L6:
        BaseViewHolder r1 = r0.setTextColor(2131368824, r2.getResources().getColor(r3)).setText(2131388720, r10.c);
        if (r10.c.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        BaseViewHolder r6 = r1.setGone(2131388720, r5);
        View r11 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r10.e == false) goto L13;
        r4 = 2131106620;
    L13:
        r6.setTextColor(2131388720, r11.getResources().getColor(r4)).setEnabled(2131368824, r10.e).setGone(2131385825, r10.d).setGone(2131369197, r10.f);
        if (r10.e == true) goto L16;
    L18:
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(null);
        return;
    L16:
        if (r10.d == true) goto L18;
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(r10.g);
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = 2131106610;
        goto L6
    }
}
