package com.ss.android.lark.security.compliance.infra.network;

import com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f440441a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        x18.b r101 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getLarkHttpClient();
        if (r101 == null) goto L5;
        List<a28.a> r102 = r101.a(r100);
    L6:
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        a28.a r104 = (a28.a) r103.next();
        if (Intrinsics.areEqual(r104.f1421a, "sl_session") == false) goto L9;
        return r104.f1422b;
    L14:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        HttpUrl r102 = HttpUrl.parse(r100);
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L29;
        if (r102 == null) goto L30;
        okhttp3.g r104 = okhttp3.g.c(r102, r101);
        if (r104 == null) goto L31;
        a28.a.C0006a r105 = new a28.a.C0006a();
        r105.c(r104.f523855a);
        r105.e(r104.f523856b);
        r105.b(r104.f523857c);
        r105.a(r104.f523858d);
        r105.d(r104.f523859e);
        if (r104.f523860f == false) goto L17;
        r105.f1434f = true;
    L17:
        if (r104.f523861g == false) goto L20;
        r105.f1435g = true;
    L20:
        if (r104.f523863i == false) goto L23;
        r105.f1435g = true;
    L23:
        if (r104.f523862h == false) goto L25;
        r105.f1435g = true;
    L25:
        ArrayList r106 = new ArrayList();
        a28.a r107 = new a28.a(r105);
        Intrinsics.checkNotNull(r107);
        r106.add(r107);
        x18.b r108 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getLarkHttpClient();
        if (r108 == null) goto L32;
        r108.b(r100, r106);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
