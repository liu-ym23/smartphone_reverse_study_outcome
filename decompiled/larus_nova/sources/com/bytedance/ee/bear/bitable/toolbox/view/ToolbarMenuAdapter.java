package com.bytedance.ee.bear.bitable.toolbox.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.EToolbarMenu;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u001b\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter$MenuViewHolder;", "<init>", "()V", "mMenuList", "", "Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "mOnMenuClickListener", "Lkotlin/Function1;", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateMenuList", "menuArray", "", "([Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;)V", "setOnMenuClickListener", "listener", "MenuViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarMenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ToolbarData.MenuItem> f216026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f216027b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter$MenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter;Landroid/view/View;)V", "mMenuContainer", "mMenuIcon", "Landroid/widget/ImageView;", "mMenuTitle", "Landroid/widget/TextView;", "mCountTV", "mTipIcIv", "badgeView", "setMenuItem", "", "menuItem", "Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MenuViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f216028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f216029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f216030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f216031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f216032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f216033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ToolbarMenuAdapter f216034g;

        public MenuViewHolder(ToolbarMenuAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f216034g = r100;
            super(r101);
            this.f216028a = r101.findViewById(R.id.menu_container);
            this.f216029b = (ImageView) r101.findViewById(R.id.menu_icon);
            this.f216030c = (TextView) r101.findViewById(R.id.menu_title);
            this.f216031d = (TextView) r101.findViewById(R.id.count);
            this.f216032e = r101.findViewById(R.id.tip_icon);
            this.f216033f = r101.findViewById(R.id.guideBadge);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f216026a).size();
    }

    public ToolbarMenuAdapter() {
        this.f216026a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        MenuViewHolder r112 = (MenuViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        if (r111 >= 0) goto L5;
        return;
    L5:
        if (r111 >= ((ArrayList) this.f216026a).size()) goto L37;
        ToolbarData.MenuItem r113 = (ToolbarData.MenuItem) ListProtector.get(this.f216026a, r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "menuItem");
        r112.itemView.setTag(r113.getId());
        ToolbarMenuAdapter r100 = r112.f216034g;
        EToolbarMenu.a r101 = EToolbarMenu.Companion;
        String r102 = r113.getId();
        r101.getClass();
        EToolbarMenu[] r103 = EToolbarMenu.values();
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L8:
        String r107 = null;
        if (r106 >= r104) goto L14;
        EToolbarMenu r108 = r103[r106];
        if (TextUtils.equals(r108.getValue(), r102) == true) goto L15;
        r106 = r106 + 1;
    L15:
        if (r108 == null) goto L17;
        r112.f216029b.setSelected(r113.getActive());
        r112.f216029b.setImageResource(r108.getResId());
    L17:
        r112.f216030c.setSelected(r113.getActive());
        r112.f216030c.setText(r113.getTitle());
        TextView r109 = r112.f216031d;
        if (r113.getActive() == false) goto L20;
        int r114 = 0;
    L21:
        r109.setVisibility(r114);
        TextView r115 = r112.f216031d;
        Integer r116 = r113.getCount();
        if (r116 == null) goto L24;
        r107 = r116.toString();
    L24:
        r115.setText(r107);
        View r117 = r112.f216032e;
        if (r113.getHasInvalidCondition() == false) goto L27;
        int r118 = 0;
    L28:
        r117.setVisibility(r118);
        View r119 = r112.f216033f;
        if (r113.getShowBadge() == true) goto L32;
        r105 = 8;
    L32:
        r119.setVisibility(r105);
        r112.f216028a.setOnClickListener(new f(r113, r112, r100));
        return;
    L27:
        r118 = 8;
        goto L28
    L20:
        r114 = 8;
        goto L21
    L14:
        r108 = null;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new MenuViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_toolbar_menu_item, r100, false));
    }
}
