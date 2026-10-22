package rk9;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public class i implements a {
    @Override // rk9.a
    public final boolean d() {
        return true;
    }

    public i() {
    }

    public static String l(List r100) {
        Intrinsics.checkNotNullParameter(r100, "devices");
        if (((ArrayList) r100).isEmpty() == false) goto L7;
        return "[]";
    L7:
        return CollectionsKt.joinToString$default(r100, null, "[", "]", 0, null, new g(), 25, null);
    }

    @Override // rk9.a
    public l e(AudioManager r110) {
        Intrinsics.checkNotNullParameter(r110, "manager");
        List r100 = ArraysKt.toList(r110.getDevices(1));
        List r101 = ArraysKt.toList(r110.getDevices(2));
        int r102 = r110.getMode();
        boolean r103 = r110.isSpeakerphoneOn();
        boolean r104 = r110.isBluetoothScoOn();
        boolean r105 = r110.isBluetoothA2dpOn();
        boolean r106 = r110.isWiredHeadsetOn();
        ArrayList r111 = new ArrayList();
        Iterator r107 = r100.iterator();
    L4:
        if (r107.hasNext() == false) goto L8;
        Object r108 = r107.next();
        AudioDeviceInfo r112 = (AudioDeviceInfo) r108;
        Intrinsics.checkNotNull(r112);
        if (d.c(r112) == false) goto L4;
        r111.add(r108);
        goto L4
    L8:
        String r113 = l(r111);
        ArrayList r114 = new ArrayList();
        Iterator r109 = r101.iterator();
    L10:
        if (r109.hasNext() == false) goto L21;
        Object r115 = r109.next();
        AudioDeviceInfo r116 = (AudioDeviceInfo) r115;
        Intrinsics.checkNotNull(r116);
        Intrinsics.checkNotNullParameter(r116, "<this>");
        if (d.e(r116) == false) goto L14;
    L17:
        boolean r117 = true;
    L18:
        if (r117 == false) goto L10;
        r114.add(r115);
        goto L10
    L14:
        if (d.c(r116) == true) goto L17;
        r117 = false;
        goto L18
    L21:
        return new l(r102, r103, r104, r105, r106, "unsupported", "unsupported", r113, l(r114));
    }

    @Override // rk9.a
    public j f(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (r100.isBluetoothScoOn() == false) goto L11;
        if (e.c(r100, "releaseBluetoothInput") == true) goto L9;
        return new j("release_bluetooth_sco_input_failed", null, false);
    L9:
        return new j("release_bluetooth_sco_input", null, true);
    L11:
        return new j("bluetooth_sco_input_not_active", null, true);
    }

    @Override // rk9.a
    public final String h(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        AudioDeviceInfo[] r101 = r100.getDevices(2);
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        AudioDeviceInfo r104 = r101[r103];
        Intrinsics.checkNotNull(r104);
        if (d.e(r104) == true) goto L10;
        r103 = r103 + 1;
    L10:
        if (r104 != null) goto L12;
        return null;
    L12:
        return d.a(r104);
    L9:
        r104 = null;
        goto L10
    }

    @Override // rk9.a
    public final boolean i(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (k(r100) == null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isBluetoothScoOn() == true) goto L8;
        return false;
    }

    public AudioDeviceInfo k(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        AudioDeviceInfo[] r101 = r100.getDevices(1);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        AudioDeviceInfo r104 = null;
        if (r103 >= r102) goto L9;
        AudioDeviceInfo r105 = r101[r103];
        Intrinsics.checkNotNull(r105);
        if (d.c(r105) == true) goto L10;
        r103 = r103 + 1;
    L10:
        if (r105 != null) goto L26;
        AudioDeviceInfo[] r106 = r100.getDevices(2);
        int r107 = r106.length;
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L21;
        AudioDeviceInfo r109 = r106[r108];
        if (r109.getType() != 7) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == true) goto L18;
        r108 = r108 + 1;
        goto L12
    L18:
        r104 = r109;
        goto L21
    L16:
        r110 = false;
    L21:
        return r104;
    L26:
        return r105;
    L9:
        r105 = null;
        goto L10
    }

    @Override // rk9.a
    public j b(AudioManager r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if ((r101 instanceof k.a) == false) goto L5;
        k.a r102 = (k.a) r101;
    L7:
        if (r102 != null) goto L11;
        return new j("release_route_no_snapshot", null, true);
    L11:
        if (r102.f538421a == false) goto L19;
        if (r100.isBluetoothScoOn() == true) goto L19;
        if (e.b(r100, "releaseRoute") == true) goto L27;
        return new j("release_bluetooth_sco_route_failed", null, false);
    L27:
        return new j("release_bluetooth_sco_route", null, true);
    L19:
        if (r102.f538421a == true) goto L27;
        if (r100.isBluetoothScoOn() == false) goto L27;
        if (e.c(r100, "releaseRoute") == true) goto L27;
        return new j("release_bluetooth_sco_route_failed", null, false);
    L5:
        r102 = null;
        goto L7
    }

    @Override // rk9.a
    public final void c(AudioManager r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "callbackToken");
        if ((r101 instanceof AudioDeviceCallback) == false) goto L5;
        AudioDeviceCallback r102 = (AudioDeviceCallback) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        r100.unregisterAudioDeviceCallback(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // rk9.a
    public j g(AudioManager r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (i(r100) == false) goto L5;
        if (r101 != null) goto L9;
        r101 = new k.a(r100.isBluetoothScoOn());
    L9:
        if (r100.isBluetoothScoOn() == true) goto L15;
        if (e.b(r100, "routeInputToBluetooth") == true) goto L15;
        return new j("start_bluetooth_sco_failed", r101, false);
    L15:
        return new j("start bluetooth sco", r101, true);
    L5:
        return new j("bluetooth_input_unavailable", r101, false);
    }

    @Override // rk9.a
    public j j(AudioManager r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (r101 != null) goto L6;
        r101 = new k.a(r100.isBluetoothScoOn());
    L6:
        if (r100.isBluetoothScoOn() == false) goto L12;
        if (e.c(r100, "routeInputToBuiltInMic") == true) goto L12;
        return new j("force_builtin_mic_stop_bluetooth_sco_failed", r101, false);
    L12:
        return new j("force_builtin_mic_stop_bluetooth_sco", r101, true);
    }

    @Override // rk9.a
    public final Object a(AudioManager r100, Handler r101, com.larus.media.l r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "onDeviceChanged");
        h r103 = new h(r102);
        r100.registerAudioDeviceCallback(r103, r101);
        return r103;
    }
}
