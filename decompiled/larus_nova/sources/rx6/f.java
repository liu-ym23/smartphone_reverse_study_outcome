package rx6;

import com.larus.common.apphost.AppHost;
import com.larus.jato.api.IJato;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    public static final void a() {
        IJato r100 = (IJato) ServiceManager.get().getService(IJato.class);
        if (r100 == null) goto L6;
        r100.k(true, AppHost.f326268a.getApplication());
        return;
    }
}
