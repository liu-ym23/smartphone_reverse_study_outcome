package com.larus.dora.impl.device.settings.sound;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraAmbientVolumeSettingsNotifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraAmbientVolumeSettingsNotifier f334888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IntRange f334889b = null;

    public DoraAmbientVolumeSettingsNotifier() {
    }

    static {
        f334888a = new DoraAmbientVolumeSettingsNotifier();
        f334889b = new IntRange(0, 1);
    }

    public static Boolean a(Intent r100, DoraDevice r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, "device");
        if (Intrinsics.areEqual(r100.getAction(), "com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED") == true) goto L5;
        return null;
    L5:
        if (r100.hasExtra("enabled") == false) goto L35;
        String r102 = r100.getStringExtra("device_serial_number");
        boolean r103 = true;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
    L17:
        String r105 = r100.getStringExtra("device_mac");
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == false) goto L26;
    L28:
        r103 = false;
    L29:
        if (r103 == true) goto L32;
        return null;
    L32:
        return Boolean.valueOf(r100.getBooleanExtra("enabled", false));
    L26:
        if (Intrinsics.areEqual(r105, r101.f204389mac) == false) goto L28;
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L15:
        if (Intrinsics.areEqual(r102, r101.getSerialNumber()) == false) goto L17;
    L9:
        if (r102.length() == 0) goto L12;
        r104 = false;
        goto L13
    L35:
        return null;
    }

    public static void b(DoraDevice r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "device");
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).sendBroadcast(new Intent("com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED").putExtra("device_serial_number", r100.getSerialNumber()).putExtra("device_mac", r100.f204389mac).putExtra("enabled", r101));
    }

    public final Object c(DoraDevice r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1) == false) goto L7;
        DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1 r102 = (DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (DoraDevice) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        int r108 = ((Number) r104).intValue();
        IntRange r109 = f334889b;
        int r110 = r109.getFirst();
        if (r108 > r109.getLast()) goto L21;
        if (r110 > r108) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == true) goto L25;
        g49.d.e("DoraAmbientVolumeSettingsNotifier", "ignore unexpected ambient-volume state=" + r108);
        return Unit.INSTANCE;
    L25:
        if (r108 == 1) goto L28;
        r107 = false;
    L28:
        b(r100, r107);
        return Unit.INSTANCE;
    L21:
        r111 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        kj4.a r112 = kj4.a.g();
        r102.L$0 = r100;
        r102.label = 1;
        r104 = DoraAdapterExtKt.l(r112);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DoraAmbientVolumeSettingsNotifier$notifyCurrentState$1(this, r101);
        goto L8
    }
}
