package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import com.bytedance.android.shopping.feed.widget.InflowSimpleAbilityView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static InflowSimpleAbilityView a(Context r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "text");
        InflowSimpleAbilityView r0 = new InflowSimpleAbilityView(r4, null, 6, 0);
        r0.setIcon(r5);
        r0.setText(r6);
        return r0;
    }
}
