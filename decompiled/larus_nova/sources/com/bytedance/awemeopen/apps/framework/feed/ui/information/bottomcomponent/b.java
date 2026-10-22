package com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static final void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((j54.a) r101.next()).getClass();
        goto L4
    }
}
