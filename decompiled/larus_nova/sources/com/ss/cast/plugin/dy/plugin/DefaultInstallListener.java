package com.ss.cast.plugin.dy.plugin;

import android.text.TextUtils;
import c56.b;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultInstallListener implements b {
    private static final String TAG = "DefaultInstallListener";
    private final IPluginInstallCallback callback;
    private final IByteCastPlugin plugin;
    public String pluginPackageName;

    public DefaultInstallListener(IByteCastPlugin r100, IPluginInstallCallback r101) {
        this.pluginPackageName = "com.ss.android.ugc.aweme.bytecast";
        this.plugin = r100;
        this.callback = r101;
    }

    public void onFailed(String r100, boolean r101) {
        if (TextUtils.equals(this.pluginPackageName, r100) == false) goto L8;
        IPluginInstallCallback r102 = this.callback;
        if (r102 == null) goto L9;
        r102.onFailed(r100, r101, 64);
        return;
    L9:
        return;
    }

    public void onSuccess(String r100, boolean r101) {
        if (TextUtils.equals(this.pluginPackageName, r100) == false) goto L11;
        IByteCastPlugin r102 = this.plugin;
        if (r102 == null) goto L7;
        r102.getCurProcessPluginVer(r100);
    L7:
        IPluginInstallCallback r103 = this.callback;
        if (r103 == null) goto L12;
        r103.onSuccess(r100, r101);
        return;
    L12:
        return;
    }

    public void onSuccessInMainThread(String r100, boolean r101) {
        if (TextUtils.equals(this.pluginPackageName, r100) == false) goto L11;
        IByteCastPlugin r102 = this.plugin;
        if (r102 == null) goto L7;
        r102.getCurProcessPluginVer(r100);
    L7:
        IPluginInstallCallback r103 = this.callback;
        if (r103 == null) goto L12;
        r103.onSuccess(r100, r101);
        return;
    L12:
        return;
    }

    @Override // c56.b
    public void onFailed(String r100, boolean r101, int r102) {
        if (TextUtils.equals(this.pluginPackageName, r100) == false) goto L8;
        IPluginInstallCallback r103 = this.callback;
        if (r103 == null) goto L9;
        r103.onFailed(r100, r101, r102);
        return;
    L9:
        return;
    }

    public void onFailedInMainThread(String r100, boolean r101, int r102) {
        if (TextUtils.equals(this.pluginPackageName, r100) == false) goto L8;
        IPluginInstallCallback r103 = this.callback;
        if (r103 == null) goto L9;
        r103.onFailed(r100, r101, r102);
        return;
    L9:
        return;
    }
}
