package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements com.bytedance.android.live.ktv.common.music.download.p.a {
    public final /* synthetic */ KtvRoomSingerController a;

    public final void b(MusicPanel r1, int r2, String r3) {
    }

    public final void c(MusicPanel r1, int r2) {
    }

    public v(KtvRoomSingerController r1) {
        this.a = r1;
    }

    public final void a(MusicPanel r1, String r2, String r3) {
        if (r1 == null) goto L7;
        BaseCoreViewModel r4 = this.a.o();
        if (r4 == null) goto L8;
        r4.sendEvent(new KtvRoomLyricsStateMachineConfig.a.i(r1), "KtvRoomSingerController");
        return;
    L8:
        return;
    }
}
