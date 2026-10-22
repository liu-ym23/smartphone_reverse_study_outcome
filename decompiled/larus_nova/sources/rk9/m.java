package rk9;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.larus.im.internal.delegate.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538432a;

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f538432a = r100;
    }

    @Override // rk9.i, rk9.a
    public final l e(AudioManager r110) {
        Intrinsics.checkNotNullParameter(r110, "manager");
        l r100 = super.e(r110);
        AudioDeviceInfo r101 = r110.getCommunicationDevice();
        if (r101 == null) goto L6;
        String r102 = d.a(r101);
        if (r102 == null) goto L6;
    L7:
        String r103 = r102;
        List<AudioDeviceInfo> r111 = r110.getAvailableCommunicationDevices();
        ArrayList r104 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
    L9:
        if (r112.hasNext() == false) goto L13;
        Object r105 = r112.next();
        AudioDeviceInfo r106 = (AudioDeviceInfo) r105;
        Intrinsics.checkNotNull(r106);
        if (d.c(r106) == false) goto L9;
        r104.add(r105);
        goto L9
    L13:
        String r107 = i.l(r104);
        int r108 = r100.f538423a;
        boolean r109 = r100.f538424b;
        boolean r113 = r100.f538425c;
        boolean r114 = r100.f538426d;
        boolean r115 = r100.f538427e;
        String r116 = r100.f538430h;
        String r117 = r100.f538431i;
        Intrinsics.checkNotNullParameter(r103, "communicationDevice");
        Intrinsics.checkNotNullParameter(r107, "bluetoothCommunicationDevices");
        Intrinsics.checkNotNullParameter(r116, "bluetoothInputDevices");
        Intrinsics.checkNotNullParameter(r117, "externalOutputDevices");
        return new l(r108, r109, r113, r114, r115, r103, r107, r116, r117);
    L6:
        r102 = "none";
        goto L7
    }

    @Override // rk9.i, rk9.a
    public final j f(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        AudioDeviceInfo r101 = r100.getCommunicationDevice();
        if (r101 == null) goto L9;
        if (d.c(r101) == false) goto L9;
        r100.clearCommunicationDevice();
        return new j("release_bluetooth_communication_route", null, true);
    L9:
        return new j("bluetooth_communication_route_not_active", null, true);
    }

    @Override // rk9.i
    public final AudioDeviceInfo k(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Iterator<T> r101 = r100.getAvailableCommunicationDevices().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        AudioDeviceInfo r103 = (AudioDeviceInfo) r102;
        Intrinsics.checkNotNull(r103);
        if (d.c(r103) == false) goto L4;
    L10:
        return (AudioDeviceInfo) r102;
    L8:
        r102 = null;
        goto L10
    }

    public final AudioDeviceInfo n(AudioManager r100) {
        AudioDeviceInfo r101 = r100.getCommunicationDevice();
        if (r101 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (d.d(r101) == false) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L16;
        c0.f348199b.i(this.f538432a, "captureRestorableCommunicationDevice: skip non-communication device " + d.a(r101));
        return null;
    L16:
        if (m(r101, r100) == true) goto L19;
        c0.f348199b.i(this.f538432a, "captureRestorableCommunicationDevice: skip unavailable device " + d.a(r101));
        return null;
    L19:
        return r101;
    L8:
        if (d.c(r101) == true) goto L11;
        r102 = false;
        goto L12
    }

    public static boolean m(AudioDeviceInfo r100, AudioManager r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (d.d(r100) == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        List<AudioDeviceInfo> r103 = r101.getAvailableCommunicationDevices();
        if ((r103 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L27;
        AudioDeviceInfo r105 = (AudioDeviceInfo) r104.next();
        Intrinsics.checkNotNull(r105);
        if (d.f(r105, r100) == false) goto L18;
        return true;
    L27:
        return false;
    L14:
        if (r103.isEmpty() == false) goto L16;
        return false;
    L5:
        if (d.c(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // rk9.i, rk9.a
    public final j b(AudioManager r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if ((r101 instanceof k.b) == false) goto L5;
        k.b r102 = (k.b) r101;
    L6:
        if (r102 == null) goto L8;
        Object r103 = r102.f538422a;
    L10:
        if ((r103 instanceof AudioDeviceInfo) == false) goto L12;
        AudioDeviceInfo r104 = (AudioDeviceInfo) r103;
    L28:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        if (r104 != null) goto L16;
    L18:
        r100.clearCommunicationDevice();     // Catch: Throwable -> L21
        Object r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L27;
        c0.f348199b.w(this.f538432a, "releaseRoute: restore communication device failed: " + r108.getMessage());
    L27:
        return new j("release_communication_route", null, true);
    L16:
        if (m(r104, r100) == false) goto L18;
        r106 = Boolean.valueOf(r100.setCommunicationDevice(r104));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L12:
        r104 = null;
        goto L28
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // rk9.i, rk9.a
    public final j g(AudioManager r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        AudioDeviceInfo r102 = k(r100);
        if (r102 == null) goto L5;
        if (r101 != null) goto L8;
        r101 = new k.b(n(r100));
    L8:
        AudioDeviceInfo r103 = r100.getCommunicationDevice();
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L16;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r100.setCommunicationDevice(r102)));     // Catch: Throwable -> L19
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L26;
        c0.f348199b.w(this.f538432a, "routeInputToBluetooth: setCommunicationDevice failed: " + r107.getMessage());
        r106 = Boolean.FALSE;
    L26:
        if (((Boolean) r106).booleanValue() == true) goto L30;
        c0.f348199b.w(this.f538432a, "routeInputToBluetooth: setCommunicationDevice returned false, device=" + d.a(r102));
        return new j("bluetooth_route_failed " + d.a(r102), r101, false);
    L30:
        return new j("set bluetooth " + d.a(r102), r101, true);
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L16:
        return new j("bluetooth already selected " + d.a(r102), r101, true);
    L11:
        if (d.f(r103, r102) != true) goto L13;
        r104 = true;
        goto L14
    L5:
        return new j("bluetooth_input_unavailable", r101, false);
    }

    @Override // rk9.i, rk9.a
    public final j j(AudioManager r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (r101 != null) goto L5;
        r101 = new k.b(n(r100));
    L5:
        Intrinsics.checkNotNullParameter(r100, "manager");
        AudioDeviceInfo r102 = r100.getCommunicationDevice();
        boolean r103 = false;
        if (r102 != null) goto L8;
    L10:
        Iterator<T> r104 = r100.getAvailableCommunicationDevices().iterator();
    L11:
        Object r105 = null;
        if (r104.hasNext() == false) goto L19;
        Object r106 = r104.next();
        if (((AudioDeviceInfo) r106).getType() != 2) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L11;
    L20:
        AudioDeviceInfo r108 = (AudioDeviceInfo) r106;
        if (r108 != null) goto L41;
        Iterator<T> r109 = r100.getAvailableCommunicationDevices().iterator();
    L24:
        if (r109.hasNext() == false) goto L31;
        Object r110 = r109.next();
        if (((AudioDeviceInfo) r110).getType() != 1) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L24;
    L32:
        r108 = (AudioDeviceInfo) r110;
        if (r108 != null) goto L41;
        Iterator<T> r112 = r100.getAvailableCommunicationDevices().iterator();
    L36:
        if (r112.hasNext() == false) goto L40;
        Object r113 = r112.next();
        AudioDeviceInfo r114 = (AudioDeviceInfo) r113;
        Intrinsics.checkNotNull(r114);
        if (d.d(r114) == false) goto L36;
        r105 = r113;
    L40:
        r102 = (AudioDeviceInfo) r105;
    L42:
        if (r102 != null) goto L45;
        r100.clearCommunicationDevice();
        return new j("force_builtin_mic_clear_communication_device_no_builtin_route", r101, true);
    L45:
        AudioDeviceInfo r115 = r100.getCommunicationDevice();
        if (r115 != null) goto L48;
    L50:
        if (r103 == true) goto L52;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L55
        Object r117 = Result.m9449constructorimpl(Boolean.valueOf(r100.setCommunicationDevice(r102)));     // Catch: Throwable -> L55
    L57:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L61;
        c0.f348199b.w(this.f538432a, "routeInputToBuiltInMic: setCommunicationDevice failed: " + r118.getMessage());
        r117 = Boolean.FALSE;
    L61:
        boolean r119 = ((Boolean) r117).booleanValue();
        return new j("force_builtin_mic success=" + r119 + " route=" + d.a(r102), r101, r119);
    L55:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L52:
        return new j("force_builtin_mic_already_selected " + d.a(r102), r101, true);
    L48:
        if (d.f(r115, r102) != true) goto L50;
        r103 = true;
        goto L50
    L28:
        r111 = false;
        goto L29
    L31:
        r110 = null;
    L41:
        r102 = r108;
        goto L42
    L16:
        r107 = false;
        goto L17
    L19:
        r106 = null;
        goto L20
    L8:
        if (d.d(r102) == false) goto L10;
        goto L10
    }
}
