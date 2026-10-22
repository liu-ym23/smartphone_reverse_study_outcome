package com.bytedance.ee.bear.drive.biz.preview.configuration;

import android.content.res.Configuration;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DrivePreviewStatus;
import com.bytedance.ee.bear.drive.biz.preview.orientation.a;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/configuration/DriveConfigurationPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", SimpleItemModel.ITEM_STYLE_DISABLE, "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "changeConfiguration", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveConfigurationPlugin extends AbsDrivePlugin {
    private boolean disable;

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void changeConfiguration() {
        if (this.disable == false) goto L5;
        return;
    L5:
        DriveConfigurationVM r0 = (DriveConfigurationVM) viewModel(DriveConfigurationVM.class);
        if (getHost().c.isInBlockState() == false) goto L8;
        r0.getLiveUiState().setValue(DrivePreviewStatus.BLOCK);
        return;
    L8:
        int r1 = a.a;
        if (a.C0152a.a(getActivity()) == false) goto L12;
        r0.getLiveUiState().setValue(DrivePreviewStatus.LANDSCAPE);
        r0.isLandscape().setValue(Boolean.TRUE);
        return;
    L12:
        if (a.C0152a.b(getActivity()) == false) goto L17;
        r0.getLiveUiState().setValue(DrivePreviewStatus.Portrait);
        r0.isPortrait().setValue(Boolean.TRUE);
        return;
    }

    public DriveConfigurationPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        this.disable = c.k(LarkContext.getApplication());
        changeConfiguration();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        changeConfiguration();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
