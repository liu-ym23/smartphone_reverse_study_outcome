package com.bytedance.ee.bear.drive.config.plugin;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.ss.android.lark.chat.export.offlineCacheClean.b;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/config/plugin/DriveOfflineCacheCleanPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "exitAction", "Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheCleanAction;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfflineCacheCleanPlugin extends AbsDrivePreviewPlugin {
    private final b exitAction;

    public static final class a implements b {
        public final /* synthetic */ DriveOfflineCacheCleanPlugin a;

        public final void a() {
            Context r0 = DriveOfflineCacheCleanPlugin.access$getContext(this.a);
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (ForsetiConfig.a(r0) != true) goto L7;
        L8:
            if (r1 == false) goto L16;
            Fragment r2 = this.a.getHost().getHostFragment();
            if (r2 == null) goto L12;
            g r3 = f.b(r2);
        L13:
            if (r3 == null) goto L16;
            r3.g(null);
            return;
        L12:
            r3 = null;
        L16:
            this.a.getHost().getActivity().finish();
            return;
        L7:
            r1 = false;
            goto L8
        }

        public a(DriveOfflineCacheCleanPlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveOfflineCacheCleanPlugin() {
        this.exitAction = new a(this);
    }

    public static final /* synthetic */ Context access$getContext(DriveOfflineCacheCleanPlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        com.ss.android.lark.chat.export.offlineCacheClean.f.a().Wa(this.exitAction);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        com.ss.android.lark.chat.export.offlineCacheClean.f.a().Ib(this.exitAction);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }
}
