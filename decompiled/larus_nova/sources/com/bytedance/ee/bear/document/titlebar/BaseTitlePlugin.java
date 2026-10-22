package com.bytedance.ee.bear.document.titlebar;

import android.content.res.Configuration;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bH&J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0005H&J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H&J\b\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u0005H&¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/titlebar/BaseTitlePlugin;", FaceService.neutralLabel, "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "setImmersiveDelegate", "", "immersiveDelegate", "Lcom/bytedance/ee/bear/document/titlebar/BaseTitlePlugin$ImmersiveDelegate;", "getImmersiveDelegate", "updateIsHostSupportNestScroll", "isHostSupportNestScroll", "", "updateEnableNestScroll", "enable", "updateIsInCustomHeader", "isInCustomHeader", "updateIsInCustomHeaderNestScroll", "customHeaderNestScrollEnable", "setAppBarLayoutVisible", "setAppBarLayoutInvisible", "updateAntiShakePreDrawEnable", "antiShakePreDrawEnable", "updateCustomPreviewStatus", "isCustomPreviewMode", "customContentHeight", "", "setTitleBarVisible", "handleOrientation", "configuration", "Landroid/content/res/Configuration;", "getAiRightIconPosition", "index", "getTitleBarHeightLocation", "", "setNotifyTitleBarHideRunnable", "runnable", "Ljava/lang/Runnable;", "removeNotifyTitleBarHideRunnable", "ImmersiveDelegate", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BaseTitlePlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(BaseTitlePlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(BaseTitlePlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(BaseTitlePlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(BaseTitlePlugin r100, PluginHost r101) {
        }
    }

    public interface a {
    }

    int getAiRightIconPosition(int r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    a getImmersiveDelegate();

    int[] getTitleBarHeightLocation();

    void handleOrientation(Configuration r100);

    boolean isHostSupportNestScroll();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r100, com.bytedance.ee.bear.browser.plugin.t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r100, com.bytedance.ee.bear.browser.plugin.t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r100);

    void removeNotifyTitleBarHideRunnable();

    void setAppBarLayoutInvisible();

    void setAppBarLayoutVisible();

    void setImmersiveDelegate(a r100);

    void setNotifyTitleBarHideRunnable(Runnable r100);

    void setTitleBarVisible();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);

    void updateAntiShakePreDrawEnable(boolean r100);

    void updateCustomPreviewStatus(boolean r100, int r101);

    void updateEnableNestScroll(boolean r100);

    void updateIsHostSupportNestScroll(boolean r100);

    void updateIsInCustomHeader(boolean r100);

    void updateIsInCustomHeaderNestScroll(boolean r100);
}
