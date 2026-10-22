package s80;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f540946a = null;

    static {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L35;
        Class<?> r102 = Class.forName("com.bytedance.android.livesdkapi.depend.model.live.Room");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdkapi.depend.model.live.Room");     // Catch: Throwable -> L8
    L30:
        f540946a = r102;
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdkapi.depend.model.live.Room");
    L12:
        throw th;
    L35:
        r102 = Class.forName("com.bytedance.android.livesdkapi.depend.model.live.Room");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdkapi.depend.model.live.Room");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdkapi.depend.model.live.Room");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r102 = MiraPluginFix.forName("com.bytedance.android.livesdkapi.depend.model.live.Room");
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
