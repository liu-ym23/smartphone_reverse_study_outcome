package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.c;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes23.dex */
public class HmsMsgService extends Service {

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f277748a;

        public a(Context r100) {
            this.f277748a = r100;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            Bundle r101 = r100.getData();
            if (Objects.equals(this.f277748a.getApplicationContext().getPackageManager().getNameForUid(r100.sendingUid), HMSPackageManager.getInstance(this.f277748a).getHMSPackageName()) == false) goto L19;
            if (r101 == null) goto L19;
            PackageManagerHelper.PackageStates r102 = HMSPackageManager.getInstance(this.f277748a).getHMSPackageStates();
            PackageManagerHelper.PackageStates r103 = PackageManagerHelper.PackageStates.ENABLED;
            if (r102 != r103) goto L19;
            if (HMSPackageManager.getInstance(this.f277748a).getHMSPackageStates() == r103) goto L10;
            HMSLog.i("HmsMsgService", "service not start by hms");
            goto L19
        L10:
            HMSLog.i("HmsMsgService", "chose push type");
            if (Objects.equals(c.b(r101, "push_action"), "com.huawei.push.msg.NOTIFY_MSG") == false) goto L17;
            if (ResourceLoaderUtil.getmContext() != null) goto L15;
            ResourceLoaderUtil.setmContext(this.f277748a.getApplicationContext());
        L15:
            HMSLog.i("HmsMsgService", "invokeSelfShow");
            HmsMsgService.a(this.f277748a, r101);
            goto L19
        L17:
            if (Objects.equals(c.b(r101, "push_action"), "com.huawei.push.msg.PASSBY_MSG") == false) goto L19;
            HMSLog.i("HmsMsgService", "sendBroadcastToHms");
            HmsMsgService.b(this.f277748a, r101);
        L19:
            super.handleMessage(r100);
        }
    }

    public HmsMsgService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        HMSLog.i("HmsMsgService", "onBind");
        return new Messenger(new a(this)).getBinder();
    }

    public static /* synthetic */ void a(Context r100, Bundle r101) {
        c(r100, r101);
    }

    public static /* synthetic */ void b(Context r100, Bundle r101) {
        d(r100, r101);
    }

    private static void c(Context r100, Bundle r101) {
        if (i.a(r100) == true) goto L6;
        HMSLog.i("HmsMsgService", r100.getPackageName() + " disable display notification.");
        return;
    L6:
        Intent r102 = new Intent();
        r102.setAction("com.huawei.push.msg.NOTIFY_MSG");
        r102.putExtra("selfshow_info", c.a(r101, "selfshow_info"));
        r102.putExtra("selfshow_token", c.a(r101, "selfshow_token"));
        r102.setPackage(c.c(r101, "push_package"));
        t.a(r100, r102);
        HMSLog.i("HmsMsgService", "invokeSelfShow done");
    }

    private static void d(Context r100, Bundle r101) {
        Intent r102 = new Intent();     // Catch: Exception -> L5 SecurityException -> L6
        r102.setAction("com.huawei.android.push.intent.RECEIVE");     // Catch: Exception -> L5 SecurityException -> L6
        r102.putExtra("msg_data", c.a(r101, "msg_data"));     // Catch: Exception -> L5 SecurityException -> L6
        r102.putExtra(RemoteMessageConst.DEVICE_TOKEN, c.a(r101, RemoteMessageConst.DEVICE_TOKEN));     // Catch: Exception -> L5 SecurityException -> L6
        r102.putExtra("msgIdStr", c.c(r101, "msgIdStr"));     // Catch: Exception -> L5 SecurityException -> L6
        r102.setFlags(32);     // Catch: Exception -> L5 SecurityException -> L6
        r102.setPackage(c.c(r101, "push_package"));     // Catch: Exception -> L5 SecurityException -> L6
        r100.sendBroadcast(r102, r100.getPackageName() + ".permission.PROCESS_PUSH_MSG");     // Catch: Exception -> L5 SecurityException -> L6
        HMSLog.i("HmsMsgService", "send broadcast passby done");     // Catch: Exception -> L5 SecurityException -> L6
    L11:
        return;
    L6:
        HMSLog.i("HmsMsgService", "send broadcast SecurityException");
        return;
    L5:
        HMSLog.i("HmsMsgService", "send broadcast Exception");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        HMSLog.i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }
}
