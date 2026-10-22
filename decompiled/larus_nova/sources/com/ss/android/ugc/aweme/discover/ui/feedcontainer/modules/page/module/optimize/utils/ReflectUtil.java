package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.utils;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/utils/ReflectUtil;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReflectUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReflectUtil f450784a = null;

    private ReflectUtil() {
    }

    static {
        f450784a = new ReflectUtil();
    }

    public static Field a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter(r101, "fieldName");
        Class<?> r102 = r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "clazz");
        Intrinsics.checkNotNullParameter(r101, "fieldName");
    L3:
        if (r102 == null) goto L12;
        Field[] r103 = r102.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        Field r106 = r103[r105];
        if (Intrinsics.areEqual(r106.getName(), r101) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        r106.setAccessible(true);
        return r106;
    L10:
        r102 = r102.getSuperclass();
        goto L3
    L12:
        return null;
    }

    public static Method b(Object r100, String r101, Class... r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r102, "parameterTypes");
        Class<?> r103 = r100.getClass();
    L3:
        if (r103 == null) goto L8;
        Method r104 = r103.getDeclaredMethod(r101, (Class[]) Arrays.copyOf(r102, r102.length));     // Catch: Exception -> L6
        r104.setAccessible(true);     // Catch: Exception -> L6
        return r104;
    L6:
        r103 = r103.getSuperclass();
        goto L3
    L8:
        return null;
    }
}
