package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006012345B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0016H\u0005J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020\u0016H\u0004J\u001a\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0016H\u0004J \u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0016H\u0004R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "<init>", "([Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;)V", "[Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "itemClickListener", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$OnItemClickListener;", "toolbarConfig", "Lcom/bytedance/ee/bear/api/registry/IToolbarConfig;", "toolbarContext", "Lcom/bytedance/ee/bear/api/registry/ToolbarContext;", "getToolbarContext", "()Lcom/bytedance/ee/bear/api/registry/ToolbarContext;", "setToolbarContext", "(Lcom/bytedance/ee/bear/api/registry/ToolbarContext;)V", "getItems", "()[Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "getItemCount", "", "updateItems", "", "newItems", "setItemClickListener", "listener", "parseColor", "color", "", "defColor", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemViewFactory", "Lcom/bytedance/ee/bear/api/registry/ToolbarItemViewFactory;", "getCustomViewHolder", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$CustomViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "setIconAttrs", "subToolbarViewHolder", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$SubToolbarViewHolder;", MapController.ITEM_LAYER_TAG, "resId", "OnItemClickListener", "DividerViewHolder", "SubToolbarViewHolder", "TextColorViewHolder", "CustomViewHolder", "Companion", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubToolbarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemV2[] f226205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f226206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public an4.a f226207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public an4.b f226208d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$CustomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$SubToolbarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mIcon", "Landroid/widget/ImageView;", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubToolbarViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f226209a;

        public SubToolbarViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_icon);
            this.f226209a = r101;
            com.bytedance.ee.util.ui.l.c(r101, R.color.icon_n1);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarAdapter$TextColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "colorRect", "icon", "Landroid/widget/ImageView;", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TextColorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f226210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f226211b;

        public TextColorViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f226210a = r100.findViewById(R.id.textColorRect);
            ImageView r101 = (ImageView) r100.findViewById(R.id.icon);
            this.f226211b = r101;
            com.bytedance.ee.util.ui.l.c(r101, R.color.icon_n1);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(ItemV2 r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSubToolbarAdapter f226212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ItemV2[] f226213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f226214c;

        public c(BaseSubToolbarAdapter r100, ItemV2[] r101, int r102) {
            this.f226212a = r100;
            this.f226213b = r101;
            this.f226214c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f226212a.f226206b;
            if (r101 == null) goto L6;
            r101.a(this.f226213b[this.f226214c]);
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ItemV2[] r100 = this.f226205a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.length;
    }

    public BaseSubToolbarAdapter(ItemV2[] r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f226205a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        if (y2(r100) == null) goto L7;
        return r100 + 1000;
    L7:
        return super.getItemViewType(r100);
    }

    public final an4.g y2(int r100) {
        ItemV2[] r101 = this.f226205a;
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        ItemV2 r103 = r101[r100];
        an4.a r104 = this.f226207c;
        if (r104 == null) goto L29;
        ItemIdV2 r105 = r103.id();
        Set<an4.e> r106 = r104.getItemFactorySet();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        Object r109 = r108.next();
        if ((r109 instanceof an4.g) == false) goto L9;
        r107.add(r109);
        goto L9
    L13:
        Iterator r110 = r107.iterator();
    L15:
        if (r110.hasNext() == false) goto L20;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((an4.e) r111).getItemId().name(), r105.name()) == false) goto L15;
        r102 = r111;
    L20:
        return (an4.g) ((an4.e) r102);
    L29:
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ItemV2[] r102 = this.f226205a;
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof CustomViewHolder) == false) goto L16;
        an4.g r103 = y2(r101);
        if (r103 == null) goto L22;
        an4.b r104 = this.f226208d;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContext");
        r104 = null;
    L13:
        r103.a(r104, r100.itemView, r102[r101]);
        return;
    L22:
        return;
    L16:
        if ((r100 instanceof DividerViewHolder) == false) goto L18;
        return;
    L18:
        if (r101 >= r102.length) goto L24;
        r100.itemView.setOnClickListener(new c(this, r102, r101));
        return;
    }

    public final int z2(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "color");
    L9:
        th = move-exception;
        tt5.a.e("BaseSubToolbarAdapter", "color:" + r100, th, false);
    L11:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L11;
        return ColorUtils.h(r100);
    }

    public final void A2(SubToolbarViewHolder r100, ItemV2 r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "subToolbarViewHolder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        an4.a r103 = this.f226207c;
        Integer r104 = null;
        if (r103 == null) goto L5;
        an4.e r105 = an4.h.a(r103, r101.id());
    L6:
        if (r105 == null) goto L10;
        Integer r106 = r105.getIconRes();
        if (r106 == null) goto L10;
        r102 = r106.intValue();
    L10:
        if (r105 == null) goto L16;
        an4.d r107 = r105.getToolbarIconDecoration();
        if (r107 == null) goto L16;
        Integer r108 = r107.f4498a;
        if (r108 == null) goto L16;
    L23:
        int r109 = r108.intValue();
    L25:
        if (r105 == null) goto L31;
        an4.d r110 = r105.getToolbarIconDecoration();
        if (r110 == null) goto L31;
        Integer r111 = r110.f4499b;
        if (r111 == null) goto L31;
        int r112 = r111.intValue();
    L39:
        ImageView r113 = r100.f226209a;
        r113.setImageResource(r102);
        r113.setImageTintList(r113.getResources().getColorStateList(r109));
        r113.setBackground(r113.getResources().getDrawable(r112));
        if (r101.isEnable() == true) goto L42;
    L44:
        boolean r114 = false;
    L45:
        r113.setSelected(r114);
        r113.setEnabled(r101.isEnable());
        return;
    L42:
        if (r101.isSelected() == false) goto L44;
        r114 = true;
    L31:
        an4.a r115 = this.f226207c;
        if (r115 == null) goto L36;
        an4.d r116 = r115.getGlobalDecoration();
        if (r116 == null) goto L36;
        r104 = r116.f4499b;
    L36:
        if (r104 == null) goto L38;
        r112 = r104.intValue();
        goto L39
    L38:
        r112 = R.drawable.core_doc_toolbar_v2_subitem_all_selector;
    L16:
        an4.a r117 = this.f226207c;
        if (r117 == null) goto L21;
        an4.d r118 = r117.getGlobalDecoration();
        if (r118 == null) goto L21;
        r108 = r118.f4498a;
    L22:
        if (r108 != null) goto L23;
        r109 = R.color.core_toolbar_item_tint;
    L21:
        r108 = null;
        goto L22
    L5:
        r105 = null;
        goto L6
    }
}
