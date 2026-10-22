package com.bytedance.ee.bear.document.plugin.permission;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes16.dex */
public class OfficePermissionPlugin extends OfficePermissionPluginBase<PermissionData> {
    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase, com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase, com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public OfficePermissionPlugin() {
    }
}
