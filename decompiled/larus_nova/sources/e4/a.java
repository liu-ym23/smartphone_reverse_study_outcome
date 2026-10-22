package e4;

import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.app.foundation.performance.f;
import com.bytedance.ai.applet.app.foundation.performance.g;
import com.bytedance.ai.applet.app.foundation.performance.i;
import com.bytedance.ai.bridge.performance.AbsGetPerformanceEntriesMethodIDL;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final AbsGetPerformanceEntriesMethodIDL.PerformanceEntry b(f r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = null;
        if ((r110 instanceof f.a) == false) goto L10;
        f.a r101 = (f.a) r110;
        Long r102 = Long.valueOf(r101.f34296b);
        String r103 = r101.f34297c.f34328b;
        Long r104 = r101.f34298d;
        AppletPerformanceNavigationType r105 = r101.f34299e;
        if (r105 == null) goto L7;
        String r106 = r105.getValue();
    L54:
        return a(r110, r102, r103, r104, r106, null, null, null, null, null, null, 1008);
    L7:
        r106 = null;
        goto L54
    L10:
        if ((r110 instanceof f.h) == false) goto L16;
        f.h r107 = (f.h) r110;
        Long r108 = Long.valueOf(r107.f34320b);
        String r109 = r107.f34321c.f34328b;
        Long r111 = r107.f34324f;
        AppletPerformanceNavigationType r112 = r107.f34325g;
        if (r112 == null) goto L55;
        r100 = r112.getValue();
    L55:
        return a(r110, r108, r109, r111, r100, null, null, null, null, r107.f34322d, r107.f34323e, 240);
    L16:
        if ((r110 instanceof f.C0680f) == false) goto L25;
        f.C0680f r113 = (f.C0680f) r110;
        Long r114 = Long.valueOf(r113.f34313b);
        i r115 = r113.f34314c;
        if ((r115 instanceof g.a) == false) goto L20;
        g.a r116 = (g.a) r115;
    L21:
        if (r116 == null) goto L56;
        r100 = r116.f34328b;
    L56:
        return a(r110, r114, r100, null, null, null, r113.f34315d, r113.f34316e, r113.f34317f, null, null, 796);
    L20:
        r116 = null;
        goto L21
    L25:
        if ((r110 instanceof f.e) == false) goto L34;
        i r117 = ((f.e) r110).f34310b;
        if ((r117 instanceof g.a) == false) goto L29;
        g.a r118 = (g.a) r117;
    L30:
        if (r118 == null) goto L57;
        r100 = r118.f34328b;
    L57:
        return a(r110, null, r100, null, null, null, null, null, null, null, null, 1021);
    L29:
        r118 = null;
        goto L30
    L34:
        if ((r110 instanceof f.d) == false) goto L43;
        i r119 = ((f.d) r110).f34307b;
        if ((r119 instanceof g.a) == false) goto L38;
        g.a r120 = (g.a) r119;
    L39:
        if (r120 == null) goto L58;
        r100 = r120.f34328b;
    L58:
        return a(r110, null, r100, null, null, null, null, null, null, null, null, 1021);
    L38:
        r120 = null;
        goto L39
    L43:
        if ((r110 instanceof f.c) == false) goto L46;
        f.c r121 = (f.c) r110;
        return a(r110, Long.valueOf(r121.f34302b), null, null, null, r121.f34304d, null, null, null, null, null, 1006);
    L46:
        if ((r110 instanceof f.b) == false) goto L49;
        ((f.b) r110).getClass();
        return a(r110, 0L, null, null, null, null, null, null, null, null, null, 1022);
    L49:
        if ((r110 instanceof f.g) == false) goto L53;
        ((f.g) r110).getClass();
        return a(r110, 0L, null, null, null, null, null, null, null, null, null, 1022);
    L53:
        throw new NoWhenBranchMatchedException();
    }

    public static AbsGetPerformanceEntriesMethodIDL.PerformanceEntry a(f r210, Long r211, String r212, Long r213, String r214, String r215, Long r216, Long r310, Long r311, String r312, Long r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        Long r110 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r112 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Long r113 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Long r114 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Long r115 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Long r117 = null;
    L42:
        g r102 = r210.b();
        if ((r102 instanceof g.a) == false) goto L45;
        g.a r103 = (g.a) r102;
    L46:
        g r104 = r210.b();
        if ((r104 instanceof g.c) == false) goto L49;
        g.c r105 = (g.c) r104;
    L50:
        String r106 = r210.a().getEntryType().getValue();
        String r107 = r210.a().getValue();
        long r108 = r210.c();
        if (r103 == null) goto L53;
        Long r109 = Long.valueOf(r103.f34327a);
    L54:
        if (r105 == null) goto L56;
        String r118 = r105.f34331b;
    L57:
        if (r105 == null) goto L59;
        String r217 = r105.f34332c;
    L60:
        if (r105 == null) goto L62;
        Boolean r218 = Boolean.valueOf(r105.f34333d);
    L64:
        return new AbsGetPerformanceEntriesMethodIDL.PerformanceEntry(r106, r107, r108, r100, r101, r110, r111, r112, r114, r115, r109, r116, r117, r113, r118, r217, r218);
    L62:
        r218 = null;
        goto L64
    L59:
        r217 = null;
        goto L60
    L56:
        r118 = null;
        goto L57
    L53:
        r109 = null;
        goto L54
    L49:
        r105 = null;
        goto L50
    L45:
        r103 = null;
        goto L46
    L41:
        r117 = r313;
        goto L42
    L37:
        r116 = r312;
        goto L39
    L33:
        r115 = r311;
        goto L35
    L29:
        r114 = r310;
        goto L31
    L25:
        r113 = r216;
        goto L27
    L21:
        r112 = r215;
        goto L23
    L17:
        r111 = r214;
        goto L19
    L13:
        r110 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
