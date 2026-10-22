package com.bytedance.sdk.xbridge.cn.optimize;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class OptimizeConfigKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f269934a = null;

    static {
        f269934a = LazyKt.lazy(OptimizeConfigKt$serialThreadPool$2.INSTANCE);
    }

    public static final IDLXBridgeMethod.XBridgeThreadType a(List<c> r100, le7.a<?> r110) {
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
        if (r100 == null) goto L57;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L57;
        c r102 = (c) r101.next();
        HashSet<String> r103 = r102.f269940a;
        boolean r104 = false;
        if (r103 == null) goto L19;
        Iterator<T> r105 = r103.iterator();
    L10:
        boolean r106 = true;
    L12:
        if (r105.hasNext() == false) goto L20;
        String r107 = (String) r105.next();
        if (Intrinsics.areEqual(r107, "bdx_thread_opt_all_schema") == true) goto L10;
        if (StringsKt.contains$default(r110.d(), r107, false, 2, null) == true) goto L12;
        r106 = false;
    L20:
        if (r106 == false) goto L6;
        HashSet<String> r108 = r102.f269941b;
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == true) goto L30;
        HashSet<String> r111 = r102.f269942c;
        if (r111 != null) goto L34;
    L36:
        boolean r112 = false;
    L37:
        if (r112 == true) goto L39;
        HashSet<String> r113 = r102.f269943d;
        if (r113 != null) goto L43;
    L45:
        boolean r114 = false;
    L46:
        if (r114 == true) goto L48;
        HashSet<String> r115 = r102.f269944e;
        if (r115 != null) goto L52;
    L54:
        if (r104 == false) goto L57;
        return IDLXBridgeMethod.XBridgeThreadType.MAIN_THREAD_OPT;
    L52:
        if (r115.contains(r110.f508943a) != true) goto L54;
        r104 = true;
        goto L54
    L48:
        return IDLXBridgeMethod.XBridgeThreadType.MAIN_THREAD;
    L43:
        if (r113.contains(r110.f508943a) != true) goto L45;
        r114 = true;
        goto L46
    L39:
        return IDLXBridgeMethod.XBridgeThreadType.ASYNC_THREAD;
    L34:
        if (r111.contains(r110.f508943a) != true) goto L36;
        r112 = true;
        goto L37
    L30:
        return IDLXBridgeMethod.XBridgeThreadType.SYNC_THREAD;
    L25:
        if (r108.contains(r110.f508943a) != true) goto L27;
        r109 = true;
        goto L28
    L19:
        r106 = true;
    L57:
        return null;
    }
}
