package com.bytedance.ee.bear.profile;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements VerticalScrollInterceptLayout.a {
    public final /* synthetic */ HalfProfileActivity a;

    public b(HalfProfileActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.profile.VerticalScrollInterceptLayout.a
    public final boolean a(float r5) {
        j r0 = this.a.j;
        if (r0 == null) goto L11;
        View r1 = ((com.bytedance.ee.bear.facade.common.widget.d) r0).e;
        if (r1 == null) goto L7;
        Float r2 = Float.valueOf(r1.getTranslationY());
    L9:
        if (Intrinsics.areEqual(r2, 0.0f) == true) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
    L17:
        return true;
    L14:
        if (r5 > 0.0f) goto L16;
        return false;
    L16:
        if (this.a.l == true) goto L17;
        return false;
    L7:
        r2 = null;
    L11:
        r3 = false;
        goto L12
    }
}
