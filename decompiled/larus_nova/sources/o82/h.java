package o82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vr1.j;

/* JADX INFO: loaded from: classes9.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("LiveInteractive", r100);
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("LiveInteractive", r100);
    }

    @JvmStatic
    public static final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "toastMessage");
        if (v.a() == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r102 = nq1.d.f520092a;
        if (nq1.d.f520110s.getValue().booleanValue() == false) goto L11;
        j r103 = r.i();
        if (r103 == null) goto L12;
        r103.n(r101);
        return;
    L12:
        return;
    L11:
        return;
    }
}
