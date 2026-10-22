package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d0 implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_OfficeSpaceDemoActivity a;

    public d0(Hilt_OfficeSpaceDemoActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_OfficeSpaceDemoActivity r3 = this.a;
        if (r3.c == true) goto L6;
        r3.c = true;
        ((e1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).l1((OfficeSpaceDemoActivity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
