package vwb;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CookieManager f557453a;

    /* JADX INFO: renamed from: vwb.a$a, reason: collision with other inner class name */
    public static final class C8047a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f557454a = null;

        static {
            f557454a = new a();
        }
    }

    public a() {
        this.f557453a = CookieManager.getInstance();     // Catch: Exception -> L8
        int r100 = g.f437223a;     // Catch: Exception -> L8
        if (g.a.a("openplatform.enable.cookie.syncmanager") == false) goto L6;
        j.e("LarkCookieManager", "enableCookieSyncManager is true");     // Catch: Exception -> L8
        CookieSyncManager.getInstance();     // Catch: Exception -> L8
    L6:
        j.e("LarkCookieManager", "init LarkCookieManager");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        j.c("LarkCookieManager", "init LarkCookieManager error", e);
    }
}
