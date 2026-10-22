package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements OnContextAvailableListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        b r3 = this.a;
        if (r3.c == true) goto L6;
        r3.c = true;
        ((g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).h((WikiSpaceDetailActivity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
