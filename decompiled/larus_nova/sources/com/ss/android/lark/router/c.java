package com.ss.android.lark.router;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.p;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f439675a = 0;

    static {
    }

    public static com.ss.android.lark.officesdk.applink.a a() {
        OfficeSDKUserComponent r100 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Exception -> L9
        if (r100 == null) goto L6;
        com.ss.android.lark.officesdk.applink.a r101 = (com.ss.android.lark.officesdk.applink.a) OfficeSDKSPIKtxKt.spiByDwarf(r100, com.ss.android.lark.officesdk.applink.a.class);     // Catch: Exception -> L9
    L7:
        Log.i("OpenUrlUtil", "spi IOfficeSDKAppLinkService, instance: " + r101);     // Catch: Exception -> L9
        return r101;
    L6:
        r101 = null;
    L9:
        e = move-exception;
        Log.w("OpenUrlUtil", "get IOfficeSDKAppLinkService failed", e);
        return null;
    }

    public static boolean b(Context r100, String r101) {
        boolean r102 = false;
        if (r100 == null) goto L66;
        if (r101 == null) goto L66;
        Set<String> r103 = com.ss.android.lark.officesdk.applink.b.f433098a;
        Intrinsics.checkNotNullParameter(r101, "url");
        if (com.ss.android.lark.officesdk.applink.b.a(r101) == null) goto L9;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L67;
        boolean r105 = false;
    L24:
        if (r105 == false) goto L26;
        return true;
    L26:
        Log.i("OpenUrlUtil", "openUrl url:".concat(r101));
        String r106 = UriProtector.parse(r101).getPath();
        if (r106 != null) goto L31;
    L35:
        boolean r107 = false;
    L36:
        if (r107 == false) goto L48;
        com.ss.android.lark.officesdk.applink.a r108 = a();
        if (r108 == null) goto L48;
        if (r108.d9(r100, r101) == true) goto L69;
        Log.i("OpenUrlUtil", "todo appLink canOpen false");
        goto L48
    L69:
        r108.q6(r100, r101);     // Catch: Exception -> L46
        boolean r109 = true;
    L49:
        if (r109 == false) goto L52;
        Log.i("OpenUrlUtil", "appLink intercept");
        return true;
    L52:
        int r110 = d.f439676a;
        a r111 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r111 == null) goto L55;
        r102 = Intrinsics.areEqual(r111.openUrl(r100, r101), Boolean.TRUE);
    L55:
        if (r102 == false) goto L58;
        Log.i("OpenUrlUtil", "inject intercept");
        return true;
    L58:
        UrlDependencyHelper r112 = UrlDependencyHelper.f439672b.getValue();
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Boolean r113 = null;
        if (r112.f439673a != null) goto L61;
        DependencyContainer r114 = DependencyContainer.f433166a;
        r112.f439673a = (p) DependencyContainer.a(p.class, null);
    L61:
        p r115 = r112.f439673a;
        if (r115 == null) goto L65;
        r113 = r115.a();
    L65:
        return Intrinsics.areEqual(r113, Boolean.TRUE);
    L46:
        e = move-exception;
        Log.w("OpenUrlUtil", "open todo appLink failed", e);
    L48:
        r109 = false;
        goto L49
    L31:
        if (StringsKt.startsWith(r106, "/client/todo/", true) != true) goto L35;
        r107 = true;
    L33:
        e = move-exception;
        Log.w("OpenUrlUtil", "parse todo appLink failed", e);
        goto L35
    L67:
        com.ss.android.lark.officesdk.applink.a r116 = a();     // Catch: Exception -> L18
        if (r116 == null) goto L19;
        if (r116.u7(r100, r101) != true) goto L19;
        boolean r117 = true;
    L20:
        Log.i("OpenUrlUtil", "group invite link intercepted, accepted=" + r117);
        if (r117 == true) goto L23;
        new Handler(Looper.getMainLooper()).post(new b(r100));
    L23:
        r105 = true;
    L19:
        r117 = false;
    L18:
        Log.w("OpenUrlUtil", "open group invite link failed");
        goto L19
    L9:
        r104 = false;
    L66:
        return false;
    }
}
