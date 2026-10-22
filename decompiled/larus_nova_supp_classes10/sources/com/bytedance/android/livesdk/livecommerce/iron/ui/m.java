package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sg2.v;
import xi2.f0;
import xi2.m0;
import xi2.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public int a;
    public final TitleSwitchHelper$switchAction$1 b;
    public final TextView c;
    public final w d;
    public final Map<String, String> e;
    public final View.OnClickListener f;
    public final int g;
    public final String h;
    public final gi2.a i;

    public final void b() {
        Handler r0 = UtilityKotlinExtentionsKt.b;
        r0.removeCallbacks(this.b);
        if (ViewCompat.isAttachedToWindow(this.c) == false) goto L6;
        r0.postDelayed(this.b, this.d.a() * ((long) 1000));
        return;
    }

    public final int getType() {
        return this.g;
    }

    public final void a(f0 r6) {
        TextView r0 = this.c;
        r0.setText(r6.c());
        int r1 = s.a;
        Integer r2 = s.b(r6.a());
        if (r2 == null) goto L6;
        r0.setTextColor(r2.intValue());
    L6:
        if (r6.b() <= 0) goto L8;
        float r3 = r6.b();
    L9:
        r0.setTextSize(1, r3);
        r0.setVisibility(0);
        this.c.setTag(r6);
        Object r4 = this.c.getParent();
        if (r4 == null) goto L61;
        View r5 = (View) r4;
        if (cg4.a.a(r6.d()) == false) goto L14;
        View.OnClickListener r7 = this.f;
    L15:
        r5.setOnClickListener(r7);
        String r8 = "";
        if (this.g != 2) goto L43;
        gi2.a r9 = this.i;
        if (r9 == null) goto L20;
        LiveRoomParams r10 = (LiveRoomParams) r9.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
    L21:
        com.bytedance.android.ec.common.api.jump.model.b r11 = this.i;
        if (r11 != null) goto L24;
        r11 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L24:
        v r12 = new v("livesdk_show_store_entrance", r11);
        r12.c("store_type", "shop");
        if (r10 == null) goto L27;
        String r13 = r10.getEnterFromMerge();
    L28:
        r12.c("store_source_page", r13);
        if (r10 == null) goto L31;
        String r14 = r10.getEnterMethod();
    L32:
        r12.c("store_source_method", r14);
        r12.c("store_group_type", "live");
        w r15 = this.d;
        if (r15 == null) goto L42;
        m0 r16 = r15.b();
        if (r16 == null) goto L42;
        Map<String, String> r17 = r16.c();
        if (r17 == null) goto L42;
        String r18 = r17.get("author_id");
        if (r18 == null) goto L42;
        r8 = r18;
    L42:
        r12.c("author_id", r8);
        r12.c("live_anchor_id", this.h);
        r12.c("entrance_location", "live_brand_speical");
        r12.i(null);
        return;
    L31:
        r14 = null;
        goto L32
    L27:
        r13 = null;
        goto L28
    L20:
        r10 = null;
        goto L21
    L43:
        m0 r19 = this.d.b();
        if (r19 == null) goto L63;
        String r20 = r19.b();
        if (r20 == null) goto L64;
        String r21 = r20.concat("show");
        com.bytedance.android.ec.common.api.jump.model.b r22 = this.i;
        if (r22 != null) goto L50;
        r22 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L50:
        v r23 = new v(r21, r22);
        m0 r24 = this.d.b();
        if (r24 == null) goto L53;
        Map<String, String> r25 = r24.c();
    L54:
        r23.d(r25);
        r23.d(this.e);
        String r26 = r6.c();
        if (r26 == null) goto L58;
        r8 = r26;
    L58:
        r23.c("button_text", r8);
        r23.i(null);
        return;
    L53:
        r25 = null;
        goto L54
    L64:
        return;
    L63:
        return;
    L14:
        r7 = null;
        goto L15
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L8:
        r3 = 13.0f;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(TextView r2, w r3, Map r4, IronPromotionListBackgroundView.b r5, int r6, String r7, gi2.a r8) {
        Intrinsics.checkNotNullParameter(r2, "tvTitle");
        Intrinsics.checkNotNullParameter(r3, "marketComponent");
        Intrinsics.checkNotNullParameter(r5, "clickListener");
        Intrinsics.checkNotNullParameter(r7, "roomId");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.b = new TitleSwitchHelper$switchAction$1(this);
    }
}
