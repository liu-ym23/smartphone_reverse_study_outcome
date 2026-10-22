package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/list/HashTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "hashTagContainer", "getHashTagContainer", "()Landroid/view/View;", "swipeLayout", "Lcom/larksuite/component/blockit/hashtag/widget/SwipeLayout;", "getSwipeLayout", "()Lcom/larksuite/component/blockit/hashtag/widget/SwipeLayout;", "ivDeleteHashTag", "Landroid/widget/ImageView;", "getIvDeleteHashTag", "()Landroid/widget/ImageView;", "teamWorker", "getTeamWorker", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HashTagViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f283032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f283033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SwipeLayout f283034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f283035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f283036e;

    public HashTagViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f283032a = (TextView) r100.findViewById(R.id.tvTagName);
        this.f283033b = r100.findViewById(R.id.hashTagContainer);
        this.f283034c = (SwipeLayout) r100.findViewById(R.id.swipeLayout);
        this.f283035d = (ImageView) r100.findViewById(R.id.ivDeleteHashTag);
        this.f283036e = (TextView) r100.findViewById(R.id.tvTeamWorker);
    }
}
