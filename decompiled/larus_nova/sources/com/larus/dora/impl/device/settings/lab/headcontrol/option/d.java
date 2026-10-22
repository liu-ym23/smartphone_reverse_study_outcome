package com.larus.dora.impl.device.settings.lab.headcontrol.option;

import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlOptionBinding;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class d<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadControlOptionFragment f334733a;

    public d(HeadControlOptionFragment r100) {
        this.f334733a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        w49.c r102 = (w49.c) r100;
        HeadControlOptionFragment r103 = this.f334733a;
        int r104 = HeadControlOptionFragment.f334725i;
        if (((HeadControlGestureType) r103.f334728h.getValue()) != HeadControlGestureType.NOD) goto L5;
        HeadControlActionOption r105 = r102.f558269a;
    L6:
        LarusDoraPageHeadControlOptionBinding r106 = this.f334733a.f334726f;
        if (r106 == null) goto L22;
        ItemTextSelector r107 = r106.f332965c;
        boolean r108 = true;
        if (r105 != HeadControlActionOption.ACCEPT_CONFIRM) goto L11;
        boolean r109 = true;
    L12:
        r107.setSelected(r109);
        ItemTextSelector r110 = r106.f332967e;
        if (r105 != HeadControlActionOption.REJECT_CLOSE) goto L15;
        boolean r111 = true;
    L16:
        r110.setSelected(r111);
        ItemTextSelector r112 = r106.f332966d;
        if (r105 == HeadControlActionOption.NONE) goto L20;
        r108 = false;
    L20:
        r112.setSelected(r108);
        goto L22
    L15:
        r111 = false;
        goto L16
    L11:
        r109 = false;
    L22:
        return Unit.INSTANCE;
    L5:
        r105 = r102.f558270b;
        goto L6
    }
}
