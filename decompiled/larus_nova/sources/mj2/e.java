package mj2;

import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.BizExtendParam;
import com.bytedance.android.ec.model.response.b1;
import com.bytedance.android.ec.model.response.w;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionListABConfig;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageBottomData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageDynamicOpenRegion;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHeaderData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHintData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageListTop;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdk.livecommerce.utils.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f514176y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends ql.a> f514177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends ql.a> f514178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ql.a f514179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ql.a f514180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends ql.a> f514181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends ql.a> f514182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<rl.a> f514183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f514184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f514185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LivePromotionPageRoomInfo f514186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LivePromotionListABConfig f514187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ECPromotionListTopData f514188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LivePromotionPageHeaderData f514189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LivePromotionPageListTop f514190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LivePromotionPageHintData f514191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LivePromotionPageCategoryData f514192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LivePromotionPageBottomData f514193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f514194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b1 f514195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f514196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f514197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f514198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LivePromotionPageDynamicOpenRegion f514199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f514200x;

    public static final class a {
        public static e a(vj2.b r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            e r101 = new e();
            List<w> r102 = r100.m();
            ArrayList r103 = null;
            if (r102 == null) goto L10;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r102.iterator();
        L6:
            if (r105.hasNext() == false) goto L11;
            ECUIPromotionV2 r106 = c0.a((w) r105.next(), r100.getLogId());
            if (r106 == null) goto L6;
            r104.add(r106);
        L11:
            r101.f514177a = r104;
            List<w> r107 = r100.r();
            if (r107 == null) goto L19;
            ArrayList r108 = new ArrayList();
            Iterator<T> r109 = r107.iterator();
        L15:
            if (r109.hasNext() == false) goto L20;
            ECUIPromotionV2 r110 = c0.a((w) r109.next(), r100.getLogId());
            if (r110 == null) goto L15;
            r108.add(r110);
        L20:
            r101.f514178b = r108;
            w r111 = r100.s();
            if (r111 == null) goto L23;
            ECUIPromotionV2 r112 = c0.a(r111, r100.getLogId());
        L24:
            r101.f514179c = r112;
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L47;
            List<w> r113 = r100.p();
            if (r113 != null) goto L29;
        L31:
            w r114 = r100.o();
            if (r114 == null) goto L34;
            List<w> r115 = CollectionsKt.listOf(r114);
        L35:
            if (r115 == null) goto L45;
            ArrayList r116 = new ArrayList();
            Iterator<T> r117 = r115.iterator();
        L38:
            if (r117.hasNext() == false) goto L46;
            ECUIPromotionV2 r118 = c0.a((w) r117.next(), r100.getLogId());
            if (r118 == null) goto L42;
            r118.setRelatedInfo(true);
        L43:
            if (r118 == null) goto L38;
            r116.add(r118);
            goto L38
        L42:
            r118 = null;
        L46:
            r101.f514181e = r116;
        L50:
            List<w> r119 = r100.n();
            if (r119 == null) goto L75;
            ArrayList r120 = new ArrayList();
            Iterator<T> r121 = r119.iterator();
        L54:
            if (r121.hasNext() == false) goto L65;
            Object r122 = r121.next();
            BizExtendParam r123 = ((w) r122).b();
            boolean r124 = false;
            if (r123 == null) goto L60;
            Integer r125 = r123.getDynamicRecommendIndex();
            if (r125 == null) goto L60;
            int r126 = r125.intValue();
        L61:
            if (r126 <= 0) goto L63;
            r124 = true;
        L63:
            if (r124 == false) goto L54;
            r120.add(r122);
        L60:
            r126 = 0;
            goto L61
        L65:
            ArrayList r127 = new ArrayList();
            Iterator r128 = r120.iterator();
        L67:
            if (r128.hasNext() == false) goto L74;
            ECUIPromotionV2 r129 = c0.a((w) r128.next(), r100.getLogId());
            if (r129 == null) goto L71;
            r129.setRelatedInfo(true);
        L72:
            if (r129 == null) goto L67;
            r127.add(r129);
            goto L67
        L71:
            r129 = null;
            goto L72
        L74:
            r103 = r127;
        L75:
            r101.f514182f = r103;
            r101.f514183g = r100.e();
            r101.f514184h = r100.t();
            r101.f514185i = r100.i();
            r101.f514186j = r100.q();
            r101.f514187k = r100.a();
            if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == true) goto L78;
            r101.f514188l = r100.u();
        L78:
            r101.f514189m = r100.f();
            r101.f514190n = r100.h();
            r101.f514191o = r100.g();
            r101.f514192p = r100.c();
            r101.f514193q = r100.b();
            r101.f514196t = r100.getLogId();
            r101.f514194r = r100.j();
            r101.f514195s = r100.k();
            r101.f514199w = r100.d();
            return r101;
        L45:
            r116 = null;
            goto L46
        L34:
            r115 = null;
            goto L35
        L29:
            if ((!r113.isEmpty()) != true) goto L31;
            r115 = r100.p();
            goto L35
        L47:
            ECUIPromotionV2 r130 = c0.a(r100.o(), r100.getLogId());
            r101.f514180d = r130;
            if (r130 == null) goto L50;
            r130.setRelatedInfo(true);
            goto L50
        L23:
            r112 = null;
            goto L24
        L19:
            r108 = null;
            goto L20
        L10:
            r104 = null;
            goto L11
        }
    }

    static {
    }

    public e() {
    }
}
