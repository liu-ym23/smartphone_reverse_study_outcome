package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.luckycat.impl.utils.x;
import com.bytedance.ug.sdk.luckycat.impl.utils.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class LuckyCatContainerIDManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, WeakReference<c>> f271169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, WeakReference<c>>> f271170b = null;

    static {
        f271169a = new LinkedHashMap();
        f271170b = new LinkedHashMap();
    }

    public static void a(final List r100) {
        if (((ArrayList) r100).isEmpty() == true) goto L11;
        Function0<Unit> r101 = new LuckyCatContainerIDManager$registerXBridges$1(r100);
        Handler r102 = y.f271530a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L8;
        r101.invoke();
        return;
    L8:
        y.f271530a.post(new x(r101));
        return;
    }
}
