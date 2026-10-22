package f91;

import com.bytedance.android.live.room.navi.userinfo_p.presenter.h;
import e91.d;
import e91.f;
import e91.i;
import kotlin.jvm.internal.Intrinsics;
import m91.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: f91.a$a, reason: collision with other inner class name */
    public static final class C5870a {
    }

    static {
    }

    public a() {
    }

    public final e91.a a(c r100, Object r101, h r102) {
        int r103 = ((Number) r101).intValue();
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L19;
        if (r103 == 3) goto L18;
        if (r103 == 4) goto L17;
        return null;
    L17:
        return new d(r100, r102);
    L18:
        return new f(r102);
    L19:
        return new i(r102);
    L15:
        return new e91.h(r102);
    }
}
