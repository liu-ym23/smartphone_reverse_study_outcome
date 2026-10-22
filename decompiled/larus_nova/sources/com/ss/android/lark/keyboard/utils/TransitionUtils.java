package com.ss.android.lark.keyboard.utils;

import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class TransitionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f430954a = null;

    static {
        f430954a = LazyKt.lazy(TransitionUtils$sPendingTransitionsField$2.INSTANCE);
    }

    public static boolean a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneRoot");
        Field r101 = (Field) f430954a.getValue();
        ArrayList r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get(null);
    L7:
        if ((r103 instanceof ArrayList) == false) goto L9;
        r102 = (ArrayList) r103;
    L9:
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.contains(r100) != true) goto L13;
        return true;
    L5:
        r103 = null;
        goto L7
    }
}
