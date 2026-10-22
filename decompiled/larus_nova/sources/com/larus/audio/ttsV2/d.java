package com.larus.audio.ttsV2;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f289913a;

    public /* synthetic */ d(boolean r100) {
        this.f289913a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = this.f289913a;
        e r101 = e.f289914a;
        AudioDeviceInfo[] r102 = ((AudioManager) e.f289917d.getValue()).getDevices(2);
        int r103 = r102.length;
        boolean r104 = false;
        int r105 = 0;
    L3:
        boolean r106 = true;
        if (r105 >= r103) goto L16;
        int r107 = r102[r105].getType();
        if (r107 != 3) goto L8;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == true) goto L14;
        r105 = r105 + 1;
        goto L3
    L14:
        boolean r109 = true;
    L17:
        StateFlowImpl r110 = e.f289915b;
        a r111 = (a) r110.getValue();
        Intrinsics.checkNotNullParameter(r111, "current");
        if (r100 == false) goto L20;
    L21:
        r104 = true;
    L22:
        if (r104 == false) goto L24;
        FLogger.f375446a.i("HeadsetDetector", "Earphone state changed: " + r109);
    L24:
        if (r109 == true) goto L26;
    L28:
        r106 = r111.f289911b;
    L29:
        r111.getClass();
        r110.setValue(new a(r109, r106));
        return;
    L26:
        if (r111.f289910a == true) goto L28;
    L20:
        if (r111.f289910a == r109) goto L22;
    L8:
        if (r107 == 4) goto L12;
        if (r107 == 8) goto L12;
        r108 = false;
        goto L13
    L16:
        r109 = false;
        goto L17
    }
}
