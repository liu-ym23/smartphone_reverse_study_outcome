package com.ivy.ivykit.plugin.impl.utils;

import com.bytedance.ttnet.utils.RetrofitUtils;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements g47.a {
    public i() {
    }

    @Override // g47.a
    public final <T> T create(String r100, Class<T> r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (T) RetrofitUtils.createSsService(r100, r101);
    }
}
