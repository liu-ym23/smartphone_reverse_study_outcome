package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC5531a {
        void a(PlayControlBar r100);
    }

    Context getContext();

    Object getTag(int r100);

    void pausePlay();

    void resumePlay();

    void setProgress(float r100);

    void startPlay();

    void stopPlay();
}
