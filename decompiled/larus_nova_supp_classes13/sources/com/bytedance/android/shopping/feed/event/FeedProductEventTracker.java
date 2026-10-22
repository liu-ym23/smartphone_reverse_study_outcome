package com.bytedance.android.shopping.feed.event;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.InnerFlowAdData;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.android.ec.model.response.anchorv3.ProductLeaderBoardEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLogisticsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductShopEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.ShopBindAuthorDTO;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.bytedance.android.shopping.feed.utils.CommerceButtonUtil;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FeedProductEventTracker {
    public static final FeedProductEventTracker a = null;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ PromotionProductStruct d;
        public final /* synthetic */ Boolean e;

        public a(Integer r1, Context r2, List r3, PromotionProductStruct r4, Boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            com.bytedance.android.shopping.feed.event.e r0 = new com.bytedance.android.shopping.feed.event.e();
            PromotionProductStruct r1 = this.d;
            String r2 = null;
            if (r1 == null) goto L7;
            PromotionProductBaseStruct r3 = r1.getBaseInfo();
            if (r3 == null) goto L7;
            String r4 = r3.getPromotionId();
        L8:
            r0.c = r4;
            PromotionProductStruct r5 = this.d;
            if (r5 == null) goto L13;
            PromotionProductBaseStruct r6 = r5.getBaseInfo();
            if (r6 == null) goto L13;
            Integer r7 = r6.getPromotionSource();
        L14:
            r0.e = String.valueOf(r7);
            PromotionProductStruct r8 = this.d;
            if (r8 == null) goto L19;
            PromotionProductBaseStruct r9 = r8.getBaseInfo();
            if (r9 == null) goto L19;
            String r10 = r9.getProductId();
        L20:
            r0.d = r10;
            Boolean r11 = this.e;
            Boolean r12 = Boolean.TRUE;
            if (Intrinsics.areEqual(r11, r12) == false) goto L23;
            r2 = "guess_you_like_product";
        L23:
            r0.a = r2;
            if (Intrinsics.areEqual(this.e, r12) == false) goto L26;
            String r13 = "product_card";
        L27:
            r0.b = r13;
            Integer r14 = this.a;
            if (r14 != null) goto L31;
        L33:
            if (r14 != null) goto L36;
        L38:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L36:
            if (r14.intValue() != 0) goto L38;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L38
        L31:
            if (r14.intValue() != 2) goto L33;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L38
        L26:
            r13 = "video";
        L19:
            r10 = null;
        L13:
            r7 = null;
        L7:
            r4 = null;
            goto L8
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        public b(Integer r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.i = r7;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            qd3.a r0 = new qd3.a();
            r0.a = this.d;
            r0.b = this.e;
            r0.c = this.f;
            r0.d = this.g;
            r0.e = this.h;
            r0.f = this.i;
            Integer r1 = this.a;
            if (r1 != null) goto L6;
        L8:
            if (r1 != null) goto L11;
        L13:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L11:
            if (r1.intValue() != 0) goto L13;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L13
        L6:
            if (r1.intValue() != 2) goto L8;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L13
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ JSONObject p;

        public c(Integer r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, JSONObject r14) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.i = r7;
            this.j = r8;
            this.k = r9;
            this.l = r10;
            this.m = r11;
            this.n = r12;
            this.o = r13;
            this.p = r14;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            od3.c r0 = new od3.c();
            r0.a = this.d;
            r0.b = this.e;
            r0.c = this.f;
            r0.d = this.g;
            r0.e = this.h;
            r0.f = this.i;
            r0.g = this.j;
            r0.h = this.k;
            r0.i = this.l;
            r0.j = this.m;
            r0.k = this.n;
            r0.l = this.o;
            r0.m = com.bytedance.android.ec.core.utils.z1.j(this.p);
            Integer r1 = this.a;
            if (r1 != null) goto L6;
        L8:
            if (r1 != null) goto L11;
        L13:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L11:
            if (r1.intValue() != 0) goto L13;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L13
        L6:
            if (r1.intValue() != 2) goto L8;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L13
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ JSONObject p;

        public d(Integer r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, JSONObject r14) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.i = r7;
            this.j = r8;
            this.k = r9;
            this.l = r10;
            this.m = r11;
            this.n = r12;
            this.o = r13;
            this.p = r14;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            od3.b r0 = new od3.b();
            r0.a = this.d;
            r0.b = this.e;
            r0.c = this.f;
            r0.d = this.g;
            r0.e = this.h;
            r0.f = this.i;
            r0.g = this.j;
            r0.h = this.k;
            r0.i = this.l;
            r0.j = this.m;
            r0.k = this.n;
            r0.l = this.o;
            r0.m = com.bytedance.android.ec.core.utils.z1.j(this.p);
            Integer r1 = this.a;
            if (r1 != null) goto L6;
        L8:
            if (r1 != null) goto L11;
        L13:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L11:
            if (r1.intValue() != 0) goto L13;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L13
        L6:
            if (r1.intValue() != 2) goto L8;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L13
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class e<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ JSONObject l;

        public e(Integer r1, String r2, String r3, String r4, String r5, String r6, Map r7, String r8, String r9, JSONObject r10) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.i = r7;
            this.j = r8;
            this.k = r9;
            this.l = r10;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            pd3.c r0 = new pd3.c();
            r0.a = this.d;
            r0.b = this.e;
            r0.c = this.f;
            r0.d = this.g;
            r0.e = this.h;
            r0.f = this.i;
            r0.g = this.j;
            r0.h = this.k;
            r0.i = com.bytedance.android.ec.core.utils.z1.j(this.l);
            Integer r1 = this.a;
            if (r1 != null) goto L6;
        L8:
            if (r1 != null) goto L11;
        L13:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L11:
            if (r1.intValue() != 0) goto L13;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L13
        L6:
            if (r1.intValue() != 2) goto L8;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L13
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class f<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Map i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ JSONObject l;
        public final /* synthetic */ String m;

        public f(Integer r1, String r2, String r3, String r4, String r5, String r6, Map r7, String r8, String r9, JSONObject r10, String r11) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.i = r7;
            this.j = r8;
            this.k = r9;
            this.l = r10;
            this.m = r11;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            pd3.b r0 = new pd3.b();
            r0.a = this.d;
            r0.b = this.e;
            r0.c = this.f;
            r0.d = this.g;
            r0.e = this.h;
            r0.f = this.i;
            r0.g = this.j;
            r0.h = this.k;
            r0.i = com.bytedance.android.ec.core.utils.z1.j(this.l);
            r0.j = this.m;
            Integer r1 = this.a;
            if (r1 != null) goto L6;
        L8:
            if (r1 != null) goto L11;
        L13:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L11:
            if (r1.intValue() != 0) goto L13;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L13
        L6:
            if (r1.intValue() != 2) goto L8;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L13
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class g<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ rd3.a d;
        public final /* synthetic */ SearchItem e;

        public g(Integer r1, Context r2, rd3.a r3, SearchItem r4) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            b1 r0 = new b1("trending_words_click");
            rd3.a r1 = this.d;
            Long r2 = null;
            if (r1 == null) goto L11;
            yd3.p r3 = r1.i();
            if (r3 == null) goto L11;
            yd3.q r4 = r3.o();
            if (r4 == null) goto L11;
            ArrayList<SearchItem> r5 = r4.c();
            if (r5 == null) goto L11;
            Integer r6 = Integer.valueOf(r5.indexOf(this.e));
        L12:
            r0.a = r6;
            r0.b = this.e.getKeyword();
            rd3.a r7 = this.d;
            if (r7 == null) goto L23;
            ProductFeedViewModel r8 = r7.c;
            if (r8 == null) goto L23;
            InnerFlowPageStyleDTO r9 = r8.getInnerFlowPageStyle();
            if (r9 == null) goto L23;
            PageStyle r10 = r9.getPageStyle();
            if (r10 == null) goto L23;
            if (r10.searchCardWithPicture() != true) goto L23;
            String r11 = "inflow_search_product_trending";
        L24:
            r0.d = r11;
            rd3.a r12 = this.d;
            if (r12 == null) goto L27;
            String r13 = r12.j;
        L28:
            r0.c = r13;
            String r14 = this.e.getQueryId();
            if (r14 != null) goto L31;
            r14 = "";
        L31:
            r0.e = r14;
            StringBuilder r15 = new StringBuilder("product_flow_page_");
            rd3.a r16 = this.d;
            if (r16 == null) goto L40;
            ProductFeedViewModel r17 = r16.c;
            if (r17 == null) goto L40;
            AnchorV3Param r18 = r17.m907getAnchorV3Param();
            if (r18 == null) goto L40;
            AnchorV3PromotionRequestParam r19 = r18.getRequestParam();
            if (r19 == null) goto L40;
            String r20 = r19.getSourcePage();
        L41:
            r15.append(r20);
            r0.f = r15.toString();
            rd3.a r21 = this.d;
            if (r21 == null) goto L44;
            String r22 = r21.h;
        L45:
            r0.g = r22;
            if (r21 == null) goto L48;
            String r23 = r21.i;
        L49:
            r0.h = r23;
            SearchItem r24 = this.e;
            if (r24 == null) goto L52;
            r2 = r24.getProductId();
        L52:
            r0.i = String.valueOf(r2);
            Integer r25 = this.a;
            if (r25 != null) goto L56;
        L58:
            if (r25 != null) goto L61;
        L63:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L61:
            if (r25.intValue() != 0) goto L63;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L63
        L56:
            if (r25.intValue() != 2) goto L58;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L63
        L48:
            r23 = null;
            goto L49
        L44:
            r22 = null;
        L40:
            r20 = null;
            goto L41
        L27:
            r13 = null;
        L23:
            r11 = "inflow_search_product_trending_tag";
        L11:
            r6 = null;
            goto L12
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class h<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ rd3.a d;
        public final /* synthetic */ SearchItem e;

        public h(Integer r1, Context r2, List r3, rd3.a r4, SearchItem r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            z0 r0 = new z0("ecom_inflow_trending_click");
            rd3.a r1 = this.d;
            if (r1 == null) goto L5;
            String r2 = r1.h;
        L6:
            r0.a = r2;
            JsonObject r3 = new JsonObject();
            rd3.a r4 = this.d;
            if (r4 == null) goto L24;
            yd3.p r5 = r4.i();
            if (r5 == null) goto L24;
            yd3.q r6 = r5.o();
            if (r6 == null) goto L24;
            ArrayList<SearchItem> r7 = r6.c();
            if (r7 == null) goto L24;
            Iterator<T> r8 = r7.iterator();
            int r9 = 0;
        L16:
            if (r8.hasNext() == false) goto L24;
            Object r10 = r8.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L20;
            CollectionsKt.throwIndexOverflow();
        L20:
            String r12 = ((SearchItem) r10).getKeyword();
            if (r12 == null) goto L23;
            r3.addProperty(String.valueOf(r9), r12);
        L23:
            r9 = r11;
        L24:
            r0.b = r3.toString();
            r0.c = this.e.getKeyword();
            Integer r13 = this.a;
            if (r13 != null) goto L28;
        L30:
            if (r13 != null) goto L33;
        L35:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L33:
            if (r13.intValue() != 0) goto L35;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L35
        L28:
            if (r13.intValue() != 2) goto L30;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L35
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class i<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ rd3.a d;

        public i(Integer r1, Context r2, List r3, rd3.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            d1 r0 = new d1("inflow_sku_component_click");
            r0.a = "product_flow_page";
            rd3.a r1 = this.d;
            Integer r2 = null;
            if (r1 == null) goto L11;
            Promotion r3 = r1.f();
            if (r3 == null) goto L11;
            PromotionProductStruct r4 = r3.getPromotionInfo();
            if (r4 == null) goto L11;
            PromotionProductBaseStruct r5 = r4.getBaseInfo();
            if (r5 == null) goto L11;
            String r6 = r5.getProductId();
        L12:
            r0.b = r6;
            rd3.a r7 = this.d;
            if (r7 == null) goto L21;
            Promotion r8 = r7.f();
            if (r8 == null) goto L21;
            PromotionProductStruct r9 = r8.getPromotionInfo();
            if (r9 == null) goto L21;
            PromotionProductBaseStruct r10 = r9.getBaseInfo();
            if (r10 == null) goto L21;
            String r11 = r10.getPromotionId();
        L22:
            r0.c = r11;
            rd3.a r12 = this.d;
            if (r12 == null) goto L31;
            Promotion r13 = r12.f();
            if (r13 == null) goto L31;
            PromotionProductStruct r14 = r13.getPromotionInfo();
            if (r14 == null) goto L31;
            PromotionProductBaseStruct r15 = r14.getBaseInfo();
            if (r15 == null) goto L31;
            r2 = r15.getPromotionSource();
        L31:
            r0.d = String.valueOf(r2);
            Integer r16 = this.a;
            if (r16 != null) goto L35;
        L37:
            if (r16 != null) goto L40;
        L42:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L40:
            if (r16.intValue() != 0) goto L42;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L42
        L35:
            if (r16.intValue() != 2) goto L37;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
        L21:
            r11 = null;
        L11:
            r6 = null;
            goto L12
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class j<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ rd3.a d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;

        public j(Integer r1, Context r2, rd3.a r3, boolean r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
            this.f = r5;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            rd3.a r0 = this.d;
            if (r0 == null) goto L7;
            Promotion r1 = r0.f();
            if (r1 == null) goto L7;
            PromotionProductStruct r2 = r1.getPromotionInfo();
        L8:
            v0 r3 = new v0();
            r3.a = f53.a.b(r2) ? 1 : 0;
            r3.b = f53.a.a(r2);
            r3.c = this.e ? 1 : 0;
            rd3.a r4 = this.d;
            if (r4 != null) goto L11;
        L13:
            r3.appendParam("btm_id", this.f);
            Integer r5 = this.a;
            if (r5 != null) goto L17;
        L19:
            if (r5 != null) goto L22;
        L24:
            r3.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r3.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r3;
        L22:
            if (r5.intValue() != 0) goto L24;
            com.bytedance.android.shopping.feed.event.g.b(r3, this.b);
            goto L24
        L17:
            if (r5.intValue() != 2) goto L19;
            com.bytedance.android.shopping.feed.event.g.a(r3, this.b, this.c);
            goto L24
        L11:
            if (r4.e != true) goto L13;
            r3.d = "guess_you_like_product";
        L7:
            r2 = null;
            goto L8
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class k<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ rd3.a d;
        public final /* synthetic */ String e;

        public k(Integer r1, Context r2, rd3.a r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            rd3.a r0 = this.d;
            if (r0 == null) goto L7;
            Promotion r1 = r0.f();
            if (r1 == null) goto L7;
            PromotionProductStruct r2 = r1.getPromotionInfo();
        L8:
            w0 r3 = new w0();
            r3.a = f53.a.b(r2) ? 1 : 0;
            r3.b = f53.a.a(r2);
            rd3.a r4 = this.d;
            if (r4 != null) goto L11;
        L13:
            r3.appendParam("btm_id", this.e);
            Integer r5 = this.a;
            if (r5 != null) goto L17;
        L19:
            if (r5 != null) goto L22;
        L24:
            r3.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r3.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r3;
        L22:
            if (r5.intValue() != 0) goto L24;
            com.bytedance.android.shopping.feed.event.g.b(r3, this.b);
            goto L24
        L17:
            if (r5.intValue() != 2) goto L19;
            com.bytedance.android.shopping.feed.event.g.a(r3, this.b, this.c);
            goto L24
        L11:
            if (r4.e != true) goto L13;
            r3.c = "guess_you_like_product";
        L7:
            r2 = null;
            goto L8
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class l<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ rd3.a e;
        public final /* synthetic */ AnchorV3Param f;

        public l(Integer r1, JSONObject r2, rd3.a r3, AnchorV3Param r4) {
            this.a = r1;
            this.b = null;
            this.c = null;
            this.d = r2;
            this.e = r3;
            this.f = r4;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            b0 r0 = new b0();
            r0.appendParam("product_tag", this.d.toString());
            r0.appendParam("tag_show_scene", "video");
            if (this.e.e == false) goto L5;
            String r1 = "video_flow_card";
        L6:
            r0.appendParam("tag_show_page_position", r1);
            Promotion r2 = this.e.f();
            if (r2 == null) goto L13;
            PromotionProductStruct r3 = r2.getPromotionInfo();
            if (r3 == null) goto L13;
            PromotionProductBaseStruct r4 = r3.getBaseInfo();
            if (r4 == null) goto L13;
            String r5 = r4.getProductId();
        L14:
            r0.appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r5);
            r0.appendParam("ecom_group_type", "video");
            String r6 = "";
            if (this.e.e == false) goto L17;
            String r7 = "guess_you_like";
        L24:
            r0.appendParam("ecom_entrance_form", r7);
            r0.appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
            AnchorV3Param r8 = this.f;
            if (r8 == null) goto L30;
            ECLogExtraData r9 = r8.getLogExtraData();
            if (r9 == null) goto L30;
            String r10 = r9.getEnterFrom();
            if (r10 == null) goto L30;
        L31:
            r0.appendParam("carrier_source", r10);
            AnchorV3Param r11 = this.f;
            if (r11 == null) goto L37;
            ECLogExtraData r12 = r11.getLogExtraData();
            if (r12 == null) goto L37;
            String r13 = r12.getEnterFrom();
            if (r13 == null) goto L37;
        L38:
            r0.appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, r13);
            if (this.e.e == false) goto L41;
            r6 = "guess_you_like_product";
        L41:
            r0.appendParam("module_label", r6);
            Integer r14 = this.a;
            if (r14 != null) goto L45;
        L47:
            if (r14 != null) goto L50;
        L52:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L50:
            if (r14.intValue() != 0) goto L52;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L52
        L45:
            if (r14.intValue() != 2) goto L47;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
        L37:
            r13 = "";
        L30:
            r10 = "";
            goto L31
        L17:
            AnchorV3Param r15 = this.f;
            if (r15 == null) goto L23;
            ECLogExtraData r16 = r15.getLogExtraData();
            if (r16 == null) goto L23;
            r7 = r16.getEComEntranceForm();
            if (r7 != null) goto L24;
        L23:
            r7 = "";
        L13:
            r5 = null;
            goto L14
        L5:
            r1 = "video_flow_first_card";
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class m<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ boolean g;

        public m(Integer r1, Context r2, boolean r3, String r4, int r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            s1 r0 = new s1("save_money_card_module_click");
            if (this.d == false) goto L5;
            String r1 = "video_product_feeds_new_resource";
        L6:
            r0.a = r1;
            r0.b = this.e;
            if (this.f != 2) goto L9;
            String r2 = "use";
        L10:
            r0.c = r2;
            if (this.g == false) goto L13;
            String r3 = "first_card_product";
        L14:
            r0.d = r3;
            Integer r4 = this.a;
            if (r4 != null) goto L18;
        L20:
            if (r4 != null) goto L23;
        L25:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L23:
            if (r4.intValue() != 0) goto L25;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L25
        L18:
            if (r4.intValue() != 2) goto L20;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L25
        L13:
            r3 = "guess_you_like_product";
            goto L14
        L9:
            r2 = "sale";
            goto L10
        L5:
            r1 = "video_product_feeds_discount_area";
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class n<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ boolean g;

        public n(Integer r1, Context r2, boolean r3, String r4, int r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            s1 r0 = new s1("save_money_card_module_show");
            if (this.d == false) goto L5;
            String r1 = "video_product_feeds_new_resource";
        L6:
            r0.a = r1;
            r0.b = this.e;
            if (this.f != 2) goto L9;
            String r2 = "use";
        L10:
            r0.c = r2;
            if (this.g == false) goto L13;
            String r3 = "first_card_product";
        L14:
            r0.d = r3;
            Integer r4 = this.a;
            if (r4 != null) goto L18;
        L20:
            if (r4 != null) goto L23;
        L25:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L23:
            if (r4.intValue() != 0) goto L25;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L25
        L18:
            if (r4.intValue() != 2) goto L20;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L25
        L13:
            r3 = "guess_you_like_product";
            goto L14
        L9:
            r2 = "sale";
            goto L10
        L5:
            r1 = "video_product_feeds_discount_area";
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class o<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ProductFeedViewModel d;
        public final /* synthetic */ rd3.a e;
        public final /* synthetic */ Boolean f;

        public o(Integer r1, Context r2, ProductFeedViewModel r3, rd3.a r4, Boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
            this.f = r5;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            AnchorV3Param r1 = this.d.m907getAnchorV3Param();
            if (r1 == null) goto L10;
            ECLogExtraData r2 = r1.getLogExtraData();
            if (r2 == null) goto L10;
            String r3 = r2.getEnterFrom();
            if (r3 == null) goto L10;
            String r4 = r3;
        L11:
            String r5 = this.e.c();
            String r6 = String.valueOf(this.e.f);
            rd3.g r7 = this.e.d();
            if (r7 == null) goto L17;
            String r8 = r7.a();
            if (r8 == null) goto L17;
            String r9 = r8;
        L18:
            rd3.a r10 = this.e;
            String r11 = r10.d;
            ProductFeedViewModel r12 = r10.c;
            if (r12 == null) goto L23;
            AnchorV3Param r13 = r12.m907getAnchorV3Param();
            if (r13 == null) goto L23;
            String r14 = r13.getVideoId();
        L24:
            ProductFeedViewModel r15 = this.e.c;
            if (r15 == null) goto L31;
            AnchorV3Param r16 = r15.m907getAnchorV3Param();
            if (r16 == null) goto L31;
            ECLogExtraData r17 = r16.getLogExtraData();
            if (r17 == null) goto L31;
            String r22 = r17.getEnterFrom();
        L33:
            if (Intrinsics.areEqual(this.f, Boolean.TRUE) == false) goto L35;
            String r18 = "";
        L36:
            AnchorV3Param r19 = this.d.m907getAnchorV3Param();
            if (r19 == null) goto L43;
            String r20 = r19.getEntranceInfo();
            if (r20 == null) goto L43;
            JSONObject r21 = com.bytedance.android.ec.core.utils.z1.g(r20);
            if (r21 == null) goto L43;
            String r23 = r21.optString("previous_page");
        L44:
            y1 r110 = new y1(r4, r5, r6, r9, r11, null, r23, r14, r18, r22, null, null, null, null, null, null, null, null, null, null);
            Integer r24 = this.a;
            if (r24 != null) goto L48;
        L50:
            y1 r25 = r110;
            if (r24 != null) goto L54;
        L56:
            r25.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r25.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r25;
        L54:
            if (r24.intValue() != 0) goto L56;
            com.bytedance.android.shopping.feed.event.g.b(r25, this.b);
            goto L56
        L48:
            if (r24.intValue() != 2) goto L50;
            r25 = r110;
            com.bytedance.android.shopping.feed.event.g.a(r25, this.b, this.c);
        L43:
            r23 = null;
            goto L44
        L35:
            r18 = "guess_you_like_product";
        L31:
            r22 = null;
        L23:
            r14 = null;
        L17:
            r9 = "";
        L10:
            r4 = "";
            goto L11
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class p<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ProductFeedViewModel d;
        public final /* synthetic */ PromotionProductStruct e;
        public final /* synthetic */ String f;
        public final /* synthetic */ rd3.a g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public p(Integer r1, Context r2, List r3, ProductFeedViewModel r4, PromotionProductStruct r5, String r6, rd3.a r7, String r8, String r9, String r10, String r11, String r12) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            g2 r0 = new g2("click_store_entrance");
            AnchorV3Param r1 = this.d.m907getAnchorV3Param();
            if (r1 == null) goto L5;
            int r2 = com.bytedance.android.ec.core.anchorv3.a.a;
            r0.e = com.bytedance.android.ec.core.anchorv3.a.a(r1.getRequestParam().getSourcePage());
        L5:
            r0.a = String.valueOf(this.d.getDurationFromResume());
            int r3 = com.bytedance.android.shopping.anchorv3.utils.y.a;
            r0.f = com.bytedance.android.shopping.anchorv3.utils.y.d(this.e);
            PromotionProductStruct r4 = this.e;
            String r5 = null;
            if (r4 == null) goto L10;
            PromotionProductExtraStruct r6 = r4.getExtraInfo();
            if (r6 == null) goto L10;
            String r7 = r6.getShopId();
        L11:
            r0.g = r7;
            r0.h = this.f;
            PromotionProductStruct r8 = this.e;
            if (r8 == null) goto L24;
            PromotionProductAuthorEntriesStruct r9 = r8.getEntryInfo();
            if (r9 == null) goto L24;
            PromotionProductShopEntryStruct r10 = r9.getShopEntry();
            if (r10 == null) goto L19;
            String r11 = r10.getShopAuthorId();
            if (r11 == null) goto L19;
        L23:
            if (r11 == null) goto L24;
        L25:
            r0.b = r11;
            r0.i = this.g.m;
            if (cg4.a.a(this.h) == false) goto L29;
            String r12 = this.h;
        L32:
            r0.d = r12;
            String r13 = this.i;
            if (r13 != null) goto L35;
        L37:
            r0.c = this.j;
            r0.k = this.k;
            r0.l = this.l;
            AnchorV3Param r14 = this.d.m907getAnchorV3Param();
            if (r14 == null) goto L40;
            r0.j = r14.getRequestParam().getSourcePage();
        L40:
            Integer r15 = this.a;
            if (r15 != null) goto L44;
        L46:
            if (r15 != null) goto L49;
        L51:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L49:
            if (r15.intValue() != 0) goto L51;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L51
        L44:
            if (r15.intValue() != 2) goto L46;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L51
        L35:
            if (com.bytedance.android.ec.core.utils.a2.d(r13) == null) goto L37;
            String r16 = this.i;
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("btm_id", r16, com.bytedance.android.ec.core.event.a.b.a.a);
            goto L37
        L29:
            if (this.g.e == false) goto L31;
            r12 = "product_flow_page_102";
            goto L32
        L31:
            r12 = "product_flow_page_101";
        L19:
            ShopBindAuthorDTO r17 = r9.getShopBindAuthor();
            if (r17 == null) goto L22;
            r5 = r17.getAuthorId();
        L22:
            r11 = r5;
        L24:
            r11 = "";
        L10:
            r7 = null;
            goto L11
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class q<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ProductFeedViewModel d;
        public final /* synthetic */ PromotionProductStruct e;
        public final /* synthetic */ String f;
        public final /* synthetic */ rd3.a g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        public q(Integer r1, Context r2, ProductFeedViewModel r3, PromotionProductStruct r4, String r5, rd3.a r6, String r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            this.i = r8;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            g2 r0 = new g2("show_store_entrance");
            AnchorV3Param r1 = this.d.m907getAnchorV3Param();
            if (r1 == null) goto L5;
            int r2 = com.bytedance.android.ec.core.anchorv3.a.a;
            r0.e = com.bytedance.android.ec.core.anchorv3.a.a(r1.getRequestParam().getSourcePage());
        L5:
            r0.a = String.valueOf(this.d.getDurationFromResume());
            int r3 = com.bytedance.android.shopping.anchorv3.utils.y.a;
            r0.f = com.bytedance.android.shopping.anchorv3.utils.y.d(this.e);
            PromotionProductStruct r4 = this.e;
            String r5 = null;
            if (r4 == null) goto L10;
            PromotionProductExtraStruct r6 = r4.getExtraInfo();
            if (r6 == null) goto L10;
            String r7 = r6.getShopId();
        L11:
            r0.g = r7;
            r0.h = this.f;
            PromotionProductStruct r8 = this.e;
            if (r8 == null) goto L24;
            PromotionProductAuthorEntriesStruct r9 = r8.getEntryInfo();
            if (r9 == null) goto L24;
            PromotionProductShopEntryStruct r10 = r9.getShopEntry();
            if (r10 == null) goto L19;
            String r11 = r10.getShopAuthorId();
            if (r11 == null) goto L19;
        L23:
            if (r11 == null) goto L24;
        L25:
            r0.b = r11;
            r0.i = this.g.m;
            if (cg4.a.a(this.h) == false) goto L29;
            String r12 = this.h;
        L32:
            r0.d = r12;
            String r13 = this.i;
            if (r13 != null) goto L35;
        L37:
            AnchorV3Param r14 = this.d.m907getAnchorV3Param();
            if (r14 == null) goto L40;
            r0.j = r14.getRequestParam().getSourcePage();
        L40:
            Integer r15 = this.a;
            if (r15 != null) goto L44;
        L46:
            if (r15 != null) goto L49;
        L51:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L49:
            if (r15.intValue() != 0) goto L51;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L51
        L44:
            if (r15.intValue() != 2) goto L46;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L51
        L35:
            if (com.bytedance.android.ec.core.utils.a2.d(r13) == null) goto L37;
            String r16 = this.i;
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("btm_id", r16, com.bytedance.android.ec.core.event.a.b.a.a);
            goto L37
        L29:
            if (this.g.e == false) goto L31;
            r12 = "product_flow_page_102";
            goto L32
        L31:
            r12 = "product_flow_page_101";
        L19:
            ShopBindAuthorDTO r17 = r9.getShopBindAuthor();
            if (r17 == null) goto L22;
            r5 = r17.getAuthorId();
        L22:
            r11 = r5;
        L24:
            r11 = "";
        L10:
            r7 = null;
            goto L11
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class r<V> implements Callable {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ AnchorV3Param d;
        public final /* synthetic */ String e;
        public final /* synthetic */ rd3.a f;
        public final /* synthetic */ boolean g;

        public r(Integer r1, Context r2, AnchorV3Param r3, String r4, rd3.a r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = null;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
        }

        @Override // java.util.concurrent.Callable
        public final com.bytedance.android.ec.core.event.a call() {
            j2 r0 = new j2(this.e);
            r0.a = this.f.d;
            String r1 = this.d.getEntranceInfo();
            Fragment r2 = null;
            if (r1 == null) goto L7;
            JSONObject r3 = com.bytedance.android.ec.core.utils.z1.g(r1);
            if (r3 == null) goto L7;
            String r4 = r3.optString("carrier_source");
        L8:
            r0.f = r4;
            r0.d = this.d.getRequestParam().getItemId();
            r0.b = "product_flow_page";
            if (this.g == false) goto L11;
            String r5 = "guess_you_like_product";
        L12:
            r0.e = r5;
            Promotion r6 = this.f.f();
            if (r6 == null) goto L19;
            PromotionProductStruct r7 = r6.getPromotionInfo();
            if (r7 == null) goto L19;
            PromotionProductBaseStruct r8 = r7.getBaseInfo();
            if (r8 == null) goto L19;
            String r9 = r8.getProductId();
        L20:
            r0.c = r9;
            if (this.g == false) goto L23;
            String r10 = "product_card";
        L24:
            r0.g = r10;
            rd3.a r11 = this.f;
            r0.h = r11.m;
            int r12 = com.bytedance.android.shopping.feed.utils.c.a;
            Promotion r13 = r11.f();
            if (r13 == null) goto L29;
            PromotionProductStruct r14 = r13.getPromotionInfo();
            if (r14 == null) goto L29;
            PromotionProductPriceStruct r15 = r14.getProductPrice();
        L30:
            r0.i = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r15));
            Promotion r16 = this.f.f();
            if (r16 == null) goto L35;
            PromotionProductStruct r17 = r16.getPromotionInfo();
            if (r17 == null) goto L35;
            PromotionProductPriceStruct r18 = r17.getProductPrice();
        L36:
            r0.j = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r18));
            Promotion r19 = this.f.f();
            if (r19 == null) goto L41;
            PromotionProductStruct r20 = r19.getPromotionInfo();
            if (r20 == null) goto L41;
            PromotionProductPriceStruct r21 = r20.getProductPrice();
        L42:
            r0.k = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r21));
            Promotion r22 = this.f.f();
            if (r22 == null) goto L47;
            PromotionProductStruct r23 = r22.getPromotionInfo();
            if (r23 == null) goto L47;
            PromotionProductPriceStruct r24 = r23.getProductPrice();
        L48:
            r0.l = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r24));
            JSONObject r25 = new JSONObject();
            if (Intrinsics.areEqual(this.e, "click_wish_button") == true) goto L51;
            String r26 = "";
        L55:
            ProductFeedViewModel r27 = this.f.c;
            if (r27 == null) goto L58;
            r2 = r27.getFlowFragment();
        L58:
            Iterator r28 = BtmSDK.INSTANCE.createReportParams(r26, PageFinder.via(r2)).entrySet().iterator();
        L60:
            if (r28.hasNext() == false) goto L62;
            Map.Entry r29 = (Map.Entry) r28.next();
            r25.put((String) r29.getKey(), r29.getValue());
            goto L60
        L62:
            r0.appendParam(com.bytedance.android.ec.core.utils.z1.j(r25));
            Integer r30 = this.a;
            if (r30 != null) goto L66;
        L68:
            if (r30 != null) goto L71;
        L73:
            r0.buildLogParams();
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
            return r0;
        L71:
            if (r30.intValue() != 0) goto L73;
            com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
            goto L73
        L66:
            if (r30.intValue() != 2) goto L68;
            com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
            goto L73
        L51:
            if (this.f.e == false) goto L53;
            r26 = "c3865.d90626";
            goto L55
        L53:
            r26 = "c4701.d43041";
        L47:
            r24 = null;
        L41:
            r21 = null;
        L35:
            r18 = null;
        L29:
            r15 = null;
            goto L30
        L23:
            r10 = "video";
        L19:
            r9 = null;
            goto L20
        L11:
            r5 = null;
        L7:
            r4 = null;
            goto L8
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public FeedProductEventTracker() {
    }

    static {
        a = new FeedProductEventTracker();
    }

    public static void J(rd3.a r5) {
        if (r5 == null) goto L6;
        ProductFeedViewModel r0 = r5.c;
        if (r0 == null) goto L6;
        AnchorV3Param r1 = r0.m907getAnchorV3Param();
    L7:
        if (r5 == null) goto L20;
        Promotion r2 = r5.f();
        if (r2 == null) goto L22;
        PromotionProductStruct r3 = r2.getPromotionInfo();
        if (r3 == null) goto L23;
        PromotionProductPrivilegesStruct r4 = r3.getPrivilegeInfo();
        if (r4 == null) goto L24;
        List r6 = r4.getTagInfoShowList();
        if (r6 == null) goto L25;
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L26;
        Single.fromCallable(new l(2, (JSONObject) r7.next(), r5, r1)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        goto L18
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L6:
        r1 = null;
        goto L7
    }

    public static boolean h(PromotionProductStruct r0) {
        if (r0 == null) goto L10;
        PromotionProductPrivilegesStruct r1 = r0.getPrivilegeInfo();
        if (r1 == null) goto L10;
        PromotionProductActivitiesStruct r2 = r1.getActivities();
        if (r2 == null) goto L10;
        GroupInfo r3 = r2.getGroupInfoActivity();
        if (r3 == null) goto L10;
        return r3.isInGroup();
    L10:
        return false;
    }

    public static void p(rd3.a r14) {
        Integer r0 = null;
        if (r14 == null) goto L7;
        ProductFeedViewModel r1 = r14.c;
        if (r1 == null) goto L7;
        AnchorV3Param r2 = r1.m907getAnchorV3Param();
    L8:
        String r3 = "";
        if (r2 == null) goto L18;
        String r4 = r2.getEntranceInfo();
        if (r4 == null) goto L18;
        JSONObject r5 = com.bytedance.android.ec.core.utils.z1.g(r4);
        if (r5 == null) goto L18;
        String r6 = r5.optString("product_source_page", "");
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        String r12 = r6;
    L19:
        int r7 = ld3.b.a;
        if (r14 == null) goto L31;
        Promotion r8 = r14.f();
        if (r8 == null) goto L31;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L31;
        PromotionProductBaseStruct r10 = r9.getBaseInfo();
        if (r10 == null) goto L31;
        String r11 = r10.getProductId();
        if (r11 == null) goto L31;
        String r13 = r11;
    L33:
        if (r14 != null) goto L35;
    L37:
        String r15 = "";
    L38:
        if (r2 == null) goto L41;
        String r16 = r2.getAuthorId();
        if (r16 == null) goto L41;
    L42:
        if (r14 == null) goto L51;
        ProductFeedViewModel r17 = r14.c;
        if (r17 == null) goto L51;
        PromotionProductStruct r18 = r17.getPromotion();
        if (r18 == null) goto L51;
        PromotionProductBaseStruct r19 = r18.getBaseInfo();
        if (r19 == null) goto L51;
        String r20 = r19.getPromotionId();
        if (r20 == null) goto L51;
    L52:
        if (r14 == null) goto L60;
        ProductFeedViewModel r21 = r14.c;
        if (r21 == null) goto L60;
        PromotionProductStruct r22 = r21.getPromotion();
        if (r22 == null) goto L60;
        PromotionProductBaseStruct r23 = r22.getBaseInfo();
        if (r23 == null) goto L60;
        r0 = r23.getPromotionSource();
    L60:
        String r24 = String.valueOf(r0);
        if (r2 == null) goto L68;
        Integer r25 = r2.getFollowStatus();
        if (r25 == null) goto L68;
        String r26 = String.valueOf(r25.intValue());
        if (r26 == null) goto L68;
        String r110 = r26;
    L69:
        if (r2 == null) goto L74;
        String r27 = r2.getVideoId();
        if (r27 == null) goto L74;
        String r111 = r27;
    L75:
        if (r14 != null) goto L77;
    L79:
        if (r2 == null) goto L86;
        ECLogExtraData r112 = r2.getLogExtraData();
        if (r112 == null) goto L86;
        String r113 = r112.getEComEntranceForm();
        if (r113 == null) goto L86;
        String r114 = r113;
    L87:
        new a0(r13, r15, r16, r20, r24, r110, r111, r12, r114);
        return;
    L86:
        r114 = r3;
        goto L87
    L77:
        if (r14.e != true) goto L79;
        r3 = "guess_you_like";
    L74:
        r111 = "";
    L68:
        r110 = "";
    L51:
        r20 = "";
    L41:
        r16 = "";
        goto L42
    L35:
        if (r14.e != true) goto L37;
        r15 = "guess_you_like_product";
    L31:
        r13 = "";
    L18:
        r12 = "";
    L7:
        r2 = null;
        goto L8
    }

    public static void B(Context r4, rd3.a r5) {
        Single.fromCallable(new i(2, r4, CollectionsKt.listOf(new String[]{PdpOpenThirdParam.KEY_PRODUCT_ID, "commodity_id", "commodity_type"}), r5)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void H(rd3.a r9, Context r10) {
        String r0 = null;
        if (r9 == null) goto L7;
        ProductFeedViewModel r1 = r9.c;
        if (r1 == null) goto L7;
        AnchorV3Param r2 = r1.m907getAnchorV3Param();
    L8:
        String r3 = "";
        if (r2 == null) goto L16;
        String r4 = r2.getEntranceInfo();
        if (r4 == null) goto L16;
        JSONObject r5 = com.bytedance.android.ec.core.utils.z1.g(r4);
        if (r5 == null) goto L16;
        String r6 = r5.optString("product_source_page", "");
        if (r6 == null) goto L16;
    L17:
        if (r9 == null) goto L29;
        Promotion r7 = r9.f();
        if (r7 == null) goto L29;
        PromotionProductStruct r8 = r7.getPromotionInfo();
        if (r8 == null) goto L29;
        PromotionProductExtraStruct r11 = r8.getExtraInfo();
        if (r11 == null) goto L29;
        String r12 = r11.getLogExtra();
        if (r12 == null) goto L29;
        JSONObject r13 = com.bytedance.android.ec.core.utils.z1.g(r12);
        if (r13 == null) goto L29;
        String r14 = r13.optString("inflow_list_type", "");
        String r15 = r13.optString("rank_id", "");
    L30:
        r1 r16 = new r1();
        r16.a = "product_flow_page";
        if (r9 != null) goto L33;
    L35:
        if (r2 == null) goto L40;
        ECLogExtraData r17 = r2.getLogExtraData();
        if (r17 == null) goto L40;
        String r18 = r17.getEComEntranceForm();
        if (r18 == null) goto L40;
    L41:
        r16.b = r18;
        if (r9 == null) goto L44;
        Integer r19 = Integer.valueOf(r9.f);
    L45:
        r16.c = String.valueOf(r19);
        if (r9 == null) goto L55;
        Promotion r20 = r9.f();
        if (r20 == null) goto L55;
        PromotionProductStruct r21 = r20.getPromotionInfo();
        if (r21 == null) goto L55;
        PromotionProductBaseStruct r22 = r21.getBaseInfo();
        if (r22 == null) goto L55;
        String r23 = r22.getPromotionId();
        if (r23 == null) goto L55;
    L56:
        r16.d = r23;
        if (r9 == null) goto L65;
        Promotion r24 = r9.f();
        if (r24 == null) goto L65;
        PromotionProductStruct r25 = r24.getPromotionInfo();
        if (r25 == null) goto L65;
        PromotionProductBaseStruct r26 = r25.getBaseInfo();
        if (r26 == null) goto L65;
        Integer r27 = r26.getPromotionSource();
    L66:
        r16.e = String.valueOf(r27);
        r16.f = r6;
        if (r9 != null) goto L69;
    L71:
        String r28 = "";
    L72:
        r16.g = r28;
        r16.h = "product_card";
        if (r9 == null) goto L85;
        Promotion r29 = r9.f();
        if (r29 == null) goto L85;
        PromotionProductStruct r30 = r29.getPromotionInfo();
        if (r30 == null) goto L85;
        PromotionProductAuthorEntriesStruct r31 = r30.getEntryInfo();
        if (r31 == null) goto L85;
        ProductLeaderBoardEntryStruct r32 = r31.getLeaderBoardEntry();
        if (r32 == null) goto L85;
        Integer r33 = r32.getRank();
        if (r33 == null) goto L85;
        r0 = String.valueOf(r33.intValue());
    L85:
        r16.i = r0;
        r16.j = r14;
        r16.k = r15;
        if (r9 == null) goto L97;
        Promotion r34 = r9.f();
        if (r34 == null) goto L97;
        PromotionProductStruct r35 = r34.getPromotionInfo();
        if (r35 == null) goto L97;
        PromotionProductBaseStruct r36 = r35.getBaseInfo();
        if (r36 == null) goto L97;
        String r37 = r36.getProductId();
        if (r37 == null) goto L97;
        r3 = r37;
    L97:
        r16.l = r3;
        com.bytedance.android.shopping.feed.event.g.c(r16, r10, CollectionsKt.listOf(new String[]{PdpOpenThirdParam.KEY_PRODUCT_ID, "commodity_id"}));
        return;
    L69:
        if (r9.e != true) goto L71;
        r28 = "guess_you_like_product";
    L65:
        r27 = null;
    L55:
        r23 = "";
        goto L56
    L44:
        r19 = null;
    L40:
        r18 = "";
        goto L41
    L33:
        if (r9.e != true) goto L35;
        r18 = "guess_you_like";
    L29:
        r15 = "";
        r14 = r15;
    L16:
        r6 = "";
    L7:
        r2 = null;
        goto L8
    }

    public static void I(rd3.a r9, Context r10) {
        String r0 = null;
        if (r9 == null) goto L7;
        ProductFeedViewModel r1 = r9.c;
        if (r1 == null) goto L7;
        AnchorV3Param r2 = r1.m907getAnchorV3Param();
    L8:
        String r3 = "";
        if (r2 == null) goto L16;
        String r4 = r2.getEntranceInfo();
        if (r4 == null) goto L16;
        JSONObject r5 = com.bytedance.android.ec.core.utils.z1.g(r4);
        if (r5 == null) goto L16;
        String r6 = r5.optString("product_source_page", "");
        if (r6 == null) goto L16;
    L17:
        if (r9 == null) goto L29;
        Promotion r7 = r9.f();
        if (r7 == null) goto L29;
        PromotionProductStruct r8 = r7.getPromotionInfo();
        if (r8 == null) goto L29;
        PromotionProductExtraStruct r11 = r8.getExtraInfo();
        if (r11 == null) goto L29;
        String r12 = r11.getLogExtra();
        if (r12 == null) goto L29;
        JSONObject r13 = com.bytedance.android.ec.core.utils.z1.g(r12);
        if (r13 == null) goto L29;
        String r14 = r13.optString("inflow_list_type", "");
        String r15 = r13.optString("rank_id", "");
    L30:
        pe3.a r16 = new pe3.a();
        r16.a = "product_flow_page";
        if (r9 != null) goto L33;
    L35:
        if (r2 == null) goto L40;
        ECLogExtraData r17 = r2.getLogExtraData();
        if (r17 == null) goto L40;
        String r18 = r17.getEComEntranceForm();
        if (r18 == null) goto L40;
    L41:
        r16.b = r18;
        if (r9 == null) goto L44;
        Integer r19 = Integer.valueOf(r9.f);
    L45:
        r16.c = String.valueOf(r19);
        if (r9 == null) goto L55;
        Promotion r20 = r9.f();
        if (r20 == null) goto L55;
        PromotionProductStruct r21 = r20.getPromotionInfo();
        if (r21 == null) goto L55;
        PromotionProductBaseStruct r22 = r21.getBaseInfo();
        if (r22 == null) goto L55;
        String r23 = r22.getPromotionId();
        if (r23 == null) goto L55;
    L56:
        r16.d = r23;
        if (r9 == null) goto L65;
        Promotion r24 = r9.f();
        if (r24 == null) goto L65;
        PromotionProductStruct r25 = r24.getPromotionInfo();
        if (r25 == null) goto L65;
        PromotionProductBaseStruct r26 = r25.getBaseInfo();
        if (r26 == null) goto L65;
        Integer r27 = r26.getPromotionSource();
    L66:
        r16.e = String.valueOf(r27);
        r16.f = r6;
        if (r9 != null) goto L69;
    L71:
        String r28 = "";
    L72:
        r16.g = r28;
        r16.h = "product_card";
        if (r9 == null) goto L85;
        Promotion r29 = r9.f();
        if (r29 == null) goto L85;
        PromotionProductStruct r30 = r29.getPromotionInfo();
        if (r30 == null) goto L85;
        PromotionProductAuthorEntriesStruct r31 = r30.getEntryInfo();
        if (r31 == null) goto L85;
        ProductLeaderBoardEntryStruct r32 = r31.getLeaderBoardEntry();
        if (r32 == null) goto L85;
        Integer r33 = r32.getRank();
        if (r33 == null) goto L85;
        r0 = String.valueOf(r33.intValue());
    L85:
        r16.i = r0;
        r16.j = r14;
        r16.k = r15;
        if (r9 == null) goto L97;
        Promotion r34 = r9.f();
        if (r34 == null) goto L97;
        PromotionProductStruct r35 = r34.getPromotionInfo();
        if (r35 == null) goto L97;
        PromotionProductBaseStruct r36 = r35.getBaseInfo();
        if (r36 == null) goto L97;
        String r37 = r36.getProductId();
        if (r37 == null) goto L97;
        r3 = r37;
    L97:
        r16.l = r3;
        com.bytedance.android.shopping.feed.event.g.c(r16, r10, CollectionsKt.listOf(new String[]{PdpOpenThirdParam.KEY_PRODUCT_ID, "commodity_id"}));
        return;
    L69:
        if (r9.e != true) goto L71;
        r28 = "guess_you_like_product";
    L65:
        r27 = null;
    L55:
        r23 = "";
        goto L56
    L44:
        r19 = null;
    L40:
        r18 = "";
        goto L41
    L33:
        if (r9.e != true) goto L35;
        r18 = "guess_you_like";
    L29:
        r15 = "";
        r14 = r15;
    L16:
        r6 = "";
    L7:
        r2 = null;
        goto L8
    }

    public static void M(rd3.a r13, Context r14) {
        if (r13 == null) goto L7;
        ProductFeedViewModel r1 = r13.c;
        if (r1 == null) goto L7;
        AnchorV3Param r2 = r1.m907getAnchorV3Param();
    L9:
        if (r2 == null) goto L18;
        String r3 = r2.getEntranceInfo();
        if (r3 == null) goto L18;
        JSONObject r4 = com.bytedance.android.ec.core.utils.z1.g(r3);
        if (r4 == null) goto L18;
        String r5 = r4.optString("product_source_page", "");
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r11 = r5;
    L20:
        if (r13 == null) goto L31;
        Promotion r6 = r13.f();
        if (r6 == null) goto L31;
        PromotionProductStruct r7 = r6.getPromotionInfo();
        if (r7 == null) goto L31;
        PromotionProductBaseStruct r8 = r7.getBaseInfo();
        if (r8 == null) goto L31;
        String r9 = r8.getProductId();
        if (r9 == null) goto L31;
        String r10 = r9;
    L32:
        if (r13 != null) goto L34;
    L36:
        String r12 = "";
    L37:
        if (r2 == null) goto L42;
        String r15 = r2.getAuthorId();
        if (r15 == null) goto L42;
        String r16 = r15;
    L43:
        if (r13 == null) goto L54;
        ProductFeedViewModel r17 = r13.c;
        if (r17 == null) goto L54;
        PromotionProductStruct r18 = r17.getPromotion();
        if (r18 == null) goto L54;
        PromotionProductBaseStruct r19 = r18.getBaseInfo();
        if (r19 == null) goto L54;
        String r20 = r19.getPromotionId();
        if (r20 == null) goto L54;
        String r21 = r20;
    L55:
        if (r13 == null) goto L63;
        ProductFeedViewModel r110 = r13.c;
        if (r110 == null) goto L63;
        PromotionProductStruct r111 = r110.getPromotion();
        if (r111 == null) goto L63;
        PromotionProductBaseStruct r112 = r111.getBaseInfo();
        if (r112 == null) goto L63;
        Integer r113 = r112.getPromotionSource();
    L64:
        String r22 = String.valueOf(r113);
        if (r2 == null) goto L70;
        String r114 = r2.getVideoId();
        if (r114 == null) goto L70;
        String r115 = r114;
    L71:
        if (r2 == null) goto L78;
        ECLogExtraData r116 = r2.getLogExtraData();
        if (r116 == null) goto L78;
        String r117 = r116.getEnterFrom();
        if (r117 == null) goto L78;
        String r118 = r117;
    L79:
        com.bytedance.android.shopping.feed.event.g.c(new c1(r10, r12, r16, r21, r22, r115, r11, r118), r14, null);
        return;
    L78:
        r118 = "";
    L70:
        r115 = "";
    L63:
        r113 = null;
    L54:
        r21 = "";
    L42:
        r16 = "";
        goto L43
    L34:
        if (r13.e != true) goto L36;
        r12 = "guess_you_like_product";
    L31:
        r10 = "";
    L18:
        r11 = "";
    L7:
        r2 = null;
        goto L9
    }

    public static void a(u0 r1, PromotionProductStruct r2) {
        if (ECSettingKeys.g0() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L14;
        PromotionProductExtraStruct r3 = r2.getExtraInfo();
        if (r3 == null) goto L15;
        String r4 = r3.getLogExtra();
        if (r4 == null) goto L16;
        JSONObject r5 = com.bytedance.android.ec.core.utils.z1.g(r4);
        if (r5 == null) goto L17;
        r1.h2 = r5.optString("standard_track_param");
        r1.p2 = r5.optString("standard_product_marketing_param");
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static String f(rd3.a r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "btmPoint");
        if (r1 == null) goto L5;
        int r3 = r1.f;
    L7:
        return r2 + "_i" + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public static Map g(rd3.a r5, String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = null;
        if (r5 == null) goto L7;
        ProductFeedViewModel r7 = r5.c;
        if (r7 == null) goto L7;
        AnchorV3Param r8 = r7.m907getAnchorV3Param();
    L8:
        String r2 = "";
        if (r8 == null) goto L12;
        String r3 = r8.getVideoId();
        if (r3 == null) goto L12;
    L13:
        r0.put("group_id", r3);
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r0.put("request_id", r6);
        if (r8 == null) goto L22;
        String r9 = r8.getAuthorId();
        if (r9 == null) goto L22;
        r2 = r9;
    L22:
        r0.put("author_id", r2);
        if (r8 == null) goto L27;
        ECAdLogExtra r10 = r8.getAdLogExtra();
        if (r10 == null) goto L27;
        String r11 = r10.getCreativeId();
    L28:
        boolean r4 = false;
        if (r11 != null) goto L31;
    L34:
        boolean r12 = true;
    L36:
        if ((!r12) == true) goto L39;
        r11 = null;
    L39:
        if (r11 == null) goto L41;
        String r13 = (String) r0.put("cid", r11);
    L41:
        if (r8 == null) goto L43;
        String r14 = r8.getAdType();
    L44:
        if (r14 != null) goto L46;
    L47:
        r4 = true;
    L49:
        if ((!r4) == false) goto L52;
        r1 = r14;
    L52:
        if (r1 != null) goto L54;
    L55:
        String r15 = (String) r0.put("ad_type", "0");
    L56:
        return r0;
    L54:
        if (((String) r0.put("ad_type", r1)) != null) goto L56;
    L46:
        if (r14.length() != 0) goto L49;
    L43:
        r14 = null;
        goto L44
    L31:
        if (r11.length() == 0) goto L34;
        r12 = false;
    L27:
        r11 = null;
    L12:
        r3 = "";
    L7:
        r8 = null;
        goto L8
    }

    public static void i(Context r8, rd3.a r9) {
        Boolean r0 = null;
        if (r9 == null) goto L7;
        Promotion r1 = r9.f();
        if (r1 == null) goto L7;
        PromotionProductStruct r6 = r1.getPromotionInfo();
    L8:
        if (r9 == null) goto L10;
        r0 = Boolean.valueOf(r9.e);
    L10:
        Single.fromCallable(new a(2, r8, CollectionsKt.listOf(new String[]{"ecom_group_type", PdpOpenThirdParam.KEY_PRODUCT_ID}), r6, r0)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L7:
        r6 = null;
        goto L8
    }

    public static void F(Context r2, rd3.a r3, String r4) {
        Single.fromCallable(new k(2, r2, r3, r4)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void G(Context r2, String r3, TopicItemInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        p1 r0 = new p1(r3);
        if (r4 == null) goto L5;
        String r1 = r4.getId();
    L6:
        r0.a = r1;
        if (r4 == null) goto L9;
        String r5 = r4.getName();
    L10:
        r0.b = r5;
        if (r4 == null) goto L13;
        String r6 = r4.getLabelInfo();
    L14:
        r0.c = r6;
        com.bytedance.android.shopping.feed.event.g.c(r0, r2, null);
        return;
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static void O(rd3.a r7, Boolean r8, Context r9) {
        if (r7 == null) goto L8;
        ProductFeedViewModel r3 = r7.c;
        if (r3 == null) goto L9;
        Single.fromCallable(new o(2, r9, r3, r7, r8)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L9:
        return;
    }

    public static void T(String r9, Context r10, rd3.a r11) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r11 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r11 == null) goto L79;
        ProductFeedViewModel r0 = r11.c;
        if (r0 == null) goto L80;
        AnchorV3Param r5 = r0.m907getAnchorV3Param();
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.isOptInflowCode() == false) goto L16;
        Single.fromCallable(new r(2, r10, r5, r9, r11, r8)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L16:
        j2 r1 = new j2(r9);
        r1.a = r11.d;
        String r2 = r5.getEntranceInfo();
        Fragment r3 = null;
        if (r2 == null) goto L21;
        JSONObject r4 = com.bytedance.android.ec.core.utils.z1.g(r2);
        if (r4 == null) goto L21;
        String r6 = r4.optString("carrier_source");
    L22:
        r1.f = r6;
        r1.d = r5.getRequestParam().getItemId();
        r1.b = "product_flow_page";
        if (r8 == false) goto L25;
        String r7 = "guess_you_like_product";
    L26:
        r1.e = r7;
        Promotion r12 = r11.f();
        if (r12 == null) goto L33;
        PromotionProductStruct r13 = r12.getPromotionInfo();
        if (r13 == null) goto L33;
        PromotionProductBaseStruct r14 = r13.getBaseInfo();
        if (r14 == null) goto L33;
        String r15 = r14.getProductId();
    L34:
        r1.c = r15;
        if (r8 == false) goto L37;
        String r16 = "product_card";
    L38:
        r1.g = r16;
        r1.h = r11.m;
        int r17 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r18 = r11.f();
        if (r18 == null) goto L43;
        PromotionProductStruct r19 = r18.getPromotionInfo();
        if (r19 == null) goto L43;
        PromotionProductPriceStruct r20 = r19.getProductPrice();
    L44:
        r1.i = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r20));
        Promotion r21 = r11.f();
        if (r21 == null) goto L49;
        PromotionProductStruct r22 = r21.getPromotionInfo();
        if (r22 == null) goto L49;
        PromotionProductPriceStruct r23 = r22.getProductPrice();
    L50:
        r1.j = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r23));
        Promotion r24 = r11.f();
        if (r24 == null) goto L55;
        PromotionProductStruct r25 = r24.getPromotionInfo();
        if (r25 == null) goto L55;
        PromotionProductPriceStruct r26 = r25.getProductPrice();
    L56:
        r1.k = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r26));
        Promotion r27 = r11.f();
        if (r27 == null) goto L61;
        PromotionProductStruct r28 = r27.getPromotionInfo();
        if (r28 == null) goto L61;
        PromotionProductPriceStruct r29 = r28.getProductPrice();
    L62:
        r1.l = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r29));
        JSONObject r30 = new JSONObject();
        if (Intrinsics.areEqual(r9, "click_wish_button") == true) goto L65;
        String r31 = "";
    L69:
        ProductFeedViewModel r110 = r11.c;
        if (r110 == null) goto L72;
        r3 = r110.getFlowFragment();
    L72:
        Iterator r32 = BtmSDK.INSTANCE.createReportParams(r31, PageFinder.via(r3)).entrySet().iterator();
    L74:
        if (r32.hasNext() == false) goto L76;
        Map.Entry r111 = (Map.Entry) r32.next();
        r30.put((String) r111.getKey(), r111.getValue());
        goto L74
    L76:
        r1.appendParam(com.bytedance.android.ec.core.utils.z1.j(r30));
        com.bytedance.android.shopping.feed.event.g.d(r1, r10);
        return;
    L65:
        if (r11.e == false) goto L67;
        r31 = "c3865.d90626";
        goto L69
    L67:
        r31 = "c4701.d43041";
    L61:
        r29 = null;
    L55:
        r26 = null;
    L49:
        r23 = null;
    L43:
        r20 = null;
        goto L44
    L37:
        r16 = "video";
    L33:
        r15 = null;
        goto L34
    L25:
        r7 = null;
    L21:
        r6 = null;
        goto L22
    L80:
        return;
    L79:
        return;
    L5:
        if (r11.e != true) goto L7;
        r8 = true;
        goto L8
    }

    public static void s(Context r8, AnchorV3Param r9, String r10) {
        if (r9 == null) goto L5;
        PromotionProductStruct r1 = r9.getCurrentPromotion();
    L6:
        c0 r2 = new c0();
        if (r9 == null) goto L11;
        ECAnchorV3ExtraData r3 = r9.getAnchorV3ExtraData();
        if (r3 == null) goto L11;
        String r4 = r3.getPromotionLogId();
    L12:
        r2.a = r4;
        if (r9 == null) goto L17;
        ECLogExtraData r5 = r9.getLogExtraData();
        if (r5 == null) goto L17;
        String r6 = r5.getInflowRecommendType();
    L18:
        r2.b = String.valueOf(r6);
        r2.c = r10;
        String r7 = "1";
        if (r1 != null) goto L21;
    L23:
        String r11 = "0";
    L24:
        r2.e = r11;
        if (r9 == null) goto L29;
        String r12 = r9.getRawCreativeId();
        if (r12 == null) goto L29;
        r2.f = r12;
    L29:
        com.bytedance.android.shopping.feed.event.g.c(r2, r8, null);
        int r13 = ECSdk.a;
        pi.b r14 = (pi.b) ECSdk.a(pi.b.class);
        if (r14 == null) goto L51;
        JSONObject r15 = new JSONObject();
        if (r9 == null) goto L36;
        ECAnchorV3ExtraData r16 = r9.getAnchorV3ExtraData();
        if (r16 == null) goto L36;
        String r17 = r16.getPromotionLogId();
    L37:
        r15.put("log_id", r17);
        r15.put("status", 0);
        if (r9 == null) goto L42;
        ECLogExtraData r18 = r9.getLogExtraData();
        if (r18 == null) goto L42;
        String r19 = r18.getInflowRecommendType();
    L43:
        r15.put("inflow_recommend_type", String.valueOf(r19));
        r15.put("inflow_product_card_mode", r10);
        if (r1 != null) goto L46;
    L48:
        r7 = "0";
    L49:
        r15.put("video_product_is_unsale", r7);
        Unit r20 = Unit.INSTANCE;
        r14.monitorEvent("ec_perf_page_show_video_product_flow", r15, null, null);
        return;
    L46:
        if (d63.r.a(r1).a != true) goto L48;
    L42:
        r19 = null;
    L36:
        r17 = null;
        goto L37
    L51:
        return;
    L21:
        if (d63.r.a(r1).a != true) goto L23;
        r11 = "1";
    L17:
        r6 = null;
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static void y(Context r2, rd3.a r3, SearchItem r4) {
        Intrinsics.checkNotNullParameter("trending_words_show", "eventName");
        Intrinsics.checkNotNullParameter(r4, "searchItem");
        Single.fromCallable(new j0(4, r2, r3, r4)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void z(Context r9, rd3.a r10, SearchItem r11) {
        Intrinsics.checkNotNullParameter(r11, "searchItem");
        Single r0 = Single.fromCallable(new g(4, r9, r10, r11)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io());
        q0 r1 = q0.a;
        r0 r2 = r0.a;
        r0.subscribe(r1, r2);
        Single.fromCallable(new h(2, r9, CollectionsKt.listOf(PdpOpenThirdParam.KEY_PRODUCT_ID), r10, r11)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r1, r2);
    }

    public static void A(Context r1, String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        dh3.a r0 = new dh3.a(r2);
        r0.a = r3;
        r0.b = r4;
        com.bytedance.android.shopping.feed.event.g.c(r0, r1, null);
    }

    public static void E(Context r7, rd3.a r8, boolean r9, String r10) {
        Single.fromCallable(new j(2, r7, r8, r9, r10)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void Q(String r2, Context r3, ProductFeedViewModel r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        jd3.v0 r0 = new jd3.v0(r2);
        if (r4 == null) goto L9;
        AnchorV3Param r1 = r4.m907getAnchorV3Param();
        if (r1 == null) goto L9;
        ECLogExtraData r6 = r1.getLogExtraData();
        if (r6 == null) goto L9;
        String r7 = r6.getInflowRecommendType();
    L10:
        r0.a = String.valueOf(r7);
        r0.b = r5;
        if (r4 == null) goto L13;
        Integer r8 = Integer.valueOf(r4.isAutoExpand());
    L14:
        r0.c = r8;
        int r9 = ld3.a.a;
        int r10 = com.bytedance.android.ec.core.opt.ab.c.a;
        com.bytedance.android.shopping.feed.event.g.c(r0, r3, null);
        return;
    L13:
        r8 = null;
    L9:
        r7 = null;
        goto L10
    }

    public static void q(String r3, ProductFeedViewModel r4, String r5, Context r6) {
        jd3.p r0 = new jd3.p(r3);
        AnchorV3Param r7 = r4.m907getAnchorV3Param();
        if (r7 == null) goto L5;
        int r1 = com.bytedance.android.ec.core.anchorv3.a.a;
        r0.d = com.bytedance.android.ec.core.anchorv3.a.a(r7.getRequestParam().getSourcePage());
    L5:
        r0.e = r4.getPageType();
        r0.a = String.valueOf(r4.getDurationFromResume());
        r0.f = r5;
        JSONObject r8 = new JSONObject();
        PageFinder r9 = PageFinder.via(r4.getFlowFragment());
        Iterator r10 = BtmSDK.INSTANCE.createReportParams("a1.b7365.c0.d0", r9).entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry r11 = (Map.Entry) r10.next();
        r8.put((String) r11.getKey(), r11.getValue());
        goto L7
    L9:
        r0.appendParam(com.bytedance.android.ec.core.utils.z1.j(r8));
        com.bytedance.android.shopping.feed.event.g.c(r0, r6, null);
    }

    public static void C(String r2, ProductFeedViewModel r3, String r4, Integer r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "vm");
        m1 r0 = new m1(r2);
        AnchorV3Param r7 = r3.m907getAnchorV3Param();
        if (r7 == null) goto L5;
        String r8 = r7.getAuthorId();
    L6:
        r0.a = r8;
        AnchorV3Param r9 = r3.m907getAnchorV3Param();
        if (r9 == null) goto L9;
        String r10 = r9.getProductId();
    L10:
        r0.b = r10;
        AnchorV3Param r11 = r3.m907getAnchorV3Param();
        if (r11 == null) goto L13;
        String r12 = r11.getCurrentPromotionId();
    L14:
        r0.c = r12;
        AnchorV3Param r13 = r3.m907getAnchorV3Param();
        if (r13 == null) goto L19;
        AnchorV3PromotionRequestParam r14 = r13.getRequestParam();
        if (r14 == null) goto L19;
        String r15 = r14.getEnterFrom();
    L20:
        r0.d = r15;
        AnchorV3Param r16 = r3.m907getAnchorV3Param();
        if (r16 == null) goto L25;
        AnchorV3PromotionRequestParam r17 = r16.getRequestParam();
        if (r17 == null) goto L25;
        String r18 = r17.getItemId();
    L26:
        r0.e = r18;
        r0.f = r4;
        r0.g = r5;
        r0.h = r6;
        r0.post(null, null);
        return;
    L25:
        r18 = null;
    L19:
        r15 = null;
        goto L20
    L13:
        r12 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public static void K(Context r8, String r9, int r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "text");
        Single.fromCallable(new m(4, r8, r11, r9, r10, r12)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void L(Context r8, String r9, int r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "text");
        Single.fromCallable(new n(4, r8, r11, r9, r10, r12)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void N(FeedProductEventTracker r4, Context r5, String r6, String r7, int r8) {
        if ((r8 & 2) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r8 & 4) == 0) goto L10;
        r6 = "";
    L10:
        if ((r8 & 8) == 0) goto L12;
        r7 = "full_screen";
    L12:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        v1 r9 = new v1();
        r9.a = r0;
        if (r6 != null) goto L15;
    L17:
        r9.appendParam("inflow_cart_type", r7);
        com.bytedance.android.shopping.feed.event.g.c(r9, r5, null);
        return;
    L15:
        if (com.bytedance.android.ec.core.utils.a2.d(r6) == null) goto L17;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r9.appendParam("btm_id", r6, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L17
    L5:
        r0 = null;
        goto L7
    }

    public static void P(Context r11, rd3.a r12, Promotion r13, String r14, Map r15) {
        d2 r0 = new d2();
        String r1 = null;
        if (r13 == null) goto L11;
        PromotionProductStruct r2 = r13.getPromotionInfo();
        if (r2 == null) goto L11;
        PromotionProductExtraStruct r3 = r2.getExtraInfo();
        if (r3 == null) goto L11;
        String r4 = r3.getLogExtra();
        if (r4 == null) goto L11;
        JSONObject r5 = com.bytedance.android.ec.core.utils.z1.g(r4);
    L12:
        if (r5 == null) goto L21;
        String r6 = r5.optString("new_gift_type");
        if (r6 == null) goto L21;
        if (cg4.a.a(r6) == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L21;
        r0.y = r6;
    L21:
        if (r12 == null) goto L23;
        String r7 = r12.c();
    L24:
        r0.g = r7;
        if (r12 == null) goto L33;
        Promotion r8 = r12.f();
        if (r8 == null) goto L33;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L33;
        PromotionProductExtraStruct r10 = r9.getExtraInfo();
        if (r10 == null) goto L33;
        String r16 = r10.getEntranceInfo();
    L34:
        s0.a(r0, r16);
        if (r13 == null) goto L37;
        String r17 = r13.getRecommendInfo();
    L38:
        r0.q = r17;
        if (r12 == null) goto L43;
        yd3.p r18 = r12.i();
        if (r18 == null) goto L43;
        Integer r19 = Integer.valueOf(r18.getType());
    L45:
        if (r19 != null) goto L48;
    L50:
        if (r19 != null) goto L53;
    L55:
        if (r19 != null) goto L58;
    L60:
        String r20 = "product_flow_page";
    L61:
        r0.s = r20;
        if (r12 == null) goto L70;
        ProductFeedViewModel r21 = r12.c;
        if (r21 == null) goto L70;
        AnchorV3Param r22 = r21.m907getAnchorV3Param();
        if (r22 == null) goto L70;
        AnchorV3PromotionRequestParam r23 = r22.getRequestParam();
        if (r23 == null) goto L70;
        String r24 = r23.getEnterFrom();
    L71:
        r0.r = r24;
        r0.t = "guess_you_like_product";
        if (r13 == null) goto L78;
        PromotionProductStruct r25 = r13.getPromotionInfo();
        if (r25 == null) goto L78;
        PromotionProductBaseStruct r26 = r25.getBaseInfo();
        if (r26 == null) goto L78;
        String r27 = r26.getProductId();
    L79:
        r0.A = r27;
        if (r12 == null) goto L85;
        yd3.p r28 = r12.i();
        if (r28 == null) goto L85;
        if (r28.getType() != 7) goto L85;
    L95:
        r0.w = "product";
    L96:
        r0.z = r14;
        if (r12 == null) goto L105;
        Promotion r110 = r12.f();
        if (r110 == null) goto L105;
        PromotionProductStruct r111 = r110.getPromotionInfo();
        if (r111 == null) goto L105;
        PromotionProductExtraStruct r112 = r111.getExtraInfo();
        if (r112 == null) goto L105;
        Boolean r113 = r112.getNeedCheck();
    L107:
        if (Intrinsics.areEqual(r113, Boolean.FALSE) == false) goto L109;
        String r114 = "0";
    L110:
        r0.x = r114;
        if (r12 == null) goto L117;
        ProductFeedViewModel r115 = r12.c;
        if (r115 == null) goto L117;
        AnchorV3Param r116 = r115.m907getAnchorV3Param();
        if (r116 == null) goto L117;
        String r117 = r116.getEntranceInfo();
    L118:
        r0.appendParam(s0.b(r117));
        if (r13 == null) goto L127;
        PromotionProductStruct r118 = r13.getPromotionInfo();
        if (r118 == null) goto L127;
        PromotionProductPrivilegesStruct r119 = r118.getPrivilegeInfo();
        if (r119 == null) goto L127;
        List r120 = r119.getTagCodeList();
        if (r120 == null) goto L127;
        r1 = CollectionsKt.joinToString$default(r120, ",", null, null, 0, null, null, 62, null);
    L127:
        r0.appendParam("tag_code_list", r1);
        if (r15 == null) goto L130;
        r0.appendParam(r15);
    L130:
        com.bytedance.android.shopping.feed.event.g.c(r0, r11, CollectionsKt.listOf(new String[]{PdpOpenThirdParam.KEY_PAGE_NAME, PdpOpenThirdParam.KEY_PRODUCT_ID}));
        return;
    L117:
        r117 = null;
        goto L118
    L109:
        r114 = "1";
    L105:
        r113 = null;
    L85:
        if (r12 == null) goto L90;
        yd3.p r29 = r12.i();
        if (r29 == null) goto L90;
        if (r29.getType() == 9) goto L95;
    L90:
        if (r12 == null) goto L96;
        yd3.p r30 = r12.i();
        if (r30 == null) goto L96;
        if (r30.getType() != 12) goto L96;
    L78:
        r27 = null;
    L70:
        r24 = null;
        goto L71
    L58:
        if (r19.intValue() != 9) goto L60;
    L59:
        r20 = "product_flow_page_inflow_card";
        goto L61
    L53:
        if (r19.intValue() != 7) goto L55;
    L48:
        if (r19.intValue() != 6) goto L50;
        r20 = "product_flow_page_new_channel";
    L43:
        r19 = null;
        goto L45
    L37:
        r17 = null;
    L33:
        r16 = null;
        goto L34
    L23:
        r7 = null;
    L11:
        r5 = null;
        goto L12
    }

    public static void S(rd3.a r9, Context r10, String r11, String r12, String r13) {
        if (r9 == null) goto L22;
        ProductFeedViewModel r3 = r9.c;
        if (r3 == null) goto L23;
        Promotion r0 = r9.f();
        if (r0 == null) goto L9;
        PromotionProductStruct r1 = r0.getPromotionInfo();
    L10:
        PromotionProductStruct r4 = r1;
        if (cg4.a.a(r13) == true) goto L20;
        if (r4 == null) goto L19;
        PromotionProductAuthorEntriesStruct r14 = r4.getEntryInfo();
        if (r14 == null) goto L19;
        if (r14.getShopEntry() == null) goto L19;
        r13 = "window";
    L19:
        r13 = "shop";
    L20:
        Single.fromCallable(new q(2, r10, r3, r4, r13, r9, r12, r11)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L9:
        r1 = null;
        goto L10
    L23:
        return;
    }

    public static d2 e(PromotionProductStruct r17, rd3.a r18, String r19, boolean r20, Map r21) {
        Intrinsics.checkNotNullParameter(r17, "promotion");
        Intrinsics.checkNotNullParameter(r18, "anchorInflowFeedItem");
        d2 r3 = new d2();
        PromotionProductPriceStruct r5 = r17.getProductPrice();
        String r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.getPriceTrackingInfo();
    L6:
        r3.F = r7;
        PromotionProductExtraStruct r8 = r17.getExtraInfo();
        if (r8 == null) goto L11;
        String r9 = r8.getLogExtra();
        if (r9 == null) goto L11;
        JSONObject r10 = com.bytedance.android.ec.core.utils.z1.g(r9);
    L12:
        if (r10 == null) goto L21;
        String r11 = r10.optString("user_type");
        if (r11 == null) goto L21;
        if (cg4.a.a(r11) == true) goto L19;
        r11 = null;
    L19:
        if (r11 == null) goto L21;
        r3.u = r11;
    L21:
        if (r10 == null) goto L30;
        String r12 = r10.optString("coupon_name");
        if (r12 == null) goto L30;
        if (cg4.a.a(r12) == true) goto L28;
        r12 = null;
    L28:
        if (r12 == null) goto L30;
        r3.v = r12;
    L30:
        if (r10 == null) goto L40;
        String r13 = r10.optString("new_gift_type");
        if (r13 == null) goto L40;
        if (cg4.a.a(r13) == true) goto L37;
        r13 = null;
    L37:
        if (r13 == null) goto L40;
        r3.y = r13;
    L40:
        if (ECSettingKeys.g0() == false) goto L59;
        if (r10 == null) goto L50;
        String r14 = r10.optString("standard_track_param");
        if (r14 == null) goto L50;
        if (cg4.a.a(r14) == true) goto L48;
        r14 = null;
    L48:
        if (r14 == null) goto L50;
        r3.G = r14;
    L50:
        if (r10 == null) goto L59;
        String r15 = r10.optString("standard_product_marketing_param");
        if (r15 == null) goto L59;
        if (cg4.a.a(r15) == true) goto L57;
        r15 = null;
    L57:
        if (r15 == null) goto L59;
        r3.H = r15;
    L59:
        String r16 = String.valueOf(r18.f);
        String r22 = "";
        if (r16 != null) goto L62;
        r16 = "";
    L62:
        r3.f = r16;
        PromotionProductPrivilegesStruct r23 = r17.getPrivilegeInfo();
        if (r23 == null) goto L69;
        PromotionProductActivitiesStruct r24 = r23.getActivities();
        if (r24 == null) goto L69;
        PromotionDepositPresaleActivity r25 = r24.getDepositPresaleActivity();
        if (r25 == null) goto L69;
        r3.b = com.bytedance.android.ec.model.n.a(r25);
    L69:
        r3.a = tf3.n.a(r17);
        r3.c = f53.a.c(r17).getActivityName();
        PromotionProductPrivilegesStruct r26 = r17.getPrivilegeInfo();
        if (r26 == null) goto L74;
        List r27 = r26.getServices();
        if (r27 == null) goto L74;
        String r28 = CollectionsKt.joinToString$default(r27, ",", null, null, 0, null, FeedProductEventTracker$createMainProductShowEvent$1$12.INSTANCE, 30, null);
    L75:
        r3.d = r28;
        PromotionProductExtraStruct r29 = r17.getExtraInfo();
        if (r29 == null) goto L78;
        Boolean r30 = r29.getNeedCheck();
    L79:
        String r31 = "0";
        if (Intrinsics.areEqual(r30, Boolean.FALSE) == false) goto L82;
        String r32 = "0";
    L83:
        r3.x = r32;
        int r33 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r3.e = com.bytedance.android.shopping.anchorv3.utils.y.i(r17);
        r3.g = r18.c();
        ProductFeedViewModel r34 = r18.c;
        if (r34 == null) goto L90;
        AnchorV3Param r35 = r34.m907getAnchorV3Param();
        if (r35 == null) goto L90;
        ECLogExtraData r36 = r35.getLogExtraData();
        if (r36 == null) goto L90;
        String r37 = r36.getInflowRecommendType();
    L91:
        r3.j = String.valueOf(r37);
        Promotion r38 = r18.f();
        if (r38 == null) goto L98;
        PromotionProductStruct r39 = r38.getPromotionInfo();
        if (r39 == null) goto L98;
        PromotionProductExtraStruct r40 = r39.getExtraInfo();
        if (r40 == null) goto L98;
        PromotionVideoInfo r41 = r40.getProductVideo();
    L99:
        if (r41 == null) goto L101;
        r31 = "1";
    L101:
        r3.h = r31;
        PromotionProductBaseStruct r42 = r17.getBaseInfo();
        if (r42 == null) goto L106;
        SalesInfoStruct r43 = r42.getSalesInfo();
        if (r43 == null) goto L106;
        Integer r44 = r43.getType();
    L107:
        if (r44 != null) goto L110;
    L112:
        if (r44 != null) goto L115;
    L117:
        r3.i = r22;
        r3.w = "video";
        ProductFeedViewModel r45 = r18.c;
        if (r45 == null) goto L124;
        AnchorV3Param r46 = r45.m907getAnchorV3Param();
        if (r46 == null) goto L124;
        AnchorV3PromotionRequestParam r47 = r46.getRequestParam();
        if (r47 == null) goto L124;
        String r48 = r47.getSourcePage();
    L125:
        r3.k = r48;
        PromotionProductExtraStruct r49 = r17.getExtraInfo();
        if (r49 == null) goto L128;
        String r50 = r49.getEntranceInfo();
    L129:
        s0.a(r3, r50);
        r3.l = r18.m;
        int r51 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r52 = r18.f();
        if (r52 == null) goto L134;
        PromotionProductStruct r53 = r52.getPromotionInfo();
        if (r53 == null) goto L134;
        PromotionProductPriceStruct r54 = r53.getProductPrice();
    L135:
        r3.m = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r54));
        Promotion r55 = r18.f();
        if (r55 == null) goto L140;
        PromotionProductStruct r56 = r55.getPromotionInfo();
        if (r56 == null) goto L140;
        PromotionProductPriceStruct r57 = r56.getProductPrice();
    L141:
        r3.n = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r57));
        Promotion r58 = r18.f();
        if (r58 == null) goto L146;
        PromotionProductStruct r59 = r58.getPromotionInfo();
        if (r59 == null) goto L146;
        PromotionProductPriceStruct r60 = r59.getProductPrice();
    L147:
        r3.o = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r60));
        Promotion r61 = r18.f();
        if (r61 == null) goto L152;
        PromotionProductStruct r62 = r61.getPromotionInfo();
        if (r62 == null) goto L152;
        PromotionProductPriceStruct r63 = r62.getProductPrice();
    L153:
        r3.p = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r63));
        if (r19 != null) goto L156;
    L158:
        if (r20 == false) goto L160;
        com.bytedance.android.bst.api.f.f("video_product_list");
        r3.appendParam("bst_tag", null);
    L160:
        InnerFlowAdRawData r1 = r18.a;
        if (r1 == null) goto L167;
        InnerFlowAdData r2 = r1.getAdData();
        if (r2 == null) goto L167;
        Long r4 = r2.getCreativeId();
        if (r4 == null) goto L167;
        r3.B = String.valueOf(r4.longValue());
    L167:
        ProductFeedViewModel r64 = r18.c;
        if (r64 == null) goto L172;
        AnchorV3Param r65 = r64.m907getAnchorV3Param();
        if (r65 == null) goto L172;
        String r66 = r65.getEntranceInfo();
    L173:
        r3.appendParam(s0.b(r66));
        Promotion r67 = r18.f();
        if (r67 == null) goto L178;
        PromotionProductStruct r68 = r67.getPromotionInfo();
        if (r68 == null) goto L178;
        String r69 = com.bytedance.android.shopping.feed.utils.e0.b(r68);
    L179:
        r3.C = r69;
        Promotion r70 = r18.f();
        if (r70 == null) goto L184;
        PromotionProductStruct r71 = r70.getPromotionInfo();
        if (r71 == null) goto L184;
        String r72 = com.bytedance.android.shopping.feed.utils.e0.a(r71);
    L185:
        r3.D = r72;
        Promotion r73 = r18.f();
        if (r73 == null) goto L190;
        PromotionProductStruct r74 = r73.getPromotionInfo();
        if (r74 == null) goto L190;
        String r75 = r74.getActivityLabel();
    L191:
        r3.E = r75;
        r3.appendParam(r18.k);
        PromotionProductPrivilegesStruct r0 = r17.getPrivilegeInfo();
        if (r0 == null) goto L196;
        List r76 = r0.getTagCodeList();
        if (r76 == null) goto L196;
        r6 = CollectionsKt.joinToString$default(r76, ",", null, null, 0, null, null, 62, null);
    L196:
        r3.appendParam("tag_code_list", r6);
        if (r21 == null) goto L199;
        r3.appendParam(r21);
    L199:
        return r3;
    L190:
        r75 = null;
    L184:
        r72 = null;
    L178:
        r69 = null;
    L172:
        r66 = null;
        goto L173
    L156:
        if (com.bytedance.android.ec.core.utils.a2.d(r19) == null) goto L158;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r3.appendParam("btm_id", r19, com.bytedance.android.ec.core.event.a.b.a.a);
    L152:
        r63 = null;
    L146:
        r60 = null;
    L140:
        r57 = null;
    L134:
        r54 = null;
        goto L135
    L128:
        r50 = null;
    L124:
        r48 = null;
        goto L125
    L115:
        if (r44.intValue() != 1) goto L117;
        r22 = "repeat";
        goto L117
    L110:
        if (r44.intValue() != 0) goto L112;
        r22 = "sales";
    L106:
        r44 = null;
    L98:
        r41 = null;
    L90:
        r37 = null;
        goto L91
    L82:
        r32 = "1";
        goto L83
    L78:
        r30 = null;
    L74:
        r28 = null;
    L11:
        r10 = null;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public static void k(FeedProductEventTracker r4, Context r5, String r6, String r7, int r8) {
        if ((r8 & 2) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r8 & 4) == 0) goto L10;
        r6 = "";
    L10:
        if ((r8 & 8) == 0) goto L12;
        r7 = "full_screen";
    L12:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        com.bytedance.android.shopping.feed.event.r r9 = new com.bytedance.android.shopping.feed.event.r();
        r9.a = r0;
        if (r6 != null) goto L15;
    L17:
        r9.appendParam("inflow_cart_type", r7);
        com.bytedance.android.shopping.feed.event.g.c(r9, r5, null);
        return;
    L15:
        if (com.bytedance.android.ec.core.utils.a2.d(r6) == null) goto L17;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r9.appendParam("btm_id", r6, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L17
    L5:
        r0 = null;
        goto L7
    }

    public static u0 c(rd3.a r25, String r26, String r27, boolean r28, Map r29, Map r30) {
        Intrinsics.checkNotNullParameter(r25, "itemAnchor");
        ProductFeedViewModel r4 = r25.c;
        if (r4 != null) goto L5;
        return null;
    L5:
        AnchorV3Param r6 = r4.m907getAnchorV3Param();
        u0 r7 = new u0(r25.c());
        r7.g2 = Integer.valueOf(r4.isAutoExpand());
        Promotion r8 = r25.f();
        if (r8 == null) goto L8;
        PromotionProductStruct r9 = r8.getPromotionInfo();
    L9:
        a.getClass();
        a(r7, r9);
        if (r9 == null) goto L14;
        PromotionProductPriceStruct r10 = r9.getProductPrice();
        if (r10 == null) goto L14;
        String r11 = r10.getPriceTrackingInfo();
    L15:
        r7.h1 = r11;
        Gson r12 = new Gson();
        if (r6 == null) goto L18;
        String r13 = r6.getEntranceInfo();
    L19:
        JsonObject r14 = (JsonObject) GsonProtectorUtils.fromJson(r12, r13, JsonObject.class);
        if (r14 == null) goto L22;
        r14.addProperty("display_rank", String.valueOf(r25.f));
    L22:
        if (r14 == null) goto L24;
        r14.addProperty("inflow_product_card_mode", r25.m);
    L24:
        if (r14 == null) goto L27;
        r14.addProperty("ecom_type", r25.c());
    L27:
        if (r14 == null) goto L30;
        r14.remove("ecom_group_type");
    L30:
        if (r14 == null) goto L33;
        r14.addProperty("ecom_group_type", "product_card");
    L33:
        if (r14 == null) goto L35;
        r14.addProperty("module_label", "guess_you_like_product");
    L35:
        if (r29 == null) goto L42;
        Iterator r15 = r29.entrySet().iterator();
    L38:
        if (r15.hasNext() == false) goto L42;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (r14 == null) goto L38;
        r14.addProperty((String) r16.getKey(), (String) r16.getValue());
    L42:
        if (r9 == null) goto L46;
        PromotionProductExtraStruct r17 = r9.getExtraInfo();
        if (r17 == null) goto L46;
        Boolean r18 = r17.getNeedCheck();
    L47:
        String r19 = "0";
        if (Intrinsics.areEqual(r18, Boolean.FALSE) == false) goto L50;
        String r110 = "0";
    L51:
        r7.E = r110;
        if (r9 == null) goto L58;
        PromotionProductExtraStruct r111 = r9.getExtraInfo();
        if (r111 == null) goto L58;
        String r112 = r111.getLogExtra();
        if (r112 == null) goto L58;
        JSONObject r113 = com.bytedance.android.ec.core.utils.z1.g(r112);
    L59:
        if (r113 == null) goto L68;
        String r114 = r113.optString("new_gift_type");
        if (r114 == null) goto L68;
        if (cg4.a.a(r114) == true) goto L66;
        r114 = null;
    L66:
        if (r114 == null) goto L68;
        r7.S1 = r114;
    L68:
        if (r14 == null) goto L70;
        String r115 = r14.toString();
    L71:
        r7.o = r115;
        if (r9 != null) goto L74;
    L76:
        String r116 = "0";
    L77:
        r7.g = r116;
        rd3.g r117 = r25.d();
        if (r117 == null) goto L80;
        Boolean r118 = r117.b();
    L82:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L84;
        int r5 = 1;
    L85:
        r7.k = r5;
        if (r9 == null) goto L90;
        PromotionProductBaseStruct r20 = r9.getBaseInfo();
        if (r20 == null) goto L90;
        String r21 = r20.getPromotionId();
    L91:
        r7.c = r21;
        if (r9 == null) goto L96;
        PromotionProductBaseStruct r22 = r9.getBaseInfo();
        if (r22 == null) goto L96;
        Integer r23 = r22.getPromotionSource();
    L97:
        r7.d = String.valueOf(r23);
        if (r9 == null) goto L102;
        PromotionProductBaseStruct r24 = r9.getBaseInfo();
        if (r24 == null) goto L102;
        String r31 = r24.getProductId();
    L103:
        r7.t = r31;
        if (r6 == null) goto L106;
        String r32 = r6.getSourceMethod();
    L107:
        r7.p = r32;
        if (r6 == null) goto L114;
        String r33 = r6.getEntranceInfo();
        if (r33 == null) goto L114;
        JSONObject r34 = com.bytedance.android.ec.core.utils.z1.g(r33);
        if (r34 == null) goto L114;
        String r35 = r34.optString("carrier_source");
    L115:
        r7.q = r35;
        r7.v = "guess_you_like_product";
        if (r6 == null) goto L120;
        AnchorV3PromotionRequestParam r36 = r6.getRequestParam();
        if (r36 == null) goto L120;
        String r37 = r36.getAuthorId();
    L121:
        r7.b = r37;
        if (r6 == null) goto L126;
        AnchorV3PromotionRequestParam r38 = r6.getRequestParam();
        if (r38 == null) goto L126;
        String r39 = r38.getItemId();
    L127:
        r7.a = r39;
        String r40 = String.valueOf(r25.f);
        if (r40 != null) goto L130;
        r40 = "";
    L130:
        r7.w = r40;
        if (r9 == null) goto L139;
        PromotionProductPrivilegesStruct r41 = r9.getPrivilegeInfo();
        if (r41 == null) goto L139;
        PromotionProductCouponsStruct r42 = r41.getCoupons();
        if (r42 == null) goto L139;
        List r43 = r42.getDiscountLabels();
        if (r43 == null) goto L139;
        PromotionDiscountLabel r44 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r43);
    L140:
        r7.y = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r44));
        if (r9 == null) goto L151;
        PromotionProductPrivilegesStruct r45 = r9.getPrivilegeInfo();
        if (r45 == null) goto L151;
        PromotionProductCouponsStruct r46 = r45.getCoupons();
        if (r46 == null) goto L151;
        List r47 = r46.getDiscountLabels();
        if (r47 == null) goto L151;
        PromotionDiscountLabel r48 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r47);
        if (r48 == null) goto L151;
        String r49 = r48.getId();
    L152:
        r7.x = r49;
        if (r9 == null) goto L155;
        PromotionProductPriceStruct r50 = r9.getProductPrice();
    L156:
        if (r50 == null) goto L158;
        String r51 = "1";
    L159:
        r7.B = r51;
        rd3.g r52 = r25.d();
        if (r52 == null) goto L162;
        String r53 = r52.a();
    L163:
        r7.F = r53;
        if (r6 == null) goto L170;
        ECAdLogExtra r54 = r6.getAdLogExtra();
        if (r54 == null) goto L170;
        String r55 = r54.getCreativeId();
        if (r55 == null) goto L170;
    L171:
        r7.G = r55;
        InnerFlowAdRawData r56 = r25.a;
        if (r56 == null) goto L183;
        InnerFlowAdData r57 = r56.getAdData();
        if (r57 == null) goto L183;
        Long r58 = r57.getCreativeId();
        if (r58 == null) goto L183;
        long r119 = r58.longValue();
        if (r14 == null) goto L180;
        r14.remove("cid");
    L180:
        if (r14 == null) goto L182;
        r14.addProperty("cid", String.valueOf(r119));
    L182:
        r7.G = String.valueOf(r119);
    L183:
        r7.S = r25.d;
        r7.T = "guess_you_like_product";
        r7.v = "guess_you_like_product";
        r7.r = "product_flow_page";
        r7.U = r26;
        if (r9 == null) goto L186;
        r7.W = CommerceButtonUtil.a(r9).getType();
    L186:
        if (r6 == null) goto L188;
        String r59 = r6.getVideoId();
    L189:
        r7.Y = r59;
        if (r9 == null) goto L192;
        String r60 = tf3.n.a(r9);
    L193:
        r7.p0 = r60;
        if (r9 == null) goto L200;
        PromotionProductPrivilegesStruct r61 = r9.getPrivilegeInfo();
        if (r61 == null) goto L200;
        List r62 = r61.getServices();
        if (r62 == null) goto L200;
        String r63 = CollectionsKt.joinToString$default(r62, ",", null, null, 0, null, FeedProductEventTracker$createGuessULikeClickProductEvent$1$6.INSTANCE, 30, null);
    L201:
        r7.k0 = r63;
        if (r6 == null) goto L208;
        String r64 = r6.getEntranceInfo();
        if (r64 == null) goto L208;
        JSONObject r65 = com.bytedance.android.ec.core.utils.z1.g(r64);
        if (r65 == null) goto L208;
        r7.P0 = r65.optString("product_source_page", "");
    L208:
        r7.M = "product_flow_page";
        r7.u = r4.getPageType();
        r7.V0 = "product_card";
        Promotion r66 = r25.f();
        if (r66 == null) goto L215;
        PromotionProductStruct r67 = r66.getPromotionInfo();
        if (r67 == null) goto L215;
        PromotionProductExtraStruct r68 = r67.getExtraInfo();
        if (r68 == null) goto L215;
        PromotionVideoInfo r69 = r68.getProductVideo();
    L216:
        if (r69 == null) goto L218;
        r19 = "1";
    L218:
        r7.v1 = r19;
        if (r6 == null) goto L223;
        ECLogExtraData r70 = r6.getLogExtraData();
        if (r70 == null) goto L223;
        String r71 = r70.getInflowRecommendType();
    L224:
        r7.x1 = r71;
        r7.y1 = r25.m;
        int r72 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r73 = r25.f();
        if (r73 == null) goto L229;
        PromotionProductStruct r74 = r73.getPromotionInfo();
        if (r74 == null) goto L229;
        PromotionProductPriceStruct r75 = r74.getProductPrice();
    L230:
        r7.G1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r75));
        Promotion r76 = r25.f();
        if (r76 == null) goto L235;
        PromotionProductStruct r77 = r76.getPromotionInfo();
        if (r77 == null) goto L235;
        PromotionProductPriceStruct r78 = r77.getProductPrice();
    L236:
        r7.H1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r78));
        Promotion r79 = r25.f();
        if (r79 == null) goto L241;
        PromotionProductStruct r80 = r79.getPromotionInfo();
        if (r80 == null) goto L241;
        PromotionProductPriceStruct r81 = r80.getProductPrice();
    L242:
        r7.L1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r81));
        Promotion r82 = r25.f();
        if (r82 == null) goto L247;
        PromotionProductStruct r84 = r82.getPromotionInfo();
        if (r84 == null) goto L247;
        PromotionProductPriceStruct r85 = r84.getProductPrice();
    L248:
        r7.M1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r85));
        r7.b1 = "product";
        if (r9 == null) goto L251;
        String r86 = com.bytedance.android.shopping.feed.utils.e0.b(r9);
    L252:
        r7.T1 = r86;
        if (r9 == null) goto L255;
        String r87 = com.bytedance.android.shopping.feed.utils.e0.a(r9);
    L256:
        r7.V1 = r87;
        if (r9 == null) goto L259;
        String r88 = r9.getActivityLabel();
    L260:
        r7.b2 = r88;
        if (r27 != null) goto L263;
    L265:
        if (r28 == false) goto L267;
        com.bytedance.android.bst.api.f.f("video_product_list");
        String r89 = null;
        r7.appendParam("bst_tag", null);
    L268:
        if (r9 == null) goto L272;
        PromotionProductExtraStruct r1 = r9.getExtraInfo();
        if (r1 == null) goto L272;
        String r2 = r1.getEntranceInfo();
    L273:
        s0.a(r7, r2);
        ProductFeedViewModel r0 = r25.c;
        if (r0 == null) goto L278;
        AnchorV3Param r3 = r0.m907getAnchorV3Param();
        if (r3 == null) goto L278;
        String r90 = r3.getEntranceInfo();
    L279:
        r7.appendParam(s0.b(r90));
        if (r29 == null) goto L282;
        r7.appendParam(r29);
    L282:
        if (r30 == null) goto L284;
        r7.appendParam(r30);
    L284:
        return r7;
    L278:
        r90 = r89;
    L272:
        r2 = r89;
        goto L273
    L267:
        r89 = null;
        goto L268
    L263:
        if (com.bytedance.android.ec.core.utils.a2.d(r27) == null) goto L265;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r7.appendParam("btm_id", r27, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L265
    L259:
        r88 = null;
        goto L260
    L255:
        r87 = null;
        goto L256
    L251:
        r86 = null;
    L247:
        r85 = null;
    L241:
        r81 = null;
    L235:
        r78 = null;
    L229:
        r75 = null;
    L223:
        r71 = null;
    L215:
        r69 = null;
    L200:
        r63 = null;
        goto L201
    L192:
        r60 = null;
        goto L193
    L188:
        r59 = null;
    L170:
        r55 = null;
        goto L171
    L162:
        r53 = null;
        goto L163
    L158:
        r51 = "0";
        goto L159
    L155:
        r50 = null;
    L151:
        r49 = null;
    L139:
        r44 = null;
    L126:
        r39 = null;
    L120:
        r37 = null;
    L114:
        r35 = null;
        goto L115
    L106:
        r32 = null;
    L102:
        r31 = null;
    L96:
        r23 = null;
    L90:
        r21 = null;
        goto L91
    L84:
        r5 = 0;
        goto L85
    L80:
        r118 = null;
        goto L82
    L74:
        if (r9.hasCoupon() != true) goto L76;
        r116 = "1";
        goto L77
    L70:
        r115 = null;
    L58:
        r113 = null;
        goto L59
    L50:
        r110 = "1";
    L46:
        r18 = null;
        goto L47
    L18:
        r13 = null;
    L14:
        r11 = null;
        goto L15
    L8:
        r9 = null;
        goto L9
    }

    public static jd3.u d(AnchorV3Param r19, rd3.a r20, PromotionProductStruct r21, String r22, boolean r23, Map r24) {
        Intrinsics.checkNotNullParameter(r20, "anchorInflowFeedItem");
        jd3.u r3 = new jd3.u();
        String r4 = null;
        if (r21 == null) goto L7;
        PromotionProductPriceStruct r5 = r21.getProductPrice();
        if (r5 == null) goto L7;
        String r6 = r5.getPriceTrackingInfo();
    L8:
        r3.R = r6;
        Gson r7 = new Gson();
        if (r19 == null) goto L11;
        String r8 = r19.getEntranceInfo();
    L12:
        JsonObject r9 = (JsonObject) GsonProtectorUtils.fromJson(r7, r8, JsonObject.class);
        if (r9 == null) goto L15;
        r9.addProperty("ecom_group_type", "product_card");
    L15:
        if (r9 == null) goto L17;
        r9.addProperty("display_rank", String.valueOf(r20.f));
    L17:
        if (r21 == null) goto L23;
        PromotionProductExtraStruct r10 = r21.getExtraInfo();
        if (r10 == null) goto L23;
        String r11 = r10.getLogExtra();
        if (r11 == null) goto L23;
        JSONObject r12 = com.bytedance.android.ec.core.utils.z1.g(r11);
    L24:
        if (r12 == null) goto L34;
        String r13 = r12.optString("new_gift_type");
        if (r13 == null) goto L34;
        if (cg4.a.a(r13) == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L34;
        r3.K = r13;
    L34:
        if (ECSettingKeys.g0() == false) goto L53;
        if (r12 == null) goto L44;
        String r14 = r12.optString("standard_track_param");
        if (r14 == null) goto L44;
        if (cg4.a.a(r14) == true) goto L42;
        r14 = null;
    L42:
        if (r14 == null) goto L44;
        r3.S = r14;
    L44:
        if (r12 == null) goto L53;
        String r15 = r12.optString("standard_product_marketing_param");
        if (r15 == null) goto L53;
        if (cg4.a.a(r15) == true) goto L51;
        r15 = null;
    L51:
        if (r15 == null) goto L53;
        r3.T = r15;
    L53:
        if (r9 == null) goto L55;
        String r16 = r9.toString();
    L56:
        r3.j = r16;
        if (r21 == null) goto L63;
        PromotionProductPrivilegesStruct r17 = r21.getPrivilegeInfo();
        if (r17 == null) goto L63;
        PromotionProductCouponsStruct r18 = r17.getCoupons();
        if (r18 == null) goto L63;
        List r25 = r18.getDiscountLabels();
    L64:
        List r26 = r25;
        if (r26 != null) goto L67;
    L70:
        boolean r27 = true;
    L71:
        String r28 = "1";
        if (r27 == true) goto L74;
        String r29 = "1";
    L75:
        r3.e = r29;
        rd3.g r30 = r20.d();
        if (r30 == null) goto L78;
        Boolean r31 = r30.b();
    L80:
        if (Intrinsics.areEqual(r31, Boolean.TRUE) == false) goto L82;
        int r32 = 1;
    L83:
        r3.h = r32;
        if (r21 == null) goto L88;
        PromotionProductBaseStruct r33 = r21.getBaseInfo();
        if (r33 == null) goto L88;
        Integer r34 = r33.getPromotionSource();
    L89:
        r3.d = String.valueOf(r34);
        if (r21 == null) goto L94;
        PromotionProductBaseStruct r35 = r21.getBaseInfo();
        if (r35 == null) goto L94;
        String r36 = r35.getPromotionId();
    L95:
        r3.c = r36;
        if (r21 == null) goto L100;
        PromotionProductBaseStruct r37 = r21.getBaseInfo();
        if (r37 == null) goto L100;
        String r38 = r37.getProductId();
    L101:
        r3.l = r38;
        if (r19 == null) goto L104;
        String r39 = r19.getSourceMethod();
    L105:
        r3.n = r39;
        if (r19 == null) goto L112;
        String r40 = r19.getEntranceInfo();
        if (r40 == null) goto L112;
        JSONObject r41 = com.bytedance.android.ec.core.utils.z1.g(r40);
        if (r41 == null) goto L112;
        String r42 = r41.optString("carrier_source");
    L113:
        r3.m = r42;
        r3.o = "guess_you_like_product";
        if (r19 == null) goto L118;
        AnchorV3PromotionRequestParam r43 = r19.getRequestParam();
        if (r43 == null) goto L118;
        String r44 = r43.getAuthorId();
    L119:
        r3.b = r44;
        if (r19 == null) goto L124;
        AnchorV3PromotionRequestParam r45 = r19.getRequestParam();
        if (r45 == null) goto L124;
        String r46 = r45.getItemId();
    L125:
        r3.a = r46;
        r3.p = String.valueOf(r20.f);
        if (r21 == null) goto L134;
        PromotionProductPrivilegesStruct r47 = r21.getPrivilegeInfo();
        if (r47 == null) goto L134;
        PromotionProductCouponsStruct r48 = r47.getCoupons();
        if (r48 == null) goto L134;
        List r49 = r48.getDiscountLabels();
        if (r49 == null) goto L134;
        PromotionDiscountLabel r50 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r49);
    L135:
        r3.s = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r50));
        if (r21 == null) goto L146;
        PromotionProductPrivilegesStruct r51 = r21.getPrivilegeInfo();
        if (r51 == null) goto L146;
        PromotionProductCouponsStruct r52 = r51.getCoupons();
        if (r52 == null) goto L146;
        List r53 = r52.getDiscountLabels();
        if (r53 == null) goto L146;
        PromotionDiscountLabel r54 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r53);
        if (r54 == null) goto L146;
        String r55 = r54.getId();
    L147:
        r3.r = r55;
        int r56 = com.bytedance.android.ec.core.anchorv3.a.a;
        if (r19 == null) goto L152;
        AnchorV3PromotionRequestParam r57 = r19.getRequestParam();
        if (r57 == null) goto L152;
        String r58 = r57.getSourcePage();
    L153:
        r3.i = com.bytedance.android.ec.core.anchorv3.a.a(r58);
        rd3.g r59 = r20.d();
        if (r59 == null) goto L156;
        String r60 = r59.a();
    L157:
        r3.t = r60;
        r3.u = r20.d;
        r3.v = "guess_you_like_product";
        r3.o = "guess_you_like_product";
        r3.k = "product_flow_page";
        if (r21 == null) goto L162;
        PromotionProductExtraStruct r61 = r21.getExtraInfo();
        if (r61 == null) goto L162;
        Boolean r62 = r61.getNeedCheck();
    L164:
        if (Intrinsics.areEqual(r62, Boolean.FALSE) == false) goto L166;
        String r63 = "0";
    L167:
        r3.M = r63;
        r3.z = r20.c();
        if (r21 == null) goto L170;
        r3.w = CommerceButtonUtil.a(r21).getType();
    L170:
        if (r19 == null) goto L172;
        String r64 = r19.getVideoId();
    L173:
        r3.y = r64;
        if (r21 == null) goto L176;
        String r65 = tf3.n.a(r21);
    L177:
        r3.x = r65;
        if (r21 == null) goto L180;
        ActivityVO r66 = f53.a.c(r21);
    L181:
        if (r66 == null) goto L183;
        String r67 = r66.getActivityName();
    L184:
        r3.A = r67;
        if (r21 == null) goto L191;
        PromotionProductPrivilegesStruct r68 = r21.getPrivilegeInfo();
        if (r68 == null) goto L191;
        List r69 = r68.getServices();
        if (r69 == null) goto L191;
        String r70 = CollectionsKt.joinToString$default(r69, ",", null, null, 0, null, FeedProductEventTracker$createGuessULikeProductShowEvent$1$8.INSTANCE, 30, null);
    L192:
        r3.B = r70;
        r3.J = "product";
        Promotion r71 = r20.f();
        if (r71 == null) goto L199;
        PromotionProductStruct r72 = r71.getPromotionInfo();
        if (r72 == null) goto L199;
        PromotionProductExtraStruct r73 = r72.getExtraInfo();
        if (r73 == null) goto L199;
        PromotionVideoInfo r74 = r73.getProductVideo();
    L200:
        if (r74 != null) goto L203;
        r28 = "0";
    L203:
        r3.C = r28;
        if (r21 == null) goto L210;
        PromotionProductBaseStruct r75 = r21.getBaseInfo();
        if (r75 == null) goto L210;
        SalesInfoStruct r76 = r75.getSalesInfo();
        if (r76 == null) goto L210;
        Integer r77 = r76.getType();
    L211:
        if (r77 != null) goto L214;
    L216:
        if (r77 != null) goto L219;
    L221:
        String r78 = "";
    L222:
        r3.D = r78;
        if (r22 != null) goto L225;
    L227:
        if (r23 == false) goto L229;
        com.bytedance.android.bst.api.f.f("video_product_list");
        r3.appendParam("bst_tag", null);
    L229:
        r3.E = r20.m;
        int r1 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r2 = r20.f();
        if (r2 == null) goto L234;
        PromotionProductStruct r79 = r2.getPromotionInfo();
        if (r79 == null) goto L234;
        PromotionProductPriceStruct r80 = r79.getProductPrice();
    L235:
        r3.F = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r80));
        Promotion r81 = r20.f();
        if (r81 == null) goto L240;
        PromotionProductStruct r82 = r81.getPromotionInfo();
        if (r82 == null) goto L240;
        PromotionProductPriceStruct r84 = r82.getProductPrice();
    L241:
        r3.G = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r84));
        Promotion r85 = r20.f();
        if (r85 == null) goto L246;
        PromotionProductStruct r86 = r85.getPromotionInfo();
        if (r86 == null) goto L246;
        PromotionProductPriceStruct r87 = r86.getProductPrice();
    L247:
        r3.H = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r87));
        Promotion r88 = r20.f();
        if (r88 == null) goto L252;
        PromotionProductStruct r89 = r88.getPromotionInfo();
        if (r89 == null) goto L252;
        PromotionProductPriceStruct r90 = r89.getProductPrice();
    L253:
        r3.I = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r90));
        InnerFlowAdRawData r91 = r20.a;
        if (r91 == null) goto L260;
        InnerFlowAdData r92 = r91.getAdData();
        if (r92 == null) goto L260;
        Long r94 = r92.getCreativeId();
        if (r94 == null) goto L260;
        r3.N = String.valueOf(r94.longValue());
    L260:
        ProductFeedViewModel r95 = r20.c;
        if (r95 == null) goto L265;
        AnchorV3Param r96 = r95.m907getAnchorV3Param();
        if (r96 == null) goto L265;
        String r97 = r96.getEntranceInfo();
    L266:
        r3.appendParam(s0.b(r97));
        Promotion r98 = r20.f();
        if (r98 == null) goto L271;
        PromotionProductStruct r99 = r98.getPromotionInfo();
        if (r99 == null) goto L271;
        String r100 = com.bytedance.android.shopping.feed.utils.e0.b(r99);
    L272:
        r3.O = r100;
        Promotion r101 = r20.f();
        if (r101 == null) goto L277;
        PromotionProductStruct r102 = r101.getPromotionInfo();
        if (r102 == null) goto L277;
        String r103 = com.bytedance.android.shopping.feed.utils.e0.a(r102);
    L278:
        r3.P = r103;
        Promotion r104 = r20.f();
        if (r104 == null) goto L283;
        PromotionProductStruct r105 = r104.getPromotionInfo();
        if (r105 == null) goto L283;
        String r106 = r105.getActivityLabel();
    L284:
        r3.Q = r106;
        if (r21 == null) goto L289;
        PromotionProductExtraStruct r107 = r21.getExtraInfo();
        if (r107 == null) goto L289;
        String r108 = r107.getEntranceInfo();
    L290:
        s0.a(r3, r108);
        r3.appendParam(r20.k);
        if (r21 == null) goto L297;
        PromotionProductPrivilegesStruct r0 = r21.getPrivilegeInfo();
        if (r0 == null) goto L297;
        List r109 = r0.getTagCodeList();
        if (r109 == null) goto L297;
        r4 = CollectionsKt.joinToString$default(r109, ",", null, null, 0, null, null, 62, null);
    L297:
        r3.appendParam("tag_code_list", r4);
        if (r24 == null) goto L300;
        r3.appendParam(r24);
    L300:
        return r3;
    L289:
        r108 = null;
    L283:
        r106 = null;
    L277:
        r103 = null;
    L271:
        r100 = null;
    L265:
        r97 = null;
    L252:
        r90 = null;
    L246:
        r87 = null;
    L240:
        r84 = null;
    L234:
        r80 = null;
        goto L235
    L225:
        if (com.bytedance.android.ec.core.utils.a2.d(r22) == null) goto L227;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r3.appendParam("btm_id", r22, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L227
    L219:
        if (r77.intValue() != 1) goto L221;
        r78 = "repeat";
        goto L222
    L214:
        if (r77.intValue() != 0) goto L216;
        r78 = "sales";
    L210:
        r77 = null;
    L199:
        r74 = null;
    L191:
        r70 = null;
        goto L192
    L183:
        r67 = null;
        goto L184
    L180:
        r66 = null;
        goto L181
    L176:
        r65 = null;
        goto L177
    L172:
        r64 = null;
        goto L173
    L166:
        r63 = "1";
    L162:
        r62 = null;
        goto L164
    L156:
        r60 = null;
    L152:
        r58 = null;
    L146:
        r55 = null;
    L134:
        r50 = null;
    L124:
        r46 = null;
    L118:
        r44 = null;
    L112:
        r42 = null;
        goto L113
    L104:
        r39 = null;
    L100:
        r38 = null;
    L94:
        r36 = null;
    L88:
        r34 = null;
        goto L89
    L82:
        r32 = 0;
        goto L83
    L78:
        r31 = null;
        goto L80
    L74:
        r29 = "0";
        goto L75
    L67:
        if (r26.isEmpty() == true) goto L70;
        r27 = false;
    L63:
        r25 = null;
        goto L64
    L55:
        r16 = null;
    L23:
        r12 = null;
        goto L24
    L11:
        r8 = null;
    L7:
        r6 = null;
        goto L8
    }

    public static void j(Context r21, ProductFeedViewModel r22, rd3.a r23, Promotion r24, String r25, Map r26) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "itemAnchor");
        String r3 = null;
        if (r22 == null) goto L5;
        AnchorV3Param r4 = r22.m907getAnchorV3Param();
    L6:
        u0 r5 = new u0(r23.c());
        if (r22 == null) goto L9;
        Integer r6 = Integer.valueOf(r22.isAutoExpand());
    L10:
        r5.g2 = r6;
        if (r24 == null) goto L13;
        PromotionProductStruct r7 = r24.getPromotionInfo();
    L14:
        a.getClass();
        a(r5, r7);
        if (r7 == null) goto L19;
        PromotionProductPriceStruct r8 = r7.getProductPrice();
        if (r8 == null) goto L19;
        String r9 = r8.getPriceTrackingInfo();
    L20:
        r5.h1 = r9;
        Gson r10 = new Gson();
        if (r4 == null) goto L23;
        String r11 = r4.getEntranceInfo();
    L24:
        JsonObject r12 = (JsonObject) GsonProtectorUtils.fromJson(r10, r11, JsonObject.class);
        if (r12 == null) goto L27;
        r12.addProperty("display_rank", String.valueOf(r23.f));
    L27:
        if (r12 == null) goto L29;
        r12.addProperty("ecom_type", r23.c());
    L29:
        if (r7 == null) goto L35;
        PromotionProductExtraStruct r13 = r7.getExtraInfo();
        if (r13 == null) goto L35;
        String r14 = r13.getLogExtra();
        if (r14 == null) goto L35;
        JSONObject r15 = com.bytedance.android.ec.core.utils.z1.g(r14);
    L36:
        if (r15 == null) goto L45;
        String r16 = r15.optString("new_gift_type");
        if (r16 == null) goto L45;
        if (cg4.a.a(r16) == true) goto L43;
        r16 = null;
    L43:
        if (r16 == null) goto L45;
        r5.S1 = r16;
    L45:
        if (r12 == null) goto L47;
        String r17 = r12.toString();
    L48:
        r5.o = r17;
        String r18 = "1";
        if (r7 != null) goto L51;
    L53:
        String r19 = "0";
    L54:
        r5.g = r19;
        if (r7 == null) goto L59;
        PromotionProductBaseStruct r20 = r7.getBaseInfo();
        if (r20 == null) goto L59;
        String r27 = r20.getPromotionId();
    L60:
        r5.c = r27;
        if (r7 == null) goto L65;
        PromotionProductBaseStruct r28 = r7.getBaseInfo();
        if (r28 == null) goto L65;
        Integer r29 = r28.getPromotionSource();
    L66:
        r5.d = String.valueOf(r29);
        if (r7 == null) goto L71;
        PromotionProductBaseStruct r30 = r7.getBaseInfo();
        if (r30 == null) goto L71;
        String r31 = r30.getProductId();
    L72:
        r5.t = r31;
        if (r4 == null) goto L75;
        String r32 = r4.getSourceMethod();
    L76:
        r5.p = r32;
        if (r4 == null) goto L83;
        String r33 = r4.getEntranceInfo();
        if (r33 == null) goto L83;
        JSONObject r34 = com.bytedance.android.ec.core.utils.z1.g(r33);
        if (r34 == null) goto L83;
        String r35 = r34.optString("carrier_source");
    L84:
        r5.q = r35;
        r5.v = "guess_you_like_product";
        if (r4 == null) goto L89;
        AnchorV3PromotionRequestParam r110 = r4.getRequestParam();
        if (r110 == null) goto L89;
        String r111 = r110.getAuthorId();
    L90:
        r5.b = r111;
        if (r4 == null) goto L95;
        AnchorV3PromotionRequestParam r112 = r4.getRequestParam();
        if (r112 == null) goto L95;
        String r113 = r112.getItemId();
    L96:
        r5.a = r113;
        String r114 = String.valueOf(r23.f);
        if (r114 != null) goto L99;
        r114 = "";
    L99:
        r5.w = r114;
        if (r7 == null) goto L108;
        PromotionProductPrivilegesStruct r115 = r7.getPrivilegeInfo();
        if (r115 == null) goto L108;
        PromotionProductCouponsStruct r116 = r115.getCoupons();
        if (r116 == null) goto L108;
        List r117 = r116.getDiscountLabels();
        if (r117 == null) goto L108;
        PromotionDiscountLabel r118 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r117);
    L109:
        r5.y = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r118));
        if (r7 == null) goto L120;
        PromotionProductPrivilegesStruct r119 = r7.getPrivilegeInfo();
        if (r119 == null) goto L120;
        PromotionProductCouponsStruct r120 = r119.getCoupons();
        if (r120 == null) goto L120;
        List r121 = r120.getDiscountLabels();
        if (r121 == null) goto L120;
        PromotionDiscountLabel r122 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r121);
        if (r122 == null) goto L120;
        String r123 = r122.getId();
    L121:
        r5.x = r123;
        if (r7 == null) goto L124;
        PromotionProductPriceStruct r124 = r7.getProductPrice();
    L125:
        if (r124 != null) goto L128;
        r18 = "0";
    L128:
        r5.B = r18;
        if (r24 == null) goto L131;
        String r36 = r24.getRecommendInfo();
    L133:
        if (cg4.a.a(r36) == false) goto L136;
        if (r24 == null) goto L139;
        String r37 = r24.getRecommendInfo();
    L140:
        r5.F = r37;
        if (r4 == null) goto L147;
        ECAdLogExtra r38 = r4.getAdLogExtra();
        if (r38 == null) goto L147;
        String r39 = r38.getCreativeId();
        if (r39 == null) goto L147;
    L148:
        r5.G = r39;
        r5.S = r23.d;
        r5.T = "guess_you_like_product";
        r5.v = "guess_you_like_product";
        r5.f = "product_flow_page";
        yd3.p r40 = r23.i();
        if (r40 == null) goto L151;
        Integer r41 = Integer.valueOf(r40.getType());
    L153:
        if (r41 != null) goto L156;
    L158:
        if (r41 != null) goto L161;
    L163:
        if (r41 != null) goto L166;
    L168:
        String r42 = "product_flow_page";
    L169:
        r5.r = r42;
        if (r7 == null) goto L172;
        r5.W = CommerceButtonUtil.a(r7).getType();
    L172:
        yd3.p r43 = r23.i();
        if (r43 != null) goto L175;
    L176:
        yd3.p r44 = r23.i();
        if (r44 != null) goto L179;
    L180:
        yd3.p r1 = r23.i();
        if (r1 != null) goto L183;
    L185:
        r5.g1 = r25;
        if (r4 == null) goto L188;
        String r2 = r4.getVideoId();
    L189:
        r5.Y = r2;
        if (r7 == null) goto L192;
        String r45 = tf3.n.a(r7);
    L193:
        r5.p0 = r45;
        if (r7 == null) goto L200;
        PromotionProductPrivilegesStruct r46 = r7.getPrivilegeInfo();
        if (r46 == null) goto L200;
        List r47 = r46.getServices();
        if (r47 == null) goto L200;
        String r48 = CollectionsKt.joinToString$default(r47, ",", null, null, 0, null, FeedProductEventTracker$logBrandClickEvent$1$4.INSTANCE, 30, null);
    L201:
        r5.k0 = r48;
        if (r4 == null) goto L208;
        String r49 = r4.getEntranceInfo();
        if (r49 == null) goto L208;
        JSONObject r50 = com.bytedance.android.ec.core.utils.z1.g(r49);
        if (r50 == null) goto L208;
        r5.P0 = r50.optString("product_source_page", "");
    L208:
        r5.M = "product_flow_page";
        if (r22 == null) goto L211;
        String r51 = r22.getPageType();
    L212:
        r5.u = r51;
        if (r22 == null) goto L219;
        AnchorV3Param r52 = r22.m907getAnchorV3Param();
        if (r52 == null) goto L219;
        AnchorV3PromotionRequestParam r53 = r52.getRequestParam();
        if (r53 == null) goto L219;
        String r54 = r53.getEnterFrom();
    L220:
        r5.m = r54;
        if (r26 == null) goto L223;
        r5.appendParam(r26);
    L223:
        if (r7 == null) goto L227;
        PromotionProductExtraStruct r55 = r7.getExtraInfo();
        if (r55 == null) goto L227;
        r3 = r55.getEntranceInfo();
    L227:
        s0.a(r5, r3);
        com.bytedance.android.shopping.feed.event.g.d(r5, r21);
        return;
    L219:
        r54 = null;
        goto L220
    L211:
        r51 = null;
    L200:
        r48 = null;
        goto L201
    L192:
        r45 = null;
        goto L193
    L188:
        r2 = null;
        goto L189
    L183:
        if (r1.getType() != 12) goto L185;
    L184:
        r5.b1 = "product";
        goto L185
    L179:
        if (r44.getType() == 9) goto L184;
    L175:
        if (r43.getType() == 7) goto L184;
    L166:
        if (r41.intValue() != 9) goto L168;
    L167:
        r42 = "product_flow_page_inflow_card";
        goto L169
    L161:
        if (r41.intValue() != 7) goto L163;
    L156:
        if (r41.intValue() != 6) goto L158;
        r42 = "product_flow_page_new_channel";
        goto L169
    L151:
        r41 = null;
    L147:
        r39 = null;
    L139:
        r37 = null;
        goto L140
    L136:
        rd3.g r56 = r23.d();
        if (r56 == null) goto L139;
        r37 = r56.a();
        goto L140
    L131:
        r36 = null;
        goto L133
    L124:
        r124 = null;
    L120:
        r123 = null;
    L108:
        r118 = null;
    L95:
        r113 = null;
    L89:
        r111 = null;
    L83:
        r35 = null;
        goto L84
    L75:
        r32 = null;
    L71:
        r31 = null;
    L65:
        r29 = null;
    L59:
        r27 = null;
        goto L60
    L51:
        if (r7.hasCoupon() != true) goto L53;
        r19 = "1";
        goto L54
    L47:
        r17 = null;
    L35:
        r15 = null;
        goto L36
    L23:
        r11 = null;
    L19:
        r9 = null;
        goto L20
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static void n(FeedProductEventTracker r18, rd3.a r19, Context r20, String r21, String r22, String r23) {
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "anchorInflowFeedItem");
        int r3 = r19.f;
        ProductFeedViewModel r4 = r19.c;
        if (r4 == null) goto L231;
        AnchorV3Param r5 = r4.m907getAnchorV3Param();
        if (r5 == null) goto L232;
        Gson r6 = new Gson();
        AnchorV3Param r7 = r4.m907getAnchorV3Param();
        if (r7 == null) goto L11;
        String r8 = r7.getEntranceInfo();
    L12:
        JsonObject r9 = (JsonObject) GsonProtectorUtils.fromJson(r6, r8, JsonObject.class);
        if (r9 == null) goto L15;
        r9.addProperty("display_rank", String.valueOf(r19.f));
    L15:
        Iterator r10 = ((LinkedHashMap) r19.k).entrySet().iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        Map.Entry r11 = (Map.Entry) r10.next();
        if (r9 == null) goto L17;
        r9.addProperty((String) r11.getKey(), (String) r11.getValue());
        goto L17
    L21:
        TrackerProvider.a r12 = TrackerProvider.Companion;
        if (r20 == null) goto L29;
        Activity r13 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r20);
        if ((r13 instanceof FragmentActivity) == true) goto L27;
        r13 = null;
    L27:
        FragmentActivity r14 = (FragmentActivity) r13;
        if (r14 == null) goto L29;
        Object r15 = ViewModelProviders.of(r14).get(TrackerProvider.class).getTracker();
        if ((r15 instanceof o1) == true) goto L33;
        r15 = null;
    L33:
        o1 r16 = (o1) r15;
    L35:
        if (r16 == null) goto L40;
        if (r9 == null) goto L38;
        String r17 = r9.toString();
    L39:
        r16.c("entrance_info", r17, "");
        goto L40
    L38:
        r17 = null;
    L40:
        Promotion r24 = r19.f();
        if (r24 == null) goto L43;
        PromotionProductStruct r25 = r24.getPromotionInfo();
    L44:
        u0 r26 = new u0(r19.c());
        r26.g2 = Integer.valueOf(r4.isAutoExpand());
        a.getClass();
        a(r26, r25);
        if (r25 == null) goto L49;
        PromotionProductPriceStruct r110 = r25.getProductPrice();
        if (r110 == null) goto L49;
        String r111 = r110.getPriceTrackingInfo();
    L50:
        r26.h1 = r111;
        if (r25 == null) goto L57;
        PromotionProductExtraStruct r112 = r25.getExtraInfo();
        if (r112 == null) goto L57;
        String r113 = r112.getLogExtra();
        if (r113 == null) goto L57;
        JSONObject r114 = com.bytedance.android.ec.core.utils.z1.g(r113);
    L58:
        if (r114 == null) goto L67;
        String r115 = r114.optString("new_gift_type");
        if (r115 == null) goto L67;
        if (cg4.a.a(r115) == true) goto L65;
        r115 = null;
    L65:
        if (r115 == null) goto L67;
        r26.S1 = r115;
    L67:
        r26.e = "full_screen_card";
        r26.u = r4.getPageType();
        int r27 = com.bytedance.android.ec.core.anchorv3.a.a;
        r26.n = com.bytedance.android.ec.core.anchorv3.a.a(r5.getRequestParam().getSourcePage());
        r26.b = r5.getAuthorId();
        if (r25 == null) goto L74;
        PromotionProductExtraStruct r28 = r25.getExtraInfo();
        if (r28 == null) goto L74;
        Integer r29 = r28.getApplyCoupon();
        if (r29 == null) goto L74;
        r26.A = r29.intValue();
    L74:
        if (r25 == null) goto L82;
        PromotionProductPrivilegesStruct r30 = r25.getPrivilegeInfo();
        if (r30 == null) goto L82;
        PromotionProductCouponsStruct r31 = r30.getCoupons();
        if (r31 == null) goto L82;
        List r32 = r31.getDiscountLabels();
        if (r32 == null) goto L82;
        PromotionDiscountLabel r33 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r32);
    L83:
        r26.y = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r33));
        if (r25 == null) goto L94;
        PromotionProductPrivilegesStruct r34 = r25.getPrivilegeInfo();
        if (r34 == null) goto L94;
        PromotionProductCouponsStruct r35 = r34.getCoupons();
        if (r35 == null) goto L94;
        List r36 = r35.getDiscountLabels();
        if (r36 == null) goto L94;
        PromotionDiscountLabel r37 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r36);
        if (r37 == null) goto L94;
        String r38 = r37.getId();
    L95:
        r26.x = r38;
        String r116 = "1";
        if (r5.getCurrentPromotion().getProductPrice() == null) goto L98;
        String r39 = "1";
    L99:
        r26.B = r39;
        r26.z = r5.getWhichAccount();
        r26.a = r5.getRequestParam().getItemId();
        ECAdLogExtra r40 = r5.getAdLogExtra();
        if (r40 == null) goto L104;
        String r41 = r40.getCreativeId();
        if (r41 == null) goto L104;
    L105:
        r26.G = r41;
        ECAdLogExtra r42 = r5.getAdLogExtra();
        if (r42 == null) goto L108;
        String r43 = r42.getLogExtra();
    L109:
        r26.D = r43;
        if (r25 == null) goto L114;
        PromotionProductExtraStruct r44 = r25.getExtraInfo();
        if (r44 == null) goto L114;
        Boolean r45 = r44.getNeedCheck();
    L116:
        if (Intrinsics.areEqual(r45, Boolean.FALSE) == false) goto L118;
        String r46 = "0";
    L119:
        r26.E = r46;
        if (h(r25) == false) goto L122;
        r116 = "0";
    L122:
        r26.H = r116;
        int r47 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r26.I = com.bytedance.android.shopping.anchorv3.utils.y.l(r25);
        if (r25 == null) goto L127;
        PromotionProductExtraStruct r48 = r25.getExtraInfo();
        if (r48 == null) goto L127;
        String r49 = r48.getShopId();
    L128:
        r26.J = r49;
        if (h(r25) == false) goto L131;
        String r50 = "directbuying";
    L132:
        r26.L = r50;
        r26.K = com.bytedance.android.shopping.anchorv3.utils.y.d(r25);
        r26.N = r21;
        r26.P = com.bytedance.android.shopping.anchorv3.utils.y.s(r25);
        r26.O = com.bytedance.android.shopping.anchorv3.utils.y.i(r25);
        if (r25 == null) goto L139;
        PromotionProductPrivilegesStruct r51 = r25.getPrivilegeInfo();
        if (r51 == null) goto L139;
        PromotionProductLogisticsStruct r52 = r51.getLogistics();
        if (r52 == null) goto L139;
        Integer r53 = r52.getFastDispatch();
    L140:
        r26.Q = r53;
        r26.T = "product_fullscreen_card";
        r26.U = r22;
        r26.M = "product_flow_page";
        r26.w = String.valueOf(r3);
        ProductFeedViewModel r54 = r19.c;
        if (r54 == null) goto L147;
        AnchorV3Param r55 = r54.m907getAnchorV3Param();
        if (r55 == null) goto L147;
        ECLogExtraData r56 = r55.getLogExtraData();
        if (r56 == null) goto L147;
        String r57 = r56.getInflowRecommendType();
    L148:
        r26.x1 = String.valueOf(r57);
        String r58 = r5.getEntranceInfo();
        if (r58 == null) goto L153;
        JSONObject r59 = com.bytedance.android.ec.core.utils.z1.g(r58);
        if (r59 == null) goto L153;
        r26.q = r59.optString("carrier_source", "");
        r26.p = r59.optString("source_method", "");
        r26.R = r59.optString("search_params", "");
        r26.s = r59.optString("previous_page", "");
        r26.P0 = r59.optString("product_source_page", "");
    L153:
        if (r25 == null) goto L175;
        PromotionProductPrivilegesStruct r60 = r25.getPrivilegeInfo();
        if (r60 == null) goto L161;
        PromotionProductActivitiesStruct r61 = r60.getActivities();
        if (r61 == null) goto L161;
        PromotionDepositPresaleActivity r62 = r61.getDepositPresaleActivity();
        if (r62 == null) goto L161;
        r26.f = r5.getRequestParam().getSourcePage();
        r26.X = com.bytedance.android.ec.model.n.a(r62);
    L161:
        PromotionProductExtraStruct r63 = r25.getExtraInfo();
        if (r63 == null) goto L164;
        PromotionVideoInfo r64 = r63.getProductVideo();
    L165:
        if (r64 == null) goto L167;
        int r65 = 1;
    L168:
        r26.V = Integer.valueOf(r65);
        r26.X = com.bytedance.android.shopping.anchorv3.utils.y.f(r25);
        r26.p0 = tf3.n.a(r25);
        r26.Z = f53.a.c(r25).getActivityName();
        PromotionProductPrivilegesStruct r66 = r25.getPrivilegeInfo();
        if (r66 == null) goto L173;
        List r67 = r66.getServices();
        if (r67 == null) goto L173;
        String r68 = CollectionsKt.joinToString$default(r67, ",", null, null, 0, null, FeedProductEventTracker$logClickMainProductBuyEvent$2$5$2.INSTANCE, 30, null);
    L174:
        r26.k0 = r68;
    L173:
        r68 = null;
        goto L174
    L167:
        r65 = 0;
        goto L168
    L164:
        r64 = null;
    L175:
        Pair r69 = com.bytedance.android.shopping.anchorv3.utils.y.n(r5.getCurrentPromotion());
        r26.L0 = (String) r69.getFirst();
        r26.H0 = (String) r69.getSecond();
        if (r5.getRequestParam().getSourcePage().equals("ecom_tag") == false) goto L178;
        r26.v = "ecom_tag";
    L178:
        int r70 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r71 = r19.f();
        if (r71 == null) goto L183;
        PromotionProductStruct r72 = r71.getPromotionInfo();
        if (r72 == null) goto L183;
        PromotionProductPriceStruct r73 = r72.getProductPrice();
    L184:
        r26.G1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r73));
        Promotion r74 = r19.f();
        if (r74 == null) goto L189;
        PromotionProductStruct r75 = r74.getPromotionInfo();
        if (r75 == null) goto L189;
        PromotionProductPriceStruct r76 = r75.getProductPrice();
    L190:
        r26.H1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r76));
        Promotion r77 = r19.f();
        if (r77 == null) goto L195;
        PromotionProductStruct r78 = r77.getPromotionInfo();
        if (r78 == null) goto L195;
        PromotionProductPriceStruct r79 = r78.getProductPrice();
    L196:
        r26.L1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r79));
        Promotion r80 = r19.f();
        if (r80 == null) goto L201;
        PromotionProductStruct r81 = r80.getPromotionInfo();
        if (r81 == null) goto L201;
        PromotionProductPriceStruct r82 = r81.getProductPrice();
    L202:
        r26.M1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r82));
        if (r25 == null) goto L207;
        PromotionProductExtraStruct r84 = r25.getExtraInfo();
        if (r84 == null) goto L207;
        String r85 = r84.getEntranceInfo();
    L208:
        s0.a(r26, r85);
        if (r19.e == false) goto L211;
        String r86 = "product";
    L212:
        r26.b1 = r86;
        r26.appendParam(r19.k);
        if (r23 != null) goto L215;
    L217:
        if (r25 == null) goto L223;
        PromotionProductPrivilegesStruct r0 = r25.getPrivilegeInfo();
        if (r0 == null) goto L223;
        List r1 = r0.getTagCodeList();
        if (r1 == null) goto L223;
        String r2 = CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null);
    L224:
        r26.appendParam("tag_code_list", r2);
        com.bytedance.android.shopping.feed.event.g.c(r26, r20, null);
        return;
    L223:
        r2 = null;
        goto L224
    L215:
        if (com.bytedance.android.ec.core.utils.a2.d(r23) == null) goto L217;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r26.appendParam("btm_id", r23, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L217
    L211:
        r86 = "video";
    L207:
        r85 = null;
    L201:
        r82 = null;
    L195:
        r79 = null;
    L189:
        r76 = null;
    L183:
        r73 = null;
    L147:
        r57 = null;
    L139:
        r53 = null;
        goto L140
    L131:
        r50 = "GROUP_BUYING";
    L127:
        r49 = null;
        goto L128
    L118:
        r46 = "1";
    L114:
        r45 = null;
        goto L116
    L108:
        r43 = null;
    L104:
        r41 = null;
        goto L105
    L98:
        r39 = "0";
    L94:
        r38 = null;
    L82:
        r33 = null;
    L57:
        r114 = null;
    L49:
        r111 = null;
        goto L50
    L43:
        r25 = null;
    L29:
        r16 = null;
        goto L35
    L11:
        r8 = null;
        goto L12
    L232:
        return;
    }

    public static void r(String r9, String r10, String r11, String r12, String r13, String r14) {
        Single.fromCallable(new b(4, r9, r10, r11, r12, r13, r14)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }

    public static void x(String r17, rd3.a r18, String r19, String r20, Map r21, String r22) {
        Intrinsics.checkNotNullParameter(r17, "type");
        Intrinsics.checkNotNullParameter(r20, "btmPoint");
        String r3 = null;
        if (r18 == null) goto L7;
        ProductFeedViewModel r4 = r18.c;
        if (r4 == null) goto L7;
        AnchorV3Param r5 = r4.m907getAnchorV3Param();
    L8:
        JSONObject r15 = new JSONObject();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        if (r18 == null) goto L20;
        ProductFeedViewModel r7 = r18.c;     // Catch: Throwable -> L23
        if (r7 == null) goto L20;
        Fragment r8 = r7.getFlowFragment();     // Catch: Throwable -> L23
        if (r8 == null) goto L20;
        Iterator r0 = BtmSDK.INSTANCE.createReportParams(r20, PageFinder.via(r8)).entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r9 = (Map.Entry) r0.next();     // Catch: Throwable -> L23
        r15.put((String) r9.getKey(), r9.getValue());     // Catch: Throwable -> L23
        goto L17
    L19:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(r1);     // Catch: Throwable -> L23
    L25:
        if (r18 == null) goto L33;
        Promotion r2 = r18.f();
        if (r2 == null) goto L33;
        PromotionProductStruct r10 = r2.getPromotionInfo();
        if (r10 == null) goto L33;
        PromotionProductBaseStruct r11 = r10.getBaseInfo();
        if (r11 == null) goto L33;
        String r12 = r11.getProductId();
    L34:
        if (r18 != null) goto L36;
    L38:
        String r13 = "";
    L39:
        String r14 = r13;
        if (r5 == null) goto L44;
        ECLogExtraData r16 = r5.getLogExtraData();
        if (r16 == null) goto L44;
        String r110 = r16.getEnterFrom();
    L45:
        if (r5 == null) goto L47;
        String r23 = r5.getVideoId();
    L48:
        if (r5 == null) goto L50;
        String r24 = r5.getAuthorId();
    L51:
        if (r18 == null) goto L59;
        Promotion r25 = r18.f();
        if (r25 == null) goto L59;
        PromotionProductStruct r26 = r25.getPromotionInfo();
        if (r26 == null) goto L59;
        PromotionProductPriceStruct r27 = r26.getProductPrice();
        if (r27 == null) goto L59;
        r3 = r27.getPriceTrackingInfo();
    L59:
        String r111 = r3;
        boolean r28 = Intrinsics.areEqual(r17, "inflow_price_feedback_panel_show");
        r0 r29 = r0.a;
        q0 r30 = q0.a;
        if (r28 == false) goto L63;
        Single.fromCallable(new e(4, r12, r23, r24, r14, r110, r21, r111, r19, r15)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r30, r29);
        return;
    L63:
        if (Intrinsics.areEqual(r17, "inflow_price_feedback_panel_click") == false) goto L70;
        Single.fromCallable(new f(4, r12, r23, r24, r14, r110, r21, r111, r19, r15, r22)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r30, r29);
        return;
    L70:
        return;
    L50:
        r24 = null;
        goto L51
    L47:
        r23 = null;
    L44:
        r110 = null;
        goto L45
    L36:
        if (r18.e != true) goto L38;
        r13 = "guess_you_like_product";
    L33:
        r12 = null;
    L20:
        r1 = null;
    L23:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = null;
        goto L8
    }

    public static void D(FeedProductEventTracker r10, Context r11, rd3.a r12, String r13, boolean r14, Map r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        rd3.a r6 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r16 & 16) == 0) goto L17;
        Map r9 = null;
    L18:
        r10.getClass();
        if (r6 == null) goto L27;
        Promotion r0 = r6.f();
        if (r0 == null) goto L28;
        PromotionProductStruct r5 = r0.getPromotionInfo();
        if (r5 == null) goto L29;
        int r1 = ld3.b.a;
        Single.fromCallable(new l0(2, r11, r5, r6, r7, r8, r9)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L17:
        r9 = r15;
        goto L18
    L13:
        r8 = r14;
        goto L15
    L9:
        r7 = r13;
        goto L11
    L5:
        r6 = r12;
        goto L7
    }

    public static void l(rd3.a r29, String r30, String r31, Promotion r32, Boolean r33, Context r34, String r35) {
        String r3 = "";
        if (r29 == null) goto L8;
        yd3.p r4 = r29.i();
        if (r4 == null) goto L8;
        if (r4.getType() != 7) goto L8;
    L15:
        String r13 = "";
    L18:
        if (r29 == null) goto L29;
        ProductFeedViewModel r5 = r29.c;
        if (r5 == null) goto L29;
        AnchorV3Param r6 = r5.m907getAnchorV3Param();
        if (r6 == null) goto L29;
        ECLogExtraData r7 = r6.getLogExtraData();
        if (r7 == null) goto L29;
        String r8 = r7.getEnterFrom();
        if (r8 == null) goto L29;
        String r9 = r8;
    L30:
        if (r29 == null) goto L34;
        yd3.p r10 = r29.i();
        if (r10 == null) goto L34;
        Integer r11 = Integer.valueOf(r10.getType());
    L36:
        if (r11 != null) goto L39;
    L41:
        if (r11 != null) goto L44;
    L46:
        if (r11 != null) goto L49;
    L51:
        if (r11 != null) goto L54;
    L56:
        if (r29 == null) goto L58;
        String r1 = r29.c();
    L59:
        if (r29 == null) goto L72;
        yd3.p r12 = r29.i();
        if (r12 == null) goto L72;
        if (r12.getType() != 9) goto L72;
        yd3.p r14 = r29.i();
        if (r14 == null) goto L67;
        yd3.m r15 = r14.l();
    L68:
        if (r15 == null) goto L70;
        String r16 = "is_product";
    L71:
        String r21 = r16;
    L73:
        if (r29 == null) goto L75;
        Integer r17 = Integer.valueOf(r29.f);
    L76:
        String r18 = String.valueOf(r17);
        if (r30 != null) goto L79;
        String r19 = "";
    L80:
        if (r32 == null) goto L83;
        String r20 = r32.getRecommendInfo();
        if (r20 == null) goto L83;
    L88:
        if (r20 != null) goto L90;
        String r110 = "";
    L91:
        if (r29 == null) goto L93;
        String r111 = r29.d;
    L94:
        if (r29 == null) goto L102;
        ProductFeedViewModel r22 = r29.c;
        if (r22 == null) goto L102;
        AnchorV3Param r23 = r22.m907getAnchorV3Param();
        if (r23 == null) goto L102;
        ECLogExtraData r24 = r23.getLogExtraData();
        if (r24 == null) goto L102;
        String r112 = r24.getEnterFrom();
    L103:
        if (r29 == null) goto L111;
        ProductFeedViewModel r25 = r29.c;
        if (r25 == null) goto L111;
        AnchorV3Param r26 = r25.m907getAnchorV3Param();
        if (r26 == null) goto L111;
        ECLogExtraData r27 = r26.getLogExtraData();
        if (r27 == null) goto L111;
        String r113 = r27.getEnterFrom();
    L112:
        if (r29 == null) goto L118;
        ProductFeedViewModel r28 = r29.c;
        if (r28 == null) goto L118;
        AnchorV3Param r36 = r28.m907getAnchorV3Param();
        if (r36 == null) goto L118;
        String r114 = r36.getVideoId();
    L119:
        if (r29 == null) goto L127;
        yd3.p r37 = r29.i();
        if (r37 == null) goto L127;
        yd3.b r38 = r37.d();
        if (r38 == null) goto L127;
        String r39 = r38.e();
        if (r39 == null) goto L127;
        String r115 = r39;
    L128:
        if (r29 == null) goto L136;
        yd3.p r40 = r29.i();
        if (r40 == null) goto L136;
        yd3.b r41 = r40.d();
        if (r41 == null) goto L136;
        Long r42 = r41.i();
        if (r42 == null) goto L136;
        Float r43 = Float.valueOf(r42.longValue() / 100.0f);
    L137:
        String r116 = String.valueOf(r43);
        if (r29 == null) goto L144;
        yd3.p r44 = r29.i();
        if (r44 == null) goto L144;
        yd3.b r45 = r44.d();
        if (r45 == null) goto L144;
        Integer r46 = Integer.valueOf(r45.b());
    L146:
        if (r46 != null) goto L149;
    L151:
        if (r46 != null) goto L154;
    L156:
        if (r46 != null) goto L159;
    L161:
        if (r46 != null) goto L164;
    L166:
        String r2 = "";
    L167:
        if (r29 == null) goto L180;
        yd3.p r47 = r29.i();
        if (r47 == null) goto L180;
        if (r47.getType() != 9) goto L180;
        yd3.p r48 = r29.i();
        if (r48 == null) goto L179;
        yd3.f r49 = r48.h();
        if (r49 == null) goto L179;
        yd3.t r50 = r49.d();
        if (r50 == null) goto L179;
        r3 = r50.c();
    L179:
        String r210 = null;
    L181:
        if (r29 == null) goto L197;
        yd3.p r51 = r29.i();
        if (r51 == null) goto L197;
        if (r51.getType() != 9) goto L197;
        yd3.p r52 = r29.i();
        if (r52 == null) goto L193;
        yd3.f r53 = r52.h();
        if (r53 == null) goto L193;
        yd3.t r54 = r53.d();
        if (r54 == null) goto L193;
        String r55 = r54.c();
    L195:
        if (cg4.a.a(r55) == false) goto L197;
        String r211 = "1";
    L198:
        if (r29 == null) goto L200;
        String r212 = s0.c(r29);
    L201:
        if (r29 == null) goto L207;
        yd3.p r56 = r29.i();
        if (r56 == null) goto L207;
        yd3.b r57 = r56.d();
        if (r57 == null) goto L207;
        String r213 = r57.d();
    L208:
        if (r29 == null) goto L212;
        ProductFeedViewModel r58 = r29.c;
        if (r58 == null) goto L212;
        Integer r214 = Integer.valueOf(r58.isAutoExpand());
    L214:
        if (r29 == null) goto L224;
        yd3.p r59 = r29.i();
        if (r59 == null) goto L224;
        if (r59.getType() != 20) goto L224;
        yd3.p r60 = r29.i();
        if (r60 == null) goto L224;
        yd3.p.b r61 = r60.g();
        if (r61 == null) goto L224;
        String r215 = r61.c();
    L225:
        if (r29 == null) goto L235;
        yd3.p r62 = r29.i();
        if (r62 == null) goto L235;
        if (r62.getType() != 20) goto L235;
        yd3.p r0 = r29.i();
        if (r0 == null) goto L235;
        yd3.p.b r63 = r0.g();
        if (r63 == null) goto L235;
        String r216 = r63.a();
    L236:
        com.bytedance.android.shopping.feed.event.g.c(new t(r9, r1, r18, r19, r110, r111, r112, r13, r113, r114, r31, r115, r116, r2, r35, r21, r211, r210, r212, r213, r214, r215, r216), r34, null);
        return;
    L235:
        r216 = null;
    L224:
        r215 = null;
    L212:
        r214 = null;
    L207:
        r213 = null;
        goto L208
    L200:
        r212 = null;
    L193:
        r55 = null;
    L197:
        r211 = "0";
    L180:
        r210 = r3;
        goto L181
    L164:
        if (r46.intValue() != 7) goto L166;
    L165:
        r2 = "1";
        goto L167
    L159:
        if (r46.intValue() != 5) goto L161;
    L154:
        if (r46.intValue() != 6) goto L156;
    L155:
        r2 = "0";
        goto L167
    L149:
        if (r46.intValue() != 4) goto L151;
    L144:
        r46 = null;
    L136:
        r43 = null;
    L127:
        r115 = null;
    L118:
        r114 = null;
    L111:
        r113 = null;
    L102:
        r112 = null;
        goto L103
    L93:
        r111 = null;
        goto L94
    L90:
        r110 = r20;
    L83:
        if (r29 == null) goto L87;
        rd3.g r64 = r29.d();
        if (r64 == null) goto L87;
        r20 = r64.a();
    L87:
        r20 = null;
        goto L88
    L79:
        r19 = r30;
        goto L80
    L75:
        r17 = null;
        goto L76
    L70:
        r16 = "non_product";
        goto L71
    L67:
        r15 = null;
    L72:
        r21 = "";
        goto L73
    L58:
        r1 = "";
        goto L59
    L54:
        if (r11.intValue() != 12) goto L56;
        r1 = "ecom_growth";
        goto L59
    L49:
        if (r11.intValue() != 11) goto L51;
        r1 = "window";
        goto L59
    L44:
        if (r11.intValue() != 9) goto L46;
        r1 = "enter_mall";
        goto L59
    L39:
        if (r11.intValue() != 8) goto L41;
        r1 = "book_rank_card";
    L34:
        r11 = null;
    L29:
        r9 = "";
    L8:
        if (r29 == null) goto L14;
        yd3.p r65 = r29.i();
        if (r65 == null) goto L14;
        if (r65.getType() == 11) goto L15;
    L14:
        if (Intrinsics.areEqual(r33, Boolean.TRUE) == true) goto L15;
        r13 = "guess_you_like_product";
        goto L18
    }

    public static void t(FeedProductEventTracker r23, Context r24, rd3.a r25, String r26, String r27, Map r28, int r29) {
        if ((r29 & 4) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r29 & 16) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r29 & 32) == 0) goto L13;
        Map r6 = null;
    L14:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "context");
        if (r25 == null) goto L299;
        ProductFeedViewModel r7 = r25.c;
        if (r7 == null) goto L300;
        AnchorV3Param r8 = r7.m907getAnchorV3Param();
        if (r8 == null) goto L301;
        Promotion r9 = r25.f();
        if (r9 == null) goto L25;
        PromotionProductStruct r10 = r9.getPromotionInfo();
    L26:
        u0 r11 = new u0(r25.c());
        ProductFeedViewModel r12 = r25.c;
        if (r12 == null) goto L29;
        Integer r13 = Integer.valueOf(r12.isAutoExpand());
    L30:
        r11.g2 = r13;
        a.getClass();
        a(r11, r10);
        if (r10 == null) goto L35;
        PromotionProductPriceStruct r14 = r10.getProductPrice();
        if (r14 == null) goto L35;
        String r15 = r14.getPriceTrackingInfo();
    L36:
        r11.h1 = r15;
        if (r10 == null) goto L43;
        PromotionProductExtraStruct r16 = r10.getExtraInfo();
        if (r16 == null) goto L43;
        String r17 = r16.getLogExtra();
        if (r17 == null) goto L43;
        JSONObject r18 = com.bytedance.android.ec.core.utils.z1.g(r17);
    L44:
        if (r18 == null) goto L53;
        String r19 = r18.optString("new_gift_type");
        if (r19 == null) goto L53;
        if (cg4.a.a(r19) == true) goto L51;
        r19 = null;
    L51:
        if (r19 == null) goto L53;
        r11.S1 = r19;
    L53:
        int r110 = com.bytedance.android.ec.core.anchorv3.a.a;
        r11.n = com.bytedance.android.ec.core.anchorv3.a.a(r8.getRequestParam().getSourcePage());
        if (r10 == null) goto L60;
        PromotionProductExtraStruct r111 = r10.getExtraInfo();
        if (r111 == null) goto L60;
        Integer r112 = r111.getApplyCoupon();
        if (r112 == null) goto L60;
        r11.A = r112.intValue();
    L60:
        if (r6 == null) goto L62;
        r11.appendParam(r6);
    L62:
        r11.z = r8.getWhichAccount();
        ECAdLogExtra r113 = r8.getAdLogExtra();
        if (r113 == null) goto L65;
        String r114 = r113.getLogExtra();
    L66:
        r11.D = r114;
        if (r10 == null) goto L71;
        PromotionProductExtraStruct r115 = r10.getExtraInfo();
        if (r115 == null) goto L71;
        Boolean r116 = r115.getNeedCheck();
    L73:
        if (Intrinsics.areEqual(r116, Boolean.FALSE) == false) goto L75;
        String r117 = "0";
    L76:
        r11.E = r117;
        if (h(r10) == false) goto L79;
        String r118 = "0";
    L80:
        r11.H = r118;
        if (r10 == null) goto L85;
        PromotionProductExtraStruct r119 = r10.getExtraInfo();
        if (r119 == null) goto L85;
        String r120 = r119.getShopId();
    L86:
        r11.J = r120;
        if (h(r10) == false) goto L89;
        String r121 = "directbuying";
    L90:
        r11.L = r121;
        int r122 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r11.K = com.bytedance.android.shopping.anchorv3.utils.y.d(r10);
        r11.N = r2;
        r11.P = com.bytedance.android.shopping.anchorv3.utils.y.s(r10);
        r11.O = com.bytedance.android.shopping.anchorv3.utils.y.i(r10);
        if (r10 == null) goto L97;
        PromotionProductPrivilegesStruct r3 = r10.getPrivilegeInfo();
        if (r3 == null) goto L97;
        PromotionProductLogisticsStruct r5 = r3.getLogistics();
        if (r5 == null) goto L97;
        Integer r20 = r5.getFastDispatch();
    L98:
        r11.Q = r20;
        r11.T = "product_fullscreen_card";
        String r21 = String.valueOf(r25.f);
        if (r21 != null) goto L101;
        r21 = "";
    L101:
        r11.w = r21;
        r11.U = null;
        r11.M = "product_flow_page";
        r11.e = "full_screen_card";
        String r123 = r8.getEntranceInfo();
        if (r123 == null) goto L123;
        JSONObject r124 = com.bytedance.android.ec.core.utils.z1.g(r123);
        if (r124 == null) goto L123;
        r124.put("display_rank", String.valueOf(r25.f));
        r124.put("ecom_group_type", "product_card");
        r124.put("inflow_product_card_mode", r25.m);
        r124.put("module_label", "guess_you_like_product");
        if (r6 == null) goto L111;
        Iterator r22 = r6.entrySet().iterator();
    L109:
        if (r22.hasNext() == false) goto L111;
        Map.Entry r30 = (Map.Entry) r22.next();
        r124.put((String) r30.getKey(), r30.getValue());
    L111:
        Iterator r31 = ((LinkedHashMap) r25.k).entrySet().iterator();
    L113:
        if (r31.hasNext() == false) goto L115;
        Map.Entry r32 = (Map.Entry) r31.next();
        r124.put((String) r32.getKey(), r32.getValue());
        goto L113
    L115:
        InnerFlowAdRawData r33 = r25.a;
        if (r33 == null) goto L122;
        InnerFlowAdData r34 = r33.getAdData();
        if (r34 == null) goto L122;
        Long r35 = r34.getCreativeId();
        if (r35 == null) goto L122;
        long r125 = r35.longValue();
        r124.remove("cid");
        r124.put("cid", String.valueOf(r125));
    L122:
        Unit r36 = Unit.INSTANCE;
    L124:
        r11.o = String.valueOf(r124);
        if (r10 != null) goto L127;
    L129:
        String r37 = r12;
    L130:
        r11.g = r37;
        rd3.g r38 = r25.d();
        if (r38 == null) goto L133;
        Boolean r39 = r38.b();
    L134:
        r11.k = Integer.valueOf(Intrinsics.areEqual(r39, Boolean.TRUE) ? 1 : 0);
        if (r10 == null) goto L139;
        PromotionProductBaseStruct r40 = r10.getBaseInfo();
        if (r40 == null) goto L139;
        String r41 = r40.getPromotionId();
    L140:
        r11.c = r41;
        if (r10 == null) goto L145;
        PromotionProductBaseStruct r42 = r10.getBaseInfo();
        if (r42 == null) goto L145;
        Integer r43 = r42.getPromotionSource();
    L146:
        r11.d = String.valueOf(r43);
        if (r10 == null) goto L151;
        PromotionProductBaseStruct r44 = r10.getBaseInfo();
        if (r44 == null) goto L151;
        String r45 = r44.getProductId();
    L152:
        r11.t = r45;
        r11.p = r8.getSourceMethod();
        r11.v = "guess_you_like_product";
        r11.b = r8.getRequestParam().getAuthorId();
        r11.a = r8.getRequestParam().getItemId();
        if (r10 == null) goto L161;
        PromotionProductPrivilegesStruct r46 = r10.getPrivilegeInfo();
        if (r46 == null) goto L161;
        PromotionProductCouponsStruct r47 = r46.getCoupons();
        if (r47 == null) goto L161;
        List r48 = r47.getDiscountLabels();
        if (r48 == null) goto L161;
        PromotionDiscountLabel r49 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r48);
    L162:
        r11.y = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r49));
        if (r10 == null) goto L173;
        PromotionProductPrivilegesStruct r50 = r10.getPrivilegeInfo();
        if (r50 == null) goto L173;
        PromotionProductCouponsStruct r51 = r50.getCoupons();
        if (r51 == null) goto L173;
        List r52 = r51.getDiscountLabels();
        if (r52 == null) goto L173;
        PromotionDiscountLabel r53 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r52);
        if (r53 == null) goto L173;
        String r54 = r53.getId();
    L174:
        r11.x = r54;
        if (r10 == null) goto L179;
        PromotionProductBaseStruct r55 = r10.getBaseInfo();
        if (r55 == null) goto L179;
        PromotionProductPrice r56 = r55.getPrice();
    L180:
        if (r56 == null) goto L182;
        String r57 = "1";
    L183:
        r11.B = r57;
        rd3.g r58 = r25.d();
        if (r58 == null) goto L186;
        String r59 = r58.a();
    L187:
        r11.F = r59;
        ECAdLogExtra r60 = r8.getAdLogExtra();
        if (r60 == null) goto L192;
        String r61 = r60.getCreativeId();
        if (r61 == null) goto L192;
    L193:
        r11.G = r61;
        r11.S = r25.d;
        r11.T = "guess_you_like_product";
        r11.v = "guess_you_like_product";
        r11.r = "product_flow_page";
        r11.U = null;
        ProductFeedViewModel r62 = r25.c;
        if (r62 == null) goto L200;
        AnchorV3Param r63 = r62.m907getAnchorV3Param();
        if (r63 == null) goto L200;
        ECLogExtraData r64 = r63.getLogExtraData();
        if (r64 == null) goto L200;
        String r65 = r64.getInflowRecommendType();
    L201:
        r11.x1 = String.valueOf(r65);
        String r66 = r8.getEntranceInfo();
        if (r66 == null) goto L206;
        JSONObject r67 = com.bytedance.android.ec.core.utils.z1.g(r66);
        if (r67 == null) goto L206;
        r11.q = r67.optString("carrier_source", "");
        r11.p = r67.optString("source_method", "");
        r11.R = r67.optString("search_params", "");
        r11.P0 = r67.optString("product_source_page", "");
    L206:
        r11.appendParam(s0.b(r8.getEntranceInfo()));
        r11.V0 = "product_card";
        String r68 = r8.getEntranceInfo();
        if (r68 == null) goto L211;
        JSONObject r69 = com.bytedance.android.ec.core.utils.z1.g(r68);
        if (r69 == null) goto L211;
        String r70 = r69.optString("carrier_source");
    L212:
        r11.q = r70;
        r11.Y = r8.getVideoId();
        if (r10 == null) goto L215;
        String r71 = tf3.n.a(r10);
    L216:
        r11.p0 = r71;
        if (r10 == null) goto L219;
        ActivityVO r72 = f53.a.c(r10);
    L220:
        if (r72 == null) goto L222;
        String r73 = r72.getActivityName();
    L223:
        r11.Z = r73;
        if (r10 == null) goto L230;
        PromotionProductPrivilegesStruct r74 = r10.getPrivilegeInfo();
        if (r74 == null) goto L230;
        List r75 = r74.getServices();
        if (r75 == null) goto L230;
        String r76 = CollectionsKt.joinToString$default(r75, ",", null, null, 0, null, FeedProductEventTracker$logGuessULikeClickBuyProduct$1$7.INSTANCE, 30, null);
    L231:
        r11.k0 = r76;
        r11.u = r7.getPageType();
        s0.a(r11, r8.getEntranceInfo());
        if (r10 == null) goto L236;
        PromotionProductExtraStruct r77 = r10.getExtraInfo();
        if (r77 == null) goto L236;
        String r78 = r77.getEntranceInfo();
    L237:
        s0.a(r11, r78);
        String r79 = r8.getEntranceInfo();
        if (r79 == null) goto L240;
        JSONObject r80 = com.bytedance.android.ec.core.utils.z1.g(r79);
    L241:
        if (r80 == null) goto L243;
        r11.k1 = r80.optString("share_object");
        r11.p1 = r80.optString("share_content");
    L243:
        Promotion r81 = r25.f();
        if (r81 == null) goto L250;
        PromotionProductStruct r82 = r81.getPromotionInfo();
        if (r82 == null) goto L250;
        PromotionProductExtraStruct r84 = r82.getExtraInfo();
        if (r84 == null) goto L250;
        PromotionVideoInfo r85 = r84.getProductVideo();
    L251:
        if (r85 == null) goto L253;
        String r126 = "1";
    L254:
        r11.v1 = r126;
        r11.y1 = r25.m;
        if (r4 != null) goto L257;
    L259:
        int r86 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r87 = r25.f();
        if (r87 == null) goto L264;
        PromotionProductStruct r88 = r87.getPromotionInfo();
        if (r88 == null) goto L264;
        PromotionProductPriceStruct r89 = r88.getProductPrice();
    L265:
        r11.G1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r89));
        Promotion r90 = r25.f();
        if (r90 == null) goto L270;
        PromotionProductStruct r91 = r90.getPromotionInfo();
        if (r91 == null) goto L270;
        PromotionProductPriceStruct r92 = r91.getProductPrice();
    L271:
        r11.H1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r92));
        Promotion r94 = r25.f();
        if (r94 == null) goto L276;
        PromotionProductStruct r95 = r94.getPromotionInfo();
        if (r95 == null) goto L276;
        PromotionProductPriceStruct r96 = r95.getProductPrice();
    L277:
        r11.L1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r96));
        Promotion r97 = r25.f();
        if (r97 == null) goto L282;
        PromotionProductStruct r98 = r97.getPromotionInfo();
        if (r98 == null) goto L282;
        PromotionProductPriceStruct r99 = r98.getProductPrice();
    L283:
        r11.M1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r99));
        if (r25.e == false) goto L286;
        String r100 = "product";
    L287:
        r11.b1 = r100;
        r11.appendParam(r25.k);
        if (r10 == null) goto L294;
        PromotionProductPrivilegesStruct r1 = r10.getPrivilegeInfo();
        if (r1 == null) goto L294;
        List r101 = r1.getTagCodeList();
        if (r101 == null) goto L294;
        String r102 = CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null);
    L295:
        r11.appendParam("tag_code_list", r102);
        com.bytedance.android.shopping.feed.event.g.d(r11, r24);
        return;
    L294:
        r102 = null;
        goto L295
    L286:
        r100 = "video";
    L282:
        r99 = null;
    L276:
        r96 = null;
    L270:
        r92 = null;
    L264:
        r89 = null;
        goto L265
    L257:
        if (com.bytedance.android.ec.core.utils.a2.d(r4) == null) goto L259;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r11.appendParam("btm_id", r4, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L259
    L253:
        r126 = "0";
    L250:
        r85 = null;
        goto L251
    L240:
        r80 = null;
    L236:
        r78 = null;
    L230:
        r76 = null;
        goto L231
    L222:
        r73 = null;
        goto L223
    L219:
        r72 = null;
        goto L220
    L215:
        r71 = null;
    L211:
        r70 = null;
    L200:
        r65 = null;
    L192:
        r61 = null;
        goto L193
    L186:
        r59 = null;
        goto L187
    L182:
        r57 = r12;
    L179:
        r56 = null;
    L173:
        r54 = null;
    L161:
        r49 = null;
    L151:
        r45 = null;
    L145:
        r43 = null;
    L139:
        r41 = null;
        goto L140
    L133:
        r39 = null;
        goto L134
    L127:
        if (r10.hasCoupon() != true) goto L129;
        r37 = "1";
    L123:
        r124 = null;
    L97:
        r20 = null;
        goto L98
    L89:
        r121 = "GROUP_BUYING";
    L85:
        r120 = null;
        goto L86
    L79:
        r118 = "1";
        goto L80
    L75:
        r117 = "1";
    L71:
        r116 = null;
        goto L73
    L65:
        r114 = null;
    L43:
        r18 = null;
    L35:
        r15 = null;
        goto L36
    L29:
        r13 = null;
        goto L30
    L25:
        r10 = null;
        goto L26
    L301:
        return;
    L300:
        return;
    L299:
        return;
    L13:
        r6 = r28;
        goto L14
    L9:
        r4 = r27;
        goto L11
    L5:
        r2 = r26;
        goto L7
    }

    public static void v(FeedProductEventTracker r9, Context r10, rd3.a r11, String r12, boolean r13, Map r14, int r15) {
        if ((r15 & 4) == 0) goto L5;
        r12 = "";
    L5:
        String r6 = r12;
        if ((r15 & 8) == 0) goto L8;
        boolean r7 = false;
    L10:
        if ((r15 & 16) == 0) goto L12;
        Map r8 = null;
    L13:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        ProductFeedViewModel r16 = r11.c;
        if (r16 == null) goto L22;
        AnchorV3Param r3 = r16.m907getAnchorV3Param();
        Promotion r17 = r11.f();
        if (r17 == null) goto L19;
        PromotionProductStruct r5 = r17.getPromotionInfo();
    L20:
        Single.fromCallable(new f0(0, r10, r3, r11, r5, r6, r7, r8)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L19:
        r5 = null;
        goto L20
    L22:
        return;
    L12:
        r8 = r14;
        goto L13
    L8:
        r7 = r13;
        goto L10
    }

    public static void w(String r19, rd3.a r20, String r21, String r22, String r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r19, "type");
        Intrinsics.checkNotNullParameter(r21, "productIdGroup");
        Intrinsics.checkNotNullParameter(r22, "location");
        Intrinsics.checkNotNullParameter(r23, "btmPoint");
        if (r20 == null) goto L7;
        ProductFeedViewModel r4 = r20.c;
        if (r4 == null) goto L7;
        AnchorV3Param r5 = r4.m907getAnchorV3Param();
    L8:
        JSONObject r14 = new JSONObject();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        if (r20 == null) goto L20;
        ProductFeedViewModel r7 = r20.c;     // Catch: Throwable -> L23
        if (r7 == null) goto L20;
        Fragment r8 = r7.getFlowFragment();     // Catch: Throwable -> L23
        if (r8 == null) goto L20;
        BtmSDK r9 = BtmSDK.INSTANCE;     // Catch: Throwable -> L23
        a.getClass();     // Catch: Throwable -> L23
        Iterator r0 = r9.createReportParams(f(r20, r23), PageFinder.via(r8)).entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r10 = (Map.Entry) r0.next();     // Catch: Throwable -> L23
        r14.put((String) r10.getKey(), r10.getValue());     // Catch: Throwable -> L23
        goto L17
    L19:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(r1);     // Catch: Throwable -> L23
    L26:
        if (r20 != null) goto L28;
    L30:
        if (r5 == null) goto L35;
        ECLogExtraData r11 = r5.getLogExtraData();
        if (r11 == null) goto L35;
        String r12 = r11.getEComEntranceForm();
    L34:
        String r13 = r12;
    L36:
        if (r5 == null) goto L40;
        AnchorV3PromotionRequestParam r15 = r5.getRequestParam();
        if (r15 == null) goto L40;
        String r16 = r15.getSourcePage();
    L41:
        if (r5 == null) goto L45;
        ECLogExtraData r17 = r5.getLogExtraData();
        if (r17 == null) goto L45;
        String r18 = r17.getEnterFrom();
    L46:
        if (r5 == null) goto L50;
        ECLogExtraData r26 = r5.getLogExtraData();
        if (r26 == null) goto L50;
        String r110 = r26.getEnterFrom();
    L51:
        if (r5 == null) goto L55;
        ECLogExtraData r27 = r5.getLogExtraData();
        if (r27 == null) goto L55;
        String r111 = r27.getEnterFrom();
    L56:
        if (r20 != null) goto L58;
    L60:
        String r2 = "";
    L61:
        if (r5 == null) goto L63;
        String r112 = r5.getVideoId();
    L64:
        if (r5 == null) goto L66;
        String r28 = r5.getAuthorId();
    L67:
        boolean r3 = Intrinsics.areEqual(r19, "inflow_low_price_entrance_show");
        r0 r29 = r0.a;
        q0 r113 = q0.a;
        if (r3 == false) goto L71;
        Single.fromCallable(new c(4, r24, r21, r28, r13, r16, r18, r112, r25, r110, r2, r111, r22, r14)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r113, r29);
        return;
    L71:
        if (Intrinsics.areEqual(r19, "inflow_low_price_entrance_click") == false) goto L78;
        Single.fromCallable(new d(4, r24, r21, r28, r13, r16, r18, r112, r25, r110, r2, r111, r22, r14)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r113, r29);
        return;
    L78:
        return;
    L66:
        r28 = null;
        goto L67
    L63:
        r112 = null;
        goto L64
    L58:
        if (r20.e != true) goto L60;
        r2 = "guess_you_like_product";
    L55:
        r111 = null;
    L50:
        r110 = null;
    L45:
        r18 = null;
    L40:
        r16 = null;
    L35:
        r13 = null;
        goto L36
    L28:
        if (r20.e != true) goto L30;
        r12 = "guess_you_like";
    L20:
        r1 = null;
    L23:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = null;
        goto L8
    }

    public static void R(rd3.a r14, Context r15, String r16, String r17, String r18, String r19, String r20, String r21) {
        if (r14 == null) goto L24;
        ProductFeedViewModel r4 = r14.c;
        if (r4 == null) goto L25;
        Promotion r0 = r14.f();
        if (r0 == null) goto L10;
        PromotionProductStruct r1 = r0.getPromotionInfo();
    L11:
        PromotionProductStruct r5 = r1;
        if (cg4.a.a(r20) == false) goto L14;
        String r6 = r20;
    L22:
        Single.fromCallable(new p(2, r15, CollectionsKt.listOf(PdpOpenThirdParam.KEY_PRODUCT_ID), r4, r5, r6, r14, r17, r16, r21, r19, r18)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        return;
    L14:
        if (r5 == null) goto L20;
        PromotionProductAuthorEntriesStruct r2 = r5.getEntryInfo();
        if (r2 == null) goto L20;
        if (r2.getShopEntry() == null) goto L20;
        String r3 = "window";
    L21:
        r6 = r3;
    L20:
        r3 = "shop";
        goto L21
    L10:
        r1 = null;
        goto L11
    L25:
        return;
    }

    public static void u(FeedProductEventTracker r2, Context r3, rd3.a r4, String r5, String r6, boolean r7, Map r8, int r9) {
        if ((r9 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 8) == 0) goto L9;
        r6 = "";
    L9:
        if ((r9 & 16) == 0) goto L12;
        r7 = false;
    L12:
        if ((r9 & 32) == 0) goto L14;
        r8 = null;
    L14:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "itemAnchor");
        u0 r10 = c(r4, r5, r6, r7, r8, null);
        if (r10 == null) goto L18;
        com.bytedance.android.shopping.feed.event.g.d(r10, r3);
        return;
    }

    public static /* synthetic */ void m(FeedProductEventTracker r9, rd3.a r10, String r11, String r12, Promotion r13, Boolean r14, Context r15, String r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        Promotion r5 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        Boolean r6 = Boolean.FALSE;
    L15:
        if ((r17 & 32) == 0) goto L17;
        Context r7 = null;
    L19:
        if ((r17 & 64) == 0) goto L21;
        String r8 = null;
    L22:
        r9.getClass();
        l(r10, r11, r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = r16;
        goto L22
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public static u0 b(ProductFeedViewModel r19, PromotionProductStruct r20, String r21, String r22, boolean r23, String r24, String r25, String r26, boolean r27, Map r28, Map r29) {
        Intrinsics.checkNotNullParameter(r19, "vm");
        Intrinsics.checkNotNullParameter(r24, "inflowProductCardMode");
        AnchorV3Param r6 = r19.m907getAnchorV3Param();
        String r8 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        u0 r9 = new u0(null);
        r9.g2 = Integer.valueOf(r19.isAutoExpand());
        a.getClass();
        a(r9, r20);
        if (r20 == null) goto L10;
        PromotionProductPriceStruct r10 = r20.getProductPrice();
        if (r10 == null) goto L10;
        String r11 = r10.getPriceTrackingInfo();
    L11:
        r9.h1 = r11;
        if (r20 == null) goto L18;
        PromotionProductExtraStruct r12 = r20.getExtraInfo();
        if (r12 == null) goto L18;
        String r13 = r12.getLogExtra();
        if (r13 == null) goto L18;
        JSONObject r14 = com.bytedance.android.ec.core.utils.z1.g(r13);
    L19:
        if (r14 == null) goto L28;
        String r15 = r14.optString("user_type");
        if (r15 == null) goto L28;
        if (cg4.a.a(r15) == true) goto L26;
        r15 = null;
    L26:
        if (r15 == null) goto L28;
        r9.P1 = r15;
    L28:
        if (r14 == null) goto L37;
        String r16 = r14.optString("coupon_name");
        if (r16 == null) goto L37;
        if (cg4.a.a(r16) == true) goto L35;
        r16 = null;
    L35:
        if (r16 == null) goto L37;
        r9.Q1 = r16;
    L37:
        if (r14 == null) goto L46;
        String r17 = r14.optString("new_gift_type");
        if (r17 == null) goto L46;
        if (cg4.a.a(r17) == true) goto L44;
        r17 = null;
    L44:
        if (r17 == null) goto L46;
        r9.S1 = r17;
    L46:
        if (r23 == true) goto L48;
        r9.e = "full_screen_card";
    L48:
        r9.w = r26;
        r9.u = r19.getPageType();
        int r7 = com.bytedance.android.ec.core.anchorv3.a.a;
        r9.n = com.bytedance.android.ec.core.anchorv3.a.a(r6.getRequestParam().getSourcePage());
        r9.b = r6.getAuthorId();
        if (r20 == null) goto L55;
        PromotionProductExtraStruct r18 = r20.getExtraInfo();
        if (r18 == null) goto L55;
        Integer r30 = r18.getApplyCoupon();
        if (r30 == null) goto L55;
        r9.A = r30.intValue();
    L55:
        if (r20 == null) goto L63;
        PromotionProductPrivilegesStruct r31 = r20.getPrivilegeInfo();
        if (r31 == null) goto L63;
        PromotionProductCouponsStruct r32 = r31.getCoupons();
        if (r32 == null) goto L63;
        List r33 = r32.getDiscountLabels();
        if (r33 == null) goto L63;
        PromotionDiscountLabel r34 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r33);
    L64:
        r9.y = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r34));
        if (r20 == null) goto L75;
        PromotionProductPrivilegesStruct r35 = r20.getPrivilegeInfo();
        if (r35 == null) goto L75;
        PromotionProductCouponsStruct r36 = r35.getCoupons();
        if (r36 == null) goto L75;
        List r37 = r36.getDiscountLabels();
        if (r37 == null) goto L75;
        PromotionDiscountLabel r38 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r37);
        if (r38 == null) goto L75;
        String r39 = r38.getId();
    L76:
        r9.x = r39;
        String r110 = "1";
        if (r6.getCurrentPromotion().getProductPrice() == null) goto L79;
        String r40 = "1";
    L80:
        r9.B = r40;
        r9.z = r6.getWhichAccount();
        r9.a = r6.getRequestParam().getItemId();
        ECAdLogExtra r41 = r6.getAdLogExtra();
        if (r41 == null) goto L85;
        String r42 = r41.getCreativeId();
        if (r42 == null) goto L85;
    L86:
        r9.G = r42;
        ECAdLogExtra r43 = r6.getAdLogExtra();
        if (r43 == null) goto L89;
        String r44 = r43.getLogExtra();
    L90:
        r9.D = r44;
        if (r20 == null) goto L95;
        PromotionProductExtraStruct r45 = r20.getExtraInfo();
        if (r45 == null) goto L95;
        Boolean r46 = r45.getNeedCheck();
    L97:
        if (Intrinsics.areEqual(r46, Boolean.FALSE) == false) goto L99;
        String r47 = "0";
    L100:
        r9.E = r47;
        if (h(r20) == false) goto L103;
        r110 = "0";
    L103:
        r9.H = r110;
        int r48 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r9.I = com.bytedance.android.shopping.anchorv3.utils.y.l(r20);
        if (r20 == null) goto L108;
        PromotionProductExtraStruct r49 = r20.getExtraInfo();
        if (r49 == null) goto L108;
        String r50 = r49.getShopId();
    L109:
        r9.J = r50;
        if (h(r20) == false) goto L112;
        String r51 = "directbuying";
    L113:
        r9.L = r51;
        r9.K = com.bytedance.android.shopping.anchorv3.utils.y.d(r20);
        r9.N = r21;
        r9.P = com.bytedance.android.shopping.anchorv3.utils.y.s(r20);
        r9.O = com.bytedance.android.shopping.anchorv3.utils.y.i(r20);
        if (r20 == null) goto L120;
        PromotionProductPrivilegesStruct r52 = r20.getPrivilegeInfo();
        if (r52 == null) goto L120;
        PromotionProductLogisticsStruct r53 = r52.getLogistics();
        if (r53 == null) goto L120;
        Integer r54 = r53.getFastDispatch();
    L121:
        r9.Q = r54;
        r9.T = "product_fullscreen_card";
        r9.U = r22;
        r9.M = "product_flow_page";
        JsonObject r55 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r6.getEntranceInfo(), JsonObject.class);
        if (r55 == null) goto L124;
        r55.addProperty("display_rank", r26);
    L124:
        if (r28 == null) goto L131;
        Iterator r3 = r28.entrySet().iterator();
    L127:
        if (r3.hasNext() == false) goto L131;
        Map.Entry r111 = (Map.Entry) r3.next();
        if (r55 == null) goto L127;
        r55.addProperty((String) r111.getKey(), (String) r111.getValue());
    L131:
        if (r55 == null) goto L133;
        String r4 = r55.toString();
    L134:
        r9.o = r4;
        String r5 = r6.getEntranceInfo();
        if (r5 == null) goto L139;
        JSONObject r56 = com.bytedance.android.ec.core.utils.z1.g(r5);
        if (r56 == null) goto L139;
        r9.q = r56.optString("carrier_source", "");
        r9.p = r56.optString("source_method", "");
        r9.R = r56.optString("search_params", "");
        r9.s = r56.optString("previous_page", "");
        r9.P0 = r56.optString("product_source_page", "");
    L139:
        r9.appendParam(s0.b(r6.getEntranceInfo()));
        if (r20 == null) goto L152;
        PromotionProductPrivilegesStruct r57 = r20.getPrivilegeInfo();
        if (r57 == null) goto L152;
        PromotionProductActivitiesStruct r58 = r57.getActivities();
        if (r58 == null) goto L152;
        PromotionDepositPresaleActivity r59 = r58.getDepositPresaleActivity();
        if (r59 == null) goto L152;
        AnchorV3PromotionRequestParam r60 = r6.getRequestParam();
        if (r60 == null) goto L150;
        String r61 = r60.getSourcePage();
    L151:
        r9.f = r61;
        r9.X = com.bytedance.android.ec.model.n.a(r59);
        goto L152
    L150:
        r61 = null;
    L152:
        if (r20 == null) goto L156;
        PromotionProductExtraStruct r62 = r20.getExtraInfo();
        if (r62 == null) goto L156;
        PromotionVideoInfo r63 = r62.getProductVideo();
    L157:
        if (r63 == null) goto L159;
        int r64 = 1;
    L160:
        r9.V = Integer.valueOf(r64);
        int r65 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r9.X = com.bytedance.android.shopping.anchorv3.utils.y.f(r20);
        if (r20 == null) goto L163;
        String r66 = tf3.n.a(r20);
    L164:
        r9.p0 = r66;
        r9.b1 = "video";
        if (r20 == null) goto L167;
        ActivityVO r67 = f53.a.c(r20);
    L168:
        if (r67 == null) goto L170;
        String r68 = r67.getActivityName();
    L171:
        r9.Z = r68;
        if (r20 == null) goto L178;
        PromotionProductPrivilegesStruct r69 = r20.getPrivilegeInfo();
        if (r69 == null) goto L178;
        List r70 = r69.getServices();
        if (r70 == null) goto L178;
        String r71 = CollectionsKt.joinToString$default(r70, ",", null, null, 0, null, FeedProductEventTracker$createClickMainProductEvent$1$11.INSTANCE, 30, null);
    L179:
        r9.k0 = r71;
        Pair r72 = com.bytedance.android.shopping.anchorv3.utils.y.n(r6.getCurrentPromotion());
        r9.L0 = (String) r72.getFirst();
        r9.H0 = (String) r72.getSecond();
        ECLogExtraData r73 = r6.getLogExtraData();
        if (r73 == null) goto L182;
        String r74 = r73.getInflowRecommendType();
    L183:
        r9.x1 = r74;
        if (r6.getRequestParam().getSourcePage().equals("ecom_tag") == false) goto L186;
        r9.v = "ecom_tag";
    L186:
        r9.y1 = r24;
        int r1 = com.bytedance.android.shopping.feed.utils.c.a;
        if (r20 == null) goto L189;
        PromotionProductPriceStruct r2 = r20.getProductPrice();
    L190:
        r9.G1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.f(r2));
        if (r20 == null) goto L193;
        PromotionProductPriceStruct r75 = r20.getProductPrice();
    L194:
        r9.H1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.k(r75));
        if (r20 == null) goto L197;
        PromotionProductPriceStruct r76 = r20.getProductPrice();
    L198:
        r9.L1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.j(r76));
        if (r20 == null) goto L201;
        PromotionProductPriceStruct r77 = r20.getProductPrice();
    L202:
        r9.M1 = String.valueOf(com.bytedance.android.shopping.feed.utils.c.g(r77));
        if (r20 == null) goto L205;
        String r78 = com.bytedance.android.shopping.feed.utils.e0.b(r20);
    L206:
        r9.T1 = r78;
        if (r20 == null) goto L209;
        String r79 = com.bytedance.android.shopping.feed.utils.e0.a(r20);
    L210:
        r9.V1 = r79;
        if (r20 == null) goto L213;
        String r80 = r20.getActivityLabel();
    L214:
        r9.b2 = r80;
        if (r20 == null) goto L219;
        PromotionProductExtraStruct r81 = r20.getExtraInfo();
        if (r81 == null) goto L219;
        String r82 = r81.getEntranceInfo();
    L220:
        s0.a(r9, r82);
        if (r25 != null) goto L223;
    L225:
        if (r27 == false) goto L227;
        com.bytedance.android.bst.api.f.f("video_product_list");
        r9.appendParam("bst_tag", null);
    L227:
        if (r28 == null) goto L229;
        r9.appendParam(r28);
    L229:
        if (r20 == null) goto L235;
        PromotionProductPrivilegesStruct r0 = r20.getPrivilegeInfo();
        if (r0 == null) goto L235;
        List r84 = r0.getTagCodeList();
        if (r84 == null) goto L235;
        r8 = CollectionsKt.joinToString$default(r84, ",", null, null, 0, null, null, 62, null);
    L235:
        r9.appendParam("tag_code_list", r8);
        if (r29 == null) goto L238;
        r9.appendParam(r29);
    L238:
        return r9;
    L223:
        if (com.bytedance.android.ec.core.utils.a2.d(r25) == null) goto L225;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r9.appendParam("btm_id", r25, com.bytedance.android.ec.core.event.a.b.a.a);
    L219:
        r82 = null;
        goto L220
    L213:
        r80 = null;
        goto L214
    L209:
        r79 = null;
        goto L210
    L205:
        r78 = null;
        goto L206
    L201:
        r77 = null;
        goto L202
    L197:
        r76 = null;
        goto L198
    L193:
        r75 = null;
        goto L194
    L189:
        r2 = null;
        goto L190
    L182:
        r74 = null;
    L178:
        r71 = null;
        goto L179
    L170:
        r68 = null;
        goto L171
    L167:
        r67 = null;
        goto L168
    L163:
        r66 = null;
        goto L164
    L159:
        r64 = 0;
    L156:
        r63 = null;
        goto L157
    L133:
        r4 = null;
    L120:
        r54 = null;
        goto L121
    L112:
        r51 = "GROUP_BUYING";
    L108:
        r50 = null;
        goto L109
    L99:
        r47 = "1";
    L95:
        r46 = null;
        goto L97
    L89:
        r44 = null;
    L85:
        r42 = null;
        goto L86
    L79:
        r40 = "0";
    L75:
        r39 = null;
    L63:
        r34 = null;
    L18:
        r14 = null;
    L10:
        r11 = null;
        goto L11
    }

    public static void o(FeedProductEventTracker r14, ProductFeedViewModel r15, Context r16, PromotionProductStruct r17, String r18, String r19, boolean r20, String r21, String r22, String r23, boolean r24, Map r25, Map r26, int r27) {
        if ((r27 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r27 & 16) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r27 & 32) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r27 & 128) == 0) goto L17;
        String r9 = "";
    L19:
        if ((r27 & 256) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r27 & 512) == 0) goto L25;
        boolean r11 = false;
    L27:
        if ((r27 & 1024) == 0) goto L29;
        Map r12 = null;
    L31:
        if ((r27 & 2048) == 0) goto L33;
        Map r13 = null;
    L34:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "vm");
        Intrinsics.checkNotNullParameter(r21, "inflowProductCardMode");
        u0 r0 = b(r15, r17, r5, r6, r7, r21, r9, r10, r11, r12, r13);
        if (r0 == null) goto L38;
        com.bytedance.android.shopping.feed.event.g.c(r0, r16, null);
        return;
    L38:
        return;
    L33:
        r13 = r26;
        goto L34
    L29:
        r12 = r25;
        goto L31
    L25:
        r11 = r24;
        goto L27
    L21:
        r10 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }
}
