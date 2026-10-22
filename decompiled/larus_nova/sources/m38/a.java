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

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f511783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f511784b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f511785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f511786d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Pair<String, ? extends LoginPlatform> f511787e;

    /* JADX INFO: renamed from: m38.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes24.dex */
    public /* synthetic */ class C6766a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511788a = null;

        static {
            int[] r100 = new int[LoginPlatform.values().length];
            r100[LoginPlatform.PHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoginPlatform.GOOGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoginPlatform.DOUYIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f511788a = r100;
        }
    }

    public a() {
    }

    static {
        f511783a = new a();
        f511784b = Keva.getRepo("default", 0);
        e10 r100 = e10.f368561a;
        f511786d = e10.g();
    }

    public static LoginPlatform a(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        FLogger.f375446a.e("AccountHelper", "get account platform got invalid uid, return null");
        return null;
    L14:
        if (f511786d == false) goto L36;
        Pair<String, ? extends LoginPlatform> r103 = f511787e;
        if (r103 == null) goto L36;
        if (Intrinsics.areEqual(r103.getFirst(), r100) == true) goto L21;
        r103 = null;
    L21:
        if (r103 == null) goto L36;
        return r103.getSecond();
    L36:
        Keva r104 = f511784b;     // Catch: Throwable -> L35
        String r105 = r104.getString("login_platform_" + r100, "");     // Catch: Throwable -> L35
        if (r105 != null) goto L27;
    L30:
        if (r101 == false) goto L32;
        r105 = r104.getString("login_platform", "");     // Catch: Throwable -> L35
    L32:
        LoginPlatform r106 = f(r105);     // Catch: Throwable -> L35
        f511787e = TuplesKt.to(r100, r106);     // Catch: Throwable -> L35
        return r106;
    L27:
        if (r105.length() == 0) goto L30;
        r101 = false;
    L38:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public static LoginPlatform f(String r100) {
        if (r100 == null) goto L22;
        int r101 = r100.hashCode();
        if (r101 == (-979246518)) goto L19;
        if (r101 == (-893555025)) goto L15;
        if (r101 != 949110328) goto L22;
        if (r100.equals("login_platform_phone") == false) goto L22;
        return LoginPlatform.PHONE;
    L15:
        if (r100.equals("login_platform_google") == false) goto L22;
        return LoginPlatform.GOOGLE;
    L19:
        if (r100.equals("login_platform_douyin") == false) goto L22;
        return LoginPlatform.DOUYIN;
    L22:
        if (r100 != null) goto L24;
    L27:
        boolean r102 = true;
    L28:
        Object r103 = null;
        if (r102 == true) goto L46;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L33
        Object r105 = Result.m9449constructorimpl(LoginPlatform.valueOf(r100));     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r105) == true) goto L40;
        r103 = r105;
    L40:
        return (LoginPlatform) r103;
    L33:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L46:
        return null;
    L24:
        if (r100.length() == 0) goto L27;
        r102 = false;
        goto L28
    }

    public static void e(String r100, LoginPlatform r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        FLogger.f375446a.e("AccountHelper", "save account platform got invalid uid, return");
        return;
    L12:
        if (r101 != null) goto L14;
        int r104 = -1;
    L15:
        Pair<String, ? extends LoginPlatform> r105 = null;
        if (r104 != 1) goto L18;
        String r106 = "login_platform_phone";
    L27:
        f511784b.storeString("login_platform_" + r100, r106);
        if (r106 != null) goto L30;
    L31:
        r102 = true;
    L32:
        if (r102 == true) goto L35;
        r105 = TuplesKt.to(r100, r101);
    L35:
        f511787e = r105;
        return;
    L30:
        if (r106.length() != 0) goto L32;
    L18:
        if (r104 != 2) goto L20;
        r106 = "login_platform_google";
        goto L27
    L20:
        if (r104 == 3) goto L24;
        if (r101 == null) goto L23;
        r106 = r101.name();
        goto L27
    L23:
        r106 = null;
        goto L27
    L24:
        r106 = "login_platform_douyin";
        goto L27
    L14:
        r104 = C6766a.f511788a[r101.ordinal()];
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static void b(String r100, LoginPlatform r101, UserAction r102) {
        Intrinsics.checkNotNullParameter(r100, "businessScene");
        Intrinsics.checkNotNullParameter(r102, "action");
        q38.a r103 = ILoginService.f286097a.getAccountInfo();
        if (r102 != UserAction.USER_LOGIN) goto L5;
        e(r103.f531530c, r101);
        IMultiAccountService.f286100a.onLoginSuccess();
    L5:
        n38.c r104 = new n38.c(r103.f531530c, r103.f531531d);
        List<j> r105 = c.f511794a;
        Intrinsics.checkNotNullParameter(r104, "user");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r100, "businessScene");
        FLogger.f375446a.i("AccountStatusManager", "dispatch userDidOnline, uid = " + r104.f516993a + ", action = " + r102 + ", businessScene = " + r100);
        n38.a r106 = new n38.a(AccountStatus.LOGGED_IN, r104, r102, r100);
        c.f511795b = r106;
        List<j> r107 = c.f511794a;
        if (r107 == null) goto L11;
        Iterator r108 = ((CopyOnWriteArrayList) r107).iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        ((j) r108.next()).b(r106);
        goto L9
    L13:
        return;
    }

    public static /* synthetic */ void c(a r100, String r101, LoginPlatform r102) {
        UserAction r103 = UserAction.USER_LOGIN;
        r100.getClass();
        b(r101, r102, r103);
    }

    public static void d(String r100, UserAction r101, n38.c r102) {
        Intrinsics.checkNotNullParameter(r100, "businessScene");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "beforeAccountInfo");
        e(r102.f516993a, null);
        xg9.b.a().storeBoolean("key_has_profile_overview_data", false);
        xg9.b.a().storeString("key_profile_overview_data", "");
        g.f365738a.monitorEventForSlardar("logout_and_clear_profile_data", null, null, null);
        FLogger r103 = FLogger.f375446a;
        r103.i("LoginServiceImpl", "logout_and_clear_profile_data");
        if (r101 != UserAction.USER_LOGOUT) goto L5;
        IMultiAccountService.f286100a.h(r102.f516994b);
    L5:
        List<j> r104 = c.f511794a;
        Intrinsics.checkNotNullParameter(r102, "user");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r100, "businessScene");
        r103.i("AccountStatusManager", "dispatch userDidOffline, uid = " + r102.f516993a + ", action = " + r101 + ", businessScene = " + r100);
        n38.a r105 = new n38.a(AccountStatus.LOGGED_OUT, r102, r101, r100);
        c.f511795b = r105;
        List<j> r106 = c.f511794a;
        if (r106 == null) goto L11;
        Iterator r107 = ((CopyOnWriteArrayList) r106).iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        ((j) r107.next()).a(r105);
        goto L9
    L13:
        return;
    }
}
