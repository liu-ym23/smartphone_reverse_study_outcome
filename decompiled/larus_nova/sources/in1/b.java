package in1;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.ht0;
import com.bytedance.android.livesdkapi.depend.model.LiveStartRoomOptConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveStartRoomOptConfig f490573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f490574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f490575c;

    static {
        f490573a = ht0.f120403a.getValue();
        f490574b = -1;
        f490575c = -1;
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        g.i("LiveStartRoomOpt", r100);
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (v.a() == true) goto L5;
        return;
    L5:
        a(r100 + ' ' + ((System.currentTimeMillis() - f490574b) - f490575c) + " ms");
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (v.a() == true) goto L6;
        return;
    L6:
        if (f490574b > 0) goto L8;
        return;
    L8:
        a(r100 + ' ' + (System.currentTimeMillis() - f490574b) + " ms");
    }
}
