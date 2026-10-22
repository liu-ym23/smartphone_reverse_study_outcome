package com.bytedance.ee.bear.bitable.homepage.recommend;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.templates.ITemplateViewHolder;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateShowCardType;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/HomePageDiscoveryTemplateAdapter;", "Lcom/bytedance/ee/bear/templates/TemplateAdapter;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", "form", "", "type", "", "categoryName", "uniqueID", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/bytedance/ee/bear/templates/LayoutType;Ljava/lang/String;ILjava/lang/String;J)V", "onCreateViewHolder", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomePageDiscoveryTemplateAdapter extends TemplateAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LifecycleOwner f213000i;

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter
    public final ITemplateViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ITemplateViewHolder r102 = super.z2(r100, r101);
        if (r101 != TemplateShowCardType.SHOW_CARD_TYPE_HEAD.ordinal()) goto L5;
        r102.itemView.setBackgroundColor(UIHelper.getColor(R.color.bg_body));
    L5:
        return r102;
    }

    public HomePageDiscoveryTemplateAdapter(LifecycleOwner r100, LayoutType r110, int r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r110, "layoutType");
        super(r100, r110, null, r111, r112, r113);
        this.f213000i = r100;
    }
}
