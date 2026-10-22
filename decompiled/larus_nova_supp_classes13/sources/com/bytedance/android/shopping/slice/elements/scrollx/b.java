package com.bytedance.android.shopping.slice.elements.scrollx;

import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final float a;
    public float b;
    public float c;
    public Boolean d;
    public boolean e;
    public final View f;

    public static final class a {
    }

    static {
    }

    public b(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        this.f = r2;
        this.a = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
    }
}
