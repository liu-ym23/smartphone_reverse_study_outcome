package com.ss.android.lark.search.doubao.chat.holder.cold;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.search.ui.result.view.IconFrontTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/holder/cold/ColdAndHotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "iconFrontTextView", "Lcom/ss/android/lark/search/ui/result/view/IconFrontTextView;", "getIconFrontTextView", "()Lcom/ss/android/lark/search/ui/result/view/IconFrontTextView;", "errorView", "getErrorView", "loadingContainer", "getLoadingContainer", "loadingImg", "Landroid/widget/ImageView;", "getLoadingImg", "()Landroid/widget/ImageView;", "loadingTxt", "Landroid/widget/TextView;", "getLoadingTxt", "()Landroid/widget/TextView;", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColdAndHotViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f440066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IconFrontTextView f440067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f440068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f440069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f440070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f440071f;

    public ColdAndHotViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f440066a = r100;
        this.f440067b = (IconFrontTextView) this.itemView.findViewById(R.id.cold_and_hot_tip_text);
        this.f440068c = this.itemView.findViewById(R.id.search_result_error);
        this.f440069d = this.itemView.findViewById(R.id.cold_and_hot_loading_container);
        this.f440070e = (ImageView) this.itemView.findViewById(R.id.cold_and_hot_loading_img);
        this.f440071f = (TextView) this.itemView.findViewById(R.id.cold_and_hot_loading_txt);
    }
}
