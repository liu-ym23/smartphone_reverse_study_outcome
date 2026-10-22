package com.larus.photopicker.impl.ui.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/photopicker/impl/ui/holder/InputPaddingFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "paddingView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "updateHeight", "", "height", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputPaddingFooterViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f364120a;

    public InputPaddingFooterViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingView");
        super(r100);
        this.f364120a = r100;
    }

    public final void T3(int r100) {
        ViewGroup.LayoutParams r101 = this.f364120a.getLayoutParams();
        if (r101.height == r100) goto L10;
        r101.height = r100;
        this.f364120a.setLayoutParams(r101);
        View r102 = this.f364120a;
        if (r100 <= 0) goto L7;
        int r103 = 0;
    L8:
        r102.setVisibility(r103);
        return;
    L7:
        r103 = 8;
        goto L8
    }
}
