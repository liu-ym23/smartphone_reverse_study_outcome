package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.livesdk.livecommerce.model.AtmosphereData;
import com.bytedance.android.livesdk.livecommerce.model.AtmosphereInfo;
import com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.AuctionUser;
import com.bytedance.android.livesdk.livecommerce.model.CategoryInfo;
import com.bytedance.android.livesdk.livecommerce.model.CountdownAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.DigitalAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionSuccess;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuthorListRoomStatsData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuthorOrderLimitInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2BarrageBuyInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2BidInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2BrowseInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponActivityData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponMeta;
import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.ECV2FilterSwitchChangeData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2GMVData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2LotteryInfoList;
import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2ProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RedirectData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RedpackActivityInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RoomTagOfflineInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2SkuInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2TaskInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCampaignInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCouponInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedGroupInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedSkuInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UrlPicture;
import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryAlert;
import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryInfo;
import com.bytedance.android.livesdk.livecommerce.model.EndTimeRefreshInfo;
import com.bytedance.android.livesdk.livecommerce.model.IntelligentPopMessage;
import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;
import com.bytedance.android.livesdk.livecommerce.model.ProductAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ProductNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import si2.a2;
import si2.b2;
import si2.c2;
import si2.d2;
import si2.e1;
import si2.e2;
import si2.f1;
import si2.f2;
import si2.g1;
import si2.g2;
import si2.h1;
import si2.h2;
import si2.i1;
import si2.i2;
import si2.j1;
import si2.j2;
import si2.k1;
import si2.k2;
import si2.l1;
import si2.l2;
import si2.m1;
import si2.m2;
import si2.n1;
import si2.o1;
import si2.p1;
import si2.q1;
import si2.r1;
import si2.s1;
import si2.t1;
import si2.u1;
import si2.v1;
import si2.w1;
import si2.x1;
import si2.y1;
import si2.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveCommerceMessageProvider implements bh2.w {
    public static final LiveCommerceMessageProvider a = null;

    public LiveCommerceMessageProvider() {
    }

    static {
        a = new LiveCommerceMessageProvider();
    }

    @Override // bh2.w
    public final Map<Class<?>, am3.c<?>> a() {
        HashMap r0 = new HashMap();
        r0.put(si2.a.class, new si2.k0());
        r0.put(EndTimeRefreshInfo.class, new u1());
        r0.put(ECV2AuctionInfo.class, new com.bytedance.android.livesdk.livecommerce.model.d());
        r0.put(ECV2AuctionInfo.ECV2AuctionUserInfo.class, new com.bytedance.android.livesdk.livecommerce.model.c());
        r0.put(ECV2AuctionInfo.ECV2AuctionImg.class, new com.bytedance.android.livesdk.livecommerce.model.a());
        r0.put(ECV2AuctionInfo.ECV2AuctionIncrPrice.class, new com.bytedance.android.livesdk.livecommerce.model.b());
        r0.put(ECV2AuctionSuccess.class, new si2.q0());
        r0.put(ECV2AuthorListRoomStatsData.class, new si2.r0());
        r0.put(ECV2AuthorOrderLimitInfo.class, new com.bytedance.android.livesdk.livecommerce.model.f());
        r0.put(ECV2AuthorOrderLimitInfo.ICON.class, new com.bytedance.android.livesdk.livecommerce.model.e());
        r0.put(ECV2BarrageBuyInfo.class, new si2.s0());
        r0.put(ECV2BidInfo.class, new si2.t0());
        r0.put(ECV2BrowseInfo.class, new si2.u0());
        r0.put(ECV2CouponActivityData.class, new si2.v0());
        r0.put(ECV2CouponInfo.class, new si2.w0());
        r0.put(ECV2CouponMeta.class, new si2.x0());
        r0.put(ECV2DelayParam.class, new si2.y0());
        r0.put(ECV2FilterSwitchChangeData.class, new com.bytedance.android.livesdk.livecommerce.model.g());
        r0.put(ECV2FilterSwitchChangeData.UpIcon.class, new com.bytedance.android.livesdk.livecommerce.model.h());
        r0.put(ECV2GMVData.class, new si2.z0());
        r0.put(ECV2HotAtmosphere.class, new si2.a1());
        r0.put(ECV2InteractionData.class, new com.bytedance.android.livesdk.livecommerce.model.y());
        r0.put(ECV2InteractionData.InteractionContent.class, new com.bytedance.android.livesdk.livecommerce.model.r());
        r0.put(ECV2InteractionData.InteractionContentCheck.class, new com.bytedance.android.livesdk.livecommerce.model.q());
        r0.put(ECV2InteractionData.InteractionElement.class, new com.bytedance.android.livesdk.livecommerce.model.s());
        r0.put(ECV2InteractionData.InteractionAvatar.class, new com.bytedance.android.livesdk.livecommerce.model.p());
        r0.put(ECV2InteractionData.MessageProduct.class, new com.bytedance.android.livesdk.livecommerce.model.w());
        r0.put(ECV2InteractionData.ProductCover.class, new com.bytedance.android.livesdk.livecommerce.model.x());
        r0.put(ECV2InteractionData.ListTopInteractionRow.class, new com.bytedance.android.livesdk.livecommerce.model.v());
        r0.put(ECV2InteractionData.ListAction.class, new com.bytedance.android.livesdk.livecommerce.model.u());
        r0.put(ECV2InteractionData.BizActionMeta.class, new com.bytedance.android.livesdk.livecommerce.model.i());
        r0.put(ECV2InteractionData.JumpActionMeta.class, new com.bytedance.android.livesdk.livecommerce.model.t());
        r0.put(ECV2InteractionData.ElementText.class, new com.bytedance.android.livesdk.livecommerce.model.o());
        r0.put(ECV2InteractionData.ElementBlank.class, new com.bytedance.android.livesdk.livecommerce.model.k());
        r0.put(ECV2InteractionData.ElementAvatar.class, new com.bytedance.android.livesdk.livecommerce.model.j());
        r0.put(ECV2InteractionData.UrlImage.class, new com.bytedance.android.livesdk.livecommerce.model.z());
        r0.put(ECV2InteractionData.ElementImage.class, new com.bytedance.android.livesdk.livecommerce.model.m());
        r0.put(ECV2InteractionData.ElementImageBubble.class, new com.bytedance.android.livesdk.livecommerce.model.l());
        r0.put(ECV2InteractionData.ElementLoopText.class, new com.bytedance.android.livesdk.livecommerce.model.n());
        r0.put(ECV2LotteryInfoList.class, new si2.b1());
        r0.put(ECV2OpenPriceTriggerInfo.class, new si2.c1());
        r0.put(ECV2PopMsgProductInfo.class, new si2.d1());
        r0.put(ECV2PopupInfo.class, new e1());
        r0.put(JumpUrl.class, new w1());
        r0.put(ECV2ProductInfo.class, new f1());
        r0.put(ECV2RedirectData.class, new g1());
        r0.put(ECV2RedpackActivityInfo.class, new h1());
        r0.put(ECV2RoomTagOfflineInfo.class, new i1());
        r0.put(ECV2SkuInfo.class, new j1());
        r0.put(ECV2TaskInfo.class, new k1());
        r0.put(ECV2UpdatedCampaignInfo.class, new l1());
        r0.put(ECV2UpdatedCommentaryVideoInfo.class, new m1());
        r0.put(ECV2UpdatedCouponInfo.class, new n1());
        r0.put(ECV2UpdatedGroupInfo.class, new o1());
        r0.put(ECV2UpdatedProductInfo.class, new p1());
        r0.put(ECV2UpdatedSkuInfo.class, new q1());
        r0.put(ECV2UrlPicture.class, new r1());
        r0.put(ECV2WinLotteryAlert.class, new s1());
        r0.put(ECV2WinLotteryInfo.class, new t1());
        r0.put(IntelligentPopMessage.class, new v1());
        r0.put(si2.t.class, new x1());
        r0.put(si2.v.class, new y1());
        r0.put(si2.x.class, new z1());
        r0.put(si2.y.class, new a2());
        r0.put(si2.z.class, new b2());
        r0.put(si2.a0.class, new c2());
        r0.put(si2.b0.class, new d2());
        r0.put(si2.c0.class, new e2());
        r0.put(si2.c.class, new si2.n0());
        r0.put(CategoryInfo.class, new si2.m0());
        r0.put(si2.d0.class, new h2());
        r0.put(si2.e0.class, new j2());
        r0.put(RequestInfo.class, new l2());
        r0.put(Request.class, new m2());
        r0.put(ProductInfo.class, new g2());
        r0.put(AuctionInfo.class, new si2.j0());
        r0.put(AtmosphereInfo.class, new si2.h0());
        r0.put(ProductAtmosphere.class, new f2());
        r0.put(ProductNumAtmosphere.class, new i2());
        r0.put(AuctionUser.class, new si2.l0());
        r0.put(AuctionAtmosphere.class, new si2.i0());
        r0.put(CountdownAtmosphere.class, new si2.o0());
        r0.put(DigitalAtmosphere.class, new si2.p0());
        r0.put(AtmosphereData.class, new si2.g0());
        r0.put(si2.f0.class, new k2());
        return r0;
    }

    @Override // bh2.w
    public final Map<String, Class<?>> b() {
        HashMap r0 = new HashMap();
        r0.put("LivePopMessage", si2.a0.class);
        r0.put("IntelligentPopMessage", IntelligentPopMessage.class);
        r0.put("LiveCommonMessage", si2.v.class);
        r0.put("LiveMarketingMessage", si2.z.class);
        r0.put("ProductUpdateMessage", si2.f0.class);
        r0.put("LiveInteractionMessage", si2.y.class);
        r0.put("LiveSellerMessage", si2.b0.class);
        r0.put("ProductListRefreshMessage", si2.d0.class);
        r0.put("CategoryRefreshMessage", si2.c.class);
        r0.put("ProductRefreshMessage", si2.e0.class);
        r0.put("AuthorConnectMessage", si2.t.class);
        r0.put("LiveHighHeatMessage", si2.x.class);
        r0.put("LiveTargetFlashMessage", si2.c0.class);
        r0.put("AuctionUpdateMessage", si2.a.class);
        return r0;
    }

    public final void c() {
        bh2.x r0 = bh2.x.e;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(this, "provider");     // Catch: Throwable -> L10
        if (bh2.x.b == true) goto L7;
        ((ArrayList) bh2.x.a).add(this);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);
        List r1 = fh.a.a;
        LiveCommerceMessageProvider$injectMessage$1 r2 = LiveCommerceMessageProvider$injectMessage$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "provider");
        ((ArrayList) fh.a.a).add(r2);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
