package com.oplus.ocs.base.common.api;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;

/* JADX INFO: loaded from: classes34.dex */
public interface OplusApiClient {
    <T> void addQueue(TaskListenerHolder<T> r100);

    void connect();

    void disconnect();

    Api getApi();

    AuthResult getAuthResult();

    Looper getLooper();

    IBinder getRemoteService();

    int getRemoteVersion();

    boolean isConnected();

    boolean isConnecting();

    void setOnCapabilityAuthListener(i r100);

    void setOnClearListener(j r100);

    void setOnConnectionFailedListener(OnConnectionFailedListener r100, Handler r101);

    void setOnConnectionSucceedListener(OnConnectionSucceedListener r100, Handler r101);
}
