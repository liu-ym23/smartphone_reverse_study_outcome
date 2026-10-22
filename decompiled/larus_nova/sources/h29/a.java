package h29;

import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.community.impl.applet.music.MusicGenerationAppletApplication;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f483632a = null;

    static {
        f483632a = new AtomicBoolean(false);
    }

    public static void a() {
        if (f483632a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("MusicGenerationAppletRegistry", "register music template applet");
        AppletAppManagerService.INSTANCE.getClass();
        AppletAppManagerService.e(MusicAppletPage.APP_ID, MusicGenerationAppletApplication.class);
    }
}
