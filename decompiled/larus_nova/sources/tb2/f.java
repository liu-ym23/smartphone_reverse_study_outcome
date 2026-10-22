package tb2;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.o;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f545245a = 0;

    static {
    }

    public static boolean a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        x r101 = r.f141030b;
        Intrinsics.checkNotNullParameter(vb2.b.class, "clazz");
        o r102 = r.f141034f;
        r102.getClass();
        vb2.a r103 = (vb2.a) ((HashMap) r102.f141029a).get(vb2.b.class);     // Catch: ClassCastException -> L5
    L7:
        vb2.b r104 = (vb2.b) r103;
        if (r104 != null) goto L10;
    L12:
        return false;
    L10:
        if (r100.a().a() == null) goto L12;
        return r104.a(r100.a().a());
    L5:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        r103 = null;
        goto L7
    }
}
