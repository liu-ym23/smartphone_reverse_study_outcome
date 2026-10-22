package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_OfficeDoubaoUiDemoActivity a;

    public b0(Hilt_OfficeDoubaoUiDemoActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_OfficeDoubaoUiDemoActivity r3 = this.a;
        if (r3.c == true) goto L6;
        r3.c = true;
        c1 r0 = (c1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent();
        OfficeDoubaoUiDemoActivity r4 = (OfficeDoubaoUiDemoActivity) UnsafeCasts.unsafeCast(r3);
        r0.G0();
        return;
    }
}
