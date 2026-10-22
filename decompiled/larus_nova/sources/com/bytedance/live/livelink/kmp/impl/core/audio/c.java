package com.bytedance.live.livelink.kmp.impl.core.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f255363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ei6.a f255364b;

    public static final class a {
    }

    static {
    }

    @Override // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceState");
        super.onServiceStateChanged(r100);
        int r101 = ej6.a.f472874a;
        ej6.a.a("RtcPhoneStateListener", "CustomPhoneStateListener onServiceStateChanged: " + r100);
    }

    public c(ei6.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f255364b = r100;
        this.f255363a = new d(r100, r101);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "incomingNumber");
        int r102 = ej6.a.f472874a;
        ej6.a.b("RtcPhoneStateListener", "CustomPhoneStateListener state: " + r100 + " incomingNumber: " + r101);
        boolean r103 = true;
        Looper r104 = null;
        Object r105 = null;
        boolean r106 = false;
        if (r100 == 0) goto L39;
        if (r100 != 1) goto L6;
        d r107 = this.f255363a;
        r107.getClass();
        ej6.a.a(r107.f255369e, "CustomPhoneStateListener onCallStateChanged RING");
        if (r107.f255366b.compareAndSet(0, 0) == false) goto L77;
        Object r108 = r107.f255365a.getSystemService("audio");
        if ((r108 instanceof AudioManager) == true) goto L21;
        r108 = null;
    L21:
        AudioManager r109 = (AudioManager) r108;
        if (r109 != null) goto L25;
    L31:
        if (r106 == true) goto L78;
        Object r110 = r107.f255365a.getSystemService("audio");
        if ((r110 instanceof AudioManager) == false) goto L36;
        r105 = r110;
    L36:
        AudioManager r111 = (AudioManager) r105;
        if (r111 == null) goto L79;
        r111.isSpeakerphoneOn();
        return;
    L79:
        return;
    L78:
        return;
    L25:
        if (r109.isBluetoothScoOn() == false) goto L27;
    L30:
        r106 = r103;
        goto L31
    L27:
        if (r109.isWiredHeadsetOn() == true) goto L30;
        r103 = false;
        goto L30
    L77:
        return;
    L6:
        if (r100 != 2) goto L83;
        d r112 = this.f255363a;
        if (r112.f255366b.getAndIncrement() != 0) goto L74;
        ej6.a.a(r112.f255369e, "CustomPhoneStateListener onCallStateChanged StartCall");
        ri6.b r113 = r112.f255368d.r();
        if (r113 == null) goto L13;
        r113.s(r112.a(), true);
    L13:
        ri6.b r114 = r112.f255368d.r();
        if (r114 == null) goto L75;
        r114.p(r112.a(), true, "");
        return;
    L75:
        return;
    L74:
        return;
    L83:
        return;
    L39:
        d r115 = this.f255363a;
        if (r115.f255366b.compareAndSet(0, 0) == false) goto L43;
        return;
    L43:
        if (r115.f255366b.decrementAndGet() != 0) goto L81;
        ej6.a.a(r115.f255369e, "CustomPhoneStateListener onCallStateChanged END");
        ri6.b r116 = r115.f255368d.r();
        if (r116 == null) goto L47;
        r116.s(r115.a(), false);
    L47:
        ri6.b r117 = r115.f255368d.r();
        if (r117 == null) goto L50;
        r117.p(r115.a(), false, "");
    L50:
        Object r118 = r115.f255365a.getSystemService("audio");
        if ((r118 instanceof AudioManager) == true) goto L53;
        r118 = null;
    L53:
        AudioManager r119 = (AudioManager) r118;
        if (r119 != null) goto L57;
    L63:
        if (r106 == true) goto L82;
        e r120 = new e(r115);
        if (Looper.myLooper() == null) goto L68;
        r104 = Looper.myLooper();
    L68:
        if (Looper.getMainLooper() == null) goto L70;
        r104 = Looper.getMainLooper();
    L70:
        if (r104 == null) goto L85;
        new d.b(r104).postDelayed(r120, 1500);
        return;
    L85:
        return;
    L82:
        return;
    L57:
        if (r119.isBluetoothScoOn() == false) goto L59;
    L62:
        r106 = r103;
        goto L63
    L59:
        if (r119.isWiredHeadsetOn() == true) goto L62;
        r103 = false;
        goto L62
    }
}
