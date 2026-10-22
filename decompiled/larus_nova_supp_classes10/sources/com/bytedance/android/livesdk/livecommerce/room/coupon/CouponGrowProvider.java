package com.bytedance.android.livesdk.livecommerce.room.coupon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.event.j0;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEnterRequestData;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import vi2.v0;
import xi2.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CouponGrowProvider {
    public static final CouponGrowProvider f = null;
    public static final int g = 0;
    public static final long h = 0;
    public static final long i = 0;
    public static final String j = null;
    public static final Map<String, Long> k = null;
    public static final Companion l = null;
    public c a;
    public final Map<String, a> b;
    public String c;
    public b d;
    public JSONObject e;

    public static final class Companion {

        public static final class a implements v0<s> {
            public final /* synthetic */ Ref.ObjectRef a;
            public final /* synthetic */ Function0 b;

            @Override // vi2.v0
            public final void onError(Throwable r4) {
                i.a.e(ECAppInfoService.e.getApplicationContext(), "网络异常，券领取失败", false, false);
                CouponGrowProvider.l.getClass();
                Companion.a("ac-fail");
            }

            @Override // vi2.v0
            public final void onSuccess(s r5) {
                s r6 = r5;
                boolean r0 = false;
                if (r6 == null) goto L14;
                ECEnterRequestData r7 = r6.a();
                if (r7 == null) goto L14;
                String r8 = r7.getToast();
                if (r8 == null) goto L14;
                HashMap r1 = j.a;
                if (j.e(r8) == true) goto L12;
                r8 = null;
            L12:
                if (r8 == null) goto L14;
                i.a.e(ECAppInfoService.e.getApplicationContext(), r8, false, false);
            L14:
                Companion r9 = CouponGrowProvider.l;
                String r2 = (String) this.a.element;
                r9.getClass();
                if (r2 != null) goto L29;
            L24:
                Function0 r10 = this.b;
                if (r10 == null) goto L27;
                Unit r11 = (Unit) r10.invoke();
            L27:
                CouponGrowProvider.l.getClass();
                Companion.a("ac-succ");
                return;
            L29:
            L22:
                th = move-exception;
                ECExceptionMonitor.e(th);
                goto L24
            L17:
                if (r2.length() <= 0) goto L19;
                r0 = true;
            L19:
                if (r0 == false) goto L24;
                q.a.c(CouponGrowProvider.j + r2, true);     // Catch: Throwable -> L22
                goto L24
            }

            public a(Ref.ObjectRef r1, Function0 r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class b implements ih2.d.a {
            public final /* synthetic */ ih2.d a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ JSONObject c;
            public final /* synthetic */ String d;
            public final /* synthetic */ PromotionListController e;

            @Override // ih2.d.a
            public final void b() {
                j0 r0 = new j0("livesdk_coupon_expansion_task_click");
                HashMap r1 = new HashMap();
                r1.put("button_type", "reject");
                r0.n(r1);
                r0.k();
                Companion.h(CouponGrowProvider.l, this.b, this.c, this.d, false, 24);
                ih2.d r2 = this.a;
                r2.getClass();
                ih2.d.a(r2);     // Catch: Throwable -> L5
                return;
            }

            @Override // ih2.d.a
            public final void a(long r13) {
                CouponGrowProvider.l.getClass();
                Companion.a("entogro");
                j0 r0 = new j0("livesdk_coupon_expansion_task_click");
                HashMap r1 = new HashMap();
                r1.put("button_type", "accept");
                r0.n(r1);
                r0.k();
                CouponGrowProvider r2 = CouponGrowProvider.f;
                Context r3 = this.b;
                JSONObject r4 = this.c;
                String r5 = this.d;
                PromotionListController r11 = this.e;
                r2.getClass();
                Intrinsics.checkNotNullParameter(r3, "context");
                Intrinsics.checkNotNullParameter(r4, "ecomLiveParam");
                Intrinsics.checkNotNullParameter(r5, "roomId");
                Intrinsics.checkNotNullParameter(r11, "listController");
                if (r13 <= 0) goto L6;
                r2.c = r5;
                long r8 = r13 * CouponGrowProvider.i;
                long r14 = System.currentTimeMillis() + r8;
                CouponGrowProvider.k.put(r5, Long.valueOf(r14));
                r2.e = r4;
                r2.c(r3, r4, r5, r8, r11);
                r2.a(r3, r5, r4, r11);
            L6:
                i.a.e(this.b, "已接受券膨胀任务，计时开始～", false, false);
                ih2.d r15 = this.a;
                r15.getClass();
                ih2.d.a(r15);     // Catch: Throwable -> L9
                return;
            }

            public b(ih2.d r1, Context r2, JSONObject r3, String r4, PromotionListController r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }
        }

        public static final class c implements DialogInterface.OnCancelListener {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface r4) {
                j0 r5 = new j0("livesdk_coupon_expansion_task_click");
                HashMap r0 = new HashMap();
                r0.put("button_type", "cancel");
                r5.n(r0);
                r5.k();
            }
        }

        public static final class d implements ih2.h.a {
            public final /* synthetic */ ih2.h a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ String c;
            public final /* synthetic */ JSONObject d;
            public final /* synthetic */ Runnable e;
            public final /* synthetic */ PromotionListController f;

            @Override // ih2.h.a
            public final void a() {
                j0 r0 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r1 = new HashMap();
                r1.put("button_type", "keep");
                r0.n(r1);
                r0.k();
                ih2.h r2 = this.a;
                r2.getClass();
                ih2.h.a(r2);     // Catch: Throwable -> L5
                return;
            }

            @Override // ih2.h.a
            public final void b() {
                j0 r0 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r1 = new HashMap();
                r1.put("button_type", "use");
                r0.n(r1);
                r0.k();
                ih2.h r2 = this.a;
                r2.getClass();
                ih2.h.a(r2);     // Catch: Throwable -> L6
            L4:
                Companion r3 = CouponGrowProvider.l;
                Context r4 = this.b;
                JSONObject r5 = this.d;
                String r6 = this.c;
                PromotionListController r7 = this.f;
                r3.getClass();
                Companion.f(r4, r5, r6, true, r7);
            }

            @Override // ih2.h.a
            public final void onDismiss() {
                int r0 = RoomContextController.h;     // Catch: Throwable -> L6
                if (RoomContextController.a.a().M() == false) goto L9;
                Companion.h(CouponGrowProvider.l, this.b, this.d, this.c, true, 16);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            }

            @Override // ih2.h.a
            public final void onExitRoom() {
                j0 r0 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r1 = new HashMap();
                r1.put("button_type", "sign_out");
                r0.n(r1);
                r0.k();
                ih2.h r2 = this.a;
                r2.getClass();
                ih2.h.a(r2);     // Catch: Throwable -> L5
            L6:
                Runnable r3 = this.e;
                if (r3 == null) goto L12;
                r3.run();
                return;
            }

            public d(ih2.h r1, Context r2, String r3, JSONObject r4, Runnable r5, PromotionListController r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }
        }

        public static final class e implements DialogInterface.OnCancelListener {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface r4) {
                j0 r5 = new j0("livesdk_chest_keep_popup_coupon_click");
                HashMap r0 = new HashMap();
                r0.put("button_type", "cancel");
                r5.n(r0);
                r5.k();
            }
        }

        public static final class f implements zk.b {
            public f() {
            }

            public final String entryName() {
                return "live_list_channel";
            }

            public final String getCouponId() {
                return null;
            }
        }

        public Companion() {
        }

        public static void a(String r1) {
            dm.a.b r0 = dm.a.a("lqmt");
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.a(r1);
        }

        public static long b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "roomId");
            Long r5 = (Long) ((LinkedHashMap) CouponGrowProvider.k).get(r4);
            if (r5 == null) goto L9;
            long r0 = r5.longValue();
            if (r0 <= CouponGrowProvider.h) goto L8;
            r0 = r0 - System.currentTimeMillis();
        L8:
            return r0 / CouponGrowProvider.i;
        L9:
            return 0;
        }

        public static JSONObject c(JSONObject r5) {
            JSONArray r6 = r5.optJSONArray("incr_coupon");
            if (r6 == null) goto L11;
            int r0 = r6.length();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L11;
            JSONObject r2 = r6.optJSONObject(r1);
            if (JSONObjectProtectorUtils.getInt(r2, "interaction_type") == 1) goto L15;
            r1 = r1 + 1;
            goto L6
        L15:
            return r2;
        L11:
            return null;
        }

        public static boolean d(String r4) {
            if (r4 != null) goto L14;
        L13:
            return false;
        L14:
        L11:
            th = move-exception;
            ECExceptionMonitor.e(th);
            goto L13
        L5:
            if (r4.length() <= 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == false) goto L13;
            return q.a.getBoolean(CouponGrowProvider.j + r4, false);
        L7:
            r1 = false;
            goto L8
        }

        public static boolean e(JSONObject r10) {
            if (r10 != null) goto L23;
        L21:
            return false;
        L23:
            int r1 = r10.optInt("activity_type");     // Catch: Throwable -> L22
            JSONArray r11 = r10.optJSONArray("incr_coupon");     // Catch: Throwable -> L22
            if (r11 != null) goto L8;
            return false;
        L8:
            if (r1 == CouponGrowProvider.g) goto L10;
            return false;
        L10:
            int r2 = r11.length();     // Catch: Throwable -> L22
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L21;
            JSONObject r4 = r11.optJSONObject(r3);     // Catch: Throwable -> L22
            if (Intrinsics.areEqual(r4.get("interaction_type"), 1) == false) goto L20;
            if (r4.optLong("task_time") <= 0) goto L20;
            if (r4.optLong("value") <= 0) goto L20;
            return true;
        L20:
            r3 = r3 + 1;
            goto L11
        }

        public static void k(Context r11, String r12, PromotionListController r13) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "roomId");
            Intrinsics.checkNotNullParameter(r13, "listController");
            int r0 = RoomContextController.h;     // Catch: Exception -> L7
            if (Intrinsics.areEqual(RoomContextController.a.a().B(), r12) == false) goto L12;
            PromotionListController.a r1 = PromotionListController.T;     // Catch: Exception -> L7
            String r14 = r13.D();     // Catch: Exception -> L7
            r1.getClass();     // Catch: Exception -> L7
            PromotionListController.N(PromotionListController.a.c(r12, r14), r11, "live_list_channel", new f(), null, false, null, null, null, 248);     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }

        public static void f(final Context r11, final JSONObject r12, final String r13, final boolean r14, final PromotionListController r15) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "ecomLiveParam");
            Intrinsics.checkNotNullParameter(r13, "roomId");
            Intrinsics.checkNotNullParameter(r15, "listController");
            int r0 = RoomContextController.h;
            if (RoomContextController.a.a().M() == false) goto L6;
            g(r11, r12, r13, true, new CouponGrowProvider$Companion$processApplyCoupon$1(r14, r11, r13, r15));
            return;
        L6:
            if ((r11 instanceof Activity) == false) goto L10;
            r.a.showLogin((Activity) r11, "live_detail", "livesdk_click_product", new CouponGrowProvider$Companion$processApplyCoupon$2(r11, r12, r13, r14, r15), CouponGrowProvider$Companion$processApplyCoupon$3.INSTANCE);
            return;
        }

        public static void g(Context r6, JSONObject r7, String r8, boolean r9, Function0 r10) {
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r8, "roomId");
            if (r7 == null) goto L32;
            String r11 = r7.optString("host");     // Catch: Throwable -> L27
            HashMap r0 = j.a;     // Catch: Throwable -> L27
            LinkedHashMap r1 = null;
            if (j.e(r11) == true) goto L8;
            r11 = null;
        L8:
            if (r11 != null) goto L10;
            r11 = si2.g.a;     // Catch: Throwable -> L27
        L10:
            String r2 = r7.optString("api");     // Catch: Throwable -> L27
            if (r2 != null) goto L13;
            return;
        L13:
            Ref.ObjectRef r3 = new Ref.ObjectRef();     // Catch: Throwable -> L27
            r3.element = "";     // Catch: Throwable -> L27
            JSONObject r12 = r7.optJSONObject("params");     // Catch: Throwable -> L27
            if (r12 == null) goto L21;
            r3.element = r12.optString("token");     // Catch: Throwable -> L27
            r1 = new LinkedHashMap();     // Catch: Throwable -> L27
            Iterator<String> r4 = r12.keys();     // Catch: Throwable -> L27
        L17:
            if (r4.hasNext() == false) goto L19;
            String r5 = r4.next();     // Catch: Throwable -> L27
            r1.put(r5, r12.optString(r5));     // Catch: Throwable -> L27
            goto L17
        L19:
            if (r9 == false) goto L21;
            JSONArray r13 = new JSONArray();     // Catch: Throwable -> L27
            r13.put(1);     // Catch: Throwable -> L27
            r1.put("completed_interaction_type", r13.toString());     // Catch: Throwable -> L27
        L21:
            Companion r14 = CouponGrowProvider.l;     // Catch: Throwable -> L27
            String r15 = (String) r3.element;     // Catch: Throwable -> L27
            r14.getClass();     // Catch: Throwable -> L27
            if (d(r15) == false) goto L25;
            a("aplyed..");     // Catch: Throwable -> L27
            return;
        L25:
            CompositeDisposable r16 = CoreRequests.a;     // Catch: Throwable -> L27
            CoreRequests.a("https://" + r11 + r2, r8, r1, new a(r3, r10));     // Catch: Throwable -> L27
            return;
        L27:
            th = move-exception;
            ECExceptionMonitor.e(th);
            return;
        }

        public static /* synthetic */ void h(Companion r0, Context r1, JSONObject r2, String r3, boolean r4, int r5) {
            if ((r5 & 8) == 0) goto L5;
            r4 = false;
        L5:
            r0.getClass();
            g(r1, r2, r3, r4, null);
        }

        public static ih2.d i(Context r17, boolean r18, Map r19, String r20, boolean r21, PromotionListController r22) {
            Intrinsics.checkNotNullParameter(r17, "context");
            Intrinsics.checkNotNullParameter(r19, "ecomParams");
            Intrinsics.checkNotNullParameter(r20, "roomId");
            Intrinsics.checkNotNullParameter(r22, "listController");
            a("enst");
            if (r18 == true) goto L6;
            a("en-" + r18);
            return null;
        L6:
            if (r21 == true) goto L9;
            a("ennofir");
            return null;
        L9:
            int r0 = RoomContextController.h;
            if (RoomContextController.a.a().M() == true) goto L13;
            a("enunaut");
            return null;
        L13:
            HashMap r1 = j.a;
            JSONObject r6 = j.i((String) r19.get("enter_request"));
            CouponGrowProvider.l.getClass();
            if (e(r6) == true) goto L17;
            a("ennogro");
            return null;
        L17:
            a("enprepup..");
            if (r6 == null) goto L35;
            JSONObject r2 = r6.optJSONObject("params");
            if (r2 == null) goto L35;
            if (d(r2.optString("token")) == false) goto L25;
            a("enaplyed");
            return null;
        L25:
            final ih2.d r7 = new ih2.d(r17);
            JSONObject r3 = c(r6);     // Catch: Throwable -> L36
            if (r3 == null) goto L33;
            JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r6, "params");     // Catch: Throwable -> L36
            long r9 = r4.optLong("coupon_amount");     // Catch: Throwable -> L36
            long r11 = r4.optLong("coupon_threshold");     // Catch: Throwable -> L36
            long r13 = r3.optLong("value");     // Catch: Throwable -> L36
            long r15 = r3.optLong("threshold");     // Catch: Throwable -> L36
            long r5 = r3.optLong("task_time");     // Catch: Throwable -> L36
            r7.h = r5;     // Catch: Throwable -> L36
            long r14 = r13 + r9;     // Catch: Throwable -> L36
            r7.a.setText(ih2.d.b(r5, r14));     // Catch: Throwable -> L36
            r7.c.setText(String.valueOf(r9));     // Catch: Throwable -> L36
            r7.e.setText(String.valueOf(r14));     // Catch: Throwable -> L36
            if (r4.optInt("coupon_type") != 26) goto L32;
            r7.b.setText(String.format("满%s可用", new Object[]{Long.valueOf(r11)}));     // Catch: Throwable -> L36
            r7.d.setText(String.format("满%s可用", new Object[]{Long.valueOf(r11 + r15)}));     // Catch: Throwable -> L36
        L32:
            r7.f.setText(String.format("直接领取%s元", new Object[]{Long.valueOf(r9)}));     // Catch: Throwable -> L36
        L33:
            r7.g = new b(r7, r17, r6, r20, r22);
            r7.setOnCancelListener(c.a);
            r7.setCanceledOnTouchOutside(true);
            r7.setCancelable(true);
            UtilityKotlinExtentionsKt.j(1000, new CouponGrowProvider$Companion$showEnterRoomCouponExpandDialog$1$3(r7), 2);
            return r7;
        L35:
            return null;
        }

        public static ih2.h j(Context r20, boolean r21, Map r22, String r23, PromotionListController r24, Runnable r25) {
            Intrinsics.checkNotNullParameter(r20, "context");
            Intrinsics.checkNotNullParameter(r22, "ecomParams");
            Intrinsics.checkNotNullParameter(r23, "roomId");
            Intrinsics.checkNotNullParameter(r24, "listController");
            a("etst");
            if (r21 == true) goto L6;
            a("et-" + r21);
            return null;
        L6:
            CouponGrowProvider.l.getClass();
            if (b(r23) > 0) goto L10;
            a("et0");
            return null;
        L10:
            HashMap r0 = j.a;
            JSONObject r1 = j.i((String) r22.get("enter_request"));
            if (r1 != null) goto L13;
            r1 = CouponGrowProvider.f.d(r23);
        L13:
            JSONObject r5 = r1;
            if (e(r5) == true) goto L17;
            a("etnogro");
            return null;
        L17:
            a("etprepup");
            if (r5 == null) goto L38;
            JSONObject r2 = r5.optJSONObject("params");
            if (r2 == null) goto L38;
            if (d(r2.optString("token")) == false) goto L25;
            a("etaplyed");
            return null;
        L25:
            final ih2.h r10 = new ih2.h(r20);
            r10.i = r23;
            JSONObject r3 = c(r5);     // Catch: Exception -> L34
            if (r3 == null) goto L36;
            JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r5, "params");     // Catch: Exception -> L34
            long r12 = r4.optLong("coupon_amount");     // Catch: Exception -> L34
            long r14 = r4.optLong("coupon_threshold");     // Catch: Exception -> L34
            long r16 = r3.optLong("value");     // Catch: Exception -> L34
            long r18 = r3.optLong("threshold");     // Catch: Exception -> L34
            r10.h = r16 + r12;     // Catch: Exception -> L34
            r10.a.setText(r10.c(b(r23), r10.h));     // Catch: Exception -> L34
            if (r4.optInt("coupon_type") != 26) goto L32;
            r10.b.setText(String.format("满%s可用", new Object[]{Long.valueOf(r14)}));     // Catch: Exception -> L34
            r10.d.setText(String.format("满%s可用", new Object[]{Long.valueOf(r14 + r18)}));     // Catch: Exception -> L34
        L32:
            r10.c.setText(String.valueOf(r12));     // Catch: Exception -> L34
            r10.e.setText(String.valueOf(r10.h));     // Catch: Exception -> L34
            r10.b();     // Catch: Exception -> L34
        L36:
            r10.g = new d(r10, r20, r23, r5, r25, r24);
            r10.setCanceledOnTouchOutside(true);
            r10.setCancelable(true);
            r10.setOnCancelListener(e.a);
            UtilityKotlinExtentionsKt.j(0, new CouponGrowProvider$Companion$showExitRoomCouponExpandDialog$1$3(r10), 3);
            return r10;
        L34:
            e = move-exception;
            ECExceptionMonitor.e(e);
        L38:
            return null;
        }
    }

    public interface a {
        void onFinish();

        void onTick(long r1);
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CouponGrowProvider a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ PromotionListController e;

        public b(CouponGrowProvider r1, String r2, Context r3, JSONObject r4, PromotionListController r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void onChanged(Object r7) {
            Boolean r8 = (Boolean) r7;
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.booleanValue() == false) goto L7;
            CouponGrowProvider.l.getClass();
            Companion.a("bgd");
            this.a.f(this.b, false);
            return;
        L7:
            CouponGrowProvider.l.getClass();
            Companion.a("fgd");
            this.a.e(this.c, this.b, this.d, false, this.e);
        }
    }

    public static final class c extends CountDownTimer {
        public final /* synthetic */ CouponGrowProvider a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ PromotionListController e;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            CouponGrowProvider.l.getClass();
            Companion.a("fin");
            if (this.a.b.containsKey(this.b) == true) goto L5;
            Companion.f(this.c, this.d, this.b, false, this.e);
        L9:
            CouponGrowProvider.k.remove(this.b);
            this.a.b();
            return;
        L5:
            Map<String, a> r0 = this.a.b;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            a r2 = (a) r1.get(this.b);
            if (r2 == null) goto L8;
            r2.onFinish();
        L8:
            this.a.b.remove(this.b);
            goto L9
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r3) {
            long r4 = r3 / CouponGrowProvider.i;
            Map<String, a> r0 = this.a.b;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            a r2 = (a) r1.get(this.b);
            if (r2 == null) goto L6;
            r2.onTick(r4);
            return;
        }

        public c(CouponGrowProvider r1, String r2, Context r3, JSONObject r4, PromotionListController r5, long r6, long r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            super(r6, r8);
        }
    }

    static {
        l = new Companion();
        f = new CouponGrowProvider();
        g = 1;
        h = 604800000;
        i = 1000;
        j = "COUPON_";
        k = new LinkedHashMap();
    }

    public final void b() {
        c r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.a = null;
        this.c = "";
        this.e = null;
        g();
    }

    public final void g() {
        b r0 = this.d;     // Catch: Throwable -> L11
        if (r0 == null) goto L16;
        l.getClass();     // Catch: Throwable -> L11
        Companion.a("rmob");     // Catch: Throwable -> L11
        int r1 = ECSdk.a;     // Catch: Throwable -> L11
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        MutableLiveData r3 = r2.getAppEnterBackgroundOb();     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        r3.removeObserver(r0);     // Catch: Throwable -> L11
    L9:
        this.d = null;     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }

    public CouponGrowProvider() {
        this.b = new LinkedHashMap();
        this.c = "";
    }

    public final JSONObject d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        if (this.c.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(this.c, r2) == true) goto L10;
        return null;
    L10:
        return this.e;
    L5:
        r0 = false;
        goto L6
    }

    public final void f(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Map<String, Long> r0 = k;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Long r2 = (Long) r1.get(r8);
        if (r2 == null) goto L25;
        long r3 = r2.longValue();
        if (r3 >= h) goto L7;
        return;
    L7:
        long r4 = System.currentTimeMillis();
        if (r4 <= r3) goto L10;
        r0.remove(r8);
    L11:
        Companion r5 = l;
        String r6 = "et: " + ((Long) r1.get(r8));
        r5.getClass();
        Companion.a(r6);
        if (this.c.length() <= 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(this.c, r8) == false) goto L27;
        c r10 = this.a;
        if (r10 == null) goto L21;
        r10.cancel();
    L21:
        this.a = null;
        if (r9 == false) goto L28;
        g();
        return;
    L28:
        return;
    L27:
        return;
    L14:
        r7 = false;
        goto L15
    L10:
        r0.put(r8, Long.valueOf(r3 - r4));
        goto L11
    }

    public final void a(Context r9, String r10, JSONObject r11, PromotionListController r12) {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L5;
        MutableLiveData r2 = r1.getAppEnterBackgroundOb();
    L6:
        g();
        this.d = new b(this, r10, r9, r11, r12);
        l.getClass();
        Companion.a("adob");
        if (r2 == null) goto L13;
        b r13 = this.d;
        if (r13 == null) goto L12;
        r2.observeForever(r13);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.compat.nullable.Observer<kotlin.Boolean>");
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void c(Context r13, JSONObject r14, String r15, long r16, PromotionListController r18) {
        c r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        c r11 = new c(this, r15, r13, r14, r18, r16, i);
        this.a = r11;
        r11.start();
    }

    public final void e(Context r13, String r14, JSONObject r15, boolean r16, PromotionListController r17) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "roomId");
        Intrinsics.checkNotNullParameter(r17, "listController");
        Map<String, Long> r0 = k;
        Long r1 = (Long) ((LinkedHashMap) r0).get(r14);
        if (r1 == null) goto L26;
        long r2 = r1.longValue();
        if (r2 <= h) goto L7;
        r2 = r2 - System.currentTimeMillis();
    L8:
        long r4 = r2;
        l.getClass();
        Companion.a("en-" + r4);
        if (r15 != null) goto L11;
        JSONObject r11 = d(r14);
    L13:
        if (this.c.length() <= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(this.c, r14) == false) goto L28;
        if (r11 != null) goto L21;
        return;
    L21:
        if (r4 <= 0) goto L30;
        c(r13, r11, r14, r4, r17);
        if (r16 == false) goto L31;
        a(r13, r14, r11, r17);
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L15:
        r3 = false;
        goto L16
    L11:
        r11 = r15;
        goto L13
    L7:
        r0.put(r14, Long.valueOf(System.currentTimeMillis() + r2));
        goto L8
    }
}
