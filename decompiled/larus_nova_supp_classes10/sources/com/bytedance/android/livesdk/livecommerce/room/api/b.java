package com.bytedance.android.livesdk.livecommerce.room.api;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {
    void a(com.bytedance.android.ec.adapter.api.state.a r1);

    void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2);

    void d(e r1);

    void e(f r1);

    void g(d r1);

    void i(c r1);

    void j(h r1);

    void onActivityCreated();

    void onContextAttached(Context r1);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onEnterRoomPrepared();

    void onExitRoom();

    void onFirstFrame();

    void onP0WidgetLoadFinished();

    void onPause();

    void onResume();

    void onRoomVisible();

    void onSpecificBehaviorLoad(String r1, boolean r2, boolean r3, String r4);

    void onSpecificBehaviorUnload(String r1, boolean r2, boolean r3);

    void onSpecificViewAttached(String r1);

    void onSpecificWidgetLoadFinished(String r1);

    void onStart();

    void onStop();

    void onWidgetLoadFinished();
}
