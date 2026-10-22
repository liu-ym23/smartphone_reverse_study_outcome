package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Bundle;
import me.ele.lancet.base.Origin;

/* JADX INFO: loaded from: classes22.dex */
public class BadParcelableLancet {
    public BadParcelableLancet() {
    }

    public Bundle getBundleExtra(String r100) {
        Bundle r101 = (Bundle) Origin.call();
        Context r102 = BadParcelableCrashOptimizer.getContext();
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        r101.setClassLoader(r102.getClassLoader());
    L6:
        return r101;
    }
}
