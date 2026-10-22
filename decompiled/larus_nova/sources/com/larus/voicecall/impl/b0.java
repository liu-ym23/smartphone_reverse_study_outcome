package com.larus.voicecall.impl;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<z2a.b> f377181a = null;

    static {
        f377181a = new CopyOnWriteArrayList();
    }

    public static void a(z2a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("addStateChangeListener: ");
        r102.append(r100);
        r102.append(", isInList: ");
        CopyOnWriteArrayList<z2a.b> r103 = f377181a;
        r102.append(r103.contains(r100));
        r101.i("RealtimeCallStateManager", r102.toString());
        if (r103.contains(r100) == true) goto L6;
        r103.add(r100);
        return;
    }
}
