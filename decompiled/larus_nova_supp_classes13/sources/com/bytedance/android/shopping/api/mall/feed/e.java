package com.bytedance.android.shopping.api.mall.feed;

import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface e {
    Map<String, Object> PN(String r1, int r2);

    yj.e Pn();

    Map<String, String> Xj(String r1, int r2);

    Map<String, Object> getGlobalProps();

    boolean isDarkMode();

    void jq(Map<String, ? extends Object> r1, Set<String> r2);

    boolean oi();

    LifecycleOwner s4();

    void sj();
}
