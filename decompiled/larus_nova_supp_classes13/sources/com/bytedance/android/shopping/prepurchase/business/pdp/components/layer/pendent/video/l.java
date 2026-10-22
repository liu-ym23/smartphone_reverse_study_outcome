package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.shopping.api.video.AVScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public final Context a;
    public final ViewGroup b;
    public final x c;
    public final y d;
    public u e;
    public final Map<String, Object> f;

    public final boolean a() {
        if (this.c.d != AVScene.CONTENT_PRODUCT_DETAIL_HEADER) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.a;
    }

    public l(Context r2, ViewGroup r3, x r4, y r5, u r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "playerConfig");
        Intrinsics.checkNotNullParameter(r5, "uiConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
