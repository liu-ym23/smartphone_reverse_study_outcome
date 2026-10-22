package com.bytedance.sync.v2.net;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NetTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f270441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f270442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f270443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f270444d;

    /* JADX INFO: loaded from: classes22.dex */
    public @interface SendMethod {
        public static final int UNKNOWN = 0;
        public static final int WITH_HTTPS = 2;
        public static final int WITH_SOCKET = 1;
    }

    /* JADX INFO: loaded from: classes22.dex */
    public @interface SendResult {
        public static final int SEND_FAILED = 2;
        public static final int SEND_FAILED_NET_NOT_AVAILABLE = 3;
        public static final int SEND_SUCCESS = 1;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: loaded from: classes22.dex */
    public @interface Strategy {
        public static final int HTTP_FIRST_BACKGROUND = 4;
        public static final int HTTP_FIRST_FOREGROUND = 3;
        public static final int UNKNOWN = 0;
        public static final int WS_FIRST_CONNECTED = 1;
        public static final int WS_FIRST_DISCONNECTED = 2;
    }

    public interface a {
        int e();
    }

    public abstract void a();

    public NetTrace() {
        this.f270441a = 0;
        this.f270442b = 0;
        this.f270443c = 0;
        this.f270444d = 0;
    }
}
