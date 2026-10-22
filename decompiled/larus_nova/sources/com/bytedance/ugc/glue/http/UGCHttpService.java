package com.bytedance.ugc.glue.http;

import ep7.a;

/* JADX INFO: loaded from: classes22.dex */
public class UGCHttpService {
    private static UGCHttpService instance;

    static {
        instance = new UGCHttpService();
    }

    private static UGCHttpService getInstance() {
        int r100 = a.f473437a;
        return instance;
    }

    public UGCHttpService() {
    }

    public final void register() {
        instance = this;
    }

    public static <T> void send(UGCRequest<T> r100) {
        getInstance().sendImpl(r100);
    }

    public <T> void sendImpl(UGCRequest<T> r100) {
        UGCCallback<T> r101 = r100.getCallback();
        if (r101 == null) goto L6;
        r101.onResponse(0, null);
        return;
    }
}
