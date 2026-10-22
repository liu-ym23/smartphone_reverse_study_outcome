package com.bytedance.locallife.hybrid.bullet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import b36.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class LifeBulletWebViewClient extends c26.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m16.b f259059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f259060c;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return (Context) this.f259060c.getValue();
    }

    public LifeBulletWebViewClient(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        this.f259059b = r100;
        this.f259060c = LazyKt.lazy(new LifeBulletWebViewClient$context$2(this));
    }

    @Override // b36.q
    public final boolean c(WebView r100, k r101) {
        if (r101 == null) goto L7;
        Uri r102 = r101.getUrl();
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        Context r104 = getContext();
        boolean r105 = false;
        if (r103 != null) goto L11;
    L13:
        if (r105 == false) goto L21;
        if (r104 == null) goto L21;
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r103));
        r106.setPackage(MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);
        if (r106.resolveActivity(r104.getPackageManager()) == null) goto L19;
        r104.startActivity(r106);
        return true;
    L19:
        super.c(r100, r101);
        throw null;
    L21:
        super.c(r100, r101);
        throw null;
    L11:
        if (StringsKt.startsWith$default(r103, "amapuri://route/plan", false, 2, null) != true) goto L13;
        r105 = true;
    L7:
        r103 = null;
        goto L8
    }
}
