package com.bytedance.bpea.entry.api.camera;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import f06.c;
import fna.g;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class Camera2Entry$Companion$openCamera$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CameraDevice.StateCallback $callback;
    final /* synthetic */ String $cameraId;
    final /* synthetic */ Executor $executor;
    final /* synthetic */ CameraManager $this_openCamera;

    public Camera2Entry$Companion$openCamera$2(CameraManager r100, String r101, Executor r102, CameraDevice.StateCallback r103) {
        this.$this_openCamera = r100;
        this.$cameraId = r101;
        this.$executor = r102;
        this.$callback = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$openCamera$2_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.$this_openCamera, this.$cameraId, this.$executor, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_camera_Camera2Entry$Companion$openCamera$2_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r100, String r101, Executor r102, CameraDevice.StateCallback r103) throws CameraAccessException {
        if (g.d() == true) goto L6;
        a(r100, r101, r102, r103);
        return;
    L6:
        a(r100, r101, r102, r103);
        jna.a.b(r101);
    }

    public static void a(CameraManager r110, String r111, Executor r112, CameraDevice.StateCallback r113) throws CameraAccessException {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113};
        f06.b r114 = new f06.b();
        if (r100.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, "void", r114).f474982a == false) goto L6;
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, false);
        return;
    L6:
        r110.openCamera(r111, r112, r113);
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, true);
    }
}
