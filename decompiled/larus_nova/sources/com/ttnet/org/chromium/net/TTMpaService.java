package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TTMpaService {

    /* JADX INFO: loaded from: classes41.dex */
    public interface ICallback {
        void onFinish(boolean r100, String r101);
    }

    public TTMpaService() {
    }

    public abstract void command(String r100, String r101);

    public abstract void init(ICallback r100);

    public abstract void setAccAddress(List<String> r100, ICallback r101);

    public abstract void start();

    public abstract void stop();
}
