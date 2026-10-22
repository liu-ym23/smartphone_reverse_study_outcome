package com.bytedance.ee.bear.slide.presentation;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.orientation.DocUnspecifiedOrientationPlugin;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SlidesUnspecifiedOrientationPlugin extends DocUnspecifiedOrientationPlugin {
    private static final String TAG = "SlidesUnspecifiedOrientationPlugin";
    private boolean isSupportSlidePresentation;

    public static /* synthetic */ void h(SlidesUnspecifiedOrientationPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.orientation.DocUnspecifiedOrientationPlugin
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.orientation.DocUnspecifiedOrientationPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.orientation.DocUnspecifiedOrientationPlugin
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    public SlidesUnspecifiedOrientationPlugin() {
        this.isSupportSlidePresentation = false;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r3) {
        if (r3.booleanValue() == false) goto L5;
        disableTips();
    L6:
        a.h(TAG, "getPresentationLiveData() called with: isFullScreen = " + r3);
        return;
    L5:
        enableTips();
        goto L6
    }

    @Override // com.bytedance.ee.bear.orientation.DocUnspecifiedOrientationPlugin
    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.isSupportSlidePresentation = c.a.a.g("ccm.slides.presentation_enable");
        FullAndExitStagePlugin r4 = findPlugin(FullAndExitStagePlugin.class);
        if (this.isSupportSlidePresentation == false) goto L7;
        if (r4 == null) goto L8;
        r4.getPresentationLiveData().observe(getLifecycleOwner(), new sn5.a(this));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.ee.bear.orientation.DocUnspecifiedOrientationPlugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
