package com.larus.dora.impl.guide;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.strategy.FeatureGuideServerStrategy;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraConnectDeviceGuide extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f335910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BluetoothDevice f335911i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String j() {
        return "dora_connect_device_guide";
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void r(j59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.larus.dora.impl.guide.d
    public final int A() {
        if (this.f335867e.f497470b > 1) goto L5;
        return R.string.larus_dora_connect_device_balloon_tips_cn;
    L5:
        return R.string.larus_dora_h_ug_reactive_cn;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object v() {
        BluetoothDevice r100 = this.f335911i;
        if (r100 != null) goto L6;
        g49.d.d(k(), "resolveDeviceParams() failed: connectDevice is null");
        return null;
    L6:
        DoraDevice r101 = DoraDevice.from(r100);
        r101.vendorId = 4096;
        String r102 = r101.getSerialNumber();
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L17;
        g49.d.d(k(), "resolveDeviceParams() failed: serialNumber is null");
        return null;
    L17:
        return new i59.a(r102, String.valueOf(n1.c(r101)));
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    @Override // com.larus.dora.impl.guide.d
    public final int z() {
        if (this.f335867e.f497470b > 1) goto L5;
        return R.string.larus_dora_connect_device_balloon_connect;
    L5:
        return R.string.larus_dora_h_ug_reactive_btn_cn;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final DoraGuideMeta i() {
        return DoraGuideMeta.DoraConnectDeviceGuide;
    }

    public DoraConnectDeviceGuide(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        super(r100);
        this.f335910h = LazyKt.lazy(new x());
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object p(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraConnectDeviceGuide$localConditionCheck$1) == false) goto L7;
        DoraConnectDeviceGuide$localConditionCheck$1 r100 = (DoraConnectDeviceGuide$localConditionCheck$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L27:
        if (((Boolean) r111).booleanValue() == true) goto L113;
        g49.d.d(k(), "bluetooth permission not granted");
        return Boxing.boxBoolean(false);
    L113:
        Object r112 = AppHost.f326268a.getApplication().getSystemService("bluetooth");     // Catch: Exception -> L110
        Object r104 = null;
        if ((r112 instanceof BluetoothManager) == false) goto L33;
        BluetoothManager r113 = (BluetoothManager) r112;     // Catch: Exception -> L110
    L34:
        if (r113 == null) goto L36;
        BluetoothAdapter r114 = r113.getAdapter();     // Catch: Exception -> L110
    L37:
        if (r114 != null) goto L39;
    L108:
        g49.d.e(k(), "bluetooth adapter is null or disabled");     // Catch: Exception -> L110
        return Boxing.boxBoolean(false);
    L39:
        if (r114.isEnabled() == false) goto L108;
        Set<BluetoothDevice> r115 = r114.getBondedDevices();     // Catch: Exception -> L110
        List<DoraDevice> r105 = DoraAdapterExtKt.k(kj4.a.g());     // Catch: Exception -> L110
        Intrinsics.checkNotNull(r115);     // Catch: Exception -> L110
        Iterator<T> r116 = r115.iterator();     // Catch: Exception -> L110
    L43:
        if (r116.hasNext() == false) goto L97;
        Object r106 = r116.next();     // Catch: Exception -> L110
        BluetoothDevice r107 = (BluetoothDevice) r106;     // Catch: Exception -> L110
        boolean r108 = pk4.a.f(r107);     // Catch: Exception -> L110
        if (r105 == null) goto L57;
        List<DoraDevice> r109 = r105;     // Catch: Exception -> L110
        if ((r109 instanceof Collection) == true) goto L49;
    L51:
        Iterator<T> r117 = r109.iterator();     // Catch: Exception -> L110
    L53:
        if (r117.hasNext() == false) goto L57;
        if (Intrinsics.areEqual(((DoraDevice) r117.next()).f204389mac, r107.getAddress()) == false) goto L53;
        boolean r118 = false;
    L58:
        String r119 = r107.getName();     // Catch: Exception -> L110
        if (r119 != null) goto L61;
    L63:
        boolean r120 = false;
    L64:
        if (r120 == false) goto L80;
        String r121 = r107.getName();     // Catch: Exception -> L110
        if (r121 != null) goto L68;
    L70:
        boolean r122 = false;
    L71:
        if (r122 == false) goto L80;
        String r123 = r107.getName();     // Catch: Exception -> L110
        if (r123 != null) goto L75;
    L77:
        boolean r124 = false;
    L78:
        if (r124 == false) goto L80;
        boolean r125 = true;
    L81:
        String r126 = k();     // Catch: Exception -> L110
        StringBuilder r127 = new StringBuilder();     // Catch: Exception -> L110
        r127.append("notBound=");     // Catch: Exception -> L110
        if (r118 == false) goto L84;
        boolean r128 = true;
    L85:
        r127.append(r128);     // Catch: Exception -> L110
        r127.append(", nameMatch=");     // Catch: Exception -> L110
        if (r125 == false) goto L88;
        boolean r129 = true;
    L89:
        r127.append(r129);     // Catch: Exception -> L110
        g49.d.a(r126, r127.toString());     // Catch: Exception -> L110
        if (r108 == false) goto L94;
        if (r118 == false) goto L94;
        if (r125 == false) goto L94;
        boolean r130 = true;
    L95:
        if (r130 == false) goto L43;
        r104 = r106;
    L94:
        r130 = false;
        goto L95
    L88:
        r129 = false;
        goto L89
    L84:
        r128 = false;
        goto L85
    L75:
        if (StringsKt.contains(r123, "2", true) != true) goto L77;
        r124 = true;
        goto L78
    L68:
        if (StringsKt.contains(r121, RomUtils.BRAND_HUAWEI, true) != true) goto L70;
        r122 = true;
    L80:
        r125 = false;
        goto L81
    L61:
        if (StringsKt.contains(r119, "clip", true) != true) goto L63;
        r120 = true;
        goto L64
    L49:
        if (r109.isEmpty() == false) goto L51;
    L57:
        r118 = true;
    L97:
        BluetoothDevice r131 = (BluetoothDevice) r104;     // Catch: Exception -> L110
        if (r131 == null) goto L114;
        this.f335911i = r131;     // Catch: Exception -> L110
        return Boxing.boxBoolean(true);
    L114:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L101
        g49.d.d(k(), "localConditionCheck: no eligible bonded device");     // Catch: Throwable -> L101
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L104:
        return Boxing.boxBoolean(false);
    L101:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Exception -> L110
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L110
        goto L104
    L36:
        r114 = null;
        goto L37
    L33:
        r113 = null;
    L110:
        e = move-exception;
        g49.d.c(k(), "localConditionCheck() exception: " + e.getMessage(), e);
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
    L20:
        if (Intrinsics.areEqual((Boolean) r111, Boxing.boxBoolean(true)) == true) goto L23;
        g49.d.d(k(), "H device is not enabled");
        return Boxing.boxBoolean(false);
    L23:
        com.larus.dora.impl.guide.strategy.a r134 = (com.larus.dora.impl.guide.strategy.a) this.f335910h.getValue();
        r100.label = 2;
        r134.getClass();
        r111 = com.larus.dora.impl.guide.strategy.a.c();
        if (r111 != r102) goto L27;
        return r102;
    L16:
        ResultKt.throwOnFailure(r111);
        DoraSetting r135 = DoraSetting.f338023a;
        String r136 = k().concat("-updateConnectDeviceShouldShowState-isHDeviceEnabled");
        Function0 r137 = new w();
        r100.label = 1;
        r111 = r135.b(5000, 100, r136, r137, r100);
        if (r111 != r102) goto L20;
        return r102;
    L7:
        r100 = new DoraConnectDeviceGuide$localConditionCheck$1(this, r110);
        goto L8
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void u(j59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        DoraBuryPointManager.f331862a.L("balloon_connect_device_show", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(r100.f497470b))));
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void s(j59.a r100, Fragment r110) {
        Intrinsics.checkNotNullParameter(r100, "state");
        DoraBuryPointManager.f331862a.L("balloon_connect_device_clicked", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(r100.f497470b))));
        if (r110 == null) goto L8;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r110);
        if (r101 == null) goto L9;
        BuildersKt.launch$default(r101, null, null, new DoraConnectDeviceGuide$onConfirmBtnClicked$1(this, r110, null), 3, null);
        return;
    L9:
        return;
    }

    public static final Object B(DoraConnectDeviceGuide r100, Fragment r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DoraConnectDeviceGuide$onConnectDeviceClicked$1) == false) goto L7;
        DoraConnectDeviceGuide$onConnectDeviceClicked$1 r103 = (DoraConnectDeviceGuide$onConnectDeviceClicked$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        r101 = (Fragment) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L29:
        if (((Boolean) r105).booleanValue() == true) goto L31;
        g49.d.e(r100.k(), "connect device does not support proprietary protocol");
        return Unit.INSTANCE;
    L31:
        if (r101 != null) goto L45;
    L34:
        Context r108 = AppHost.f326268a.getApplication();     // Catch: Exception -> L41
    L35:
        y r109 = new y(r100);     // Catch: Exception -> L41
        com.bytedance.router.i r110 = SmartRouter.buildRoute(r108, "//flow/dora/bind_device");     // Catch: Exception -> L41
        r110.f267555d = R.anim.larus_router_slide_in_right;     // Catch: Exception -> L41
        r110.f267556e = R.anim.larus_router_no_anim;     // Catch: Exception -> L41
        Bundle r111 = com.larus.utils.f.c(new Pair[0]);     // Catch: Exception -> L41
        by7.h.k(r111, r109);     // Catch: Exception -> L41
        BluetoothDevice r112 = r100.f335911i;     // Catch: Exception -> L41
        if (r112 == null) goto L38;
        String r113 = r112.getAddress();     // Catch: Exception -> L41
    L39:
        r111.putString("extra_mac", r113);     // Catch: Exception -> L41
        r111.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");     // Catch: Exception -> L41
        r111.putString("product_id", "-1");     // Catch: Exception -> L41
        r111.putString(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, "4096");     // Catch: Exception -> L41
        r110.f267554c.putExtras(r111);     // Catch: Exception -> L41
        r110.d();     // Catch: Exception -> L41
    L44:
        return Unit.INSTANCE;
    L41:
        e = move-exception;
        g49.d.c(r100.k(), "onConnectDeviceClicked exception: " + e.getMessage(), e);
        goto L44
    L38:
        r113 = null;
        goto L39
    L45:
        r108 = r101.getContext();     // Catch: Exception -> L41
        if (r108 != null) goto L35;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Fragment) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        if (((Boolean) r105).booleanValue() == true) goto L22;
        g49.d.b(r100.k(), "bluetooth permission not granted when connecting device");
        return Unit.INSTANCE;
    L22:
        BluetoothDevice r114 = r100.f335911i;
        if (r114 == null) goto L48;
        FineDoraDeviceStrategy r115 = new FineDoraDeviceStrategy(r114, 4096);
        r103.L$0 = r101;
        r103.label = 2;
        r105 = r115.a(r103);
        if (r105 != r106) goto L29;
        return r106;
    L48:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r105);
        com.larus.dora.impl.guide.strategy.a r116 = (com.larus.dora.impl.guide.strategy.a) r100.f335910h.getValue();
        r103.L$0 = r101;
        r103.label = 1;
        r116.getClass();
        r105 = com.larus.dora.impl.guide.strategy.a.c();
        if (r105 != r106) goto L20;
        return r106;
    L7:
        r103 = new DoraConnectDeviceGuide$onConnectDeviceClicked$1(r100, r102);
        goto L8
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object w(i59.a r100, j59.a r101, Continuation<? super Boolean> r102) {
        return new FeatureGuideServerStrategy(new DoraConnectDeviceGuide$serverConditionCheck$strategy$1(r100, r101, null), k(), true).a(r102);
    }
}
