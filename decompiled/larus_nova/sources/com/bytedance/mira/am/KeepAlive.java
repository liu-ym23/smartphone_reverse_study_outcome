package com.bytedance.mira.am;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.mira.Mira;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.OSUtil;

/* JADX INFO: loaded from: classes21.dex */
public class KeepAlive extends Service {
    private static final int NOTIFICATION_ID = 32;
    private static final String TAG = "KeepAlive";

    public static final class InnerService extends Service {
        private static final String TAG = "InnerService";

        @Override // android.app.Service
        public IBinder onBind(Intent r100) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            MiraLogger.i(MiraLogger.TAG_PAM, "InnerService onCreate, then startForeground, then stopSelf");
            startForeground(32, new Notification());
            stopSelf();
        }

        @Override // android.app.Service
        public void onDestroy() {
            super.onDestroy();
            MiraLogger.i(MiraLogger.TAG_PAM, "InnerService onDestroy");
            stopForeground(true);
        }

        public InnerService() {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    public static void start() {
        MiraLogger.d(MiraLogger.TAG_PAM, "KeepAlive start KeepAlive");
        Intent r100 = new Intent(Mira.getAppContext(), KeepAlive.class);
        Mira.getAppContext().startService(r100);
    }

    public static void stop() {
        MiraLogger.d(MiraLogger.TAG_PAM, "KeepAlive stop KeepAlive");
        Intent r100 = new Intent(Mira.getAppContext(), KeepAlive.class);
        Mira.getAppContext().stopService(r100);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MiraLogger.i(MiraLogger.TAG_PAM, "KeepAlive onCreate");
        if (OSUtil.isAndroidJ_MR2Higher() == false) goto L5;
        MiraLogger.d(MiraLogger.TAG_PAM, "KeepAlive start InnerService with startForeground");
        startService(new Intent(this, InnerService.class));
    L5:
        startForeground(32, new Notification());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MiraLogger.i(MiraLogger.TAG_PAM, "KeepAlive onDestroy");
        stopForeground(true);
    }

    public KeepAlive() {
    }
}
