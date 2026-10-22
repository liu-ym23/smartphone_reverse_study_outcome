package com.bytedance.sdk.account.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f268940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lb7.a f268941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lb7.b f268942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f268943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f268944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f268945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f268946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f268947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f268948i;

    public b(lb7.a r100, lb7.b r101) {
        this.f268940a = false;
        this.f268943d = 0;
        this.f268944e = 0;
        this.f268945f = 0;
        this.f268946g = 0;
        this.f268947h = false;
        this.f268948i = false;
        this.f268941b = r100;
        this.f268942c = r101;
        long r102 = System.currentTimeMillis();
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.f269391o == false) goto L13;
        String r103 = UriProtector.parse(r100.f508352a).getPath().toLowerCase();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r103) == true) goto L13;
        if (com.bytedance.sdk.account.settings.common.a.c(r103, com.bytedance.sdk.account.settings.common.a.f269378c, com.bytedance.sdk.account.settings.common.a.f269380d, com.bytedance.sdk.account.settings.common.a.f269381e) == false) goto L13;
        this.f268940a = true;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e("AccountApiMonitor", "parse path exception", th);
    L13:
        if (this.f268940a == false) goto L19;
        this.f268943d = r102;
        return;
    }
}
