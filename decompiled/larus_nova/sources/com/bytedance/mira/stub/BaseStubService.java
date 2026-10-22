package com.bytedance.mira.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes21.dex */
public class BaseStubService extends Service {

    public static final class CodeConst {
        public static final String EXTRA_CONNECTION_ID = "connection_id";
        public static final String EXTRA_REAL_PACKAGE_NAME = "real_package_name";
        public static final String EXTRA_START_SERVICE = "start_service";
        public static final String EXTRA_STOP_SERVICE = "stop_service";
        public static final String EXTRA_STUB_SERVICEINFO = "stub_serviceinfo";
        public static final String EXTRA_TARGET_INTENT = "target_intent";
        public static final String EXTRA_TARGET_SERVICEINFO = "target_serviceinfo";

        public CodeConst() {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        stopSelf();
    }

    public BaseStubService() {
    }
}
