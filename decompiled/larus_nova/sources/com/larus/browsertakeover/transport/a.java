package com.larus.browsertakeover.transport;

import android.net.Uri;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.platform.service.AccountService;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f319669a = null;

    static {
        f319669a = new a();
    }

    public a() {
    }

    public static Map b() {
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == false) goto L5;
        String r101 = r100.getXTTToken();
        if (r101 == null) goto L44;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L44;
        if (r102.length() <= 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
    L18:
        boolean r104 = false;
    L19:
        String r105 = null;
        if (r104 == true) goto L23;
        r102 = null;
    L23:
        if (r102 == null) goto L44;
        int r106 = 0;
    L26:
        if (r106 >= r102.length()) goto L37;
        char r107 = r102.charAt(r106);
        if (r107 != '\r') goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == true) goto L35;
        r106 = r106 + 1;
        goto L26
    L35:
        boolean r109 = false;
    L38:
        if (r109 == false) goto L40;
        r105 = r102;
    L40:
        if (r105 == null) goto L44;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("Passport-Auth", AppbrandHostConstants.SCHEMA_INSPECT.SESSION), TuplesKt.to("sdk-version", "2"), TuplesKt.to(LoginVerifyService.X_TT_TOKEN, r105)});
    L30:
        if (r107 == '\n') goto L33;
        r108 = false;
        goto L34
    L37:
        r109 = true;
        goto L38
    L16:
        if (r102.length() > 4096) goto L18;
        r104 = true;
        goto L19
    L13:
        r103 = false;
    L44:
        return MapsKt.emptyMap();
    L5:
        return MapsKt.emptyMap();
    }

    public static void a(Uri r100, Uri.Builder r101, String r102, String r103) {
        boolean r104 = false;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L23;
        return;
    L23:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L10
        Object r107 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r100, r102));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r107) == false) goto L15;
        r107 = null;
    L15:
        String r108 = (String) r107;
        if (r108 != null) goto L18;
    L19:
        r104 = true;
    L20:
        if (r104 == false) goto L25;
        r101.appendQueryParameter(r102, r103);
        return;
    L25:
        return;
    L18:
        if (r108.length() != 0) goto L20;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        r105 = false;
        goto L6
    }
}
