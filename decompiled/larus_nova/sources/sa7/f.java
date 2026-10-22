package sa7;

import android.content.Context;
import android.text.TextUtils;
import ara.t;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larus.account.base.impl.MultiAccountServiceImpl;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f541191b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f541192a;

    public static j a() {
        if (f541191b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f541191b != null) goto L9;
        f541191b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f541191b;
    }

    public f() {
        this.f541192a = com.ss.android.account.k.d().getApplicationContext();
    }

    public final void b(com.ss.android.token.d r100, t r101) {
        b r102 = new b(this, r101);
        String r103 = r100.f449724b;
        com.bytedance.sdk.account.impl.g.a().c(r103, null, r100, new e(this, r103, r102));
    }

    @Override // sa7.j
    public final void i(String r110, MultiAccountServiceImpl.e r111) {
        Context r100 = this.f541192a;
        int r101 = rb7.a.f536938l;
        String r102 = ta7.d.a("/passport/account/remove/");
        HashMap r103 = new HashMap();
        r103.put("removed_user_id", r110);
        String r112 = UGCMonitor.TYPE_POST;
        if (TextUtils.isEmpty(UGCMonitor.TYPE_POST) == false) goto L5;
        r112 = MonitorConstants.CONNECT_TYPE_GET;
    L5:
        new rb7.a(r100, new lb7.a(r102, r112, r103, null, null, null, false, 0), r111).m();
    }

    @Override // sa7.j
    public final void h(String r100, Map<String, String> r101, va7.g r102) {
        Context r103 = this.f541192a;
        int r104 = rb7.j.f536966l;
        lb7.a.C6671a r105 = new lb7.a.C6671a();
        r105.f508360a = ta7.d.a("/passport/account/switch/");
        r105.e("sec_to_user_id", r100);
        r105.f(r101);
        new rb7.j(r103, r105.h(), r102).m();
    }
}
