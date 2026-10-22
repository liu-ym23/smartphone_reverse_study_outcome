package com.larus.dora.obric.device_management.setting.earbuds.keep_alive;

import android.widget.CompoundButton;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.obric.oui.oswitch.OSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class j implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsKeepAliveFragment f340176a;

    public /* synthetic */ j(DoraObricEarbudsKeepAliveFragment r100) {
        this.f340176a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r110) {
        DoraObricEarbudsKeepAliveFragment r101 = this.f340176a;
        int r102 = DoraObricEarbudsKeepAliveFragment.F;
        String r103 = null;
        r100.setOnCheckedChangeListener(null);
        r100.setChecked(r101.f340159t);
        OSwitch r104 = r101.f340157r;
        if (r104 == null) goto L5;
        r104.setOnCheckedChangeListener(new j(r101));
    L5:
        Intrinsics.checkNotNull(r100);
        if (com.larus.dora.obric.device_management.setting.earbuds.k.a(r100) == false) goto L9;
        return;
    L9:
        if (r101.ba0() == null) goto L26;
        DoraKeepAliveViewModel r105 = r101.ca0();
        IFlowCompanionDeviceManager r106 = (IFlowCompanionDeviceManager) r101.f340148i.getValue();
        oy8.e r107 = r101.f340149j;
        DoraDevice r108 = r101.ba0();
        if (r108 == null) goto L13;
        String r109 = r108.f204389mac;
    L15:
        if (r109 != null) goto L17;
        String r111 = "";
    L18:
        DoraDevice r112 = r101.ba0();
        if (r112 == null) goto L21;
        r103 = r112.f204390sn;
    L21:
        if (r103 != null) goto L23;
        String r113 = "";
    L24:
        r105.enableCdm(r110, r106, r107, r111, r113);
        return;
    L23:
        r113 = r103;
        goto L24
    L17:
        r111 = r109;
        goto L18
    L13:
        r109 = null;
        goto L15
    }
}
