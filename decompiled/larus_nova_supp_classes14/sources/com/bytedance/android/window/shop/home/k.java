package com.bytedance.android.window.shop.home;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public final List<Runnable> a;

    public final boolean a() {
        if (((ArrayList) this.a).isEmpty() == false) goto L5;
        return false;
    L5:
        ((Runnable) ListProtector.remove(this.a, 0)).run();
        return true;
    }

    public k() {
        this.a = new ArrayList();
    }
}
