package com.ss.android.lark.picker.recommand.history;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/recommand/history/PickerHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "itemType", "", "<init>", "(Landroid/view/View;I)V", "getItemType", "()I", "historyIcon", "Landroid/widget/ImageView;", "getHistoryIcon", "()Landroid/widget/ImageView;", "contentView", "getContentView", "()Landroid/view/View;", "historyContent", "Landroid/widget/TextView;", "getHistoryContent", "()Landroid/widget/TextView;", "historyDelete", "getHistoryDelete", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerHistoryViewHolder extends RecyclerView.ViewHolder {
    private final View contentView;
    private final TextView historyContent;
    private final ImageView historyDelete;
    private final ImageView historyIcon;
    private final int itemType;

    public final View getContentView() {
        return this.contentView;
    }

    public final TextView getHistoryContent() {
        return this.historyContent;
    }

    public final ImageView getHistoryDelete() {
        return this.historyDelete;
    }

    public final ImageView getHistoryIcon() {
        return this.historyIcon;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public PickerHistoryViewHolder(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.itemType = r101;
        this.historyIcon = (ImageView) r100.findViewById(R.id.iv_history_icon);
        this.contentView = r100.findViewById(R.id.ll_content);
        this.historyContent = (TextView) r100.findViewById(R.id.tv_history_content);
        this.historyDelete = (ImageView) r100.findViewById(R.id.iv_history_delete);
    }
}
