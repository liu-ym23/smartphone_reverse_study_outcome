package com.larus.audio.call.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class y implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.audio.call.arch.c f289551a;

    public /* synthetic */ y(com.larus.audio.call.arch.c r100) {
        this.f289551a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        com.larus.audio.call.arch.c r102 = this.f289551a;
        String r103 = (String) r100;
        String r104 = (String) r101;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        String r106 = null;
        if (r105 == true) goto L12;
    L15:
        LinkedHashMap r107 = new LinkedHashMap();
        ouc.g0 r108 = ouc.k.c(r103);
        Intrinsics.checkNotNullParameter("trigger_event", "key");
        Intrinsics.checkNotNullParameter(r108, "element");
        ouc.i r109 = (ouc.i) r107.put("trigger_event", r108);
        ouc.g0 r110 = ouc.k.c(r104);
        Intrinsics.checkNotNullParameter("enter_method", "key");
        Intrinsics.checkNotNullParameter(r110, "element");
        ouc.i r111 = (ouc.i) r107.put("enter_method", r110);
        ouc.d0 r112 = new ouc.d0(r107);
    L16:
        id9.d r113 = r102.j();
        if (r113 == null) goto L23;
        TriggerMode r114 = TriggerMode.HANGUP;
        if (r112 == null) goto L21;
        r106 = r112.toString();
    L21:
        r113.p(r114, r106);
    L23:
        return Unit.INSTANCE;
    L12:
        if (com.larus.audio.call.util.p.a(r104) == true) goto L15;
        r112 = null;
        goto L16
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
