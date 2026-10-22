package vr1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_host.impl.VSPlayerService$createGestureViewManager$manager$1;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.Pair;

/* JADX INFO: loaded from: classes8.dex */
public interface s {
    void a(DataCenter r100);

    String c();

    ILivePlayerClient currentClient();

    void d(IBaseStreamUrl r100);

    void f(long r100, long r101, boolean r102);

    VSPlayerService$createGestureViewManager$manager$1 g(Context r100, View r101, ViewGroup r102, com.bytedance.android.livesdk.chatroom.vs.gesture.g r103);

    Pair<WeakReference<View>, WeakReference<View>> getLivePlayerView();
}
