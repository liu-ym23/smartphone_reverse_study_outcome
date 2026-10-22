package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements LoadMoreFrameLayout.f {
    public final /* synthetic */ AosPagerListFragment<Object, AosPagerListViewModel<Object>> a;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout.f
    public final void onHide() {
        AosPagerListFragment<Object, AosPagerListViewModel<Object>> r0 = this.a;
        int r1 = AosPagerListFragment.v;
        ListState r2 = (ListState) r0.W90().getDataList().getValue();
        if (r2 == null) goto L23;
        List r3 = (List) r2.a;
        if (r3 == null) goto L27;
        int r4 = r0.W90().getCurrentSelectedIndex();
        if (r4 >= 0) goto L10;
        return;
    L10:
        if (r4 >= r3.size()) goto L25;
        AosPagerListFragment<Object, AosPagerListViewModel<Object>>.AosFeedItemAdapter r5 = r0.la0();
        g<Object> r6 = r5.b.get(ListProtector.get(r3, r4));
        PhotoFeedViewHolder r7 = null;
        if ((r6 instanceof VideoFeedViewHolder) == false) goto L14;
        VideoFeedViewHolder r8 = (VideoFeedViewHolder) r6;
    L15:
        if (r8 == null) goto L18;
        r8.e.c.getLoadMoreUiShow().setValue(Boolean.FALSE);
    L18:
        if ((r6 instanceof PhotoFeedViewHolder) == false) goto L20;
        r7 = (PhotoFeedViewHolder) r6;
    L20:
        if (r7 == null) goto L26;
        r7.e.c.getLoadMoreUiShow().setValue(Boolean.FALSE);
        return;
    L26:
        return;
    L14:
        r8 = null;
        goto L15
    L25:
        return;
    L27:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout.f
    public final void onShow() {
        AosPagerListFragment<Object, AosPagerListViewModel<Object>> r0 = this.a;
        r0.g = true;
        ListState r1 = (ListState) r0.W90().getDataList().getValue();
        if (r1 == null) goto L23;
        List r2 = (List) r1.a;
        if (r2 == null) goto L27;
        int r3 = r0.W90().getCurrentSelectedIndex();
        if (r3 >= 0) goto L10;
        return;
    L10:
        if (r3 >= r2.size()) goto L25;
        AosPagerListFragment<Object, AosPagerListViewModel<Object>>.AosFeedItemAdapter r4 = r0.la0();
        g<Object> r5 = r4.b.get(ListProtector.get(r2, r3));
        PhotoFeedViewHolder r6 = null;
        if ((r5 instanceof VideoFeedViewHolder) == false) goto L14;
        VideoFeedViewHolder r7 = (VideoFeedViewHolder) r5;
    L15:
        if (r7 == null) goto L18;
        r7.e.c.getLoadMoreUiShow().setValue(Boolean.TRUE);
    L18:
        if ((r5 instanceof PhotoFeedViewHolder) == false) goto L20;
        r6 = (PhotoFeedViewHolder) r5;
    L20:
        if (r6 == null) goto L26;
        r6.e.c.getLoadMoreUiShow().setValue(Boolean.TRUE);
        return;
    L26:
        return;
    L14:
        r7 = null;
        goto L15
    L25:
        return;
    L27:
        return;
    }

    public m(AosPagerListFragment<Object, AosPagerListViewModel<Object>> r1) {
        this.a = r1;
    }
}
