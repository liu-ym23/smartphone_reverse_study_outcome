package com.bytedance.ee.bear.document.ability;

import android.content.res.Configuration;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.more.protocol3.panel.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/ability/IDocMorePanelPlugin;", FaceService.neutralLabel, "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "registerMoreConfig", "", "block", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/more/protocol3/panel/MoreDslBuilder;", "Lkotlin/ExtensionFunctionType;", "unregisterMoreConfig", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocMorePanelPlugin<H extends PluginHost> extends f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ability.IDocMorePanelPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(IDocMorePanelPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(IDocMorePanelPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(IDocMorePanelPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(IDocMorePanelPlugin r100, PluginHost r101) {
        }
    }

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

    void registerMoreConfig(Function1<? super l, Unit> r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);

    void unregisterMoreConfig();
}
