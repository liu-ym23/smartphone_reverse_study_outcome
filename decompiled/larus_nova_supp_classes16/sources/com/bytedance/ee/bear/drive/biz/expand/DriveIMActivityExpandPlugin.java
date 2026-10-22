package com.bytedance.ee.bear.drive.biz.expand;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileManager;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveImFileMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.manager.DriveIMAttachmentMoreMenuManager;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.route.ExpandDocHelperForKA;
import com.larksuite.framework.utils.l0;
import h85.j1;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lw4.c;
import o75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/expand/DriveIMActivityExpandPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/content/expand/OnExpandActivityClickListener;", "<init>", "()V", "expandWrapper", "Lcom/bytedance/ee/bear/content/expand/ActivityExpandWrapper;", "uuid", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "isExpandActivity", "", "onExpandItemClick", "openExpandActivity", "entity", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveShadowFileEntity;", "onExpandItemClickWhenDowngrade", "openExpandActivityWhenDowngrade", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveIMActivityExpandPlugin extends AbsDrivePreviewPlugin implements c {
    public static final a Companion = null;
    private static final String TAG = "DriveIMActivityExpandPlugin";
    private final lw4.a expandWrapper;
    private final String uuid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void onExpandItemClickWhenDowngrade() {
        int r0 = lw4.a.g;
        boolean r1 = com.bytedance.ee.util.ui.a.a(getActivity());
        b.a().Ke().G(!r1);
        if (r1 == false) goto L5;
        getActivity().finish();     // Catch: Exception -> L11
        return;
    L5:
        DriveShadowFileEntity.a r2 = new DriveShadowFileEntity.a();     // Catch: Exception -> L11
        r2.a = true;     // Catch: Exception -> L11
        String r3 = this.uuid;     // Catch: Exception -> L11
        Intrinsics.checkNotNullParameter(r3, "shadowFileUUID");     // Catch: Exception -> L11
        r2.b = r3;     // Catch: Exception -> L11
        DriveShadowFileEntity r4 = new DriveShadowFileEntity(r2);     // Catch: Exception -> L11
        Lazy<DriveShadowFileManager> r5 = DriveShadowFileManager.b;     // Catch: Exception -> L11
        DriveShadowFileManager r6 = DriveShadowFileManager.a.a();     // Catch: Exception -> L11
        String r7 = this.uuid;     // Catch: Exception -> L11
        DriveImFileMoreMenuPlugin r8 = (DriveImFileMoreMenuPlugin) findPlugin(DriveImFileMoreMenuPlugin.class);     // Catch: Exception -> L11
        if (r8 == null) goto L8;
        DriveIMAttachmentMoreMenuManager r9 = r8.createMoreMenuManager(DriveIMAttachmentMoreMenuManager.Sence.UNKNOW);     // Catch: Exception -> L11
    L9:
        r6.a(r7, r9);     // Catch: Exception -> L11
        openExpandActivityWhenDowngrade(r4);     // Catch: Exception -> L11
        return;
    L8:
        r9 = null;
    L11:
        e = move-exception;
        tt5.a.d(TAG, "onExpandItemClick fail: " + e);
    }

    public final boolean isExpandActivity() {
        if (this.expandWrapper.c == false) goto L7;
        int r0 = lw4.a.g;
        if (com.bytedance.ee.util.ui.a.a(getActivity()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public DriveIMActivityExpandPlugin() {
        this.expandWrapper = new lw4.a(this);
        this.uuid = l0.a().toString();
    }

    @Override // lw4.c
    public void onExpandItemClick() {
        if (ExpandDocHelperForKA.a() == false) goto L6;
        onExpandItemClickWhenDowngrade();
        return;
    L6:
        int r0 = lw4.a.g;
        b.a().Ke().G(!com.bytedance.ee.util.ui.a.a(getActivity()));
        DriveShadowFileEntity.a r1 = new DriveShadowFileEntity.a();     // Catch: Exception -> L13
        r1.a = true;     // Catch: Exception -> L13
        String r2 = this.uuid;     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r2, "shadowFileUUID");     // Catch: Exception -> L13
        r1.b = r2;     // Catch: Exception -> L13
        DriveShadowFileEntity r3 = new DriveShadowFileEntity(r1);     // Catch: Exception -> L13
        Lazy<DriveShadowFileManager> r4 = DriveShadowFileManager.b;     // Catch: Exception -> L13
        DriveShadowFileManager r5 = DriveShadowFileManager.a.a();     // Catch: Exception -> L13
        String r6 = this.uuid;     // Catch: Exception -> L13
        DriveImFileMoreMenuPlugin r7 = (DriveImFileMoreMenuPlugin) findPlugin(DriveImFileMoreMenuPlugin.class);     // Catch: Exception -> L13
        if (r7 == null) goto L10;
        DriveIMAttachmentMoreMenuManager r8 = r7.createMoreMenuManager(DriveIMAttachmentMoreMenuManager.Sence.UNKNOW);     // Catch: Exception -> L13
    L11:
        r5.a(r6, r8);     // Catch: Exception -> L13
        openExpandActivity(r3);     // Catch: Exception -> L13
        return;
    L10:
        r8 = null;
    L13:
        e = move-exception;
        tt5.a.d(TAG, "onExpandItemClick fail: " + e);
    }

    private final void openExpandActivity(DriveShadowFileEntity r8) {
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        if ((r0 instanceof OnlineOpenEntity) == false) goto L5;
        OnlineOpenEntity r1 = (OnlineOpenEntity) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        ArrayList<? extends BaseOpenEntity> r3 = new ArrayList();
        r3.add(r1);
        int r2 = lw4.a.g;
        boolean r4 = com.bytedance.ee.util.ui.a.a(getActivity());
        ma5.a r5 = new ma5.a();
        r5.d = !r4;
        r5.c = true;
        Bundle r6 = new Bundle();
        r6.putSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA, r8);
        new j1().f(getActivity(), r3, 0, r5, r6);     // Catch: Exception -> L11
        getActivity().finish();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.e(TAG, "openExpandActivity fail: ", e, false);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void openExpandActivityWhenDowngrade(DriveShadowFileEntity r8) {
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        if ((r0 instanceof OnlineOpenEntity) == false) goto L5;
        OnlineOpenEntity r1 = (OnlineOpenEntity) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        ArrayList<? extends BaseOpenEntity> r3 = new ArrayList();
        r3.add(r1);
        ma5.a r5 = new ma5.a();
        r5.d = true;
        Bundle r6 = new Bundle();
        r6.putSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA, r8);
        new j1().f(getActivity(), r3, 0, r5, r6);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        this.expandWrapper.d(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        this.expandWrapper.f(getTitleBar(), getActivity());
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        this.expandWrapper.e(getTitleBar());
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    @Override // lw4.c
    public boolean extraCloseExpandItemMenu(TitleBar r1, Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin
    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        this.expandWrapper.f(getTitleBar(), getActivity());
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
