package com.bytedance.ee.bear.middleground.comment.input;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements ComponentCallbacks {
    public final /* synthetic */ AsideInputComment a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public f(AsideInputComment r1) {
        this.a = r1;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        tt5.a.h(this.a.i0, "onConfigurationChanged() called with: newConfig = " + r5);
        int r0 = r5.orientation;
        AsideInputComment r1 = this.a;
        if (r0 == r1.n0) goto L5;
    L6:
        r1.n0 = r0;
        r1.o0 = r5.screenLayout;
        r1.G0();
        BaseInputComment.y(this.a);
        this.a.H0();
        return;
    L5:
        if (r5.screenLayout != r1.o0) goto L6;
    }
}
