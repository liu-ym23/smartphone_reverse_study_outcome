package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ Function1 a;

    public j(Function1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Long r3 = (Long) r2;
        if (r3 == null) goto L6;
        this.a.invoke(r3);
        return;
    }
}
