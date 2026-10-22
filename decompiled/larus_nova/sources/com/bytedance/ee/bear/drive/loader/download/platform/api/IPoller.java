package com.bytedance.ee.bear.drive.loader.download.platform.api;

/* JADX INFO: loaded from: classes16.dex */
public interface IPoller<PARAMS, RESULT> {

    public interface IPollingStartListener {
        void onPollingStart();
    }

    RESULT poll(PARAMS r100) throws Throwable;

    void setPollingStartListener(IPollingStartListener r100);

    void shutdown();
}
