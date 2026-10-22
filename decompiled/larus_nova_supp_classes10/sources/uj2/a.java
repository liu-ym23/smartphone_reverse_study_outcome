package uj2;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements c {
    public final v a;

    public a() {
        this.a = new v("livesdk_goods_list_request_failure", com.bytedance.android.ec.common.api.jump.model.b.a);
    }

    @Override // uj2.c
    public final void a(String r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        Uri r4 = UriProtector.parse(r3);     // Catch: Exception -> L6
        this.a.c("request_path", r4.getPath());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // uj2.c
    public final void b(Integer r3) {
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
        this.a.c("http_code", String.valueOf(r4));
        return;
    }
}
