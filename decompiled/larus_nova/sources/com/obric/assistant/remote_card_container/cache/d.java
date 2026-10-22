package com.obric.assistant.remote_card_container.cache;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f391238a;

    public /* synthetic */ d(String r100) {
        this.f391238a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final String r100 = this.f391238a;
        p9a.e r101 = p9a.b.f528329a;
        p9a.b.a("CardCacheManager", "removeInfoAndCacheOfUri: " + r100);
        n.f391253a.b(r100);
        i r102 = i.f391243a;
        i.b(r100);
        m r103 = m.f391249a;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r100, "cardUri");     // Catch: Throwable -> L7
        p9a.b.a("CardInfoCache", "removeCardInfo: ".concat(r100));     // Catch: Throwable -> L7
        m.f391252d.remove(r100);     // Catch: Throwable -> L7
        CardCacheManager r104 = CardCacheManager.f391235a;     // Catch: Throwable -> L7
        CardCacheManager.b(new l(r100));     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
