package wb6;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.m;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public interface a extends vb6.d {

    /* JADX INFO: renamed from: wb6.a$a, reason: collision with other inner class name */
    public interface InterfaceC8088a {
        void U8(long r100, ExtraResponse<IApplyResult, Extra> r101);

        void Wb(long r100, Throwable r101);
    }

    public interface b {
        void bp(long r100, ExtraResponse<LinkFinishResult, Extra> r101);

        void yp(long r100, Throwable r101);
    }

    public interface c {
        void C2(long r100, ExtraResponse<? extends IJoinChannelResult, Extra> r101);

        void o1(long r100, Throwable r101);
    }

    public interface d {
        void a(ExtraResponse r100);

        void b(Throwable r100);
    }

    public interface e {
        void F2(long r100, Throwable r101);

        void Xf(long r100, ExtraResponse<? extends g1, Extra> r101);
    }

    public interface f {
        void a(Throwable r100);

        void b(long r100, ExtraResponse<Unit, Extra> r101);
    }

    public interface g {
        void a(long r100, ExtraResponse<t2, Extra> r101);

        void b(long r100, Throwable r101);
    }

    public interface h {
        void Fk(long r100, Throwable r101);

        void wn(long r100, ExtraResponse<m, Extra> r101);
    }

    void C(long r100, String r101, String r102, com.bytedance.live.bizlink.impl.platform.manager.a.m r103);

    void F(long r100, String r101, com.bytedance.android.live.livelink.multilink.pipeline.d r102);

    void M(long r100, String r101, String r102, String r103, com.bytedance.live.bizlink.impl.platform.manager.a.i r104);

    void R(long r100, String r101, Map r102, LinkPipelineManager.f r103);

    void f0(long r100, String r101, String r102, int r103, int r104, Map r105, LinkPipelineManager.k r106);

    void i0(long r100, Map r101, LinkPipelineManager.j r102);

    void p0(long r100, String r101, com.bytedance.android.live.livelink.multilink.pipeline.e r102);

    void y(long r100, String r101, Map r102, com.bytedance.android.live.livelink.multilink.pipeline.c r103);
}
