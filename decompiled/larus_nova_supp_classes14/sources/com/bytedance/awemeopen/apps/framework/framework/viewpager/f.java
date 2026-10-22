package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements com.bytedance.awemeopen.infra.base.player.k {
    public final /* synthetic */ AosFeedPagerListFragment<FeedPagerListViewModel> a;

    public final void c(String r1) {
    }

    public final void d(String r1, long r2, int r4) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
    }

    public final void g(String r1, boolean r2, String r3) {
    }

    public final void h(String r1) {
    }

    public final void onPlaying(String r1) {
    }

    public f(AosFeedPagerListFragment<FeedPagerListViewModel> r1) {
        this.a = r1;
    }

    public final void onPlayPrepare(String r6) {
        AosFeedPagerListFragment<FeedPagerListViewModel> r7 = this.a;
        int r0 = AosFeedPagerListFragment.z;
        boolean r2 = true;
        if (r7.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L6;
    L29:
        if (r2 == false) goto L32;
        this.a.W90().getFeedPlayerHelper().e().pause();
        return;
    L32:
        return;
    L6:
        if (r7.W90().isInFeedPage() == false) goto L29;
        Object r1 = r7.W90().getDataList().getValue();
        Intrinsics.checkNotNull(r1);
        List r3 = (List) ((ListState) r1).a;
        int r4 = r7.W90().getCurrentSelectedIndex();
        if (r4 >= 0) goto L11;
    L28:
        r2 = false;
        goto L29
    L11:
        if (r4 >= r3.size()) goto L28;
        AosPagerListFragment<jz3.a, VM>.AosFeedItemAdapter r8 = r7.la0();
        Object r5 = ListProtector.get(r3, r4);
        g<jz3.a> r9 = r8.b.get(r5);
        if ((r9 instanceof VideoFeedViewHolder) == false) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == false) goto L29;
        if (r9 != null) goto L23;
    L25:
        boolean r11 = false;
    L26:
        if (r11 == false) goto L28;
    L23:
        if (r9.d == true) goto L25;
        r11 = true;
        goto L26
    L15:
        if ((r9 instanceof PhotoFeedViewHolder) == true) goto L18;
        r10 = false;
        goto L19
    }

    public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }
}
