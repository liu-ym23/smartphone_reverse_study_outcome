package com.larus.dora.impl.guide;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.strategy.FeatureGuideServerStrategy;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.nova.R;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraDNULostUserGuide extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DoraDevice f335912h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.guide.d
    public final int A() {
        return R.string.larus_dora_h_ug_recall_cn;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String j() {
        return "dora_dnu_lost_user_guide";
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void r(j59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.larus.dora.impl.guide.d
    public final int z() {
        return R.string.larus_dora_h_ug_recall_btn_cn;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object v() {
        DoraDevice r100 = this.f335912h;
        if (r100 != null) goto L6;
        r100 = DoraAdapterExtKt.h(kj4.a.g());
    L6:
        if (r100 != null) goto L9;
        g49.d.d(k(), "resolveDeviceParams() failed: currentDevice is null");
        return null;
    L9:
        String r101 = r100.getSerialNumber();
        if (r101 != null) goto L12;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L20;
        g49.d.d(k(), "resolveDeviceParams() failed: serialNumber is null");
        return null;
    L20:
        return new i59.a(r101, String.valueOf(n1.c(r100)));
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
        goto L16
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final DoraGuideMeta i() {
        return DoraGuideMeta.DoraDNULostUserGuide;
    }

    public DoraDNULostUserGuide(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        super(r100);
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object p(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraDNULostUserGuide$localConditionCheck$1) == false) goto L7;
        DoraDNULostUserGuide$localConditionCheck$1 r100 = (DoraDNULostUserGuide$localConditionCheck$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraDNULostUserGuide$localConditionCheck$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L18:
        if (Intrinsics.areEqual((Boolean) r111, Boxing.boxBoolean(true)) == true) goto L21;
        g49.d.d(k(), "H device is not enabled for DNU guide");
        return Boxing.boxBoolean(false);
    L21:
        DoraDevice r112 = DoraAdapterExtKt.h(kj4.a.g());
        int r105 = kj4.a.g().getDoraLinkState(r112);
        if (r112 != null) goto L24;
    L32:
        g49.d.d(k(), "localConditionCheck: device not connected, device=" + r112 + ", linkState=" + r105);
        return Boxing.boxBoolean(false);
    L24:
        if (r105 != 2) goto L32;
        if (r112.vendorId == 4096) goto L30;
        g49.d.d(k(), "localConditionCheck: device vendorId is not H, vendorId=" + r112.vendorId);
        return Boxing.boxBoolean(false);
    L30:
        this.f335912h = r112;
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        DoraSetting r106 = DoraSetting.f338023a;
        String r107 = k().concat("-isHDeviceEnabled");
        Function0 r108 = new z();
        r102.label = 1;
        r111 = r106.b(5000, 100, r107, r108, r102);
        if (r111 != r103) goto L18;
        return r103;
    L7:
        r100 = new DoraDNULostUserGuide$localConditionCheck$1(this, r110);
        goto L8
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void u(j59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        DoraBuryPointManager.f331862a.L("dora_dnu_lost_user_balloon_show", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(r100.f497470b))));
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void s(j59.a r100, Fragment r110) {
        Intrinsics.checkNotNullParameter(r100, "state");
        DoraBuryPointManager.f331862a.L("dora_dnu_lost_user_balloon_clicked", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(this.f335867e.f497470b))));
        if (r110 == null) goto L8;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r110);
        if (r101 == null) goto L9;
        BuildersKt.launch$default(r101, null, null, new DoraDNULostUserGuide$onConfirmBtnClicked$1(null), 3, null);
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object w(i59.a r100, j59.a r101, Continuation<? super Boolean> r102) {
        return new FeatureGuideServerStrategy(new DoraDNULostUserGuide$serverConditionCheck$strategy$1(r100, r101, null), k(), true).a(r102);
    }
}
