package com.bytedance.ee.bear.document.icon;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends t {
    public final /* synthetic */ IconImageAdapter c;

    public b(IconImageAdapter r1) {
        this.c = r1;
    }

    public final void a(View r3) {
        DocIconNetResult.Icon r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.getTag();
    L7:
        if ((r4 instanceof DocIconNetResult.Icon) == false) goto L9;
        r0 = (DocIconNetResult.Icon) r4;
    L9:
        if (r0 == null) goto L14;
        Function1<? super DocIconNetResult.Icon, Unit> r5 = this.c.b;
        if (r5 == null) goto L15;
        r5.invoke(r0);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
