package yr1;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastOptionResolutionStrategyInfo;
import com.bytedance.android.livesdk.castscreen.datacontext.CastScreenConnectDataContext;
import com.bytedance.android.livesdk.castscreen.datacontext.ReplayCastScreenModelFactory;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    com.bytedance.live.datacontext.m<Boolean> A(DataCenter r100);

    com.bytedance.live.datacontext.m<Boolean> E(DataCenter r100);

    Boolean F(DataCenter r100);

    void I();

    void J();

    Boolean K(DataCenter r100);

    CastScreenConnectDataContext a();

    com.bytedance.live.datacontext.m<Boolean> c(DataCenter r100);

    com.bytedance.live.datacontext.m<Boolean> castScreenMode(DataCenter r100);

    Boolean d(DataCenter r100);

    com.bytedance.android.livesdk.chatroom.vs_host.business.c f();

    Class<? extends ViewModel> g();

    void h();

    void i(long r100);

    boolean isByteMatchCasting(DataCenter r100);

    boolean j();

    void k(boolean r100);

    LiveCastOptionResolutionStrategyInfo liveClarityStrategy();

    boolean liveIconOpt();

    void n(DataCenter r100, KVData r101);

    com.bytedance.live.datacontext.m<String> o(DataCenter r100);

    void pause();

    boolean q();

    NextLiveData<Boolean> s(DataCenter r100);

    void w(DataCenter r100, boolean r101);

    boolean x(DataCenter r100);

    ReplayCastScreenModelFactory y(DataCenter r100);
}
