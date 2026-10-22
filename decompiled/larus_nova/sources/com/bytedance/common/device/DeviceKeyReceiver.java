package com.bytedance.common.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes15.dex */
public class DeviceKeyReceiver extends BroadcastReceiver {
    private static DeviceKeyReceiver deviceKeyReceiver;
    private static final AtomicBoolean mHasRegister = null;
    private static Set<IMultiTaskListener> multiTaskListenerSet;
    private final String ACTION_MULTI_TASK;
    private final String REASON_HOMEKEY;
    private final String REASON_MULTI_TASK;
    private final String REASON_MULTI_TASK_MI;
    private final String TAG;

    public interface IMultiTaskListener {
        void enterMultiTask();

        void onPressHomeKey();
    }

    static {
        multiTaskListenerSet = new HashSet();
        deviceKeyReceiver = new DeviceKeyReceiver();
        mHasRegister = new AtomicBoolean(false);
    }

    public DeviceKeyReceiver() {
        this.TAG = "DeviceKeyReceiver";
        this.REASON_MULTI_TASK_MI = "fs_gesture";
        this.REASON_MULTI_TASK = "recentapps";
        this.REASON_HOMEKEY = "homekey";
        this.ACTION_MULTI_TASK = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    }

    public static void registerMultiTaskListener(IMultiTaskListener r100) {
        if (mHasRegister.compareAndSet(false, true) == false) goto L5;
        PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(AppProvider.getApp(), deviceKeyReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    L5:
        multiTaskListenerSet.add(r100);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L18;
        String r102 = r101.getAction();
        String r103 = r101.getStringExtra("reason");
        f.b("DeviceKeyReceiver", "onReceive:" + r102 + " reason:" + r103);
        if (TextUtils.equals(r102, "android.intent.action.CLOSE_SYSTEM_DIALOGS") == false) goto L21;
        int r104 = 0;
        if (TextUtils.equals(r103, "fs_gesture") == false) goto L8;
    L15:
        Object[] r105 = multiTaskListenerSet.toArray();
        int r106 = r105.length;
    L16:
        if (r104 >= r106) goto L24;
        ((IMultiTaskListener) r105[r104]).enterMultiTask();
        r104 = r104 + 1;
        goto L16
    L24:
        return;
    L8:
        if (TextUtils.equals(r103, "recentapps") == true) goto L15;
        if (TextUtils.equals(r103, "homekey") == false) goto L22;
        Object[] r107 = multiTaskListenerSet.toArray();
        int r108 = r107.length;
    L13:
        if (r104 >= r108) goto L23;
        ((IMultiTaskListener) r107[r104]).onPressHomeKey();
        r104 = r104 + 1;
        goto L13
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }
}
