package com.bytedance.timonbase;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R0\u0010\u0003\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timonbase/TimonIgnoreToken;", "", "()V", "threadLocal", "Ljava/lang/ThreadLocal;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "value", MonitorConstants.CONNECT_TYPE_GET, "remove", "timonbase_release"}, k = 1, mv = {1, 1, 16})
public final class TimonIgnoreToken {
    public static final TimonIgnoreToken INSTANCE = null;
    private static final ThreadLocal<HashMap<String, String>> threadLocal = null;

    private TimonIgnoreToken() {
    }

    static {
        INSTANCE = new TimonIgnoreToken();
        threadLocal = new ThreadLocal();
    }

    @JvmStatic
    public static final void remove(String r100) {
        HashMap<String, String> r101 = threadLocal.get();
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public final String get(String r100) {
        HashMap<String, String> r101 = threadLocal.get();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.get(r100);
    }

    @JvmStatic
    public static final void add(String r100, String r101) {
        ThreadLocal<HashMap<String, String>> r102 = threadLocal;
        HashMap<String, String> r103 = r102.get();
        if (r103 != null) goto L6;
        r103 = new HashMap();
        r102.set(r103);
    L6:
        r103.put(r100, r101);
    }
}
