package com.huawei.hms.base.log;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f277001a;

    public c() {
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d r100) {
        this.f277001a = r100;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(Context r100, String r101) {
        d r102 = this.f277001a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String r100, int r101, String r102, String r103) {
        d r104 = this.f277001a;
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }
}
