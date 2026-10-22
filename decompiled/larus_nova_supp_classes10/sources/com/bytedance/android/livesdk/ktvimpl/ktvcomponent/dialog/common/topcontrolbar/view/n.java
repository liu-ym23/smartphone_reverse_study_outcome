package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ VideoChorusTopBarControlContainer a;

    public n(VideoChorusTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List r4 = (List) r3;
        VideoChorusTopBarControlContainer r5 = this.a;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = VideoChorusDataContext.Companion.a();
        if (r0 == null) goto L5;
        jd2.c r1 = r0.f();
    L6:
        int r2 = VideoChorusTopBarControlContainer.s;
        r5.j(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
