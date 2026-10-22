package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ VideoChorusTopBarControlContainer a;

    public o(VideoChorusTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        VideoChorusTopBarControlContainer r0 = this.a;
        int r1 = VideoChorusTopBarControlContainer.s;
        r0.j((jd2.c) r3);
    }
}
