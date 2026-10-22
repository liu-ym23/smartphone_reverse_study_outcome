package com.larus.dora.impl.ota.g;

import com.google.gson.Gson;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.device.ota.DoraOTAReporter;
import com.larus.dora.impl.device.ota.EventTypeOTAErrorCode;
import com.larus.dora.impl.device.ota.EventTypeOTAStatus;
import com.larus.dora.impl.device.ota.l0;
import com.larus.dora.impl.ota.plugin.DoraOTAPeripheralStage;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraGOTAPlugin implements i69.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f337516c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f337517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f337518b;

    public static final class a {
    }

    static {
    }

    @Override // i69.a
    public final boolean d(int r100) {
        if (r100 != 190) goto L5;
        return true;
    L5:
        return false;
    }

    public DoraGOTAPlugin() {
        this.f337518b = new Gson();
    }

    @Override // i69.a
    public final Object a(e49.a r100, Continuation<? super com.larus.dora.impl.ota.c> r101) {
        if ((r101 instanceof DoraGOTAPlugin$checkBeforeDataTransfer$1) == false) goto L7;
        DoraGOTAPlugin$checkBeforeDataTransfer$1 r102 = (DoraGOTAPlugin$checkBeforeDataTransfer$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        com.larus.dora.impl.ota.c r107 = (com.larus.dora.impl.ota.c) r104;
        g49.d.d("DoraGOTAPlugin", "checkBeforeDataTransfer: peripheralIntent=" + r107.a());
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        r104 = e(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DoraGOTAPlugin$checkBeforeDataTransfer$1(this, r101);
        goto L8
    }

    @Override // i69.a
    public final DoraOTAPeripheralStage b(int r100, int r101) {
        if (r100 != 1) goto L6;
        return new DoraOTAPeripheralStage.a(r101);
    L6:
        if (r100 != 4) goto L9;
        return new DoraOTAPeripheralStage.b(r101);
    L9:
        if (r100 != 5) goto L12;
        return new DoraOTAPeripheralStage.f(r101);
    L12:
        if (r100 != 9) goto L15;
        return DoraOTAPeripheralStage.d.f337789a;
    L15:
        if (r100 <= 100) goto L22;
        if (v.a(r100) == false) goto L19;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoraGOTAPlugin$doReboot$1(null), 3, null);
        com.larus.dora.impl.ota.c r102 = u.d.f337560a;
    L27:
        return new DoraOTAPeripheralStage.c(r100, r102);
    L19:
        r102 = com.larus.dora.impl.ota.a.e.f337420a;
        goto L27
    L22:
        return new DoraOTAPeripheralStage.e(r100);
    }

    @Override // i69.a
    public final DoraOTAPeripheralStage c(int r110, int r111) {
        if (r110 != 4) goto L9;
        if (this.f337517a == r110) goto L7;
        int r100 = j69.a.f497534a;
        j69.b.b("ota_update_upgrade");
        j69.a.b("ota_update_upgrade", MapsKt.mapOf(TuplesKt.to("step", "start")));
        DoraOTAReporter.f334181a.f334212f.f334220d = EventTypeOTAStatus.START_INSTALL.getCode();
        DoraOTAReporter.d();
    L7:
        DoraOTAPeripheralStage r101 = new DoraOTAPeripheralStage.b(r111);
    L33:
        this.f337517a = r110;
        return r101;
    L9:
        if (r110 != 5) goto L15;
        if (this.f337517a == r110) goto L13;
        int r102 = j69.a.f497534a;
        j69.a.b("ota_update_upgrade", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(j69.b.a("ota_update_upgrade")))}));
        j69.b.b("ota_update_device_reboot");
        j69.a.b("ota_update_device_reboot", MapsKt.mapOf(TuplesKt.to("step", "start")));
    L13:
        r101 = new DoraOTAPeripheralStage.f(r111);
        goto L33
    L15:
        if (r110 != 9) goto L21;
        if (this.f337517a == r110) goto L19;
        int r112 = j69.a.f497534a;
        j69.a.e(null);
    L19:
        r101 = DoraOTAPeripheralStage.d.f337789a;
        goto L33
    L21:
        if (r110 <= 100) goto L32;
        int r113 = j69.a.f497534a;
        String r114 = "upgrade_firmware_failure_" + r110;
        if (this.f337517a != 4) goto L28;
        Intrinsics.checkNotNullParameter(r114, "failReason");
        j69.a.b("ota_update_upgrade", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("duration", Long.valueOf(j69.b.a("ota_update_upgrade"))), TuplesKt.to("fail_reason", r114), TuplesKt.to("error_message", "ota_" + r114)}));
        if (r110 != 130) goto L28;
        l0 r115 = DoraOTAReporter.f334181a.f334212f;
        r115.f334220d = EventTypeOTAStatus.FAIL.getCode();
        r115.f334217a = EventTypeOTAErrorCode.VERIFICATION_FAILED.getCode();
        DoraOTAReporter.d();
    L28:
        if (v.a(r110) == false) goto L30;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoraGOTAPlugin$doReboot$1(null), 3, null);
        com.larus.dora.impl.ota.c r116 = u.d.f337560a;
    L31:
        r101 = new DoraOTAPeripheralStage.c(r110, r116);
        goto L33
    L30:
        r116 = com.larus.dora.impl.ota.a.e.f337420a;
        goto L31
    L32:
        r101 = new DoraOTAPeripheralStage.e(r110);
        goto L33
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x01f7 -> B:13:0x0044). Please report as a decompilation issue!!! */
    public final Object e(e49.a r210, Continuation<? super com.larus.dora.impl.ota.c> r211) {
        if ((r211 instanceof DoraGOTAPlugin$checkPeripheral$1) == false) goto L7;
        DoraGOTAPlugin$checkPeripheral$1 r100 = (DoraGOTAPlugin$checkPeripheral$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        DoraGOTAPlugin r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L17;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        int r106 = r100.I$1;
        int r107 = r100.I$0;
        OTAUpdatePackage r108 = (OTAUpdatePackage) r100.L$1;
        e49.a r110 = (e49.a) r100.L$0;
        ResultKt.throwOnFailure(r103);
        DoraGOTAPlugin r212 = r102;
        Object r109 = r104;
        int r111 = r107;
        e49.a r112 = r110;
    L13:
        DoraGOTAPlugin$checkPeripheral$1 r113 = r100;
        OTAUpdatePackage r114 = r108;
        int r115 = r106 + 1;
        Object r116 = r109;
    L22:
        if (r115 >= r111) goto L120;
        String r117 = vk4.e.d.f555490a.c();
        if (r117 != null) goto L26;
        String r118 = "";
    L27:
        Integer r119 = r114.getId();
        if (r119 == null) goto L30;
        long r120 = r119.intValue();
    L31:
        String r121 = r114.getMd5();
        if (r121 != null) goto L34;
        String r122 = "";
    L35:
        String r123 = r114.getName();
        if (r123 != null) goto L38;
        String r124 = "";
    L39:
        Integer r125 = r114.getSize();
        if (r125 == null) goto L42;
        long r126 = r125.intValue();
    L43:
        int r127 = r114.getType();
        String r128 = r114.getUrl();
        if (r128 != null) goto L46;
        String r129 = "";
    L47:
        String r130 = r114.getVersion();
        if (r130 != null) goto L50;
        String r131 = "";
    L51:
        Long r132 = r114.getBuildTime();
        if (r132 == null) goto L54;
        long r213 = r132.longValue();
    L56:
        if (r112.f471023b == false) goto L58;
        String r214 = "NuttX";
    L59:
        r113.L$0 = r112;
        r113.L$1 = r114;
        r113.I$0 = r111;
        r113.I$1 = r115;
        r113.label = 1;
        int r215 = r115;
        int r216 = r111;
        Object r133 = r212.f(r118, r120, r122, r124, r126, r127, r129, r131, r213, r214, r113);
        if (r133 != r116) goto L62;
        return r116;
    L62:
        e49.a r134 = r112;
        r108 = r114;
        r100 = r113;
        r104 = r116;
        Object r135 = r133;
        r106 = r215;
        int r136 = r216;
    L64:
        if (Result.m9456isSuccessimpl(r135) == false) goto L107;
        CheckRemoteResponse r137 = (CheckRemoteResponse) r135;
        g49.d.d("DoraGOTAPlugin", "checkPeripheral: map " + r137);
        Integer r138 = r137.getStatus();
        if (r138 != null) goto L69;
    L71:
        if (r138 != null) goto L74;
    L75:
        if (r138 != null) goto L78;
    L80:
        if (r138 != null) goto L83;
    L85:
        if (r138 != null) goto L88;
    L89:
        if (r138 != null) goto L92;
    L94:
        Integer r139 = r137.getStatus();
        if (r139 == null) goto L97;
        int r140 = r139.intValue();
    L98:
        Object r141 = new u.b(r140);
    L123:
        return r141;
    L97:
        r140 = -1;
        goto L98
    L92:
        if (r138.intValue() != 101) goto L94;
    L99:
        Integer r142 = r137.getStatus();
        if (r142 == null) goto L102;
        int r143 = r142.intValue();
    L103:
        r141 = new u.e(r143);
        goto L123
    L102:
        r143 = 0;
        goto L103
    L88:
        if (r138.intValue() == 100) goto L99;
    L83:
        if (r138.intValue() != 2) goto L85;
        return u.f.f337563a;
    L78:
        if (r138.intValue() != 4) goto L80;
    L106:
        return u.c.f337559a;
    L74:
        if (r138.intValue() == 3) goto L106;
    L69:
        if (r138.intValue() != 0) goto L71;
        return com.larus.dora.impl.ota.c.a.f337426a;
    L107:
        Throwable r144 = Result.m9452exceptionOrNullimpl(r135);
        if ((r144 instanceof CancellationException) == true) goto L117;
        int r145 = 1 - r106;
        g49.d.c("DoraGOTAPlugin", "checkPeripheral: attempt=" + (r106 + 1) + '/' + r136 + " failed", r144);
        if (r145 <= 0) goto L120;
        g49.d.d("DoraGOTAPlugin", "checkPeripheral: retry /otaprepare after 500ms");
        r100.L$0 = r134;
        r100.L$1 = r108;
        r100.I$0 = r136;
        r100.I$1 = r106;
        r100.label = 2;
        if (DelayKt.delay(500, r100) != r104) goto L115;
        return r104;
    L115:
        r109 = r104;
        r111 = r136;
        r112 = r134;
        goto L13
    L117:
        g49.d.d("DoraGOTAPlugin", "checkPeripheral: retry cancelled at attempt=" + (r106 + 1) + '/' + r136);
        throw r144;
    L58:
        r214 = "";
        goto L59
    L54:
        r213 = 0;
        goto L56
    L50:
        r131 = r130;
        goto L51
    L46:
        r129 = r128;
        goto L47
    L42:
        r126 = 0;
        goto L43
    L38:
        r124 = r123;
        goto L39
    L34:
        r122 = r121;
        goto L35
    L30:
        r120 = 0;
        goto L31
    L26:
        r118 = r117;
    L120:
        return new u.a(1);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r106 = r100.I$1;
        r136 = r100.I$0;
        r108 = (OTAUpdatePackage) r100.L$1;
        r134 = (e49.a) r100.L$0;
        ResultKt.throwOnFailure(r103);
        r135 = ((Result) r103).m9458unboximpl();
        r212 = r102;
        goto L64
    L17:
        ResultKt.throwOnFailure(r103);
        OTAUpdatePackage r146 = e49.b.a(r210);
        if (r146 == null) goto L20;
        r212 = r102;
        r116 = r104;
        r115 = 0;
        r111 = 2;
        r113 = r100;
        r114 = r146;
        r112 = r210;
        goto L22
    L20:
        return new u.a(0);
    L7:
        r102 = this;
        r100 = new DoraGOTAPlugin$checkPeripheral$1(r102, r211);
        goto L8
    }

    public final Object f(String r210, long r211, String r212, String r213, long r214, int r215, String r310, String r311, long r312, String r313, Continuation r314) {
        if ((r314 instanceof DoraGOTAPlugin$checkPeripheralInner$1) == false) goto L7;
        DoraGOTAPlugin$checkPeripheralInner$1 r100 = (DoraGOTAPlugin$checkPeripheralInner$1) r314;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraGOTAPlugin$checkPeripheralInner$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L18:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        CoroutineDispatcher r112 = Dispatchers.getIO();
        DoraGOTAPlugin$checkPeripheralInner$2 r113 = new DoraGOTAPlugin$checkPeripheralInner$2(r211, r214, r215, r310, false, r313, r210, r212, r213, r311, r312, this, null);
        r110.label = 1;
        r102 = BuildersKt.withContext(r112, r113, r110);
        if (r102 != r111) goto L18;
        return r111;
    L7:
        r100 = new DoraGOTAPlugin$checkPeripheralInner$1(this, r314);
        goto L8
    }
}
