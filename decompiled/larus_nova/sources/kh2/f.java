package kh2;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f503451a;

    @Override // kh2.k
    public final Map<String, String> getValue() {
        return this.f503451a;
    }

    public f(com.bytedance.android.ec.adapter.api.state.a r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.f42698m;
        if (r101 == null) goto L6;
    L7:
        this.f503451a = r101;
        return;
    L6:
        r101 = MapsKt.emptyMap();
        goto L7
    }
}
