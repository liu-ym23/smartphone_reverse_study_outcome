package fe2;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import hg6.g;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1 f476563a;

    public final void d() {
        j1 r100 = this.f476563a;
        if (r100 == null) goto L14;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r101 == null) goto L15;
        g r102 = r101.getRtcManager();
        if (r102 == null) goto L16;
        ec6.b r103 = r102.R();
        if (r103 == null) goto L17;
        d r104 = gc6.b.a(r103);
        if (r104 == null) goto L18;
        r104.u();
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

    public b(j1 r100) {
        this.f476563a = r100;
    }

    @Override // fe2.a
    public final void b(float r100) {
        j1 r101 = this.f476563a;
        if (r101 == null) goto L9;
        cg6.a r102 = (cg6.a) r101.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r102 == null) goto L9;
        g r103 = r102.getRtcManager();
        if (r103 == null) goto L9;
        ei6.a r104 = r103.V0();
    L10:
        if (r104 == null) goto L15;
        ri6.b r105 = r104.r();
        if (r105 == null) goto L16;
        r105.d(MathKt.roundToInt(r100));
        return;
    L16:
        return;
    L15:
        return;
    L9:
        r104 = null;
        goto L10
    }
}
