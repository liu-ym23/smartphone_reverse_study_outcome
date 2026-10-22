package y27;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.navigation.kmp.capability.sensor.overlay.HeadingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f565719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f565720b = null;

    public b() {
    }

    public static void a() {
    }

    public final void update(HeadingSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    static {
        f565719a = new b();
        f565720b = new Handler(Looper.getMainLooper());
        HeadingSource r100 = HeadingSource.IDLE;
    }
}
