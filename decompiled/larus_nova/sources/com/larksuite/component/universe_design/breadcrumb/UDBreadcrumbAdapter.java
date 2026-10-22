package com.larksuite.component.universe_design.breadcrumb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\u000f2\b\b\u0001\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter$BreadcrumbViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onClickListener", "Lcom/larksuite/component/universe_design/breadcrumb/OnBreadcrumbItemClickListener;", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/universe_design/breadcrumb/OnBreadcrumbItemClickListener;)V", "items", "", "", "itemMaxWidth", "", "setItems", "", "itemList", "", "addItem", MapController.ITEM_LAYER_TAG, "removeItems", "index", "count", "updateItem", "setItemMaxWidth", "maxWidth", "getItemMaxWidth", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "isLastItem", "", "createItemView", "Landroid/view/View;", "BreadcrumbViewHolder", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDBreadcrumbAdapter extends RecyclerView.Adapter<BreadcrumbViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f284558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f284559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f284560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284561d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbAdapter$BreadcrumbViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "labelTv", "Landroid/widget/TextView;", "getLabelTv", "()Landroid/widget/TextView;", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BreadcrumbViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f284562a;

        public BreadcrumbViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f284562a = (TextView) r100.findViewById(R.id.breadcrumb_label_tv);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f284560c).size();
    }

    public UDBreadcrumbAdapter(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onClickListener");
        this.f284558a = r100;
        this.f284559b = r101;
        this.f284560c = new ArrayList();
        this.f284561d = Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BreadcrumbViewHolder r102 = (BreadcrumbViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ListProtector.get(this.f284560c, r101);
        r102.f284562a.setText(r103);
        View r104 = r102.itemView;
        boolean r105 = true;
        if (r101 == (getItemCount() - 1)) goto L5;
        boolean r106 = true;
    L6:
        r104.setEnabled(r106);
        TextView r107 = r102.f284562a;
        if (r101 != (getItemCount() - 1)) goto L10;
        r105 = false;
    L10:
        r107.setEnabled(r105);
        r102.itemView.setOnClickListener(new b(this, r101));
        int r108 = r102.f284562a.getMaxWidth();
        int r109 = this.f284561d;
        if (r108 == r109) goto L14;
        r102.f284562a.setMaxWidth(r109);
        return;
    L14:
        return;
    L5:
        r106 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        TextView r102 = new TextView(this.f284558a, null, 0, R.style.UDBreadcrumbItemLabel);
        r102.setId(R.id.breadcrumb_label_tv);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        r102.setLayoutParams(r103);
        r102.setMaxWidth(this.f284561d);
        LinearLayout r104 = new LinearLayout(this.f284558a, null, 0, R.style.UDBreadcrumbItem);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, d.d(r104.getContext(), R.dimen.ud_breadcrumb_item_height)));
        r104.setOrientation(0);
        r104.addView(r102);
        return new BreadcrumbViewHolder(r104);
    }
}
