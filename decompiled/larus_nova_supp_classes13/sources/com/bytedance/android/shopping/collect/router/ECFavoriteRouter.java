package com.bytedance.android.shopping.collect.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import bf.b;
import bf.e;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.collect.container.ECFavoriteActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECFavoriteRouter implements e {

    public static final class a {
    }

    static {
    }

    public ECFavoriteRouter() {
    }

    public final boolean a(Uri r6) {
        Intrinsics.checkNotNullParameter(r6, "uri");
        Lazy r0 = ECAppInfoService.a;
        boolean r1 = false;
        if (we.a.a == true) goto L5;
        return false;
    L5:
        int r2 = b.a;
        Integer r3 = null;
        if (r6 != null) goto L8;
        String r4 = null;
    L10:
        if ((!Intrinsics.areEqual(r4, "favorite")) == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r6, "tab_name"), "goods") == true) goto L25;
        String r7 = UriProtector.getQueryParameter(r6, "type");
        if (r7 == null) goto L18;
        r3 = StringsKt.toIntOrNull(r7);
    L18:
        if (r3 == null) goto L24;
        if (r3.intValue() != 6) goto L24;
        r1 = true;
    L24:
        return r1;
    L25:
        return true;
    L8:
        r4 = b.a(r6.getHost(), r6.getPath());
        goto L10
    }

    public final boolean open(final Context r8, final Uri r9, boolean r10, final boolean r11) {
        if (r8 == null) goto L18;
        if (r9 != null) goto L6;
        return false;
    L6:
        if ((r8 instanceof Activity) == true) goto L8;
        Context r0 = null;
    L9:
        Activity r2 = (Activity) r0;
        if (r10 == true) goto L16;
        if (r2 == null) goto L16;
        r r1 = r.a;
        if (r1.isLogin() == true) goto L16;
        r1.showLogin(r2, "favorite_login_guide", "favorite_login_guide_click", new AnonymousClass1(r8, r9, r11), null);
        return true;
    L16:
        int r12 = ECFavoriteActivity.m;
        ECFavoriteActivity.a.a(r8, r9, r11);
        return true;
    L8:
        r0 = r8;
        goto L9
    L18:
        return false;
    }
}
