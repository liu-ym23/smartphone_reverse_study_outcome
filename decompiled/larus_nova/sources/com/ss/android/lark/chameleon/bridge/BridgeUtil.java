package com.ss.android.lark.chameleon.bridge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.ReflectUtils;

/* JADX INFO: loaded from: classes35.dex */
public class BridgeUtil {
    private static final Gson GSON = null;
    private static final String TAG = "BridgeUtil";

    public BridgeUtil() {
    }

    static {
        GSON = new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void handleJSMsg(String r100, JSHandler<T> r101, CallBackFunction r102) {
        Class<T> r103 = ReflectUtils.getGenericClass(r101);
        if (r103 != null) goto L5;
        r103 = ReflectUtils.getGenericInterfaceClass(r101);
    L5:
        Object r104 = null;
        if (r103 != null) goto L17;
        r101.handle(null, r102);
        return;
    L17:
    L13:
        th = move-exception;
        Log.e(TAG, "handleJSMsg PARSE_DATA_ERR  data： " + r100 + "    clazz： " + r103 + "  e: " + th);
    L15:
        r101.handle(r104, r102);
        return;
    L9:
        if (r103.equals(String.class) == false) goto L11;
        Object r105 = r100;
    L12:
        r104 = r105;
        goto L15
    L11:
        r105 = GSON.fromJson(r100, r103);     // Catch: Throwable -> L13
        goto L12
    }
}
