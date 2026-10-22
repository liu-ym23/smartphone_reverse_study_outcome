package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.vivo.push.b.y;
import com.vivo.push.m;
import com.vivo.push.util.t;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f462481a;

    public b(com.vivo.push.restructure.b.a r100) {
        this.f462481a = r100;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int r100, String r101) {
        t.d("ReportImpl", "reportIntercepted() , msgID = " + r101 + ", code = " + r100);
        if (r100 > 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        y r102 = new y(r100);
        HashMap<String, String> r103 = new HashMap();
        r103.put(com.heytap.mcssdk.constant.b.f276353c, r101);
        com.vivo.push.restructure.b.a r104 = this.f462481a;
        if (r104 == null) goto L11;
        String r105 = r104.a();
        if (TextUtils.isEmpty(r105) == true) goto L11;
        r103.put("remoteAppId", r105);
    L11:
        r102.a(r103);
        m.a().a(r102);
        return;
    }
}
