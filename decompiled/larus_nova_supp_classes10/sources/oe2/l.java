package oe2;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements b {
    public static final a f = null;
    public String a;
    public final int b;
    public final int c;
    public com.bytedance.android.live.pushstream.d d;
    public final j1 e;

    public static final class a {
        public a() {
        }

        public static int a() {
            int r0 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
            int r1 = ((Number) com.bytedance.android.livesdk.sharedpref.c.f.getValue()).intValue();
            if (r1 != 0) goto L6;
            return 2;
        L6:
            return r1;
        }
    }

    public l() {
        this(null);
    }

    @Override // oe2.b
    public final int b() {
        return -1;
    }

    @Override // oe2.b
    public final Boolean e() {
        return null;
    }

    @Override // oe2.b
    public final boolean j() {
        return false;
    }

    @Override // oe2.b
    public final boolean l() {
        return false;
    }

    static {
        f = new a();
    }

    @Override // oe2.b
    public final int d() {
        f.getClass();
        return a.a();
    }

    @Override // oe2.b
    public final boolean m() {
        if (jc1.k.n(IInteractService.class).getCurrentScene() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // oe2.b
    public final String a() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L5;
        return "ktv_room_open";
    L5:
        return null;
    }

    @Override // oe2.b
    public final String c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L7;
        return null;
    L7:
        return this.a;
    }

    @Override // oe2.b
    public final com.bytedance.android.live.pushstream.d g() {
        return this.d;
    }

    @Override // oe2.b
    public final String getEnterFrom() {
        return this.a;
    }

    @Override // oe2.b
    public final int i() {
        return this.c;
    }

    @Override // oe2.b
    public final int k() {
        return this.b;
    }

    public l(j1 r1) {
        this.e = r1;
        this.b = 1;
        this.c = 2;
    }

    @Override // oe2.b
    public final void f(boolean r2) {
        f.getClass();
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.f;
        if (r2 == false) goto L5;
        int r3 = 1;
    L6:
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        return;
    L5:
        r3 = 2;
        goto L6
    }

    @Override // oe2.b
    public final <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        j1 r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.getScopeServiceOrNullInMultiLinkRoom(r2);
    }

    @Override // oe2.b
    public final com.bytedance.android.live.pushstream.d h(boolean r1) {
        if (r1 == true) goto L9;
        Lazy r2 = KtvSettingHelper.a;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.guestLiveStream();
    L9:
        return this.d;
    }
}
