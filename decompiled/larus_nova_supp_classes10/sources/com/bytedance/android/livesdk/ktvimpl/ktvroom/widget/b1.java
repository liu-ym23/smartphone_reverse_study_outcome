package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b1<T> implements Observer {
    public final /* synthetic */ KtvRoomAnchorWidget a;

    public b1(KtvRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        IVoiceLiveTheme r4 = (IVoiceLiveTheme) r3;
        if (r4 == null) goto L10;
        KtvRoomContainerWidget r0 = this.a.E;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "theme");
        qe2.a r1 = r0.e;
        if (r1 == null) goto L12;
        r1.n(r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
