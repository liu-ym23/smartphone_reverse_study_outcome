package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* JADX INFO: loaded from: classes23.dex */
public class q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static q1 f277429c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f277430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277431b;

    static {
        f277429c = new q1();
    }

    private q1() {
        this.f277430a = false;
        this.f277431b = q0.i();
    }

    public static q1 b() {
        return f277429c;
    }

    public boolean a() {
        if (this.f277430a == true) goto L16;
        Context r100 = this.f277431b;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT < 24) goto L13;
        UserManager r101 = (UserManager) r100.getSystemService("user");
        if (r101 == null) goto L12;
        boolean r102 = r101.isUserUnlocked();
    L14:
        this.f277430a = r102;
        goto L16
    L12:
        this.f277430a = false;
        goto L16
    L13:
        r102 = true;
    L16:
        return this.f277430a;
    }
}
