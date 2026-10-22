package com.larus.audio.ttsV2;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f289914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f289915b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StateFlowImpl f289916c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f289917d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f289918e = null;

    public static final class a extends AudioDeviceCallback {
        public a() {
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] r100) {
            Intrinsics.checkNotNullParameter(r100, "addedDevices");
            e r101 = e.f289914a;
            t0.b(new d(false), 0);
            e.a(r100, "Connected");
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] r100) {
            Intrinsics.checkNotNullParameter(r100, "removedDevices");
            e r101 = e.f289914a;
            t0.b(new d(false), 0);
            e.a(r100, "Disconnected");
        }
    }

    public e() {
    }

    static {
        f289914a = new e();
        StateFlowImpl r100 = j1.a(new com.larus.audio.ttsV2.a(false, true));
        f289915b = r100;
        f289916c = r100;
        f289917d = LazyKt.lazy(new b());
        f289918e = new a();
        t0.b(new c(), 5000);
    }

    public static final void a(AudioDeviceInfo[] r100, String r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        int r104 = r100[r103].getType();
        if (r104 != 3) goto L7;
        FLogger.f375446a.i("HeadsetDetector", "Wired headset ".concat(r101));
    L14:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 != 4) goto L9;
        FLogger.f375446a.i("HeadsetDetector", "Wired headphones ".concat(r101));
        goto L14
    L9:
        if (r104 != 8) goto L14;
        FLogger.f375446a.i("HeadsetDetector", "Bluetooth headset ".concat(r101));
        goto L14
    }
}
