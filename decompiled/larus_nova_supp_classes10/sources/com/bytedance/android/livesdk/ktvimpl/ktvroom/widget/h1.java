package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h1<T> implements Consumer {
    public final /* synthetic */ ye0.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public h1(ye0.a r1, long r2) {
        this.a = r1;
        this.b = 1;
        this.c = r2;
    }

    public final void accept(Object r5) {
        CustomApiServerException r6 = (Throwable) r5;
        this.a.onFailure();
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        int r1 = this.b;
        long r2 = this.c;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.b(r1, r2, r6);
        if ((r6 instanceof CustomApiServerException) == false) goto L10;
        String r7 = r6.getPrompt();
        if (r7 != null) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual("", r7)) == false) goto L14;
        f2.c(r7, 0);
        return;
    L14:
        return;
    L10:
        if (this.b != 0) goto L16;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131917744), 0);
        return;
    }
}
