package com.bytedance.ee.bear.bitable.homepage.recommend;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u001c\u0010\u000b\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/HomePageDiscoveryCategoryIndicatorAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/templates/data/CategoryTab;", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/HomePageDiscoveryCategoryIndicatorAdapter$ViewHolder;", "<init>", "()V", "selectedPosition", "", "setSelectedPosition", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "convert", "helper", MapController.ITEM_LAYER_TAG, "ViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomePageDiscoveryCategoryIndicatorAdapter extends BaseQuickAdapter<CategoryTab, ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f212999a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/HomePageDiscoveryCategoryIndicatorAdapter$ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/homepage/recommend/HomePageDiscoveryCategoryIndicatorAdapter;Landroid/view/View;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        public ViewHolder(HomePageDiscoveryCategoryIndicatorAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            super(r101);
        }
    }

    public HomePageDiscoveryCategoryIndicatorAdapter() {
        super(R.layout.homepage_discovery_categories_item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, CategoryTab r101) {
        ViewHolder r102 = (ViewHolder) r100;
        CategoryTab r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "helper");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.setText(R.id.categoriesTv, r103.getCategoryTabName());
        int r104 = getData().indexOf(r103);
        Resources r105 = r102.itemView.getResources();
        int r106 = h18.e.f483540a;
        Typeface r107 = h18.e.a(this.mContext);
        if (r104 != this.f212999a) goto L5;
        r102.setTextColor(R.id.categoriesTv, r105.getColor(R.color.primary_fill_default));
        r102.setBackgroundRes(R.id.categoriesTv, R.drawable.catagore_item_select_bg);
        ((TextView) r102.getView(R.id.categoriesTv)).setTypeface(r107, 1);
        return;
    L5:
        r102.setTextColor(R.id.categoriesTv, r105.getColor(R.color.icon_n2));
        r102.setBackgroundRes(R.id.categoriesTv, R.drawable.catagore_item_bg);
        ((TextView) r102.getView(R.id.categoriesTv)).setTypeface(r107, 0);
    }
}
