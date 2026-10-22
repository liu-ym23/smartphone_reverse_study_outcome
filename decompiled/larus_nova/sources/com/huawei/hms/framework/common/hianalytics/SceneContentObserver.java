package com.huawei.hms.framework.common.hianalytics;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes23.dex */
public class SceneContentObserver extends ContentObserver {
    public native void onChangeForMp();

    public SceneContentObserver(Handler r100) {
        super(r100);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r100) {
        onChangeForMp();
    }
}
