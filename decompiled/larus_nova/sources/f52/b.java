package f52;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public interface b {
    void a(j r100);

    void b(c r100, View r101, ViewGroup.LayoutParams r102);

    View c(c r100);

    void d(c r100);

    void e(d r100);

    void f(e r100);

    Context getContext();

    DataCenter getDataCenter();

    o getRoomContext();

    ViewGroup getRoot();

    void onCreate();

    void onDestroy();
}
