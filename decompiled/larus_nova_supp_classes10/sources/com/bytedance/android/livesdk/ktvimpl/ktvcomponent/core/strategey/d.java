package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;
    public final /* synthetic */ long b;
    public final /* synthetic */ KtvMusic c;

    public d(KtvComponentSingleBroadcastStrategy r1, long r2, KtvMusic r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r14) {
        Throwable r15 = (Throwable) r14;
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_prepare_apply, failure, logId=" + ke2.a.c(r15));
        ExceptionUtils.handleException(this.a.f.getContext(), r15);
        mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiAddSongPrepareApply, System.currentTimeMillis() - this.b, r15);
        KtvMusic r5 = this.c;
        if (r5 == null) goto L8;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r16 = KtvComponentOrderSongDataContext.Companion.a();
        if (r16 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d.a.b(r16, new MusicPanel(r5, 0, null, false, null, null, null, 1073741822), null, 4);
        return;
    L9:
        return;
    }
}
