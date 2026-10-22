package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Context a;

    public e(Context r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        ALogger.e("GroupLiveGameInviteUtils", "inviteFriends failed", r4);
        ExceptionUtils.handleException(this.a, r4);
    }
}
