package com.bytedance.ee.bear.office.list.selectpanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter$ActionViewHolder;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelItemSpec;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "submitList", "nextItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ActionViewHolder", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSelectPanelAdapter extends RecyclerView.Adapter<ActionViewHolder> {
    public final Function1<d, Unit> a;
    public final List<d> b;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter$ActionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelItemSpec;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "icon", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "bind", "item", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActionViewHolder extends RecyclerView.ViewHolder {
        public final Function1<d, Unit> a;
        public final ImageView b;
        public final TextView c;

        /* JADX WARN: Multi-variable type inference failed */
        public ActionViewHolder(View r2, Function1<? super d, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, SendEventContainerMethodParamModel.EventKinds.onClick);
            super(r2);
            this.a = r3;
            this.b = (ImageView) r2.findViewById(2131381374);
            this.c = (TextView) r2.findViewById(2131381375);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSelectPanelAdapter(Function1<? super d, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.a = r2;
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ActionViewHolder r6 = (ActionViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        d r7 = (d) ListProtector.get(this.b, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.b.setImageResource(r7.c);
        r6.c.setText(r7.b);
        if (r7.d == false) goto L5;
        float r0 = 1.0f;
    L6:
        r6.b.setAlpha(r0);
        r6.c.setAlpha(r0);
        if (r7.e == false) goto L9;
        int r1 = 2131103946;
    L10:
        r6.c.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r6).itemView.getContext(), r1));
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new a(r6, r7));
        return;
    L9:
        r1 = 2131103948;
        goto L10
    L5:
        r0 = 0.35f;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564116, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ActionViewHolder(r5, this.a);
    }
}
