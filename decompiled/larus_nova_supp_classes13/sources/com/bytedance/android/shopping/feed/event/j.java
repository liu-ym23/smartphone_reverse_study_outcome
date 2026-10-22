package com.bytedance.android.shopping.feed.event;

import android.view.View;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ View a;
    public final /* synthetic */ rd3.a b;

    public j(BaseCardDetailView r1, rd3.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r8, Map<Object, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "params");
        FeedProductEventTracker.D(FeedProductEventTracker.a, this.a.getContext(), this.b, null, false, o.a(r9), 8);
    }
}
