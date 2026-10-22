package qz8;

import androidx.appcompat.app.AppCompatDelegate;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes26.dex */
public final class h {
    public static final String a(String r100, String r101) {
        int r102 = AppCompatDelegate.getDefaultNightMode();
        if (r102 == 2) goto L9;
        boolean r103 = v19.h.f552477a;
        if (v19.h.b(AppHost.f326268a.getApplication().getApplicationContext()) == true) goto L7;
        return r100;
    L7:
        if (r102 == (-1)) goto L9;
        return r100;
    L9:
        return r101;
    }
}
