package ho1;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.n;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.p;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.t;
import com.bytedance.android.livesdk.chatroom.widget.landscape.u;
import com.bytedance.android.livesdk.widget.h0;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import gd0.f;
import gd0.k;
import iy.d;
import jo1.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static final d a(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (d) r101.getAbility(d.class);
    L6:
        return null;
    }

    public static final f b(e0 r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.f162378m;
        if (r101 == null) goto L6;
        return (f) r101.getAbility(f.class);
    L6:
        return null;
    }

    public static final com.bytedance.android.livesdk.chatroom.ui.framework.a c(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.a) r101.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
    L6:
        return null;
    }

    public static final com.bytedance.android.livesdk.chatroom.ui.framework.c d(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.c) r101.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
    L6:
        return null;
    }

    public static final n e(h70.b r100) {
        IAbilityCenter r101 = r100.a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (n) r101.getAbility(n.class);
    }

    public static final q f(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (q) r101.getAbility(q.class);
    L6:
        return null;
    }

    public static final h g(e0 r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.f162378m;
        if (r101 == null) goto L6;
        return (h) r101.getAbility(h.class);
    L6:
        return null;
    }

    public static final u h(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (u) r101.getAbility(u.class);
    L6:
        return null;
    }

    public static final com.bytedance.android.livesdk.chatroom.ui.framework.d i(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.d) r101.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.d.class);
    L6:
        return null;
    }

    public static final p j(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (p) r101.getAbility(p.class);
    L6:
        return null;
    }

    public static final k k(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (k) r101.getAbility(k.class);
    L6:
        return null;
    }

    public static final h0 l(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (h0) r101.getAbility(h0.class);
    L6:
        return null;
    }

    public static final yh0.c m(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (yh0.c) r101.getAbility(yh0.c.class);
    L6:
        return null;
    }

    public static final t n(e0 r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.f162378m;
        if (r101 == null) goto L6;
        return (t) r101.getAbility(t.class);
    L6:
        return null;
    }

    public static final boolean o(h70.b r100) {
        if ((r100 instanceof d90.d) == true) goto L5;
        r100 = null;
    L5:
        d90.d r101 = (d90.d) r100;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.f467476d;
    }

    public static final <T extends IAbility> void q(h70.b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 == null) goto L8;
        IAbilityCenter r102 = r100.a();
        if (r102 == null) goto L9;
        r102.unregisterAbility(r101);
        return;
    L9:
        return;
    }

    public static final <T extends IAbility> void p(h70.b r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "ability");
        if (r100 == null) goto L8;
        IAbilityCenter r103 = r100.a();
        if (r103 == null) goto L9;
        r103.registerAbility(r101, r102);
        return;
    L9:
        return;
    }
}
