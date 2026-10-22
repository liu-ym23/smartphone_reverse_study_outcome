package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum LoadState extends Enum<LoadState> {
    private static final /* synthetic */ LoadState[] $VALUES = null;
    public static final LoadState CONNECTING = null;
    public static final LoadState DOWNLOADING_PAC_FILE = null;
    public static final LoadState ESTABLISHING_PROXY_TUNNEL = null;
    public static final LoadState IDLE = null;
    public static final LoadState READING_RESPONSE = null;
    public static final LoadState RESOLVING_HOST = null;
    public static final LoadState RESOLVING_HOST_IN_PAC_FILE = null;
    public static final LoadState RESOLVING_PROXY_FOR_URL = null;
    public static final LoadState SENDING_REQUEST = null;
    public static final LoadState SSL_HANDSHAKE = null;
    public static final LoadState WAITING_FOR_APPCACHE = null;
    public static final LoadState WAITING_FOR_AVAILABLE_SOCKET = null;
    public static final LoadState WAITING_FOR_CACHE = null;
    public static final LoadState WAITING_FOR_DELEGATE = null;
    public static final LoadState WAITING_FOR_RESPONSE = null;
    public static final LoadState WAITING_FOR_STALLED_SOCKET_POOL = null;

    static {
        LoadState r100 = new LoadState("IDLE", 0);
        IDLE = r100;
        LoadState r101 = new LoadState("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        WAITING_FOR_STALLED_SOCKET_POOL = r101;
        LoadState r102 = new LoadState("WAITING_FOR_AVAILABLE_SOCKET", 2);
        WAITING_FOR_AVAILABLE_SOCKET = r102;
        LoadState r103 = new LoadState("WAITING_FOR_DELEGATE", 3);
        WAITING_FOR_DELEGATE = r103;
        LoadState r104 = new LoadState("WAITING_FOR_CACHE", 4);
        WAITING_FOR_CACHE = r104;
        LoadState r105 = new LoadState("WAITING_FOR_APPCACHE", 5);
        WAITING_FOR_APPCACHE = r105;
        LoadState r110 = new LoadState("DOWNLOADING_PAC_FILE", 6);
        DOWNLOADING_PAC_FILE = r110;
        LoadState r111 = new LoadState("RESOLVING_PROXY_FOR_URL", 7);
        RESOLVING_PROXY_FOR_URL = r111;
        LoadState r112 = new LoadState("RESOLVING_HOST_IN_PAC_FILE", 8);
        RESOLVING_HOST_IN_PAC_FILE = r112;
        LoadState r113 = new LoadState("ESTABLISHING_PROXY_TUNNEL", 9);
        ESTABLISHING_PROXY_TUNNEL = r113;
        LoadState r114 = new LoadState("RESOLVING_HOST", 10);
        RESOLVING_HOST = r114;
        LoadState r115 = new LoadState("CONNECTING", 11);
        CONNECTING = r115;
        LoadState r106 = new LoadState("SSL_HANDSHAKE", 12);
        SSL_HANDSHAKE = r106;
        LoadState r107 = new LoadState("SENDING_REQUEST", 13);
        SENDING_REQUEST = r107;
        LoadState r108 = new LoadState("WAITING_FOR_RESPONSE", 14);
        WAITING_FOR_RESPONSE = r108;
        LoadState r109 = new LoadState("READING_RESPONSE", 15);
        READING_RESPONSE = r109;
        $VALUES = new LoadState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public static LoadState[] values() {
        return (LoadState[]) $VALUES.clone();
    }

    public static LoadState valueOf(String r100) {
        return (LoadState) a.a(LoadState.class, r100);
    }

    private LoadState(String r100, int r101) {
        super(r100, r101);
    }
}
