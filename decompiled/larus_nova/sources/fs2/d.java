package fs2;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f478652a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Handler f478653a = null;

        static {
            f478653a = new Handler(Looper.getMainLooper());
        }
    }

    static {
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        a.f478653a.post(r100);
    }
}
