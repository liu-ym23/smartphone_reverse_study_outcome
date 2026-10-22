package ps;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import yr.c;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530408a = 0;

    public static String b() {
        Thread r100 = ThreadMethodProxy.currentThread();
        return "【isMainThread=" + Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) + "-threadName=" + r100.getName() + "-threadId=" + r100.getId() + 12305;
    }

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        c.a("DownloadComponent", r100 + "---" + b());
    }
}
