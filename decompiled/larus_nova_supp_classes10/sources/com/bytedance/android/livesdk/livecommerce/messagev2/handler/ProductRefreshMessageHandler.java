package com.bytedance.android.livesdk.livecommerce.messagev2.handler;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionCurrentUserInfo;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.ec.model.response.c1;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.e1;
import com.bytedance.android.ec.model.response.h1;
import com.bytedance.android.ec.model.response.n0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.AuctionUser;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class ProductRefreshMessageHandler {
    public static final /* synthetic */ int b = 0;
    public final g a;

    public static final class a {
    }

    static {
    }

    public abstract int a();

    public abstract int b();

    public boolean c(int r1) {
        return true;
    }

    public abstract void d(String r1, int r2);

    public abstract void f(String r1, Map<String, String> r2, List<String> r3, Function1<? super ql.a, Unit> r4, RoomContextController r5);

    public ProductRefreshMessageHandler() {
        this.a = new g();
    }

    public final void e(e0 r20, List<? extends ql.a> r21, Function2<? super ql.a, ? super Integer, Unit> r22, RoomContextController r23) {
        Intrinsics.checkNotNullParameter(r20, "message");
        if (c(r20.actionType) == true) goto L5;
        return;
    L5:
        int r0 = r20.actionType;
        Pair r3 = null;
        if (r0 == 1) goto L126;
        if (r0 != 2) goto L9;
        ProductInfo r1 = r20.productInfo;
        if (r1 == null) goto L159;
        String r2 = r1.title;
        if (r2 == null) goto L118;
        if (r21 == null) goto L118;
        Iterator<T> r4 = r21.iterator();
    L116:
        if (r4.hasNext() == false) goto L118;
        ((ql.a) r4.next()).setTitle(r2);
    L118:
        String r5 = r1.cover;
        if (r5 == null) goto L125;
        if (r21 == null) goto L125;
        Iterator<T> r6 = r21.iterator();
    L123:
        if (r6.hasNext() == false) goto L125;
        ((ql.a) r6.next()).setCover(r5);
    L125:
        d(String.valueOf(r20.promotionId), 2);
        return;
    L159:
        return;
    L9:
        if (r0 != 3) goto L11;
        ECV2HotAtmosphere r7 = r20.hotAtmosphere;
        if (r7 == null) goto L108;
        if (r21 == null) goto L108;
        Iterator<T> r8 = r21.iterator();
    L106:
        if (r8.hasNext() == false) goto L108;
        ((ql.a) r8.next()).updateHotAtmosphere(r7);
    L108:
        d(String.valueOf(r20.promotionId), 3);
        return;
    L11:
        if (r0 != 4) goto L13;
        AuctionInfo r9 = r20.auctionInfo;
        if (r9 == null) goto L100;
        if (r21 == null) goto L100;
        Iterator<T> r10 = r21.iterator();
    L42:
        if (r10.hasNext() == false) goto L100;
        ql.a r11 = (ql.a) r10.next();
        if ((r11 instanceof ECUIPromotion) == true) goto L46;
        ql.a r12 = null;
    L47:
        ECUIPromotion r13 = (ECUIPromotion) r12;
        if (r13 == null) goto L74;
        ECAuctionInfo r14 = r13.auctionV2;
        if (r14 == null) goto L52;
        r14.setPrice(r9.price);
    L52:
        ECAuctionInfo r15 = r13.auctionV2;
        if (r15 == null) goto L55;
        r15.setPriceLabel(r9.priceLabel);
    L55:
        ECAuctionInfo r16 = r13.auctionV2;
        if (r16 == null) goto L58;
        r16.setEndTime(r9.endTime);
    L58:
        ECAuctionInfo r17 = r13.auctionV2;
        if (r17 == null) goto L68;
        AuctionUser r18 = r9.currentUser;
        if (r18 == null) goto L66;
        AuctionUser.Companion.getClass();
        Intrinsics.checkNotNullParameter(r18, "$this$convertToECAuctionCurrentUserInfo");
        ECAuctionCurrentUserInfo r19 = new ECAuctionCurrentUserInfo(null, null, 0, false, 15, null);
        r19.setSelf(r18.isSelf);
        r19.setUserName(r18.name);
        ECUrlModel r110 = new ECUrlModel();
        String r24 = r18.profile;
        if (r24 != null) goto L65;
        r24 = "";
    L65:
        r110.setUrlList(CollectionsKt.listOf(r24));
        Unit r25 = Unit.INSTANCE;
        r19.setUserPic(r110);
    L67:
        r17.setCurrentUserInfo(r19);
        goto L68
    L66:
        r19 = null;
    L68:
        AuctionAtmosphere r26 = r9.atmosphere;
        if (r26 == null) goto L71;
        AuctionAtmosphere.Companion.getClass();
        ECAuctionAtmosphere r27 = AuctionAtmosphere.a.a(r26);
    L72:
        r13.auctionAtmosphere = r27;
        goto L74
    L71:
        r27 = null;
    L74:
        if ((r11 instanceof ECUIPromotionV2) == true) goto L76;
        r11 = null;
    L76:
        ECUIPromotionV2 r28 = (ECUIPromotionV2) r11;
        if (r28 == null) goto L42;
        z0 r29 = r28.getImage();
        if (r29 == null) goto L85;
        AuctionAtmosphere r30 = r9.atmosphere;
        if (r30 == null) goto L83;
        AuctionAtmosphere.Companion.getClass();
        ECAuctionAtmosphere r31 = AuctionAtmosphere.a.a(r30);
    L84:
        r29.j(r31);
        goto L85
    L83:
        r31 = null;
    L85:
        d1 r32 = r28.getPrice();
        if (r32 == null) goto L99;
        h1 r33 = r32.c();
        if (r33 == null) goto L99;
        c1 r34 = r33.b();
        if (r34 == null) goto L92;
        r34.d(r9.price);
    L92:
        List r35 = r33.a();
        if (r35 == null) goto L99;
        e1 r36 = (e1) CollectionsKt.firstOrNull(r35);
        if (r36 == null) goto L99;
        n0 r37 = r36.d();
        if (r37 == null) goto L99;
        r37.d(r9.priceLabel);
    L99:
        r28.setAuctionV2EndTime(r9.endTime);
        goto L42
    L46:
        r12 = r11;
    L100:
        d(String.valueOf(r20.promotionId), 4);
        return;
    L13:
        if (r0 != 5) goto L162;
        AuctionAtmosphere r38 = r20.auctionAtmosphere;
        if (r38 == null) goto L36;
        if (r21 == null) goto L36;
        Iterator<T> r39 = r21.iterator();
    L20:
        if (r39.hasNext() == false) goto L36;
        ql.a r40 = (ql.a) r39.next();
        if ((r40 instanceof ECUIPromotion) == true) goto L24;
        ql.a r41 = null;
    L25:
        ECUIPromotion r42 = (ECUIPromotion) r41;
        if (r42 == null) goto L29;
        AuctionAtmosphere.Companion.getClass();
        r42.auctionAtmosphere = AuctionAtmosphere.a.a(r38);
    L29:
        if ((r40 instanceof ECUIPromotionV2) == true) goto L31;
        r40 = null;
    L31:
        ECUIPromotionV2 r43 = (ECUIPromotionV2) r40;
        if (r43 == null) goto L20;
        z0 r44 = r43.getImage();
        if (r44 == null) goto L20;
        AuctionAtmosphere.Companion.getClass();
        r44.j(AuctionAtmosphere.a.a(r38));
        goto L20
    L24:
        r41 = r40;
    L36:
        d(String.valueOf(r20.promotionId), 5);
        return;
    L162:
        return;
    L126:
        RequestInfo r45 = r20.requestInfo;
        if (r45 == null) goto L138;
        int r46 = a();
        if (r46 == 1) goto L133;
        if (r46 == 2) goto L132;
        Map<Integer, Request> r47 = null;
    L134:
        if (r47 == null) goto L138;
        Request r48 = r47.get(Integer.valueOf(b()));
        if (r48 == null) goto L138;
        r3 = new Pair(Integer.valueOf(b()), r48);
        goto L138
    L132:
        r47 = r45.pop;
        goto L134
    L133:
        r47 = r45.list;
    L138:
        if (r3 == null) goto L161;
        int r49 = ((Number) r3.component1()).intValue();
        Request r50 = (Request) r3.component2();
        UtilityKotlinExtentionsKt.f(r50.path, r50.params, new ProductRefreshMessageHandler$refreshProductByMessage$$inlined$also$lambda$1(r50, r49, this, r20, r22, r23));
        return;
    }
}
