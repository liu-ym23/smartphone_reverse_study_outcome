package com.bytedance.push.sys.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import v67.v;

/* JADX INFO: loaded from: classes21.dex */
public class SystemBroadcastServiceImpl extends BroadcastReceiver implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Set<v.a>> f267027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267028b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f267029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SystemBroadcastServiceImpl f267030b;

        @Override // java.lang.Runnable
        public final void run() {
            Set r100 = (Set) ((ConcurrentHashMap) this.f267030b.f267027a).get("com.android.systemui.fsgesture");     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            Object[] r101 = r100.toArray();     // Catch: Throwable -> L8
            int r102 = r101.length;     // Catch: Throwable -> L8
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L17;
            ((v.a) r101[r103]).onReceiveFromPushSystemBroadcastService(this.f267029a);     // Catch: Throwable -> L8
            r103 = r103 + 1;
            goto L5
        L17:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(SystemBroadcastServiceImpl r100, Intent r101) {
            this.f267030b = r100;
            this.f267029a = r101;
        }
    }

    public SystemBroadcastServiceImpl() {
        this.f267027a = new ConcurrentHashMap();
    }

    public final synchronized void a(v.a r100) {
        monitor-enter(this);
        Set r101 = (Set) ((ConcurrentHashMap) this.f267027a).get(r100);     // Catch: Throwable -> L19
        if (r101 != null) goto L7;
        r101 = new HashSet();     // Catch: Throwable -> L19
    L7:
        r101.add(r100);     // Catch: Throwable -> L19
        ((ConcurrentHashMap) this.f267027a).put("com.android.systemui.fsgesture", r101);     // Catch: Throwable -> L19
        if (this.f267028b == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f267028b = true;     // Catch: Throwable -> L19
        IntentFilter r102 = new IntentFilter("com.android.systemui.fsgesture");     // Catch: Throwable -> L19
        f.b("SystemBroadcastServiceImpl", "register as : com.android.systemui.fsgesture");     // Catch: Throwable -> L19
        PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(AppProvider.getApp(), this, r102);     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        f.e("SystemBroadcastServiceImpl", "addNotificationBarPullDownListener failed because exception:" + th.getLocalizedMessage());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        f.b("SystemBroadcastServiceImpl", "onReceive:" + r101.getAction());
        if (TextUtils.equals(r101.getAction(), "com.android.systemui.fsgesture") == false) goto L12;
        Bundle r102 = r101.getExtras();
        if (r102 != null) goto L7;
        return;
    L7:
        if (TextUtils.equals(r102.getString("typeFrom"), "typefrom_status_bar_expansion") == false) goto L14;
        boolean r103 = r102.getBoolean("isEnter");
        f.b("SystemBroadcastServiceImpl", "notification bar status changed,isEnter:" + r103);
        if (r103 == false) goto L15;
        PushThreadHandlerManager.inst().postRunnable(new a(this, r101));
        return;
    L15:
        return;
    L14:
        return;
    }
}
