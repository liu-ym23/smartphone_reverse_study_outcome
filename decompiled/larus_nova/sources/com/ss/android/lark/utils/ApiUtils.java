package com.ss.android.lark.utils;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class ApiUtils {
    private static final Map<Class, Object> APIS = null;
    private static final Map<Class, Class> API_IMPL_MAP = null;
    private static final String TAG = "ApiUtils";
    private static k0 handler;
    private static boolean sEnableMockProxy;

    public interface a<T> {
        void consume(T r100);
    }

    public ApiUtils() {
    }

    static {
        API_IMPL_MAP = new ConcurrentHashMap();
        APIS = new ConcurrentHashMap();
        sEnableMockProxy = false;
        handler = new k0();
    }

    private static boolean isDebug() {
        return LarkContext.getApplication().getPackageName().endsWith(".debug");
    }

    public static void enableMockProxy(boolean r100) {
        sEnableMockProxy = r100;
    }

    public static <T> T getApi(Class<T> r100) {
        T r101 = null;
        if (r100 != null) goto L18;
        Log.i(TAG, "getApi api is null");
        return null;
    L18:
        r101 = (T) ClaymoreServiceLoader.loadFirst(r100);
    L10:
        if (r101 != null) goto L20;
        Log.i(TAG, "getApi service is null,class name:" + r100.getName() + " sEnableMockProxy=" + sEnableMockProxy);
        if (sEnableMockProxy == false) goto L15;
        return (T) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class[]{r100}, handler);
    L15:
        if (isDebug() == false) goto L22;
        ViewUtils.showToastLong("need register(" + r100.getSimpleName() + ")");
        return r101;
    L22:
        return r101;
    L20:
        return r101;
    L8:
        e = move-exception;
        Log.e(TAG, e);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void invokeApi(Class<T> r100, a<T> r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        Object r102 = getApi(r100);
        if (r102 == null) goto L8;
        r101.consume(r102);
        return;
    }

    public static <T, E extends T> void register(Class<T> r100, Class<E> r101) {
        if (r100 != null) goto L6;
        Log.e(TAG, "api is null.");
        return;
    L6:
        if (r101 != null) goto L10;
        Log.e(TAG, "implClass is null.");
        return;
    L10:
        if (r100.isAssignableFrom(r101) == true) goto L13;
        Log.e(TAG, "The api of <" + r100.getSimpleName() + "> register failed: " + r101.getSimpleName() + " didn't implement api.");
        return;
    L13:
        API_IMPL_MAP.put(r100, r101);
        Log.d(TAG, "The api of <" + r100.getSimpleName() + "> register <" + r101.getSimpleName() + "> success.");
    }

    public static <T> void register(Class<T> r100, T r101) {
        if (r100 != null) goto L7;
        Log.e(TAG, "api is null.");
        return;
    L7:
        if (r101 != null) goto L10;
        Log.e(TAG, "The api of <" + r100.getSimpleName() + "> register failed: apiImpl is null.");
        return;
    L10:
        ServiceManager.registerService(r100, r101);
        Log.d(TAG, "The api of <" + r100.getSimpleName() + "> register <" + r101.getClass().getSimpleName() + "> instance success.");
    }
}
