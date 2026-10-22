package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.eventcenter.event.ScrollMode;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.widgets.nest.BodyViewAction;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListLinkedScrollView;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListSwipeNestRefreshLayout;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListTwoRevViewAction;
import com.bytedance.android.shopping.utils.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListBodyComponent extends b {
    public final CardListLinkedScrollView d;
    public final List<t> e;
    public final Lazy f;
    public final Lazy g;
    public final String h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final com.bytedance.android.shopping.card_list.widgets.nest.a m;
    public final BodyViewAction n;
    public final CardListObjectContainer o;
    public final CardListSwipeNestRefreshLayout p;

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        CardListLinkedScrollView r0 = this.d;
        if (r0 == null) goto L5;
        r0.setObjectContainer(this.o);
    L5:
        boolean r1 = this.o.f.getNeedSetGradientView();
        NestedScrollView r2 = this.p;
        ViewParent r3 = null;
        if (r2 == null) goto L8;
        ViewParent r4 = r2.getParent();
    L10:
        if ((r4 instanceof ViewGroup) == false) goto L13;
        r3 = r4;
    L13:
        ViewGroup r5 = (ViewGroup) r3;
        if (r5 == null) goto L22;
        View r6 = r5.findViewById(2131373888);
        if (r6 == null) goto L23;
        if (r1 == false) goto L19;
        int r7 = 0;
    L20:
        r6.setVisibility(r7);
        return;
    L19:
        r7 = 8;
        goto L20
    L23:
        return;
    L22:
        return;
    L8:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onDestroy() {
        super.onDestroy();
        this.m.d.c.e.setValue(Unit.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onPause() {
        super.onPause();
        this.m.d.c.d.setValue(Boolean.FALSE);
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onResume() {
        super.onResume();
        this.m.d.c.d.setValue(Boolean.TRUE);
    }

    public final void g(boolean r2) {
        this.m.d.l.setValue(Boolean.valueOf(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListBodyComponent(CardListObjectContainer r11, CardListSwipeNestRefreshLayout r12) {
        Intrinsics.checkNotNullParameter(r11, "objectContainer");
        super(r11);
        this.o = r11;
        this.p = r12;
        String r0 = null;
        if (r12 == 0) goto L5;
        CardListLinkedScrollView r13 = (CardListLinkedScrollView) r12.findViewById(2131378044);
    L6:
        this.d = r13;
        this.e = new ArrayList();
        this.f = LazyKt.lazy(new CardListBodyComponent$trackerComponent$2(this));
        this.g = LazyKt.lazy(new CardListBodyComponent$queryFetchComponent$2(this));
        CardPassThroughData r14 = r11.e.a;
        if (r14 == null) goto L9;
        r0 = r14.getMonitorId();
    L9:
        this.h = r0;
        this.i = LazyKt.lazy(new CardListBodyComponent$monitorManager$2(this));
        this.j = LazyKt.lazy(new CardListBodyComponent$loadMoreComponent$2(this));
        this.k = LazyKt.lazy(new CardListBodyComponent$sliceCustomWidgetAdapterComponent$2(this));
        this.l = LazyKt.lazy(new CardListBodyComponent$backToTopBtnManageComponent$2(this));
        this.m = new com.bytedance.android.shopping.card_list.widgets.nest.a(this.b);
        this.n = new BodyViewAction(new CardListBodyComponent$viewAction$1(this), new CardListBodyComponent$viewAction$2(this), r11.f.getNeedPullRefresh(), new CardListTwoRevViewAction(new CardListBodyComponent$viewAction$6(this), new CardListBodyComponent$viewAction$3(this), new CardListBodyComponent$viewAction$4(this), new CardListBodyComponent$viewAction$5(this), new CardListBodyComponent$viewAction$7(this), new com.bytedance.android.shopping.card_list.widgets.a(0)));
        r r15 = d.a(new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r15, "scene");
        this.a = r15;
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final void h(int r3, ScrollMode r4) {
        Intrinsics.checkNotNullParameter(r4, "scrollMode");
        this.m.d.i.setValue(new Pair(Integer.valueOf(r3), r4));
    }
}
