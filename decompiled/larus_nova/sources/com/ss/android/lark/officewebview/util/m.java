package com.ss.android.lark.officewebview.util;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f437553a;

    public m() {
        this.f437553a = new ConcurrentHashMap();
    }

    public final void a(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f437553a.put(r100, Long.valueOf(r101));
        return;
    }
}
