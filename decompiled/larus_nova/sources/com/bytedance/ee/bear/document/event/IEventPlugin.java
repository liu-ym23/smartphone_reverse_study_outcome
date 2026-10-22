package com.bytedance.ee.bear.document.event;

import android.content.res.Configuration;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\tJ\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/event/IEventPlugin;", FaceService.neutralLabel, "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "addDeleteListener", "", "listener", "Lcom/bytedance/ee/bear/document/event/IEventPlugin$OnDeleteListener;", "removeDeleteListener", "OnDeleteListener", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IEventPlugin<H extends PluginHost> extends f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.event.IEventPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(IEventPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(IEventPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(IEventPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(IEventPlugin r100, PluginHost r101) {
        }
    }

    public interface a {
        void a(String r100);
    }

    void addDeleteListener(a r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

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

    void removeDeleteListener(a r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);
}
