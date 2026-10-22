package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public p(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == false) goto L14;
        Object r3 = this.a.r;
        if ((r3 instanceof View) == true) goto L7;
        r3 = null;
    L7:
        View r4 = (View) r3;
        if (r4 == null) goto L10;
        r4.setVisibility(8);
    L10:
        View r5 = this.a.t;
        if (r5 == null) goto L15;
        r5.setVisibility(8);
        return;
    L15:
        return;
    }
}
