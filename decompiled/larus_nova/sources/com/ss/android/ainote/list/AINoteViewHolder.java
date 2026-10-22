package com.ss.android.ainote.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ainote/list/AINoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "noteItemView", "Lcom/ss/android/ainote/list/AINoteItemView;", "<init>", "(Landroid/view/View;Lcom/ss/android/ainote/list/AINoteItemView;)V", "getNoteItemView", "()Lcom/ss/android/ainote/list/AINoteItemView;", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AINoteViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AINoteItemView f407053a;

    public AINoteViewHolder(View r100, AINoteItemView r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "noteItemView");
        super(r100);
        this.f407053a = r101;
    }
}
