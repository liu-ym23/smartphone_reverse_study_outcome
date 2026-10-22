package org.koin.android.ext.android;

import android.content.ComponentCallbacks;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static final org.koin.core.a a(ComponentCallbacks r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof org.koin.core.component.a) == true) goto L7;
        hwc.a r101 = hwc.a.f487464a;
        return hwc.a.a();
    L7:
        return ((org.koin.core.component.a) r100).Pw();
    }
}
