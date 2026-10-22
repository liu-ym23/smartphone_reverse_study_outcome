package com.larus.platform.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes31.dex */
public interface u0 {
    void a(Activity r100, Bundle r101);

    void attachBaseContext(Context r100);

    void b(Activity r100, Bundle r101);

    kotlinx.coroutines.flow.i1<Boolean> c();

    void d(Activity r100, boolean r101);

    void onCreate();

    void onDestroy();
}
