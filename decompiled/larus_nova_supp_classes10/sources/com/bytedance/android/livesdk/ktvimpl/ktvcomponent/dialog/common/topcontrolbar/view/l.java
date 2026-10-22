package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public l(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        KtvComponentTopBarControlContainer r0 = this.a;
        List<MusicPanel> r4 = (List) sh6.c.b((sh6.b) r3);
        int r1 = KtvComponentTopBarControlContainer.u;
        r0.h(r4);
    }
}
