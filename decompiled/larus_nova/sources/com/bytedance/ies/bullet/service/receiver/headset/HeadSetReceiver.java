package com.bytedance.ies.bullet.service.receiver.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/receiver/headset/HeadSetReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class HeadSetReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f248109b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, r36.a> f248110a;

    public static final class a {
    }

    static {
    }

    public HeadSetReceiver() {
        this.f248110a = new LinkedHashMap();
    }

    public final void a(boolean r100) {
        Map<String, r36.a> r101 = this.f248110a;
        monitor-enter(r101);
        Iterator r102 = ((LinkedHashMap) this.f248110a).entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        r36.a r103 = (r36.a) ((Map.Entry) r102.next()).getValue();     // Catch: Throwable -> L11
        HeadSetType r104 = HeadSetType.BLUETOOTH;     // Catch: Throwable -> L11
        r103.a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        StringBuilder r103 = new StringBuilder("onReceive broadcast receiver, action=");
        if (r101 == null) goto L5;
        String r104 = r101.getAction();
    L6:
        r103.append(r104);
        BulletLogger.d(r103.toString());
        if (r101 != null) goto L9;
        return;
    L9:
        String r105 = r101.getAction();
        if (r105 == null) goto L41;
        int r106 = r105.hashCode();
        if (r106 == (-1676458352)) goto L27;
        if (r106 == 545516589) goto L17;
        return;
    L17:
        if (r105.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L48;
        int r107 = r101.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
        String r108 = r101.getStringExtra("android.bluetooth.device.extra.DEVICE");
        BulletLogger.d("action = ACTION_CONNECTION_STATE_CHANGED, state=" + r107 + ", device=" + r108);
        if (r107 != 0) goto L22;
        BulletLogger.d("BT headset connection state change, device=" + r108 + ", disconnected");
        a(false);
        return;
    L22:
        if (r107 != 2) goto L49;
        BulletLogger.d("BT headset connection state change, device=" + r108 + ", connected");
        a(true);
        return;
    L49:
        return;
    L48:
        return;
    L27:
        if (r105.equals("android.intent.action.HEADSET_PLUG") == false) goto L50;
        BulletLogger.d("action = ACTION_HEADSET_PLUG, state=" + r101.getIntExtra("state", -1) + ", device=" + r101.getStringExtra("name") + ", hasMicrophone=" + r101.getIntExtra("microphone", -1));
        Map<String, r36.a> r109 = this.f248110a;
        monitor-enter(r109);
        Iterator r110 = ((LinkedHashMap) this.f248110a).entrySet().iterator();     // Catch: Throwable -> L38
    L33:
        if (r110.hasNext() == false) goto L35;
        r36.a r111 = (r36.a) ((Map.Entry) r110.next()).getValue();     // Catch: Throwable -> L38
        HeadSetType r112 = HeadSetType.BLUETOOTH;     // Catch: Throwable -> L38
        r111.a();     // Catch: Throwable -> L38
        goto L33
    L35:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r109);
        return;
    L38:
        th = move-exception;
        throw th;
    L50:
        return;
    L41:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
