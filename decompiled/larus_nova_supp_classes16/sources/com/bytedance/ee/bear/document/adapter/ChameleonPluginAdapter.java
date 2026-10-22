package com.bytedance.ee.bear.document.adapter;

import android.content.Intent;
import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.t;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u001d\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J \u0010'\u001a\u00020\u00142\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)H\u0016J\"\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020%H\u0016J\u001a\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u0001032\n\u00104\u001a\u0006\u0012\u0002\b\u000305H\u0016J\f\u00106\u001a\u0006\u0012\u0002\b\u000303H\u0016R\u0010\u0010\u0007\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/document/adapter/ChameleonPluginAdapter;", "H", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/browser/plugin/ICustomFindPlugin;", "pluginHost", "legacyPlugin", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "<init>", "(Lcom/bytedance/ee/bear/browser/plugin/PluginHost;Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;)V", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getPluginId", "", "getMountStrategy", "Lcom/bytedance/ee/bear/browser/plugin/lazy/PluginMountStrategy;", "getUILevel", "", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onStart", "onResume", "onPause", "onStop", "onDetachFromUIContainer", "onDetachFromHost", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "setUserVisibleHint", "isVisibleToUser", "", "isViewImmersive", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "findPluginInner", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "pluginClass", "Ljava/lang/Class;", "getLegacyPlugin", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonPluginAdapter<H extends PluginHost> extends AbsChameleonPlugin implements sa5.a, sa5.d, com.bytedance.ee.bear.browser.plugin.e {
    private final BasePlugin<H> legacyPlugin;
    private final H pluginHost;

    public PluginMountStrategy getMountStrategy() {
        return this.legacyPlugin.getMountStrategy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getPluginId() {
        String r0 = this.legacyPlugin.getPluginId();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.getPluginId();
    }

    public Enum<?> getUILevel() {
        return this.legacyPlugin.getUILevel();
    }

    public boolean isViewImmersive() {
        return this.legacyPlugin.isViewImmersive();
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        BasePlugin<H> r0 = this.legacyPlugin;
        if ((r0 instanceof sa5.d) == true) goto L7;
        return false;
    L7:
        return ((sa5.d) r0).onBackPressed();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.e
    public com.bytedance.ee.bear.browser.plugin.f<?> getLegacyPlugin() {
        return this.legacyPlugin;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.e
    public com.bytedance.ee.bear.browser.plugin.f<?> findPluginInner(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginClass");
        if (r2.isAssignableFrom(this.legacyPlugin.getClass()) == true) goto L7;
        return null;
    L7:
        return this.legacyPlugin;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        BasePlugin<H> r0 = this.legacyPlugin;
        if ((r0 instanceof yv4.a) == false) goto L6;
        ((yv4.a) r0).getBridgeHandlers(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        this.legacyPlugin.onAttachToHost(this.pluginHost);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfiguration");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r2);
        this.legacyPlugin.onConfigurationChanged(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        this.legacyPlugin.onDetachFromHost(this.pluginHost);
    }

    public void onPause(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onPause(r2);
        this.legacyPlugin.onPause(this.pluginHost);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onResume(r2);
        this.legacyPlugin.onResume(this.pluginHost);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onStart(r2);
        this.legacyPlugin.onStart(this.pluginHost);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStop(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onStop(r2);
        this.legacyPlugin.onStop(this.pluginHost);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setUserVisibleHint(boolean r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.setUserVisibleHint(r2);
        this.legacyPlugin.setUserVisibleHint(r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
        onPause((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onStop(PluginHost r1) {
        onStop((ChameleonPluginHost) r1);
    }

    public ChameleonPluginAdapter(H r2, BasePlugin<H> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "legacyPlugin");
        this.pluginHost = r2;
        this.legacyPlugin = r3;
        r3.setHost(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        this.legacyPlugin.onAttachToUIContainer(this.pluginHost, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        this.legacyPlugin.onDetachFromUIContainer(this.pluginHost, r3);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // sa5.a
    public void onActivityResult(int r3, int r4, Intent r5) {
        BasePlugin<H> r0 = this.legacyPlugin;
        if ((r0 instanceof sa5.a) == false) goto L6;
        ((sa5.a) r0).onActivityResult(r3, r4, r5);
        return;
    }
}
