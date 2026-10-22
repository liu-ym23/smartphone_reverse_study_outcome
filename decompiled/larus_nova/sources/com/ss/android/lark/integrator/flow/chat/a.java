package com.ss.android.lark.integrator.flow.chat;

import aqb.j;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import hza.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowChatDependencyImpl$feedDependency$1 f427915a;

    public a(FlowChatDependencyImpl$feedDependency$1 r100) {
        this.f427915a = r100;
    }

    @Override // hza.b
    public final void a(pza.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator r101 = ((ArrayList) this.f427915a.f427913a).iterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        j r102 = (j) r101.next();
        qtb.b r103 = (qtb.b) LarkContext.spiByDwarf(qtb.b.class);     // Catch: Throwable -> L8
    L10:
        if (r103 == null) goto L14;
        boolean r104 = true;
        if (r103.P0() != true) goto L14;
    L15:
        if (r104 == false) goto L17;
        int r105 = r100.f531136c;
    L18:
        r102.onBadgeChange(r105);
        goto L4
    L17:
        r105 = r100.f531135b;
    L14:
        r104 = false;
    L8:
        th = move-exception;
        Log.e("FlowChatDependencyImpl", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r103 = null;
        goto L10
    }
}
