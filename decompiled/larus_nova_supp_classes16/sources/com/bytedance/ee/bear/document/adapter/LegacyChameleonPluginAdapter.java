package com.bytedance.ee.bear.document.adapter;

import android.content.Intent;
import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0016H\u0016J \u0010(\u001a\u00020\u00182\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0*H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\"\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\u001a\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u0001072\n\u00108\u001a\u0006\u0012\u0002\b\u000309H\u0016J\f\u0010:\u001a\u0006\u0012\u0002\b\u000307H\u0016J\b\u0010;\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/bytedance/ee/bear/document/adapter/LegacyChameleonPluginAdapter;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/lazy/BridgeInteractivePlugin;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/browser/plugin/ICustomFindPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/AbilityProvider;", "chameleonPlugin", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "(Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;)V", "hostAdapter", "Lcom/bytedance/ee/bear/document/adapter/DocumentChameleonPluginHostAdapter;", "getChameleonPlugin", "getPluginId", "", "getMountStrategy", "Lcom/bytedance/ee/bear/browser/plugin/lazy/PluginMountStrategy;", "getUILevel", "", "isViewImmersive", "", "onAttachToHost", "", "host", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onStart", "onResume", "onPause", "onStop", "onDetachFromUIContainer", "onDetachFromHost", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "setUserVisibleHint", "isVisibleToUser", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getAbilities", "", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "findPluginInner", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "pluginClass", "Ljava/lang/Class;", "getLegacyPlugin", "requireHostAdapter", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LegacyChameleonPluginAdapter extends BasePlugin<DocumentPluginHost> implements yv4.a, sa5.a, sa5.d, com.bytedance.ee.bear.browser.plugin.e, com.bytedance.ee.bear.browser.plugin.a {
    private final AbsChameleonPlugin chameleonPlugin;
    private c hostAdapter;

    private final c requireHostAdapter() {
        c r0 = this.hostAdapter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("LegacyChameleonPluginAdapter must attach to host before dispatching lifecycle".toString());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.a
    public List<i> getAbilities() {
        ArrayList r0 = new ArrayList();
        AbsChameleonPlugin r1 = this.chameleonPlugin;
        if ((r1 instanceof i) == false) goto L5;
        r0.add(r1);
    L5:
        com.bytedance.ee.bear.browser.plugin.a r2 = this.chameleonPlugin;
        if ((r2 instanceof com.bytedance.ee.bear.browser.plugin.a) == false) goto L9;
        r0.addAll(r2.getAbilities());
    L9:
        return CollectionsKt.distinct(r0);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public PluginMountStrategy getMountStrategy() {
        return this.chameleonPlugin.getMountStrategy();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        return this.chameleonPlugin.getPluginId();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public Enum<?> getUILevel() {
        return this.chameleonPlugin.getUILevel();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return this.chameleonPlugin.isViewImmersive();
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        sa5.d r0 = this.chameleonPlugin;
        if ((r0 instanceof sa5.d) == true) goto L7;
        return false;
    L7:
        return r0.onBackPressed();
    }

    public final AbsChameleonPlugin getChameleonPlugin() {
        return this.chameleonPlugin;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.e
    public com.bytedance.ee.bear.browser.plugin.f<?> getLegacyPlugin() {
        return this.chameleonPlugin;
    }

    public LegacyChameleonPluginAdapter(AbsChameleonPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "chameleonPlugin");
        this.chameleonPlugin = r2;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.e
    public com.bytedance.ee.bear.browser.plugin.f<?> findPluginInner(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginClass");
        if (r2.isAssignableFrom(this.chameleonPlugin.getClass()) == true) goto L7;
        return null;
    L7:
        return this.chameleonPlugin;
    }

    @Override // yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        this.chameleonPlugin.getBridgeHandlers(r2);
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        c r0 = this.hostAdapter;
        if (r0 != null) goto L5;
        r0 = new c(r3);
        this.hostAdapter = r0;
    L5:
        tt5.a.h("LegacyChameleonPluginAdapter", "attach chameleon plugin, plugin=".concat(this.chameleonPlugin.getClass().getSimpleName()));
        this.chameleonPlugin.onAttachToHost(r0);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfiguration");
        super.onConfigurationChanged(r2);
        this.chameleonPlugin.onConfigurationChanged(r2);
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        tt5.a.h("LegacyChameleonPluginAdapter", "detach chameleon plugin, plugin=".concat(this.chameleonPlugin.getClass().getSimpleName()));
        this.chameleonPlugin.onDetachFromHost(this.hostAdapter);
        c r3 = this.hostAdapter;
        if (r3 == null) goto L5;
        r3.b();
    L5:
        this.hostAdapter = null;
    }

    public void onPause(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onPause(r2);
        this.chameleonPlugin.onPause(requireHostAdapter());
    }

    public void onResume(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onResume(r2);
        this.chameleonPlugin.onResume(requireHostAdapter());
    }

    public void onStart(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onStart(r2);
        this.chameleonPlugin.onStart(requireHostAdapter());
    }

    public void onStop(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onStop(r2);
        this.chameleonPlugin.onStop(requireHostAdapter());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        this.chameleonPlugin.setUserVisibleHint(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
        onPause((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStop(PluginHost r1) {
        onStop((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        c r4 = requireHostAdapter();
        this.chameleonPlugin.onAttachToUIContainer(r4, r4.getUIContainer());
    }

    public void onDetachFromUIContainer(DocumentPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        c r4 = requireHostAdapter();
        this.chameleonPlugin.onDetachFromUIContainer(r4, r4.getUIContainer());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // sa5.a
    public void onActivityResult(int r3, int r4, Intent r5) {
        sa5.a r0 = this.chameleonPlugin;
        if ((r0 instanceof sa5.a) == false) goto L6;
        r0.onActivityResult(r3, r4, r5);
        return;
    }
}
