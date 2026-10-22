package com.bytedance.android.livesdk.log.filter;

import android.view.View;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.v6;
import com.bytedance.android.livesdk.w4;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements v {
    public static WeakReference<View> a;
    public static final g b = null;

    public g() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        b = new g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Map<String, String> r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L26
        IMiddlewareHostBusiness r1 = jc1.k.f(IMiddlewareHostBusiness.class);     // Catch: Throwable -> L26
        Unit r2 = null;
        if (r1 == null) goto L24;
        WeakReference<View> r3 = a;     // Catch: Throwable -> L26
        if (r3 == null) goto L9;
        View r4 = r3.get();     // Catch: Throwable -> L26
        if (r4 == null) goto L9;
    L13:
        Map r6 = r1.createReportParams("c0.d0", r4);     // Catch: Throwable -> L26
        if (r6 == null) goto L24;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L26
    L17:
        if (r7.hasNext() == false) goto L23;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Throwable -> L26
        if (r8.getKey() == null) goto L17;
        if (r8.getValue() == null) goto L17;
        r5.put(r8.getKey(), r8.getValue().toString());     // Catch: Throwable -> L26
        goto L17
    L23:
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L9:
        IMiddlewareHostApp r9 = jc1.k.f(IMiddlewareHostApp.class);     // Catch: Throwable -> L26
        if (r9 == null) goto L12;
        r4 = r9.getTopActivity();     // Catch: Throwable -> L26
        goto L13
    L12:
        r4 = null;
    L24:
        Result.constructor-impl(r2);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        switch(r2.hashCode()) {
            case -1837102167: goto L56;
            case -1122536402: goto L53;
            case -1115849514: goto L50;
            case -804282046: goto L47;
            case -597919004: goto L44;
            case -546689387: goto L41;
            case -505186085: goto L38;
            case 21313630: goto L35;
            case 479193863: goto L32;
            case 516631638: goto L29;
            case 516908681: goto L26;
            case 525059201: goto L23;
            case 868621731: goto L20;
            case 1499179894: goto L15;
            case 1499265855: goto L12;
            case 1744840954: goto L9;
            case 2041791848: goto L6;
            default: goto L59;
        };
    L6:
        if (r2.equals("livesdk_like") == false) goto L59;
    L57:
        a(r3);
        goto L59
    L9:
        if (r2.equals("livesdk_send_barrage") == false) goto L59;
    L12:
        if (r2.equals("livesdk_live_show") == false) goto L59;
    L15:
        if (r2.equals("livesdk_live_play") == false) goto L59;
        if (((Boolean) v6.a.getValue()).booleanValue() == false) goto L59;
        a(r3);
        goto L59
    L20:
        if (r2.equals("livesdk_live_dislike") == false) goto L59;
    L23:
        if (r2.equals("livesdk_redpackage_send") == false) goto L59;
    L26:
        if (r2.equals("livesdk_send_prop") == false) goto L59;
    L29:
        if (r2.equals("livesdk_send_gift") == false) goto L59;
    L32:
        if (r2.equals("livesdk_rec_live_play") == false) goto L59;
    L35:
        if (r2.equals("livesdk_audience_live_message") == false) goto L59;
    L38:
        if (r2.equals("livesdk_unfollow") == false) goto L59;
    L41:
        if (r2.equals("livesdk_live_user_report_submit_success") == false) goto L59;
    L44:
        if (r2.equals("livesdk_live_click_user") == false) goto L59;
    L47:
        if (r2.equals("livesdk_follow") == false) goto L59;
    L50:
        if (r2.equals("livesdk_live_duration") == false) goto L59;
    L53:
        if (r2.equals("livesdk_share") == false) goto L59;
    L56:
        if (r2.equals("livesdk_fans_club_join_success") == true) goto L57;
    L59:
        if (((List) w4.a.getValue()).contains(r2) == false) goto L62;
        a(r3);
        return;
    }
}
