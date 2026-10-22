package com.bytedance.ee.bear.document;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q5 implements ew4.g0 {
    public q5() {
    }

    @Override // ew4.g0
    public final boolean O(int r1) {
        return true;
    }

    @Override // ew4.g0
    public final Fragment u1(PluginHost r1, int r2, wm5.o r3) {
        Intrinsics.checkNotNullParameter(r1, "host");
        Intrinsics.checkNotNullParameter(r3, "closeToolbar");
        r3.invoke();
        return null;
    }
}
