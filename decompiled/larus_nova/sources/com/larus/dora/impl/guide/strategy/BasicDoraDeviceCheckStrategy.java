package com.larus.dora.impl.guide.strategy;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import com.larus.network.http.y;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class BasicDoraDeviceCheckStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f335977d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothAdapter f335978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f335979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothDevice f335980c;

    public static final class a {
    }

    static {
    }

    public BasicDoraDeviceCheckStrategy() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("bluetooth");
        BluetoothAdapter r101 = null;
        if ((r100 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r102 = (BluetoothManager) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.getAdapter();
    L8:
        this.f335978a = r101;
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x017e -> B:83:0x0186). Please report as a decompilation issue!!! */
    public final Object b(Continuation<? super Boolean> r110) {
        if ((r110 instanceof BasicDoraDeviceCheckStrategy$isConditionMet$1) == false) goto L7;
        BasicDoraDeviceCheckStrategy$isConditionMet$1 r100 = (BasicDoraDeviceCheckStrategy$isConditionMet$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        boolean r104 = r100.Z$0;
        BluetoothDevice r105 = (BluetoothDevice) r100.L$1;
        Iterator r106 = (Iterator) r100.L$0;
        ResultKt.throwOnFailure(r111);
        Object r112 = ((Result) r111).m9458unboximpl();
        Iterator r107 = r106;
        BluetoothDevice r108 = r105;
        boolean r109 = r104;
        Object r113 = r102;
        BasicDoraDeviceCheckStrategy$isConditionMet$1 r114 = r100;
        BasicDoraDeviceCheckStrategy r115 = this;
    L84:
        if (Result.m9455isFailureimpl(r112) == false) goto L86;
        r112 = null;
    L86:
        Boolean r116 = (Boolean) r112;
        if (r116 == null) goto L95;
        boolean r117 = r116.booleanValue();
        if (r109 == false) goto L93;
        if (r117 == true) goto L93;
        r115.f335979b = Boxing.boxInt(4096);
        g49.d.d("BasicDoraDeviceCheckStrategy", "has dora device, vendorId=" + r115.f335979b);
        r115.f335980c = r108;
        return Boxing.boxBoolean(true);
    L93:
        BasicDoraDeviceCheckStrategy r118 = r115;
        r100 = r114;
        r102 = r113;
        Iterator r119 = r107;
    L40:
        if (r119.hasNext() == false) goto L97;
        BluetoothDevice r120 = (BluetoothDevice) r119.next();
        if (kj4.a.g().getBtConnectState(DoraDevice.from(r120)) != 2) goto L48;
        boolean r121 = true;
    L49:
        if (r121 == false) goto L40;
        g49.d.d("BasicDoraDeviceCheckStrategy", "check bonded device, device=" + r120);
        String r122 = r120.getName();     // Catch: Exception -> L74 SecurityException -> L76
        if (r122 != null) goto L55;
    L57:
        boolean r123 = false;
    L58:
        if (r123 == false) goto L78;
        String r124 = r120.getName();     // Catch: Exception -> L74 SecurityException -> L76
        if (r124 != null) goto L62;
    L64:
        boolean r125 = false;
    L65:
        if (r125 == false) goto L78;
        String r126 = r120.getName();     // Catch: Exception -> L74 SecurityException -> L76
        if (r126 != null) goto L69;
    L71:
        boolean r127 = false;
    L72:
        if (r127 == false) goto L78;
        boolean r128 = true;
    L79:
        r100.L$0 = r119;
        r100.L$1 = r120;
        r100.Z$0 = r128;
        r100.label = 1;
        Object r129 = r118.c(r120, 4096, r100);
        if (r129 != r102) goto L82;
        return r102;
    L82:
        BasicDoraDeviceCheckStrategy$isConditionMet$1 r130 = r100;
        r115 = r118;
        r112 = r129;
        r107 = r119;
        r108 = r120;
        r109 = r128;
        r113 = r102;
        r114 = r130;
        goto L84
    L69:
        if (StringsKt.contains(r126, "2", true) != true) goto L71;
        r127 = true;
        goto L72
    L62:
        if (StringsKt.contains(r124, RomUtils.BRAND_HUAWEI, true) != true) goto L64;
        r125 = true;
    L78:
        r128 = false;
        goto L79
    L55:
        if (StringsKt.contains(r122, "clip", true) != true) goto L57;
        r123 = true;
        goto L58
    L76:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Failed to read device name for H check: " + r120.getAddress(), e);
    L74:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Unexpected error when reading device name: " + r120.getAddress(), e);
    L48:
        r121 = false;
    L46:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "getBtConnectState failed for device: " + r120.getAddress(), e);
        goto L48
    L97:
        return Boxing.boxBoolean(false);
    L95:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        int r131 = Build.VERSION.SDK_INT;
        if (r131 >= 31) goto L18;
        boolean r132 = true;
    L23:
        if (r132 == true) goto L26;
        g49.d.c("BasicDoraDeviceCheckStrategy", "BLUETOOTH_CONNECT permission not granted, skip Dora device check on sdk=" + r131, new SecurityException("BLUETOOTH_CONNECT not granted"));
        return Boxing.boxBoolean(false);
    L26:
        BluetoothAdapter r133 = this.f335978a;
        if (r133 != null) goto L29;
    L104:
        g49.d.c("BasicDoraDeviceCheckStrategy", "BluetoothAdapter is null or not enabled, cannot check Dora devices", new IllegalStateException("adapter null"));
        return Boxing.boxBoolean(false);
    L29:
        if (r133.isEnabled() == false) goto L104;
        Set<BluetoothDevice> r134 = r133.getBondedDevices();     // Catch: Exception -> L98 SecurityException -> L101
        if (r134 != null) goto L35;
        r134 = SetsKt.emptySet();     // Catch: Exception -> L98 SecurityException -> L101
    L35:
        if (r134.isEmpty() == true) goto L37;
        r119 = r134.iterator();
        r118 = this;
        goto L40
    L37:
        return Boxing.boxBoolean(false);
    L101:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Failed to access bondedDevices, permission might be missing", e);
        return Boxing.boxBoolean(false);
    L98:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Unexpected error when reading bondedDevices", e);
        return Boxing.boxBoolean(false);
    L18:
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L20;
        r132 = true;
    L21:
        if (r132 == true) goto L23;
        g49.d.c("BasicDoraDeviceCheckStrategy", "BLUETOOTH_CONNECT permission not granted when checking Dora devices", new SecurityException("BLUETOOTH_CONNECT not granted"));
        goto L23
    L20:
        r132 = false;
    L7:
        r100 = new BasicDoraDeviceCheckStrategy$isConditionMet$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(DoraDevice r110, Continuation<? super Result<Boolean>> r111) {
        if ((r111 instanceof BasicDoraDeviceCheckStrategy$checkBindStatus$1) == false) goto L7;
        BasicDoraDeviceCheckStrategy$checkBindStatus$1 r100 = (BasicDoraDeviceCheckStrategy$checkBindStatus$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BasicDoraDeviceCheckStrategy$checkBindStatus$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L39
    L19:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;     // Catch: Throwable -> L39
        if ((r113 instanceof y) == false) goto L33;
        Long r114 = ((y) r113).f360205g;     // Catch: Throwable -> L39
        if (r114 == null) goto L33;
        if (r114.longValue() != 0) goto L33;
        FineDoraDeviceStrategy.a r115 = (FineDoraDeviceStrategy.a) ((y) r113).f360135b;     // Catch: Throwable -> L39
        if (r115 == null) goto L31;
        Boolean r116 = r115.a();     // Catch: Throwable -> L39
        if (r116 == null) goto L31;
        boolean r117 = r116.booleanValue();     // Catch: Throwable -> L39
    L32:
        g49.d.d("BasicDoraDeviceCheckStrategy", "checkBindStatus() success, bindingStatus=" + r117);     // Catch: Throwable -> L39
        Object r118 = Result.m9449constructorimpl(Boxing.boxBoolean(r117));     // Catch: Throwable -> L39
    L41:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L47;
        g49.d.c("BasicDoraDeviceCheckStrategy", "checkBindStatus() error: " + r119.getMessage(), r119);
        return Result.m9449constructorimpl(ResultKt.createFailure(r119));
    L47:
        return Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r118).booleanValue()));
    L31:
        r117 = false;
    L33:
        StringBuilder r105 = new StringBuilder("Check bind status failed, code=");     // Catch: Throwable -> L39
        if ((r113 instanceof y) == false) goto L36;
        Long r120 = ((y) r113).f360205g;     // Catch: Throwable -> L39
    L37:
        r105.append(r120);     // Catch: Throwable -> L39
        throw new IllegalStateException(r105.toString());     // Catch: Throwable -> L39
    L36:
        r120 = Boxing.boxLong(-1);     // Catch: Throwable -> L39
        goto L37
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        g49.d.d("BasicDoraDeviceCheckStrategy", "checkBindStatus() start, w_did=" + r110.getSerialNumber());
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L39
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L39
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L39
        HttpConst.f359979a.getClass();     // Catch: Throwable -> L39
        r107.append(HttpConst.f360003m);     // Catch: Throwable -> L39
        r107.append("/alice/w/device/check_binding_status");     // Catch: Throwable -> L39
        String r108 = r107.toString();     // Catch: Throwable -> L39
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L39
        r109.put("w_did", r110.getSerialNumber());     // Catch: Throwable -> L39
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r102.label = 1;     // Catch: Throwable -> L39
        r112 = com.larus.dora.api.network.a.c(r106, FineDoraDeviceStrategy.a.class, r108, r109, null, r102, 248);     // Catch: Throwable -> L39
        if (r112 != r103) goto L19;
        return r103;
    L39:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new BasicDoraDeviceCheckStrategy$checkBindStatus$1(this, r111);
        goto L8
    }

    public final Object c(BluetoothDevice r100, int r101, Continuation<? super Result<Boolean>> r102) {
        if ((r102 instanceof BasicDoraDeviceCheckStrategy$isDeviceBound$1) == false) goto L7;
        BasicDoraDeviceCheckStrategy$isDeviceBound$1 r103 = (BasicDoraDeviceCheckStrategy$isDeviceBound$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        BluetoothDevice r108 = (BluetoothDevice) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L34
        return ((Result) r105).m9458unboximpl();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        List<DoraDevice> r109 = kj4.a.g().getDoraBindList();     // Catch: Exception -> L34
        boolean r110 = false;
        if ((r109 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r111 = r109.iterator();     // Catch: Exception -> L34
    L24:
        if (r111.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(((DoraDevice) r111.next()).f204389mac, r100.getAddress()) == false) goto L24;
        r110 = true;
    L28:
        if (r110 == false) goto L31;
        Result.Companion r112 = Result.Companion;     // Catch: Exception -> L34
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L31:
        DoraDevice r113 = DoraDevice.from(r100);     // Catch: Exception -> L34
        r113.vendorId = r101;     // Catch: Exception -> L34
        r103.L$0 = r100;     // Catch: Exception -> L34
        r103.label = 1;     // Catch: Exception -> L34
        Object r114 = a(r113, r103);     // Catch: Exception -> L34
        if (r114 != r106) goto L41;
        return r106;
    L41:
        return r114;
    L20:
        if (r109.isEmpty() == false) goto L22;
    L34:
        e = move-exception;
        g49.d.c("BasicDoraDeviceCheckStrategy", "Failed to check bind state for device: " + r100.getAddress(), e);
        Result.Companion r115 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    L7:
        r103 = new BasicDoraDeviceCheckStrategy$isDeviceBound$1(this, r102);
        goto L8
    }
}
