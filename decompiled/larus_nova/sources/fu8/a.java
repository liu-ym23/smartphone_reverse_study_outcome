package fu8;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.reparo.IReparoConfig;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ita.i;
import ita.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends IReparoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f478913a;

    @Override // com.bytedance.reparo.IReparoConfig
    public final boolean enable() {
        return true;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getAppId() {
        return String.valueOf(AppHost.f326268a.getAppId());
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getChannel() {
        return AppHost.f326268a.getBuildChannel();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getDeviceId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getUpdateVersionCode() {
        return String.valueOf(AppHost.f326268a.getUpdateVersionCode());
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final boolean isMainProcess() {
        Application r100 = this.f478913a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return k.i(r100);
    L5:
        th = move-exception;
        nu8.a.f("ProcessUtils", th, "isMainProcess failed ");
        return false;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final Application getApplication() {
        return this.f478913a;
    }

    public a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f478913a = r100;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String executePatchRequest(int r100, String r101, byte[] r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "localPatchInfoBytes");
        Intrinsics.checkNotNullParameter(r103, "contentType");
        Uri.Builder r104 = UriProtector.parse(r101).buildUpon();
        r104.appendQueryParameter("device_id", getDeviceId()).appendQueryParameter("channel", getChannel()).appendQueryParameter("aid", getAppId()).appendQueryParameter("device_platform", "android").appendQueryParameter("os_api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("update_version_code", getUpdateVersionCode());
        String r105 = Build.VERSION.RELEASE;     // Catch: Exception -> L10
        if (r105 != null) goto L6;
    L8:
        r104.appendQueryParameter("os_version", r105);     // Catch: Exception -> L10
    L13:
        return i.b(r100, r104.build().toString(), r102, NetworkUtils.CompressType.GZIP, r103);
    L6:
        if (r105.length() <= 10) goto L8;
        r105 = r105.substring(0, 10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.f375446a.e("hot patch", e.getMessage(), e);
        goto L13
    }
}
