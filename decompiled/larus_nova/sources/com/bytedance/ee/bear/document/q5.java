package com.bytedance.ee.bear.document;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class q5 implements ew4.g0 {
    public q5() {
    }

    @Override // ew4.g0
    public final boolean O(int r100) {
        return true;
    }

    @Override // ew4.g0
    public final Fragment u1(PluginHost r100, int r101, wm5.o r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r102, "closeToolbar");
        r102.invoke();
        return null;
    }
}
