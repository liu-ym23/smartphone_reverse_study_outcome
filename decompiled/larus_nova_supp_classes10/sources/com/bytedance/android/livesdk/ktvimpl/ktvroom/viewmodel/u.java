package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ KtvRoomSingerController a;

    public u(KtvRoomSingerController r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        MusicPanel r7 = this.a.p().f;
        if (r7 == null) goto L13;
        KtvMusic r8 = r7.a;
        if (r8 != null) goto L8;
        return;
    L8:
        if (KtvSettingHelper.z() == false) goto L10;
        JSONObject r9 = KtvRoomSingerController.k(this.a).put("cmd", 4);
    L11:
        this.a.v(r9);
        return;
    L10:
        r9 = KtvRoomSingerController.j(this.a).put("cmd", 4).put("id", r8.getMId());
        goto L11
    }
}
