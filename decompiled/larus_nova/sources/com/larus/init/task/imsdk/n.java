package com.larus.init.task.imsdk;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements f09.a.b {
    public n() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        ArrayList<String> r100 = o.f351391b;
        o.f351390a = SystemClock.elapsedRealtime();
    }
}
