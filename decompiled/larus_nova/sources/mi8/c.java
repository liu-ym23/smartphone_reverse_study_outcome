package mi8;

import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514110a = 0;

    static {
    }

    public static IMoaGrantingAppletService a() {
        return (IMoaGrantingAppletService) ServiceManager.get().getService(IMoaGrantingAppletService.class);
    }
}
