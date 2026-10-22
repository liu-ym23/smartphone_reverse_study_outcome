package lhc;

import android.os.Bundle;
import com.ss.android.ugc.route_monitor.api.RouteLazyConfigProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<b> f509310a;

    public static List a() {
        if (f509310a != null) goto L10;
        RouteLazyConfigProxy r100 = RouteLazyConfigProxy.f454387b;
        if (r100.isLazy() == false) goto L7;
        List<b> r101 = CollectionsKt.toList(r100.routeOutPageReportConfigList());
    L8:
        f509310a = r101;
        goto L10
    L7:
        r101 = new ArrayList();
    L10:
        return f509310a;
    }

    static {
    }

    public static String b(String r100, String r101, Bundle r102) {
        List r103 = a();
        if (r103 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L23;
        b r105 = (b) r104.next();
        if (Intrinsics.areEqual(r105.a(), r100) == false) goto L7;
        if (r105.c() == false) goto L19;
        if (r102 == null) goto L22;
        Iterator<String> r106 = r102.keySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L22;
        String r107 = r106.next();
        if (Intrinsics.areEqual(r107, r105.b()) == false) goto L15;
        return r102.getString(r107, "");
    L22:
        return "";
    L19:
        if (r101 == null) goto L22;
        return r101;
    L23:
        if (r101 == null) goto L26;
        return r101;
    L26:
        return "";
    }
}
