package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface g {
    View a(String r1);

    c asView();

    boolean b(com.bytedance.android.ecom.arch.slice.g r1, Map<String, ? extends Object> r2, String r3);

    void setDisableTouchEvent(boolean r1);

    void setOnViewReadyCallback(l r1);
}
