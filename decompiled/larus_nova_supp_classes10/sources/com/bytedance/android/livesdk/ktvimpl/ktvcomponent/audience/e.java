package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import com.bytedance.android.livesdk.ktvimpl.base.util.i;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ KtvComponentAudienceLogicWidget a;

    public e(KtvComponentAudienceLogicWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        i r4 = (i) r3;
        if (r4 == null) goto L9;
        Float r0 = r4.a;
        if (r0 == null) goto L9;
        float r1 = r0.floatValue();
        KtvComponentContext r2 = this.a.f;
        if (r2 == null) goto L9;
        r2.setContainerTransY(Float.valueOf(r1));
    L9:
        if (r4 == null) goto L16;
        Integer r5 = r4.b;
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
        KtvComponentContext r7 = this.a.f;
        if (r7 == null) goto L18;
        r7.setContainerRightMargin(Integer.valueOf(r6));
        return;
    L18:
        return;
    L17:
        return;
    }
}
