package com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final void a(List r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((j54.a) r2.next()).getClass();
        goto L4
    }
}
