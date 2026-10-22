package com.bytedance.android.livesdk.ktvimpl.base;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ i a;

    public l(i r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        i r11 = this.a;
        r11.q = SystemClock.elapsedRealtime();
        final Ref.LongRef r12 = new Ref.LongRef();
        this.a.d();
        r12.element = 0;
        this.a.h = 0L;
        if (this.a.k.isCleared() == false) goto L5;
    L13:
        UtilityKotlinExtentionsKt.s(0, false, false, new KtvCoreController$starGetProgressDispose$1$1(this, r12), 7);
        return;
    L5:
        if (((Boolean) this.a.k.getHasBgm().getValue()).booleanValue() == true) goto L13;
        this.a.getClass();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L9;
        r0 = null;
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r1 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r0;
        if (r1 == null) goto L12;
        r1.W(true);
    L12:
        this.a.k.getHasBgm().setValue(Boolean.TRUE);
        goto L13
    }
}
