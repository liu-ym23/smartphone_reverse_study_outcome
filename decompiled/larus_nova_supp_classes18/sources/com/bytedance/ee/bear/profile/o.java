package com.bytedance.ee.bear.profile;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_HalfProfileActivity a;

    public o(Hilt_HalfProfileActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_HalfProfileActivity r3 = this.a;
        if (r3.e == true) goto L6;
        r3.e = true;
        i r0 = (i) r3.generatedComponent();
        HalfProfileActivity r4 = (HalfProfileActivity) UnsafeCasts.unsafeCast(r3);
        r0.c();
        return;
    }
}
