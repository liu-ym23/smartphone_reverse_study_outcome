package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements com.ss.android.lark.http.netstate.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f439717a;

    public e() {
        this.f439717a = f.a.f439718a;
    }

    @Override // com.ss.android.lark.http.netstate.a
    public final void a(NetworkUtils.NetworkType r100) {
        Log.i("NetworkStateChangeManager", "onNetworkStateChange called.");
        this.f439717a.getClass();
        if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((k3c.a) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(LarkContext.getApplication()), DwarfSPIEntryPoint.class)).dwarfSPI().get(k3c.a.class)).hd(r100);
        return;
    L5:
        new i3c.b(c3c.f.a());
        i3c.b.b(r100);
    }
}
