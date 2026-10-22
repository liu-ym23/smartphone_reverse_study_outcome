package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 extends com.bytedance.ee.bear.more.protocol3.k {
    public final Function1<ViewGroup, View> e;
    public final View.OnClickListener f;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(com.bytedance.ee.bear.more.protocol3.k r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        return false;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        if ((r3 instanceof FrameLayout) == false) goto L6;
        FrameLayout r0 = (FrameLayout) r3;
        r0.removeAllViews();
        r0.addView((View) this.e.invoke(r3));
        r3.setOnClickListener(this.f);
        return;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final View c(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        FrameLayout r0 = new FrameLayout(r5.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.addView((View) this.e.invoke(r5));
        r0.setOnClickListener(this.f);
        return r0;
    }

    public g0(String r2, Function1 r3, CustomMoreItem.b r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "renderer");
        super(r2);
        this.e = r3;
        this.f = r4;
    }
}
