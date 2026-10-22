package com.bytedance.awemeopen.domain.user.login.onekey;

import android.app.Activity;
import c24.b;
import com.bytedance.awemeopen.bizmodels.user.AoLoginErrorCode;
import com.bytedance.awemeopen.bizmodels.user.LoginMethod;
import com.bytedance.awemeopen.domain.user.login.LoginHelper;
import com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService;
import com.bytedance.awemeopen.user.serviceapi.onekey.AoOneKeyLoginService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AoOneKeyLoginService f198541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AoNormalLoginService f198542b = null;

    static {
        f198541a = (AoOneKeyLoginService) j64.a.a(AoOneKeyLoginService.class);
        f198542b = (AoNormalLoginService) j64.a.a(AoNormalLoginService.class);
    }

    public static void a(final Activity r100, final String r110, final Map r111, final b r112, final Function1 r113, final LoginHelper.b r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "loginSource");
        Intrinsics.checkNotNullParameter(r112, "oneKeyPhoneNumberHandler");
        Intrinsics.checkNotNullParameter(r113, "fallback");
        AoOneKeyLoginService r101 = f198541a;
        if (r101 != null) goto L5;
    L9:
        LoginMethod r102 = LoginMethod.ONE_KEY;
        Lazy r115 = AoLoginErrorCode.f198214a;
        r114.b(r102, -1, "手机号一键登录未实现");
        return;
    L5:
        if (f198542b == null) goto L9;
        final Function1<String, Unit> r103 = new OneKeyLogin$login$handler$1(r112, r100, r110, r111, r113, r114);
        Function0<Unit> r116 = new OneKeyLogin$login$afterHostLogin$1(r100, r113, r114, r103);
        r101.isHostLogin();
        r116.invoke();
    }
}
