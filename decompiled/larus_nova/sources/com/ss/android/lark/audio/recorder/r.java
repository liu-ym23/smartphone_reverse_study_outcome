package com.ss.android.lark.audio.recorder;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class r extends AudioManager.AudioRecordingCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f409152a;

    public r(p r100) {
        this.f409152a = r100;
    }

    @Override // android.media.AudioManager.AudioRecordingCallback
    public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> r110) {
        AudioRecord r100 = this.f409152a.f409137c;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getAudioSessionId());
    L6:
        if (r110 == null) goto L63;
        p r102 = this.f409152a;
        Iterator<T> r111 = r110.iterator();
    L9:
        if (r111.hasNext() == false) goto L71;
        AudioRecordingConfiguration r103 = (AudioRecordingConfiguration) r111.next();
        int r104 = r103.getClientAudioSessionId();
        boolean r105 = true;
        if (r101 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        AudioDeviceInfo r107 = r103.getAudioDevice();
        if (r107 == null) goto L36;
        r102.getClass();
        StringBuilder r108 = new StringBuilder();
        int r109 = r107.getType();
        if (r109 != 3) goto L22;
        String r112 = "wired_headset";
    L35:
        r108.append(r112);
        r108.append(": ");
        r108.append(r107.getProductName());
        String r113 = r108.toString();
    L37:
        StringBuilder r114 = new StringBuilder("[onRecordingConfigChanged]audioSource:");
        r114.append(r103.getAudioSource());
        r114.append(" clientAudioSessionId:");
        r114.append(r103.getClientAudioSessionId());
        r114.append(" activeAudioDevice:");
        AudioDeviceInfo r115 = r103.getAudioDevice();
        if (r115 == null) goto L40;
        CharSequence r116 = r115.getProductName();
    L41:
        r114.append(r116);
        r114.append(" recordingDevice:");
        r114.append(r113);
        r114.append(" sampleRates:");
        AudioDeviceInfo r117 = r103.getAudioDevice();
        if (r117 == null) goto L44;
        int[] r118 = r117.getSampleRates();
    L45:
        r114.append(r118);
        r114.append("  isClientSilenced:");
        r114.append(r103.isClientSilenced());
        Log.i("RecordTask", r114.toString());
        if (r106 == false) goto L59;
        if (r113 != null) goto L49;
    L52:
        if (r105 == true) goto L59;
        if (Intrinsics.areEqual(r113, r102.f409145k) == true) goto L59;
        r102.f409145k = r113;
        k r119 = r102.f409142h;
        if (r119 == null) goto L59;
        r119.g(r113);
        goto L59
    L49:
        if (r113.length() == 0) goto L52;
        r105 = false;
    L59:
        if (r103.isClientSilenced() == false) goto L9;
        k r120 = r102.f409142h;
        if (r120 == null) goto L9;
        r120.j();
        goto L9
    L44:
        r118 = null;
        goto L45
    L40:
        r116 = null;
        goto L41
    L22:
        if (r109 != 7) goto L24;
        r112 = "bluetooth_sco";
        goto L35
    L24:
        if (r109 != 11) goto L26;
        r112 = "usb_device";
        goto L35
    L26:
        if (r109 != 15) goto L28;
        r112 = "builtin_mic";
        goto L35
    L28:
        if (r109 == 22) goto L30;
        r112 = "unknown_" + r109;
        goto L35
    L30:
        r112 = "usb_headset";
        goto L35
    L36:
        r113 = null;
        goto L37
    L14:
        if (r104 != r101.intValue()) goto L16;
        r106 = true;
        goto L17
    L71:
        return;
    L63:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
