package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b {
    public final View a;
    public final m0 b;

    public static final class a {
    }

    static {
    }

    public abstract boolean a(int r1);

    public void b(RectF r1) {
    }

    public void c(boolean r1) {
    }

    public void d(boolean r1) {
    }

    public b(View r2, m0 r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
    }
}
