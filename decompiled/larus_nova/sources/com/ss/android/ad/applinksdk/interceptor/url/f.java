package com.ss.android.ad.applinksdk.interceptor.url;

import com.ss.android.ad.applinksdk.model.AppLinkResult;
import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements com.ss.android.ad.applinksdk.interceptor.a {
    public f() {
    }

    @Override // com.ss.android.ad.applinksdk.interceptor.a
    public final AppLinkResult intercept(com.ss.android.ad.applinksdk.interceptor.b r100) {
        ira.d r101 = r100.f406370b.f406366b;
        if (r101.f495527c == false) goto L46;
        if (r101.f495532h == false) goto L46;
        String r102 = r101.f495529e;
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
        JSONArray r104 = mra.c.a().optJSONArray("settings_block_list");
        if (r104 != null) goto L20;
    L24:
        ArrayList r105 = (ArrayList) mra.c.f515037b;
        r105.addAll(((c) r100.f406370b.f406365a.getValue()).f406376a);
        String r106 = r100.f406370b.f406366b.f495529e;
        if (r106 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        Iterator r107 = r105.iterator();
    L29:
        if (r107.hasNext() == false) goto L33;
        Object r108 = r107.next();
        if (StringsKt.startsWith$default(r106, (String) r108, false, 2, null) == false) goto L29;
    L34:
        if (r108 == null) goto L44;
        int r109 = MonitorUtils.f406394a;
        com.ss.android.ad.applinksdk.core.d.f406360e.getClass();
        com.ss.android.ad.applinksdk.core.d.b().getClass();
        ira.e r110 = r100.f406370b.f406367c;
        r110.f495545d.f495533i = true;
        com.ss.android.ad.applinksdk.core.b.c("applink_click", null, r110);
        AppLinkResult.Type.Companion.getClass();
        AppLinkResult.Message.Companion.getClass();
        AppLinkResult r111 = new AppLinkResult(1, 18);
        ira.e r112 = r100.f406370b.f406367c;
        ira.b r113 = r112.f495542a;
        if (r113 != null) goto L38;
    L42:
        return r111;
    L38:
        if (r113.f495506d != true) goto L42;
        com.ss.android.ad.applinksdk.core.a r114 = r112.f495543b;
        if (r114 == null) goto L42;
        r114.onResponse(r111);
        goto L42
    L44:
        return r100.a();
    L33:
        r108 = null;
        goto L34
    L20:
        if (((ArrayList) mra.c.f515037b).isEmpty() == false) goto L24;
        int r115 = r104.length();
        int r116 = 0;
    L22:
        if (r116 >= r115) goto L24;
        ((ArrayList) mra.c.f515037b).add(r104.optString(r116));
        r116 = r116 + 1;
        goto L22
    L16:
        return r100.a();
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
    L46:
        return r100.a();
    }
}
