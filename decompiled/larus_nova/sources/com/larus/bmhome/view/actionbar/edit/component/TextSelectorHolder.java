package com.larus.bmhome.view.actionbar.edit.component;

import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;)V", "getCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "selectedColor", "", "unSelectedColor", "tag", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/SingleSelectorInstructionOption;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextSelectorHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f316202e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r2 f316203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f316204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f316205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f316206d;

    public TextSelectorHolder(View r100, r2 r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f316203a = r101;
        this.f316204b = ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_primary_50, r100.getContext(), R.color.larus_primary_50));
        this.f316205c = ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_neutral_100, r100.getContext(), R.color.larus_neutral_100));
        this.f316206d = (TextView) r100.findViewById(R.id.tv_item_name);
    }
}
