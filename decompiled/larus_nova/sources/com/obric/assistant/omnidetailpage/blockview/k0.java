package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.assistant.omnidetailpage.localmedia.TaskLocalVideoAutoPlayManager$attachToRecyclerView$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
public final class k0 extends OmniDetailVerticalLineFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.assistant.omnidetailpage.localmedia.w f390652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f390653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f390654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f390655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends ifa.c> f390656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<? extends ifa.c> f390657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LocalMediaDisplayMode f390658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f390659j;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f390660a = null;

        static {
            int[] r100 = new int[LocalMediaDisplayMode.values().length];
            r100[LocalMediaDisplayMode.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LocalMediaDisplayMode.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f390660a = r100;
        }
    }

    public final int b() {
        int r100 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        int r101 = com.larus.utils.m0.f375450a;
        return RangesKt.coerceAtLeast((com.larus.utils.m0.b(getContext()) - getPaddingLeft()) - getPaddingRight(), 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new g0(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.obric.assistant.omnidetailpage.localmedia.w r100 = this.f390652c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "owner");
        com.obric.assistant.omnidetailpage.localmedia.y r101 = r100.f390860d;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(((LinkedHashMap) r100.f390858b).get(r101), this) == false) goto L9;
        r101.R3();
        r100.f390860d = null;
        return;
    }

    public final void a(ifa.f.e r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        setShowLine(r100.f489686c);
        List<ifa.c> r101 = r100.f489695h;
        this.f390656g = r101;
        this.f390657h = r100.f489696i;
        List<ifa.c> r102 = r101;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        if ((((ifa.c) r104.next()) instanceof ifa.c.b) == false) goto L9;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        LocalMediaDisplayMode r106 = LocalMediaDisplayMode.VERTICAL;
    L17:
        this.f390658i = r106;
        int r107 = a.f390660a[r106.ordinal()];
        if (r107 != 1) goto L20;
        int r108 = 0;
    L26:
        if (this.f390653d.getOrientation() == r108) goto L28;
        this.f390653d.setOrientation(r108);
    L28:
        RecyclerView r109 = this.f390654e;
        if (r106 != LocalMediaDisplayMode.HORIZONTAL) goto L31;
        r103 = true;
    L31:
        r109.setNestedScrollingEnabled(r103);
        this.f390659j.y2(this.f390656g, b(), this.f390658i);
        this.f390654e.post(new i0(this));
        return;
    L20:
        if (r107 != 2) goto L23;
        r108 = 1;
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L16:
        r106 = LocalMediaDisplayMode.HORIZONTAL;
    L13:
        r105 = false;
        goto L14
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.assistant.omnidetailpage.blockview.h0] */
    public k0(final Context r110, final com.obric.assistant.omnidetailpage.localmedia.w r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "autoPlayManager");
        super(r110, null, 0);
        this.f390652c = r111;
        LinearLayoutManager r100 = new LinearLayoutManager(r110, 0, false);
        this.f390653d = r100;
        RecyclerView r101 = new RecyclerView(r110);
        r101.setLayoutManager(r100);
        r101.setOverScrollMode(2);
        r101.setClipToPadding(false);
        this.f390654e = r101;
        CoroutineScope r102 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f390655f = r102;
        this.f390656g = CollectionsKt.emptyList();
        this.f390657h = CollectionsKt.emptyList();
        this.f390658i = LocalMediaDisplayMode.HORIZONTAL;
        b r103 = new b(this, r111, new h0(this, r110));
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r103.f390609f = r102;
        this.f390659j = r103;
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setPadding(i5.q(), i5.j0(), i5.q(), i5.j0());
        ImageCardNestedScrollableHost r104 = new ImageCardNestedScrollableHost(r110);
        r104.setClipToPadding(false);
        addView(r104, new FrameLayout.LayoutParams(-1, -2));
        r104.addView(r101, new FrameLayout.LayoutParams(-1, -2));
        r101.setAdapter(r103);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        r101.addOnScrollListener(new TaskLocalVideoAutoPlayManager$attachToRecyclerView$1(r111));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        return;
    L5:
        if ((!this.f390656g.isEmpty()) == false) goto L9;
        this.f390659j.y2(this.f390656g, b(), this.f390658i);
        this.f390654e.post(new f0(this));
        return;
    }
}
