package dc6;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final long a(long r100) {
        Intrinsics.checkNotNullParameter(i97.a.f488802a, "$this$elapsedRealtime");
        return SystemClock.elapsedRealtime() - r100;
    }
}
