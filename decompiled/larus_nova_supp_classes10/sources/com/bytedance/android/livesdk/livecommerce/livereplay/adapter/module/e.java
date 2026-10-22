package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.playback.ReplayParams;
import com.bytedance.android.livesdk.livecommerce.utils.LiveSettingKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements jf.c {
    public final /* synthetic */ f a;

    public final void a() {
    }

    public final void b() {
    }

    public final void h() {
    }

    public final void l() {
    }

    public final void m() {
    }

    public e(f r1) {
        this.a = r1;
    }

    public final boolean k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r2, "schema");
        return false;
    }

    public final void d(Context r1, com.bytedance.android.btm.api.model.d r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final void e(Context r1, com.bytedance.android.btm.api.model.d r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final void f(String r3, com.bytedance.android.ec.common.api.jump.model.g r4) {
        Intrinsics.checkNotNullParameter(r3, "clickArea");
        Intrinsics.checkNotNullParameter(r4, "promotionParams");
        Intrinsics.checkNotNullParameter(r3, "clickArea");
        Intrinsics.checkNotNullParameter(r4, "promotionParams");
    }

    public final boolean i(String r1, com.bytedance.android.btm.api.model.d r2) {
        Intrinsics.checkNotNullParameter(r1, "clickArea");
        Intrinsics.checkNotNullParameter(r1, "clickArea");
        return false;
    }

    public final Map<String, String> j(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "eventParams");
        int r0 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.a.n.h) == false) goto L17;
        Map r5 = this.a.n.i.b();
        if (r5 != null) goto L7;
        r5 = MapsKt.emptyMap();
    L7:
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = r5.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r7.next();
        if (((CharSequence) r1.getValue()).length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        r6.put(r1.getKey(), r1.getValue());
        goto L9
    L13:
        r2 = false;
        goto L14
    L23:
        return r6;
    L17:
        return jf.c.a.a(r3, r4);
    }

    public final void n(String r2, com.bytedance.android.ec.common.api.jump.model.g r3) {
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        jf.c.a.b(r2, r3);
    }

    public final boolean c(Context r2, com.bytedance.android.btm.api.model.d r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r5 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        boolean r6 = false;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.a.n.h) == false) goto L16;
        ReplayParams r7 = this.a.n.i.f();
        if (r7 == null) goto L9;
        Boolean r8 = r7.isFromProductDetail();
        if (r8 == null) goto L9;
        boolean r9 = r8.booleanValue();
    L10:
        if (r9 == true) goto L12;
    L14:
        if (r6 == false) goto L16;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().i("[ECProductCardUIModule onCreateView]close replayback, isFromProductDetail ");
        com.bytedance.android.ec.sdk.plugin.e.getActivity(r2).finish();
        goto L16
    L12:
        if (LiveSettingKeys.getEC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE() == false) goto L14;
        r6 = true;
    L9:
        r9 = false;
    L16:
        return r6;
    }

    public final void g(String r2, ql.a r3, BtmItemBuilder r4) {
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotion");
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotion");
    }
}
