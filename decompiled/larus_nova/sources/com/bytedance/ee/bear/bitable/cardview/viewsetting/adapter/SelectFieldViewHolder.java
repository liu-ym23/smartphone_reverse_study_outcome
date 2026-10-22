package com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/SelectFieldViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "fieldIcon", "Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "getFieldIcon", "()Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "leftIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getLeftIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "rightIcon", "getRightIcon", "fieldNameTv", "Landroid/widget/TextView;", "getFieldNameTv", "()Landroid/widget/TextView;", "itemRightLayout", "Landroid/widget/FrameLayout;", "getItemRightLayout", "()Landroid/widget/FrameLayout;", "itemLeftLayout", "getItemLeftLayout", "initStyle", "", "position", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectFieldViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SyncIconImageView f209235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f209236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f209237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f209238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f209239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f209240f;

    public void T3() {
        this.f209236b.setImageResource(R.drawable.ud_icon_delete_colorful);
        this.f209237c.setImageResource(R.drawable.ud_icon_menu_outlined);
    }

    public SelectFieldViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(LayoutInflater.from(r100.getContext()).inflate(R.layout.viewsetting_field_list_item, r100, false));
        this.f209235a = (SyncIconImageView) this.itemView.findViewById(R.id.fieldIcon);
        this.f209236b = (AppCompatImageView) this.itemView.findViewById(R.id.itemLeftIcon);
        this.f209237c = (AppCompatImageView) this.itemView.findViewById(R.id.itemRightIcon);
        this.f209238d = (TextView) this.itemView.findViewById(R.id.fieldName);
        this.f209239e = (FrameLayout) this.itemView.findViewById(R.id.itemRightLayout);
        this.f209240f = (FrameLayout) this.itemView.findViewById(R.id.itemLeftLayout);
    }
}
