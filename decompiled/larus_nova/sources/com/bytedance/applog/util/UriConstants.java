package com.bytedance.applog.util;

import com.bytedance.applog.r;
import com.bytedance.bdinstall.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes14.dex */
public final class UriConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f192848a = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UriRegion {
    }

    static {
        r.a r100 = new r.a();
        r100.f192844e = u.f199794i;
        r100.f192840a = new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"};
        r100.f192843d = "https://log.zijieapi.com/service/2/app_log_monitor/";
        r100.f192841b = new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"};
        r100.f192842c = "https://log.zijieapi.com/service/2/log_settings/";
        f192848a = new r(r100);
    }
}
