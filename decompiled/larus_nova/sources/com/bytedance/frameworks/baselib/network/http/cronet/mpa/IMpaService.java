package com.bytedance.frameworks.baselib.network.http.cronet.mpa;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface IMpaService {

    public interface ICallback {
        void onFinish(boolean r100, String r101);
    }

    void command(String r100, String r101);

    void init(ICallback r100);

    void setAccAddress(List<String> r100, ICallback r101);

    void start();

    void stop();
}
