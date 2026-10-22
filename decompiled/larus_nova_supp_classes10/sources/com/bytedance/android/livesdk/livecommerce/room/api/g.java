package com.bytedance.android.livesdk.livecommerce.room.api;

import ak2.j;
import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface g {
    void a(com.bytedance.android.ec.adapter.api.state.c r1);

    void b(j r1);

    void onContextAttached(Context r1);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onStart();

    void onStop();

    void onViewCreated();
}
