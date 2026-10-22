package lb9;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.permission.api.IPermissionX;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements IPermissionX.b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.larus.permission.api.IPermissionX.b
    public final boolean a(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isBasicMode() != true) goto L7;
    L8:
        FLogger.f375446a.i("PermissionInterceptor", "onInterceptPermission: " + r101 + ", isBasicMode: " + r103);
        if (r103 == false) goto L18;
        Activity r104 = AppHost.f326268a.a().getCurrentActivity();
        if ((r104 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r105 = (FragmentActivity) r104;
    L14:
        if (r105 == null) goto L18;
        SecurityService r106 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r106 == null) goto L18;
        r106.k(r105);
        goto L18
    L13:
        r105 = null;
    L18:
        SecurityService r107 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r107 == null) goto L21;
        r107.g(r101);
    L21:
        return r103;
    L7:
        r103 = false;
        goto L8
    }
}
