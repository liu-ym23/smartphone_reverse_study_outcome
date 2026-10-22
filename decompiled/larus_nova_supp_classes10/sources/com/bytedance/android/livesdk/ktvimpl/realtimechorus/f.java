package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ RTChorusLogView a;

    public f(RTChorusLogView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Integer r2 = (Integer) r1;
        RTChorusLogView.R5(this.a);
    }
}
