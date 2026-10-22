package com.bytedance.awemeopen.apps.framework.feed.ui.information.camera;

import com.bytedance.awemeopen.apps.framework.utils.o;
import kotlin.jvm.internal.Intrinsics;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends o {
    public final /* synthetic */ f d;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        f r0 = this.d;
        w r1 = r0.k;
        if (r1 == null) goto L6;
        g r2 = (g) r0.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "hostExpand");
        r2.a.b(r1);
        h r3 = (h) r0.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "hostExpand");
        r3.b.b(r1);
        return;
    }

    public e(f r1) {
        this.d = r1;
        super(0);
    }
}
