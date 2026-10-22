package com.bytedance.awemeopen.apps.framework.feed.ui.information.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<b, c> {
    public final l14.c e;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        l14.c r3 = this.e;
        if (r3 == null) goto L7;
        View r4 = r3.createView(getContext());
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new View(getContext());
    }

    public a(Context r2, b r3, c r4, l14.c r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.e = r5;
    }
}
