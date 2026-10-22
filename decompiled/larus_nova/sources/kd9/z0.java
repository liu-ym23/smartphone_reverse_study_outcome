package kd9;

import com.bytedance.common.wschannel.WsConstants;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class z0 implements com.larus.im.internal.audio.session.v2.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y0 f502973a;

    public z0(y0 r100) {
        this.f502973a = r100;
    }

    @Override // com.larus.im.internal.audio.session.v2.q0
    public final void a(nd9.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        y0 r101 = this.f502973a;
        if (r101.f502957h == true) goto L5;
        r101.f502957h = true;
        fe9.c.f476624a.e(r101.f502956g, "start uplink data callback");
    L5:
        y0 r102 = this.f502973a;
        if (r102.f502958i == true) goto L9;
        fe9.c.f476624a.e(r102.f502956g, "capture is not active, skip");
        return;
    L9:
        LinkedBlockingQueue<y0.c> r103 = r102.f502962m;
        byte[] r104 = com.flow.kmp.common.util.b.e(r100.f518809a);
        he9.c r105 = this.f502973a.f502959j;
        String r106 = null;
        if (r105 == null) goto L20;
        ByteBuffer r107 = r100.f518810b;
        if (r107 == null) goto L14;
        byte[] r108 = com.flow.kmp.common.util.b.e(r107);
    L15:
        he9.a.C6134a r109 = r105.a(r108);
        if (r109 == null) goto L20;
        ouc.d0 r110 = r109.f484895b;
        if (r110 == null) goto L20;
        r106 = r110.toString();
        goto L20
    L14:
        r108 = null;
    L20:
        ue9.g.f549873a.getClass();
        com.larus.im.service.audio.l r111 = new com.larus.im.service.audio.l(r104, r106, ue9.g.b.f549878c, false);
        y0 r112 = this.f502973a;
        int r113 = r112.f502965p + 1;
        r112.f502965p = r113;
        r103.offer(new y0.c(r111, ((long) r113) * 20000));
    }

    @Override // com.larus.im.internal.audio.session.v2.q0
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
    }
}
