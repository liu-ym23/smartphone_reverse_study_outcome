package com.bytedance.ee.drive.preview;

import android.content.res.Configuration;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/drive/preview/IDriveThirdPartyTitleMenuPlugin;", FaceService.neutralLabel, "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "Lcom/bytedance/ee/drive/preview/IDriveTitleMenuPlugin;", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDriveThirdPartyTitleMenuPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.drive.preview.IDriveThirdPartyTitleMenuPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(IDriveThirdPartyTitleMenuPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(IDriveThirdPartyTitleMenuPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(IDriveThirdPartyTitleMenuPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(IDriveThirdPartyTitleMenuPlugin r100, PluginHost r101) {
        }
    }

    /* synthetic */ MenuItem createDownloadMenu();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    /* synthetic */ List<MenuItem> getRightMenus();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r100, t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r100, t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r100);

    /* synthetic */ void setRightMenus(List<? extends MenuItem> r100);

    /* synthetic */ void setUpdateListener(g r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);
}
