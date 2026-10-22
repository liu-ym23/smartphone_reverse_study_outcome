package vi2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o0 implements h.f<vj2.b> {
    public final /* synthetic */ String A;
    public final /* synthetic */ String B;
    public final /* synthetic */ uj2.c C;
    public final /* synthetic */ String D;
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ int n;
    public final /* synthetic */ String o;
    public final /* synthetic */ int p;
    public final /* synthetic */ boolean q;
    public final /* synthetic */ int r;
    public final /* synthetic */ int s;
    public final /* synthetic */ int t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ String w;
    public final /* synthetic */ String x;
    public final /* synthetic */ boolean y;
    public final /* synthetic */ boolean z;

    @Override // vi2.h.f
    public final wi2.a<vj2.b> execute() throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        String r1 = this.a;
        int r2 = si2.k.c;
        r0.add(si2.k.a.a("room_unique_key", r1));
        if (hh2.f.g() == false) goto L5;
        String r3 = "author_open_id";
    L6:
        r0.add(si2.k.a.a(r3, this.b));
        r0.add(si2.k.a.a("sec_author_id", this.c));
        r0.add(si2.k.a.a("room_id", this.a));
        r0.add(si2.k.a.a("container_room_id", this.d));
        r0.add(si2.k.a.a("is_linkmic", String.valueOf(this.e)));
        r0.add(si2.k.a.a("unique_index", this.f));
        r0.add(si2.k.a.a("entrance_info", this.g));
        r0.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r0.add(si2.k.a.a("force_refresh", String.valueOf(this.h)));
        String r4 = "1";
        if (this.i == false) goto L9;
        String r5 = "1";
    L10:
        r0.add(si2.k.a.a("close_order_banner", r5));
        if (this.j == true) goto L14;
        r4 = BDLocationException.ERROR_TIMEOUT;
    L14:
        r0.add(si2.k.a.a("use_recommend_store", r4));
        r0.add(si2.k.a.a(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, String.valueOf(this.k)));
        r0.add(si2.k.a.a("limit", String.valueOf(this.l)));
        r0.add(si2.k.a.a("recommended_product_displayed", String.valueOf(this.m)));
        r0.add(si2.k.a.a("request_scene", String.valueOf(this.n)));
        r0.add(si2.k.a.a("recommended_ab_tag", this.o));
        r0.add(si2.k.a.a("use_promotion_v2", String.valueOf(true)));
        int r6 = this.p;
        if (r6 <= 0) goto L17;
        r0.add(si2.k.a.a("apply_coupon", String.valueOf(r6)));
    L18:
        r0.add(si2.k.a.a("height_percent", String.valueOf(this.r)));
        int r7 = this.s;
        if (r7 == 0) goto L21;
        r0.add(si2.k.a.a("open_panel", String.valueOf(r7)));
    L21:
        r0.add(si2.k.a.a("open_cart", String.valueOf(this.t)));
        String r8 = this.a;
        String r9 = this.u;
        boolean r10 = EntryController.M1;
        String r11 = EntryController.a.b(r8, r9).M().f(IRelatedInfoManager$Scene.PROMOTION_LIST);
        int r12 = xh2.c.a;
        String r13 = null;
        if (xh2.c.a(this.h) == false) goto L27;
        String r14 = this.v;
        if (r14 == null) goto L27;
        r11 = r14;
    L33:
        if (TextUtils.isEmpty(this.w) == true) goto L38;
        if (TextUtils.isEmpty(this.x) == true) goto L38;
        JSONObject r15 = com.bytedance.android.shopping.extensions.k.u(r11);
        r15.put("recommend_product_id", this.w);
        r15.put("recommend_promotion_id", this.x);
        r0.add(si2.k.a.a("related_info", r15.toString()));
    L41:
        if (this.y == true) goto L43;
        r0.add(si2.k.a.a("enable_ab_opt", String.valueOf(EComABUtils.enableListAbOpt())));
    L43:
        r0.add(si2.k.a.a("routine_optimize", String.valueOf(EComABUtils.enableServerRoutineOpt())));
        r0.add(si2.k.a.a("routine_optimize_reverse_step", String.valueOf(EComABUtils.serverRoutineReverseStep())));
        String r16 = this.a;
        String r17 = this.u;
        PromotionListController.T.getClass();
        String r18 = PromotionListController.a.c(r16, r17).Q;
        if (TextUtils.isEmpty(r18) == true) goto L46;
        r0.add(si2.k.a.a("header_callback", r18));
    L46:
        ECLiveABUtils r19 = ECLiveABUtils.INSTANCE;
        if (r19.getEC_LIVE_SPLIT_PROMOTION_LIST_REQUEST().booleanValue() == false) goto L49;
        r0.add(si2.k.a.a("is_in_split", String.valueOf(this.z)));
    L49:
        String r20 = this.A;
        if (r20 == null) goto L52;
        r0.add(si2.k.a.a("cart_icon_related_info", r20));
    L52:
        r0.add(si2.k.a.a("preferred_coupon", this.B));
        Map<String, String> r21 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        if (r19.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L55;
    L57:
        SsResponse r22 = h.h(this.D, r0);
        if (r19.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L62;
        uj2.c r23 = this.C;
        if (r23 == null) goto L62;
        r23.b(Integer.valueOf(r22.code()));
    L62:
        vj2.b r24 = (vj2.b) h.j(r22, vj2.b.class);
        com.bytedance.android.livesdk.livecommerce.network.hook.c r25 = com.bytedance.android.livesdk.livecommerce.network.hook.c.a;
        String r26 = this.a;
        String r27 = this.u;
        Intrinsics.checkNotNullParameter(r26, "roomId");
        Intrinsics.checkNotNullParameter(r27, "roomUniqueKey");
        if (r24 != null) goto L66;
    L82:
        if (r24 == null) goto L87;
        if (r24.getLogId() == null) goto L87;
        com.bytedance.android.livesdk.livecommerce.utils.k.k(r24.l(), r24.getLogId());
    L87:
        return h.f(r24, r21, r22);
    L66:
        if (((com.bytedance.android.ec.model.g) r24).statusCode != 0) goto L82;
        LivePromotionPageRoomInfo r28 = r24.q();
        if (r28 == null) goto L70;
        long r29 = r28.getVirtualRoomId();
        int r30 = com.bytedance.android.livesdk.livecommerce.messagev2.a.k;
        ControllerCenter.c(r26, r27).n.H(r29);
    L70:
        LivePromotionPageRoomInfo r31 = r24.q();
        if (r31 == null) goto L73;
        String r32 = r31.getAddressType();
    L74:
        LivePromotionPageRoomInfo r33 = r24.q();
        if (r33 == null) goto L77;
        String r34 = r33.getReceiveAddressId();
    L78:
        LivePromotionPageRoomInfo r35 = r24.q();
        if (r35 == null) goto L81;
        r13 = r35.getAddressStrategy();
    L81:
        com.bytedance.android.livesdk.livecommerce.network.hook.c.c(r34, r32, r13);
        goto L82
    L77:
        r34 = null;
        goto L78
    L73:
        r32 = null;
        goto L74
    L55:
        if (this.C == null) goto L57;
        int r36 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a;
        this.C.a(com.bytedance.android.livesdk.livecommerce.network.hook.a.a(this.D, r0));
    L38:
        if (TextUtils.isEmpty(r11) == true) goto L41;
        r0.add(si2.k.a.a("related_info", r11));
    L27:
        if (TextUtils.isEmpty(this.a) == false) goto L29;
    L31:
        r11 = null;
        goto L33
    L29:
        if (TextUtils.isEmpty(r11) == true) goto L31;
    L17:
        r0.add(si2.k.a.a("auto_apply_coupon", String.valueOf(this.q)));
        goto L18
    L9:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r3 = "author_id";
        goto L6
    }

    public o0(String r3, String r4, String r5, String r6, boolean r7, String r8, String r9, int r10, boolean r11, boolean r12, int r13, int r14, boolean r15, int r16, String r17, int r18, boolean r19, int r20, int r21, int r22, String r23, String r24, String r25, String r26, boolean r27, boolean r28, String r29, String r30, uj2.a r31, String r32) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
    }
}
