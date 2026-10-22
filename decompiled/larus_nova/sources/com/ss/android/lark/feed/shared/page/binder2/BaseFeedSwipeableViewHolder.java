package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/binder2/BaseFeedSwipeableViewHolder;", "Lcom/h6ah4i/android/widget/advrecyclerview/utils/AbstractSwipeableItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "isSwipeLeftPinned", "", "()Z", "setSwipeLeftPinned", "(Z)V", "isSwipeRightPinned", "setSwipeRightPinned", "onViewRecycled", "", "onRightRemoveAction", "data", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "getSwipeReactionType", "", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFeedSwipeableViewHolder extends AbstractSwipeableItemViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f421316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f421317l;

    public int T3() {
        return 0;
    }

    public void U3(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void onViewRecycled() {
    }

    public BaseFeedSwipeableViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
