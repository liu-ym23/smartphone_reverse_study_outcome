package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes3.dex */
public class StreamTrafficObservable extends Observable {
    public static final String STREAM_CONTENTTYPE = "content_type";
    public static final String STREAM_RECEIVEDBYTES = "received_bytes";
    public static final String STREAM_REQUESTLOG = "request_log";
    public static final String STREAM_SENTBYTES = "sent_bytes";
    public static final String STREAM_URL = "url";
    private static volatile StreamTrafficObservable sInstance;

    public static StreamTrafficObservable inst() {
        if (sInstance != null) goto L15;
        monitor-enter(StreamTrafficObservable.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StreamTrafficObservable();     // Catch: Throwable -> L11
    L9:
        monitor-exit(StreamTrafficObservable.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public StreamTrafficObservable() {
    }

    private void notifyTrafficChangedObservers(Map<String, Object> r100) {
        setChanged();
        notifyObservers(r100);
    }

    public void onStreamTrafficChanged(String r100, long r101, long r102, String r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("url", r100);
        r105.put(STREAM_SENTBYTES, Long.valueOf(r101));
        r105.put(STREAM_RECEIVEDBYTES, Long.valueOf(r102));
        r105.put("content_type", r103);
        r105.put("request_log", r104);
        notifyTrafficChangedObservers(r105);
    }
}
