package com.bytedance.common.wschannel.channel;

import android.content.Context;

/* JADX INFO: loaded from: classes15.dex */
public interface IWsChannelDepend {
    int getNetworkType(Context r100);

    void loadLibrary(Context r100, String r101);

    void loggerD(String r100, String r101);

    boolean loggerDebug();

    void setAdapter(IWsChannelDepend r100);
}
