package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f434788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f434789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f434790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f434791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AudioManager f434792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f434793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MmAudioRouteDetector$registerVolumeReceiver$1 f434794g;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        AudioManager r100 = this.f434792e;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L32;
        AudioDeviceInfo[] r101 = r100.getDevices(2);
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L42;
        AudioDeviceInfo r104 = r101[r103];
        Intrinsics.checkNotNull(r104);
        int r105 = r104.getType();
        if (r105 != 3) goto L12;
    L27:
        boolean r106 = true;
    L28:
        if (r106 == true) goto L37;
        r103 = r103 + 1;
    L37:
        return true;
    L12:
        if (r105 == 4) goto L27;
        if (r105 == 7) goto L27;
        if (r105 == 8) goto L27;
        if (r105 == 11) goto L27;
        if (r105 == 22) goto L27;
        if (Build.VERSION.SDK_INT >= 31) goto L24;
    L26:
        r106 = false;
        goto L28
    L24:
        if (r104.getType() != 26) goto L26;
    L42:
        return false;
    L32:
        if (r100.isWiredHeadsetOn() == true) goto L37;
        if (r100.isBluetoothScoOn() == true) goto L37;
        if (r100.isBluetoothA2dpOn() == true) goto L37;
        return false;
    }

    public q(Context r100, Handler r101, Function0<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callbackHandler");
        Intrinsics.checkNotNullParameter(r102, "onRouteChanged");
        Intrinsics.checkNotNullParameter(r103, "onVolumeChanged");
        this.f434788a = r101;
        this.f434789b = r102;
        this.f434790c = r103;
        Context r104 = r100.getApplicationContext();
        this.f434791d = r104;
        Object r105 = r104.getSystemService("audio");
        if ((r105 instanceof AudioManager) == false) goto L5;
        AudioManager r106 = (AudioManager) r105;
    L6:
        this.f434792e = r106;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
