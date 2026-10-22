package com.bytedance.android.livesdk.livecommerce.room.coupon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ReferralCoupon {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(final com.bytedance.android.ec.adapter.api.state.a r5, final Context r6, final boolean r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual((String) r5.p.get("pop_fission_coupon"), "true")) == false) goto L9;
        return;
    L9:
        Function0<Unit> r0 = new ReferralCoupon$handleBackFlow$1(r5, r6, r7);
        if (r5.a() == true) goto L12;
        Bundle r8 = new Bundle();
        r8.putString("enter_from", "live_detail");
        r8.putString("source", "live");
        int r9 = ge.b.h;
        ge.b.a r10 = new ge.b.a();
        String r3 = th.a.g(r6, 2131896640);
        Intrinsics.checkNotNullParameter(r3, "msg");
        r10.a = r3;
        Intrinsics.checkNotNullParameter("live_detail", "enterFrom");
        r10.e = "live_detail";
        Intrinsics.checkNotNullParameter("live", "source");
        r10.d = "live";
        yj2.b.a(r6, new ge.b(r10), new e(r0));
        return;
    L12:
        r0.invoke();
    }

    public static Uri.Builder a(com.bytedance.android.ec.adapter.api.state.a r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r6, "referralId");
        Uri.Builder r8 = UriProtector.parse(r5).buildUpon();
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.f;
    L6:
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r8.appendQueryParameter("room_id", r1);
        if (r4 == null) goto L12;
        String r3 = r4.g;
    L13:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r8.appendQueryParameter("anchor_id", r3);
        r8.appendQueryParameter("item_id", r6);
        JSONObject r9 = new JSONObject();
        if (r4 == null) goto L20;
        Map r10 = r4.m;
        if (r10 == null) goto L20;
        String r11 = (String) r10.get("enter_method");
    L21:
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        r9.put("enter_method", r11);
        r9.put("ecom_group_type", "live");
        if (r4 == null) goto L28;
        Map r12 = r4.m;
        if (r12 == null) goto L28;
        r0 = (String) r12.get("enter_from_merge");
    L28:
        if (r0 == null) goto L31;
        r2 = r0;
    L31:
        r9.put("enter_from_merge", r2);
        r9.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r7 == null) goto L34;
        r9.put("ecom_entrance_form", r7);
    L34:
        Unit r13 = Unit.INSTANCE;
        r8.appendQueryParameter("log_data", r9.toString());
        return r8;
    L20:
        r11 = null;
        goto L21
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
