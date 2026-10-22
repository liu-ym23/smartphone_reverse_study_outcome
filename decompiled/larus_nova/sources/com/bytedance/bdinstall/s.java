package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f199780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile u f199781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile o0 f199782c;

    @Override // com.bytedance.bdinstall.a
    public final String c() {
        u r100 = this.f199781b;
        Context r101 = this.f199780a;
        return r100.f199617e.b(new Object[]{r101}).getString(RemoteMessageConst.DEVICE_TOKEN, null);
    }

    public s(o0 r100, u r101) {
        this.f199782c = r100;
        this.f199780a = r100.getContext();
        this.f199781b = r101;
    }

    @Override // com.bytedance.bdinstall.r
    public final void a(String r100, u r101) {
        this.f199781b = r101;
        if (r101 == null) goto L7;
        SharedPreferences r102 = r101.a(this.f199782c);
        if (r102 == null) goto L7;
        r102.edit().putString(RemoteMessageConst.DEVICE_TOKEN, r100).apply();
    L7:
        a1.a(this.f199780a).c(this.f199782c.a(), RemoteMessageConst.DEVICE_TOKEN, r100);
    }
}
