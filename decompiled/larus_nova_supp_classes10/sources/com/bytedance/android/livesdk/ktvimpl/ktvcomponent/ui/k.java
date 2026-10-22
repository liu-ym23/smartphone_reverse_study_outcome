package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public k(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List<MusicPanel> r3 = (List) r2;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r0 = this.a.A;
        if (r0 == null) goto L6;
        r0.f(r3);
        return;
    }
}
