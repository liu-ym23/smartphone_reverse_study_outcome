package com.bytedance.push.third;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IPushAdapter {
    boolean checkThirdPushConfig(String r100, Context r101) throws Exception;

    boolean isPushAvailable(Context r100, int r101);

    void registerPush(Context r100, int r101);

    boolean requestRemoveVoipNotification(Context r100, int r101);

    void setAlias(Context r100, String r101, int r102);

    void trackPush(Context r100, int r101, Object r102);

    void unregisterPush(Context r100, int r101);
}
