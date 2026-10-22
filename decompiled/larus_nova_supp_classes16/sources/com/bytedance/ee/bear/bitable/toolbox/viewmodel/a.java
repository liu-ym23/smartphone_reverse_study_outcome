package com.bytedance.ee.bear.bitable.toolbox.viewmodel;

import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.google.gson.Gson;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ Observable a(b r1, EQueryType r2, Class r3, Gson r4, int r5) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r1.b(r2, null, r3, r4);
    }
}
