package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.karaokestation.view.CommonOrderSongDialog;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ KSongOrderSongDialog a;

    public f(KSongOrderSongDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((UserAttr) r4).isAdmin() == false) goto L5;
        ALogger.d("KSongOrderSongDialog", "observeAdminChanged.isAdmin");
    L6:
        CommonOrderSongDialog r5 = this.a.k;
        if (r5 == null) goto L12;
        Function3 r0 = r5.t.b.l;
        if (r0 == null) goto L13;
        Unit r6 = (Unit) r0.invoke(r5.n, r5.p, r5.j);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        ALogger.d("KSongOrderSongDialog", "observeAdminChanged.notAdmin");
        goto L6
    }
}
