package sr8;

import com.larus.bmhome.share.api.IConversationSharePanelService;
import com.larus.platform.service.n0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ga9.e;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f543233a = 0;

    static {
    }

    public static boolean a() {
        if (n0.f365775a.b() == true) goto L5;
        return false;
    L5:
        int r100 = wa9.a.f558904a;
        a r101 = new a(0);
        AtomicReference<ga9.a.C5998a> r102 = ga9.a.f480591a;
        e.f480599a.getClass();
        if (((a) e.a(ga9.a.c("share", e.c(r101)), a.class, r101)).a() == 1) goto L8;
        return false;
    L8:
        IConversationSharePanelService r103 = (IConversationSharePanelService) ServiceManager.get().getService(IConversationSharePanelService.class);
        if (r103 != null) goto L11;
        return false;
    L11:
        if (r103.isAvailable() != true) goto L15;
        return true;
    L15:
        return false;
    }
}
