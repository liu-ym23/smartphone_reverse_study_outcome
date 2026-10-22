package com.bytedance.ee.larkwebview.util;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f242979a;

    public l() {
        this.f242979a = new ConcurrentHashMap();
    }

    public final void a(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f242979a.put(r100, Long.valueOf(r101));
        return;
    }
}
