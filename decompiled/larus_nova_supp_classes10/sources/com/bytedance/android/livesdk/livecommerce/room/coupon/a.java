package com.bytedance.android.livesdk.livecommerce.room.coupon;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.p0;
import com.bytedance.live.datacontext.i;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final RoomContextController a;
    public final com.bytedance.android.ec.adapter.api.state.a b;
    public final Context c;
    public final MutableLiveData<Boolean> d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.coupon.a$a, reason: collision with other inner class name */
    public static final class C0103a extends p0<ge.a> {
        public final /* synthetic */ Function0 a;

        public C0103a(Function0 r1) {
            this.a = r1;
        }

        public final void onNext(Object r2) {
            Intrinsics.checkNotNullParameter((ge.a) r2, "iUser");
            this.a.invoke();
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public b(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L6;
            a r4 = this.a;
            String r0 = this.b;
            r4.getClass();
            r4.a(new AutoApplyCoupon$autoApply$1(r4, r0));
            return;
        }
    }

    public final void b() {
        String r0 = (String) this.b.p.get("coupon_id");
        if (r0 != null) goto L5;
    L19:
        Lazy r1 = ECAppInfoService.a;
        if (ECAppInfoService.m() == false) goto L37;
        final String r2 = (String) this.b.p.get("legou_coupon_toast");
        if (r2 != null) goto L24;
        r2 = "";
    L24:
        HashMap r3 = j.a;
        if (j.e(r2) == false) goto L38;
        Function0<Unit> r4 = new AutoApplyCoupon$autoToast$1(this, r2);
        ECContext r5 = this.a.r();
        if (r5 == null) goto L39;
        i<LiveRoomLifecycleOwner> r6 = r5.getLifecycleOwner();
        if (r6 == null) goto L40;
        LiveRoomLifecycleOwner r7 = (LiveRoomLifecycleOwner) r6.getValue();
        if (r7 != null) goto L33;
        return;
    L33:
        if (Intrinsics.areEqual((Boolean) this.d.getValue(), Boolean.TRUE) == false) goto L35;
        r4.invoke();
        return;
    L35:
        this.d.observe(r7, new com.bytedance.android.livesdk.livecommerce.room.coupon.b(r4));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 != true) goto L19;
        ECContext r9 = this.a.r();
        if (r9 == null) goto L19;
        i<LiveRoomLifecycleOwner> r10 = r9.getLifecycleOwner();
        if (r10 == null) goto L19;
        LiveRoomLifecycleOwner r11 = (LiveRoomLifecycleOwner) r10.getValue();
        if (r11 == null) goto L19;
        if (Intrinsics.areEqual((Boolean) this.d.getValue(), Boolean.TRUE) == false) goto L18;
        a(new AutoApplyCoupon$autoApply$1(this, r0));
        goto L19
    L18:
        this.d.observe(r11, new b(this, r0));
        goto L19
    L7:
        r8 = false;
        goto L8
    }

    public final Context getContext() {
        return this.c;
    }

    public final void a(Function0<Unit> r8) {
        if (this.a.M() == true) goto L5;
        Bundle r0 = new Bundle();
        r0.putString("enter_from", "live_detail");
        r0.putString("source", "live");
        Context r1 = this.c;
        int r4 = ge.b.h;
        ge.b.a r5 = new ge.b.a();
        String r6 = th.a.g(this.c, 2131896640);
        Intrinsics.checkNotNullParameter(r6, "msg");
        r5.a = r6;
        Intrinsics.checkNotNullParameter("live_detail", "enterFrom");
        r5.e = "live_detail";
        Intrinsics.checkNotNullParameter("live", "source");
        r5.d = "live";
        yj2.b.a(r1, new ge.b(r5), new C0103a(r8));
        return;
    L5:
        r8.invoke();
    }

    public a(com.bytedance.android.ec.adapter.api.state.a r2, Context r3, MutableLiveData<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "roomState");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "playStatus");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        int r5 = RoomContextController.h;
        this.a = RoomContextController.a.b(r2.f, r2.e);
    }
}
