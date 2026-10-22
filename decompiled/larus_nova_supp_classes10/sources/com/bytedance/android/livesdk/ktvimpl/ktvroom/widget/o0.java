package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o0<T> implements Observer {
    public final /* synthetic */ KtvOpusMidiWidget a;

    public o0(KtvOpusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == false) goto L17;
        Object r4 = this.a.d;
        if ((r4 instanceof View) == true) goto L7;
        r4 = null;
    L7:
        View r5 = (View) r4;
        if (r5 == null) goto L10;
        r5.setVisibility(8);
    L10:
        View r6 = this.a.o;
        if (r6 == null) goto L13;
        r6.setBackgroundColor(0);
    L13:
        View r7 = this.a.o;
        if (r7 == null) goto L18;
        r7.setVisibility(8);
        return;
    L18:
        return;
    }
}
