package com.ss.android.lark.monitor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes36.dex */
public class OkHttpUtils {
    public OkHttpUtils() {
    }

    public static void insertToOkHttpClientBuilder(List<Interceptor> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = false;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= r100.size()) goto L14;
        if ((ListProtector.get(r100, r102) instanceof evc.i) == false) goto L11;
        r103 = r102;
    L11:
        if ((ListProtector.get(r100, r102) instanceof OkHttpMonitorInterceptor) == true) goto L12;
        r102 = r102 + 1;
        goto L6
    L12:
        r101 = true;
    L14:
        if (r101 == true) goto L19;
        ListProtector.add(r100, r103 + 1, new OkHttpMonitorInterceptor());
        return;
    }
}
