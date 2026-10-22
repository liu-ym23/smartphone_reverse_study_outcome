package mi6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimulcastStreamType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMessageConfig;
import dg2.i;
import java.util.List;
import yf2.d;
import yf2.e;
import zf2.l0;
import zf2.r;

/* JADX INFO: loaded from: classes19.dex */
public interface b {
    int a(i r100);

    int b();

    long c(String r100);

    int d();

    void destroy();

    int e();

    int f(List<r> r100, String r101);

    int g();

    String getRoomId();

    int h();

    long i(String r100, String r101, LiveWrappedMessageConfig r102);

    int j(List<r> r100, String r101);

    int k(boolean r100);

    int l(LiveWrappedSimulcastStreamType r100);

    int leaveRoom();

    void m(LiveWrappedStreamIndex r100, LiveWrappedMediaStreamType r101);

    void n(String r100, LiveWrappedStreamIndex r101, LiveWrappedMediaStreamType r102);

    void o();

    int p();

    int q();

    int r();

    int s(int r100);

    int t(String r100, e r101, boolean r102, d r103);

    int u(String r100, LiveWrappedStreamIndex r101, l0 r102);

    int v();

    void w(String r100, LiveWrappedStreamIndex r101, LiveWrappedMediaStreamType r102);

    int x();

    void y(LiveWrappedStreamIndex r100, LiveWrappedMediaStreamType r101);
}
