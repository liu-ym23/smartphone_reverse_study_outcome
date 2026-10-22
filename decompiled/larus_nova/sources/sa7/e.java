package sa7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends ua7.a<ua7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f541187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f541188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ua7.a f541189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f541190d;

    @Override // ua7.a
    public final void onResponse(ua7.b r110) {
        ua7.f r100 = new ua7.f((ua7.c) r110, "logout", this.f541187a);
        if (r100.f549265q != 1) goto L8;
        if (TextUtils.isEmpty(r100.f549266r) == true) goto L8;
        String r111 = r100.f549266r;
        Map<String, String> r101 = this.f541188b;
        ua7.a r102 = this.f541189c;
        this.f541190d.h(r111, r101, new d(this, r102, r101));
        return;
    L8:
        if (r100.f549265q != 2) goto L13;
        f r112 = this.f541190d;
        c r103 = new c(this);
        Context r113 = r112.f541192a;
        int r104 = xb7.d.f563136l;
        String r105 = ta7.d.a("/passport/account/logout_others/");
        String r106 = UGCMonitor.TYPE_POST;
        if (TextUtils.isEmpty(UGCMonitor.TYPE_POST) == false) goto L12;
        r106 = MonitorConstants.CONNECT_TYPE_GET;
    L12:
        new xb7.d(r113, new lb7.a(r105, r106, null, null, null, null, false, 0), r103).m();
        return;
    L13:
        this.f541189c.onResponse(r100);
    }

    public e(f r100, String r101, b r102) {
        this.f541190d = r100;
        this.f541187a = r101;
        this.f541188b = null;
        this.f541189c = r102;
    }
}
