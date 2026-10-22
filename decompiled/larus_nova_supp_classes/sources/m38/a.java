package m38;

import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.api.UserAction;
import com.larus.account.base.model.AccountStatus;
import com.larus.account.base.model.LoginPlatform;
import com.larus.platform.service.g;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import n38.j;
import org.xmlpull.v1.XmlPullParser;
import xg9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final a a = null;
    public static final Keva b = null;
    public static boolean c;
    public static final boolean d = false;
    public static volatile Pair<String, ? extends LoginPlatform> e;

    public a() {
    }

    static {
        a = new a();
        b = Keva.getRepo("default", 0);
        e10 r0 = e10.a;
        d = e10.g();
    }

    public static LoginPlatform a(String r7) {
        boolean r2 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L14;
        FLogger.a.e("AccountHelper", "get account platform got invalid uid, return null");
        return null;
    L14:
        if (d == false) goto L36;
        Pair<String, ? extends LoginPlatform> r5 = e;
        if (r5 == null) goto L36;
        if (Intrinsics.areEqual(r5.getFirst(), r7) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L36;
        return r5.getSecond();
    L36:
        Keva r6 = b;     // Catch: Throwable -> L35
        String r1 = r6.getString("login_platform_" + r7, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L35
        if (r1 != null) goto L27;
    L30:
        if (r2 == false) goto L32;
        r1 = r6.getString("login_platform", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L35
    L32:
        LoginPlatform r0 = f(r1);     // Catch: Throwable -> L35
        e = TuplesKt.to(r7, r0);     // Catch: Throwable -> L35
        return r0;
    L27:
        if (r1.length() == 0) goto L30;
        r2 = false;
    L38:
        return null;
    L5:
        if (r7.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    public static LoginPlatform f(String r2) {
        if (r2 == null) goto L22;
        int r0 = r2.hashCode();
        if (r0 == (-979246518)) goto L19;
        if (r0 == (-893555025)) goto L15;
        if (r0 != 949110328) goto L22;
        if (r2.equals("login_platform_phone") == false) goto L22;
        return LoginPlatform.PHONE;
    L15:
        if (r2.equals("login_platform_google") == false) goto L22;
        return LoginPlatform.GOOGLE;
    L19:
        if (r2.equals("login_platform_douyin") == false) goto L22;
        return LoginPlatform.DOUYIN;
    L22:
        if (r2 != null) goto L24;
    L27:
        boolean r1 = true;
    L28:
        Object r3 = null;
        if (r1 == true) goto L46;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L33
        Object r5 = Result.m49constructorimpl(LoginPlatform.valueOf(r2));     // Catch: Throwable -> L33
    L36:
        if (Result.m55isFailureimpl(r5) == true) goto L40;
        r3 = r5;
    L40:
        return (LoginPlatform) r3;
    L33:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L36
    L46:
        return null;
    L24:
        if (r2.length() == 0) goto L27;
        r1 = false;
        goto L28
    }

    public static void e(String r7, LoginPlatform r8) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        FLogger.a.e("AccountHelper", "save account platform got invalid uid, return");
        return;
    L12:
        if (r8 != null) goto L14;
        int r3 = -1;
    L15:
        Pair<String, ? extends LoginPlatform> r4 = null;
        if (r3 != 1) goto L18;
        String r5 = "login_platform_phone";
    L27:
        b.storeString("login_platform_" + r7, r5);
        if (r5 != null) goto L30;
    L31:
        r0 = true;
    L32:
        if (r0 == true) goto L35;
        r4 = TuplesKt.to(r7, r8);
    L35:
        e = r4;
        return;
    L30:
        if (r5.length() != 0) goto L32;
    L18:
        if (r3 != 2) goto L20;
        r5 = "login_platform_google";
        goto L27
    L20:
        if (r3 == 3) goto L24;
        if (r8 == null) goto L23;
        r5 = r8.name();
        goto L27
    L23:
        r5 = null;
        goto L27
    L24:
        r5 = "login_platform_douyin";
        goto L27
    L14:
        r3 = a.a[r8.ordinal()];
        goto L15
    L5:
        if (r7.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void b(String r4, LoginPlatform r5, UserAction r6) {
        Intrinsics.checkNotNullParameter(r4, "businessScene");
        Intrinsics.checkNotNullParameter(r6, "action");
        q38.a r2 = ILoginService.a.getAccountInfo();
        if (r6 != UserAction.USER_LOGIN) goto L5;
        e(r2.c, r5);
        IMultiAccountService.a.onLoginSuccess();
    L5:
        n38.c r7 = new n38.c(r2.c, r2.d);
        List<j> r3 = c.a;
        Intrinsics.checkNotNullParameter(r7, "user");
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r4, "businessScene");
        FLogger.a.i("AccountStatusManager", "dispatch userDidOnline, uid = " + r7.a + ", action = " + r6 + ", businessScene = " + r4);
        n38.a r0 = new n38.a(AccountStatus.LOGGED_IN, r7, r6, r4);
        c.b = r0;
        List<j> r8 = c.a;
        if (r8 == null) goto L11;
        Iterator r9 = ((CopyOnWriteArrayList) r8).iterator();
    L9:
        if (r9.hasNext() == false) goto L13;
        ((j) r9.next()).b(r0);
        goto L9
    L13:
        return;
    }

    public static /* synthetic */ void c(a r1, String r2, LoginPlatform r3) {
        UserAction r0 = UserAction.USER_LOGIN;
        r1.getClass();
        b(r2, r3, r0);
    }

    public static void d(String r6, UserAction r7, n38.c r8) {
        Intrinsics.checkNotNullParameter(r6, "businessScene");
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r8, "beforeAccountInfo");
        e(r8.a, null);
        b.a().storeBoolean("key_has_profile_overview_data", false);
        b.a().storeString("key_profile_overview_data", XmlPullParser.NO_NAMESPACE);
        g.a.monitorEventForSlardar("logout_and_clear_profile_data", null, null, null);
        FLogger r2 = FLogger.a;
        r2.i("LoginServiceImpl", "logout_and_clear_profile_data");
        if (r7 != UserAction.USER_LOGOUT) goto L5;
        IMultiAccountService.a.h(r8.b);
    L5:
        List<j> r3 = c.a;
        Intrinsics.checkNotNullParameter(r8, "user");
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r6, "businessScene");
        r2.i("AccountStatusManager", "dispatch userDidOffline, uid = " + r8.a + ", action = " + r7 + ", businessScene = " + r6);
        n38.a r0 = new n38.a(AccountStatus.LOGGED_OUT, r8, r7, r6);
        c.b = r0;
        List<j> r9 = c.a;
        if (r9 == null) goto L11;
        Iterator r10 = ((CopyOnWriteArrayList) r9).iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        ((j) r10.next()).a(r0);
        goto L9
    L13:
        return;
    }
}
