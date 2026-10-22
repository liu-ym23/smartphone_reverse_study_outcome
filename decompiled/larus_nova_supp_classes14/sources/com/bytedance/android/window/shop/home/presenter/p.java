package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleBackGroundPresenter a;

    public p(ECWindowCroppedStyleBackGroundPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        uq3.a r12 = (uq3.a) r11;
        uq3.a r0 = (uq3.a) this.a.O().getHeaderResponse().getValue();
        if (r0 == null) goto L7;
        uq3.o r1 = r0.c;
        if (r1 == null) goto L7;
        ECUrlModel r2 = r1.g;
    L8:
        uq3.a r3 = (uq3.a) this.a.O().getHeaderResponse().getValue();
        if (r3 == null) goto L13;
        uq3.o r4 = r3.c;
        if (r4 == null) goto L13;
        Integer r5 = r4.h;
    L14:
        if (r2 == null) goto L17;
        if (r5 == null) goto L17;
        View r13 = ECWindowCroppedStyleBackGroundPresenter.Z(this.a, r2, r5.intValue());
    L18:
        r13.setId(2131371259);
        int r6 = com.bytedance.android.ec.window.base.utils.c.a;
        Intrinsics.checkNotNullParameter(r13, "$this$setRadius");
        float r7 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(20.0f));
        float r8 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(20.0f));
        float r9 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(0.0f));
        float r10 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(0.0f));
        Float r14 = ArraysKt.maxOrNull(new float[]{r7, r8, r9, r10});
        if (r14 == null) goto L21;
        float r15 = r14.floatValue();
    L23:
        if (r15 <= 0) goto L25;
        r13.setClipToOutline(true);
        r13.setOutlineProvider(new com.bytedance.android.ec.window.base.utils.b(r15, r7, r10, r8, r9));
    L26:
        r13.findViewById(2131371261).setVisibility(0);
        ((FrameLayout) this.a.n.getValue()).addView(r13, 0);
        ECWindowCroppedStyleBackGroundPresenter r16 = this.a;
        r16.O().getCollapseProgress().observe(r16.U(), new o(r16));
        return;
    L25:
        r13.setClipToOutline(false);
        r13.setOutlineProvider(null);
        goto L26
    L21:
        r15 = 0.0f;
    L17:
        r13 = ECWindowCroppedStyleBackGroundPresenter.a0(this.a, r12);
    L13:
        r5 = null;
    L7:
        r2 = null;
        goto L8
    }
}
