package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* JADX INFO: loaded from: classes23.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    public PushMsgReceiver() {
    }

    private static void a(Context r100, Intent r101) {
        if (r101.hasExtra("selfshow_info") == true) goto L5;
        return;
    L5:
        if (i.a(r100) == true) goto L9;
        HMSLog.i("PushMsgReceiver", r100.getPackageName() + " disable display notification.");
        if (r101.hasExtra("selfshow_event_id") == true) goto L9;
        return;
    L9:
        t.a(r100, r101);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L25;
        if (r100 == null) goto L26;
        HMSLog.i("PushMsgReceiver", "push receive broadcast message, Intent:" + r101.getAction() + " pkgName:" + r100.getPackageName());
        r101.getStringExtra("TestIntent");     // Catch: Exception -> L20
        String r102 = r101.getAction();
        if (ResourceLoaderUtil.getmContext() != null) goto L11;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L11:
        if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(r102) == false) goto L13;
    L18:
        a(r100, r101);
        return;
    L13:
        if ("com.huawei.intent.action.PUSH".equals(r102) == true) goto L15;
    L17:
        HMSLog.i("PushMsgReceiver", "message can't be recognised.");
        return;
    L15:
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 10) goto L17;
    L20:
        HMSLog.e("PushMsgReceiver", "intent has some error");
        return;
    L26:
        return;
    }
}
