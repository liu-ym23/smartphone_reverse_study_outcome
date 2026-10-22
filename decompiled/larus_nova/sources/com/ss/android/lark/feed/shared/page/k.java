package com.ss.android.lark.feed.shared.page;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.SwipeDismissItemAnimator;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.feed.shared.data.utils.FeedValueHelper;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f421422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarkFeedInBoxListAdapter f421423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView.Adapter<?> f421424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f421425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FeedItemsViewInit$forbiddenScrollItemListener$1 f421426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f421427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StableLinearLayoutManager f421428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f421429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final teb.d f421430j;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    static {
    }

    public final Context getContext() {
        return this.f421421a;
    }

    public final void a(r r100) {
        Intrinsics.checkNotNullParameter(r100, "inboxContainerListener");
        this.f421427g = r100;
        LarkFeedInBoxListAdapter r101 = this.f421423c;
        if (r101 == null) goto L5;
        r101.f421283d = new l();
    L5:
        if (r101 == null) goto L7;
        r101.f421285f = new m(this);
    L7:
        if (r101 == null) goto L9;
        r101.f421284e = new n(this);
    L9:
        if (r101 == null) goto L11;
        r101.f421286g = new o();
    L11:
        peb.a r102 = heb.a.f484903a.getFeedDependency();
        p r103 = this.f421429i;
        ((com.ss.android.lark.integrator.im.feed_shared.dependency.f) r102).getClass();
        Intrinsics.checkNotNullParameter(r103, "shortcutStatusListener");
    }

    public final void b(RecyclerView.RecycledViewPool r100) {
        if (r100 != null) goto L4;
        r100 = new RecyclerView.RecycledViewPool();
        r100.setMaxRecycledViews(1, 10);
    L4:
        RecyclerView r101 = this.f421422b;
        if (r101 == null) goto L7;
        r101.setRecycledViewPool(r100);
    L7:
        RecyclerView r102 = this.f421422b;
        if (r102 == null) goto L10;
        r102.setLayoutManager(this.f421428h);
    L10:
        RecyclerView r103 = this.f421422b;
        if (r103 == null) goto L16;
        RecyclerView.Adapter r104 = this.f421424d;
        if (r104 != null) goto L15;
        r104 = this.f421423c;
    L15:
        r103.setAdapter(r104);
    L16:
        RecyclerView r105 = this.f421422b;
        if (r105 == null) goto L20;
        r105.setItemViewCacheSize(4);
    L20:
        if (((Boolean) FeedValueHelper.f421161h.getValue()).booleanValue() == false) goto L29;
        teb.d r106 = this.f421430j;
        RecyclerView r107 = this.f421422b;
        LarkFeedInBoxListAdapter r108 = this.f421423c;
        r106.f545647b = r107;
        r106.f545646a = r108;     // Catch: Exception -> L24
        RecyclerView.Recycler r109 = (RecyclerView.Recycler) d27.b.b(r107, "mRecycler");     // Catch: Exception -> L24
        r106.f545648c = r109;     // Catch: Exception -> L24
        r106.f545649d = (ArrayList) d27.b.b(r109, "mCachedViews");     // Catch: Exception -> L24
        r107.addOnScrollListener(new teb.b(r106));
        r107.setViewCacheExtension(new teb.c(r106, r107));
    L26:
        LarkFeedInBoxListAdapter r110 = this.f421423c;
        if (r110 == null) goto L29;
        r110.f421304v = this.f421430j;
    L24:
        e = move-exception;
        Log.e("FeedPreBinder", "FeedPreBinder init error.", e);
    L29:
        RecyclerView r111 = this.f421422b;
        if (heb.a.f484903a.getFeatureGatingDependency().isEnable("lark.feed.anim.default") == false) goto L33;
        SimpleItemAnimator r112 = new SwipeDismissItemAnimator();
    L36:
        if (r112 == null) goto L45;
        r112.setSupportsChangeAnimations(false);
        r112.setRemoveDuration(300);
        r111.setItemAnimator(r112);
        if (com.ss.android.lark.feed.shared.page.utils.b.b() == false) goto L44;
        zdc.h.b(r111);
        return;
    L44:
        return;
    L45:
        return;
    L33:
        if ((r111.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L35;
        r112 = (SimpleItemAnimator) r111.getItemAnimator();
        goto L36
    L35:
        r112 = null;
        goto L36
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.lark.feed.shared.page.FeedItemsViewInit$forbiddenScrollItemListener$1] */
    public k(Context r100, FeedRecyclerView r101, LarkFeedInBoxListAdapter r102, RecyclerView.Adapter r103, b r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "dependency");
        this.f421421a = r100;
        this.f421422b = r101;
        this.f421423c = r102;
        this.f421424d = r103;
        this.f421425e = r104;
        this.f421426f = new FeedItemsViewInit$forbiddenScrollItemListener$1();
        this.f421428h = new StableLinearLayoutManager(r100, 0);
        this.f421429i = new p();
        this.f421430j = new teb.d();
    }
}
