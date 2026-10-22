package uj2;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f550259a;

    public a() {
        this.f550259a = new v("livesdk_goods_list_request_failure", com.bytedance.android.ec.common.api.jump.model.b.f42853a);
    }

    @Override // uj2.c
    public final void a(String r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L6
        this.f550259a.c("request_path", r101.getPath());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // uj2.c
    public final void b(Integer r100) {
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
        this.f550259a.c("http_code", String.valueOf(r101));
        return;
    }
}
