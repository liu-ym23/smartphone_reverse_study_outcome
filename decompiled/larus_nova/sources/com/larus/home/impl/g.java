package com.larus.home.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.h1;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements q97.a {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 == null) goto L6;
        Uri r101 = r100.f267530d;
        if (r101 == null) goto L6;
        String r102 = r101.getHost();
    L7:
        e10 r103 = e10.f368561a;
        return CollectionsKt.contains(e10.a0().keySet(), r102);
    L6:
        r102 = null;
        goto L7
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r110) {
        if (r100 == null) goto L28;
        if (r110 == null) goto L28;
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == true) goto L10;
        t19.s.j(t19.s.f544207a, r100, r100.getString(R.string.larus_LarkIM_Friend_LinkUnsupported_Toast), null, false, 28);
        return false;
    L10:
        Uri r101 = r110.f267530d;
        if (r101 == null) goto L13;
        String r102 = r101.getHost();
    L14:
        e10 r103 = e10.f368561a;
        String r104 = (String) e10.a0().get(r102);
        if (r104 == null) goto L28;
        Uri r111 = r110.f267530d;
        Uri.Builder r105 = UriProtector.parse(r104).buildUpon();
        if (r111 == null) goto L26;
        Set<String> r106 = UriProtector.getQueryParameterNames(r111);
        if (r106 == null) goto L26;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        String r108 = (String) r107.next();
        String r109 = UriProtector.getQueryParameter(r111, r108);
        if (r109 == null) goto L22;
        r105.appendQueryParameter(r108, r109);
    L26:
        String r112 = r105.build().toString();
        FLogger.f375446a.i("LarkOfficeAppLinkInterceptor", "onInterceptRoute mapping " + r102 + " -> " + r112);
        return h1.f365744a.N(r100, r112);
    L13:
        r102 = null;
    L28:
        return false;
    }
}
