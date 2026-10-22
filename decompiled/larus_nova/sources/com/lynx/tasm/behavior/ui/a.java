package com.lynx.tasm.behavior.ui;

import android.view.View;

/* JADX INFO: loaded from: classes32.dex */
public interface a {
    void afterDispatchProcessViewInfo(m r100);

    void afterProcessChildViewInfo(m r100, View r101, long r102);

    void afterProcessViewInfo(m r100);

    void beforeDispatchProcessViewInfo(m r100);

    void beforeProcessChildViewInfo(m r100, View r101, long r102);

    void beforeProcessViewInfo(m r100);

    void processLayoutChildren();

    void processMeasureChildren();
}
