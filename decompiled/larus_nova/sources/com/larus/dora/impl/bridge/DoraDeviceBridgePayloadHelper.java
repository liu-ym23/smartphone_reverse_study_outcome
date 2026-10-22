package com.larus.dora.impl.bridge;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraDeviceBridgePayloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraDeviceBridgePayloadHelper f332059a = null;

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f332060a = null;

        static {
            int[] r100 = new int[GestureWakeupType.values().length];
            r100[GestureWakeupType.RADIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[GestureWakeupType.CLOSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f332060a = r100;
        }
    }

    static {
        f332059a = new DoraDeviceBridgePayloadHelper();
    }

    public DoraDeviceBridgePayloadHelper() {
    }

    public static String b(Byte r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return "answer_hang_up";
    L10:
        if (r100 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        return "answer";
    L17:
        if (r100 != null) goto L19;
    L21:
        if (r101 == false) goto L23;
        return "hang_up";
    L23:
        if (r100 == null) goto L25;
        r100.byteValue();
    L25:
        return "none";
    L19:
        if (r100.byteValue() != 3) goto L21;
        r101 = true;
        goto L21
    L12:
        if (r100.byteValue() != 2) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100.byteValue() != 1) goto L7;
        r102 = true;
        goto L8
    }

    public static String d(Byte r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return "play_pause";
    L10:
        if (r100 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        return "previous_track";
    L17:
        if (r100 != null) goto L19;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L24;
        return "next_track";
    L24:
        if (r100 != null) goto L26;
    L28:
        boolean r105 = false;
    L29:
        if (r105 == false) goto L31;
        return "simul_interpret";
    L31:
        if (r100 != null) goto L33;
    L35:
        r101 = false;
    L36:
        if (r101 == false) goto L38;
        return "voice_reminder";
    L38:
        if (r100 == null) goto L40;
        r100.byteValue();
    L40:
        return "none";
    L33:
        if (r100.byteValue() != (-1)) goto L35;
    L26:
        if (r100.byteValue() != 34) goto L28;
        r105 = true;
        goto L29
    L19:
        if (r100.byteValue() != 20) goto L21;
        r104 = true;
        goto L22
    L12:
        if (r100.byteValue() != 19) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100.byteValue() != 16) goto L7;
        r102 = true;
        goto L8
    }

    public static String f(GestureWakeupType r100) {
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        if (r101 != (-1)) goto L8;
    L21:
        return "none";
    L8:
        if (r101 != 1) goto L10;
        return "radio";
    L10:
        if (r101 != 2) goto L12;
        return "continuous_dialogue";
    L12:
        if (r101 != 3) goto L14;
        return "radio_record";
    L14:
        if (r101 == 4) goto L21;
        throw new NoWhenBranchMatchedException();
    L5:
        r101 = a.f332060a[r100.ordinal()];
        goto L6
    }

    public static boolean e(DoraDevice r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "device");
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        sk4.e r103 = o0.f332223a;
        if (o0.e(r100.getSerialNumber(), "wakeupGestureUnify") == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (r101.contains("wakeupGestureUnify") != true) goto L7;
        r102 = true;
        goto L8
    }

    public static Map a(DoraDevice r100, Map r110, List r111) {
        boolean r112 = e(r100, r111);
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L9;
        DeviceService r102 = r101.device();
        if (r102 == null) goto L9;
        if (r102.q0(null) != true) goto L9;
        boolean r103 = true;
    L10:
        GestureWakeupType r104 = GestureWakeupRepository.f(GestureWakeupRepository.f334505a, r100, 2);
        GestureWakeupType r105 = GestureWakeupRepository.e(r100, 1);
        GestureWakeupType r106 = GestureWakeupRepository.e(r100, 2);
        Pair[] r107 = new Pair[9];
        r107[0] = TuplesKt.to("supportsWakeupGestureUnify", Boolean.valueOf(r112));
        r107[1] = TuplesKt.to("aiKeySupported", Boolean.valueOf(r103));
        String r108 = "";
        if (r112 == false) goto L14;
        if (r103 == true) goto L14;
        String r109 = f(r104);
    L15:
        r107[2] = TuplesKt.to("wakeupGestureValue", r109);
        if (r112 == false) goto L21;
        if (r103 == false) goto L21;
        if (r105 != null) goto L20;
        r105 = r104;
    L20:
        String r113 = f(r105);
    L22:
        r107[3] = TuplesKt.to("wakeupLeftValue", r113);
        if (r112 == false) goto L29;
        if (r103 == false) goto L29;
        if (r106 == null) goto L28;
        r104 = r106;
    L28:
        r108 = f(r104);
    L29:
        r107[4] = TuplesKt.to("wakeupRightValue", r108);
        r107[5] = TuplesKt.to("mediaLeftValue", d((Byte) r110.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK)));
        r107[6] = TuplesKt.to("mediaRightValue", d((Byte) r110.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK)));
        r107[7] = TuplesKt.to("callLeftValue", b((Byte) r110.get(GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK)));
        r107[8] = TuplesKt.to("callRightValue", b((Byte) r110.get(GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK)));
        return MapsKt.linkedMapOf(r107);
    L21:
        r113 = "";
    L14:
        r109 = "";
    L9:
        r103 = false;
        goto L10
    }

    public final Object c(DoraDevice r110, List<String> r111, Continuation<? super Map<String, ? extends Object>> r112) {
        if ((r112 instanceof DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1) == false) goto L7;
        DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1 r100 = (DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        List<String> r114 = (List) r100.L$1;
        DoraDevice r115 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r111 = r114;
        r110 = r115;
    L48:
        GestureSettingsRepository.f334402a.getClass();
        Map r104 = GestureSettingsRepository.d(r110);
    L50:
        return a(r110, r104, r111);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = (List) r100.L$1;
        r110 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L45:
        GestureWakeupRepository r116 = GestureWakeupRepository.f334505a;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 2;
        if (r116.i(r100) != r102) goto L48;
        return r102;
    L16:
        ResultKt.throwOnFailure(r113);
        boolean r117 = e(r110, r111);
        IDoraService r105 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r105 == null) goto L23;
        DeviceService r106 = r105.device();
        if (r106 == null) goto L23;
        if (r106.q0(null) != true) goto L23;
        boolean r107 = true;
    L24:
        GestureSettingsRepository r108 = GestureSettingsRepository.f334402a;
        r108.getClass();
        r104 = GestureSettingsRepository.d(r110);
        if (r117 == false) goto L38;
        if (r107 == false) goto L35;
        GestureWakeupRepository r118 = GestureWakeupRepository.f334505a;
        r118.getClass();
        if (GestureWakeupRepository.e(r110, 1) != null) goto L38;
        if (GestureWakeupRepository.e(r110, 2) != null) goto L38;
        if (GestureWakeupRepository.f(r118, r110, 2) != null) goto L38;
    L37:
        boolean r119 = false;
    L40:
        if (r104.isEmpty() == true) goto L42;
        if (r119 == true) goto L50;
    L42:
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        if (r108.f(false, r100) != r102) goto L45;
        return r102;
    L35:
        if (GestureWakeupRepository.f(GestureWakeupRepository.f334505a, r110, 2) == null) goto L37;
    L38:
        r119 = true;
    L23:
        r107 = false;
    L7:
        r100 = new DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1(this, r112);
        goto L8
    }
}
