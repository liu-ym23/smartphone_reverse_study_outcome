package com.bytedance.ee.bear.templates.center.list;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u001c\u0010\u000b\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/list/CategoryIndicatorAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/templates/data/CategoryTab;", "Lcom/bytedance/ee/bear/templates/center/list/CategoryIndicatorAdapter$ViewHolder;", "<init>", "()V", "selectedPosition", "", "setSelectedPosition", "", "pos", "convert", "helper", "item", "ViewHolder", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryIndicatorAdapter extends BaseQuickAdapter<CategoryTab, ViewHolder> {
    public int a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/list/CategoryIndicatorAdapter$ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/templates/center/list/CategoryIndicatorAdapter;Landroid/view/View;)V", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        public ViewHolder(CategoryIndicatorAdapter r1, View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public CategoryIndicatorAdapter() {
        super(2131559267);
    }

    public final void convert(BaseViewHolder r4, Object r5) {
        ViewHolder r6 = (ViewHolder) r4;
        CategoryTab r7 = (CategoryTab) r5;
        Intrinsics.checkNotNullParameter(r6, "helper");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.setText(2131365284, r7.getCategoryTabName());
        int r8 = getData().indexOf(r7);
        Resources r0 = ((RecyclerView.ViewHolder) r6).itemView.getResources();
        if (r8 != this.a) goto L5;
        r6.setTextColor(2131365284, r0.getColor(2131105548));
        r6.setBackgroundRes(2131365284, 2131232535);
        return;
    L5:
        r6.setTextColor(2131365284, r0.getColor(2131102419));
        r6.setBackgroundRes(2131365284, 2131232534);
    }
}
