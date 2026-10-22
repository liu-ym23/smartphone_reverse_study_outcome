package xc0;

import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.o;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f563197b = null;

    public static final class a {
    }

    public c() {
    }

    static {
        f563197b = new c();
    }

    @Override // xc0.b
    public final o a(com.bytedance.android.live.liveinteract.animation.e r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r101, o r102, ArrayList<String> r103) {
        Intrinsics.checkNotNullParameter(r101, "giftInfo");
        Intrinsics.checkNotNullParameter(r102, "positionInfo");
        Intrinsics.checkNotNullParameter(r103, "onlineList");
        String r104 = r101.f79374b;
        if (r104 != null) goto L5;
        return r102;
    L5:
        o r105 = new o(r102.f79396a, r102.f79397b, r102.f79398c);
        if (r103.contains(r104) == false) goto L11;
        if (r100 == null) goto L9;
        EPointF r106 = r100.Mj(r104);
    L10:
        r105.f79396a = r106;
        r105.f79399d = true;
        goto L11
    L9:
        r106 = null;
    L11:
        return r105;
    }
}
