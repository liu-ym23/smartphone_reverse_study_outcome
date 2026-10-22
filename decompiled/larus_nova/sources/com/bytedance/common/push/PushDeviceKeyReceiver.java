package com.bytedance.common.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.common.push.interfaze.IDeviceKeyListener;
import com.bytedance.push.utils.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes15.dex */
public class PushDeviceKeyReceiver extends BroadcastReceiver {
    private final String ACTION_MULTI_TASK;
    private final String REASON_MULTI_TASK;
    private final String REASON_MULTI_TASK_MI;
    private final String TAG;
    private boolean hasRegisterReceiver;
    private Set<IDeviceKeyListener> mIDeviceKeyListeners;

    public PushDeviceKeyReceiver() {
        this.TAG = "DeviceKeyReceiver";
        this.REASON_MULTI_TASK = "recentapps";
        this.REASON_MULTI_TASK_MI = "fs_gesture";
        this.ACTION_MULTI_TASK = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
        this.hasRegisterReceiver = false;
        this.mIDeviceKeyListeners = new HashSet();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L13;
        String r102 = r101.getAction();
        String r103 = r101.getStringExtra("reason");
        f.b("DeviceKeyReceiver", "onReceive:" + r102 + " reason:" + r103);
        if (TextUtils.equals(r102, "android.intent.action.CLOSE_SYSTEM_DIALOGS") == true) goto L6;
        return;
    L6:
        if (TextUtils.equals(r103, "recentapps") == false) goto L8;
    L9:
        f.b("DeviceKeyReceiver", "update app status for multi task action");
        Iterator<IDeviceKeyListener> r104 = this.mIDeviceKeyListeners.iterator();
    L11:
        if (r104.hasNext() == false) goto L17;
        r104.next().onMultiTask();
        goto L11
    L17:
        return;
    L8:
        if (TextUtils.equals(r103, "fs_gesture") == true) goto L9;
        return;
    }
}
