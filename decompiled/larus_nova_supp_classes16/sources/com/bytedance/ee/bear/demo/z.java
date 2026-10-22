package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_OfficeCCMDemoActivity a;

    public z(Hilt_OfficeCCMDemoActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_OfficeCCMDemoActivity r3 = this.a;
        if (r3.c == true) goto L6;
        r3.c = true;
        ((z0) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).g0((OfficeCCMDemoActivity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
