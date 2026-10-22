package com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant;

import cf.x;
import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionRecyclerView;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.shopping.ligo.container.event.AddCartExtraData;
import com.bytedance.android.shopping.ligo.container.event.AddCartProductInfoData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class InstantAddOnFloorManager {
    public rj2.a a;
    public final LivePromotionListViewModel b;
    public final PromotionLinearLayoutManager c;
    public final LivePromotionListPageAdapter d;
    public final Function2<Integer, Integer, Unit> e;
    public final Function1<List<x>, Unit> f;

    public final void showCardBottomAddOnFloor(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h0 r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        List<ql.a> r0 = this.b.getTotalPromotions();
        AddCartExtraData r1 = r12.a.d;
        boolean r2 = true;
        int r3 = 0;
        String r4 = null;
        if (r1 == null) goto L14;
        AddCartProductInfoData r5 = r1.getProductInfo();
        if (r5 == null) goto L14;
        String r6 = r5.getProductId();
        if (r6 == null) goto L14;
        if (r6.length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
    L15:
        a r8 = r12.a;
        boolean r9 = r8.c;
        String r10 = r8.b;
        int r11 = r10.hashCode();
        if (r11 == (-838846263)) goto L139;
        if (r11 == 3482191) goto L103;
        if (r11 == 104086553) goto L23;
        return;
    L23:
        if (r10.equals("mount") == false) goto L160;
        if (r6 != null) goto L26;
        return;
    L26:
        if (r9 == false) goto L43;
        Iterator<T> r13 = this.b.getTotalPromotions().iterator();
        int r14 = 0;
    L29:
        if (r13.hasNext() == false) goto L37;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        ql.a r17 = (ql.a) r15;
        if (r17.getClientData().h == null) goto L36;
        r17.getClientData().h = null;
        this.f.invoke(CollectionsKt.listOf(new x(r14, UpdateLocalViewType.UPDATE_ALL)));
    L36:
        r14 = r16;
        goto L29
    L37:
        rj2.a r18 = this.a;
        if (r18 == null) goto L42;
        Map<String, a> r19 = r18.a;
        if (r19 == null) goto L42;
        ((LinkedHashMap) r19).clear();
    L42:
        this.b.getViewCacheCenter().a(null);
    L43:
        Iterator<T> r20 = r0.iterator();
    L45:
        if (r20.hasNext() == false) goto L49;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((ql.a) r21).getProductId(), r6) == false) goto L45;
    L50:
        if (r21 != null) goto L52;
        return;
    L52:
        int r22 = this.c.findFirstVisibleItemPosition();
        int r23 = this.c.findLastVisibleItemPosition();
        Iterator<ql.a> r24 = r0.iterator();
        int r25 = 0;
    L54:
        if (r24.hasNext() == false) goto L59;
        if (Intrinsics.areEqual(r24.next().getProductId(), r6) == true) goto L60;
        r25 = r25 + 1;
    L60:
        Integer r26 = Integer.valueOf(r25);
        if (r26.intValue() >= 0) goto L64;
        r2 = false;
    L64:
        if (r2 == true) goto L67;
        r26 = null;
    L67:
        if (r26 == null) goto L101;
        int r27 = r26.intValue() + (this.d.c ? 1 : 0);
        if (r22 > r23) goto L82;
        int r28 = r22;
    L71:
        ql.a r29 = (ql.a) CollectionsKt.getOrNull(r0, r28 - (this.d.c ? 1 : 0));
        if (r29 != null) goto L74;
    L79:
        if (r28 == r23) goto L82;
        r28 = r28 + 1;
        goto L71
    L74:
        if (Intrinsics.areEqual(r29.getProductId(), r6) == true) goto L77;
        r29 = null;
    L77:
        if (r29 == null) goto L79;
        r27 = r28 - (this.d.c ? 1 : 0);
    L82:
        if (r22 > r27) goto L86;
        if (r23 <= r27) goto L86;
        dm.a.a("InstantAddOn").i("show add on floor card, within visual range, index = " + r27);
        this.e.invoke(Integer.valueOf(r27), 0);
    L87:
        ql.a r30 = (ql.a) CollectionsKt.getOrNull(this.b.getTotalPromotions(), r27);
        if (r30 == null) goto L92;
        ql.b r31 = r30.getClientData();
        if (r31 == null) goto L92;
        r31.h = r12.a.a;
    L92:
        ql.a r32 = (ql.a) CollectionsKt.getOrNull(this.b.getTotalPromotions(), r27);
        if (r32 == null) goto L95;
        int r33 = rj2.a.d;
        r4 = rj2.a.C0169a.a(r32);
    L95:
        if (r4 != null) goto L97;
        r4 = "";
    L97:
        this.f.invoke(CollectionsKt.listOf(new x(r27, UpdateLocalViewType.UPDATE_ALL)));
        if (this.a != null) goto L100;
        rj2.a r34 = new rj2.a(new AnonymousClass5(this), new AnonymousClass6(this));
        this.b.registerDataRefreshHandler(r34);
        Unit r35 = Unit.INSTANCE;
        this.a = r34;
    L100:
        a(r4, r12.a);
        return;
    L86:
        dm.a.a("InstantAddOn").i("show add on floor card, without visual range, index = " + r27);
        goto L87
    L101:
        return;
    L59:
        r25 = -1;
        goto L60
    L49:
        r21 = null;
        goto L50
    L160:
        return;
    L103:
        if (r10.equals("quit") == false) goto L182;
        if (r9 == false) goto L120;
        Iterator<T> r110 = this.b.getTotalPromotions().iterator();
    L107:
        if (r110.hasNext() == false) goto L115;
        Object r36 = r110.next();
        int r37 = r3 + 1;
        if (r3 >= 0) goto L111;
        CollectionsKt.throwIndexOverflow();
    L111:
        ql.a r38 = (ql.a) r36;
        if (r38.getClientData().h == null) goto L114;
        r38.getClientData().h = null;
        this.f.invoke(CollectionsKt.listOf(new x(r3, UpdateLocalViewType.UPDATE_ALL)));
    L114:
        r3 = r37;
        goto L107
    L115:
        this.b.getViewCacheCenter().a(null);
        rj2.a r111 = this.a;
        if (r111 == null) goto L183;
        Map<String, a> r112 = r111.a;
        if (r112 == null) goto L184;
        ((LinkedHashMap) r112).clear();
        return;
    L184:
        return;
    L183:
        return;
    L120:
        if (r6 == null) goto L186;
        Iterator<T> r113 = this.b.getTotalPromotions().iterator();
    L123:
        if (r113.hasNext() == false) goto L192;
        Object r39 = r113.next();
        int r40 = r3 + 1;
        if (r3 >= 0) goto L127;
        CollectionsKt.throwIndexOverflow();
    L127:
        ql.a r41 = (ql.a) r39;
        if (Intrinsics.areEqual(r6, r41.getProductId()) == false) goto L137;
        if (r41.getClientData().h == null) goto L137;
        r41.getClientData().h = null;
        this.f.invoke(CollectionsKt.listOf(new x(r3, UpdateLocalViewType.UPDATE_ALL)));
        int r42 = rj2.a.d;
        String r43 = rj2.a.C0169a.a(r41);
        rj2.a r44 = this.a;
        if (r44 == null) goto L136;
        Map<String, a> r45 = r44.a;
        if (r45 == null) goto L136;
        a r46 = r45.remove(r43);
    L136:
        this.b.getViewCacheCenter().a(r6);
    L137:
        r3 = r40;
        goto L123
    L192:
        return;
    L186:
        return;
    L182:
        return;
    L139:
        if (r10.equals("update") == false) goto L187;
        Iterator<T> r47 = this.b.getTotalPromotions().iterator();
    L142:
        if (r47.hasNext() == false) goto L150;
        Object r48 = r47.next();
        int r49 = r3 + 1;
        if (r3 >= 0) goto L146;
        CollectionsKt.throwIndexOverflow();
    L146:
        ql.a r50 = (ql.a) r48;
        if (r50.getClientData().h == null) goto L149;
        r50.getClientData().h = r12.a.a;
        this.f.invoke(CollectionsKt.listOf(new x(r3, UpdateLocalViewType.UPDATE_ALL)));
    L149:
        r3 = r49;
        goto L142
    L150:
        rj2.a r51 = this.a;
        if (r51 == null) goto L188;
        Map<String, a> r52 = r51.a;
        if (r52 == null) goto L189;
        Set r53 = ((LinkedHashMap) r52).keySet();
        if (r53 == null) goto L190;
        Iterator r54 = r53.iterator();
    L158:
        if (r54.hasNext() == false) goto L193;
        a((String) r54.next(), r12.a);
        goto L158
    L193:
        return;
    L190:
        return;
    L189:
        return;
    L188:
        return;
    L187:
        return;
    L11:
        r7 = false;
    L14:
        r6 = null;
        goto L15
    }

    public final void a(String r8, a r9) {
        String r2 = r9.a.b();
        int r6 = r9.a.d();
        String r4 = r9.a.e();
        int r3 = r9.a.a();
        JSONObject r0 = z1.f(r9.a.c());
        r0.put("is_update", true);
        Unit r1 = Unit.INSTANCE;
        a r5 = new a(new ll.a(r2, r3, r4, r0.toString(), r6), r9.b, r9.c, r9.d);
        rj2.a r10 = this.a;
        if (r10 == null) goto L8;
        Map<String, a> r11 = r10.a;
        if (r11 == null) goto L9;
        a r12 = r11.put(r8, r5);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InstantAddOnFloorManager(LivePromotionListViewModel r2, PromotionRecyclerView r3, PromotionLinearLayoutManager r4, LivePromotionListPageAdapter r5, Function2<? super Integer, ? super Integer, Unit> r6, Function1<? super List<x>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "layoutManager");
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Intrinsics.checkNotNullParameter(r6, "scrollToPositionWithOffset");
        Intrinsics.checkNotNullParameter(r7, "onAdapterDataItemChange");
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
