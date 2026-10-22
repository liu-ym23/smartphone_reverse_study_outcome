package com.bytedance.ee.bear.office.list.selectpanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter$ActionViewHolder;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelItemSpec;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "submitList", "nextItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ActionViewHolder", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSelectPanelAdapter extends RecyclerView.Adapter<ActionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<d, Unit> f235956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f235957b;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter$ActionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelItemSpec;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "icon", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "bind", MapController.ITEM_LAYER_TAG, "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActionViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<d, Unit> f235958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f235959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f235960c;

        /* JADX WARN: Multi-variable type inference failed */
        public ActionViewHolder(View r100, Function1<? super d, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
            super(r100);
            this.f235958a = r101;
            this.f235959b = (ImageView) r100.findViewById(R.id.office_select_panel_item_icon);
            this.f235960c = (TextView) r100.findViewById(R.id.office_select_panel_item_title);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f235957b).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSelectPanelAdapter(Function1<? super d, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f235956a = r100;
        this.f235957b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ActionViewHolder r102 = (ActionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        d r103 = (d) ListProtector.get(this.f235957b, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f235959b.setImageResource(r103.f236024c);
        r102.f235960c.setText(r103.f236023b);
        if (r103.f236025d == false) goto L5;
        float r104 = 1.0f;
    L6:
        r102.f235959b.setAlpha(r104);
        r102.f235960c.setAlpha(r104);
        if (r103.f236026e == false) goto L9;
        int r105 = R.color.office_select_panel_danger_text;
    L10:
        r102.f235960c.setTextColor(ContextCompat.getColor(r102.itemView.getContext(), r105));
        r102.itemView.setOnClickListener(new a(r102, r103));
        return;
    L9:
        r105 = R.color.office_select_panel_text;
        goto L10
    L5:
        r104 = 0.35f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.office_select_panel_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ActionViewHolder(r102, this.f235956a);
    }
}
