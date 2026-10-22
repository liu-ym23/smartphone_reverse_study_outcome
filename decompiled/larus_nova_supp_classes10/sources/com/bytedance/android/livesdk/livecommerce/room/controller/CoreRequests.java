package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.utils.k0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vi2.i0;
import vi2.j0;
import vi2.s0;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CoreRequests {
    public static final CompositeDisposable a = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ v0 a;

        public a(v0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            xi2.s r3 = (xi2.s) r2;
            v0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSuccess(r3);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ v0 a;

        public b(v0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            v0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r3);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ v0 a;

        public c(v0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            xi2.n r3 = (xi2.n) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            v0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSuccess(r3);
            sg2.h r1 = sg2.h.a.a;
            r1.e = r3.allowSetCoupons;
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ v0 a;

        public d(v0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            v0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r3);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ v0 a;

        public e(v0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ECPromotionList r3 = (ECPromotionList) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((com.bytedance.android.ec.model.g) r3).statusCode != 0) goto L5;
            this.a.onSuccess(r3);
            return;
        L5:
            this.a.onError(null);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ v0 a;

        public f(v0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            v0 r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    static {
        a = new CompositeDisposable();
    }

    public static void c(v0 r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        String r0 = vi2.h.a;
        String r1 = si2.g.F;
        vi2.h.e(null, null, r1, new vi2.y(r1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(new CoreRequests$queryFlashAuth$1(r3)), new p(new CoreRequests$queryFlashAuth$2(r3)));
    }

    public static void d(k0 r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        vi2.h.e(null, null, "/live/seller/flash/get_permission_info/", new vi2.z()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(new CoreRequests$queryFlashPermissionInfo$1(r3)), new p(new CoreRequests$queryFlashPermissionInfo$2(r3)));
    }

    public static void f(String r2, qk2.c.a r3, int r4) {
        String r0 = vi2.h.a;
        if (hh2.f.g() == false) goto L5;
        String r1 = si2.g.y;
    L6:
        Disposable r5 = vi2.h.e(null, null, r1, new vi2.o(r2, r4)).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(r3), new o(r3));
        a.add(r5);
        return;
    L5:
        r1 = si2.g.x;
        goto L6
    }

    public static void a(String r1, String r2, Map r3, v0 r4) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "roomId");
        if (r3 != null) goto L5;
        r3 = MapsKt.emptyMap();
    L5:
        Disposable r5 = vi2.h.e(null, null, r1, new i0(r2, r3, r1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r4), new b(r4));
        a.add(r5);
    }

    public static void b(String r8, String r9, String r10, int r11, v0 r12) {
        String r0 = vi2.h.a;
        String r1 = vi2.h.d(si2.g.u);
        vi2.h.e(null, null, r1, new vi2.l(r8, r9, r10, r11, r1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r12), new d(r12));
    }

    public static void e(String r16, String r17, String r18, String r19, v0 r20) {
        Intrinsics.checkNotNullParameter(r20, "apiObserver");
        ECEventUtilsV2.b.getClass();
        String r6 = ECEventUtilsV2.e("live_list_card");
        int r11 = com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r18, r19);
        if (TextUtils.isEmpty("") == true) goto L5;
        String r0 = vi2.h.a;
        Observable r1 = vi2.h.e(r18, r19, si2.g.m, new s0(r16, r17, r18, r19, r6));
    L17:
        Disposable r2 = r1.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r20), new f(r20));
        a.add(r2);
        return;
    L5:
        String r3 = vi2.h.a;
        if (TextUtils.isEmpty(r18) == true) goto L8;
        PromotionListController.T.getClass();
        boolean r4 = PromotionListController.a.c(r18, r19).s();
    L9:
        if (r4 == true) goto L13;
        String r5 = si2.g.c;
    L11:
        String r7 = r5;
        r1 = vi2.h.e(r18, r19, r7, new j0(false, r18, r19, r16, r17, r6, true, -1, 0, false, r11, r7));
        goto L17
    L13:
        if (hh2.f.g() == false) goto L15;
        r5 = si2.g.e;
        goto L11
    L15:
        r5 = si2.g.b;
        goto L11
    L8:
        r4 = false;
        goto L9
    }
}
