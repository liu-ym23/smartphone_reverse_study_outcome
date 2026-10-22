package fe2;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import hg6.g;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements a {
    public final j1 a;

    public final void d() {
        j1 r0 = this.a;
        if (r0 == null) goto L14;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L15;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L16;
        ec6.b r3 = r2.R();
        if (r3 == null) goto L17;
        d r4 = gc6.b.a(r3);
        if (r4 == null) goto L18;
        r4.u();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // fe2.a
    public final void a() {
        d();
    }

    @Override // fe2.a
    public final void c() {
        d();
    }

    public b(j1 r1) {
        this.a = r1;
    }

    @Override // fe2.a
    public final void b(float r3) {
        j1 r0 = this.a;
        if (r0 == null) goto L9;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L9;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L9;
        ei6.a r4 = r2.V0();
    L10:
        if (r4 == null) goto L15;
        ri6.b r5 = r4.r();
        if (r5 == null) goto L16;
        r5.d(MathKt.roundToInt(r3));
        return;
    L16:
        return;
    L15:
        return;
    L9:
        r4 = null;
        goto L10
    }
}
