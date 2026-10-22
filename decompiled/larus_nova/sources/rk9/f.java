package rk9;

import android.media.AudioManager;
import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements a {
    public f() {
    }

    @Override // rk9.a
    public final Object a(AudioManager r100, Handler r101, com.larus.media.l r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "onDeviceChanged");
        return null;
    }

    @Override // rk9.a
    public final void c(AudioManager r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "callbackToken");
    }

    @Override // rk9.a
    public final boolean d() {
        return false;
    }

    @Override // rk9.a
    public final l e(AudioManager r110) {
        Intrinsics.checkNotNullParameter(r110, "manager");
        return new l(r110.getMode(), r110.isSpeakerphoneOn(), r110.isBluetoothScoOn(), r110.isBluetoothA2dpOn(), r110.isWiredHeadsetOn(), "unsupported", "unsupported", "unsupported", "unsupported");
    }

    @Override // rk9.a
    public final j f(AudioManager r100) {
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
        if (r100.isBluetoothScoOn() == false) goto L5;
    L10:
        return "legacy_external_output";
    L5:
        if (r100.isBluetoothA2dpOn() == true) goto L10;
        if (r100.isWiredHeadsetOn() == true) goto L10;
        return null;
    }

    @Override // rk9.a
    public final boolean i(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (r100.isBluetoothScoOn() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.isBluetoothScoAvailableOffCall() == true) goto L8;
        return false;
    }

    @Override // rk9.a
    public final j b(AudioManager r100, k r101) {
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
    public final j g(AudioManager r100, k r101) {
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
    public final j j(AudioManager r100, k r101) {
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
}
