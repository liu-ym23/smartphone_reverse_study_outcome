package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Observer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L10;
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L12;
        r1.setValue(r3);
        return;
    L12:
        return;
    L11:
        return;
    }
}
