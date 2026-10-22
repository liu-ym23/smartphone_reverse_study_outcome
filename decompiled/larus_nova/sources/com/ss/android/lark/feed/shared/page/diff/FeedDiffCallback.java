package com.ss.android.lark.feed.shared.page.diff;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class FeedDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<UIFeedCard> f421406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<UIFeedCard> f421407b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f421407b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f421406a.size();
    }

    public FeedDiffCallback(List<UIFeedCard> r100, List<UIFeedCard> r101) {
        this.f421406a = r100;
        this.f421407b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return ((UIFeedCard) ListProtector.get(this.f421406a, r100)).exactlyCompare((UIFeedCard) ListProtector.get(this.f421407b, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        UIFeedCard r102 = (UIFeedCard) ListProtector.get(this.f421406a, r100);
        UIFeedCard r103 = (UIFeedCard) ListProtector.get(this.f421407b, r101);
        if (r102 == null) goto L8;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r102.getId().equals(r103.getId());
    L8:
        return false;
    }
}
