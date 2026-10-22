package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, m> f462465a;

    public o() {
        this.f462465a = new ConcurrentHashMap();
    }

    @Override // com.vivo.push.restructure.a.a.n
    public final void a(com.vivo.push.restructure.a.a r100, a r101) {
        if (r100 != null) goto L6;
        t.a("addToCache error. msg is null");
        return;
    L6:
        if (TextUtils.isEmpty(r100.a()) == false) goto L9;
        t.a("addToCache error. messageID is null");
        return;
    L9:
        if (r101 != null) goto L12;
        t.a("addToCache error. firstNode is null");
        return;
    }
}
