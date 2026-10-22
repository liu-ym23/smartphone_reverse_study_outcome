package rd;

import android.content.Context;
import td.d;
import td.e;

/* JADX INFO: loaded from: classes43.dex */
public interface a {
    void a(com.bytedance.android.ec.adapter.api.state.a r100);

    void b(d r100);

    void businessType();

    void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101);

    void d(td.c r100);

    void e(e r100);

    void f(td.b r100);

    void onActivityCreated();

    void onContextAttached(Context r100);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onEnterRoomPrepared();

    void onExitRoom();

    void onRoomVisible();

    void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103);

    void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102);

    void onSpecificWidgetLoadFinished(String r100);

    void onStart();

    void onStop();

    void onWidgetLoadFinished();
}
