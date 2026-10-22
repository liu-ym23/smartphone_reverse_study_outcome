package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ Observer a;

    public m(TuningPanelDialog.c r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.onChanged(Boolean.valueOf(!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)));
    }
}
