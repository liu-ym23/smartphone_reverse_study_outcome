package xs5;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CookieManager f565003a;

    /* JADX INFO: renamed from: xs5.a$a, reason: collision with other inner class name */
    public static final class C8269a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f565004a = null;

        static {
            f565004a = new a();
        }
    }

    public a() {
        this.f565003a = CookieManager.getInstance();     // Catch: Exception -> L8
        if (FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.enable.cookie.syncmanager") == false) goto L6;
        Log.i("LarkCookieManager", "enableCookieSyncManager is true");     // Catch: Exception -> L8
        CookieSyncManager.getInstance();     // Catch: Exception -> L8
    L6:
        Log.i("LarkCookieManager", "init LarkCookieManager");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.i("LarkCookieManager", "init LarkCookieManager error", e);
    }
}
