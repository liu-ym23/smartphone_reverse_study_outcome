package com.ss.android.common.applog;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f408122a = null;

    static {
        String[] r100 = {"mc", "build_serial", "aliyun_uuid", "udid", "serial_number", "sim_serial_number"};
        String[] r101 = AppLog.f408012o0;
        String[] r102 = new String[r101.length + 6];
        f408122a = r102;
        System.arraycopy(r101, 0, r102, 0, r101.length);
        System.arraycopy(r100, 0, r102, r101.length + 0, r100.length);
    }

    public static String a(kta.n r110) throws JSONException {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(SearchCommonConstants.SearchResultType.THREAD_GROUP, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(SearchCommonConstants.SearchResultType.THREAD_GROUP, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.b();
        r100.a(SearchCommonConstants.SearchResultType.THREAD_GROUP, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r110, r101, r113, r111, true);
        return r113;
    }
}
