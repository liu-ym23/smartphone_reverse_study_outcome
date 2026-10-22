package com.bytedance.ee.bear.content.common.morepanel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000bJ\"\u0010\u0019\u001a\u00020\u00132\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001cR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/content/common/morepanel/ViewHolder;", "<init>", "()V", "mData", "", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "mContext", "Landroid/content/Context;", "mListener", "Lcom/bytedance/ee/bear/content/common/morepanel/OnItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "initBackground", "setOnItemClickListener", "listener", "updateData", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonPanelAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<CommonMorePanelItemData> f216788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f216789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public hw4.d f216790c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f216788a.size();
    }

    public CommonPanelAdapter() {
        this.f216788a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        CommonMorePanelItemData r100 = (CommonMorePanelItemData) ListProtector.get(this.f216788a, r111);
        int r101 = getItemCount();
        if (r111 != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r111 != (r101 - 1)) goto L9;
        boolean r103 = true;
    L10:
        if (r102 == false) goto L13;
        if (r103 == false) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        int r105 = R.drawable.facade_round_around_m;
    L21:
        r112.itemView.setBackgroundResource(r105);
        View r106 = r112.itemView;
        Context r107 = this.f216789b;
        ViewGroup.LayoutParams r108 = null;
        if (r107 == null) goto L26;
        Resources r109 = r107.getResources();
        if (r109 == null) goto L26;
        ColorStateList r113 = r109.getColorStateList(R.color.facade_selector_item_float);
    L27:
        r106.setBackgroundTintList(r113);
        if (r100.f216781b <= 0) goto L35;
        ImageView r114 = r112.f216791a;
        if (r114 == null) goto L32;
        r114.setVisibility(0);
    L32:
        ImageView r115 = r112.f216791a;
        if (r115 == null) goto L39;
        r115.setImageResource(r100.f216781b);
    L39:
        if (r100.f216783d <= 0) goto L46;
        ImageView r116 = r112.f216793c;
        if (r116 == null) goto L43;
        r116.setVisibility(0);
    L43:
        ImageView r117 = r112.f216793c;
        if (r117 == null) goto L50;
        r117.setImageResource(r100.f216783d);
    L50:
        if (r100.f216785f == false) goto L59;
        l.c(r112.f216791a, R.color.icon_n1);
        l.c(r112.f216793c, R.color.icon_n1);
        Context r118 = this.f216789b;
        if (r118 == null) goto L68;
        TextView r119 = r112.f216792b;
        if (r119 == null) goto L56;
        r119.setTextColor(r118.getResources().getColor(R.color.text_title));
    L56:
        TextView r120 = r112.f216794d;
        if (r120 == null) goto L68;
        r120.setTextColor(r118.getResources().getColor(R.color.text_caption));
    L68:
        if (r100.f216786g <= 0) goto L76;
        ImageView r121 = r112.f216793c;
        if (r121 == null) goto L72;
        r108 = r121.getLayoutParams();
    L72:
        if (r108 == null) goto L76;
        int r122 = r100.f216786g;
        r108.height = r122;
        r108.width = r122;
        ImageView r123 = r112.f216793c;
        if (r123 == null) goto L76;
        r123.setLayoutParams(r108);
    L76:
        int r124 = r100.f216787h;
        if (r124 <= 0) goto L79;
        l.c(r112.f216793c, r124);
    L79:
        TextView r125 = r112.f216792b;
        if (r125 == null) goto L82;
        r125.setText(r100.f216782c);
    L82:
        TextView r126 = r112.f216794d;
        if (r126 == null) goto L86;
        r126.setText(r100.f216784e);
    L86:
        if (r111 != (this.f216788a.size() - 1)) goto L90;
        View r127 = r112.f216795e;
        if (r127 == null) goto L93;
        r127.setVisibility(8);
    L93:
        r112.itemView.setOnClickListener(new hw4.c(r100, this, r111));
        return;
    L90:
        View r128 = r112.f216795e;
        if (r128 == null) goto L93;
        r128.setVisibility(0);
        goto L93
    L59:
        l.c(r112.f216791a, R.color.icon_disabled);
        l.c(r112.f216793c, R.color.icon_disabled);
        Context r129 = this.f216789b;
        if (r129 == null) goto L68;
        TextView r130 = r112.f216792b;
        if (r130 == null) goto L64;
        r130.setTextColor(r129.getResources().getColor(R.color.text_disabled));
    L64:
        TextView r131 = r112.f216794d;
        if (r131 == null) goto L68;
        r131.setTextColor(r129.getResources().getColor(R.color.text_disabled));
        goto L68
    L46:
        ImageView r132 = r112.f216793c;
        if (r132 == null) goto L50;
        r132.setVisibility(8);
        goto L50
    L35:
        ImageView r133 = r112.f216791a;
        if (r133 == null) goto L39;
        r133.setVisibility(8);
    L26:
        r113 = null;
        goto L27
    L16:
        if (r102 == false) goto L18;
        r105 = R.drawable.facade_round_top_m;
        goto L21
    L18:
        if (r103 == false) goto L20;
        r105 = R.drawable.facade_round_bottom_m;
        goto L21
    L20:
        r105 = R.drawable.facade_rectangle;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f216789b = r100.getContext();
        return new ViewHolder(LayoutInflater.from(this.f216789b).inflate(R.layout.common_panel_item, r100, false));
    }
}
