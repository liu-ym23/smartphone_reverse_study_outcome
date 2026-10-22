package zva;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.log.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573773a = 0;

    public static final class a {
        public static Object b(Class r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
        L17:
            return r100.getDeclaredConstructor((Class[]) Arrays.copyOf(new Class[0], 0)).newInstance(Arrays.copyOf(new Object[0], 0));
        L9:
            e = move-exception;
            Log.e("ReflectUtils", "failed to newInstance, e:" + e);
        L13:
            return null;
        L11:
            e = move-exception;
            Log.e("ReflectUtils", "failed to newInstance, e:" + e);
        L5:
            e = move-exception;
            Log.e("ReflectUtils", "failed to newInstance, e:" + e);
        L7:
            e = move-exception;
            Log.e("ReflectUtils", "failed to newInstance, e:" + e);
            goto L13
        }

        public static Object a(Object r100, Class r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r102, "parseMethod");
            Intrinsics.checkNotNullParameter(r103, "jsonStr");
            Object r104 = r101.getDeclaredMethod(r102, new Class[]{String.class}).invoke(r100, new Object[]{r103});     // Catch: NoSuchMethodException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 IllegalArgumentException -> L14
            if (r104 != null) goto L7;
            return r100;
        L7:
            return r104;
        L12:
            e = move-exception;
            Log.e("ReflectUtils", "failed to invoke, e:" + e);
            return null;
        L14:
            e = move-exception;
            Log.e("ReflectUtils", "failed to invoke, e:" + e);
            return null;
        L8:
            e = move-exception;
            Log.e("ReflectUtils", "failed to invoke, e:" + e);
            return null;
        L10:
            e = move-exception;
            Log.e("ReflectUtils", "failed to invoke, e:" + e);
            return null;
        }
    }

    static {
    }
}
