package f81;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(com.bytedance.android.live.room.api.base.alog.a r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Throwable r101 = r100.f98900b;
        if (r101 == null) goto L5;
        ALogger.e("RotateALog", r100.f98899a, r101);
        return;
    L5:
        ALogger.i("RotateALog", r100.f98899a);
        Unit r102 = Unit.INSTANCE;
    }
}
