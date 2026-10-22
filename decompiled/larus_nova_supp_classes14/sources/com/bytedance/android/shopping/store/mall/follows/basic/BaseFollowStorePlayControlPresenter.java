package com.bytedance.android.shopping.store.mall.follows.basic;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaseFollowStorePlayControlPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {
    public static final /* synthetic */ int q = 0;
    public ECHybridListContainer f;
    public long g;
    public final Map<String, Pair<Integer, Integer>> h;
    public Pair<String, Integer> i;
    public String j;
    public int k;
    public final Set<String> l;
    public PlayAreaConfig m;
    public final Lazy n;
    public final c o;
    public final Class<T> p;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseFollowStorePlayControlPresenter a;
        public final /* synthetic */ View b;

        public b(BaseFollowStorePlayControlPresenter r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            FollowStoreResponse r5 = (FollowStoreResponse) r4;
            if (r5.isFirstFrame() == false) goto L5;
        L6:
            this.b.postDelayed(new g(this), 1000);
            return;
        L5:
            if (r5.getRequestAfterCache() == true) goto L6;
        }
    }

    public static final class c implements JsEventSubscriber {
        public final /* synthetic */ BaseFollowStorePlayControlPresenter a;

        public c(BaseFollowStorePlayControlPresenter r1) {
            this.a = r1;
        }

        public final void onReceiveJsEvent(Js2NativeEvent r9) {
            Intrinsics.checkNotNullParameter(r9, "jsEvent");
            dm.a.b r0 = dm.a.a("FollowStore");
            StringBuilder r1 = new StringBuilder("manualTriggerPlayControl--skip:");
            XReadableMap r2 = r9.getParams();
            String r5 = null;
            if (r2 == null) goto L5;
            Integer r3 = Integer.valueOf(s.d(r2, "skip", 0));
        L6:
            r1.append(r3);
            r1.append(",item_id:");
            XReadableMap r4 = r9.getParams();
            if (r4 == null) goto L9;
            String r6 = s.f(r4, "item_id", "");
        L10:
            r1.append(r6);
            r0.a(r1.toString());
            XReadableMap r10 = r9.getParams();
            if (r10 != null) goto L13;
        L19:
            this.a.j0(false, true, true);
            return;
        L13:
            if (s.d(r10, "skip", 0) != 1) goto L19;
            String r11 = s.f(r10, "item_id", "");
            if (com.bytedance.android.shopping.extensions.k.c(r11) == false) goto L17;
            r5 = r11;
        L17:
            if (r5 == null) goto L19;
            this.a.l.add(r5);
            goto L19
        L9:
            r6 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    public final T h0() {
        return (T) this.n.getValue();
    }

    public final void c0() {
        EventCenter.unregisterJsEventSubscriber("ec.shop.manualTriggerPlayControl", this.o);
    }

    public final PlayAreaConfig i0() {
        PlayAreaConfig r0 = this.m;
        if (r0 != null) goto L6;
        float r1 = e0();
        float r2 = 1 - e0();
        View r3 = Z().b(2131370737).f();
        int[] r4 = {0, 0};
        r3.getLocationOnScreen(r4);
        int r5 = r4[1];
        Pair r6 = new Pair(Integer.valueOf(r5), Integer.valueOf(r3.getHeight() + r5));
        int r7 = ((Number) r6.getFirst()).intValue();
        float r8 = ((Number) r6.getSecond()).intValue() - r7;
        int r9 = ((int) (r1 * r8)) + r7;
        int r10 = r7 + ((int) (r8 * r2));
        PlayAreaConfig r11 = new PlayAreaConfig(r9, r10, r10 - r9);
        this.m = r11;
        return r11;
    L6:
        return r0;
    }

    public final float e0() {
        hj3.g r0 = h0().getMomentConfig();
        if (r0 == null) goto L8;
        Float r1 = r0.h();
        if (r1 != null) goto L7;
        return 0.2f;
    L7:
        return (1 - r1.floatValue()) / 2;
    L8:
        return 0.2f;
    }

    public final void b0(QModel r4) {
        EventCenter.registerJsEventSubscriber("ec.shop.manualTriggerPlayControl", this.o);
        View r5 = Z().b(2131370737).f();
        ECHybridListContainer r0 = Z().b(2131370738).f();
        this.f = r0;
        r0.getRecyclerView().addOnScrollListener(new BaseFollowStorePlayControlPresenter$onBind$$inlined$apply$lambda$1(this));
        h0().getResponse().b(ECQuickUtilKt.a(Y()), new b(this, r5));
    }

    public BaseFollowStorePlayControlPresenter(Fragment r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.p = r3;
        this.h = new LinkedHashMap();
        this.l = new LinkedHashSet();
        this.n = LazyKt.lazy(new BaseFollowStorePlayControlPresenter$viewModel$2(this));
        this.o = new c(this);
    }

    public final float d0(ECHybridListEngine r9, ECHybridListItemVO r10) {
        String r0 = r10.d;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        View r2 = null;
        ECLynxCardHolder r11 = r9.e(null, r0);
        if (r11 != null) goto L9;
        return 0.0f;
    L9:
        if (this.h.containsKey(r0) == true) goto L32;
        String r3 = r10.d;
        if (r3 == null) goto L32;
        Integer r12 = r10.c;
        if (r12 != null) goto L16;
        String r13 = "";
    L22:
        if (r13 != null) goto L24;
    L30:
        if (r2 == null) goto L32;
        int[] r14 = new int[2];
        int[] r6 = new int[2];
        r2.getLocationOnScreen(r14);
        ((RecyclerView.ViewHolder) r11).itemView.getLocationOnScreen(r6);
        this.h.put(r3, new Pair(Integer.valueOf(r14[1] - r6[1]), Integer.valueOf(r2.getHeight())));
        goto L32
    L24:
        if ((r11 instanceof ECLynxCardHolder) == true) goto L26;
        ECLynxCardHolder r7 = null;
    L27:
        ECLynxCardHolder r8 = r7;
        if (r8 == null) goto L30;
        r2 = r8.k4(r13);
        goto L30
    L26:
        r7 = r11;
        goto L27
    L16:
        hj3.g r15 = h0().getMomentConfig();
        if (r15 == null) goto L21;
        Map<String, String> r16 = r15.i();
        if (r16 == null) goto L21;
        r13 = r16.get(String.valueOf(r12.intValue()));
    L21:
        r13 = null;
    L32:
        Pair r17 = (Pair) ((LinkedHashMap) this.h).get(r0);
        if (r17 == null) goto L38;
        PlayAreaConfig r4 = i0();
        int r5 = ((Number) r17.getSecond()).intValue();
        if (r5 <= 0) goto L38;
        int[] r1 = {0, 0};
        ((RecyclerView.ViewHolder) r11).itemView.getLocationOnScreen(r1);
        int r18 = r1[1] + com.bytedance.android.shopping.extensions.k.f((Integer) r17.getFirst());
        float r19 = (RangesKt.coerceAtMost(r4.getEndPlay(), com.bytedance.android.shopping.extensions.k.f((Integer) r17.getSecond()) + r18) - RangesKt.coerceAtLeast(r18, r4.getStartPlay())) / r5;
        dm.a.a("FollowStore").a("itemId:" + r0 + " ,showPct：" + r19);
        return r19;
    L38:
        return 0.0f;
    }

    public final void j0(boolean r19, boolean r20, boolean r21) {
        ECHybridListContainer r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hybridContainer");
    L5:
        ECHybridListEngine r2 = r1.getEngine();
        if (r2 == null) goto L171;
        ExposeLinearLayoutManagerEx r3 = r2.b.getLayoutManager();
        String r4 = null;
        if ((r3 instanceof LinearLayoutManager) == true) goto L10;
        r3 = null;
    L10:
        Pair<String, Integer> r5 = this.i;
        if (r5 == null) goto L21;
        Integer r6 = (Integer) r5.getSecond();
        if (r6 == null) goto L21;
        int r7 = r6.intValue();
        if (this.k > 0) goto L25;
        if (r3 == null) goto L19;
        Integer r8 = Integer.valueOf(r3.findFirstVisibleItemPosition());
    L20:
        r7 = com.bytedance.android.shopping.extensions.k.f(r8);
        goto L25
    L19:
        r8 = null;
    L25:
        Pair<String, Integer> r9 = this.i;
        if (r9 == null) goto L35;
        Integer r10 = (Integer) r9.getSecond();
        if (r10 == null) goto L35;
        int r11 = r10.intValue();
        if (this.k <= 0) goto L39;
        if (r3 == null) goto L33;
        Integer r12 = Integer.valueOf(r3.findLastVisibleItemPosition());
    L34:
        r11 = com.bytedance.android.shopping.extensions.k.f(r12);
        goto L39
    L33:
        r12 = null;
    L39:
        dm.a.a("FollowStore").a("queryPlayItemId：first:" + r7 + ",second:" + r11);
        if (r7 > r11) goto L143;
        int r13 = r7;
    L42:
        if (r13 < 0) goto L143;
        if (r13 >= r2.i()) goto L143;
        ECHybridListItemVO r14 = r2.h(r13);
        if (r14 != null) goto L50;
    L48:
        int r15 = r13;
    L140:
        int r16 = r15;
        if (r16 == r11) goto L143;
        r13 = r16 + 1;
        goto L42
    L50:
        if (h0().isDoubleRaw() == true) goto L52;
        hj3.g r17 = h0().getMomentConfig();
        if (r17 == null) goto L70;
        Map<String, String> r18 = r17.i();
        if (r18 == null) goto L70;
        String r110 = r18.get(String.valueOf(r14.c));
    L71:
        boolean r111 = com.bytedance.android.shopping.extensions.k.c(r110);
    L72:
        if (r111 == false) goto L48;
        int r112 = r13 + 1;
        if (r112 < r7) goto L78;
        if (r112 > r11) goto L78;
        ECHybridListItemVO r113 = r2.h(r112);
    L80:
        if (h0().isDoubleRaw() == false) goto L134;
        String r114 = r14.d;
        if (r114 == null) goto L97;
        float r115 = d0(r2, r14);
        int r116 = i0().getPlayableHeight();
        if (r116 == 0) goto L87;
        float r117 = this.k / r116;
    L88:
        dm.a.b r118 = dm.a.a("FollowStore");
        StringBuilder r119 = new StringBuilder("itemId:");
        r119.append(r114);
        r119.append(" ,totalDyPct：");
        r119.append(r117);
        r119.append(",currentPlayingItemId：");
        Pair<String, Integer> r22 = this.i;
        if (r22 == null) goto L91;
        String r23 = (String) r22.getFirst();
    L92:
        r119.append(r23);
        r119.append(",pendingPlayItemId：");
        r119.append(this.j);
        r118.a(r119.toString());
        if (r21 == true) goto L95;
        Pair<String, Integer> r24 = this.i;
        if (r24 == null) goto L101;
        String r25 = (String) r24.getFirst();
    L103:
        if (Intrinsics.areEqual(r114, r25) == false) goto L126;
        if (r113 == null) goto L116;
        int r26 = i0().getPlayableHeight();
        if (r26 == 0) goto L108;
        float r27 = this.k / r26;
    L109:
        r15 = r13;
        if (Math.abs(r27) > 0.1d) goto L112;
    L117:
        boolean r28 = false;
    L118:
        if (r28 == false) goto L124;
        if (r113 == null) goto L121;
        String r29 = r113.d;
    L122:
        this.j = r29;
    L137:
        boolean r30 = false;
    L138:
        if (r30 == false) goto L140;
        Pair<String, Integer> r31 = new Pair(r14.d, Integer.valueOf(r15));
    L144:
        this.j = null;
        dm.a.b r32 = dm.a.a("FollowStore");
        StringBuilder r33 = new StringBuilder("try sendPlayEvent：");
        if (r31 == null) goto L147;
        String r34 = (String) r31.getFirst();
    L148:
        r33.append(r34);
        r32.a(r33.toString());
        Pair<String, Integer> r35 = this.i;
        if (r35 == null) goto L151;
        String r36 = (String) r35.getFirst();
    L152:
        if (r31 == null) goto L154;
        String r37 = (String) r31.getFirst();
    L156:
        if ((!Intrinsics.areEqual(r36, r37)) == true) goto L158;
        if (r20 == true) goto L158;
        return;
    L158:
        this.k = 0;
        dm.a.b r38 = dm.a.a("FollowStore");
        StringBuilder r39 = new StringBuilder("real sendPlayEvent：");
        if (r31 == null) goto L161;
        String r40 = (String) r31.getFirst();
    L162:
        r39.append(r40);
        r38.a(r39.toString());
        this.i = r31;
        long r41 = System.currentTimeMillis();
        String r42 = h0().getSceneId();
        if (r31 == null) goto L165;
        r4 = (String) r31.getFirst();
    L165:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.shop.playControl", r41, r42, false, MapsKt.mapOf(TuplesKt.to("item_id", r4)), false, 32));
        return;
    L161:
        r40 = null;
        goto L162
    L154:
        r37 = null;
        goto L156
    L151:
        r36 = null;
        goto L152
    L147:
        r34 = null;
        goto L148
    L121:
        r29 = null;
        goto L122
    L124:
        if (r115 <= 0.6d) goto L137;
    L136:
        r30 = true;
        goto L138
    L112:
        if (d0(r2, r113) <= 0.6d) goto L117;
        if (CollectionsKt.contains(this.l, r113.d) == true) goto L117;
        r28 = true;
        goto L118
    L108:
        r27 = 0.0f;
        goto L109
    L116:
        r15 = r13;
        goto L117
    L126:
        r15 = r13;
        if (Intrinsics.areEqual(this.j, r114) == false) goto L132;
        this.j = null;
        if (r115 <= 0.6d) goto L137;
    L132:
        if (r115 < 1) goto L137;
    L101:
        r25 = null;
        goto L103
    L95:
        if (r115 < 0.5d) goto L97;
        r15 = r13;
        goto L136
    L91:
        r23 = null;
        goto L92
    L87:
        r117 = 0.0f;
    L97:
        r15 = r13;
        goto L137
    L134:
        r15 = r13;
        if (d0(r2, r14) <= 0.4d) goto L137;
    L78:
        r113 = null;
    L70:
        r110 = null;
        goto L71
    L52:
        if (com.bytedance.android.shopping.extensions.k.c(r14.d) == true) goto L54;
    L64:
        r111 = false;
        goto L72
    L54:
        if (CollectionsKt.contains(this.l, r14.d) == true) goto L64;
        Integer r120 = r14.c;
        if (r120 != null) goto L58;
    L61:
        boolean r121 = true;
    L62:
        if (r121 == true) goto L64;
        r111 = true;
        goto L72
    L58:
        if (r120.intValue() == 50106) goto L61;
        r121 = false;
    L143:
        r31 = null;
    L35:
        if (r3 == null) goto L37;
        Integer r43 = Integer.valueOf(r3.findLastVisibleItemPosition());
    L38:
        r11 = com.bytedance.android.shopping.extensions.k.f(r43);
        goto L39
    L37:
        r43 = null;
    L21:
        if (r3 == null) goto L23;
        Integer r44 = Integer.valueOf(r3.findFirstVisibleItemPosition());
    L24:
        r7 = com.bytedance.android.shopping.extensions.k.f(r44);
        goto L25
    L23:
        r44 = null;
        goto L24
    }
}
