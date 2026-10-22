package com.larus.community.impl.applet;

import android.os.Bundle;
import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s implements e29.c {
    public s() {
    }

    @Override // e29.c
    public final String a() {
        cy9.a r100 = cy9.a.f465949a;
        monitor-enter(r100);
        Bundle r101 = cy9.a.f465950b;     // Catch: Throwable -> L15
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getString("recent_enter_feed_from");     // Catch: Throwable -> L15
    L9:
        if (Intrinsics.areEqual(r103, "fixed_tab") == true) goto L12;
        if (Intrinsics.areEqual(r103, VoiceInputFrom.ACTION_BAR) == true) goto L12;
    L13:
        monitor-exit(r100);
        return r102;
    L12:
        r102 = r103;
        goto L13
    L7:
        r103 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
