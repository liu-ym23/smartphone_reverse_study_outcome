package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L5;
        boolean r5 = r4.booleanValue();
    L6:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.a.e;
        if (r0 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L11;
        MusicPanel r2 = r1.b();
    L12:
        if (r2 != null) goto L14;
    L21:
        ImageView r6 = this.a.a;
        if (r6 == null) goto L24;
        r6.setAlpha(0.5f);
    L24:
        ImageView r7 = this.a.a;
        if (r7 == null) goto L27;
        r7.setTag(Boolean.FALSE);
    L27:
        this.a.a(r5);
        return;
    L14:
        if (KtvUtilsKt.D(r2) != true) goto L21;
        ImageView r8 = this.a.a;
        if (r8 == null) goto L18;
        r8.setAlpha(1.0f);
    L18:
        ImageView r9 = this.a.a;
        if (r9 == null) goto L27;
        r9.setTag(Boolean.TRUE);
    L11:
        r2 = null;
        goto L12
    L5:
        r5 = false;
        goto L6
    }
}
