package y62;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import r52.l1;
import r52.m1;
import r52.n1;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f566322a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f566323b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f566324c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f566325d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f566326e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f566327f = 0;

    static {
        f566322a = m1.f536219a.getValue().booleanValue();
        f566323b = l1.f536213a.getValue().booleanValue();
        v r100 = n1.f536225a.getValue();
        f566324c = r100;
        f566325d = r100.d();
        f566326e = s1.G(s1.y());
        f566327f = r100.a();
    }

    public static boolean a(IRoom r100, boolean r101) {
        if (r100 == null) goto L23;
        IRoomAuthStatus r102 = r100.getRoomAuthStatus();
        if (r102 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.service.model.c r103 = (com.bytedance.android.livesdk.interactivity.service.model.c) r102.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r103 == null) goto L9;
        long r104 = r103.getMyLiveEntrance();
    L11:
        if (r104 != 1) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        return false;
    L19:
        if (f566322a == false) goto L26;
        if (r101 == false) goto L27;
        return true;
    L27:
        return false;
    L26:
        return false;
    L13:
        if (r104 == 0) goto L16;
        r105 = false;
        goto L17
    L9:
        r104 = 0;
        goto L11
    L24:
        return false;
    L23:
        return false;
    }
}
