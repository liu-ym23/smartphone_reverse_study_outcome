package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* JADX INFO: loaded from: classes37.dex */
public final class r extends AudioDeviceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f434795a;

    public r(q r100) {
        this.f434795a = r100;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] r100) {
        lvb.a.e("MmAudioRouteDetector", "[onAudioDevicesAdded]");
        this.f434795a.f434789b.invoke();
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] r100) {
        lvb.a.e("MmAudioRouteDetector", "[onAudioDevicesRemoved]");
        this.f434795a.f434789b.invoke();
    }
}
