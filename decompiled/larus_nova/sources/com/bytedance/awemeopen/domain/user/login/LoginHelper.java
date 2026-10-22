package com.bytedance.awemeopen.domain.user.login;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.LoginMethod;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.user.serviceapi.AoLoginBaseService;
import com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService;
import com.bytedance.awemeopen.user.serviceapi.onekey.AoOneKeyLoginService;
import com.bytedance.awemeopen.user.serviceapi.silent.AoSilentLoginService;
import java.util.HashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class LoginHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoginHelper f198497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AoLoginBaseService f198498b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f198499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashSet<Function2<String, u64.b, Unit>> f198500d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashSet<Function0<Unit>> f198501e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static com.bytedance.awemeopen.domain.user.login.a f198502f;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f198503a;

        public b(e r100) {
            this.f198503a = r100;
        }

        @Override // com.bytedance.awemeopen.domain.user.login.e
        public final void a(LoginMethod r100, u64.b r101) {
            Intrinsics.checkNotNullParameter(r100, "loginMethod");
            Intrinsics.checkNotNullParameter(r101, "result");
            e r102 = this.f198503a;
            if (r102 == null) goto L5;
            r102.a(r100, r101);
        L5:
            LoginHelper r103 = LoginHelper.f198497a;
            LoginHelper.b();
        }

        @Override // com.bytedance.awemeopen.domain.user.login.e
        public final void b(LoginMethod r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "loginMethod");
            e r103 = this.f198503a;
            if (r103 == null) goto L6;
            r103.b(r100, r101, r102);
            return;
        }
    }

    public LoginHelper() {
    }

    static {
        f198497a = new LoginHelper();
        AoLoginBaseService r100 = (AoLoginBaseService) j64.a.a(AoLoginBaseService.class);
        f198498b = r100;
        f198499c = "";
        f198500d = new HashSet();
        f198501e = new HashSet();
        if (r100 == null) goto L6;
        r100.b1(new a());
        return;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.awemeopen.domain.user.login.a, java.lang.Runnable] */
    public static u64.b b() {
        AoLoginBaseService r100 = f198498b;
        String r101 = null;
        if (r100 == null) goto L5;
        final u64.b r102 = r100.getAccessToken();
    L6:
        if (r102 == null) goto L8;
        r101 = r102.f548920a;
    L8:
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        final String r103 = f198499c;
        if (Intrinsics.areEqual(r101, r103) == true) goto L16;
        f198499c = r101;
        com.bytedance.awemeopen.domain.user.login.a r104 = f198502f;
        if (r104 == null) goto L15;
        AoPool r105 = AoPool.f198803a;
        Intrinsics.checkNotNullParameter(r104, "task");
        AoPool.f198803a.getClass();
        AoPool.c().p1(r104);
    L15:
        ?? r106 = new com.bytedance.awemeopen.domain.user.login.a(r103, r102);
        AoPool.d(r106, 1);
        f198502f = r106;
    L16:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static void a(c24.b r100, d24.a r101, b24.a r102) {
        boolean r103 = true;
        if (r100 == null) goto L13;
        AoOneKeyLoginService r104 = com.bytedance.awemeopen.domain.user.login.onekey.a.f198541a;
        if (r104 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == false) goto L13;
        if (r104 == null) goto L30;
        r104.a();
        return;
    L30:
        return;
    L7:
        if (com.bytedance.awemeopen.domain.user.login.onekey.a.f198542b == null) goto L9;
        r105 = true;
    L13:
        if (r101 == null) goto L21;
        AoSilentLoginService r106 = k44.a.f501758a;
        if (r106 == null) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L21;
        if (r106 == null) goto L32;
        r106.a();
        return;
    L32:
        return;
    L17:
        r107 = false;
    L21:
        if (r102 == null) goto L34;
        AoNormalLoginService r108 = com.bytedance.awemeopen.domain.user.login.normal.a.f198533a;
        if (r108 != null) goto L26;
        r103 = false;
    L26:
        if (r103 == false) goto L35;
        if (r108 == null) goto L36;
        r108.a();
        return;
    L36:
        return;
    L35:
        return;
    }

    public static void c(final Activity r100, final String r101, c24.b r110, d24.a r111, b24.a r112, e r113, Map r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginSource");
        final b r102 = new b(r113);
        boolean r115 = true;
        if (r110 != null) goto L5;
    L12:
        if (r111 != null) goto L14;
    L19:
        if (r112 != null) goto L21;
        return;
    L21:
        if (com.bytedance.awemeopen.domain.user.login.normal.a.f198533a != null) goto L24;
        r115 = false;
    L24:
        if (r115 == false) goto L30;
        com.bytedance.awemeopen.domain.user.login.normal.a.a(r100, r101, r102);
        return;
    L30:
        return;
    L14:
        if (k44.a.f501758a == null) goto L16;
        boolean r116 = true;
    L17:
        if (r116 == false) goto L19;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginSource");
        Intrinsics.checkNotNullParameter(r111, "silentLoginHandler");
        r111.a();
        return;
    L16:
        r116 = false;
        goto L17
    L5:
        if (com.bytedance.awemeopen.domain.user.login.onekey.a.f198541a != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        com.bytedance.awemeopen.domain.user.login.onekey.a.a(r100, r101, r114, r110, new LoginHelper$refreshAccessToken$1(r100, r101, r102), r102);
        return;
    L7:
        if (com.bytedance.awemeopen.domain.user.login.onekey.a.f198542b == null) goto L9;
        r103 = true;
        goto L10
    }
}
