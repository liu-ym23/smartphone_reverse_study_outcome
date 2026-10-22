package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface g<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> {
    void a(ViewGroup r1, Component<STATE, STORE> r2, ViewGroup.LayoutParams r3, int r4);

    void c(Component<STATE, STORE> r1, View r2);

    void d(i<STATE, STORE> r1);

    void e(Component r1);

    boolean f(AbsComponent<?, ?> r1);
}
