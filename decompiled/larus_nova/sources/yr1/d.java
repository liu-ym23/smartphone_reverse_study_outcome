package yr1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface d {
    void a(Bundle r100, DataCenter r101);

    String appId();

    DataCenter c(DataCenter r100, long r101);

    String currentUserId();

    boolean d(DataCenter r100);

    void f(FragmentActivity r100);

    boolean g(Bundle r100);

    List<Class<?>> getAllLiveActivity();

    Activity getTopActivity();

    void h(Bundle r100, Bundle r101);

    void i(long r100);

    boolean isSaas();

    com.bytedance.android.livesdk.chatroom.vs_host.business.e j(Context r100);

    void k(DataCenter r100);

    void n();

    boolean o();

    void q(Context r100, String r101, String r102);

    void registerLiveLifeCycleListener(IHostAppMonitorListener r100);

    void s(FragmentActivity r100);

    void updateAnimatedFrameScheduler(boolean r100);
}
