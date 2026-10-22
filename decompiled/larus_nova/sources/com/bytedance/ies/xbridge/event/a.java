package com.bytedance.ies.xbridge.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    public static AppEvent a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        AppEvent.Companion.getClass();     // Catch: IllegalArgumentException -> L11
        Intrinsics.checkNotNullParameter(r100, "eventName");     // Catch: IllegalArgumentException -> L11
        AppEvent[] r101 = AppEvent.values();     // Catch: IllegalArgumentException -> L11
        int r102 = r101.length;     // Catch: IllegalArgumentException -> L11
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        AppEvent r104 = r101[r103];     // Catch: IllegalArgumentException -> L11
        if (Intrinsics.areEqual(r100, r104.getEventName()) == true) goto L16;
        r103 = r103 + 1;
        goto L4
    L16:
        return r104;
    L9:
        return null;
    }
}
