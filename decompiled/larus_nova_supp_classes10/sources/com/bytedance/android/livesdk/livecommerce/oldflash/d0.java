package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public d0(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        String r8 = (String) r7;
        String r0 = "";
        String r2 = null;
        if (r8 == null) goto L27;
        LiveFlashNewFragment r3 = this.a;
        s r4 = r3.m;
        if (r4 == null) goto L9;
        a r5 = r4.h;
        if (r5 == null) goto L9;
        r5.g = r8;
    L9:
        LiveFlashListAdapter r9 = r3.l;
        if (r9 == null) goto L12;
        r9.notifyDataSetChanged();
    L12:
        LiveFlashViewModel r10 = (LiveFlashViewModel) this.a.g;
        if (r10 == null) goto L26;
        q r11 = r10.getEventHelper();
        if (r11 == null) goto L26;
        s r6 = this.a.m;
        if (r6 == null) goto L21;
        a r12 = r6.h;
        if (r12 == null) goto L21;
        r2 = r12.b;
    L21:
        com.bytedance.android.livesdk.livecommerce.event.f0 r13 = new com.bytedance.android.livesdk.livecommerce.event.f0(r11.a, r11.b, r11.c);
        if (r2 == null) goto L25;
        r0 = r2;
    L25:
        r13.f("attribute_name", r0);
        r13.k();
    L26:
        this.a.la0(false, false);
        return;
    L27:
        Context r14 = this.a.getContext();
        Context r15 = this.a.getContext();
        if (r15 == null) goto L30;
        String r16 = th.a.g(r15, 2131896576);
    L31:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r14, r16);
        LiveFlashNewFragment r17 = this.a;
        int r18 = LiveFlashNewFragment.w;
        LiveFlashViewModel r19 = (LiveFlashViewModel) r17.g;
        if (r19 == null) goto L47;
        q r20 = r19.getEventHelper();
        if (r20 == null) goto L48;
        s r21 = this.a.m;
        if (r21 == null) goto L40;
        a r22 = r21.h;
        if (r22 == null) goto L40;
        r2 = r22.b;
    L40:
        com.bytedance.android.livesdk.livecommerce.event.e0 r23 = new com.bytedance.android.livesdk.livecommerce.event.e0(r20.a, r20.b, r20.c);
        if (r2 == null) goto L44;
        r0 = r2;
    L44:
        r23.f("attribute_name", r0);
        r23.k();
        return;
    L48:
        return;
    L47:
        return;
    L30:
        r16 = null;
        goto L31
    }
}
