package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public v1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        o42.g r4 = (o42.g) r3;
        KtvRoomGuestWidget r0 = this.a;
        int r1 = KtvRoomGuestWidget.G2;
        r0.getClass();
        if (r4 == null) goto L5;
        IBaseUser r2 = r4.a;
    L6:
        if (r2 == null) goto L10;
        r0.b2 = r4.b;
        ((Widget) r0).dataCenter.put("cmd_audio_talk_invite", r4.a);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
