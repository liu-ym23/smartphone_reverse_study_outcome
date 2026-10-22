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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u001b\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter$MenuViewHolder;", "<init>", "()V", "mMenuList", "", "Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "mOnMenuClickListener", "Lkotlin/Function1;", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateMenuList", "menuArray", "", "([Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;)V", "setOnMenuClickListener", "listener", "MenuViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarMenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    public final List<ToolbarData.MenuItem> a;
    public Function1<? super String, Unit> b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter$MenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/toolbox/view/ToolbarMenuAdapter;Landroid/view/View;)V", "mMenuContainer", "mMenuIcon", "Landroid/widget/ImageView;", "mMenuTitle", "Landroid/widget/TextView;", "mCountTV", "mTipIcIv", "badgeView", "setMenuItem", "", "menuItem", "Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MenuViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final ImageView b;
        public final TextView c;
        public final TextView d;
        public final View e;
        public final View f;
        public final /* synthetic */ ToolbarMenuAdapter g;

        public MenuViewHolder(ToolbarMenuAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.g = r2;
            super(r3);
            this.a = r3.findViewById(2131379903);
            this.b = (ImageView) r3.findViewById(2131379912);
            this.c = (TextView) r3.findViewById(2131379932);
            this.d = (TextView) r3.findViewById(2131368004);
            this.e = r3.findViewById(2131388727);
            this.f = r3.findViewById(2131374087);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public ToolbarMenuAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        MenuViewHolder r12 = (MenuViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        if (r11 >= 0) goto L5;
        return;
    L5:
        if (r11 >= ((ArrayList) this.a).size()) goto L37;
        ToolbarData.MenuItem r13 = (ToolbarData.MenuItem) ListProtector.get(this.a, r11);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "menuItem");
        ((RecyclerView.ViewHolder) r12).itemView.setTag(r13.getId());
        ToolbarMenuAdapter r0 = r12.g;
        EToolbarMenu.a r1 = EToolbarMenu.Companion;
        String r2 = r13.getId();
        r1.getClass();
        EToolbarMenu[] r3 = EToolbarMenu.values();
        int r4 = r3.length;
        int r5 = 0;
        int r6 = 0;
    L8:
        String r7 = null;
        if (r6 >= r4) goto L14;
        EToolbarMenu r8 = r3[r6];
        if (TextUtils.equals(r8.getValue(), r2) == true) goto L15;
        r6 = r6 + 1;
    L15:
        if (r8 == null) goto L17;
        r12.b.setSelected(r13.getActive());
        r12.b.setImageResource(r8.getResId());
    L17:
        r12.c.setSelected(r13.getActive());
        r12.c.setText(r13.getTitle());
        TextView r9 = r12.d;
        if (r13.getActive() == false) goto L20;
        int r14 = 0;
    L21:
        r9.setVisibility(r14);
        TextView r16 = r12.d;
        Integer r17 = r13.getCount();
        if (r17 == null) goto L24;
        r7 = r17.toString();
    L24:
        r16.setText(r7);
        View r18 = r12.e;
        if (r13.getHasInvalidCondition() == false) goto L27;
        int r19 = 0;
    L28:
        r18.setVisibility(r19);
        View r20 = r12.f;
        if (r13.getShowBadge() == true) goto L32;
        r5 = 8;
    L32:
        r20.setVisibility(r5);
        r12.a.setOnClickListener(new f(r13, r12, r0));
        return;
    L27:
        r19 = 8;
        goto L28
    L20:
        r14 = 8;
        goto L21
    L14:
        r8 = null;
        goto L15
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new MenuViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131559175, r4, false));
    }
}
