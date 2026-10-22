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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public static final /* synthetic */ int y = 0;
    public List<? extends ql.a> a;
    public List<? extends ql.a> b;
    public ql.a c;
    public ql.a d;
    public List<? extends ql.a> e;
    public List<? extends ql.a> f;
    public List<rl.a> g;
    public int h;
    public int i;
    public LivePromotionPageRoomInfo j;
    public LivePromotionListABConfig k;
    public ECPromotionListTopData l;
    public LivePromotionPageHeaderData m;
    public LivePromotionPageListTop n;
    public LivePromotionPageHintData o;
    public LivePromotionPageCategoryData p;
    public LivePromotionPageBottomData q;
    public f r;
    public b1 s;
    public String t;
    public boolean u;
    public boolean v;
    public LivePromotionPageDynamicOpenRegion w;
    public g x;

    public static final class a {
        public static e a(vj2.b r8) {
            Intrinsics.checkNotNullParameter(r8, "response");
            e r0 = new e();
            List<w> r1 = r8.m();
            ArrayList r2 = null;
            if (r1 == null) goto L10;
            ArrayList r3 = new ArrayList();
            Iterator<T> r4 = r1.iterator();
        L6:
            if (r4.hasNext() == false) goto L11;
            ECUIPromotionV2 r5 = c0.a((w) r4.next(), r8.getLogId());
            if (r5 == null) goto L6;
            r3.add(r5);
        L11:
            r0.a = r3;
            List<w> r6 = r8.r();
            if (r6 == null) goto L19;
            ArrayList r7 = new ArrayList();
            Iterator<T> r9 = r6.iterator();
        L15:
            if (r9.hasNext() == false) goto L20;
            ECUIPromotionV2 r10 = c0.a((w) r9.next(), r8.getLogId());
            if (r10 == null) goto L15;
            r7.add(r10);
        L20:
            r0.b = r7;
            w r11 = r8.s();
            if (r11 == null) goto L23;
            ECUIPromotionV2 r12 = c0.a(r11, r8.getLogId());
        L24:
            r0.c = r12;
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L47;
            List<w> r13 = r8.p();
            if (r13 != null) goto L29;
        L31:
            w r14 = r8.o();
            if (r14 == null) goto L34;
            List<w> r15 = CollectionsKt.listOf(r14);
        L35:
            if (r15 == null) goto L45;
            ArrayList r16 = new ArrayList();
            Iterator<T> r17 = r15.iterator();
        L38:
            if (r17.hasNext() == false) goto L46;
            ECUIPromotionV2 r18 = c0.a((w) r17.next(), r8.getLogId());
            if (r18 == null) goto L42;
            r18.setRelatedInfo(true);
        L43:
            if (r18 == null) goto L38;
            r16.add(r18);
            goto L38
        L42:
            r18 = null;
        L46:
            r0.e = r16;
        L50:
            List<w> r19 = r8.n();
            if (r19 == null) goto L75;
            ArrayList r20 = new ArrayList();
            Iterator<T> r21 = r19.iterator();
        L54:
            if (r21.hasNext() == false) goto L65;
            Object r22 = r21.next();
            BizExtendParam r23 = ((w) r22).b();
            boolean r24 = false;
            if (r23 == null) goto L60;
            Integer r25 = r23.getDynamicRecommendIndex();
            if (r25 == null) goto L60;
            int r26 = r25.intValue();
        L61:
            if (r26 <= 0) goto L63;
            r24 = true;
        L63:
            if (r24 == false) goto L54;
            r20.add(r22);
        L60:
            r26 = 0;
            goto L61
        L65:
            ArrayList r27 = new ArrayList();
            Iterator r28 = r20.iterator();
        L67:
            if (r28.hasNext() == false) goto L74;
            ECUIPromotionV2 r29 = c0.a((w) r28.next(), r8.getLogId());
            if (r29 == null) goto L71;
            r29.setRelatedInfo(true);
        L72:
            if (r29 == null) goto L67;
            r27.add(r29);
            goto L67
        L71:
            r29 = null;
            goto L72
        L74:
            r2 = r27;
        L75:
            r0.f = r2;
            r0.g = r8.e();
            r0.h = r8.t();
            r0.i = r8.i();
            r0.j = r8.q();
            r0.k = r8.a();
            if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == true) goto L78;
            r0.l = r8.u();
        L78:
            r0.m = r8.f();
            r0.n = r8.h();
            r0.o = r8.g();
            r0.p = r8.c();
            r0.q = r8.b();
            r0.t = r8.getLogId();
            r0.r = r8.j();
            r0.s = r8.k();
            r0.w = r8.d();
            return r0;
        L45:
            r16 = null;
            goto L46
        L34:
            r15 = null;
            goto L35
        L29:
            if ((!r13.isEmpty()) != true) goto L31;
            r15 = r8.p();
            goto L35
        L47:
            ECUIPromotionV2 r30 = c0.a(r8.o(), r8.getLogId());
            r0.d = r30;
            if (r30 == null) goto L50;
            r30.setRelatedInfo(true);
            goto L50
        L23:
            r12 = null;
            goto L24
        L19:
            r7 = null;
            goto L20
        L10:
            r3 = null;
            goto L11
        }
    }

    static {
    }

    public e() {
    }
}
