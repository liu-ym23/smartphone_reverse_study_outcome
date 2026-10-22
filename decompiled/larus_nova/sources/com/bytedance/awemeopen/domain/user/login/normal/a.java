package com.bytedance.awemeopen.domain.user.login.normal;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.AoLoginErrorCode;
import com.bytedance.awemeopen.bizmodels.user.LoginMethod;
import com.bytedance.awemeopen.domain.user.login.LoginHelper;
import com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AoNormalLoginService f198533a = null;

    static {
        f198533a = (AoNormalLoginService) j64.a.a(AoNormalLoginService.class);
    }

    public static void a(final Activity r100, String r101, final LoginHelper.b r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginSource");
        AoNormalLoginService r103 = f198533a;
        if (r103 != null) goto L7;
        if (r102 == null) goto L9;
        LoginMethod r104 = LoginMethod.NORMAL;
        Lazy r105 = AoLoginErrorCode.f198214a;
        r102.b(r104, -1, "service not found");
        return;
    L9:
        return;
    L7:
        Function0<Unit> r106 = new NormalLogin$login$afterHostLogin$1(r100, r102);
        r103.isHostLogin();
        r106.invoke();
    }
}
