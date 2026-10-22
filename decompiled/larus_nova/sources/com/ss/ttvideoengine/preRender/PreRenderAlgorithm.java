package com.ss.ttvideoengine.preRender;

import com.ss.ttvideoengine.source.Source;

/* JADX INFO: loaded from: classes34.dex */
public interface PreRenderAlgorithm {
    int getAutoRange();

    void shouldStartPreRender(Source r100, PreRenderTriggerListener r101);

    void stop();
}
