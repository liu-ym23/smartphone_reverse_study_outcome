package com.ivy.ivykit.plugin.impl.applet;

import android.util.LruCache;
import com.bytedance.ies.bullet.service.base.d1;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends LruCache<String, d1> {
    public a() {
        super(5242880);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String r100, d1 r101) {
        d1 r102 = r101;
        if (r102 == null) goto L7;
        byte[] r103 = r102.D;
        if (r103 == null) goto L7;
        return r103.length;
    L7:
        return 0;
    }
}
