package com.larus.dora.impl.nl;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class s0<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProactiveSettingsFragment f336393a;

    public s0(ProactiveSettingsFragment r100) {
        this.f336393a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        final ProactiveSettingsFragment r103 = this.f336393a;
        LarusDoraPageProactiveBinding r104 = r103.f336241f;
        if (r104 == null) goto L29;
        g49.d.d("ProactiveSettingsFragment", "updateProactiveNotificationState: enabled=" + r102);
        r104.f333211l.getToggleView().setChecked(r102);
        if (r102 == false) goto L26;
        e1.x(r104.f333210k);
        r104.f333208i.setVisible(true);
        e1.x(r104.f333207h);
        IDoraService r105 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r105 == null) goto L9;
        DeviceService r106 = r105.device();
    L10:
        if (r106 != null) goto L12;
    L14:
        boolean r107 = false;
    L15:
        g49.d.d("ProactiveSettingsFragment", "setupHeadGestureControl: isSupported=" + r107);
        final LarusDoraPageProactiveBinding r108 = r103.f336241f;
        if (r108 == null) goto L25;
        if (r107 == false) goto L24;
        e1.x(r108.f333203d);
        com.larus.dora.impl.util.b0.f338123a.getClass();
        boolean r109 = com.larus.dora.impl.util.b0.r();
        int r110 = kj4.a.g().D();
        if (r109 == true) goto L21;
    L23:
        r108.f333203d.getToggleView().setChecked(com.larus.dora.impl.util.b0.r());
        r108.f333203d.getToggleView().f316954a = true;
        e1.d(r108.f333203d, new v(r108, r103));
        goto L25
    L21:
        if (r110 == 2) goto L23;
        g49.d.d("ProactiveSettingsFragment", "updateHeadGestureControl: local ON but system OFF, syncing to OFF");
        com.larus.dora.impl.util.b0.K(false);
        goto L23
    L24:
        e1.o(r108.f333203d);
    L25:
        e1.x(r104.f333202c);
        r104.f333211l.setBackgroundResource(R.drawable.larus_bg_item_selector_first);
    L27:
        Unit r111 = Unit.INSTANCE;
        goto L29
    L12:
        if (r106.n0("conversation") != true) goto L14;
        r107 = true;
        goto L15
    L9:
        r106 = null;
        goto L10
    L26:
        e1.o(r104.f333210k);
        r104.f333208i.setVisible(false);
        e1.o(r104.f333207h);
        e1.o(r104.f333203d);
        e1.o(r104.f333202c);
        r104.f333211l.setBackgroundResource(R.drawable.larus_bg_item_selector);
    L29:
        return Unit.INSTANCE;
    }
}
