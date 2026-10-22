package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.CarouselDetailInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ECFloatWindowPanelAdapter;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.ECFloatPanelExpandedUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView$getAdapterDataObserver$1;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECFloatWindowCarouselPresenter extends QPresenter {
    public final il.a e;
    public final Lazy f;
    public final Lazy g;
    public PagerSnapScrollListener h;
    public PagerSnapScrollListener i;
    public ECFloatWindowCarouselPresenter$init$5 j;
    public ECCarouselIndicatorView$getAdapterDataObserver$1 k;
    public a l;
    public long m;
    public final Handler n;
    public boolean o;

    public final ECFloatWindowPanelAdapter E() {
        return (ECFloatWindowPanelAdapter) this.f.getValue();
    }

    public ECFloatWindowCarouselPresenter() {
        this.e = new il.a();
        this.f = LazyKt.lazy(new ECFloatWindowCarouselPresenter$adapter$2(this));
        this.g = LazyKt.lazy(ECFloatWindowCarouselPresenter$pagerSnapHelper$2.INSTANCE);
        this.m = 15000;
        this.n = UtilityKotlinExtentionsKt.b;
        this.o = true;
    }

    public final void C() {
        RecyclerView r0 = w().b(2131384980).f();
        PagerSnapScrollListener r1 = this.h;
        if (r1 == null) goto L5;
        r0.removeOnScrollListener(r1);
    L5:
        this.h = null;
        ECCarouselIndicatorView$getAdapterDataObserver$1 r2 = this.k;
        if (r2 == null) goto L8;
        E().unregisterAdapterDataObserver(r2);
    L8:
        this.k = null;
        ECFloatWindowCarouselPresenter$init$5 r3 = this.j;
        if (r3 == null) goto L11;
        E().unregisterAdapterDataObserver(r3);
    L11:
        this.j = null;
        PagerSnapScrollListener r4 = this.i;
        if (r4 == null) goto L14;
        r0.removeOnScrollListener(r4);
    L14:
        F(false);
        this.i = null;
        il.a.a(this.e);
        a r5 = this.l;
        if (r5 == null) goto L18;
        this.n.removeCallbacks(r5);
        return;
    }

    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.recyclerview.widget.RecyclerView$AdapterDataObserver, com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter.ECFloatWindowCarouselPresenter$init$5] */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.recyclerview.widget.RecyclerView$AdapterDataObserver, com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView$getAdapterDataObserver$1] */
    public final void A(QModel r11) {
        if ((r11 instanceof lk2.a) == true) goto L5;
        r11 = null;
    L5:
        lk2.a r12 = (lk2.a) r11;
        if (r12 != null) goto L8;
        return;
    L8:
        boolean r2 = true;
        int r3 = 0;
        if (((QPresenter) this).d == true) goto L26;
        final RecyclerView r0 = w().b(2131384980).f();
        final ScrollingLinearLayoutManager r5 = new ScrollingLinearLayoutManager(u().c());
        r0.setLayoutManager(r5);
        r0.setAdapter(E());
        if (r0.getOnFlingListener() == null) goto L13;
        r0.setOnFlingListener(null);
    L13:
        r0.setHasFixedSize(false);
        ((PagerSnapHelper) this.g.getValue()).attachToRecyclerView(r0);     // Catch: Exception -> L16
    L18:
        final ECCarouselIndicatorView r1 = (ECCarouselIndicatorView) w().b(2131365238).f();
        PagerSnapHelper r6 = (PagerSnapHelper) this.g.getValue();
        Intrinsics.checkNotNullParameter(r6, "pagerSnapHelper");
        PagerSnapScrollListener r7 = new PagerSnapScrollListener(r6, r1);
        r0.addOnScrollListener(r7);
        Unit r8 = Unit.INSTANCE;
        this.h = r7;
        PagerSnapScrollListener r9 = new PagerSnapScrollListener((PagerSnapHelper) this.g.getValue(), new b(this, r5, r0));
        r0.addOnScrollListener(r9);
        this.i = r9;
        final ECFloatWindowPanelAdapter r10 = E();
        Intrinsics.checkNotNullParameter(r10, "adapter");
        Intrinsics.checkNotNullParameter(r0, "recyclerView");
        ?? r13 = new ECCarouselIndicatorView$getAdapterDataObserver$1(r1, r0, r10);
        E().registerAdapterDataObserver(r13);
        this.k = r13;
        ?? r14 = new ECFloatWindowCarouselPresenter$init$5(this, r5, r0);
        E().registerAdapterDataObserver(r14);
        this.j = r14;
        Integer r15 = r12.a;
        if (r15 == null) goto L21;
        int r16 = r15.intValue();
    L22:
        if (r16 != 1) goto L24;
        boolean r17 = true;
    L25:
        MutableLiveData<Boolean> r18 = ECFloatPanelExpandedUtils.a;
        r18.setValue(Boolean.valueOf(q.a.getBoolean("ecom_live_float_window_panel_open", r17)));
        r18.observe(u().e(), new d(this, r5, r1, r0));
        this.l = new a(this, r5, r0);
        goto L26
    L24:
        r17 = false;
        goto L25
    L21:
        r16 = 1;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L26:
        List<CarouselDetailInfo> r4 = r12.b;
        ECFloatWindowPanelAdapter r19 = E();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r4, "dataList");
        Intrinsics.checkNotNullParameter(r12, "data");
        r19.b = r4;
        r19.c = r12;
        r19.d = -1;
        r19.safeNotifyDataSetChanged();
        if (ECFloatPanelExpandedUtils.a() == true) goto L29;
    L31:
        r2 = false;
    L32:
        Query r20 = w().b(2131365238);
        if (r2 == true) goto L36;
        r3 = 8;
    L36:
        r20.g(r3);
        Long r110 = r12.c;
        if (r110 == null) goto L39;
        long r21 = r110.longValue();
    L40:
        this.m = r21;
        a r111 = this.l;
        if (r111 == null) goto L43;
        this.n.removeCallbacks(r111);
    L43:
        F(r2);
        return;
    L39:
        r21 = 15000;
        goto L40
    L29:
        if (E().getItemCount() <= 1) goto L31;
        goto L31
    }

    public final void F(boolean r4) {
        this.o = r4;
        a r0 = this.l;
        if (r0 == null) goto L5;
        this.n.removeCallbacks(r0);
    L5:
        a r1 = this.l;
        if (r4 == false) goto L10;
        if (r1 == null) goto L11;
        this.n.postDelayed(r1, this.m);
        return;
    L11:
        return;
    }

    public static final void D(ECFloatWindowCarouselPresenter r6, ScrollingLinearLayoutManager r7, RecyclerView r8, ECFloatWindowPanelAdapter r9) {
        r6.getClass();
        int r1 = -1;
        if (ECFloatPanelExpandedUtils.a() == true) goto L10;
        int r10 = r7.findFirstVisibleItemPosition();
        if (r10 == (-1)) goto L65;
        View r11 = r7.findViewByPosition(r10);
        if (r11 == null) goto L66;
    L51:
        r11.measure(View.MeasureSpec.makeMeasureSpec(r8.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r11.getMeasuredHeight() <= 0) goto L62;
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        if (r12 != null) goto L56;
        return;
    L56:
        if (r12.height == r11.getMeasuredHeight()) goto L64;
        r12.height = r11.getMeasuredHeight();
        r8.requestLayout();
        return;
    L64:
        return;
    L62:
        return;
    L66:
        return;
    L65:
        return;
    L10:
        List<CarouselDetailInfo> r13 = r9.b;
        if (r13 != null) goto L13;
    L48:
        r11 = null;
    L49:
        if (r11 != null) goto L51;
        return;
    L13:
        if (r13.isEmpty() == true) goto L48;
        RecyclerView r14 = r9.a;
        if (r14 == null) goto L48;
        Iterator<T> r15 = r13.iterator();
        int r2 = 0;
        int r3 = 0;
    L20:
        if (r15.hasNext() == false) goto L38;
        Object r4 = r15.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ECFloatWindowDetailInfo r16 = ((CarouselDetailInfo) r4).getDetailInfo();
        if (r16 == null) goto L33;
        List r17 = r16.getColumnInfos();
        if (r17 == null) goto L33;
        ECFloatWindowColumnInfo r18 = (ECFloatWindowColumnInfo) CollectionsKt.getOrNull(r17, 0);
        if (r18 == null) goto L33;
        List r19 = r18.getElements();
        if (r19 == null) goto L33;
        int r20 = r19.size();
    L34:
        if (r3 >= r20) goto L36;
        r1 = r2;
        r3 = r20;
    L36:
        r2 = r5;
    L33:
        r20 = 0;
        goto L34
    L38:
        if (r9.d != r1) goto L40;
    L45:
        ECFloatWindowPanelAdapter.ViewHolder r21 = r9.e;
        if (r21 == null) goto L48;
        r11 = ((RecyclerView.ViewHolder) r21).itemView;
        goto L49
    L40:
        if (r9.e != null) goto L42;
        r9.e = (ECFloatWindowPanelAdapter.ViewHolder) r9.createViewHolder(r14, r9.getItemViewType(r1));
    L42:
        r9.d = r1;
        ECFloatWindowPanelAdapter.ViewHolder r22 = r9.e;
        if (r22 == null) goto L45;
        lk2.b r23 = r9.y2(r1);
        r22.a.b(r23);
        goto L45
    }
}
