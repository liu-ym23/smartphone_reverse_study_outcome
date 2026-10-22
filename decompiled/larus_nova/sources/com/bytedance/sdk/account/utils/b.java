package com.bytedance.sdk.account.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.ss.android.account.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f269536a = null;

    static {
        f269536a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.account.c
    public final boolean a(hb7.b r100) {
        wqa.f r101 = com.ss.android.account.k.f406318b;
        if (r101 == null) goto L5;
        com.larus.account.saas.core.internal.init.b r102 = r101.f();
    L6:
        if (r102 == null) goto L10;
        return r102.a(r100);
    L10:
        return super.a(r100);
    L5:
        r102 = null;
        goto L6
    }

    public final boolean b(int r100) {
        wqa.f r101 = com.ss.android.account.k.f406318b;
        if (r101 == null) goto L7;
        r101.f();
        return true;
    L7:
        return true;
    }

    public final boolean c(String r100, String r101) {
        wqa.f r102 = com.ss.android.account.k.f406318b;
        if (r102 == null) goto L5;
        com.larus.account.saas.core.internal.init.b r103 = r102.f();
    L6:
        if (r103 == null) goto L9;
        r103.b(r100, r101);
        return true;
    L9:
        return false;
    L5:
        r103 = null;
        goto L6
    }
}
