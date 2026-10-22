package com.ss.android.lark.chameleon.bridge;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Utils;", "", "()V", "sGson", "Lcom/google/gson/Gson;", "combineRequestContent", "", ExifInterface.GPS_DIRECTION_TRUE, "functionName", "functionParam", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "getGenericClass", "Ljava/lang/Class;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "getGenericInterfaceClass", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = null;
    private static final Gson sGson = null;

    private Utils() {
    }

    static {
        INSTANCE = new Utils();
        sGson = new Gson();
    }

    private final Class<?> getGenericInterfaceClass(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Class<?> r101 = r100.getClass();
    L6:
        boolean r102 = true;
        if (r101 == null) goto L14;
        if (r101.getGenericInterfaces().length != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101 = r101.getSuperclass();
        goto L6
    L11:
        r103 = false;
    L14:
        if (r101 != null) goto L16;
        return null;
    L16:
        Type[] r104 = r101.getGenericInterfaces();
        if (r104.length > 0) goto L19;
    L18:
        Type[] r105 = null;
    L22:
        if (r105 != null) goto L24;
        return null;
    L24:
        if (r105.length == 0) goto L27;
        r102 = false;
    L27:
        if (r102 == true) goto L37;
        Type r106 = r105[0];
        if ((r106 instanceof Class) == true) goto L32;
        return null;
    L32:
        return (Class) r106;
    L37:
        return null;
    L19:
        Type r107 = r104[0];
        if ((r107 instanceof ParameterizedType) == false) goto L18;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        r105 = ((ParameterizedType) r107).getActualTypeArguments();
        goto L22
    }

    public final Class<?> getGenericClass(Object r100) {
        Class<?> r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Type r102 = r100.getClass().getGenericSuperclass();
        if ((r102 instanceof ParameterizedType) == false) goto L16;
        Type[] r103 = ((ParameterizedType) r102).getActualTypeArguments();
        if (r103.length != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L16;
        Type r105 = r103[0];
        if ((r105 instanceof Class) == false) goto L16;
        r101 = (Class) r105;
        goto L16
    L10:
        r104 = false;
    L16:
        if (r101 == null) goto L18;
        return r101;
    L18:
        return getGenericInterfaceClass(r100);
    }

    public final <T> String combineRequestContent(String r100, T r101) {
        return new Regex("\n").replace(r100 + '(' + JsonUtils.INSTANCE.toJsonString(r101) + ')', "\\\\n");
    }
}
