package mb6;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.guestlink.api.GuestLinkEnterChannelType;

/* JADX INFO: loaded from: classes19.dex */
public interface b extends lb6.d {

    public interface a {
        void h(long r100, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r101, @GuestLinkEnterChannelType long r102);

        void o(long r100, Throwable r101, @GuestLinkEnterChannelType long r102);
    }

    /* JADX INFO: renamed from: mb6.b$b, reason: collision with other inner class name */
    public interface InterfaceC6793b {
        void j(long r100, String r101, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.a, Extra> r102);

        void r(long r100, Throwable r101);
    }

    public interface c {
        void C2(long r100, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.c, Extra> r101);

        void o1(long r100, Throwable r101);
    }

    public interface d {
        void i(long r100, Throwable r101);

        void q(long r100, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.d, Extra> r101);
    }

    void B(long r100, long r101, String r102, d r103);

    void D(long r100, long r101, long r102);

    void m(long r100, long r101, long r102, @GuestLinkEnterChannelType long r103, GuestLinkPipeLineManager.b r104);

    void t(long r100, long r101, String r102, String r103, GuestLinkPipeLineManager.f r104);

    void v(long r100, long r101, int r102, com.bytedance.android.live.livelink.guestlink.pipeline.a r103);
}
