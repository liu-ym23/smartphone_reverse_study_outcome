package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_BitableHomeActivity a;

    public k(Hilt_BitableHomeActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_BitableHomeActivity r3 = this.a;
        if (r3.h == true) goto L6;
        r3.h = true;
        b r0 = (b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        BitableHomeActivity r4 = (BitableHomeActivity) UnsafeCasts.unsafeCast(r3);
        r0.H0();
        return;
    }
}
