package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator;

import android.content.Context;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends LinearLayout {
    public boolean a;

    public final boolean getHasMeasuredButNotLayout() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setHasMeasuredButNotLayout(boolean r1) {
        this.a = r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.a = true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.a = false;
    }
}
