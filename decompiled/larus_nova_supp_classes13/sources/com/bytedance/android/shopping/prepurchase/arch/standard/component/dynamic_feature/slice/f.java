package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface f extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {

    public static final class a {
        public static /* synthetic */ void a(f r0, IAction r1, com.bytedance.android.ecom.arch.slice.action.c r2, boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            r2 = null;
        L5:
            r0.y0(r1, r2, null);
        }

        public static /* synthetic */ void b(f r1, com.bytedance.android.ecom.arch.slice.g r2, IAction r3, View r4, int r5) {
            if ((r5 & 1) == 0) goto L5;
            r2 = null;
        L5:
            r1.O0(r2, r3, r4, null);
        }
    }

    List<com.bytedance.android.ecom.arch.slice.g> F();

    void M0(Map<String, ? extends Object> r1);

    void O0(com.bytedance.android.ecom.arch.slice.g r1, IAction r2, View r3, Map<String, ? extends Object> r4);

    void o1(Map<String, SlcElement> r1);

    void y0(IAction r1, com.bytedance.android.ecom.arch.slice.action.c r2, Map r3);
}
