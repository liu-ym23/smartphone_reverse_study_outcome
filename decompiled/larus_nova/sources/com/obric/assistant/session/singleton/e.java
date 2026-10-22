package com.obric.assistant.session.singleton;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f391669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f391670b = null;

    public static final class a extends ContentObserver {
        public a(Handler r100) {
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            super.onChange(r100);
            boolean r101 = e.f391669a;
            boolean r102 = false;
            if (Settings.Secure.getInt(AppHost.f326268a.getApplication().getContentResolver(), "lost_mode", 0) != 1) goto L5;
            r102 = true;
        L5:
            e.f391669a = r102;
            FLogger.f375446a.i("LostModeMonitor", "lost mode state changed to " + e.f391669a);
        }
    }

    static {
        f391670b = new a(t0.f375469b);
    }
}
