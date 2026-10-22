package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TTWebsocketConnection {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract TTWebsocketConnection build();

        public abstract Builder setAppId(int r100);

        public abstract Builder setAppKey(String r100);

        public abstract Builder setAppToken(String r100);

        public abstract Builder setAppVersion(int r100);

        public abstract Builder setCustomizedHeaders(Map<String, String> r100);

        public abstract Builder setCustomizedParams(Map<String, String> r100);

        public abstract Builder setDeviceId(long r100);

        public abstract Builder setFpid(int r100);

        public abstract Builder setInstallId(long r100);

        public abstract Builder setSessionId(String r100);

        public abstract Builder setSharedConnection(boolean r100);

        public abstract Builder setUrlList(List<String> r100);

        public abstract Builder useFrontierProtocol(boolean r100);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onConnectionError(TTWebsocketConnection r100, int r101, String r102, String r103);

        public abstract void onConnectionStateChanged(TTWebsocketConnection r100, int r101, String r102);

        public void onFeedbackLog(TTWebsocketConnection r100, String r101) {
        }

        public abstract void onMessageReceived(TTWebsocketConnection r100, ByteBuffer r101, int r102) throws Exception;

        public void onTrafficChanged(TTWebsocketConnection r100, String r101, long r102, long r103, boolean r104) {
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class Status {
        public static final int ConnectClosed = 3;
        public static final int ConnectFailed = 2;
        public static final int ConnectUnknown = -1;
        public static final int Connected = 4;
        public static final int Connecting = 0;
        public static final int Disconnecting = 1;

        private Status() {
        }
    }

    public TTWebsocketConnection() {
    }

    public abstract void asyncSendBinary(ByteBuffer r100);

    public abstract void asyncSendText(String r100);

    public abstract void destroyConnection();

    public abstract boolean isConnected();

    public abstract void startConnection();

    public abstract void stopConnection();
}
