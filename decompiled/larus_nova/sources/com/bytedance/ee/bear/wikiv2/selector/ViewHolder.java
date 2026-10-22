package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroid/widget/LinearLayout;", "getContentView", "()Landroid/widget/LinearLayout;", "setContentView", "(Landroid/widget/LinearLayout;)V", "itemName", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getItemName", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "setItemName", "(Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;)V", "itemIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setItemIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f241125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpaceTagTitleView f241126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f241127c;

    public ViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.item_content);
        this.f241125a = r101;
        this.f241126b = (SpaceTagTitleView) r101.findViewById(R.id.item_name);
        this.f241127c = (AppCompatImageView) r101.findViewById(R.id.item_icon);
    }
}
