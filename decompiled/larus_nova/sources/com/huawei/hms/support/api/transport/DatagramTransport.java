package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* JADX INFO: loaded from: classes23.dex */
public interface DatagramTransport {

    public interface a {
        void a(int r100, IMessageEntity r101);
    }

    void post(ApiClient r100, a r101);

    void send(ApiClient r100, a r101);
}
