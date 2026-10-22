package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/binder2/FeedExpiredFoldHintViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "closeListener", "Lcom/ss/android/lark/feed/shared/page/binder2/ExpiredFoldCloseListener;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/feed/shared/page/binder2/ExpiredFoldCloseListener;)V", "expiredFoldHintView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "expiredCloseImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "expiredClickFilterTextView", "Landroid/widget/TextView;", "expiredFoldTitleTextView", "expiredContentTextView", "bind", "", "bindExpiredFoldView", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedExpiredFoldHintViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f421333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f421334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f421335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f421336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f421337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f421338f;

    public FeedExpiredFoldHintViewHolder(View r100, teb.g r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "closeListener");
        super(r100);
        this.f421333a = r101;
        this.f421334b = (ConstraintLayout) r100.findViewById(R.id.rl_expired_fold_hint);
        this.f421335c = (AppCompatImageView) r100.findViewById(R.id.img_expired_fold_hint_close);
        this.f421336d = (TextView) r100.findViewById(R.id.tv_expired_fold_click_filter);
        this.f421337e = (TextView) r100.findViewById(R.id.tv_expired_fold_title);
        this.f421338f = (TextView) r100.findViewById(R.id.tv_expired_fold_content);
    }
}
