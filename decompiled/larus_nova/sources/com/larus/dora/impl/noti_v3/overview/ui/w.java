package com.larus.dora.impl.noti_v3.overview.ui;

import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class w<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationBroadcastV3Fragment f336444a;

    public w(NotificationBroadcastV3Fragment r100) {
        this.f336444a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        LarusDoraPageNotiV3Binding r103 = this.f336444a.f336412f;
        if (r103 == null) goto L9;
        ItemTextToggle r104 = r103.f333077p;
        if (r104 == null) goto L9;
        CustomSwitchCompat r105 = r104.getToggleView();
        if (r105 == null) goto L9;
        r105.setChecked(r102);
    L9:
        final NotificationBroadcastV3Fragment r106 = this.f336444a;
        LarusDoraPageNotiV3Binding r107 = r106.f336412f;
        if (r107 == null) goto L39;
        boolean r108 = false;
        if (r102 == false) goto L33;
        e1.x(r107.f333067f);
        e1.x(r107.f333066e);
        e1.x(r107.f333063b);
        e1.x(r107.f333065d);
        e1.x(r107.f333064c);
        r107.f333077p.setBackgroundResource(R.drawable.larus_bg_item_selector);
        IDoraService r109 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r109 == null) goto L16;
        DeviceService r110 = r109.device();
    L17:
        if (r110 != null) goto L19;
    L21:
        boolean r111 = false;
    L22:
        g49.d.d("NotificationBroadcastV3Fragment", "updateHeadGestureControl: isSupported=" + r111);
        final LarusDoraPageNotiV3Binding r112 = r106.f336412f;
        if (r112 == null) goto L35;
        if (r111 == false) goto L31;
        e1.x(r112.f333069h);
        com.larus.dora.impl.util.b0.f338123a.getClass();
        boolean r113 = com.larus.dora.impl.util.b0.r();
        int r114 = kj4.a.g().D();
        if (r113 == true) goto L28;
    L30:
        r112.f333069h.getToggleView().setChecked(com.larus.dora.impl.util.b0.r());
        r112.f333069h.getToggleView().f316954a = true;
        e1.d(r112.f333069h, new f(r112, r106));
    L32:
        r112.f333064c.c();
        goto L35
    L28:
        if (r114 == 2) goto L30;
        com.larus.dora.impl.util.b0.K(false);
        goto L30
    L31:
        e1.o(r112.f333069h);
    L35:
        if (r107.f333082u.getVisibility() != 0) goto L37;
        r108 = true;
    L37:
        r106.ba0(r108, r102);
        goto L39
    L19:
        if (r110.n0("conversation") != true) goto L21;
        r111 = true;
        goto L22
    L16:
        r110 = null;
        goto L17
    L33:
        e1.o(r107.f333067f);
        e1.o(r107.f333066e);
        e1.o(r107.f333063b);
        e1.o(r107.f333065d);
        e1.o(r107.f333064c);
        r107.f333077p.setBackgroundResource(R.drawable.larus_bg_item_selector);
    L39:
        return Unit.INSTANCE;
    }
}
