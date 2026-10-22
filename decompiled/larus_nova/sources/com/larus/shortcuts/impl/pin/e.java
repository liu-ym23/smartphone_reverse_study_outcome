package com.larus.shortcuts.impl.pin;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.text.TextUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f369251a = null;

    static {
        f369251a = LazyKt.lazy(new d());
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 25) goto L19;
        Iterator<T> r101 = ((ShortcutManager) AppHost.f326268a.getApplication().getSystemService(ShortcutManager.class)).getPinnedShortcuts().iterator();
    L9:
        if (r101.hasNext() == false) goto L19;
        if (TextUtils.equals(((ShortcutInfo) r101.next()).getId(), r100) == false) goto L9;
        return true;
    L19:
        String r102 = a.f369249a;     // Catch: Throwable -> L16
        if (a.f(AppHost.f326268a.getApplication(), r100) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        th = move-exception;
        FLogger.f375446a.e("PinShortcutUtil", "error " + th.getMessage());
        goto L18
    }
}
