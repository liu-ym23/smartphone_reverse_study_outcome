package com.larus.home.impl.sdk;

import android.os.Bundle;
import android.view.View;
import com.larus.network.HttpConst;
import com.larus.platform.api.k3;
import com.larus.platform.api.l3;
import com.larus.search.api.IBrowserService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d2 implements k3, l3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d2 f346161b = null;

    static {
        f346161b = new d2();
    }

    public d2() {
    }

    @Override // com.larus.platform.api.k3
    public final String l() {
        return "//flow/global_search";
    }

    @Override // com.larus.platform.api.k3
    public final String m() {
        String r100 = kb9.c.f502279a;
        return kb9.c.f502282d;
    }

    @Override // com.larus.platform.api.k3
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IBrowserService r101 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r101 == null) goto L6;
        HttpConst.f359979a.getClass();
        IBrowserService.a.a(r101, r100, HttpConst.E);
        return;
    }

    @Override // com.larus.platform.api.l3
    public final void a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IBrowserService r102 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r102 == null) goto L6;
        HttpConst.f359979a.getClass();
        String r103 = HttpConst.E;
        Bundle r104 = new Bundle();
        r104.putString("feedback_extra_params_json", r101);
        Unit r105 = Unit.INSTANCE;
        r102.k(r100, r103, r104);
        return;
    }
}
