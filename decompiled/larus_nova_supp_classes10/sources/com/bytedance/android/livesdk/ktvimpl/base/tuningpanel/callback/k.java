package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ Observer a;

    public k(TuningPanelDialog.c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.onChanged(Boolean.valueOf(((ae2.a) r2).b));
    }
}
