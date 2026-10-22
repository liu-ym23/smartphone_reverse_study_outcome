package com.ss.android.lark.todo.impl.features.detail.at.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import f8c.b;
import f8c.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AtLabelBinder implements c<b, AtLabelViewHolder> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtLabelBinder$AtLabelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mLabel", "Landroid/widget/TextView;", "getMLabel", "()Landroid/widget/TextView;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AtLabelViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f442808a;

        public AtLabelViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442808a = (TextView) r100.findViewById(R.id.label);
        }
    }

    public AtLabelBinder(AtSelectAdapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // f8c.c
    public final long a(AtBean r100) {
        Intrinsics.checkNotNullParameter((b) r100, "data");
        return -1;
    }

    @Override // f8c.c
    public final RecyclerView.ViewHolder n(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_at_label_item, r100, false);
        Intrinsics.checkNotNull(r101);
        return new AtLabelViewHolder(r101);
    }

    @Override // f8c.c
    public final void b(RecyclerView.ViewHolder r100, AtBean r101) {
        AtLabelViewHolder r102 = (AtLabelViewHolder) r100;
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "data");
        if (r103.f442801a != 3) goto L5;
        r102.f442808a.setVisibility(8);
        return;
    L5:
        r102.f442808a.setVisibility(0);
        r102.f442808a.setText(r103.f475946b);
    }
}
