package wf0;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkcast.i;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.live.datacontext.m;
import kotlin.Pair;
import kotlin.math.MathKt;
import rj0.k;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    public static final class a implements IMiddlewareOpenPlatformAnchorService.a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: wf0.b$b, reason: collision with other inner class name */
    public static final class C8104b implements IMiddlewareOpenPlatformAnchorService.a {
        public C8104b() {
        }
    }

    public static final class c implements IMiddlewareOpenPlatformAnchorService.a {
        public c() {
        }
    }

    public static final Integer b() {
        IMiddlewareBroadcastService r100 = (IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getCastingType());
    }

    public static final t.b c() {
        k.f537953m2.getClass();
        k r100 = k.a.a();
        if (r100 == null) goto L7;
        t r101 = r100.Hk();
        if (r101 == null) goto L7;
        t.b r102 = r101.f59039d;
    L8:
        if (r102 != null) goto L14;
        k r103 = k.a.a();
        if (r103 == null) goto L14;
        t r104 = r103.Hk();
        if (r104 == null) goto L14;
        r104.f59039d = new t.b();
    L14:
        k r105 = k.a.a();
        if (r105 == null) goto L20;
        t r106 = r105.Hk();
        if (r106 != null) goto L19;
        return null;
    L19:
        return r106.f59039d;
    L20:
        return null;
    L7:
        r102 = null;
        goto L8
    }

    public static final boolean f() {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isLinkCasting() != true) goto L7;
        return true;
    }

    public static final void a() {
        m<Boolean> r100 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getValue().booleanValue() != true) goto L12;
        m<Boolean> r101 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r101 == null) goto L9;
        r101.setValue(Boolean.FALSE);
    L9:
        IMiddlewareBroadcastService.b.b((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class));
        int r102 = i.f74332a;
        i.a.c(LinkScreenCastType.CAST_TYPE_MINI_APP, false, "force_stop_cast", true);
        return;
    }

    public static final boolean e() {
        Integer r100 = je0.d.h();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 7) goto L8;
        return true;
    }

    public static final void h() {
        if (f() == false) goto L14;
        Integer r100 = b();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.intValue() != 2) goto L15;
        m<Boolean> r101 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r101 == null) goto L12;
        r101.setValue(Boolean.TRUE);
    L12:
        ((IMiddlewareOpenPlatformAnchorService) jc1.k.n(IMiddlewareOpenPlatformAnchorService.class)).pauseLinkCastWhenSceneSwitched(0, new C8104b());
        return;
    L15:
        return;
    }

    public static final void g(int r100) {
        m<Boolean> r101 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r101 == null) goto L21;
        boolean r102 = true;
        if (r101.getValue().booleanValue() != true) goto L22;
        m<Boolean> r103 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r103 == null) goto L10;
        r103.setValue(Boolean.FALSE);
    L10:
        if (r100 != 12) goto L12;
    L18:
        if (r102 == false) goto L23;
        ((IMiddlewareOpenPlatformAnchorService) jc1.k.n(IMiddlewareOpenPlatformAnchorService.class)).resumeLinkCastWhenSceneSwitched(new a());
        return;
    L23:
        return;
    L12:
        if (r100 == 16) goto L18;
        if (r100 == 0) goto L18;
        if (r100 == 8) goto L18;
        r102 = false;
        goto L18
    L22:
        return;
    }

    public static final void i(int r100) {
        if (f() == false) goto L14;
        Integer r101 = b();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.intValue() != 2) goto L15;
        m<Boolean> r102 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r102 == null) goto L12;
        r102.setValue(Boolean.TRUE);
    L12:
        ((IMiddlewareOpenPlatformAnchorService) jc1.k.n(IMiddlewareOpenPlatformAnchorService.class)).pauseLinkCastWhenSceneSwitched(r100, new c());
        return;
    L15:
        return;
    }

    public static final void d(int r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        if (f() == false) goto L16;
        Integer r102 = b();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.intValue() != 2) goto L17;
        if (r100 <= 0) goto L18;
        t.b r103 = j(r100, 2);
        k.f537953m2.getClass();
        k r104 = k.a.a();
        if (r104 == null) goto L19;
        r104.kh(r103);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static final t.b j(int r100, int r101) {
        if (r101 != 1) goto L6;
        r100 = 6;
    L9:
        Pair r102 = new Pair(Double.valueOf(0.7638888888888888d), Double.valueOf(1.0d - ((((double) ((r100 - 1) + 1)) * 0.1171875d) + 0.0875d)));
        Double r103 = (Double) r102.getFirst();
        Double r104 = (Double) r102.getSecond();
        t.b r105 = c();
        if (r105 == null) goto L12;
        r105.f59040a = MathKt.roundToInt(((double) s1.y()) * 0.20833333333333334d);
        r105.f59041b = MathKt.roundToInt(((double) s1.w()) * 0.1171875d);
        r105.f59042c = MathKt.roundToInt(r103.doubleValue() * ((double) s1.y()));
        r105.f59043d = MathKt.roundToInt(r104.doubleValue() * ((double) s1.w()));
        return r105;
    L12:
        return null;
    L6:
        if (r101 != 2) goto L8;
        if (r100 != 1) goto L9;
    L8:
        r100 = 2;
        goto L9
    }
}
