package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.v;
import com.bytedance.android.livesdk.livecommerce.room.f;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import java.util.Map;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ v b;
    public final /* synthetic */ IntroCardImageComponent c;

    public a(String r1, v r2, IntroCardImageComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L21;
        Context r6 = this.c.getContext();
        String r0 = this.a;
        Handler r1 = k.a;
        f.b(r6, r0);
        s1 r7 = this.b.g();
        if (r7 == null) goto L22;
        String r8 = r7.c();
        if (r8 == null) goto L23;
        e r2 = this.c.getArgument();
        if (r2 == null) goto L24;
        IntroCardEventCenter r3 = r2.a;
        if (r3 == null) goto L25;
        String r9 = "livesdk_" + r8 + "_click";
        s1 r10 = this.b.g();
        if (r10 == null) goto L18;
        Map<String, String> r11 = r10.d();
    L19:
        r3.a(r9, r11, null);
        return;
    L18:
        r11 = null;
        goto L19
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
