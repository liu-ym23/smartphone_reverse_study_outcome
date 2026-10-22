package com.bytedance.timon_monitor_impl;

import com.bytedance.timon_monitor_impl.settings.HeliosSettings;
import gz5.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends gz5.a {
    @Override // gz5.a
    public final y a() {
        y r100 = ((HeliosSettings) HeliosSettings.f270764b.getValue()).f270766a;
        if (r100 != null) goto L6;
        r100 = (y) HeliosSettings.f270765c.getValue();
    L6:
        if (r100 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r100;
    }

    public d() {
    }
}
