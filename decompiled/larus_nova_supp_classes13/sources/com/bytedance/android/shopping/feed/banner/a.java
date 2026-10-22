package com.bytedance.android.shopping.feed.banner;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ ImageSlideListProgressBar g;
    public final /* synthetic */ int h;

    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        ImageSlideListProgressBar r4 = this.g;
        if (r4.b != this.h) goto L5;
        return;
    L5:
        Function1<Boolean, Unit> r5 = r4.getOnProgressBarSelected();
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.h <= this.g.b) goto L10;
        boolean r0 = true;
    L11:
        Unit r6 = (Unit) r5.invoke(Boolean.valueOf(r0));
        return;
    L10:
        r0 = false;
        goto L11
    }

    public a(ImageSlideListProgressBar r1, int r2) {
        this.g = r1;
        this.h = r2;
        super(null, null, 3);
    }
}
