package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ VideoChorusTopBarControlContainer a;

    public p(VideoChorusTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        UserAttr r4 = (UserAttr) r3;
        VideoChorusTopBarControlContainer r5 = this.a;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = VideoChorusDataContext.Companion.a();
        if (r0 == null) goto L5;
        jd2.c r1 = r0.f();
    L6:
        int r2 = VideoChorusTopBarControlContainer.s;
        r5.j(r1);
        VideoChorusTopBarControlContainer r6 = this.a;
        r6.getClass();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
    L14:
        ConstraintLayout r7 = r6.getMusicOperateArea();
        if (r7 == null) goto L20;
        r7.setVisibility(0);
        return;
    L20:
        return;
    L9:
        if (KtvUtilsKt.j() == true) goto L14;
        ConstraintLayout r8 = r6.getMusicOperateArea();
        if (r8 == null) goto L18;
        r8.setVisibility(8);
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
