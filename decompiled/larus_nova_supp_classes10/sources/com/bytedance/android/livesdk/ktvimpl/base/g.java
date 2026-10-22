package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.EffectMusicSelectDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ KtvControlWidget a;
    public final /* synthetic */ id2.d b;

    public g(KtvControlWidget r1, id2.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        id2.d r0 = this.b;
        r0.a((id2.c) r2);
        KSongOrderSongUtilKt.b(((Widget) this.a).context, CloseOrderSongDialogSource.MANUAL);
        EffectMusicSelectDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = EffectMusicSelectDataContext.Companion.a();
        if (r3 == null) goto L6;
        r3.clearSelectedSongList();
        return;
    }
}
