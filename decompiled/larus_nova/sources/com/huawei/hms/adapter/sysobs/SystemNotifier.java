package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int r100);

    void notifyObservers(int r100);

    void notifyObservers(Intent r100, String r101);

    void registerObserver(SystemObserver r100);

    void unRegisterObserver(SystemObserver r100);
}
