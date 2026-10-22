package com.bytedance.ee.bear.document.orientation;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SensorOrientationDetectorPlugin extends DocumentPlugin implements BaseSensorOrientationDetectorPlugin<DocumentPluginHost> {
    private static final String TAG = "SensorOrientationDetectorPlugin";
    private MutableLiveData<ru5.d> mOrientation;
    private ru5.j sensorOrientationDetector;

    public static /* synthetic */ void c(SensorOrientationDetectorPlugin r0, ru5.d r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseSensorOrientationDetectorPlugin
    public MutableLiveData<ru5.d> getOrientation() {
        if (this.mOrientation != null) goto L6;
        this.mOrientation = new MutableLiveData();
    L6:
        return this.mOrientation;
    }

    public SensorOrientationDetectorPlugin() {
    }

    private /* synthetic */ void lambda$onAttachToHost$0(ru5.d r3) {
        tt5.a.b(TAG, "onChange, orientation: " + r3);
        getOrientation().setValue(r3);
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.sensorOrientationDetector = new ru5.j(getContext(), new r(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        boolean r4 = this.sensorOrientationDetector.canDetectOrientation();
        tt5.a.h(TAG, "canDetect: " + r4);
        if (r4 == false) goto L6;
        this.sensorOrientationDetector.enable();
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.sensorOrientationDetector.disable();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
