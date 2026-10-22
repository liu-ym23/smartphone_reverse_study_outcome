package com.bytedance.bdinstall;

import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: loaded from: classes8.dex */
public final class o extends a implements a1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f199726a;

    @Override // com.bytedance.bdinstall.a
    public final String c() {
        return this.f199726a;
    }

    public o(o0 r100) {
        a1.a(r100.getContext()).b(r100.a(), RemoteMessageConst.DEVICE_TOKEN, this);
    }

    @Override // com.bytedance.bdinstall.r
    public final void a(String r100, u r101) {
        this.f199726a = r100;
    }

    @Override // com.bytedance.bdinstall.a1.c
    public final void b(String r100, String r101) {
        this.f199726a = r100;
    }
}
