package com.larus.office.base.plugins.toolbar.submenu;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.docsdk.impl.utils.TintUtils;
import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.model.Item;
import kn9.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 )2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0005%&'()B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001d\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u001c\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0013H\u0004J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0013H\u0004R$\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "<init>", "([Lcom/larus/office/base/plugins/toolbar/model/Item;)V", "getItems", "()[Lcom/larus/office/base/plugins/toolbar/model/Item;", "setItems", "[Lcom/larus/office/base/plugins/toolbar/model/Item;", "itemClickListener", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$OnItemClickListener;", "getItemClickListener", "()Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$OnItemClickListener;", "setItemClickListener", "(Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$OnItemClickListener;)V", "getItemCount", "", "updateItems", "", "newItems", "setOnItemClickListener", "listener", "parseColor", "color", "", "defColor", "onBindViewHolder", "holder", "position", "setIconAttrs", "subToolbarViewHolder", "Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$SubToolbarViewHolder;", MapController.ITEM_LAYER_TAG, "resId", "OnItemClickListener", "DividerViewHolder", "SubToolbarViewHolder", "TextColorViewHolder", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubToolbarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Item[] f360938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f360939b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$SubToolbarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mIcon", "Landroid/widget/ImageView;", "getMIcon", "()Landroid/widget/ImageView;", "setMIcon", "(Landroid/widget/ImageView;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubToolbarViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f360940a;

        public SubToolbarViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_icon);
            this.f360940a = r101;
            TintUtils.updateImageTint(r101, R.color.icon_n1);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/submenu/BaseSubToolbarAdapter$TextColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "colorRect", "getColorRect", "()Landroid/view/View;", "setColorRect", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TextColorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f360941a;

        public TextColorViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f360941a = r100.findViewById(R.id.textColorRect);
            TintUtils.updateImageTint((ImageView) r100.findViewById(R.id.icon), R.color.icon_n1);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Item r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f360938a.length;
    }

    public BaseSubToolbarAdapter(Item[] r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f360938a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof DividerViewHolder) == true) goto L11;
        Item[] r102 = this.f360938a;
        if (r102 == null) goto L12;
        Intrinsics.checkNotNull(r102);
        if (r101 >= r102.length) goto L13;
        r100.itemView.setOnClickListener(new g(this, r101));
        return;
    L13:
        return;
    L12:
        return;
    }
}
