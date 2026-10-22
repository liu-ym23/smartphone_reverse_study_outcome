package kh2;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements k {
    public final Map<String, String> a;

    @Override // kh2.k
    public final Map<String, String> getValue() {
        return this.a;
    }

    public f(com.bytedance.android.ec.adapter.api.state.a r1) {
        if (r1 == null) goto L6;
        Map<String, String> r2 = r1.m;
        if (r2 == null) goto L6;
    L7:
        this.a = r2;
        return;
    L6:
        r2 = MapsKt.emptyMap();
        goto L7
    }
}
