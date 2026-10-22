package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t0 {
    public final FrameLayout a;
    public final com.bytedance.android.shopping.anchorv4.helper.n b;
    public final Function2<com.bytedance.android.ecom.arch.slice.g, View, Unit> c;

    public t0(FragmentActivity r2, SlcContext r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "slcContext");
        Intrinsics.checkNotNullParameter(r4, "onSliceViewCreated");
        this.c = r4;
        FrameLayout r5 = new FrameLayout(r2);
        this.a = r5;
        this.b = new com.bytedance.android.shopping.anchorv4.helper.n(r5, r3, new s0(this));
    }
}
