package com.obric.cae.libs.multipath;

import android.os.IBinder;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaeMultipathClient f395898a;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        CaeMultipathClient r100 = this.f395898a;
        r100.f395893a = null;
        r100.f395895c.sendEmptyMessage(1);
    }

    public a(CaeMultipathClient r100) {
        this.f395898a = r100;
    }
}
