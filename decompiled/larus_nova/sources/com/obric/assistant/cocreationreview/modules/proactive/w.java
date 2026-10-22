package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.g5;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f387525a;

    public w() {
        this.f387525a = new AtomicLong(0);
    }

    public final boolean a(x r100, g5 r101) {
        Intrinsics.checkNotNullParameter(r100, "ticket");
        Intrinsics.checkNotNullParameter(r101, "activeRequest");
        if (r100.f387526a == this.f387525a.get()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f387527b, r101) == false) goto L7;
        return true;
    }
}
