package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462464b;

    public final com.vivo.push.b.h a() {
        if (TextUtils.isEmpty(this.f462463a) == false) goto L5;
    L9:
        t.a("convertOffLineMsg() error, mMessageID = " + this.f462463a + ", mNodeArrayInfo = " + this.f462464b);
        return null;
    L5:
        if (TextUtils.isEmpty(this.f462464b) == true) goto L9;
        return new com.vivo.push.b.h(this.f462463a, this.f462464b);
    }

    public m(com.vivo.push.restructure.a.a r100, String r101) {
        if (r100 == null) goto L5;
        this.f462463a = r100.a();
    L5:
        this.f462464b = r101;
    }
}
