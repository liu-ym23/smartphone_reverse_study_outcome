package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;

/* JADX INFO: loaded from: classes41.dex */
public final class r implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f462605a = null;

    public r() {
    }

    static {
        f462605a = "(" + Process.myPid() + ")";
    }

    private static boolean a() {
        t.a();
        if (com.vivo.push.i.a.a().b() == false) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.vivo.push.util.s
    public final int a(String r100, String r101) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101);
    }

    @Override // com.vivo.push.util.s
    public final int b(String r100, String r101) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101);
    }

    @Override // com.vivo.push.util.s
    public final int c(String r100, String r101) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101);
    }

    @Override // com.vivo.push.util.s
    public final int d(String r100, String r101) {
        if (t.a() == true) goto L5;
        return -1;
    L5:
        return Log.i("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101);
    }

    @Override // com.vivo.push.util.s
    public final int e(String r100, String r101) {
        if (t.a() == true) goto L5;
        return -1;
    L5:
        return Log.v("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101);
    }

    @Override // com.vivo.push.util.s
    public final int a(String r100, Throwable r101) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(r100)), Log.getStackTraceString(r101));
    }

    @Override // com.vivo.push.util.s
    public final void b(Context r100, String r101) {
        if (a() == false) goto L6;
        a(r100, r101, 1);
        return;
    }

    @Override // com.vivo.push.util.s
    public final void c(Context r100, String r101) {
        if (a() == false) goto L6;
        a(r100, r101, 2);
        return;
    }

    @Override // com.vivo.push.util.s
    public final void a(Context r100, String r101) {
        if (a() == false) goto L6;
        a(r100, r101, 0);
        return;
    }

    @Override // com.vivo.push.util.s
    public final int a(String r100, String r101, Throwable r102) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101, r102);
    }

    @Override // com.vivo.push.util.s
    public final int b(String r100, String r101, Throwable r102) {
        if (t.a() == true) goto L5;
        return -1;
    L5:
        return Log.i("VivoPush.Client.".concat(String.valueOf(r100)), f462605a + r101, r102);
    }

    private void a(Context r100, String r101, int r102) {
        com.vivo.push.b.n r103 = new com.vivo.push.b.n();
        r103.b(r101);
        r103.a(r102);
        if (r102 <= 0) goto L5;
        d("LogController", r101);
    L5:
        r103.h();
        com.vivo.push.a.a.a(r100, r103, r100.getPackageName());
    }
}
