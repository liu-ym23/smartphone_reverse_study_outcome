package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.view.View;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface h {
    Boolean a(String r1, JSONObject r2);

    View b();

    ti.l c();

    void d(String r1, Map<String, ? extends Object> r2);

    void e(List<? extends com.bytedance.android.ecom.arch.slice.g> r1, Map<String, ? extends Object> r2, c r3);

    View f(String r1);

    void release();
}
