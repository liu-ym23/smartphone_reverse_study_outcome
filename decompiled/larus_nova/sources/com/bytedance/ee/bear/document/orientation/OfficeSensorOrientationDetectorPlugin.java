package com.bytedance.ee.bear.document.orientation;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;

/* JADX INFO: loaded from: classes16.dex */
public class OfficeSensorOrientationDetectorPlugin extends DocumentPluginV3 implements BaseSensorOrientationDetectorPlugin<ChameleonPluginHost> {
    private static final String TAG = "SensorOrientationDetectorPlugin";
    private MutableLiveData<ru5.d> mOrientation;
    private ru5.j sensorOrientationDetector;

    public static /* synthetic */ void a(OfficeSensorOrientationDetectorPlugin r100, ru5.d r101) {
        r100.lambda$onAttachToHost$0(r101);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseSensorOrientationDetectorPlugin
    public MutableLiveData<ru5.d> getOrientation() {
        if (this.mOrientation != null) goto L6;
        this.mOrientation = new MutableLiveData();
    L6:
        return this.mOrientation;
    }

    public OfficeSensorOrientationDetectorPlugin() {
    }

    private /* synthetic */ void lambda$onAttachToHost$0(ru5.d r100) {
        tt5.a.b(TAG, "onChange, orientation: " + r100);
        getOrientation().setValue(r100);
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        this.sensorOrientationDetector = new ru5.j(getContext(), new l(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        boolean r102 = this.sensorOrientationDetector.canDetectOrientation();
        tt5.a.h(TAG, "canDetect: " + r102);
        if (r102 == false) goto L6;
        this.sensorOrientationDetector.enable();
        return;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.sensorOrientationDetector.disable();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }
}
