package ngc;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.ss.android.ttve.model.VEAudioDeviceType;
import com.ss.android.vesdk.runtime.VERuntime;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public a() {
    }

    public static VEAudioDeviceType a() {
        boolean[] r100 = new boolean[VEAudioDeviceType.values().length];
        int r101 = VEAudioDeviceType.BLUETOOTH.ordinal();
        int r102 = VEAudioDeviceType.WIRED.ordinal();
        AudioDeviceInfo[] r103 = ((AudioManager) VERuntime.getInstance().getContext().getSystemService("audio")).getDevices(2);
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L17;
        AudioDeviceInfo r106 = r103[r105];
        if (r106.getType() != 7) goto L7;
    L14:
        r100[r101] = true;
    L15:
        r105 = r105 + 1;
        goto L3
    L7:
        if (r106.getType() == 8) goto L14;
        if (r106.getType() != 4) goto L12;
    L13:
        r100[r102] = true;
        goto L15
    L12:
        if (r106.getType() != 3) goto L15;
    L17:
        if (r100[r102] == false) goto L21;
        return VEAudioDeviceType.WIRED;
    L21:
        if (r100[r101] == false) goto L25;
        return VEAudioDeviceType.BLUETOOTH;
    L25:
        return VEAudioDeviceType.DEFAULT;
    }

    static {
    }
}
