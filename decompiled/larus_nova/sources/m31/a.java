package m31;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.multianchor.player.utils.LiveType;
import kotlin.jvm.internal.Intrinsics;
import rc0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511706a = 0;

    static {
    }

    public static boolean a(LiveType r100, DeviceType r101) {
        Intrinsics.checkNotNullParameter(r100, "live");
        Intrinsics.checkNotNullParameter(r101, "device");
        if (n.a(r101) == false) goto L8;
        b03.a r102 = b03.a.f16857a;
        if (b03.a.b() == true) goto L8;
        return false;
    L8:
        if (r100 != LiveType.PC_LIVE) goto L11;
        return true;
    L11:
        if (r100 != LiveType.VIDEO) goto L14;
        return true;
    L14:
        if (r100 != LiveType.AUDIO) goto L17;
        return true;
    L17:
        if (r100 != LiveType.SCREEN_RECORD) goto L19;
        return true;
    L19:
        return false;
    }
}
