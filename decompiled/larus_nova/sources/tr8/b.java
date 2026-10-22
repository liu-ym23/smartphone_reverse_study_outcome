package tr8;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.n0;
import ic8.n;
import wc9.e;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    public static final String a(e r100) {
        if (n0.f365775a.b() == true) goto L5;
    L7:
        int r101 = R.string.app_name_replace;
    L8:
        AppHost.Companion r102 = AppHost.f326268a;
        if (r102.isOversea() == false) goto L11;
        int r103 = R.string.larus_dola_sidebar_back_to_main_chat_global;
    L13:
        return r102.getApplication().getString(r103, new Object[]{n.g(r100, r102.getApplication().getString(r101))});
    L11:
        r103 = R.string.larus_dola_sidebar_back_to_main_chat_cn;
        goto L13
    L5:
        if (AppHost.f326268a.isOversea() == true) goto L7;
        r101 = R.string.larus_mainchat_inpage_chatTitle_doubaoWork;
        goto L8
    }
}
