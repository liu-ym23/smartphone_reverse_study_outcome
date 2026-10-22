package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.Context;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {

    public static final class a {
        public static int a() {
            return ((Number) vm2.h.e2.getValue(null, vm2.h.a[159(0x9f, float:2.23E-43)])).intValue();
        }
    }

    void cancelApply(h80.a<Boolean> r1);

    void checkAudienceSingEnablePermission(Long r1, rj0.b r2);

    void checkPermision(Context r1, IRoom r2, rj0.b r3);

    int ktvAddSongLimitNum();

    void ktvApply(KtvMusic r1, String r2, LinkApplyType r3, tf0.b r4);
}
