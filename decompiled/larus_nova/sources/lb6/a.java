package lb6;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.guestlink.i;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.guestlink.api.GuestLinkEnterChannelType;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class a implements f {
    public a() {
    }

    public void A(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    public void J(String[] r100, boolean[] r101, int[] r102) {
    }

    public void a() {
    }

    public void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r101, "rtcUserId");
    }

    @Override // ob6.a.InterfaceC7033a
    public final void c() {
    }

    public void d(String r100) {
    }

    public void e(long r100, long r101) {
    }

    @Override // qb6.a.InterfaceC7306a
    public void f(i r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    public void g() {
    }

    public void k(String r100, int r101) {
    }

    public void l(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoomId");
    }

    public void m() {
    }

    public void n() {
    }

    public void onInitSuccess() {
    }

    public void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoomId");
    }

    @Override // ob6.a.InterfaceC7033a
    public final void s() {
    }

    @Override // ob6.a.InterfaceC7033a
    public final void t() {
    }

    public void C2(long r100, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.c, Extra> r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    public void i(long r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
    }

    public void o1(long r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
    }

    public void q(long r100, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.d, Extra> r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    public void r(long r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
    }

    public void j(long r100, String r101, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.a, Extra> r102) {
        Intrinsics.checkNotNullParameter(r101, "requestSource");
        Intrinsics.checkNotNullParameter(r102, "response");
        Intrinsics.checkNotNullParameter(r101, "requestSource");
        Intrinsics.checkNotNullParameter(r102, "response");
        Intrinsics.checkNotNullParameter(r101, "requestSource");
        Intrinsics.checkNotNullParameter(r102, "response");
    }

    public void o(long r100, Throwable r101, @GuestLinkEnterChannelType long r102) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
    }
}
