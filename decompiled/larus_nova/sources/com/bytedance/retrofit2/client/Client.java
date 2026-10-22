package com.bytedance.retrofit2.client;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface Client {

    /* JADX INFO: loaded from: classes3.dex */
    public interface Provider {
        Client get();
    }

    SsCall newSsCall(Request r100) throws IOException;
}
