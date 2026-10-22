package com.bytedance.ies.sve_core;

import com.bytedance.ies.sve_core.s;

/* JADX INFO: loaded from: classes19.dex */
public class u<S extends s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f248702a;

    public u(String r100) {
        this.f248702a = r100;
    }

    public final u<S> a(String r100) {
        if (r100 != null) goto L4;
    L9:
        String r101 = this.f248702a;
    L11:
        return new u(r101);
    L4:
        if (r100.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        r101 = r100 + '-' + this.f248702a;
        goto L11
    L6:
        r102 = false;
        goto L7
    }
}
