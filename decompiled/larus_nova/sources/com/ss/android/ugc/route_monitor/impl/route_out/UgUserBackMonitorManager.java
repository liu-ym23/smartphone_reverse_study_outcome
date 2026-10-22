package com.ss.android.ugc.route_monitor.impl.route_out;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class UgUserBackMonitorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f454593a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/UgUserBackMonitorManager$UserBackReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
    public static final class UserBackReceiver extends BroadcastReceiver {
        public UserBackReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 == null) goto L4;
            String r102 = r101.getAction();
        L5:
            if (r102 == null) goto L43;
            int r103 = r102.hashCode();
            if (r103 == (-2128145023)) goto L31;
            if (r103 != (-1454123155)) goto L12;
            r102.equals("android.intent.action.SCREEN_ON");
            return;
        L12:
            if (r103 == (-403228793)) goto L15;
            return;
        L15:
            if (r102.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") == false) goto L34;
            String r104 = r101.getStringExtra("reason");
            if (r104 != null) goto L19;
            return;
        L19:
            if ((!Intrinsics.areEqual(r104, "")) == true) goto L21;
            return;
        L21:
            if (Intrinsics.areEqual("homekey", r104) == false) goto L24;
            ScheduledExecutorService r105 = UgUserBackMonitorManager.f454593a;
            return;
        L24:
            if (Intrinsics.areEqual("recentapps", r104) == false) goto L27;
            ScheduledExecutorService r106 = UgUserBackMonitorManager.f454593a;
            return;
        L27:
            if (Intrinsics.areEqual("fs_gesture", r104) == false) goto L39;
            ScheduledExecutorService r107 = UgUserBackMonitorManager.f454593a;
            return;
        L39:
            return;
        L34:
            return;
        L31:
            if (r102.equals("android.intent.action.SCREEN_OFF") == false) goto L42;
            ScheduledExecutorService r108 = UgUserBackMonitorManager.f454593a;
            return;
        L42:
            return;
        L43:
            return;
        L4:
            r102 = null;
            goto L5
        }
    }

    static {
        new UserBackReceiver();
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        r100.addAction("android.intent.action.SCREEN_OFF");
        r100.addAction("android.intent.action.SCREEN_ON");
        f454593a = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("UgUserBackMonitorManager"));
    }
}
