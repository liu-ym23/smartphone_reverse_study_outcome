package com.volcengine.zeus.download;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/volcengine/zeus/download/DefaultDownloadPolicy;", "Lcom/volcengine/zeus/download/DownloadPolicy;", "()V", "mLastRequestTime", "", "", "", "allowRequest", "", "pluginPkgName", "ignoreTimeInterval", "isDownloadWifiOnly", "bean", "Lcom/volcengine/zeus/download/PluginDownloadBean;", "updateLastRequestTime", "", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public class DefaultDownloadPolicy implements DownloadPolicy {
    private final Map<String, Long> mLastRequestTime;

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public boolean isDownloadWifiOnly(String r100, PluginDownloadBean r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "bean");
        return false;
    }

    public DefaultDownloadPolicy() {
        this.mLastRequestTime = new ConcurrentHashMap();
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public Map<String, String> getCustomTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        return MapsKt.emptyMap();
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public void updateLastRequestTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        this.mLastRequestTime.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public boolean allowDownload(String r100, PluginDownloadBean r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "bean");
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r101, "bean");
        return true;
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public boolean allowRequest(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkgName");
        long r102 = System.currentTimeMillis();
        Long r103 = this.mLastRequestTime.get(r100);
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L7:
        if (r101 == true) goto L24;
        if ((r102 - r104) >= 300000) goto L24;
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins skip. Short interval. " + r100);
        return false;
    L24:
        NetworkInfo r105 = ((ConnectivityManager) Zeus.getAppApplication().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L23
        if (r105 == null) goto L18;
        if (r105.isConnected() == false) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L22;
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "asyncFetchPlugins skip. Network off. " + r100);
        return false;
    L22:
        return true;
    L18:
        r106 = false;
        goto L19
    L5:
        r104 = 0;
        goto L7
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public void onDownloadSuccess(String r100, PluginDownloadBean r101) {
        Intrinsics.checkNotNullParameter(r100, NativeDownloadModel.JsonKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r101, "pluginDownloadBean");
        Intrinsics.checkNotNullParameter(r100, NativeDownloadModel.JsonKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r101, "pluginDownloadBean");
    }
}
