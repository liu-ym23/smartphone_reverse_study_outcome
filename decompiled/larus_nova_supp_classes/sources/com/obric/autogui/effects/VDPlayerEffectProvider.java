package com.obric.autogui.effects;

import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import com.volcengine.zeus.provider.BaseProxyProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class VDPlayerEffectProvider extends BaseProxyProvider {
    private static final String BROWSER_PACKAGE_NAME = "com.obric.browser";

    @Override // com.volcengine.zeus.provider.BaseProxyProvider
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    private boolean isTrustedCaller() {
        int r0 = Binder.getCallingUid();
        if (r0 != Process.myUid()) goto L6;
        return true;
    L6:
        if (getContext() != null) goto L8;
        return false;
    L8:
        String[] r1 = getContext().getPackageManager().getPackagesForUid(r0);
        if (r1 != null) goto L11;
        return false;
    L11:
        int r2 = r1.length;
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L17;
        if (BROWSER_PACKAGE_NAME.equals(r1[r4]) == true) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    public VDPlayerEffectProvider() {
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r2, String r3, Bundle r4) {
        if (isTrustedCaller() == true) goto L7;
        return Bundle.EMPTY;
    L7:
        return super.call(r2, r3, r4);
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r2, String r3, String r4, Bundle r5) {
        if (isTrustedCaller() == true) goto L7;
        return Bundle.EMPTY;
    L7:
        return super.call(r2, r3, r4, r5);
    }
}
