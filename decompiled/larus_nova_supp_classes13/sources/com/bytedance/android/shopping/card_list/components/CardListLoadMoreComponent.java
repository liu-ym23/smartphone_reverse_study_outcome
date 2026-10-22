package com.bytedance.android.shopping.card_list.components;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListLinkedScrollView;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListLoadMoreComponent extends com.bytedance.android.shopping.card_list.components.b {
    public boolean d;
    public boolean e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public Boolean j;
    public boolean k;
    public final CardListObjectContainer l;
    public final n m;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CardListLoadMoreComponent a;

        public b(CardListLoadMoreComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            p r4 = (p) r3;
            CardListLoadMoreComponent r0 = this.a;
            r0.d = r4.b;
            String r5 = r4.a;
            Intrinsics.checkNotNullParameter(r5, "queryScene");
            if ((!Intrinsics.areEqual(r5, GYLFetchType.LOAD_MORE)) == true) goto L7;
            r0.e = true;
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CardListLoadMoreComponent a;

        public c(CardListLoadMoreComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            o r11 = (o) r10;
            CardListLoadMoreComponent r0 = this.a;
            Context r2 = r0.e();
            String r1 = r11.a;
            com.bytedance.kmp.ec.yata.common.protocol.data.e r3 = r11.b;
            if (r3 == null) goto L5;
            boolean r4 = com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r3);
        L6:
            com.bytedance.kmp.ec.yata.common.protocol.data.e r12 = r11.b;
            if (r12 == null) goto L9;
            String r13 = r12.b();
        L10:
            Intrinsics.checkNotNullParameter(r1, "queryScene");
            if ((!Intrinsics.areEqual(r1, GYLFetchType.LOAD_MORE)) == true) goto L25;
            r0.f = r4;
            if (r4 == true) goto L23;
            if (r13 == null) goto L18;
            String r14 = a2.d(r13);
            if (r14 == null) goto L18;
        L19:
            String r5 = r14;
            if (r5 == null) goto L23;
            if (r2 == null) goto L23;
            ECToast.showToast$default(ECToast.INSTANCE, r2, r5, 0, null, 8, null);
        L18:
            r14 = a2.d(r0.m.c);
        L23:
            r0.e = false;
            return;
        L25:
            return;
        L9:
            r13 = null;
            goto L10
        L5:
            r4 = false;
            goto L6
        }
    }

    static {
    }

    public final CardListBodyComponent g() {
        return (CardListBodyComponent) this.i.getValue();
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        CardListQueryFetchComponent r0 = (CardListQueryFetchComponent) this.g.getValue();
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.e;
        if (r1 == null) goto L7;
        r1.observe(this.b, new b(this));
    L7:
        CardListQueryFetchComponent r2 = (CardListQueryFetchComponent) this.g.getValue();
        if (r2 == null) goto L13;
        MutableLiveData r3 = r2.g;
        if (r3 == null) goto L14;
        r3.observe(this.b, new c(this));
        return;
    L14:
        return;
    }

    public final void h(boolean r8) {
        if (this.e == false) goto L5;
        return;
    L5:
        int r0 = com.bytedance.android.shopping.card_list.utils.f.a;
        if ((!Intrinsics.areEqual(com.bytedance.android.shopping.card_list.utils.f.a((AndroidYaTaInstance) this.l.e.c.invoke(), Boolean.FALSE), Boolean.TRUE)) == false) goto L8;
        return;
    L8:
        CardListBodyComponent r1 = g();
        int r3 = 0;
        if (r1 == null) goto L18;
        CardListLinkedScrollView r2 = r1.d;
        if (r2 == null) goto L13;
        RecyclerView r4 = r2.getYataBody();
    L14:
        if (r4 == null) goto L18;
        RecyclerView.Adapter r5 = r4.getAdapter();
        if (r5 == null) goto L18;
        int r6 = r5.getItemCount();
    L19:
        CardListBodyComponent r7 = g();
        if (r7 == null) goto L27;
        CardListLinkedScrollView r9 = r7.d;
        if (r9 == null) goto L24;
        RecyclerView r10 = r9.getYataBody();
    L25:
        if (r10 == null) goto L27;
        RecyclerView.LayoutManager r11 = r10.getLayoutManager();
    L29:
        if ((r11 instanceof LinearLayoutManager) == true) goto L31;
        r11 = null;
    L31:
        LinearLayoutManager r12 = (LinearLayoutManager) r11;
        if (r12 == null) goto L34;
        int r13 = r12.findLastCompletelyVisibleItemPosition();
    L35:
        int r14 = this.m.b;
        if (this.f == true) goto L38;
    L39:
        if (r8 == false) goto L57;
        CardListBodyComponent r15 = g();
        if (r15 != null) goto L43;
    L44:
        CardListTrackerComponent r16 = (CardListTrackerComponent) this.h.getValue();
        if (r16 == null) goto L53;
        Pair[] r17 = new Pair[2];
        r17[0] = TuplesKt.to("event_type", "do_load_more");
        CardListBodyComponent r18 = g();
        if (r18 != null) goto L49;
    L52:
        r17[1] = TuplesKt.to("is_auto", Integer.valueOf(r3));
        CardListTrackerComponent.h(r16, "card_list_load_more_event", MapsKt.mapOf(r17), 4);
        goto L53
    L49:
        if (((Boolean) r18.m.d.k.invoke()).booleanValue() != true) goto L52;
        r3 = 1;
    L53:
        CardListQueryFetchComponent r19 = (CardListQueryFetchComponent) this.g.getValue();
        if (r19 == null) goto L59;
        int r20 = CardListQueryFetchComponent.x;
        r19.i(true, GYLFetchType.LOAD_MORE, null);
        return;
    L59:
        return;
    L43:
        if (((Boolean) r15.m.d.k.invoke()).booleanValue() != true) goto L44;
        return;
    L57:
        return;
    L38:
        if ((r13 + r14) >= r6) goto L44;
    L34:
        r13 = 0;
        goto L35
    L24:
        r10 = null;
    L27:
        r11 = null;
        goto L29
    L13:
        r4 = null;
    L18:
        r6 = 0;
        goto L19
    }

    public CardListLoadMoreComponent(CardListObjectContainer r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "loadMoreParams");
        super(r2);
        this.l = r2;
        this.m = r3;
        this.d = true;
        this.f = true;
        this.g = LazyKt.lazy(new CardListLoadMoreComponent$queryFetchComponent$2(this));
        this.h = LazyKt.lazy(new CardListLoadMoreComponent$trackerComponent$2(this));
        this.i = LazyKt.lazy(new CardListLoadMoreComponent$bodyComponent$2(this));
        this.k = true;
    }
}
