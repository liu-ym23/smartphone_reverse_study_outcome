package eh8;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, InterfaceC5779a> f472670a = null;

    /* JADX INFO: renamed from: eh8.a$a, reason: collision with other inner class name */
    public interface InterfaceC5779a {
        void onResult(boolean r100);
    }

    static {
        f472670a = new ConcurrentHashMap();
    }

    public static void b(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        FLogger.f375446a.i("CodeRenderLynxManager", "[unregisterCallback] containerId=".concat(r100));
        f472670a.remove(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void a(String r100, InterfaceC5779a r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        FLogger.f375446a.w("CodeRenderLynxManager", "[registerCallback] skip empty containerId");
        return;
    L10:
        FLogger.f375446a.i("CodeRenderLynxManager", "[registerCallback] containerId=".concat(r100));
        f472670a.put(r100, r101);
        return;
    L5:
        r102 = false;
        goto L7
    }
}
