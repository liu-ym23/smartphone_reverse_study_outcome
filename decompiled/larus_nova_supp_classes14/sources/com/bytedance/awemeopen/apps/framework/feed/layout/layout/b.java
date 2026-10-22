package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements com.bytedance.awemeopen.infra.base.player.k {
    public final /* synthetic */ AosFeedPagerListLayout<FeedPagerListViewModel> a;

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

    public b(AosFeedPagerListLayout<FeedPagerListViewModel> r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object] */
    public final void onPlayPrepare(String r6) {
        AosFeedPagerListLayout<FeedPagerListViewModel> r7 = this.a;
        int r0 = AosFeedPagerListLayout.O;
        boolean r2 = true;
        if (r7.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L6;
    L29:
        if (r2 == false) goto L32;
        this.a.getVm().getFeedPlayerHelper().e().pause();
        return;
    L32:
        return;
    L6:
        if (r7.getVm().isInFeedPage() == false) goto L29;
        Object r1 = r7.getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r1);
        List r3 = (List) ((ListState) r1).a;
        int r4 = r7.getVm().getCurrentSelectedIndex();
        if (r4 >= 0) goto L11;
    L28:
        r2 = false;
        goto L29
    L11:
        if (r4 >= r3.size()) goto L28;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r8 = r7.getAdapter().k(ListProtector.get(r3, r4));
        if ((r8 instanceof VideoFeedViewHolder) == false) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L29;
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L28;
    L23:
        if (r8.d == true) goto L25;
        r9 = true;
        goto L26
    L15:
        if ((r8 instanceof PhotoFeedViewHolder) == true) goto L18;
        r5 = false;
        goto L19
    }

    public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }
}
