package com.bytedance.ee.bear.drive.loader.download.platform.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IPoller<PARAMS, RESULT> {

    public interface IPollingStartListener {
        void onPollingStart();
    }

    RESULT poll(PARAMS r1) throws Throwable;

    void setPollingStartListener(IPollingStartListener r1);

    void shutdown();
}
