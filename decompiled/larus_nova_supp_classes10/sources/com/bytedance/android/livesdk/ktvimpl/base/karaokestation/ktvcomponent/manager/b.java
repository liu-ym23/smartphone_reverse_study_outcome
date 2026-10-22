package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ KtvComponentFirstLevelTabManager a;

    public b(KtvComponentFirstLevelTabManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Long r3 = (Long) r2;
        KtvComponentFirstLevelTabManager r4 = this.a;
        int r0 = KtvComponentFirstLevelTabManager.q;
        r4.B();
    }
}
