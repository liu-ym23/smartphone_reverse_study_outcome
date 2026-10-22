package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface o {
    void a(Function2<? super Boolean, ? super InFeedProductV2, Unit> r1);

    Map<String, String> b();

    void c(JSONObject r1, JSONObject r2, boolean r3);

    void d(int r1, String r2, String r3, boolean r4);

    void loadProductFeed(n r1);
}
