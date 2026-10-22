package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public u(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        KtvInteractElementWidget r1 = this.a;
        KtvContext.observerCurrentUserIsSinger$default(r1.z, r1, false, new t(this), 2, null);
        if (((Boolean) r7).booleanValue() == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.a() == true) goto L14;
        FrameLayout r8 = this.a.h;
        if (r8 == null) goto L9;
        r8.setVisibility(0);
    L9:
        KtvOpusMidiWidget r9 = this.a.j;
        if (r9 == null) goto L23;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r10 = r9.c;
        if (r10 == null) goto L24;
        r10.setContainerVisibility(0);
        return;
    L24:
        return;
    L23:
        return;
    L14:
        FrameLayout r11 = this.a.h;
        if (r11 == null) goto L17;
        r11.setVisibility(8);
    L17:
        KtvOpusMidiWidget r12 = this.a.j;
        if (r12 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r13 = r12.c;
        if (r13 == null) goto L27;
        r13.setContainerVisibility(8);
        return;
    L27:
        return;
    }
}
