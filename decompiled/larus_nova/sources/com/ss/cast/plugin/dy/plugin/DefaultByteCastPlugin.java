package com.ss.cast.plugin.dy.plugin;

import b56.a;
import c56.b;
import com.bytedance.ies.ugc.aweme.plugin.service.IPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultByteCastPlugin implements IByteCastPlugin {
    private static final String TAG = "ByteCastPluginImpl";
    private final IPluginService pluginService;

    public DefaultByteCastPlugin() {
        IPluginService r100 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        this.pluginService = r100;
        Objects.toString(r100);
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public boolean checkInitialized(boolean r100) {
        IPluginService r101 = this.pluginService;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.d();
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public boolean checkPluginInstalled(String r100) {
        IPluginService r101 = this.pluginService;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.b();
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public String getCurProcessPluginVer(String r100) {
        if (this.pluginService != null) goto L7;
        return null;
    L7:
        return this.pluginService.f() + "";
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public void installPlugin(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        IPluginService r101 = this.pluginService;
        if (r101 != null) goto L10;
        b r102 = r100.f17762f;
        if (r102 == null) goto L12;
        r102.onFailed(r100.f17758b, r100.f17759c, 65);
        return;
    L12:
        return;
    L10:
        r101.a();
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public boolean isPluginLoaded(String r100) {
        IPluginService r101 = this.pluginService;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.e();
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public boolean needUpgradePlugin(String r100) {
        IPluginService r101 = this.pluginService;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.c();
    }

    @Override // com.ss.cast.plugin.dy.plugin.IByteCastPlugin
    public void preload(String r100) {
        IPluginService r101 = this.pluginService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.preload();
    }
}
