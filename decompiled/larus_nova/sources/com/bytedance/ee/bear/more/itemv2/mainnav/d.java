package com.bytedance.ee.bear.more.itemv2.mainnav;

import com.bytedance.ee.bear.more.protocol3.m;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f234622a;

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        oj5.c r100 = this.f234622a.c();
        if (r100 != null) goto L5;
    L10:
        return false;
    L5:
        if (r100.m() == true) goto L10;
        wb5.d r101 = this.f234622a.f234619c;
        if (r101 == null) goto L10;
        return r101.f558995a;
    }

    public d(b r100) {
        this.f234622a = r100;
    }
}
