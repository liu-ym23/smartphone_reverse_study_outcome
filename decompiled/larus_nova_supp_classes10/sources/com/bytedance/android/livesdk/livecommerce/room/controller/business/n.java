package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.p1;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.ECLiveSliceHelper;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends c0 {
    public static final /* synthetic */ int o = 0;
    public ECUIPromotion c;
    public long d;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c e;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o f;
    public com.bytedance.android.livesdk.livecommerce.intro.message.a g;
    public cf.d h;
    public com.bytedance.android.livesdk.livecommerce.intro.manager.c i;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a j;
    public uk2.b k;
    public final List<cf.g> l;
    public boolean m;
    public final com.bytedance.android.livesdk.livecommerce.kmp.a n;

    public static final class a {
        @JvmStatic
        public static n a(String r0, String r1) {
            n r2 = ControllerCenter.c(r0, r1).q;
            Objects.toString(r2);
            return r2;
        }
    }

    public static final class b implements v0<ECPromotion> {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;

        @Override // vi2.v0
        public final void onError(Throwable r1) {
        }

        @Override // vi2.v0
        public final void onSuccess(ECPromotion r6) {
            ECPromotion r7 = r6;
            if (TextUtils.equals(this.b, this.a.B()) == false) goto L6;
            n r0 = this.a;
            Handler r1 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
            r0.c = com.bytedance.android.livesdk.livecommerce.utils.k.d(r7, com.bytedance.android.livesdk.livecommerce.room.f.a(), 0, Boolean.TRUE);
            n r8 = this.a;
            r8.d = SystemClock.elapsedRealtime();
            return;
        }

        public b(n r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        if (this.n == null) goto L6;
        ECLiveSliceHelper.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void G() {
        if (s() == true) goto L5;
    L9:
        this.c = null;
        this.d = 0;
        uk2.b r1 = this.k;
        if (r1 == null) goto L12;
        r1.clear();
    L12:
        this.k = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r2 = this.j;
        if (r2 == null) goto L15;
        r2.o();
    L15:
        this.j = null;
        return;
    L5:
        if (this.c == null) goto L9;
        if (this.d <= 0) goto L9;
        String r4 = B();
        String r5 = y();
        ECUIPromotion r3 = this.c;
        Intrinsics.checkNotNull(r3);
        String r6 = r3.getPromotionId();
        ECUIPromotion r7 = this.c;
        Intrinsics.checkNotNull(r7);
        String r8 = r7.getEventItemType();
        long r9 = this.d;
        Handler r10 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new p1(r4, r5, r6, r8, SystemClock.elapsedRealtime() - r9).k();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        this.f = null;
        this.e = null;
        this.g = null;
        this.h = null;
        uk2.b r1 = this.k;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        this.k = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r2 = this.j;
        if (r2 == null) goto L8;
        r2.o();
    L8:
        this.j = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        this.m = true;
    }

    public n(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
        this.l = new ArrayList();
        this.m = true;
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.kmp.a r3 = new com.bytedance.android.livesdk.livecommerce.kmp.a();
    L6:
        this.n = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void I(boolean r21) {
        if (s() == true) goto L5;
        return;
    L5:
        if (this.c != null) goto L7;
    L9:
        this.c = null;
        this.d = 0;
        if (r21 == false) goto L20;
        String r2 = y();
        String r3 = z();
        String r15 = B();
        CompositeDisposable r4 = CoreRequests.a;
        b r13 = new b(this, r15);
        ECEventUtilsV2.b.getClass();
        vi2.h.l(r2, r3, r15, null, ECEventUtilsV2.a(BDLocationException.ERROR_TIMEOUT), null, false, false, false, false, null, null, false, null, null).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.room.controller.j(r13), new com.bytedance.android.livesdk.livecommerce.room.controller.k(r13));
        com.bytedance.android.livesdk.livecommerce.event.o r1 = new com.bytedance.android.livesdk.livecommerce.event.o();
        PromotionListController.T.getClass();
        fh2.a r5 = PromotionListController.a.b(r15, null);
        if (r5 == null) goto L16;
        int r6 = 1;
        if (((LivePromotionListFragment) r5).p() != true) goto L16;
    L17:
        r1.d("list_is_show", r6);
        r1.k();
        return;
    L16:
        r6 = 0;
        goto L17
    L20:
        return;
    L7:
        if (this.d <= 0) goto L9;
        String r7 = B();
        String r8 = y();
        ECUIPromotion r9 = this.c;
        Intrinsics.checkNotNull(r9);
        String r10 = r9.getPromotionId();
        ECUIPromotion r11 = this.c;
        Intrinsics.checkNotNull(r11);
        String r12 = r11.getEventItemType();
        long r14 = this.d;
        Handler r16 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new p1(r7, r8, r10, r12, SystemClock.elapsedRealtime() - r14).k();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.n == null) goto L6;
        ECLiveSliceHelper.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        super.c(r1, r2);
    }

    public static void H(n r8, ql.a r9, String r10, String r11) {
        ak2.m r3 = r8.A().t.F;
        if (r3 == null) goto L31;
        if (r9 == null) goto L32;
        String r4 = r9.getEventItemType();
        if (r4 != null) goto L8;
        r4 = "-1";
    L8:
        JSONObject r5 = new JSONObject();
        r5.put("anchor_id", r8.y());     // Catch: Exception -> L20
        if (hh2.f.e() == false) goto L12;
        r5.put("anchor_open_id", r8.y());     // Catch: Exception -> L20
    L12:
        r5.put("room_id", r8.B());     // Catch: Exception -> L20
        r5.put("commodity_id", r9.getPromotionId());     // Catch: Exception -> L20
        r5.put("commodity_type", r4);     // Catch: Exception -> L20
        String r12 = r9.getPrice();     // Catch: Exception -> L20
        if (r12 == null) goto L17;
        Float r13 = StringsKt.toFloatOrNull(r12);     // Catch: Exception -> L20
        if (r13 == null) goto L17;
        float r14 = r13.floatValue();     // Catch: Exception -> L20
    L18:
        r5.put("commodity_price", (int) (r14 * 100));     // Catch: Exception -> L20
        r5.put("go_to_tag", r11);     // Catch: Exception -> L20
        r5.put("screen_type", l0.m(null, null));     // Catch: Exception -> L20
        r5.put("action_type", l0.i("action_type"));     // Catch: Exception -> L20
        r5.put("enter_from_merge", l0.i("enter_from_merge"));     // Catch: Exception -> L20
        r5.put("enter_method", l0.i("enter_method"));     // Catch: Exception -> L20
    L22:
        r3.onClickPromotion("live_ad", "click_product", r10, r5);
        if (r8.C().u == false) goto L26;
        r3.onClickPromotion("detail_ad", "click", "", r5);
    L26:
        if ((!Intrinsics.areEqual("short_half_screen_card", r11)) == false) goto L33;
        r3.onClickPromotion("live_ad", "live_click_buy_right_now", r10, r5);
        return;
    L33:
        return;
    L17:
        r14 = 0.0f;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L32:
        return;
    }
}
