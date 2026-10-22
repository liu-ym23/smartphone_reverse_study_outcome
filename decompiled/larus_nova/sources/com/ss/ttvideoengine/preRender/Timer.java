package com.ss.ttvideoengine.preRender;

/* JADX INFO: loaded from: classes34.dex */
public interface Timer {

    public interface TimerListener {
        void trigger();
    }

    void addTimerListener(TimerListener r100);

    void removeTimerListener(TimerListener r100);

    void start();

    void stop();
}
