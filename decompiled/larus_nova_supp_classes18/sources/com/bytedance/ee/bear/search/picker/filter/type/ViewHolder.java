package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/type/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "selectCheckBox", "Landroid/widget/CheckBox;", "getSelectCheckBox", "()Landroid/widget/CheckBox;", "setSelectCheckBox", "(Landroid/widget/CheckBox;)V", "typeNameTxt", "Landroid/widget/TextView;", "getTypeNameTxt", "()Landroid/widget/TextView;", "setTypeNameTxt", "(Landroid/widget/TextView;)V", "divider", "getDivider", "()Landroid/view/View;", "setDivider", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewHolder extends RecyclerView.ViewHolder {
    public final CheckBox a;
    public final TextView b;
    public final View c;

    public ViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.a = (CheckBox) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385820);
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385821);
        this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131369197);
    }
}
