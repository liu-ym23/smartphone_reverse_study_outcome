package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.app.Application;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.officesdk.utils.di.e;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> f411292a = null;

    public static boolean a() {
        int r100 = com.ss.android.lark.officesdk.utils.di.d.f437220a;     // Catch: Exception -> L8
        Application r101 = com.ss.android.lark.officesdk.utils.di.d.a.a();     // Catch: Exception -> L8
        int r102 = e.f437221a;     // Catch: Exception -> L8
        boolean r103 = e.a.b(r101);     // Catch: Exception -> L8
        boolean r104 = e.a.a(r101);     // Catch: Exception -> L8
        if (r103 == true) goto L6;
        if (r104 == true) goto L6;
        return false;
    L6:
        return true;
    L8:
        e = move-exception;
        j.b("CML_TAG_ContainerUtils", "get debug status error: e:" + e);
        return false;
    }

    static {
        f411292a = new LinkedHashMap();
    }

    @JvmStatic
    public static final ChameleonConfig b(String r110) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Pair r111 = (Pair) ((LinkedHashMap) f411292a).get(r110);
        if (r111 == null) goto L7;
        ChameleonConfig r112 = (ChameleonConfig) r111.getFirst();
        if (r112 == null) goto L7;
        return r112;
    L7:
        return new ChameleonConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @JvmStatic
    public static final List<AbsChameleonPlugin> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Pair r101 = (Pair) ((LinkedHashMap) f411292a).get(r100);
        if (r101 == null) goto L7;
        List<AbsChameleonPlugin> r102 = (List) r101.getSecond();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return CollectionsKt.emptyList();
    }

    public static String d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return "";
    L12:
        int r102 = StringsKt.indexOf$default(r100, "?", 0, false, 6, null);
        if (r102 <= (-1)) goto L16;
        r100 = r100.substring(0, r102);
    L16:
        if (r100.length() > 1024) goto L18;
        return r100;
    L18:
        return r100.substring(0, 1024);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final void e(String r100, ChameleonConfig r101, List<? extends AbsChameleonPlugin> r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "bizPlugins");
        f411292a.put(r100, new Pair(r101, r102));
    }
}
