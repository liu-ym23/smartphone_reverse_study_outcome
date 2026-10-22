package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a extends com.bytedance.android.shopping.anchorv3.detail.widget.l implements com.bytedance.android.shopping.anchorv4.vm.h {
    public final int c;

    public final void S2(float r1) {
    }

    public final void a2(boolean r1) {
    }

    public void b2(boolean r1) {
    }

    public abstract List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f();

    public abstract p g();

    public a(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r3;
    }
}
