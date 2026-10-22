package lb9;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.c;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.home.impl.route.u0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: lb9.a$a, reason: collision with other inner class name */
    public static final class C6672a {
    }

    static {
    }

    public a() {
    }

    @Override // q97.a
    public final boolean b(c r100) {
        int r101 = u0.f346102a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        String r104 = u0.a(r103);
        if (Intrinsics.areEqual(r104, "//flow/realtime_chat") == false) goto L11;
    L16:
        return true;
    L11:
        if (Intrinsics.areEqual(r104, "//flow/account_login") == true) goto L16;
        if (Intrinsics.areEqual(r104, "//flow/half_account_login") == true) goto L16;
        return false;
    L7:
        r103 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("BasicModeRouteInterceptor#onInterceptRoute, isBasicMode=");
        SecurityService r104 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        FragmentActivity r105 = null;
        if (r104 == null) goto L5;
        Boolean r106 = Boolean.valueOf(r104.isBasicMode());
    L6:
        r103.append(r106);
        r102.i("BasicModeRouteInterceptor", r103.toString());
        SecurityService r107 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r107 != null) goto L9;
    L11:
        boolean r108 = false;
    L12:
        if (r108 == false) goto L21;
        Activity r109 = AppHost.f326268a.a().getCurrentActivity();
        if ((r109 instanceof FragmentActivity) == false) goto L16;
        r105 = (FragmentActivity) r109;
    L16:
        if (r105 == null) goto L20;
        SecurityService r110 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r110 == null) goto L20;
        r110.k(r105);
    L20:
        return true;
    L21:
        return false;
    L9:
        if (r107.isBasicMode() != true) goto L11;
        r108 = true;
        goto L12
    L5:
        r106 = null;
        goto L6
    }
}
