package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ Observer a;

    public l(TuningPanelDialog.c r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List r4 = (List) r3;
        Observer r0 = this.a;
        boolean r1 = false;
        if (r4 == null) goto L5;
        int r5 = r4.size();
    L6:
        if (r5 > 0) goto L8;
        r1 = true;
    L8:
        r0.onChanged(Boolean.valueOf(r1));
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
