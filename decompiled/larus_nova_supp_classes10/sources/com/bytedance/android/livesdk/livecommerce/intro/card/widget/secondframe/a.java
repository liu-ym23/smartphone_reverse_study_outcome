package com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.a$a, reason: collision with other inner class name */
    public static final class C0062a {
    }

    static {
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setOrientation(1);
        setGravity(48);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r2);
    }
}
