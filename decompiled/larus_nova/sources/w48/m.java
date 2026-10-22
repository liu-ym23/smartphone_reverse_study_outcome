package w48;

import com.bytedance.applog.r;
import com.bytedance.bdinstall.u;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558265a = 0;

    static {
    }

    public static r a(boolean r100) {
        r.a r101 = new r.a();
        if (r100 == false) goto L5;
        u r102 = u.f199793h;
    L6:
        r101.f192844e = r102;
        r101.f192840a = new String[]{"https://log.doubao.com/service/2/app_log/"};
        r101.f192841b = new String[]{"https://rtlog.doubao.com/service/2/app_log/"};
        r101.f192842c = "https://log.doubao.com/service/2/log_settings/";
        return new r(r101);
    L5:
        r102 = u.f199792g;
        goto L6
    }
}
