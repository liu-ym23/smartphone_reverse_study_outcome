package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import com.baidu.platform.comapi.map.MapController;
import com.larus.utils.y;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class o implements com.larus.home.impl.main.side_bar.view.group.datasource.lark.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f345433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Function0<Unit>> f345434b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile pza.a f345435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static OfficeSDKUserApi f345436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f345437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f345438f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f345439g = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345440a = null;

        static {
            int[] r100 = new int[HumanFeedScope.values().length];
            r100[HumanFeedScope.All.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[HumanFeedScope.Pinned.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[HumanFeedScope.Unpinned.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f345440a = r100;
        }
    }

    public static final class b implements hza.b {
        public b() {
        }

        @Override // hza.b
        public final void a(pza.a r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            o.d(r100);
        }
    }

    public o() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.home.impl.main.side_bar.view.group.datasource.lark.n] */
    static {
        f345433a = new o();
        f345434b = new CopyOnWriteArraySet();
        f345438f = new b();
        f345439g = new n();
    }

    public static final void d(pza.a r100) {
        f345435c = r100;
        int r101 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_badge_changed", "onTop=" + r100.f531137d + " notOnTop=" + r100.f531138e + " version=" + r100.f531140g);
        y.c(new m());
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.a
    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<Function0<Unit>> r101 = f345434b;
        if (r101.remove(r100) == true) goto L6;
        return;
    L6:
        if ((!r101.isEmpty()) == false) goto L8;
        return;
    L8:
        if (f345437e == false) goto L19;
        f345437e = false;
        Object r102 = xp9.o.f564776a;
        xp9.o.d(f345439g);
        OfficeSDKUserApi r103 = f345436d;
        if (r103 == null) goto L20;
        aza.d r104 = (aza.d) r103.getService(aza.d.class);
        if (r104 == null) goto L16;
        r104.R6(f345438f);
    L16:
        f345436d = null;
        f345435c = null;
        return;
    L20:
        return;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.a
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (f345434b.add(r100) == true) goto L6;
        return;
    L6:
        if (f345437e == false) goto L8;
        return;
    L8:
        f345437e = true;
        Object r101 = xp9.o.f564776a;
        xp9.o.a(f345439g);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.a
    public final int c(HumanFeedScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        pza.a r101 = f345435c;
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = a.f345440a[r100.ordinal()];
        if (r102 != 1) goto L8;
        int r103 = r101.f531136c;
    L17:
        return RangesKt.coerceAtLeast(r103, 0);
    L8:
        if (r102 != 2) goto L10;
        r103 = r101.f531137d;
        goto L17
    L10:
        if (r102 != 3) goto L13;
        r103 = r101.f531138e;
        goto L17
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
