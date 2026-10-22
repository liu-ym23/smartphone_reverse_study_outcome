package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public String a;
    public rd3.a b;
    public final g c;

    public static final class a {
    }

    static {
    }

    public f(Context r3, ProductFeedAdapter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        super(r3, null, 0);
        this.c = new g(this, r4);
    }
}
