package com.bytedance.bpea.entry.api.camera;

import android.hardware.camera2.CameraDevice;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import f06.c;
import fna.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class Camera2Entry$Companion$close$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CameraDevice $this_close;

    public Camera2Entry$Companion$close$1(CameraDevice r100) {
        this.$this_close = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$close$1_com_obric_performance_power_monitor_camera_CameraLancet_close(this.$this_close);
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$close$1_com_obric_performance_power_monitor_camera_CameraLancet_close(CameraDevice r100) {
        if (g.d() == true) goto L6;
        a(r100);
        return;
    L6:
        a(r100);
        if ((r100 instanceof CameraDevice) == false) goto L10;
        jna.a.a(r100.getId());
        return;
    }

    public static void a(CameraDevice r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, false);
        return;
    L6:
        r110.close();
        r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, true);
    }
}
