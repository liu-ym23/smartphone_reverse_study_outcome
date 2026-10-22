package com.obric.autogui.effects;

import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import com.volcengine.zeus.provider.BaseProxyProvider;

/* JADX INFO: loaded from: classes.dex */
public class VDPlayerEffectProvider extends BaseProxyProvider {
    private static final String BROWSER_PACKAGE_NAME = "com.obric.browser";

    @Override // com.volcengine.zeus.provider.BaseProxyProvider
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    private boolean isTrustedCaller() {
        int r100 = Binder.getCallingUid();
        if (r100 != Process.myUid()) goto L6;
        return true;
    L6:
        if (getContext() != null) goto L8;
        return false;
    L8:
        String[] r101 = getContext().getPackageManager().getPackagesForUid(r100);
        if (r101 != null) goto L11;
        return false;
    L11:
        int r102 = r101.length;
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        if (BROWSER_PACKAGE_NAME.equals(r101[r103]) == true) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    public VDPlayerEffectProvider() {
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        if (isTrustedCaller() == true) goto L7;
        return Bundle.EMPTY;
    L7:
        return super.call(r100, r101, r102);
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, String r102, Bundle r103) {
        if (isTrustedCaller() == true) goto L7;
        return Bundle.EMPTY;
    L7:
        return super.call(r100, r101, r102, r103);
    }
}
