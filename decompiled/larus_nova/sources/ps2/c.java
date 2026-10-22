package ps2;

import android.util.Log;
import com.bytedance.android.livesdk.room.LiveScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530435a = 0;

    static {
    }

    public static void b(Throwable r100) {
        pm0.b r101 = om0.c.f();
        if (r101 == null) goto L6;
        r101.i("liveLifecycle_core_", Log.getStackTraceString(r100));
        return;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        pm0.b r102 = om0.c.f();
        if (r102 == null) goto L6;
        r102.i("liveLifecyclePef_" + r100, r101);
        return;
    }

    public static void a(LiveScope r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r102, "msg");
        int r103 = b.f530434a[r100.ordinal()];
        if (r103 == 1) goto L16;
        if (r103 != 2) goto L7;
        pm0.b r104 = om0.c.f();
        if (r104 == null) goto L19;
        r104.i("liveLifecycle_core_session_" + r101, r102);
        return;
    L19:
        return;
    L7:
        if (r103 != 3) goto L21;
        pm0.b r105 = om0.c.f();
        if (r105 == null) goto L17;
        r105.i("liveLifecycle_core_live_" + r101, r102);
        return;
    L17:
        return;
    L21:
        return;
    }
}
