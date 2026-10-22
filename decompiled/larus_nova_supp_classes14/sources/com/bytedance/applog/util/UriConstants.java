package com.bytedance.applog.util;

import com.bytedance.applog.r;
import com.bytedance.bdinstall.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class UriConstants {
    public static final r a = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UriRegion {
    }

    static {
        r.a r0 = new r.a();
        r0.e = u.i;
        r0.a = new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"};
        r0.d = "https://log.zijieapi.com/service/2/app_log_monitor/";
        r0.b = new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"};
        r0.c = "https://log.zijieapi.com/service/2/log_settings/";
        a = new r(r0);
    }
}
