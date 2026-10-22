package pp9;

import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530228a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r100) != 0) goto L5;
        boolean r101 = true;
    L6:
        FLogger.f375446a.i("AlbumPermissionUtils", "[checkSelfPermission] " + r100 + ':' + r101);
        return r101;
    L5:
        r101 = false;
        goto L6
    }
}
