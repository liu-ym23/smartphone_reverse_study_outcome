package nc0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements com.bytedance.android.live.revenuelink.connect.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ey.h f518611a;

    public g(ey.h r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518611a = r100;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void Z2(fy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "finishParams");
        this.f518611a.Z2(r100);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void h3(fy.f r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "joinChannelParams");
        this.f518611a.h3(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void i3(fy.d r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "finishParams");
        this.f518611a.i3(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult] */
    /* JADX WARN: Type inference failed for: r2v4, types: [EXTRA extends com.bytedance.android.live.base.model.Extra, R extends com.bytedance.android.live.base.model.Extra] */
    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void k3(fy.h r100, ExtraResponse<n0, Extra> r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveParams");
        ey.h r102 = this.f518611a;
        if (r101 == null) goto L9;
        Response<LinkLeaveResult> r103 = new Response();
        vh7.c r104 = k.a(r101.data);
        if (r104 == null) goto L8;
        r103.data = (LinkLeaveResult) r104;
        r103.extra = r101.extra;
        r103.logId = r101.logId;
        r103.traceId = r101.f83937b;
        r103.requestType = r101.f83936a;
    L10:
        r102.Pi(r100, r103);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult");
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void m2(fy.h r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveParams");
        this.f518611a.m2(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult] */
    /* JADX WARN: Type inference failed for: r2v4, types: [EXTRA extends com.bytedance.android.live.base.model.Extra, R extends com.bytedance.android.live.base.model.Extra] */
    @Override // com.bytedance.android.live.revenuelink.connect.i
    public final void m3(fy.f r100, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r101) {
        Intrinsics.checkNotNullParameter(r100, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r101, "response");
        ey.h r102 = this.f518611a;
        Response<AnchorJoinChannelResult> r103 = new Response();
        vh7.c r104 = k.a(r101.data);
        if (r104 == null) goto L7;
        r103.data = (AnchorJoinChannelResult) r104;
        r103.extra = r101.extra;
        r103.logId = r101.logId;
        r103.traceId = r101.f83937b;
        r103.requestType = r101.f83936a;
        Unit r105 = Unit.INSTANCE;
        r102.pl(r100, r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult");
    }
}
