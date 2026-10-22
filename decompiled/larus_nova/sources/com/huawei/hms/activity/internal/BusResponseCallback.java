package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public interface BusResponseCallback {
    BusResponseResult innerError(Activity r100, int r101, String r102);

    BusResponseResult succeedReturn(Activity r100, int r101, Intent r102);
}
