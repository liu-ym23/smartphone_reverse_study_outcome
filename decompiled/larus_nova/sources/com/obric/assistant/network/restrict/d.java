package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements uea.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f390361a;

    public d(e r100) {
        this.f390361a = r100;
    }

    @Override // uea.a
    public final void a(boolean r100) {
        FLogger.f375446a.i(this.f390361a.f390364c, "onObricStatusChanged: " + r100);
        this.f390361a.f390363b.set(r100);
        hm9.j r101 = hm9.j.f485959a;
        hm9.j.f485966h.d(false);
    }
}
