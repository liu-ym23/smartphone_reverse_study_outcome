package com.lark.kmp.rustclient.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class x implements com.lark.kmp.rustclient.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f282566a;

    public x() {
        this.f282566a = new LinkedHashMap();
    }

    @Override // com.lark.kmp.rustclient.api.e
    public final Long a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return (Long) ((LinkedHashMap) this.f282566a).get(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
