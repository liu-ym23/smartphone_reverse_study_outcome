package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* JADX INFO: loaded from: classes23.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HMSExtLogger f276996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f276997b;

    public a(HMSExtLogger r100) {
        this.f276996a = r100;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d r100) {
        this.f276997b = r100;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(Context r100, String r101) {
        d r102 = this.f276997b;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String r100, int r101, String r102, String r103) {
        HMSExtLogger r104 = this.f276996a;
        if (r104 != null) goto L5;
    L14:
        d r105 = this.f276997b;
        if (r105 == null) goto L18;
        r105.a(r100, r101, r102, r103);
        return;
    L18:
        return;
    L5:
        if (r101 != 3) goto L7;
        r104.d(r102, r103);
        goto L14
    L7:
        if (r101 != 4) goto L9;
        r104.i(r102, r103);
        goto L14
    L9:
        if (r101 == 5) goto L11;
        r104.e(r102, r103);
        goto L14
    L11:
        r104.w(r102, r103);
        goto L14
    }
}
