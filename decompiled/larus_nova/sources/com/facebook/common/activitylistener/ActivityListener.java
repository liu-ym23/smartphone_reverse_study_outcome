package com.facebook.common.activitylistener;

import android.app.Activity;

/* JADX INFO: loaded from: classes22.dex */
public interface ActivityListener {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;

    int getPriority();

    void onActivityCreate(Activity r100);

    void onDestroy(Activity r100);

    void onPause(Activity r100);

    void onResume(Activity r100);

    void onStart(Activity r100);

    void onStop(Activity r100);
}
