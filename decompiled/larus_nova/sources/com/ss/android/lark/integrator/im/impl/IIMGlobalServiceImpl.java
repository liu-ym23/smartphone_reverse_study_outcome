package com.ss.android.lark.integrator.im.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus;
import com.larus.home.impl.main.side_bar.view.group.datasource.lark.r;
import com.larus.larkfeed.impl.mixedfeed.LarkMixedFeedFragment;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapter;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapterWrapper;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapterWrapper$feedItemListener$2;
import com.ss.android.lark.flow.feed.sidebar.human.OfficeSidebarHumanFeedController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKGlobalScope
public final class IIMGlobalServiceImpl implements aza.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f427949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vmb.c f427950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public sza.c f427951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedSidebarAdapterWrapper f427952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f427953e;

    public static final class a {
    }

    static {
    }

    @Override // aza.c
    public final lza.a G5() {
        return new lza.a();
    }

    @Override // aza.c
    public final sza.c N1() {
        sza.c r100 = this.f427951c;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("officeUrlPreviewService");
        return null;
    L7:
        return r100;
    }

    @Override // aza.c
    public final void d3(String r110) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Log.i("IIMGlobalServiceImpl", "clearFeedLocalCacheData invoked, userId=" + r110);
        ((com.ss.android.lark.feed.molten.cache.b) this.f427953e.getValue()).f(r110);
        List<DoubaoFeedMigrateStatus> r111 = com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus.f423362j;
        j r112 = this.f427949a;
        Intrinsics.checkNotNullParameter(r112, "passport");
        com.ss.android.lark.flow.feed.utils.b.d("DoubaoFeedMigrateStatus", "clearMigrateStatusKvForAllUsers invoke");
        com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus.f423363k.set(true);
        List<f0c.b> r113 = r112.a();
        ArrayList r100 = new ArrayList();
        Iterator<T> r114 = r113.iterator();
    L4:
        if (r114.hasNext() == false) goto L13;
        f0c.g r101 = ((f0c.b) r114.next()).a();
        if (r101 == null) goto L10;
        User r102 = r101.f475033a;
        if (r102 == null) goto L10;
        String r103 = r102.userId;
    L11:
        if (r103 == null) goto L4;
        r100.add(r103);
    L10:
        r103 = null;
        goto L11
    L13:
        List r115 = CollectionsKt.distinct(r100);
        StringBuilder r104 = new StringBuilder("clearMigrateStatusKvForAllUsers:");
        List r116 = r115;
        r104.append(CollectionsKt.joinToString$default(r116, ",", null, null, 0, null, null, 62, null));
        com.ss.android.lark.flow.feed.utils.b.d("DoubaoFeedMigrateStatus", r104.toString());
        Iterator r117 = r116.iterator();
    L15:
        if (r117.hasNext() == false) goto L24;
        String r105 = (String) r117.next();
        List<DoubaoFeedMigrateStatus> r106 = com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus.f423362j;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
        com.ss.android.lark.storage.c.d(null, r105, new com.ss.android.lark.storage.a("mixed_feed"), "mixed_feed_storage", null, 49).remove("mixed_feed_migrate");     // Catch: Throwable -> L19
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L15;
        Intrinsics.checkNotNullParameter("DoubaoFeedMigrateStatus", "tag");
        Log.e("DoubaoFeedMigrateStatus", "[FlowFeedLog] ".concat("clearMigrateStatusKvForAllUsers error"), r109, true);
    L19:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Override // aza.c
    public final FlowMixedFeedFragment y6(LarkMixedFeedFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        FlowMixedFeedFragment r101 = new FlowMixedFeedFragment();
        vmb.c r102 = this.f427950b;
        com.ss.android.lark.feed.molten.cache.b r103 = (com.ss.android.lark.feed.molten.cache.b) this.f427953e.getValue();
        Intrinsics.checkNotNullParameter(r102, "dataSource");
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r103, "localCache");
        r101.f423411d = r102;
        r101.f423418k = r100;
        r101.f423415h = r103;
        r101.V90().S(r102, r103);
        r101.V90().U();
        return r101;
    }

    @Inject
    public IIMGlobalServiceImpl(j r100, vmb.c r101) {
        Intrinsics.checkNotNullParameter(r100, "userService");
        Intrinsics.checkNotNullParameter(r101, "mixedFeedUserBundleProxy");
        this.f427949a = r100;
        this.f427950b = r101;
        this.f427953e = LazyKt.lazy(IIMGlobalServiceImpl$feedItemsMoltenLocalCache$2.INSTANCE);
    }

    @Override // aza.c
    public final OfficeSidebarHumanFeedController p4(Fragment r100, iza.e r101) {
        r.a r102 = r.a.f345443a;
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        Intrinsics.checkNotNullParameter(r101, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Log.i("IIMGlobalServiceImpl", "createSidebarHumanFeedController invoked, hostFragment=" + r100.getClass().getSimpleName() + '@' + System.identityHashCode(r100));
        if (r100.getContext() != null) goto L7;
        Log.e("IIMGlobalServiceImpl", "createSidebarHumanFeedController skipped: hostFragment.context is null");
        return null;
    L7:
        return new OfficeSidebarHumanFeedController(r100, r100.getViewLifecycleOwner(), r101, this.f427950b, (com.ss.android.lark.feed.molten.cache.b) this.f427953e.getValue());
    }

    @Override // aza.c
    public final FeedSidebarAdapter Md(Fragment r110, RecyclerView r111, iza.e r112, com.larus.larkfeed.impl.mixedfeed.flow.a r113) {
        Intrinsics.checkNotNullParameter(r110, "hostFragment");
        Intrinsics.checkNotNullParameter(r111, "recyclerView");
        Intrinsics.checkNotNullParameter(r112, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r113, "callback");
        Log.i("IIMGlobalServiceImpl", "createSidebarFeedAdapter invoked, hostFragment=" + r110.getClass().getSimpleName() + '@' + System.identityHashCode(r110) + ", recyclerView=" + r111.getClass().getSimpleName() + '@' + System.identityHashCode(r111));
        Context r100 = r110.getContext();
        if (r100 != null) goto L6;
        Log.e("IIMGlobalServiceImpl", "createSidebarFeedAdapter skipped: hostFragment.context is null");
        return null;
    L6:
        FeedSidebarAdapterWrapper r101 = this.f427952d;
        if (r101 == null) goto L9;
        r101.d();
    L9:
        this.f427952d = null;
        FeedSidebarAdapterWrapper r102 = new FeedSidebarAdapterWrapper(r100, r110, r110.getViewLifecycleOwner(), FeedFolderCompat.INSTANCE.getMESSAGE(), r112, new e(), r113);
        vmb.c r114 = this.f427950b;
        com.ss.android.lark.feed.molten.cache.b r115 = (com.ss.android.lark.feed.molten.cache.b) this.f427953e.getValue();
        Intrinsics.checkNotNullParameter(r114, "dataSource");
        Intrinsics.checkNotNullParameter(r115, "localCache");
        r102.f423473i = false;
        r102.f423471g = r114;
        r102.a().S(r114, r115);
        r102.a().U();
        Intrinsics.checkNotNullParameter(r111, "recyclerView");
        com.ss.android.lark.flow.feed.sidebar.adapter.b r116 = new com.ss.android.lark.flow.feed.sidebar.adapter.b(r102.f423465a, r111, r102.b());
        FeedSidebarAdapterWrapper$feedItemListener$2.a r117 = (FeedSidebarAdapterWrapper$feedItemListener$2.a) r102.f423482r.getValue();
        Intrinsics.checkNotNullParameter(r117, "sidebarContainerListener");
        r116.f423504c = r117;
        FeedSidebarAdapter r118 = r116.f423503b;
        if (r118 == null) goto L12;
        r118.f421283d = new com.ss.android.lark.flow.feed.sidebar.adapter.c();
    L12:
        if (r118 == null) goto L14;
        r118.f421284e = new com.ss.android.lark.flow.feed.sidebar.adapter.d(r116);
    L14:
        r102.f423483s = r116;
        r102.f423477m = r111;
        r102.a().R();
        this.f427952d = r102;
        return r102.b();
    }
}
