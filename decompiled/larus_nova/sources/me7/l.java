package me7;

import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class l {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    public static Class a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Class<?>[] r101 = r100.getDeclaredClasses();
        ?? r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        boolean r105 = true;
        if (r104 >= r103) goto L13;
        Class<?> r106 = r101[r104];
        if (r106.getAnnotation(XBridgeParamModel.class) != null) goto L9;
        r105 = false;
    L9:
        if (r105 == false) goto L11;
        r102.add(r106);
    L11:
        r104 = r104 + 1;
        goto L3
    L13:
        if (r102.isEmpty() == false) goto L29;
        Class r107 = r100.getSuperclass();
        if (r107 == null) goto L27;
        Class<?>[] r108 = r107.getDeclaredClasses();
        if (r108 == null) goto L27;
        r102 = new ArrayList();
        int r109 = r108.length;
        int r110 = 0;
    L19:
        if (r110 >= r109) goto L29;
        Class<?> r111 = r108[r110];
        if (r111.getAnnotation(XBridgeParamModel.class) == null) goto L23;
        boolean r112 = true;
    L24:
        if (r112 == false) goto L26;
        r102.add(r111);
    L26:
        r110 = r110 + 1;
        goto L19
    L23:
        r112 = false;
    L27:
        r102 = CollectionsKt.emptyList();
    L29:
        if (r102.isEmpty() == false) goto L31;
        return null;
    L31:
        Object r113 = CollectionsKt.first(r102);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type java.lang.Class<out com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel>");
        return (Class) r113;
    }
}
