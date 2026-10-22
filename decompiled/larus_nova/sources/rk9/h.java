package rk9;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h extends AudioDeviceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3<String, String, String, Unit> f538417a;

    public h(com.larus.media.l r100) {
        this.f538417a = r100;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] r100) {
        Intrinsics.checkNotNullParameter(r100, "addedDevices");
        this.f538417a.invoke("onAudioDevicesAdded", d.b(ArraysKt.toList(r100)), "[]");
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] r100) {
        Intrinsics.checkNotNullParameter(r100, "removedDevices");
        this.f538417a.invoke("onAudioDevicesRemoved", "[]", d.b(ArraysKt.toList(r100)));
    }
}
